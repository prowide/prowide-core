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
package com.prowidesoftware.swift.model.mt.mt2xx;



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
 * MT 210 - Notice to Receive.
 *
 * <p>
 * SWIFT MT210 (ISO 15022) message structure:
 *
 <div class="scheme"><ul>
<li class="field">Field 20  (M)</li>
<li class="field">Field 25  (O)</li>
<li class="field">Field 30  (M)</li>
<li class="sequence">
Sequence Loop1 (M) (repetitive)<ul><li class="field">Field 21  (M)</li>
<li class="field">Field 32 B (M)</li>
<li class="field">Field 50 C,F,NONE (O)</li>
<li class="field">Field 52 A,D (O)</li>
<li class="field">Field 56 A,D (O)</li>
</ul></li>
</ul></div>

 *
 * <p>
 * This source code is specific to release <strong>SRU 2024</strong>
 * <p>
 * For additional resources check <a href="https://www.prowidesoftware.com/resources">https://www.prowidesoftware.com/resources</a>
 */
@Generated
public class MT210 extends AbstractMT implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;
	private static final long serialVersionUID = 1L;
	private static final java.util.logging.Logger log = java.util.logging.Logger.getLogger(MT210.class.getName());
	
	/**
	 * Constant for MT name, this is part of the classname, after MT.
	 */
	public static final String NAME = "210";

	/**
	 * Creates an MT210 initialized with the parameter SwiftMessage.
	 * @param m swift message with the MT210 content
	 */
	public MT210(final SwiftMessage m) {
		super(m);
		sanityCheck(m);
	}

	/**
	 * Creates an MT210 initialized with the parameter MtSwiftMessage.
	 * @param m swift message with the MT210 content, the parameter can not be null
	 * @see #MT210(String)
	 */
	public MT210(final MtSwiftMessage m) {
		this(m.message());
	}
	
	/**
	 * Creates an MT210 initialized with the parameter MtSwiftMessage.
	 *
	 * @param m swift message with the MT210 content
	 * @return the created object or null if the parameter is null
	 * @see #MT210(String)
	 * @since 7.7
	 */
	public static MT210 parse(final MtSwiftMessage m) {
		if (m == null) {
			return null;
		}
		return new MT210(m);
	}
	
	/**
	 * Creates and initializes a new MT210 input message setting TEST BICS as sender and receiver.
	 * All mandatory header attributes are completed with default values.
	 *
	 * @since 7.6
	 */
	public MT210() {
		this(BIC.TEST8, BIC.TEST8);
	}
	
	/**
	 * Creates and initializes a new MT210 input message from sender to receiver.
	 * All mandatory header attributes are completed with default values. 
	 * In particular the sender and receiver addresses will be filled with proper default LT identifier 
	 * and branch codes if not provided,
	 * 
	 * @param sender the sender address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @param receiver the receiver address as a bic8, bic11 or full logical terminal consisting of 12 characters
	 * @since 7.7
	 */
	public MT210(final String sender, final String receiver) {
		super(210, sender, receiver);
	}
	
	/**
	 * Creates a new MT210 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter is null or the message cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed.
	 *
	 * @param fin a string with the MT message in its FIN swift format
	 * @since 7.7
	 */
	public MT210(final String fin) {
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
			log.warning("Creating an MT210 object from FIN content with a Service Message. Check if the MT210 you are intended to read is prepended with and ACK.");
		} else if (!StringUtils.equals(param.getType(), "210")) {
			log.warning("Creating an MT210 object from FIN content with message type "+param.getType());
		}
    }
	
	/**
	 * Creates a new MT210 by parsing a String with the message content in its swift FIN format.
	 * If the fin parameter cannot be parsed, the returned MT210 will have its internal message object
	 * initialized (blocks will be created) but empty.
	 * If the string contains multiple messages, only the first one will be parsed. 
	 *
	 * @param fin a string with the MT message in its FIN swift format. <em>fin may be null in which case this method returns null</em>
	 * @return a new instance of MT210 or null if fin is null 
	 * @since 7.7
	 */
	public static MT210 parse(final String fin) {
		if (fin == null) {
			return null;
		}
		return new MT210(fin);
    }
    
    /**
	 * Creates a new MT210 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the message content is null or cannot be parsed, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public MT210(final InputStream stream) throws IOException {
		this(Lib.readStream(stream));
    }
    
    /**
	 * Creates a new MT210 by parsing a input stream with the message content in its swift FIN format, using "UTF-8" as encoding.
	 * If the stream contains multiple messages, only the first one will be parsed.
	 *
	 * @param stream an input stream in UTF-8 encoding with the MT message in its FIN swift format.
	 * @return a new instance of MT210 or null if stream is null or the message cannot be parsed 
	 * @throws IOException if the stream data cannot be read
	 * @since 7.7
	 */
	public static MT210 parse(final InputStream stream) throws IOException {
		if (stream == null) {
			return null;
		}
		return new MT210(stream);
    }
    
    /**
	 * Creates a new MT210 by parsing a file with the message content in its swift FIN format.
	 * If the file content is null or cannot be parsed as a message, the internal message object
	 * will be initialized (blocks will be created) but empty.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public MT210(final File file) throws IOException {
		this(Lib.readFile(file));
    }
    
    /**
	 * Creates a new MT210 by parsing a file with the message content in its swift FIN format.
	 * If the file contains multiple messages, only the first one will be parsed.
	 *
	 * @param file a file with the MT message in its FIN swift format.
	 * @return a new instance of MT210 or null if; file is null, does not exist, can't be read, is not a file or the message cannot be parsed
	 * @throws IOException if the file content cannot be read
	 * @since 7.7
	 */
	public static MT210 parse(final File file) throws IOException {
		if (file == null) {
			return null;
		}
		return new MT210(file);
    }
    
	/**
	 * Returns this MT number.
	 * @return the message type number of this MT
	 * @since 6.4
	 */
	@Override
	public String getMessageType() {
		return "210";
	}

	/**
	 * Add all tags from block to the end of the block4.
	 *
	 * @param block to append
	 * @return this object to allow method chaining
	 * @since 7.6
	 */
	@Override
	public MT210 append(final SwiftTagListBlock block) {
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
	public MT210 append(final Tag... tags) {
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
	public MT210 append(final Field... fields) {
		super.append(fields);
		return this;
	}

   /**
	* Creates an MT210 messages from its JSON representation.
	* <p>
	* For generic conversion of JSON into the corresponding MT instance
	* see {@link AbstractMT#fromJson(String)}
	*
	* @param json a JSON representation of an MT210 message
	* @return a new instance of MT210
	* @since 7.10.3
	*/
	public static MT210 fromJson(final String json) {
		return (MT210) AbstractMT.fromJson(json);
	}

	/**
	 * Iterates through block4 fields and return the first one whose name matches 20, 
	 * or null if none is found.
	 * The first occurrence of field 20 at MT210 is expected to be the only one.
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
	 * Iterates through block4 fields and return the first one whose name matches 25, 
	 * or null if none is found.
	 * The first occurrence of field 25 at MT210 is expected to be the only one.
	 * 
	 * @return a Field25 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field25 getField25() {
		final Tag t = tag("25");
		if (t != null) {
			return new Field25(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return the first one whose name matches 30, 
	 * or null if none is found.
	 * The first occurrence of field 30 at MT210 is expected to be the only one.
	 * 
	 * @return a Field30 object or null if the field is not found
	 * @see SwiftTagListBlock#getTagByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public Field30 getField30() {
		final Tag t = tag("30");
		if (t != null) {
			return new Field30(t.getValue());
		} else {
			return null;
		}
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 21, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 21 at MT210 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 32B, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 32B at MT210 are expected at one sequence or across several sequences.
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
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 50C, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 50C at MT210 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field50C objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field50C> getField50C() {
		final List<Field50C> result = new ArrayList<>();
		final Tag[] tags = tags("50C");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field50C(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 50F, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 50F at MT210 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field50F objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field50F> getField50F() {
		final List<Field50F> result = new ArrayList<>();
		final Tag[] tags = tags("50F");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field50F(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 50, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 50 at MT210 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field50 objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field50> getField50() {
		final List<Field50> result = new ArrayList<>();
		final Tag[] tags = tags("50");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field50(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 52A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 52A at MT210 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field52A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field52A> getField52A() {
		final List<Field52A> result = new ArrayList<>();
		final Tag[] tags = tags("52A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field52A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 52D, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 52D at MT210 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field52D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field52D> getField52D() {
		final List<Field52D> result = new ArrayList<>();
		final Tag[] tags = tags("52D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field52D(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 56A, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 56A at MT210 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field56A objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field56A> getField56A() {
		final List<Field56A> result = new ArrayList<>();
		final Tag[] tags = tags("56A");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field56A(tag.getValue()));
            }
		}
		return result;
	}
	
	/**
	 * Iterates through block4 fields and return all occurrences of fields whose names matches 56D, 
	 * or <code>Collections.emptyList()</code> if none is found.
	 * Multiple occurrences of field 56D at MT210 are expected at one sequence or across several sequences.
	 * 
	 * @return a List of Field56D objects or <code>Collections.emptyList()</code> if none is not found
	 * @see SwiftTagListBlock#getTagsByName(String)
	 * @throws IllegalStateException if SwiftMessage object is not initialized
	 */
	public List<Field56D> getField56D() {
		final List<Field56D> result = new ArrayList<>();
		final Tag[] tags = tags("56D");
		if (tags != null && tags.length > 0) {
            for (Tag tag : tags) {
                result.add(new Field56D(tag.getValue()));
            }
		}
		return result;
	}
	

	/**
	 * Class to model Sequence "Loop1" in MT 210.
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
		 * First mandatory tag name of the sequence: <em>"21"  </em>.
		 * Array format is for cases when more than one letter options is allowed
		 */
		public static final String[] START = { "21"   } ;

		/**
		 * Last mandatory tag name of the sequence: <em>"32B"  </em>
		 * Array format is for cases when more than one letter options is allowed
		 */
		protected static final String[] END = { "32B"   };

		/**
		 * List of optional tags after the last mandatory tag.
		 */
		protected static final String[] TAIL = new String[]{ "50C", "50F", "50", "52A", "52D", "56A", "56D"   };

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
     * @deprecated use {@link #getLoop1List()} instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2025)
    public List<SequenceA> getSequenceAList() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getSequenceAList", "Use getLoop1List() instead");
		return getSequenceAList(super.getSwiftMessageNotNullOrException().getBlock4());
	}

	/**
	 * @deprecated use {@link #getLoop1List(SwiftTagListBlock)} instead
	 */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2025)
	public static List<SequenceA> getSequenceAList(final SwiftTagListBlock parentSequence) {
	    com.prowidesoftware.deprecation.DeprecationUtils.phase3(MT210.class, "getSequenceAList", "Use getLoop1List(SwiftTagListBlock) instead");
		List<SequenceA> result = new ArrayList<>();
        getLoop1List(parentSequence).forEach(s -> result.add(new SequenceA(s)));
        return result;
	}

	/**
	 * @deprecated use Loop1 instead
	 */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2025)
	public static class SequenceA extends SwiftTagListBlock {
	    private SequenceA(final Loop1 content) {
            super(content.getTags());
	        com.prowidesoftware.deprecation.DeprecationUtils.phase3(MT210.class, "SequenceA(Loop1)", "Use Loop1() instead");
        }
    }
}
