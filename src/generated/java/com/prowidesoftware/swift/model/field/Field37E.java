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

import com.prowidesoftware.swift.model.field.AmountContainer;
import com.prowidesoftware.swift.model.field.AmountResolver;
import com.prowidesoftware.swift.model.field.DateContainer;
import com.prowidesoftware.swift.model.field.DateResolver;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 37E.
 * <p>
 * Model and parser for field 37E of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Rate: <code>BigDecimal</code></li>
 * 		<li>Component 2: EndDate: <code>Calendar</code></li>
 * 		<li>Component 3: Period: <code>String</code></li>
 * 		<li>Component 4: Number: <code>Long</code></li>
 * 		<li>Component 5: Information: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;AMOUNT&gt;12[//&lt;DATE2&gt;&lt;DM&gt;3n][/16x]</code></li>
 * 		<li>parser pattern: <code>N[//&lt;DATE2&gt;cS][/S]</code></li>
 * 		<li>components pattern: <code>NESNS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field37E extends Field implements Serializable, AmountContainer, DateContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 37E.
	 */
    public static final String NAME = "37E";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_37E = "37E";

	/**
	 * Component number for the Rate subfield.
	 */
	public static final Integer RATE = 1;

	/**
	 * Component number for the End Date subfield.
	 */
	public static final Integer END_DATE = 2;


	/**
	 * Component number for the Period subfield.
	 */
	public static final Integer PERIOD = 3;


	/**
	 * Component number for the Number subfield.
	 */
	public static final Integer NUMBER = 4;


	/**
	 * Component number for the Information subfield.
	 */
	public static final Integer INFORMATION = 5;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field37E() {
        super(5);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field37E(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field37E(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "37E")) {
            throw new IllegalArgumentException("cannot create field 37E from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field37E newInstance(Field37E source) {
        Field37E cp = new Field37E();
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
        setComponent1(SwiftParseUtils.getTokenFirst(value, "//"));
        String toparse = SwiftParseUtils.getTokenSecondLast(value, "//");
        if (toparse != null) {
            if (toparse.length() >= 6) {
                setComponent2(StringUtils.substring(toparse, 0, 6));
            }
            if (toparse.length() >= 7) {
                setComponent3(StringUtils.substring(toparse, 6, 7));
            }
            if (toparse.length() > 7) {
                String toparse2 = StringUtils.substring(toparse, 7);
                setComponent4(SwiftParseUtils.getTokenFirst(toparse2, "/"));
                setComponent5(SwiftParseUtils.getTokenSecondLast(toparse2, "/"));
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
        if (getComponent2() != null || getComponent3() != null || getComponent4() != null) {
            result.append("//");
            append(result, 2);
            append(result, 3);
            append(result, 4);
        }
        if (getComponent5() != null) {
            result.append("/").append(getComponent5());
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
        if (component < 1 || component > 5) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 37E");
        }
        if (component == 1) {
            //amount, rate
            java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
            f.setMaximumFractionDigits(13);
            BigDecimal n = getComponent1AsBigDecimal();
            if (n != null) {
                return f.format(n);
            }
        }
        if (component == 2) {
            //date: [YY]YYMMDD
            java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, notNull(locale));
            java.util.Calendar cal = getComponent2AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
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
        return "IESNS";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "N[//<DATE2>cS][/S]";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "<AMOUNT>12[//<DATE2><DM>3n][/16x]";
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
        result.add("Rate");
        result.add("End Date");
        result.add("Period");
        result.add("Number");
        result.add("Information");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "rate");
        result.put(2, "endDate");
        result.put(3, "period");
        result.put(4, "number");
        result.put(5, "information");
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
        super.labelMap.put("rate", 1);
        super.labelMap.put("enddate", 2);
        // alias name
        super.labelMap.put("date", 2);
        super.labelMap.put("period", 3);
        // alias name
        super.labelMap.put("dmmark", 3);
        super.labelMap.put("number", 4);
        // alias name
        super.labelMap.put("numberofdaysmonths", 4);
        super.labelMap.put("information", 5);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Rate).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Get the component 1 as BigDecimal
     *
     * @return the component 1 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getComponent1AsBigDecimal() {
        return SwiftFormatUtils.getBigDecimal(getComponent(1));
    }

    /**
     * Gets the Rate (component 1).
     * @return the Rate from component 1
     */
    public String getRate() {
        return getComponent1();
    }

    /**
     * Get the Rate (component 1) as BigDecimal
     * @return the Rate from component 1 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getRateAsBigDecimal() {
        return getComponent1AsBigDecimal();
    }

    /**
     * Gets the component 2 (End Date).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Get the component 2 as Calendar
     *
     * @return the component 2 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent2AsCalendar() {
        return SwiftFormatUtils.getDate2(getComponent(2));
    }

    /**
     * Gets the End Date (component 2).
     * @return the End Date from component 2
     */
    public String getEndDate() {
        return getComponent2();
    }


    /**
     * Get the End Date (component 2) as Calendar
     * @return the End Date from component 2 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getEndDateAsCalendar() {
        return getComponent2AsCalendar();
    }

    /**
     * Gets the component 3 (Period).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Period (component 3).
     * @return the Period from component 3
     */
    public String getPeriod() {
        return getComponent3();
    }


    /**
     * Gets the component 4 (Number).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Get the component 4 as Long
     *
     * @return the component 4 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent4AsLong() {
        return SwiftFormatUtils.getLong(getComponent(4));
    }

    /**
     * Gets the Number (component 4).
     * @return the Number from component 4
     */
    public String getNumber() {
        return getComponent4();
    }


    /**
     * Get the Number (component 4) as Long
     * @return the Number from component 4 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getNumberAsLong() {
        return getComponent4AsLong();
    }

    /**
     * Gets the component 5 (Information).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Gets the Information (component 5).
     * @return the Information from component 5
     */
    public String getInformation() {
        return getComponent5();
    }

    /**
     * Set the component 1 (Rate).
     *
     * @param component1 the Rate to set
     * @return the field object to enable build pattern
     */
    public Field37E setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Alternative method setter for field's Rate (component 1) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10.0 becomes an Float)
     *
     * @param component1 the Number with the Rate content to set
     * @return the field object to enable build pattern
     */
    public Field37E setComponent1(java.lang.Number component1) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component1 instanceof BigDecimal) {
            setComponent(1, SwiftFormatUtils.getBigDecimal((BigDecimal) component1));
        } else if (component1 instanceof BigInteger) {
            setComponent(1, SwiftFormatUtils.getBigDecimal(new BigDecimal((BigInteger) component1)));
        } else if (component1 instanceof Long || component1 instanceof Integer) {
            setComponent(1, SwiftFormatUtils.getBigDecimal(BigDecimal.valueOf(component1.longValue())));
        } else if (component1 != null) {
            // it's other non-null Number (Float, Double, etc...)
            setComponent(1, SwiftFormatUtils.getBigDecimal(BigDecimal.valueOf(component1.doubleValue())));
        } else {
            // explicitly set component as null
            setComponent(1, null);
        }
        return this;
    }

    /**
     * Set the Rate (component 1).
     *
     * @param component1 the Rate to set
     * @return the field object to enable build pattern
     */
    public Field37E setRate(String component1) {
        return setComponent1(component1);
    }

    /**
     * Alternative method setter for field's Rate (component 1) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Rate content to set
     * @return the field object to enable build pattern
     */
    public Field37E setRate(java.lang.Number component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (End Date).
     *
     * @param component2 the End Date to set
     * @return the field object to enable build pattern
     */
    public Field37E setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Calendar object.
     *
     * @param component2 the Calendar with the End Date content to set
     * @return the field object to enable build pattern
     */
    public Field37E setComponent2(java.util.Calendar component2) {
        setComponent(2, SwiftFormatUtils.getDate2(component2));
        return this;
    }

    /**
     * Set the End Date (component 2).
     *
     * @param component2 the End Date to set
     * @return the field object to enable build pattern
     */
    public Field37E setEndDate(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the End Date (component 2) from a Calendar object.
     *
     * @see #setComponent2(java.util.Calendar)
     *
     * @param component2 Calendar with the End Date content to set
     * @return the field object to enable build pattern
     */
    public Field37E setEndDate(java.util.Calendar component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Period).
     *
     * @param component3 the Period to set
     * @return the field object to enable build pattern
     */
    public Field37E setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Period (component 3).
     *
     * @param component3 the Period to set
     * @return the field object to enable build pattern
     */
    public Field37E setPeriod(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Number).
     *
     * @param component4 the Number to set
     * @return the field object to enable build pattern
     */
    public Field37E setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }


    /**
     * Alternative method setter for field's Number (component 4) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Number content to set
     * @return the field object to enable build pattern
     */
    public Field37E setComponent4(java.lang.Number component4) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component4 instanceof Long) {
            setComponent(4, SwiftFormatUtils.getLong((Long) component4));
        } else if (component4 instanceof BigInteger || component4 instanceof Integer) {
            setComponent(4, SwiftFormatUtils.getLong(component4.longValue()));
        } else if (component4 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(4, SwiftFormatUtils.getLong(component4.longValue()));
        } else {
            // explicitly set component as null
            setComponent(4, null);
        }
        return this;
    }

    /**
     * Set the Number (component 4).
     *
     * @param component4 the Number to set
     * @return the field object to enable build pattern
     */
    public Field37E setNumber(String component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative method setter for field's Number (component 4) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Number content to set
     * @return the field object to enable build pattern
     */
    public Field37E setNumber(java.lang.Number component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Information).
     *
     * @param component5 the Information to set
     * @return the field object to enable build pattern
     */
    public Field37E setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the Information (component 5).
     *
     * @param component5 the Information to set
     * @return the field object to enable build pattern
     */
    public Field37E setInformation(String component5) {
        return setComponent5(component5);
    }


    /**
     * Returns the list of all NON-NULL amounts as BigDecimal
     *
     * @return the list of NON-NULL amounts as BigDecimal values
     * @see AmountResolver#amounts(Field)
     */
    public List<BigDecimal> amounts() {
        return AmountResolver.amounts(this);
    }

    /**
     * Returns the first amounts as BigDecimal
     *
     * @return the first amount as BigDecimal value. Can be null
     * @see AmountResolver#amount(Field)
     */
    @Override
    public BigDecimal amount() {
        return AmountResolver.amount(this);
    }

    /**
     * Returns all components that can be converted to a Calendar
     *
     * @return the list of converted components (a Calendar object or null)
     */
    @Override
    public List<Calendar> dates() {
        return DateResolver.dates(this);
    }

    /**
     * Returns the first component that can be converted to a Calendar
     *
     * @return the converted components (a Calendar object or null)
     */
    public Calendar date() {
        return DateResolver.date(this);
    }


    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field37E.NAME
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
    public static Field37E get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field37E(t);
    }

    /**
     * Gets the first instance of Field37E in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field37E get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field37E in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field37E> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field37E from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field37E> getAll(final SwiftTagListBlock block) {
        final List<Field37E> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field37E(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field37E object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field37E fromJson(final String json) {

        final Field37E field = new Field37E();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Rate

        if (jsonObject.get("rate") != null) {
            field.setComponent1(jsonObject.get("rate").getAsString());
        }

        // **** COMPONENT 2 - End Date

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("date") != null) {
            field.setComponent2(jsonObject.get("date").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("endDate") != null) {
            field.setComponent2(jsonObject.get("endDate").getAsString());
        }

        // **** COMPONENT 3 - Period

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("dMMark") != null) {
            field.setComponent3(jsonObject.get("dMMark").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("period") != null) {
            field.setComponent3(jsonObject.get("period").getAsString());
        }

        // **** COMPONENT 4 - Number

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("numberofDaysMonths") != null) {
            field.setComponent4(jsonObject.get("numberofDaysMonths").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("number") != null) {
            field.setComponent4(jsonObject.get("number").getAsString());
        }

        // **** COMPONENT 5 - Information

        if (jsonObject.get("information") != null) {
            field.setComponent5(jsonObject.get("information").getAsString());
        }

        return field;
    }


}
