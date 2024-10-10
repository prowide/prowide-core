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

import com.prowidesoftware.swift.model.field.DateContainer;
import com.prowidesoftware.swift.model.field.DateResolver;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 333.
 * <p>
 * Model and parser for field 333 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: DateLastSessionOpened: <code>Calendar</code></li>
 * 		<li>Component 2: TimeLastSessionOpened: <code>Calendar</code></li>
 * 		<li>Component 3: SessionNumber: <code>Long</code></li>
 * 		<li>Component 4: DateLastSessionClosed: <code>Calendar</code></li>
 * 		<li>Component 5: TimeLastSessionClosed: <code>Calendar</code></li>
 * 		<li>Component 6: ReasonForClosure: <code>Long</code></li>
 * 		<li>Component 7: LastInputSequenceNumberReceived: <code>Long</code></li>
 * 		<li>Component 8: LastOutputSequenceNumberSent: <code>Long</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;DATE2&gt;&lt;HHMM&gt;4!n&lt;DATE2&gt;&lt;HHMM&gt;3!n6!n6!n</code></li>
 * 		<li>parser pattern: <code>&lt;DATE2&gt;&lt;HHMM&gt;4!N&lt;DATE2&gt;&lt;HHMM&gt;3!N6!N6!N</code></li>
 * 		<li>components pattern: <code>EHNEHNNN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field333 extends Field implements Serializable, DateContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 333.
	 */
    public static final String NAME = "333";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_333 = "333";

	/**
	 * Component number for the Date Last Session Opened subfield.
	 */
	public static final Integer DATE_LAST_SESSION_OPENED = 1;

	/**
	 * Component number for the Time Last Session Opened subfield.
	 */
	public static final Integer TIME_LAST_SESSION_OPENED = 2;

	/**
	 * Component number for the Session Number subfield.
	 */
	public static final Integer SESSION_NUMBER = 3;

	/**
	 * Component number for the Date Last Session Closed subfield.
	 */
	public static final Integer DATE_LAST_SESSION_CLOSED = 4;

	/**
	 * Component number for the Time Last Session Closed subfield.
	 */
	public static final Integer TIME_LAST_SESSION_CLOSED = 5;

	/**
	 * Component number for the Reason For Closure subfield.
	 */
	public static final Integer REASON_FOR_CLOSURE = 6;

	/**
	 * Component number for the Last Input Sequence Number Received subfield.
	 */
	public static final Integer LAST_INPUT_SEQUENCE_NUMBER_RECEIVED = 7;

	/**
	 * Component number for the Last Output Sequence Number Sent subfield.
	 */
	public static final Integer LAST_OUTPUT_SEQUENCE_NUMBER_SENT = 8;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field333() {
        super(8);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field333(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field333(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "333")) {
            throw new IllegalArgumentException("cannot create field 333 from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field333 newInstance(Field333 source) {
        Field333 cp = new Field333();
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
        init(8);
        if (value != null) {
            if (value.length() >= 6) {
                setComponent1(StringUtils.substring(value, 0, 6));
            }
            if (value.length() >= 10) {
                setComponent2(StringUtils.substring(value, 6, 10));
            }
            if (value.length() >= 14) {
                setComponent3(StringUtils.substring(value, 10, 14));
            }
            if (value.length() >= 20) {
                setComponent4(StringUtils.substring(value, 14, 20));
            }
            if (value.length() >= 24) {
                setComponent5(StringUtils.substring(value, 20, 24));
            }
            if (value.length() >= 27) {
                setComponent6(StringUtils.substring(value, 24, 27));
            }
            if (value.length() >= 33) {
                setComponent7(StringUtils.substring(value, 27, 33));
            }
            if (value.length() > 33) {
                setComponent8(StringUtils.substring(value, 33));
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
        if (component < 1 || component > 8) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 333");
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
            //time: HH[mm]
            java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
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
        if (component == 6) {
            //default format (as is)
            return getComponent(6);
        }
        if (component == 7) {
            //default format (as is)
            return getComponent(7);
        }
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(8);
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
        return "EHNEHNNN";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "<DATE2><HHMM>4!N<DATE2><HHMM>3!N6!N6!N";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "<DATE2><HHMM>4!n<DATE2><HHMM>3!n6!n6!n";
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
        return 8;
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
        result.add("Date Last Session Opened");
        result.add("Time Last Session Opened");
        result.add("Session Number");
        result.add("Date Last Session Closed");
        result.add("Time Last Session Closed");
        result.add("Reason For Closure");
        result.add("Last Input Sequence Number Received");
        result.add("Last Output Sequence Number Sent");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "dateLastSessionOpened");
        result.put(2, "timeLastSessionOpened");
        result.put(3, "sessionNumber");
        result.put(4, "dateLastSessionClosed");
        result.put(5, "timeLastSessionClosed");
        result.put(6, "reasonForClosure");
        result.put(7, "lastInputSequenceNumberReceived");
        result.put(8, "lastOutputSequenceNumberSent");
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
        super.labelMap.put("datelastsessionopened", 1);
        super.labelMap.put("timelastsessionopened", 2);
        super.labelMap.put("sessionnumber", 3);
        super.labelMap.put("datelastsessionclosed", 4);
        super.labelMap.put("timelastsessionclosed", 5);
        super.labelMap.put("reasonforclosure", 6);
        super.labelMap.put("lastinputsequencenumberreceived", 7);
        super.labelMap.put("lastoutputsequencenumbersent", 8);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Date Last Session Opened).
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
     * Gets the Date Last Session Opened (component 1).
     * @return the Date Last Session Opened from component 1
     */
    public String getDateLastSessionOpened() {
        return getComponent1();
    }

    /**
     * Get the Date Last Session Opened (component 1) as Calendar
     * @return the Date Last Session Opened from component 1 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getDateLastSessionOpenedAsCalendar() {
        return getComponent1AsCalendar();
    }

    /**
     * Gets the component 2 (Time Last Session Opened).
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
        return SwiftFormatUtils.getTime3(getComponent(2));
    }

    /**
     * Gets the Time Last Session Opened (component 2).
     * @return the Time Last Session Opened from component 2
     */
    public String getTimeLastSessionOpened() {
        return getComponent2();
    }

    /**
     * Get the Time Last Session Opened (component 2) as Calendar
     * @return the Time Last Session Opened from component 2 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getTimeLastSessionOpenedAsCalendar() {
        return getComponent2AsCalendar();
    }

    /**
     * Gets the component 3 (Session Number).
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
     * Gets the Session Number (component 3).
     * @return the Session Number from component 3
     */
    public String getSessionNumber() {
        return getComponent3();
    }

    /**
     * Get the Session Number (component 3) as Long
     * @return the Session Number from component 3 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getSessionNumberAsLong() {
        return getComponent3AsLong();
    }

    /**
     * Gets the component 4 (Date Last Session Closed).
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
     * Gets the Date Last Session Closed (component 4).
     * @return the Date Last Session Closed from component 4
     */
    public String getDateLastSessionClosed() {
        return getComponent4();
    }

    /**
     * Get the Date Last Session Closed (component 4) as Calendar
     * @return the Date Last Session Closed from component 4 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getDateLastSessionClosedAsCalendar() {
        return getComponent4AsCalendar();
    }

    /**
     * Gets the component 5 (Time Last Session Closed).
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
     * Gets the Time Last Session Closed (component 5).
     * @return the Time Last Session Closed from component 5
     */
    public String getTimeLastSessionClosed() {
        return getComponent5();
    }

    /**
     * Get the Time Last Session Closed (component 5) as Calendar
     * @return the Time Last Session Closed from component 5 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getTimeLastSessionClosedAsCalendar() {
        return getComponent5AsCalendar();
    }

    /**
     * Gets the component 6 (Reason For Closure).
     * @return the component 6
     */
    public String getComponent6() {
        return getComponent(6);
    }

    /**
     * Get the component 6 as Long
     *
     * @return the component 6 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent6AsLong() {
        return SwiftFormatUtils.getLong(getComponent(6));
    }

    /**
     * Gets the Reason For Closure (component 6).
     * @return the Reason For Closure from component 6
     */
    public String getReasonForClosure() {
        return getComponent6();
    }

    /**
     * Get the Reason For Closure (component 6) as Long
     * @return the Reason For Closure from component 6 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getReasonForClosureAsLong() {
        return getComponent6AsLong();
    }

    /**
     * Gets the component 7 (Last Input Sequence Number Received).
     * @return the component 7
     */
    public String getComponent7() {
        return getComponent(7);
    }

    /**
     * Get the component 7 as Long
     *
     * @return the component 7 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent7AsLong() {
        return SwiftFormatUtils.getLong(getComponent(7));
    }

    /**
     * Gets the Last Input Sequence Number Received (component 7).
     * @return the Last Input Sequence Number Received from component 7
     */
    public String getLastInputSequenceNumberReceived() {
        return getComponent7();
    }

    /**
     * Get the Last Input Sequence Number Received (component 7) as Long
     * @return the Last Input Sequence Number Received from component 7 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getLastInputSequenceNumberReceivedAsLong() {
        return getComponent7AsLong();
    }

    /**
     * Gets the component 8 (Last Output Sequence Number Sent).
     * @return the component 8
     */
    public String getComponent8() {
        return getComponent(8);
    }

    /**
     * Get the component 8 as Long
     *
     * @return the component 8 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent8AsLong() {
        return SwiftFormatUtils.getLong(getComponent(8));
    }

    /**
     * Gets the Last Output Sequence Number Sent (component 8).
     * @return the Last Output Sequence Number Sent from component 8
     */
    public String getLastOutputSequenceNumberSent() {
        return getComponent8();
    }

    /**
     * Get the Last Output Sequence Number Sent (component 8) as Long
     * @return the Last Output Sequence Number Sent from component 8 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getLastOutputSequenceNumberSentAsLong() {
        return getComponent8AsLong();
    }

    /**
     * Set the component 1 (Date Last Session Opened).
     *
     * @param component1 the Date Last Session Opened to set
     * @return the field object to enable build pattern
     */
    public Field333 setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the component1 from a Calendar object.
     *
     * @param component1 the Calendar with the Date Last Session Opened content to set
     * @return the field object to enable build pattern
     */
    public Field333 setComponent1(java.util.Calendar component1) {
        setComponent(1, SwiftFormatUtils.getDate2(component1));
        return this;
    }

    /**
     * Set the Date Last Session Opened (component 1).
     *
     * @param component1 the Date Last Session Opened to set
     * @return the field object to enable build pattern
     */
    public Field333 setDateLastSessionOpened(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the Date Last Session Opened (component 1) from a Calendar object.
     *
     * @see #setComponent1(java.util.Calendar)
     *
     * @param component1 Calendar with the Date Last Session Opened content to set
     * @return the field object to enable build pattern
     */
    public Field333 setDateLastSessionOpened(java.util.Calendar component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Time Last Session Opened).
     *
     * @param component2 the Time Last Session Opened to set
     * @return the field object to enable build pattern
     */
    public Field333 setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Calendar object.
     *
     * @param component2 the Calendar with the Time Last Session Opened content to set
     * @return the field object to enable build pattern
     */
    public Field333 setComponent2(java.util.Calendar component2) {
        setComponent(2, SwiftFormatUtils.getTime3(component2));
        return this;
    }

    /**
     * Set the Time Last Session Opened (component 2).
     *
     * @param component2 the Time Last Session Opened to set
     * @return the field object to enable build pattern
     */
    public Field333 setTimeLastSessionOpened(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Time Last Session Opened (component 2) from a Calendar object.
     *
     * @see #setComponent2(java.util.Calendar)
     *
     * @param component2 Calendar with the Time Last Session Opened content to set
     * @return the field object to enable build pattern
     */
    public Field333 setTimeLastSessionOpened(java.util.Calendar component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Session Number).
     *
     * @param component3 the Session Number to set
     * @return the field object to enable build pattern
     */
    public Field333 setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }


    /**
     * Alternative method setter for field's Session Number (component 3) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Session Number content to set
     * @return the field object to enable build pattern
     */
    public Field333 setComponent3(java.lang.Number component3) {

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
     * Set the Session Number (component 3).
     *
     * @param component3 the Session Number to set
     * @return the field object to enable build pattern
     */
    public Field333 setSessionNumber(String component3) {
        return setComponent3(component3);
    }

    /**
     * Alternative method setter for field's Session Number (component 3) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Session Number content to set
     * @return the field object to enable build pattern
     */
    public Field333 setSessionNumber(java.lang.Number component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Date Last Session Closed).
     *
     * @param component4 the Date Last Session Closed to set
     * @return the field object to enable build pattern
     */
    public Field333 setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component4 from a Calendar object.
     *
     * @param component4 the Calendar with the Date Last Session Closed content to set
     * @return the field object to enable build pattern
     */
    public Field333 setComponent4(java.util.Calendar component4) {
        setComponent(4, SwiftFormatUtils.getDate2(component4));
        return this;
    }

    /**
     * Set the Date Last Session Closed (component 4).
     *
     * @param component4 the Date Last Session Closed to set
     * @return the field object to enable build pattern
     */
    public Field333 setDateLastSessionClosed(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the Date Last Session Closed (component 4) from a Calendar object.
     *
     * @see #setComponent4(java.util.Calendar)
     *
     * @param component4 Calendar with the Date Last Session Closed content to set
     * @return the field object to enable build pattern
     */
    public Field333 setDateLastSessionClosed(java.util.Calendar component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Time Last Session Closed).
     *
     * @param component5 the Time Last Session Closed to set
     * @return the field object to enable build pattern
     */
    public Field333 setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the component5 from a Calendar object.
     *
     * @param component5 the Calendar with the Time Last Session Closed content to set
     * @return the field object to enable build pattern
     */
    public Field333 setComponent5(java.util.Calendar component5) {
        setComponent(5, SwiftFormatUtils.getTime3(component5));
        return this;
    }

    /**
     * Set the Time Last Session Closed (component 5).
     *
     * @param component5 the Time Last Session Closed to set
     * @return the field object to enable build pattern
     */
    public Field333 setTimeLastSessionClosed(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the Time Last Session Closed (component 5) from a Calendar object.
     *
     * @see #setComponent5(java.util.Calendar)
     *
     * @param component5 Calendar with the Time Last Session Closed content to set
     * @return the field object to enable build pattern
     */
    public Field333 setTimeLastSessionClosed(java.util.Calendar component5) {
        return setComponent5(component5);
    }

    /**
     * Set the component 6 (Reason For Closure).
     *
     * @param component6 the Reason For Closure to set
     * @return the field object to enable build pattern
     */
    public Field333 setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }


    /**
     * Alternative method setter for field's Reason For Closure (component 6) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component6 the Number with the Reason For Closure content to set
     * @return the field object to enable build pattern
     */
    public Field333 setComponent6(java.lang.Number component6) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component6 instanceof Long) {
            setComponent(6, SwiftFormatUtils.getLong((Long) component6));
        } else if (component6 instanceof BigInteger || component6 instanceof Integer) {
            setComponent(6, SwiftFormatUtils.getLong(component6.longValue()));
        } else if (component6 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(6, SwiftFormatUtils.getLong(component6.longValue()));
        } else {
            // explicitly set component as null
            setComponent(6, null);
        }
        return this;
    }

    /**
     * Set the Reason For Closure (component 6).
     *
     * @param component6 the Reason For Closure to set
     * @return the field object to enable build pattern
     */
    public Field333 setReasonForClosure(String component6) {
        return setComponent6(component6);
    }

    /**
     * Alternative method setter for field's Reason For Closure (component 6) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component6 the Number with the Reason For Closure content to set
     * @return the field object to enable build pattern
     */
    public Field333 setReasonForClosure(java.lang.Number component6) {
        return setComponent6(component6);
    }

    /**
     * Set the component 7 (Last Input Sequence Number Received).
     *
     * @param component7 the Last Input Sequence Number Received to set
     * @return the field object to enable build pattern
     */
    public Field333 setComponent7(String component7) {
        setComponent(7, component7);
        return this;
    }


    /**
     * Alternative method setter for field's Last Input Sequence Number Received (component 7) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component7 the Number with the Last Input Sequence Number Received content to set
     * @return the field object to enable build pattern
     */
    public Field333 setComponent7(java.lang.Number component7) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component7 instanceof Long) {
            setComponent(7, SwiftFormatUtils.getLong((Long) component7));
        } else if (component7 instanceof BigInteger || component7 instanceof Integer) {
            setComponent(7, SwiftFormatUtils.getLong(component7.longValue()));
        } else if (component7 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(7, SwiftFormatUtils.getLong(component7.longValue()));
        } else {
            // explicitly set component as null
            setComponent(7, null);
        }
        return this;
    }

    /**
     * Set the Last Input Sequence Number Received (component 7).
     *
     * @param component7 the Last Input Sequence Number Received to set
     * @return the field object to enable build pattern
     */
    public Field333 setLastInputSequenceNumberReceived(String component7) {
        return setComponent7(component7);
    }

    /**
     * Alternative method setter for field's Last Input Sequence Number Received (component 7) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component7 the Number with the Last Input Sequence Number Received content to set
     * @return the field object to enable build pattern
     */
    public Field333 setLastInputSequenceNumberReceived(java.lang.Number component7) {
        return setComponent7(component7);
    }

    /**
     * Set the component 8 (Last Output Sequence Number Sent).
     *
     * @param component8 the Last Output Sequence Number Sent to set
     * @return the field object to enable build pattern
     */
    public Field333 setComponent8(String component8) {
        setComponent(8, component8);
        return this;
    }


    /**
     * Alternative method setter for field's Last Output Sequence Number Sent (component 8) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component8 the Number with the Last Output Sequence Number Sent content to set
     * @return the field object to enable build pattern
     */
    public Field333 setComponent8(java.lang.Number component8) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component8 instanceof Long) {
            setComponent(8, SwiftFormatUtils.getLong((Long) component8));
        } else if (component8 instanceof BigInteger || component8 instanceof Integer) {
            setComponent(8, SwiftFormatUtils.getLong(component8.longValue()));
        } else if (component8 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(8, SwiftFormatUtils.getLong(component8.longValue()));
        } else {
            // explicitly set component as null
            setComponent(8, null);
        }
        return this;
    }

    /**
     * Set the Last Output Sequence Number Sent (component 8).
     *
     * @param component8 the Last Output Sequence Number Sent to set
     * @return the field object to enable build pattern
     */
    public Field333 setLastOutputSequenceNumberSent(String component8) {
        return setComponent8(component8);
    }

    /**
     * Alternative method setter for field's Last Output Sequence Number Sent (component 8) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component8 the Number with the Last Output Sequence Number Sent content to set
     * @return the field object to enable build pattern
     */
    public Field333 setLastOutputSequenceNumberSent(java.lang.Number component8) {
        return setComponent8(component8);
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
     * @return the static value of Field333.NAME
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
    public static Field333 get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field333(t);
    }

    /**
     * Gets the first instance of Field333 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field333 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field333 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field333> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field333 from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field333> getAll(final SwiftTagListBlock block) {
        final List<Field333> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field333(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field333 object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field333 fromJson(final String json) {

        final Field333 field = new Field333();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Date Last Session Opened

        if (jsonObject.get("dateLastSessionOpened") != null) {
            field.setComponent1(jsonObject.get("dateLastSessionOpened").getAsString());
        }

        // **** COMPONENT 2 - Time Last Session Opened

        if (jsonObject.get("timeLastSessionOpened") != null) {
            field.setComponent2(jsonObject.get("timeLastSessionOpened").getAsString());
        }

        // **** COMPONENT 3 - Session Number

        if (jsonObject.get("sessionNumber") != null) {
            field.setComponent3(jsonObject.get("sessionNumber").getAsString());
        }

        // **** COMPONENT 4 - Date Last Session Closed

        if (jsonObject.get("dateLastSessionClosed") != null) {
            field.setComponent4(jsonObject.get("dateLastSessionClosed").getAsString());
        }

        // **** COMPONENT 5 - Time Last Session Closed

        if (jsonObject.get("timeLastSessionClosed") != null) {
            field.setComponent5(jsonObject.get("timeLastSessionClosed").getAsString());
        }

        // **** COMPONENT 6 - Reason For Closure

        if (jsonObject.get("reasonForClosure") != null) {
            field.setComponent6(jsonObject.get("reasonForClosure").getAsString());
        }

        // **** COMPONENT 7 - Last Input Sequence Number Received

        if (jsonObject.get("lastInputSequenceNumberReceived") != null) {
            field.setComponent7(jsonObject.get("lastInputSequenceNumberReceived").getAsString());
        }

        // **** COMPONENT 8 - Last Output Sequence Number Sent

        if (jsonObject.get("lastOutputSequenceNumberSent") != null) {
            field.setComponent8(jsonObject.get("lastOutputSequenceNumberSent").getAsString());
        }

        return field;
    }


}
