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
 * SWIFT MT Field 77H.
 * <p>
 * Model and parser for field 77H of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: TypeOfAgreement: <code>String</code></li>
 * 		<li>Component 2: Date: <code>Calendar</code></li>
 * 		<li>Component 3: Version: <code>Calendar</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>6a[/&lt;DATE4&gt;][//&lt;YEAR&gt;]</code></li>
 * 		<li>parser pattern: <code>S[/S][//S]</code></li>
 * 		<li>components pattern: <code>SDY</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field77H extends Field implements Serializable, DateContainer {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 77H.
	 */
    public static final String NAME = "77H";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_77H = "77H";

	/**
	 * Component number for the Type Of Agreement subfield.
	 */
	public static final Integer TYPE_OF_AGREEMENT = 1;

	/**
     * Alternative constant name for field's Type Of Agreement Component number.
     * @see #TYPE_OF_AGREEMENT
     */
    public static final Integer TYPE = 1;

	/**
	 * Component number for the Date subfield.
	 */
	public static final Integer DATE = 2;

	/**
	 * Component number for the Version subfield.
	 */
	public static final Integer VERSION = 3;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field77H() {
        super(3);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field77H(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field77H(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "77H")) {
            throw new IllegalArgumentException("cannot create field 77H from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field77H newInstance(Field77H source) {
        Field77H cp = new Field77H();
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
        setComponent1(SwiftParseUtils.getTokenFirst(value, null, "/"));
        setComponent3(SwiftParseUtils.getTokenSecondLast(value, "//"));
        String toparse = SwiftParseUtils.getTokenFirst(value, "//");
        setComponent2(SwiftParseUtils.getTokenSecondLast(toparse, "/"));
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
        if (getComponent3() != null) {
            result.append("//").append(getComponent3());
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
        if (component < 1 || component > 3) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 77H");
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
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(3);
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
        return "SDY";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "S[/S][//S]";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "6a[/<DATE4>][//<YEAR>]";
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
        if (component == 3) {
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
        result.add("Type Of Agreement");
        result.add("Date");
        result.add("Version");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "typeOfAgreement");
        result.put(2, "date");
        result.put(3, "version");
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
        super.labelMap.put("typeofagreement", 1);
        // alias name
        super.labelMap.put("type", 1);
        super.labelMap.put("date", 2);
        super.labelMap.put("version", 3);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Type Of Agreement).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Type Of Agreement (component 1).
     * @return the Type Of Agreement from component 1
     */
    public String getTypeOfAgreement() {
        return getComponent1();
    }

    /**
     * Alternative method getter for field's Type Of Agreement
     * @since 9.2.7
     */
    public String getType() {
        return getTypeOfAgreement();
    }

    /**
     * Gets the component 2 (Date).
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
     * Gets the Date (component 2).
     * @return the Date from component 2
     */
    public String getDate() {
        return getComponent2();
    }

    /**
     * Get the Date (component 2) as Calendar
     * @return the Date from component 2 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getDateAsCalendar() {
        return getComponent2AsCalendar();
    }

    /**
     * Gets the component 3 (Version).
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
        return SwiftFormatUtils.getYear(getComponent(3));
    }

    /**
     * Gets the Version (component 3).
     * @return the Version from component 3
     */
    public String getVersion() {
        return getComponent3();
    }

    /**
     * Get the Version (component 3) as Calendar
     * @return the Version from component 3 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getVersionAsCalendar() {
        return getComponent3AsCalendar();
    }

    /**
     * Set the component 1 (Type Of Agreement).
     *
     * @param component1 the Type Of Agreement to set
     * @return the field object to enable build pattern
     */
    public Field77H setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Type Of Agreement (component 1).
     *
     * @param component1 the Type Of Agreement to set
     * @return the field object to enable build pattern
     */
    public Field77H setTypeOfAgreement(String component1) {
        return setComponent1(component1);
    }

    public Field77H setType(String component1) {
        return setTypeOfAgreement(component1);
    }

    /**
     * Set the component 2 (Date).
     *
     * @param component2 the Date to set
     * @return the field object to enable build pattern
     */
    public Field77H setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Calendar object.
     *
     * @param component2 the Calendar with the Date content to set
     * @return the field object to enable build pattern
     */
    public Field77H setComponent2(java.util.Calendar component2) {
        setComponent(2, SwiftFormatUtils.getDate4(component2));
        return this;
    }

    /**
     * Set the Date (component 2).
     *
     * @param component2 the Date to set
     * @return the field object to enable build pattern
     */
    public Field77H setDate(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Date (component 2) from a Calendar object.
     *
     * @see #setComponent2(java.util.Calendar)
     *
     * @param component2 Calendar with the Date content to set
     * @return the field object to enable build pattern
     */
    public Field77H setDate(java.util.Calendar component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Version).
     *
     * @param component3 the Version to set
     * @return the field object to enable build pattern
     */
    public Field77H setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a Calendar object.
     *
     * @param component3 the Calendar with the Version content to set
     * @return the field object to enable build pattern
     */
    public Field77H setComponent3(java.util.Calendar component3) {
        setComponent(3, SwiftFormatUtils.getYear(component3));
        return this;
    }

    /**
     * Set the Version (component 3).
     *
     * @param component3 the Version to set
     * @return the field object to enable build pattern
     */
    public Field77H setVersion(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Version (component 3) from a Calendar object.
     *
     * @see #setComponent3(java.util.Calendar)
     *
     * @param component3 Calendar with the Version content to set
     * @return the field object to enable build pattern
     */
    public Field77H setVersion(java.util.Calendar component3) {
        return setComponent3(component3);
    }


    /**
     * Returns all components that can be converted to a Calendar
     *
     * @return the list of converted components (a Calendar object or null)
     * @since 9.2.7
     */
    @Override
    public List<Calendar> dates() {
        return DateResolver.dates(this);
    }

    /**
     * Returns the first component that can be converted to a Calendar
     *
     * @return the converted components (a Calendar object or null)
     * @since 9.2.7
     */
    public Calendar date() {
        return DateResolver.date(this);
    }


    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field77H.NAME
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
    public static Field77H get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field77H(t);
    }

    /**
     * Gets the first instance of Field77H in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field77H get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field77H in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field77H> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field77H from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field77H> getAll(final SwiftTagListBlock block) {
        final List<Field77H> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field77H(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field77H object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field77H fromJson(final String json) {

        final Field77H field = new Field77H();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Type Of Agreement

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("type") != null) {
            field.setComponent1(jsonObject.get("type").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("typeOfAgreement") != null) {
            field.setComponent1(jsonObject.get("typeOfAgreement").getAsString());
        }

        // **** COMPONENT 2 - Date

        if (jsonObject.get("date") != null) {
            field.setComponent2(jsonObject.get("date").getAsString());
        }

        // **** COMPONENT 3 - Version

        if (jsonObject.get("version") != null) {
            field.setComponent3(jsonObject.get("version").getAsString());
        }

        return field;
    }


}
