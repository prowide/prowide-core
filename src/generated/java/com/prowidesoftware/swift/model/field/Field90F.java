/*
 * Copyright 2006-2024 Prowide
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

import com.prowidesoftware.swift.model.field.GenericField;
import com.prowidesoftware.swift.model.field.MonetaryAmountContainer;
import com.prowidesoftware.swift.model.field.MonetaryAmountResolver;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 90F.
 * <p>
 * Model and parser for field 90F of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Qualifier: <code>String</code></li>
 * 		<li>Component 2: AmountTypeCode: <code>String</code></li>
 * 		<li>Component 3: CurrencyCode: <code>Currency</code></li>
 * 		<li>Component 4: Amount: <code>BigDecimal</code></li>
 * 		<li>Component 5: QuantityTypeCode: <code>String</code></li>
 * 		<li>Component 6: Quantity: <code>BigDecimal</code></li>
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
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field90F extends Field implements Serializable, MonetaryAmountContainer, GenericField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 90F.
	 */
    public static final String NAME = "90F";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_90F = "90F";

	/**
	 * Component number for the Qualifier subfield.
	 */
	public static final Integer QUALIFIER = 1;

	/**
	 * Component number for the Amount Type Code subfield.
	 */
	public static final Integer AMOUNT_TYPE_CODE = 2;

	/**
	 * Component number for the Currency Code subfield.
	 */
	public static final Integer CURRENCY_CODE = 3;


	/**
	 * Component number for the Amount subfield.
	 */
	public static final Integer AMOUNT = 4;

	/**
	 * Component number for the Quantity Type Code subfield.
	 */
	public static final Integer QUANTITY_TYPE_CODE = 5;

	/**
	 * Component number for the Quantity subfield.
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
     * Copy constructor.
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
        init(6);
        setComponent1(SwiftParseUtils.getTokenFirst(value, ":", "//"));
        String toparse = SwiftParseUtils.getTokenSecondLast(value, "//"); /* S/SN/S/N */
        setComponent2(SwiftParseUtils.getTokenFirst(toparse, "/"));
        String toparse2 = SwiftParseUtils.getTokenSecondLast(toparse, "/"); /* SN/S/N */
        String toparse3 = SwiftParseUtils.getTokenFirst(toparse2, "/"); /* SN */
        setComponent3(SwiftParseUtils.getAlphaPrefixTrimSlash(toparse3));
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 90F");
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
        if (component == 5) {
            //default format (as is)
            return getComponent(5);
        }
        // This is the last component, return directly without `if`
        //amount, rate
        java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
        f.setMaximumFractionDigits(13);
        BigDecimal n = getComponent6AsBigDecimal();
        if (n != null) {
            return f.format(n);
        }
        return null;
    }

    /**
     * Returns the field component types pattern.
     * <p>
     * This method returns a letter representing the type for each component in the Field. It supersedes
     * the Components Pattern because it distinguishes between N (Number) and I (BigDecimal).
     * @since 9.2.7
     */
    @Override
    public String typesPattern() {
        return "SSCISI";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return ":S//S/SN/S/N";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
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
    public List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Qualifier");
        result.add("Amount Type Code");
        result.add("Currency Code");
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
        result.put(3, "currencyCode");
        result.put(4, "amount");
        result.put(5, "quantityTypeCode");
        result.put(6, "quantity");
        return result;
    }

    /**
     * @see Field#getLabelMap()
     * @since 9.3.12
     */
    @Override
    protected Map<String, Integer> getLabelMap() {
        if (super.labelMap != null && !super.labelMap.isEmpty()) {
            // return cached map
            return super.labelMap;
        }
        super.labelMap = new HashMap<>();
        super.labelMap.put("qualifier", 1);
        super.labelMap.put("amounttypecode", 2);
        super.labelMap.put("currencycode", 3);
        // alias name
        super.labelMap.put("currency", 3);
        super.labelMap.put("amount", 4);
        super.labelMap.put("quantitytypecode", 5);
        super.labelMap.put("quantity", 6);
        return super.labelMap;
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
        return getComponent1();
    }

    /**
     * Gets the component 2 (Amount Type Code).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Amount Type Code (component 2).
     * @return the Amount Type Code from component 2
     */
    public String getAmountTypeCode() {
        return getComponent2();
    }

    /**
     * Gets the component 3 (Currency Code).
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
     * Gets the Currency Code (component 3).
     * @return the Currency Code from component 3
     */
    public String getCurrencyCode() {
        return getComponent3();
    }


    /**
     * Get the Currency Code (component 3) as Currency
     * @return the Currency Code from component 3 converted to Currency or null if cannot be converted
     */
    public java.util.Currency getCurrencyCodeAsCurrency() {
        return getComponent3AsCurrency();
    }

    /**
     * Gets the component 4 (Amount).
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
     * Gets the Amount (component 4).
     * @return the Amount from component 4
     */
    public String getAmount() {
        return getComponent4();
    }

    /**
     * Get the Amount (component 4) as BigDecimal
     * @return the Amount from component 4 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getAmountAsBigDecimal() {
        return getComponent4AsBigDecimal();
    }

    /**
     * Gets the component 5 (Quantity Type Code).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Gets the Quantity Type Code (component 5).
     * @return the Quantity Type Code from component 5
     */
    public String getQuantityTypeCode() {
        return getComponent5();
    }

    /**
     * Gets the component 6 (Quantity).
     * @return the component 6
     */
    public String getComponent6() {
        return getComponent(6);
    }

    /**
     * Get the component 6 as BigDecimal
     *
     * @return the component 6 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getComponent6AsBigDecimal() {
        return SwiftFormatUtils.getBigDecimal(getComponent(6));
    }

    /**
     * Gets the Quantity (component 6).
     * @return the Quantity from component 6
     */
    public String getQuantity() {
        return getComponent6();
    }

    /**
     * Get the Quantity (component 6) as BigDecimal
     * @return the Quantity from component 6 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getQuantityAsBigDecimal() {
        return getComponent6AsBigDecimal();
    }

    /**
     * Set the component 1 (Qualifier).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field90F setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Qualifier (component 1).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field90F setQualifier(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Amount Type Code).
     *
     * @param component2 the Amount Type Code to set
     * @return the field object to enable build pattern
     */
    public Field90F setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Amount Type Code (component 2).
     *
     * @param component2 the Amount Type Code to set
     * @return the field object to enable build pattern
     */
    public Field90F setAmountTypeCode(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Currency Code).
     *
     * @param component3 the Currency Code to set
     * @return the field object to enable build pattern
     */
    public Field90F setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a Currency object.
     *
     * @param component3 the Currency with the Currency Code content to set
     * @return the field object to enable build pattern
     */
    public Field90F setComponent3(java.util.Currency component3) {
        setComponent(3, SwiftFormatUtils.getCurrency(component3));
        return this;
    }

    /**
     * Set the Currency Code (component 3).
     *
     * @param component3 the Currency Code to set
     * @return the field object to enable build pattern
     */
    public Field90F setCurrencyCode(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Currency Code (component 3) from a Currency object.
     *
     * @see #setComponent3(java.util.Currency)
     *
     * @param component3 Currency with the Currency Code content to set
     * @return the field object to enable build pattern
     */
    public Field90F setCurrencyCode(java.util.Currency component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Amount).
     *
     * @param component4 the Amount to set
     * @return the field object to enable build pattern
     */
    public Field90F setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Alternative method setter for field's Amount (component 4) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10.0 becomes an Float)
     *
     * @param component4 the Number with the Amount content to set
     * @return the field object to enable build pattern
     */
    public Field90F setComponent4(java.lang.Number component4) {

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
     * Set the Amount (component 4).
     *
     * @param component4 the Amount to set
     * @return the field object to enable build pattern
     */
    public Field90F setAmount(String component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative method setter for field's Amount (component 4) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Amount content to set
     * @return the field object to enable build pattern
     */
    public Field90F setAmount(java.lang.Number component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Quantity Type Code).
     *
     * @param component5 the Quantity Type Code to set
     * @return the field object to enable build pattern
     */
    public Field90F setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the Quantity Type Code (component 5).
     *
     * @param component5 the Quantity Type Code to set
     * @return the field object to enable build pattern
     */
    public Field90F setQuantityTypeCode(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the component 6 (Quantity).
     *
     * @param component6 the Quantity to set
     * @return the field object to enable build pattern
     */
    public Field90F setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }

    /**
     * Alternative method setter for field's Quantity (component 6) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10.0 becomes an Float)
     *
     * @param component6 the Number with the Quantity content to set
     * @return the field object to enable build pattern
     */
    public Field90F setComponent6(java.lang.Number component6) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component6 instanceof BigDecimal) {
            setComponent(6, SwiftFormatUtils.getBigDecimal((BigDecimal) component6));
        } else if (component6 instanceof BigInteger) {
            setComponent(6, SwiftFormatUtils.getBigDecimal(new BigDecimal((BigInteger) component6)));
        } else if (component6 instanceof Long || component6 instanceof Integer) {
            setComponent(6, SwiftFormatUtils.getBigDecimal(BigDecimal.valueOf(component6.longValue())));
        } else if (component6 != null) {
            // it's other non-null Number (Float, Double, etc...)
            setComponent(6, SwiftFormatUtils.getBigDecimal(BigDecimal.valueOf(component6.doubleValue())));
        } else {
            // explicitly set component as null
            setComponent(6, null);
        }
        return this;
    }

    /**
     * Set the Quantity (component 6).
     *
     * @param component6 the Quantity to set
     * @return the field object to enable build pattern
     */
    public Field90F setQuantity(String component6) {
        return setComponent6(component6);
    }

    /**
     * Alternative method setter for field's Quantity (component 6) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component6 the Number with the Quantity content to set
     * @return the field object to enable build pattern
     */
    public Field90F setQuantity(java.lang.Number component6) {
        return setComponent6(component6);
    }


    @Override
    public List<String> currencyStrings() {
        return MonetaryAmountResolver.currencyStrings(this);
    }

    @Override
    public List<Currency> currencies() {
        return MonetaryAmountResolver.currencies(this);
    }

    @Override
    public Currency currency() {
        return MonetaryAmountResolver.resolveCurrency(this);
    }

    @Override
    public String currencyString() {
        return MonetaryAmountResolver.resolveCurrencyString(this);
    }

    @Override
    public void initializeCurrencies(String cur) {
        MonetaryAmountResolver.resolveSetCurrency(this, cur);
    }

    @Override
    public void initializeCurrencies(Currency cur) {
        MonetaryAmountResolver.resolveSetCurrency(this, cur);
    }

    /**
     * Returns the list of all NON-NULL amounts as BigDecimal
     *
     * @return the list of NON-NULL amounts as BigDecimal values
     * @see MonetaryAmountResolver#amounts(Field)
     */
    public List<BigDecimal> amounts() {
        return MonetaryAmountResolver.amounts(this);
    }

    /**
     * Returns the first amounts as BigDecimal
     *
     * @return the first amount as BigDecimal value. Can be null
     * @see MonetaryAmountResolver#amount(Field)
     */
    @Override
    public BigDecimal amount() {
        return MonetaryAmountResolver.amount(this);
    }


    /**
     * Returns the issuer code (or Data Source Scheme or DSS).
     * The DSS is only present in some generic fields, when present, is equals to component two.
     *
     * @return DSS component value or null if the DSS is not set or not available for this field.
     */
    @Override
    public String getDSS() {
        return null;
    }

    /**
     * Checks if the issuer code (or Data Source Scheme or DSS) is present.
     *
     * @see #getDSS()
     * @return true if DSS is present, false otherwise.
     */
    @Override
    public boolean isDSSPresent() {
        return false;
    }

    /**
     * Component number for the conditional qualifier subfield.
     */
    public static final Integer CONDITIONAL_QUALIFIER = 2;

    /**
     * Gets the component with the conditional (secondary) qualifier.
     *
     * @return for generic fields returns the value of the conditional qualifier or null if not set or not applicable for this field.
     */
    @Override
    public String getConditionalQualifier() {
        return getComponent(CONDITIONAL_QUALIFIER);
    }

    /**
     * Returns the field's name composed by the field number and the letter option (if any).
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
        return new Field90F(t);
    }

    /**
     * Gets the first instance of Field90F in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field90F get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field90F in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field90F> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field90F from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field90F> getAll(final SwiftTagListBlock block) {
        final List<Field90F> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field90F(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field90F object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field90F fromJson(final String json) {

        final Field90F field = new Field90F();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Qualifier

        if (jsonObject.get("qualifier") != null) {
            field.setComponent1(jsonObject.get("qualifier").getAsString());
        }

        // **** COMPONENT 2 - Amount Type Code

        if (jsonObject.get("amountTypeCode") != null) {
            field.setComponent2(jsonObject.get("amountTypeCode").getAsString());
        }

        // **** COMPONENT 3 - Currency Code

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("currency") != null) {
            field.setComponent3(jsonObject.get("currency").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("currencyCode") != null) {
            field.setComponent3(jsonObject.get("currencyCode").getAsString());
        }

        // **** COMPONENT 4 - Amount

        if (jsonObject.get("amount") != null) {
            field.setComponent4(jsonObject.get("amount").getAsString());
        }

        // **** COMPONENT 5 - Quantity Type Code

        if (jsonObject.get("quantityTypeCode") != null) {
            field.setComponent5(jsonObject.get("quantityTypeCode").getAsString());
        }

        // **** COMPONENT 6 - Quantity

        if (jsonObject.get("quantity") != null) {
            field.setComponent6(jsonObject.get("quantity").getAsString());
        }

        return field;
    }


}
