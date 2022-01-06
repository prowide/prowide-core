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
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

import java.io.Serializable;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Currency;

import com.prowidesoftware.swift.model.field.AmountContainer;
import com.prowidesoftware.swift.model.field.AmountResolver;
import com.prowidesoftware.swift.model.field.CurrencyContainer;
import com.prowidesoftware.swift.model.field.CurrencyResolver;

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 34C.
 * <p>
 * Model and parser for field 34C of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Currency</code></li>
 * 		<li><code>BigDecimal</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>4!c/[&lt;N&gt;]&lt;CUR&gt;&lt;AMOUNT&gt;15</code></li>
 * 		<li>parser pattern: <code>S/[c]&lt;CUR&gt;N</code></li>
 * 		<li>components pattern: <code>SSCN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field34C extends Field implements Serializable, CurrencyContainer, AmountContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 34C.
	 */
    public static final String NAME = "34C";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_34C = "34C";
	public static final String PARSER_PATTERN = "S/[c]<CUR>N";

    /**
     * Components pattern.
     *
     * Contains a description of the type for every component. This is <em>DEPRECATED</em>,
     * use TYPES_PATTERN instead, because it distinguishes between N (number) and I (BigDecimal)
     * @see #TYPES_PATTERN
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "SSCN";

    /**
     * Types pattern.
     *
     * Contains a description of the type for every component, use instead of COMPONENTS_PATTERN.
     * @since 9.2.7
     */
	public static final String TYPES_PATTERN = "SSCI";

	/**
	 * Component number for the Commission Type subfield.
	 */
	public static final Integer COMMISSION_TYPE = 1;

	/**
	 * Component number for the Sign subfield.
	 */
	public static final Integer SIGN = 2;

	/**
	 * Component number for the Currency/Percent subfield.
	 */
	public static final Integer CURRENCYPERCENT = 3;

	/**
	 * Alternative (<em>DEPRECATED</em>) constant name for field's Currency/Percent Component number.
	 * @see #CURRENCYPERCENT
	 */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public static final Integer CURRENCY = 3;

	/**
	 * Component number for the Amount/Rate subfield.
	 */
	public static final Integer AMOUNTRATE = 4;

	/**
	 * Alternative (<em>DEPRECATED</em>) constant name for field's Amount/Rate Component number.
	 * @see #AMOUNTRATE
	 */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public static final Integer AMOUNT = 4;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field34C() {
        super(4);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field34C(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field34C(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "34C")) {
            throw new IllegalArgumentException("cannot create field 34C from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field34C newInstance(Field34C source) {
        Field34C cp = new Field34C();
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
     * Create a Tag with this field name and an empty string as value.
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
        init(4);
        setComponent1(SwiftParseUtils.getTokenFirst(value, "/"));
        String toparse = SwiftParseUtils.getTokenSecondLast(value, "/");
        String prefix = SwiftParseUtils.getAlphaPrefix(toparse);
        if (prefix != null) {
            if (prefix.length() > 3) {
                setComponent2(StringUtils.substring(prefix, 0, 1));
                setComponent3(StringUtils.substring(prefix, 1, prefix.length()));
            } else {
                setComponent3(prefix);
            }
        }
        setComponent4(SwiftParseUtils.getNumericSuffix(value));
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
        append(result, 3);
        append(result, 4);
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
        if (component < 1 || component > 4) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 34C");
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
            //amount, rate
            java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
            f.setMaximumFractionDigits(13);
            BigDecimal n = getComponent4AsBigDecimal();
            if (n != null) {
                return f.format(n);
            }
        }
        return null;
    }

    /**
     * Returns the field components pattern
     *
     * This method is <em>DEPRECATED</em>, use <code>typesPattern()</code> instead.
     * @see #typesPattern()
     * @return the static value of Field34C.COMPONENTS_PATTERN
     */
    @Override
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public final String componentsPattern() {
        return COMPONENTS_PATTERN;
    }

    /**
     * Returns the field component types pattern
     *
     * This method returns a letter representing the type for each component in the Field. It supersedes
     * the Components Pattern because it distinguishes between N (Number) and I (BigDecimal).
     * @since 9.2.7
     * @see #TYPES_PATTERN
     * @return the static value of Field34C.TYPES_PATTERN
     */
    @Override
    public final String typesPattern() {
        return TYPES_PATTERN;
    }

    /**
     * Returns the field parser pattern
     * @return the static value of Field34C.PARSER_PATTERN
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
        return "4!c/[<N>]<CUR><AMOUNT>15";
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
        return 4;
    }

    /**
     * Returns english label for components.
     * <br>
     * The index in the list is in sync with specific field component structure.
     * @see #getComponentLabel(int)
     * @since 7.8.4
     */
    @Override
    public List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Commission Type");
        result.add("Sign");
        result.add("Currency/Percent");
        result.add("Amount/Rate");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "commissionType");
        result.put(2, "sign");
        result.put(3, "currencyPercent");
        result.put(4, "amountRate");
        return result;
    }


    /**
     * Gets the component 1 (Commission Type).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Commission Type (component 1).
     * @return the Commission Type from component 1
     */
    public String getCommissionType() {
        return getComponent1();
    }

    /**
     * Gets the component 2 (Sign).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Sign (component 2).
     * @return the Sign from component 2
     */
    public String getSign() {
        return getComponent2();
    }

    /**
     * Gets the component 3 (Currency/Percent).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Get the component 3 as Currency
     *
     * @return the component 3 converted to Currency or null if cannot be converted
     */
    public java.util.Currency getComponent3AsCurrency() {
        return SwiftFormatUtils.getCurrency(getComponent(3));
    }

    /**
     * Gets the Currency/Percent (component 3).
     * @return the Currency/Percent from component 3
     */
    public String getCurrencyPercent() {
        return getComponent3();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Currency/Percent
     * @see #getCurrencyPercent()
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public String getCurrency() {
        return getCurrencyPercent();
    }

    /**
     * Get the Currency/Percent (component 3) as Currency
     * @return the Currency/Percent from component 3 converted to Currency or null if cannot be converted
     */
    public java.util.Currency getCurrencyPercentAsCurrency() {
        return getComponent3AsCurrency();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Currency/Percent as Currency
     * @see #getCurrencyPercentAsCurrency()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.util.Currency getCurrencyAsCurrency() {
        return getCurrencyPercentAsCurrency();
    }

    /**
     * Gets the component 4 (Amount/Rate).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Get the component 4 as BigDecimal
     *
     * @return the component 4 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getComponent4AsBigDecimal() {
        return SwiftFormatUtils.getBigDecimal(getComponent(4));
    }

    /**
     * Get the component 4 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent4AsBigDecimal()</code> to get the proper value.
     *
     * @return the component 4 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent4AsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getComponent4AsNumber() {
        return getComponent4AsBigDecimal();
    }

    /**
     * Gets the Amount/Rate (component 4).
     * @return the Amount/Rate from component 4
     */
    public String getAmountRate() {
        return getComponent4();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Amount/Rate
     * @see #getAmountRate()
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public String getAmount() {
        return getAmountRate();
    }

    /**
     * Get the Amount/Rate (component 4) as BigDecimal
     * @return the Amount/Rate from component 4 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getAmountRateAsBigDecimal() {
        return getComponent4AsBigDecimal();
    }

    /**
     * Get the Amount/Rate (component 4) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent4AsBigDecimal()</code> to get the proper value.
     *
     * @return the component 4 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getAmountRateAsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getAmountRateAsNumber() {
        return getComponent4AsNumber();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Amount/Rate as BigDecimal
     * @see #getAmountRateAsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.math.BigDecimal getAmountAsBigDecimal() {
        return getAmountRateAsBigDecimal();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Amount/Rate (component 4) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent4AsBigDecimal()</code> to get the proper value.
     *
     * @return the component 4 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getAmountRateAsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getAmountAsNumber() {
        return getAmountRateAsNumber();
    }

    /**
     * Set the component 1 (Commission Type).
     *
     * @param component1 the Commission Type to set
     * @return the field object to enable build pattern
     */
    public Field34C setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Commission Type (component 1).
     *
     * @param component1 the Commission Type to set
     * @return the field object to enable build pattern
     */
    public Field34C setCommissionType(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Sign).
     *
     * @param component2 the Sign to set
     * @return the field object to enable build pattern
     */
    public Field34C setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Sign (component 2).
     *
     * @param component2 the Sign to set
     * @return the field object to enable build pattern
     */
    public Field34C setSign(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Currency/Percent).
     *
     * @param component3 the Currency/Percent to set
     * @return the field object to enable build pattern
     */
    public Field34C setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a Currency object.
     *
     * @param component3 the Currency with the Currency/Percent content to set
     * @return the field object to enable build pattern
     */
    public Field34C setComponent3(java.util.Currency component3) {
        setComponent(3, SwiftFormatUtils.getCurrency(component3));
        return this;
    }

    /**
     * Set the Currency/Percent (component 3).
     *
     * @param component3 the Currency/Percent to set
     * @return the field object to enable build pattern
     */
    public Field34C setCurrencyPercent(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Currency/Percent (component 3) from a Currency object.
     *
     * @see #setComponent3(java.util.Currency)
     *
     * @param component3 Currency with the Currency/Percent content to set
     * @return the field object to enable build pattern
     */
    public Field34C setCurrencyPercent(java.util.Currency component3) {
        return setComponent3(component3);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Currency/Percent
     *
     * @see #setCurrencyPercent(String)
     *
     * @param component3 the Currency/Percent to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public Field34C setCurrency(String component3) {
        return setCurrencyPercent(component3);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Currency/Percent from a Currency object.
     *
     * @see #setComponent3(java.util.Currency)
     *
     * @param component3 Currency with the Currency/Percent content to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public Field34C setCurrency(java.util.Currency component3) {
        return setCurrencyPercent(component3);
    }

    /**
     * Set the component 4 (Amount/Rate).
     *
     * @param component4 the Amount/Rate to set
     * @return the field object to enable build pattern
     */
    public Field34C setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component4 from a BigDecimal object.
     * <br>
     * Parses the BigDecimal into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
     * <ul>
     *     <li>Example: 1234.00 -&gt; 1234,</li>
     *     <li>Example: 1234 -&gt; 1234,</li>
     *     <li>Example: 1234.56 -&gt; 1234,56</li>
     * </ul>
     * @since 9.2.7
     *
     * @param component4 the BigDecimal with the Amount/Rate content to set
     * @return the field object to enable build pattern
     */
    public Field34C setComponent4(java.math.BigDecimal component4) {
        setComponent(4, SwiftFormatUtils.getBigDecimal(component4));
        return this;
    }
    /**
     * Alternative method setter for field's Amount/Rate (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10.0 becomes an Float)
     *
     * @param component4 the Number with the Amount/Rate content to set
     * @return the field object to enable build pattern
     * @see #setAmountRate(java.math.BigDecimal)
     */
    public Field34C setComponent4(java.lang.Number component4) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component4 instanceof BigDecimal) {
            setComponent(4, SwiftFormatUtils.getBigDecimal((BigDecimal) component4));
        } else if (component4 instanceof BigInteger) {
            setComponent(4, SwiftFormatUtils.getBigDecimal(new BigDecimal((BigInteger) component4)));
        } else if (component4 instanceof Long || component4 instanceof Integer) {
            setComponent(4, SwiftFormatUtils.getBigDecimal(BigDecimal.valueOf(component4.longValue())));
        } else if (component4 != null) {
            // it's other non-null Number (Float, Double, etc...)
            setComponent(4, SwiftFormatUtils.getBigDecimal(BigDecimal.valueOf(component4.doubleValue())));
        } else {
            // explicitly set component as null
            setComponent(4, null);
        }
        return this;
    }

    /**
     * Set the Amount/Rate (component 4).
     *
     * @param component4 the Amount/Rate to set
     * @return the field object to enable build pattern
     */
    public Field34C setAmountRate(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the Amount/Rate (component 4) from a BigDecimal object.
     *
     * @see #setComponent4(java.math.BigDecimal)
     *
     * @param component4 BigDecimal with the Amount/Rate content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field34C setAmountRate(java.math.BigDecimal component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative method setter for field's Amount/Rate (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Amount/Rate content to set
     * @return the field object to enable build pattern
     * @see #setAmountRate(java.math.BigDecimal)
     */
    public Field34C setAmountRate(java.lang.Number component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Amount/Rate
     *
     * @see #setAmountRate(String)
     *
     * @param component4 the Amount/Rate to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public Field34C setAmount(String component4) {
        return setAmountRate(component4);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Amount/Rate from a BigDecimal object.
     *
     * @see #setComponent4(java.math.BigDecimal)
     *
     * @param component4 BigDecimal with the Amount/Rate content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public Field34C setAmount(java.math.BigDecimal component4) {
        return setAmountRate(component4);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Amount/Rate (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Amount/Rate content to set
     * @return the field object to enable build pattern
     * @see #setAmountRate(java.math.BigDecimal)
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public Field34C setAmount(java.lang.Number component4) {
        return setAmountRate(component4);
    }


    public List<String> currencyStrings() {
        return CurrencyResolver.currencyStrings(this);
    }

    public List<Currency> currencies() {
        return CurrencyResolver.currencies(this);
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
     * Returns the list of all NON-NULL amounts as BigDecimal
     *
     * @return the list of NON-NULL amounts as BigDecimal values
     * @see AmountResolver#amounts(Field)
     */
    public List<BigDecimal> amounts() {
        return AmountResolver.amounts(this);
    }

    /**
     * Returns the first amounts as BigDecimal
     *
     * @return the first amount as BigDecimal value. Can be null
     * @see AmountResolver#amount(Field)
     */
    public BigDecimal amount() {
        return AmountResolver.amount(this);
    }


    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field34C.NAME
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
    public static Field34C get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field34C(t);
    }

    /**
     * Gets the first instance of Field34C in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field34C get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field34C in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field34C> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field34C from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field34C> getAll(final SwiftTagListBlock block) {
        final List<Field34C> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add(new Field34C(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field34C object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field34C fromJson(final String json) {

        final Field34C field = new Field34C();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Commission Type

        if (jsonObject.get("commissionType") != null) {
            field.setComponent1(jsonObject.get("commissionType").getAsString());
        }

        // **** COMPONENT 2 - Sign

        if (jsonObject.get("sign") != null) {
            field.setComponent2(jsonObject.get("sign").getAsString());
        }

        // **** COMPONENT 3 - Currency/Percent

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("currency") != null) {
            field.setComponent3(jsonObject.get("currency").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("currencyPercent") != null) {
            field.setComponent3(jsonObject.get("currencyPercent").getAsString());
        }

        // **** COMPONENT 4 - Amount/Rate

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("amount") != null) {
            field.setComponent4(jsonObject.get("amount").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("amountRate") != null) {
            field.setComponent4(jsonObject.get("amountRate").getAsString());
        }

        return field;
    }


}
