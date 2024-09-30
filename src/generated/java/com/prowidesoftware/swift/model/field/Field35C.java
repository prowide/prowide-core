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



import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 35C.
 * <p>
 * Model and parser for field 35C of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: IdentificationOfInstrument: <code>String</code></li>
 * 		<li>Component 2: DescriptionOfInstrument: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;VAR-SEQU-5&gt;</code></li>
 * 		<li>parser pattern: <code>S[/S]</code></li>
 * 		<li>components pattern: <code>SS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field35C extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 35C.
	 */
    public static final String NAME = "35C";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_35C = "35C";

	/**
	 * Component number for the Identification Of Instrument subfield.
	 */
	public static final Integer IDENTIFICATION_OF_INSTRUMENT = 1;

	/**
	 * Component number for the Description Of Instrument subfield.
	 */
	public static final Integer DESCRIPTION_OF_INSTRUMENT = 2;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field35C() {
        super(2);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field35C(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field35C(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "35C")) {
            throw new IllegalArgumentException("cannot create field 35C from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field35C newInstance(Field35C source) {
        Field35C cp = new Field35C();
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
        if (getComponent2() != null) {
            result.append("/").append(getComponent2());
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
        if (component < 1 || component > 2) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 35C");
        }
        if (component == 1) {
            //default format (as is)
            return getComponent(1);
        }
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(2);
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
        return "SS";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "S[/S]";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "<VAR-SEQU-5>";
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
        result.add("Identification Of Instrument");
        result.add("Description Of Instrument");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "identificationOfInstrument");
        result.put(2, "descriptionOfInstrument");
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
        super.labelMap.put("identificationofinstrument", 1);
        super.labelMap.put("descriptionofinstrument", 2);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Identification Of Instrument).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Identification Of Instrument (component 1).
     * @return the Identification Of Instrument from component 1
     */
    public String getIdentificationOfInstrument() {
        return getComponent1();
    }

    /**
     * Gets the component 2 (Description Of Instrument).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Description Of Instrument (component 2).
     * @return the Description Of Instrument from component 2
     */
    public String getDescriptionOfInstrument() {
        return getComponent2();
    }

    /**
     * Set the component 1 (Identification Of Instrument).
     *
     * @param component1 the Identification Of Instrument to set
     * @return the field object to enable build pattern
     */
    public Field35C setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Identification Of Instrument (component 1).
     *
     * @param component1 the Identification Of Instrument to set
     * @return the field object to enable build pattern
     */
    public Field35C setIdentificationOfInstrument(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Description Of Instrument).
     *
     * @param component2 the Description Of Instrument to set
     * @return the field object to enable build pattern
     */
    public Field35C setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Description Of Instrument (component 2).
     *
     * @param component2 the Description Of Instrument to set
     * @return the field object to enable build pattern
     */
    public Field35C setDescriptionOfInstrument(String component2) {
        return setComponent2(component2);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field35C.NAME
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
    public static Field35C get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field35C(t);
    }

    /**
     * Gets the first instance of Field35C in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field35C get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field35C in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field35C> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field35C from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field35C> getAll(final SwiftTagListBlock block) {
        final List<Field35C> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field35C(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field35C object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field35C fromJson(final String json) {

        final Field35C field = new Field35C();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Identification Of Instrument

        if (jsonObject.get("identificationOfInstrument") != null) {
            field.setComponent1(jsonObject.get("identificationOfInstrument").getAsString());
        }

        // **** COMPONENT 2 - Description Of Instrument

        if (jsonObject.get("descriptionOfInstrument") != null) {
            field.setComponent2(jsonObject.get("descriptionOfInstrument").getAsString());
        }

        return field;
    }


}
