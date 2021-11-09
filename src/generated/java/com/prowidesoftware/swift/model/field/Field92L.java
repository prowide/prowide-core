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

import com.prowidesoftware.swift.model.field.GenericField;
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
 * <strong>SWIFT MT Field 92L</strong>
 * <p>
 * Model and parser for field 92L of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>Currency</code></li>
 * 		<li><code>BigDecimal</code></li>
 * 		<li><code>Currency</code></li>
 * 		<li><code>BigDecimal</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>:4!c//&lt;CUR&gt;&lt;AMOUNT&gt;15/&lt;CUR&gt;&lt;AMOUNT&gt;15</code></li>
 * 		<li>parser pattern: <code>:S//SN/SN</code></li>
 * 		<li>components pattern: <code>SCNCN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field92L extends Field implements Serializable, CurrencyContainer, AmountContainer, GenericField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 92L
	 */
    public static final String NAME = "92L";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_92L = "92L";
	public static final String PARSER_PATTERN = ":S//SN/SN";

    /**
     * Components pattern
     *
     * Contains a description of the type for every component. This is <em>DEPRECATED</em>,
     * use TYPES_PATTERN instead, because it distinguishes between N (number) and I (BigDecimal)
     * @see #TYPES_PATTERN
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "SCNCN";

    /**
     * Types pattern
     *
     * Contains a description of the type for every component, use instead of COMPONENTS_PATTERN.
     * @since 9.2.7
     */
	public static final String TYPES_PATTERN = "SCICI";

	/**
	 * Component number for the Qualifier subfield
	 */
	public static final Integer QUALIFIER = 1;

	/**
	 * Component number for the First Currency Code subfield
	 */
	public static final Integer FIRST_CURRENCY_CODE = 2;

	/**
	 * Alternative (<em>DEPRECATED</em>) constant name for field's First Currency Code Component number
	 * @see #FIRST_CURRENCY_CODE
	 */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public static final Integer CURRENCY1 = 2;

	/**
	 * Component number for the Amount1 subfield
	 */
	public static final Integer AMOUNT1 = 3;

	/**
	 * Component number for the Second Currency Code subfield
	 */
	public static final Integer SECOND_CURRENCY_CODE = 4;

	/**
	 * Alternative (<em>DEPRECATED</em>) constant name for field's Second Currency Code Component number
	 * @see #SECOND_CURRENCY_CODE
	 */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public static final Integer CURRENCY2 = 4;

	/**
	 * Component number for the Amount2 subfield
	 */
	public static final Integer AMOUNT2 = 5;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field92L() {
        super(5);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field92L(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field92L(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "92L")) {
            throw new IllegalArgumentException("cannot create field 92L from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.<br>
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field92L newInstance(Field92L source) {
        Field92L cp = new Field92L();
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
        init(5);
        setComponent1(SwiftParseUtils.getTokenFirst(value, ":", "//"));
        String toparse = SwiftParseUtils.getTokenSecond(value, "//");
        String toparse2 = SwiftParseUtils.getTokenFirst(toparse, "/");
        setComponent2(SwiftParseUtils.getAlphaPrefix(toparse2));
        setComponent3(SwiftParseUtils.getNumericSuffix(toparse2));
        String toparse3 = SwiftParseUtils.getTokenSecondLast(toparse, "/");
        setComponent4(SwiftParseUtils.getAlphaPrefix(toparse3));
        setComponent5(SwiftParseUtils.getNumericSuffix(toparse3));
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 92L");
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
        return null;
    }

    /**
     * Returns the field components pattern
     *
     * This method is <em>DEPRECATED</em>, use <code>typesPattern()</code> instead.
     * @see #typesPattern()
     * @return the static value of Field92L.COMPONENTS_PATTERN
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
     * @return the static value of Field92L.TYPES_PATTERN
     */
    @Override
    public final String typesPattern() {
        return TYPES_PATTERN;
    }

    /**
     * Returns the field parser pattern
     * @return the static value of Field92L.PARSER_PATTERN
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
        return ":4!c//<CUR><AMOUNT>15/<CUR><AMOUNT>15";
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
    protected List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Qualifier");
        result.add("First Currency Code");
        result.add("Amount1");
        result.add("Second Currency Code");
        result.add("Amount2");
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
        result.put(2, "firstCurrencyCode");
        result.put(3, "amount1");
        result.put(4, "secondCurrencyCode");
        result.put(5, "amount2");
        return result;
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
     * Gets the component 2 (First Currency Code).
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
     * Gets the First Currency Code (component 2).
     * @return the First Currency Code from component 2
     */
    public String getFirstCurrencyCode() {
        return getComponent2();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's First Currency Code
     * @see #getFirstCurrencyCode()
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public String getCurrency1() {
        return getFirstCurrencyCode();
    }

    /**
     * Get the First Currency Code (component 2) as Currency
     * @return the First Currency Code from component 2 converted to Currency or null if cannot be converted
     */
    public java.util.Currency getFirstCurrencyCodeAsCurrency() {
        return getComponent2AsCurrency();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's First Currency Code as Currency
     * @see #getFirstCurrencyCodeAsCurrency()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.util.Currency getCurrency1AsCurrency() {
        return getFirstCurrencyCodeAsCurrency();
    }

    /**
     * Gets the component 3 (Amount1).
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
     * Get the component 3 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent3AsBigDecimal()</code> to get the proper value.
     *
     * @return the component 3 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent3AsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getComponent3AsNumber() {
        return getComponent3AsBigDecimal();
    }

    /**
     * Gets the Amount1 (component 3).
     * @return the Amount1 from component 3
     */
    public String getAmount1() {
        return getComponent3();
    }

    /**
     * Get the Amount1 (component 3) as BigDecimal
     * @return the Amount1 from component 3 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getAmount1AsBigDecimal() {
        return getComponent3AsBigDecimal();
    }

    /**
     * Get the Amount1 (component 3) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent3AsBigDecimal()</code> to get the proper value.
     *
     * @return the component 3 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getAmount1AsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getAmount1AsNumber() {
        return getComponent3AsNumber();
    }

    /**
     * Gets the component 4 (Second Currency Code).
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
     * Gets the Second Currency Code (component 4).
     * @return the Second Currency Code from component 4
     */
    public String getSecondCurrencyCode() {
        return getComponent4();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Second Currency Code
     * @see #getSecondCurrencyCode()
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public String getCurrency2() {
        return getSecondCurrencyCode();
    }

    /**
     * Get the Second Currency Code (component 4) as Currency
     * @return the Second Currency Code from component 4 converted to Currency or null if cannot be converted
     */
    public java.util.Currency getSecondCurrencyCodeAsCurrency() {
        return getComponent4AsCurrency();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Second Currency Code as Currency
     * @see #getSecondCurrencyCodeAsCurrency()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.util.Currency getCurrency2AsCurrency() {
        return getSecondCurrencyCodeAsCurrency();
    }

    /**
     * Gets the component 5 (Amount2).
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
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getComponent5AsNumber() {
        return getComponent5AsBigDecimal();
    }

    /**
     * Gets the Amount2 (component 5).
     * @return the Amount2 from component 5
     */
    public String getAmount2() {
        return getComponent5();
    }

    /**
     * Get the Amount2 (component 5) as BigDecimal
     * @return the Amount2 from component 5 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getAmount2AsBigDecimal() {
        return getComponent5AsBigDecimal();
    }

    /**
     * Get the Amount2 (component 5) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent5AsBigDecimal()</code> to get the proper value.
     *
     * @return the component 5 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getAmount2AsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getAmount2AsNumber() {
        return getComponent5AsNumber();
    }

    /**
     * Set the component 1 (Qualifier).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field92L setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Qualifier (component 1).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field92L setQualifier(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (First Currency Code).
     *
     * @param component2 the First Currency Code to set
     * @return the field object to enable build pattern
     */
    public Field92L setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Currency object.
     *
     * @param component2 the Currency with the First Currency Code content to set
     * @return the field object to enable build pattern
     */
    public Field92L setComponent2(java.util.Currency component2) {
        setComponent(2, SwiftFormatUtils.getCurrency(component2));
        return this;
    }

    /**
     * Set the First Currency Code (component 2).
     *
     * @param component2 the First Currency Code to set
     * @return the field object to enable build pattern
     */
    public Field92L setFirstCurrencyCode(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the First Currency Code (component 2) from a Currency object.
     *
     * @see #setComponent2(java.util.Currency)
     *
     * @param component2 Currency with the First Currency Code content to set
     * @return the field object to enable build pattern
     */
    public Field92L setFirstCurrencyCode(java.util.Currency component2) {
        return setComponent2(component2);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's First Currency Code
     *
     * @see #setFirstCurrencyCode(String)
     *
     * @param component2 the First Currency Code to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public Field92L setCurrency1(String component2) {
        return setFirstCurrencyCode(component2);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's First Currency Code from a Currency object.
     *
     * @see #setComponent2(java.util.Currency)
     *
     * @param component2 Currency with the First Currency Code content to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public Field92L setCurrency1(java.util.Currency component2) {
        return setFirstCurrencyCode(component2);
    }

    /**
     * Set the component 3 (Amount1).
     *
     * @param component3 the Amount1 to set
     * @return the field object to enable build pattern
     */
    public Field92L setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a BigDecimal object.
     * <br>
     * Parses the BigDecimal into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
     * <ul>
     *     <li>Example: 1234.00 -&gt; 1234,</li>
     *     <li>Example: 1234 -&gt; 1234,</li>
     *     <li>Example: 1234.56 -&gt; 1234,56</li>
     * </ul>
     * @since 9.2.7
     *
     * @param component3 the BigDecimal with the Amount1 content to set
     * @return the field object to enable build pattern
     */
    public Field92L setComponent3(java.math.BigDecimal component3) {
        setComponent(3, SwiftFormatUtils.getBigDecimal(component3));
        return this;
    }
    /**
     * Alternative method setter for field's Amount1 (component 3) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10.0 becomes an Float)
     *
     * @param component3 the Number with the Amount1 content to set
     * @return the field object to enable build pattern
     * @see #setAmount1(java.math.BigDecimal)
     */
    public Field92L setComponent3(java.lang.Number component3) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component3 instanceof BigDecimal) {
            setComponent(3, SwiftFormatUtils.getBigDecimal( (BigDecimal) component3));
        } else if (component3 instanceof BigInteger) {
            setComponent(3, SwiftFormatUtils.getBigDecimal(new BigDecimal( (BigInteger) component3)));
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
     * Set the Amount1 (component 3).
     *
     * @param component3 the Amount1 to set
     * @return the field object to enable build pattern
     */
    public Field92L setAmount1(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Amount1 (component 3) from a BigDecimal object.
     *
     * @see #setComponent3(java.math.BigDecimal)
     *
     * @param component3 BigDecimal with the Amount1 content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field92L setAmount1(java.math.BigDecimal component3) {
        return setComponent3(component3);
    }

    /**
     * Alternative method setter for field's Amount1 (component 3) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Amount1 content to set
     * @return the field object to enable build pattern
     * @see #setAmount1(java.math.BigDecimal)
     */
    public Field92L setAmount1(java.lang.Number component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Second Currency Code).
     *
     * @param component4 the Second Currency Code to set
     * @return the field object to enable build pattern
     */
    public Field92L setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component4 from a Currency object.
     *
     * @param component4 the Currency with the Second Currency Code content to set
     * @return the field object to enable build pattern
     */
    public Field92L setComponent4(java.util.Currency component4) {
        setComponent(4, SwiftFormatUtils.getCurrency(component4));
        return this;
    }

    /**
     * Set the Second Currency Code (component 4).
     *
     * @param component4 the Second Currency Code to set
     * @return the field object to enable build pattern
     */
    public Field92L setSecondCurrencyCode(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the Second Currency Code (component 4) from a Currency object.
     *
     * @see #setComponent4(java.util.Currency)
     *
     * @param component4 Currency with the Second Currency Code content to set
     * @return the field object to enable build pattern
     */
    public Field92L setSecondCurrencyCode(java.util.Currency component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Second Currency Code
     *
     * @see #setSecondCurrencyCode(String)
     *
     * @param component4 the Second Currency Code to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public Field92L setCurrency2(String component4) {
        return setSecondCurrencyCode(component4);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Second Currency Code from a Currency object.
     *
     * @see #setComponent4(java.util.Currency)
     *
     * @param component4 Currency with the Second Currency Code content to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public Field92L setCurrency2(java.util.Currency component4) {
        return setSecondCurrencyCode(component4);
    }

    /**
     * Set the component 5 (Amount2).
     *
     * @param component5 the Amount2 to set
     * @return the field object to enable build pattern
     */
    public Field92L setComponent5(String component5) {
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
     * @param component5 the BigDecimal with the Amount2 content to set
     * @return the field object to enable build pattern
     */
    public Field92L setComponent5(java.math.BigDecimal component5) {
        setComponent(5, SwiftFormatUtils.getBigDecimal(component5));
        return this;
    }
    /**
     * Alternative method setter for field's Amount2 (component 5) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10.0 becomes an Float)
     *
     * @param component5 the Number with the Amount2 content to set
     * @return the field object to enable build pattern
     * @see #setAmount2(java.math.BigDecimal)
     */
    public Field92L setComponent5(java.lang.Number component5) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component5 instanceof BigDecimal) {
            setComponent(5, SwiftFormatUtils.getBigDecimal( (BigDecimal) component5));
        } else if (component5 instanceof BigInteger) {
            setComponent(5, SwiftFormatUtils.getBigDecimal(new BigDecimal( (BigInteger) component5)));
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
     * Set the Amount2 (component 5).
     *
     * @param component5 the Amount2 to set
     * @return the field object to enable build pattern
     */
    public Field92L setAmount2(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the Amount2 (component 5) from a BigDecimal object.
     *
     * @see #setComponent5(java.math.BigDecimal)
     *
     * @param component5 BigDecimal with the Amount2 content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field92L setAmount2(java.math.BigDecimal component5) {
        return setComponent5(component5);
    }

    /**
     * Alternative method setter for field's Amount2 (component 5) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component5 the Number with the Amount2 content to set
     * @return the field object to enable build pattern
     * @see #setAmount2(java.math.BigDecimal)
     */
    public Field92L setAmount2(java.lang.Number component5) {
        return setComponent5(component5);
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
     * Returns the issuer code (or Data Source Scheme or DSS).
     * The DSS is only present in some generic fields, when present, is equals to component two.
     *
     * @return DSS component value or null if the DSS is not set or not available for this field.
     */
    public String getDSS() {
        return null;
    }

    /**
     * Checks if the issuer code (or Data Source Scheme or DSS) is present.
     *
     * @see #getDSS()
     * @return true if DSS is present, false otherwise.
     */
    public boolean isDSSPresent() {
        return false;
    }

    /**
     * Component number for the conditional qualifier subfield
     */
    public static final Integer CONDITIONAL_QUALIFIER = 2;

    /**
     * Gets the component with the conditional (secondary) qualifier.
     *
     * @return for generic fields returns the value of the conditional qualifier or null if not set or not applicable for this field.
     */
    public String getConditionalQualifier() {
        return getComponent(CONDITIONAL_QUALIFIER);
    }

    /**
     * Returns the field's name composed by the field number and the letter option (if any)
     * @return the static value of Field92L.NAME
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
    public static Field92L get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field92L(t) ;
    }

    /**
     * Gets the first instance of Field92L in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field92L get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return null;
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field92L in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field92L> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return java.util.Collections.emptyList();
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field92L from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field92L> getAll(final SwiftTagListBlock block) {
        final List<Field92L> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add( new Field92L(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field92L object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field92L fromJson(final String json) {

        Field92L field = new Field92L();

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(json);

        // **** COMPONENT 1 - Qualifier

        if (jsonObject.get("qualifier") != null) {
            field.setComponent1(jsonObject.get("qualifier").getAsString());
        }

        // **** COMPONENT 2 - First Currency Code

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("currency1") != null) {
            field.setComponent2(jsonObject.get("currency1").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("firstCurrencyCode") != null) {
            field.setComponent2(jsonObject.get("firstCurrencyCode").getAsString());
        }

        // **** COMPONENT 3 - Amount1

        if (jsonObject.get("amount1") != null) {
            field.setComponent3(jsonObject.get("amount1").getAsString());
        }

        // **** COMPONENT 4 - Second Currency Code

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("currency2") != null) {
            field.setComponent4(jsonObject.get("currency2").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("secondCurrencyCode") != null) {
            field.setComponent4(jsonObject.get("secondCurrencyCode").getAsString());
        }

        // **** COMPONENT 5 - Amount2

        if (jsonObject.get("amount2") != null) {
            field.setComponent5(jsonObject.get("amount2").getAsString());
        }

        return field;
    }


}
