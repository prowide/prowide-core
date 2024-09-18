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

import java.util.Currency;

import com.prowidesoftware.swift.model.field.CurrencyContainer;
import com.prowidesoftware.swift.model.field.CurrencyResolver;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 23.
 * <p>
 * Model and parser for field 23 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Code1: <code>String</code></li>
 * 		<li>Component 2: Code2: <code>String</code></li>
 * 		<li>Component 3: Code3: <code>String</code></li>
 * 		<li>Component 4: Currency: <code>Currency</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>CUSTOM</code></li>
 * 		<li>parser pattern: <code>S[/S/S[/S]]</code></li>
 * 		<li>components pattern: <code>SSSC</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field23 extends Field implements Serializable, CurrencyContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 23.
	 */
    public static final String NAME = "23";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_23 = "23";

	/**
	 * Component number for the Code 1 subfield.
	 */
	public static final Integer CODE_1 = 1;

	/**
     * Alternative constant name for field's Code 1 Component number.
     * @see #CODE_1
     */
    public static final Integer BUY_SELL_INDICATOR = 1;

	/**
	 * Component number for the Code 2 subfield.
	 */
	public static final Integer CODE_2 = 2;

	/**
     * Alternative constant name for field's Code 2 Component number.
     * @see #CODE_2
     */
    public static final Integer CALL_PUT_INDICATOR = 2;

	/**
	 * Component number for the Code 3 subfield.
	 */
	public static final Integer CODE_3 = 3;

	/**
     * Alternative constant name for field's Code 3 Component number.
     * @see #CODE_3
     */
    public static final Integer STYLE_INDICATOR = 3;

	/**
	 * Component number for the Currency subfield.
	 */
	public static final Integer CURRENCY = 4;

	/**
     * Alternative constant name for field's Currency Component number.
     * @see #CURRENCY
     */
    public static final Integer MANUAL_AUTOMATIC_INDICATOR = 4;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field23() {
        super(4);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field23(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field23(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "23")) {
            throw new IllegalArgumentException("cannot create field 23 from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field23 newInstance(Field23 source) {
        Field23 cp = new Field23();
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
        setComponent1(SwiftParseUtils.getTokenFirst(value, null, "/"));
        String toparse = SwiftParseUtils.getTokenSecondLast(value, "/");
        if (StringUtils.isNotBlank(toparse)) {
            setComponent2(SwiftParseUtils.getTokenFirst(toparse, null, "/"));
            String toparse2 = SwiftParseUtils.getTokenSecondLast(toparse, "/");
            if (StringUtils.isNotBlank(toparse2)) {
                setComponent3(SwiftParseUtils.getTokenFirst(toparse2, null, "/"));
                setComponent4(SwiftParseUtils.getTokenSecondLast(toparse2, "/"));
            }
        }
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        append(result, 1);
        if (getComponent2() != null || getComponent3() != null || getComponent4() != null) {
            result.append("/");
            if (getComponent2() != null) {
                result.append(getComponent2());
            }
            result.append("/");
            if (getComponent3() != null) {
                result.append(getComponent3());
            }
            if (getComponent4() != null) {
                result.append("/").append(getComponent4());
            }
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
        if (component < 1 || component > 4) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 23");
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
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(4);
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
        return "SSSC";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "S[/S/S[/S]]";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "CUSTOM";
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
        if (component == 3) {
            return true;
        }
        if (component == 4) {
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
        result.add("Code 1");
        result.add("Code 2");
        result.add("Code 3");
        result.add("Currency");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "code1");
        result.put(2, "code2");
        result.put(3, "code3");
        result.put(4, "currency");
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
        super.labelMap.put("code1", 1);
        // alias name
        super.labelMap.put("buysellindicator", 1);
        super.labelMap.put("code2", 2);
        // alias name
        super.labelMap.put("callputindicator", 2);
        super.labelMap.put("code3", 3);
        // alias name
        super.labelMap.put("styleindicator", 3);
        super.labelMap.put("currency", 4);
        // alias name
        super.labelMap.put("manualautomaticindicator", 4);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Code 1).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Code 1 (component 1).
     * @return the Code 1 from component 1
     */
    public String getCode1() {
        return getComponent1();
    }

    /**
     * Alternative method getter for field's Code 1
     * @since 9.2.7
     */
    public String getBuySellIndicator() {
        return getCode1();
    }

    /**
     * Gets the component 2 (Code 2).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Code 2 (component 2).
     * @return the Code 2 from component 2
     */
    public String getCode2() {
        return getComponent2();
    }

    /**
     * Alternative method getter for field's Code 2
     * @since 9.2.7
     */
    public String getCallPutIndicator() {
        return getCode2();
    }

    /**
     * Gets the component 3 (Code 3).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Code 3 (component 3).
     * @return the Code 3 from component 3
     */
    public String getCode3() {
        return getComponent3();
    }

    /**
     * Alternative method getter for field's Code 3
     * @since 9.2.7
     */
    public String getStyleIndicator() {
        return getCode3();
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
     * Alternative method getter for field's Currency
     * @since 9.2.7
     */
    public String getManualAutomaticIndicator() {
        return getCurrency();
    }

    /**
     * Get the Currency (component 4) as Currency
     * @return the Currency from component 4 converted to Currency or null if cannot be converted
     */
    public java.util.Currency getCurrencyAsCurrency() {
        return getComponent4AsCurrency();
    }

    /**
     * @since 9.2.7
     */
    public java.util.Currency getManualAutomaticIndicatorAsCurrency() {
        return getCurrencyAsCurrency();
    }

    /**
     * Set the component 1 (Code 1).
     *
     * @param component1 the Code 1 to set
     * @return the field object to enable build pattern
     */
    public Field23 setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Code 1 (component 1).
     *
     * @param component1 the Code 1 to set
     * @return the field object to enable build pattern
     */
    public Field23 setCode1(String component1) {
        return setComponent1(component1);
    }

    public Field23 setBuySellIndicator(String component1) {
        return setCode1(component1);
    }

    /**
     * Set the component 2 (Code 2).
     *
     * @param component2 the Code 2 to set
     * @return the field object to enable build pattern
     */
    public Field23 setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Code 2 (component 2).
     *
     * @param component2 the Code 2 to set
     * @return the field object to enable build pattern
     */
    public Field23 setCode2(String component2) {
        return setComponent2(component2);
    }

    public Field23 setCallPutIndicator(String component2) {
        return setCode2(component2);
    }

    /**
     * Set the component 3 (Code 3).
     *
     * @param component3 the Code 3 to set
     * @return the field object to enable build pattern
     */
    public Field23 setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Code 3 (component 3).
     *
     * @param component3 the Code 3 to set
     * @return the field object to enable build pattern
     */
    public Field23 setCode3(String component3) {
        return setComponent3(component3);
    }

    public Field23 setStyleIndicator(String component3) {
        return setCode3(component3);
    }

    /**
     * Set the component 4 (Currency).
     *
     * @param component4 the Currency to set
     * @return the field object to enable build pattern
     */
    public Field23 setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component4 from a Currency object.
     *
     * @param component4 the Currency with the Currency content to set
     * @return the field object to enable build pattern
     */
    public Field23 setComponent4(java.util.Currency component4) {
        setComponent(4, SwiftFormatUtils.getCurrency(component4));
        return this;
    }

    /**
     * Set the Currency (component 4).
     *
     * @param component4 the Currency to set
     * @return the field object to enable build pattern
     */
    public Field23 setCurrency(String component4) {
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
    public Field23 setCurrency(java.util.Currency component4) {
        return setComponent4(component4);
    }

    public Field23 setManualAutomaticIndicator(String component4) {
        return setCurrency(component4);
    }

    public Field23 setManualAutomaticIndicator(java.util.Currency component4) {
        return setCurrency(component4);
    }


    @Override
    public List<String> currencyStrings() {
        return CurrencyResolver.currencyStrings(this);
    }

    @Override
    public List<Currency> currencies() {
        return CurrencyResolver.currencies(this);
    }

    @Override
    public Currency currency() {
        return CurrencyResolver.resolveCurrency(this);
    }

    @Override
    public String currencyString() {
        return CurrencyResolver.resolveCurrencyString(this);
    }

    @Override
    public void initializeCurrencies(String cur) {
        CurrencyResolver.resolveSetCurrency(this, cur);
    }

    @Override
    public void initializeCurrencies(Currency cur) {
        CurrencyResolver.resolveSetCurrency(this, cur);
    }


    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field23.NAME
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
    public static Field23 get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field23(t);
    }

    /**
     * Gets the first instance of Field23 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field23 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field23 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field23> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field23 from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field23> getAll(final SwiftTagListBlock block) {
        final List<Field23> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field23(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field23 object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field23 fromJson(final String json) {

        final Field23 field = new Field23();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Code 1

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("buySellIndicator") != null) {
            field.setComponent1(jsonObject.get("buySellIndicator").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("code1") != null) {
            field.setComponent1(jsonObject.get("code1").getAsString());
        }

        // **** COMPONENT 2 - Code 2

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("callPutIndicator") != null) {
            field.setComponent2(jsonObject.get("callPutIndicator").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("code2") != null) {
            field.setComponent2(jsonObject.get("code2").getAsString());
        }

        // **** COMPONENT 3 - Code 3

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("styleIndicator") != null) {
            field.setComponent3(jsonObject.get("styleIndicator").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("code3") != null) {
            field.setComponent3(jsonObject.get("code3").getAsString());
        }

        // **** COMPONENT 4 - Currency

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("manualAutomaticIndicator") != null) {
            field.setComponent4(jsonObject.get("manualAutomaticIndicator").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("currency") != null) {
            field.setComponent4(jsonObject.get("currency").getAsString());
        }

        return field;
    }


}
