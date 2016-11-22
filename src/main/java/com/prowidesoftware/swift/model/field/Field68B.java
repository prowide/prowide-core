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
import java.util.Calendar;
import com.prowidesoftware.swift.model.field.DateContainer;
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
 * Field 68B<br /><br />
 *
 * validation pattern: &lt;DATE2&gt;&lt;DATE2&gt;16x/1a$3!a&lt;AMOUNT&gt;15$&lt;CUR&gt;&lt;AMOUNT&gt;15/&lt;DATE2&gt;&lt;CUR&gt;&lt;AMOUNT&gt;15<br />
 * parser pattern: &lt;DATE2&gt;&lt;DATE2&gt;S/cSN$SN/&lt;DATE2&gt;SN<br />
 * components pattern: EEScSNCNECN<br />
 *
 * <h1>Components Data types</h1>
 * <ul> 
 * 		<li>component1: <code>Calendar</code></li> 
 * 		<li>component2: <code>Calendar</code></li> 
 * 		<li>component3: <code>String</code></li> 
 * 		<li>component4: <code>Character</code></li> 
 * 		<li>component5: <code>String</code></li> 
 * 		<li>component6: <code>Number</code></li> 
 * 		<li>component7: <code>Currency</code></li> 
 * 		<li>component8: <code>Number</code></li> 
 * 		<li>component9: <code>Calendar</code></li> 
 * 		<li>component10: <code>Currency</code></li> 
 * 		<li>component11: <code>Number</code></li> 
 * </ul>
 *		 
 * <em>NOTE: this source code has been generated from template</em>
 *
 * <em>This class complies with standard release SRU2016</em>
 *
 */
@SuppressWarnings("unused") 
@Generated
public class Field68B extends Field implements Serializable, CurrencyContainer, DateContainer, AmountContainer, com.prowidesoftware.swift.model.field.MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 68B
	 */
    public static final String NAME = "68B";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_68B = "68B";
	public static final String PARSER_PATTERN ="<DATE2><DATE2>S/cSN$SN/<DATE2>SN";
	public static final String COMPONENTS_PATTERN = "EEScSNCNECN";

	/**
	 * Component number for the Trade Date subfield
	 */
	public static final Integer TRADE_DATE = 1;

	/**
	 * Component number for the Maturity Date subfield
	 */
	public static final Integer MATURITY_DATE = 2;

	/**
	 * Component number for the Contract Number subfield
	 */
	public static final Integer CONTRACT_NUMBER = 3;

	/**
	 * Component number for the Indicator subfield
	 */
	public static final Integer INDICATOR = 4;

	/**
	 * Component number for the Unit subfield
	 */
	public static final Integer UNIT = 5;

	/**
	 * Component number for the Quantity Of The Commodity subfield
	 */
	public static final Integer QUANTITY_OF_THE_COMMODITY = 6;

	/**
	 * Component number for the Price Per Unit Currency subfield
	 */
	public static final Integer PRICE_PER_UNIT_CURRENCY = 7;

	/**
	 * Component number for the Price Per Unit subfield
	 */
	public static final Integer PRICE_PER_UNIT = 8;

	/**
	 * Component number for the Value Date Of The Consideration subfield
	 */
	public static final Integer VALUE_DATE_OF_THE_CONSIDERATION = 9;

	/**
	 * Component number for the Consideration Currency subfield
	 */
	public static final Integer CONSIDERATION_CURRENCY = 10;

	/**
	 * Component number for the Consideration subfield
	 */
	public static final Integer CONSIDERATION = 11;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field68B() {
		super(11);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field68B(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field68B(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "68B")) {
			throw new IllegalArgumentException("cannot create field 68B from tag "+tag.getName()+", tagname must match the name of the field.");
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
		init(11);
		java.util.List<String> lines = SwiftParseUtils.getLines(value);
		if (lines.size() > 0) {
			if (lines.get(0) != null) {
				String toparse = SwiftParseUtils.getTokenFirst(lines.get(0), "/");
				if (toparse != null && toparse.length() >= 6) {
					setComponent1(org.apache.commons.lang.StringUtils.substring(toparse, 0, 6));
				}
				if (toparse != null && toparse.length() >= 12) {
					setComponent2(org.apache.commons.lang.StringUtils.substring(toparse, 6, 12));
				}
				if (toparse != null && toparse.length() > 12) {
					setComponent3(org.apache.commons.lang.StringUtils.substring(toparse, 12));
				}
				
				toparse = SwiftParseUtils.getAlphaPrefix(SwiftParseUtils.getTokenSecond(lines.get(0), "/"));
				if (toparse != null && toparse.length() >= 1) {
					setComponent4(org.apache.commons.lang.StringUtils.substring(toparse, 0, 1));
				}
				if (toparse != null && toparse.length() > 1) {
					setComponent5(org.apache.commons.lang.StringUtils.substring(toparse, 1));
				}
				setComponent6(SwiftParseUtils.getNumericSuffix(SwiftParseUtils.getTokenSecond(lines.get(0), "/")));
			}
		}
		if (lines.size() > 1) {
			if (lines.get(1) != null) {
				String toparse = SwiftParseUtils.getTokenFirst(lines.get(1), "/");
				setComponent7(SwiftParseUtils.getAlphaPrefix(toparse));
				setComponent8(SwiftParseUtils.getNumericSuffix(toparse));
				toparse = SwiftParseUtils.getTokenSecondLast(lines.get(1), "/");
				if (toparse != null && toparse.length() >= 6) {
					setComponent9(org.apache.commons.lang.StringUtils.substring(toparse, 0, 6));
					String toparse2 = org.apache.commons.lang.StringUtils.substring(toparse, 6);
					setComponent10(SwiftParseUtils.getAlphaPrefix(toparse2));
					setComponent11(SwiftParseUtils.getNumericSuffix(toparse2));
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
	public static Field68B newInstance(Field68B source) {
		Field68B cp = new Field68B();
		cp.setComponents(new ArrayList<String>(source.getComponents()));
		return cp;
	}
	
	/**
	 * Serializes the fields' components into the single string value (SWIFT format)
	 */
	@Override
	public String getValue() {
		final StringBuilder result = new StringBuilder();
		result.append(StringUtils.trimToEmpty(getComponent1()));
		result.append(StringUtils.trimToEmpty(getComponent2()));
		result.append(StringUtils.trimToEmpty(getComponent3()));
		result.append("/");
		result.append(StringUtils.trimToEmpty(getComponent4()));
		result.append(StringUtils.trimToEmpty(getComponent5()));
		result.append(StringUtils.trimToEmpty(getComponent6()));
		result.append(com.prowidesoftware.swift.io.writer.FINWriterVisitor.SWIFT_EOL);
		result.append(StringUtils.trimToEmpty(getComponent7()));
		result.append(StringUtils.trimToEmpty(getComponent8()));
		result.append("/");
		result.append(StringUtils.trimToEmpty(getComponent9()));
		result.append(StringUtils.trimToEmpty(getComponent10()));
		result.append(StringUtils.trimToEmpty(getComponent11()));
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
	 * Get the component1 as Calendar
	 * @return the component1 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getComponent1AsCalendar() {
		return SwiftFormatUtils.getDate2(getComponent(1));
	}

	/**
	 * Get the Trade Date (component1).
	 * @return the Trade Date from component1
	 */
	public String getTradeDate() {
		return getComponent(1);
	}
	
	/**
	 * Get the Trade Date (component1) as Calendar
	 * @return the Trade Date from component1 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getTradeDateAsCalendar() {
		return SwiftFormatUtils.getDate2(getComponent(1));
	}

	/**
	 * Set the component1.
	 * @param component1 the component1 to set
	 */
	public Field68B setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the component1 from a Calendar object.
	 * <br />
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -> 1234,</li>
	 * 	<li>Example: 1234 -> 1234,</li>
	 * 	<li>Example: 1234.56 -> 1234,56</li>
	 * </ul>
	 * @param component1 the Calendar with the component1 content to set
	 */
	public Field68B setComponent1(java.util.Calendar component1) {
		setComponent(1, SwiftFormatUtils.getDate2(component1));
		return this;
	}
	
	/**
	 * Set the Trade Date (component1).
	 * @param component1 the Trade Date to set
	 */
	public Field68B setTradeDate(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Trade Date (component1) from a Calendar object.
	 * @see #setComponent1(java.util.Calendar)
	 * @param component1 Calendar with the Trade Date content to set
	 */
	public Field68B setTradeDate(java.util.Calendar component1) {
		setComponent1(component1);
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
		return SwiftFormatUtils.getDate2(getComponent(2));
	}

	/**
	 * Get the Maturity Date (component2).
	 * @return the Maturity Date from component2
	 */
	public String getMaturityDate() {
		return getComponent(2);
	}
	
	/**
	 * Get the Maturity Date (component2) as Calendar
	 * @return the Maturity Date from component2 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getMaturityDateAsCalendar() {
		return SwiftFormatUtils.getDate2(getComponent(2));
	}

	/**
	 * Set the component2.
	 * @param component2 the component2 to set
	 */
	public Field68B setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the component2 from a Calendar object.
	 * <br />
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -> 1234,</li>
	 * 	<li>Example: 1234 -> 1234,</li>
	 * 	<li>Example: 1234.56 -> 1234,56</li>
	 * </ul>
	 * @param component2 the Calendar with the component2 content to set
	 */
	public Field68B setComponent2(java.util.Calendar component2) {
		setComponent(2, SwiftFormatUtils.getDate2(component2));
		return this;
	}
	
	/**
	 * Set the Maturity Date (component2).
	 * @param component2 the Maturity Date to set
	 */
	public Field68B setMaturityDate(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Maturity Date (component2) from a Calendar object.
	 * @see #setComponent2(java.util.Calendar)
	 * @param component2 Calendar with the Maturity Date content to set
	 */
	public Field68B setMaturityDate(java.util.Calendar component2) {
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
	 * Same as getComponent(3)
	 */
	@Deprecated
	public java.lang.String getComponent3AsString() {
		return getComponent(3);
	}

	/**
	 * Get the Contract Number (component3).
	 * @return the Contract Number from component3
	 */
	public String getContractNumber() {
		return getComponent(3);
	}

	/**
	 * Set the component3.
	 * @param component3 the component3 to set
	 */
	public Field68B setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the Contract Number (component3).
	 * @param component3 the Contract Number to set
	 */
	public Field68B setContractNumber(String component3) {
		setComponent(3, component3);
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
	 * Get the Indicator (component4).
	 * @return the Indicator from component4
	 */
	public String getIndicator() {
		return getComponent(4);
	}

	/**
	 * Set the component4.
	 * @param component4 the component4 to set
	 */
	public Field68B setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the Indicator (component4).
	 * @param component4 the Indicator to set
	 */
	public Field68B setIndicator(String component4) {
		setComponent(4, component4);
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
	 * Same as getComponent(5)
	 */
	@Deprecated
	public java.lang.String getComponent5AsString() {
		return getComponent(5);
	}

	/**
	 * Get the Unit (component5).
	 * @return the Unit from component5
	 */
	public String getUnit() {
		return getComponent(5);
	}

	/**
	 * Set the component5.
	 * @param component5 the component5 to set
	 */
	public Field68B setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the Unit (component5).
	 * @param component5 the Unit to set
	 */
	public Field68B setUnit(String component5) {
		setComponent(5, component5);
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
	 * Get the Quantity Of The Commodity (component6).
	 * @return the Quantity Of The Commodity from component6
	 */
	public String getQuantityOfTheCommodity() {
		return getComponent(6);
	}
	
	/**
	 * Get the Quantity Of The Commodity (component6) as Number
	 * @return the Quantity Of The Commodity from component6 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getQuantityOfTheCommodityAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(6));
	}

	/**
	 * Set the component6.
	 * @param component6 the component6 to set
	 */
	public Field68B setComponent6(String component6) {
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
	public Field68B setComponent6(java.lang.Number component6) {
		setComponent(6, SwiftFormatUtils.getNumber(component6));
		return this;
	}
	
	/**
	 * Set the Quantity Of The Commodity (component6).
	 * @param component6 the Quantity Of The Commodity to set
	 */
	public Field68B setQuantityOfTheCommodity(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the Quantity Of The Commodity (component6) from a Number object.
	 * @see #setComponent6(java.lang.Number)
	 * @param component6 Number with the Quantity Of The Commodity content to set
	 */
	public Field68B setQuantityOfTheCommodity(java.lang.Number component6) {
		setComponent6(component6);
		return this;
	}
	/**
	 * Get the component7
	 * @return the component7
	 */
	public String getComponent7() {
		return getComponent(7);
	}

	/**
	 * Get the component7 as Currency
	 * @return the component7 converted to Currency or <code>null</code> if cannot be converted
	 */
	public java.util.Currency getComponent7AsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(7));
	}

	/**
	 * Get the Price Per Unit Currency (component7).
	 * @return the Price Per Unit Currency from component7
	 */
	public String getPricePerUnitCurrency() {
		return getComponent(7);
	}
	
	/**
	 * Get the Price Per Unit Currency (component7) as Currency
	 * @return the Price Per Unit Currency from component7 converted to Currency or <code>null</code> if cannot be converted
	 */
	public java.util.Currency getPricePerUnitCurrencyAsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(7));
	}

	/**
	 * Set the component7.
	 * @param component7 the component7 to set
	 */
	public Field68B setComponent7(String component7) {
		setComponent(7, component7);
		return this;
	}
	
	/**
	 * Set the component7 from a Currency object.
	 * <br />
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -> 1234,</li>
	 * 	<li>Example: 1234 -> 1234,</li>
	 * 	<li>Example: 1234.56 -> 1234,56</li>
	 * </ul>
	 * @param component7 the Currency with the component7 content to set
	 */
	public Field68B setComponent7(java.util.Currency component7) {
		setComponent(7, SwiftFormatUtils.getCurrency(component7));
		return this;
	}
	
	/**
	 * Set the Price Per Unit Currency (component7).
	 * @param component7 the Price Per Unit Currency to set
	 */
	public Field68B setPricePerUnitCurrency(String component7) {
		setComponent(7, component7);
		return this;
	}
	
	/**
	 * Set the Price Per Unit Currency (component7) from a Currency object.
	 * @see #setComponent7(java.util.Currency)
	 * @param component7 Currency with the Price Per Unit Currency content to set
	 */
	public Field68B setPricePerUnitCurrency(java.util.Currency component7) {
		setComponent7(component7);
		return this;
	}
	/**
	 * Get the component8
	 * @return the component8
	 */
	public String getComponent8() {
		return getComponent(8);
	}

	/**
	 * Get the component8 as Number
	 * @return the component8 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getComponent8AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(8));
	}

	/**
	 * Get the Price Per Unit (component8).
	 * @return the Price Per Unit from component8
	 */
	public String getPricePerUnit() {
		return getComponent(8);
	}
	
	/**
	 * Get the Price Per Unit (component8) as Number
	 * @return the Price Per Unit from component8 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getPricePerUnitAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(8));
	}

	/**
	 * Set the component8.
	 * @param component8 the component8 to set
	 */
	public Field68B setComponent8(String component8) {
		setComponent(8, component8);
		return this;
	}
	
	/**
	 * Set the component8 from a Number object.
	 * <br />
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -> 1234,</li>
	 * 	<li>Example: 1234 -> 1234,</li>
	 * 	<li>Example: 1234.56 -> 1234,56</li>
	 * </ul>
	 * @param component8 the Number with the component8 content to set
	 */
	public Field68B setComponent8(java.lang.Number component8) {
		setComponent(8, SwiftFormatUtils.getNumber(component8));
		return this;
	}
	
	/**
	 * Set the Price Per Unit (component8).
	 * @param component8 the Price Per Unit to set
	 */
	public Field68B setPricePerUnit(String component8) {
		setComponent(8, component8);
		return this;
	}
	
	/**
	 * Set the Price Per Unit (component8) from a Number object.
	 * @see #setComponent8(java.lang.Number)
	 * @param component8 Number with the Price Per Unit content to set
	 */
	public Field68B setPricePerUnit(java.lang.Number component8) {
		setComponent8(component8);
		return this;
	}
	/**
	 * Get the component9
	 * @return the component9
	 */
	public String getComponent9() {
		return getComponent(9);
	}

	/**
	 * Get the component9 as Calendar
	 * @return the component9 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getComponent9AsCalendar() {
		return SwiftFormatUtils.getDate2(getComponent(9));
	}

	/**
	 * Get the Value Date Of The Consideration (component9).
	 * @return the Value Date Of The Consideration from component9
	 */
	public String getValueDateOfTheConsideration() {
		return getComponent(9);
	}
	
	/**
	 * Get the Value Date Of The Consideration (component9) as Calendar
	 * @return the Value Date Of The Consideration from component9 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getValueDateOfTheConsiderationAsCalendar() {
		return SwiftFormatUtils.getDate2(getComponent(9));
	}

	/**
	 * Set the component9.
	 * @param component9 the component9 to set
	 */
	public Field68B setComponent9(String component9) {
		setComponent(9, component9);
		return this;
	}
	
	/**
	 * Set the component9 from a Calendar object.
	 * <br />
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -> 1234,</li>
	 * 	<li>Example: 1234 -> 1234,</li>
	 * 	<li>Example: 1234.56 -> 1234,56</li>
	 * </ul>
	 * @param component9 the Calendar with the component9 content to set
	 */
	public Field68B setComponent9(java.util.Calendar component9) {
		setComponent(9, SwiftFormatUtils.getDate2(component9));
		return this;
	}
	
	/**
	 * Set the Value Date Of The Consideration (component9).
	 * @param component9 the Value Date Of The Consideration to set
	 */
	public Field68B setValueDateOfTheConsideration(String component9) {
		setComponent(9, component9);
		return this;
	}
	
	/**
	 * Set the Value Date Of The Consideration (component9) from a Calendar object.
	 * @see #setComponent9(java.util.Calendar)
	 * @param component9 Calendar with the Value Date Of The Consideration content to set
	 */
	public Field68B setValueDateOfTheConsideration(java.util.Calendar component9) {
		setComponent9(component9);
		return this;
	}
	/**
	 * Get the component10
	 * @return the component10
	 */
	public String getComponent10() {
		return getComponent(10);
	}

	/**
	 * Get the component10 as Currency
	 * @return the component10 converted to Currency or <code>null</code> if cannot be converted
	 */
	public java.util.Currency getComponent10AsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(10));
	}

	/**
	 * Get the Consideration Currency (component10).
	 * @return the Consideration Currency from component10
	 */
	public String getConsiderationCurrency() {
		return getComponent(10);
	}
	
	/**
	 * Get the Consideration Currency (component10) as Currency
	 * @return the Consideration Currency from component10 converted to Currency or <code>null</code> if cannot be converted
	 */
	public java.util.Currency getConsiderationCurrencyAsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(10));
	}

	/**
	 * Set the component10.
	 * @param component10 the component10 to set
	 */
	public Field68B setComponent10(String component10) {
		setComponent(10, component10);
		return this;
	}
	
	/**
	 * Set the component10 from a Currency object.
	 * <br />
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -> 1234,</li>
	 * 	<li>Example: 1234 -> 1234,</li>
	 * 	<li>Example: 1234.56 -> 1234,56</li>
	 * </ul>
	 * @param component10 the Currency with the component10 content to set
	 */
	public Field68B setComponent10(java.util.Currency component10) {
		setComponent(10, SwiftFormatUtils.getCurrency(component10));
		return this;
	}
	
	/**
	 * Set the Consideration Currency (component10).
	 * @param component10 the Consideration Currency to set
	 */
	public Field68B setConsiderationCurrency(String component10) {
		setComponent(10, component10);
		return this;
	}
	
	/**
	 * Set the Consideration Currency (component10) from a Currency object.
	 * @see #setComponent10(java.util.Currency)
	 * @param component10 Currency with the Consideration Currency content to set
	 */
	public Field68B setConsiderationCurrency(java.util.Currency component10) {
		setComponent10(component10);
		return this;
	}
	/**
	 * Get the component11
	 * @return the component11
	 */
	public String getComponent11() {
		return getComponent(11);
	}

	/**
	 * Get the component11 as Number
	 * @return the component11 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getComponent11AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(11));
	}

	/**
	 * Get the Consideration (component11).
	 * @return the Consideration from component11
	 */
	public String getConsideration() {
		return getComponent(11);
	}
	
	/**
	 * Get the Consideration (component11) as Number
	 * @return the Consideration from component11 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getConsiderationAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(11));
	}

	/**
	 * Set the component11.
	 * @param component11 the component11 to set
	 */
	public Field68B setComponent11(String component11) {
		setComponent(11, component11);
		return this;
	}
	
	/**
	 * Set the component11 from a Number object.
	 * <br />
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -> 1234,</li>
	 * 	<li>Example: 1234 -> 1234,</li>
	 * 	<li>Example: 1234.56 -> 1234,56</li>
	 * </ul>
	 * @param component11 the Number with the component11 content to set
	 */
	public Field68B setComponent11(java.lang.Number component11) {
		setComponent(11, SwiftFormatUtils.getNumber(component11));
		return this;
	}
	
	/**
	 * Set the Consideration (component11).
	 * @param component11 the Consideration to set
	 */
	public Field68B setConsideration(String component11) {
		setComponent(11, component11);
		return this;
	}
	
	/**
	 * Set the Consideration (component11) from a Number object.
	 * @see #setComponent11(java.lang.Number)
	 * @param component11 Number with the Consideration content to set
	 */
	public Field68B setConsideration(java.lang.Number component11) {
		setComponent11(component11);
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
    
    public List<Calendar> dates() {
		List<Calendar> result = new java.util.ArrayList<Calendar>();
		result.add(SwiftFormatUtils.getDate2(getComponent(1)));
		result.add(SwiftFormatUtils.getDate2(getComponent(2)));
		result.add(SwiftFormatUtils.getDate2(getComponent(9)));
		return result;
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
       return false;
   }
   
   public String parserPattern() {
           return PARSER_PATTERN;
   }

	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field68B.NAME
	 */
	@Override
	public String getName() {
		return NAME;
	}
	
	/**
	 * Returns the field's components pattern
	 * @return the static value of Field68B.COMPONENTS_PATTERN
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
		return "<DATE2><DATE2>16x/1a$3!a<AMOUNT>15$<CUR><AMOUNT>15/<DATE2><CUR><AMOUNT>15";
	}

	/**
	 * Get the first occurrence form the tag list or null if not found.
	 * @return null if not found o block is null or empty
	 * @param block may be null or empty 
	 */
	public static Field68B get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field68B(t) ;
	}
	
	/**
	 * Get the first instance of Field68B in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field68B get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Get a list of all occurrences of the field Field68B in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static java.util.List<Field68B> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Get a list of all occurrences of the field Field68B from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static java.util.List<Field68B> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length>0) {
			final java.util.ArrayList<Field68B> result = new java.util.ArrayList<Field68B>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field68B(f));
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
		return 11;
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
		Field68B cp = newInstance(this);
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
		Field68B cp = newInstance(this);
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
		Field68B cp = newInstance(this);
		return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
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
		if (component < 1 || component > 11) {
			throw new IllegalArgumentException("invalid component number "+component+" for field 68B");
		}
		if (locale == null) {
			locale = Locale.getDefault();
		}
		if (component == 1) {
			//date
			java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, locale);
			java.util.Calendar cal = getComponent1AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
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
		if (component == 6) {
			//number or amount
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(locale);
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
			//number or amount
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(locale);
    		Number n = getComponent8AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 9) {
			//date
			java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, locale);
			java.util.Calendar cal = getComponent9AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		if (component == 10) {
			//default format (as is)
			return getComponent(10);
		}
		if (component == 11) {
			//number or amount
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(locale);
    		Number n = getComponent11AsNumber();
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
		result.add("Trade Date");
		result.add("Maturity Date");
		result.add("Contract Number");
		result.add("Indicator");
		result.add("Unit");
		result.add("Quantity Of The Commodity");
		result.add("Price Per Unit Currency");
		result.add("Price Per Unit");
		result.add("Value Date Of The Consideration");
		result.add("Consideration Currency");
		result.add("Consideration");
		return result;
	}
	

}
