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

import com.prowidesoftware.swift.model.field.GenericField;
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
 * SWIFT MT Field 92R.
 * <p>
 * Model and parser for field 92R of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>BigDecimal</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>:4!c/[8c]/4!c/&lt;AMOUNT&gt;15</code></li>
 * 		<li>parser pattern: <code>:S/[S]/S/N</code></li>
 * 		<li>components pattern: <code>SSSN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field92R extends Field implements Serializable, AmountContainer, GenericField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 92R.
	 */
    public static final String NAME = "92R";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_92R = "92R";

    /**
     * @deprecated use {@link #parserPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
	public static final String PARSER_PATTERN = ":S/[S]/S/N";

    /**
     * @deprecated use {@link #typesPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "SSSN";

    /**
     * @deprecated use {@link #typesPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
	public static final String TYPES_PATTERN = "SSSI";

	/**
	 * Component number for the Qualifier subfield.
	 */
	public static final Integer QUALIFIER = 1;

	/**
	 * Component number for the Data Source Scheme subfield.
	 */
	public static final Integer DATA_SOURCE_SCHEME = 2;

	/**
	 * Component number for the Rate Type Code subfield.
	 */
	public static final Integer RATE_TYPE_CODE = 3;

	/**
	 * Alternative (<em>DEPRECATED</em>) constant name for field's Rate Type Code Component number.
	 * @see #RATE_TYPE_CODE
	 */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public static final Integer CODE = 3;

	/**
	 * Component number for the Rate subfield.
	 */
	public static final Integer RATE = 4;

	/**
	 * Alternative (<em>DEPRECATED</em>) constant name for field's Rate Component number.
	 * @see #RATE
	 */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public static final Integer AMOUNT = 4;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field92R() {
        super(4);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field92R(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field92R(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "92R")) {
            throw new IllegalArgumentException("cannot create field 92R from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field92R newInstance(Field92R source) {
        Field92R cp = new Field92R();
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
        setComponent1(SwiftParseUtils.getTokenFirst(value, ":", "/"));
        setComponent2(SwiftParseUtils.getTokenSecond(value, "/"));
        setComponent3(SwiftParseUtils.getTokenThird(value, "/"));
        setComponent4(SwiftParseUtils.getTokenForthLast(value, "/"));
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        result.append(":");
        append(result, 1);
        result.append("/");
           append(result, 2);
        result.append("/");
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 92R");
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
        return "SSSN";
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
        return "SSSI";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return ":S/[S]/S/N";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return ":4!c/[8c]/4!c/<AMOUNT>15";
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
        result.add("Data Source Scheme");
        result.add("Rate Type Code");
        result.add("Rate");
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
        result.put(2, "dataSourceScheme");
        result.put(3, "rateTypeCode");
        result.put(4, "rate");
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
     * Gets the component 2 (Data Source Scheme).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Data Source Scheme (component 2).
     * @return the Data Source Scheme from component 2
     */
    public String getDataSourceScheme() {
        return getComponent2();
    }

    /**
     * Gets the component 3 (Rate Type Code).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Rate Type Code (component 3).
     * @return the Rate Type Code from component 3
     */
    public String getRateTypeCode() {
        return getComponent3();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Rate Type Code
     * @see #getRateTypeCode()
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public String getCode() {
        return getRateTypeCode();
    }

    /**
     * Gets the component 4 (Rate).
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
     * Gets the Rate (component 4).
     * @return the Rate from component 4
     */
    public String getRate() {
        return getComponent4();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Rate
     * @see #getRate()
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public String getAmount() {
        return getRate();
    }

    /**
     * Get the Rate (component 4) as BigDecimal
     * @return the Rate from component 4 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getRateAsBigDecimal() {
        return getComponent4AsBigDecimal();
    }

    /**
     * Get the Rate (component 4) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent4AsBigDecimal()</code> to get the proper value.
     *
     * @return the component 4 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getRateAsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getRateAsNumber() {
        return getComponent4AsNumber();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Rate as BigDecimal
     * @see #getRateAsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.math.BigDecimal getAmountAsBigDecimal() {
        return getRateAsBigDecimal();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Rate (component 4) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent4AsBigDecimal()</code> to get the proper value.
     *
     * @return the component 4 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getRateAsBigDecimal()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getAmountAsNumber() {
        return getRateAsNumber();
    }

    /**
     * Set the component 1 (Qualifier).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field92R setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Qualifier (component 1).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field92R setQualifier(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Data Source Scheme).
     *
     * @param component2 the Data Source Scheme to set
     * @return the field object to enable build pattern
     */
    public Field92R setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Data Source Scheme (component 2).
     *
     * @param component2 the Data Source Scheme to set
     * @return the field object to enable build pattern
     */
    public Field92R setDataSourceScheme(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Rate Type Code).
     *
     * @param component3 the Rate Type Code to set
     * @return the field object to enable build pattern
     */
    public Field92R setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Rate Type Code (component 3).
     *
     * @param component3 the Rate Type Code to set
     * @return the field object to enable build pattern
     */
    public Field92R setRateTypeCode(String component3) {
        return setComponent3(component3);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Rate Type Code
     *
     * @see #setRateTypeCode(String)
     *
     * @param component3 the Rate Type Code to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public Field92R setCode(String component3) {
        return setRateTypeCode(component3);
    }

    /**
     * Set the component 4 (Rate).
     *
     * @param component4 the Rate to set
     * @return the field object to enable build pattern
     */
    public Field92R setComponent4(String component4) {
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
     * @param component4 the BigDecimal with the Rate content to set
     * @return the field object to enable build pattern
     */
    public Field92R setComponent4(java.math.BigDecimal component4) {
        setComponent(4, SwiftFormatUtils.getBigDecimal(component4));
        return this;
    }
    /**
     * Alternative method setter for field's Rate (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10.0 becomes an Float)
     *
     * @param component4 the Number with the Rate content to set
     * @return the field object to enable build pattern
     * @see #setRate(java.math.BigDecimal)
     */
    public Field92R setComponent4(java.lang.Number component4) {

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
     * Set the Rate (component 4).
     *
     * @param component4 the Rate to set
     * @return the field object to enable build pattern
     */
    public Field92R setRate(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the Rate (component 4) from a BigDecimal object.
     *
     * @see #setComponent4(java.math.BigDecimal)
     *
     * @param component4 BigDecimal with the Rate content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field92R setRate(java.math.BigDecimal component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative method setter for field's Rate (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Rate content to set
     * @return the field object to enable build pattern
     * @see #setRate(java.math.BigDecimal)
     */
    public Field92R setRate(java.lang.Number component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Rate
     *
     * @see #setRate(String)
     *
     * @param component4 the Rate to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public Field92R setAmount(String component4) {
        return setRate(component4);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Rate from a BigDecimal object.
     *
     * @see #setComponent4(java.math.BigDecimal)
     *
     * @param component4 BigDecimal with the Rate content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public Field92R setAmount(java.math.BigDecimal component4) {
        return setRate(component4);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Rate (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Rate content to set
     * @return the field object to enable build pattern
     * @see #setRate(java.math.BigDecimal)
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public Field92R setAmount(java.lang.Number component4) {
        return setRate(component4);
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
        return getComponent2();
    }

    /**
     * Checks if the issuer code (or Data Source Scheme or DSS) is present.
     *
     * @see #getDSS()
     * @return true if DSS is present, false otherwise.
     */
    public boolean isDSSPresent() {
        return getComponent2() != null;
    }

    /**
     * Component number for the conditional qualifier subfield.
     */
    public static final Integer CONDITIONAL_QUALIFIER = 3;

    /**
     * Gets the component with the conditional (secondary) qualifier.
     *
     * @return for generic fields returns the value of the conditional qualifier or null if not set or not applicable for this field.
     */
    public String getConditionalQualifier() {
        return getComponent(CONDITIONAL_QUALIFIER);
    }

    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field92R.NAME
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
    public static Field92R get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field92R(t);
    }

    /**
     * Gets the first instance of Field92R in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field92R get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field92R in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field92R> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field92R from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field92R> getAll(final SwiftTagListBlock block) {
        final List<Field92R> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add(new Field92R(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field92R object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field92R fromJson(final String json) {

        final Field92R field = new Field92R();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Qualifier

        if (jsonObject.get("qualifier") != null) {
            field.setComponent1(jsonObject.get("qualifier").getAsString());
        }

        // **** COMPONENT 2 - Data Source Scheme

        if (jsonObject.get("dataSourceScheme") != null) {
            field.setComponent2(jsonObject.get("dataSourceScheme").getAsString());
        }

        // **** COMPONENT 3 - Rate Type Code

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("code") != null) {
            field.setComponent3(jsonObject.get("code").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("rateTypeCode") != null) {
            field.setComponent3(jsonObject.get("rateTypeCode").getAsString());
        }

        // **** COMPONENT 4 - Rate

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("amount") != null) {
            field.setComponent4(jsonObject.get("amount").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("rate") != null) {
            field.setComponent4(jsonObject.get("rate").getAsString());
        }

        return field;
    }


}
