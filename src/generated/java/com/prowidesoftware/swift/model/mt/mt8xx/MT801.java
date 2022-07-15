/*
 * Copyright 2006-2021 Prowide
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
package com.prowidesoftware.swift.model.mt.mt8xx;



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
 * MT 801 - T/C Multiple Sales Advice.
 *
 * <p>
 * SWIFT MT801 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="field">Field 20  (M)</li>
<li class="field">Field 28  (M)</li>
<li class="sequence">
Sequence Loop1 (M) (repetitive)<ul><li class="field">Field 51 A,C (M)</li>
<li class="sequence">
Sequence Loop2 (M) (repetitive)<ul><li class="field">Field 23  (M)</li>
<li class="field">Field 30  (O)</li>
<li class="field">Field 26 A (M) (repetitive)</li>
<li class="field">Field 33 B (M)</li>
<li class="field">Field 73  (O)</li>
</ul></li>
<li class="field">Field 34 B (M)</li>
<li class="field">Field 16 A (M)</li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2021</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT801 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;
	private static final long serialVersionUID = 1L;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT801.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "801";

	/**
	 * Creates an MT801 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT801 content
	 */
	public MT801(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT801 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT801 content, the parameter can not be null
	 * @see #MT801(String)
	 */
	public MT801(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT801 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT801 content
	 * @return the created object or null if the parameter is null
	 * @see #MT801(String)
	 * @since 7.7
	 */
	public static MT801 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT801(m);
	}
	
	/**
	 * Creates and initializes a new MT801 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT801() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT801 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT801(final String sender, final String receiver) {
		super(801, sender, receiver);
	}
	
	/**
	 * Creates a new MT801 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT801(final String fin) {
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
			log.warning("Creating an MT801 object from FIN content with a Service Message. Check if the MT801 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), "801")) {
			log.warning("Creating an MT801 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT801 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT801 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT801 or null if fin is null 
	 * @since 7.7
	 */
	public static MT801 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT801(fin);
    }
    
    /**
	 * Creates a new MT801 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT801(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT801 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT801 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT801 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT801(stream);
    }
    
    /**
	 * Creates a new MT801 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT801(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT801 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT801 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT801 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT801(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "801";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT801 append(final SwiftTagListBlock block) {
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
	public MT801 append(final Tag... tags) {
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
	public MT801 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT801 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT801 message
	* @return a new instance of MT801
	* @since 7.10.3
	*/
	public static MT801 fromJson(final String json) {
		return (MT801) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or null if none is found.
	 * The first occurrence of field 20 at MT801 is expected to be the only one.
	 * 
	 * @return a Field20 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field20 getField20() {
		final Tag t = tag("20");
		if (t != null) {
			return new Field20(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 28, 
	 * or null if none is found.
	 * The first occurrence of field 28 at MT801 is expected to be the only one.
	 * 
	 * @return a Field28 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field28 getField28() {
		final Tag t = tag("28");
		if (t != null) {
			return new Field28(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 51A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 51A at MT801 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field51A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field51A> getField51A() {
		final List<Field51A> result = new ArrayList<>();
		final Tag[] tags = tags("51A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field51A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 51C, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 51C at MT801 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field51C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field51C> getField51C() {
		final List<Field51C> result = new ArrayList<>();
		final Tag[] tags = tags("51C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field51C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 23, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 23 at MT801 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field23 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field23> getField23() {
		final List<Field23> result = new ArrayList<>();
		final Tag[] tags = tags("23");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field23(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 30, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 30 at MT801 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field30 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field30> getField30() {
		final List<Field30> result = new ArrayList<>();
		final Tag[] tags = tags("30");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field30(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 26A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 26A at MT801 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field26A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field26A> getField26A() {
		final List<Field26A> result = new ArrayList<>();
		final Tag[] tags = tags("26A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field26A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 33B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 33B at MT801 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field33B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field33B> getField33B() {
		final List<Field33B> result = new ArrayList<>();
		final Tag[] tags = tags("33B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field33B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 73, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 73 at MT801 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field73 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field73> getField73() {
		final List<Field73> result = new ArrayList<>();
		final Tag[] tags = tags("73");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field73(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 34B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 34B at MT801 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field34B objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field34B> getField34B() {
		final List<Field34B> result = new ArrayList<>();
		final Tag[] tags = tags("34B");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field34B(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 16A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 16A at MT801 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field16A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field16A> getField16A() {
		final List<Field16A> result = new ArrayList<>();
		final Tag[] tags = tags("16A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field16A(tag.getValue()));
            }
		}
		return result;
	}
	

	/**
	 * Class to model Sequence "Loop1" in MT 801.
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
		 * First mandatory tag name of the sequence: <em>"51A", "51C"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "51A", "51C"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"16A"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "16A"   };

		/**
		 * List of optional tags after the last mandatory tag.
		 */
		protected static final String[] TAIL = new String[]{  };

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
 

	/**
	 * Class to model Sequence "Loop2" in MT 801.
	 */
	public static class Loop2 extends SwiftTagListBlock {
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructs an empty sequence.
		 */
	    private Loop2() {
			super(new ArrayList<>());
		}

		/**
		 * Creates a sequence with the given content.
		 * @see SwiftTagListBlock
		 */
		private Loop2(final SwiftTagListBlock content) {
			super(content.getTags());
		}

		/**
		 * First mandatory tag name of the sequence: <em>"23"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "23"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"33B"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "33B"   };

		/**
		 * List of optional tags after the last mandatory tag.
		 */
		protected static final String[] TAIL = new String[]{ "73"   };

		/**
		 * Same as {@link #newInstance(int, int, Tag...)} using zero for the indexes.
		 * @param tags the list of tags to set as sequence content
		 * @return a new instance of the sequence, initialized with the parameter tags
		 */
		@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
		public static Loop2 newInstance(final Tag... tags) {
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
		public static Loop2 newInstance(final int start, final int end, final Tag... tags) {
			final Loop2 result = new Loop2();
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
	 * Get the list of Loop2 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @return the found sequences or an empty list if none is found
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public List<Loop2> getLoop2List() {
		return getLoop2List(super.getSwiftMessageNotNullOrException().getBlock4());
	}
	
	/**
	 * Get the list of Loop2 delimited by leading tag and end, with an optional tail.
	 * The presence of this method indicates that this sequence can occur more than once according to the Standard.
	 * If message is empty or no sequences are found <em>an empty list</em> is returned.
	 *
	 * @see SwiftTagListBlock#getSubBlocksDelimitedWithOptionalTail(String[], String[], String[])
	 * @param parentSequence a not null parent sequence to find Loop2 within it
	 * @return the found sequences or an empty list if none is found or parent sequence is null
	 * @since 7.7
	 */
	@SequenceStyle(Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL)
	public static List<Loop2> getLoop2List(final SwiftTagListBlock parentSequence) {
	    if (parentSequence != null) {
            final List<SwiftTagListBlock> blocks = parentSequence.getSubBlocksDelimitedWithOptionalTail(Loop2.START, Loop2.END, Loop2.TAIL);
            if (blocks != null && !blocks.isEmpty()) {
                final List<Loop2> result = new ArrayList<>(blocks.size());
                for (final SwiftTagListBlock b : blocks) {
                    result.add(new Loop2(b));
                }
                return result;
            }
        }
        return Collections.emptyList();
	}
 



}
