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
 * SWIFT MT Field 252.
 * <p>
 * Model and parser for field 252 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: StartMIR: <code>MIR</code></li>
 * 		<li>Component 2: EndMIR: <code>MIR</code></li>
 * 		<li>Component 3: StartTime: <code>Calendar</code></li>
 * 		<li>Component 4: EndTime: <code>Calendar</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;MIR&gt;&lt;MIR&gt;[&lt;HHMM&gt;&lt;HHMM&gt;]</code></li>
 * 		<li>parser pattern: <code>&lt;MIR&gt;&lt;MIR&gt;[&lt;HHMM&gt;&lt;HHMM&gt;]</code></li>
 * 		<li>components pattern: <code>RRHH</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field252 extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 252.
	 */
    public static final String NAME = "252";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_252 = "252";

	/**
	 * Component number for the Start MIR subfield.
	 */
	public static final Integer START_MIR = 1;

	/**
	 * Component number for the End MIR subfield.
	 */
	public static final Integer END_MIR = 2;

	/**
	 * Component number for the Start Time subfield.
	 */
	public static final Integer START_TIME = 3;

	/**
	 * Component number for the End Time subfield.
	 */
	public static final Integer END_TIME = 4;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field252() {
        super(4);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field252(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field252(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "252")) {
            throw new IllegalArgumentException("cannot create field 252 from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field252 newInstance(Field252 source) {
        Field252 cp = new Field252();
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
            if (value.length() >= 28) {
                setComponent1(StringUtils.substring(value, 0, 28));
            }
            if (value.length() >= 56) {
                setComponent2(StringUtils.substring(value, 28, 56));
            }
            if (value.length() >= 60) {
                setComponent3(StringUtils.substring(value, 56, 60));
            }
            if (value.length() > 60) {
                setComponent4(StringUtils.substring(value, 60));
            }
        }
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        append(result, 1);
        append(result, 2);
        append(result, 3);
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 252");
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
            //time: HH[mm]
            java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
            java.util.Calendar cal = getComponent3AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
        }
        // This is the last component, return directly without `if`
        //time: HH[mm]
        java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
        java.util.Calendar cal = getComponent4AsCalendar();
        if (cal != null) {
            return f.format(cal.getTime());
        }
        return null;
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
        return "RRHH";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "<MIR><MIR>[<HHMM><HHMM>]";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "<MIR><MIR>[<HHMM><HHMM>]";
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
        result.add("Start MIR");
        result.add("End MIR");
        result.add("Start Time");
        result.add("End Time");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "startMIR");
        result.put(2, "endMIR");
        result.put(3, "startTime");
        result.put(4, "endTime");
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
        super.labelMap.put("startmir", 1);
        super.labelMap.put("endmir", 2);
        super.labelMap.put("starttime", 3);
        super.labelMap.put("endtime", 4);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Start MIR).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Get the component 1 as MIR
     *
     * @return the component 1 converted to MIR or null if cannot be converted
     */
    public com.prowidesoftware.swift.model.MIR getComponent1AsMIR() {
        return SwiftFormatUtils.getMIR(getComponent(1));
    }

    /**
     * Gets the Start MIR (component 1).
     * @return the Start MIR from component 1
     */
    public String getStartMIR() {
        return getComponent1();
    }

    /**
     * Get the Start MIR (component 1) as MIR
     * @return the Start MIR from component 1 converted to MIR or null if cannot be converted
     */
    public com.prowidesoftware.swift.model.MIR getStartMIRAsMIR() {
        return getComponent1AsMIR();
    }

    /**
     * Gets the component 2 (End MIR).
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
     * Gets the End MIR (component 2).
     * @return the End MIR from component 2
     */
    public String getEndMIR() {
        return getComponent2();
    }

    /**
     * Get the End MIR (component 2) as MIR
     * @return the End MIR from component 2 converted to MIR or null if cannot be converted
     */
    public com.prowidesoftware.swift.model.MIR getEndMIRAsMIR() {
        return getComponent2AsMIR();
    }

    /**
     * Gets the component 3 (Start Time).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Get the component 3 as Calendar
     *
     * @return the component 3 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent3AsCalendar() {
        return SwiftFormatUtils.getTime3(getComponent(3));
    }

    /**
     * Gets the Start Time (component 3).
     * @return the Start Time from component 3
     */
    public String getStartTime() {
        return getComponent3();
    }

    /**
     * Get the Start Time (component 3) as Calendar
     * @return the Start Time from component 3 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getStartTimeAsCalendar() {
        return getComponent3AsCalendar();
    }

    /**
     * Gets the component 4 (End Time).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Get the component 4 as Calendar
     *
     * @return the component 4 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent4AsCalendar() {
        return SwiftFormatUtils.getTime3(getComponent(4));
    }

    /**
     * Gets the End Time (component 4).
     * @return the End Time from component 4
     */
    public String getEndTime() {
        return getComponent4();
    }

    /**
     * Get the End Time (component 4) as Calendar
     * @return the End Time from component 4 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getEndTimeAsCalendar() {
        return getComponent4AsCalendar();
    }

    /**
     * Set the component 1 (Start MIR).
     *
     * @param component1 the Start MIR to set
     * @return the field object to enable build pattern
     */
    public Field252 setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the component1 from a MIR object.
     *
     * @param component1 the MIR with the Start MIR content to set
     * @return the field object to enable build pattern
     */
    public Field252 setComponent1(com.prowidesoftware.swift.model.MIR component1) {
        setComponent(1, SwiftFormatUtils.getMIR(component1));
        return this;
    }

    /**
     * Set the Start MIR (component 1).
     *
     * @param component1 the Start MIR to set
     * @return the field object to enable build pattern
     */
    public Field252 setStartMIR(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the Start MIR (component 1) from a MIR object.
     *
     * @see #setComponent1(com.prowidesoftware.swift.model.MIR)
     *
     * @param component1 MIR with the Start MIR content to set
     * @return the field object to enable build pattern
     */
    public Field252 setStartMIR(com.prowidesoftware.swift.model.MIR component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (End MIR).
     *
     * @param component2 the End MIR to set
     * @return the field object to enable build pattern
     */
    public Field252 setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a MIR object.
     *
     * @param component2 the MIR with the End MIR content to set
     * @return the field object to enable build pattern
     */
    public Field252 setComponent2(com.prowidesoftware.swift.model.MIR component2) {
        setComponent(2, SwiftFormatUtils.getMIR(component2));
        return this;
    }

    /**
     * Set the End MIR (component 2).
     *
     * @param component2 the End MIR to set
     * @return the field object to enable build pattern
     */
    public Field252 setEndMIR(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the End MIR (component 2) from a MIR object.
     *
     * @see #setComponent2(com.prowidesoftware.swift.model.MIR)
     *
     * @param component2 MIR with the End MIR content to set
     * @return the field object to enable build pattern
     */
    public Field252 setEndMIR(com.prowidesoftware.swift.model.MIR component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Start Time).
     *
     * @param component3 the Start Time to set
     * @return the field object to enable build pattern
     */
    public Field252 setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a Calendar object.
     *
     * @param component3 the Calendar with the Start Time content to set
     * @return the field object to enable build pattern
     */
    public Field252 setComponent3(java.util.Calendar component3) {
        setComponent(3, SwiftFormatUtils.getTime3(component3));
        return this;
    }

    /**
     * Set the Start Time (component 3).
     *
     * @param component3 the Start Time to set
     * @return the field object to enable build pattern
     */
    public Field252 setStartTime(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Start Time (component 3) from a Calendar object.
     *
     * @see #setComponent3(java.util.Calendar)
     *
     * @param component3 Calendar with the Start Time content to set
     * @return the field object to enable build pattern
     */
    public Field252 setStartTime(java.util.Calendar component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (End Time).
     *
     * @param component4 the End Time to set
     * @return the field object to enable build pattern
     */
    public Field252 setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component4 from a Calendar object.
     *
     * @param component4 the Calendar with the End Time content to set
     * @return the field object to enable build pattern
     */
    public Field252 setComponent4(java.util.Calendar component4) {
        setComponent(4, SwiftFormatUtils.getTime3(component4));
        return this;
    }

    /**
     * Set the End Time (component 4).
     *
     * @param component4 the End Time to set
     * @return the field object to enable build pattern
     */
    public Field252 setEndTime(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the End Time (component 4) from a Calendar object.
     *
     * @see #setComponent4(java.util.Calendar)
     *
     * @param component4 Calendar with the End Time content to set
     * @return the field object to enable build pattern
     */
    public Field252 setEndTime(java.util.Calendar component4) {
        return setComponent4(component4);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field252.NAME
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
    public static Field252 get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field252(t);
    }

    /**
     * Gets the first instance of Field252 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field252 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field252 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field252> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field252 from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field252> getAll(final SwiftTagListBlock block) {
        final List<Field252> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field252(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field252 object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field252 fromJson(final String json) {

        final Field252 field = new Field252();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Start MIR

        if (jsonObject.get("startMIR") != null) {
            field.setComponent1(jsonObject.get("startMIR").getAsString());
        }

        // **** COMPONENT 2 - End MIR

        if (jsonObject.get("endMIR") != null) {
            field.setComponent2(jsonObject.get("endMIR").getAsString());
        }

        // **** COMPONENT 3 - Start Time

        if (jsonObject.get("startTime") != null) {
            field.setComponent3(jsonObject.get("startTime").getAsString());
        }

        // **** COMPONENT 4 - End Time

        if (jsonObject.get("endTime") != null) {
            field.setComponent4(jsonObject.get("endTime").getAsString());
        }

        return field;
    }


}
