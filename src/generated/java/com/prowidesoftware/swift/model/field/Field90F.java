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
import java.util.Currency;
import com.prowidesoftware.swift.model.field.CurrencyContainer;
import com.prowidesoftware.swift.model.field.CurrencyResolver;
import java.math.BigDecimal;
import com.prowidesoftware.swift.model.field.AmountContainer;
import com.prowidesoftware.swift.model.field.AmountResolver;
import com.prowidesoftware.swift.model.field.GenericField;


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 90F</strong>
 * <p>
 * Model and parser for field 90F of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Currency</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Number</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>:4!c//4!c/&lt;CUR&gt;&lt;AMOUNT&gt;15/4!c/&lt;AMOUNT&gt;15</code></li>
 * 		<li>parser pattern: <code>:S//S/SN/S/N</code></li>
 * 		<li>components pattern: <code>SSCNSN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2019</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field90F extends Field implements Serializable, CurrencyContainer, AmountContainer, GenericField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 90F
	 */
    public static final String NAME = "90F";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_90F = "90F";
	public static final String PARSER_PATTERN =":S//S/SN/S/N";
	public static final String COMPONENTS_PATTERN = "SSCNSN";

	/**
	 * Component number for the Qualifier subfield
	 */
	public static final Integer QUALIFIER = 1;

	/**
	 * Component number for the Amount Type Code subfield
	 */
	public static final Integer AMOUNT_TYPE_CODE = 2;

	/**
	 * Component number for the Currency subfield
	 */
	public static final Integer CURRENCY = 3;

	/**
	 * Component number for the Amount subfield
	 */
	public static final Integer AMOUNT = 4;

	/**
	 * Component number for the Quantity Type Code subfield
	 */
	public static final Integer QUANTITY_TYPE_CODE = 5;

	/**
	 * Component number for the Quantity subfield
	 */
	public static final Integer QUANTITY = 6;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field90F() {
		super(6);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field90F(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field90F(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "90F")) {
			throw new IllegalArgumentException("cannot create field 90F from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field90F newInstance(Field90F source) {
		Field90F cp = new Field90F();
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
		String toparse = SwiftParseUtils.getTokenSecondLast(value, "//"); /* S/SN/S/N */
		setComponent2(SwiftParseUtils.getTokenFirst(toparse, "/"));
		String toparse2 = SwiftParseUtils.getTokenSecondLast(toparse, "/"); /* SN/S/N */
		String toparse3 = SwiftParseUtils.getTokenFirst(toparse2, "/"); /* SN */
		setComponent3(SwiftParseUtils.getAlphaPrefix(toparse3));
		setComponent4(SwiftParseUtils.getNumericSuffix(toparse3));
		String toparse4 = SwiftParseUtils.getTokenSecondLast(toparse2, "/"); /* S/N */
		setComponent5(SwiftParseUtils.getTokenFirst(toparse4, "/"));
		setComponent6(SwiftParseUtils.getTokenSecondLast(toparse4, "/"));
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
		result.append("/");
		append(result, 3);
		append(result, 4);
		result.append("/");
		append(result, 5);
		result.append("/");
		append(result, 6);
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
			throw new IllegalArgumentException("invalid component number "+component+" for field 90F");
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
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field90F.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field90F.PARSER_PATTERN
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
		return ":4!c//4!c/<CUR><AMOUNT>15/4!c/<AMOUNT>15";
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
		result.add("Amount Type Code");
		result.add("Currency");
		result.add("Amount");
		result.add("Quantity Type Code");
		result.add("Quantity");
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
		result.put(2, "amountTypeCode");
		result.put(3, "currency");
		result.put(4, "amount");
		result.put(5, "quantityTypeCode");
		result.put(6, "quantity");
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
	 * Gets the component2 (Amount Type Code).
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
	 * Gets the Amount Type Code (component2).
	 * @return the Amount Type Code from component2
	 */
	public String getAmountTypeCode() {
		return getComponent(2);
	}
	/**
	 * Gets the component3 (Currency).
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
	 * Gets the Currency (component3).
	 * @return the Currency from component3
	 */
	public String getCurrency() {
		return getComponent(3);
	}
	
	/**
	 * Get the Currency (component3) as Currency
	 * @return the Currency from component3 converted to Currency or null if cannot be converted
	 */
	public java.util.Currency getCurrencyAsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(3));
	}
	/**
	 * Gets the component4 (Amount).
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
	 * Gets the Amount (component4).
	 * @return the Amount from component4
	 */
	public String getAmount() {
		return getComponent(4);
	}
	
	/**
	 * Get the Amount (component4) as Number
	 * @return the Amount from component4 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getAmountAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(4));
	}
	/**
	 * Gets the component5 (Quantity Type Code).
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
	 * Gets the Quantity Type Code (component5).
	 * @return the Quantity Type Code from component5
	 */
	public String getQuantityTypeCode() {
		return getComponent(5);
	}
	/**
	 * Gets the component6 (Quantity).
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
	 * Gets the Quantity (component6).
	 * @return the Quantity from component6
	 */
	public String getQuantity() {
		return getComponent(6);
	}
	
	/**
	 * Get the Quantity (component6) as Number
	 * @return the Quantity from component6 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getQuantityAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(6));
	}
    
	public List<String> currencyStrings() {
		return CurrencyResolver.resolveComponentsPattern(COMPONENTS_PATTERN, components);
	}

	public List<Currency> currencies() {
		final List<String> l = currencyStrings();
		if (l.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final List<Currency> result = new ArrayList<>();
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
    
	/**
	 * @see AmountResolver#amounts(Field)
	 */
	public List<BigDecimal> amounts() {
		return AmountResolver.amounts(this);
	}
	
	/**
	 * @see AmountResolver#amount(Field)
	 */
	public BigDecimal amount() {
		return AmountResolver.amount(this);
	}


	/**
	 * Set the component1 (Qualifier).
	 * @param component1 the component1 to set
	 */
	public Field90F setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Qualifier (component1).
	 * @param component1 the Qualifier to set
	 */
	public Field90F setQualifier(String component1) {
		setComponent(1, component1);
		return this;
	}

	/**
	 * Set the component2 (Amount Type Code).
	 * @param component2 the component2 to set
	 */
	public Field90F setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Amount Type Code (component2).
	 * @param component2 the Amount Type Code to set
	 */
	public Field90F setAmountTypeCode(String component2) {
		setComponent(2, component2);
		return this;
	}

	/**
	 * Set the component3 (Currency).
	 * @param component3 the component3 to set
	 */
	public Field90F setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the component3 from a Currency object.
	 * <br>
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -&gt; 1234,</li>
	 * 	<li>Example: 1234 -&gt; 1234,</li>
	 * 	<li>Example: 1234.56 -&gt; 1234,56</li>
	 * </ul>
	 * @param component3 the Currency with the component3 content to set
	 */
	public Field90F setComponent3(java.util.Currency component3) {
		setComponent(3, SwiftFormatUtils.getCurrency(component3));
		return this;
	}
	
	/**
	 * Set the Currency (component3).
	 * @param component3 the Currency to set
	 */
	public Field90F setCurrency(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the Currency (component3) from a Currency object.
	 * @see #setComponent3(java.util.Currency)
	 * @param component3 Currency with the Currency content to set
	 */
	public Field90F setCurrency(java.util.Currency component3) {
		setComponent3(component3);
		return this;
	}

	/**
	 * Set the component4 (Amount).
	 * @param component4 the component4 to set
	 */
	public Field90F setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the component4 from a Number object.
	 * <br>
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -&gt; 1234,</li>
	 * 	<li>Example: 1234 -&gt; 1234,</li>
	 * 	<li>Example: 1234.56 -&gt; 1234,56</li>
	 * </ul>
	 * @param component4 the Number with the component4 content to set
	 */
	public Field90F setComponent4(java.lang.Number component4) {
		setComponent(4, SwiftFormatUtils.getNumber(component4));
		return this;
	}
	
	/**
	 * Set the Amount (component4).
	 * @param component4 the Amount to set
	 */
	public Field90F setAmount(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the Amount (component4) from a Number object.
	 * @see #setComponent4(java.lang.Number)
	 * @param component4 Number with the Amount content to set
	 */
	public Field90F setAmount(java.lang.Number component4) {
		setComponent4(component4);
		return this;
	}

	/**
	 * Set the component5 (Quantity Type Code).
	 * @param component5 the component5 to set
	 */
	public Field90F setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the Quantity Type Code (component5).
	 * @param component5 the Quantity Type Code to set
	 */
	public Field90F setQuantityTypeCode(String component5) {
		setComponent(5, component5);
		return this;
	}

	/**
	 * Set the component6 (Quantity).
	 * @param component6 the component6 to set
	 */
	public Field90F setComponent6(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the component6 from a Number object.
	 * <br>
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -&gt; 1234,</li>
	 * 	<li>Example: 1234 -&gt; 1234,</li>
	 * 	<li>Example: 1234.56 -&gt; 1234,56</li>
	 * </ul>
	 * @param component6 the Number with the component6 content to set
	 */
	public Field90F setComponent6(java.lang.Number component6) {
		setComponent(6, SwiftFormatUtils.getNumber(component6));
		return this;
	}
	
	/**
	 * Set the Quantity (component6).
	 * @param component6 the Quantity to set
	 */
	public Field90F setQuantity(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the Quantity (component6) from a Number object.
	 * @see #setComponent6(java.lang.Number)
	 * @param component6 Number with the Quantity content to set
	 */
	public Field90F setQuantity(java.lang.Number component6) {
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
	 * @return the static value of Field90F.NAME
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
	public static Field90F get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field90F(t) ;
	}
	
	/**
	 * Gets the first instance of Field90F in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field90F get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field90F in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field90F> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field90F from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field90F> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field90F> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field90F(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}

	/**
	 * This method deserializes the JSON data into a Field90F object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field90F fromJson(final String json) {
		Field90F field = new Field90F();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("qualifier") != null) {
			field.setComponent1(jsonObject.get("qualifier").getAsString());
		}
		if (jsonObject.get("amountTypeCode") != null) {
			field.setComponent2(jsonObject.get("amountTypeCode").getAsString());
		}
		if (jsonObject.get("currency") != null) {
			field.setComponent3(jsonObject.get("currency").getAsString());
		}
		if (jsonObject.get("amount") != null) {
			field.setComponent4(jsonObject.get("amount").getAsString());
		}
		if (jsonObject.get("quantityTypeCode") != null) {
			field.setComponent5(jsonObject.get("quantityTypeCode").getAsString());
		}
		if (jsonObject.get("quantity") != null) {
			field.setComponent6(jsonObject.get("quantity").getAsString());
		}
		return field;
	}
	

}
