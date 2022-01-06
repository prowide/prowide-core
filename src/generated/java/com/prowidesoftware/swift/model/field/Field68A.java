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
 * SWIFT MT Field 68A.
 * <p>
 * Model and parser for field 68A of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>Long</code></li>
 * 		<li><code>Currency</code></li>
 * 		<li><code>Long</code></li>
 * 		<li><code>Long</code></li>
 * 		<li><code>BigDecimal</code></li>
 * 		<li><code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>6n&lt;CUR&gt;6n/2n[/&lt;AMOUNT&gt;15][//10x]</code></li>
 * 		<li>parser pattern: <code>NSN/N[/N][//S]</code></li>
 * 		<li>components pattern: <code>NCNNNS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field68A extends Field implements Serializable, CurrencyContainer, AmountContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 68A.
	 */
    public static final String NAME = "68A";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_68A = "68A";
	public static final String PARSER_PATTERN = "NSN/N[/N][//S]";

    /**
     * Components pattern.
     *
     * Contains a description of the type for every component. This is <em>DEPRECATED</em>,
     * use TYPES_PATTERN instead, because it distinguishes between N (number) and I (BigDecimal)
     * @see #TYPES_PATTERN
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "NCNNNS";

    /**
     * Types pattern.
     *
     * Contains a description of the type for every component, use instead of COMPONENTS_PATTERN.
     * @since 9.2.7
     */
	public static final String TYPES_PATTERN = "NCNNIS";

	/**
	 * Component number for the Number subfield.
	 */
	public static final Integer NUMBER = 1;

	/**
	 * Component number for the Currency subfield.
	 */
	public static final Integer CURRENCY = 2;

	/**
	 * Component number for the Denomination subfield.
	 */
	public static final Integer DENOMINATION = 3;

	/**
	 * Component number for the Mode subfield.
	 */
	public static final Integer MODE = 4;

	/**
	 * Component number for the Amount subfield.
	 */
	public static final Integer AMOUNT = 5;

	/**
	 * Component number for the Product Code subfield.
	 */
	public static final Integer PRODUCT_CODE = 6;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field68A() {
        super(6);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field68A(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field68A(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "68A")) {
            throw new IllegalArgumentException("cannot create field 68A from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field68A newInstance(Field68A source) {
        Field68A cp = new Field68A();
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
        String toparse = SwiftParseUtils.getTokenFirst(value, "/");
        setComponent1(SwiftParseUtils.getNumericPrefix(toparse));
        String toparse2 = SwiftParseUtils.getAlphaSuffix(toparse);
        setComponent2(SwiftParseUtils.getAlphaPrefixTrimSlash(toparse2));
        setComponent3(SwiftParseUtils.getNumericSuffix(toparse2));
        setComponent4(SwiftParseUtils.getTokenSecond(value, "/"));
        toparse = SwiftParseUtils.getTokenThirdLast(value, "/");
        setComponent5(SwiftParseUtils.getTokenFirst(toparse, "//"));
        setComponent6(SwiftParseUtils.getTokenSecondLast(toparse, "//"));
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
        result.append("/");
        append(result, 4);
        if (getComponent5() != null) {
            result.append("/").append(getComponent5());
        }
        if (getComponent6() != null) {
            result.append("//").append(getComponent6());
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
        if (component < 1 || component > 6) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 68A");
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
        if (component == 5) {
            //amount, rate
            java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
            f.setMaximumFractionDigits(13);
            BigDecimal n = getComponent5AsBigDecimal();
            if (n != null) {
                return f.format(n);
            }
        }
        if (component == 6) {
            //default format (as is)
            return getComponent(6);
        }
        return null;
    }

    /**
     * Returns the field components pattern
     *
     * This method is <em>DEPRECATED</em>, use <code>typesPattern()</code> instead.
     * @see #typesPattern()
     * @return the static value of Field68A.COMPONENTS_PATTERN
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
     * @return the static value of Field68A.TYPES_PATTERN
     */
    @Override
    public final String typesPattern() {
        return TYPES_PATTERN;
    }

    /**
     * Returns the field parser pattern
     * @return the static value of Field68A.PARSER_PATTERN
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
        return "6n<CUR>6n/2n[/<AMOUNT>15][//10x]";
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
        if (component == 5) {
            return true;
        }
        if (component == 6) {
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
        result.add("Number");
        result.add("Currency");
        result.add("Denomination");
        result.add("Mode");
        result.add("Amount");
        result.add("Product Code");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "number");
        result.put(2, "currency");
        result.put(3, "denomination");
        result.put(4, "mode");
        result.put(5, "amount");
        result.put(6, "productCode");
        return result;
    }


    /**
     * Gets the component 1 (Number).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Get the component 1 as Long
     *
     * @return the component 1 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent1AsLong() {
        return SwiftFormatUtils.getLong(getComponent(1));
    }

    /**
     * Get the component 1 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent1AsLong()</code> to get the proper value.
     *
     * @return the component 1 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent1AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getComponent1AsNumber() {
        Long l = getComponent1AsLong();
        return l != null ? new BigDecimal(l) : null;
    }

    /**
     * Gets the Number (component 1).
     * @return the Number from component 1
     */
    public String getNumber() {
        return getComponent1();
    }

    /**
     * Get the Number (component 1) as Long
     * @return the Number from component 1 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getNumberAsLong() {
        return getComponent1AsLong();
    }

    /**
     * Get the Number (component 1) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent1AsLong()</code> to get the proper value.
     *
     * @return the component 1 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getNumberAsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getNumberAsNumber() {
        return getComponent1AsNumber();
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
     * Gets the component 3 (Denomination).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Get the component 3 as Long
     *
     * @return the component 3 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent3AsLong() {
        return SwiftFormatUtils.getLong(getComponent(3));
    }

    /**
     * Get the component 3 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent3AsLong()</code> to get the proper value.
     *
     * @return the component 3 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent3AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getComponent3AsNumber() {
        Long l = getComponent3AsLong();
        return l != null ? new BigDecimal(l) : null;
    }

    /**
     * Gets the Denomination (component 3).
     * @return the Denomination from component 3
     */
    public String getDenomination() {
        return getComponent3();
    }

    /**
     * Get the Denomination (component 3) as Long
     * @return the Denomination from component 3 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getDenominationAsLong() {
        return getComponent3AsLong();
    }

    /**
     * Get the Denomination (component 3) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent3AsLong()</code> to get the proper value.
     *
     * @return the component 3 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getDenominationAsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getDenominationAsNumber() {
        return getComponent3AsNumber();
    }

    /**
     * Gets the component 4 (Mode).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Get the component 4 as Long
     *
     * @return the component 4 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent4AsLong() {
        return SwiftFormatUtils.getLong(getComponent(4));
    }

    /**
     * Get the component 4 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent4AsLong()</code> to get the proper value.
     *
     * @return the component 4 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent4AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getComponent4AsNumber() {
        Long l = getComponent4AsLong();
        return l != null ? new BigDecimal(l) : null;
    }

    /**
     * Gets the Mode (component 4).
     * @return the Mode from component 4
     */
    public String getMode() {
        return getComponent4();
    }

    /**
     * Get the Mode (component 4) as Long
     * @return the Mode from component 4 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getModeAsLong() {
        return getComponent4AsLong();
    }

    /**
     * Get the Mode (component 4) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent4AsLong()</code> to get the proper value.
     *
     * @return the component 4 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getModeAsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getModeAsNumber() {
        return getComponent4AsNumber();
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
     * Get the component 5 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent5AsBigDecimal()</code> to get the proper value.
     *
     * @return the component 5 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent5AsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getComponent5AsNumber() {
        return getComponent5AsBigDecimal();
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
     * Get the Amount (component 5) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent5AsBigDecimal()</code> to get the proper value.
     *
     * @return the component 5 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getAmountAsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getAmountAsNumber() {
        return getComponent5AsNumber();
    }

    /**
     * Gets the component 6 (Product Code).
     * @return the component 6
     */
    public String getComponent6() {
        return getComponent(6);
    }

    /**
     * Gets the Product Code (component 6).
     * @return the Product Code from component 6
     */
    public String getProductCode() {
        return getComponent6();
    }

    /**
     * Set the component 1 (Number).
     *
     * @param component1 the Number to set
     * @return the field object to enable build pattern
     */
    public Field68A setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the component1 from a Long object.
     * <br>
     * <em>If the component being set is a fixed length number, the argument will not be
     * padded.</em> It is recommended for these cases to use the setComponent1(String)
     * method.
     *
     * @see #setComponent1(String)
     * @since 9.2.7
     *
     * @param component1 the Long with the Number content to set
     * @return the field object to enable build pattern
     */
    public Field68A setComponent1(java.lang.Long component1) {
        setComponent(1, SwiftFormatUtils.getLong(component1));
        return this;
    }

    /**
     * Alternative method setter for field's Number (component 1) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Number content to set
     * @return the field object to enable build pattern
     * @see #setNumber(java.lang.Long)
     */
    public Field68A setComponent1(java.lang.Number component1) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component1 instanceof Long) {
            setComponent(1, SwiftFormatUtils.getLong((Long) component1));
        } else if (component1 instanceof BigInteger || component1 instanceof Integer) {
            setComponent(1, SwiftFormatUtils.getLong(component1.longValue()));
        } else if (component1 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(1, SwiftFormatUtils.getLong(component1.longValue()));
        } else {
            // explicitly set component as null
            setComponent(1, null);
        }
        return this;
    }

    /**
     * Set the Number (component 1).
     *
     * @param component1 the Number to set
     * @return the field object to enable build pattern
     */
    public Field68A setNumber(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the Number (component 1) from a Long object.
     *
     * @see #setComponent1(java.lang.Long)
     *
     * @param component1 Long with the Number content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field68A setNumber(java.lang.Long component1) {
        return setComponent1(component1);
    }

    /**
     * Alternative method setter for field's Number (component 1) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Number content to set
     * @return the field object to enable build pattern
     * @see #setNumber(java.lang.Long)
     */
    public Field68A setNumber(java.lang.Number component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Currency).
     *
     * @param component2 the Currency to set
     * @return the field object to enable build pattern
     */
    public Field68A setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Currency object.
     *
     * @param component2 the Currency with the Currency content to set
     * @return the field object to enable build pattern
     */
    public Field68A setComponent2(java.util.Currency component2) {
        setComponent(2, SwiftFormatUtils.getCurrency(component2));
        return this;
    }

    /**
     * Set the Currency (component 2).
     *
     * @param component2 the Currency to set
     * @return the field object to enable build pattern
     */
    public Field68A setCurrency(String component2) {
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
    public Field68A setCurrency(java.util.Currency component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Denomination).
     *
     * @param component3 the Denomination to set
     * @return the field object to enable build pattern
     */
    public Field68A setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a Long object.
     * <br>
     * <em>If the component being set is a fixed length number, the argument will not be
     * padded.</em> It is recommended for these cases to use the setComponent3(String)
     * method.
     *
     * @see #setComponent3(String)
     * @since 9.2.7
     *
     * @param component3 the Long with the Denomination content to set
     * @return the field object to enable build pattern
     */
    public Field68A setComponent3(java.lang.Long component3) {
        setComponent(3, SwiftFormatUtils.getLong(component3));
        return this;
    }

    /**
     * Alternative method setter for field's Denomination (component 3) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Denomination content to set
     * @return the field object to enable build pattern
     * @see #setDenomination(java.lang.Long)
     */
    public Field68A setComponent3(java.lang.Number component3) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component3 instanceof Long) {
            setComponent(3, SwiftFormatUtils.getLong((Long) component3));
        } else if (component3 instanceof BigInteger || component3 instanceof Integer) {
            setComponent(3, SwiftFormatUtils.getLong(component3.longValue()));
        } else if (component3 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(3, SwiftFormatUtils.getLong(component3.longValue()));
        } else {
            // explicitly set component as null
            setComponent(3, null);
        }
        return this;
    }

    /**
     * Set the Denomination (component 3).
     *
     * @param component3 the Denomination to set
     * @return the field object to enable build pattern
     */
    public Field68A setDenomination(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Denomination (component 3) from a Long object.
     *
     * @see #setComponent3(java.lang.Long)
     *
     * @param component3 Long with the Denomination content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field68A setDenomination(java.lang.Long component3) {
        return setComponent3(component3);
    }

    /**
     * Alternative method setter for field's Denomination (component 3) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Denomination content to set
     * @return the field object to enable build pattern
     * @see #setDenomination(java.lang.Long)
     */
    public Field68A setDenomination(java.lang.Number component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Mode).
     *
     * @param component4 the Mode to set
     * @return the field object to enable build pattern
     */
    public Field68A setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component4 from a Long object.
     * <br>
     * <em>If the component being set is a fixed length number, the argument will not be
     * padded.</em> It is recommended for these cases to use the setComponent4(String)
     * method.
     *
     * @see #setComponent4(String)
     * @since 9.2.7
     *
     * @param component4 the Long with the Mode content to set
     * @return the field object to enable build pattern
     */
    public Field68A setComponent4(java.lang.Long component4) {
        setComponent(4, SwiftFormatUtils.getLong(component4));
        return this;
    }

    /**
     * Alternative method setter for field's Mode (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Mode content to set
     * @return the field object to enable build pattern
     * @see #setMode(java.lang.Long)
     */
    public Field68A setComponent4(java.lang.Number component4) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component4 instanceof Long) {
            setComponent(4, SwiftFormatUtils.getLong((Long) component4));
        } else if (component4 instanceof BigInteger || component4 instanceof Integer) {
            setComponent(4, SwiftFormatUtils.getLong(component4.longValue()));
        } else if (component4 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(4, SwiftFormatUtils.getLong(component4.longValue()));
        } else {
            // explicitly set component as null
            setComponent(4, null);
        }
        return this;
    }

    /**
     * Set the Mode (component 4).
     *
     * @param component4 the Mode to set
     * @return the field object to enable build pattern
     */
    public Field68A setMode(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the Mode (component 4) from a Long object.
     *
     * @see #setComponent4(java.lang.Long)
     *
     * @param component4 Long with the Mode content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field68A setMode(java.lang.Long component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative method setter for field's Mode (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Mode content to set
     * @return the field object to enable build pattern
     * @see #setMode(java.lang.Long)
     */
    public Field68A setMode(java.lang.Number component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Amount).
     *
     * @param component5 the Amount to set
     * @return the field object to enable build pattern
     */
    public Field68A setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the component5 from a BigDecimal object.
     * <br>
     * Parses the BigDecimal into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
     * <ul>
     *     <li>Example: 1234.00 -&gt; 1234,</li>
     *     <li>Example: 1234 -&gt; 1234,</li>
     *     <li>Example: 1234.56 -&gt; 1234,56</li>
     * </ul>
     * @since 9.2.7
     *
     * @param component5 the BigDecimal with the Amount content to set
     * @return the field object to enable build pattern
     */
    public Field68A setComponent5(java.math.BigDecimal component5) {
        setComponent(5, SwiftFormatUtils.getBigDecimal(component5));
        return this;
    }
    /**
     * Alternative method setter for field's Amount (component 5) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10.0 becomes an Float)
     *
     * @param component5 the Number with the Amount content to set
     * @return the field object to enable build pattern
     * @see #setAmount(java.math.BigDecimal)
     */
    public Field68A setComponent5(java.lang.Number component5) {

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
    public Field68A setAmount(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the Amount (component 5) from a BigDecimal object.
     *
     * @see #setComponent5(java.math.BigDecimal)
     *
     * @param component5 BigDecimal with the Amount content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field68A setAmount(java.math.BigDecimal component5) {
        return setComponent5(component5);
    }

    /**
     * Alternative method setter for field's Amount (component 5) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component5 the Number with the Amount content to set
     * @return the field object to enable build pattern
     * @see #setAmount(java.math.BigDecimal)
     */
    public Field68A setAmount(java.lang.Number component5) {
        return setComponent5(component5);
    }

    /**
     * Set the component 6 (Product Code).
     *
     * @param component6 the Product Code to set
     * @return the field object to enable build pattern
     */
    public Field68A setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }

    /**
     * Set the Product Code (component 6).
     *
     * @param component6 the Product Code to set
     * @return the field object to enable build pattern
     */
    public Field68A setProductCode(String component6) {
        return setComponent6(component6);
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
     * @return the static value of Field68A.NAME
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
    public static Field68A get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field68A(t);
    }

    /**
     * Gets the first instance of Field68A in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field68A get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field68A in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field68A> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field68A from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field68A> getAll(final SwiftTagListBlock block) {
        final List<Field68A> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add(new Field68A(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field68A object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field68A fromJson(final String json) {

        final Field68A field = new Field68A();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Number

        if (jsonObject.get("number") != null) {
            field.setComponent1(jsonObject.get("number").getAsString());
        }

        // **** COMPONENT 2 - Currency

        if (jsonObject.get("currency") != null) {
            field.setComponent2(jsonObject.get("currency").getAsString());
        }

        // **** COMPONENT 3 - Denomination

        if (jsonObject.get("denomination") != null) {
            field.setComponent3(jsonObject.get("denomination").getAsString());
        }

        // **** COMPONENT 4 - Mode

        if (jsonObject.get("mode") != null) {
            field.setComponent4(jsonObject.get("mode").getAsString());
        }

        // **** COMPONENT 5 - Amount

        if (jsonObject.get("amount") != null) {
            field.setComponent5(jsonObject.get("amount").getAsString());
        }

        // **** COMPONENT 6 - Product Code

        if (jsonObject.get("productCode") != null) {
            field.setComponent6(jsonObject.get("productCode").getAsString());
        }

        return field;
    }


}
