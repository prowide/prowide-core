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

import com.prowidesoftware.swift.model.field.MonetaryAmountContainer;
import com.prowidesoftware.swift.model.field.MonetaryAmountResolver;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 34E.
 * <p>
 * Model and parser for field 34E of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Sign: <code>String</code></li>
 * 		<li>Component 2: Currency: <code>Currency</code></li>
 * 		<li>Component 3: Amount: <code>BigDecimal</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>[&lt;N&gt;]&lt;CUR&gt;&lt;AMOUNT&gt;15</code></li>
 * 		<li>parser pattern: <code>[c]&lt;CUR&gt;N</code></li>
 * 		<li>components pattern: <code>SCN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field34E extends Field implements Serializable, MonetaryAmountContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 34E.
	 */
    public static final String NAME = "34E";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_34E = "34E";

	/**
	 * Component number for the Sign subfield.
	 */
	public static final Integer SIGN = 1;

	/**
	 * Component number for the Currency subfield.
	 */
	public static final Integer CURRENCY = 2;

	/**
	 * Component number for the Amount subfield.
	 */
	public static final Integer AMOUNT = 3;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field34E() {
        super(3);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field34E(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field34E(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "34E")) {
            throw new IllegalArgumentException("cannot create field 34E from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field34E newInstance(Field34E source) {
        Field34E cp = new Field34E();
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
        init(3);
        String prefix = SwiftParseUtils.getAlphaPrefix(value);
        if (prefix != null) {
            if (prefix.length() > 3) {
                setComponent1(StringUtils.substring(prefix, 0, 1));
                setComponent2(StringUtils.substring(prefix, 1, prefix.length()));
            } else {
                setComponent2(prefix);
            }
        }
        setComponent3(SwiftParseUtils.getNumericSuffix(value));
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        result.append(joinComponents());
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
        if (component < 1 || component > 3) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 34E");
        }
        if (component == 1) {
            //default format (as is)
            return getComponent(1);
        }
        if (component == 2) {
            //default format (as is)
            return getComponent(2);
        }
        // This is the last component, return directly without `if`
        //amount, rate
        java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
        f.setMaximumFractionDigits(13);
        BigDecimal n = getComponent3AsBigDecimal();
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
        return "SCI";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "[c]<CUR>N";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "[<N>]<CUR><AMOUNT>15";
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
        if (component == 1) {
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
        return 3;
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
        result.add("Sign");
        result.add("Currency");
        result.add("Amount");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "sign");
        result.put(2, "currency");
        result.put(3, "amount");
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
        super.labelMap.put("sign", 1);
        super.labelMap.put("currency", 2);
        super.labelMap.put("amount", 3);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Sign).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Sign (component 1).
     * @return the Sign from component 1
     */
    public String getSign() {
        return getComponent1();
    }

    /**
     * Gets the component 2 (Currency).
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
     * Gets the Currency (component 2).
     * @return the Currency from component 2
     */
    public String getCurrency() {
        return getComponent2();
    }

    /**
     * Get the Currency (component 2) as Currency
     * @return the Currency from component 2 converted to Currency or null if cannot be converted
     */
    public java.util.Currency getCurrencyAsCurrency() {
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
     * Set the component 1 (Sign).
     *
     * @param component1 the Sign to set
     * @return the field object to enable build pattern
     */
    public Field34E setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Sign (component 1).
     *
     * @param component1 the Sign to set
     * @return the field object to enable build pattern
     */
    public Field34E setSign(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Currency).
     *
     * @param component2 the Currency to set
     * @return the field object to enable build pattern
     */
    public Field34E setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Currency object.
     *
     * @param component2 the Currency with the Currency content to set
     * @return the field object to enable build pattern
     */
    public Field34E setComponent2(java.util.Currency component2) {
        setComponent(2, SwiftFormatUtils.getCurrency(component2));
        return this;
    }

    /**
     * Set the Currency (component 2).
     *
     * @param component2 the Currency to set
     * @return the field object to enable build pattern
     */
    public Field34E setCurrency(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Currency (component 2) from a Currency object.
     *
     * @see #setComponent2(java.util.Currency)
     *
     * @param component2 Currency with the Currency content to set
     * @return the field object to enable build pattern
     */
    public Field34E setCurrency(java.util.Currency component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Amount).
     *
     * @param component3 the Amount to set
     * @return the field object to enable build pattern
     */
    public Field34E setComponent3(String component3) {
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
    public Field34E setComponent3(java.lang.Number component3) {

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
    public Field34E setAmount(String component3) {
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
    public Field34E setAmount(java.lang.Number component3) {
        return setComponent3(component3);
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
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field34E.NAME
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
    public static Field34E get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field34E(t);
    }

    /**
     * Gets the first instance of Field34E in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field34E get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field34E in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field34E> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field34E from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field34E> getAll(final SwiftTagListBlock block) {
        final List<Field34E> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field34E(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field34E object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field34E fromJson(final String json) {

        final Field34E field = new Field34E();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Sign

        if (jsonObject.get("sign") != null) {
            field.setComponent1(jsonObject.get("sign").getAsString());
        }

        // **** COMPONENT 2 - Currency

        if (jsonObject.get("currency") != null) {
            field.setComponent2(jsonObject.get("currency").getAsString());
        }

        // **** COMPONENT 3 - Amount

        if (jsonObject.get("amount") != null) {
            field.setComponent3(jsonObject.get("amount").getAsString());
        }

        return field;
    }


}
