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

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 86D.
 * <p>
 * Model and parser for field 86D of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: DCMark: <code>String</code></li>
 * 		<li>Component 2: Account: <code>String</code></li>
 * 		<li>Component 3: NameAndAddress: <code>String</code></li>
 * 		<li>Component 4: NameAndAddress2: <code>String</code></li>
 * 		<li>Component 5: NameAndAddress3: <code>String</code></li>
 * 		<li>Component 6: NameAndAddress4: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>[[/&lt;DC&gt;][/34x]$]35x[$35x]0-3</code></li>
 * 		<li>parser pattern: <code>[[/c][/S]$]S[$S]0-3</code></li>
 * 		<li>components pattern: <code>SSSSSS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field86D extends OptionDPartyField implements Serializable, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 86D.
	 */
    public static final String NAME = "86D";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_86D = "86D";

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field86D() {
        super();
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field86D(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field86D(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "86D")) {
            throw new IllegalArgumentException("cannot create field 86D from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field86D newInstance(Field86D source) {
        Field86D cp = new Field86D();
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
        return "[[/<DC>][/34x]$]35x[$35x]0-3";
    }

    /**
     * Set the component 1 (D/C Mark).
     *
     * @param component1 the D/C Mark to set
     * @return the field object to enable build pattern
     */
    public Field86D setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the D/C Mark (component 1).
     *
     * @param component1 the D/C Mark to set
     * @return the field object to enable build pattern
     */
    public Field86D setDCMark(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Account).
     *
     * @param component2 the Account to set
     * @return the field object to enable build pattern
     */
    public Field86D setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Account (component 2).
     *
     * @param component2 the Account to set
     * @return the field object to enable build pattern
     */
    public Field86D setAccount(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Name And Address).
     *
     * @param component3 the Name And Address to set
     * @return the field object to enable build pattern
     */
    public Field86D setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Name And Address (component 3).
     *
     * @param component3 the Name And Address to set
     * @return the field object to enable build pattern
     */
    public Field86D setNameAndAddressLine1(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Name And Address splitting the parameter lines into components 3 to 6.
     *
     * @param value the Name And Address to set, may contain line ends and each line will be set to its correspondent component attribute
     * @return the field object to enable build pattern
     */
    public Field86D setNameAndAddress(String value) {
        List<String> lines = SwiftParseUtils.getLines(value);
        SwiftParseUtils.setComponentsFromLines(this, 3, 4, 0, lines);
        return this;
    }

    /**
     * Set the component 4 (Name And Address 2).
     *
     * @param component4 the Name And Address 2 to set
     * @return the field object to enable build pattern
     */
    public Field86D setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the Name And Address 2 (component 4).
     *
     * @param component4 the Name And Address 2 to set
     * @return the field object to enable build pattern
     */
    public Field86D setNameAndAddressLine2(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Name And Address 3).
     *
     * @param component5 the Name And Address 3 to set
     * @return the field object to enable build pattern
     */
    public Field86D setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the Name And Address 3 (component 5).
     *
     * @param component5 the Name And Address 3 to set
     * @return the field object to enable build pattern
     */
    public Field86D setNameAndAddressLine3(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the component 6 (Name And Address 4).
     *
     * @param component6 the Name And Address 4 to set
     * @return the field object to enable build pattern
     */
    public Field86D setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }

    /**
     * Set the Name And Address 4 (component 6).
     *
     * @param component6 the Name And Address 4 to set
     * @return the field object to enable build pattern
     */
    public Field86D setNameAndAddressLine4(String component6) {
        return setComponent6(component6);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field86D.NAME
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
    public static Field86D get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field86D(t);
    }

    /**
     * Gets the first instance of Field86D in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field86D get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field86D in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field86D> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field86D from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field86D> getAll(final SwiftTagListBlock block) {
        final List<Field86D> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field86D(f));
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
    @Override
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
    @Override
    public String getLine(int line, int offset) {
        Field86D cp = newInstance(this);
        return getLine(cp, line, null, offset);
    }

    /**
     * Returns the field value split into lines.
     *
     * @see MultiLineField#getLines()
     * @return lines content or empty list if field's value is empty
     * @since 7.7
     */
    @Override
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
    @Override
    public List<String> getLines(int offset) {
        Field86D cp = newInstance(this);
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
    @Override
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
    @Override
    public List<String> getLinesBetween(int start, int end, int offset) {
        Field86D cp = newInstance(this);
        return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
    }

    /**
     * This method deserializes the JSON data into a Field86D object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field86D fromJson(final String json) {

        final Field86D field = new Field86D();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - D/C Mark

        if (jsonObject.get("dCMark") != null) {
            field.setComponent1(jsonObject.get("dCMark").getAsString());
        }

        // **** COMPONENT 2 - Account

        if (jsonObject.get("account") != null) {
            field.setComponent2(jsonObject.get("account").getAsString());
        }

        // **** COMPONENT 3 - Name And Address

        if (jsonObject.get("nameAndAddress") != null) {
            field.setComponent3(jsonObject.get("nameAndAddress").getAsString());
        }

        // **** COMPONENT 4 - Name And Address 2

        if (jsonObject.get("nameAndAddress2") != null) {
            field.setComponent4(jsonObject.get("nameAndAddress2").getAsString());
        }

        // **** COMPONENT 5 - Name And Address 3

        if (jsonObject.get("nameAndAddress3") != null) {
            field.setComponent5(jsonObject.get("nameAndAddress3").getAsString());
        }

        // **** COMPONENT 6 - Name And Address 4

        if (jsonObject.get("nameAndAddress4") != null) {
            field.setComponent6(jsonObject.get("nameAndAddress4").getAsString());
        }

        return field;
    }


}
