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
 * Field 68C<br /><br />
 *
 * validation pattern: 4a/4a/1a[&lt;DATE2&gt;]3!a&lt;AMOUNT&gt;15$&lt;CUR&gt;&lt;AMOUNT&gt;15&lt;CUR&gt;&lt;AMOUNT&gt;15&lt;CUR&gt;&lt;AMOUNT&gt;15<br />
 * parser pattern: S/S/c[&lt;DATE2&gt;]SN$SNSNSN<br />
 * components pattern: SScESNCNCNCN<br />
 *
 * <h1>Components Data types</h1>
 * <ul> 
 * 		<li>component1: <code>String</code></li> 
 * 		<li>component2: <code>String</code></li> 
 * 		<li>component3: <code>Character</code></li> 
 * 		<li>component4: <code>Calendar</code></li> 
 * 		<li>component5: <code>String</code></li> 
 * 		<li>component6: <code>Number</code></li> 
 * 		<li>component7: <code>Currency</code></li> 
 * 		<li>component8: <code>Number</code></li> 
 * 		<li>component9: <code>Currency</code></li> 
 * 		<li>component10: <code>Number</code></li> 
 * 		<li>component11: <code>Currency</code></li> 
 * 		<li>component12: <code>Number</code></li> 
 * </ul>
 *		 
 * <em>NOTE: this source code has been generated from template</em>
 *
 * <em>This class complies with standard release SRU2016</em>
 *
 */
@SuppressWarnings("unused") 
@Generated
public class Field68C extends Field implements Serializable, CurrencyContainer, DateContainer, AmountContainer, com.prowidesoftware.swift.model.field.MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2016;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 68C
	 */
    public static final String NAME = "68C";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_68C = "68C";
	public static final String PARSER_PATTERN ="S/S/c[<DATE2>]SN$SNSNSN";
	public static final String COMPONENTS_PATTERN = "SScESNCNCNCN";

	/**
	 * Component number for the Buy/Sell Indicator subfield
	 */
	public static final Integer BUYSELL_INDICATOR = 1;

	/**
	 * Component number for the Call/Put Indicator subfield
	 */
	public static final Integer CALLPUT_INDICATOR = 2;

	/**
	 * Component number for the Style Indicator subfield
	 */
	public static final Integer STYLE_INDICATOR = 3;

	/**
	 * Component number for the Date Contract Agreed subfield
	 */
	public static final Integer DATE_CONTRACT_AGREED = 4;

	/**
	 * Component number for the Unit subfield
	 */
	public static final Integer UNIT = 5;

	/**
	 * Component number for the Amount Of The Underlying Commodity subfield
	 */
	public static final Integer AMOUNT_OF_THE_UNDERLYING_COMMODITY = 6;

	/**
	 * Component number for the Strike Price Per Unit Currency subfield
	 */
	public static final Integer STRIKE_PRICE_PER_UNIT_CURRENCY = 7;

	/**
	 * Component number for the Strike Price Per Unit subfield
	 */
	public static final Integer STRIKE_PRICE_PER_UNIT = 8;

	/**
	 * Component number for the Premium Price Per Unit Currency subfield
	 */
	public static final Integer PREMIUM_PRICE_PER_UNIT_CURRENCY = 9;

	/**
	 * Component number for the Premium Price Per Unit subfield
	 */
	public static final Integer PREMIUM_PRICE_PER_UNIT = 10;

	/**
	 * Component number for the Premium Payment Currency subfield
	 */
	public static final Integer PREMIUM_PAYMENT_CURRENCY = 11;

	/**
	 * Component number for the Premium Payment subfield
	 */
	public static final Integer PREMIUM_PAYMENT = 12;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field68C() {
		super(12);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field68C(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field68C(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "68C")) {
			throw new IllegalArgumentException("cannot create field 68C from tag "+tag.getName()+", tagname must match the name of the field.");
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
		init(12);
		java.util.List<String> lines = SwiftParseUtils.getLines(value);
		if (lines.size() > 0) {
			if (lines.get(0) != null) {
				setComponent1(SwiftParseUtils.getTokenFirst(lines.get(0), "/"));
				setComponent2(SwiftParseUtils.getTokenSecond(lines.get(0), "/"));
				String toparse = SwiftParseUtils.getTokenThirdLast(lines.get(0), "/");
				if (toparse != null && toparse.length() >= 1) {
					StringBuilder parsed = new StringBuilder();
					setComponent3(org.apache.commons.lang.StringUtils.substring(toparse, 0, 1));
					if (getComponent3() != null) {
						parsed.append(getComponent3());
					}
					String toparse2 = org.apache.commons.lang.StringUtils.substringAfter(toparse, parsed.toString());
					setComponent4(SwiftParseUtils.getNumericPrefix(toparse2));
					if (getComponent4() != null) {
						parsed.append(getComponent4());
					}
					toparse2 = org.apache.commons.lang.StringUtils.substringAfter(toparse, parsed.toString());
					setComponent5(SwiftParseUtils.getAlphaPrefix(toparse2));
					setComponent6(SwiftParseUtils.getNumericSuffix(toparse2));
				}
			}
		}
		if (lines.size() > 1) {
			if (lines.get(1) != null) {
				StringBuilder parsed = new StringBuilder();
				String l = lines.get(1);

				setComponent7(SwiftParseUtils.getAlphaPrefix(l));
				if (getComponent7() != null) {
					parsed.append(getComponent7());
				}
				
				String toparse = org.apache.commons.lang.StringUtils.substringAfter(l, parsed.toString());
				setComponent8(SwiftParseUtils.getNumericPrefix(toparse));
				if (getComponent8() != null) {
					parsed.append(getComponent8());
				}

				toparse = org.apache.commons.lang.StringUtils.substringAfter(l, parsed.toString());
				setComponent9(SwiftParseUtils.getAlphaPrefix(toparse));
				if (getComponent9() != null) {
					parsed.append(getComponent9());
				}
				
				toparse = org.apache.commons.lang.StringUtils.substringAfter(l, parsed.toString());
				setComponent10(SwiftParseUtils.getNumericPrefix(toparse));
				if (getComponent10() != null) {
					parsed.append(getComponent10());
				}

				toparse = org.apache.commons.lang.StringUtils.substringAfter(l, parsed.toString());
				setComponent11(SwiftParseUtils.getAlphaPrefix(toparse));
				if (getComponent11() != null) {
					parsed.append(getComponent11());
				}

				toparse = org.apache.commons.lang.StringUtils.substringAfter(l, parsed.toString());
				setComponent12(SwiftParseUtils.getNumericPrefix(toparse));
			}
		}
	}
	
	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field68C newInstance(Field68C source) {
		Field68C cp = new Field68C();
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
		result.append("/");
		result.append(StringUtils.trimToEmpty(getComponent2()));
		result.append("/");
		result.append(StringUtils.trimToEmpty(getComponent3()));
		if (org.apache.commons.lang.StringUtils.isNotEmpty(getComponent4())) {
			result.append(StringUtils.trimToEmpty(getComponent4()));
		}
		result.append(StringUtils.trimToEmpty(getComponent5()));
		result.append(StringUtils.trimToEmpty(getComponent6()));
		result.append(com.prowidesoftware.swift.io.writer.FINWriterVisitor.SWIFT_EOL);
		result.append(StringUtils.trimToEmpty(getComponent7()));
		result.append(StringUtils.trimToEmpty(getComponent8()));
		result.append(StringUtils.trimToEmpty(getComponent9()));
		result.append(StringUtils.trimToEmpty(getComponent10()));
		result.append(StringUtils.trimToEmpty(getComponent11()));
		result.append(StringUtils.trimToEmpty(getComponent12()));
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
	 * Get the Buy/Sell Indicator (component1).
	 * @return the Buy/Sell Indicator from component1
	 */
	public String getBuySellIndicator() {
		return getComponent(1);
	}

	/**
	 * Set the component1.
	 * @param component1 the component1 to set
	 */
	public Field68C setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Buy/Sell Indicator (component1).
	 * @param component1 the Buy/Sell Indicator to set
	 */
	public Field68C setBuySellIndicator(String component1) {
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
	 * Get the Call/Put Indicator (component2).
	 * @return the Call/Put Indicator from component2
	 */
	public String getCallPutIndicator() {
		return getComponent(2);
	}

	/**
	 * Set the component2.
	 * @param component2 the component2 to set
	 */
	public Field68C setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Call/Put Indicator (component2).
	 * @param component2 the Call/Put Indicator to set
	 */
	public Field68C setCallPutIndicator(String component2) {
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
	 * Get the Style Indicator (component3).
	 * @return the Style Indicator from component3
	 */
	public String getStyleIndicator() {
		return getComponent(3);
	}

	/**
	 * Set the component3.
	 * @param component3 the component3 to set
	 */
	public Field68C setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the Style Indicator (component3).
	 * @param component3 the Style Indicator to set
	 */
	public Field68C setStyleIndicator(String component3) {
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
	 * Get the component4 as Calendar
	 * @return the component4 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getComponent4AsCalendar() {
		return SwiftFormatUtils.getDate2(getComponent(4));
	}

	/**
	 * Get the Date Contract Agreed (component4).
	 * @return the Date Contract Agreed from component4
	 */
	public String getDateContractAgreed() {
		return getComponent(4);
	}
	
	/**
	 * Get the Date Contract Agreed (component4) as Calendar
	 * @return the Date Contract Agreed from component4 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getDateContractAgreedAsCalendar() {
		return SwiftFormatUtils.getDate2(getComponent(4));
	}

	/**
	 * Set the component4.
	 * @param component4 the component4 to set
	 */
	public Field68C setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the component4 from a Calendar object.
	 * <br />
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -> 1234,</li>
	 * 	<li>Example: 1234 -> 1234,</li>
	 * 	<li>Example: 1234.56 -> 1234,56</li>
	 * </ul>
	 * @param component4 the Calendar with the component4 content to set
	 */
	public Field68C setComponent4(java.util.Calendar component4) {
		setComponent(4, SwiftFormatUtils.getDate2(component4));
		return this;
	}
	
	/**
	 * Set the Date Contract Agreed (component4).
	 * @param component4 the Date Contract Agreed to set
	 */
	public Field68C setDateContractAgreed(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the Date Contract Agreed (component4) from a Calendar object.
	 * @see #setComponent4(java.util.Calendar)
	 * @param component4 Calendar with the Date Contract Agreed content to set
	 */
	public Field68C setDateContractAgreed(java.util.Calendar component4) {
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
	public Field68C setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the Unit (component5).
	 * @param component5 the Unit to set
	 */
	public Field68C setUnit(String component5) {
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
	 * Get the Amount Of The Underlying Commodity (component6).
	 * @return the Amount Of The Underlying Commodity from component6
	 */
	public String getAmountOfTheUnderlyingCommodity() {
		return getComponent(6);
	}
	
	/**
	 * Get the Amount Of The Underlying Commodity (component6) as Number
	 * @return the Amount Of The Underlying Commodity from component6 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getAmountOfTheUnderlyingCommodityAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(6));
	}

	/**
	 * Set the component6.
	 * @param component6 the component6 to set
	 */
	public Field68C setComponent6(String component6) {
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
	public Field68C setComponent6(java.lang.Number component6) {
		setComponent(6, SwiftFormatUtils.getNumber(component6));
		return this;
	}
	
	/**
	 * Set the Amount Of The Underlying Commodity (component6).
	 * @param component6 the Amount Of The Underlying Commodity to set
	 */
	public Field68C setAmountOfTheUnderlyingCommodity(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the Amount Of The Underlying Commodity (component6) from a Number object.
	 * @see #setComponent6(java.lang.Number)
	 * @param component6 Number with the Amount Of The Underlying Commodity content to set
	 */
	public Field68C setAmountOfTheUnderlyingCommodity(java.lang.Number component6) {
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
	 * Get the Strike Price Per Unit Currency (component7).
	 * @return the Strike Price Per Unit Currency from component7
	 */
	public String getStrikePricePerUnitCurrency() {
		return getComponent(7);
	}
	
	/**
	 * Get the Strike Price Per Unit Currency (component7) as Currency
	 * @return the Strike Price Per Unit Currency from component7 converted to Currency or <code>null</code> if cannot be converted
	 */
	public java.util.Currency getStrikePricePerUnitCurrencyAsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(7));
	}

	/**
	 * Set the component7.
	 * @param component7 the component7 to set
	 */
	public Field68C setComponent7(String component7) {
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
	public Field68C setComponent7(java.util.Currency component7) {
		setComponent(7, SwiftFormatUtils.getCurrency(component7));
		return this;
	}
	
	/**
	 * Set the Strike Price Per Unit Currency (component7).
	 * @param component7 the Strike Price Per Unit Currency to set
	 */
	public Field68C setStrikePricePerUnitCurrency(String component7) {
		setComponent(7, component7);
		return this;
	}
	
	/**
	 * Set the Strike Price Per Unit Currency (component7) from a Currency object.
	 * @see #setComponent7(java.util.Currency)
	 * @param component7 Currency with the Strike Price Per Unit Currency content to set
	 */
	public Field68C setStrikePricePerUnitCurrency(java.util.Currency component7) {
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
	 * Get the Strike Price Per Unit (component8).
	 * @return the Strike Price Per Unit from component8
	 */
	public String getStrikePricePerUnit() {
		return getComponent(8);
	}
	
	/**
	 * Get the Strike Price Per Unit (component8) as Number
	 * @return the Strike Price Per Unit from component8 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getStrikePricePerUnitAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(8));
	}

	/**
	 * Set the component8.
	 * @param component8 the component8 to set
	 */
	public Field68C setComponent8(String component8) {
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
	public Field68C setComponent8(java.lang.Number component8) {
		setComponent(8, SwiftFormatUtils.getNumber(component8));
		return this;
	}
	
	/**
	 * Set the Strike Price Per Unit (component8).
	 * @param component8 the Strike Price Per Unit to set
	 */
	public Field68C setStrikePricePerUnit(String component8) {
		setComponent(8, component8);
		return this;
	}
	
	/**
	 * Set the Strike Price Per Unit (component8) from a Number object.
	 * @see #setComponent8(java.lang.Number)
	 * @param component8 Number with the Strike Price Per Unit content to set
	 */
	public Field68C setStrikePricePerUnit(java.lang.Number component8) {
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
	 * Get the component9 as Currency
	 * @return the component9 converted to Currency or <code>null</code> if cannot be converted
	 */
	public java.util.Currency getComponent9AsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(9));
	}

	/**
	 * Get the Premium Price Per Unit Currency (component9).
	 * @return the Premium Price Per Unit Currency from component9
	 */
	public String getPremiumPricePerUnitCurrency() {
		return getComponent(9);
	}
	
	/**
	 * Get the Premium Price Per Unit Currency (component9) as Currency
	 * @return the Premium Price Per Unit Currency from component9 converted to Currency or <code>null</code> if cannot be converted
	 */
	public java.util.Currency getPremiumPricePerUnitCurrencyAsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(9));
	}

	/**
	 * Set the component9.
	 * @param component9 the component9 to set
	 */
	public Field68C setComponent9(String component9) {
		setComponent(9, component9);
		return this;
	}
	
	/**
	 * Set the component9 from a Currency object.
	 * <br />
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -> 1234,</li>
	 * 	<li>Example: 1234 -> 1234,</li>
	 * 	<li>Example: 1234.56 -> 1234,56</li>
	 * </ul>
	 * @param component9 the Currency with the component9 content to set
	 */
	public Field68C setComponent9(java.util.Currency component9) {
		setComponent(9, SwiftFormatUtils.getCurrency(component9));
		return this;
	}
	
	/**
	 * Set the Premium Price Per Unit Currency (component9).
	 * @param component9 the Premium Price Per Unit Currency to set
	 */
	public Field68C setPremiumPricePerUnitCurrency(String component9) {
		setComponent(9, component9);
		return this;
	}
	
	/**
	 * Set the Premium Price Per Unit Currency (component9) from a Currency object.
	 * @see #setComponent9(java.util.Currency)
	 * @param component9 Currency with the Premium Price Per Unit Currency content to set
	 */
	public Field68C setPremiumPricePerUnitCurrency(java.util.Currency component9) {
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
	 * Get the component10 as Number
	 * @return the component10 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getComponent10AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(10));
	}

	/**
	 * Get the Premium Price Per Unit (component10).
	 * @return the Premium Price Per Unit from component10
	 */
	public String getPremiumPricePerUnit() {
		return getComponent(10);
	}
	
	/**
	 * Get the Premium Price Per Unit (component10) as Number
	 * @return the Premium Price Per Unit from component10 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getPremiumPricePerUnitAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(10));
	}

	/**
	 * Set the component10.
	 * @param component10 the component10 to set
	 */
	public Field68C setComponent10(String component10) {
		setComponent(10, component10);
		return this;
	}
	
	/**
	 * Set the component10 from a Number object.
	 * <br />
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -> 1234,</li>
	 * 	<li>Example: 1234 -> 1234,</li>
	 * 	<li>Example: 1234.56 -> 1234,56</li>
	 * </ul>
	 * @param component10 the Number with the component10 content to set
	 */
	public Field68C setComponent10(java.lang.Number component10) {
		setComponent(10, SwiftFormatUtils.getNumber(component10));
		return this;
	}
	
	/**
	 * Set the Premium Price Per Unit (component10).
	 * @param component10 the Premium Price Per Unit to set
	 */
	public Field68C setPremiumPricePerUnit(String component10) {
		setComponent(10, component10);
		return this;
	}
	
	/**
	 * Set the Premium Price Per Unit (component10) from a Number object.
	 * @see #setComponent10(java.lang.Number)
	 * @param component10 Number with the Premium Price Per Unit content to set
	 */
	public Field68C setPremiumPricePerUnit(java.lang.Number component10) {
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
	 * Get the component11 as Currency
	 * @return the component11 converted to Currency or <code>null</code> if cannot be converted
	 */
	public java.util.Currency getComponent11AsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(11));
	}

	/**
	 * Get the Premium Payment Currency (component11).
	 * @return the Premium Payment Currency from component11
	 */
	public String getPremiumPaymentCurrency() {
		return getComponent(11);
	}
	
	/**
	 * Get the Premium Payment Currency (component11) as Currency
	 * @return the Premium Payment Currency from component11 converted to Currency or <code>null</code> if cannot be converted
	 */
	public java.util.Currency getPremiumPaymentCurrencyAsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(11));
	}

	/**
	 * Set the component11.
	 * @param component11 the component11 to set
	 */
	public Field68C setComponent11(String component11) {
		setComponent(11, component11);
		return this;
	}
	
	/**
	 * Set the component11 from a Currency object.
	 * <br />
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -> 1234,</li>
	 * 	<li>Example: 1234 -> 1234,</li>
	 * 	<li>Example: 1234.56 -> 1234,56</li>
	 * </ul>
	 * @param component11 the Currency with the component11 content to set
	 */
	public Field68C setComponent11(java.util.Currency component11) {
		setComponent(11, SwiftFormatUtils.getCurrency(component11));
		return this;
	}
	
	/**
	 * Set the Premium Payment Currency (component11).
	 * @param component11 the Premium Payment Currency to set
	 */
	public Field68C setPremiumPaymentCurrency(String component11) {
		setComponent(11, component11);
		return this;
	}
	
	/**
	 * Set the Premium Payment Currency (component11) from a Currency object.
	 * @see #setComponent11(java.util.Currency)
	 * @param component11 Currency with the Premium Payment Currency content to set
	 */
	public Field68C setPremiumPaymentCurrency(java.util.Currency component11) {
		setComponent11(component11);
		return this;
	}
	/**
	 * Get the component12
	 * @return the component12
	 */
	public String getComponent12() {
		return getComponent(12);
	}

	/**
	 * Get the component12 as Number
	 * @return the component12 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getComponent12AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(12));
	}

	/**
	 * Get the Premium Payment (component12).
	 * @return the Premium Payment from component12
	 */
	public String getPremiumPayment() {
		return getComponent(12);
	}
	
	/**
	 * Get the Premium Payment (component12) as Number
	 * @return the Premium Payment from component12 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getPremiumPaymentAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(12));
	}

	/**
	 * Set the component12.
	 * @param component12 the component12 to set
	 */
	public Field68C setComponent12(String component12) {
		setComponent(12, component12);
		return this;
	}
	
	/**
	 * Set the component12 from a Number object.
	 * <br />
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -> 1234,</li>
	 * 	<li>Example: 1234 -> 1234,</li>
	 * 	<li>Example: 1234.56 -> 1234,56</li>
	 * </ul>
	 * @param component12 the Number with the component12 content to set
	 */
	public Field68C setComponent12(java.lang.Number component12) {
		setComponent(12, SwiftFormatUtils.getNumber(component12));
		return this;
	}
	
	/**
	 * Set the Premium Payment (component12).
	 * @param component12 the Premium Payment to set
	 */
	public Field68C setPremiumPayment(String component12) {
		setComponent(12, component12);
		return this;
	}
	
	/**
	 * Set the Premium Payment (component12) from a Number object.
	 * @see #setComponent12(java.lang.Number)
	 * @param component12 Number with the Premium Payment content to set
	 */
	public Field68C setPremiumPayment(java.lang.Number component12) {
		setComponent12(component12);
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
		result.add(SwiftFormatUtils.getDate2(getComponent(4)));
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
	 * @return the static value of Field68C.NAME
	 */
	@Override
	public String getName() {
		return NAME;
	}
	
	/**
	 * Returns the field's components pattern
	 * @return the static value of Field68C.COMPONENTS_PATTERN
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
		return "4a/4a/1a[<DATE2>]3!a<AMOUNT>15$<CUR><AMOUNT>15<CUR><AMOUNT>15<CUR><AMOUNT>15";
	}

	/**
	 * Get the first occurrence form the tag list or null if not found.
	 * @return null if not found o block is null or empty
	 * @param block may be null or empty 
	 */
	public static Field68C get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field68C(t) ;
	}
	
	/**
	 * Get the first instance of Field68C in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field68C get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Get a list of all occurrences of the field Field68C in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static java.util.List<Field68C> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Get a list of all occurrences of the field Field68C from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static java.util.List<Field68C> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length>0) {
			final java.util.ArrayList<Field68C> result = new java.util.ArrayList<Field68C>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field68C(f));
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
		return 12;
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
		Field68C cp = newInstance(this);
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
		Field68C cp = newInstance(this);
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
		Field68C cp = newInstance(this);
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
		if (component < 1 || component > 12) {
			throw new IllegalArgumentException("invalid component number "+component+" for field 68C");
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
			//date
			java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, locale);
			java.util.Calendar cal = getComponent4AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
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
			//default format (as is)
			return getComponent(9);
		}
		if (component == 10) {
			//number or amount
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(locale);
    		Number n = getComponent10AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 11) {
			//default format (as is)
			return getComponent(11);
		}
		if (component == 12) {
			//number or amount
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(locale);
    		Number n = getComponent12AsNumber();
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
		result.add("Buy/Sell Indicator");
		result.add("Call/Put Indicator");
		result.add("Style Indicator");
		result.add("Date Contract Agreed");
		result.add("Unit");
		result.add("Amount Of The Underlying Commodity");
		result.add("Strike Price Per Unit Currency");
		result.add("Strike Price Per Unit");
		result.add("Premium Price Per Unit Currency");
		result.add("Premium Price Per Unit");
		result.add("Premium Payment Currency");
		result.add("Premium Payment");
		return result;
	}
	

}
