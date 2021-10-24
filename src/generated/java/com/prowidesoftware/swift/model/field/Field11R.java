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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Calendar;

import com.prowidesoftware.swift.model.field.MultiLineField;
import com.prowidesoftware.swift.model.field.DateContainer;
import com.prowidesoftware.swift.model.field.DateResolver;

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 11R</strong>
 * <p>
 * Model and parser for field 11R of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>Long</code></li>
 * 		<li><code>Calendar</code></li>
 * 		<li><code>Long</code></li>
 * 		<li><code>Long</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>&lt;MT&gt;$&lt;DATE2&gt;[$4!n6!n]</code></li>
 * 		<li>parser pattern: <code>S$&lt;DATE2&gt;[$4!S6!S]</code></li>
 * 		<li>components pattern: <code>MENN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field11R extends Field implements Serializable, DateContainer, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 11R
	 */
    public static final String NAME = "11R";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_11R = "11R";
	public static final String PARSER_PATTERN = "S$<DATE2>[$4!S6!S]";

    /**
     * Components pattern
     *
     * Contains a description of the type for every component. This is <em>DEPRECATED</em>,
     * use TYPES_PATTERN instead, because it distinguishes between N (number) and I (BigDecimal)
     * @see #TYPES_PATTERN
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "MENN";

    /**
     * Types pattern
     *
     * Contains a description of the type for every component, use instead of COMPONENTS_PATTERN.
     * @since 9.2.7
     */
	public static final String TYPES_PATTERN = "MENN";

	/**
	 * Component number for the MT Number subfield
	 */
	public static final Integer MT_NUMBER = 1;

	/**
	 * Alternative (<em>DEPRECATED</em>) constant name for field's MT Number Component number
	 * @see #MT_NUMBER
	 */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public static final Integer MT = 1;

	/**
	 * Component number for the Date subfield
	 */
	public static final Integer DATE = 2;

	/**
	 * Component number for the Session Number subfield
	 */
	public static final Integer SESSION_NUMBER = 3;

	/**
	 * Component number for the ISN subfield
	 */
	public static final Integer ISN = 4;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field11R() {
        super(4);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field11R(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field11R(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "11R")) {
            throw new IllegalArgumentException("cannot create field 11R from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.<br>
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field11R newInstance(Field11R source) {
        Field11R cp = new Field11R();
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
        List<String> lines = SwiftParseUtils.getLines(value);
        if (lines.isEmpty()) {
            return;
        }
        setComponent1(lines.get(0));
        if (lines.size() > 1) {
            setComponent2(lines.get(1));
        }
        if (lines.size() > 2) {
            String toparse = lines.get(2);
            if (toparse != null && toparse.length() >= 4) {
                setComponent3(StringUtils.substring(toparse, 0, 4));
                if (toparse.length() > 4 ) {
                    setComponent4(StringUtils.substring(toparse, 4));
                }
            } else {
                setComponent3(toparse);
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
        if (getComponent2() != null) {
            result.append(com.prowidesoftware.swift.io.writer.FINWriterVisitor.SWIFT_EOL).append(getComponent2());
        }
        if (getComponent3() != null || getComponent4() != null) {
            result.append(com.prowidesoftware.swift.io.writer.FINWriterVisitor.SWIFT_EOL);
            append(result, 3);
            append(result, 4);
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
        if (component < 1 || component > 4) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 11R");
        }
        if (component == 1) {
            //default format (as is)
            return getComponent(1);
        }
        if (component == 2) {
            //date
            java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, notNull(locale));
            java.util.Calendar cal = getComponent2AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
        }
        if (component == 3) {
            //number, amount, rate
            java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
            f.setMaximumFractionDigits(13);
            Number n = getComponent3AsNumber();
            if (n != null) {
                return f.format(n);
            }
        }
        if (component == 4) {
            //number, amount, rate
            java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
            f.setMaximumFractionDigits(13);
            Number n = getComponent4AsNumber();
            if (n != null) {
                return f.format(n);
            }
        }
        return null;
    }

    /**
     * Returns the field components pattern
     *
     * This method is <em>DEPRECATED</em>, use <code>typesPattern()</code> instead.
     * @see #typesPattern()
     * @return the static value of Field11R.COMPONENTS_PATTERN
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
     * @return the static value of Field11R.TYPES_PATTERN
     */
    @Override
    public final String typesPattern() {
        return TYPES_PATTERN;
    }

    /**
     * Returns the field parser pattern
     * @return the static value of Field11R.PARSER_PATTERN
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
        return "<MT>$<DATE2>[$4!n6!n]";
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
        if (component == 3) {
            return true;
        }
        if (component == 4) {
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
        result.add("MT Number");
        result.add("Date");
        result.add("Session Number");
        result.add("ISN");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "mTNumber");
        result.put(2, "date");
        result.put(3, "sessionNumber");
        result.put(4, "iSN");
        return result;
    }


    /**
     * Gets the component 1 (MT Number).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the MT Number (component 1).
     * @return the MT Number from component 1
     */
    public String getMTNumber() {
        return getComponent1();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's MT Number
     * @see #getMTNumber()
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public String getMT() {
        return getMTNumber();
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
        return SwiftFormatUtils.getDate2(getComponent(2));
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
     * Gets the component 3 (Session Number).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Get the component 3 as Long
     *
     * @return the component 3 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent3AsLong() {
        return SwiftFormatUtils.getLong(getComponent(3));
    }

    /**
     * Get the component 3 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent3AsLong()</code> to get the proper value.
     *
     * @return the component 3 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent3AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getComponent3AsNumber() {
        Long l = getComponent3AsLong();
        return l != null ? new BigDecimal(l) : null;
    }

    /**
     * Gets the Session Number (component 3).
     * @return the Session Number from component 3
     */
    public String getSessionNumber() {
        return getComponent3();
    }

    /**
     * Get the Session Number (component 3) as Long
     * @return the Session Number from component 3 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getSessionNumberAsLong() {
        return getComponent3AsLong();
    }

    /**
     * Get the Session Number (component 3) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent3AsLong()</code> to get the proper value.
     *
     * @return the component 3 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getSessionNumberAsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getSessionNumberAsNumber() {
        return getComponent3AsNumber();
    }

    /**
     * Gets the component 4 (ISN).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Get the component 4 as Long
     *
     * @return the component 4 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent4AsLong() {
        return SwiftFormatUtils.getLong(getComponent(4));
    }

    /**
     * Get the component 4 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent4AsLong()</code> to get the proper value.
     *
     * @return the component 4 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent4AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getComponent4AsNumber() {
        Long l = getComponent4AsLong();
        return l != null ? new BigDecimal(l) : null;
    }

    /**
     * Gets the ISN (component 4).
     * @return the ISN from component 4
     */
    public String getISN() {
        return getComponent4();
    }

    /**
     * Get the ISN (component 4) as Long
     * @return the ISN from component 4 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getISNAsLong() {
        return getComponent4AsLong();
    }

    /**
     * Get the ISN (component 4) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent4AsLong()</code> to get the proper value.
     *
     * @return the component 4 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getISNAsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getISNAsNumber() {
        return getComponent4AsNumber();
    }

    /**
     * Set the component 1 (MT Number).
     *
     * @param component1 the MT Number to set
     * @return the field object to enable build pattern
     */
    public Field11R setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the MT Number (component 1).
     *
     * @param component1 the MT Number to set
     * @return the field object to enable build pattern
     */
    public Field11R setMTNumber(String component1) {
        return setComponent1(component1);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's MT Number
     *
     * @see #setMTNumber(String)
     *
     * @param component1 the MT Number to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public Field11R setMT(String component1) {
        return setMTNumber(component1);
    }

    /**
     * Set the component 2 (Date).
     *
     * @param component2 the Date to set
     * @return the field object to enable build pattern
     */
    public Field11R setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Calendar object.
     *
     * @param component2 the Calendar with the Date content to set
     * @return the field object to enable build pattern
     */
    public Field11R setComponent2(java.util.Calendar component2) {
        setComponent(2, SwiftFormatUtils.getDate2(component2));
        return this;
    }

    /**
     * Set the Date (component 2).
     *
     * @param component2 the Date to set
     * @return the field object to enable build pattern
     */
    public Field11R setDate(String component2) {
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
    public Field11R setDate(java.util.Calendar component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Session Number).
     *
     * @param component3 the Session Number to set
     * @return the field object to enable build pattern
     */
    public Field11R setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a Long object.
     * <br>
     * <em>If the component being set is a fixed length number, the argument will not be
     * padded.</em> It is recommended for these cases to use the setComponent3(String)
     * method.
     *
     * @see #setComponent3(String)
     * @since 9.2.7
     *
     * @param component3 the Long with the Session Number content to set
     * @return the field object to enable build pattern
     */
    public Field11R setComponent3(java.lang.Long component3) {
        setComponent(3, SwiftFormatUtils.getLong(component3));
        return this;
    }

    /**
     * Alternative method setter for field's Session Number (component 3) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Session Number content to set
     * @return the field object to enable build pattern
     * @see #setSessionNumber(java.lang.Long)
     */
    public Field11R setComponent3(java.lang.Number component3) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component3 instanceof Long) {
            setComponent(3, SwiftFormatUtils.getLong( (Long) component3));
        } else if (component3 instanceof BigInteger || component3 instanceof Integer) {
            setComponent(3, SwiftFormatUtils.getLong(component3.longValue()));
        } else if (component3 instanceof Float || component3 instanceof Double ||
                   component3 instanceof BigDecimal) {
            // it's non null
            setComponent(3, SwiftFormatUtils.getLong(component3.longValue()));
        } else {
            // so it's a Number that failed instanceof Number => it's null
            setComponent(3, null);
        }
        return this;
    }

    /**
     * Set the Session Number (component 3).
     *
     * @param component3 the Session Number to set
     * @return the field object to enable build pattern
     */
    public Field11R setSessionNumber(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Session Number (component 3) from a Long object.
     *
     * @see #setComponent3(java.lang.Long)
     *
     * @param component3 Long with the Session Number content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field11R setSessionNumber(java.lang.Long component3) {
        return setComponent3(component3);
    }

    /**
     * Alternative method setter for field's Session Number (component 3) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Session Number content to set
     * @return the field object to enable build pattern
     * @see #setSessionNumber(java.lang.Long)
     */
    public Field11R setSessionNumber(java.lang.Number component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (ISN).
     *
     * @param component4 the ISN to set
     * @return the field object to enable build pattern
     */
    public Field11R setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component4 from a Long object.
     * <br>
     * <em>If the component being set is a fixed length number, the argument will not be
     * padded.</em> It is recommended for these cases to use the setComponent4(String)
     * method.
     *
     * @see #setComponent4(String)
     * @since 9.2.7
     *
     * @param component4 the Long with the ISN content to set
     * @return the field object to enable build pattern
     */
    public Field11R setComponent4(java.lang.Long component4) {
        setComponent(4, SwiftFormatUtils.getLong(component4));
        return this;
    }

    /**
     * Alternative method setter for field's ISN (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the ISN content to set
     * @return the field object to enable build pattern
     * @see #setISN(java.lang.Long)
     */
    public Field11R setComponent4(java.lang.Number component4) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component4 instanceof Long) {
            setComponent(4, SwiftFormatUtils.getLong( (Long) component4));
        } else if (component4 instanceof BigInteger || component4 instanceof Integer) {
            setComponent(4, SwiftFormatUtils.getLong(component4.longValue()));
        } else if (component4 instanceof Float || component4 instanceof Double ||
                   component4 instanceof BigDecimal) {
            // it's non null
            setComponent(4, SwiftFormatUtils.getLong(component4.longValue()));
        } else {
            // so it's a Number that failed instanceof Number => it's null
            setComponent(4, null);
        }
        return this;
    }

    /**
     * Set the ISN (component 4).
     *
     * @param component4 the ISN to set
     * @return the field object to enable build pattern
     */
    public Field11R setISN(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the ISN (component 4) from a Long object.
     *
     * @see #setComponent4(java.lang.Long)
     *
     * @param component4 Long with the ISN content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field11R setISN(java.lang.Long component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative method setter for field's ISN (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the ISN content to set
     * @return the field object to enable build pattern
     * @see #setISN(java.lang.Long)
     */
    public Field11R setISN(java.lang.Number component4) {
        return setComponent4(component4);
    }


    /**
     * Returns all components that can be converted to a Calendar
     *
     * @return the list of converted components (a Calendar object or null)
     */
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
     * Returns the field's name composed by the field number and the letter option (if any)
     * @return the static value of Field11R.NAME
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
    public static Field11R get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field11R(t) ;
    }

    /**
     * Gets the first instance of Field11R in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field11R get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return null;
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field11R in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field11R> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return java.util.Collections.emptyList();
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field11R from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field11R> getAll(final SwiftTagListBlock block) {
        final List<Field11R> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add( new Field11R(f));
            }
        }
        return result;
    }

    /**
     * Returns a specific line from the field's value.<br>
     *
     * @see MultiLineField#getLine(int)
     * @param line a reference to a specific line in the field, first line being 1
     * @return line content or null if not present or if line number is above the expected
     * @since 7.7
     */
    public String getLine(int line) {
        return getLine(line, 0);
    }

    /**
     * Returns a specific line from the field's value.<br>
     *
     * @see MultiLineField#getLine(int, int)
     * @param line a reference to a specific line in the field, first line being 1
     * @param offset an optional component number used as offset when counting lines
     * @return line content or null if not present or if line number is above the expected
     * @since 7.7
     */
    public String getLine(int line, int offset) {
        Field11R cp = newInstance(this);
        return getLine(cp, line, null, offset);
    }

    /**
     * Returns the field value split into lines.<br>
     *
     * @see MultiLineField#getLines()
     * @return lines content or empty list if field's value is empty
     * @since 7.7
     */
    public List<String> getLines() {
        return SwiftParseUtils.getLines(getValue());
    }

    /**
     * Returns the field value starting at the offset component, split into lines.<br>
     *
     * @see MultiLineField#getLines(int)
     * @param offset an optional component number used as offset when counting lines
     * @return found lines or empty list if lines are not present or the offset is invalid
     * @since 7.7
     */
    public List<String> getLines(int offset) {
        Field11R cp = newInstance(this);
        return SwiftParseUtils.getLines(getLine(cp, null, null, offset));
    }

    /**
     * Returns a specific subset of lines from the field's value, given a range.<br>
     *
     * @see MultiLineField#getLinesBetween(int, int )
     * @param start a reference to a specific line in the field, first line being 1
     * @param end a reference to a specific line in the field, must be greater than start
     * @return found lines or empty list if value is empty
     * @since 7.7
     */
    public List<String> getLinesBetween(int start, int end) {
        return getLinesBetween(start, end, 0);
    }

    /**
     * Returns a specific subset of lines from the field's value, starting at the offset component.<br>
     *
     * @see MultiLineField#getLinesBetween(int start, int end, int offset)
     * @param start a reference to a specific line in the field, first line being 1
     * @param end a reference to a specific line in the field, must be greater than start
     * @param offset an optional component number used as offset when counting lines
     * @return found lines or empty list if lines are not present or the offset is invalid
     * @since 7.7
     */
    public List<String> getLinesBetween(int start, int end, int offset) {
        Field11R cp = newInstance(this);
        return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
    }

    /**
     * This method deserializes the JSON data into a Field11R object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field11R fromJson(final String json) {

        Field11R field = new Field11R();

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(json);

        // **** COMPONENT 1 - MT Number

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("mT") != null) {
            field.setComponent1(jsonObject.get("mT").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("mTNumber") != null) {
            field.setComponent1(jsonObject.get("mTNumber").getAsString());
        }

        // **** COMPONENT 2 - Date

        if (jsonObject.get("date") != null) {
            field.setComponent2(jsonObject.get("date").getAsString());
        }

        // **** COMPONENT 3 - Session Number

        if (jsonObject.get("sessionNumber") != null) {
            field.setComponent3(jsonObject.get("sessionNumber").getAsString());
        }

        // **** COMPONENT 4 - ISN

        if (jsonObject.get("iSN") != null) {
            field.setComponent4(jsonObject.get("iSN").getAsString());
        }

        return field;
    }


}
