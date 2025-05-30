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

import com.prowidesoftware.swift.model.BIC;

import com.prowidesoftware.swift.model.field.BICContainer;
import com.prowidesoftware.swift.model.field.BICResolver;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 128.
 * <p>
 * Model and parser for field 128 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Priority: <code>Character</code></li>
 * 		<li>Component 2: BIC: <code>BIC</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>1a/&lt;BIC&gt;</code></li>
 * 		<li>parser pattern: <code>S/S</code></li>
 * 		<li>components pattern: <code>cB</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field128 extends Field implements Serializable, BICContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 128.
	 */
    public static final String NAME = "128";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_128 = "128";

	/**
	 * Component number for the Priority subfield.
	 */
	public static final Integer PRIORITY = 1;

	/**
	 * Component number for the BIC subfield.
	 */
	public static final Integer BIC = 2;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field128() {
        super(2);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field128(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field128(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "128")) {
            throw new IllegalArgumentException("cannot create field 128 from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field128 newInstance(Field128 source) {
        Field128 cp = new Field128();
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 128");
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
        return "cB";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "S/S";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "1a/<BIC>";
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
        result.add("Priority");
        result.add("BIC");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "priority");
        result.put(2, "bIC");
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
        super.labelMap.put("priority", 1);
        super.labelMap.put("bic", 2);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Priority).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Priority (component 1).
     * @return the Priority from component 1
     */
    public String getPriority() {
        return getComponent1();
    }

    /**
     * Gets the component 2 (BIC).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Get the component 2 as BIC
     *
     * @return the component 2 converted to BIC or null if cannot be converted
     */
    public com.prowidesoftware.swift.model.BIC getComponent2AsBIC() {
        return SwiftFormatUtils.getBIC(getComponent(2));
    }

    /**
     * Gets the BIC (component 2).
     * @return the BIC from component 2
     */
    public String getBIC() {
        return getComponent2();
    }

    /**
     * Get the BIC (component 2) as BIC
     * @return the BIC from component 2 converted to BIC or null if cannot be converted
     */
    public com.prowidesoftware.swift.model.BIC getBICAsBIC() {
        return getComponent2AsBIC();
    }

    /**
     * Set the component 1 (Priority).
     *
     * @param component1 the Priority to set
     * @return the field object to enable build pattern
     */
    public Field128 setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Priority (component 1).
     *
     * @param component1 the Priority to set
     * @return the field object to enable build pattern
     */
    public Field128 setPriority(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (BIC).
     *
     * @param component2 the BIC to set
     * @return the field object to enable build pattern
     */
    public Field128 setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a BIC object.
     *
     * @param component2 the BIC with the BIC content to set
     * @return the field object to enable build pattern
     */
    public Field128 setComponent2(com.prowidesoftware.swift.model.BIC component2) {
        setComponent(2, SwiftFormatUtils.getBIC(component2));
        return this;
    }

    /**
     * Set the BIC (component 2).
     *
     * @param component2 the BIC to set
     * @return the field object to enable build pattern
     */
    public Field128 setBIC(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the BIC (component 2) from a BIC object.
     *
     * @see #setComponent2(com.prowidesoftware.swift.model.BIC)
     *
     * @param component2 BIC with the BIC content to set
     * @return the field object to enable build pattern
     */
    public Field128 setBIC(com.prowidesoftware.swift.model.BIC component2) {
        return setComponent2(component2);
    }


    @Override
    public List<BIC> bics() {
        return BICResolver.bics(this);
    }

    @Override
    public List<String> bicStrings () {
        return BICResolver.bicStrings(this);
    }


    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field128.NAME
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
    public static Field128 get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field128(t);
    }

    /**
     * Gets the first instance of Field128 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field128 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field128 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field128> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field128 from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field128> getAll(final SwiftTagListBlock block) {
        final List<Field128> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field128(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field128 object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field128 fromJson(final String json) {

        final Field128 field = new Field128();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Priority

        if (jsonObject.get("priority") != null) {
            field.setComponent1(jsonObject.get("priority").getAsString());
        }

        // **** COMPONENT 2 - BIC

        if (jsonObject.get("bIC") != null) {
            field.setComponent2(jsonObject.get("bIC").getAsString());
        }

        return field;
    }


}
