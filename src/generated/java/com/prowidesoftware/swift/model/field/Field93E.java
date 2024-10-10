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

import com.prowidesoftware.swift.model.field.GenericField;
import com.prowidesoftware.swift.model.field.AmountContainer;
import com.prowidesoftware.swift.model.field.AmountResolver;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 93E.
 * <p>
 * Model and parser for field 93E of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Qualifier: <code>String</code></li>
 * 		<li>Component 2: QuantityTypeCode: <code>String</code></li>
 * 		<li>Component 3: BalanceTypeCode: <code>String</code></li>
 * 		<li>Component 4: Sign: <code>String</code></li>
 * 		<li>Component 5: BalanceofDigitalTokens: <code>BigDecimal</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>:4!c//4!c/4!c/[&lt;N&gt;]&lt;AMOUNT&gt;30</code></li>
 * 		<li>parser pattern: <code>:S//S/S/[S]N</code></li>
 * 		<li>components pattern: <code>SSSSN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field93E extends Field implements Serializable, AmountContainer, GenericField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 93E.
	 */
    public static final String NAME = "93E";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_93E = "93E";

	/**
	 * Component number for the Qualifier subfield.
	 */
	public static final Integer QUALIFIER = 1;

	/**
	 * Component number for the Quantity Type Code subfield.
	 */
	public static final Integer QUANTITY_TYPE_CODE = 2;

	/**
	 * Component number for the Balance Type Code subfield.
	 */
	public static final Integer BALANCE_TYPE_CODE = 3;

	/**
	 * Component number for the Sign subfield.
	 */
	public static final Integer SIGN = 4;

	/**
	 * Component number for the Balance of Digital Tokens subfield.
	 */
	public static final Integer BALANCE_OF_DIGITAL_TOKENS = 5;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field93E() {
        super(5);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field93E(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field93E(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "93E")) {
            throw new IllegalArgumentException("cannot create field 93E from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field93E newInstance(Field93E source) {
        Field93E cp = new Field93E();
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
        setComponent1(SwiftParseUtils.getTokenFirst(value, ":", "//"));
        String toparse = SwiftParseUtils.getTokenSecondLast(value, "//"); /* S/S/[c]N */
        setComponent2(SwiftParseUtils.getTokenFirst(toparse, "/"));
        setComponent3(SwiftParseUtils.getTokenSecond(toparse, "/"));
        String toparse2 = SwiftParseUtils.getTokenThirdLast(toparse, "/"); /* [c]N */
        setComponent4(SwiftParseUtils.getAlphaPrefixTrimSlash(toparse2));
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
        result.append("//");
        append(result, 2);
        result.append("/");
        append(result, 3);
        result.append("/");
        append(result, 4);
        append(result, 5);
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 93E");
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
        return "SSSSI";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return ":S//S/S/[S]N";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return ":4!c//4!c/4!c/[<N>]<AMOUNT>30";
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
        result.add("Qualifier");
        result.add("Quantity Type Code");
        result.add("Balance Type Code");
        result.add("Sign");
        result.add("Balance of Digital Tokens");
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
        result.put(2, "quantityTypeCode");
        result.put(3, "balanceTypeCode");
        result.put(4, "sign");
        result.put(5, "balanceofDigitalTokens");
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
        super.labelMap.put("quantitytypecode", 2);
        super.labelMap.put("balancetypecode", 3);
        super.labelMap.put("sign", 4);
        super.labelMap.put("balanceofdigitaltokens", 5);
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
     * Gets the component 2 (Quantity Type Code).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Quantity Type Code (component 2).
     * @return the Quantity Type Code from component 2
     */
    public String getQuantityTypeCode() {
        return getComponent2();
    }

    /**
     * Gets the component 3 (Balance Type Code).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Balance Type Code (component 3).
     * @return the Balance Type Code from component 3
     */
    public String getBalanceTypeCode() {
        return getComponent3();
    }

    /**
     * Gets the component 4 (Sign).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the Sign (component 4).
     * @return the Sign from component 4
     */
    public String getSign() {
        return getComponent4();
    }

    /**
     * Gets the component 5 (Balance of Digital Tokens).
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
     * Gets the Balance of Digital Tokens (component 5).
     * @return the Balance of Digital Tokens from component 5
     */
    public String getBalanceofDigitalTokens() {
        return getComponent5();
    }

    /**
     * Get the Balance of Digital Tokens (component 5) as BigDecimal
     * @return the Balance of Digital Tokens from component 5 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getBalanceofDigitalTokensAsBigDecimal() {
        return getComponent5AsBigDecimal();
    }

    /**
     * Set the component 1 (Qualifier).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field93E setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Qualifier (component 1).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field93E setQualifier(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Quantity Type Code).
     *
     * @param component2 the Quantity Type Code to set
     * @return the field object to enable build pattern
     */
    public Field93E setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Quantity Type Code (component 2).
     *
     * @param component2 the Quantity Type Code to set
     * @return the field object to enable build pattern
     */
    public Field93E setQuantityTypeCode(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Balance Type Code).
     *
     * @param component3 the Balance Type Code to set
     * @return the field object to enable build pattern
     */
    public Field93E setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Balance Type Code (component 3).
     *
     * @param component3 the Balance Type Code to set
     * @return the field object to enable build pattern
     */
    public Field93E setBalanceTypeCode(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Sign).
     *
     * @param component4 the Sign to set
     * @return the field object to enable build pattern
     */
    public Field93E setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the Sign (component 4).
     *
     * @param component4 the Sign to set
     * @return the field object to enable build pattern
     */
    public Field93E setSign(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Balance of Digital Tokens).
     *
     * @param component5 the Balance of Digital Tokens to set
     * @return the field object to enable build pattern
     */
    public Field93E setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Alternative method setter for field's Balance of Digital Tokens (component 5) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10.0 becomes an Float)
     *
     * @param component5 the Number with the Balance of Digital Tokens content to set
     * @return the field object to enable build pattern
     */
    public Field93E setComponent5(java.lang.Number component5) {

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
     * Set the Balance of Digital Tokens (component 5).
     *
     * @param component5 the Balance of Digital Tokens to set
     * @return the field object to enable build pattern
     */
    public Field93E setBalanceofDigitalTokens(String component5) {
        return setComponent5(component5);
    }

    /**
     * Alternative method setter for field's Balance of Digital Tokens (component 5) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component5 the Number with the Balance of Digital Tokens content to set
     * @return the field object to enable build pattern
     */
    public Field93E setBalanceofDigitalTokens(java.lang.Number component5) {
        return setComponent5(component5);
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
    @Override
    public BigDecimal amount() {
        return AmountResolver.amount(this);
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
     * @return the static value of Field93E.NAME
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
    public static Field93E get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field93E(t);
    }

    /**
     * Gets the first instance of Field93E in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field93E get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field93E in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field93E> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field93E from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field93E> getAll(final SwiftTagListBlock block) {
        final List<Field93E> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field93E(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field93E object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field93E fromJson(final String json) {

        final Field93E field = new Field93E();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Qualifier

        if (jsonObject.get("qualifier") != null) {
            field.setComponent1(jsonObject.get("qualifier").getAsString());
        }

        // **** COMPONENT 2 - Quantity Type Code

        if (jsonObject.get("quantityTypeCode") != null) {
            field.setComponent2(jsonObject.get("quantityTypeCode").getAsString());
        }

        // **** COMPONENT 3 - Balance Type Code

        if (jsonObject.get("balanceTypeCode") != null) {
            field.setComponent3(jsonObject.get("balanceTypeCode").getAsString());
        }

        // **** COMPONENT 4 - Sign

        if (jsonObject.get("sign") != null) {
            field.setComponent4(jsonObject.get("sign").getAsString());
        }

        // **** COMPONENT 5 - Balance of Digital Tokens

        if (jsonObject.get("balanceofDigitalTokens") != null) {
            field.setComponent5(jsonObject.get("balanceofDigitalTokens").getAsString());
        }

        return field;
    }


}
