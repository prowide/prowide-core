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

import com.prowidesoftware.swift.model.LogicalTerminalAddress;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

import com.prowidesoftware.swift.model.field.DateContainer;
import com.prowidesoftware.swift.model.field.DateResolver;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 260.
 * <p>
 * Model and parser for field 260 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: LTAddress: <code>LogicalTerminalAddress</code></li>
 * 		<li>Component 2: Date: <code>Calendar</code></li>
 * 		<li>Component 3: StartTime: <code>Calendar</code></li>
 * 		<li>Component 4: EndTime: <code>Calendar</code></li>
 * 		<li>Component 5: SessionNumber: <code>Long</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;LT&gt;&lt;DATE2&gt;&lt;HHMM&gt;&lt;HHMM&gt;[4!n]</code></li>
 * 		<li>parser pattern: <code>&lt;LT&gt;&lt;DATE2&gt;&lt;HHMM&gt;&lt;HHMM&gt;[N]</code></li>
 * 		<li>components pattern: <code>ZEHHN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field260 extends Field implements Serializable, DateContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 260.
	 */
    public static final String NAME = "260";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_260 = "260";

	/**
	 * Component number for the LT Address subfield.
	 */
	public static final Integer LT_ADDRESS = 1;

	/**
	 * Component number for the Date subfield.
	 */
	public static final Integer DATE = 2;

	/**
	 * Component number for the Start Time subfield.
	 */
	public static final Integer START_TIME = 3;

	/**
	 * Component number for the End Time subfield.
	 */
	public static final Integer END_TIME = 4;

	/**
	 * Component number for the Session Number subfield.
	 */
	public static final Integer SESSION_NUMBER = 5;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field260() {
        super(5);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field260(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field260(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "260")) {
            throw new IllegalArgumentException("cannot create field 260 from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field260 newInstance(Field260 source) {
        Field260 cp = new Field260();
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
            if (value.length() >= 12) {
                setComponent1(StringUtils.substring(value, 0, 12));
            }
            if (value.length() >= 18) {
                setComponent2(StringUtils.substring(value, 12, 18));
            }
            if (value.length() >= 22) {
                setComponent3(StringUtils.substring(value, 18, 22));
            }
            if (value.length() >= 26) {
                setComponent4(StringUtils.substring(value, 22, 26));
            }
            if (value.length() > 26) {
                setComponent5(StringUtils.substring(value, 26));
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
        append(result, 3);
        append(result, 4);
        append(result, 5);
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 260");
        }
        if (component == 1) {
            //default format (as is)
            return getComponent(1);
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
            //time: HH[mm]
            java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
            java.util.Calendar cal = getComponent3AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
        }
        if (component == 4) {
            //time: HH[mm]
            java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
            java.util.Calendar cal = getComponent4AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
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
        return "ZEHHN";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "<LT><DATE2><HHMM><HHMM>[N]";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "<LT><DATE2><HHMM><HHMM>[4!n]";
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
        result.add("LT Address");
        result.add("Date");
        result.add("Start Time");
        result.add("End Time");
        result.add("Session Number");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "lTAddress");
        result.put(2, "date");
        result.put(3, "startTime");
        result.put(4, "endTime");
        result.put(5, "sessionNumber");
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
        super.labelMap.put("ltaddress", 1);
        super.labelMap.put("date", 2);
        super.labelMap.put("starttime", 3);
        super.labelMap.put("endtime", 4);
        super.labelMap.put("sessionnumber", 5);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (LT Address).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Get the component 1 as LogicalTerminalAddress
     *
     * @return the component 1 converted to LogicalTerminalAddress or null if cannot be converted
     */
    public com.prowidesoftware.swift.model.LogicalTerminalAddress getComponent1AsLogicalTerminalAddress() {
        return SwiftFormatUtils.getLTAddress(getComponent(1));
    }

    /**
     * Gets the LT Address (component 1).
     * @return the LT Address from component 1
     */
    public String getLTAddress() {
        return getComponent1();
    }

    /**
     * Get the LT Address (component 1) as LogicalTerminalAddress
     * @return the LT Address from component 1 converted to LogicalTerminalAddress or null if cannot be converted
     */
    public com.prowidesoftware.swift.model.LogicalTerminalAddress getLTAddressAsLogicalTerminalAddress() {
        return getComponent1AsLogicalTerminalAddress();
    }

    /**
     * Gets the component 2 (Date).
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
     * Gets the Date (component 2).
     * @return the Date from component 2
     */
    public String getDate() {
        return getComponent2();
    }

    /**
     * Get the Date (component 2) as Calendar
     * @return the Date from component 2 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getDateAsCalendar() {
        return getComponent2AsCalendar();
    }

    /**
     * Gets the component 3 (Start Time).
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
     * Gets the Start Time (component 3).
     * @return the Start Time from component 3
     */
    public String getStartTime() {
        return getComponent3();
    }

    /**
     * Get the Start Time (component 3) as Calendar
     * @return the Start Time from component 3 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getStartTimeAsCalendar() {
        return getComponent3AsCalendar();
    }

    /**
     * Gets the component 4 (End Time).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Get the component 4 as Calendar
     *
     * @return the component 4 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent4AsCalendar() {
        return SwiftFormatUtils.getTime3(getComponent(4));
    }

    /**
     * Gets the End Time (component 4).
     * @return the End Time from component 4
     */
    public String getEndTime() {
        return getComponent4();
    }

    /**
     * Get the End Time (component 4) as Calendar
     * @return the End Time from component 4 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getEndTimeAsCalendar() {
        return getComponent4AsCalendar();
    }

    /**
     * Gets the component 5 (Session Number).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Get the component 5 as Long
     *
     * @return the component 5 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent5AsLong() {
        return SwiftFormatUtils.getLong(getComponent(5));
    }

    /**
     * Gets the Session Number (component 5).
     * @return the Session Number from component 5
     */
    public String getSessionNumber() {
        return getComponent5();
    }

    /**
     * Get the Session Number (component 5) as Long
     * @return the Session Number from component 5 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getSessionNumberAsLong() {
        return getComponent5AsLong();
    }

    /**
     * Set the component 1 (LT Address).
     *
     * @param component1 the LT Address to set
     * @return the field object to enable build pattern
     */
    public Field260 setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the component1 from a LogicalTerminalAddress object.
     *
     * @param component1 the LogicalTerminalAddress with the LT Address content to set
     * @return the field object to enable build pattern
     */
    public Field260 setComponent1(com.prowidesoftware.swift.model.LogicalTerminalAddress component1) {
        setComponent(1, SwiftFormatUtils.getLTAddress(component1));
        return this;
    }

    /**
     * Set the LT Address (component 1).
     *
     * @param component1 the LT Address to set
     * @return the field object to enable build pattern
     */
    public Field260 setLTAddress(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the LT Address (component 1) from a LogicalTerminalAddress object.
     *
     * @see #setComponent1(com.prowidesoftware.swift.model.LogicalTerminalAddress)
     *
     * @param component1 LogicalTerminalAddress with the LT Address content to set
     * @return the field object to enable build pattern
     */
    public Field260 setLTAddress(com.prowidesoftware.swift.model.LogicalTerminalAddress component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Date).
     *
     * @param component2 the Date to set
     * @return the field object to enable build pattern
     */
    public Field260 setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Calendar object.
     *
     * @param component2 the Calendar with the Date content to set
     * @return the field object to enable build pattern
     */
    public Field260 setComponent2(java.util.Calendar component2) {
        setComponent(2, SwiftFormatUtils.getDate2(component2));
        return this;
    }

    /**
     * Set the Date (component 2).
     *
     * @param component2 the Date to set
     * @return the field object to enable build pattern
     */
    public Field260 setDate(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Date (component 2) from a Calendar object.
     *
     * @see #setComponent2(java.util.Calendar)
     *
     * @param component2 Calendar with the Date content to set
     * @return the field object to enable build pattern
     */
    public Field260 setDate(java.util.Calendar component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Start Time).
     *
     * @param component3 the Start Time to set
     * @return the field object to enable build pattern
     */
    public Field260 setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a Calendar object.
     *
     * @param component3 the Calendar with the Start Time content to set
     * @return the field object to enable build pattern
     */
    public Field260 setComponent3(java.util.Calendar component3) {
        setComponent(3, SwiftFormatUtils.getTime3(component3));
        return this;
    }

    /**
     * Set the Start Time (component 3).
     *
     * @param component3 the Start Time to set
     * @return the field object to enable build pattern
     */
    public Field260 setStartTime(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Start Time (component 3) from a Calendar object.
     *
     * @see #setComponent3(java.util.Calendar)
     *
     * @param component3 Calendar with the Start Time content to set
     * @return the field object to enable build pattern
     */
    public Field260 setStartTime(java.util.Calendar component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (End Time).
     *
     * @param component4 the End Time to set
     * @return the field object to enable build pattern
     */
    public Field260 setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component4 from a Calendar object.
     *
     * @param component4 the Calendar with the End Time content to set
     * @return the field object to enable build pattern
     */
    public Field260 setComponent4(java.util.Calendar component4) {
        setComponent(4, SwiftFormatUtils.getTime3(component4));
        return this;
    }

    /**
     * Set the End Time (component 4).
     *
     * @param component4 the End Time to set
     * @return the field object to enable build pattern
     */
    public Field260 setEndTime(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the End Time (component 4) from a Calendar object.
     *
     * @see #setComponent4(java.util.Calendar)
     *
     * @param component4 Calendar with the End Time content to set
     * @return the field object to enable build pattern
     */
    public Field260 setEndTime(java.util.Calendar component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Session Number).
     *
     * @param component5 the Session Number to set
     * @return the field object to enable build pattern
     */
    public Field260 setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }


    /**
     * Alternative method setter for field's Session Number (component 5) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component5 the Number with the Session Number content to set
     * @return the field object to enable build pattern
     */
    public Field260 setComponent5(java.lang.Number component5) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component5 instanceof Long) {
            setComponent(5, SwiftFormatUtils.getLong((Long) component5));
        } else if (component5 instanceof BigInteger || component5 instanceof Integer) {
            setComponent(5, SwiftFormatUtils.getLong(component5.longValue()));
        } else if (component5 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(5, SwiftFormatUtils.getLong(component5.longValue()));
        } else {
            // explicitly set component as null
            setComponent(5, null);
        }
        return this;
    }

    /**
     * Set the Session Number (component 5).
     *
     * @param component5 the Session Number to set
     * @return the field object to enable build pattern
     */
    public Field260 setSessionNumber(String component5) {
        return setComponent5(component5);
    }

    /**
     * Alternative method setter for field's Session Number (component 5) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component5 the Number with the Session Number content to set
     * @return the field object to enable build pattern
     */
    public Field260 setSessionNumber(java.lang.Number component5) {
        return setComponent5(component5);
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
     * @return the static value of Field260.NAME
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
    public static Field260 get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field260(t);
    }

    /**
     * Gets the first instance of Field260 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field260 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field260 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field260> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field260 from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field260> getAll(final SwiftTagListBlock block) {
        final List<Field260> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field260(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field260 object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field260 fromJson(final String json) {

        final Field260 field = new Field260();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - LT Address

        if (jsonObject.get("lTAddress") != null) {
            field.setComponent1(jsonObject.get("lTAddress").getAsString());
        }

        // **** COMPONENT 2 - Date

        if (jsonObject.get("date") != null) {
            field.setComponent2(jsonObject.get("date").getAsString());
        }

        // **** COMPONENT 3 - Start Time

        if (jsonObject.get("startTime") != null) {
            field.setComponent3(jsonObject.get("startTime").getAsString());
        }

        // **** COMPONENT 4 - End Time

        if (jsonObject.get("endTime") != null) {
            field.setComponent4(jsonObject.get("endTime").getAsString());
        }

        // **** COMPONENT 5 - Session Number

        if (jsonObject.get("sessionNumber") != null) {
            field.setComponent5(jsonObject.get("sessionNumber").getAsString());
        }

        return field;
    }


}
