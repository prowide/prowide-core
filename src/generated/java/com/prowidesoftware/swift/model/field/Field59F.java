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
import com.prowidesoftware.swift.model.field.MultiLineField;


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 59F</strong>
 * <p>
 * Model and parser for field 59F of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>CUSTOM</code></li>
 * 		<li>parser pattern: <code>[/S$]N/S[$N/S$]0-3</code></li>
 * 		<li>components pattern: <code>SNSNSNSNS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2019</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field59F extends Field implements Serializable, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 59F
	 */
    public static final String NAME = "59F";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_59F = "59F";
	public static final String PARSER_PATTERN ="[/S$]N/S[$N/S$]0-3";
	public static final String COMPONENTS_PATTERN = "SNSNSNSNS";

	/**
	 * Component number for the Account subfield
	 */
	public static final Integer ACCOUNT = 1;

	/**
	 * Component number for the Number 1 subfield
	 */
	public static final Integer NUMBER_1 = 2;

	/**
	 * Component number for the Name And Address 1 subfield
	 */
	public static final Integer NAME_AND_ADDRESS_1 = 3;

	/**
	 * Component number for the Number 2 subfield
	 */
	public static final Integer NUMBER_2 = 4;

	/**
	 * Component number for the Name And Address 2 subfield
	 */
	public static final Integer NAME_AND_ADDRESS_2 = 5;

	/**
	 * Component number for the Number 3 subfield
	 */
	public static final Integer NUMBER_3 = 6;

	/**
	 * Component number for the Name And Address 3 subfield
	 */
	public static final Integer NAME_AND_ADDRESS_3 = 7;

	/**
	 * Component number for the Number 4 subfield
	 */
	public static final Integer NUMBER_4 = 8;

	/**
	 * Component number for the Name And Address 4 subfield
	 */
	public static final Integer NAME_AND_ADDRESS_4 = 9;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field59F() {
		super(9);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field59F(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field59F(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "59F")) {
			throw new IllegalArgumentException("cannot create field 59F from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field59F newInstance(Field59F source) {
		Field59F cp = new Field59F();
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
		init(9);
		List<String> lines = SwiftParseUtils.getLines(value);
		int component = 2;
		for (int i=0; i<lines.size(); i++) {
			if (i == 0 && lines.get(0).startsWith("/")) {
				setComponent1(StringUtils.substring(lines.get(0), 1));
			} else {
				setComponent(component++, SwiftParseUtils.getTokenFirst(lines.get(i), "/"));
				setComponent(component++, SwiftParseUtils.getTokenSecondLast(lines.get(i), "/"));
			}
		}
	}
	/**
	 * Serializes the fields' components into the single string value (SWIFT format)
	 */
	@Override
	public String getValue() {
		final StringBuilder result = new StringBuilder();
		if (getComponent1() != null) {
			result.append("/").append(getComponent1());
		}
		for (int comp = 2; comp<=8; comp++) {
			if (getComponent(comp) != null || getComponent(comp+1) != null) {
				if (result.length() > 0) {
					result.append(com.prowidesoftware.swift.io.writer.FINWriterVisitor.SWIFT_EOL);
				}
				append(result, comp);
				result.append('/');
				append(result, comp+1);
				comp++;
			}
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
		if (component < 1 || component > 9) {
			throw new IllegalArgumentException("invalid component number "+component+" for field 59F");
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
			//number, amount, rate
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
			f.setMaximumFractionDigits(13);
    		Number n = getComponent4AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 5) {
			//default format (as is)
			return getComponent(5);
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
		if (component == 7) {
			//default format (as is)
			return getComponent(7);
		}
		if (component == 8) {
			//number, amount, rate
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
			f.setMaximumFractionDigits(13);
    		Number n = getComponent8AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 9) {
			//default format (as is)
			return getComponent(9);
		}
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field59F.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field59F.PARSER_PATTERN
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
		return "CUSTOM";
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
        if (component == 4) {
            return true;
        }
        if (component == 5) {
            return true;
        }
        if (component == 6) {
            return true;
        }
        if (component == 7) {
            return true;
        }
        if (component == 8) {
            return true;
        }
        if (component == 9) {
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
		return 9;
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
		result.add("Account");
		result.add("Number 1");
		result.add("Name And Address 1");
		result.add("Number 2");
		result.add("Name And Address 2");
		result.add("Number 3");
		result.add("Name And Address 3");
		result.add("Number 4");
		result.add("Name And Address 4");
		return result;
	}

	/**
	 * Returns a mapping between component numbers and their label in camel case format.
	 * @since 7.10.3
	 */
	@Override
	protected Map<Integer, String> getComponentMap() {
		Map<Integer, String> result = new HashMap<>();
		result.put(1, "account");
		result.put(2, "number1");
		result.put(3, "nameAndAddress1");
		result.put(4, "number2");
		result.put(5, "nameAndAddress2");
		result.put(6, "number3");
		result.put(7, "nameAndAddress3");
		result.put(8, "number4");
		result.put(9, "nameAndAddress4");
		return result;
	}
	/**
	 * Gets the component1 (Account).
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
	 * Gets the Account (component1) removing its starting slashes if any.
	 * @return the Account from component1
	 */
	public String getAccount() {
		String c = getComponent(1);
		if (c != null) {
			for (int i=0; i<c.length(); i++) {
				if (c.charAt(i) != '/') {
					return c.substring(i);
				}
			}
			return "";
		}
		return null;
	}
	/**
	 * Gets the component2 (Number 1).
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
	 * Gets the Number 1 (component2).
	 * @return the Number 1 from component2
	 */
	public String getNumber1() {
		return getComponent(2);
	}
	
	/**
	 * Get the Number 1 (component2) as Number
	 * @return the Number 1 from component2 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getNumber1AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(2));
	}
	/**
	 * Gets the component3 (Name And Address 1).
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
	 * Gets the Name And Address 1 (component3).
	 * @return the Name And Address 1 from component3
	 */
	public String getNameAndAddress1() {
		return getComponent(3);
	}
	/**
	 * Gets the component4 (Number 2).
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
	 * Gets the Number 2 (component4).
	 * @return the Number 2 from component4
	 */
	public String getNumber2() {
		return getComponent(4);
	}
	
	/**
	 * Get the Number 2 (component4) as Number
	 * @return the Number 2 from component4 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getNumber2AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(4));
	}
	/**
	 * Gets the component5 (Name And Address 2).
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
	 * Gets the Name And Address 2 (component5).
	 * @return the Name And Address 2 from component5
	 */
	public String getNameAndAddress2() {
		return getComponent(5);
	}
	/**
	 * Gets the component6 (Number 3).
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
	 * Gets the Number 3 (component6).
	 * @return the Number 3 from component6
	 */
	public String getNumber3() {
		return getComponent(6);
	}
	
	/**
	 * Get the Number 3 (component6) as Number
	 * @return the Number 3 from component6 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getNumber3AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(6));
	}
	/**
	 * Gets the component7 (Name And Address 3).
	 * @return the component7
	 */
	public String getComponent7() {
		return getComponent(7);
	}

	/**
	 * Same as getComponent(7)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent7AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent7AsString()", "Use use #getComponent(int) instead.");
		return getComponent(7);
	}

	/**
	 * Gets the Name And Address 3 (component7).
	 * @return the Name And Address 3 from component7
	 */
	public String getNameAndAddress3() {
		return getComponent(7);
	}
	/**
	 * Gets the component8 (Number 4).
	 * @return the component8
	 */
	public String getComponent8() {
		return getComponent(8);
	}

	/**
	 * Get the component8 as Number
	 * @return the component8 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getComponent8AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(8));
	}

	/**
	 * Gets the Number 4 (component8).
	 * @return the Number 4 from component8
	 */
	public String getNumber4() {
		return getComponent(8);
	}
	
	/**
	 * Get the Number 4 (component8) as Number
	 * @return the Number 4 from component8 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getNumber4AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(8));
	}
	/**
	 * Gets the component9 (Name And Address 4).
	 * @return the component9
	 */
	public String getComponent9() {
		return getComponent(9);
	}

	/**
	 * Same as getComponent(9)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent9AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent9AsString()", "Use use #getComponent(int) instead.");
		return getComponent(9);
	}

	/**
	 * Gets the Name And Address 4 (component9).
	 * @return the Name And Address 4 from component9
	 */
	public String getNameAndAddress4() {
		return getComponent(9);
	}


	/**
	 * Set the component1 (Account).
	 * @param component1 the component1 to set
	 */
	public Field59F setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Account (component1).
	 * @param component1 the Account to set
	 */
	public Field59F setAccount(String component1) {
		setComponent(1, component1);
		return this;
	}

	/**
	 * Set the component2 (Number 1).
	 * @param component2 the component2 to set
	 */
	public Field59F setComponent2(String component2) {
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
	public Field59F setComponent2(java.lang.Number component2) {
		if (component2 != null) {
			setComponent(2, Integer.toString(component2.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the Number 1 (component2).
	 * @param component2 the Number 1 to set
	 */
	public Field59F setNumber1(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Number 1 (component2) from a Number object.
	 * @see #setComponent2(java.lang.Number)
	 * @param component2 Number with the Number 1 content to set
	 */
	public Field59F setNumber1(java.lang.Number component2) {
		setComponent2(component2);
		return this;
	}

	/**
	 * Set the component3 (Name And Address 1).
	 * @param component3 the component3 to set
	 */
	public Field59F setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the Name And Address 1 (component3).
	 * @param component3 the Name And Address 1 to set
	 */
	public Field59F setNameAndAddress1(String component3) {
		setComponent(3, component3);
		return this;
	}

	/**
	 * Set the component4 (Number 2).
	 * @param component4 the component4 to set
	 */
	public Field59F setComponent4(String component4) {
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
	public Field59F setComponent4(java.lang.Number component4) {
		if (component4 != null) {
			setComponent(4, Integer.toString(component4.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the Number 2 (component4).
	 * @param component4 the Number 2 to set
	 */
	public Field59F setNumber2(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the Number 2 (component4) from a Number object.
	 * @see #setComponent4(java.lang.Number)
	 * @param component4 Number with the Number 2 content to set
	 */
	public Field59F setNumber2(java.lang.Number component4) {
		setComponent4(component4);
		return this;
	}

	/**
	 * Set the component5 (Name And Address 2).
	 * @param component5 the component5 to set
	 */
	public Field59F setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the Name And Address 2 (component5).
	 * @param component5 the Name And Address 2 to set
	 */
	public Field59F setNameAndAddress2(String component5) {
		setComponent(5, component5);
		return this;
	}

	/**
	 * Set the component6 (Number 3).
	 * @param component6 the component6 to set
	 */
	public Field59F setComponent6(String component6) {
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
	public Field59F setComponent6(java.lang.Number component6) {
		if (component6 != null) {
			setComponent(6, Integer.toString(component6.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the Number 3 (component6).
	 * @param component6 the Number 3 to set
	 */
	public Field59F setNumber3(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the Number 3 (component6) from a Number object.
	 * @see #setComponent6(java.lang.Number)
	 * @param component6 Number with the Number 3 content to set
	 */
	public Field59F setNumber3(java.lang.Number component6) {
		setComponent6(component6);
		return this;
	}

	/**
	 * Set the component7 (Name And Address 3).
	 * @param component7 the component7 to set
	 */
	public Field59F setComponent7(String component7) {
		setComponent(7, component7);
		return this;
	}
	
	/**
	 * Set the Name And Address 3 (component7).
	 * @param component7 the Name And Address 3 to set
	 */
	public Field59F setNameAndAddress3(String component7) {
		setComponent(7, component7);
		return this;
	}

	/**
	 * Set the component8 (Number 4).
	 * @param component8 the component8 to set
	 */
	public Field59F setComponent8(String component8) {
		setComponent(8, component8);
		return this;
	}
	
	/**
	 * Set the component8 from a Number object.
	 * <br>
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent8(String) 
	 * method.
	 * 
	 * @see #setComponent8(String)
	 *
	 * @param component8 the Number with the component8 content to set
	 */
	public Field59F setComponent8(java.lang.Number component8) {
		if (component8 != null) {
			setComponent(8, Integer.toString(component8.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the Number 4 (component8).
	 * @param component8 the Number 4 to set
	 */
	public Field59F setNumber4(String component8) {
		setComponent(8, component8);
		return this;
	}
	
	/**
	 * Set the Number 4 (component8) from a Number object.
	 * @see #setComponent8(java.lang.Number)
	 * @param component8 Number with the Number 4 content to set
	 */
	public Field59F setNumber4(java.lang.Number component8) {
		setComponent8(component8);
		return this;
	}

	/**
	 * Set the component9 (Name And Address 4).
	 * @param component9 the component9 to set
	 */
	public Field59F setComponent9(String component9) {
		setComponent(9, component9);
		return this;
	}
	
	/**
	 * Set the Name And Address 4 (component9).
	 * @param component9 the Name And Address 4 to set
	 */
	public Field59F setNameAndAddress4(String component9) {
		setComponent(9, component9);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field59F.NAME
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
	public static Field59F get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field59F(t) ;
	}
	
	/**
	 * Gets the first instance of Field59F in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field59F get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field59F in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field59F> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field59F from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field59F> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field59F> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field59F(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}
	
	/**
	 * Returns a specific line from the field's value.<br>
	 *
	 * @see MultiLineField#getLine(int)
	 * @param line a reference to a specific line in the field, first line being 1
	 * @return line content or null if not present or if line number is above the expected
	 * @since 7.7
	 */
	public String getLine(int line) {
		return getLine(line, 0);
	}
	
	/**
	 * Returns a specific line from the field's value.<br>
	 * 
	 * @see MultiLineField#getLine(int, int)
	 * @param line a reference to a specific line in the field, first line being 1
	 * @param offset an optional component number used as offset when counting lines
	 * @return line content or null if not present or if line number is above the expected
	 * @since 7.7
	 */
	public String getLine(int line, int offset) {
		Field59F cp = newInstance(this);
		return getLine(cp, line, null, offset);
	}
	
	/**
	 * Returns the field value split into lines.<br>
	 *
	 * @see MultiLineField#getLines()
	 * @return lines content or empty list if field's value is empty
	 * @since 7.7
	 */
	public List<String> getLines() {
		return SwiftParseUtils.getLines(getValue());
	}

	/**
	 * Returns the field value starting at the offset component, split into lines.<br>
	 *
	 * @see MultiLineField#getLines(int)
	 * @param offset an optional component number used as offset when counting lines
	 * @return found lines or empty list if lines are not present or the offset is invalid
	 * @since 7.7
	 */
	public List<String> getLines(int offset) {
		Field59F cp = newInstance(this);
		return SwiftParseUtils.getLines(getLine(cp, null, null, offset));
	}
	
	/**
	 * Returns a specific subset of lines from the field's value, given a range.<br>
	 *
	 * @see MultiLineField#getLinesBetween(int, int )
	 * @param start a reference to a specific line in the field, first line being 1
	 * @param end a reference to a specific line in the field, must be greater than start
	 * @return found lines or empty list if value is empty
	 * @since 7.7
	 */
	public List<String> getLinesBetween(int start, int end) {
		return getLinesBetween(start, end, 0);
	}

	/**
	 * Returns a specific subset of lines from the field's value, starting at the offset component.<br>
	 *
	 * @see MultiLineField#getLinesBetween(int start, int end, int offset)
	 * @param start a reference to a specific line in the field, first line being 1
	 * @param end a reference to a specific line in the field, must be greater than start
	 * @param offset an optional component number used as offset when counting lines
	 * @return found lines or empty list if lines are not present or the offset is invalid
	 * @since 7.7
	 */
	public List<String> getLinesBetween(int start, int end, int offset) {
		Field59F cp = newInstance(this);
		return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
	}

	/**
	 * This method deserializes the JSON data into a Field59F object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field59F fromJson(final String json) {
		Field59F field = new Field59F();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("account") != null) {
			field.setComponent1(jsonObject.get("account").getAsString());
		}
		if (jsonObject.get("number1") != null) {
			field.setComponent2(jsonObject.get("number1").getAsString());
		}
		if (jsonObject.get("nameAndAddress1") != null) {
			field.setComponent3(jsonObject.get("nameAndAddress1").getAsString());
		}
		if (jsonObject.get("number2") != null) {
			field.setComponent4(jsonObject.get("number2").getAsString());
		}
		if (jsonObject.get("nameAndAddress2") != null) {
			field.setComponent5(jsonObject.get("nameAndAddress2").getAsString());
		}
		if (jsonObject.get("number3") != null) {
			field.setComponent6(jsonObject.get("number3").getAsString());
		}
		if (jsonObject.get("nameAndAddress3") != null) {
			field.setComponent7(jsonObject.get("nameAndAddress3").getAsString());
		}
		if (jsonObject.get("number4") != null) {
			field.setComponent8(jsonObject.get("number4").getAsString());
		}
		if (jsonObject.get("nameAndAddress4") != null) {
			field.setComponent9(jsonObject.get("nameAndAddress4").getAsString());
		}
		return field;
	}
	
    /**
     * Get the details (right part of the line) based on the line identification number.
     * This API is specific for the structured field 59F.
     * @param lineIdentifier a line number in the range of 1 to 3
     * @return the details for the found lines or empty list if non is found or the line number is incorrect
     * @since 7.10.4
     */
    public List<String> detailsByNumber(int lineIdentifier) {
		List<String> result = new ArrayList<>();
		String number = String.valueOf(lineIdentifier);
		if (StringUtils.equals(number, getComponent2()) && StringUtils.isNotBlank(getComponent3())) {
			result.add(getComponent3());
		}
		if (StringUtils.equals(number, getComponent4()) && StringUtils.isNotBlank(getComponent5())) {
			result.add(getComponent5());
		}
		if (StringUtils.equals(number, getComponent6()) && StringUtils.isNotBlank(getComponent7())) {
			result.add(getComponent7());
		}
		if (StringUtils.equals(number, getComponent8()) && StringUtils.isNotBlank(getComponent9())) {
			result.add(getComponent9());
		}
		return result;
	}

    /**
     * Check if the line identified by a given number is present.
     * This API is specific for the structured field 59F.
     * @param lineIdentifier a line number in the range of 1 to 3
     * @return true if the structured content includes the line identified by the given number
     * @since 7.10.4
     */
    public boolean contains(int lineIdentifier) {
		String number = String.valueOf(lineIdentifier);
		if (StringUtils.equals(number, getComponent2()) && StringUtils.isNotBlank(getComponent3())) {
			return true;
		}
		if (StringUtils.equals(number, getComponent4()) && StringUtils.isNotBlank(getComponent5())) {
            return true;
		}
		if (StringUtils.equals(number, getComponent6()) && StringUtils.isNotBlank(getComponent7())) {
			return true;
		}
		if (StringUtils.equals(number, getComponent8()) && StringUtils.isNotBlank(getComponent9())) {
			return true;
		}
		return false;
	}
}
