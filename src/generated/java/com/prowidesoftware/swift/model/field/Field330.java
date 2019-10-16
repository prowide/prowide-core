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
 * <strong>SWIFT MT Field 330</strong>
 * <p>
 * Model and parser for field 330 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>Number</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>Number</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>4!n6!n6!n6!n6!n1!n</code></li>
 * 		<li>parser pattern: <code>4!N6!N6!N6!N6!N1!N</code></li>
 * 		<li>components pattern: <code>NNNNNN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2019</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field330 extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 330
	 */
    public static final String NAME = "330";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_330 = "330";
	public static final String PARSER_PATTERN ="4!N6!N6!N6!N6!N1!N";
	public static final String COMPONENTS_PATTERN = "NNNNNN";

	/**
	 * Component number for the Session Number subfield
	 */
	public static final Integer SESSION_NUMBER = 1;

	/**
	 * Component number for the ISN subfield
	 */
	public static final Integer ISN = 2;

	/**
	 * Component number for the ISN NAK subfield
	 */
	public static final Integer ISN_NAK = 3;

	/**
	 * Component number for the OSN subfield
	 */
	public static final Integer OSN = 4;

	/**
	 * Component number for the OSN NAK subfield
	 */
	public static final Integer OSN_NAK = 5;

	/**
	 * Component number for the ACK Replay Indicator subfield
	 */
	public static final Integer ACK_REPLAY_INDICATOR = 6;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field330() {
		super(6);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field330(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field330(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "330")) {
			throw new IllegalArgumentException("cannot create field 330 from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field330 newInstance(Field330 source) {
		Field330 cp = new Field330();
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
        	if (value.length() >= 4) {
				setComponent1(StringUtils.substring(value, 0, 4));
			}
        	if (value.length() >= 10) {
				setComponent2(StringUtils.substring(value, 4, 10));
			}
        	if (value.length() >= 16) {
				setComponent3(StringUtils.substring(value, 10, 16));
			}
			if (value.length() >= 22) {
				setComponent4(StringUtils.substring(value, 16, 22));
			}
			if (value.length() >= 28) {
				setComponent5(StringUtils.substring(value, 22, 28));
			}
			if (value.length() > 28) {
				setComponent6(StringUtils.substring(value, 28));
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
			throw new IllegalArgumentException("invalid component number "+component+" for field 330");
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
			//number, amount, rate
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
			f.setMaximumFractionDigits(13);
    		Number n = getComponent2AsNumber();
			if (n != null) {
				return f.format(n);
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
			//number, amount, rate
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
			f.setMaximumFractionDigits(13);
    		Number n = getComponent4AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 5) {
			//number, amount, rate
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
			f.setMaximumFractionDigits(13);
    		Number n = getComponent5AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 6) {
			//number, amount, rate
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
			f.setMaximumFractionDigits(13);
    		Number n = getComponent6AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field330.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field330.PARSER_PATTERN
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
		return "4!n6!n6!n6!n6!n1!n";
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
		result.add("Session Number");
		result.add("ISN");
		result.add("ISN NAK");
		result.add("OSN");
		result.add("OSN NAK");
		result.add("ACK Replay Indicator");
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
		result.put(2, "iSN");
		result.put(3, "iSNNAK");
		result.put(4, "oSN");
		result.put(5, "oSNNAK");
		result.put(6, "aCKReplayIndicator");
		return result;
	}
	/**
	 * Gets the component1 (Session Number).
	 * @return the component1
	 */
	public String getComponent1() {
		return getComponent(1);
	}

	/**
	 * Get the component1 as Number
	 * @return the component1 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getComponent1AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(1));
	}

	/**
	 * Gets the Session Number (component1).
	 * @return the Session Number from component1
	 */
	public String getSessionNumber() {
		return getComponent(1);
	}
	
	/**
	 * Get the Session Number (component1) as Number
	 * @return the Session Number from component1 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getSessionNumberAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(1));
	}
	/**
	 * Gets the component2 (ISN).
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
	 * Gets the ISN (component2).
	 * @return the ISN from component2
	 */
	public String getISN() {
		return getComponent(2);
	}
	
	/**
	 * Get the ISN (component2) as Number
	 * @return the ISN from component2 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getISNAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(2));
	}
	/**
	 * Gets the component3 (ISN NAK).
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
	 * Gets the ISN NAK (component3).
	 * @return the ISN NAK from component3
	 */
	public String getISNNAK() {
		return getComponent(3);
	}
	
	/**
	 * Get the ISN NAK (component3) as Number
	 * @return the ISN NAK from component3 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getISNNAKAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(3));
	}
	/**
	 * Gets the component4 (OSN).
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
	 * Gets the OSN (component4).
	 * @return the OSN from component4
	 */
	public String getOSN() {
		return getComponent(4);
	}
	
	/**
	 * Get the OSN (component4) as Number
	 * @return the OSN from component4 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getOSNAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(4));
	}
	/**
	 * Gets the component5 (OSN NAK).
	 * @return the component5
	 */
	public String getComponent5() {
		return getComponent(5);
	}

	/**
	 * Get the component5 as Number
	 * @return the component5 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getComponent5AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(5));
	}

	/**
	 * Gets the OSN NAK (component5).
	 * @return the OSN NAK from component5
	 */
	public String getOSNNAK() {
		return getComponent(5);
	}
	
	/**
	 * Get the OSN NAK (component5) as Number
	 * @return the OSN NAK from component5 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getOSNNAKAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(5));
	}
	/**
	 * Gets the component6 (ACK Replay Indicator).
	 * @return the component6
	 */
	public String getComponent6() {
		return getComponent(6);
	}

	/**
	 * Get the component6 as Number
	 * @return the component6 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getComponent6AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(6));
	}

	/**
	 * Gets the ACK Replay Indicator (component6).
	 * @return the ACK Replay Indicator from component6
	 */
	public String getACKReplayIndicator() {
		return getComponent(6);
	}
	
	/**
	 * Get the ACK Replay Indicator (component6) as Number
	 * @return the ACK Replay Indicator from component6 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getACKReplayIndicatorAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(6));
	}


	/**
	 * Set the component1 (Session Number).
	 * @param component1 the component1 to set
	 */
	public Field330 setComponent1(String component1) {
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
	public Field330 setComponent1(java.lang.Number component1) {
		if (component1 != null) {
			setComponent(1, Integer.toString(component1.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the Session Number (component1).
	 * @param component1 the Session Number to set
	 */
	public Field330 setSessionNumber(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Session Number (component1) from a Number object.
	 * @see #setComponent1(java.lang.Number)
	 * @param component1 Number with the Session Number content to set
	 */
	public Field330 setSessionNumber(java.lang.Number component1) {
		setComponent1(component1);
		return this;
	}

	/**
	 * Set the component2 (ISN).
	 * @param component2 the component2 to set
	 */
	public Field330 setComponent2(String component2) {
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
	public Field330 setComponent2(java.lang.Number component2) {
		if (component2 != null) {
			setComponent(2, Integer.toString(component2.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the ISN (component2).
	 * @param component2 the ISN to set
	 */
	public Field330 setISN(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the ISN (component2) from a Number object.
	 * @see #setComponent2(java.lang.Number)
	 * @param component2 Number with the ISN content to set
	 */
	public Field330 setISN(java.lang.Number component2) {
		setComponent2(component2);
		return this;
	}

	/**
	 * Set the component3 (ISN NAK).
	 * @param component3 the component3 to set
	 */
	public Field330 setComponent3(String component3) {
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
	public Field330 setComponent3(java.lang.Number component3) {
		if (component3 != null) {
			setComponent(3, Integer.toString(component3.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the ISN NAK (component3).
	 * @param component3 the ISN NAK to set
	 */
	public Field330 setISNNAK(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the ISN NAK (component3) from a Number object.
	 * @see #setComponent3(java.lang.Number)
	 * @param component3 Number with the ISN NAK content to set
	 */
	public Field330 setISNNAK(java.lang.Number component3) {
		setComponent3(component3);
		return this;
	}

	/**
	 * Set the component4 (OSN).
	 * @param component4 the component4 to set
	 */
	public Field330 setComponent4(String component4) {
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
	public Field330 setComponent4(java.lang.Number component4) {
		if (component4 != null) {
			setComponent(4, Integer.toString(component4.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the OSN (component4).
	 * @param component4 the OSN to set
	 */
	public Field330 setOSN(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the OSN (component4) from a Number object.
	 * @see #setComponent4(java.lang.Number)
	 * @param component4 Number with the OSN content to set
	 */
	public Field330 setOSN(java.lang.Number component4) {
		setComponent4(component4);
		return this;
	}

	/**
	 * Set the component5 (OSN NAK).
	 * @param component5 the component5 to set
	 */
	public Field330 setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the component5 from a Number object.
	 * <br>
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent5(String) 
	 * method.
	 * 
	 * @see #setComponent5(String)
	 *
	 * @param component5 the Number with the component5 content to set
	 */
	public Field330 setComponent5(java.lang.Number component5) {
		if (component5 != null) {
			setComponent(5, Integer.toString(component5.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the OSN NAK (component5).
	 * @param component5 the OSN NAK to set
	 */
	public Field330 setOSNNAK(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the OSN NAK (component5) from a Number object.
	 * @see #setComponent5(java.lang.Number)
	 * @param component5 Number with the OSN NAK content to set
	 */
	public Field330 setOSNNAK(java.lang.Number component5) {
		setComponent5(component5);
		return this;
	}

	/**
	 * Set the component6 (ACK Replay Indicator).
	 * @param component6 the component6 to set
	 */
	public Field330 setComponent6(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the component6 from a Number object.
	 * <br>
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent6(String) 
	 * method.
	 * 
	 * @see #setComponent6(String)
	 *
	 * @param component6 the Number with the component6 content to set
	 */
	public Field330 setComponent6(java.lang.Number component6) {
		if (component6 != null) {
			setComponent(6, Integer.toString(component6.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the ACK Replay Indicator (component6).
	 * @param component6 the ACK Replay Indicator to set
	 */
	public Field330 setACKReplayIndicator(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the ACK Replay Indicator (component6) from a Number object.
	 * @see #setComponent6(java.lang.Number)
	 * @param component6 Number with the ACK Replay Indicator content to set
	 */
	public Field330 setACKReplayIndicator(java.lang.Number component6) {
		setComponent6(component6);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field330.NAME
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
	public static Field330 get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field330(t) ;
	}
	
	/**
	 * Gets the first instance of Field330 in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field330 get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field330 in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field330> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field330 from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field330> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field330> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field330(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}

	/**
	 * This method deserializes the JSON data into a Field330 object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field330 fromJson(final String json) {
		Field330 field = new Field330();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("sessionNumber") != null) {
			field.setComponent1(jsonObject.get("sessionNumber").getAsString());
		}
		if (jsonObject.get("iSN") != null) {
			field.setComponent2(jsonObject.get("iSN").getAsString());
		}
		if (jsonObject.get("iSNNAK") != null) {
			field.setComponent3(jsonObject.get("iSNNAK").getAsString());
		}
		if (jsonObject.get("oSN") != null) {
			field.setComponent4(jsonObject.get("oSN").getAsString());
		}
		if (jsonObject.get("oSNNAK") != null) {
			field.setComponent5(jsonObject.get("oSNNAK").getAsString());
		}
		if (jsonObject.get("aCKReplayIndicator") != null) {
			field.setComponent6(jsonObject.get("aCKReplayIndicator").getAsString());
		}
		return field;
	}
	

}
