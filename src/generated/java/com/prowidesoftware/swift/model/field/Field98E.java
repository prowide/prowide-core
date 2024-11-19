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
 * SWIFT MT Field 98E.
 * <p>
 * Model and parser for field 98E of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Qualifier: <code>String</code></li>
 * 		<li>Component 2: Date: <code>Calendar</code></li>
 * 		<li>Component 3: Time: <code>Calendar</code></li>
 * 		<li>Component 4: Decimals: <code>Long</code></li>
 * 		<li>Component 5: Sign: <code>String</code></li>
 * 		<li>Component 6: Offset: <code>Calendar</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>:4!c//&lt;DATE4&gt;&lt;TIME2&gt;[,3n][/[&lt;N&gt;]&lt;TIME3&gt;]</code></li>
 * 		<li>parser pattern: <code>:S//&lt;DATE4&gt;&lt;TIME2&gt;[,S][/[c]&lt;TIME3&gt;]</code></li>
 * 		<li>components pattern: <code>SDTNSW</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field98E extends Field implements Serializable, DateContainer, GenericField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 98E.
	 */
    public static final String NAME = "98E";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_98E = "98E";

	/**
	 * Component number for the Qualifier subfield.
	 */
	public static final Integer QUALIFIER = 1;

	/**
	 * Component number for the Date subfield.
	 */
	public static final Integer DATE = 2;

	/**
	 * Component number for the Time subfield.
	 */
	public static final Integer TIME = 3;

	/**
	 * Component number for the Decimals subfield.
	 */
	public static final Integer DECIMALS = 4;

	/**
	 * Component number for the Sign subfield.
	 */
	public static final Integer SIGN = 5;

	/**
	 * Component number for the Offset subfield.
	 */
	public static final Integer OFFSET = 6;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field98E() {
        super(6);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field98E(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field98E(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "98E")) {
            throw new IllegalArgumentException("cannot create field 98E from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field98E newInstance(Field98E source) {
        Field98E cp = new Field98E();
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
        init(6);
		setComponent1(SwiftParseUtils.getTokenFirst(value, ":", "//"));
		String toparse = SwiftParseUtils.getTokenSecondLast(value, "//"); /* <DATE4><TIME2>[,S][/[c]<TIME3>] */
		if (toparse != null) {
			if (toparse.length() >= 8) {
				setComponent2(StringUtils.substring(toparse, 0, 8));
			}
			if (toparse.length() >= 14) {
				setComponent3(StringUtils.substring(toparse, 8, 14));
			}
			if (toparse.length() > 14) {
			    String toparse2 = StringUtils.substring(toparse, 14);
			    setComponent4(SwiftParseUtils.getTokenFirst(toparse2, ",", "/"));
			    String toparse3 = SwiftParseUtils.getTokenSecondLast(toparse2, "/");
			    if (toparse3 != null) {
					if (toparse3.length() < 2) {
					    setComponent5(toparse3);
					} else if (toparse3.length() == 2 || toparse3.length() == 4) {
					    //HH or HH[MM]
					    setComponent6(toparse3);
					} else if (toparse3.length() == 3 || toparse3.length() == 5) {
					    //[N]HH or [N]HH[MM]
					    setComponent5(StringUtils.substring(toparse3, 0, 1));
					    setComponent6(StringUtils.substring(toparse3, 1));
					} else if (toparse3.length() > 4) {
					    setComponent5(SwiftParseUtils.getAlphaPrefixTrimSlash(toparse3));
					    setComponent6(SwiftParseUtils.getNumericSuffix(toparse3));
					}
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
        result.append(":");
        append(result, 1);
        result.append("//");
        append(result, 2);
        append(result, 3);
        if (getComponent4() != null) {
            result.append(",").append(getComponent4());
        }
        if (getComponent5() != null || getComponent6() != null) {
            result.append("/");
            append(result, 5);
            append(result, 6);
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
        if (component < 1 || component > 6) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 98E");
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
            //default format (as is)
            return getComponent(4);
        }
        if (component == 5) {
            //default format (as is)
            return getComponent(5);
        }
        // This is the last component, return directly without `if`
        //time: HH[mm]
        java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
        java.util.Calendar cal = getComponent6AsCalendar();
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
        return "SDTNSW";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return ":S//<DATE4><TIME2>[,S][/[c]<TIME3>]";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return ":4!c//<DATE4><TIME2>[,3n][/[<N>]<TIME3>]";
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
        if (component == 4) {
            return true;
        }
        if (component == 5) {
            return true;
        }
        if (component == 6) {
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
        return 6;
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
        result.add("Date");
        result.add("Time");
        result.add("Decimals");
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
        result.put(1, "qualifier");
        result.put(2, "date");
        result.put(3, "time");
        result.put(4, "decimals");
        result.put(5, "sign");
        result.put(6, "offset");
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
        super.labelMap.put("date", 2);
        super.labelMap.put("time", 3);
        super.labelMap.put("decimals", 4);
        super.labelMap.put("sign", 5);
        super.labelMap.put("offset", 6);
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
     * Gets the component 3 (Time).
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
     * Gets the Time (component 3).
     * @return the Time from component 3
     */
    public String getTime() {
        return getComponent3();
    }

    /**
     * Get the Time (component 3) as Calendar
     * @return the Time from component 3 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getTimeAsCalendar() {
        return getComponent3AsCalendar();
    }

    /**
     * Gets the component 4 (Decimals).
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
     * Gets the Decimals (component 4).
     * @return the Decimals from component 4
     */
    public String getDecimals() {
        return getComponent4();
    }

    /**
     * Get the Decimals (component 4) as Long
     * @return the Decimals from component 4 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getDecimalsAsLong() {
        return getComponent4AsLong();
    }

    /**
     * Gets the component 5 (Sign).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Gets the Sign (component 5).
     * @return the Sign from component 5
     */
    public String getSign() {
        return getComponent5();
    }

    /**
     * Gets the component 6 (Offset).
     * @return the component 6
     */
    public String getComponent6() {
        return getComponent(6);
    }

    /**
     * Get the component 6 as Calendar
     *
     * @return the component 6 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent6AsCalendar() {
        return SwiftFormatUtils.getTime3(getComponent(6));
    }

    /**
     * Gets the Offset (component 6).
     * @return the Offset from component 6
     */
    public String getOffset() {
        return getComponent6();
    }

    /**
     * Get the Offset (component 6) as Calendar
     * @return the Offset from component 6 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getOffsetAsCalendar() {
        return getComponent6AsCalendar();
    }

    /**
     * Set the component 1 (Qualifier).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field98E setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Qualifier (component 1).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field98E setQualifier(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Date).
     *
     * @param component2 the Date to set
     * @return the field object to enable build pattern
     */
    public Field98E setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Calendar object.
     *
     * @param component2 the Calendar with the Date content to set
     * @return the field object to enable build pattern
     */
    public Field98E setComponent2(java.util.Calendar component2) {
        setComponent(2, SwiftFormatUtils.getDate4(component2));
        return this;
    }

    /**
     * Set the Date (component 2).
     *
     * @param component2 the Date to set
     * @return the field object to enable build pattern
     */
    public Field98E setDate(String component2) {
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
    public Field98E setDate(java.util.Calendar component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Time).
     *
     * @param component3 the Time to set
     * @return the field object to enable build pattern
     */
    public Field98E setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a Calendar object.
     *
     * @param component3 the Calendar with the Time content to set
     * @return the field object to enable build pattern
     */
    public Field98E setComponent3(java.util.Calendar component3) {
        setComponent(3, SwiftFormatUtils.getTime2(component3));
        return this;
    }

    /**
     * Set the Time (component 3).
     *
     * @param component3 the Time to set
     * @return the field object to enable build pattern
     */
    public Field98E setTime(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Time (component 3) from a Calendar object.
     *
     * @see #setComponent3(java.util.Calendar)
     *
     * @param component3 Calendar with the Time content to set
     * @return the field object to enable build pattern
     */
    public Field98E setTime(java.util.Calendar component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Decimals).
     *
     * @param component4 the Decimals to set
     * @return the field object to enable build pattern
     */
    public Field98E setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }


    /**
     * Alternative method setter for field's Decimals (component 4) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Decimals content to set
     * @return the field object to enable build pattern
     */
    public Field98E setComponent4(java.lang.Number component4) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component4 instanceof Long) {
            setComponent(4, SwiftFormatUtils.getLong((Long) component4));
        } else if (component4 instanceof BigInteger || component4 instanceof Integer) {
            setComponent(4, SwiftFormatUtils.getLong(component4.longValue()));
        } else if (component4 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(4, SwiftFormatUtils.getLong(component4.longValue()));
        } else {
            // explicitly set component as null
            setComponent(4, null);
        }
        return this;
    }

    /**
     * Set the Decimals (component 4).
     *
     * @param component4 the Decimals to set
     * @return the field object to enable build pattern
     */
    public Field98E setDecimals(String component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative method setter for field's Decimals (component 4) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Decimals content to set
     * @return the field object to enable build pattern
     */
    public Field98E setDecimals(java.lang.Number component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Sign).
     *
     * @param component5 the Sign to set
     * @return the field object to enable build pattern
     */
    public Field98E setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the Sign (component 5).
     *
     * @param component5 the Sign to set
     * @return the field object to enable build pattern
     */
    public Field98E setSign(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the component 6 (Offset).
     *
     * @param component6 the Offset to set
     * @return the field object to enable build pattern
     */
    public Field98E setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }

    /**
     * Set the component6 from a Calendar object.
     *
     * @param component6 the Calendar with the Offset content to set
     * @return the field object to enable build pattern
     */
    public Field98E setComponent6(java.util.Calendar component6) {
        setComponent(6, SwiftFormatUtils.getTime3(component6));
        return this;
    }

    /**
     * Set the Offset (component 6).
     *
     * @param component6 the Offset to set
     * @return the field object to enable build pattern
     */
    public Field98E setOffset(String component6) {
        return setComponent6(component6);
    }

    /**
     * Set the Offset (component 6) from a Calendar object.
     *
     * @see #setComponent6(java.util.Calendar)
     *
     * @param component6 Calendar with the Offset content to set
     * @return the field object to enable build pattern
     */
    public Field98E setOffset(java.util.Calendar component6) {
        return setComponent6(component6);
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
     * @return the static value of Field98E.NAME
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
    public static Field98E get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field98E(t);
    }

    /**
     * Gets the first instance of Field98E in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field98E get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field98E in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field98E> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field98E from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field98E> getAll(final SwiftTagListBlock block) {
        final List<Field98E> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field98E(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field98E object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field98E fromJson(final String json) {

        final Field98E field = new Field98E();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Qualifier

        if (jsonObject.get("qualifier") != null) {
            field.setComponent1(jsonObject.get("qualifier").getAsString());
        }

        // **** COMPONENT 2 - Date

        if (jsonObject.get("date") != null) {
            field.setComponent2(jsonObject.get("date").getAsString());
        }

        // **** COMPONENT 3 - Time

        if (jsonObject.get("time") != null) {
            field.setComponent3(jsonObject.get("time").getAsString());
        }

        // **** COMPONENT 4 - Decimals

        if (jsonObject.get("decimals") != null) {
            field.setComponent4(jsonObject.get("decimals").getAsString());
        }

        // **** COMPONENT 5 - Sign

        if (jsonObject.get("sign") != null) {
            field.setComponent5(jsonObject.get("sign").getAsString());
        }

        // **** COMPONENT 6 - Offset

        if (jsonObject.get("offset") != null) {
            field.setComponent6(jsonObject.get("offset").getAsString());
        }

        return field;
    }

	/**
	 * Get the ISO UTC Indicator combining the sign and offset, and changing the "N" negative sign indication by
	 * proper +/- signs
	 * @return the the UTC indicator such as +0100 or -0300
	 */
	public String getUtcIndicator() {
	    if (getOffset() != null) {
            if (getSign() != null && getSign().equals("N")) {
                return "-" + StringUtils.trimToEmpty(getOffset());
            } else {
                return "+" + StringUtils.trimToEmpty(getOffset());
            }
	    }
	    return null;
	}

}
