/*
 * Copyright 2006-2021 Prowide
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


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 13C</strong>
 * <p>
 * Model and parser for field 13C of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>Calendar</code></li>
 * 		<li><code>Character</code></li>
 * 		<li><code>Calendar</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>/8c/&lt;HHMM&gt;&lt;SIGN&gt;&lt;OFFSET&gt;</code></li>
 * 		<li>parser pattern: <code>/S/&lt;HHMM&gt;&lt;SIGN&gt;&lt;OFFSET&gt;</code></li>
 * 		<li>components pattern: <code>SHGO</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field13C extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 13C
	 */
    public static final String NAME = "13C";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_13C = "13C";
	public static final String PARSER_PATTERN = "/S/<HHMM><SIGN><OFFSET>";

    /**
     * Components pattern
     *
     * Contains a description of the type for every component. This is <em>DEPRECATED</em>,
     * use TYPES_PATTERN instead, because it distinguishes between N (number) and I (BigDecimal)
     * @see #TYPES_PATTERN
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "SHGO";

    /**
     * Types pattern
     *
     * Contains a description of the type for every component, use instead of COMPONENTS_PATTERN.
     * @since 9.2.7
     */
	public static final String TYPES_PATTERN = "SHGO";

	/**
	 * Component number for the Code subfield
	 */
	public static final Integer CODE = 1;

	/**
	 * Component number for the Time Indication subfield
	 */
	public static final Integer TIME_INDICATION = 2;

	/**
	 * Alternative (<em>DEPRECATED</em>) constant name for field's Time Indication Component number
	 * @see #TIME_INDICATION
	 */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public static final Integer TIME = 2;

	/**
	 * Component number for the Sign subfield
	 */
	public static final Integer SIGN = 3;

	/**
	 * Component number for the Time Offset subfield
	 */
	public static final Integer TIME_OFFSET = 4;

	/**
	 * Alternative (<em>DEPRECATED</em>) constant name for field's Time Offset Component number
	 * @see #TIME_OFFSET
	 */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public static final Integer OFFSET = 4;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field13C() {
        super(4);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field13C(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field13C(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "13C")) {
            throw new IllegalArgumentException("cannot create field 13C from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.<br>
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field13C newInstance(Field13C source) {
        Field13C cp = new Field13C();
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
     * Create a Tag with this field name and an empty string as value
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
        setComponent1(SwiftParseUtils.getTokenFirst(value, "/", "/"));
        String toparse = SwiftParseUtils.getTokenSecondLast(SwiftParseUtils.removePrefix(value, "/"), "/");
        if (toparse != null) {
            if (toparse.length() >= 4) {
                setComponent2(StringUtils.substring(toparse, 0, 4));
            }
            if (toparse.length() >= 5) {
                setComponent3(StringUtils.substring(toparse, 4, 5));
            }
            if (toparse.length() > 5) {
                setComponent4(StringUtils.substring(toparse, 5));
            }
        }
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        result.append("/");
        append(result, 1);
        result.append("/");
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 13C");
        }
        if (component == 1) {
            //default format (as is)
            return getComponent(1);
        }
        if (component == 2) {
            //time
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
        if (component == 4) {
            //default format (as is)
            return getComponent(4);
        }
        return null;
    }

    /**
     * Returns the field components pattern
     *
     * This method is <em>DEPRECATED</em>, use <code>typesPattern()</code> instead.
     * @see #typesPattern()
     * @return the static value of Field13C.COMPONENTS_PATTERN
     */
    @Override
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public final String componentsPattern() {
        return COMPONENTS_PATTERN;
    }

    /**
     * Returns the field component types pattern
     *
     * This method returns a letter representing the type for each component in the Field. It supersedes
     * the Components Pattern because it distinguishes between N (Number) and I (BigDecimal).
     * @since 9.2.7
     * @see #TYPES_PATTERN
     * @return the static value of Field13C.TYPES_PATTERN
     */
    @Override
    public final String typesPattern() {
        return TYPES_PATTERN;
    }

    /**
     * Returns the field parser pattern
     * @return the static value of Field13C.PARSER_PATTERN
     */
    @Override
    public final String parserPattern() {
        return PARSER_PATTERN;
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public final String validatorPattern() {
        return "/8c/<HHMM><SIGN><OFFSET>";
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
    protected List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Code");
        result.add("Time Indication");
        result.add("Sign");
        result.add("Time Offset");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "code");
        result.put(2, "timeIndication");
        result.put(3, "sign");
        result.put(4, "timeOffset");
        return result;
    }


    /**
     * Gets the component 1 (Code).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Code (component 1).
     * @return the Code from component 1
     */
    public String getCode() {
        return getComponent1();
    }

    /**
     * Gets the component 2 (Time Indication).
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
     * Gets the Time Indication (component 2).
     * @return the Time Indication from component 2
     */
    public String getTimeIndication() {
        return getComponent2();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Time Indication
     * @see #getTimeIndication()
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public String getTime() {
        return getTimeIndication();
    }

    /**
     * Get the Time Indication (component 2) as Calendar
     * @return the Time Indication from component 2 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getTimeIndicationAsCalendar() {
        return getComponent2AsCalendar();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Time Indication as Calendar
     * @see #getTimeIndicationAsCalendar()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.util.Calendar getTimeAsCalendar() {
        return getTimeIndicationAsCalendar();
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
     * Gets the component 4 (Time Offset).
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
     * Gets the Time Offset (component 4).
     * @return the Time Offset from component 4
     */
    public String getTimeOffset() {
        return getComponent4();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Time Offset
     * @see #getTimeOffset()
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public String getOffset() {
        return getTimeOffset();
    }

    /**
     * Get the Time Offset (component 4) as Calendar
     * @return the Time Offset from component 4 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getTimeOffsetAsCalendar() {
        return getComponent4AsCalendar();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Time Offset as Calendar
     * @see #getTimeOffsetAsCalendar()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.util.Calendar getOffsetAsCalendar() {
        return getTimeOffsetAsCalendar();
    }

    /**
     * Set the component 1 (Code).
     *
     * @param component1 the Code to set
     * @return the field object to enable build pattern
     */
    public Field13C setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Code (component 1).
     *
     * @param component1 the Code to set
     * @return the field object to enable build pattern
     */
    public Field13C setCode(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Time Indication).
     *
     * @param component2 the Time Indication to set
     * @return the field object to enable build pattern
     */
    public Field13C setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Calendar object.
     *
     * @param component2 the Calendar with the Time Indication content to set
     * @return the field object to enable build pattern
     */
    public Field13C setComponent2(java.util.Calendar component2) {
        setComponent(2, SwiftFormatUtils.getTime3(component2));
        return this;
    }

    /**
     * Set the Time Indication (component 2).
     *
     * @param component2 the Time Indication to set
     * @return the field object to enable build pattern
     */
    public Field13C setTimeIndication(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Time Indication (component 2) from a Calendar object.
     *
     * @see #setComponent2(java.util.Calendar)
     *
     * @param component2 Calendar with the Time Indication content to set
     * @return the field object to enable build pattern
     */
    public Field13C setTimeIndication(java.util.Calendar component2) {
        return setComponent2(component2);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Time Indication
     *
     * @see #setTimeIndication(String)
     *
     * @param component2 the Time Indication to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public Field13C setTime(String component2) {
        return setTimeIndication(component2);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Time Indication from a Calendar object.
     *
     * @see #setComponent2(java.util.Calendar)
     *
     * @param component2 Calendar with the Time Indication content to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public Field13C setTime(java.util.Calendar component2) {
        return setTimeIndication(component2);
    }

    /**
     * Set the component 3 (Sign).
     *
     * @param component3 the Sign to set
     * @return the field object to enable build pattern
     */
    public Field13C setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Sign (component 3).
     *
     * @param component3 the Sign to set
     * @return the field object to enable build pattern
     */
    public Field13C setSign(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Time Offset).
     *
     * @param component4 the Time Offset to set
     * @return the field object to enable build pattern
     */
    public Field13C setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component4 from a Calendar object.
     *
     * @param component4 the Calendar with the Time Offset content to set
     * @return the field object to enable build pattern
     */
    public Field13C setComponent4(java.util.Calendar component4) {
        setComponent(4, SwiftFormatUtils.getOffset(component4));
        return this;
    }

    /**
     * Set the Time Offset (component 4).
     *
     * @param component4 the Time Offset to set
     * @return the field object to enable build pattern
     */
    public Field13C setTimeOffset(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the Time Offset (component 4) from a Calendar object.
     *
     * @see #setComponent4(java.util.Calendar)
     *
     * @param component4 Calendar with the Time Offset content to set
     * @return the field object to enable build pattern
     */
    public Field13C setTimeOffset(java.util.Calendar component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Time Offset
     *
     * @see #setTimeOffset(String)
     *
     * @param component4 the Time Offset to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public Field13C setOffset(String component4) {
        return setTimeOffset(component4);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Time Offset from a Calendar object.
     *
     * @see #setComponent4(java.util.Calendar)
     *
     * @param component4 Calendar with the Time Offset content to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public Field13C setOffset(java.util.Calendar component4) {
        return setTimeOffset(component4);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any)
     * @return the static value of Field13C.NAME
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
    public static Field13C get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field13C(t) ;
    }

    /**
     * Gets the first instance of Field13C in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field13C get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return null;
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field13C in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field13C> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return java.util.Collections.emptyList();
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field13C from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field13C> getAll(final SwiftTagListBlock block) {
        final List<Field13C> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add( new Field13C(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field13C object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field13C fromJson(final String json) {

        Field13C field = new Field13C();

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(json);

        // **** COMPONENT 1 - Code

        if (jsonObject.get("code") != null) {
            field.setComponent1(jsonObject.get("code").getAsString());
        }

        // **** COMPONENT 2 - Time Indication

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("time") != null) {
            field.setComponent2(jsonObject.get("time").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("timeIndication") != null) {
            field.setComponent2(jsonObject.get("timeIndication").getAsString());
        }

        // **** COMPONENT 3 - Sign

        if (jsonObject.get("sign") != null) {
            field.setComponent3(jsonObject.get("sign").getAsString());
        }

        // **** COMPONENT 4 - Time Offset

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("offset") != null) {
            field.setComponent4(jsonObject.get("offset").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("timeOffset") != null) {
            field.setComponent4(jsonObject.get("timeOffset").getAsString());
        }

        return field;
    }


}
