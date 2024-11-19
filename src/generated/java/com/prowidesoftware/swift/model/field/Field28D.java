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


import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 28D.
 * <p>
 * Model and parser for field 28D of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: MessageIndex: <code>Long</code></li>
 * 		<li>Component 2: Total: <code>Long</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>5n/5n</code></li>
 * 		<li>parser pattern: <code>S/S</code></li>
 * 		<li>components pattern: <code>NN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field28D extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 28D.
	 */
    public static final String NAME = "28D";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_28D = "28D";

	/**
	 * Component number for the Message Index subfield.
	 */
	public static final Integer MESSAGE_INDEX = 1;


	/**
	 * Component number for the Total subfield.
	 */
	public static final Integer TOTAL = 2;


    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field28D() {
        super(2);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field28D(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field28D(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "28D")) {
            throw new IllegalArgumentException("cannot create field 28D from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field28D newInstance(Field28D source) {
        Field28D cp = new Field28D();
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 28D");
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
        return "NN";
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
        return "5n/5n";
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
        result.add("Message Index");
        result.add("Total");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "messageIndex");
        result.put(2, "total");
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
        super.labelMap.put("messageindex", 1);
        // alias name
        super.labelMap.put("statementnumber", 1);
        super.labelMap.put("total", 2);
        // alias name
        super.labelMap.put("sequencenumber", 2);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Message Index).
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
     * Gets the Message Index (component 1).
     * @return the Message Index from component 1
     */
    public String getMessageIndex() {
        return getComponent1();
    }


    /**
     * Get the Message Index (component 1) as Long
     * @return the Message Index from component 1 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getMessageIndexAsLong() {
        return getComponent1AsLong();
    }

    /**
     * Gets the component 2 (Total).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Get the component 2 as Long
     *
     * @return the component 2 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent2AsLong() {
        return SwiftFormatUtils.getLong(getComponent(2));
    }

    /**
     * Gets the Total (component 2).
     * @return the Total from component 2
     */
    public String getTotal() {
        return getComponent2();
    }


    /**
     * Get the Total (component 2) as Long
     * @return the Total from component 2 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getTotalAsLong() {
        return getComponent2AsLong();
    }

    /**
     * Set the component 1 (Message Index).
     *
     * @param component1 the Message Index to set
     * @return the field object to enable build pattern
     */
    public Field28D setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }


    /**
     * Alternative method setter for field's Message Index (component 1) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Message Index content to set
     * @return the field object to enable build pattern
     */
    public Field28D setComponent1(java.lang.Number component1) {

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
     * Set the Message Index (component 1).
     *
     * @param component1 the Message Index to set
     * @return the field object to enable build pattern
     */
    public Field28D setMessageIndex(String component1) {
        return setComponent1(component1);
    }

    /**
     * Alternative method setter for field's Message Index (component 1) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Message Index content to set
     * @return the field object to enable build pattern
     */
    public Field28D setMessageIndex(java.lang.Number component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Total).
     *
     * @param component2 the Total to set
     * @return the field object to enable build pattern
     */
    public Field28D setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }


    /**
     * Alternative method setter for field's Total (component 2) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the Total content to set
     * @return the field object to enable build pattern
     */
    public Field28D setComponent2(java.lang.Number component2) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component2 instanceof Long) {
            setComponent(2, SwiftFormatUtils.getLong((Long) component2));
        } else if (component2 instanceof BigInteger || component2 instanceof Integer) {
            setComponent(2, SwiftFormatUtils.getLong(component2.longValue()));
        } else if (component2 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(2, SwiftFormatUtils.getLong(component2.longValue()));
        } else {
            // explicitly set component as null
            setComponent(2, null);
        }
        return this;
    }

    /**
     * Set the Total (component 2).
     *
     * @param component2 the Total to set
     * @return the field object to enable build pattern
     */
    public Field28D setTotal(String component2) {
        return setComponent2(component2);
    }

    /**
     * Alternative method setter for field's Total (component 2) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the Total content to set
     * @return the field object to enable build pattern
     */
    public Field28D setTotal(java.lang.Number component2) {
        return setComponent2(component2);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field28D.NAME
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
    public static Field28D get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field28D(t);
    }

    /**
     * Gets the first instance of Field28D in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field28D get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field28D in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field28D> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field28D from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field28D> getAll(final SwiftTagListBlock block) {
        final List<Field28D> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field28D(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field28D object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field28D fromJson(final String json) {

        final Field28D field = new Field28D();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Message Index

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("statementNumber") != null) {
            field.setComponent1(jsonObject.get("statementNumber").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("messageIndex") != null) {
            field.setComponent1(jsonObject.get("messageIndex").getAsString());
        }

        // **** COMPONENT 2 - Total

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("sequenceNumber") != null) {
            field.setComponent2(jsonObject.get("sequenceNumber").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("total") != null) {
            field.setComponent2(jsonObject.get("total").getAsString());
        }

        return field;
    }


}
