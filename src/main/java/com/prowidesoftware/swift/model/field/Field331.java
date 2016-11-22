/*******************************************************************************
 * Copyright (c) 2016 Prowide Inc.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as 
 *     published by the Free Software Foundation, either version 3 of the 
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 *     
 *     Check the LGPL at <http://www.gnu.org/licenses/> for more details.
 *******************************************************************************/
 package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.Generated;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Locale;
import java.util.List;
import java.util.Calendar;
import com.prowidesoftware.swift.model.field.DateContainer;

import org.apache.commons.lang.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.CurrencyResolver;
import com.prowidesoftware.swift.model.field.AmountResolver;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;


/**
 * Field 331<br /><br />
 *
 * validation pattern: 4!n&lt;DATE2&gt;&lt;HHMM&gt;&lt;DATE2&gt;&lt;HHMM&gt;3!n6!n6!n6!n6!n6!n6!n<br />
 * parser pattern: 4!N&lt;DATE2&gt;&lt;HHMM&gt;&lt;DATE2&gt;&lt;HHMM&gt;3!N6!N6!N6!N6!N6!N6!N<br />
 * components pattern: NEHEHNNNNNNN<br />
 *
 * <h1>Components Data types</h1>
 * <ul> 
 * 		<li>component1: <code>Number</code></li> 
 * 		<li>component2: <code>Calendar</code></li> 
 * 		<li>component3: <code>Calendar</code></li> 
 * 		<li>component4: <code>Calendar</code></li> 
 * 		<li>component5: <code>Calendar</code></li> 
 * 		<li>component6: <code>Number</code></li> 
 * 		<li>component7: <code>Number</code></li> 
 * 		<li>component8: <code>Number</code></li> 
 * 		<li>component9: <code>Number</code></li> 
 * 		<li>component10: <code>Number</code></li> 
 * 		<li>component11: <code>Number</code></li> 
 * 		<li>component12: <code>Number</code></li> 
 * </ul>
 *		 
 * <em>NOTE: this source code has been generated from template</em>
 *
 * <em>This class complies with standard release SRU2016</em>
 *
 */
@SuppressWarnings("unused") 
@Generated
public class Field331 extends Field implements Serializable, DateContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 331
	 */
    public static final String NAME = "331";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_331 = "331";
	public static final String PARSER_PATTERN ="4!N<DATE2><HHMM><DATE2><HHMM>3!N6!N6!N6!N6!N6!N6!N";
	public static final String COMPONENTS_PATTERN = "NEHEHNNNNNNN";

	/**
	 * Component number for the Session Number subfield
	 */
	public static final Integer SESSION_NUMBER = 1;

	/**
	 * Component number for the Date Session Opened subfield
	 */
	public static final Integer DATE_SESSION_OPENED = 2;

	/**
	 * Component number for the Time Session Opened subfield
	 */
	public static final Integer TIME_SESSION_OPENED = 3;

	/**
	 * Component number for the Date Session Closed subfield
	 */
	public static final Integer DATE_SESSION_CLOSED = 4;

	/**
	 * Component number for the Time Session Closed subfield
	 */
	public static final Integer TIME_SESSION_CLOSED = 5;

	/**
	 * Component number for the Reason For Closure subfield
	 */
	public static final Integer REASON_FOR_CLOSURE = 6;

	/**
	 * Component number for the Quantity Of Messages Sent subfield
	 */
	public static final Integer QUANTITY_OF_MESSAGES_SENT = 7;

	/**
	 * Component number for the Quantity Of Messages Received subfield
	 */
	public static final Integer QUANTITY_OF_MESSAGES_RECEIVED = 8;

	/**
	 * Component number for the First Input Sequence Number subfield
	 */
	public static final Integer FIRST_INPUT_SEQUENCE_NUMBER = 9;

	/**
	 * Component number for the Last Input Sequence Number subfield
	 */
	public static final Integer LAST_INPUT_SEQUENCE_NUMBER = 10;

	/**
	 * Component number for the First Output Sequence Number subfield
	 */
	public static final Integer FIRST_OUTPUT_SEQUENCE_NUMBER = 11;

	/**
	 * Component number for the Last Output Sequence Number subfield
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
	 * Parses the parameter value into the internal components structure.
	 * Used to update all components from a full new value, as an alternative
	 * to setting individual components. Previous components value is overwritten.
	 * @param value complete field value including separators and CRLF
	 * @since 7.8
	 */
	@Override
	public void parse(final String value) {
		init(12);
		if (value != null) {
        	if (value.length() >= 4) {
				setComponent1(org.apache.commons.lang.StringUtils.substring(value, 0, 4));
			}
        	if (value.length() >= 10) {
				setComponent2(org.apache.commons.lang.StringUtils.substring(value, 4, 10));
			}
        	if (value.length() >= 14) {
				setComponent3(org.apache.commons.lang.StringUtils.substring(value, 10, 14));
			}
			if (value.length() >= 20) {
				setComponent4(org.apache.commons.lang.StringUtils.substring(value, 14, 20));
			}
			if (value.length() >= 24) {
				setComponent5(org.apache.commons.lang.StringUtils.substring(value, 20, 24));
			}
			if (value.length() >= 27) {
				setComponent6(org.apache.commons.lang.StringUtils.substring(value, 24, 27));
			}
			String toparse = org.apache.commons.lang.StringUtils.substring(value, 27);
			SwiftParseUtils.setComponentsFromTokens(this, 7, 12, 6, toparse);			
		}
	}
	
	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field331 newInstance(Field331 source) {
		Field331 cp = new Field331();
		cp.setComponents(new ArrayList<String>(source.getComponents()));
		return cp;
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
	* Create a Tag with this field name and the given value.
	* Shorthand for <code>new Tag(NAME, value)</code>
	* @see #NAME
	* @since 7.5
	*/
	public static Tag tag(final String value) {
		return new Tag(NAME, value);
	}

	/**
	* Create a Tag with this field name and an empty string as value
	* Shorthand for <code>new Tag(NAME, "")</code>
	* @see #NAME
	* @since 7.5
	*/
	public static Tag emptyTag() {
		return new Tag(NAME, "");
	}
	
	/**
	 * Get the component1
	 * @return the component1
	 */
	public String getComponent1() {
		return getComponent(1);
	}

	/**
	 * Get the component1 as Number
	 * @return the component1 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getComponent1AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(1));
	}

	/**
	 * Get the Session Number (component1).
	 * @return the Session Number from component1
	 */
	public String getSessionNumber() {
		return getComponent(1);
	}
	
	/**
	 * Get the Session Number (component1) as Number
	 * @return the Session Number from component1 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getSessionNumberAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(1));
	}

	/**
	 * Set the component1.
	 * @param component1 the component1 to set
	 */
	public Field331 setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the component1 from a Number object.
	 * <br />
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent1(String) 
	 * method.
	 * 
	 * @see #setComponent1(String)
	 *
	 * @param component1 the Number with the component1 content to set
	 */
	public Field331 setComponent1(java.lang.Number component1) {
		if (component1 != null) {
			setComponent(1, ""+component1.intValue());
		}
		return this;
	}
	
	/**
	 * Set the Session Number (component1).
	 * @param component1 the Session Number to set
	 */
	public Field331 setSessionNumber(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Session Number (component1) from a Number object.
	 * @see #setComponent1(java.lang.Number)
	 * @param component1 Number with the Session Number content to set
	 */
	public Field331 setSessionNumber(java.lang.Number component1) {
		setComponent1(component1);
		return this;
	}
	/**
	 * Get the component2
	 * @return the component2
	 */
	public String getComponent2() {
		return getComponent(2);
	}

	/**
	 * Get the component2 as Calendar
	 * @return the component2 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getComponent2AsCalendar() {
		return SwiftFormatUtils.getDate2(getComponent(2));
	}

	/**
	 * Get the Date Session Opened (component2).
	 * @return the Date Session Opened from component2
	 */
	public String getDateSessionOpened() {
		return getComponent(2);
	}
	
	/**
	 * Get the Date Session Opened (component2) as Calendar
	 * @return the Date Session Opened from component2 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getDateSessionOpenedAsCalendar() {
		return SwiftFormatUtils.getDate2(getComponent(2));
	}

	/**
	 * Set the component2.
	 * @param component2 the component2 to set
	 */
	public Field331 setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the component2 from a Calendar object.
	 * @param component2 the Calendar with the component2 content to set
	 */
	public Field331 setComponent2(java.util.Calendar component2) {
		setComponent(2, SwiftFormatUtils.getDate2(component2));
		return this;
	}
	
	/**
	 * Set the Date Session Opened (component2).
	 * @param component2 the Date Session Opened to set
	 */
	public Field331 setDateSessionOpened(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Date Session Opened (component2) from a Calendar object.
	 * @see #setComponent2(java.util.Calendar)
	 * @param component2 Calendar with the Date Session Opened content to set
	 */
	public Field331 setDateSessionOpened(java.util.Calendar component2) {
		setComponent2(component2);
		return this;
	}
	/**
	 * Get the component3
	 * @return the component3
	 */
	public String getComponent3() {
		return getComponent(3);
	}

	/**
	 * Get the component3 as Calendar
	 * @return the component3 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getComponent3AsCalendar() {
		return SwiftFormatUtils.getTime3(getComponent(3));
	}

	/**
	 * Get the Time Session Opened (component3).
	 * @return the Time Session Opened from component3
	 */
	public String getTimeSessionOpened() {
		return getComponent(3);
	}
	
	/**
	 * Get the Time Session Opened (component3) as Calendar
	 * @return the Time Session Opened from component3 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getTimeSessionOpenedAsCalendar() {
		return SwiftFormatUtils.getTime3(getComponent(3));
	}

	/**
	 * Set the component3.
	 * @param component3 the component3 to set
	 */
	public Field331 setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the component3 from a Calendar object.
	 * @param component3 the Calendar with the component3 content to set
	 */
	public Field331 setComponent3(java.util.Calendar component3) {
		setComponent(3, SwiftFormatUtils.getTime3(component3));
		return this;
	}
	
	/**
	 * Set the Time Session Opened (component3).
	 * @param component3 the Time Session Opened to set
	 */
	public Field331 setTimeSessionOpened(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the Time Session Opened (component3) from a Calendar object.
	 * @see #setComponent3(java.util.Calendar)
	 * @param component3 Calendar with the Time Session Opened content to set
	 */
	public Field331 setTimeSessionOpened(java.util.Calendar component3) {
		setComponent3(component3);
		return this;
	}
	/**
	 * Get the component4
	 * @return the component4
	 */
	public String getComponent4() {
		return getComponent(4);
	}

	/**
	 * Get the component4 as Calendar
	 * @return the component4 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getComponent4AsCalendar() {
		return SwiftFormatUtils.getDate2(getComponent(4));
	}

	/**
	 * Get the Date Session Closed (component4).
	 * @return the Date Session Closed from component4
	 */
	public String getDateSessionClosed() {
		return getComponent(4);
	}
	
	/**
	 * Get the Date Session Closed (component4) as Calendar
	 * @return the Date Session Closed from component4 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getDateSessionClosedAsCalendar() {
		return SwiftFormatUtils.getDate2(getComponent(4));
	}

	/**
	 * Set the component4.
	 * @param component4 the component4 to set
	 */
	public Field331 setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the component4 from a Calendar object.
	 * @param component4 the Calendar with the component4 content to set
	 */
	public Field331 setComponent4(java.util.Calendar component4) {
		setComponent(4, SwiftFormatUtils.getDate2(component4));
		return this;
	}
	
	/**
	 * Set the Date Session Closed (component4).
	 * @param component4 the Date Session Closed to set
	 */
	public Field331 setDateSessionClosed(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the Date Session Closed (component4) from a Calendar object.
	 * @see #setComponent4(java.util.Calendar)
	 * @param component4 Calendar with the Date Session Closed content to set
	 */
	public Field331 setDateSessionClosed(java.util.Calendar component4) {
		setComponent4(component4);
		return this;
	}
	/**
	 * Get the component5
	 * @return the component5
	 */
	public String getComponent5() {
		return getComponent(5);
	}

	/**
	 * Get the component5 as Calendar
	 * @return the component5 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getComponent5AsCalendar() {
		return SwiftFormatUtils.getTime3(getComponent(5));
	}

	/**
	 * Get the Time Session Closed (component5).
	 * @return the Time Session Closed from component5
	 */
	public String getTimeSessionClosed() {
		return getComponent(5);
	}
	
	/**
	 * Get the Time Session Closed (component5) as Calendar
	 * @return the Time Session Closed from component5 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getTimeSessionClosedAsCalendar() {
		return SwiftFormatUtils.getTime3(getComponent(5));
	}

	/**
	 * Set the component5.
	 * @param component5 the component5 to set
	 */
	public Field331 setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the component5 from a Calendar object.
	 * @param component5 the Calendar with the component5 content to set
	 */
	public Field331 setComponent5(java.util.Calendar component5) {
		setComponent(5, SwiftFormatUtils.getTime3(component5));
		return this;
	}
	
	/**
	 * Set the Time Session Closed (component5).
	 * @param component5 the Time Session Closed to set
	 */
	public Field331 setTimeSessionClosed(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the Time Session Closed (component5) from a Calendar object.
	 * @see #setComponent5(java.util.Calendar)
	 * @param component5 Calendar with the Time Session Closed content to set
	 */
	public Field331 setTimeSessionClosed(java.util.Calendar component5) {
		setComponent5(component5);
		return this;
	}
	/**
	 * Get the component6
	 * @return the component6
	 */
	public String getComponent6() {
		return getComponent(6);
	}

	/**
	 * Get the component6 as Number
	 * @return the component6 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getComponent6AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(6));
	}

	/**
	 * Get the Reason For Closure (component6).
	 * @return the Reason For Closure from component6
	 */
	public String getReasonForClosure() {
		return getComponent(6);
	}
	
	/**
	 * Get the Reason For Closure (component6) as Number
	 * @return the Reason For Closure from component6 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getReasonForClosureAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(6));
	}

	/**
	 * Set the component6.
	 * @param component6 the component6 to set
	 */
	public Field331 setComponent6(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the component6 from a Number object.
	 * <br />
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent6(String) 
	 * method.
	 * 
	 * @see #setComponent6(String)
	 *
	 * @param component6 the Number with the component6 content to set
	 */
	public Field331 setComponent6(java.lang.Number component6) {
		if (component6 != null) {
			setComponent(6, ""+component6.intValue());
		}
		return this;
	}
	
	/**
	 * Set the Reason For Closure (component6).
	 * @param component6 the Reason For Closure to set
	 */
	public Field331 setReasonForClosure(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the Reason For Closure (component6) from a Number object.
	 * @see #setComponent6(java.lang.Number)
	 * @param component6 Number with the Reason For Closure content to set
	 */
	public Field331 setReasonForClosure(java.lang.Number component6) {
		setComponent6(component6);
		return this;
	}
	/**
	 * Get the component7
	 * @return the component7
	 */
	public String getComponent7() {
		return getComponent(7);
	}

	/**
	 * Get the component7 as Number
	 * @return the component7 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getComponent7AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(7));
	}

	/**
	 * Get the Quantity Of Messages Sent (component7).
	 * @return the Quantity Of Messages Sent from component7
	 */
	public String getQuantityOfMessagesSent() {
		return getComponent(7);
	}
	
	/**
	 * Get the Quantity Of Messages Sent (component7) as Number
	 * @return the Quantity Of Messages Sent from component7 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getQuantityOfMessagesSentAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(7));
	}

	/**
	 * Set the component7.
	 * @param component7 the component7 to set
	 */
	public Field331 setComponent7(String component7) {
		setComponent(7, component7);
		return this;
	}
	
	/**
	 * Set the component7 from a Number object.
	 * <br />
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent7(String) 
	 * method.
	 * 
	 * @see #setComponent7(String)
	 *
	 * @param component7 the Number with the component7 content to set
	 */
	public Field331 setComponent7(java.lang.Number component7) {
		if (component7 != null) {
			setComponent(7, ""+component7.intValue());
		}
		return this;
	}
	
	/**
	 * Set the Quantity Of Messages Sent (component7).
	 * @param component7 the Quantity Of Messages Sent to set
	 */
	public Field331 setQuantityOfMessagesSent(String component7) {
		setComponent(7, component7);
		return this;
	}
	
	/**
	 * Set the Quantity Of Messages Sent (component7) from a Number object.
	 * @see #setComponent7(java.lang.Number)
	 * @param component7 Number with the Quantity Of Messages Sent content to set
	 */
	public Field331 setQuantityOfMessagesSent(java.lang.Number component7) {
		setComponent7(component7);
		return this;
	}
	/**
	 * Get the component8
	 * @return the component8
	 */
	public String getComponent8() {
		return getComponent(8);
	}

	/**
	 * Get the component8 as Number
	 * @return the component8 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getComponent8AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(8));
	}

	/**
	 * Get the Quantity Of Messages Received (component8).
	 * @return the Quantity Of Messages Received from component8
	 */
	public String getQuantityOfMessagesReceived() {
		return getComponent(8);
	}
	
	/**
	 * Get the Quantity Of Messages Received (component8) as Number
	 * @return the Quantity Of Messages Received from component8 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getQuantityOfMessagesReceivedAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(8));
	}

	/**
	 * Set the component8.
	 * @param component8 the component8 to set
	 */
	public Field331 setComponent8(String component8) {
		setComponent(8, component8);
		return this;
	}
	
	/**
	 * Set the component8 from a Number object.
	 * <br />
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent8(String) 
	 * method.
	 * 
	 * @see #setComponent8(String)
	 *
	 * @param component8 the Number with the component8 content to set
	 */
	public Field331 setComponent8(java.lang.Number component8) {
		if (component8 != null) {
			setComponent(8, ""+component8.intValue());
		}
		return this;
	}
	
	/**
	 * Set the Quantity Of Messages Received (component8).
	 * @param component8 the Quantity Of Messages Received to set
	 */
	public Field331 setQuantityOfMessagesReceived(String component8) {
		setComponent(8, component8);
		return this;
	}
	
	/**
	 * Set the Quantity Of Messages Received (component8) from a Number object.
	 * @see #setComponent8(java.lang.Number)
	 * @param component8 Number with the Quantity Of Messages Received content to set
	 */
	public Field331 setQuantityOfMessagesReceived(java.lang.Number component8) {
		setComponent8(component8);
		return this;
	}
	/**
	 * Get the component9
	 * @return the component9
	 */
	public String getComponent9() {
		return getComponent(9);
	}

	/**
	 * Get the component9 as Number
	 * @return the component9 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getComponent9AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(9));
	}

	/**
	 * Get the First Input Sequence Number (component9).
	 * @return the First Input Sequence Number from component9
	 */
	public String getFirstInputSequenceNumber() {
		return getComponent(9);
	}
	
	/**
	 * Get the First Input Sequence Number (component9) as Number
	 * @return the First Input Sequence Number from component9 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getFirstInputSequenceNumberAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(9));
	}

	/**
	 * Set the component9.
	 * @param component9 the component9 to set
	 */
	public Field331 setComponent9(String component9) {
		setComponent(9, component9);
		return this;
	}
	
	/**
	 * Set the component9 from a Number object.
	 * <br />
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent9(String) 
	 * method.
	 * 
	 * @see #setComponent9(String)
	 *
	 * @param component9 the Number with the component9 content to set
	 */
	public Field331 setComponent9(java.lang.Number component9) {
		if (component9 != null) {
			setComponent(9, ""+component9.intValue());
		}
		return this;
	}
	
	/**
	 * Set the First Input Sequence Number (component9).
	 * @param component9 the First Input Sequence Number to set
	 */
	public Field331 setFirstInputSequenceNumber(String component9) {
		setComponent(9, component9);
		return this;
	}
	
	/**
	 * Set the First Input Sequence Number (component9) from a Number object.
	 * @see #setComponent9(java.lang.Number)
	 * @param component9 Number with the First Input Sequence Number content to set
	 */
	public Field331 setFirstInputSequenceNumber(java.lang.Number component9) {
		setComponent9(component9);
		return this;
	}
	/**
	 * Get the component10
	 * @return the component10
	 */
	public String getComponent10() {
		return getComponent(10);
	}

	/**
	 * Get the component10 as Number
	 * @return the component10 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getComponent10AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(10));
	}

	/**
	 * Get the Last Input Sequence Number (component10).
	 * @return the Last Input Sequence Number from component10
	 */
	public String getLastInputSequenceNumber() {
		return getComponent(10);
	}
	
	/**
	 * Get the Last Input Sequence Number (component10) as Number
	 * @return the Last Input Sequence Number from component10 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getLastInputSequenceNumberAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(10));
	}

	/**
	 * Set the component10.
	 * @param component10 the component10 to set
	 */
	public Field331 setComponent10(String component10) {
		setComponent(10, component10);
		return this;
	}
	
	/**
	 * Set the component10 from a Number object.
	 * <br />
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent10(String) 
	 * method.
	 * 
	 * @see #setComponent10(String)
	 *
	 * @param component10 the Number with the component10 content to set
	 */
	public Field331 setComponent10(java.lang.Number component10) {
		if (component10 != null) {
			setComponent(10, ""+component10.intValue());
		}
		return this;
	}
	
	/**
	 * Set the Last Input Sequence Number (component10).
	 * @param component10 the Last Input Sequence Number to set
	 */
	public Field331 setLastInputSequenceNumber(String component10) {
		setComponent(10, component10);
		return this;
	}
	
	/**
	 * Set the Last Input Sequence Number (component10) from a Number object.
	 * @see #setComponent10(java.lang.Number)
	 * @param component10 Number with the Last Input Sequence Number content to set
	 */
	public Field331 setLastInputSequenceNumber(java.lang.Number component10) {
		setComponent10(component10);
		return this;
	}
	/**
	 * Get the component11
	 * @return the component11
	 */
	public String getComponent11() {
		return getComponent(11);
	}

	/**
	 * Get the component11 as Number
	 * @return the component11 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getComponent11AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(11));
	}

	/**
	 * Get the First Output Sequence Number (component11).
	 * @return the First Output Sequence Number from component11
	 */
	public String getFirstOutputSequenceNumber() {
		return getComponent(11);
	}
	
	/**
	 * Get the First Output Sequence Number (component11) as Number
	 * @return the First Output Sequence Number from component11 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getFirstOutputSequenceNumberAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(11));
	}

	/**
	 * Set the component11.
	 * @param component11 the component11 to set
	 */
	public Field331 setComponent11(String component11) {
		setComponent(11, component11);
		return this;
	}
	
	/**
	 * Set the component11 from a Number object.
	 * <br />
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent11(String) 
	 * method.
	 * 
	 * @see #setComponent11(String)
	 *
	 * @param component11 the Number with the component11 content to set
	 */
	public Field331 setComponent11(java.lang.Number component11) {
		if (component11 != null) {
			setComponent(11, ""+component11.intValue());
		}
		return this;
	}
	
	/**
	 * Set the First Output Sequence Number (component11).
	 * @param component11 the First Output Sequence Number to set
	 */
	public Field331 setFirstOutputSequenceNumber(String component11) {
		setComponent(11, component11);
		return this;
	}
	
	/**
	 * Set the First Output Sequence Number (component11) from a Number object.
	 * @see #setComponent11(java.lang.Number)
	 * @param component11 Number with the First Output Sequence Number content to set
	 */
	public Field331 setFirstOutputSequenceNumber(java.lang.Number component11) {
		setComponent11(component11);
		return this;
	}
	/**
	 * Get the component12
	 * @return the component12
	 */
	public String getComponent12() {
		return getComponent(12);
	}

	/**
	 * Get the component12 as Number
	 * @return the component12 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getComponent12AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(12));
	}

	/**
	 * Get the Last Output Sequence Number (component12).
	 * @return the Last Output Sequence Number from component12
	 */
	public String getLastOutputSequenceNumber() {
		return getComponent(12);
	}
	
	/**
	 * Get the Last Output Sequence Number (component12) as Number
	 * @return the Last Output Sequence Number from component12 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getLastOutputSequenceNumberAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(12));
	}

	/**
	 * Set the component12.
	 * @param component12 the component12 to set
	 */
	public Field331 setComponent12(String component12) {
		setComponent(12, component12);
		return this;
	}
	
	/**
	 * Set the component12 from a Number object.
	 * <br />
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent12(String) 
	 * method.
	 * 
	 * @see #setComponent12(String)
	 *
	 * @param component12 the Number with the component12 content to set
	 */
	public Field331 setComponent12(java.lang.Number component12) {
		if (component12 != null) {
			setComponent(12, ""+component12.intValue());
		}
		return this;
	}
	
	/**
	 * Set the Last Output Sequence Number (component12).
	 * @param component12 the Last Output Sequence Number to set
	 */
	public Field331 setLastOutputSequenceNumber(String component12) {
		setComponent(12, component12);
		return this;
	}
	
	/**
	 * Set the Last Output Sequence Number (component12) from a Number object.
	 * @see #setComponent12(java.lang.Number)
	 * @param component12 Number with the Last Output Sequence Number content to set
	 */
	public Field331 setLastOutputSequenceNumber(java.lang.Number component12) {
		setComponent12(component12);
		return this;
	}
    
    public List<Calendar> dates() {
		List<Calendar> result = new java.util.ArrayList<Calendar>();
		result.add(SwiftFormatUtils.getDate2(getComponent(2)));
		result.add(SwiftFormatUtils.getTime3(getComponent(3)));
		result.add(SwiftFormatUtils.getDate2(getComponent(4)));
		result.add(SwiftFormatUtils.getTime3(getComponent(5)));
		return result;
	}

   /**
    * Given a component number it returns true if the component is optional,
    * regardless of the field being mandatory in a particular message.<br />
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
    *
    * @return true if the field is generic, false otherwise
    */
   @Override
   public boolean isGeneric() {   
       return false;
   }
   
   public String parserPattern() {
           return PARSER_PATTERN;
   }

	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field331.NAME
	 */
	@Override
	public String getName() {
		return NAME;
	}
	
	/**
	 * Returns the field's components pattern
	 * @return the static value of Field331.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
	 * Returns the field's validators pattern
	 */
	@Override
	public final String validatorPattern() {
		return "4!n<DATE2><HHMM><DATE2><HHMM>3!n6!n6!n6!n6!n6!n6!n";
	}

	/**
	 * Get the first occurrence form the tag list or null if not found.
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
		return new Field331(t) ;
	}
	
	/**
	 * Get the first instance of Field331 in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field331 get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Get a list of all occurrences of the field Field331 in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static java.util.List<Field331> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Get a list of all occurrences of the field Field331 from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static java.util.List<Field331> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length>0) {
			final java.util.ArrayList<Field331> result = new java.util.ArrayList<Field331>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field331(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
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
			throw new IllegalArgumentException("invalid component number "+component+" for field 331");
		}
		if (locale == null) {
			locale = Locale.getDefault();
		}
		if (component == 1) {
			//number or amount
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(locale);
    		Number n = getComponent1AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 2) {
			//date
			java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, locale);
			java.util.Calendar cal = getComponent2AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		if (component == 3) {
			//time
			java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", locale);
			java.util.Calendar cal = getComponent3AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		if (component == 4) {
			//date
			java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, locale);
			java.util.Calendar cal = getComponent4AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		if (component == 5) {
			//time
			java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", locale);
			java.util.Calendar cal = getComponent5AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		if (component == 6) {
			//number or amount
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(locale);
    		Number n = getComponent6AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 7) {
			//number or amount
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(locale);
    		Number n = getComponent7AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 8) {
			//number or amount
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(locale);
    		Number n = getComponent8AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 9) {
			//number or amount
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(locale);
    		Number n = getComponent9AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 10) {
			//number or amount
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(locale);
    		Number n = getComponent10AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 11) {
			//number or amount
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(locale);
    		Number n = getComponent11AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 12) {
			//number or amount
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(locale);
    		Number n = getComponent12AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		return null;	
	}
	
	/**
	 * Returns english label for components.
	 * <br />
	 * The index in the list is in sync with specific field component structure.
	 * @see #getComponentLabel(int)
	 * @since 7.8.4
	 */
	@Override
	protected List<String> getComponentLabels() {
		List<String> result = new ArrayList<String>();
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
	

}
