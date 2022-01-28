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
import java.util.Calendar;
import java.util.Currency;

import com.prowidesoftware.swift.model.field.AmountContainer;
import com.prowidesoftware.swift.model.field.AmountResolver;
import com.prowidesoftware.swift.model.field.CurrencyContainer;
import com.prowidesoftware.swift.model.field.CurrencyResolver;
import com.prowidesoftware.swift.model.field.DateContainer;
import com.prowidesoftware.swift.model.field.DateResolver;

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 60M.
 * <p>
 * Model and parser for field 60M of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>Calendar</code></li>
 * 		<li><code>Currency</code></li>
 * 		<li><code>BigDecimal</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;DC&gt;&lt;DATE2&gt;&lt;3!a&gt;&lt;AMOUNT&gt;15</code></li>
 * 		<li>parser pattern: <code>[c]&lt;DATE2&gt;SN</code></li>
 * 		<li>components pattern: <code>SECN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field60M extends Field implements Serializable, CurrencyContainer, DateContainer, AmountContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 60M.
	 */
    public static final String NAME = "60M";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_60M = "60M";

    /**
     * @deprecated use {@link #parserPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
	public static final String PARSER_PATTERN = "[c]<DATE2>SN";

    /**
     * @deprecated use {@link #typesPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "SECN";

    /**
     * @deprecated use {@link #typesPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
	public static final String TYPES_PATTERN = "SECI";

	/**
	 * Component number for the D/C Mark subfield.
	 */
	public static final Integer DC_MARK = 1;

	/**
	 * Component number for the Date subfield.
	 */
	public static final Integer DATE = 2;

	/**
	 * Component number for the Currency subfield.
	 */
	public static final Integer CURRENCY = 3;

	/**
     * Alternative constant name for field's Currency Component number.
     * @see #CURRENCY
     */
    public static final Integer UNIT = 3;

	/**
	 * Component number for the Amount subfield.
	 */
	public static final Integer AMOUNT = 4;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field60M() {
        super(4);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field60M(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field60M(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "60M")) {
            throw new IllegalArgumentException("cannot create field 60M from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field60M newInstance(Field60M source) {
        Field60M cp = new Field60M();
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
        setComponent1(SwiftParseUtils.getAlphaPrefix(value));
        String toparse = SwiftParseUtils.getNumericSuffix(value);
        setComponent2(SwiftParseUtils.getNumericPrefix(toparse));
        String toparse2 = SwiftParseUtils.getAlphaSuffix(toparse);
        setComponent3(SwiftParseUtils.getAlphaPrefix(toparse2));
        setComponent4(SwiftParseUtils.getNumericSuffix(toparse2));
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
        if (component < 1 || component > 4) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 60M");
        }
        if (component == 1) {
            //default format (as is)
            return getComponent(1);
        }
        if (component == 2) {
            //date: [YY]YYMMDD
            java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, notNull(locale));
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
     * @deprecated use {@link #typesPattern()} instead.
     */
    @Override
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public String componentsPattern() {
        return "SECN";
    }

    /**
     * Returns the field component types pattern.
     *
     * This method returns a letter representing the type for each component in the Field. It supersedes
     * the Components Pattern because it distinguishes between N (Number) and I (BigDecimal).
     * @since 9.2.7
     */
    @Override
    public String typesPattern() {
        return "SECI";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "[c]<DATE2>SN";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "<DC><DATE2><3!a><AMOUNT>15";
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
        result.add("D/C Mark");
        result.add("Date");
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
        result.put(1, "dCMark");
        result.put(2, "date");
        result.put(3, "currency");
        result.put(4, "amount");
        return result;
    }


    /**
     * Gets the component 1 (D/C Mark).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the D/C Mark (component 1).
     * @return the D/C Mark from component 1
     */
    public String getDCMark() {
        return getComponent1();
    }

    /**
     * Gets the component 2 (Date).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Get the component 2 as Calendar
     *
     * @return the component 2 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent2AsCalendar() {
        return SwiftFormatUtils.getDate2(getComponent(2));
    }

    /**
     * Gets the Date (component 2).
     * @return the Date from component 2
     */
    public String getDate() {
        return getComponent2();
    }

    /**
     * Get the Date (component 2) as Calendar
     * @return the Date from component 2 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getDateAsCalendar() {
        return getComponent2AsCalendar();
    }

    /**
     * Gets the component 3 (Currency).
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
     * Gets the Currency (component 3).
     * @return the Currency from component 3
     */
    public String getCurrency() {
        return getComponent3();
    }

    /**
     * Alternative method getter for field's Currency
     * @see #getCurrency()
     * @since 9.2.7
     */
    public String getUnit() {
        return getCurrency();
    }

    /**
     * Get the Currency (component 3) as Currency
     * @return the Currency from component 3 converted to Currency or null if cannot be converted
     */
    public java.util.Currency getCurrencyAsCurrency() {
        return getComponent3AsCurrency();
    }

    /**
     * Alternative method getter for field's Currency as Currency
     * @see #getCurrencyAsCurrency()
     * @since 9.2.7
     */
    public java.util.Currency getUnitAsCurrency() {
        return getCurrencyAsCurrency();
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
     * Get the Amount (component 4) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent4AsBigDecimal()</code> to get the proper value.
     *
     * @return the component 4 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getAmountAsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getAmountAsNumber() {
        return getComponent4AsNumber();
    }

    /**
     * Set the component 1 (D/C Mark).
     *
     * @param component1 the D/C Mark to set
     * @return the field object to enable build pattern
     */
    public Field60M setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the D/C Mark (component 1).
     *
     * @param component1 the D/C Mark to set
     * @return the field object to enable build pattern
     */
    public Field60M setDCMark(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Date).
     *
     * @param component2 the Date to set
     * @return the field object to enable build pattern
     */
    public Field60M setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Calendar object.
     *
     * @param component2 the Calendar with the Date content to set
     * @return the field object to enable build pattern
     */
    public Field60M setComponent2(java.util.Calendar component2) {
        setComponent(2, SwiftFormatUtils.getDate2(component2));
        return this;
    }

    /**
     * Set the Date (component 2).
     *
     * @param component2 the Date to set
     * @return the field object to enable build pattern
     */
    public Field60M setDate(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Date (component 2) from a Calendar object.
     *
     * @see #setComponent2(java.util.Calendar)
     *
     * @param component2 Calendar with the Date content to set
     * @return the field object to enable build pattern
     */
    public Field60M setDate(java.util.Calendar component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Currency).
     *
     * @param component3 the Currency to set
     * @return the field object to enable build pattern
     */
    public Field60M setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a Currency object.
     *
     * @param component3 the Currency with the Currency content to set
     * @return the field object to enable build pattern
     */
    public Field60M setComponent3(java.util.Currency component3) {
        setComponent(3, SwiftFormatUtils.getCurrency(component3));
        return this;
    }

    /**
     * Set the Currency (component 3).
     *
     * @param component3 the Currency to set
     * @return the field object to enable build pattern
     */
    public Field60M setCurrency(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Currency (component 3) from a Currency object.
     *
     * @see #setComponent3(java.util.Currency)
     *
     * @param component3 Currency with the Currency content to set
     * @return the field object to enable build pattern
     */
    public Field60M setCurrency(java.util.Currency component3) {
        return setComponent3(component3);
    }

    /**
     * Alternative method setter for field's Currency
     *
     * @see #setCurrency(String)
     *
     * @param component3 the Currency to set
     * @return the field object to enable build pattern
     */
    public Field60M setUnit(String component3) {
        return setCurrency(component3);
    }

    /**
     * Alternative method setter for field's Currency from a Currency object.
     *
     * @see #setComponent3(java.util.Currency)
     *
     * @param component3 Currency with the Currency content to set
     * @return the field object to enable build pattern
     */
    public Field60M setUnit(java.util.Currency component3) {
        return setCurrency(component3);
    }

    /**
     * Set the component 4 (Amount).
     *
     * @param component4 the Amount to set
     * @return the field object to enable build pattern
     */
    public Field60M setComponent4(String component4) {
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
     * @param component4 the BigDecimal with the Amount content to set
     * @return the field object to enable build pattern
     */
    public Field60M setComponent4(java.math.BigDecimal component4) {
        setComponent(4, SwiftFormatUtils.getBigDecimal(component4));
        return this;
    }
    /**
     * Alternative method setter for field's Amount (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10.0 becomes an Float)
     *
     * @param component4 the Number with the Amount content to set
     * @return the field object to enable build pattern
     * @see #setAmount(java.math.BigDecimal)
     */
    public Field60M setComponent4(java.lang.Number component4) {

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
    public Field60M setAmount(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the Amount (component 4) from a BigDecimal object.
     *
     * @see #setComponent4(java.math.BigDecimal)
     *
     * @param component4 BigDecimal with the Amount content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field60M setAmount(java.math.BigDecimal component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative method setter for field's Amount (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Amount content to set
     * @return the field object to enable build pattern
     * @see #setAmount(java.math.BigDecimal)
     */
    public Field60M setAmount(java.lang.Number component4) {
        return setComponent4(component4);
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
     * Returns all components that can be converted to a Calendar
     *
     * @return the list of converted components (a Calendar object or null)
     */
    public List<Calendar> dates() {
        return DateResolver.dates(this);
    }

    /**
     * Returns the first component that can be converted to a Calendar
     *
     * @return the converted components (a Calendar object or null)
     */
    public Calendar date() {
        return DateResolver.date(this);
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
     * @return the static value of Field60M.NAME
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
    public static Field60M get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field60M(t);
    }

    /**
     * Gets the first instance of Field60M in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field60M get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field60M in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field60M> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field60M from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field60M> getAll(final SwiftTagListBlock block) {
        final List<Field60M> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add(new Field60M(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field60M object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field60M fromJson(final String json) {

        final Field60M field = new Field60M();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - D/C Mark

        if (jsonObject.get("dCMark") != null) {
            field.setComponent1(jsonObject.get("dCMark").getAsString());
        }

        // **** COMPONENT 2 - Date

        if (jsonObject.get("date") != null) {
            field.setComponent2(jsonObject.get("date").getAsString());
        }

        // **** COMPONENT 3 - Currency

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("unit") != null) {
            field.setComponent3(jsonObject.get("unit").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("currency") != null) {
            field.setComponent3(jsonObject.get("currency").getAsString());
        }

        // **** COMPONENT 4 - Amount

        if (jsonObject.get("amount") != null) {
            field.setComponent4(jsonObject.get("amount").getAsString());
        }

        return field;
    }


}
