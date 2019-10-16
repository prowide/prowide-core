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
import com.prowidesoftware.swift.model.field.GenericField;


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 98E</strong>
 * <p>
 * Model and parser for field 98E of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>Calendar</code></li>
 * 		<li><code>Calendar</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>Currency</code></li>
 * 		<li><code>Calendar</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>:4!c//&lt;DATE4&gt;&lt;TIME2&gt;[,3n][/[&lt;N&gt;]&lt;TIME3&gt;]</code></li>
 * 		<li>parser pattern: <code>:S//&lt;DATE4&gt;&lt;TIME2&gt;[,S][/[c]&lt;TIME3&gt;]</code></li>
 * 		<li>components pattern: <code>SDTNCW</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2019</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field98E extends Field implements Serializable, DateContainer, GenericField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 98E
	 */
    public static final String NAME = "98E";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_98E = "98E";
	public static final String PARSER_PATTERN =":S//<DATE4><TIME2>[,S][/[c]<TIME3>]";
	public static final String COMPONENTS_PATTERN = "SDTNCW";

	/**
	 * Component number for the Qualifier subfield
	 */
	public static final Integer QUALIFIER = 1;

	/**
	 * Component number for the Date subfield
	 */
	public static final Integer DATE = 2;

	/**
	 * Component number for the Time subfield
	 */
	public static final Integer TIME = 3;

	/**
	 * Component number for the Decimals subfield
	 */
	public static final Integer DECIMALS = 4;

	/**
	 * Component number for the Sign subfield
	 */
	public static final Integer SIGN = 5;

	/**
	 * Component number for the UTC Indicator subfield
	 */
	public static final Integer UTC_INDICATOR = 6;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field98E() {
		super(6);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field98E(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field98E(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "98E")) {
			throw new IllegalArgumentException("cannot create field 98E from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field98E newInstance(Field98E source) {
		Field98E cp = new Field98E();
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
		setComponent1(SwiftParseUtils.getTokenFirst(value, ":", "//"));
		String toparse = SwiftParseUtils.getTokenSecondLast(value, "//"); /* <DATE4><TIME2>[,S][/[c]<TIME3>] */
		if (toparse != null) {
			if (toparse.length() >= 8) {
				setComponent2(StringUtils.substring(toparse, 0, 8));
			}
			if (toparse.length() >= 14) {
				setComponent3(StringUtils.substring(toparse, 8, 14));
			}
			if (toparse.length() > 14) {
			    String toparse2 = StringUtils.substring(toparse, 14);
			    setComponent4(SwiftParseUtils.getTokenFirst(toparse2, ",", "/"));
			    String toparse3 = SwiftParseUtils.getTokenSecondLast(toparse2, "/");
			    if (toparse3 != null) {
					if (toparse3.length() < 2) {
					    setComponent5(toparse3);
					} else if (toparse3.length() == 2 || toparse3.length() == 4) {
					    //HH or HH[MM]
					    setComponent6(toparse3);
					} else if (toparse3.length() == 3 || toparse3.length() == 5) {
					    //[N]HH or [N]HH[MM]
					    setComponent5(StringUtils.substring(toparse3, 0, 1));
					    setComponent6(StringUtils.substring(toparse3, 1));
					} else if (toparse3.length() > 4) {
					    setComponent5(SwiftParseUtils.getAlphaPrefix(toparse3));
					    setComponent6(SwiftParseUtils.getNumericSuffix(toparse3));
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
		result.append(":");
		append(result, 1);
		result.append("//");
		append(result, 2);
		append(result, 3);
        if (getComponent4() != null) {
            result.append(",").append(getComponent4());
        }
        if (getComponent5() != null || getComponent6() != null) {
            result.append("/");
            append(result, 5);
            append(result, 6);
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
		if (component < 1 || component > 6) {
			throw new IllegalArgumentException("invalid component number "+component+" for field 98E");
		}
		if (component == 1) {
			//default format (as is)
			return getComponent(1);
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
			//time with seconds
			java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm:ss", notNull(locale));
			java.util.Calendar cal = getComponent3AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
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
			//default format (as is)
			return getComponent(5);
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
	 * @return the static value of Field98E.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field98E.PARSER_PATTERN
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
		return ":4!c//<DATE4><TIME2>[,3n][/[<N>]<TIME3>]";
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
        if (component == 4) {
            return true;
        }
        if (component == 5) {
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
        return true;
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
		result.add("Qualifier");
		result.add("Date");
		result.add("Time");
		result.add("Decimals");
		result.add("Sign");
		result.add("UTC Indicator");
		return result;
	}

	/**
	 * Returns a mapping between component numbers and their label in camel case format.
	 * @since 7.10.3
	 */
	@Override
	protected Map<Integer, String> getComponentMap() {
		Map<Integer, String> result = new HashMap<>();
		result.put(1, "qualifier");
		result.put(2, "date");
		result.put(3, "time");
		result.put(4, "decimals");
		result.put(5, "sign");
		result.put(6, "uTCIndicator");
		return result;
	}
	/**
	 * Gets the component1 (Qualifier).
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
	 * Gets the Qualifier (component1).
	 * @return the Qualifier from component1
	 */
	public String getQualifier() {
		return getComponent(1);
	}
	/**
	 * Gets the component2 (Date).
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
		return SwiftFormatUtils.getDate4(getComponent(2));
	}

	/**
	 * Gets the Date (component2).
	 * @return the Date from component2
	 */
	public String getDate() {
		return getComponent(2);
	}
	
	/**
	 * Get the Date (component2) as Calendar
	 * @return the Date from component2 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getDateAsCalendar() {
		return SwiftFormatUtils.getDate4(getComponent(2));
	}
	/**
	 * Gets the component3 (Time).
	 * @return the component3
	 */
	public String getComponent3() {
		return getComponent(3);
	}

	/**
	 * Get the component3 as Calendar
	 * @return the component3 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getComponent3AsCalendar() {
		return SwiftFormatUtils.getTime2(getComponent(3));
	}

	/**
	 * Gets the Time (component3).
	 * @return the Time from component3
	 */
	public String getTime() {
		return getComponent(3);
	}
	
	/**
	 * Get the Time (component3) as Calendar
	 * @return the Time from component3 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getTimeAsCalendar() {
		return SwiftFormatUtils.getTime2(getComponent(3));
	}
	/**
	 * Gets the component4 (Decimals).
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
	 * Gets the Decimals (component4).
	 * @return the Decimals from component4
	 */
	public String getDecimals() {
		return getComponent(4);
	}
	
	/**
	 * Get the Decimals (component4) as Number
	 * @return the Decimals from component4 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getDecimalsAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(4));
	}
	/**
	 * Gets the component5 (Sign).
	 * @return the component5
	 */
	public String getComponent5() {
		return getComponent(5);
	}

	/**
	 * Get the component5 as Currency
	 * @return the component5 converted to Currency or null if cannot be converted
	 */
	public java.util.Currency getComponent5AsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(5));
	}

	/**
	 * Gets the Sign (component5).
	 * @return the Sign from component5
	 */
	public String getSign() {
		return getComponent(5);
	}
	
	/**
	 * Get the Sign (component5) as Currency
	 * @return the Sign from component5 converted to Currency or null if cannot be converted
	 */
	public java.util.Currency getSignAsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(5));
	}
	/**
	 * Gets the component6 (UTC Indicator).
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
	 * Gets the UTC Indicator (component6).
	 * @return the UTC Indicator from component6
	 */
	public String getUTCIndicator() {
		return getComponent(6);
	}
	
	/**
	 * Get the UTC Indicator (component6) as Calendar
	 * @return the UTC Indicator from component6 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getUTCIndicatorAsCalendar() {
		return SwiftFormatUtils.getTime3(getComponent(6));
	}
    
    public List<Calendar> dates() {
		List<Calendar> result = new ArrayList<>();
		result.add(SwiftFormatUtils.getDate4(getComponent(2)));
		result.add(SwiftFormatUtils.getTime2(getComponent(3)));
		result.add(SwiftFormatUtils.getTime3(getComponent(6)));
		return result;
	}


	/**
	 * Set the component1 (Qualifier).
	 * @param component1 the component1 to set
	 */
	public Field98E setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Qualifier (component1).
	 * @param component1 the Qualifier to set
	 */
	public Field98E setQualifier(String component1) {
		setComponent(1, component1);
		return this;
	}

	/**
	 * Set the component2 (Date).
	 * @param component2 the component2 to set
	 */
	public Field98E setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the component2 from a Calendar object.
	 * @param component2 the Calendar with the component2 content to set
	 */
	public Field98E setComponent2(java.util.Calendar component2) {
		setComponent(2, SwiftFormatUtils.getDate4(component2));
		return this;
	}
	
	/**
	 * Set the Date (component2).
	 * @param component2 the Date to set
	 */
	public Field98E setDate(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Date (component2) from a Calendar object.
	 * @see #setComponent2(java.util.Calendar)
	 * @param component2 Calendar with the Date content to set
	 */
	public Field98E setDate(java.util.Calendar component2) {
		setComponent2(component2);
		return this;
	}

	/**
	 * Set the component3 (Time).
	 * @param component3 the component3 to set
	 */
	public Field98E setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the component3 from a Calendar object.
	 * @param component3 the Calendar with the component3 content to set
	 */
	public Field98E setComponent3(java.util.Calendar component3) {
		setComponent(3, SwiftFormatUtils.getTime2(component3));
		return this;
	}
	
	/**
	 * Set the Time (component3).
	 * @param component3 the Time to set
	 */
	public Field98E setTime(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the Time (component3) from a Calendar object.
	 * @see #setComponent3(java.util.Calendar)
	 * @param component3 Calendar with the Time content to set
	 */
	public Field98E setTime(java.util.Calendar component3) {
		setComponent3(component3);
		return this;
	}

	/**
	 * Set the component4 (Decimals).
	 * @param component4 the component4 to set
	 */
	public Field98E setComponent4(String component4) {
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
	public Field98E setComponent4(java.lang.Number component4) {
		if (component4 != null) {
			setComponent(4, Integer.toString(component4.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the Decimals (component4).
	 * @param component4 the Decimals to set
	 */
	public Field98E setDecimals(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the Decimals (component4) from a Number object.
	 * @see #setComponent4(java.lang.Number)
	 * @param component4 Number with the Decimals content to set
	 */
	public Field98E setDecimals(java.lang.Number component4) {
		setComponent4(component4);
		return this;
	}

	/**
	 * Set the component5 (Sign).
	 * @param component5 the component5 to set
	 */
	public Field98E setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the component5 from a Currency object.
	 * @param component5 the Currency with the component5 content to set
	 */
	public Field98E setComponent5(java.util.Currency component5) {
		setComponent(5, SwiftFormatUtils.getCurrency(component5));
		return this;
	}
	
	/**
	 * Set the Sign (component5).
	 * @param component5 the Sign to set
	 */
	public Field98E setSign(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the Sign (component5) from a Currency object.
	 * @see #setComponent5(java.util.Currency)
	 * @param component5 Currency with the Sign content to set
	 */
	public Field98E setSign(java.util.Currency component5) {
		setComponent5(component5);
		return this;
	}

	/**
	 * Set the component6 (UTC Indicator).
	 * @param component6 the component6 to set
	 */
	public Field98E setComponent6(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the component6 from a Calendar object.
	 * @param component6 the Calendar with the component6 content to set
	 */
	public Field98E setComponent6(java.util.Calendar component6) {
		setComponent(6, SwiftFormatUtils.getTime3(component6));
		return this;
	}
	
	/**
	 * Set the UTC Indicator (component6).
	 * @param component6 the UTC Indicator to set
	 */
	public Field98E setUTCIndicator(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the UTC Indicator (component6) from a Calendar object.
	 * @see #setComponent6(java.util.Calendar)
	 * @param component6 Calendar with the UTC Indicator content to set
	 */
	public Field98E setUTCIndicator(java.util.Calendar component6) {
		setComponent6(component6);
		return this;
	}


   /**
    * Returns the issuer code (or Data Source Scheme or DSS).
    * The DSS is only present in some generic fields, when present, is equals to component two.
    *
    * @return DSS component value or null if the DSS is not set or not available for this field.
    */
   public String getDSS() {
       return null;
   }

   /**
    * Checks if the issuer code (or Data Source Scheme or DSS) is present.
    *
    * @see #getDSS()
    * @return true if DSS is present, false otherwise.
    */
   public boolean isDSSPresent() {
       return getDSS() != null;
   }

	/**
	 * Component number for the conditional qualifier subfield
	 */
    public static final Integer CONDITIONAL_QUALIFIER = 2;
   
   /**
    * Gets the conditional qualifier.<br>
    * The conditional qualifier is the the component following the DSS of generic fields, being component 2 or 3 depending on the field structure definition.
    *
    * @return for generic fields returns the value of the conditional qualifier or null if not set or not applicable for this kind of field.
    */
   public String getConditionalQualifier() {
       return getComponent(CONDITIONAL_QUALIFIER);
   }
   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field98E.NAME
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
	public static Field98E get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field98E(t) ;
	}
	
	/**
	 * Gets the first instance of Field98E in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field98E get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field98E in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field98E> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field98E from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field98E> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field98E> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field98E(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}

	/**
	 * This method deserializes the JSON data into a Field98E object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field98E fromJson(final String json) {
		Field98E field = new Field98E();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("qualifier") != null) {
			field.setComponent1(jsonObject.get("qualifier").getAsString());
		}
		if (jsonObject.get("date") != null) {
			field.setComponent2(jsonObject.get("date").getAsString());
		}
		if (jsonObject.get("time") != null) {
			field.setComponent3(jsonObject.get("time").getAsString());
		}
		if (jsonObject.get("decimals") != null) {
			field.setComponent4(jsonObject.get("decimals").getAsString());
		}
		if (jsonObject.get("sign") != null) {
			field.setComponent5(jsonObject.get("sign").getAsString());
		}
		if (jsonObject.get("uTCIndicator") != null) {
			field.setComponent6(jsonObject.get("uTCIndicator").getAsString());
		}
		return field;
	}
	

}
