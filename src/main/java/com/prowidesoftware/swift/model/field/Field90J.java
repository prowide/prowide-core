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
import java.util.Currency;
import com.prowidesoftware.swift.model.field.CurrencyContainer;
import java.math.BigDecimal;
import com.prowidesoftware.swift.model.field.AmountContainer;

import org.apache.commons.lang.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.CurrencyResolver;
import com.prowidesoftware.swift.model.field.AmountResolver;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;


/**
 * Field 90J<br /><br />
 *
 * validation pattern: :4!c//4!c/&lt;CUR&gt;&lt;AMOUNT&gt;15/&lt;CUR&gt;&lt;AMOUNT&gt;15<br />
 * parser pattern: :S//S/SN/SN<br />
 * components pattern: SSCNCN<br />
 *
 * <h1>Components Data types</h1>
 * <ul> 
 * 		<li>component1: <code>String</code></li> 
 * 		<li>component2: <code>String</code></li> 
 * 		<li>component3: <code>Currency</code></li> 
 * 		<li>component4: <code>Number</code></li> 
 * 		<li>component5: <code>Currency</code></li> 
 * 		<li>component6: <code>Number</code></li> 
 * </ul>
 *		 
 * <em>NOTE: this source code has been generated from template</em>
 *
 * <em>This class complies with standard release SRU2016</em>
 *
 */
@SuppressWarnings("unused") 
@Generated
public class Field90J extends Field implements Serializable, CurrencyContainer, AmountContainer, com.prowidesoftware.swift.model.field.GenericField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 90J
	 */
    public static final String NAME = "90J";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_90J = "90J";
	public static final String PARSER_PATTERN =":S//S/SN/SN";
	public static final String COMPONENTS_PATTERN = "SSCNCN";

	/**
	 * Component number for the Qualifier subfield
	 */
	public static final Integer QUALIFIER = 1;

	/**
	 * Component number for the Code subfield
	 */
	public static final Integer CODE = 2;

	/**
	 * Component number for the Currency1 subfield
	 */
	public static final Integer CURRENCY1 = 3;

	/**
	 * Component number for the Amount1 subfield
	 */
	public static final Integer AMOUNT1 = 4;

	/**
	 * Component number for the Currency2 subfield
	 */
	public static final Integer CURRENCY2 = 5;

	/**
	 * Component number for the Amount2 subfield
	 */
	public static final Integer AMOUNT2 = 6;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field90J() {
		super(6);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field90J(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field90J(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "90J")) {
			throw new IllegalArgumentException("cannot create field 90J from tag "+tag.getName()+", tagname must match the name of the field.");
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
		String toparse = SwiftParseUtils.getTokenSecondLast(value, "//"); /* S/SN/SN */
		setComponent2(SwiftParseUtils.getTokenFirst(toparse, "/"));
		String toparse2 = SwiftParseUtils.getTokenSecondLast(toparse, "/"); /* SN/SN */
		String toparse3 = SwiftParseUtils.getTokenFirst(toparse2, "/"); /* SN */
		setComponent3(SwiftParseUtils.getAlphaPrefix(toparse3));
		setComponent4(SwiftParseUtils.getNumericSuffix(toparse3));
		String toparse4 = SwiftParseUtils.getTokenSecondLast(toparse2, "/"); /* SN */
		setComponent5(SwiftParseUtils.getAlphaPrefix(toparse4));
		setComponent6(SwiftParseUtils.getNumericSuffix(toparse4));
	}
	
	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field90J newInstance(Field90J source) {
		Field90J cp = new Field90J();
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
		result.append("/");
		result.append(StringUtils.trimToEmpty(getComponent3()));
		result.append(StringUtils.trimToEmpty(getComponent4()));
		result.append("/");
		result.append(StringUtils.trimToEmpty(getComponent5()));
		result.append(StringUtils.trimToEmpty(getComponent6()));		
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
	public Field90J setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Qualifier (component1).
	 * @param component1 the Qualifier to set
	 */
	public Field90J setQualifier(String component1) {
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
	 * Same as getComponent(2)
	 */
	@Deprecated
	public java.lang.String getComponent2AsString() {
		return getComponent(2);
	}

	/**
	 * Get the Code (component2).
	 * @return the Code from component2
	 */
	public String getCode() {
		return getComponent(2);
	}

	/**
	 * Set the component2.
	 * @param component2 the component2 to set
	 */
	public Field90J setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Code (component2).
	 * @param component2 the Code to set
	 */
	public Field90J setCode(String component2) {
		setComponent(2, component2);
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
	 * Get the component3 as Currency
	 * @return the component3 converted to Currency or <code>null</code> if cannot be converted
	 */
	public java.util.Currency getComponent3AsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(3));
	}

	/**
	 * Get the Currency1 (component3).
	 * @return the Currency1 from component3
	 */
	public String getCurrency1() {
		return getComponent(3);
	}
	
	/**
	 * Get the Currency1 (component3) as Currency
	 * @return the Currency1 from component3 converted to Currency or <code>null</code> if cannot be converted
	 */
	public java.util.Currency getCurrency1AsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(3));
	}

	/**
	 * Set the component3.
	 * @param component3 the component3 to set
	 */
	public Field90J setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the component3 from a Currency object.
	 * <br />
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -> 1234,</li>
	 * 	<li>Example: 1234 -> 1234,</li>
	 * 	<li>Example: 1234.56 -> 1234,56</li>
	 * </ul>
	 * @param component3 the Currency with the component3 content to set
	 */
	public Field90J setComponent3(java.util.Currency component3) {
		setComponent(3, SwiftFormatUtils.getCurrency(component3));
		return this;
	}
	
	/**
	 * Set the Currency1 (component3).
	 * @param component3 the Currency1 to set
	 */
	public Field90J setCurrency1(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the Currency1 (component3) from a Currency object.
	 * @see #setComponent3(java.util.Currency)
	 * @param component3 Currency with the Currency1 content to set
	 */
	public Field90J setCurrency1(java.util.Currency component3) {
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
	 * Get the Amount1 (component4).
	 * @return the Amount1 from component4
	 */
	public String getAmount1() {
		return getComponent(4);
	}
	
	/**
	 * Get the Amount1 (component4) as Number
	 * @return the Amount1 from component4 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getAmount1AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(4));
	}

	/**
	 * Set the component4.
	 * @param component4 the component4 to set
	 */
	public Field90J setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the component4 from a Number object.
	 * <br />
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -> 1234,</li>
	 * 	<li>Example: 1234 -> 1234,</li>
	 * 	<li>Example: 1234.56 -> 1234,56</li>
	 * </ul>
	 * @param component4 the Number with the component4 content to set
	 */
	public Field90J setComponent4(java.lang.Number component4) {
		setComponent(4, SwiftFormatUtils.getNumber(component4));
		return this;
	}
	
	/**
	 * Set the Amount1 (component4).
	 * @param component4 the Amount1 to set
	 */
	public Field90J setAmount1(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the Amount1 (component4) from a Number object.
	 * @see #setComponent4(java.lang.Number)
	 * @param component4 Number with the Amount1 content to set
	 */
	public Field90J setAmount1(java.lang.Number component4) {
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
	 * Get the Currency2 (component5).
	 * @return the Currency2 from component5
	 */
	public String getCurrency2() {
		return getComponent(5);
	}
	
	/**
	 * Get the Currency2 (component5) as Currency
	 * @return the Currency2 from component5 converted to Currency or <code>null</code> if cannot be converted
	 */
	public java.util.Currency getCurrency2AsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(5));
	}

	/**
	 * Set the component5.
	 * @param component5 the component5 to set
	 */
	public Field90J setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the component5 from a Currency object.
	 * <br />
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -> 1234,</li>
	 * 	<li>Example: 1234 -> 1234,</li>
	 * 	<li>Example: 1234.56 -> 1234,56</li>
	 * </ul>
	 * @param component5 the Currency with the component5 content to set
	 */
	public Field90J setComponent5(java.util.Currency component5) {
		setComponent(5, SwiftFormatUtils.getCurrency(component5));
		return this;
	}
	
	/**
	 * Set the Currency2 (component5).
	 * @param component5 the Currency2 to set
	 */
	public Field90J setCurrency2(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the Currency2 (component5) from a Currency object.
	 * @see #setComponent5(java.util.Currency)
	 * @param component5 Currency with the Currency2 content to set
	 */
	public Field90J setCurrency2(java.util.Currency component5) {
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
	 * Get the component6 as Number
	 * @return the component6 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getComponent6AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(6));
	}

	/**
	 * Get the Amount2 (component6).
	 * @return the Amount2 from component6
	 */
	public String getAmount2() {
		return getComponent(6);
	}
	
	/**
	 * Get the Amount2 (component6) as Number
	 * @return the Amount2 from component6 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getAmount2AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(6));
	}

	/**
	 * Set the component6.
	 * @param component6 the component6 to set
	 */
	public Field90J setComponent6(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the component6 from a Number object.
	 * <br />
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -> 1234,</li>
	 * 	<li>Example: 1234 -> 1234,</li>
	 * 	<li>Example: 1234.56 -> 1234,56</li>
	 * </ul>
	 * @param component6 the Number with the component6 content to set
	 */
	public Field90J setComponent6(java.lang.Number component6) {
		setComponent(6, SwiftFormatUtils.getNumber(component6));
		return this;
	}
	
	/**
	 * Set the Amount2 (component6).
	 * @param component6 the Amount2 to set
	 */
	public Field90J setAmount2(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the Amount2 (component6) from a Number object.
	 * @see #setComponent6(java.lang.Number)
	 * @param component6 Number with the Amount2 content to set
	 */
	public Field90J setAmount2(java.lang.Number component6) {
		setComponent6(component6);
		return this;
	}
    
	public List<String> currencyStrings() {
		List<String> result = new ArrayList<String>();
		result = CurrencyResolver.resolveComponentsPattern(COMPONENTS_PATTERN, components);
		return result;
	}

	public List<Currency> currencies() {
		final List<String> l = currencyStrings();
		if (l.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final ArrayList<Currency> result = new ArrayList<Currency>();
		for (String s: l) {
			result.add(Currency.getInstance(s));
		}
		return result;
	}
    
	public Currency currency() {
		return CurrencyResolver.resolveCurrency(this);
	}

	public String currencyString() {
		return CurrencyResolver.resolveCurrencyString(this);
	}

	public void initializeCurrencies(String cur) {
		CurrencyResolver.resolveSetCurrency(this, cur);
	}

	public void initializeCurrencies(Currency cur) {
		CurrencyResolver.resolveSetCurrency(this, cur);
	}
    
	public List<BigDecimal> amounts() {
		return AmountResolver.amounts(this);
	}
	public BigDecimal amount() {
		return AmountResolver.amount(this);
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
	 * @return the static value of Field90J.NAME
	 */
	@Override
	public String getName() {
		return NAME;
	}
	
	/**
	 * Returns the field's components pattern
	 * @return the static value of Field90J.COMPONENTS_PATTERN
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
		return ":4!c//4!c/<CUR><AMOUNT>15/<CUR><AMOUNT>15";
	}

	/**
	 * Get the first occurrence form the tag list or null if not found.
	 * @return null if not found o block is null or empty
	 * @param block may be null or empty 
	 */
	public static Field90J get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field90J(t) ;
	}
	
	/**
	 * Get the first instance of Field90J in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field90J get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Get a list of all occurrences of the field Field90J in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static java.util.List<Field90J> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Get a list of all occurrences of the field Field90J from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static java.util.List<Field90J> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length>0) {
			final java.util.ArrayList<Field90J> result = new java.util.ArrayList<Field90J>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field90J(f));
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
			throw new IllegalArgumentException("invalid component number "+component+" for field 90J");
		}
		if (locale == null) {
			locale = Locale.getDefault();
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
			//number or amount
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(locale);
    		Number n = getComponent6AsNumber();
			if (n != null) {
				return f.format(n);
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
		result.add("Code");
		result.add("Currency1");
		result.add("Amount1");
		result.add("Currency2");
		result.add("Amount2");
		return result;
	}
	

}
