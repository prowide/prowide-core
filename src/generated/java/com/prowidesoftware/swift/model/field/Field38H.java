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
 * SWIFT MT Field 38H.
 * <p>
 * Model and parser for field 38H of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: NumberFrom: <code>Long</code></li>
 * 		<li>Component 2: PeriodFrom: <code>String</code></li>
 * 		<li>Component 3: NumberTo: <code>Long</code></li>
 * 		<li>Component 4: PeriodTo: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>2n1a/2n1a</code></li>
 * 		<li>parser pattern: <code>NS/NS</code></li>
 * 		<li>components pattern: <code>NSNS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field38H extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 38H.
	 */
    public static final String NAME = "38H";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_38H = "38H";

	/**
	 * Component number for the Number From subfield.
	 */
	public static final Integer NUMBER_FROM = 1;

	/**
	 * Component number for the Period From subfield.
	 */
	public static final Integer PERIOD_FROM = 2;

	/**
	 * Component number for the Number To subfield.
	 */
	public static final Integer NUMBER_TO = 3;

	/**
	 * Component number for the Period To subfield.
	 */
	public static final Integer PERIOD_TO = 4;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field38H() {
        super(4);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field38H(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field38H(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "38H")) {
            throw new IllegalArgumentException("cannot create field 38H from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field38H newInstance(Field38H source) {
        Field38H cp = new Field38H();
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
        init(4);
        setComponent1(SwiftParseUtils.getNumericPrefix(StringUtils.substringBefore(value, "/")));
        setComponent2(SwiftParseUtils.getAlphaSuffix(StringUtils.substringBefore(value, "/")));
        String toparse = SwiftParseUtils.getTokenSecondLast(value, "/");
        setComponent3(SwiftParseUtils.getNumericPrefix(toparse));
        setComponent4(SwiftParseUtils.getAlphaSuffix(toparse));
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        append(result, 1);
        append(result, 2);
        result.append("/");
        append(result, 3);
        append(result, 4);
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
        if (component < 1 || component > 4) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 38H");
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
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(4);
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
        return "NSNS";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "NS/NS";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "2n1a/2n1a";
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
        return 4;
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
        result.add("Number From");
        result.add("Period From");
        result.add("Number To");
        result.add("Period To");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "numberFrom");
        result.put(2, "periodFrom");
        result.put(3, "numberTo");
        result.put(4, "periodTo");
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
        super.labelMap.put("numberfrom", 1);
        super.labelMap.put("periodfrom", 2);
        super.labelMap.put("numberto", 3);
        super.labelMap.put("periodto", 4);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Number From).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Get the component 1 as Long
     *
     * @return the component 1 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent1AsLong() {
        return SwiftFormatUtils.getLong(getComponent(1));
    }

    /**
     * Gets the Number From (component 1).
     * @return the Number From from component 1
     */
    public String getNumberFrom() {
        return getComponent1();
    }

    /**
     * Get the Number From (component 1) as Long
     * @return the Number From from component 1 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getNumberFromAsLong() {
        return getComponent1AsLong();
    }

    /**
     * Gets the component 2 (Period From).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Period From (component 2).
     * @return the Period From from component 2
     */
    public String getPeriodFrom() {
        return getComponent2();
    }

    /**
     * Gets the component 3 (Number To).
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
     * Gets the Number To (component 3).
     * @return the Number To from component 3
     */
    public String getNumberTo() {
        return getComponent3();
    }

    /**
     * Get the Number To (component 3) as Long
     * @return the Number To from component 3 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getNumberToAsLong() {
        return getComponent3AsLong();
    }

    /**
     * Gets the component 4 (Period To).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the Period To (component 4).
     * @return the Period To from component 4
     */
    public String getPeriodTo() {
        return getComponent4();
    }

    /**
     * Set the component 1 (Number From).
     *
     * @param component1 the Number From to set
     * @return the field object to enable build pattern
     */
    public Field38H setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }


    /**
     * Alternative method setter for field's Number From (component 1) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Number From content to set
     * @return the field object to enable build pattern
     */
    public Field38H setComponent1(java.lang.Number component1) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component1 instanceof Long) {
            setComponent(1, SwiftFormatUtils.getLong((Long) component1));
        } else if (component1 instanceof BigInteger || component1 instanceof Integer) {
            setComponent(1, SwiftFormatUtils.getLong(component1.longValue()));
        } else if (component1 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(1, SwiftFormatUtils.getLong(component1.longValue()));
        } else {
            // explicitly set component as null
            setComponent(1, null);
        }
        return this;
    }

    /**
     * Set the Number From (component 1).
     *
     * @param component1 the Number From to set
     * @return the field object to enable build pattern
     */
    public Field38H setNumberFrom(String component1) {
        return setComponent1(component1);
    }

    /**
     * Alternative method setter for field's Number From (component 1) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Number From content to set
     * @return the field object to enable build pattern
     */
    public Field38H setNumberFrom(java.lang.Number component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Period From).
     *
     * @param component2 the Period From to set
     * @return the field object to enable build pattern
     */
    public Field38H setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Period From (component 2).
     *
     * @param component2 the Period From to set
     * @return the field object to enable build pattern
     */
    public Field38H setPeriodFrom(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Number To).
     *
     * @param component3 the Number To to set
     * @return the field object to enable build pattern
     */
    public Field38H setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }


    /**
     * Alternative method setter for field's Number To (component 3) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Number To content to set
     * @return the field object to enable build pattern
     */
    public Field38H setComponent3(java.lang.Number component3) {

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
     * Set the Number To (component 3).
     *
     * @param component3 the Number To to set
     * @return the field object to enable build pattern
     */
    public Field38H setNumberTo(String component3) {
        return setComponent3(component3);
    }

    /**
     * Alternative method setter for field's Number To (component 3) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Number To content to set
     * @return the field object to enable build pattern
     */
    public Field38H setNumberTo(java.lang.Number component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Period To).
     *
     * @param component4 the Period To to set
     * @return the field object to enable build pattern
     */
    public Field38H setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the Period To (component 4).
     *
     * @param component4 the Period To to set
     * @return the field object to enable build pattern
     */
    public Field38H setPeriodTo(String component4) {
        return setComponent4(component4);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field38H.NAME
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
    public static Field38H get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field38H(t);
    }

    /**
     * Gets the first instance of Field38H in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field38H get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field38H in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field38H> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field38H from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field38H> getAll(final SwiftTagListBlock block) {
        final List<Field38H> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field38H(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field38H object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field38H fromJson(final String json) {

        final Field38H field = new Field38H();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Number From

        if (jsonObject.get("numberFrom") != null) {
            field.setComponent1(jsonObject.get("numberFrom").getAsString());
        }

        // **** COMPONENT 2 - Period From

        if (jsonObject.get("periodFrom") != null) {
            field.setComponent2(jsonObject.get("periodFrom").getAsString());
        }

        // **** COMPONENT 3 - Number To

        if (jsonObject.get("numberTo") != null) {
            field.setComponent3(jsonObject.get("numberTo").getAsString());
        }

        // **** COMPONENT 4 - Period To

        if (jsonObject.get("periodTo") != null) {
            field.setComponent4(jsonObject.get("periodTo").getAsString());
        }

        return field;
    }


}
