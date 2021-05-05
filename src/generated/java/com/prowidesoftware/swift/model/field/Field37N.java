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
 * <strong>SWIFT MT Field 37N</strong>
 * <p>
 * Model and parser for field 37N of a SWIFT MT message.
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
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field37N extends StructuredNarrativeField implements Serializable, NarrativeContainer, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 37N
	 */
    public static final String NAME = "37N";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_37N = "37N";

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field37N() {
        super();
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field37N(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field37N(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "37N")) {
			throw new IllegalArgumentException("cannot create field 37N from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Creates a new field from a Narrative instance.
	 * @see Narrative#builder
	 * @param narrative a not-null narrative to use as field value
	 * @since 8.1.0
	 */
	public Field37N(final Narrative narrative) {
		this(narrative.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field37N newInstance(Field37N source) {
		Field37N cp = new Field37N();
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
	public Field37N setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Narrative (component1).
	 * @param component1 the Narrative to set
	 */
	public Field37N setNarrative(String component1) {
		setComponent(1, component1);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field37N.NAME
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
	public static Field37N get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field37N(t) ;
	}
	
	/**
	 * Gets the first instance of Field37N in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field37N get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field37N in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field37N> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field37N from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field37N> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field37N> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field37N(f));
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
		Field37N cp = newInstance(this);
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
		Field37N cp = newInstance(this);
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
		Field37N cp = newInstance(this);
		return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
	}

	/**
	 * This method deserializes the JSON data into a Field37N object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field37N fromJson(final String json) {
		Field37N field = new Field37N();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
        NarrativeContainerJsonUtils.fromJson(jsonObject, json, field);
		return field;
	}
	
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
	public static final Integer NARRATIVE = 1;

	/**
     * @deprecated use getValue() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public String getNarrative() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "getNarrative()", "Use getValue() instead");
        return getValue();
    }

    // changed component 1

	/**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public String getNarrativeLine1() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "getNarrativeLine1()", "Use getLine(int) or narrative() instead");
		return getLine(1);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public Field37N setNarrativeLine1(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "setNarrativeLine1()", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 2

	/**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
	public String getComponent2() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "getComponent2()", "Use getLine(int) or narrative() instead");
        return getLine(2);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public Field37N setComponent2(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "setComponent2()", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public String getNarrativeLine2() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "getNarrativeLine2()", "Use getLine(int) or narrative() instead");
		return getLine(2);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public Field37N setNarrativeLine2(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "setNarrativeLine2()", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 3

	/**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
	public String getComponent3() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "getComponent3()", "Use getLine(int) or narrative() instead");
        return getLine(3);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public Field37N setComponent3(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "setComponent3()", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public String getNarrativeLine3() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "getNarrativeLine3()", "Use getLine(int) or narrative() instead");
		return getLine(3);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public Field37N setNarrativeLine3(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "setNarrativeLine3()", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 4

	/**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
	public String getComponent4() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "getComponent4()", "Use getLine(int) or narrative() instead");
        return getLine(4);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public Field37N setComponent4(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "setComponent4()", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public String getNarrativeLine4() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "getNarrativeLine4()", "Use getLine(int) or narrative() instead");
		return getLine(4);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public Field37N setNarrativeLine4(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "setNarrativeLine4()", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 5

	/**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
	public String getComponent5() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "getComponent5()", "Use getLine(int) or narrative() instead");
        return getLine(5);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public Field37N setComponent5(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "setComponent5()", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public String getNarrativeLine5() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "getNarrativeLine5()", "Use getLine(int) or narrative() instead");
		return getLine(5);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public Field37N setNarrativeLine5(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "setNarrativeLine5()", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 6

	/**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
	public String getComponent6() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "getComponent6()", "Use getLine(int) or narrative() instead");
        return getLine(6);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public Field37N setComponent6(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "setComponent6()", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public String getNarrativeLine6() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "getNarrativeLine6()", "Use getLine(int) or narrative() instead");
		return getLine(6);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase3=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public Field37N setNarrativeLine6(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase2(this.getClass(), "setNarrativeLine6()", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }
}
