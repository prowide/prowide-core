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
 * SWIFT MT Field 23R.
 * <p>
 * Model and parser for field 23R of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Code: <code>String</code></li>
 * 		<li>Component 2: Text: <code>String</code></li>
 * 		<li>Component 3: Text2: <code>String</code></li>
 * 		<li>Component 4: Text3: <code>String</code></li>
 * 		<li>Component 5: Text4: <code>String</code></li>
 * 		<li>Component 6: Text5: <code>String</code></li>
 * 		<li>Component 7: Text6: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>4!c(**)[$35x]0-6</code></li>
 * 		<li>parser pattern: <code>S[$S]0-6</code></li>
 * 		<li>components pattern: <code>SSSSSSS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field23R extends Field implements Serializable, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 23R.
	 */
    public static final String NAME = "23R";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_23R = "23R";

	/**
	 * Component number for the Code subfield.
	 */
	public static final Integer CODE = 1;

	/**
	 * Component number for the Text subfield.
	 */
	public static final Integer TEXT = 2;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field23R() {
        super(7);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field23R(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field23R(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "23R")) {
            throw new IllegalArgumentException("cannot create field 23R from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field23R newInstance(Field23R source) {
        Field23R cp = new Field23R();
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
        init(7);
        List<String> lines = SwiftParseUtils.getLines(value);
        SwiftParseUtils.setComponentsFromLines(this, 1, null, 0, lines);
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        appendInLines(result, 1, 7);
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
        if (component < 1 || component > 7) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 23R");
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
        if (component == 6) {
            //default format (as is)
            return getComponent(6);
        }
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(7);
    }

    /**
     * Returns the field component types pattern.
     * <p>
     * This method returns a letter representing the type for each component in the Field. It supersedes
     * the Components Pattern because it distinguishes between N (Number) and I (BigDecimal).
     * @since 9.2.7
     */
    @Override
    public String typesPattern() {
        return "SSSSSSS";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "S[$S]0-6";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "4!c(**)[$35x]0-6";
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
        if (component == 5) {
            return true;
        }
        if (component == 6) {
            return true;
        }
        if (component == 7) {
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
        return 7;
    }

    /**
     * Returns english label for components.
     * <br>
     * The index in the list is in sync with specific field component structure.
     * @see #getComponentLabel(int)
     * @since 7.8.4
     */
    @Override
    public List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Code");
        result.add("Text");
        result.add("Text 2");
        result.add("Text 3");
        result.add("Text 4");
        result.add("Text 5");
        result.add("Text 6");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "code");
        result.put(2, "text");
        result.put(3, "text2");
        result.put(4, "text3");
        result.put(5, "text4");
        result.put(6, "text5");
        result.put(7, "text6");
        return result;
    }

    /**
     * @see Field#getLabelMap()
     * @since 9.3.12
     */
    @Override
    protected Map<String, Integer> getLabelMap() {
        if (super.labelMap != null && !super.labelMap.isEmpty()) {
            // return cached map
            return super.labelMap;
        }
        super.labelMap = new HashMap<>();
        super.labelMap.put("code", 1);
        super.labelMap.put("text", 2);
        super.labelMap.put("text2", 3);
        super.labelMap.put("text3", 4);
        super.labelMap.put("text4", 5);
        super.labelMap.put("text5", 6);
        super.labelMap.put("text6", 7);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Code).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Code (component 1).
     * @return the Code from component 1
     */
    public String getCode() {
        return getComponent1();
    }

    /**
     * Gets the component 2 (Text).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Text (component 2).
     * @return the Text from component 2
     */
    public String getTextLine1() {
        return getComponent2();
    }

    /**
     * Gets the Text as a concatenation of component 2 to component 7.
     * @return the Text from components
     */
    public String getText() {
        return getText(null);
    }

    /**
     * Gets the Text as a concatenation of component 2 to component 7 joined together with a copy of the
     * specified delimiter.
     * @param deli the delimiter that separates each component
     * @return the Text from components
     * @since 9.1.4
     */
    public String getText(CharSequence deli) {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i < 8; i++) {
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
     * Gets the component 3 (Text 2).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Text 2 (component 3).
     * @return the Text 2 from component 3
     */
    public String getTextLine2() {
        return getComponent3();
    }

    /**
     * Gets the component 4 (Text 3).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the Text 3 (component 4).
     * @return the Text 3 from component 4
     */
    public String getTextLine3() {
        return getComponent4();
    }

    /**
     * Gets the component 5 (Text 4).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Gets the Text 4 (component 5).
     * @return the Text 4 from component 5
     */
    public String getTextLine4() {
        return getComponent5();
    }

    /**
     * Gets the component 6 (Text 5).
     * @return the component 6
     */
    public String getComponent6() {
        return getComponent(6);
    }

    /**
     * Gets the Text 5 (component 6).
     * @return the Text 5 from component 6
     */
    public String getTextLine5() {
        return getComponent6();
    }

    /**
     * Gets the component 7 (Text 6).
     * @return the component 7
     */
    public String getComponent7() {
        return getComponent(7);
    }

    /**
     * Gets the Text 6 (component 7).
     * @return the Text 6 from component 7
     */
    public String getTextLine6() {
        return getComponent7();
    }

    /**
     * Set the component 1 (Code).
     *
     * @param component1 the Code to set
     * @return the field object to enable build pattern
     */
    public Field23R setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Code (component 1).
     *
     * @param component1 the Code to set
     * @return the field object to enable build pattern
     */
    public Field23R setCode(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Text).
     *
     * @param component2 the Text to set
     * @return the field object to enable build pattern
     */
    public Field23R setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Text (component 2).
     *
     * @param component2 the Text to set
     * @return the field object to enable build pattern
     */
    public Field23R setTextLine1(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Text splitting the parameter lines into components 2 to 7.
     *
     * @param value the Text to set, may contain line ends and each line will be set to its correspondent component attribute
     * @return the field object to enable build pattern
     */
    public Field23R setText(String value) {
        List<String> lines = SwiftParseUtils.getLines(value);
        SwiftParseUtils.setComponentsFromLines(this, 2, 6, 0, lines);
        return this;
    }

    /**
     * Set the component 3 (Text 2).
     *
     * @param component3 the Text 2 to set
     * @return the field object to enable build pattern
     */
    public Field23R setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Text 2 (component 3).
     *
     * @param component3 the Text 2 to set
     * @return the field object to enable build pattern
     */
    public Field23R setTextLine2(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Text 3).
     *
     * @param component4 the Text 3 to set
     * @return the field object to enable build pattern
     */
    public Field23R setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the Text 3 (component 4).
     *
     * @param component4 the Text 3 to set
     * @return the field object to enable build pattern
     */
    public Field23R setTextLine3(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Text 4).
     *
     * @param component5 the Text 4 to set
     * @return the field object to enable build pattern
     */
    public Field23R setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the Text 4 (component 5).
     *
     * @param component5 the Text 4 to set
     * @return the field object to enable build pattern
     */
    public Field23R setTextLine4(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the component 6 (Text 5).
     *
     * @param component6 the Text 5 to set
     * @return the field object to enable build pattern
     */
    public Field23R setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }

    /**
     * Set the Text 5 (component 6).
     *
     * @param component6 the Text 5 to set
     * @return the field object to enable build pattern
     */
    public Field23R setTextLine5(String component6) {
        return setComponent6(component6);
    }

    /**
     * Set the component 7 (Text 6).
     *
     * @param component7 the Text 6 to set
     * @return the field object to enable build pattern
     */
    public Field23R setComponent7(String component7) {
        setComponent(7, component7);
        return this;
    }

    /**
     * Set the Text 6 (component 7).
     *
     * @param component7 the Text 6 to set
     * @return the field object to enable build pattern
     */
    public Field23R setTextLine6(String component7) {
        return setComponent7(component7);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field23R.NAME
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
    public static Field23R get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field23R(t);
    }

    /**
     * Gets the first instance of Field23R in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field23R get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field23R in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field23R> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field23R from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field23R> getAll(final SwiftTagListBlock block) {
        final List<Field23R> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field23R(f));
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
        Field23R cp = newInstance(this);
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
        Field23R cp = newInstance(this);
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
        Field23R cp = newInstance(this);
        return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
    }

    /**
     * This method deserializes the JSON data into a Field23R object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field23R fromJson(final String json) {

        final Field23R field = new Field23R();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Code

        if (jsonObject.get("code") != null) {
            field.setComponent1(jsonObject.get("code").getAsString());
        }

        // **** COMPONENT 2 - Text

        if (jsonObject.get("text") != null) {
            field.setComponent2(jsonObject.get("text").getAsString());
        }

        // **** COMPONENT 3 - Text 2

        if (jsonObject.get("text2") != null) {
            field.setComponent3(jsonObject.get("text2").getAsString());
        }

        // **** COMPONENT 4 - Text 3

        if (jsonObject.get("text3") != null) {
            field.setComponent4(jsonObject.get("text3").getAsString());
        }

        // **** COMPONENT 5 - Text 4

        if (jsonObject.get("text4") != null) {
            field.setComponent5(jsonObject.get("text4").getAsString());
        }

        // **** COMPONENT 6 - Text 5

        if (jsonObject.get("text5") != null) {
            field.setComponent6(jsonObject.get("text5").getAsString());
        }

        // **** COMPONENT 7 - Text 6

        if (jsonObject.get("text6") != null) {
            field.setComponent7(jsonObject.get("text6").getAsString());
        }

        return field;
    }


}
