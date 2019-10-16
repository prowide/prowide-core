/*
 * Copyright 2006-2019 Prowide
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


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 258</strong>
 * <p>
 * Model and parser for field 258 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>LogicalTerminalAddress</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>Calendar</code></li>
 * 		<li><code>Calendar</code></li>
 * 		<li><code>Calendar</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;LT&gt;4!n&lt;MT&gt;&lt;DATE2&gt;[&lt;HHMM&gt;&lt;HHMM&gt;]</code></li>
 * 		<li>parser pattern: <code>&lt;LT&gt;4!N&lt;MT&gt;&lt;DATE2&gt;[&lt;HHMM&gt;&lt;HHMM&gt;]</code></li>
 * 		<li>components pattern: <code>ZNMEHH</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2019</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field258 extends Field implements Serializable, DateContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 258
	 */
    public static final String NAME = "258";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_258 = "258";
	public static final String PARSER_PATTERN ="<LT>4!N<MT><DATE2>[<HHMM><HHMM>]";
	public static final String COMPONENTS_PATTERN = "ZNMEHH";

	/**
	 * Component number for the LT Address subfield
	 */
	public static final Integer LT_ADDRESS = 1;

	/**
	 * Component number for the Session Number subfield
	 */
	public static final Integer SESSION_NUMBER = 2;

	/**
	 * Component number for the Message Type subfield
	 */
	public static final Integer MESSAGE_TYPE = 3;

	/**
	 * Component number for the Date subfield
	 */
	public static final Integer DATE = 4;

	/**
	 * Component number for the Start Time subfield
	 */
	public static final Integer START_TIME = 5;

	/**
	 * Component number for the End Time subfield
	 */
	public static final Integer END_TIME = 6;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field258() {
		super(6);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field258(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field258(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "258")) {
			throw new IllegalArgumentException("cannot create field 258 from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field258 newInstance(Field258 source) {
		Field258 cp = new Field258();
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
	 * Create a Tag with this field name and an empty string as value
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
	        if (value.length() >= 19) {
				setComponent3(StringUtils.substring(value, 16, 19));
			}
	        if (value.length() >= 25) {
				setComponent4(StringUtils.substring(value, 19, 25));
			}
			if (value.length() >= 29) {
				setComponent5(StringUtils.substring(value, 25, 29));
			}
			if (value.length() > 29) {
				setComponent6(StringUtils.substring(value, 29));
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
		append(result, 6);
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
			throw new IllegalArgumentException("invalid component number "+component+" for field 258");
		}
		if (component == 1) {
			//default format (as is)
			return getComponent(1);
		}
		if (component == 2) {
			//number, amount, rate
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
			f.setMaximumFractionDigits(13);
    		Number n = getComponent2AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 3) {
			//default format (as is)
			return getComponent(3);
		}
		if (component == 4) {
			//date
			java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, notNull(locale));
			java.util.Calendar cal = getComponent4AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		if (component == 5) {
			//time
			java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
			java.util.Calendar cal = getComponent5AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		if (component == 6) {
			//time
			java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
			java.util.Calendar cal = getComponent6AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field258.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field258.PARSER_PATTERN
     */
	@Override
	public final String parserPattern() {
        return PARSER_PATTERN;
    }

	/**
	 * Returns the field validator pattern
	 */
	@Override
	public final String validatorPattern() {
		return "<LT>4!n<MT><DATE2>[<HHMM><HHMM>]";
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
	protected List<String> getComponentLabels() {
		List<String> result = new ArrayList<>();
		result.add("LT Address");
		result.add("Session Number");
		result.add("Message Type");
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
		result.put(3, "messageType");
		result.put(4, "date");
		result.put(5, "startTime");
		result.put(6, "endTime");
		return result;
	}
	/**
	 * Gets the component1 (LT Address).
	 * @return the component1
	 */
	public String getComponent1() {
		return getComponent(1);
	}

	/**
	 * Get the component1 as LogicalTerminalAddress
	 * @return the component1 converted to LogicalTerminalAddress or null if cannot be converted
	 */
	public com.prowidesoftware.swift.model.LogicalTerminalAddress getComponent1AsLogicalTerminalAddress() {
		return SwiftFormatUtils.getLTAddress(getComponent(1));
	}

	/**
	 * Gets the LT Address (component1).
	 * @return the LT Address from component1
	 */
	public String getLTAddress() {
		return getComponent(1);
	}
	
	/**
	 * Get the LT Address (component1) as LogicalTerminalAddress
	 * @return the LT Address from component1 converted to LogicalTerminalAddress or null if cannot be converted
	 */
	public com.prowidesoftware.swift.model.LogicalTerminalAddress getLTAddressAsLogicalTerminalAddress() {
		return SwiftFormatUtils.getLTAddress(getComponent(1));
	}
	/**
	 * Gets the component2 (Session Number).
	 * @return the component2
	 */
	public String getComponent2() {
		return getComponent(2);
	}

	/**
	 * Get the component2 as Number
	 * @return the component2 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getComponent2AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(2));
	}

	/**
	 * Gets the Session Number (component2).
	 * @return the Session Number from component2
	 */
	public String getSessionNumber() {
		return getComponent(2);
	}
	
	/**
	 * Get the Session Number (component2) as Number
	 * @return the Session Number from component2 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getSessionNumberAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(2));
	}
	/**
	 * Gets the component3 (Message Type).
	 * @return the component3
	 */
	public String getComponent3() {
		return getComponent(3);
	}

	/**
	 * Gets the Message Type (component3).
	 * @return the Message Type from component3
	 */
	public String getMessageType() {
		return getComponent(3);
	}
	/**
	 * Gets the component4 (Date).
	 * @return the component4
	 */
	public String getComponent4() {
		return getComponent(4);
	}

	/**
	 * Get the component4 as Calendar
	 * @return the component4 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getComponent4AsCalendar() {
		return SwiftFormatUtils.getDate2(getComponent(4));
	}

	/**
	 * Gets the Date (component4).
	 * @return the Date from component4
	 */
	public String getDate() {
		return getComponent(4);
	}
	
	/**
	 * Get the Date (component4) as Calendar
	 * @return the Date from component4 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getDateAsCalendar() {
		return SwiftFormatUtils.getDate2(getComponent(4));
	}
	/**
	 * Gets the component5 (Start Time).
	 * @return the component5
	 */
	public String getComponent5() {
		return getComponent(5);
	}

	/**
	 * Get the component5 as Calendar
	 * @return the component5 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getComponent5AsCalendar() {
		return SwiftFormatUtils.getTime3(getComponent(5));
	}

	/**
	 * Gets the Start Time (component5).
	 * @return the Start Time from component5
	 */
	public String getStartTime() {
		return getComponent(5);
	}
	
	/**
	 * Get the Start Time (component5) as Calendar
	 * @return the Start Time from component5 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getStartTimeAsCalendar() {
		return SwiftFormatUtils.getTime3(getComponent(5));
	}
	/**
	 * Gets the component6 (End Time).
	 * @return the component6
	 */
	public String getComponent6() {
		return getComponent(6);
	}

	/**
	 * Get the component6 as Calendar
	 * @return the component6 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getComponent6AsCalendar() {
		return SwiftFormatUtils.getTime3(getComponent(6));
	}

	/**
	 * Gets the End Time (component6).
	 * @return the End Time from component6
	 */
	public String getEndTime() {
		return getComponent(6);
	}
	
	/**
	 * Get the End Time (component6) as Calendar
	 * @return the End Time from component6 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getEndTimeAsCalendar() {
		return SwiftFormatUtils.getTime3(getComponent(6));
	}
    
    public List<Calendar> dates() {
		List<Calendar> result = new ArrayList<>();
		result.add(SwiftFormatUtils.getDate2(getComponent(4)));
		result.add(SwiftFormatUtils.getTime3(getComponent(5)));
		result.add(SwiftFormatUtils.getTime3(getComponent(6)));
		return result;
	}


	/**
	 * Set the component1 (LT Address).
	 * @param component1 the component1 to set
	 */
	public Field258 setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the component1 from a LogicalTerminalAddress object.
	 * @param component1 the LogicalTerminalAddress with the component1 content to set
	 */
	public Field258 setComponent1(com.prowidesoftware.swift.model.LogicalTerminalAddress component1) {
		setComponent(1, SwiftFormatUtils.getLTAddress(component1));
		return this;
	}
	
	/**
	 * Set the LT Address (component1).
	 * @param component1 the LT Address to set
	 */
	public Field258 setLTAddress(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the LT Address (component1) from a LogicalTerminalAddress object.
	 * @see #setComponent1(com.prowidesoftware.swift.model.LogicalTerminalAddress)
	 * @param component1 LogicalTerminalAddress with the LT Address content to set
	 */
	public Field258 setLTAddress(com.prowidesoftware.swift.model.LogicalTerminalAddress component1) {
		setComponent1(component1);
		return this;
	}

	/**
	 * Set the component2 (Session Number).
	 * @param component2 the component2 to set
	 */
	public Field258 setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the component2 from a Number object.
	 * <br>
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent2(String) 
	 * method.
	 * 
	 * @see #setComponent2(String)
	 *
	 * @param component2 the Number with the component2 content to set
	 */
	public Field258 setComponent2(java.lang.Number component2) {
		if (component2 != null) {
			setComponent(2, Integer.toString(component2.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the Session Number (component2).
	 * @param component2 the Session Number to set
	 */
	public Field258 setSessionNumber(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Session Number (component2) from a Number object.
	 * @see #setComponent2(java.lang.Number)
	 * @param component2 Number with the Session Number content to set
	 */
	public Field258 setSessionNumber(java.lang.Number component2) {
		setComponent2(component2);
		return this;
	}

	/**
	 * Set the component3 (Message Type).
	 * @param component3 the component3 to set
	 */
	public Field258 setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the Message Type (component3).
	 * @param component3 the Message Type to set
	 */
	public Field258 setMessageType(String component3) {
		setComponent(3, component3);
		return this;
	}

	/**
	 * Set the component4 (Date).
	 * @param component4 the component4 to set
	 */
	public Field258 setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the component4 from a Calendar object.
	 * @param component4 the Calendar with the component4 content to set
	 */
	public Field258 setComponent4(java.util.Calendar component4) {
		setComponent(4, SwiftFormatUtils.getDate2(component4));
		return this;
	}
	
	/**
	 * Set the Date (component4).
	 * @param component4 the Date to set
	 */
	public Field258 setDate(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the Date (component4) from a Calendar object.
	 * @see #setComponent4(java.util.Calendar)
	 * @param component4 Calendar with the Date content to set
	 */
	public Field258 setDate(java.util.Calendar component4) {
		setComponent4(component4);
		return this;
	}

	/**
	 * Set the component5 (Start Time).
	 * @param component5 the component5 to set
	 */
	public Field258 setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the component5 from a Calendar object.
	 * @param component5 the Calendar with the component5 content to set
	 */
	public Field258 setComponent5(java.util.Calendar component5) {
		setComponent(5, SwiftFormatUtils.getTime3(component5));
		return this;
	}
	
	/**
	 * Set the Start Time (component5).
	 * @param component5 the Start Time to set
	 */
	public Field258 setStartTime(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the Start Time (component5) from a Calendar object.
	 * @see #setComponent5(java.util.Calendar)
	 * @param component5 Calendar with the Start Time content to set
	 */
	public Field258 setStartTime(java.util.Calendar component5) {
		setComponent5(component5);
		return this;
	}

	/**
	 * Set the component6 (End Time).
	 * @param component6 the component6 to set
	 */
	public Field258 setComponent6(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the component6 from a Calendar object.
	 * @param component6 the Calendar with the component6 content to set
	 */
	public Field258 setComponent6(java.util.Calendar component6) {
		setComponent(6, SwiftFormatUtils.getTime3(component6));
		return this;
	}
	
	/**
	 * Set the End Time (component6).
	 * @param component6 the End Time to set
	 */
	public Field258 setEndTime(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the End Time (component6) from a Calendar object.
	 * @see #setComponent6(java.util.Calendar)
	 * @param component6 Calendar with the End Time content to set
	 */
	public Field258 setEndTime(java.util.Calendar component6) {
		setComponent6(component6);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field258.NAME
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
	public static Field258 get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field258(t) ;
	}
	
	/**
	 * Gets the first instance of Field258 in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field258 get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field258 in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field258> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field258 from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field258> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field258> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field258(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}

	/**
	 * This method deserializes the JSON data into a Field258 object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field258 fromJson(final String json) {
		Field258 field = new Field258();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("lTAddress") != null) {
			field.setComponent1(jsonObject.get("lTAddress").getAsString());
		}
		if (jsonObject.get("sessionNumber") != null) {
			field.setComponent2(jsonObject.get("sessionNumber").getAsString());
		}
		if (jsonObject.get("messageType") != null) {
			field.setComponent3(jsonObject.get("messageType").getAsString());
		}
		if (jsonObject.get("date") != null) {
			field.setComponent4(jsonObject.get("date").getAsString());
		}
		if (jsonObject.get("startTime") != null) {
			field.setComponent5(jsonObject.get("startTime").getAsString());
		}
		if (jsonObject.get("endTime") != null) {
			field.setComponent6(jsonObject.get("endTime").getAsString());
		}
		return field;
	}
	

}
