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

import java.util.Currency;

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
 * SWIFT MT Field 32Q.
 * <p>
 * Model and parser for field 32Q of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>Currency</code></li>
 * 		<li><code>Currency</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;CUR&gt;/&lt;CUR&gt;</code></li>
 * 		<li>parser pattern: <code>S/S</code></li>
 * 		<li>components pattern: <code>CC</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field32Q extends Field implements Serializable, CurrencyContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 32Q.
	 */
    public static final String NAME = "32Q";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_32Q = "32Q";
	public static final String PARSER_PATTERN = "S/S";

    /**
     * Components pattern.
     *
     * Contains a description of the type for every component. This is <em>DEPRECATED</em>,
     * use TYPES_PATTERN instead, because it distinguishes between N (number) and I (BigDecimal)
     * @see #TYPES_PATTERN
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "CC";

    /**
     * Types pattern.
     *
     * Contains a description of the type for every component, use instead of COMPONENTS_PATTERN.
     * @since 9.2.7
     */
	public static final String TYPES_PATTERN = "CC";

	/**
	 * Component number for the Currency 1 subfield.
	 */
	public static final Integer CURRENCY_1 = 1;

	/**
	 * Component number for the Currency 2 subfield.
	 */
	public static final Integer CURRENCY_2 = 2;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field32Q() {
        super(2);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field32Q(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field32Q(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "32Q")) {
            throw new IllegalArgumentException("cannot create field 32Q from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field32Q newInstance(Field32Q source) {
        Field32Q cp = new Field32Q();
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
        init(2);
        setComponent1(SwiftParseUtils.getTokenFirst(value, "/"));
        setComponent2(SwiftParseUtils.getTokenSecondLast(value, "/"));
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
        if (component < 1 || component > 2) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 32Q");
        }
        if (component == 1) {
            //default format (as is)
            return getComponent(1);
        }
        if (component == 2) {
            //default format (as is)
            return getComponent(2);
        }
        return null;
    }

    /**
     * Returns the field components pattern
     *
     * This method is <em>DEPRECATED</em>, use <code>typesPattern()</code> instead.
     * @see #typesPattern()
     * @return the static value of Field32Q.COMPONENTS_PATTERN
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
     * @return the static value of Field32Q.TYPES_PATTERN
     */
    @Override
    public final String typesPattern() {
        return TYPES_PATTERN;
    }

    /**
     * Returns the field parser pattern
     * @return the static value of Field32Q.PARSER_PATTERN
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
        return "<CUR>/<CUR>";
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
        return 2;
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
        result.add("Currency 1");
        result.add("Currency 2");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "currency1");
        result.put(2, "currency2");
        return result;
    }


    /**
     * Gets the component 1 (Currency 1).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Get the component 1 as Currency
     *
     * @return the component 1 converted to Currency or null if cannot be converted
     */
    public java.util.Currency getComponent1AsCurrency() {
        return SwiftFormatUtils.getCurrency(getComponent(1));
    }

    /**
     * Gets the Currency 1 (component 1).
     * @return the Currency 1 from component 1
     */
    public String getCurrency1() {
        return getComponent1();
    }

    /**
     * Get the Currency 1 (component 1) as Currency
     * @return the Currency 1 from component 1 converted to Currency or null if cannot be converted
     */
    public java.util.Currency getCurrency1AsCurrency() {
        return getComponent1AsCurrency();
    }

    /**
     * Gets the component 2 (Currency 2).
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
     * Gets the Currency 2 (component 2).
     * @return the Currency 2 from component 2
     */
    public String getCurrency2() {
        return getComponent2();
    }

    /**
     * Get the Currency 2 (component 2) as Currency
     * @return the Currency 2 from component 2 converted to Currency or null if cannot be converted
     */
    public java.util.Currency getCurrency2AsCurrency() {
        return getComponent2AsCurrency();
    }

    /**
     * Set the component 1 (Currency 1).
     *
     * @param component1 the Currency 1 to set
     * @return the field object to enable build pattern
     */
    public Field32Q setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the component1 from a Currency object.
     *
     * @param component1 the Currency with the Currency 1 content to set
     * @return the field object to enable build pattern
     */
    public Field32Q setComponent1(java.util.Currency component1) {
        setComponent(1, SwiftFormatUtils.getCurrency(component1));
        return this;
    }

    /**
     * Set the Currency 1 (component 1).
     *
     * @param component1 the Currency 1 to set
     * @return the field object to enable build pattern
     */
    public Field32Q setCurrency1(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the Currency 1 (component 1) from a Currency object.
     *
     * @see #setComponent1(java.util.Currency)
     *
     * @param component1 Currency with the Currency 1 content to set
     * @return the field object to enable build pattern
     */
    public Field32Q setCurrency1(java.util.Currency component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Currency 2).
     *
     * @param component2 the Currency 2 to set
     * @return the field object to enable build pattern
     */
    public Field32Q setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Currency object.
     *
     * @param component2 the Currency with the Currency 2 content to set
     * @return the field object to enable build pattern
     */
    public Field32Q setComponent2(java.util.Currency component2) {
        setComponent(2, SwiftFormatUtils.getCurrency(component2));
        return this;
    }

    /**
     * Set the Currency 2 (component 2).
     *
     * @param component2 the Currency 2 to set
     * @return the field object to enable build pattern
     */
    public Field32Q setCurrency2(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Currency 2 (component 2) from a Currency object.
     *
     * @see #setComponent2(java.util.Currency)
     *
     * @param component2 Currency with the Currency 2 content to set
     * @return the field object to enable build pattern
     */
    public Field32Q setCurrency2(java.util.Currency component2) {
        return setComponent2(component2);
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
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field32Q.NAME
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
    public static Field32Q get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field32Q(t);
    }

    /**
     * Gets the first instance of Field32Q in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field32Q get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field32Q in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field32Q> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field32Q from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field32Q> getAll(final SwiftTagListBlock block) {
        final List<Field32Q> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add(new Field32Q(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field32Q object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field32Q fromJson(final String json) {

        final Field32Q field = new Field32Q();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Currency 1

        if (jsonObject.get("currency1") != null) {
            field.setComponent1(jsonObject.get("currency1").getAsString());
        }

        // **** COMPONENT 2 - Currency 2

        if (jsonObject.get("currency2") != null) {
            field.setComponent2(jsonObject.get("currency2").getAsString());
        }

        return field;
    }


}
