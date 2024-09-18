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
import java.util.Calendar;


import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 14S.
 * <p>
 * Model and parser for field 14S of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Source: <code>String</code></li>
 * 		<li>Component 2: Number: <code>Long</code></li>
 * 		<li>Component 3: Time: <code>Calendar</code></li>
 * 		<li>Component 4: Location: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>3!a2!n[/&lt;HHMM&gt;/4!c]</code></li>
 * 		<li>parser pattern: <code>SN[/&lt;HHMM&gt;/S]</code></li>
 * 		<li>components pattern: <code>SNHS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field14S extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 14S.
	 */
    public static final String NAME = "14S";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_14S = "14S";

	/**
	 * Component number for the Source subfield.
	 */
	public static final Integer SOURCE = 1;

	/**
	 * Component number for the Number subfield.
	 */
	public static final Integer NUMBER = 2;

	/**
	 * Component number for the Time subfield.
	 */
	public static final Integer TIME = 3;

	/**
	 * Component number for the Location subfield.
	 */
	public static final Integer LOCATION = 4;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field14S() {
        super(4);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field14S(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field14S(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "14S")) {
            throw new IllegalArgumentException("cannot create field 14S from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field14S newInstance(Field14S source) {
        Field14S cp = new Field14S();
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
        if (value != null) {
            String left;
            String right = null;
            if (value.indexOf('/') >= 0) {
                left = SwiftParseUtils.getTokenFirst(value, "/");
                right = SwiftParseUtils.getTokenSecondLast(value, "/");
            } else {
                left = value;
            }
            setComponent1(SwiftParseUtils.getAlphaPrefix(left));
            final String second = getComponent1() == null ? left : StringUtils.substringAfter(left, getComponent1());
            setComponent2(second);
            if (right != null) {
                setComponent3(SwiftParseUtils.getTokenFirst(right, "/"));
                setComponent4(SwiftParseUtils.getTokenSecondLast(right, "/"));
            }
        }
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        append(result, 1);
        append(result, 2);
        if (getComponent3() != null || getComponent4() != null) {
            result.append("/");
            append(result, 3);
            result.append("/");
            append(result, 4);
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
        if (component < 1 || component > 4) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 14S");
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
            //time: HH[mm]
            java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
            java.util.Calendar cal = getComponent3AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
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
        return "SNHS";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "SN[/<HHMM>/S]";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "3!a2!n[/<HHMM>/4!c]";
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
        result.add("Source");
        result.add("Number");
        result.add("Time");
        result.add("Location");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "source");
        result.put(2, "number");
        result.put(3, "time");
        result.put(4, "location");
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
        super.labelMap.put("source", 1);
        super.labelMap.put("number", 2);
        super.labelMap.put("time", 3);
        super.labelMap.put("location", 4);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Source).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Source (component 1).
     * @return the Source from component 1
     */
    public String getSource() {
        return getComponent1();
    }

    /**
     * Gets the component 2 (Number).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Get the component 2 as Long
     *
     * @return the component 2 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent2AsLong() {
        return SwiftFormatUtils.getLong(getComponent(2));
    }

    /**
     * Gets the Number (component 2).
     * @return the Number from component 2
     */
    public String getNumber() {
        return getComponent2();
    }

    /**
     * Get the Number (component 2) as Long
     * @return the Number from component 2 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getNumberAsLong() {
        return getComponent2AsLong();
    }

    /**
     * Gets the component 3 (Time).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Get the component 3 as Calendar
     *
     * @return the component 3 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent3AsCalendar() {
        return SwiftFormatUtils.getTime3(getComponent(3));
    }

    /**
     * Gets the Time (component 3).
     * @return the Time from component 3
     */
    public String getTime() {
        return getComponent3();
    }

    /**
     * Get the Time (component 3) as Calendar
     * @return the Time from component 3 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getTimeAsCalendar() {
        return getComponent3AsCalendar();
    }

    /**
     * Gets the component 4 (Location).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the Location (component 4).
     * @return the Location from component 4
     */
    public String getLocation() {
        return getComponent4();
    }

    /**
     * Set the component 1 (Source).
     *
     * @param component1 the Source to set
     * @return the field object to enable build pattern
     */
    public Field14S setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Source (component 1).
     *
     * @param component1 the Source to set
     * @return the field object to enable build pattern
     */
    public Field14S setSource(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Number).
     *
     * @param component2 the Number to set
     * @return the field object to enable build pattern
     */
    public Field14S setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }


    /**
     * Alternative method setter for field's Number (component 2) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the Number content to set
     * @return the field object to enable build pattern
     */
    public Field14S setComponent2(java.lang.Number component2) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component2 instanceof Long) {
            setComponent(2, SwiftFormatUtils.getLong((Long) component2));
        } else if (component2 instanceof BigInteger || component2 instanceof Integer) {
            setComponent(2, SwiftFormatUtils.getLong(component2.longValue()));
        } else if (component2 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(2, SwiftFormatUtils.getLong(component2.longValue()));
        } else {
            // explicitly set component as null
            setComponent(2, null);
        }
        return this;
    }

    /**
     * Set the Number (component 2).
     *
     * @param component2 the Number to set
     * @return the field object to enable build pattern
     */
    public Field14S setNumber(String component2) {
        return setComponent2(component2);
    }

    /**
     * Alternative method setter for field's Number (component 2) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the Number content to set
     * @return the field object to enable build pattern
     */
    public Field14S setNumber(java.lang.Number component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Time).
     *
     * @param component3 the Time to set
     * @return the field object to enable build pattern
     */
    public Field14S setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a Calendar object.
     *
     * @param component3 the Calendar with the Time content to set
     * @return the field object to enable build pattern
     */
    public Field14S setComponent3(java.util.Calendar component3) {
        setComponent(3, SwiftFormatUtils.getTime3(component3));
        return this;
    }

    /**
     * Set the Time (component 3).
     *
     * @param component3 the Time to set
     * @return the field object to enable build pattern
     */
    public Field14S setTime(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Time (component 3) from a Calendar object.
     *
     * @see #setComponent3(java.util.Calendar)
     *
     * @param component3 Calendar with the Time content to set
     * @return the field object to enable build pattern
     */
    public Field14S setTime(java.util.Calendar component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Location).
     *
     * @param component4 the Location to set
     * @return the field object to enable build pattern
     */
    public Field14S setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the Location (component 4).
     *
     * @param component4 the Location to set
     * @return the field object to enable build pattern
     */
    public Field14S setLocation(String component4) {
        return setComponent4(component4);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field14S.NAME
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
    public static Field14S get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field14S(t);
    }

    /**
     * Gets the first instance of Field14S in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field14S get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field14S in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field14S> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field14S from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field14S> getAll(final SwiftTagListBlock block) {
        final List<Field14S> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field14S(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field14S object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field14S fromJson(final String json) {

        final Field14S field = new Field14S();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Source

        if (jsonObject.get("source") != null) {
            field.setComponent1(jsonObject.get("source").getAsString());
        }

        // **** COMPONENT 2 - Number

        if (jsonObject.get("number") != null) {
            field.setComponent2(jsonObject.get("number").getAsString());
        }

        // **** COMPONENT 3 - Time

        if (jsonObject.get("time") != null) {
            field.setComponent3(jsonObject.get("time").getAsString());
        }

        // **** COMPONENT 4 - Location

        if (jsonObject.get("location") != null) {
            field.setComponent4(jsonObject.get("location").getAsString());
        }

        return field;
    }

	/**
	 * Gets the Rate Source (components 1 and 2) as a unit
	 * @return the concatenated values of component 1 and 2
     * @since 9.2.7
	 */
	public String getRateSource() {
        final StringBuilder result = new StringBuilder();
        append(result, 1);
        append(result, 2);
        return result.toString();
	}

	/**
	 * Sets the Rate Source (components 1 and 2) as a unit
	 * @param rateSource the new expected value for components 1 and 2 concatenated
     * @return the field object to enable build pattern
     * @since 9.2.7
	 */
	public Field14S setRateSource(String rateSource) {

        // get the parts
        String source = SwiftParseUtils.getAlphaPrefix(rateSource);
        String number = source == null ? rateSource : StringUtils.substringAfter(rateSource, source);

        // set the values
        setComponent1(StringUtils.trimToNull(source));
        setComponent2(StringUtils.trimToNull(number));

        return this;
	}

	/**
	 * Gets the Time And Location (components 3 and 4) as a unit
	 * @return the concatenated values of component 3 and 4 with the separating "/"
     * @since 9.2.7
	 */
	public String getTimeAndLocation() {

        // if both empty => just nothing
        if (StringUtils.isBlank(getComponent3()) && StringUtils.isBlank(getComponent4())) {
            return null;
        }

        // build
        final StringBuilder result = new StringBuilder();
        result.append("/");
        append(result, 3);
        result.append("/");
        append(result, 4);
        return result.toString();
	}

	/**
	 * Sets the Time And Location (components 3 and 4) as a unit
	 * @param timeAndLocation the new expected value for components 3 and 4 concatenated, including "/
     * @return the field object to enable build pattern
     * @since 9.2.7
	 */
	public Field14S setTimeAndLocation(String timeAndLocation) {

        // get the parts
        String time = null;
        String location = null;
        if (StringUtils.indexOf(timeAndLocation, '/') != -1) {

            // get the parts and
            timeAndLocation = SwiftParseUtils.removePrefix(timeAndLocation, "/");
            time = SwiftParseUtils.getTokenFirst(timeAndLocation, "/");
            location = SwiftParseUtils.getTokenSecond(timeAndLocation, "/");
        }

        // set the new component values
        setComponent3(StringUtils.trimToNull(time));
        setComponent4(StringUtils.trimToNull(location));

        return this;
	}

}
