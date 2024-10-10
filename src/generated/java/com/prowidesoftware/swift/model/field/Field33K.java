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
 * SWIFT MT Field 33K.
 * <p>
 * Model and parser for field 33K of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: DayMonth: <code>String</code></li>
 * 		<li>Component 2: NumberOfDaysMonths: <code>Long</code></li>
 * 		<li>Component 3: Code: <code>String</code></li>
 * 		<li>Component 4: Currency: <code>Currency</code></li>
 * 		<li>Component 5: Amount: <code>BigDecimal</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;DM&gt;3!n2!a&lt;CUR&gt;&lt;AMOUNT&gt;15</code></li>
 * 		<li>parser pattern: <code>cNS&lt;CUR&gt;N</code></li>
 * 		<li>components pattern: <code>SNSCN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field33K extends Field implements Serializable, MonetaryAmountContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 33K.
	 */
    public static final String NAME = "33K";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_33K = "33K";

	/**
	 * Component number for the DayMonth subfield.
	 */
	public static final Integer DAYMONTH = 1;


	/**
	 * Component number for the Number Of Days/Months subfield.
	 */
	public static final Integer NUMBER_OF_DAYSMONTHS = 2;

	/**
	 * Component number for the Code subfield.
	 */
	public static final Integer CODE = 3;

	/**
	 * Component number for the Currency subfield.
	 */
	public static final Integer CURRENCY = 4;

	/**
	 * Component number for the Amount subfield.
	 */
	public static final Integer AMOUNT = 5;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field33K() {
        super(5);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field33K(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field33K(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "33K")) {
            throw new IllegalArgumentException("cannot create field 33K from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field33K newInstance(Field33K source) {
        Field33K cp = new Field33K();
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
        init(5);
        setComponent1(SwiftParseUtils.getAlphaPrefix(value));
        String toparse = SwiftParseUtils.getNumericSuffix(value);
        setComponent2(SwiftParseUtils.getNumericPrefix(toparse));
        String toparse2 = SwiftParseUtils.getAlphaSuffix(toparse);
        setComponent5(SwiftParseUtils.getNumericSuffix(toparse2));
        String toparse3 = SwiftParseUtils.getAlphaPrefix(toparse2);
        if (toparse3 != null && toparse3.length() > 0) {
            if (toparse3.length() >= 4) {

                // set currency (comp 4, last 3 chars)
                // set code (comp 3, all but last 3 chars)
                String currency = StringUtils.substring(toparse3, -3);
                String code = StringUtils.removeEnd(toparse3, currency);
                setComponent3(code);
                setComponent4(currency);

            } else if (toparse3.length() == 3) {

                // set currency (comp 4, all 3 chars)
                setComponent4(toparse3);
            } else {

                // set code (comp 3, all chars 1 or 2)
                setComponent3(toparse3);
            }
        }
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
        if (component < 1 || component > 5) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 33K");
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
        // This is the last component, return directly without `if`
        //amount, rate
        java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
        f.setMaximumFractionDigits(13);
        BigDecimal n = getComponent5AsBigDecimal();
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
        return "SNSCI";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "cNS<CUR>N";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "<DM>3!n2!a<CUR><AMOUNT>15";
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
        return 5;
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
        result.add("DayMonth");
        result.add("Number Of Days/Months");
        result.add("Code");
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
        result.put(1, "dayMonth");
        result.put(2, "numberOfDaysMonths");
        result.put(3, "code");
        result.put(4, "currency");
        result.put(5, "amount");
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
        super.labelMap.put("daymonth", 1);
        // alias name
        super.labelMap.put("dmmark", 1);
        super.labelMap.put("numberofdaysmonths", 2);
        // alias name
        super.labelMap.put("numberofdaysmonths", 2);
        super.labelMap.put("code", 3);
        super.labelMap.put("currency", 4);
        super.labelMap.put("amount", 5);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (DayMonth).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the DayMonth (component 1).
     * @return the DayMonth from component 1
     */
    public String getDayMonth() {
        return getComponent1();
    }


    /**
     * Gets the component 2 (Number Of Days/Months).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Get the component 2 as Long
     *
     * @return the component 2 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent2AsLong() {
        return SwiftFormatUtils.getLong(getComponent(2));
    }

    /**
     * Gets the Number Of Days/Months (component 2).
     * @return the Number Of Days/Months from component 2
     */
    public String getNumberOfDaysMonths() {
        return getComponent2();
    }


    /**
     * Get the Number Of Days/Months (component 2) as Long
     * @return the Number Of Days/Months from component 2 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getNumberOfDaysMonthsAsLong() {
        return getComponent2AsLong();
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
        return getComponent3();
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
     *
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
        return getComponent4();
    }

    /**
     * Get the Currency (component 4) as Currency
     * @return the Currency from component 4 converted to Currency or null if cannot be converted
     */
    public java.util.Currency getCurrencyAsCurrency() {
        return getComponent4AsCurrency();
    }

    /**
     * Gets the component 5 (Amount).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Get the component 5 as BigDecimal
     *
     * @return the component 5 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getComponent5AsBigDecimal() {
        return SwiftFormatUtils.getBigDecimal(getComponent(5));
    }

    /**
     * Gets the Amount (component 5).
     * @return the Amount from component 5
     */
    public String getAmount() {
        return getComponent5();
    }

    /**
     * Get the Amount (component 5) as BigDecimal
     * @return the Amount from component 5 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getAmountAsBigDecimal() {
        return getComponent5AsBigDecimal();
    }

    /**
     * Set the component 1 (DayMonth).
     *
     * @param component1 the DayMonth to set
     * @return the field object to enable build pattern
     */
    public Field33K setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the DayMonth (component 1).
     *
     * @param component1 the DayMonth to set
     * @return the field object to enable build pattern
     */
    public Field33K setDayMonth(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Number Of Days/Months).
     *
     * @param component2 the Number Of Days/Months to set
     * @return the field object to enable build pattern
     */
    public Field33K setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }


    /**
     * Alternative method setter for field's Number Of Days/Months (component 2) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the Number Of Days/Months content to set
     * @return the field object to enable build pattern
     */
    public Field33K setComponent2(java.lang.Number component2) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component2 instanceof Long) {
            setComponent(2, SwiftFormatUtils.getLong((Long) component2));
        } else if (component2 instanceof BigInteger || component2 instanceof Integer) {
            setComponent(2, SwiftFormatUtils.getLong(component2.longValue()));
        } else if (component2 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(2, SwiftFormatUtils.getLong(component2.longValue()));
        } else {
            // explicitly set component as null
            setComponent(2, null);
        }
        return this;
    }

    /**
     * Set the Number Of Days/Months (component 2).
     *
     * @param component2 the Number Of Days/Months to set
     * @return the field object to enable build pattern
     */
    public Field33K setNumberOfDaysMonths(String component2) {
        return setComponent2(component2);
    }

    /**
     * Alternative method setter for field's Number Of Days/Months (component 2) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the Number Of Days/Months content to set
     * @return the field object to enable build pattern
     */
    public Field33K setNumberOfDaysMonths(java.lang.Number component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Code).
     *
     * @param component3 the Code to set
     * @return the field object to enable build pattern
     */
    public Field33K setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Code (component 3).
     *
     * @param component3 the Code to set
     * @return the field object to enable build pattern
     */
    public Field33K setCode(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Currency).
     *
     * @param component4 the Currency to set
     * @return the field object to enable build pattern
     */
    public Field33K setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component4 from a Currency object.
     *
     * @param component4 the Currency with the Currency content to set
     * @return the field object to enable build pattern
     */
    public Field33K setComponent4(java.util.Currency component4) {
        setComponent(4, SwiftFormatUtils.getCurrency(component4));
        return this;
    }

    /**
     * Set the Currency (component 4).
     *
     * @param component4 the Currency to set
     * @return the field object to enable build pattern
     */
    public Field33K setCurrency(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the Currency (component 4) from a Currency object.
     *
     * @see #setComponent4(java.util.Currency)
     *
     * @param component4 Currency with the Currency content to set
     * @return the field object to enable build pattern
     */
    public Field33K setCurrency(java.util.Currency component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Amount).
     *
     * @param component5 the Amount to set
     * @return the field object to enable build pattern
     */
    public Field33K setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Alternative method setter for field's Amount (component 5) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10.0 becomes an Float)
     *
     * @param component5 the Number with the Amount content to set
     * @return the field object to enable build pattern
     */
    public Field33K setComponent5(java.lang.Number component5) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component5 instanceof BigDecimal) {
            setComponent(5, SwiftFormatUtils.getBigDecimal((BigDecimal) component5));
        } else if (component5 instanceof BigInteger) {
            setComponent(5, SwiftFormatUtils.getBigDecimal(new BigDecimal((BigInteger) component5)));
        } else if (component5 instanceof Long || component5 instanceof Integer) {
            setComponent(5, SwiftFormatUtils.getBigDecimal(BigDecimal.valueOf(component5.longValue())));
        } else if (component5 != null) {
            // it's other non-null Number (Float, Double, etc...)
            setComponent(5, SwiftFormatUtils.getBigDecimal(BigDecimal.valueOf(component5.doubleValue())));
        } else {
            // explicitly set component as null
            setComponent(5, null);
        }
        return this;
    }

    /**
     * Set the Amount (component 5).
     *
     * @param component5 the Amount to set
     * @return the field object to enable build pattern
     */
    public Field33K setAmount(String component5) {
        return setComponent5(component5);
    }

    /**
     * Alternative method setter for field's Amount (component 5) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component5 the Number with the Amount content to set
     * @return the field object to enable build pattern
     */
    public Field33K setAmount(java.lang.Number component5) {
        return setComponent5(component5);
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
     * @return the static value of Field33K.NAME
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
    public static Field33K get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field33K(t);
    }

    /**
     * Gets the first instance of Field33K in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field33K get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field33K in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field33K> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field33K from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field33K> getAll(final SwiftTagListBlock block) {
        final List<Field33K> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field33K(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field33K object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field33K fromJson(final String json) {

        final Field33K field = new Field33K();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - DayMonth

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("dMMark") != null) {
            field.setComponent1(jsonObject.get("dMMark").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("dayMonth") != null) {
            field.setComponent1(jsonObject.get("dayMonth").getAsString());
        }

        // **** COMPONENT 2 - Number Of Days/Months

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("numberofDaysMonths") != null) {
            field.setComponent2(jsonObject.get("numberofDaysMonths").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("numberOfDaysMonths") != null) {
            field.setComponent2(jsonObject.get("numberOfDaysMonths").getAsString());
        }

        // **** COMPONENT 3 - Code

        if (jsonObject.get("code") != null) {
            field.setComponent3(jsonObject.get("code").getAsString());
        }

        // **** COMPONENT 4 - Currency

        if (jsonObject.get("currency") != null) {
            field.setComponent4(jsonObject.get("currency").getAsString());
        }

        // **** COMPONENT 5 - Amount

        if (jsonObject.get("amount") != null) {
            field.setComponent5(jsonObject.get("amount").getAsString());
        }

        return field;
    }


}
