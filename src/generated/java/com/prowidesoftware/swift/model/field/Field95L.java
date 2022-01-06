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

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 95L.
 * <p>
 * Model and parser for field 95L of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Long</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>:4!c//18!c2!n</code></li>
 * 		<li>parser pattern: <code>:S//18!SS</code></li>
 * 		<li>components pattern: <code>SSN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field95L extends Field implements Serializable, GenericField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 95L.
	 */
    public static final String NAME = "95L";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_95L = "95L";
	public static final String PARSER_PATTERN = ":S//18!SS";

    /**
     * Components pattern.
     *
     * Contains a description of the type for every component. This is <em>DEPRECATED</em>,
     * use TYPES_PATTERN instead, because it distinguishes between N (number) and I (BigDecimal)
     * @see #TYPES_PATTERN
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "SSN";

    /**
     * Types pattern.
     *
     * Contains a description of the type for every component, use instead of COMPONENTS_PATTERN.
     * @since 9.2.7
     */
	public static final String TYPES_PATTERN = "SSN";

	/**
	 * Component number for the Qualifier subfield.
	 */
	public static final Integer QUALIFIER = 1;

	/**
	 * Component number for the Legal Entity Identifier Code subfield.
	 */
	public static final Integer LEGAL_ENTITY_IDENTIFIER_CODE = 2;

	/**
	 * Component number for the Legal Entity Identifier Number subfield.
	 */
	public static final Integer LEGAL_ENTITY_IDENTIFIER_NUMBER = 3;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field95L() {
        super(3);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field95L(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field95L(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "95L")) {
            throw new IllegalArgumentException("cannot create field 95L from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field95L newInstance(Field95L source) {
        Field95L cp = new Field95L();
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
        init(3);
        setComponent1(SwiftParseUtils.getTokenFirst(value, ":", "//"));
        String toparse = SwiftParseUtils.getTokenSecondLast(value, "//");
        if (toparse != null) {
            setComponent2(StringUtils.substring(toparse, 0, 18));
            if (toparse.length() > 18) {
                setComponent3(StringUtils.substring(toparse, 18));
            }
        }
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 95L");
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
        return null;
    }

    /**
     * Returns the field components pattern
     *
     * This method is <em>DEPRECATED</em>, use <code>typesPattern()</code> instead.
     * @see #typesPattern()
     * @return the static value of Field95L.COMPONENTS_PATTERN
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
     * @return the static value of Field95L.TYPES_PATTERN
     */
    @Override
    public final String typesPattern() {
        return TYPES_PATTERN;
    }

    /**
     * Returns the field parser pattern
     * @return the static value of Field95L.PARSER_PATTERN
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
        return ":4!c//18!c2!n";
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
    public List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Qualifier");
        result.add("Legal Entity Identifier Code");
        result.add("Legal Entity Identifier Number");
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
        result.put(2, "legalEntityIdentifierCode");
        result.put(3, "legalEntityIdentifierNumber");
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
     * Gets the component 2 (Legal Entity Identifier Code).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Legal Entity Identifier Code (component 2).
     * @return the Legal Entity Identifier Code from component 2
     */
    public String getLegalEntityIdentifierCode() {
        return getComponent2();
    }

    /**
     * Gets the component 3 (Legal Entity Identifier Number).
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
     * Gets the Legal Entity Identifier Number (component 3).
     * @return the Legal Entity Identifier Number from component 3
     */
    public String getLegalEntityIdentifierNumber() {
        return getComponent3();
    }

    /**
     * Get the Legal Entity Identifier Number (component 3) as Long
     * @return the Legal Entity Identifier Number from component 3 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getLegalEntityIdentifierNumberAsLong() {
        return getComponent3AsLong();
    }

    /**
     * Get the Legal Entity Identifier Number (component 3) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent3AsLong()</code> to get the proper value.
     *
     * @return the component 3 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getLegalEntityIdentifierNumberAsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public java.lang.Number getLegalEntityIdentifierNumberAsNumber() {
        return getComponent3AsNumber();
    }

    /**
     * Set the component 1 (Qualifier).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field95L setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Qualifier (component 1).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field95L setQualifier(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Legal Entity Identifier Code).
     *
     * @param component2 the Legal Entity Identifier Code to set
     * @return the field object to enable build pattern
     */
    public Field95L setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Legal Entity Identifier Code (component 2).
     *
     * @param component2 the Legal Entity Identifier Code to set
     * @return the field object to enable build pattern
     */
    public Field95L setLegalEntityIdentifierCode(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Legal Entity Identifier Number).
     *
     * @param component3 the Legal Entity Identifier Number to set
     * @return the field object to enable build pattern
     */
    public Field95L setComponent3(String component3) {
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
     * @param component3 the Long with the Legal Entity Identifier Number content to set
     * @return the field object to enable build pattern
     */
    public Field95L setComponent3(java.lang.Long component3) {
        setComponent(3, SwiftFormatUtils.getLong(component3));
        return this;
    }

    /**
     * Alternative method setter for field's Legal Entity Identifier Number (component 3) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Legal Entity Identifier Number content to set
     * @return the field object to enable build pattern
     * @see #setLegalEntityIdentifierNumber(java.lang.Long)
     */
    public Field95L setComponent3(java.lang.Number component3) {

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
     * Set the Legal Entity Identifier Number (component 3).
     *
     * @param component3 the Legal Entity Identifier Number to set
     * @return the field object to enable build pattern
     */
    public Field95L setLegalEntityIdentifierNumber(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Legal Entity Identifier Number (component 3) from a Long object.
     *
     * @see #setComponent3(java.lang.Long)
     *
     * @param component3 Long with the Legal Entity Identifier Number content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field95L setLegalEntityIdentifierNumber(java.lang.Long component3) {
        return setComponent3(component3);
    }

    /**
     * Alternative method setter for field's Legal Entity Identifier Number (component 3) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Legal Entity Identifier Number content to set
     * @return the field object to enable build pattern
     * @see #setLegalEntityIdentifierNumber(java.lang.Long)
     */
    public Field95L setLegalEntityIdentifierNumber(java.lang.Number component3) {
        return setComponent3(component3);
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
     * Component number for the conditional qualifier subfield.
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
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field95L.NAME
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
    public static Field95L get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field95L(t);
    }

    /**
     * Gets the first instance of Field95L in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field95L get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field95L in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field95L> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field95L from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field95L> getAll(final SwiftTagListBlock block) {
        final List<Field95L> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add(new Field95L(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field95L object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field95L fromJson(final String json) {

        final Field95L field = new Field95L();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Qualifier

        if (jsonObject.get("qualifier") != null) {
            field.setComponent1(jsonObject.get("qualifier").getAsString());
        }

        // **** COMPONENT 2 - Legal Entity Identifier Code

        if (jsonObject.get("legalEntityIdentifierCode") != null) {
            field.setComponent2(jsonObject.get("legalEntityIdentifierCode").getAsString());
        }

        // **** COMPONENT 3 - Legal Entity Identifier Number

        if (jsonObject.get("legalEntityIdentifierNumber") != null) {
            field.setComponent3(jsonObject.get("legalEntityIdentifierNumber").getAsString());
        }

        return field;
    }


	/**
	 * Component number for the Legal Entity Identifier
	 *
	 * <em>IMPORTANT</em>: this constant is kept for (future) compatibility, but getting component 2
	 * will return only part of the Legal Entity Identifier (the Code).
     * @since 9.2.7
	 */
	public static final Integer LEGAL_ENTITY_IDENTIFIER = 2;

	/**
	 * Gets the Legal Entity Identifier (components 2 and 3) as a unit
	 *
	 * <em>Note</em> this method was created for (future) compatibility.
	 *
	 * @return the concatenated values of component 2 and 3
     * @since 9.2.7
	 */
	public String getLegalEntityIdentifier() {

        // if both empty => just nothing
        if (StringUtils.isBlank(getComponent2()) && StringUtils.isBlank(getComponent3())) {
            return null;
        }

        // build
        final StringBuilder result = new StringBuilder();
        append(result, 2);
        append(result, 3);
        return result.toString();
	}

	/**
	 * Sets the Legal Entity Identifier (components 2 and 3) as a unit
	 *
	 * <em>Note</em> this method was created for (future) compatibility.
     *
	 * @param legalEntityIdentifier the new expected value for components 2 and 3 concatenated
     * @return the field object to enable build pattern
     * @since 9.2.7
	 */
	public Field95L setLegalEntityIdentifier(final String legalEntityIdentifier) {

        setComponent2(null);
        setComponent3( (String) null);
        if (legalEntityIdentifier != null) {
            setComponent2(StringUtils.substring(legalEntityIdentifier, 0, 18));
            if (legalEntityIdentifier.length() > 18) {
                setComponent3(StringUtils.substring(legalEntityIdentifier, 18));
            }
        }
        return this;
	}

}
