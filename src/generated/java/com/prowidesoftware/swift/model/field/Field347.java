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
 * SWIFT MT Field 347.
 * <p>
 * Model and parser for field 347 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Field1: <code>String</code></li>
 * 		<li>Component 2: Field2: <code>String</code></li>
 * 		<li>Component 3: Field3: <code>String</code></li>
 * 		<li>Component 4: Field4: <code>String</code></li>
 * 		<li>Component 5: Field5: <code>String</code></li>
 * 		<li>Component 6: Field6: <code>String</code></li>
 * 		<li>Component 7: Field7: <code>String</code></li>
 * 		<li>Component 8: Field8: <code>String</code></li>
 * 		<li>Component 9: Field9: <code>String</code></li>
 * 		<li>Component 10: Field10: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>[3!c]*10</code></li>
 * 		<li>parser pattern: <code>3!S*10</code></li>
 * 		<li>components pattern: <code>SSSSSSSSSS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field347 extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 347.
	 */
    public static final String NAME = "347";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_347 = "347";

	/**
	 * Component number for the Field 1 subfield.
	 */
	public static final Integer FIELD_1 = 1;

	/**
	 * Component number for the Field 2 subfield.
	 */
	public static final Integer FIELD_2 = 2;

	/**
	 * Component number for the Field 3 subfield.
	 */
	public static final Integer FIELD_3 = 3;

	/**
	 * Component number for the Field 4 subfield.
	 */
	public static final Integer FIELD_4 = 4;

	/**
	 * Component number for the Field 5 subfield.
	 */
	public static final Integer FIELD_5 = 5;

	/**
	 * Component number for the Field 6 subfield.
	 */
	public static final Integer FIELD_6 = 6;

	/**
	 * Component number for the Field 7 subfield.
	 */
	public static final Integer FIELD_7 = 7;

	/**
	 * Component number for the Field 8 subfield.
	 */
	public static final Integer FIELD_8 = 8;

	/**
	 * Component number for the Field 9 subfield.
	 */
	public static final Integer FIELD_9 = 9;

	/**
	 * Component number for the Field 10 subfield.
	 */
	public static final Integer FIELD_10 = 10;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field347() {
        super(10);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field347(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field347(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "347")) {
            throw new IllegalArgumentException("cannot create field 347 from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field347 newInstance(Field347 source) {
        Field347 cp = new Field347();
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
        init(10);
        if (value != null) {
            SwiftParseUtils.setComponentsFromTokens(this, 1, 10, 3, value);
        }
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        result.append(joinComponents());
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
        if (component < 1 || component > 10) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 347");
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
            //default format (as is)
            return getComponent(5);
        }
        if (component == 6) {
            //default format (as is)
            return getComponent(6);
        }
        if (component == 7) {
            //default format (as is)
            return getComponent(7);
        }
        if (component == 8) {
            //default format (as is)
            return getComponent(8);
        }
        if (component == 9) {
            //default format (as is)
            return getComponent(9);
        }
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(10);
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
        return "SSSSSSSSSS";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "3!S*10";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "[3!c]*10";
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
        return 10;
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
        result.add("Field 1");
        result.add("Field 2");
        result.add("Field 3");
        result.add("Field 4");
        result.add("Field 5");
        result.add("Field 6");
        result.add("Field 7");
        result.add("Field 8");
        result.add("Field 9");
        result.add("Field 10");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "field1");
        result.put(2, "field2");
        result.put(3, "field3");
        result.put(4, "field4");
        result.put(5, "field5");
        result.put(6, "field6");
        result.put(7, "field7");
        result.put(8, "field8");
        result.put(9, "field9");
        result.put(10, "field10");
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
        super.labelMap.put("field1", 1);
        super.labelMap.put("field2", 2);
        super.labelMap.put("field3", 3);
        super.labelMap.put("field4", 4);
        super.labelMap.put("field5", 5);
        super.labelMap.put("field6", 6);
        super.labelMap.put("field7", 7);
        super.labelMap.put("field8", 8);
        super.labelMap.put("field9", 9);
        super.labelMap.put("field10", 10);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Field 1).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Field 1 (component 1).
     * @return the Field 1 from component 1
     */
    public String getField1() {
        return getComponent1();
    }

    /**
     * Gets the component 2 (Field 2).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Field 2 (component 2).
     * @return the Field 2 from component 2
     */
    public String getField2() {
        return getComponent2();
    }

    /**
     * Gets the component 3 (Field 3).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Field 3 (component 3).
     * @return the Field 3 from component 3
     */
    public String getField3() {
        return getComponent3();
    }

    /**
     * Gets the component 4 (Field 4).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the Field 4 (component 4).
     * @return the Field 4 from component 4
     */
    public String getField4() {
        return getComponent4();
    }

    /**
     * Gets the component 5 (Field 5).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Gets the Field 5 (component 5).
     * @return the Field 5 from component 5
     */
    public String getField5() {
        return getComponent5();
    }

    /**
     * Gets the component 6 (Field 6).
     * @return the component 6
     */
    public String getComponent6() {
        return getComponent(6);
    }

    /**
     * Gets the Field 6 (component 6).
     * @return the Field 6 from component 6
     */
    public String getField6() {
        return getComponent6();
    }

    /**
     * Gets the component 7 (Field 7).
     * @return the component 7
     */
    public String getComponent7() {
        return getComponent(7);
    }

    /**
     * Gets the Field 7 (component 7).
     * @return the Field 7 from component 7
     */
    public String getField7() {
        return getComponent7();
    }

    /**
     * Gets the component 8 (Field 8).
     * @return the component 8
     */
    public String getComponent8() {
        return getComponent(8);
    }

    /**
     * Gets the Field 8 (component 8).
     * @return the Field 8 from component 8
     */
    public String getField8() {
        return getComponent8();
    }

    /**
     * Gets the component 9 (Field 9).
     * @return the component 9
     */
    public String getComponent9() {
        return getComponent(9);
    }

    /**
     * Gets the Field 9 (component 9).
     * @return the Field 9 from component 9
     */
    public String getField9() {
        return getComponent9();
    }

    /**
     * Gets the component 10 (Field 10).
     * @return the component 10
     */
    public String getComponent10() {
        return getComponent(10);
    }

    /**
     * Gets the Field 10 (component 10).
     * @return the Field 10 from component 10
     */
    public String getField10() {
        return getComponent10();
    }

    /**
     * Set the component 1 (Field 1).
     *
     * @param component1 the Field 1 to set
     * @return the field object to enable build pattern
     */
    public Field347 setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Field 1 (component 1).
     *
     * @param component1 the Field 1 to set
     * @return the field object to enable build pattern
     */
    public Field347 setField1(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Field 2).
     *
     * @param component2 the Field 2 to set
     * @return the field object to enable build pattern
     */
    public Field347 setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Field 2 (component 2).
     *
     * @param component2 the Field 2 to set
     * @return the field object to enable build pattern
     */
    public Field347 setField2(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Field 3).
     *
     * @param component3 the Field 3 to set
     * @return the field object to enable build pattern
     */
    public Field347 setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Field 3 (component 3).
     *
     * @param component3 the Field 3 to set
     * @return the field object to enable build pattern
     */
    public Field347 setField3(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Field 4).
     *
     * @param component4 the Field 4 to set
     * @return the field object to enable build pattern
     */
    public Field347 setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the Field 4 (component 4).
     *
     * @param component4 the Field 4 to set
     * @return the field object to enable build pattern
     */
    public Field347 setField4(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Field 5).
     *
     * @param component5 the Field 5 to set
     * @return the field object to enable build pattern
     */
    public Field347 setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the Field 5 (component 5).
     *
     * @param component5 the Field 5 to set
     * @return the field object to enable build pattern
     */
    public Field347 setField5(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the component 6 (Field 6).
     *
     * @param component6 the Field 6 to set
     * @return the field object to enable build pattern
     */
    public Field347 setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }

    /**
     * Set the Field 6 (component 6).
     *
     * @param component6 the Field 6 to set
     * @return the field object to enable build pattern
     */
    public Field347 setField6(String component6) {
        return setComponent6(component6);
    }

    /**
     * Set the component 7 (Field 7).
     *
     * @param component7 the Field 7 to set
     * @return the field object to enable build pattern
     */
    public Field347 setComponent7(String component7) {
        setComponent(7, component7);
        return this;
    }

    /**
     * Set the Field 7 (component 7).
     *
     * @param component7 the Field 7 to set
     * @return the field object to enable build pattern
     */
    public Field347 setField7(String component7) {
        return setComponent7(component7);
    }

    /**
     * Set the component 8 (Field 8).
     *
     * @param component8 the Field 8 to set
     * @return the field object to enable build pattern
     */
    public Field347 setComponent8(String component8) {
        setComponent(8, component8);
        return this;
    }

    /**
     * Set the Field 8 (component 8).
     *
     * @param component8 the Field 8 to set
     * @return the field object to enable build pattern
     */
    public Field347 setField8(String component8) {
        return setComponent8(component8);
    }

    /**
     * Set the component 9 (Field 9).
     *
     * @param component9 the Field 9 to set
     * @return the field object to enable build pattern
     */
    public Field347 setComponent9(String component9) {
        setComponent(9, component9);
        return this;
    }

    /**
     * Set the Field 9 (component 9).
     *
     * @param component9 the Field 9 to set
     * @return the field object to enable build pattern
     */
    public Field347 setField9(String component9) {
        return setComponent9(component9);
    }

    /**
     * Set the component 10 (Field 10).
     *
     * @param component10 the Field 10 to set
     * @return the field object to enable build pattern
     */
    public Field347 setComponent10(String component10) {
        setComponent(10, component10);
        return this;
    }

    /**
     * Set the Field 10 (component 10).
     *
     * @param component10 the Field 10 to set
     * @return the field object to enable build pattern
     */
    public Field347 setField10(String component10) {
        return setComponent10(component10);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field347.NAME
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
    public static Field347 get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field347(t);
    }

    /**
     * Gets the first instance of Field347 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field347 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field347 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field347> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field347 from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field347> getAll(final SwiftTagListBlock block) {
        final List<Field347> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field347(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field347 object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field347 fromJson(final String json) {

        final Field347 field = new Field347();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Field 1

        if (jsonObject.get("field1") != null) {
            field.setComponent1(jsonObject.get("field1").getAsString());
        }

        // **** COMPONENT 2 - Field 2

        if (jsonObject.get("field2") != null) {
            field.setComponent2(jsonObject.get("field2").getAsString());
        }

        // **** COMPONENT 3 - Field 3

        if (jsonObject.get("field3") != null) {
            field.setComponent3(jsonObject.get("field3").getAsString());
        }

        // **** COMPONENT 4 - Field 4

        if (jsonObject.get("field4") != null) {
            field.setComponent4(jsonObject.get("field4").getAsString());
        }

        // **** COMPONENT 5 - Field 5

        if (jsonObject.get("field5") != null) {
            field.setComponent5(jsonObject.get("field5").getAsString());
        }

        // **** COMPONENT 6 - Field 6

        if (jsonObject.get("field6") != null) {
            field.setComponent6(jsonObject.get("field6").getAsString());
        }

        // **** COMPONENT 7 - Field 7

        if (jsonObject.get("field7") != null) {
            field.setComponent7(jsonObject.get("field7").getAsString());
        }

        // **** COMPONENT 8 - Field 8

        if (jsonObject.get("field8") != null) {
            field.setComponent8(jsonObject.get("field8").getAsString());
        }

        // **** COMPONENT 9 - Field 9

        if (jsonObject.get("field9") != null) {
            field.setComponent9(jsonObject.get("field9").getAsString());
        }

        // **** COMPONENT 10 - Field 10

        if (jsonObject.get("field10") != null) {
            field.setComponent10(jsonObject.get("field10").getAsString());
        }

        return field;
    }


}
