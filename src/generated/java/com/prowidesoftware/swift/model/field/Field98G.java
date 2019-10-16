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
 * <strong>SWIFT MT Field 98G</strong>
 * <p>
 * Model and parser for field 98G of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>Calendar</code></li>
 * 		<li><code>Calendar</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>Currency</code></li>
 * 		<li><code>Calendar</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;DATE4&gt;&lt;TIME2&gt;[,3n][/[&lt;N&gt;]&lt;TIME3&gt;]</code></li>
 * 		<li>parser pattern: <code>&lt;DATE4&gt;&lt;TIME2&gt;[,S][/[c]&lt;TIME3&gt;]</code></li>
 * 		<li>components pattern: <code>DTNCW</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2019</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field98G extends Field implements Serializable, DateContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 98G
	 */
    public static final String NAME = "98G";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_98G = "98G";
	public static final String PARSER_PATTERN ="<DATE4><TIME2>[,S][/[c]<TIME3>]";
	public static final String COMPONENTS_PATTERN = "DTNCW";

	/**
	 * Component number for the Date subfield
	 */
	public static final Integer DATE = 1;

	/**
	 * Component number for the Time subfield
	 */
	public static final Integer TIME = 2;

	/**
	 * Component number for the Number subfield
	 */
	public static final Integer NUMBER = 3;

	/**
	 * Component number for the N subfield
	 */
	public static final Integer N = 4;

	/**
	 * Component number for the Time 2 subfield
	 */
	public static final Integer TIME_2 = 5;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field98G() {
		super(5);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field98G(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field98G(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "98G")) {
			throw new IllegalArgumentException("cannot create field 98G from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field98G newInstance(Field98G source) {
		Field98G cp = new Field98G();
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
		init(5);
		if (value != null) {
			if (value.length() >= 8) {
				setComponent1(StringUtils.substring(value, 0, 8));
			}
			if (value.length() >= 14) {
				setComponent2(StringUtils.substring(value, 8, 14));
			}
			if (value.length() > 14) {
			    String toparse2 = StringUtils.substring(value, 14);
			    setComponent3(SwiftParseUtils.getTokenFirst(toparse2, ",", "/"));
			    String toparse3 = SwiftParseUtils.getTokenSecondLast(toparse2, "/");
			    if (toparse3 != null) {
					if (toparse3.length() < 2) {
					    setComponent4(toparse3);
					} else if (toparse3.length() == 2 || toparse3.length() == 4) {
					    //HH or HH[MM] 
					    setComponent5(toparse3);
					} else if (toparse3.length() == 3 || toparse3.length() == 5) {
					    //[N]HH or [N]HH[MM]
					    setComponent4(StringUtils.substring(toparse3, 0, 1));
					    setComponent5(StringUtils.substring(toparse3, 1));
					} else if (toparse3.length() > 4) {
					    setComponent4(SwiftParseUtils.getAlphaPrefix(toparse3));
					    setComponent5(SwiftParseUtils.getNumericSuffix(toparse3));
					}
			    }
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
		if (getComponent3() != null) {
			result.append(",").append(getComponent3());
		}
		if (getComponent4() != null || getComponent5() != null) {
			result.append("/");
			append(result, 4);
			append(result, 5);
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
			throw new IllegalArgumentException("invalid component number "+component+" for field 98G");
		}
		if (component == 1) {
			//date
			java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, notNull(locale));
			java.util.Calendar cal = getComponent1AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		if (component == 2) {
			//time with seconds
			java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm:ss", notNull(locale));
			java.util.Calendar cal = getComponent2AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		if (component == 3) {
			//number, amount, rate
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
			f.setMaximumFractionDigits(13);
    		Number n = getComponent3AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 4) {
			//default format (as is)
			return getComponent(4);
		}
		if (component == 5) {
			//time
			java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
			java.util.Calendar cal = getComponent5AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field98G.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field98G.PARSER_PATTERN
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
		return "<DATE4><TIME2>[,3n][/[<N>]<TIME3>]";
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
	protected List<String> getComponentLabels() {
		List<String> result = new ArrayList<>();
		result.add("Date");
		result.add("Time");
		result.add("Number");
		result.add("N");
		result.add("Time 2");
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
		result.put(2, "time");
		result.put(3, "number");
		result.put(4, "n");
		result.put(5, "time2");
		return result;
	}
	/**
	 * Gets the component1 (Date).
	 * @return the component1
	 */
	public String getComponent1() {
		return getComponent(1);
	}

	/**
	 * Get the component1 as Calendar
	 * @return the component1 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getComponent1AsCalendar() {
		return SwiftFormatUtils.getDate4(getComponent(1));
	}

	/**
	 * Gets the Date (component1).
	 * @return the Date from component1
	 */
	public String getDate() {
		return getComponent(1);
	}
	
	/**
	 * Get the Date (component1) as Calendar
	 * @return the Date from component1 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getDateAsCalendar() {
		return SwiftFormatUtils.getDate4(getComponent(1));
	}
	/**
	 * Gets the component2 (Time).
	 * @return the component2
	 */
	public String getComponent2() {
		return getComponent(2);
	}

	/**
	 * Get the component2 as Calendar
	 * @return the component2 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getComponent2AsCalendar() {
		return SwiftFormatUtils.getTime2(getComponent(2));
	}

	/**
	 * Gets the Time (component2).
	 * @return the Time from component2
	 */
	public String getTime() {
		return getComponent(2);
	}
	
	/**
	 * Get the Time (component2) as Calendar
	 * @return the Time from component2 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getTimeAsCalendar() {
		return SwiftFormatUtils.getTime2(getComponent(2));
	}
	/**
	 * Gets the component3 (Number).
	 * @return the component3
	 */
	public String getComponent3() {
		return getComponent(3);
	}

	/**
	 * Get the component3 as Number
	 * @return the component3 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getComponent3AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(3));
	}

	/**
	 * Gets the Number (component3).
	 * @return the Number from component3
	 */
	public String getNumber() {
		return getComponent(3);
	}
	
	/**
	 * Get the Number (component3) as Number
	 * @return the Number from component3 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getNumberAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(3));
	}
	/**
	 * Gets the component4 (N).
	 * @return the component4
	 */
	public String getComponent4() {
		return getComponent(4);
	}

	/**
	 * Get the component4 as Currency
	 * @return the component4 converted to Currency or null if cannot be converted
	 */
	public java.util.Currency getComponent4AsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(4));
	}

	/**
	 * Gets the N (component4).
	 * @return the N from component4
	 */
	public String getN() {
		return getComponent(4);
	}
	
	/**
	 * Get the N (component4) as Currency
	 * @return the N from component4 converted to Currency or null if cannot be converted
	 */
	public java.util.Currency getNAsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(4));
	}
	/**
	 * Gets the component5 (Time 2).
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
	 * Gets the Time 2 (component5).
	 * @return the Time 2 from component5
	 */
	public String getTime2() {
		return getComponent(5);
	}
	
	/**
	 * Get the Time 2 (component5) as Calendar
	 * @return the Time 2 from component5 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getTime2AsCalendar() {
		return SwiftFormatUtils.getTime3(getComponent(5));
	}
    
    public List<Calendar> dates() {
		List<Calendar> result = new ArrayList<>();
		result.add(SwiftFormatUtils.getDate4(getComponent(1)));
		result.add(SwiftFormatUtils.getTime2(getComponent(2)));
		result.add(SwiftFormatUtils.getTime3(getComponent(5)));
		return result;
	}


	/**
	 * Set the component1 (Date).
	 * @param component1 the component1 to set
	 */
	public Field98G setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the component1 from a Calendar object.
	 * @param component1 the Calendar with the component1 content to set
	 */
	public Field98G setComponent1(java.util.Calendar component1) {
		setComponent(1, SwiftFormatUtils.getDate4(component1));
		return this;
	}
	
	/**
	 * Set the Date (component1).
	 * @param component1 the Date to set
	 */
	public Field98G setDate(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Date (component1) from a Calendar object.
	 * @see #setComponent1(java.util.Calendar)
	 * @param component1 Calendar with the Date content to set
	 */
	public Field98G setDate(java.util.Calendar component1) {
		setComponent1(component1);
		return this;
	}

	/**
	 * Set the component2 (Time).
	 * @param component2 the component2 to set
	 */
	public Field98G setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the component2 from a Calendar object.
	 * @param component2 the Calendar with the component2 content to set
	 */
	public Field98G setComponent2(java.util.Calendar component2) {
		setComponent(2, SwiftFormatUtils.getTime2(component2));
		return this;
	}
	
	/**
	 * Set the Time (component2).
	 * @param component2 the Time to set
	 */
	public Field98G setTime(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Time (component2) from a Calendar object.
	 * @see #setComponent2(java.util.Calendar)
	 * @param component2 Calendar with the Time content to set
	 */
	public Field98G setTime(java.util.Calendar component2) {
		setComponent2(component2);
		return this;
	}

	/**
	 * Set the component3 (Number).
	 * @param component3 the component3 to set
	 */
	public Field98G setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the component3 from a Number object.
	 * <br>
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent3(String) 
	 * method.
	 * 
	 * @see #setComponent3(String)
	 *
	 * @param component3 the Number with the component3 content to set
	 */
	public Field98G setComponent3(java.lang.Number component3) {
		if (component3 != null) {
			setComponent(3, Integer.toString(component3.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the Number (component3).
	 * @param component3 the Number to set
	 */
	public Field98G setNumber(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the Number (component3) from a Number object.
	 * @see #setComponent3(java.lang.Number)
	 * @param component3 Number with the Number content to set
	 */
	public Field98G setNumber(java.lang.Number component3) {
		setComponent3(component3);
		return this;
	}

	/**
	 * Set the component4 (N).
	 * @param component4 the component4 to set
	 */
	public Field98G setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the component4 from a Currency object.
	 * @param component4 the Currency with the component4 content to set
	 */
	public Field98G setComponent4(java.util.Currency component4) {
		setComponent(4, SwiftFormatUtils.getCurrency(component4));
		return this;
	}
	
	/**
	 * Set the N (component4).
	 * @param component4 the N to set
	 */
	public Field98G setN(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the N (component4) from a Currency object.
	 * @see #setComponent4(java.util.Currency)
	 * @param component4 Currency with the N content to set
	 */
	public Field98G setN(java.util.Currency component4) {
		setComponent4(component4);
		return this;
	}

	/**
	 * Set the component5 (Time 2).
	 * @param component5 the component5 to set
	 */
	public Field98G setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the component5 from a Calendar object.
	 * @param component5 the Calendar with the component5 content to set
	 */
	public Field98G setComponent5(java.util.Calendar component5) {
		setComponent(5, SwiftFormatUtils.getTime3(component5));
		return this;
	}
	
	/**
	 * Set the Time 2 (component5).
	 * @param component5 the Time 2 to set
	 */
	public Field98G setTime2(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the Time 2 (component5) from a Calendar object.
	 * @see #setComponent5(java.util.Calendar)
	 * @param component5 Calendar with the Time 2 content to set
	 */
	public Field98G setTime2(java.util.Calendar component5) {
		setComponent5(component5);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field98G.NAME
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
	public static Field98G get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field98G(t) ;
	}
	
	/**
	 * Gets the first instance of Field98G in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field98G get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field98G in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field98G> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field98G from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field98G> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field98G> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field98G(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}

	/**
	 * This method deserializes the JSON data into a Field98G object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field98G fromJson(final String json) {
		Field98G field = new Field98G();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("date") != null) {
			field.setComponent1(jsonObject.get("date").getAsString());
		}
		if (jsonObject.get("time") != null) {
			field.setComponent2(jsonObject.get("time").getAsString());
		}
		if (jsonObject.get("number") != null) {
			field.setComponent3(jsonObject.get("number").getAsString());
		}
		if (jsonObject.get("n") != null) {
			field.setComponent4(jsonObject.get("n").getAsString());
		}
		if (jsonObject.get("time2") != null) {
			field.setComponent5(jsonObject.get("time2").getAsString());
		}
		return field;
	}
	

}
