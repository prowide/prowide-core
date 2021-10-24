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
 * <strong>SWIFT MT Field 41D</strong>
 * <p>
 * Model and parser for field 41D of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>35x[$35x]0-3$14x</code></li>
 * 		<li>parser pattern: <code>S[$S]0-3$S</code></li>
 * 		<li>components pattern: <code>SSSSS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field41D extends Field implements Serializable, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 41D
	 */
    public static final String NAME = "41D";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_41D = "41D";
	public static final String PARSER_PATTERN = "S[$S]0-3$S";

    /**
     * Components pattern
     *
     * Contains a description of the type for every component. This is <em>DEPRECATED</em>,
     * use TYPES_PATTERN instead, because it distinguishes between N (number) and I (BigDecimal)
     * @see #TYPES_PATTERN
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "SSSSS";

    /**
     * Types pattern
     *
     * Contains a description of the type for every component, use instead of COMPONENTS_PATTERN.
     * @since 9.2.7
     */
	public static final String TYPES_PATTERN = "SSSSS";

	/**
	 * Component number for the Name And Address subfield
	 */
	public static final Integer NAME_AND_ADDRESS = 1;

	/**
	 * Component number for the Code subfield
	 */
	public static final Integer CODE = 5;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field41D() {
        super(5);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field41D(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field41D(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "41D")) {
            throw new IllegalArgumentException("cannot create field 41D from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.<br>
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field41D newInstance(Field41D source) {
        Field41D cp = new Field41D();
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
     * Parses the parameter value into the internal components structure.
     *
     * <p>Used to update all components from a full new value, as an alternative
     * to setting individual components. Previous component values are overwritten.
     *
     * @param value complete field value including separators and CRLF
     * @since 7.8
     */
    @Override
    public void parse(final String value) {
        init(5);
        final List<String> lines = SwiftParseUtils.getLines(value);
        String c5 = null;
        if (lines.size() > 1) {
            c5 = lines.remove(lines.size() > 5 ? 4 : lines.size()-1);
        }
        if (!lines.isEmpty()) {
            setComponent1(lines.get(0));
            if (lines.size() > 1) {
                setComponent2(lines.get(1));
            }
            if (lines.size() > 2) {
                setComponent3(lines.get(2));
            }
            if (lines.size() > 3) {
                setComponent4(lines.get(3));
            }
        }
        if (c5 != null) {
            setComponent5(c5);
        }
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        appendInLines(result, 1, 5);
        return result.toString();
    }

    /**
     * Returns a localized suitable for showing to humans string of a field component.<br>
     *
     * @param component number of the component to display
     * @param locale optional locale to format date and amounts, if null, the default locale is used
     * @return formatted component value or null if component number is invalid or not present
     * @throws IllegalArgumentException if component number is invalid for the field
     * @since 7.8
     */
    @Override
    public String getValueDisplay(int component, Locale locale) {
        if (component < 1 || component > 5) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 41D");
        }
        if (component == 1) {
            //default format (as is)
            return getComponent(1);
        }
        if (component == 2) {
            //default format (as is)
            return getComponent(2);
        }
        if (component == 3) {
            //default format (as is)
            return getComponent(3);
        }
        if (component == 4) {
            //default format (as is)
            return getComponent(4);
        }
        if (component == 5) {
            //default format (as is)
            return getComponent(5);
        }
        return null;
    }

    /**
     * Returns the field components pattern
     *
     * This method is <em>DEPRECATED</em>, use <code>typesPattern()</code> instead.
     * @see #typesPattern()
     * @return the static value of Field41D.COMPONENTS_PATTERN
     */
    @Override
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public final String componentsPattern() {
        return COMPONENTS_PATTERN;
    }

    /**
     * Returns the field component types pattern
     *
     * This method returns a letter representing the type for each component in the Field. It supersedes
     * the Components Pattern because it distinguishes between N (Number) and I (BigDecimal).
     * @since 9.2.7
     * @see #TYPES_PATTERN
     * @return the static value of Field41D.TYPES_PATTERN
     */
    @Override
    public final String typesPattern() {
        return TYPES_PATTERN;
    }

    /**
     * Returns the field parser pattern
     * @return the static value of Field41D.PARSER_PATTERN
     */
    @Override
    public final String parserPattern() {
        return PARSER_PATTERN;
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public final String validatorPattern() {
        return "35x[$35x]0-3$14x";
    }

    /**
     * Given a component number it returns true if the component is optional,
     * regardless of the field being mandatory in a particular message.<br>
     * Being the field's value conformed by a composition of one or several
     * internal component values, the field may be present in a message with
     * a proper value but with some of its internal components not set.
     *
     * @param component component number, first component of a field is referenced as 1
     * @return true if the component is optional for this field, false otherwise
     */
    @Override
    public boolean isOptional(int component) {
        if (component == 2) {
            return true;
        }
        if (component == 3) {
            return true;
        }
        if (component == 4) {
            return true;
        }
        return false;
    }

    /**
     * Returns true if the field is a GENERIC FIELD as specified by the standard.
     * @return true if the field is generic, false otherwise
     */
    @Override
    public boolean isGeneric() {
        return false;
    }

    /**
     * Returns the defined amount of components.<br>
     * This is not the amount of components present in the field instance, but the total amount of components
     * that this field accepts as defined.
     * @since 7.7
     */
    @Override
    public int componentsSize() {
        return 5;
    }

    /**
     * Returns english label for components.
     * <br>
     * The index in the list is in sync with specific field component structure.
     * @see #getComponentLabel(int)
     * @since 7.8.4
     */
    @Override
    protected List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Name And Address");
        result.add("Name And Address 2");
        result.add("Name And Address 3");
        result.add("Name And Address 4");
        result.add("Code");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "nameAndAddress");
        result.put(2, "nameAndAddress2");
        result.put(3, "nameAndAddress3");
        result.put(4, "nameAndAddress4");
        result.put(5, "code");
        return result;
    }


    /**
     * Gets the component 1 (Name And Address).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Name And Address (component 1).
     * @return the Name And Address from component 1
     */
    public String getNameAndAddressLine1() {
        return getComponent1();
    }

    /**
     * Gets the Name And Address as a concatenation of component 1 to component 4.
     * @return the Name And Address from components
     */
    public String getNameAndAddress() {
        return getNameAndAddress(null);
    }

    /**
     * Gets the Name And Address as a concatenation of component 1 to component 4 joined together with a copy of the
     * specified delimiter.
     * @param deli the delimiter that separates each component
     * @return the Name And Address from components
     * @since 9.1.4
     */
    public String getNameAndAddress(CharSequence deli) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < 5; i++) {
            if (getComponent(i) != null) {
                if (deli != null && result.length() > 0) {
                    result.append(deli);
                }
                result.append(getComponent(i));
            }
        }
        return result.toString();
    }

    /**
     * Gets the component 2 (Name And Address 2).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Name And Address 2 (component 2).
     * @return the Name And Address 2 from component 2
     */
    public String getNameAndAddressLine2() {
        return getComponent2();
    }

    /**
     * Gets the component 3 (Name And Address 3).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Name And Address 3 (component 3).
     * @return the Name And Address 3 from component 3
     */
    public String getNameAndAddressLine3() {
        return getComponent3();
    }

    /**
     * Gets the component 4 (Name And Address 4).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the Name And Address 4 (component 4).
     * @return the Name And Address 4 from component 4
     */
    public String getNameAndAddressLine4() {
        return getComponent4();
    }

    /**
     * Gets the component 5 (Code).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Gets the Code (component 5).
     * @return the Code from component 5
     */
    public String getCode() {
        return getComponent5();
    }

    /**
     * Set the component 1 (Name And Address).
     *
     * @param component1 the Name And Address to set
     * @return the field object to enable build pattern
     */
    public Field41D setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Name And Address (component 1).
     *
     * @param component1 the Name And Address to set
     * @return the field object to enable build pattern
     */
    public Field41D setNameAndAddressLine1(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the Name And Address splitting the parameter lines into components 1 to 4.
     *
     * @param value the Name And Address to set, may contain line ends and each line will be set to its correspondent component attribute
     * @return the field object to enable build pattern
     */
    public Field41D setNameAndAddress(String value) {
        List<String> lines = SwiftParseUtils.getLines(value);
        SwiftParseUtils.setComponentsFromLines(this, 1, 4, 0, lines);
        return this;
    }

    /**
     * Set the component 2 (Name And Address 2).
     *
     * @param component2 the Name And Address 2 to set
     * @return the field object to enable build pattern
     */
    public Field41D setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Name And Address 2 (component 2).
     *
     * @param component2 the Name And Address 2 to set
     * @return the field object to enable build pattern
     */
    public Field41D setNameAndAddressLine2(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Name And Address 3).
     *
     * @param component3 the Name And Address 3 to set
     * @return the field object to enable build pattern
     */
    public Field41D setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Name And Address 3 (component 3).
     *
     * @param component3 the Name And Address 3 to set
     * @return the field object to enable build pattern
     */
    public Field41D setNameAndAddressLine3(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Name And Address 4).
     *
     * @param component4 the Name And Address 4 to set
     * @return the field object to enable build pattern
     */
    public Field41D setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the Name And Address 4 (component 4).
     *
     * @param component4 the Name And Address 4 to set
     * @return the field object to enable build pattern
     */
    public Field41D setNameAndAddressLine4(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Code).
     *
     * @param component5 the Code to set
     * @return the field object to enable build pattern
     */
    public Field41D setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the Code (component 5).
     *
     * @param component5 the Code to set
     * @return the field object to enable build pattern
     */
    public Field41D setCode(String component5) {
        return setComponent5(component5);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any)
     * @return the static value of Field41D.NAME
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
    public static Field41D get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field41D(t) ;
    }

    /**
     * Gets the first instance of Field41D in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field41D get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return null;
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field41D in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field41D> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return java.util.Collections.emptyList();
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field41D from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field41D> getAll(final SwiftTagListBlock block) {
        final List<Field41D> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add( new Field41D(f));
            }
        }
        return result;
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
        Field41D cp = newInstance(this);
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
        Field41D cp = newInstance(this);
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
        Field41D cp = newInstance(this);
        return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
    }

    /**
     * This method deserializes the JSON data into a Field41D object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field41D fromJson(final String json) {

        Field41D field = new Field41D();

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(json);

        // **** COMPONENT 1 - Name And Address

        if (jsonObject.get("nameAndAddress") != null) {
            field.setComponent1(jsonObject.get("nameAndAddress").getAsString());
        }

        // **** COMPONENT 2 - Name And Address 2

        if (jsonObject.get("nameAndAddress2") != null) {
            field.setComponent2(jsonObject.get("nameAndAddress2").getAsString());
        }

        // **** COMPONENT 3 - Name And Address 3

        if (jsonObject.get("nameAndAddress3") != null) {
            field.setComponent3(jsonObject.get("nameAndAddress3").getAsString());
        }

        // **** COMPONENT 4 - Name And Address 4

        if (jsonObject.get("nameAndAddress4") != null) {
            field.setComponent4(jsonObject.get("nameAndAddress4").getAsString());
        }

        // **** COMPONENT 5 - Code

        if (jsonObject.get("code") != null) {
            field.setComponent5(jsonObject.get("code").getAsString());
        }

        return field;
    }


}
