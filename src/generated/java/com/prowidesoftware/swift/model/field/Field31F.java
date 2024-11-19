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

import java.util.Calendar;

import com.prowidesoftware.swift.model.field.DateContainer;
import com.prowidesoftware.swift.model.field.DateResolver;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 31F.
 * <p>
 * Model and parser for field 31F of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Date: <code>Calendar</code></li>
 * 		<li>Component 2: PeriodDate: <code>Calendar</code></li>
 * 		<li>Component 3: PeriodDetails: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;DATE2&gt;[/&lt;DATE2&gt;][//35x]</code></li>
 * 		<li>parser pattern: <code>&lt;DATE2&gt;[/&lt;DATE2&gt;][//S]</code></li>
 * 		<li>components pattern: <code>EES</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field31F extends Field implements Serializable, DateContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 31F.
	 */
    public static final String NAME = "31F";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_31F = "31F";

	/**
	 * Component number for the Date subfield.
	 */
	public static final Integer DATE = 1;

	/**
	 * Component number for the Period Date subfield.
	 */
	public static final Integer PERIOD_DATE = 2;

	/**
	 * Component number for the Period Details subfield.
	 */
	public static final Integer PERIOD_DETAILS = 3;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field31F() {
        super(3);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field31F(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field31F(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "31F")) {
            throw new IllegalArgumentException("cannot create field 31F from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field31F newInstance(Field31F source) {
        Field31F cp = new Field31F();
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
        init(3);
        setComponent1(SwiftParseUtils.getTokenFirst(value, null, "/"));
        setComponent3(SwiftParseUtils.getTokenSecondLast(value, "//"));
        String toparse = SwiftParseUtils.getTokenFirst(value, "//");
        setComponent2(SwiftParseUtils.getTokenSecondLast(toparse, "/"));
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
        if (getComponent3() != null) {
            result.append("//").append(getComponent3());
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
        if (component < 1 || component > 3) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 31F");
        }
        if (component == 1) {
            //date: [YY]YYMMDD
            java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, notNull(locale));
            java.util.Calendar cal = getComponent1AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
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
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(3);
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
        return "EES";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "<DATE2>[/<DATE2>][//S]";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "<DATE2>[/<DATE2>][//35x]";
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
        return 3;
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
        result.add("Date");
        result.add("Period Date");
        result.add("Period Details");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "date");
        result.put(2, "periodDate");
        result.put(3, "periodDetails");
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
        super.labelMap.put("date", 1);
        super.labelMap.put("perioddate", 2);
        super.labelMap.put("perioddetails", 3);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Date).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Get the component 1 as Calendar
     *
     * @return the component 1 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent1AsCalendar() {
        return SwiftFormatUtils.getDate2(getComponent(1));
    }

    /**
     * Gets the Date (component 1).
     * @return the Date from component 1
     */
    public String getDate() {
        return getComponent1();
    }

    /**
     * Get the Date (component 1) as Calendar
     * @return the Date from component 1 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getDateAsCalendar() {
        return getComponent1AsCalendar();
    }

    /**
     * Gets the component 2 (Period Date).
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
     * Gets the Period Date (component 2).
     * @return the Period Date from component 2
     */
    public String getPeriodDate() {
        return getComponent2();
    }

    /**
     * Get the Period Date (component 2) as Calendar
     * @return the Period Date from component 2 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getPeriodDateAsCalendar() {
        return getComponent2AsCalendar();
    }

    /**
     * Gets the component 3 (Period Details).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Period Details (component 3).
     * @return the Period Details from component 3
     */
    public String getPeriodDetails() {
        return getComponent3();
    }

    /**
     * Set the component 1 (Date).
     *
     * @param component1 the Date to set
     * @return the field object to enable build pattern
     */
    public Field31F setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the component1 from a Calendar object.
     *
     * @param component1 the Calendar with the Date content to set
     * @return the field object to enable build pattern
     */
    public Field31F setComponent1(java.util.Calendar component1) {
        setComponent(1, SwiftFormatUtils.getDate2(component1));
        return this;
    }

    /**
     * Set the Date (component 1).
     *
     * @param component1 the Date to set
     * @return the field object to enable build pattern
     */
    public Field31F setDate(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the Date (component 1) from a Calendar object.
     *
     * @see #setComponent1(java.util.Calendar)
     *
     * @param component1 Calendar with the Date content to set
     * @return the field object to enable build pattern
     */
    public Field31F setDate(java.util.Calendar component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Period Date).
     *
     * @param component2 the Period Date to set
     * @return the field object to enable build pattern
     */
    public Field31F setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Calendar object.
     *
     * @param component2 the Calendar with the Period Date content to set
     * @return the field object to enable build pattern
     */
    public Field31F setComponent2(java.util.Calendar component2) {
        setComponent(2, SwiftFormatUtils.getDate2(component2));
        return this;
    }

    /**
     * Set the Period Date (component 2).
     *
     * @param component2 the Period Date to set
     * @return the field object to enable build pattern
     */
    public Field31F setPeriodDate(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Period Date (component 2) from a Calendar object.
     *
     * @see #setComponent2(java.util.Calendar)
     *
     * @param component2 Calendar with the Period Date content to set
     * @return the field object to enable build pattern
     */
    public Field31F setPeriodDate(java.util.Calendar component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Period Details).
     *
     * @param component3 the Period Details to set
     * @return the field object to enable build pattern
     */
    public Field31F setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Period Details (component 3).
     *
     * @param component3 the Period Details to set
     * @return the field object to enable build pattern
     */
    public Field31F setPeriodDetails(String component3) {
        return setComponent3(component3);
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
     * @return the static value of Field31F.NAME
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
    public static Field31F get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field31F(t);
    }

    /**
     * Gets the first instance of Field31F in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field31F get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field31F in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field31F> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field31F from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field31F> getAll(final SwiftTagListBlock block) {
        final List<Field31F> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field31F(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field31F object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field31F fromJson(final String json) {

        final Field31F field = new Field31F();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Date

        if (jsonObject.get("date") != null) {
            field.setComponent1(jsonObject.get("date").getAsString());
        }

        // **** COMPONENT 2 - Period Date

        if (jsonObject.get("periodDate") != null) {
            field.setComponent2(jsonObject.get("periodDate").getAsString());
        }

        // **** COMPONENT 3 - Period Details

        if (jsonObject.get("periodDetails") != null) {
            field.setComponent3(jsonObject.get("periodDetails").getAsString());
        }

        return field;
    }


}
