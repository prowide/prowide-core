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

import java.math.BigDecimal;
import java.math.BigInteger;


import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 22C.
 * <p>
 * Model and parser for field 22C of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: PartyPrefix1: <code>String</code></li>
 * 		<li>Component 2: PartySuffix1: <code>String</code></li>
 * 		<li>Component 3: ReferenceCode: <code>Long</code></li>
 * 		<li>Component 4: PartyPrefix2: <code>String</code></li>
 * 		<li>Component 5: PartySuffix2: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>CUSTOM</code></li>
 * 		<li>parser pattern: <code>4!S2!S4!S4!S2!S</code></li>
 * 		<li>components pattern: <code>SSNSS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field22C extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 22C.
	 */
    public static final String NAME = "22C";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_22C = "22C";

	/**
	 * Component number for the Party Prefix 1 subfield.
	 */
	public static final Integer PARTY_PREFIX_1 = 1;

	/**
	 * Component number for the Party Suffix 1 subfield.
	 */
	public static final Integer PARTY_SUFFIX_1 = 2;

	/**
	 * Component number for the Reference Code subfield.
	 */
	public static final Integer REFERENCE_CODE = 3;

	/**
	 * Component number for the Party Prefix 2 subfield.
	 */
	public static final Integer PARTY_PREFIX_2 = 4;

	/**
	 * Component number for the Party Suffix 2 subfield.
	 */
	public static final Integer PARTY_SUFFIX_2 = 5;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field22C() {
        super(5);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field22C(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field22C(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "22C")) {
            throw new IllegalArgumentException("cannot create field 22C from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field22C newInstance(Field22C source) {
        Field22C cp = new Field22C();
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
        init(5);
        if (value != null) {
            if (value.length() >= 4) {
                setComponent1(StringUtils.substring(value, 0, 4));
            }
            if (value.length() >= 6) {
                setComponent2(StringUtils.substring(value, 4, 6));
            }
            if (value.length() >= 10) {
                setComponent3(StringUtils.substring(value, 6, 10));
            }
            if (value.length() >= 14) {
                setComponent4(StringUtils.substring(value, 10, 14));
            }
            if (value.length() > 14) {
                setComponent5(StringUtils.substring(value, 14));
            }
        }
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        result.append(joinComponents());
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 22C");
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
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(5);
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
        return "SSNSS";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "4!S2!S4!S4!S2!S";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "CUSTOM";
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
    public List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Party Prefix 1");
        result.add("Party Suffix 1");
        result.add("Reference Code");
        result.add("Party Prefix 2");
        result.add("Party Suffix 2");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "partyPrefix1");
        result.put(2, "partySuffix1");
        result.put(3, "referenceCode");
        result.put(4, "partyPrefix2");
        result.put(5, "partySuffix2");
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
        super.labelMap.put("partyprefix1", 1);
        super.labelMap.put("partysuffix1", 2);
        super.labelMap.put("referencecode", 3);
        super.labelMap.put("partyprefix2", 4);
        super.labelMap.put("partysuffix2", 5);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Party Prefix 1).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Party Prefix 1 (component 1).
     * @return the Party Prefix 1 from component 1
     */
    public String getPartyPrefix1() {
        return getComponent1();
    }

    /**
     * Gets the component 2 (Party Suffix 1).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Party Suffix 1 (component 2).
     * @return the Party Suffix 1 from component 2
     */
    public String getPartySuffix1() {
        return getComponent2();
    }

    /**
     * Gets the component 3 (Reference Code).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Get the component 3 as Long
     *
     * @return the component 3 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent3AsLong() {
        return SwiftFormatUtils.getLong(getComponent(3));
    }

    /**
     * Gets the Reference Code (component 3).
     * @return the Reference Code from component 3
     */
    public String getReferenceCode() {
        return getComponent3();
    }

    /**
     * Get the Reference Code (component 3) as Long
     * @return the Reference Code from component 3 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getReferenceCodeAsLong() {
        return getComponent3AsLong();
    }

    /**
     * Gets the component 4 (Party Prefix 2).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the Party Prefix 2 (component 4).
     * @return the Party Prefix 2 from component 4
     */
    public String getPartyPrefix2() {
        return getComponent4();
    }

    /**
     * Gets the component 5 (Party Suffix 2).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Gets the Party Suffix 2 (component 5).
     * @return the Party Suffix 2 from component 5
     */
    public String getPartySuffix2() {
        return getComponent5();
    }

    /**
     * Set the component 1 (Party Prefix 1).
     *
     * @param component1 the Party Prefix 1 to set
     * @return the field object to enable build pattern
     */
    public Field22C setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Party Prefix 1 (component 1).
     *
     * @param component1 the Party Prefix 1 to set
     * @return the field object to enable build pattern
     */
    public Field22C setPartyPrefix1(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Party Suffix 1).
     *
     * @param component2 the Party Suffix 1 to set
     * @return the field object to enable build pattern
     */
    public Field22C setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Party Suffix 1 (component 2).
     *
     * @param component2 the Party Suffix 1 to set
     * @return the field object to enable build pattern
     */
    public Field22C setPartySuffix1(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Reference Code).
     *
     * @param component3 the Reference Code to set
     * @return the field object to enable build pattern
     */
    public Field22C setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }


    /**
     * Alternative method setter for field's Reference Code (component 3) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Reference Code content to set
     * @return the field object to enable build pattern
     */
    public Field22C setComponent3(java.lang.Number component3) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component3 instanceof Long) {
            setComponent(3, SwiftFormatUtils.getLong((Long) component3));
        } else if (component3 instanceof BigInteger || component3 instanceof Integer) {
            setComponent(3, SwiftFormatUtils.getLong(component3.longValue()));
        } else if (component3 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(3, SwiftFormatUtils.getLong(component3.longValue()));
        } else {
            // explicitly set component as null
            setComponent(3, null);
        }
        return this;
    }

    /**
     * Set the Reference Code (component 3).
     *
     * @param component3 the Reference Code to set
     * @return the field object to enable build pattern
     */
    public Field22C setReferenceCode(String component3) {
        return setComponent3(component3);
    }

    /**
     * Alternative method setter for field's Reference Code (component 3) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Reference Code content to set
     * @return the field object to enable build pattern
     */
    public Field22C setReferenceCode(java.lang.Number component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Party Prefix 2).
     *
     * @param component4 the Party Prefix 2 to set
     * @return the field object to enable build pattern
     */
    public Field22C setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the Party Prefix 2 (component 4).
     *
     * @param component4 the Party Prefix 2 to set
     * @return the field object to enable build pattern
     */
    public Field22C setPartyPrefix2(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Party Suffix 2).
     *
     * @param component5 the Party Suffix 2 to set
     * @return the field object to enable build pattern
     */
    public Field22C setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the Party Suffix 2 (component 5).
     *
     * @param component5 the Party Suffix 2 to set
     * @return the field object to enable build pattern
     */
    public Field22C setPartySuffix2(String component5) {
        return setComponent5(component5);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field22C.NAME
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
    public static Field22C get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field22C(t);
    }

    /**
     * Gets the first instance of Field22C in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field22C get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field22C in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field22C> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field22C from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field22C> getAll(final SwiftTagListBlock block) {
        final List<Field22C> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field22C(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field22C object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field22C fromJson(final String json) {

        final Field22C field = new Field22C();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Party Prefix 1

        if (jsonObject.get("partyPrefix1") != null) {
            field.setComponent1(jsonObject.get("partyPrefix1").getAsString());
        }

        // **** COMPONENT 2 - Party Suffix 1

        if (jsonObject.get("partySuffix1") != null) {
            field.setComponent2(jsonObject.get("partySuffix1").getAsString());
        }

        // **** COMPONENT 3 - Reference Code

        if (jsonObject.get("referenceCode") != null) {
            field.setComponent3(jsonObject.get("referenceCode").getAsString());
        }

        // **** COMPONENT 4 - Party Prefix 2

        if (jsonObject.get("partyPrefix2") != null) {
            field.setComponent4(jsonObject.get("partyPrefix2").getAsString());
        }

        // **** COMPONENT 5 - Party Suffix 2

        if (jsonObject.get("partySuffix2") != null) {
            field.setComponent5(jsonObject.get("partySuffix2").getAsString());
        }

        return field;
    }


}
