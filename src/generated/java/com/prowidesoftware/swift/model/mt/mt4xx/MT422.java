/*
 * Copyright 2006-2024 Prowide
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
package com.prowidesoftware.swift.model.mt.mt4xx;



import com.prowidesoftware.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.internal.*;
import com.prowidesoftware.swift.internal.SequenceStyle.Type;
import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import com.prowidesoftware.swift.utils.Lib;
import java.io.File;
import java.io.InputStream;
import java.io.IOException;

/**
 * MT 422 - Advice of Fate and Request for Instructions.
 *
 * <p>
 * SWIFT MT422 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="sequence">
Sequence Loop1 (M) (repetitive)<ul><li class="field">Field 20  (M)</li>
<li class="field">Field 21  (M)</li>
<li class="field">Field 32 A,B,K (O)</li>
</ul></li>
<li class="field">Field 72  (O)</li>
<li class="field">Field 75  (O)</li>
<li class="field">Field 76  (O)</li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2024</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT422 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;
	private static final long serialVersionUID = 1L;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT422.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "422";

	/**
	 * Creates an MT422 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT422 content
	 */
	public MT422(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT422 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT422 content, the parameter can not be null
	 * @see #MT422(String)
	 */
	public MT422(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT422 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT422 content
	 * @return the created object or null if the parameter is null
	 * @see #MT422(String)
	 * @since 7.7
	 */
	public static MT422 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT422(m);
	}
	
	/**
	 * Creates and initializes a new MT422 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT422() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT422 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT422(final String sender, final String receiver) {
		super(422, sender, receiver);
	}
	
	/**
	 * Creates a new MT422 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT422(final String fin) {
		super();
		if (fin != null) {
			final SwiftMessage parsed = read(fin);
			if (parsed != null) {
				super.m = parsed;
				sanityCheck(parsed);
			}
		}
    }
    
    private void sanityCheck(final SwiftMessage param) {
    	if (param.isServiceMessage()) {
			log.warning("Creating an MT422 object from FIN content with a Service Message. Check if the MT422 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), "422")) {
			log.warning("Creating an MT422 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT422 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT422 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT422 or null if fin is null 
	 * @since 7.7
	 */
	public static MT422 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT422(fin);
    }
    
    /**
	 * Creates a new MT422 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT422(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT422 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT422 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT422 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT422(stream);
    }
    
    /**
	 * Creates a new MT422 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT422(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT422 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT422 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT422 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT422(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "422";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT422 append(final SwiftTagListBlock block) {
		super.append(block);
		return this;
	}
	
	/**
	 * Add all tags to the end of the block4.
	 *
	 * @param tags to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT422 append(final Tag... tags) {
		super.append(tags);
		return this;
	}
	
	/**
	 * Add all the fields to the end of the block4.
	 *
	 * @param fields to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT422 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT422 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT422 message
	* @return a new instance of MT422
	* @since 7.10.3
	*/
	public static MT422 fromJson(final String json) {
		return (MT422) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 72, 
	 * or null if none is found.
	 * The first occurrence of field 72 at MT422 is expected to be the only one.
	 * 
	 * @return a Field72 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field72 getField72() {
		final Tag t = tag("72");
		if (t != null) {
			return new Field72(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 75, 
	 * or null if none is found.
	 * The first occurrence of field 75 at MT422 is expected to be the only one.
	 * 
	 * @return a Field75 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field75 getField75() {
		final Tag t = tag("75");
		if (t != null) {
			return new Field75(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 76, 
	 * or null if none is found.
	 * The first occurrence of field 76 at MT422 is expected to be the only one.
	 * 
	 * @return a Field76 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field76 getField76() {
		final Tag t = tag("76");
		if (t != null) {
			return new Field76(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 20, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 20 at MT422 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field20 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field20> getField20() {
		final List<Field20> result = new ArrayList<>();
		final Tag[] tags = tags("20");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field20(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 21, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 21 at MT422 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field21 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field21> getField21() {
		final List<Field21> result = new ArrayList<>();
		final Tag[] tags = tags("21");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field21(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 32A at MT422 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32A> getField32A() {
		final List<Field32A> result = new ArrayList<>();
		final Tag[] tags = tags("32A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field32A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 32B at MT422 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32B> getField32B() {
		final List<Field32B> result = new ArrayList<>();
		final Tag[] tags = tags("32B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field32B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32K, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 32K at MT422 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field32K objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field32K> getField32K() {
		final List<Field32K> result = new ArrayList<>();
		final Tag[] tags = tags("32K");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field32K(tag.getValue()));
            }
		}
		return result;
	}
	

	/**
	 * Class to model Sequence "Loop1" in MT 422.
	 */
	public static class Loop1 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private Loop1() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private Loop1(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * First mandatory tag name of the sequence: <em>"20"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "20"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"21"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "21"   };

		/**
		 * List of optional tags after the last mandatory tag.
		 */
		protected static final String[] TAIL = new String[]{ "32A", "32B", "32K"   };

		/**
		 * Same as {@link #newInstance(int, int, Tag...)} using zero for the indexes.
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static Loop1 newInstance(final Tag... tags) {
			return newInstance(0, 0, tags);
		}

		/**
		 * Creates a sequence with starting and ending tags set to the indicated tags in from the
		 * {@link #START} and {@link #END} lists of mandatory fields, and with the content between
		 * the starting and ending tag initialized with the given optional tags.
		 *
		 * @param start a zero-based index within the list of mandatory starting tags in the sequence
		 * @param end a zero-based index within the list of mandatory ending tags in the sequence
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static Loop1 newInstance(final int start, final int end, final Tag... tags) {
			final Loop1 result = new Loop1();
			result.append(new Tag(START[start], ""));
			if (tags != null && tags.length > 0) {
				for (final Tag t : tags) {
					result.append(t);
				}
			}
			result.append(new Tag(END[end], ""));
			return result;
		}
	}
	/**
	 * Get the list of Loop1 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @return the found sequences or an empty list if none is found
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<Loop1> getLoop1List() {
		return getLoop1List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the list of Loop1 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find Loop1 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<Loop1> getLoop1List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocksDelimitedWithOptionalTail(Loop1.START, Loop1.END, Loop1.TAIL);
            if (blocks != null && !blocks.isEmpty()) {
                final List<Loop1> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    result.add(new Loop1(b));
                }
                return result;
            }
        }
        return Collections.emptyList();
	}
 



}
