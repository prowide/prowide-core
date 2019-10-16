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


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 98H</strong>
 * <p>
 * Model and parser for field 98H of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>Calendar</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>Currency</code></li>
 * 		<li><code>Calendar</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;TIME2&gt;[,3n][/[&lt;N&gt;]&lt;TIME3&gt;]</code></li>
 * 		<li>parser pattern: <code>&lt;TIME2&gt;[,S][/[c]&lt;TIME3&gt;]</code></li>
 * 		<li>components pattern: <code>TNCW</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2019</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field98H extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 98H
	 */
    public static final String NAME = "98H";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_98H = "98H";
	public static final String PARSER_PATTERN ="<TIME2>[,S][/[c]<TIME3>]";
	public static final String COMPONENTS_PATTERN = "TNCW";

	/**
	 * Component number for the Time subfield
	 */
	public static final Integer TIME = 1;

	/**
	 * Component number for the Number subfield
	 */
	public static final Integer NUMBER = 2;

	/**
	 * Component number for the N subfield
	 */
	public static final Integer N = 3;

	/**
	 * Component number for the Time 2 subfield
	 */
	public static final Integer TIME_2 = 4;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field98H() {
		super(4);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field98H(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field98H(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "98H")) {
			throw new IllegalArgumentException("cannot create field 98H from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field98H newInstance(Field98H source) {
		Field98H cp = new Field98H();
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
		init(4);
		if (value != null) {
			String left;
			String right = null;
			if (value.indexOf('/') >= 0) {
				left = SwiftParseUtils.getTokenFirst(value, "/");
				right = SwiftParseUtils.getTokenSecondLast(value, "/");
			} else {
				left = value;
			}
			setComponent1(SwiftParseUtils.getTokenFirst(left, ","));
			setComponent2(SwiftParseUtils.getTokenSecondLast(left, ","));

			if (right != null) {
				if (right.length() < 2) {
					setComponent3(right);
				} else if (right.length() == 2 || right.length() == 4) {
					//HH or HH[MM]
					setComponent4(right);
				} else if (right.length() == 3 || right.length() == 5) {
					//[N]HH or [N]HH[MM]
					setComponent3(StringUtils.substring(right, 0, 1));
					setComponent4(StringUtils.substring(right, 1));
				} else if (right.length() > 4) {
					setComponent3(SwiftParseUtils.getAlphaPrefix(right));
					setComponent4(SwiftParseUtils.getNumericSuffix(right));
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
		if (getComponent2() != null) {
			result.append(",").append(getComponent2());
		}
		if (getComponent3() != null || getComponent4() != null) {
			result.append("/");
			append(result, 3);
			append(result, 4);
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
		if (component < 1 || component > 4) {
			throw new IllegalArgumentException("invalid component number "+component+" for field 98H");
		}
		if (component == 1) {
			//time with seconds
			java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm:ss", notNull(locale));
			java.util.Calendar cal = getComponent1AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
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
			//time
			java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
			java.util.Calendar cal = getComponent4AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field98H.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field98H.PARSER_PATTERN
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
		return "<TIME2>[,3n][/[<N>]<TIME3>]";
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
		return 4;
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
		result.put(1, "time");
		result.put(2, "number");
		result.put(3, "n");
		result.put(4, "time2");
		return result;
	}
	/**
	 * Gets the component1 (Time).
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
		return SwiftFormatUtils.getTime2(getComponent(1));
	}

	/**
	 * Gets the Time (component1).
	 * @return the Time from component1
	 */
	public String getTime() {
		return getComponent(1);
	}
	
	/**
	 * Get the Time (component1) as Calendar
	 * @return the Time from component1 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getTimeAsCalendar() {
		return SwiftFormatUtils.getTime2(getComponent(1));
	}
	/**
	 * Gets the component2 (Number).
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
	 * Gets the Number (component2).
	 * @return the Number from component2
	 */
	public String getNumber() {
		return getComponent(2);
	}
	
	/**
	 * Get the Number (component2) as Number
	 * @return the Number from component2 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getNumberAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(2));
	}
	/**
	 * Gets the component3 (N).
	 * @return the component3
	 */
	public String getComponent3() {
		return getComponent(3);
	}

	/**
	 * Get the component3 as Currency
	 * @return the component3 converted to Currency or null if cannot be converted
	 */
	public java.util.Currency getComponent3AsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(3));
	}

	/**
	 * Gets the N (component3).
	 * @return the N from component3
	 */
	public String getN() {
		return getComponent(3);
	}
	
	/**
	 * Get the N (component3) as Currency
	 * @return the N from component3 converted to Currency or null if cannot be converted
	 */
	public java.util.Currency getNAsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(3));
	}
	/**
	 * Gets the component4 (Time 2).
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
		return SwiftFormatUtils.getTime3(getComponent(4));
	}

	/**
	 * Gets the Time 2 (component4).
	 * @return the Time 2 from component4
	 */
	public String getTime2() {
		return getComponent(4);
	}
	
	/**
	 * Get the Time 2 (component4) as Calendar
	 * @return the Time 2 from component4 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getTime2AsCalendar() {
		return SwiftFormatUtils.getTime3(getComponent(4));
	}


	/**
	 * Set the component1 (Time).
	 * @param component1 the component1 to set
	 */
	public Field98H setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the component1 from a Calendar object.
	 * @param component1 the Calendar with the component1 content to set
	 */
	public Field98H setComponent1(java.util.Calendar component1) {
		setComponent(1, SwiftFormatUtils.getTime2(component1));
		return this;
	}
	
	/**
	 * Set the Time (component1).
	 * @param component1 the Time to set
	 */
	public Field98H setTime(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Time (component1) from a Calendar object.
	 * @see #setComponent1(java.util.Calendar)
	 * @param component1 Calendar with the Time content to set
	 */
	public Field98H setTime(java.util.Calendar component1) {
		setComponent1(component1);
		return this;
	}

	/**
	 * Set the component2 (Number).
	 * @param component2 the component2 to set
	 */
	public Field98H setComponent2(String component2) {
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
	public Field98H setComponent2(java.lang.Number component2) {
		if (component2 != null) {
			setComponent(2, Integer.toString(component2.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the Number (component2).
	 * @param component2 the Number to set
	 */
	public Field98H setNumber(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Number (component2) from a Number object.
	 * @see #setComponent2(java.lang.Number)
	 * @param component2 Number with the Number content to set
	 */
	public Field98H setNumber(java.lang.Number component2) {
		setComponent2(component2);
		return this;
	}

	/**
	 * Set the component3 (N).
	 * @param component3 the component3 to set
	 */
	public Field98H setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the component3 from a Currency object.
	 * @param component3 the Currency with the component3 content to set
	 */
	public Field98H setComponent3(java.util.Currency component3) {
		setComponent(3, SwiftFormatUtils.getCurrency(component3));
		return this;
	}
	
	/**
	 * Set the N (component3).
	 * @param component3 the N to set
	 */
	public Field98H setN(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the N (component3) from a Currency object.
	 * @see #setComponent3(java.util.Currency)
	 * @param component3 Currency with the N content to set
	 */
	public Field98H setN(java.util.Currency component3) {
		setComponent3(component3);
		return this;
	}

	/**
	 * Set the component4 (Time 2).
	 * @param component4 the component4 to set
	 */
	public Field98H setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the component4 from a Calendar object.
	 * @param component4 the Calendar with the component4 content to set
	 */
	public Field98H setComponent4(java.util.Calendar component4) {
		setComponent(4, SwiftFormatUtils.getTime3(component4));
		return this;
	}
	
	/**
	 * Set the Time 2 (component4).
	 * @param component4 the Time 2 to set
	 */
	public Field98H setTime2(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the Time 2 (component4) from a Calendar object.
	 * @see #setComponent4(java.util.Calendar)
	 * @param component4 Calendar with the Time 2 content to set
	 */
	public Field98H setTime2(java.util.Calendar component4) {
		setComponent4(component4);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field98H.NAME
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
	public static Field98H get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field98H(t) ;
	}
	
	/**
	 * Gets the first instance of Field98H in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field98H get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field98H in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field98H> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field98H from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field98H> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field98H> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field98H(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}

	/**
	 * This method deserializes the JSON data into a Field98H object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field98H fromJson(final String json) {
		Field98H field = new Field98H();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("time") != null) {
			field.setComponent1(jsonObject.get("time").getAsString());
		}
		if (jsonObject.get("number") != null) {
			field.setComponent2(jsonObject.get("number").getAsString());
		}
		if (jsonObject.get("n") != null) {
			field.setComponent3(jsonObject.get("n").getAsString());
		}
		if (jsonObject.get("time2") != null) {
			field.setComponent4(jsonObject.get("time2").getAsString());
		}
		return field;
	}
	

}
