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
 * Field 98E<br /><br />
 *
 * validation pattern: :4!c//&lt;DATE4&gt;&lt;TIME2&gt;[,3n][/[&lt;N&gt;]&lt;TIME3&gt;]<br />
 * parser pattern: :S//&lt;DATE4&gt;&lt;TIME2&gt;[,S][/[c]&lt;TIME3&gt;]<br />
 * components pattern: SDTNCW<br />
 *
 * <h1>Components Data types</h1>
 * <ul> 
 * 		<li>component1: <code>String</code></li> 
 * 		<li>component2: <code>Calendar</code></li> 
 * 		<li>component3: <code>Calendar</code></li> 
 * 		<li>component4: <code>Number</code></li> 
 * 		<li>component5: <code>Currency</code></li> 
 * 		<li>component6: <code>Calendar</code></li> 
 * </ul>
 *		 
 * <em>NOTE: this source code has been generated from template</em>
 *
 * <em>This class complies with standard release SRU2016</em>
 *
 */
@SuppressWarnings("unused") 
@Generated
public class Field98E extends Field implements Serializable, DateContainer, com.prowidesoftware.swift.model.field.GenericField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;

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
	 * Parses the parameter value into the internal components structure.
	 * Used to update all components from a full new value, as an alternative
	 * to setting individual components. Previous components value is overwritten.
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
				setComponent2(org.apache.commons.lang.StringUtils.substring(toparse, 0, 8));
			}
			if (toparse.length() >= 14) {
				setComponent3(org.apache.commons.lang.StringUtils.substring(toparse, 8, 14));
			}
			if (toparse.length() > 14) {
			    String toparse2 = org.apache.commons.lang.StringUtils.substring(toparse, 14);
			    setComponent4(SwiftParseUtils.getTokenFirst(toparse2, ",", "/"));
			    String toparse3 = SwiftParseUtils.getTokenSecondLast(toparse2, "/");
			    if (toparse3 != null) {
				if (toparse3.length() < 2) {
				    setComponent5(toparse3);
				} else if (toparse3.length() == 2) {
				    //HH
				    setComponent6(toparse3);
				} else if (toparse3.length() == 3) {
				    //[N]HH
				    setComponent5(org.apache.commons.lang.StringUtils.substring(toparse3, 0, 1));
				    setComponent6(org.apache.commons.lang.StringUtils.substring(toparse3, 1));
				} else if (toparse3.length() == 4) {
				    //HH[MM]
				    setComponent6(toparse3);
				} else if (toparse3.length() == 5) {
				    //[N]HH[MM]
				    setComponent5(org.apache.commons.lang.StringUtils.substring(toparse3, 0, 1));
				    setComponent6(org.apache.commons.lang.StringUtils.substring(toparse3, 1));
				} if (toparse3.length() > 4) {
				    setComponent5(SwiftParseUtils.getAlphaPrefix(toparse3));
				    setComponent6(SwiftParseUtils.getNumericSuffix(toparse3));
				}
			    }
			}
		}
	}
	
	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field98E newInstance(Field98E source) {
		Field98E cp = new Field98E();
		cp.setComponents(new ArrayList<String>(source.getComponents()));
		return cp;
	}
	
	/**
	 * Serializes the fields' components into the single string value (SWIFT format)
	 */
	@Override
	public String getValue() {
		final StringBuilder result = new StringBuilder();
		result.append(":");
		result.append(StringUtils.trimToEmpty(getComponent1()));
		result.append("//");
		result.append(StringUtils.trimToEmpty(getComponent2()));
		result.append(StringUtils.trimToEmpty(getComponent3()));
        if (StringUtils.isNotEmpty(getComponent4())) {
            result.append(",");
            result.append(StringUtils.trimToEmpty(getComponent4()));
        }
        if (StringUtils.isNotEmpty(getComponent6())) {
            result.append("/");
            result.append(StringUtils.trimToEmpty(getComponent5()));
            result.append(StringUtils.trimToEmpty(getComponent6()));
        }
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
	 * Same as getComponent(1)
	 */
	@Deprecated
	public java.lang.String getComponent1AsString() {
		return getComponent(1);
	}

	/**
	 * Get the Qualifier (component1).
	 * @return the Qualifier from component1
	 */
	public String getQualifier() {
		return getComponent(1);
	}

	/**
	 * Set the component1.
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
		return SwiftFormatUtils.getDate4(getComponent(2));
	}

	/**
	 * Get the Date (component2).
	 * @return the Date from component2
	 */
	public String getDate() {
		return getComponent(2);
	}
	
	/**
	 * Get the Date (component2) as Calendar
	 * @return the Date from component2 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getDateAsCalendar() {
		return SwiftFormatUtils.getDate4(getComponent(2));
	}

	/**
	 * Set the component2.
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
		return SwiftFormatUtils.getTime2(getComponent(3));
	}

	/**
	 * Get the Time (component3).
	 * @return the Time from component3
	 */
	public String getTime() {
		return getComponent(3);
	}
	
	/**
	 * Get the Time (component3) as Calendar
	 * @return the Time from component3 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getTimeAsCalendar() {
		return SwiftFormatUtils.getTime2(getComponent(3));
	}

	/**
	 * Set the component3.
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
	 * Get the component4
	 * @return the component4
	 */
	public String getComponent4() {
		return getComponent(4);
	}

	/**
	 * Get the component4 as Number
	 * @return the component4 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getComponent4AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(4));
	}

	/**
	 * Get the Decimals (component4).
	 * @return the Decimals from component4
	 */
	public String getDecimals() {
		return getComponent(4);
	}
	
	/**
	 * Get the Decimals (component4) as Number
	 * @return the Decimals from component4 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getDecimalsAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(4));
	}

	/**
	 * Set the component4.
	 * @param component4 the component4 to set
	 */
	public Field98E setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the component4 from a Number object.
	 * <br />
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
			setComponent(4, ""+component4.intValue());
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
	 * Get the component5
	 * @return the component5
	 */
	public String getComponent5() {
		return getComponent(5);
	}

	/**
	 * Get the component5 as Currency
	 * @return the component5 converted to Currency or <code>null</code> if cannot be converted
	 */
	public java.util.Currency getComponent5AsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(5));
	}

	/**
	 * Get the Sign (component5).
	 * @return the Sign from component5
	 */
	public String getSign() {
		return getComponent(5);
	}
	
	/**
	 * Get the Sign (component5) as Currency
	 * @return the Sign from component5 converted to Currency or <code>null</code> if cannot be converted
	 */
	public java.util.Currency getSignAsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(5));
	}

	/**
	 * Set the component5.
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
	 * Get the component6
	 * @return the component6
	 */
	public String getComponent6() {
		return getComponent(6);
	}

	/**
	 * Get the component6 as Calendar
	 * @return the component6 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getComponent6AsCalendar() {
		return SwiftFormatUtils.getTime3(getComponent(6));
	}

	/**
	 * Get the UTC Indicator (component6).
	 * @return the UTC Indicator from component6
	 */
	public String getUTCIndicator() {
		return getComponent(6);
	}
	
	/**
	 * Get the UTC Indicator (component6) as Calendar
	 * @return the UTC Indicator from component6 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getUTCIndicatorAsCalendar() {
		return SwiftFormatUtils.getTime3(getComponent(6));
	}

	/**
	 * Set the component6.
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
    
    public List<Calendar> dates() {
		List<Calendar> result = new java.util.ArrayList<Calendar>();
		result.add(SwiftFormatUtils.getDate4(getComponent(2)));
		result.add(SwiftFormatUtils.getTime2(getComponent(3)));
		result.add(SwiftFormatUtils.getTime3(getComponent(6)));
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
    *
    * @return true if the field is generic, false otherwise
    */
   @Override
   public boolean isGeneric() {   
       return true;
   }

   /**
    * Returns the issuer code (or Data Source Scheme or DSS).
    * The DSS is only present in some generic fields, when present, is equals to component two.
    *
    * @return DSS component value or <code>null</code> if the DSS is not set or not available for this field.
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
    * Gets the conditional qualifier.<br />
    * The conditional qualifier is the the component following the DSS of generic fields, being component 2 or 3 depending on the field structure definition.
    *
    * @return for generic fields returns the value of the conditional qualifier or <code>null</code> if not set or not applicable for this kind of field.
    */
   public String getConditionalQualifier() {
       return getComponent(CONDITIONAL_QUALIFIER);
   }
   
   public String parserPattern() {
           return PARSER_PATTERN;
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
	 * Returns the field's components pattern
	 * @return the static value of Field98E.COMPONENTS_PATTERN
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
		return ":4!c//<DATE4><TIME2>[,3n][/[<N>]<TIME3>]";
	}

	/**
	 * Get the first occurrence form the tag list or null if not found.
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
	 * Get the first instance of Field98E in the given message.
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
	 * Get a list of all occurrences of the field Field98E in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static java.util.List<Field98E> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Get a list of all occurrences of the field Field98E from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static java.util.List<Field98E> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length>0) {
			final java.util.ArrayList<Field98E> result = new java.util.ArrayList<Field98E>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field98E(f));
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
		return 6;
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
		if (locale == null) {
			locale = Locale.getDefault();
		}
		if (component == 1) {
			//default format (as is)
			return getComponent(1);
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
			//time with seconds
			java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm:ss", locale);
			java.util.Calendar cal = getComponent3AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		if (component == 4) {
			//number or amount
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(locale);
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
			java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", locale);
			java.util.Calendar cal = getComponent6AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
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
		result.add("Qualifier");
		result.add("Date");
		result.add("Time");
		result.add("Decimals");
		result.add("Sign");
		result.add("UTC Indicator");
		return result;
	}
	

}
