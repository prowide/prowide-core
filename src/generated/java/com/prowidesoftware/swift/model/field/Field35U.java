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

import com.prowidesoftware.swift.model.field.AmountContainer;
import com.prowidesoftware.swift.model.field.AmountResolver;

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 35U</strong>
 * <p>
 * Model and parser for field 35U of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>BigDecimal</code></li>
 * 		<li><code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>3!a&lt;AMOUNT&gt;15[1a]</code></li>
 * 		<li>parser pattern: <code>SN[S]</code></li>
 * 		<li>components pattern: <code>SNS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field35U extends Field implements Serializable, AmountContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 35U
	 */
    public static final String NAME = "35U";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_35U = "35U";
	public static final String PARSER_PATTERN = "SN[S]";

    /**
     * Components pattern
     *
     * Contains a description of the type for every component. This is <em>DEPRECATED</em>,
     * use TYPES_PATTERN instead, because it distinguishes between N (number) and I (BigDecimal)
     * @see #TYPES_PATTERN
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "SNS";

    /**
     * Types pattern
     *
     * Contains a description of the type for every component, use instead of COMPONENTS_PATTERN.
     * @since 9.2.7
     */
	public static final String TYPES_PATTERN = "SIS";

	/**
	 * Component number for the Currency subfield
	 */
	public static final Integer CURRENCY = 1;

	/**
	 * Component number for the Amount subfield
	 */
	public static final Integer AMOUNT = 2;

	/**
	 * Component number for the Period subfield
	 */
	public static final Integer PERIOD = 3;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field35U() {
        super(3);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field35U(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field35U(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "35U")) {
            throw new IllegalArgumentException("cannot create field 35U from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.<br>
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field35U newInstance(Field35U source) {
        Field35U cp = new Field35U();
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
        init(3);
        setComponent1(SwiftParseUtils.getAlphaPrefix(value));
        String toparse = getComponent1() == null? value : StringUtils.substringAfter(value, getComponent1());
        setComponent2(SwiftParseUtils.getNumericPrefix(toparse));
        setComponent3(SwiftParseUtils.getAlphaSuffix(toparse));
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        append(result, 1);
        append(result, 2);
        append(result, 3);
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 35U");
        }
        if (component == 1) {
            //default format (as is)
            return getComponent(1);
        }
        if (component == 2) {
            //number, amount, rate
            java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
            f.setMaximumFractionDigits(13);
            BigDecimal n = getComponent2AsBigDecimal();
            if (n != null) {
                return f.format(n);
            }
        }
        if (component == 3) {
            //default format (as is)
            return getComponent(3);
        }
        return null;
    }

    /**
     * Returns the field components pattern
     *
     * This method is <em>DEPRECATED</em>, use <code>typesPattern()</code> instead.
     * @see #typesPattern()
     * @return the static value of Field35U.COMPONENTS_PATTERN
     */
    @Override
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
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
     * @return the static value of Field35U.TYPES_PATTERN
     */
    @Override
    public final String typesPattern() {
        return TYPES_PATTERN;
    }

    /**
     * Returns the field parser pattern
     * @return the static value of Field35U.PARSER_PATTERN
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
        return "3!a<AMOUNT>15[1a]";
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
        if (component == 3) {
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
    protected List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Currency");
        result.add("Amount");
        result.add("Period");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "currency");
        result.put(2, "amount");
        result.put(3, "period");
        return result;
    }


    /**
     * Gets the component 1 (Currency).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Currency (component 1).
     * @return the Currency from component 1
     */
    public String getCurrency() {
        return getComponent1();
    }

    /**
     * Gets the component 2 (Amount).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Get the component 2 as BigDecimal
     *
     * @return the component 2 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getComponent2AsBigDecimal() {
        return SwiftFormatUtils.getBigDecimal(getComponent(2));
    }

    /**
     * Get the component 2 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent2AsBigDecimal()</code> to get the proper value.
     *
     * @return the component 2 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent2AsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getComponent2AsNumber() {
        return getComponent2AsBigDecimal();
    }

    /**
     * Gets the Amount (component 2).
     * @return the Amount from component 2
     */
    public String getAmount() {
        return getComponent2();
    }

    /**
     * Get the Amount (component 2) as BigDecimal
     * @return the Amount from component 2 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getAmountAsBigDecimal() {
        return getComponent2AsBigDecimal();
    }

    /**
     * Get the Amount (component 2) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent2AsBigDecimal()</code> to get the proper value.
     *
     * @return the component 2 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getAmountAsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getAmountAsNumber() {
        return getComponent2AsNumber();
    }

    /**
     * Gets the component 3 (Period).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Period (component 3).
     * @return the Period from component 3
     */
    public String getPeriod() {
        return getComponent3();
    }

    /**
     * Set the component 1 (Currency).
     *
     * @param component1 the Currency to set
     * @return the field object to enable build pattern
     */
    public Field35U setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Currency (component 1).
     *
     * @param component1 the Currency to set
     * @return the field object to enable build pattern
     */
    public Field35U setCurrency(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Amount).
     *
     * @param component2 the Amount to set
     * @return the field object to enable build pattern
     */
    public Field35U setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a BigDecimal object.
     * <br>
     * Parses the BigDecimal into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
     * <ul>
     *     <li>Example: 1234.00 -&gt; 1234,</li>
     *     <li>Example: 1234 -&gt; 1234,</li>
     *     <li>Example: 1234.56 -&gt; 1234,56</li>
     * </ul>
     * @since 9.2.7
     *
     * @param component2 the BigDecimal with the Amount content to set
     * @return the field object to enable build pattern
     */
    public Field35U setComponent2(java.math.BigDecimal component2) {
        setComponent(2, SwiftFormatUtils.getBigDecimal(component2));
        return this;
    }
    /**
     * Alternative method setter for field's Amount (component 2) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10.0 becomes an Float)
     *
     * @param component2 the Number with the Amount content to set
     * @return the field object to enable build pattern
     * @see #setAmount(java.math.BigDecimal)
     */
    public Field35U setComponent2(java.lang.Number component2) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component2 instanceof BigDecimal) {
            setComponent(2, SwiftFormatUtils.getBigDecimal( (BigDecimal) component2));
        } else if (component2 instanceof BigInteger) {
            setComponent(2, SwiftFormatUtils.getBigDecimal(new BigDecimal( (BigInteger) component2)));
        } else if (component2 instanceof Long || component2 instanceof Integer) {
            setComponent(2, SwiftFormatUtils.getBigDecimal(new BigDecimal(component2.longValue())));
        } else if (component2 instanceof Float || component2 instanceof Double) {
            // it's non null
            setComponent(2, SwiftFormatUtils.getBigDecimal(new BigDecimal(component2.doubleValue())));
        } else {
            // so it's a Number that failed instanceof => it's null
            setComponent(2, null);
        }
        return this;
    }

    /**
     * Set the Amount (component 2).
     *
     * @param component2 the Amount to set
     * @return the field object to enable build pattern
     */
    public Field35U setAmount(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Amount (component 2) from a BigDecimal object.
     *
     * @see #setComponent2(java.math.BigDecimal)
     *
     * @param component2 BigDecimal with the Amount content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field35U setAmount(java.math.BigDecimal component2) {
        return setComponent2(component2);
    }

    /**
     * Alternative method setter for field's Amount (component 2) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the Amount content to set
     * @return the field object to enable build pattern
     * @see #setAmount(java.math.BigDecimal)
     */
    public Field35U setAmount(java.lang.Number component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Period).
     *
     * @param component3 the Period to set
     * @return the field object to enable build pattern
     */
    public Field35U setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Period (component 3).
     *
     * @param component3 the Period to set
     * @return the field object to enable build pattern
     */
    public Field35U setPeriod(String component3) {
        return setComponent3(component3);
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
     * Returns the field's name composed by the field number and the letter option (if any)
     * @return the static value of Field35U.NAME
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
    public static Field35U get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field35U(t) ;
    }

    /**
     * Gets the first instance of Field35U in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field35U get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return null;
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field35U in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field35U> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return java.util.Collections.emptyList();
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field35U from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field35U> getAll(final SwiftTagListBlock block) {
        final List<Field35U> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add( new Field35U(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field35U object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field35U fromJson(final String json) {

        Field35U field = new Field35U();

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(json);

        // **** COMPONENT 1 - Currency

        if (jsonObject.get("currency") != null) {
            field.setComponent1(jsonObject.get("currency").getAsString());
        }

        // **** COMPONENT 2 - Amount

        if (jsonObject.get("amount") != null) {
            field.setComponent2(jsonObject.get("amount").getAsString());
        }

        // **** COMPONENT 3 - Period

        if (jsonObject.get("period") != null) {
            field.setComponent3(jsonObject.get("period").getAsString());
        }

        return field;
    }


}
