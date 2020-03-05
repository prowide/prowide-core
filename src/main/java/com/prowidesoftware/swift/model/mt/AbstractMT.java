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
package com.prowidesoftware.swift.model.mt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.prowidesoftware.JsonSerializable;
import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.io.ConversionService;
import com.prowidesoftware.swift.io.IConversionService;
import com.prowidesoftware.swift.io.parser.SwiftParser;
import com.prowidesoftware.swift.io.writer.SwiftWriter;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.utils.Lib;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.io.*;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Base class for specific MTs.<br>
 * This class implements several high level delegate methods of SwiftMessage.
 *
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public abstract class AbstractMT extends AbstractMessage implements JsonSerializable {
	private static final transient Logger log = Logger.getLogger(AbstractMT.class.getName());
	protected SwiftMessage m;
	private static final String GETSEQUENCE = "getSequence";
	/**
	 * @param m swift message to model as a particular MT
	 */
	public AbstractMT(SwiftMessage m) {
		super(MessageStandardType.MT);
		this.m = m;
	}

	/**
	 * Creates a particular MT initialized with a new SwiftMessage.
	 * All blocks are initialized.
	 */
	public AbstractMT() {
		super(MessageStandardType.MT);
		this.m = new SwiftMessage(true);
		if (getMessageType() != null) {
			this.m.getBlock2().setMessageType(getMessageType());
		}
	}
	
	/**
	 * Create an input message for the given type setting TEST BICS as sender and receiver.<br>
	 * All mandatory header attributes are completed with default values.
	 *
	 * @param messageType the message type
	 * @see #AbstractMT(int, String, String)
	 * @since 7.6
	 */
	public AbstractMT( final int messageType ) {
		this(messageType, BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates a new input message for the given type setting the given sender and receiver.<br>
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided. For the message type, if the indicated number is below 100 the
	 * category 0 will be assumed (meaning 10 will be set as 010).
	 * 
	 * @param messageType message type to create
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.6
	 */
	public AbstractMT(final int messageType, final String sender, final String receiver) {
		super(MessageStandardType.MT);
		this.m = new SwiftMessage(true);
		this.m.getBlock1().setSender(sender);
		final SwiftBlock2Input b2 = new SwiftBlock2Input();
		
		final StringBuilder type = new StringBuilder();
		if (messageType < 100) {
			type.append("0");
		}
		type.append(messageType);
		b2.setMessageType(type.toString());
        
        b2.setInput(true);
        b2.setMessagePriority("N");
        b2.setReceiver(receiver);
        this.m.setBlock2(b2);
	}

	/**
	 * Parses a the string content into the MTxxx that corresponds to the found message type. 
	 * If the file contains more than a message it will parse the first one. 
	 * If the string is empty, does not contain any MT message, the message type is not set or 
	 * an error occurs reading and parsing the message content; this method returns null.
	 * 
	 * @param fin string a string containing a swift MT message
	 * @return parser message or null if string content could not be parsed
	 * @throws IOException if the message content cannot be read
	 * 
	 * @since 7.7
	 */
	public static AbstractMT parse(final String fin) throws IOException {
		return (new SwiftParser(fin)).message().toMT();
	}
	
	/**
	 * Parses a the stream content into the MTxxx that corresponds to the found message type. 
	 * 
	 * @param stream a stream containing a swift MT message
	 * @return parser message or null if stream content could not be parsed
	 * @throws IOException if the stream content cannot be read
	 * @see #parse(String)
	 * 
	 * @since 7.7
	 */
	public static AbstractMT parse(final InputStream stream) throws IOException {
		return (new SwiftParser(stream)).message().toMT();
	}
	
	/**
	 * Parses a the file content into the MTxxx that corresponds to the found message type. 
	 * 
	 * @param file a file containing a swift MT message
	 * @return parser message or null if file content could not be parsed
	 * @throws IOException if the file content cannot be read
	 * @see #parse(String)
	 * 
	 * @since 7.7
	 */
	public static AbstractMT parse(final File file) throws IOException {
		return (new SwiftParser(Lib.readFile(file))).message().toMT();
	}
	
	/**
	 * @return the swift message object modeled as this particular MT
	 */
	public SwiftMessage getSwiftMessage() {
		return m;
	}

	/**
	 * Get the swift message guaranteeing a non null return.
	 * If the message is null an illegal state exception is thrown
	 * @return the swift message set 
	 * @since 7.7
	 */
	protected SwiftMessage getSwiftMessageNotNullOrException() {
		if (this.m == null) {
			throw new IllegalStateException("SwiftMessage is null");
		}
		return m;
	}

	/**
	 * @param m swift message to model as a particular MT
	 */
	public void setSwiftMessage(SwiftMessage m) {
		this.m = m;
	}
	
	/**
	 * @return application id from block 1
	 * @see SwiftBlock1#getApplicationId()
	 */
	public String getApplicationId() {
		if (getSwiftMessage() == null) {
			throw new IllegalStateException("SwiftMessage was not initialized");
		}
		if (m.getBlock1() != null) {
			return m.getBlock1().getApplicationId();
		} else {
			return null;
		}
	}

	/**
	 * @return service id from block 1
	 * @see SwiftBlock1#getServiceId()
	 */
	public String getServiceId() {
		if (getSwiftMessage() == null) {
			throw new IllegalStateException("SwiftMessage was not initialized");
		}
		if (m.getBlock1() != null) {
			return m.getBlock1().getServiceId();
		} else {
			return null;
		}
	}

	/**
	 * @return logical terminal from block 1
	 * @see SwiftBlock1#getLogicalTerminal()
	 */
	public String getLogicalTerminal() {
		if (getSwiftMessage() == null) {
			throw new IllegalStateException("SwiftMessage was not initialized");
		}
		if (m.getBlock1() != null) {
			return m.getBlock1().getLogicalTerminal();
		} else {
			return null;
		}
	}

	/**
	 * @return session number from block 1
	 * @see SwiftBlock1#getSessionNumber()
	 */
	public String getSessionNumber() {
		if (getSwiftMessage() == null) {
			throw new IllegalStateException("SwiftMessage was not initialized");
		}
		if (m.getBlock1() != null) {
			return m.getBlock1().getSessionNumber();
		} else {
			return null;
		}
	}

	/**
	 * @return sequence number from block 1
	 * @see SwiftBlock1#getSequenceNumber()
	 */
	public String getSequenceNumber() {
		if (getSwiftMessage() == null) {
			throw new IllegalStateException("SwiftMessage was not initialized");
		}
		if (m.getBlock1() != null) {
			return m.getBlock1().getSequenceNumber();
		} else {
			return null;
		}
	}
	
	/**
	 * @return message priority from block 2
	 * @see com.prowidesoftware.swift.model.SwiftBlock2#getMessagePriority()
	 */
	public String getMessagePriority() {
		if (getSwiftMessage() == null) {
			throw new IllegalStateException("SwiftMessage was not initialized");
		}
		if (m.getBlock2() != null) {
			return m.getBlock2().getMessagePriority();
		} else {
			return null;
		}
	}

	/**
	 * @return true if message is an input message sent to SWIFTNet, false otherwise
	 * @see SwiftMessage#isOutgoing()
	 */
	public boolean isInput() {
		if (getSwiftMessage() == null) {
			throw new IllegalStateException("SwiftMessage was not initialized");
		}
		return m.isInput();
	}
	
	/**
	 * @return true if the message is outgoing (sent to SWIFT), false other case; using the direction attribute.
	 * @see SwiftMessage#isOutgoing()
	 * @since 7.8.4
	 */
	public boolean isOutgoing() {
		return isInput();
	}

	/**
	 * @return true if message is an output message received from SWIFTNet, false otherwise
	 * @see SwiftMessage#isIncoming()
	 */
	public boolean isOutput() {
		if (getSwiftMessage() == null) {
			throw new IllegalStateException("SwiftMessage was not initialized");
		}
		return m.isOutput();
	}

	/**
	 * @return true if the message is incoming (received from SWIFT), false other case; using the direction attribute.
	 * @see SwiftMessage#isIncoming()
	 * @since 7.8.4
	 */
	public boolean isIncoming() {
		return isOutput();
	}

	/**
	 * Sets the logical terminal field of the header block 1 (the message is assumed to be of type input).
	 * The sender addresses will be filled with proper default LT identifier and branch codes if not provided.<br>
	 * 
	 * Notice this method only makes sense when building input messages (messages that are going to be sent to swift). 
	 * To emulate a received message from swift, the sender information must be put at block 2.
	 * 
	 * @since 6.4
	 * @see SwiftBlock1#setSender(String)
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 */
	public void setSender(String sender) {
		if (getSwiftMessage() == null) {
			this.m = new SwiftMessage(true);
		}
		getSwiftMessage().getBlock1().setSender(sender);		
	}
	
	/**
	 * Sets the logical terminal field of the header block 1 with the parameter BIC code and default LT identifier
	 * (the message is assumed to be of type input).<br>
	 * 
	 * Notice this method only makes sense when building input messages (messages that are going to be sent to swift). 
	 * To emulate a received message from swift, the sender information must be put at block 2.
	 * 
	 * @since 6.4
	 * @see SwiftBlock1#setLogicalTerminal(BIC)
	 * @param bic a BIC code
	 */
	public void setSender(BIC bic) {
		if (getSwiftMessage() == null) {
			this.m = new SwiftMessage(true);
		}
		getSwiftMessage().getBlock1().setLogicalTerminal(bic);
	}
	
	/**
	 * Gets the message sender BIC from the message headers.
	 * For outgoing messages this is the the logical terminal at block 1,
	 * and for incoming messages this is logical terminal at the MIR of block 2. 
	 *  
	 * @return the found address or null if the message or the header block are null.
	 * @since 6.4
	 */
	public String getSender() {
		if (getSwiftMessage() != null) {
			return getSwiftMessage().getSender();
		}
		return null;
	}

	/**
	 * Sets the logical terminal field of the application header block 2. 
	 * The receiver addresses will be filled with proper default LT identifier and branch codes if not provided.<br>
	 * 
	 * Notice this method only makes sense when building input messages (messages that are going to be sent to swift). 
	 * To emulate a received message from swift, a call to this method has no effect, and the receiver information 
	 * must be manually set in block 1.
	 * 
	 * @since 6.4
	 * @see SwiftBlock2Input#setReceiver(String)
	 * @param receiver the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 */
	public void setReceiver(String receiver) {
		if (getSwiftMessage() == null) {
			this.m = new SwiftMessage(true);
		}
		SwiftBlock2 b2 = getSwiftMessage().getBlock2();
		if (b2.isInput()) {
			((SwiftBlock2Input)b2).setReceiver(receiver);
		}
	}
		
	/**
	 * Sets the logical terminal field of the application header block 2.<br> 
	 * 
	 * Notice this method only makes sense when building input messages (messages that are going to be sent to swift). 
	 * To emulate a received message from swift, a call to this method has no effect, and the receiver information 
	 * must be manually set in block 1.

	 * @since 6.4
	 * @see SwiftBlock2Input#setReceiver(String)
	 * @param bic a BIC code
	 */
	public void setReceiver(BIC bic) {
		setReceiver(bic.getBic11());
	}

	/**
	 * Gets the message receiver BIC from the message headers.
	 * For outgoing messages this is the receiver address at block 2,
	 * and for incoming messages this is logical terminal at block 1.
	 * 
	 * @return the found BIC code of the sender or null if the message or the header block are null.
	 * @since 6.4
	 */
	public String getReceiver() {
		if (getSwiftMessage() != null) {
			return getSwiftMessage().getReceiver();
		}
		return null;
	}

	/**
	 * Adds the given field to the body block in the last position
	 * @param f a field to add
	 */
	public void addField(Field f) {
		if (getSwiftMessage() == null) {
			this.m = new SwiftMessage();
		}
		getSwiftMessage().getBlock4().append(f);
	}

	/**
	 * Get this message as string containing the FIN message (SWIFT MT message).
	 * 
	 * @return a string with the FIN format representation of the message
	 * @since 7.7
	 */
	@Override
	public String message() {
		IConversionService srv = new ConversionService();
		return srv.getFIN(this.m);
	}

	/**
	 * Returns this message type according to the specific class.
	 * 
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	public abstract String getMessageType();
	
	/**
	 * Convenience method to get the list of sequences named <code>name</code> from this message without creating the MTXXX class.
	 * 
	 * <code>getSequenceList("A")</code>
	 * is the same as 
	 * <code>((CastToSpecificMT)getMT()).getSequenceAList()</code>
	 * 
	 * <em>The requested sequence must be repetitive</em> for non repetitive sequences use getSequence(name) 
	 * 
	 * @since 7.6
	 * @param name the sequence alpha numeric identifier such as A1a
	 * @return found sequences or empty list
	 * @see #getSequence(String)
	 */
	@SuppressWarnings("unchecked")
	public List<SwiftTagListBlock> getSequenceList(final String name) {
		final String methodName = GETSEQUENCE+name+"List";
		Object o = invokeHere(methodName, this, null);
		return (List<SwiftTagListBlock>)o;
	}
	
	/**
	 * Get the sequence with a given name from the given subblock
	 * @param name the name of the sequence to get. Must not be null
	 * @param block the block from where to get the sequence
	 * 
	 * This method invokes the static version of {@link #getSequenceList(String)}
	 * @see #getSequenceList(String)
	 * 
	 * @return found sequences or empty list
	 * @since 7.8.1
	 */
	@SuppressWarnings("unchecked")
	public /* cant make static, but should be */ List<SwiftTagListBlock> getSequenceList(final String name, final SwiftTagListBlock block) {
		final String methodName = GETSEQUENCE+name+"List";
		return (List<SwiftTagListBlock>) invokeHere(methodName, this, block);
	}
	
	/**
	 * Test if the MT class contains a getSequenceXList method
	 * @since 7.8
	 * @see #getSequenceList(String)
	 */
	public boolean containsSequenceList(final String name) {
		try {
			return getClass().getMethod(GETSEQUENCE+name+"List") != null;
		} catch (Exception e) { 
			return false;
		}
	}
	
	/**
	 * Test if the MT class contains a getSequenceX method
	 * @since 7.8
	 * @see #getSequence(String)
	 */
	public boolean containsSequence(final String name) {
		try {
			return getClass().getMethod(GETSEQUENCE+name) != null;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * @since 7.6
	 * @param methodName a method to invoke
	 * @return result from reflection call
	 */
	private Object invokeHere(final String methodName, final Object where, final SwiftTagListBlock argument) {
		try {
			final Method method = argument==null ? 
					getClass().getMethod(methodName)
					: getClass().getMethod(methodName, SwiftTagListBlock.class) 
					;
			if (argument == null) {
				return method.invoke(where);
			} 
			return method.invoke(where, argument);
		} catch (final NoSuchMethodException e) {
			log.log(Level.FINE, "Method "+methodName+" does not exist in "+getClass(), e);
		} catch (Exception e) {
			log.log(Level.WARNING, "An error occured while invoking " + methodName + " in " + where, e);
		}
		return null;
	}

	/**
	 * Convenience method to get a sequence named <code>name</code> from this message without creating the MTXXX class.
	 * 
	 * <code>getSequence("A")</code>
	 * is the same as 
	 * <code>((CastToSpecificMT)getMT()).getSequenceA()</code>
	 *  
	 * <em>The requested sequence must NOT be repetitive</em> for repetitive sequences use getSequenceList(name)
	 * @since 7.6
	 * @param name the sequence alpha numeric identifier such as A1a
	 * @return found sequence or empty sequence block
	 * @see #getSequenceList(String)
	 */
	public SwiftTagListBlock getSequence(final String name) {
		final String methodName = GETSEQUENCE+name;
		Object o = invokeHere(methodName, this, null);
		return (SwiftTagListBlock)o;
	}
	
	/**
	 * Get the sequence with the given name from the tags in block invoking the proper static method in the mt class
	 * 
	 * @param name the name of the sequence to get
	 * @param block the block where to extract the sequence from
	 * @return found sequence or empty sequence block
	 * @since 7.8.1
	 */
	public /* cant make static, but should be */ SwiftTagListBlock getSequence(final String name, final SwiftTagListBlock block) {
		final String methodName = GETSEQUENCE+name;
		Object o = invokeHere(methodName, this, block);
		return (SwiftTagListBlock)o;
	}

	@Override
	public String toString() {
		return "AbstractMT [m=" + m + "]";
	}

	/**
	 * Sets the signature to the message
	 *
	 * @param signature the signature to set in block S
	 * @return <code>this</code>
	 * @throws IllegalStateException if the internal SwiftMessage object is null
	 * @since 7.10.4
	 */
	public AbstractMT setSignature(String signature) {

		// sanity check
		if (getSwiftMessage() == null) {
			throw new IllegalStateException("SwiftMessage was not initialized");
		}

		// set the signature
		getSwiftMessage().setSignature(signature);

		return(this);
	}

	/**
	 * Gets the signature of the message (looks for an S block then the MDG tag)
	 *
	 * @return the signature of the message (or null if none exists)
	 * @since 7.10.4
	 */
	public String getSignature() {

		return(getSwiftMessage() != null ? getSwiftMessage().getSignature() : null);
	}

	/**
	 * Create a blank message for the given category setting TEST bics as sender and receiver
	 * @param messageType the message type
	 * @return created message object
	 * @see #create(int, String, String)
	 * @since 7.6
	 */
	public static AbstractMT create( final int messageType ) {
		return create(messageType, BIC.TEST8, BIC.TEST8);
	}
	/**
	 * Create a blank message for the given category setting the given sender and receiver BICs
	 * @param messageType the message type
	 * @param sender the sender BIC11 code
	 * @param receiver the receiver BIC11 code
	 * @return created message object
	 * @since 7.6
	 */
	public static AbstractMT create( final int messageType , final String sender, final String receiver) {
		final SwiftMessage sm = new SwiftMessage(true);
		final SwiftBlock2Input b2 = new SwiftBlock2Input();
        b2.setMessageType(Integer.valueOf(messageType).toString());
        b2.setInput(true);
        // TODO revisar valores de inicializacion
        b2.setMessagePriority("N");
        b2.setDeliveryMonitoring("2");
        b2.setObsolescencePeriod("020");
        sm.setBlock2(b2);
		final AbstractMT result = sm.toMT();
		result.setSender(StringUtils.rightPad(sender, 12, 'X'));
		result.setReceiver(StringUtils.rightPad(receiver, 12, 'X'));
		return result;
	}
	
	/**
	 * Add all tags from block to the end of the block4
	 * @param block a block to append
	 * @return this same object for chained calls
	 * @since 7.6
	 */
	public AbstractMT append(final SwiftTagListBlock block) {
		Validate.notNull(block);
		if (!block.isEmpty())
			b4().addTags(block.getTags());
		return this;
	}
	/**
	 * Add all tags to the end of the block4 
	 * @param tags a list of tags to add
	 * @return this same object for chained calls
	 * @since 7.6
	 */
	public AbstractMT append(final Tag ... tags) {
		Validate.notNull(tags);
		if (tags.length>0) {
			for (final Tag t : tags) {
				b4().append(t);				
			}
		}
		return this;
	}
	/**
	 * Add all the fields to the end of the block4
	 * @param fields a list of fields to add
	 * @return this same object for chained calls
	 * @since 7.6
	 */
	public AbstractMT append(final Field ... fields) {
		Validate.notNull(fields);
		if (fields.length>0) {
			for (final Field t : fields) {
				b4().append(t);				
			}
		}
		return this;
	}
	private SwiftBlock4 b4() {
		if (this.m == null) {
			throw new IllegalStateException("SwiftMessage is null");
		} else {
			final SwiftBlock4 b4 = this.m.getBlock4();
			if (b4 == null) {
				this.m.setBlock4(new SwiftBlock4());
				return this.m.getBlock4();
			}
			return b4;
		}
	}
	
	/**
	 * Base implementation for subclasses static parse.
	 * 
	 * @since 7.7
	 */
    protected static SwiftMessage read(String fin) {
    	try {
	        return SwiftMessage.parse(fin);
        } catch (IOException e) {
            log.severe("An error occured while reading FIN :"+e.getClass().getName());
			log.log(Level.SEVERE, "Read exception");
			log.log(Level.SEVERE, "Read exception while parsing "+fin, e);
        }
    	return null;
    }
    
    /**
	 * Writes the message into a file with its message content in the FIN format.
	 * <p>The implementation ignores all empty blocks.
	 * 
	 * @param file a not null file to write, if it does not exists, it will be created
	 * @throws IOException if the file cannot be written
	 * @since 7.7
	 */
	public void write(File file) throws IOException {
		Validate.notNull(file, "the file to write cannot be null");
		Validate.notNull(this.m, "the message to write cannot be null");
		boolean created = file.createNewFile();
		if (created) {
			log.fine("new file created: "+file.getAbsolutePath());
		}
		FileWriter fw = new FileWriter(file.getAbsoluteFile());
		SwiftWriter.writeMessage(this.m, fw, true);
		fw.close();
	}
	
	/**
	 * Writes the message into a given output stream with its message content in the FIN format, 
	 * encoding content in UTF-8.
	 * 
	 * @param stream a non null stream to write
	 * @throws IOException if the stream cannot be written
	 * @since 7.7
	 */
	public void write(OutputStream stream) throws IOException {
		Validate.notNull(stream, "the stream to write cannot be null");
		Validate.notNull(this.m, "the message to write cannot be null");
		stream.write(message().getBytes("UTF-8"));
	}
	
	/**
	 * Returns the JSON representation of the SwiftMessage attribute
	 * @deprecated use {@link #toJson()} instead
	 * @see #toJson()
	 */
    @Deprecated
    @ProwideDeprecated(phase3 = TargetYear.SRU2020)
	public String json() {
		DeprecationUtils.phase2(getClass(), "json()", "use toJson() instead");
		Validate.notNull(this.m, "the message cannot be null");
		return this.m.toJson();
	}
	
	/**
	 * Returns the message content in XML format.<br>
	 * The XML created is the internal format defined and used by Prowide Core.<br>
	 * Notice: it is neither a standard nor the MX version of this MT.
	 * 
	 * @since 7.7
	 */
	public String xml() {
		Validate.notNull(this.m, "the message cannot be null");
		return this.m.toXml();
	}
	
	/**
	 * Returns true if the message is the same type as the indicated by parameter.
	 * 
	 * @param type a three digits number indicating a SWIFT MT type
	 * @return true if the message is the same type, false if not or if the message type cannot be determined.
	 * @since 7.7
	 */
	public boolean isType(final Integer type) {
		return this.m.getTypeInt() == type;
	}

	/**
	 * Get the given sequence from the msg
	 * 
	 * @param msg the message to extract the sequence from
	 * @param sequence the sequence name
	 * @return the given sequence or null if msg is null, sequence is null or the message can not be converted to MT 
	 * @since 7.7
	 * @see SwiftMessage#toMT()
	 * @deprecated use <code>msg.toMT().getSequence(sequence)</code> instead of this method
	 */
	public static SwiftTagListBlock getSequence(final SwiftMessage msg, final String sequence) {
		if (msg != null && sequence != null) {
			final AbstractMT amt = msg.toMT();
			if (amt != null) {
				return amt.getSequence(sequence);
			}
		}
		return null;
	}
	
	/**
	 * @return the corresponding MT variant or null if flag field is not present
	 * @since 7.8
	 */
	public MTVariant getVariant() {
		return this.m.getVariant();
	}
 
	public String nameFromClass() {
		return StringUtils.substringAfter(getClass().getName(), ".MT");
	}
	
	/**
	 * Returns the MT message identification.<br>
	 * Composed by the business process, message type and variant.
	 * Example: fin.103.STP
	 *
	 * @return the constructed message id
	 * @since 7.8.4
	 */
	public MtId getMtId() {
		return new MtId(getMessageType(), getVariant());
	}
	
	/**
	 * Returns a tag or null if tag not found
	 * @param tagName tag name to find including letter option, example "33B"
	 * @return found tag or null
	 * @since 7.8.9
	 */
	protected Tag tag(final String tagName) {
		final SwiftMessage _m = getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		}
		return _m.getBlock4().getTagByName(tagName);
	}

	/**
	 * Returns an array of tags or null if non is found
	 * @param tagName tag name to find including letter option, example "33B"
	 * @return found tags or null
	 * @since 7.8.9
	 */
	protected Tag[] tags(final String tagName) {
		final SwiftMessage _m = getSwiftMessageNotNullOrException();
		if (_m.getBlock4() == null) {
			log.info("block4 is null");
			return null;
		} else {
			return _m.getBlock4().getTagsByName(tagName);
		}
	}

	/**
	 * Get a json representation of this message with expanded fields content.
	 * @since 7.10.3
	 */
	@Override
	public String toJson() {
		final Gson gson = new GsonBuilder()
			.registerTypeAdapter(AbstractMT.class, new AbstractMTAdapter())
			.setPrettyPrinting()
			.create();
		return gson.toJson(this,AbstractMT.class);
	}

	/**
	 * This method deserializes the JSON data into a specific MT object.
	 * @param json a JSON representation of an MT message
	 * @return a specific deserialized MT message object, for example MT103
	 * @since 7.10.3
	 */
	public static AbstractMT fromJson(String json) {
		final Gson gson = new GsonBuilder()
				.registerTypeAdapter(AbstractMT.class, new AbstractMTAdapter())
				.registerTypeAdapter(SwiftBlock2.class, new SwiftBlock2Adapter())
				.create();
		return gson.fromJson(json, AbstractMT.class);
	}

	/**
	 * Gets the block 4 complete ordered list of fields
	 * @return return a list of Tag as a FieldNN instance or empty list if non is found
	 * @since 7.10.3
	 */
	public List<Field> getFields() {
		List<Field> fields = new ArrayList<>();
		for (Tag tag : this.m.getBlock4().getTags()){
			fields.add(tag.asField());
		}
		return fields;
	}

}