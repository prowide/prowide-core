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
 * <strong>SWIFT MT Field 26C</strong>
 * <p>
 * Model and parser for field 26C of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>[3!a]/15x/5!a4!a&lt;VAR-SEQU-4&gt;</code></li>
 * 		<li>parser pattern: <code>[S]/S/5!a4!aS</code></li>
 * 		<li>components pattern: <code>SSSSS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2019</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field26C extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 26C
	 */
    public static final String NAME = "26C";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_26C = "26C";
	public static final String PARSER_PATTERN ="[S]/S/5!a4!aS";
	public static final String COMPONENTS_PATTERN = "SSSSS";

	/**
	 * Component number for the Delivery Details subfield
	 */
	public static final Integer DELIVERY_DETAILS = 1;

	/**
	 * Component number for the Delivery Location subfield
	 */
	public static final Integer DELIVERY_LOCATION = 2;

	/**
	 * Component number for the Allocation subfield
	 */
	public static final Integer ALLOCATION = 3;

	/**
	 * Component number for the Type subfield
	 */
	public static final Integer TYPE = 4;

	/**
	 * Component number for the Denomination Form subfield
	 */
	public static final Integer DENOMINATION_FORM = 5;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field26C() {
		super(5);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field26C(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field26C(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "26C")) {
			throw new IllegalArgumentException("cannot create field 26C from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field26C newInstance(Field26C source) {
		Field26C cp = new Field26C();
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
		setComponent1(SwiftParseUtils.getTokenFirst(value, null, "/"));
		setComponent2(SwiftParseUtils.getTokenSecond(value, "/"));
		String toparse = SwiftParseUtils.getTokenThirdLast(value, "/");
		if (toparse != null) {
			if (toparse.length() < 5) {
				setComponent3(toparse);
			}
			if (toparse.length() >= 5) {
				setComponent3(StringUtils.substring(toparse, 0, 5));
			}
			if (toparse.length() > 5 && toparse.length() < 9) {
				setComponent4(StringUtils.substring(toparse, 5));
			}
			if (toparse.length() >= 9) {
				setComponent4(StringUtils.substring(toparse, 5, 9));
			}
			if (toparse.length() > 9) {
				setComponent5(StringUtils.substring(toparse, 9));
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
		result.append("/");
		append(result, 2);
		result.append("/");
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
			throw new IllegalArgumentException("invalid component number "+component+" for field 26C");
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
			//default format (as is)
			return getComponent(4);
		}
		if (component == 5) {
			//default format (as is)
			return getComponent(5);
		}
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field26C.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field26C.PARSER_PATTERN
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
		return "[3!a]/15x/5!a4!a<VAR-SEQU-4>";
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
        if (component == 1) {
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
		result.add("Delivery Details");
		result.add("Delivery Location");
		result.add("Allocation");
		result.add("Type");
		result.add("Denomination Form");
		return result;
	}

	/**
	 * Returns a mapping between component numbers and their label in camel case format.
	 * @since 7.10.3
	 */
	@Override
	protected Map<Integer, String> getComponentMap() {
		Map<Integer, String> result = new HashMap<>();
		result.put(1, "deliveryDetails");
		result.put(2, "deliveryLocation");
		result.put(3, "allocation");
		result.put(4, "type");
		result.put(5, "denominationForm");
		return result;
	}
	/**
	 * Gets the component1 (Delivery Details).
	 * @return the component1
	 */
	public String getComponent1() {
		return getComponent(1);
	}

	/**
	 * Same as getComponent(1)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent1AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent1AsString()", "Use use #getComponent(int) instead.");
		return getComponent(1);
	}

	/**
	 * Gets the Delivery Details (component1).
	 * @return the Delivery Details from component1
	 */
	public String getDeliveryDetails() {
		return getComponent(1);
	}
	/**
	 * Gets the component2 (Delivery Location).
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
	 * Gets the Delivery Location (component2).
	 * @return the Delivery Location from component2
	 */
	public String getDeliveryLocation() {
		return getComponent(2);
	}
	/**
	 * Gets the component3 (Allocation).
	 * @return the component3
	 */
	public String getComponent3() {
		return getComponent(3);
	}

	/**
	 * Same as getComponent(3)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent3AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent3AsString()", "Use use #getComponent(int) instead.");
		return getComponent(3);
	}

	/**
	 * Gets the Allocation (component3).
	 * @return the Allocation from component3
	 */
	public String getAllocation() {
		return getComponent(3);
	}
	/**
	 * Gets the component4 (Type).
	 * @return the component4
	 */
	public String getComponent4() {
		return getComponent(4);
	}

	/**
	 * Same as getComponent(4)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent4AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent4AsString()", "Use use #getComponent(int) instead.");
		return getComponent(4);
	}

	/**
	 * Gets the Type (component4).
	 * @return the Type from component4
	 */
	public String getType() {
		return getComponent(4);
	}
	/**
	 * Gets the component5 (Denomination Form).
	 * @return the component5
	 */
	public String getComponent5() {
		return getComponent(5);
	}

	/**
	 * Same as getComponent(5)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent5AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent5AsString()", "Use use #getComponent(int) instead.");
		return getComponent(5);
	}

	/**
	 * Gets the Denomination Form (component5).
	 * @return the Denomination Form from component5
	 */
	public String getDenominationForm() {
		return getComponent(5);
	}


	/**
	 * Set the component1 (Delivery Details).
	 * @param component1 the component1 to set
	 */
	public Field26C setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Delivery Details (component1).
	 * @param component1 the Delivery Details to set
	 */
	public Field26C setDeliveryDetails(String component1) {
		setComponent(1, component1);
		return this;
	}

	/**
	 * Set the component2 (Delivery Location).
	 * @param component2 the component2 to set
	 */
	public Field26C setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Delivery Location (component2).
	 * @param component2 the Delivery Location to set
	 */
	public Field26C setDeliveryLocation(String component2) {
		setComponent(2, component2);
		return this;
	}

	/**
	 * Set the component3 (Allocation).
	 * @param component3 the component3 to set
	 */
	public Field26C setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the Allocation (component3).
	 * @param component3 the Allocation to set
	 */
	public Field26C setAllocation(String component3) {
		setComponent(3, component3);
		return this;
	}

	/**
	 * Set the component4 (Type).
	 * @param component4 the component4 to set
	 */
	public Field26C setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the Type (component4).
	 * @param component4 the Type to set
	 */
	public Field26C setType(String component4) {
		setComponent(4, component4);
		return this;
	}

	/**
	 * Set the component5 (Denomination Form).
	 * @param component5 the component5 to set
	 */
	public Field26C setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the Denomination Form (component5).
	 * @param component5 the Denomination Form to set
	 */
	public Field26C setDenominationForm(String component5) {
		setComponent(5, component5);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field26C.NAME
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
	public static Field26C get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field26C(t) ;
	}
	
	/**
	 * Gets the first instance of Field26C in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field26C get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field26C in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field26C> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field26C from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field26C> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field26C> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field26C(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}

	/**
	 * This method deserializes the JSON data into a Field26C object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field26C fromJson(final String json) {
		Field26C field = new Field26C();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("deliveryDetails") != null) {
			field.setComponent1(jsonObject.get("deliveryDetails").getAsString());
		}
		if (jsonObject.get("deliveryLocation") != null) {
			field.setComponent2(jsonObject.get("deliveryLocation").getAsString());
		}
		if (jsonObject.get("allocation") != null) {
			field.setComponent3(jsonObject.get("allocation").getAsString());
		}
		if (jsonObject.get("type") != null) {
			field.setComponent4(jsonObject.get("type").getAsString());
		}
		if (jsonObject.get("denominationForm") != null) {
			field.setComponent5(jsonObject.get("denominationForm").getAsString());
		}
		return field;
	}
	

}
