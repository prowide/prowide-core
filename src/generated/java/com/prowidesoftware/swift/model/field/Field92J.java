/*
 * Copyright 2006-2021 Prowide
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
 * <strong>SWIFT MT Field 92J</strong>
 * <p>
 * Model and parser for field 92J of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Currency</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>:4!c/[8c]/4!c/&lt;CUR&gt;&lt;AMOUNT&gt;15[/4!c]</code></li>
 * 		<li>parser pattern: <code>:S/[S]/S/SN[/S]</code></li>
 * 		<li>components pattern: <code>SSSCNS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2020</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field92J extends Field implements Serializable, CurrencyContainer, AmountContainer, GenericField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2020;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 92J
	 */
    public static final String NAME = "92J";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_92J = "92J";
	public static final String PARSER_PATTERN =":S/[S]/S/SN[/S]";
	public static final String COMPONENTS_PATTERN = "SSSCNS";

	/**
	 * Component number for the Qualifier subfield
	 */
	public static final Integer QUALIFIER = 1;

	/**
	 * Component number for the Data Source Scheme subfield
	 */
	public static final Integer DATA_SOURCE_SCHEME = 2;

	/**
	 * Component number for the Code subfield
	 */
	public static final Integer CODE = 3;

	/**
	 * Component number for the Currency subfield
	 */
	public static final Integer CURRENCY = 4;

	/**
	 * Component number for the Amount subfield
	 */
	public static final Integer AMOUNT = 5;

	/**
	 * Component number for the Rate Status subfield
	 */
	public static final Integer RATE_STATUS = 6;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field92J() {
		super(6);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field92J(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field92J(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "92J")) {
			throw new IllegalArgumentException("cannot create field 92J from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field92J newInstance(Field92J source) {
		Field92J cp = new Field92J();
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
		setComponent1(SwiftParseUtils.getTokenFirst(value, ":", "/"));
		setComponent2(SwiftParseUtils.getTokenSecond(value, "/"));
		String toparse = SwiftParseUtils.getTokenThirdLast(value, "/");
		setComponent3(SwiftParseUtils.getTokenFirst(toparse, null, "/"));		
		String toparse2 = SwiftParseUtils.getTokenSecond(toparse, "/");
		setComponent6(SwiftParseUtils.getTokenThirdLast(toparse, "/"));
		setComponent4(SwiftParseUtils.getAlphaPrefix(toparse2));
		setComponent5(SwiftParseUtils.getNumericSuffix(toparse2));
	}
	/**
	 * Serializes the fields' components into the single string value (SWIFT format)
	 */
	@Override
	public String getValue() {
		final StringBuilder result = new StringBuilder();
		result.append(":");
		append(result, 1);
		result.append("/");
		append(result, 2);
		result.append("/");
		append(result, 3);
		result.append("/");
		append(result, 4);
		append(result, 5);
		if (getComponent6() != null) {
			result.append("/").append(getComponent6());
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
			throw new IllegalArgumentException("invalid component number "+component+" for field 92J");
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
			//number, amount, rate
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
			f.setMaximumFractionDigits(13);
    		Number n = getComponent5AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 6) {
			//default format (as is)
			return getComponent(6);
		}
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field92J.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field92J.PARSER_PATTERN
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
		return ":4!c/[8c]/4!c/<CUR><AMOUNT>15[/4!c]";
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
        if (component == 2) {
            return true;
        }
        if (component == 6) {
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
		result.add("Data Source Scheme");
		result.add("Code");
		result.add("Currency");
		result.add("Amount");
		result.add("Rate Status");
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
		result.put(2, "dataSourceScheme");
		result.put(3, "code");
		result.put(4, "currency");
		result.put(5, "amount");
		result.put(6, "rateStatus");
		return result;
	}
	/**
	 * Gets the component 1 (Qualifier).
	 * @return the component 1
	 */
	public String getComponent1() {
		return getComponent(1);
	}

	/**
	 * Gets the Qualifier (component 1).
	 * @return the Qualifier from component 1
	 */
	public String getQualifier() {
		return getComponent(1);
	}
	/**
	 * Gets the component 2 (Data Source Scheme).
	 * @return the component 2
	 */
	public String getComponent2() {
		return getComponent(2);
	}

	/**
	 * Gets the Data Source Scheme (component 2).
	 * @return the Data Source Scheme from component 2
	 */
	public String getDataSourceScheme() {
		return getComponent(2);
	}
	/**
	 * Gets the component 3 (Code).
	 * @return the component 3
	 */
	public String getComponent3() {
		return getComponent(3);
	}

	/**
	 * Gets the Code (component 3).
	 * @return the Code from component 3
	 */
	public String getCode() {
		return getComponent(3);
	}
	/**
	 * Gets the component 4 (Currency).
	 * @return the component 4
	 */
	public String getComponent4() {
		return getComponent(4);
	}

	/**
	 * Get the component 4 as Currency
	 * @return the component 4 converted to Currency or null if cannot be converted
	 */
	public java.util.Currency getComponent4AsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(4));
	}

	/**
	 * Gets the Currency (component 4).
	 * @return the Currency from component 4
	 */
	public String getCurrency() {
		return getComponent(4);
	}
	
	/**
	 * Get the Currency (component 4) as Currency
	 * @return the Currency from component 4 converted to Currency or null if cannot be converted
	 */
	public java.util.Currency getCurrencyAsCurrency() {
		return SwiftFormatUtils.getCurrency(getComponent(4));
	}
	/**
	 * Gets the component 5 (Amount).
	 * @return the component 5
	 */
	public String getComponent5() {
		return getComponent(5);
	}

	/**
	 * Get the component 5 as Number
	 * @return the component 5 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getComponent5AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(5));
	}

	/**
	 * Gets the Amount (component 5).
	 * @return the Amount from component 5
	 */
	public String getAmount() {
		return getComponent(5);
	}
	
	/**
	 * Get the Amount (component 5) as Number
	 * @return the Amount from component 5 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getAmountAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(5));
	}
	/**
	 * Gets the component 6 (Rate Status).
	 * @return the component 6
	 */
	public String getComponent6() {
		return getComponent(6);
	}

	/**
	 * Gets the Rate Status (component 6).
	 * @return the Rate Status from component 6
	 */
	public String getRateStatus() {
		return getComponent(6);
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
	public Field92J setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Qualifier (component1).
	 * @param component1 the Qualifier to set
	 */
	public Field92J setQualifier(String component1) {
		setComponent(1, component1);
		return this;
	}

	/**
	 * Set the component2 (Data Source Scheme).
	 * @param component2 the component2 to set
	 */
	public Field92J setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Data Source Scheme (component2).
	 * @param component2 the Data Source Scheme to set
	 */
	public Field92J setDataSourceScheme(String component2) {
		setComponent(2, component2);
		return this;
	}

	/**
	 * Set the component3 (Code).
	 * @param component3 the component3 to set
	 */
	public Field92J setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the Code (component3).
	 * @param component3 the Code to set
	 */
	public Field92J setCode(String component3) {
		setComponent(3, component3);
		return this;
	}

	/**
	 * Set the component4 (Currency).
	 * @param component4 the component4 to set
	 */
	public Field92J setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the component4 from a Currency object.
	 * <br>
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -&gt; 1234,</li>
	 * 	<li>Example: 1234 -&gt; 1234,</li>
	 * 	<li>Example: 1234.56 -&gt; 1234,56</li>
	 * </ul>
	 * @param component4 the Currency with the component4 content to set
	 */
	public Field92J setComponent4(java.util.Currency component4) {
		setComponent(4, SwiftFormatUtils.getCurrency(component4));
		return this;
	}
	
	/**
	 * Set the Currency (component4).
	 * @param component4 the Currency to set
	 */
	public Field92J setCurrency(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the Currency (component4) from a Currency object.
	 * @see #setComponent4(java.util.Currency)
	 * @param component4 Currency with the Currency content to set
	 */
	public Field92J setCurrency(java.util.Currency component4) {
		setComponent4(component4);
		return this;
	}

	/**
	 * Set the component5 (Amount).
	 * @param component5 the component5 to set
	 */
	public Field92J setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the component5 from a Number object.
	 * <br>
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -&gt; 1234,</li>
	 * 	<li>Example: 1234 -&gt; 1234,</li>
	 * 	<li>Example: 1234.56 -&gt; 1234,56</li>
	 * </ul>
	 * @param component5 the Number with the component5 content to set
	 */
	public Field92J setComponent5(java.lang.Number component5) {
		setComponent(5, SwiftFormatUtils.getNumber(component5));
		return this;
	}
	
	/**
	 * Set the Amount (component5).
	 * @param component5 the Amount to set
	 */
	public Field92J setAmount(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the Amount (component5) from a Number object.
	 * @see #setComponent5(java.lang.Number)
	 * @param component5 Number with the Amount content to set
	 */
	public Field92J setAmount(java.lang.Number component5) {
		setComponent5(component5);
		return this;
	}

	/**
	 * Set the component6 (Rate Status).
	 * @param component6 the component6 to set
	 */
	public Field92J setComponent6(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the Rate Status (component6).
	 * @param component6 the Rate Status to set
	 */
	public Field92J setRateStatus(String component6) {
		setComponent(6, component6);
		return this;
	}


   /**
    * Returns the issuer code (or Data Source Scheme or DSS).
    * The DSS is only present in some generic fields, when present, is equals to component two.
    *
    * @return DSS component value or null if the DSS is not set or not available for this field.
    */
   public String getDSS() {
       return getComponent2();
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
    public static final Integer CONDITIONAL_QUALIFIER = 3;
   
   /**
    * Gets the component with the conditional (secondary) qualifier.
    *
    * @return for generic fields returns the value of the conditional qualifier or null if not set or not applicable for this field.
    */
   public String getConditionalQualifier() {
       return getComponent(CONDITIONAL_QUALIFIER);
   }
   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field92J.NAME
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
	public static Field92J get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field92J(t) ;
	}
	
	/**
	 * Gets the first instance of Field92J in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field92J get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field92J in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field92J> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field92J from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field92J> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field92J> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field92J(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}

	/**
	 * This method deserializes the JSON data into a Field92J object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field92J fromJson(final String json) {
		Field92J field = new Field92J();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("qualifier") != null) {
			field.setComponent1(jsonObject.get("qualifier").getAsString());
		}
		if (jsonObject.get("dataSourceScheme") != null) {
			field.setComponent2(jsonObject.get("dataSourceScheme").getAsString());
		}
		if (jsonObject.get("code") != null) {
			field.setComponent3(jsonObject.get("code").getAsString());
		}
		if (jsonObject.get("currency") != null) {
			field.setComponent4(jsonObject.get("currency").getAsString());
		}
		if (jsonObject.get("amount") != null) {
			field.setComponent5(jsonObject.get("amount").getAsString());
		}
		if (jsonObject.get("rateStatus") != null) {
			field.setComponent6(jsonObject.get("rateStatus").getAsString());
		}
		return field;
	}
	
    /**
     * @deprecated use RATE_STATUS instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public static final Integer NARRATIVE = 6;

    /**
     * @deprecated use getRateStatus instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public String getNarrative() {
        return getRateStatus();
    }

    /**
     * @deprecated use setRateStatus instead
     */
    @Deprecated
    @com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear.SRU2022)
    public Field92J setNarrative(String narrative) {
        return setRateStatus(narrative);
    }

}
