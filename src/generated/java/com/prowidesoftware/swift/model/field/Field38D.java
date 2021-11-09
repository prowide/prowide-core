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


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 38D</strong>
 * <p>
 * Model and parser for field 38D of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>Long</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>4n</code></li>
 * 		<li>parser pattern: <code>S</code></li>
 * 		<li>components pattern: <code>N</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field38D extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 38D
	 */
    public static final String NAME = "38D";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_38D = "38D";
	public static final String PARSER_PATTERN = "S";

    /**
     * Components pattern
     *
     * Contains a description of the type for every component. This is <em>DEPRECATED</em>,
     * use TYPES_PATTERN instead, because it distinguishes between N (number) and I (BigDecimal)
     * @see #TYPES_PATTERN
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "N";

    /**
     * Types pattern
     *
     * Contains a description of the type for every component, use instead of COMPONENTS_PATTERN.
     * @since 9.2.7
     */
	public static final String TYPES_PATTERN = "N";

	/**
	 * Component number for the Period subfield
	 */
	public static final Integer PERIOD = 1;

	/**
	 * Alternative (<em>DEPRECATED</em>) constant name for field's Period Component number
	 * @see #PERIOD
	 */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public static final Integer NUMBER = 1;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field38D() {
        super(1);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field38D(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field38D(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "38D")) {
            throw new IllegalArgumentException("cannot create field 38D from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.<br>
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field38D newInstance(Field38D source) {
        Field38D cp = new Field38D();
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
        init(1);
        setComponent1(value);
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        append(result, 1);
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
        if (component < 1 || component > 1) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 38D");
        }
        if (component == 1) {
            //default format (as is)
            return getComponent(1);
        }
        return null;
    }

    /**
     * Returns the field components pattern
     *
     * This method is <em>DEPRECATED</em>, use <code>typesPattern()</code> instead.
     * @see #typesPattern()
     * @return the static value of Field38D.COMPONENTS_PATTERN
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
     * @return the static value of Field38D.TYPES_PATTERN
     */
    @Override
    public final String typesPattern() {
        return TYPES_PATTERN;
    }

    /**
     * Returns the field parser pattern
     * @return the static value of Field38D.PARSER_PATTERN
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
        return "4n";
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
        return 1;
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
        result.put(1, "period");
        return result;
    }


    /**
     * Gets the component 1 (Period).
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
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getComponent1AsNumber() {
        Long l = getComponent1AsLong();
        return l != null ? new BigDecimal(l) : null;
    }

    /**
     * Gets the Period (component 1).
     * @return the Period from component 1
     */
    public String getPeriod() {
        return getComponent1();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Period
     * @see #getPeriod()
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public String getNumber() {
        return getPeriod();
    }

    /**
     * Get the Period (component 1) as Long
     * @return the Period from component 1 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getPeriodAsLong() {
        return getComponent1AsLong();
    }

    /**
     * Get the Period (component 1) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent1AsLong()</code> to get the proper value.
     *
     * @return the component 1 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getPeriodAsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getPeriodAsNumber() {
        return getComponent1AsNumber();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Period as Long
     * @see #getPeriodAsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Long getNumberAsLong() {
        return getPeriodAsLong();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Period (component 1) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent1AsLong()</code> to get the proper value.
     *
     * @return the component 1 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getPeriodAsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getNumberAsNumber() {
        return getPeriodAsNumber();
    }

    /**
     * Set the component 1 (Period).
     *
     * @param component1 the Period to set
     * @return the field object to enable build pattern
     */
    public Field38D setComponent1(String component1) {
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
     * @param component1 the Long with the Period content to set
     * @return the field object to enable build pattern
     */
    public Field38D setComponent1(java.lang.Long component1) {
        setComponent(1, SwiftFormatUtils.getLong(component1));
        return this;
    }

    /**
     * Alternative method setter for field's Period (component 1) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Period content to set
     * @return the field object to enable build pattern
     * @see #setPeriod(java.lang.Long)
     */
    public Field38D setComponent1(java.lang.Number component1) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component1 instanceof Long) {
            setComponent(1, SwiftFormatUtils.getLong( (Long) component1));
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
     * Set the Period (component 1).
     *
     * @param component1 the Period to set
     * @return the field object to enable build pattern
     */
    public Field38D setPeriod(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the Period (component 1) from a Long object.
     *
     * @see #setComponent1(java.lang.Long)
     *
     * @param component1 Long with the Period content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field38D setPeriod(java.lang.Long component1) {
        return setComponent1(component1);
    }

    /**
     * Alternative method setter for field's Period (component 1) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Period content to set
     * @return the field object to enable build pattern
     * @see #setPeriod(java.lang.Long)
     */
    public Field38D setPeriod(java.lang.Number component1) {
        return setComponent1(component1);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Period
     *
     * @see #setPeriod(String)
     *
     * @param component1 the Period to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public Field38D setNumber(String component1) {
        return setPeriod(component1);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Period from a Long object.
     *
     * @see #setComponent1(java.lang.Long)
     *
     * @param component1 Long with the Period content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public Field38D setNumber(java.lang.Long component1) {
        return setPeriod(component1);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Period (component 1) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Period content to set
     * @return the field object to enable build pattern
     * @see #setPeriod(java.lang.Long)
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public Field38D setNumber(java.lang.Number component1) {
        return setPeriod(component1);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any)
     * @return the static value of Field38D.NAME
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
    public static Field38D get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field38D(t) ;
    }

    /**
     * Gets the first instance of Field38D in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field38D get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return null;
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field38D in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field38D> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return java.util.Collections.emptyList();
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field38D from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field38D> getAll(final SwiftTagListBlock block) {
        final List<Field38D> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add( new Field38D(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field38D object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field38D fromJson(final String json) {

        Field38D field = new Field38D();

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(json);

        // **** COMPONENT 1 - Period

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("number") != null) {
            field.setComponent1(jsonObject.get("number").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("period") != null) {
            field.setComponent1(jsonObject.get("period").getAsString());
        }

        return field;
    }


}
