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

import java.util.Calendar;


import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 29O.
 * <p>
 * Model and parser for field 29O of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Location: <code>String</code></li>
 * 		<li>Component 2: StartTime: <code>Calendar</code></li>
 * 		<li>Component 3: EndTime: <code>Calendar</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>4!c/&lt;HHMM&gt;&lt;HHMM&gt;</code></li>
 * 		<li>parser pattern: <code>S/&lt;HHMM&gt;&lt;HHMM&gt;</code></li>
 * 		<li>components pattern: <code>SHH</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field29O extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 29O.
	 */
    public static final String NAME = "29O";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_29O = "29O";

	/**
	 * Component number for the Location subfield.
	 */
	public static final Integer LOCATION = 1;

	/**
	 * Component number for the Start Time subfield.
	 */
	public static final Integer START_TIME = 2;

	/**
	 * Component number for the End Time subfield.
	 */
	public static final Integer END_TIME = 3;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field29O() {
        super(3);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field29O(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field29O(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "29O")) {
            throw new IllegalArgumentException("cannot create field 29O from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field29O newInstance(Field29O source) {
        Field29O cp = new Field29O();
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
        if (value != null) {
            setComponent1(SwiftParseUtils.getTokenFirst(value, "/"));
            String toparse = SwiftParseUtils.getTokenSecondLast(value, "/");
            if (toparse != null) {
                if (toparse.length() >= 1) {
                    int endIndex = Math.min(4, toparse.length());
                    setComponent2(StringUtils.substring(toparse, 0, endIndex));
                }
                if (toparse.length() > 4) {
                    setComponent3(StringUtils.substring(toparse, 4));
                }
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
        result.append("/");
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 29O");
        }
        if (component == 1) {
            //default format (as is)
            return getComponent(1);
        }
        if (component == 2) {
            //time: HH[mm]
            java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
            java.util.Calendar cal = getComponent2AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
        }
        // This is the last component, return directly without `if`
        //time: HH[mm]
        java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
        java.util.Calendar cal = getComponent3AsCalendar();
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
        return "SHH";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "S/<HHMM><HHMM>";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "4!c/<HHMM><HHMM>";
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
        result.add("Location");
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
        result.put(1, "location");
        result.put(2, "startTime");
        result.put(3, "endTime");
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
        super.labelMap.put("location", 1);
        super.labelMap.put("starttime", 2);
        super.labelMap.put("endtime", 3);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Location).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Location (component 1).
     * @return the Location from component 1
     */
    public String getLocation() {
        return getComponent1();
    }

    /**
     * Gets the component 2 (Start Time).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Get the component 2 as Calendar
     *
     * @return the component 2 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent2AsCalendar() {
        return SwiftFormatUtils.getTime3(getComponent(2));
    }

    /**
     * Gets the Start Time (component 2).
     * @return the Start Time from component 2
     */
    public String getStartTime() {
        return getComponent2();
    }

    /**
     * Get the Start Time (component 2) as Calendar
     * @return the Start Time from component 2 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getStartTimeAsCalendar() {
        return getComponent2AsCalendar();
    }

    /**
     * Gets the component 3 (End Time).
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
     * Gets the End Time (component 3).
     * @return the End Time from component 3
     */
    public String getEndTime() {
        return getComponent3();
    }

    /**
     * Get the End Time (component 3) as Calendar
     * @return the End Time from component 3 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getEndTimeAsCalendar() {
        return getComponent3AsCalendar();
    }

    /**
     * Set the component 1 (Location).
     *
     * @param component1 the Location to set
     * @return the field object to enable build pattern
     */
    public Field29O setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Location (component 1).
     *
     * @param component1 the Location to set
     * @return the field object to enable build pattern
     */
    public Field29O setLocation(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Start Time).
     *
     * @param component2 the Start Time to set
     * @return the field object to enable build pattern
     */
    public Field29O setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Calendar object.
     *
     * @param component2 the Calendar with the Start Time content to set
     * @return the field object to enable build pattern
     */
    public Field29O setComponent2(java.util.Calendar component2) {
        setComponent(2, SwiftFormatUtils.getTime3(component2));
        return this;
    }

    /**
     * Set the Start Time (component 2).
     *
     * @param component2 the Start Time to set
     * @return the field object to enable build pattern
     */
    public Field29O setStartTime(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Start Time (component 2) from a Calendar object.
     *
     * @see #setComponent2(java.util.Calendar)
     *
     * @param component2 Calendar with the Start Time content to set
     * @return the field object to enable build pattern
     */
    public Field29O setStartTime(java.util.Calendar component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (End Time).
     *
     * @param component3 the End Time to set
     * @return the field object to enable build pattern
     */
    public Field29O setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a Calendar object.
     *
     * @param component3 the Calendar with the End Time content to set
     * @return the field object to enable build pattern
     */
    public Field29O setComponent3(java.util.Calendar component3) {
        setComponent(3, SwiftFormatUtils.getTime3(component3));
        return this;
    }

    /**
     * Set the End Time (component 3).
     *
     * @param component3 the End Time to set
     * @return the field object to enable build pattern
     */
    public Field29O setEndTime(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the End Time (component 3) from a Calendar object.
     *
     * @see #setComponent3(java.util.Calendar)
     *
     * @param component3 Calendar with the End Time content to set
     * @return the field object to enable build pattern
     */
    public Field29O setEndTime(java.util.Calendar component3) {
        return setComponent3(component3);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field29O.NAME
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
    public static Field29O get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field29O(t);
    }

    /**
     * Gets the first instance of Field29O in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field29O get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field29O in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field29O> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field29O from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field29O> getAll(final SwiftTagListBlock block) {
        final List<Field29O> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field29O(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field29O object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field29O fromJson(final String json) {

        final Field29O field = new Field29O();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Location

        if (jsonObject.get("location") != null) {
            field.setComponent1(jsonObject.get("location").getAsString());
        }

        // **** COMPONENT 2 - Start Time

        if (jsonObject.get("startTime") != null) {
            field.setComponent2(jsonObject.get("startTime").getAsString());
        }

        // **** COMPONENT 3 - End Time

        if (jsonObject.get("endTime") != null) {
            field.setComponent3(jsonObject.get("endTime").getAsString());
        }

        return field;
    }


}
