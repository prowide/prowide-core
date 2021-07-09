/*
 * Copyright 2006-2021 Prowide
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
 * <strong>SWIFT MT Field 11T</strong>
 * <p>
 * Model and parser for field 11T of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>Number</code></li>
 * 		<li><code>Calendar</code></li>
 * 		<li><code>Calendar</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;MT&gt;&lt;DATE4&gt;&lt;HHMM&gt;</code></li>
 * 		<li>parser pattern: <code>3!S&lt;DATE4&gt;&lt;HHMM&gt;</code></li>
 * 		<li>components pattern: <code>NDH</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field11T extends Field implements Serializable, DateContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 11T
	 */
    public static final String NAME = "11T";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_11T = "11T";
	public static final String PARSER_PATTERN ="3!S<DATE4><HHMM>";
	public static final String COMPONENTS_PATTERN = "NDH";

	/**
	 * Component number for the Type subfield
	 */
	public static final Integer TYPE = 1;

	/**
	 * Component number for the Date subfield
	 */
	public static final Integer DATE = 2;

	/**
	 * Component number for the Time subfield
	 */
	public static final Integer TIME = 3;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field11T() {
		super(3);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field11T(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field11T(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "11T")) {
			throw new IllegalArgumentException("cannot create field 11T from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field11T newInstance(Field11T source) {
		Field11T cp = new Field11T();
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
		init(3);
        setComponent1(StringUtils.substring(value, 0, 3));
        setComponent2(StringUtils.substring(value, 3, 11));
        setComponent3(StringUtils.substring(value, 11));
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
			throw new IllegalArgumentException("invalid component number "+component+" for field 11T");
		}
		if (component == 1) {
			//number, amount, rate
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
			f.setMaximumFractionDigits(13);
    		Number n = getComponent1AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 2) {
			//date
			java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, notNull(locale));
			java.util.Calendar cal = getComponent2AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		if (component == 3) {
			//time
			java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
			java.util.Calendar cal = getComponent3AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field11T.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field11T.PARSER_PATTERN
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
		return "<MT><DATE4><HHMM>";
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
	protected List<String> getComponentLabels() {
		List<String> result = new ArrayList<>();
		result.add("Type");
		result.add("Date");
		result.add("Time");
		return result;
	}

	/**
	 * Returns a mapping between component numbers and their label in camel case format.
	 * @since 7.10.3
	 */
	@Override
	protected Map<Integer, String> getComponentMap() {
		Map<Integer, String> result = new HashMap<>();
		result.put(1, "type");
		result.put(2, "date");
		result.put(3, "time");
		return result;
	}
	/**
	 * Gets the component 1 (Type).
	 * @return the component 1
	 */
	public String getComponent1() {
		return getComponent(1);
	}

	/**
	 * Get the component 1 as Number
	 * @return the component 1 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getComponent1AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(1));
	}

	/**
	 * Gets the Type (component 1).
	 * @return the Type from component 1
	 */
	public String getType() {
		return getComponent(1);
	}
	
	/**
	 * Get the Type (component 1) as Number
	 * @return the Type from component 1 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getTypeAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(1));
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
	 * @return the component 2 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getComponent2AsCalendar() {
		return SwiftFormatUtils.getDate4(getComponent(2));
	}

	/**
	 * Gets the Date (component 2).
	 * @return the Date from component 2
	 */
	public String getDate() {
		return getComponent(2);
	}
	
	/**
	 * Get the Date (component 2) as Calendar
	 * @return the Date from component 2 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getDateAsCalendar() {
		return SwiftFormatUtils.getDate4(getComponent(2));
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
		return getComponent(3);
	}
	
	/**
	 * Get the Time (component 3) as Calendar
	 * @return the Time from component 3 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getTimeAsCalendar() {
		return SwiftFormatUtils.getTime3(getComponent(3));
	}
    
    public List<Calendar> dates() {
		List<Calendar> result = new ArrayList<>();
		result.add(SwiftFormatUtils.getDate4(getComponent(2)));
		result.add(SwiftFormatUtils.getTime3(getComponent(3)));
		return result;
	}


	/**
	 * Set the component1 (Type).
	 * @param component1 the component1 to set
	 */
	public Field11T setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the component1 from a Number object.
	 * <br>
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent1(String) 
	 * method.
	 * 
	 * @see #setComponent1(String)
	 *
	 * @param component1 the Number with the component1 content to set
	 */
	public Field11T setComponent1(java.lang.Number component1) {
		if (component1 != null) {
			setComponent(1, Integer.toString(component1.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the Type (component1).
	 * @param component1 the Type to set
	 */
	public Field11T setType(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Type (component1) from a Number object.
	 * @see #setComponent1(java.lang.Number)
	 * @param component1 Number with the Type content to set
	 */
	public Field11T setType(java.lang.Number component1) {
		setComponent1(component1);
		return this;
	}

	/**
	 * Set the component2 (Date).
	 * @param component2 the component2 to set
	 */
	public Field11T setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the component2 from a Calendar object.
	 * @param component2 the Calendar with the component2 content to set
	 */
	public Field11T setComponent2(java.util.Calendar component2) {
		setComponent(2, SwiftFormatUtils.getDate4(component2));
		return this;
	}
	
	/**
	 * Set the Date (component2).
	 * @param component2 the Date to set
	 */
	public Field11T setDate(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Date (component2) from a Calendar object.
	 * @see #setComponent2(java.util.Calendar)
	 * @param component2 Calendar with the Date content to set
	 */
	public Field11T setDate(java.util.Calendar component2) {
		setComponent2(component2);
		return this;
	}

	/**
	 * Set the component3 (Time).
	 * @param component3 the component3 to set
	 */
	public Field11T setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the component3 from a Calendar object.
	 * @param component3 the Calendar with the component3 content to set
	 */
	public Field11T setComponent3(java.util.Calendar component3) {
		setComponent(3, SwiftFormatUtils.getTime3(component3));
		return this;
	}
	
	/**
	 * Set the Time (component3).
	 * @param component3 the Time to set
	 */
	public Field11T setTime(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the Time (component3) from a Calendar object.
	 * @see #setComponent3(java.util.Calendar)
	 * @param component3 Calendar with the Time content to set
	 */
	public Field11T setTime(java.util.Calendar component3) {
		setComponent3(component3);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field11T.NAME
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
	public static Field11T get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field11T(t) ;
	}
	
	/**
	 * Gets the first instance of Field11T in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field11T get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field11T in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field11T> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field11T from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field11T> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field11T> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field11T(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}

	/**
	 * This method deserializes the JSON data into a Field11T object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field11T fromJson(final String json) {
		Field11T field = new Field11T();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("type") != null) {
			field.setComponent1(jsonObject.get("type").getAsString());
		}
		if (jsonObject.get("date") != null) {
			field.setComponent2(jsonObject.get("date").getAsString());
		}
		if (jsonObject.get("time") != null) {
			field.setComponent3(jsonObject.get("time").getAsString());
		}
		return field;
	}
	

}
