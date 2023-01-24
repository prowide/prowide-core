/*
 * Copyright 2006-2022 Prowide
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
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

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
 * SWIFT MT Field 77.
 * <p>
 * Model and parser for field 77 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Narrative: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>35z[$35z]0-19</code></li>
 * 		<li>parser pattern: <code>S</code></li>
 * 		<li>components pattern: <code>S</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2022</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field77 extends StructuredNarrativeField implements Serializable, NarrativeContainer, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2022;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 77.
	 */
    public static final String NAME = "77";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_77 = "77";

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field77() {
        super();
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field77(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field77(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "77")) {
            throw new IllegalArgumentException("cannot create field 77 from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Creates a new field from a Narrative instance.
     * @see Narrative#builder
     * @param narrative a not-null narrative to use as field value
     * @since 8.1.0
     */
    public Field77(final Narrative narrative) {
        this(narrative.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field77 newInstance(Field77 source) {
        Field77 cp = new Field77();
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
     * Create a Tag with this field name and an empty string as value.
     * Shorthand for <code>new Tag(NAME, "")</code>
     * @see #NAME
     * @since 7.5
     */
    public static Tag emptyTag() {
        return new Tag(NAME, "");
    }

    /**
     * Returns the field validator pattern.
     */
    @Override
    public final String validatorPattern() {
        return "35z[$35z]0-19";
    }

    /**
     * Set the component 1 (Narrative).
     *
     * @param component1 the Narrative to set
     * @return the field object to enable build pattern
     */
    public Field77 setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Narrative (component 1).
     *
     * @param component1 the Narrative to set
     * @return the field object to enable build pattern
     */
    public Field77 setNarrative(String component1) {
        return setComponent1(component1);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field77.NAME
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
    public static Field77 get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field77(t);
    }

    /**
     * Gets the first instance of Field77 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field77 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field77 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field77> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field77 from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field77> getAll(final SwiftTagListBlock block) {
        final List<Field77> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add(new Field77(f));
            }
        }
        return result;
    }

    /**
     * Returns a specific line from the field's value.
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
     * Returns a specific line from the field's value.
     *
     * @see MultiLineField#getLine(int, int)
     * @param line a reference to a specific line in the field, first line being 1
     * @param offset an optional component number used as offset when counting lines
     * @return line content or null if not present or if line number is above the expected
     * @since 7.7
     */
    public String getLine(int line, int offset) {
        Field77 cp = newInstance(this);
        return getLine(cp, line, null, offset);
    }

    /**
     * Returns the field value split into lines.
     *
     * @see MultiLineField#getLines()
     * @return lines content or empty list if field's value is empty
     * @since 7.7
     */
    public List<String> getLines() {
        return SwiftParseUtils.getLines(getValue());
    }

    /**
     * Returns the field value starting at the offset component, split into lines.
     *
     * @see MultiLineField#getLines(int)
     * @param offset an optional component number used as offset when counting lines
     * @return found lines or empty list if lines are not present or the offset is invalid
     * @since 7.7
     */
    public List<String> getLines(int offset) {
        Field77 cp = newInstance(this);
        return SwiftParseUtils.getLines(getLine(cp, null, null, offset));
    }

    /**
     * Returns a specific subset of lines from the field's value, given a range.
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
     * Returns a specific subset of lines from the field's value, starting at the offset component.
     *
     * @see MultiLineField#getLinesBetween(int start, int end, int offset)
     * @param start a reference to a specific line in the field, first line being 1
     * @param end a reference to a specific line in the field, must be greater than start
     * @param offset an optional component number used as offset when counting lines
     * @return found lines or empty list if lines are not present or the offset is invalid
     * @since 7.7
     */
    public List<String> getLinesBetween(int start, int end, int offset) {
        Field77 cp = newInstance(this);
        return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
    }

    /**
     * This method deserializes the JSON data into a Field77 object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field77 fromJson(final String json) {

        final Field77 field = new Field77();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        NarrativeContainerJsonUtils.fromJson(jsonObject, json, field);

        return field;
    }

    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public static final Integer NARRATIVE = 1;

	/**
     * @deprecated Use getValue() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrative() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrative()", "Use getValue() instead");
        return getValue();
    }

    // changed component 1

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine1() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine1()", "Use getLine(int) or narrative() instead");
		return getLine(1);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine1(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine1(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 2

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent2() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent2()", "Use getLine(int) or narrative() instead");
        return getLine(2);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent2(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent2(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine2() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine2()", "Use getLine(int) or narrative() instead");
		return getLine(2);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine2(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine2(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 3

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent3() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent3()", "Use getLine(int) or narrative() instead");
        return getLine(3);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent3(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent3(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine3() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine3()", "Use getLine(int) or narrative() instead");
		return getLine(3);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine3(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine3(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 4

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent4() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent4()", "Use getLine(int) or narrative() instead");
        return getLine(4);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent4(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent4(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine4() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine4()", "Use getLine(int) or narrative() instead");
		return getLine(4);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine4(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine4(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 5

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent5() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent5()", "Use getLine(int) or narrative() instead");
        return getLine(5);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent5(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent5(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine5() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine5()", "Use getLine(int) or narrative() instead");
		return getLine(5);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine5(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine5(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 6

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent6() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent6()", "Use getLine(int) or narrative() instead");
        return getLine(6);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent6(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent6(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine6() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine6()", "Use getLine(int) or narrative() instead");
		return getLine(6);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine6(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine6(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 7

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent7() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent7()", "Use getLine(int) or narrative() instead");
        return getLine(7);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent7(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent7(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine7() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine7()", "Use getLine(int) or narrative() instead");
		return getLine(7);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine7(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine7(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 8

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent8() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent8()", "Use getLine(int) or narrative() instead");
        return getLine(8);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent8(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent8(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine8() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine8()", "Use getLine(int) or narrative() instead");
		return getLine(8);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine8(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine8(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 9

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent9() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent9()", "Use getLine(int) or narrative() instead");
        return getLine(9);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent9(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent9(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine9() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine9()", "Use getLine(int) or narrative() instead");
		return getLine(9);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine9(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine9(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 10

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent10() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent10()", "Use getLine(int) or narrative() instead");
        return getLine(10);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent10(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent10(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine10() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine10()", "Use getLine(int) or narrative() instead");
		return getLine(10);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine10(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine10(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 11

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent11() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent11()", "Use getLine(int) or narrative() instead");
        return getLine(11);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent11(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent11(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine11() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine11()", "Use getLine(int) or narrative() instead");
		return getLine(11);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine11(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine11(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 12

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent12() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent12()", "Use getLine(int) or narrative() instead");
        return getLine(12);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent12(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent12(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine12() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine12()", "Use getLine(int) or narrative() instead");
		return getLine(12);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine12(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine12(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 13

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent13() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent13()", "Use getLine(int) or narrative() instead");
        return getLine(13);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent13(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent13(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine13() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine13()", "Use getLine(int) or narrative() instead");
		return getLine(13);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine13(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine13(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 14

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent14() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent14()", "Use getLine(int) or narrative() instead");
        return getLine(14);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent14(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent14(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine14() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine14()", "Use getLine(int) or narrative() instead");
		return getLine(14);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine14(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine14(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 15

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent15() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent15()", "Use getLine(int) or narrative() instead");
        return getLine(15);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent15(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent15(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine15() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine15()", "Use getLine(int) or narrative() instead");
		return getLine(15);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine15(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine15(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 16

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent16() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent16()", "Use getLine(int) or narrative() instead");
        return getLine(16);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent16(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent16(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine16() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine16()", "Use getLine(int) or narrative() instead");
		return getLine(16);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine16(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine16(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 17

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent17() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent17()", "Use getLine(int) or narrative() instead");
        return getLine(17);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent17(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent17(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine17() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine17()", "Use getLine(int) or narrative() instead");
		return getLine(17);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine17(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine17(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 18

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent18() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent18()", "Use getLine(int) or narrative() instead");
        return getLine(18);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent18(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent18(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine18() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine18()", "Use getLine(int) or narrative() instead");
		return getLine(18);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine18(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine18(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 19

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent19() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent19()", "Use getLine(int) or narrative() instead");
        return getLine(19);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent19(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent19(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine19() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine19()", "Use getLine(int) or narrative() instead");
		return getLine(19);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine19(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine19(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    // deprecated component 20

	/**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
	public String getComponent20() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getComponent20()", "Use getLine(int) or narrative() instead");
        return getLine(20);
    }

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setComponent20(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setComponent20(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }

    /**
     * @deprecated Use getLine(int) or narrative() instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public String getNarrativeLine20() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "getNarrativeLine20()", "Use getLine(int) or narrative() instead");
		return getLine(20);
	}

	/**
     * @deprecated this method does not set any value, use setNarrative(Narrative) or appendLine(String) instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase4=com.prowidesoftware.deprecation.TargetYear.SRU2023)
    public Field77 setNarrativeLine20(String component) {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(this.getClass(), "setNarrativeLine20(String)", "Use setNarrative(Narrative) or appendLine(String) instead");
        appendLine(component);
        return this;
    }
}
