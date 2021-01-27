/*
 * Copyright 2006-2020 Prowide
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
package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.Generated;

import java.io.Serializable;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.prowidesoftware.swift.model.field.MultiLineField;


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 76</strong>
 * <p>
 * Model and parser for field 76 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>35x[$35x]0-5</code></li>
 * 		<li>parser pattern: <code>S</code></li>
 * 		<li>components pattern: <code>S</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2020</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field76 extends StructuredNarrativeField implements Serializable, NarrativeContainer, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2020;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 76
	 */
    public static final String NAME = "76";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_76 = "76";

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field76() {
        super();
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field76(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field76(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "76")) {
			throw new IllegalArgumentException("cannot create field 76 from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Creates a new field from a Narrative instance.
	 * @see Narrative#builder
	 * @param narrative a not-null narrative to use as field value
	 * @since 8.1.0
	 */
	public Field76(final Narrative narrative) {
		this(narrative.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field76 newInstance(Field76 source) {
		Field76 cp = new Field76();
		cp.setComponents(new ArrayList<>(source.getComponents()));
		return cp;
	}

	/**
	 * Create a Tag with this field name and the given value.
	 * Shorthand for <code>new Tag(NAME, value)</code>
	 * @see #NAME
	 * @since 7.5
	 */
	public static Tag tag(final String value) {
		return new Tag(NAME, value);
	}

	/**
	 * Create a Tag with this field name and an empty string as value
	 * Shorthand for <code>new Tag(NAME, "")</code>
	 * @see #NAME
	 * @since 7.5
	 */
	public static Tag emptyTag() {
		return new Tag(NAME, "");
	}

	/**
	 * Returns the field validator pattern
	 */
	@Override
	public final String validatorPattern() {
		return "35x[$35x]0-5";
	}


	/**
	 * Set the component1 (Narrative).
	 * @param component1 the component1 to set
	 */
	public Field76 setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Narrative (component1).
	 * @param component1 the Narrative to set
	 */
	public Field76 setNarrative(String component1) {
		setComponent(1, component1);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field76.NAME
	 */
	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * Gets the first occurrence form the tag list or null if not found.
	 * @return null if not found o block is null or empty
	 * @param block may be null or empty 
	 */
	public static Field76 get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field76(t) ;
	}
	
	/**
	 * Gets the first instance of Field76 in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field76 get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field76 in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field76> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field76 from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field76> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field76> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field76(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}
	
	/**
	 * Returns a specific line from the field's value.<br>
	 *
	 * @see MultiLineField#getLine(int)
	 * @param line a reference to a specific line in the field, first line being 1
	 * @return line content or null if not present or if line number is above the expected
	 * @since 7.7
	 */
	public String getLine(int line) {
		return getLine(line, 0);
	}
	
	/**
	 * Returns a specific line from the field's value.<br>
	 * 
	 * @see MultiLineField#getLine(int, int)
	 * @param line a reference to a specific line in the field, first line being 1
	 * @param offset an optional component number used as offset when counting lines
	 * @return line content or null if not present or if line number is above the expected
	 * @since 7.7
	 */
	public String getLine(int line, int offset) {
		Field76 cp = newInstance(this);
		return getLine(cp, line, null, offset);
	}
	
	/**
	 * Returns the field value split into lines.<br>
	 *
	 * @see MultiLineField#getLines()
	 * @return lines content or empty list if field's value is empty
	 * @since 7.7
	 */
	public List<String> getLines() {
		return SwiftParseUtils.getLines(getValue());
	}

	/**
	 * Returns the field value starting at the offset component, split into lines.<br>
	 *
	 * @see MultiLineField#getLines(int)
	 * @param offset an optional component number used as offset when counting lines
	 * @return found lines or empty list if lines are not present or the offset is invalid
	 * @since 7.7
	 */
	public List<String> getLines(int offset) {
		Field76 cp = newInstance(this);
		return SwiftParseUtils.getLines(getLine(cp, null, null, offset));
	}
	
	/**
	 * Returns a specific subset of lines from the field's value, given a range.<br>
	 *
	 * @see MultiLineField#getLinesBetween(int, int )
	 * @param start a reference to a specific line in the field, first line being 1
	 * @param end a reference to a specific line in the field, must be greater than start
	 * @return found lines or empty list if value is empty
	 * @since 7.7
	 */
	public List<String> getLinesBetween(int start, int end) {
		return getLinesBetween(start, end, 0);
	}

	/**
	 * Returns a specific subset of lines from the field's value, starting at the offset component.<br>
	 *
	 * @see MultiLineField#getLinesBetween(int start, int end, int offset)
	 * @param start a reference to a specific line in the field, first line being 1
	 * @param end a reference to a specific line in the field, must be greater than start
	 * @param offset an optional component number used as offset when counting lines
	 * @return found lines or empty list if lines are not present or the offset is invalid
	 * @since 7.7
	 */
	public List<String> getLinesBetween(int start, int end, int offset) {
		Field76 cp = newInstance(this);
		return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
	}

	/**
	 * This method deserializes the JSON data into a Field76 object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field76 fromJson(final String json) {
		Field76 field = new Field76();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
        NarrativeContainerJsonUtils.fromJson(jsonObject, json, field);
		return field;
	}
	
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
	public static final Integer NARRATIVE = 1;

	/**
     * @deprecated use getValue() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public String getNarrative() {
        return getValue();
    }

    // changed component 1

	/**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public String getNarrativeLine1() {
		return getLine(1);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public Field76 setNarrativeLine1(String component) {
        return this;
    }

    // deprecated component 2

	/**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
	public String getComponent2() {
        return getLine(2);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public Field76 setComponent2(String component) {
        return this;
    }

    /**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public String getNarrativeLine2() {
		return getLine(2);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public Field76 setNarrativeLine2(String component) {
        return this;
    }

    // deprecated component 3

	/**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
	public String getComponent3() {
        return getLine(3);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public Field76 setComponent3(String component) {
        return this;
    }

    /**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public String getNarrativeLine3() {
		return getLine(3);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public Field76 setNarrativeLine3(String component) {
        return this;
    }

    // deprecated component 4

	/**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
	public String getComponent4() {
        return getLine(4);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public Field76 setComponent4(String component) {
        return this;
    }

    /**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public String getNarrativeLine4() {
		return getLine(4);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public Field76 setNarrativeLine4(String component) {
        return this;
    }

    // deprecated component 5

	/**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
	public String getComponent5() {
        return getLine(5);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public Field76 setComponent5(String component) {
        return this;
    }

    /**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public String getNarrativeLine5() {
		return getLine(5);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public Field76 setNarrativeLine5(String component) {
        return this;
    }

    // deprecated component 6

	/**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
	public String getComponent6() {
        return getLine(6);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public Field76 setComponent6(String component) {
        return this;
    }

    /**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public String getNarrativeLine6() {
		return getLine(6);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2021)
    public Field76 setNarrativeLine6(String component) {
        return this;
    }
}
