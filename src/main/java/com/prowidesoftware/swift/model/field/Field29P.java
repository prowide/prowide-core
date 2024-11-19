/*
 * Copyright 2006-2023 Prowide
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

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.model.BIC;
import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

/**
 * SWIFT MT Field 29P.
 * <p>
 * Model and parser for field 29P of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: IdentifierCode: <code>BIC</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;BIC&gt;</code></li>
 * 		<li>parser pattern: <code>S</code></li>
 * 		<li>components pattern: <code>B</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2022</strong>
 *
 * @deprecated This field has been moved to the Prowide Integrator since it is only used in SCORE messages, not in the general MT standard
 */
@Deprecated
@ProwideDeprecated(phase4 = TargetYear.SRU2025)
public class Field29P extends Field implements Serializable, BICContainer {
    /**
     * Constant identifying the SRU to which this class belongs to.
     */
    public static final int SRU = 2022;

    private static final long serialVersionUID = 1L;
    /**
     * Constant with the field name 29P.
     */
    public static final String NAME = "29P";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_29P = "29P";

    /**
     * Component number for the IdentifierCode subfield.
     */
    public static final Integer IDENTIFIERCODE = 1;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field29P() {
        super(1);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field29P(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field29P(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "29P")) {
            throw new IllegalArgumentException("cannot create field 29P from tag " + tag.getName()
                    + ", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field29P newInstance(Field29P source) {
        Field29P cp = new Field29P();
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
        if (component != 1) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 29P");
        }
        // default format (as is)
        return getComponent(1);
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
        return "B";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "S";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "<BIC>";
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
    public List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("IdentifierCode");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "identifierCode");
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
        super.labelMap.put("identifiercode", 1);
        // alias name
        super.labelMap.put("bic", 1);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (IdentifierCode).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Get the component 1 as BIC
     *
     * @return the component 1 converted to BIC or null if cannot be converted
     */
    public com.prowidesoftware.swift.model.BIC getComponent1AsBIC() {
        return SwiftFormatUtils.getBIC(getComponent(1));
    }

    /**
     * Gets the IdentifierCode (component 1).
     * @return the IdentifierCode from component 1
     */
    public String getIdentifierCode() {
        return getComponent1();
    }

    /**
     * Get the IdentifierCode (component 1) as BIC
     * @return the IdentifierCode from component 1 converted to BIC or null if cannot be converted
     */
    public com.prowidesoftware.swift.model.BIC getIdentifierCodeAsBIC() {
        return getComponent1AsBIC();
    }

    /**
     * Set the component 1 (IdentifierCode).
     *
     * @param component1 the IdentifierCode to set
     * @return the field object to enable build pattern
     */
    public Field29P setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the component1 from a BIC object.
     *
     * @param component1 the BIC with the IdentifierCode content to set
     * @return the field object to enable build pattern
     */
    public Field29P setComponent1(com.prowidesoftware.swift.model.BIC component1) {
        setComponent(1, SwiftFormatUtils.getBIC(component1));
        return this;
    }

    /**
     * Set the IdentifierCode (component 1).
     *
     * @param component1 the IdentifierCode to set
     * @return the field object to enable build pattern
     */
    public Field29P setIdentifierCode(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the IdentifierCode (component 1) from a BIC object.
     *
     * @see #setComponent1(com.prowidesoftware.swift.model.BIC)
     *
     * @param component1 BIC with the IdentifierCode content to set
     * @return the field object to enable build pattern
     */
    public Field29P setIdentifierCode(com.prowidesoftware.swift.model.BIC component1) {
        return setComponent1(component1);
    }

    @Override
    public List<BIC> bics() {
        return BICResolver.bics(this);
    }

    @Override
    public List<String> bicStrings() {
        return BICResolver.bicStrings(this);
    }

    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field29P.NAME
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
    public static Field29P get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field29P(t);
    }

    /**
     * Gets the first instance of Field29P in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field29P get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field29P in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field29P> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field29P from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field29P> getAll(final SwiftTagListBlock block) {
        final List<Field29P> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field29P(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field29P object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field29P fromJson(final String json) {

        final Field29P field = new Field29P();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - IdentifierCode

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("bIC") != null) {
            field.setComponent1(jsonObject.get("bIC").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("identifierCode") != null) {
            field.setComponent1(jsonObject.get("identifierCode").getAsString());
        }

        return field;
    }
}
