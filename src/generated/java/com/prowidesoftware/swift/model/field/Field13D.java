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

import com.prowidesoftware.swift.model.field.DateContainer;
import com.prowidesoftware.swift.model.field.DateResolver;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 13D.
 * <p>
 * Model and parser for field 13D of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Date: <code>Calendar</code></li>
 * 		<li>Component 2: Time: <code>Calendar</code></li>
 * 		<li>Component 3: Sign: <code>Character</code></li>
 * 		<li>Component 4: Offset: <code>Calendar</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;DATE2&gt;&lt;HHMM&gt;&lt;SIGN&gt;&lt;OFFSET&gt;</code></li>
 * 		<li>parser pattern: <code>&lt;DATE2&gt;&lt;HHMM&gt;&lt;SIGN&gt;&lt;OFFSET&gt;</code></li>
 * 		<li>components pattern: <code>EHGO</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field13D extends Field implements Serializable, DateContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 13D.
	 */
    public static final String NAME = "13D";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_13D = "13D";

	/**
	 * Component number for the Date subfield.
	 */
	public static final Integer DATE = 1;

	/**
	 * Component number for the Time subfield.
	 */
	public static final Integer TIME = 2;

	/**
	 * Component number for the Sign subfield.
	 */
	public static final Integer SIGN = 3;

	/**
	 * Component number for the Offset subfield.
	 */
	public static final Integer OFFSET = 4;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field13D() {
        super(4);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field13D(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field13D(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "13D")) {
            throw new IllegalArgumentException("cannot create field 13D from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field13D newInstance(Field13D source) {
        Field13D cp = new Field13D();
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
            if (value.length() >= 6) {
                setComponent1(StringUtils.substring(value, 0, 6));
            }
            if (value.length() >= 10) {
                setComponent2(StringUtils.substring(value, 6, 10));
            }
            if (value.length() >= 11) {
                setComponent3(StringUtils.substring(value, 10, 11));
            }
            if (value.length() > 11) {
                setComponent4(StringUtils.substring(value, 11));
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 13D");
        }
        if (component == 1) {
            //date: [YY]YYMMDD
            java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, notNull(locale));
            java.util.Calendar cal = getComponent1AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
        }
        if (component == 2) {
            //time: HH[mm]
            java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
            java.util.Calendar cal = getComponent2AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
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
        return "EHGO";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "<DATE2><HHMM><SIGN><OFFSET>";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "<DATE2><HHMM><SIGN><OFFSET>";
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
        result.add("Date");
        result.add("Time");
        result.add("Sign");
        result.add("Offset");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "date");
        result.put(2, "time");
        result.put(3, "sign");
        result.put(4, "offset");
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
        super.labelMap.put("date", 1);
        super.labelMap.put("time", 2);
        super.labelMap.put("sign", 3);
        super.labelMap.put("offset", 4);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Date).
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
        return SwiftFormatUtils.getDate2(getComponent(1));
    }

    /**
     * Gets the Date (component 1).
     * @return the Date from component 1
     */
    public String getDate() {
        return getComponent1();
    }

    /**
     * Get the Date (component 1) as Calendar
     * @return the Date from component 1 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getDateAsCalendar() {
        return getComponent1AsCalendar();
    }

    /**
     * Gets the component 2 (Time).
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
     * Gets the Time (component 2).
     * @return the Time from component 2
     */
    public String getTime() {
        return getComponent2();
    }

    /**
     * Get the Time (component 2) as Calendar
     * @return the Time from component 2 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getTimeAsCalendar() {
        return getComponent2AsCalendar();
    }

    /**
     * Gets the component 3 (Sign).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Sign (component 3).
     * @return the Sign from component 3
     */
    public String getSign() {
        return getComponent3();
    }

    /**
     * Gets the component 4 (Offset).
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
        return SwiftFormatUtils.getOffset(getComponent(4));
    }

    /**
     * Gets the Offset (component 4).
     * @return the Offset from component 4
     */
    public String getOffset() {
        return getComponent4();
    }

    /**
     * Get the Offset (component 4) as Calendar
     * @return the Offset from component 4 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getOffsetAsCalendar() {
        return getComponent4AsCalendar();
    }

    /**
     * Set the component 1 (Date).
     *
     * @param component1 the Date to set
     * @return the field object to enable build pattern
     */
    public Field13D setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the component1 from a Calendar object.
     *
     * @param component1 the Calendar with the Date content to set
     * @return the field object to enable build pattern
     */
    public Field13D setComponent1(java.util.Calendar component1) {
        setComponent(1, SwiftFormatUtils.getDate2(component1));
        return this;
    }

    /**
     * Set the Date (component 1).
     *
     * @param component1 the Date to set
     * @return the field object to enable build pattern
     */
    public Field13D setDate(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the Date (component 1) from a Calendar object.
     *
     * @see #setComponent1(java.util.Calendar)
     *
     * @param component1 Calendar with the Date content to set
     * @return the field object to enable build pattern
     */
    public Field13D setDate(java.util.Calendar component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Time).
     *
     * @param component2 the Time to set
     * @return the field object to enable build pattern
     */
    public Field13D setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Calendar object.
     *
     * @param component2 the Calendar with the Time content to set
     * @return the field object to enable build pattern
     */
    public Field13D setComponent2(java.util.Calendar component2) {
        setComponent(2, SwiftFormatUtils.getTime3(component2));
        return this;
    }

    /**
     * Set the Time (component 2).
     *
     * @param component2 the Time to set
     * @return the field object to enable build pattern
     */
    public Field13D setTime(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Time (component 2) from a Calendar object.
     *
     * @see #setComponent2(java.util.Calendar)
     *
     * @param component2 Calendar with the Time content to set
     * @return the field object to enable build pattern
     */
    public Field13D setTime(java.util.Calendar component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Sign).
     *
     * @param component3 the Sign to set
     * @return the field object to enable build pattern
     */
    public Field13D setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Sign (component 3).
     *
     * @param component3 the Sign to set
     * @return the field object to enable build pattern
     */
    public Field13D setSign(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Offset).
     *
     * @param component4 the Offset to set
     * @return the field object to enable build pattern
     */
    public Field13D setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component4 from a Calendar object.
     *
     * @param component4 the Calendar with the Offset content to set
     * @return the field object to enable build pattern
     */
    public Field13D setComponent4(java.util.Calendar component4) {
        setComponent(4, SwiftFormatUtils.getOffset(component4));
        return this;
    }

    /**
     * Set the Offset (component 4).
     *
     * @param component4 the Offset to set
     * @return the field object to enable build pattern
     */
    public Field13D setOffset(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the Offset (component 4) from a Calendar object.
     *
     * @see #setComponent4(java.util.Calendar)
     *
     * @param component4 Calendar with the Offset content to set
     * @return the field object to enable build pattern
     */
    public Field13D setOffset(java.util.Calendar component4) {
        return setComponent4(component4);
    }


    /**
     * Returns all components that can be converted to a Calendar
     *
     * @return the list of converted components (a Calendar object or null)
     */
    @Override
    public List<Calendar> dates() {
        return DateResolver.dates(this);
    }

    /**
     * Returns the first component that can be converted to a Calendar
     *
     * @return the converted components (a Calendar object or null)
     */
    public Calendar date() {
        return DateResolver.date(this);
    }


    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field13D.NAME
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
    public static Field13D get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field13D(t);
    }

    /**
     * Gets the first instance of Field13D in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field13D get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field13D in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field13D> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field13D from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field13D> getAll(final SwiftTagListBlock block) {
        final List<Field13D> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field13D(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field13D object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field13D fromJson(final String json) {

        final Field13D field = new Field13D();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Date

        if (jsonObject.get("date") != null) {
            field.setComponent1(jsonObject.get("date").getAsString());
        }

        // **** COMPONENT 2 - Time

        if (jsonObject.get("time") != null) {
            field.setComponent2(jsonObject.get("time").getAsString());
        }

        // **** COMPONENT 3 - Sign

        if (jsonObject.get("sign") != null) {
            field.setComponent3(jsonObject.get("sign").getAsString());
        }

        // **** COMPONENT 4 - Offset

        if (jsonObject.get("offset") != null) {
            field.setComponent4(jsonObject.get("offset").getAsString());
        }

        return field;
    }


}
