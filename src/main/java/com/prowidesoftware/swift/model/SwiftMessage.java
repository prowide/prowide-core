/*
 * Copyright 2006-2018 Prowide
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.prowidesoftware.swift.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prowidesoftware.JsonSerializable;
import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.io.parser.SwiftParser;
import com.prowidesoftware.swift.io.parser.SwiftParserConfiguration;
import com.prowidesoftware.swift.io.parser.XMLParser;
import com.prowidesoftware.swift.io.writer.SwiftWriter;
import com.prowidesoftware.swift.io.writer.XMLWriterVisitor;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.*;
import com.prowidesoftware.swift.utils.IMessageVisitor;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;

/**
 * Base class for swift messages.
 *
 * <p>This class is a generic data structure container for SWIFT messages.
 *
 * <p><em>This is a low level java representation of an MT. If you are looking for
 * a class more suitable to be persisted see {@link MtSwiftMessage}</em>
 *
 * <p>Instances of this class may have a list of unparsed texts (UnparsedTextList).
 * For easy access, methods have been created that first ensure the lists exists (the
 * real object is created and then call the base method).<br>
 * However, not all the base list methods have been implemented. If you need to use not
 * exposed functionality, retrieve the underlying list with (see getUnparsedTexts method).
 */
public class SwiftMessage implements Serializable, JsonSerializable {
	private static final long serialVersionUID = 8094995269559985432L;

	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftMessage.class.getName());

	static final int JSON_VERSION = 2;
	private static final String INVALID_NAME_BLOCK = "Invalid name for User Defined Blocks (";
	private static final String MESSAGE_IS_NOT_A_FRAGMENT = "message is not a fragment";

	/**
	 * Block 1
	 */
	private SwiftBlock1 block1;

	/**
	 * Block 2
	 */
	private SwiftBlock2 block2;

	/**
	 * Block 3
	 */
	private SwiftBlock3 block3;

	/**
	 * Block 4
	 */
	private SwiftBlock4 block4;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SwiftMessage that = (SwiftMessage) o;
		return Objects.equals(block1, that.block1) &&
				Objects.equals(block2, that.block2) &&
				Objects.equals(block3, that.block3) &&
				Objects.equals(block4, that.block4) &&
				Objects.equals(block5, that.block5) &&
				Objects.equals(userBlocks, that.userBlocks) &&
				Objects.equals(unparsedTexts, that.unparsedTexts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(block1, block2, block3, block4, block5, userBlocks, unparsedTexts);
	}

	/**
	 * Block 5
	 */
	private SwiftBlock5 block5;

	/**
	 * Placeholder for the root of the sequences parsed in this message
	 * @deprecated to retrieve fields in sequences use the AbstractMT model
	 */
	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	private SequenceNode parsedSequences;

	/**
	 * User defined blocks
	 * List of {@link SwiftBlockUser}.
	 *
	 * @since 5.0
	 */
	private List<SwiftBlockUser> userBlocks;

	/**
	 * List of unparsed texts. For performance reasons, this will be null until really needed.
	 */
	private UnparsedTextList unparsedTexts = null;

	/**
	 * Identification of the message when persisted
	 * @deprecated use persistence mapping in the AbstractSwiftMessage model instead
	 */
	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	protected Long id;

	/**
	 * Default constructor.
	 * Must be called since here is performed default handler registration
	 * @see #SwiftMessage(boolean)
	 */
	public SwiftMessage() {
		super();
	}

	/**
	 * Constructor that initializes blocks
	 * @param initBlocks when false the message will not have any blocks when constructed, if true blocks are created, just like with default constructor
	 */
	public SwiftMessage(final boolean initBlocks) {
		super();
		if (initBlocks) {
			this.block1 = new SwiftBlock1();
			this.block2 = new SwiftBlock2Input();
			this.block3 = new SwiftBlock3();
			this.block4 = new SwiftBlock4();
			this.block5 = new SwiftBlock5();
			this.userBlocks = new ArrayList<>();
		}
	}

	/**
	 * Constructor for an unparsed text list that initializes blocks
	 * @param initBlocks when false the message will not have any blocks when constructed, if true blocks are created, just like with default consturctor
	 * @param unparsedText the list of unparsed texts
	 * @see SwiftMessage#SwiftMessage()
	 */
	public SwiftMessage(final boolean initBlocks, final UnparsedTextList unparsedText) {

		// base constructor
		this(initBlocks);

		// set the unparsed text list
		this.unparsedTexts = unparsedText;
	}

	/**
	 * Constructor for an unparsed text list
	 * @param unparsedText the list of unparsed texts
	 * @see SwiftMessage#SwiftMessage()
	 */
	public SwiftMessage(final UnparsedTextList unparsedText) {

		// base constructor
		this();

		// set the unparsed text list
		this.unparsedTexts = unparsedText;
	}

	/**
	 * Parses a the string content into a SwiftMessage. 
	 *
	 * <p>If the file contains more than a message it will parse the first one.
	 * If the string is empty, does not contain any MT message, the message type is not set or 
	 * an error occurs reading and parsing the message content; this method returns null.
	 *
	 * <p>The implementation uses the default parser behaviour which is lenient and will do a best effort to
	 * read as much from the message content as possible regardless of the content and block boundaries
	 * beeing valid or not. For instance, it will read the headers even if the value length is incorrect,
	 * and it will read the text block (block 4) even if it is missing the closing hyphen and bracket. For
	 * more options check {@link SwiftParser#setConfiguration(SwiftParserConfiguration)}
	 *
	 * @param fin string a string containing a swift MT message
	 * @return parser message or null if string content could not be parsed
	 * @throws IOException
	 * 
	 * @since 7.8.8
	 */
	public final static SwiftMessage parse(final String fin) throws IOException {
		return (new SwiftParser(fin)).message();
	}
	
	/**
	 * Get the block number specified by b.
	 *
	 * @param b the block number to retrieve, must be greater or equal to 1 and smaller or equal to 5.
	 * @return the block number specified in this message
	 * @throws IllegalArgumentException if b &lt; 1 or b &gt; 5
	 */
	public SwiftBlock getBlock(final int b) {
		// sanity check
		Validate.isTrue(1 <= b && b <= 5, "block index must be 1-5 (was " + b + ")");

		switch (b) {
			case 1:
				return this.block1;
			case 2:
				return this.block2;
			case 3:
				return this.block3;
			case 4:
				return this.block4;
			case 5:
				return this.block5;
			default:
				log.severe("Invalid block number "+ b +". Expected numbers are 1 to 5");
				// should not be reached
				return null;
		}
	}

	/**
	 * Commons-lang reflection toString implementation
	 */
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	/**
	 * Add a block to this message.
	 * <p>Notes: on user blocks, no checks are done, on swift blocks, block number
	 * must be non null and have a value from 1-5 both inclusive
	 *
	 * @param b the block to add, may be null in which case nothing happens
	 * @throws IllegalArgumentException b is null or the method getInt in the block returns a value out of range (non user blocks)
	 */
	public void addBlock(final SwiftBlock b) {
		Validate.notNull(b);

		// support for user blocks in this method is useful for XML parser and other code that
		// takes advantages of using SwiftTagListBlock
		if (b instanceof SwiftBlockUser) {
			addUserBlock((SwiftBlockUser) b);
		} else {
			Validate.notNull(b.getNumber(), "SwiftBlock.getNumber() is null");
			final int index = b.getNumber().intValue();
			Validate.isTrue(index >= 1 && index <= 5, "SwiftBlock.getNumber int did not return an int between 1-5");
			switch (index) {
				case 1:
					setBlock1((SwiftBlock1) b);
					break;
				case 2:
					setBlock2((SwiftBlock2) b);
					break;
				case 3:
					setBlock3((SwiftBlock3) b);
					break;
				case 4:
					setBlock4((SwiftBlock4) b);
					break;
				case 5:
					setBlock5((SwiftBlock5) b);
					break;
				default:
					log.severe("Invalid block number "+ b +". Expected numbers are 1 to 5");
					break;
			}
		}
	}

	/**
	 * Attempt to identify the current message type (MT).
	 *
	 * @param type must be a valid registered handler id
	 * @return true if this message is successfully identified as the given MT and false in other case	 *
	 * @throws IllegalArgumentException if parameter type is null or not a valid type (i.e: 3 chars len)
	 * @see SwiftBlock2#getMessageType()
	 * @see #getType()
	 * 
	 * @deprecated this method has been deprecated in favor of {@link #isType(int)} which provides a safer API just passing an int number for the message type
	 */
    @Deprecated
    @ProwideDeprecated(phase4=TargetYear.SRU2020)
	public boolean isMT(final String type) {
		DeprecationUtils.phase3(getClass(), "isMT(String)", "Use isType(int) instead.");
		// sanity check
		Validate.notNull(type);
		Validate.isTrue(type.length() == 3, "The string must be exactly 3 chars size (type=" + type + ")");
		return getType() != null && getType().equals(type);
	}

	/**
	 * Tell the message type associated with this object if a block 2 is present.
	 *
	 * @return a String containing the SWIFT numeric code for the message types or null if the message does not have a block 2.
	 * @see SwiftBlock2#getMessageType()
	 */
	public String getType() {
		if (this.block2 != null) {
			return this.block2.getMessageType();
		} else {
			return null;
		}
	}

	/**
	 * Visit the current message with the given visitor.
	 * Writes all present blocks 1 to 5, and also the user blocks if any.
	 *
	 * @param visitor the visitor to use
	 * @throws IllegalArgumentException if parameter visitor is null
	 * @see SwiftWriter#writeMessage(SwiftMessage, java.io.Writer)
	 */
	public void visit(final IMessageVisitor visitor) {
		Validate.notNull(visitor);

		// start visiting
		visitor.startMessage(this);

		// visit block 1 and value
		final SwiftBlock1 b1 = this.block1;
		if (b1 != null) {
			visitor.startBlock1(b1);
			visitor.value(b1, b1.getValue());
			visitor.endBlock1(b1);
		}

		// visit block 2 and value
		final SwiftBlock2 b2 = this.block2;
		if (b2 != null) {
			visitor.startBlock2(b2);
			visitor.value(b2, b2.getValue());
			visitor.endBlock2(b2);
		}

		final SwiftBlock3 b3 = this.block3;
		if (b3 != null) {
			visitor.startBlock3(b3);
			visit(b3, visitor);
			visitor.endBlock3(b3);
		}

		final SwiftBlock4 b4 = this.block4;
		if (b4 != null) {
			visitor.startBlock4(b4);
			visit(b4, visitor);
			visitor.endBlock4(b4);
		}

		final SwiftBlock5 b5 = this.block5;
		if (b5 != null) {
			visitor.startBlock5(b5);
			visit(b5, visitor);
			visitor.endBlock5(b5);
		}

		// visit user defined blocks
		if (this.userBlocks != null) {

			// visit every user defined block
			for (int i = 0; i < this.userBlocks.size(); i++) {

				final SwiftBlockUser userBlock = this.userBlocks.get(i);
				if (userBlock != null) {
					visitor.startBlockUser(userBlock);
					visit(userBlock, visitor);
					visitor.endBlockUser(userBlock);
				}
			}
		}

		// stop visiting
		visitor.endMessage(this);
	}

	/**
	 * Visit a Block 3 (SwiftBlock3), i.e: call the tag method for block 3
	 * This method is called from {@link #visit(IMessageVisitor)} but may be used independently, in such case,
	 * the startBlockX and endBlockX in the visitor will not be called.
	 * <p>To serialize in SWIFT native format with block boundaries check {@link SwiftWriter#writeBlock3(SwiftBlock3, java.io.Writer)}
	 *
	 * @param block the block containing the tags to visit
	 * @param visitor the visitor to use
	 * @throws IllegalArgumentException if parameter block or visitor are null
	 *
	 * @since 5.0
	 */
	public static void visit(final SwiftBlock3 block, final IMessageVisitor visitor) {
		// sanity check
		Validate.notNull(block);
		Validate.notNull(visitor);

		// iterate thru tags
		for (final Iterator<Tag> it = block.tagIterator(); it.hasNext();) {
			visitor.tag(block, it.next());
		}
	}

	/**
	 * Visit a Block 4 (SwiftBlock4), i.e: call the tag method for block 4
	 * This method is called from {@link #visit(IMessageVisitor)} but may be used independently, in such case,
	 * the startBlockX and endBlockX in the visitor will not be called.
	 * <p>To serialize in SWIFT native format with block boundaries check {@link SwiftWriter#writeBlock4(SwiftBlock4, java.io.Writer)}
	 *
	 * @param block the block containing the tags to visit
	 * @param visitor the visitor to use
	 * @throws IllegalArgumentException if parameter block or visitor are null
	 *
	 * @since 5.0
	 */
	public static void visit(final SwiftBlock4 block, final IMessageVisitor visitor) {
		// sanity check
		Validate.notNull(block);
		Validate.notNull(visitor);

		// iterate thru tags
		for (final Iterator<Tag> it = block.tagIterator(); it.hasNext();) {
			final Tag t = it.next();
			visitor.tag(block, t);
		}
	}

	/**
	 * Visit a Block 5 (SwiftBlock5), i.e: call the tag method for block 4
	 * This method is called from {@link #visit(IMessageVisitor)} but may be used independently, in such case,
	 * the startBlockX and endBlockX in the visitor will not be called.
	 * <p>To serialize in SWIFT native format with block boundaries check {@link SwiftWriter#writeBlock5(SwiftBlock5, java.io.Writer)}
	 *
	 * @param block the block containing the tags to visit
	 * @param visitor the visitor to use
	 * @throws IllegalArgumentException if parameter block or visitor are null
	 *
	 * @since 5.0
	 */
	public static void visit(final SwiftBlock5 block, final IMessageVisitor visitor) {
		// sanity check
		Validate.notNull(block);
		Validate.notNull(visitor);

		// iterate thru tags
		for (final Iterator<Tag> it = block.tagIterator(); it.hasNext();) {
			final Tag t = it.next();
			visitor.tag(block, t);
		}
	}

	/**
	 * Visit a User Defined Block (SwiftBlockUser), i.e: call the tag method for block 4
	 * This method is called from {@link #visit(IMessageVisitor)} but may be used independently, in such case,
	 * the startBlockX and endBlockX in the visitor will not be called.
	 *
	 * @param block the block containing the tags to visit
	 * @param visitor the visitor to use
	 * @throws IllegalArgumentException if parameter block or visitor are null
	 *
	 * @since 5.0
	 */
	public static void visit(final SwiftBlockUser block, final IMessageVisitor visitor) {
		// sanity check
		Validate.notNull(block);
		Validate.notNull(visitor);

		// iterate thru tags
		for (final Iterator<Tag> it = block.tagIterator(); it.hasNext();) {

			final Tag t = it.next();
			visitor.tag(block, t);
		}
	}

	/**
	 * Get the unique identifier of this message
	 * @return the message id
	 * @see #id
	 * @deprecated use persistence mapping in the AbstractSwiftMessage model instead
	 */
	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	public Long getId() {
		DeprecationUtils.phase2(getClass(), "getId()", "The SwiftMessage model is no more intended for persistence, use the more effective JPA annotated model in AbstractSwiftMessage instead");
		return this.id;
	}

	/**
	 * Set the unique identifier of this message
	 * @param id the id to be set
	 * @see #id
	 * @deprecated use persistence mapping in the AbstractSwiftMessage model instead
	 */
	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	public void setId(final Long id) {
		DeprecationUtils.phase2(getClass(), "setId(Long)", "The SwiftMessage model is no more intended for persistence, use the more effective JPA annotated model in AbstractSwiftMessage instead");
		this.id = id;
	}

	/**
	 * Get the number of blocks in this message, including the user blocks
	 * @return an int greater or equal to zero
	 */
	public int getBlockCount() {
		return this.getBlockCount(Boolean.TRUE);
	}

	/**
	 * Get the number of blocks in this message, optionally including the user blocks.<br>
	 * A block is summed if it is not null and is not empty.
	 * <b><em>NOTE: that isEmpty() will be called in each block, the behavior of isEmpty is block
	 * dependent</em></b>
	 *
	 * @param includeUserBlocks indicates whether or not user defined blocks should be counted
	 * @return an int greater or equal to zero
	 * @see SwiftBlock1#isEmpty()
	 * @see SwiftBlock2Input#isEmpty()
	 * @see SwiftBlock2Output#isEmpty()
	 * @see SwiftBlock3#isEmpty()
	 * @see SwiftBlock4#isEmpty()
	 * @see SwiftBlock5#isEmpty()
	 */
	public int getBlockCount(final Boolean includeUserBlocks) {

		// count the basic blocks
		int count = 0;
		if (this.block1 != null && !this.block1.isEmpty()) {
			count++;
		}
		if (this.block2 != null && !this.block2.isEmpty()) {
			count++;
		}
		if (this.block3 != null && !this.block3.isEmpty()) {
			count++;
		}
		if (this.block4 != null && !this.block4.isEmpty()) {
			count++;
		}
		if (this.block5 != null && !this.block5.isEmpty()) {
			count++;
		}

		// count user defined blocks (if requested to do so)
		if (includeUserBlocks.booleanValue() && this.userBlocks != null) {
			count += this.userBlocks.size();
		}

		return count;
	}

	/**
	 * Get block number 1 of this message, may be null if not set
	 * @return the block 1 of the message or null
	 */
	public SwiftBlock1 getBlock1() {
		return this.block1;
	}

	/**
	 * Set the block 1 of the message
	 * @param block1 the content of the block 1
	 */
	public void setBlock1(final SwiftBlock1 block1) {
		this.block1 = block1;
	}

	/**
	 * Get block number 2 of this message, may be null if not set
	 * @return the block 2 of the message or null
	 */
	public SwiftBlock2 getBlock2() {
		return this.block2;
	}

	/**
	 * Set the block 2 of the message
	 * @param block2 the content of the block 1
	 */
	public void setBlock2(final SwiftBlock2 block2) {
		this.block2 = block2;
	}

	/**
	 * Get block number 3 of this message, may be null if not set
	 * @return the block 3 of the message or null
	 */
	public SwiftBlock3 getBlock3() {
		return this.block3;
	}

	/**
	 * Set the block 3 of the message
	 * @param block3 the content of the block 1
	 */
	public void setBlock3(final SwiftBlock3 block3) {
		this.block3 = block3;
	}

	/**
	 * Get block number 4 of this message, may be null if not set
	 * @return the block 4 of the message or null
	 */
	public SwiftBlock4 getBlock4() {
		return this.block4;
	}

	/**
	 * Set the block 4 of the message
	 * @param block4 the content of the block 1
	 */
	public void setBlock4(final SwiftBlock4 block4) {
		this.block4 = block4;
	}

	/**
	 * Get block number 5 of this message, may be null if not set
	 * @return the block 5 of the message or null
	 */
	public SwiftBlock5 getBlock5() {
		return this.block5;
	}

	/**
	 * Set the block 5 of the message
	 * @param block5 the content of the block 5
	 */
	public void setBlock5(final SwiftBlock5 block5) {
		this.block5 = block5;
	}

	/**
	 * Finds the position of a given User Defined Block in the internal list
	 * @param blockName the block name to find may be empty or null, in which case this method does nothing
	 * @return the position or -1 if not found
	 *
	 * @since 5.0
	 */
	public int getUserBlockPosition(final String blockName) {
		// check parameters
		if (StringUtils.isBlank(blockName) || //check user blocks array
				(this.userBlocks == null)) {
			return -1;
		}

		// start scanning the list
		for (int i = 0; i < this.userBlocks.size(); i++) {
			final SwiftBlockUser userBlock = (SwiftBlockUser) this.userBlocks.get(i);
			if (userBlock != null && StringUtils.equals(userBlock.getName(), blockName)) {
				return i;
			}
		}

		return -1;
	}

	/**
	 * Get the list of List of {@link SwiftBlockUser} user defined blocks.
	 * The requested object may be null if the message was cleared or not initialized.
	 *
	 * @return the list or user blocks or null
	 * @since 5.0
	 */
	public List<SwiftBlockUser> getUserBlocks() {
		return this.userBlocks;
	}

	/**
	 * Set the list of user defined blocks.<br>
	 * This method is mainly needed for persistence services.
	 *
	 * @param userBlocks the new list of user defined blocks
	 * @throws IllegalArgumentException if parameter userBlocks is null
	 * @throws IllegalArgumentException if parameter userBlocks has elements of class other than SwiftBlockUser
	 * @since 5.0
	 * @see SwiftBlockUser
	 */
	public void setUserBlocks(final List<SwiftBlockUser> userBlocks) {
		// sanity check
		Validate.notNull(userBlocks, "parameter 'userBlocks' cannot be null");

		// setup the new list
		this.userBlocks = userBlocks;
	}

	/**
	 * Get a user defined block by name, may be null if not set
	 *
	 * @param blockName the name of the block to find
	 * @return the requested user defined block or null
	 * @throws IllegalArgumentException if parameter blockName is null
	 * @throws IllegalArgumentException if parameter blockName has an invalid block name
	 * @since 5.0
	 */
	public SwiftBlockUser getUserBlock(final String blockName) {
		// sanity check
		Validate.notNull(blockName, "parameter 'blockName' cannot be null");

		// find the block position
		final int pos = getUserBlockPosition(blockName);
		if (pos != -1) {
			return this.userBlocks.get(pos);
		}

		return null;
	}

	/**
	 * Get a user defined block by number, may be null if not set
	 *
	 * @param blockNumber the number of the block to find
	 * @return the requested user defined block or null
	 * @throws IllegalArgumentException if parameter userBlock is null
	 * @throws IllegalArgumentException if parameter userBlock has an invalid block name
	 *
	 * @since 5.0
	 */
	public SwiftBlockUser getUserBlock(final Integer blockNumber) {
		// sanity check
		Validate.notNull(blockNumber, "parameter 'blockNumber' cannot be null");

		return this.getUserBlock(blockNumber.toString());
	}

	/**
	 * Add a user defined block to the message (if the block already exists, it is replaced)
	 * @param userBlock the user defined block
	 * @throws IllegalArgumentException if parameter userBlock is null
	 * @throws IllegalArgumentException if parameter userBlock has an invalid block name
	 * @since 5.0
	 */
	public void addUserBlock(final SwiftBlockUser userBlock) {
		// sanity check
		Validate.notNull(userBlock);
		Validate.isTrue(userBlock.isValidName().booleanValue(), INVALID_NAME_BLOCK + userBlock.getName() + ")");

		if (this.userBlocks == null) {
			this.userBlocks = new ArrayList<>();
		}

		// find the block position (if it's already there)
		final int pos = getUserBlockPosition(userBlock.getName());
		if (pos != -1) {
			this.userBlocks.add(pos, userBlock);
		} else {
			this.userBlocks.add(userBlock);
		}
	}

	/**
	 * removes a user defined block to the message (if the block does not exists, nothing is done)
	 * @param blockNumber the block number to remove
	 * @throws IllegalArgumentException if parameter blockNumber is null
	 * @throws IllegalArgumentException if parameter blockNumber is invalid
	 * @since 5.0
	 * @see SwiftBlockUser#isValidName(Integer)
	 */
	public void removeUserBlock(final Integer blockNumber) {
		// sanity check
		Validate.notNull(blockNumber, "parameter 'blockNumber' cannot be null");
		Validate.isTrue(SwiftBlockUser.isValidName(blockNumber).booleanValue(), INVALID_NAME_BLOCK + blockNumber.toString() + ")");

		this.removeUserBlock(blockNumber.toString());
	}

	/**
	 * removes a user defined block to the message (if the block does not exists, nothing is done)
	 * @param blockName the block name to remove
	 * @throws IllegalArgumentException if parameter blockName is null
	 * @throws IllegalArgumentException if parameter blockName is invalid
	 * @since 5.0
	 */
	public void removeUserBlock(final String blockName) {
		// sanity check
		Validate.notNull(blockName, "parameter 'blockName' cannot be null");
		Validate.isTrue(SwiftBlockUser.isValidName(blockName).booleanValue(), INVALID_NAME_BLOCK + blockName + ")");

		// find the block position (if it's there)
		final int pos = getUserBlockPosition(blockName);
		if (pos != -1) {
			this.userBlocks.remove(pos);
		}
	}

	/**
	 * remove all blocks from these message, including user blocks
	 */
	public void clear() {
		// release all blocks
		this.block1 = null;
		this.block2 = null;
		this.block3 = null;
		this.block4 = null;
		this.block5 = null;

		// release user blocks
		this.userBlocks = null;
	}

	/**
	 * Checks if the message is a fragment
	 * @return true if the message is a fragment
	 *
	 * @since 5.0
	 */
	public Boolean isFragment() {
		// get the block 4 (if exists)
		final SwiftBlock4 b4 = this.block4;
		if (b4 != null) {
			final String t202 = b4.getTagValue("202");
			final String t203 = b4.getTagValue("203");

			// if both tag exists => this is a fragment
			return t202 != null && t203 != null ? Boolean.TRUE : Boolean.FALSE;
		}
		return Boolean.FALSE;
	}

	/**
	 * Checks if the message is the last fragment
	 * @return true if the message is the last fragment of a fragmented message
	 *
	 * @since 5.0
	 */
	public Boolean isLastFragment() {
		if (!this.isFragment().booleanValue()) {
			return (Boolean.FALSE);
		}
		final Integer count = this.fragmentCount();
		try {
			final Integer number = this.fragmentNumber();
			return count.intValue() == number.intValue() ? Boolean.TRUE : Boolean.FALSE;
		} catch (final UnsupportedOperationException e) {
			throw new IllegalStateException("Invalid call to islastFragment for a non fragmented message", e);
		}
	}

	/**
	 * Gets the total number of fragments of a fragmented message as informed in tag 203.
	 *
	 * @return the total number of fragments or zero if the message is not fragmented
	 * @since 5.0
	 */
	public Integer fragmentCount() {
		// if this is not a fragment => 0
		if (!this.isFragment().booleanValue()) {
			return new Integer(0);
		}

		// get the block 4 and tag 203 (they BOTH exists here)
		final String t203 = this.block4.getTagValue("203");

		// process the number
		Integer _t203;
		try {
			_t203 = new Integer(Integer.parseInt(t203, 10));
		} catch (final NumberFormatException nfe) {
			throw new UnsupportedOperationException(MESSAGE_IS_NOT_A_FRAGMENT);
		}

		return _t203;
	}

	/**
	 * Gets the number of this fragment
	 *
	 * @return the number of this fragment
	 * @throws UnsupportedOperationException if the message is not a part of a fragmented message
	 * @since 5.0
	 */
	public Integer fragmentNumber() {
		// if this is not a fragment => 0
		if (!this.isFragment().booleanValue()) {
			throw new UnsupportedOperationException(MESSAGE_IS_NOT_A_FRAGMENT);
		}

		// get the block 4 and tag 203 (they BOTH exists here)
		final String t202 = this.block4.getTagValue("202");

		// process the number
		Integer _t202;
		try {
			_t202 = new Integer(Integer.parseInt(t202, 10));
		} catch (final NumberFormatException nfe) {
			throw new UnsupportedOperationException(MESSAGE_IS_NOT_A_FRAGMENT);
		}

		return _t202;
	}

	/**
	 * Gets the signature of the message (looks for an S block then the MDG tag)
	 *
	 * @return the signature of the message (or null if none exists)
	 * @since 7.10.4
	 */
	public String getSignature() {

		// prepare the result
		String signature = null;

		// get the S block (create if it does not exist in the message)
		SwiftBlockUser sBlock = getUserBlock("S");
		if (sBlock != null) {

			// get the MDG tag from the block
			Tag mdg = sBlock.getTagByName("MDG");
			if (mdg != null) {

				// get the signature from the tag
				signature = mdg.getValue();
			}
		}

		return signature;
	}

	/**
	 * Sets the signature for the message (adds an S block with the MDG tag)
	 *
	 * @param signature the signature to set in block S
	 * @return <code>this</code>
	 * @since 7.10.4
	 */
	public SwiftMessage setSignature(String signature) {

		// get the S block (create if it does not exist in the message)
		SwiftBlockUser sBlock = getUserBlock("S");
		if (sBlock == null) {

			// create the block
			sBlock = new SwiftBlockUser("S");

			// add the block to the message
			addUserBlock(sBlock);
		}

		// remove any MDG tag from the block (if present)
		Tag mdg = sBlock.getTagByName("MDG");
		if (mdg == null) {

			// create the tag
			mdg = new Tag();
			mdg.setName("MDG");
			sBlock.append(mdg);
		}

		// set the signature on the tag
		mdg.setValue(signature);

		return this;
	}

	/**
	 * verifies that the unparsed text list exists
	 */
	protected void unparsedTextVerify() {
		if (this.unparsedTexts == null) {
			this.unparsedTexts = new UnparsedTextList();
		}
	}

	/**
	 * returns the unparsed text list
	 * @return the unparsed text attached to this message
	 */
	public UnparsedTextList getUnparsedTexts() {
		// create the list if needed
		unparsedTextVerify();
		return this.unparsedTexts;
	}

	/**
	 * sets the list of unparsed texts
	 * @param texts the new list of unparsed texts (may be null)
	 */
	public void setUnparsedTexts(final UnparsedTextList texts) {
		this.unparsedTexts = texts;
	}

	/**
	 * returns the size of the unparsed text list
	 * @return the count of unparsed texts attached to this message
	 */
	public Integer getUnparsedTextsSize() {
		// no list => size is zero...
		if (this.unparsedTexts == null) {
			return new Integer(0);
		}
		return this.unparsedTexts.size();
	}

	/**
	 * decides if a specific text (by index) is likely a SWIFT FIN message. Exceptions are inherited from
	 * base implementation methods.
	 * @param index the unparsed text number
	 * @return true if the unparsed text at position index is a full SWIFT message
	 * @throws IllegalArgumentException if parameter index is null
	 * @throws IndexOutOfBoundsException if parameter index is out of bounds
	 */
	public Boolean unparsedTextIsMessage(final Integer index) {
		// create the list if needed
		unparsedTextVerify();
		return this.unparsedTexts.isMessage(index);
	}

	/**
	 * get an unparsed text
	 * @param index the unparsed text number
	 * @return the requested text
	 * @throws IllegalArgumentException if parameter index is null
	 * @throws IndexOutOfBoundsException if parameter index is out of bounds
	 */
	public String unparsedTextGetText(final Integer index) {
		// create the list if needed
		unparsedTextVerify();
		return this.unparsedTexts.getText(index);
	}

	/**
	 * get an unparsed text as a parsed swift message
	 * @param index the unparsed text number
	 * @return the unparsed text at position index parsed into a SwiftMessage object
	 * @throws IllegalArgumentException if parameter index is null
	 */
	public SwiftMessage unparsedTextGetAsMessage(final Integer index) {
		// create the list if needed
		unparsedTextVerify();
		return this.unparsedTexts.getTextAsMessage(index);
	}

	/**
	 * adds a new unparsed text
	 * @param text the unparsed text to append
	 * @throws IllegalArgumentException if parameter text is null
	 */
	public void unparsedTextAddText(final String text) {
		// create the list if needed
		unparsedTextVerify();
		this.unparsedTexts.addText(text);
	}

	/**
	 * adds a new unparsed text from a message
	 * @param message the message to be appended
	 * @throws IllegalArgumentException if parameter message is null
	 */
	public void unparsedTextAddText(final SwiftMessage message) {
		// create the list if needed
		unparsedTextVerify();
		this.unparsedTexts.addText(message);
	}

	/**
	 * Checks if the message is a cover payment, based on the content of the User Header (block3).
	 * @return true if 119:COV is found at User Header (block3)
	 */
	public boolean isCOV() {
		if (this.block3 != null) {
			return this.block3.containsTag(Field119.tag(MTVariant.COV.name()));
		}
		return false;
	}

	/**
	 * Checks if the message is Straight Through Processing (STP), based on the content of the User Header (block3).
	 * @return true if 119:STP is found at User Header (block3)
	 */
	public boolean isSTP() {
		if (this.block3 != null) {
			return this.block3.containsTag(Field119.tag(MTVariant.STP.name()));
		}
		return false;
	}

	/**
	 * Checks if the message is a remit, based on the content of the User Header (block3).
	 * @return true if 119:REMIT is found at User Header (block3)
	 * @since 7.7
	 */
	public boolean isREMIT() {
		if (this.block3 != null) {
			return this.block3.containsTag(Field119.tag(MTVariant.REMIT.name()));
		}
		return false;
	}

	/**
	 * Gets the message sender BIC from the message headers.
	 * <p>For outgoing messages this is the the logical terminal at block 1,
	 * and for incoming messages this is logical terminal at the MIR of block 2.
	 * <p>for service message (example acknowledges) always returns the logical terminal from block1
	 *
	 * @return the proper sender address or null if blocks 1 or 2 are not found or incomplete
	 */
	public String getSender() {
		try {
			if (isServiceMessage() || getDirection() == MessageIOType.outgoing) {
				return this.block1 == null ? null : this.block1.getLogicalTerminal();
			} else if (getDirection() == MessageIOType.incoming) {
				if (this.block2 != null) {
					return ((SwiftBlock2Output) this.block2).getMIRLogicalTerminal();
				}
			}
		} catch (final Exception e) {
			log.severe("Exception occurred while retrieving sender's BIC from message data: "+e);
		}
		return null;
	}

	/**
	 * Gets the message receiver BIC from the message headers.
	 * <p>For outgoing messages this is the receiver address at block 2,
	 * and for incoming messages this is logical terminal at block 1.
	 * <p>for service message (example acknowledges) always returns null
	 * 
	 * @return the proper receiver address or null if blocks 1 or 2 are not found or incomplete
	 */
	public String getReceiver() {
		try {
			if (isServiceMessage()) {
				return null;
			} else if (getDirection() == MessageIOType.incoming) {
				return this.block1.getLogicalTerminal();
			} else if (getDirection() == MessageIOType.outgoing) {
				return ((SwiftBlock2Input) this.block2).getReceiverAddress();
			} else {
				return null;
			}
		} catch (final Exception e) {
			log.severe("Exception occurred while retrieving receiver's BIC from message data: "+e);
			return null;
		}
	}

	/**
	 * Get all fields with the given name in the block 4.
	 * <em>Only direct naming is supported, 55a notation is NOT SUPPORTED</em>.
	 *
	 * @param names list of names to add in fields to search
	 * @return a list with fields matching the given names. an empty list if none found
	 * @throws IllegalArgumentException if names is null
	 */
	public List<Field> fields (final String ... names) {
		Validate.notNull(names, "names is null");
		final List<Field>result = new ArrayList<>();
		for (final String n:names) {
			final Tag[] tl = this.block4.getTagsByName(n);
			if (tl != null && tl.length>0) {
				for (final Tag t:tl) {
					result.add(t.asField());
				}
			}
		}
		return result;
	}

	/**
	 * Checks all blocks (1 to 5) and if a block is empty, it is removed from the message.
	 * @since 6.4
	 */
	public void removeEmptyBlocks() {
		if (this.block1 != null && this.block1.isEmpty()) {
			this.block1 = null;
		}
		if (this.block2 != null && this.block2.isEmpty()) {
			this.block2 = null;
		}
		if (this.block3 != null && this.block3.isEmpty()) {
			this.block3 = null;
		}
		if (this.block4 != null && this.block4.isEmpty()) {
			this.block4 = null;
		}
		if (this.block5 != null && this.block5.isEmpty()) {
			this.block5 = null;
		}
	}

	/**
	 * Gets message type as an int or -1 if an error occurs or it is not set
	 * @return the message type number or -1 if the message type is invalid or block 2 not present (for instance if the message is a service message)
	 * @since 6.4.1
	 */
	public int getTypeInt() {
		if (isServiceMessage()) {
			return -1;
		}
		try {
			return Integer.valueOf(getType());
		} catch (final NumberFormatException e) {
			final String text = "Error converting type to int " + getType();
			log.warning(text);
			log.log(Level.FINEST, text, e);
			return -1;
		}
	}

	/**
	 * Returns the message direction from block 2 or null if block 2 is not found or incomplete
	 * @since 7.0
	 */
	public MessageIOType getDirection() {
		try {
			if (this.block2 == null) {
				log.info("Requesting direction on a message without block2, can't determine direction. set log level to finer to view more details");
				log.finest("Message: " + this);
			} else {
				if (this.block2.isOutput()) {
					return MessageIOType.incoming;
				} else if (this.block2.isInput()) {
					return MessageIOType.outgoing;
				}
			}
		} catch (final Exception e) {
			log.severe("Unexpected exception ocurred while determining direction from message data: " + e);
		}
		return null;
	}
	
	/**
	 * Returns true if the message is outgoing (sent to SWIFT), false other case; using the direction attribute.
	 * If block 2 is missign or direction cannot be determined, returns false.
	 * @since 7.8.4
	 */
	public boolean isOutgoing() {
		return getDirection() == MessageIOType.outgoing;
	}
	
	/**
	 * @see #isOutgoing()
	 * @since 7.8.4
	 */
	public boolean isInput() {
		return isOutgoing();
	}

	/**
	 * Returns true if the message is incoming (received from SWIFT), false other case; using the direction attribute.
	 * If block 2 is missign or direction cannot be determined, returns false.
	 * @since 7.8.4
	 */
	public boolean isIncoming() {
		return getDirection() == MessageIOType.incoming;
	}

	/**
	 * @see #isIncoming()
	 * @since 7.8.4
	 */
	public boolean isOutput() {
		return isIncoming();
	}
	
	/**
	 * Gets PDE (Possible Duplicate Emission) flag from the trailer block or null if the trailer or the PDE field is not present
	 * <p>Notice the PDE tag could hold no value, so in that case empty string is returned, meaning the flag is set but with no value.
	 * @since 7.0
	 */
	public String getPDE() {
		if (this.block5 != null) {
			Optional<Tag> t = this.block5.getTag(SwiftBlock5Field.PDE);
			if (t.isPresent()) {
				return t.get().getValue();
			}
		}
		return null;
	}

	/**
	 * Sets the Possible Duplicate Emission tag with no value, in the trailer block (block 5),
	 * <p>If the field exists, its value will be overwritten.
	 * @since 8.0.2
	 */
	public SwiftMessage setPDE() {
		if (this.block5 == null) {
			this.block5 = new SwiftBlock5();
		}
		this.block5.setPDE();
		return this;
	}

	/**
	 * Gets PDM from the trailer block or null if the trailer or the PDM field is not present
	 * @since 7.0
	 */
	public String getPDM() {
		if (this.block5 != null) {
			Optional<Tag> t = this.block5.getTag(SwiftBlock5Field.PDM);
			if (t.isPresent()) {
				return t.get().getValue();
			}
		}
		return null;
	}

	/**
	 * The MIR (Message Input Reference) is a String of 28 characters, always local to the sender of the message.
	 * It includes the date the sender sent the message to SWIFT, followed by the full LT address of the sender of the
	 * message, and the sender's session and sequence to SWIFT: YYMMDD BANKBEBBAXXX 2222 123456.
	 * It is only available in incoming messages (received from SWIFT).
	 * @since 7.0
	 */
	public String getMIR() {
		if (this.block2 != null && this.block2.isOutput()) {
			return ((SwiftBlock2Output) this.block2).getMIR();
		} else {
			return null;
		}
	}

	/**
	 * Gets MUR (Message User Reference) from the user header block or null if the user header or MUR are not present.
	 * <p>The MUR is the Message User Reference used by applications for reconciliation with ACK.
	 * It is a free-format field in which users may specify their own reference of up to 16 characters
	 * of the permitted character set, and it is contained in a 108 field at the message user header (block 3).
	 * @since 7.0
	 */
	public String getMUR() {
		return this.block3 != null? this.block3.getTagValue(Field108.NAME) : null;
	}

	/**
	 * Sets the MUR (Message User Reference) in the user header block.
	 * <p>If a MUR field is present, its value will be overwritten.
	 * <p>The MUR is the Message User Reference used by applications for reconciliation with ACK.
	 * It is a free-format field in which users may specify their own reference of up to 16 characters
	 * of the permitted character set, and it is contained in a 108 field at the message user header (block 3).
	 * @param mur a non blank MUR value to set, if value is blank this method does nothing
	 * @return this
	 * @since 7.10.4
	 */
	public SwiftMessage setMUR(String mur) {
		if (StringUtils.isNotBlank(mur)) {
			if (this.block3 == null) {
				this.block3 = new SwiftBlock3();
			}
			this.block3.builder().setField108(new Field108(mur));
		}
		return this;
	}

	/**
	 * Gets a UUID (User Unique Identifier) for the message conformed by:
	 * 
	 * <ul>
	 * 	<li>Direction: A single-character direction indicator; "I" for an outgoing message (input to the network) and "O" for an incoming message (output from the network). Defaults to "I".</li>
	 * 	<li>The correspondent BIC 11 code; the receiver for an outgoing messages and the sender for an incoming message.</li>
	 * 	<li>Message type: the 3-character number identifying the specific message.</li>
	 *	<li>Reference: field 20 or field 20C:SEME returned by {@link SwiftMessageUtils#reference(SwiftMessage)}</li>
	 * </ul>
	 * 
	 * <p>Notice despite the name this identifier is unique only in the context of a specific message management platform,
	 * since all its values could be repeated from one installation to another. To make it completely unique in your
	 * application context, consider using {@link #getUID(Calendar, Long)}
	 * @since 7.0
	 */
	public String getUUID() {
		StringBuilder uuid = new StringBuilder();
		if (isIncoming()) {
			uuid.append("O");
		} else {
			uuid.append("I");
		}
		BIC corresp = getCorrespondentBIC();
		if (corresp != null) {
			uuid.append(corresp.getBic11());
		}
		uuid.append(StringUtils.trimToEmpty(getType()));
		uuid.append(StringUtils.trimToEmpty(SwiftMessageUtils.reference(this)));
		return uuid.toString();
	}

	/**
	 * Gets a UID (Unique Identifier) for the message appending a suffix to the UUID generated with {@link #getUUID()}.
	 * 
	 * <p>The suffix is a system-generated value that can help uniquely identify a message. The suffix generated by this method is similar to the suffix
	 * used by SWIFT Alliance Lite. The first part is the creation date of the message in YYMMDD format, a six-digit number. The second part consists of 
	 * 1-10 left padded digit number generated from the container application/system incremental identifier.
	 * 
	 * @param created optional creation date, if provided, the YYMMDD will be appended as first part of the suffix
	 * @param id optional incremental identifier number from the application, if provided it will be appended as second part of the suffix
	 * @return the created UID
	 * @since 7.9.5
	 */
	public String getUID(final Calendar created, final Long id) {
		StringBuilder suffix = new StringBuilder();
		if (created != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
			suffix.append(sdf.format(created.getTime()));
		}
		if (id != null) {
			suffix.append(StringUtils.leftPad(String.valueOf(id), 10, "0"));
		}
		if (suffix.length() == 0) {
			log.warning("The computed suffix for message UID is blank, provide either the creation date or the numeric identifier as parameters for getUID");
		}
		return getUUID() + suffix.toString();
	}

	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	public SequenceNode getParsedSequences() {
		DeprecationUtils.phase2(getClass(), "getParsedSequences()", "This is part of an discarded attempt to provide a structured model in the SwiftMessage object, it is still kept for backward compatibility but should not be used");
		return parsedSequences;
	}

	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	public void setParsedSequences(final SequenceNode parsedSequences) {
		DeprecationUtils.phase2(getClass(), "getParsedSequences()", "This is part of an discarded attempt to provide a structured model in the SwiftMessage object, it is still kept for backward compatibility but should not be used");
		this.parsedSequences = parsedSequences;
	}

	/**
	 * return first results of fields() or null if none
	 * @param name
	 * @see #fields(String...)
	 * @return null if not found
	 */
	public Field field(final String name) {
		final List<Field> l = fields(name);
		if (l.size()==0) {
			return null;
		}
		return l.get(0);
	}

	/**
	 * Checks if the message is linked to other message based on the presence of a LINK sequence.
	 * @return true if the message has a LINK sequence, false if it hasn't, and null if cannot determine
	 *
	 * @since 7.4
	 */
	public Boolean isLinked() {
		if (this.block4 != null) {
			return !this.block4.getSubBlock("LINK").isEmpty();
		}
		return null;
	}

	/**
	 * Return the message's LINK sequences if any.
	 * @return a block containing the found linkage sequences or null if cannot determine
	 *
	 * @since 7.4
	 */
	public List<SwiftTagListBlock> getLinkages() {
		if (this.block4 != null) {
			return this.block4.getSubBlocks("LINK");
		}
		return null;
	}

	/**
	 * Legacy (version 1) json representation of this object.
	 *
	 * <p>This implementation has been replaced by version 2, based on Gson.
	 * The main difference is in block4 where the new version serializes the list
	 * of Tag under a field named "tags", and in block 2 where the direction (I/O)
	 * has been explicitly added.
	 *
	 * @deprecated use {@link #toJson()} instead
	 * @since 7.9.8
	 */
	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	public String toJsonV1() {
		DeprecationUtils.phase2(getClass(), "toJsonV1()", "use toJson() instead");
		/*
		 * Return an ISO 8601 combined date and time string for current timestamp
		 */
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
		dateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
		final String ts = dateFormat.format(Calendar.getInstance().getTime());

		final StringBuilder sb = new StringBuilder();
		sb.append("{ \"version\" : ").append(JSON_VERSION).append(",\n");

		sb.append(" \"timestamp\" : \"").append(ts).append("\",\n");

		sb.append(" \"data\" : { \n");

		sb.append("\"block1\" : \n");
		if (this.block1 == null) {
			sb.append(" {}");
		} else {
			sb.append(this.block1.toJson());
		}
		sb.append(",\n");

		sb.append("\"block2\" : \n");
		if (this.block2 == null) {
			sb.append(" {}");
		} else {
			sb.append(this.block2.toJson());
		}
		sb.append(",\n"); // block

		appendBlock("3", sb, this.block3);
		sb.append(',');
		appendBlock("4", sb, this.block4);
		sb.append(',');
		appendBlock("5", sb, this.block5);

		// add user blocks add if present - requires starting with a comma
		if (this.userBlocks != null && !this.userBlocks.isEmpty()) {
			final Iterator<SwiftBlockUser> ubit = this.userBlocks.iterator();
			sb.append(',');
			sb.append("\"userblocks\" : [ \n");
			while (ubit.hasNext()) {
				final SwiftBlockUser ub = ubit.next();
				sb.append("{ ");
				sb.append("\"name\" :  \"").append(ub.getName()).append("\",\n \"tags\" : ");
				sb.append(ub.toJson());
				sb.append("}\n");
			}
			sb.append("] \n");
		}

		sb.append("}\n"); // data
		sb.append("}\n"); // message

		return sb.toString();
	}

	/**
	 * Get a json representation of this object.
	 * <br>
	 * Generated JSON string will contain additional properties with
	 * version number and timestamp, while the actual SwiftMessage
	 * serialization is put into a data element.<br>
	 * 
	 * Example:<br>
	 * <pre>
	 * { "version": 2, "timestamp": "2016-08-26T23:57:36Z", data": {
	 * "block1": {
	 * 		"applicationId": "F",
	 * 		"serviceId": "01",
	 * 		"logicalTerminal": "FOOSEDR0AXXX",
	 * 		"sessionNumber": "0000",
	 * 		"sequenceNumber": "000000"
	 * } ,
	 * "block2": {
	 *  	"messageType": "103",
	 *  	"receiverAddress": "FOORECV0XXXX",
	 *  	"messagePriority": "N",
	 *  	"deliveryMonitoring": "null",
	 *  	"obsolescencePeriod": "null"
	 *  }
	 *  "block4": {
	 *  	"tags": [
	 *  		{ "20": "REFERENCE" },
	 *  		{ "23B": "CRED" },
	 *  		{ "32A": "130204USD1234567,89" },
	 *  		{ "50K": "/12345678901234567890\nFOOBANKXXXXX" },
	 *  		{ "59": "/12345678901234567890\nJOE DOE" },
	 *  		{ "71A": "OUR" }
	 *  		]
	 *  	}
	 *  }
	 *  </pre>
	 * 
	 * @since 7.5
	 */
	@Override
	public String toJson() {
		final Gson gson = new GsonBuilder()
			.registerTypeAdapter(SwiftMessage.class, new SwiftMessageAdapter())
			.registerTypeAdapter(SwiftBlock2.class, new SwiftBlock2Adapter())
			.setPrettyPrinting()
			.create();
		return gson.toJson(this);
	}

	/**
	 * This method deserializes the JSON data into a message object.
	 *
	 * @see #toJson()
	 * @since 7.9.8
	 */
	public static SwiftMessage fromJson(String json){
		final Gson gson = new GsonBuilder()
			.registerTypeAdapter(SwiftMessage.class, new SwiftMessageAdapter())
			.registerTypeAdapter(SwiftBlock2.class, new SwiftBlock2Adapter())
			.create();
		return gson.fromJson(json,SwiftMessage.class);
	}

	/**
	 * Gets a proprietary XML representation of this message.<br>
 	 * Notice: it is neither a standard nor the MX version of this MT.
	 * @see XMLWriterVisitor
	 * @see XMLParser
	 * @return the MT message serialized into the proprietary XML
	 * @since 7.8.4
	 */
	public final String toXml() {
		final StringWriter w = new StringWriter();
		visit(new XMLWriterVisitor(w, true));
		final String xml = w.getBuffer().toString();
		if (log.isLoggable(Level.FINEST)) {
			log.finest("xml: "+xml);
		}
		return xml;
	}

	private void appendBlock(final String blockName, final StringBuilder sb, final SwiftTagListBlock b) {
		sb.append("\"block"+blockName+"\" : \n");
		if (b == null) {
			sb.append("{ }");
		} else {
			sb.append(b.toJson());
		}
		sb.append("\n"); // block
	}

	/**
	 * Get the MTxxx instance that corresponds to the current message type.
	 * <p>If you have a MT102 in a SwiftMessage, this method is the same as invoking
	 * <code>new MT102(SwiftMessage)</code>.
	 * <p>For messages with service id 21 = GPA/FIN Message (ACK/NAK/UAK/UNK) it will
	 * return an instance of {@link ServiceMessage21}.
	 * 
	 * @return created specific MT object or null if the message type is not set or an error occurs during message creation 
	 */
	public AbstractMT toMT() {
		final String type = getType();
		if (type == null) {
			if (isServiceMessage21()) {
				return ServiceMessage21.newInstance(this);
			}
			log.warning("Cannot determine the message type from application header (block 2)");
		} else {
			final StringBuilder className = new StringBuilder();
			className.append("com.prowidesoftware.swift.model.mt.mt");
			className.append(String.valueOf((char) type.charAt(0)));
			className.append("xx.MT");
			className.append(type);
			if (isSTP()) {
				if (isType(102, 103)) {
					className.append("_STP");
				} else {
					log.warning("Unexpected STP flag in MT "+getType());
				}
			} else if (isREMIT()) {
				if (isType(103)) {
					className.append("_REMIT");
				} else {
					log.warning("Unexpected REMIT flag in MT "+getType());
				}
			} else if (isCOV()) {
				if (isType(202, 205)) {
					className.append("COV");
				} else {
					log.warning("Unexpected COV flag in MT "+getType());
				}
			}
			log.finer("About to create an instance of "+className);
			try {
				final Class<?> mtClass = Class.forName(className.toString());
				return (AbstractMT) mtClass.getConstructor(SwiftMessage.class).newInstance(this);
			} catch (final Exception e) {
				log.warning("Could not create instance of "+className+": "+e);
			}
		}
		return null;
	}

	/**
	 * <p>Returns true if the message type is equal to the given number.
	 * <p>Notice this method only checks the message type number but can be combined with any
	 * message variant check such as {@link #isSTP()}, {@link #isREMIT()} or {@link #isCOV()}
	 * to determine the message kind precisely.
	 * <p>The implementation uses {@link #getTypeInt()}
	 *
	 * @param type message type number to check
	 * @return true if message type matches, false if does not match or cannot be determined because the message content is invalid
	 * @since 7.8.9
	 */
	public boolean isType(final int type) {
		return getTypeInt() == type;
	}
	
	/**
	 * Returns true if the message type is equal to one of the given numbers.
	 * The implementation uses {@link #getTypeInt()}
	 * @param types message type numbers to check
	 * @return true if message type matches, false if does not match or cannot be determined because the message content is invalid
	 * @since 7.7
	 */
	public boolean isType(final int... types) {
		final int mt = getTypeInt();
		for (final int t : types) {
			if (mt == t) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Returns true if the message category is equal to one of the given by parameter
	 * @param categories the categories 0 to 9 to check
	 * @return true if message category, false if does not match or cannot be determined because the message content is invalid or the categories parameter contains values other than 0 to 9
	 * @since 7.8.8
	 */
	public final boolean isCategory(final MtCategory... categories) {
		final MtCategory cat = getCategory();
		for (final MtCategory t : categories) {
			if (cat == t) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the message category from the message type.
	 * This implementation uses {@link #getType()} to retrieve the message type of the message.
	 * @return the category found as the first digit of the message type or null if block 2 is not found or the message type is not category number
	 */
	public final MtCategory getCategory() {
		final String type = getType();
		if (type != null) {
			try {
				return MtCategory.valueOf("_"+type.substring(0, 1));
			} catch (final Exception e) {
				final String text = "Error extracting category from message type " + getType();
				log.warning(text);
				log.log(Level.FINEST, text, e);
			}
		}
		return null;
	}

	/**
     * Returns true if message service id is anything but 01 = GPA/FIN Message (system and user-to-user)
     * 
     * @since 7.8.8
     */
    public final boolean isServiceMessage() {
    	if (this.block1 == null) {
    		return false;
    	}
    	return this.block1.getServiceIdType() != ServiceIdType._01;
    }

	/**
     * Returns true if message service id is 21 = GPA/FIN Message (ACK/NAK/UAK/UNK)
	 *
     * <p>IMPORTANT: Note despite the method name this will NOT return true for FIN system messages (category 0).
     * It is just useful to detect acknowledges.<br>
     * To check for system messages use {@link #isCategory(MtCategory...)} instead, passing zero as parameter
     * 
     * <p>@deprecated this method is kept for backward compatibility but was replace by {@link #isServiceMessage21()} which
     * reflects what the method returns properly. Notice a "system message" is actually a message with category 0, which is 
     * not the same as a "service message".
     * 
     * @since 7.8
     */
    @Deprecated
    @ProwideDeprecated(phase4=TargetYear.SRU2020)
    public boolean isSystemMessage() {
    	DeprecationUtils.phase3(getClass(), "isSystemMessage()", "Despite the method name this will NOT return true for FIN system messages (category 0), use isServiceMessage21() instead.");
    	return isServiceMessage21();
    }

    /**
     * Returns true if message service id is 21 = GPA/FIN Message (ACK/NAK/UAK/UNK)
     * @return true if it is a service message for acknowledgment, false if not or header is null and service id cannot be determined
     * @since 7.8.9
     */
    public boolean isServiceMessage21() {
    	if (this.block1 == null) {
    		return false;
    	}
    	return this.block1.getServiceIdType() == ServiceIdType._21;
    }
    
    /**
     * Returns true if this message is an ACK.
     * This is determined by testing first if it is a system message, and second
     * the value of tag 451
     * 
     * @since 7.8
     */
	public boolean isAck() {
		if (isServiceMessage21()) {
			if (this.block4 == null) {
				return false;
			}
			return StringUtils.equals(this.block4.getTagValue(Field451.NAME), "0");
		}
		return false;
	}
	
	/**
	 * Returns true if this message is an NACK.
	 * This is determined by testing first if it is a system message, and second
	 * the value of tag 451
	 * 
	 * @since 7.8
	 */
	public boolean isNack() {
		if (isServiceMessage21()) {
			if (this.block4 == null) {
				return false;
			}
			return StringUtils.equals(this.block4.getTagValue(Field451.NAME), "1");
		}
		return false;
	}
	
	/**
	 * @return the corresponding MT variant or null if flag field is not present
	 * @since 7.8
	 */
	public MTVariant getVariant() {
		if (isCOV()) {
			return MTVariant.COV;
		} else if (isSTP()) {
			return MTVariant.STP;
		} else if (isREMIT()) {
			return MTVariant.REMIT;
		}
		return null;
	}
	
	/**
	 * Get a list of unique tagname contained in this message
	 * @return the list of tagnames or an empty list, does not return null ever
	 * @since 7.8
	 */
	public List<String> getTagNames() {
		if (this.block4 == null || this.block4.isEmpty()) {
			return Collections.emptyList();
		}
		final List<String> result = new ArrayList<>();
		for (final Tag t : this.block4.getTags()) {
			if (!result.contains(t.getName())) {
				result.add(t.getName());
			}
		}
		return result;
	}
	
	/**
	 * Returns the MT message identification.<br>
	 * Composed by the business process, message type and variant.
	 * Example: fin.103.STP
	 *
	 * @return the constructed message id or null if message is a service message
	 * @since 7.8.4
	 */
	public MtId getMtId() {
		if (isServiceMessage()) {
			return null;
		} else {
			return new MtId(getType(), getVariant());
		} 
	}
	
	/**
	 * Returns the correspondent BIC code from the headers.<br>
	 * For an outgoing message, the BIC address identifies the receiver of the message. Where for an incoming message it identifies the sender of the message.
	 * @return the correspondent BIC code or null if headers are not properly set
	 * @since 7.9.5
	 */
	public BIC getCorrespondentBIC() {
		if (isOutgoing()) {
			final String receiver = getReceiver();
			if (receiver != null) {
				return new BIC(receiver);
			}
		}
		if (isIncoming()) {
			final String sender = getSender();
			if (sender != null) {
				return new BIC(sender);
			}
		}
		return null;
	}

	/**
	 * Gets the Service Type Identifier (field 111 from block 3).
	 * <p>This field is used by the SWIFT gpi service to track payments messages (category 1 and 2).
	 *
	 * @return the Service Type Identifier value or null if block3 or field 111 in block3 are not present
	 * @since 7.10.0
	 */
	public String getServiceTypeIdentifier() {
		return this.block3 != null? this.block3.getTagValue(Field111.NAME) : null;
	}

	/**
	 * Sets or updates the Service Type Identifier (field 111 in block 3).
	 * <p>If the field already exists, its value will be updated; otherwise a new field will be created
	 * <p>This field is used by the SWIFT gpi service to track payments messages (category 1 and 2).
	 *
	 * @param serviceTypeIdentifier the value for field 111
	 * @since 7.10.0
	 */
	public void setServiceTypeIdentifier(final String serviceTypeIdentifier) {
		if (this.block3 == null) {
			this.block3 = new SwiftBlock3();
		}
		this.block3.builder().setField111(new Field111(serviceTypeIdentifier));
	}

	/**
	 * Gets the Unique End to End Transaction Reference (field 121 from block 3).
	 * <p>This field is used by the SWIFT gpi service to track payments messages (category 1 and 2).
	 * @return the UETR value or null if block3 or field 121 in block3 are not present
	 *
	 * @since 7.10.0
	 */
	public String getUETR() {
		return this.block3 != null? this.block3.getTagValue(Field121.NAME) : null;
	}

	/**
	 * Sets or updates the Unique End to End Transaction Reference (field 121 in block 3).
	 * <p>If the field already exists, its value will be updated; otherwise a new field will be created
	 * <p>This field is used by the SWIFT gpi service to track payments messages (category 1 and 2).
	 * @param uniqueEndToEndTransactionReference the value for field 121
	 * @since 7.10.0
	 */
	public void setUETR(final String uniqueEndToEndTransactionReference) {
		if (this.block3 == null) {
			this.block3 = new SwiftBlock3();
		}
		this.block3.builder().setField121(new Field121(uniqueEndToEndTransactionReference));
	}

	/**
	 * Creates and sets the Unique End to End Transaction Reference (field 121 in block 3).
	 * <p>If the field already exists, its value will be updated
	 * <p>This field is used by the SWIFT gpi service to track payments messages (category 1 and 2).
	 *
	 * @return the UETR created (new value of field 121 in block3 after the operation)
	 * @since 7.10.0
	 */
	public String setUETR() {
		UUID uuid = UUID.randomUUID();
		String uuid36 = uuid.toString();
		setUETR(uuid36);
		return uuid36;
	}

	/**
	 * Sets or updates a variant (STP, REMIT, COV) in field 119 in block 3.
	 * <p>If the field already exists, its value will be updated; otherwise a new field will be created
	 *
	 * @param variant the variant (validation flag) to set in field 119
	 * @since 7.10.0
	 */
	public void setVariant(final MTVariant variant) {
		if (!variant.isValidationFlag()) {
			log.warning("Field " + Field199.NAME + " should be used only for validation flags and not for " + variant.name());
		}
		if (this.block3 == null) {
			this.block3 = new SwiftBlock3();
		}
		this.block3.builder().setField119(new Field119(variant.name()));
	}

	/**
	 * Returns true if the message is part of the Global Payments Initiative (gpi) and
	 * thus requires the mandatory UETR for tracking within SWIFT gpi service.
	 * @return true if the message type is 103, 202 or 205 in any variant
	 * @since 7.10.0
	 * @see #setUETR()
	 */
	public boolean isGpi() {
		return isType(103, 202, 205);
	}

}