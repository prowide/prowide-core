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
 * <strong>SWIFT MT Field 133</strong>
 * <p>
 * Model and parser for field 133 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>Character</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Number</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>1a3!x&lt;CC&gt;4!n</code></li>
 * 		<li>parser pattern: <code>c3!S&lt;CC&gt;N</code></li>
 * 		<li>components pattern: <code>cSKN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2019</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field133 extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 133
	 */
    public static final String NAME = "133";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_133 = "133";
	public static final String PARSER_PATTERN ="c3!S<CC>N";
	public static final String COMPONENTS_PATTERN = "cSKN";

	/**
	 * Component number for the Broadcast Indicator subfield
	 */
	public static final Integer BROADCAST_INDICATOR = 1;

	/**
	 * Component number for the Unsequenced Broadcast subfield
	 */
	public static final Integer UNSEQUENCED_BROADCAST = 2;

	/**
	 * Component number for the Broadcast Issuer subfield
	 */
	public static final Integer BROADCAST_ISSUER = 3;

	/**
	 * Component number for the Broadcast Number subfield
	 */
	public static final Integer BROADCAST_NUMBER = 4;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field133() {
		super(4);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field133(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field133(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "133")) {
			throw new IllegalArgumentException("cannot create field 133 from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field133 newInstance(Field133 source) {
		Field133 cp = new Field133();
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
			final String toparse = SwiftParseUtils.getAlphaPrefix(value);
			if (toparse != null && toparse.length() > 0) {
				if (toparse.length() > 0) {
					setComponent1(StringUtils.substring(toparse, 0, 1));
					if (toparse.length() >= 4) {
						setComponent2(StringUtils.substring(toparse, 1, 4));
						if (toparse.length() > 4) {
							setComponent3(StringUtils.substring(toparse, 4));
						}
					} else {
						setComponent2(StringUtils.substring(toparse, 1));
					}
				}
			}
			setComponent4(SwiftParseUtils.getNumericSuffix(value));
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
		if (component < 1 || component > 4) {
			throw new IllegalArgumentException("invalid component number "+component+" for field 133");
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
			//number, amount, rate
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
			f.setMaximumFractionDigits(13);
    		Number n = getComponent4AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field133.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field133.PARSER_PATTERN
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
		return "1a3!x<CC>4!n";
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
		result.add("Broadcast Indicator");
		result.add("Unsequenced Broadcast");
		result.add("Broadcast Issuer");
		result.add("Broadcast Number");
		return result;
	}

	/**
	 * Returns a mapping between component numbers and their label in camel case format.
	 * @since 7.10.3
	 */
	@Override
	protected Map<Integer, String> getComponentMap() {
		Map<Integer, String> result = new HashMap<>();
		result.put(1, "broadcastIndicator");
		result.put(2, "unsequencedBroadcast");
		result.put(3, "broadcastIssuer");
		result.put(4, "broadcastNumber");
		return result;
	}
	/**
	 * Gets the component1 (Broadcast Indicator).
	 * @return the component1
	 */
	public String getComponent1() {
		return getComponent(1);
	}

	/**
	 * Gets the Broadcast Indicator (component1).
	 * @return the Broadcast Indicator from component1
	 */
	public String getBroadcastIndicator() {
		return getComponent(1);
	}
	/**
	 * Gets the component2 (Unsequenced Broadcast).
	 * @return the component2
	 */
	public String getComponent2() {
		return getComponent(2);
	}

	/**
	 * Same as getComponent(2)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent2AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent2AsString()", "Use use #getComponent(int) instead.");
		return getComponent(2);
	}

	/**
	 * Gets the Unsequenced Broadcast (component2).
	 * @return the Unsequenced Broadcast from component2
	 */
	public String getUnsequencedBroadcast() {
		return getComponent(2);
	}
	/**
	 * Gets the component3 (Broadcast Issuer).
	 * @return the component3
	 */
	public String getComponent3() {
		return getComponent(3);
	}

	/**
	 * Gets the Broadcast Issuer (component3).
	 * @return the Broadcast Issuer from component3
	 */
	public String getBroadcastIssuer() {
		return getComponent(3);
	}
	/**
	 * Gets the component4 (Broadcast Number).
	 * @return the component4
	 */
	public String getComponent4() {
		return getComponent(4);
	}

	/**
	 * Get the component4 as Number
	 * @return the component4 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getComponent4AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(4));
	}

	/**
	 * Gets the Broadcast Number (component4).
	 * @return the Broadcast Number from component4
	 */
	public String getBroadcastNumber() {
		return getComponent(4);
	}
	
	/**
	 * Get the Broadcast Number (component4) as Number
	 * @return the Broadcast Number from component4 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getBroadcastNumberAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(4));
	}


	/**
	 * Set the component1 (Broadcast Indicator).
	 * @param component1 the component1 to set
	 */
	public Field133 setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Broadcast Indicator (component1).
	 * @param component1 the Broadcast Indicator to set
	 */
	public Field133 setBroadcastIndicator(String component1) {
		setComponent(1, component1);
		return this;
	}

	/**
	 * Set the component2 (Unsequenced Broadcast).
	 * @param component2 the component2 to set
	 */
	public Field133 setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Unsequenced Broadcast (component2).
	 * @param component2 the Unsequenced Broadcast to set
	 */
	public Field133 setUnsequencedBroadcast(String component2) {
		setComponent(2, component2);
		return this;
	}

	/**
	 * Set the component3 (Broadcast Issuer).
	 * @param component3 the component3 to set
	 */
	public Field133 setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the Broadcast Issuer (component3).
	 * @param component3 the Broadcast Issuer to set
	 */
	public Field133 setBroadcastIssuer(String component3) {
		setComponent(3, component3);
		return this;
	}

	/**
	 * Set the component4 (Broadcast Number).
	 * @param component4 the component4 to set
	 */
	public Field133 setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the component4 from a Number object.
	 * <br>
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent4(String) 
	 * method.
	 * 
	 * @see #setComponent4(String)
	 *
	 * @param component4 the Number with the component4 content to set
	 */
	public Field133 setComponent4(java.lang.Number component4) {
		if (component4 != null) {
			setComponent(4, Integer.toString(component4.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the Broadcast Number (component4).
	 * @param component4 the Broadcast Number to set
	 */
	public Field133 setBroadcastNumber(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the Broadcast Number (component4) from a Number object.
	 * @see #setComponent4(java.lang.Number)
	 * @param component4 Number with the Broadcast Number content to set
	 */
	public Field133 setBroadcastNumber(java.lang.Number component4) {
		setComponent4(component4);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field133.NAME
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
	public static Field133 get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field133(t) ;
	}
	
	/**
	 * Gets the first instance of Field133 in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field133 get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field133 in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field133> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field133 from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field133> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field133> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field133(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}

	/**
	 * This method deserializes the JSON data into a Field133 object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field133 fromJson(final String json) {
		Field133 field = new Field133();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("broadcastIndicator") != null) {
			field.setComponent1(jsonObject.get("broadcastIndicator").getAsString());
		}
		if (jsonObject.get("unsequencedBroadcast") != null) {
			field.setComponent2(jsonObject.get("unsequencedBroadcast").getAsString());
		}
		if (jsonObject.get("broadcastIssuer") != null) {
			field.setComponent3(jsonObject.get("broadcastIssuer").getAsString());
		}
		if (jsonObject.get("broadcastNumber") != null) {
			field.setComponent4(jsonObject.get("broadcastNumber").getAsString());
		}
		return field;
	}
	

}
