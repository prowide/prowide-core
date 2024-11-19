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

import com.prowidesoftware.swift.model.MIR;
import java.util.Calendar;


import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 280.
 * <p>
 * Model and parser for field 280 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: InputTime: <code>Calendar</code></li>
 * 		<li>Component 2: MIR: <code>MIR</code></li>
 * 		<li>Component 3: Accepted: <code>Boolean</code></li>
 * 		<li>Component 4: Error: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;HHMM&gt;&lt;MIR&gt;1!a&lt;?&gt;</code></li>
 * 		<li>parser pattern: <code>&lt;HHMM&gt;&lt;MIR&gt;cS</code></li>
 * 		<li>components pattern: <code>HRLS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field280 extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 280.
	 */
    public static final String NAME = "280";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_280 = "280";

	/**
	 * Component number for the Input Time subfield.
	 */
	public static final Integer INPUT_TIME = 1;

	/**
	 * Component number for the MIR subfield.
	 */
	public static final Integer MIR = 2;

	/**
	 * Component number for the Accepted subfield.
	 */
	public static final Integer ACCEPTED = 3;

	/**
	 * Component number for the Error subfield.
	 */
	public static final Integer ERROR = 4;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field280() {
        super(4);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field280(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field280(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "280")) {
            throw new IllegalArgumentException("cannot create field 280 from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field280 newInstance(Field280 source) {
        Field280 cp = new Field280();
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
        if (value != null) {
            if (value.length() >= 4) {
                setComponent1(StringUtils.substring(value, 0, 4));
            }
            if (value.length() >= 32) {
                setComponent2(StringUtils.substring(value, 4, 32));
            }
            if (value.length() >= 33) {
                setComponent3(StringUtils.substring(value, 32, 33));
            }
            if (value.length() > 33) {
                setComponent4(StringUtils.substring(value, 33));
            }
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
        if (component < 1 || component > 4) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 280");
        }
        if (component == 1) {
            //time: HH[mm]
            java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
            java.util.Calendar cal = getComponent1AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
        }
        if (component == 2) {
            //default format (as is)
            return getComponent(2);
        }
        if (component == 3) {
            //default format (as is)
            return getComponent(3);
        }
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(4);
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
        return "HRLS";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "<HHMM><MIR>cS";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "<HHMM><MIR>1!a<?>";
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
        result.add("Input Time");
        result.add("MIR");
        result.add("Accepted");
        result.add("Error");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "inputTime");
        result.put(2, "mIR");
        result.put(3, "accepted");
        result.put(4, "error");
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
        super.labelMap.put("inputtime", 1);
        super.labelMap.put("mir", 2);
        super.labelMap.put("accepted", 3);
        super.labelMap.put("error", 4);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Input Time).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Get the component 1 as Calendar
     *
     * @return the component 1 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent1AsCalendar() {
        return SwiftFormatUtils.getTime3(getComponent(1));
    }

    /**
     * Gets the Input Time (component 1).
     * @return the Input Time from component 1
     */
    public String getInputTime() {
        return getComponent1();
    }

    /**
     * Get the Input Time (component 1) as Calendar
     * @return the Input Time from component 1 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getInputTimeAsCalendar() {
        return getComponent1AsCalendar();
    }

    /**
     * Gets the component 2 (MIR).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Get the component 2 as MIR
     *
     * @return the component 2 converted to MIR or null if cannot be converted
     */
    public com.prowidesoftware.swift.model.MIR getComponent2AsMIR() {
        return SwiftFormatUtils.getMIR(getComponent(2));
    }

    /**
     * Gets the MIR (component 2).
     * @return the MIR from component 2
     */
    public String getMIR() {
        return getComponent2();
    }

    /**
     * Get the MIR (component 2) as MIR
     * @return the MIR from component 2 converted to MIR or null if cannot be converted
     */
    public com.prowidesoftware.swift.model.MIR getMIRAsMIR() {
        return getComponent2AsMIR();
    }

    /**
     * Gets the component 3 (Accepted).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Get the component 3 as Boolean
     *
     * @return the component 3 converted to Boolean or null if cannot be converted
     */
    public java.lang.Boolean getComponent3AsBoolean() {
        return SwiftFormatUtils.getBoolean(getComponent(3));
    }

    /**
     * Gets the Accepted (component 3).
     * @return the Accepted from component 3
     */
    public String getAccepted() {
        return getComponent3();
    }

    /**
     * Get the Accepted (component 3) as Boolean
     * @return the Accepted from component 3 converted to Boolean or null if cannot be converted
     */
    public java.lang.Boolean getAcceptedAsBoolean() {
        return getComponent3AsBoolean();
    }

    /**
     * Gets the component 4 (Error).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the Error (component 4).
     * @return the Error from component 4
     */
    public String getError() {
        return getComponent4();
    }

    /**
     * Set the component 1 (Input Time).
     *
     * @param component1 the Input Time to set
     * @return the field object to enable build pattern
     */
    public Field280 setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the component1 from a Calendar object.
     *
     * @param component1 the Calendar with the Input Time content to set
     * @return the field object to enable build pattern
     */
    public Field280 setComponent1(java.util.Calendar component1) {
        setComponent(1, SwiftFormatUtils.getTime3(component1));
        return this;
    }

    /**
     * Set the Input Time (component 1).
     *
     * @param component1 the Input Time to set
     * @return the field object to enable build pattern
     */
    public Field280 setInputTime(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the Input Time (component 1) from a Calendar object.
     *
     * @see #setComponent1(java.util.Calendar)
     *
     * @param component1 Calendar with the Input Time content to set
     * @return the field object to enable build pattern
     */
    public Field280 setInputTime(java.util.Calendar component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (MIR).
     *
     * @param component2 the MIR to set
     * @return the field object to enable build pattern
     */
    public Field280 setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a MIR object.
     *
     * @param component2 the MIR with the MIR content to set
     * @return the field object to enable build pattern
     */
    public Field280 setComponent2(com.prowidesoftware.swift.model.MIR component2) {
        setComponent(2, SwiftFormatUtils.getMIR(component2));
        return this;
    }

    /**
     * Set the MIR (component 2).
     *
     * @param component2 the MIR to set
     * @return the field object to enable build pattern
     */
    public Field280 setMIR(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the MIR (component 2) from a MIR object.
     *
     * @see #setComponent2(com.prowidesoftware.swift.model.MIR)
     *
     * @param component2 MIR with the MIR content to set
     * @return the field object to enable build pattern
     */
    public Field280 setMIR(com.prowidesoftware.swift.model.MIR component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Accepted).
     *
     * @param component3 the Accepted to set
     * @return the field object to enable build pattern
     */
    public Field280 setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a Boolean object.
     *
     * @param component3 the Boolean with the Accepted content to set
     * @return the field object to enable build pattern
     */
    public Field280 setComponent3(java.lang.Boolean component3) {
        setComponent(3, SwiftFormatUtils.getBoolean(component3));
        return this;
    }

    /**
     * Set the Accepted (component 3).
     *
     * @param component3 the Accepted to set
     * @return the field object to enable build pattern
     */
    public Field280 setAccepted(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Accepted (component 3) from a Boolean object.
     *
     * @see #setComponent3(java.lang.Boolean)
     *
     * @param component3 Boolean with the Accepted content to set
     * @return the field object to enable build pattern
     */
    public Field280 setAccepted(java.lang.Boolean component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Error).
     *
     * @param component4 the Error to set
     * @return the field object to enable build pattern
     */
    public Field280 setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the Error (component 4).
     *
     * @param component4 the Error to set
     * @return the field object to enable build pattern
     */
    public Field280 setError(String component4) {
        return setComponent4(component4);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field280.NAME
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
    public static Field280 get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field280(t);
    }

    /**
     * Gets the first instance of Field280 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field280 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field280 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field280> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field280 from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field280> getAll(final SwiftTagListBlock block) {
        final List<Field280> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field280(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field280 object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field280 fromJson(final String json) {

        final Field280 field = new Field280();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Input Time

        if (jsonObject.get("inputTime") != null) {
            field.setComponent1(jsonObject.get("inputTime").getAsString());
        }

        // **** COMPONENT 2 - MIR

        if (jsonObject.get("mIR") != null) {
            field.setComponent2(jsonObject.get("mIR").getAsString());
        }

        // **** COMPONENT 3 - Accepted

        if (jsonObject.get("accepted") != null) {
            field.setComponent3(jsonObject.get("accepted").getAsString());
        }

        // **** COMPONENT 4 - Error

        if (jsonObject.get("error") != null) {
            field.setComponent4(jsonObject.get("error").getAsString());
        }

        return field;
    }


}
