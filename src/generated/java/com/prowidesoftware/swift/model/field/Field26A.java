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



import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 26A.
 * <p>
 * Model and parser for field 26A of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Number1: <code>String</code></li>
 * 		<li>Component 2: Number2: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;VAR-SEQU-2&gt;</code></li>
 * 		<li>parser pattern: <code>S[/S]</code></li>
 * 		<li>components pattern: <code>SS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field26A extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 26A.
	 */
    public static final String NAME = "26A";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_26A = "26A";

	/**
	 * Component number for the Number1 subfield.
	 */
	public static final Integer NUMBER1 = 1;

	/**
	 * Component number for the Number2 subfield.
	 */
	public static final Integer NUMBER2 = 2;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field26A() {
        super(2);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field26A(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field26A(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "26A")) {
            throw new IllegalArgumentException("cannot create field 26A from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field26A newInstance(Field26A source) {
        Field26A cp = new Field26A();
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
        init(2);
        setComponent1(SwiftParseUtils.getTokenFirst(value, "/"));
        setComponent2(SwiftParseUtils.getTokenSecondLast(value, "/"));
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        append(result, 1);
        if (getComponent2() != null) {
            result.append("/").append(getComponent2());
        }
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
        if (component < 1 || component > 2) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 26A");
        }
        if (component == 1) {
            //default format (as is)
            return getComponent(1);
        }
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(2);
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
        return "SS";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "S[/S]";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "<VAR-SEQU-2>";
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
        return 2;
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
        result.add("Number1");
        result.add("Number2");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "number1");
        result.put(2, "number2");
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
        super.labelMap.put("number1", 1);
        super.labelMap.put("number2", 2);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Number1).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Number1 (component 1).
     * @return the Number1 from component 1
     */
    public String getNumber1() {
        return getComponent1();
    }

    /**
     * Gets the component 2 (Number2).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Number2 (component 2).
     * @return the Number2 from component 2
     */
    public String getNumber2() {
        return getComponent2();
    }

    /**
     * Set the component 1 (Number1).
     *
     * @param component1 the Number1 to set
     * @return the field object to enable build pattern
     */
    public Field26A setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Number1 (component 1).
     *
     * @param component1 the Number1 to set
     * @return the field object to enable build pattern
     */
    public Field26A setNumber1(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Number2).
     *
     * @param component2 the Number2 to set
     * @return the field object to enable build pattern
     */
    public Field26A setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Number2 (component 2).
     *
     * @param component2 the Number2 to set
     * @return the field object to enable build pattern
     */
    public Field26A setNumber2(String component2) {
        return setComponent2(component2);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field26A.NAME
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
    public static Field26A get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field26A(t);
    }

    /**
     * Gets the first instance of Field26A in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field26A get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field26A in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field26A> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field26A from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field26A> getAll(final SwiftTagListBlock block) {
        final List<Field26A> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field26A(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field26A object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field26A fromJson(final String json) {

        final Field26A field = new Field26A();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Number1

        if (jsonObject.get("number1") != null) {
            field.setComponent1(jsonObject.get("number1").getAsString());
        }

        // **** COMPONENT 2 - Number2

        if (jsonObject.get("number2") != null) {
            field.setComponent2(jsonObject.get("number2").getAsString());
        }

        return field;
    }


}
