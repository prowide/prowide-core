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

import com.prowidesoftware.swift.model.field.GenericField;
import com.prowidesoftware.swift.model.field.DateContainer;
import com.prowidesoftware.swift.model.field.DateResolver;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 69B.
 * <p>
 * Model and parser for field 69B of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Qualifier: <code>String</code></li>
 * 		<li>Component 2: Date1: <code>Calendar</code></li>
 * 		<li>Component 3: Time1: <code>Calendar</code></li>
 * 		<li>Component 4: Date2: <code>Calendar</code></li>
 * 		<li>Component 5: Time2: <code>Calendar</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>:4!c//&lt;DATE4&gt;&lt;TIME2&gt;/&lt;DATE4&gt;&lt;TIME2&gt;</code></li>
 * 		<li>parser pattern: <code>:S//&lt;DATE4&gt;&lt;TIME2&gt;/&lt;DATE4&gt;&lt;TIME2&gt;</code></li>
 * 		<li>components pattern: <code>SDTDT</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field69B extends Field implements Serializable, DateContainer, GenericField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 69B.
	 */
    public static final String NAME = "69B";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_69B = "69B";

	/**
	 * Component number for the Qualifier subfield.
	 */
	public static final Integer QUALIFIER = 1;

	/**
	 * Component number for the Date1 subfield.
	 */
	public static final Integer DATE1 = 2;


	/**
	 * Component number for the Time1 subfield.
	 */
	public static final Integer TIME1 = 3;


	/**
	 * Component number for the Date2 subfield.
	 */
	public static final Integer DATE2 = 4;


	/**
	 * Component number for the Time2 subfield.
	 */
	public static final Integer TIME2 = 5;


    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field69B() {
        super(5);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field69B(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field69B(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "69B")) {
            throw new IllegalArgumentException("cannot create field 69B from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field69B newInstance(Field69B source) {
        Field69B cp = new Field69B();
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
        init(5);
        setComponent1(SwiftParseUtils.getTokenFirst(value, ":", "//"));
        String toparse = SwiftParseUtils.getTokenSecondLast(value, "//");
        String toparse2 = SwiftParseUtils.getTokenFirst(toparse, "/");
        String toparse3 = SwiftParseUtils.getTokenSecondLast(toparse, "/");
        if (toparse2 != null) {
            if (toparse2.length() >= 8) {
                setComponent2(StringUtils.substring(toparse2, 0, 8));
            }
            if (toparse2.length() > 8) {
                setComponent3(StringUtils.substring(toparse2, 8));
            }
        }
        if (toparse3 != null) {
            if (toparse3.length() >= 8) {
                setComponent4(StringUtils.substring(toparse3, 0, 8));
            }
            if (toparse3.length() > 8) {
                setComponent5(StringUtils.substring(toparse3, 8));
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
        result.append("/");
        append(result, 4);
        append(result, 5);
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
        if (component < 1 || component > 5) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 69B");
        }
        if (component == 1) {
            //default format (as is)
            return getComponent(1);
        }
        if (component == 2) {
            //date: [YY]YYMMDD
            java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, notNull(locale));
            java.util.Calendar cal = getComponent2AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
        }
        if (component == 3) {
            //time with seconds: HHmmss
            java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm:ss", notNull(locale));
            java.util.Calendar cal = getComponent3AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
        }
        if (component == 4) {
            //date: [YY]YYMMDD
            java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, notNull(locale));
            java.util.Calendar cal = getComponent4AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
        }
        // This is the last component, return directly without `if`
        //time with seconds: HHmmss
        java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm:ss", notNull(locale));
        java.util.Calendar cal = getComponent5AsCalendar();
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
        return "SDTDT";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return ":S//<DATE4><TIME2>/<DATE4><TIME2>";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return ":4!c//<DATE4><TIME2>/<DATE4><TIME2>";
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
        return 5;
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
        result.add("Date1");
        result.add("Time1");
        result.add("Date2");
        result.add("Time2");
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
        result.put(2, "date1");
        result.put(3, "time1");
        result.put(4, "date2");
        result.put(5, "time2");
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
        super.labelMap.put("qualifier", 1);
        super.labelMap.put("date1", 2);
        // alias name
        super.labelMap.put("startdate", 2);
        super.labelMap.put("time1", 3);
        // alias name
        super.labelMap.put("starttime", 3);
        super.labelMap.put("date2", 4);
        // alias name
        super.labelMap.put("enddate", 4);
        super.labelMap.put("time2", 5);
        // alias name
        super.labelMap.put("endtime", 5);
        return super.labelMap;
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
     * Gets the component 2 (Date1).
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
        return SwiftFormatUtils.getDate4(getComponent(2));
    }

    /**
     * Gets the Date1 (component 2).
     * @return the Date1 from component 2
     */
    public String getDate1() {
        return getComponent2();
    }


    /**
     * Get the Date1 (component 2) as Calendar
     * @return the Date1 from component 2 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getDate1AsCalendar() {
        return getComponent2AsCalendar();
    }

    /**
     * Gets the component 3 (Time1).
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
        return SwiftFormatUtils.getTime2(getComponent(3));
    }

    /**
     * Gets the Time1 (component 3).
     * @return the Time1 from component 3
     */
    public String getTime1() {
        return getComponent3();
    }


    /**
     * Get the Time1 (component 3) as Calendar
     * @return the Time1 from component 3 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getTime1AsCalendar() {
        return getComponent3AsCalendar();
    }

    /**
     * Gets the component 4 (Date2).
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
        return SwiftFormatUtils.getDate4(getComponent(4));
    }

    /**
     * Gets the Date2 (component 4).
     * @return the Date2 from component 4
     */
    public String getDate2() {
        return getComponent4();
    }


    /**
     * Get the Date2 (component 4) as Calendar
     * @return the Date2 from component 4 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getDate2AsCalendar() {
        return getComponent4AsCalendar();
    }

    /**
     * Gets the component 5 (Time2).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Get the component 5 as Calendar
     *
     * @return the component 5 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent5AsCalendar() {
        return SwiftFormatUtils.getTime2(getComponent(5));
    }

    /**
     * Gets the Time2 (component 5).
     * @return the Time2 from component 5
     */
    public String getTime2() {
        return getComponent5();
    }


    /**
     * Get the Time2 (component 5) as Calendar
     * @return the Time2 from component 5 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getTime2AsCalendar() {
        return getComponent5AsCalendar();
    }

    /**
     * Set the component 1 (Qualifier).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field69B setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Qualifier (component 1).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field69B setQualifier(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Date1).
     *
     * @param component2 the Date1 to set
     * @return the field object to enable build pattern
     */
    public Field69B setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Calendar object.
     *
     * @param component2 the Calendar with the Date1 content to set
     * @return the field object to enable build pattern
     */
    public Field69B setComponent2(java.util.Calendar component2) {
        setComponent(2, SwiftFormatUtils.getDate4(component2));
        return this;
    }

    /**
     * Set the Date1 (component 2).
     *
     * @param component2 the Date1 to set
     * @return the field object to enable build pattern
     */
    public Field69B setDate1(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Date1 (component 2) from a Calendar object.
     *
     * @see #setComponent2(java.util.Calendar)
     *
     * @param component2 Calendar with the Date1 content to set
     * @return the field object to enable build pattern
     */
    public Field69B setDate1(java.util.Calendar component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Time1).
     *
     * @param component3 the Time1 to set
     * @return the field object to enable build pattern
     */
    public Field69B setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a Calendar object.
     *
     * @param component3 the Calendar with the Time1 content to set
     * @return the field object to enable build pattern
     */
    public Field69B setComponent3(java.util.Calendar component3) {
        setComponent(3, SwiftFormatUtils.getTime2(component3));
        return this;
    }

    /**
     * Set the Time1 (component 3).
     *
     * @param component3 the Time1 to set
     * @return the field object to enable build pattern
     */
    public Field69B setTime1(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Time1 (component 3) from a Calendar object.
     *
     * @see #setComponent3(java.util.Calendar)
     *
     * @param component3 Calendar with the Time1 content to set
     * @return the field object to enable build pattern
     */
    public Field69B setTime1(java.util.Calendar component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Date2).
     *
     * @param component4 the Date2 to set
     * @return the field object to enable build pattern
     */
    public Field69B setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component4 from a Calendar object.
     *
     * @param component4 the Calendar with the Date2 content to set
     * @return the field object to enable build pattern
     */
    public Field69B setComponent4(java.util.Calendar component4) {
        setComponent(4, SwiftFormatUtils.getDate4(component4));
        return this;
    }

    /**
     * Set the Date2 (component 4).
     *
     * @param component4 the Date2 to set
     * @return the field object to enable build pattern
     */
    public Field69B setDate2(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the Date2 (component 4) from a Calendar object.
     *
     * @see #setComponent4(java.util.Calendar)
     *
     * @param component4 Calendar with the Date2 content to set
     * @return the field object to enable build pattern
     */
    public Field69B setDate2(java.util.Calendar component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Time2).
     *
     * @param component5 the Time2 to set
     * @return the field object to enable build pattern
     */
    public Field69B setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the component5 from a Calendar object.
     *
     * @param component5 the Calendar with the Time2 content to set
     * @return the field object to enable build pattern
     */
    public Field69B setComponent5(java.util.Calendar component5) {
        setComponent(5, SwiftFormatUtils.getTime2(component5));
        return this;
    }

    /**
     * Set the Time2 (component 5).
     *
     * @param component5 the Time2 to set
     * @return the field object to enable build pattern
     */
    public Field69B setTime2(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the Time2 (component 5) from a Calendar object.
     *
     * @see #setComponent5(java.util.Calendar)
     *
     * @param component5 Calendar with the Time2 content to set
     * @return the field object to enable build pattern
     */
    public Field69B setTime2(java.util.Calendar component5) {
        return setComponent5(component5);
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
     * Returns the issuer code (or Data Source Scheme or DSS).
     * The DSS is only present in some generic fields, when present, is equals to component two.
     *
     * @return DSS component value or null if the DSS is not set or not available for this field.
     */
    @Override
    public String getDSS() {
        return null;
    }

    /**
     * Checks if the issuer code (or Data Source Scheme or DSS) is present.
     *
     * @see #getDSS()
     * @return true if DSS is present, false otherwise.
     */
    @Override
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
    @Override
    public String getConditionalQualifier() {
        return getComponent(CONDITIONAL_QUALIFIER);
    }

    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field69B.NAME
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
    public static Field69B get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field69B(t);
    }

    /**
     * Gets the first instance of Field69B in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field69B get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field69B in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field69B> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field69B from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field69B> getAll(final SwiftTagListBlock block) {
        final List<Field69B> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field69B(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field69B object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field69B fromJson(final String json) {

        final Field69B field = new Field69B();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Qualifier

        if (jsonObject.get("qualifier") != null) {
            field.setComponent1(jsonObject.get("qualifier").getAsString());
        }

        // **** COMPONENT 2 - Date1

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("startDate") != null) {
            field.setComponent2(jsonObject.get("startDate").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("date1") != null) {
            field.setComponent2(jsonObject.get("date1").getAsString());
        }

        // **** COMPONENT 3 - Time1

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("startTime") != null) {
            field.setComponent3(jsonObject.get("startTime").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("time1") != null) {
            field.setComponent3(jsonObject.get("time1").getAsString());
        }

        // **** COMPONENT 4 - Date2

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("endDate") != null) {
            field.setComponent4(jsonObject.get("endDate").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("date2") != null) {
            field.setComponent4(jsonObject.get("date2").getAsString());
        }

        // **** COMPONENT 5 - Time2

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("endTime") != null) {
            field.setComponent5(jsonObject.get("endTime").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("time2") != null) {
            field.setComponent5(jsonObject.get("time2").getAsString());
        }

        return field;
    }


}
