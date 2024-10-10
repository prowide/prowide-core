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
 * SWIFT MT Field 331.
 * <p>
 * Model and parser for field 331 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: SessionNumber: <code>Long</code></li>
 * 		<li>Component 2: DateSessionOpened: <code>Calendar</code></li>
 * 		<li>Component 3: TimeSessionOpened: <code>Calendar</code></li>
 * 		<li>Component 4: DateSessionClosed: <code>Calendar</code></li>
 * 		<li>Component 5: TimeSessionClosed: <code>Calendar</code></li>
 * 		<li>Component 6: ReasonForClosure: <code>Long</code></li>
 * 		<li>Component 7: QuantityOfMessagesSent: <code>Long</code></li>
 * 		<li>Component 8: QuantityOfMessagesReceived: <code>Long</code></li>
 * 		<li>Component 9: FirstInputSequenceNumber: <code>Long</code></li>
 * 		<li>Component 10: LastInputSequenceNumber: <code>Long</code></li>
 * 		<li>Component 11: FirstOutputSequenceNumber: <code>Long</code></li>
 * 		<li>Component 12: LastOutputSequenceNumber: <code>Long</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>4!n&lt;DATE2&gt;&lt;HHMM&gt;&lt;DATE2&gt;&lt;HHMM&gt;3!n6!n6!n6!n6!n6!n6!n</code></li>
 * 		<li>parser pattern: <code>4!N&lt;DATE2&gt;&lt;HHMM&gt;&lt;DATE2&gt;&lt;HHMM&gt;3!N6!N6!N6!N6!N6!N6!N</code></li>
 * 		<li>components pattern: <code>NEHEHNNNNNNN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field331 extends Field implements Serializable, DateContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 331.
	 */
    public static final String NAME = "331";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_331 = "331";

	/**
	 * Component number for the Session Number subfield.
	 */
	public static final Integer SESSION_NUMBER = 1;

	/**
	 * Component number for the Date Session Opened subfield.
	 */
	public static final Integer DATE_SESSION_OPENED = 2;

	/**
	 * Component number for the Time Session Opened subfield.
	 */
	public static final Integer TIME_SESSION_OPENED = 3;

	/**
	 * Component number for the Date Session Closed subfield.
	 */
	public static final Integer DATE_SESSION_CLOSED = 4;

	/**
	 * Component number for the Time Session Closed subfield.
	 */
	public static final Integer TIME_SESSION_CLOSED = 5;

	/**
	 * Component number for the Reason For Closure subfield.
	 */
	public static final Integer REASON_FOR_CLOSURE = 6;

	/**
	 * Component number for the Quantity Of Messages Sent subfield.
	 */
	public static final Integer QUANTITY_OF_MESSAGES_SENT = 7;

	/**
	 * Component number for the Quantity Of Messages Received subfield.
	 */
	public static final Integer QUANTITY_OF_MESSAGES_RECEIVED = 8;

	/**
	 * Component number for the First Input Sequence Number subfield.
	 */
	public static final Integer FIRST_INPUT_SEQUENCE_NUMBER = 9;

	/**
	 * Component number for the Last Input Sequence Number subfield.
	 */
	public static final Integer LAST_INPUT_SEQUENCE_NUMBER = 10;

	/**
	 * Component number for the First Output Sequence Number subfield.
	 */
	public static final Integer FIRST_OUTPUT_SEQUENCE_NUMBER = 11;

	/**
	 * Component number for the Last Output Sequence Number subfield.
	 */
	public static final Integer LAST_OUTPUT_SEQUENCE_NUMBER = 12;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field331() {
        super(12);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field331(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field331(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "331")) {
            throw new IllegalArgumentException("cannot create field 331 from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field331 newInstance(Field331 source) {
        Field331 cp = new Field331();
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
        init(12);
        if (value != null) {
            if (value.length() >= 4) {
                setComponent1(StringUtils.substring(value, 0, 4));
            }
            if (value.length() >= 10) {
                setComponent2(StringUtils.substring(value, 4, 10));
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
            String toparse = StringUtils.substring(value, 27);
            SwiftParseUtils.setComponentsFromTokens(this, 7, 12, 6, toparse);
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
        if (component < 1 || component > 12) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 331");
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
        if (component == 8) {
            //default format (as is)
            return getComponent(8);
        }
        if (component == 9) {
            //default format (as is)
            return getComponent(9);
        }
        if (component == 10) {
            //default format (as is)
            return getComponent(10);
        }
        if (component == 11) {
            //default format (as is)
            return getComponent(11);
        }
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(12);
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
        return "NEHEHNNNNNNN";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "4!N<DATE2><HHMM><DATE2><HHMM>3!N6!N6!N6!N6!N6!N6!N";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "4!n<DATE2><HHMM><DATE2><HHMM>3!n6!n6!n6!n6!n6!n6!n";
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
        return 12;
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
        result.add("Session Number");
        result.add("Date Session Opened");
        result.add("Time Session Opened");
        result.add("Date Session Closed");
        result.add("Time Session Closed");
        result.add("Reason For Closure");
        result.add("Quantity Of Messages Sent");
        result.add("Quantity Of Messages Received");
        result.add("First Input Sequence Number");
        result.add("Last Input Sequence Number");
        result.add("First Output Sequence Number");
        result.add("Last Output Sequence Number");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "sessionNumber");
        result.put(2, "dateSessionOpened");
        result.put(3, "timeSessionOpened");
        result.put(4, "dateSessionClosed");
        result.put(5, "timeSessionClosed");
        result.put(6, "reasonForClosure");
        result.put(7, "quantityOfMessagesSent");
        result.put(8, "quantityOfMessagesReceived");
        result.put(9, "firstInputSequenceNumber");
        result.put(10, "lastInputSequenceNumber");
        result.put(11, "firstOutputSequenceNumber");
        result.put(12, "lastOutputSequenceNumber");
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
        super.labelMap.put("sessionnumber", 1);
        super.labelMap.put("datesessionopened", 2);
        super.labelMap.put("timesessionopened", 3);
        super.labelMap.put("datesessionclosed", 4);
        super.labelMap.put("timesessionclosed", 5);
        super.labelMap.put("reasonforclosure", 6);
        super.labelMap.put("quantityofmessagessent", 7);
        super.labelMap.put("quantityofmessagesreceived", 8);
        super.labelMap.put("firstinputsequencenumber", 9);
        super.labelMap.put("lastinputsequencenumber", 10);
        super.labelMap.put("firstoutputsequencenumber", 11);
        super.labelMap.put("lastoutputsequencenumber", 12);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Session Number).
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
     * Gets the Session Number (component 1).
     * @return the Session Number from component 1
     */
    public String getSessionNumber() {
        return getComponent1();
    }

    /**
     * Get the Session Number (component 1) as Long
     * @return the Session Number from component 1 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getSessionNumberAsLong() {
        return getComponent1AsLong();
    }

    /**
     * Gets the component 2 (Date Session Opened).
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
     * Gets the Date Session Opened (component 2).
     * @return the Date Session Opened from component 2
     */
    public String getDateSessionOpened() {
        return getComponent2();
    }

    /**
     * Get the Date Session Opened (component 2) as Calendar
     * @return the Date Session Opened from component 2 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getDateSessionOpenedAsCalendar() {
        return getComponent2AsCalendar();
    }

    /**
     * Gets the component 3 (Time Session Opened).
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
     * Gets the Time Session Opened (component 3).
     * @return the Time Session Opened from component 3
     */
    public String getTimeSessionOpened() {
        return getComponent3();
    }

    /**
     * Get the Time Session Opened (component 3) as Calendar
     * @return the Time Session Opened from component 3 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getTimeSessionOpenedAsCalendar() {
        return getComponent3AsCalendar();
    }

    /**
     * Gets the component 4 (Date Session Closed).
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
     * Gets the Date Session Closed (component 4).
     * @return the Date Session Closed from component 4
     */
    public String getDateSessionClosed() {
        return getComponent4();
    }

    /**
     * Get the Date Session Closed (component 4) as Calendar
     * @return the Date Session Closed from component 4 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getDateSessionClosedAsCalendar() {
        return getComponent4AsCalendar();
    }

    /**
     * Gets the component 5 (Time Session Closed).
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
     * Gets the Time Session Closed (component 5).
     * @return the Time Session Closed from component 5
     */
    public String getTimeSessionClosed() {
        return getComponent5();
    }

    /**
     * Get the Time Session Closed (component 5) as Calendar
     * @return the Time Session Closed from component 5 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getTimeSessionClosedAsCalendar() {
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
     * Gets the component 7 (Quantity Of Messages Sent).
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
     * Gets the Quantity Of Messages Sent (component 7).
     * @return the Quantity Of Messages Sent from component 7
     */
    public String getQuantityOfMessagesSent() {
        return getComponent7();
    }

    /**
     * Get the Quantity Of Messages Sent (component 7) as Long
     * @return the Quantity Of Messages Sent from component 7 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getQuantityOfMessagesSentAsLong() {
        return getComponent7AsLong();
    }

    /**
     * Gets the component 8 (Quantity Of Messages Received).
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
     * Gets the Quantity Of Messages Received (component 8).
     * @return the Quantity Of Messages Received from component 8
     */
    public String getQuantityOfMessagesReceived() {
        return getComponent8();
    }

    /**
     * Get the Quantity Of Messages Received (component 8) as Long
     * @return the Quantity Of Messages Received from component 8 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getQuantityOfMessagesReceivedAsLong() {
        return getComponent8AsLong();
    }

    /**
     * Gets the component 9 (First Input Sequence Number).
     * @return the component 9
     */
    public String getComponent9() {
        return getComponent(9);
    }

    /**
     * Get the component 9 as Long
     *
     * @return the component 9 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent9AsLong() {
        return SwiftFormatUtils.getLong(getComponent(9));
    }

    /**
     * Gets the First Input Sequence Number (component 9).
     * @return the First Input Sequence Number from component 9
     */
    public String getFirstInputSequenceNumber() {
        return getComponent9();
    }

    /**
     * Get the First Input Sequence Number (component 9) as Long
     * @return the First Input Sequence Number from component 9 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getFirstInputSequenceNumberAsLong() {
        return getComponent9AsLong();
    }

    /**
     * Gets the component 10 (Last Input Sequence Number).
     * @return the component 10
     */
    public String getComponent10() {
        return getComponent(10);
    }

    /**
     * Get the component 10 as Long
     *
     * @return the component 10 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent10AsLong() {
        return SwiftFormatUtils.getLong(getComponent(10));
    }

    /**
     * Gets the Last Input Sequence Number (component 10).
     * @return the Last Input Sequence Number from component 10
     */
    public String getLastInputSequenceNumber() {
        return getComponent10();
    }

    /**
     * Get the Last Input Sequence Number (component 10) as Long
     * @return the Last Input Sequence Number from component 10 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getLastInputSequenceNumberAsLong() {
        return getComponent10AsLong();
    }

    /**
     * Gets the component 11 (First Output Sequence Number).
     * @return the component 11
     */
    public String getComponent11() {
        return getComponent(11);
    }

    /**
     * Get the component 11 as Long
     *
     * @return the component 11 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent11AsLong() {
        return SwiftFormatUtils.getLong(getComponent(11));
    }

    /**
     * Gets the First Output Sequence Number (component 11).
     * @return the First Output Sequence Number from component 11
     */
    public String getFirstOutputSequenceNumber() {
        return getComponent11();
    }

    /**
     * Get the First Output Sequence Number (component 11) as Long
     * @return the First Output Sequence Number from component 11 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getFirstOutputSequenceNumberAsLong() {
        return getComponent11AsLong();
    }

    /**
     * Gets the component 12 (Last Output Sequence Number).
     * @return the component 12
     */
    public String getComponent12() {
        return getComponent(12);
    }

    /**
     * Get the component 12 as Long
     *
     * @return the component 12 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent12AsLong() {
        return SwiftFormatUtils.getLong(getComponent(12));
    }

    /**
     * Gets the Last Output Sequence Number (component 12).
     * @return the Last Output Sequence Number from component 12
     */
    public String getLastOutputSequenceNumber() {
        return getComponent12();
    }

    /**
     * Get the Last Output Sequence Number (component 12) as Long
     * @return the Last Output Sequence Number from component 12 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getLastOutputSequenceNumberAsLong() {
        return getComponent12AsLong();
    }

    /**
     * Set the component 1 (Session Number).
     *
     * @param component1 the Session Number to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }


    /**
     * Alternative method setter for field's Session Number (component 1) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Session Number content to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent1(java.lang.Number component1) {

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
     * Set the Session Number (component 1).
     *
     * @param component1 the Session Number to set
     * @return the field object to enable build pattern
     */
    public Field331 setSessionNumber(String component1) {
        return setComponent1(component1);
    }

    /**
     * Alternative method setter for field's Session Number (component 1) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Session Number content to set
     * @return the field object to enable build pattern
     */
    public Field331 setSessionNumber(java.lang.Number component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Date Session Opened).
     *
     * @param component2 the Date Session Opened to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Calendar object.
     *
     * @param component2 the Calendar with the Date Session Opened content to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent2(java.util.Calendar component2) {
        setComponent(2, SwiftFormatUtils.getDate2(component2));
        return this;
    }

    /**
     * Set the Date Session Opened (component 2).
     *
     * @param component2 the Date Session Opened to set
     * @return the field object to enable build pattern
     */
    public Field331 setDateSessionOpened(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Date Session Opened (component 2) from a Calendar object.
     *
     * @see #setComponent2(java.util.Calendar)
     *
     * @param component2 Calendar with the Date Session Opened content to set
     * @return the field object to enable build pattern
     */
    public Field331 setDateSessionOpened(java.util.Calendar component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Time Session Opened).
     *
     * @param component3 the Time Session Opened to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a Calendar object.
     *
     * @param component3 the Calendar with the Time Session Opened content to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent3(java.util.Calendar component3) {
        setComponent(3, SwiftFormatUtils.getTime3(component3));
        return this;
    }

    /**
     * Set the Time Session Opened (component 3).
     *
     * @param component3 the Time Session Opened to set
     * @return the field object to enable build pattern
     */
    public Field331 setTimeSessionOpened(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Time Session Opened (component 3) from a Calendar object.
     *
     * @see #setComponent3(java.util.Calendar)
     *
     * @param component3 Calendar with the Time Session Opened content to set
     * @return the field object to enable build pattern
     */
    public Field331 setTimeSessionOpened(java.util.Calendar component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Date Session Closed).
     *
     * @param component4 the Date Session Closed to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component4 from a Calendar object.
     *
     * @param component4 the Calendar with the Date Session Closed content to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent4(java.util.Calendar component4) {
        setComponent(4, SwiftFormatUtils.getDate2(component4));
        return this;
    }

    /**
     * Set the Date Session Closed (component 4).
     *
     * @param component4 the Date Session Closed to set
     * @return the field object to enable build pattern
     */
    public Field331 setDateSessionClosed(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the Date Session Closed (component 4) from a Calendar object.
     *
     * @see #setComponent4(java.util.Calendar)
     *
     * @param component4 Calendar with the Date Session Closed content to set
     * @return the field object to enable build pattern
     */
    public Field331 setDateSessionClosed(java.util.Calendar component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Time Session Closed).
     *
     * @param component5 the Time Session Closed to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the component5 from a Calendar object.
     *
     * @param component5 the Calendar with the Time Session Closed content to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent5(java.util.Calendar component5) {
        setComponent(5, SwiftFormatUtils.getTime3(component5));
        return this;
    }

    /**
     * Set the Time Session Closed (component 5).
     *
     * @param component5 the Time Session Closed to set
     * @return the field object to enable build pattern
     */
    public Field331 setTimeSessionClosed(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the Time Session Closed (component 5) from a Calendar object.
     *
     * @see #setComponent5(java.util.Calendar)
     *
     * @param component5 Calendar with the Time Session Closed content to set
     * @return the field object to enable build pattern
     */
    public Field331 setTimeSessionClosed(java.util.Calendar component5) {
        return setComponent5(component5);
    }

    /**
     * Set the component 6 (Reason For Closure).
     *
     * @param component6 the Reason For Closure to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent6(String component6) {
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
    public Field331 setComponent6(java.lang.Number component6) {

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
    public Field331 setReasonForClosure(String component6) {
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
    public Field331 setReasonForClosure(java.lang.Number component6) {
        return setComponent6(component6);
    }

    /**
     * Set the component 7 (Quantity Of Messages Sent).
     *
     * @param component7 the Quantity Of Messages Sent to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent7(String component7) {
        setComponent(7, component7);
        return this;
    }


    /**
     * Alternative method setter for field's Quantity Of Messages Sent (component 7) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component7 the Number with the Quantity Of Messages Sent content to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent7(java.lang.Number component7) {

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
     * Set the Quantity Of Messages Sent (component 7).
     *
     * @param component7 the Quantity Of Messages Sent to set
     * @return the field object to enable build pattern
     */
    public Field331 setQuantityOfMessagesSent(String component7) {
        return setComponent7(component7);
    }

    /**
     * Alternative method setter for field's Quantity Of Messages Sent (component 7) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component7 the Number with the Quantity Of Messages Sent content to set
     * @return the field object to enable build pattern
     */
    public Field331 setQuantityOfMessagesSent(java.lang.Number component7) {
        return setComponent7(component7);
    }

    /**
     * Set the component 8 (Quantity Of Messages Received).
     *
     * @param component8 the Quantity Of Messages Received to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent8(String component8) {
        setComponent(8, component8);
        return this;
    }


    /**
     * Alternative method setter for field's Quantity Of Messages Received (component 8) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component8 the Number with the Quantity Of Messages Received content to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent8(java.lang.Number component8) {

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
     * Set the Quantity Of Messages Received (component 8).
     *
     * @param component8 the Quantity Of Messages Received to set
     * @return the field object to enable build pattern
     */
    public Field331 setQuantityOfMessagesReceived(String component8) {
        return setComponent8(component8);
    }

    /**
     * Alternative method setter for field's Quantity Of Messages Received (component 8) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component8 the Number with the Quantity Of Messages Received content to set
     * @return the field object to enable build pattern
     */
    public Field331 setQuantityOfMessagesReceived(java.lang.Number component8) {
        return setComponent8(component8);
    }

    /**
     * Set the component 9 (First Input Sequence Number).
     *
     * @param component9 the First Input Sequence Number to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent9(String component9) {
        setComponent(9, component9);
        return this;
    }


    /**
     * Alternative method setter for field's First Input Sequence Number (component 9) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component9 the Number with the First Input Sequence Number content to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent9(java.lang.Number component9) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component9 instanceof Long) {
            setComponent(9, SwiftFormatUtils.getLong((Long) component9));
        } else if (component9 instanceof BigInteger || component9 instanceof Integer) {
            setComponent(9, SwiftFormatUtils.getLong(component9.longValue()));
        } else if (component9 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(9, SwiftFormatUtils.getLong(component9.longValue()));
        } else {
            // explicitly set component as null
            setComponent(9, null);
        }
        return this;
    }

    /**
     * Set the First Input Sequence Number (component 9).
     *
     * @param component9 the First Input Sequence Number to set
     * @return the field object to enable build pattern
     */
    public Field331 setFirstInputSequenceNumber(String component9) {
        return setComponent9(component9);
    }

    /**
     * Alternative method setter for field's First Input Sequence Number (component 9) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component9 the Number with the First Input Sequence Number content to set
     * @return the field object to enable build pattern
     */
    public Field331 setFirstInputSequenceNumber(java.lang.Number component9) {
        return setComponent9(component9);
    }

    /**
     * Set the component 10 (Last Input Sequence Number).
     *
     * @param component10 the Last Input Sequence Number to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent10(String component10) {
        setComponent(10, component10);
        return this;
    }


    /**
     * Alternative method setter for field's Last Input Sequence Number (component 10) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component10 the Number with the Last Input Sequence Number content to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent10(java.lang.Number component10) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component10 instanceof Long) {
            setComponent(10, SwiftFormatUtils.getLong((Long) component10));
        } else if (component10 instanceof BigInteger || component10 instanceof Integer) {
            setComponent(10, SwiftFormatUtils.getLong(component10.longValue()));
        } else if (component10 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(10, SwiftFormatUtils.getLong(component10.longValue()));
        } else {
            // explicitly set component as null
            setComponent(10, null);
        }
        return this;
    }

    /**
     * Set the Last Input Sequence Number (component 10).
     *
     * @param component10 the Last Input Sequence Number to set
     * @return the field object to enable build pattern
     */
    public Field331 setLastInputSequenceNumber(String component10) {
        return setComponent10(component10);
    }

    /**
     * Alternative method setter for field's Last Input Sequence Number (component 10) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component10 the Number with the Last Input Sequence Number content to set
     * @return the field object to enable build pattern
     */
    public Field331 setLastInputSequenceNumber(java.lang.Number component10) {
        return setComponent10(component10);
    }

    /**
     * Set the component 11 (First Output Sequence Number).
     *
     * @param component11 the First Output Sequence Number to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent11(String component11) {
        setComponent(11, component11);
        return this;
    }


    /**
     * Alternative method setter for field's First Output Sequence Number (component 11) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component11 the Number with the First Output Sequence Number content to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent11(java.lang.Number component11) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component11 instanceof Long) {
            setComponent(11, SwiftFormatUtils.getLong((Long) component11));
        } else if (component11 instanceof BigInteger || component11 instanceof Integer) {
            setComponent(11, SwiftFormatUtils.getLong(component11.longValue()));
        } else if (component11 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(11, SwiftFormatUtils.getLong(component11.longValue()));
        } else {
            // explicitly set component as null
            setComponent(11, null);
        }
        return this;
    }

    /**
     * Set the First Output Sequence Number (component 11).
     *
     * @param component11 the First Output Sequence Number to set
     * @return the field object to enable build pattern
     */
    public Field331 setFirstOutputSequenceNumber(String component11) {
        return setComponent11(component11);
    }

    /**
     * Alternative method setter for field's First Output Sequence Number (component 11) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component11 the Number with the First Output Sequence Number content to set
     * @return the field object to enable build pattern
     */
    public Field331 setFirstOutputSequenceNumber(java.lang.Number component11) {
        return setComponent11(component11);
    }

    /**
     * Set the component 12 (Last Output Sequence Number).
     *
     * @param component12 the Last Output Sequence Number to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent12(String component12) {
        setComponent(12, component12);
        return this;
    }


    /**
     * Alternative method setter for field's Last Output Sequence Number (component 12) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component12 the Number with the Last Output Sequence Number content to set
     * @return the field object to enable build pattern
     */
    public Field331 setComponent12(java.lang.Number component12) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component12 instanceof Long) {
            setComponent(12, SwiftFormatUtils.getLong((Long) component12));
        } else if (component12 instanceof BigInteger || component12 instanceof Integer) {
            setComponent(12, SwiftFormatUtils.getLong(component12.longValue()));
        } else if (component12 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(12, SwiftFormatUtils.getLong(component12.longValue()));
        } else {
            // explicitly set component as null
            setComponent(12, null);
        }
        return this;
    }

    /**
     * Set the Last Output Sequence Number (component 12).
     *
     * @param component12 the Last Output Sequence Number to set
     * @return the field object to enable build pattern
     */
    public Field331 setLastOutputSequenceNumber(String component12) {
        return setComponent12(component12);
    }

    /**
     * Alternative method setter for field's Last Output Sequence Number (component 12) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component12 the Number with the Last Output Sequence Number content to set
     * @return the field object to enable build pattern
     */
    public Field331 setLastOutputSequenceNumber(java.lang.Number component12) {
        return setComponent12(component12);
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
     * @return the static value of Field331.NAME
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
    public static Field331 get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field331(t);
    }

    /**
     * Gets the first instance of Field331 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field331 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field331 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field331> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field331 from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field331> getAll(final SwiftTagListBlock block) {
        final List<Field331> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field331(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field331 object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field331 fromJson(final String json) {

        final Field331 field = new Field331();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Session Number

        if (jsonObject.get("sessionNumber") != null) {
            field.setComponent1(jsonObject.get("sessionNumber").getAsString());
        }

        // **** COMPONENT 2 - Date Session Opened

        if (jsonObject.get("dateSessionOpened") != null) {
            field.setComponent2(jsonObject.get("dateSessionOpened").getAsString());
        }

        // **** COMPONENT 3 - Time Session Opened

        if (jsonObject.get("timeSessionOpened") != null) {
            field.setComponent3(jsonObject.get("timeSessionOpened").getAsString());
        }

        // **** COMPONENT 4 - Date Session Closed

        if (jsonObject.get("dateSessionClosed") != null) {
            field.setComponent4(jsonObject.get("dateSessionClosed").getAsString());
        }

        // **** COMPONENT 5 - Time Session Closed

        if (jsonObject.get("timeSessionClosed") != null) {
            field.setComponent5(jsonObject.get("timeSessionClosed").getAsString());
        }

        // **** COMPONENT 6 - Reason For Closure

        if (jsonObject.get("reasonForClosure") != null) {
            field.setComponent6(jsonObject.get("reasonForClosure").getAsString());
        }

        // **** COMPONENT 7 - Quantity Of Messages Sent

        if (jsonObject.get("quantityOfMessagesSent") != null) {
            field.setComponent7(jsonObject.get("quantityOfMessagesSent").getAsString());
        }

        // **** COMPONENT 8 - Quantity Of Messages Received

        if (jsonObject.get("quantityOfMessagesReceived") != null) {
            field.setComponent8(jsonObject.get("quantityOfMessagesReceived").getAsString());
        }

        // **** COMPONENT 9 - First Input Sequence Number

        if (jsonObject.get("firstInputSequenceNumber") != null) {
            field.setComponent9(jsonObject.get("firstInputSequenceNumber").getAsString());
        }

        // **** COMPONENT 10 - Last Input Sequence Number

        if (jsonObject.get("lastInputSequenceNumber") != null) {
            field.setComponent10(jsonObject.get("lastInputSequenceNumber").getAsString());
        }

        // **** COMPONENT 11 - First Output Sequence Number

        if (jsonObject.get("firstOutputSequenceNumber") != null) {
            field.setComponent11(jsonObject.get("firstOutputSequenceNumber").getAsString());
        }

        // **** COMPONENT 12 - Last Output Sequence Number

        if (jsonObject.get("lastOutputSequenceNumber") != null) {
            field.setComponent12(jsonObject.get("lastOutputSequenceNumber").getAsString());
        }

        return field;
    }


}
