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
 * SWIFT MT Field 92M.
 * <p>
 * Model and parser for field 92M of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Qualifier: <code>String</code></li>
 * 		<li>Component 2: CurrencyCode: <code>Currency</code></li>
 * 		<li>Component 3: Amount: <code>BigDecimal</code></li>
 * 		<li>Component 4: Quantity: <code>BigDecimal</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>:4!c//&lt;CUR&gt;&lt;AMOUNT&gt;15/&lt;AMOUNT&gt;15</code></li>
 * 		<li>parser pattern: <code>:S//SN/S</code></li>
 * 		<li>components pattern: <code>SCNN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field92M extends Field implements Serializable, MonetaryAmountContainer, GenericField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 92M.
	 */
    public static final String NAME = "92M";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_92M = "92M";

	/**
	 * Component number for the Qualifier subfield.
	 */
	public static final Integer QUALIFIER = 1;

	/**
	 * Component number for the Currency Code subfield.
	 */
	public static final Integer CURRENCY_CODE = 2;


	/**
	 * Component number for the Amount subfield.
	 */
	public static final Integer AMOUNT = 3;

	/**
	 * Component number for the Quantity subfield.
	 */
	public static final Integer QUANTITY = 4;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field92M() {
        super(4);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field92M(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field92M(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "92M")) {
            throw new IllegalArgumentException("cannot create field 92M from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field92M newInstance(Field92M source) {
        Field92M cp = new Field92M();
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
        setComponent1(SwiftParseUtils.getTokenFirst(value, ":", "//"));
        String toparse = SwiftParseUtils.getTokenSecondLast(value, "//");
        String toparse2 = SwiftParseUtils.getTokenFirst(toparse, "/");
        setComponent4(SwiftParseUtils.getTokenSecondLast(toparse, "/"));
        setComponent2(SwiftParseUtils.getAlphaPrefixTrimSlash(toparse2));
        setComponent3(SwiftParseUtils.getNumericSuffix(toparse2));
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
        result.append("/");
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 92M");
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
            //amount, rate
            java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
            f.setMaximumFractionDigits(13);
            BigDecimal n = getComponent3AsBigDecimal();
            if (n != null) {
                return f.format(n);
            }
        }
        // This is the last component, return directly without `if`
        //amount, rate
        java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
        f.setMaximumFractionDigits(13);
        BigDecimal n = getComponent4AsBigDecimal();
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
        return "SCII";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return ":S//SN/S";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return ":4!c//<CUR><AMOUNT>15/<AMOUNT>15";
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
        result.add("Qualifier");
        result.add("Currency Code");
        result.add("Amount");
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
        result.put(2, "currencyCode");
        result.put(3, "amount");
        result.put(4, "quantity");
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
        super.labelMap.put("currencycode", 2);
        // alias name
        super.labelMap.put("currency", 2);
        super.labelMap.put("amount", 3);
        super.labelMap.put("quantity", 4);
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
     * Gets the component 2 (Currency Code).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Get the component 2 as Currency
     *
     * @return the component 2 converted to Currency or null if cannot be converted
     */
    public java.util.Currency getComponent2AsCurrency() {
        return SwiftFormatUtils.getCurrency(getComponent(2));
    }

    /**
     * Gets the Currency Code (component 2).
     * @return the Currency Code from component 2
     */
    public String getCurrencyCode() {
        return getComponent2();
    }


    /**
     * Get the Currency Code (component 2) as Currency
     * @return the Currency Code from component 2 converted to Currency or null if cannot be converted
     */
    public java.util.Currency getCurrencyCodeAsCurrency() {
        return getComponent2AsCurrency();
    }

    /**
     * Gets the component 3 (Amount).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Get the component 3 as BigDecimal
     *
     * @return the component 3 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getComponent3AsBigDecimal() {
        return SwiftFormatUtils.getBigDecimal(getComponent(3));
    }

    /**
     * Gets the Amount (component 3).
     * @return the Amount from component 3
     */
    public String getAmount() {
        return getComponent3();
    }

    /**
     * Get the Amount (component 3) as BigDecimal
     * @return the Amount from component 3 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getAmountAsBigDecimal() {
        return getComponent3AsBigDecimal();
    }

    /**
     * Gets the component 4 (Quantity).
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
     * Gets the Quantity (component 4).
     * @return the Quantity from component 4
     */
    public String getQuantity() {
        return getComponent4();
    }

    /**
     * Get the Quantity (component 4) as BigDecimal
     * @return the Quantity from component 4 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getQuantityAsBigDecimal() {
        return getComponent4AsBigDecimal();
    }

    /**
     * Set the component 1 (Qualifier).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field92M setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Qualifier (component 1).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field92M setQualifier(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Currency Code).
     *
     * @param component2 the Currency Code to set
     * @return the field object to enable build pattern
     */
    public Field92M setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Currency object.
     *
     * @param component2 the Currency with the Currency Code content to set
     * @return the field object to enable build pattern
     */
    public Field92M setComponent2(java.util.Currency component2) {
        setComponent(2, SwiftFormatUtils.getCurrency(component2));
        return this;
    }

    /**
     * Set the Currency Code (component 2).
     *
     * @param component2 the Currency Code to set
     * @return the field object to enable build pattern
     */
    public Field92M setCurrencyCode(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Currency Code (component 2) from a Currency object.
     *
     * @see #setComponent2(java.util.Currency)
     *
     * @param component2 Currency with the Currency Code content to set
     * @return the field object to enable build pattern
     */
    public Field92M setCurrencyCode(java.util.Currency component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Amount).
     *
     * @param component3 the Amount to set
     * @return the field object to enable build pattern
     */
    public Field92M setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Alternative method setter for field's Amount (component 3) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10.0 becomes an Float)
     *
     * @param component3 the Number with the Amount content to set
     * @return the field object to enable build pattern
     */
    public Field92M setComponent3(java.lang.Number component3) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component3 instanceof BigDecimal) {
            setComponent(3, SwiftFormatUtils.getBigDecimal((BigDecimal) component3));
        } else if (component3 instanceof BigInteger) {
            setComponent(3, SwiftFormatUtils.getBigDecimal(new BigDecimal((BigInteger) component3)));
        } else if (component3 instanceof Long || component3 instanceof Integer) {
            setComponent(3, SwiftFormatUtils.getBigDecimal(BigDecimal.valueOf(component3.longValue())));
        } else if (component3 != null) {
            // it's other non-null Number (Float, Double, etc...)
            setComponent(3, SwiftFormatUtils.getBigDecimal(BigDecimal.valueOf(component3.doubleValue())));
        } else {
            // explicitly set component as null
            setComponent(3, null);
        }
        return this;
    }

    /**
     * Set the Amount (component 3).
     *
     * @param component3 the Amount to set
     * @return the field object to enable build pattern
     */
    public Field92M setAmount(String component3) {
        return setComponent3(component3);
    }

    /**
     * Alternative method setter for field's Amount (component 3) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Amount content to set
     * @return the field object to enable build pattern
     */
    public Field92M setAmount(java.lang.Number component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Quantity).
     *
     * @param component4 the Quantity to set
     * @return the field object to enable build pattern
     */
    public Field92M setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Alternative method setter for field's Quantity (component 4) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10.0 becomes an Float)
     *
     * @param component4 the Number with the Quantity content to set
     * @return the field object to enable build pattern
     */
    public Field92M setComponent4(java.lang.Number component4) {

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
     * Set the Quantity (component 4).
     *
     * @param component4 the Quantity to set
     * @return the field object to enable build pattern
     */
    public Field92M setQuantity(String component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative method setter for field's Quantity (component 4) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Quantity content to set
     * @return the field object to enable build pattern
     */
    public Field92M setQuantity(java.lang.Number component4) {
        return setComponent4(component4);
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
     * @return the static value of Field92M.NAME
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
    public static Field92M get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field92M(t);
    }

    /**
     * Gets the first instance of Field92M in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field92M get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field92M in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field92M> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field92M from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field92M> getAll(final SwiftTagListBlock block) {
        final List<Field92M> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field92M(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field92M object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field92M fromJson(final String json) {

        final Field92M field = new Field92M();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Qualifier

        if (jsonObject.get("qualifier") != null) {
            field.setComponent1(jsonObject.get("qualifier").getAsString());
        }

        // **** COMPONENT 2 - Currency Code

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("currency") != null) {
            field.setComponent2(jsonObject.get("currency").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("currencyCode") != null) {
            field.setComponent2(jsonObject.get("currencyCode").getAsString());
        }

        // **** COMPONENT 3 - Amount

        if (jsonObject.get("amount") != null) {
            field.setComponent3(jsonObject.get("amount").getAsString());
        }

        // **** COMPONENT 4 - Quantity

        if (jsonObject.get("quantity") != null) {
            field.setComponent4(jsonObject.get("quantity").getAsString());
        }

        return field;
    }


}
