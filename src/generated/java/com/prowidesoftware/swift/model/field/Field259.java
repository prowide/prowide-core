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
 * SWIFT MT Field 259.
 * <p>
 * Model and parser for field 259 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: LTAddress: <code>LogicalTerminalAddress</code></li>
 * 		<li>Component 2: SessionNumber: <code>Long</code></li>
 * 		<li>Component 3: MessageCategory: <code>Long</code></li>
 * 		<li>Component 4: Date: <code>Calendar</code></li>
 * 		<li>Component 5: StartTime: <code>Calendar</code></li>
 * 		<li>Component 6: EndTime: <code>Calendar</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;LT&gt;4!n1!n&lt;DATE2&gt;&lt;HHMM&gt;&lt;HHMM&gt;</code></li>
 * 		<li>parser pattern: <code>&lt;LT&gt;4!Nc&lt;DATE2&gt;&lt;HHMM&gt;&lt;HHMM&gt;</code></li>
 * 		<li>components pattern: <code>ZNNEHH</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field259 extends Field implements Serializable, DateContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 259.
	 */
    public static final String NAME = "259";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_259 = "259";

	/**
	 * Component number for the LT Address subfield.
	 */
	public static final Integer LT_ADDRESS = 1;

	/**
	 * Component number for the Session Number subfield.
	 */
	public static final Integer SESSION_NUMBER = 2;

	/**
	 * Component number for the Message Category subfield.
	 */
	public static final Integer MESSAGE_CATEGORY = 3;

	/**
	 * Component number for the Date subfield.
	 */
	public static final Integer DATE = 4;

	/**
	 * Component number for the Start Time subfield.
	 */
	public static final Integer START_TIME = 5;

	/**
	 * Component number for the End Time subfield.
	 */
	public static final Integer END_TIME = 6;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field259() {
        super(6);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field259(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field259(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "259")) {
            throw new IllegalArgumentException("cannot create field 259 from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field259 newInstance(Field259 source) {
        Field259 cp = new Field259();
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
        init(6);
        if (value != null) {
            if (value.length() >= 12) {
                setComponent1(StringUtils.substring(value, 0, 12));
            }
            if (value.length() >= 16) {
                setComponent2(StringUtils.substring(value, 12, 16));
            }
            if (value.length() >= 17) {
                setComponent3(StringUtils.substring(value, 16, 17));
            }
            if (value.length() >= 23) {
                setComponent4(StringUtils.substring(value, 17, 23));
            }
            if (value.length() >= 27) {
                setComponent5(StringUtils.substring(value, 23, 27));
            }
            if (value.length() > 27) {
                setComponent6(StringUtils.substring(value, 27));
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
        if (component < 1 || component > 6) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 259");
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
            //date: [YY]YYMMDD
            java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, notNull(locale));
            java.util.Calendar cal = getComponent4AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
        }
        if (component == 5) {
            //time: HH[mm]
            java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
            java.util.Calendar cal = getComponent5AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
        }
        // This is the last component, return directly without `if`
        //time: HH[mm]
        java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
        java.util.Calendar cal = getComponent6AsCalendar();
        if (cal != null) {
            return f.format(cal.getTime());
        }
        return null;
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
        return "ZNNEHH";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "<LT>4!Nc<DATE2><HHMM><HHMM>";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "<LT>4!n1!n<DATE2><HHMM><HHMM>";
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
        return 6;
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
        result.add("Session Number");
        result.add("Message Category");
        result.add("Date");
        result.add("Start Time");
        result.add("End Time");
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
        result.put(2, "sessionNumber");
        result.put(3, "messageCategory");
        result.put(4, "date");
        result.put(5, "startTime");
        result.put(6, "endTime");
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
        super.labelMap.put("sessionnumber", 2);
        super.labelMap.put("messagecategory", 3);
        super.labelMap.put("date", 4);
        super.labelMap.put("starttime", 5);
        super.labelMap.put("endtime", 6);
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
     * Gets the component 2 (Session Number).
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
     * Gets the Session Number (component 2).
     * @return the Session Number from component 2
     */
    public String getSessionNumber() {
        return getComponent2();
    }

    /**
     * Get the Session Number (component 2) as Long
     * @return the Session Number from component 2 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getSessionNumberAsLong() {
        return getComponent2AsLong();
    }

    /**
     * Gets the component 3 (Message Category).
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
     * Gets the Message Category (component 3).
     * @return the Message Category from component 3
     */
    public String getMessageCategory() {
        return getComponent3();
    }

    /**
     * Get the Message Category (component 3) as Long
     * @return the Message Category from component 3 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getMessageCategoryAsLong() {
        return getComponent3AsLong();
    }

    /**
     * Gets the component 4 (Date).
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
        return SwiftFormatUtils.getDate2(getComponent(4));
    }

    /**
     * Gets the Date (component 4).
     * @return the Date from component 4
     */
    public String getDate() {
        return getComponent4();
    }

    /**
     * Get the Date (component 4) as Calendar
     * @return the Date from component 4 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getDateAsCalendar() {
        return getComponent4AsCalendar();
    }

    /**
     * Gets the component 5 (Start Time).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Get the component 5 as Calendar
     *
     * @return the component 5 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent5AsCalendar() {
        return SwiftFormatUtils.getTime3(getComponent(5));
    }

    /**
     * Gets the Start Time (component 5).
     * @return the Start Time from component 5
     */
    public String getStartTime() {
        return getComponent5();
    }

    /**
     * Get the Start Time (component 5) as Calendar
     * @return the Start Time from component 5 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getStartTimeAsCalendar() {
        return getComponent5AsCalendar();
    }

    /**
     * Gets the component 6 (End Time).
     * @return the component 6
     */
    public String getComponent6() {
        return getComponent(6);
    }

    /**
     * Get the component 6 as Calendar
     *
     * @return the component 6 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent6AsCalendar() {
        return SwiftFormatUtils.getTime3(getComponent(6));
    }

    /**
     * Gets the End Time (component 6).
     * @return the End Time from component 6
     */
    public String getEndTime() {
        return getComponent6();
    }

    /**
     * Get the End Time (component 6) as Calendar
     * @return the End Time from component 6 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getEndTimeAsCalendar() {
        return getComponent6AsCalendar();
    }

    /**
     * Set the component 1 (LT Address).
     *
     * @param component1 the LT Address to set
     * @return the field object to enable build pattern
     */
    public Field259 setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the component1 from a LogicalTerminalAddress object.
     *
     * @param component1 the LogicalTerminalAddress with the LT Address content to set
     * @return the field object to enable build pattern
     */
    public Field259 setComponent1(com.prowidesoftware.swift.model.LogicalTerminalAddress component1) {
        setComponent(1, SwiftFormatUtils.getLTAddress(component1));
        return this;
    }

    /**
     * Set the LT Address (component 1).
     *
     * @param component1 the LT Address to set
     * @return the field object to enable build pattern
     */
    public Field259 setLTAddress(String component1) {
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
    public Field259 setLTAddress(com.prowidesoftware.swift.model.LogicalTerminalAddress component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Session Number).
     *
     * @param component2 the Session Number to set
     * @return the field object to enable build pattern
     */
    public Field259 setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }


    /**
     * Alternative method setter for field's Session Number (component 2) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the Session Number content to set
     * @return the field object to enable build pattern
     */
    public Field259 setComponent2(java.lang.Number component2) {

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
     * Set the Session Number (component 2).
     *
     * @param component2 the Session Number to set
     * @return the field object to enable build pattern
     */
    public Field259 setSessionNumber(String component2) {
        return setComponent2(component2);
    }

    /**
     * Alternative method setter for field's Session Number (component 2) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the Session Number content to set
     * @return the field object to enable build pattern
     */
    public Field259 setSessionNumber(java.lang.Number component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Message Category).
     *
     * @param component3 the Message Category to set
     * @return the field object to enable build pattern
     */
    public Field259 setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }


    /**
     * Alternative method setter for field's Message Category (component 3) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Message Category content to set
     * @return the field object to enable build pattern
     */
    public Field259 setComponent3(java.lang.Number component3) {

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
     * Set the Message Category (component 3).
     *
     * @param component3 the Message Category to set
     * @return the field object to enable build pattern
     */
    public Field259 setMessageCategory(String component3) {
        return setComponent3(component3);
    }

    /**
     * Alternative method setter for field's Message Category (component 3) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Message Category content to set
     * @return the field object to enable build pattern
     */
    public Field259 setMessageCategory(java.lang.Number component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Date).
     *
     * @param component4 the Date to set
     * @return the field object to enable build pattern
     */
    public Field259 setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component4 from a Calendar object.
     *
     * @param component4 the Calendar with the Date content to set
     * @return the field object to enable build pattern
     */
    public Field259 setComponent4(java.util.Calendar component4) {
        setComponent(4, SwiftFormatUtils.getDate2(component4));
        return this;
    }

    /**
     * Set the Date (component 4).
     *
     * @param component4 the Date to set
     * @return the field object to enable build pattern
     */
    public Field259 setDate(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the Date (component 4) from a Calendar object.
     *
     * @see #setComponent4(java.util.Calendar)
     *
     * @param component4 Calendar with the Date content to set
     * @return the field object to enable build pattern
     */
    public Field259 setDate(java.util.Calendar component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Start Time).
     *
     * @param component5 the Start Time to set
     * @return the field object to enable build pattern
     */
    public Field259 setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the component5 from a Calendar object.
     *
     * @param component5 the Calendar with the Start Time content to set
     * @return the field object to enable build pattern
     */
    public Field259 setComponent5(java.util.Calendar component5) {
        setComponent(5, SwiftFormatUtils.getTime3(component5));
        return this;
    }

    /**
     * Set the Start Time (component 5).
     *
     * @param component5 the Start Time to set
     * @return the field object to enable build pattern
     */
    public Field259 setStartTime(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the Start Time (component 5) from a Calendar object.
     *
     * @see #setComponent5(java.util.Calendar)
     *
     * @param component5 Calendar with the Start Time content to set
     * @return the field object to enable build pattern
     */
    public Field259 setStartTime(java.util.Calendar component5) {
        return setComponent5(component5);
    }

    /**
     * Set the component 6 (End Time).
     *
     * @param component6 the End Time to set
     * @return the field object to enable build pattern
     */
    public Field259 setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }

    /**
     * Set the component6 from a Calendar object.
     *
     * @param component6 the Calendar with the End Time content to set
     * @return the field object to enable build pattern
     */
    public Field259 setComponent6(java.util.Calendar component6) {
        setComponent(6, SwiftFormatUtils.getTime3(component6));
        return this;
    }

    /**
     * Set the End Time (component 6).
     *
     * @param component6 the End Time to set
     * @return the field object to enable build pattern
     */
    public Field259 setEndTime(String component6) {
        return setComponent6(component6);
    }

    /**
     * Set the End Time (component 6) from a Calendar object.
     *
     * @see #setComponent6(java.util.Calendar)
     *
     * @param component6 Calendar with the End Time content to set
     * @return the field object to enable build pattern
     */
    public Field259 setEndTime(java.util.Calendar component6) {
        return setComponent6(component6);
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
     * @return the static value of Field259.NAME
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
    public static Field259 get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field259(t);
    }

    /**
     * Gets the first instance of Field259 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field259 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field259 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field259> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field259 from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field259> getAll(final SwiftTagListBlock block) {
        final List<Field259> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field259(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field259 object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field259 fromJson(final String json) {

        final Field259 field = new Field259();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - LT Address

        if (jsonObject.get("lTAddress") != null) {
            field.setComponent1(jsonObject.get("lTAddress").getAsString());
        }

        // **** COMPONENT 2 - Session Number

        if (jsonObject.get("sessionNumber") != null) {
            field.setComponent2(jsonObject.get("sessionNumber").getAsString());
        }

        // **** COMPONENT 3 - Message Category

        if (jsonObject.get("messageCategory") != null) {
            field.setComponent3(jsonObject.get("messageCategory").getAsString());
        }

        // **** COMPONENT 4 - Date

        if (jsonObject.get("date") != null) {
            field.setComponent4(jsonObject.get("date").getAsString());
        }

        // **** COMPONENT 5 - Start Time

        if (jsonObject.get("startTime") != null) {
            field.setComponent5(jsonObject.get("startTime").getAsString());
        }

        // **** COMPONENT 6 - End Time

        if (jsonObject.get("endTime") != null) {
            field.setComponent6(jsonObject.get("endTime").getAsString());
        }

        return field;
    }


}
