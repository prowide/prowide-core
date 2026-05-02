/*
 * Copyright 2006-2025 Prowide
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
import org.apache.commons.lang3.Strings;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 69G.
 * <p>
 * Model and parser for field 69G of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Qualifier: <code>String</code></li>
 * 		<li>Component 2: Date1: <code>Calendar</code></li>
 * 		<li>Component 3: Time1: <code>Calendar</code></li>
 * 		<li>Component 4: Decimals1: <code>Long</code></li>
 * 		<li>Component 5: Sign1: <code>String</code></li>
 * 		<li>Component 6: Offset1: <code>Calendar</code></li>
 * 		<li>Component 7: Date2: <code>Calendar</code></li>
 * 		<li>Component 8: Time2: <code>Calendar</code></li>
 * 		<li>Component 9: Decimals2: <code>Long</code></li>
 * 		<li>Component 10: Sign2: <code>String</code></li>
 * 		<li>Component 11: Offset2: <code>Calendar</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>:4!c//&lt;DATE4&gt;&lt;TIME2&gt;/[3n][/[N]&lt;TIME3&gt;]&lt;DATE4&gt;&lt;TIME2&gt;/[/3n][/[N]&lt;TIME3&gt;]</code></li>
 * 		<li>parser pattern: <code>:S//&lt;DATE4&gt;&lt;TIME2&gt;/[S][/[c]&lt;TIME3&gt;]&lt;DATE4&gt;&lt;TIME2&gt;/[/S][/[c]&lt;TIME3&gt;]</code></li>
 * 		<li>components pattern: <code>SDTNSWDTNSW</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2026</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field69G extends Field implements Serializable, DateContainer, GenericField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2026;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 69G.
	 */
    public static final String NAME = "69G";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_69G = "69G";

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
	 * Component number for the Decimals1 subfield.
	 */
	public static final Integer DECIMALS1 = 4;

	/**
	 * Component number for the Sign1 subfield.
	 */
	public static final Integer SIGN1 = 5;

	/**
	 * Component number for the Offset1 subfield.
	 */
	public static final Integer OFFSET1 = 6;

	/**
	 * Component number for the Date2 subfield.
	 */
	public static final Integer DATE2 = 7;

	/**
	 * Component number for the Time2 subfield.
	 */
	public static final Integer TIME2 = 8;

	/**
	 * Component number for the Decimals2 subfield.
	 */
	public static final Integer DECIMALS2 = 9;

	/**
	 * Component number for the Sign2 subfield.
	 */
	public static final Integer SIGN2 = 10;

	/**
	 * Component number for the Offset2 subfield.
	 */
	public static final Integer OFFSET2 = 11;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field69G() {
        super(11);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field69G(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field69G(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!Strings.CS.equals(tag.getName(), "69G")) {
            throw new IllegalArgumentException("cannot create field 69G from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field69G newInstance(Field69G source) {
        Field69G cp = new Field69G();
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
        init(11);
        setComponent1(SwiftParseUtils.getTokenFirst(value, ":", "//"));
        String toparse = SwiftParseUtils.getTokenSecondLast(value, "//");
        /* <DATE4><TIME2>/[3n][/[N]<TIME3>]<DATE4><TIME2>/[/3n][/[N]<TIME3>] */
        if (toparse != null && toparse.length() >= 14) {
            setComponent2(StringUtils.substring(toparse, 0, 8));
            setComponent3(StringUtils.substring(toparse, 8, 14));
            if (toparse.length() > 15 && toparse.charAt(14) == '/') {
                String rest = StringUtils.substring(toparse, 15);
                // Locate Date2: first occurrence of 14 consecutive digits followed by '/' or end-of-string,
                // scanning candidate offsets 0..9 (max length of first-half optional block: 3 decimals + '/' + sign + 4 TIME3)
                int date2Start = -1;
                for (int cand = 0; cand <= rest.length() - 14 && cand <= 9; cand++) {
                    boolean digits = true;
                    for (int k = 0; k < 14 && digits; k++) {
                        if (!Character.isDigit(rest.charAt(cand + k))) {
                            digits = false;
                        }
                    }
                    if (digits && (cand + 14 == rest.length() || rest.charAt(cand + 14) == '/')) {
                        date2Start = cand;
                        break;
                    }
                }
                if (date2Start >= 0) {
                    // First-half optionals: [3n][/[N]<TIME3>]
                    String firstOpt = StringUtils.substring(rest, 0, date2Start);
                    int sl1 = firstOpt.indexOf('/');
                    if (sl1 < 0) {
                        if (!firstOpt.isEmpty()) {
                            setComponent4(firstOpt);
                        }
                    } else {
                        if (sl1 > 0) {
                            setComponent4(StringUtils.substring(firstOpt, 0, sl1));
                        }
                        String off1 = StringUtils.substring(firstOpt, sl1 + 1);
                        if (!off1.isEmpty()) {
                            if (Character.isDigit(off1.charAt(0))) {
                                setComponent6(off1);
                            } else {
                                setComponent5(StringUtils.substring(off1, 0, 1));
                                if (off1.length() > 1) {
                                    setComponent6(StringUtils.substring(off1, 1));
                                }
                            }
                        }
                    }
                    // Date2 + Time2
                    setComponent7(StringUtils.substring(rest, date2Start, date2Start + 8));
                    setComponent8(StringUtils.substring(rest, date2Start + 8, date2Start + 14));
                    // Second-half optionals (after the mandatory '/' post Time2): [/3n][/[N]<TIME3>]
                    if (rest.length() > date2Start + 15) {
                        String secondOpt = StringUtils.substring(rest, date2Start + 15);
                        if (secondOpt.startsWith("/")) {
                            String afterSlash = StringUtils.substring(secondOpt, 1);
                            int sl2 = afterSlash.indexOf('/');
                            if (sl2 < 0) {
                                // Single chunk: decimals2 (1-3 digits) OR offset2
                                if (afterSlash.length() <= 3 && SwiftParseUtils.isAllAsciiDigits(afterSlash)) {
                                    setComponent9(afterSlash);
                                } else if (!afterSlash.isEmpty()) {
                                    if (Character.isDigit(afterSlash.charAt(0))) {
                                        setComponent11(afterSlash);
                                    } else {
                                        setComponent10(StringUtils.substring(afterSlash, 0, 1));
                                        if (afterSlash.length() > 1) {
                                            setComponent11(StringUtils.substring(afterSlash, 1));
                                        }
                                    }
                                }
                            } else {
                                // Two chunks: decimals2 / offset2
                                setComponent9(StringUtils.substring(afterSlash, 0, sl2));
                                String off2 = StringUtils.substring(afterSlash, sl2 + 1);
                                if (!off2.isEmpty()) {
                                    if (Character.isDigit(off2.charAt(0))) {
                                        setComponent11(off2);
                                    } else {
                                        setComponent10(StringUtils.substring(off2, 0, 1));
                                        if (off2.length() > 1) {
                                            setComponent11(StringUtils.substring(off2, 1));
                                        }
                                    }
                                }
                            }
                        }
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
        result.append("/");
        if (getComponent4() != null) {
            append(result, 4);
        }
        if (getComponent5() != null || getComponent6() != null) {
            result.append("/");
            append(result, 5);
            append(result, 6);
        }
        append(result, 7);
        append(result, 8);
        result.append("/");
        if (getComponent9() != null) {
            result.append("/").append(getComponent9());
        }
        if (getComponent10() != null || getComponent11() != null) {
            result.append("/");
            append(result, 10);
            append(result, 11);
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
        if (component < 1 || component > 11) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 69G");
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
        if (component == 6) {
            //time: HH[mm]
            java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
            java.util.Calendar cal = getComponent6AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
        }
        if (component == 7) {
            //date: [YY]YYMMDD
            java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, notNull(locale));
            java.util.Calendar cal = getComponent7AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
        }
        if (component == 8) {
            //time with seconds: HHmmss
            java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm:ss", notNull(locale));
            java.util.Calendar cal = getComponent8AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
        }
        if (component == 9) {
            //default format (as is)
            return getComponent(9);
        }
        if (component == 10) {
            //default format (as is)
            return getComponent(10);
        }
        // This is the last component, return directly without `if`
        //time: HH[mm]
        java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
        java.util.Calendar cal = getComponent11AsCalendar();
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
        return "SDTNSWDTNSW";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return ":S//<DATE4><TIME2>/[S][/[c]<TIME3>]<DATE4><TIME2>/[/S][/[c]<TIME3>]";
    }

    /**
     * Returns the field validator pattern.
     *
     * @deprecated Use {@code FieldPatternRegistry.getPattern()} from the Prowide Integrator Validation module instead.
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2026)
    @Override
    public String validatorPattern() {
        return ":4!c//<DATE4><TIME2>/[3n][/[N]<TIME3>]<DATE4><TIME2>/[/3n][/[N]<TIME3>]";
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
        if (component == 9) {
            return true;
        }
        if (component == 10) {
            return true;
        }
        if (component == 11) {
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
        return 11;
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
        result.add("Decimals1");
        result.add("Sign1");
        result.add("Offset1");
        result.add("Date2");
        result.add("Time2");
        result.add("Decimals2");
        result.add("Sign2");
        result.add("Offset2");
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
        result.put(4, "decimals1");
        result.put(5, "sign1");
        result.put(6, "offset1");
        result.put(7, "date2");
        result.put(8, "time2");
        result.put(9, "decimals2");
        result.put(10, "sign2");
        result.put(11, "offset2");
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
        super.labelMap.put("time1", 3);
        super.labelMap.put("decimals1", 4);
        super.labelMap.put("sign1", 5);
        super.labelMap.put("offset1", 6);
        super.labelMap.put("date2", 7);
        super.labelMap.put("time2", 8);
        super.labelMap.put("decimals2", 9);
        super.labelMap.put("sign2", 10);
        super.labelMap.put("offset2", 11);
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
     * Gets the component 4 (Decimals1).
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
     * Gets the Decimals1 (component 4).
     * @return the Decimals1 from component 4
     */
    public String getDecimals1() {
        return getComponent4();
    }

    /**
     * Get the Decimals1 (component 4) as Long
     * @return the Decimals1 from component 4 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getDecimals1AsLong() {
        return getComponent4AsLong();
    }

    /**
     * Gets the component 5 (Sign1).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Gets the Sign1 (component 5).
     * @return the Sign1 from component 5
     */
    public String getSign1() {
        return getComponent5();
    }

    /**
     * Gets the component 6 (Offset1).
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
     * Gets the Offset1 (component 6).
     * @return the Offset1 from component 6
     */
    public String getOffset1() {
        return getComponent6();
    }

    /**
     * Get the Offset1 (component 6) as Calendar
     * @return the Offset1 from component 6 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getOffset1AsCalendar() {
        return getComponent6AsCalendar();
    }

    /**
     * Gets the component 7 (Date2).
     * @return the component 7
     */
    public String getComponent7() {
        return getComponent(7);
    }

    /**
     * Get the component 7 as Calendar
     *
     * @return the component 7 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent7AsCalendar() {
        return SwiftFormatUtils.getDate4(getComponent(7));
    }

    /**
     * Gets the Date2 (component 7).
     * @return the Date2 from component 7
     */
    public String getDate2() {
        return getComponent7();
    }

    /**
     * Get the Date2 (component 7) as Calendar
     * @return the Date2 from component 7 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getDate2AsCalendar() {
        return getComponent7AsCalendar();
    }

    /**
     * Gets the component 8 (Time2).
     * @return the component 8
     */
    public String getComponent8() {
        return getComponent(8);
    }

    /**
     * Get the component 8 as Calendar
     *
     * @return the component 8 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent8AsCalendar() {
        return SwiftFormatUtils.getTime2(getComponent(8));
    }

    /**
     * Gets the Time2 (component 8).
     * @return the Time2 from component 8
     */
    public String getTime2() {
        return getComponent8();
    }

    /**
     * Get the Time2 (component 8) as Calendar
     * @return the Time2 from component 8 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getTime2AsCalendar() {
        return getComponent8AsCalendar();
    }

    /**
     * Gets the component 9 (Decimals2).
     * @return the component 9
     */
    public String getComponent9() {
        return getComponent(9);
    }

    /**
     * Get the component 9 as Long
     *
     * @return the component 9 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent9AsLong() {
        return SwiftFormatUtils.getLong(getComponent(9));
    }

    /**
     * Gets the Decimals2 (component 9).
     * @return the Decimals2 from component 9
     */
    public String getDecimals2() {
        return getComponent9();
    }

    /**
     * Get the Decimals2 (component 9) as Long
     * @return the Decimals2 from component 9 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getDecimals2AsLong() {
        return getComponent9AsLong();
    }

    /**
     * Gets the component 10 (Sign2).
     * @return the component 10
     */
    public String getComponent10() {
        return getComponent(10);
    }

    /**
     * Gets the Sign2 (component 10).
     * @return the Sign2 from component 10
     */
    public String getSign2() {
        return getComponent10();
    }

    /**
     * Gets the component 11 (Offset2).
     * @return the component 11
     */
    public String getComponent11() {
        return getComponent(11);
    }

    /**
     * Get the component 11 as Calendar
     *
     * @return the component 11 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent11AsCalendar() {
        return SwiftFormatUtils.getTime3(getComponent(11));
    }

    /**
     * Gets the Offset2 (component 11).
     * @return the Offset2 from component 11
     */
    public String getOffset2() {
        return getComponent11();
    }

    /**
     * Get the Offset2 (component 11) as Calendar
     * @return the Offset2 from component 11 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getOffset2AsCalendar() {
        return getComponent11AsCalendar();
    }

    /**
     * Set the component 1 (Qualifier).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Qualifier (component 1).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field69G setQualifier(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Date1).
     *
     * @param component2 the Date1 to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Calendar object.
     *
     * @param component2 the Calendar with the Date1 content to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent2(java.util.Calendar component2) {
        setComponent(2, SwiftFormatUtils.getDate4(component2));
        return this;
    }

    /**
     * Set the Date1 (component 2).
     *
     * @param component2 the Date1 to set
     * @return the field object to enable build pattern
     */
    public Field69G setDate1(String component2) {
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
    public Field69G setDate1(java.util.Calendar component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Time1).
     *
     * @param component3 the Time1 to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a Calendar object.
     *
     * @param component3 the Calendar with the Time1 content to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent3(java.util.Calendar component3) {
        setComponent(3, SwiftFormatUtils.getTime2(component3));
        return this;
    }

    /**
     * Set the Time1 (component 3).
     *
     * @param component3 the Time1 to set
     * @return the field object to enable build pattern
     */
    public Field69G setTime1(String component3) {
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
    public Field69G setTime1(java.util.Calendar component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Decimals1).
     *
     * @param component4 the Decimals1 to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }


    /**
     * Alternative method setter for field's Decimals1 (component 4) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Decimals1 content to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent4(java.lang.Number component4) {

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
     * Set the Decimals1 (component 4).
     *
     * @param component4 the Decimals1 to set
     * @return the field object to enable build pattern
     */
    public Field69G setDecimals1(String component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative method setter for field's Decimals1 (component 4) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Decimals1 content to set
     * @return the field object to enable build pattern
     */
    public Field69G setDecimals1(java.lang.Number component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Sign1).
     *
     * @param component5 the Sign1 to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the Sign1 (component 5).
     *
     * @param component5 the Sign1 to set
     * @return the field object to enable build pattern
     */
    public Field69G setSign1(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the component 6 (Offset1).
     *
     * @param component6 the Offset1 to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }

    /**
     * Set the component6 from a Calendar object.
     *
     * @param component6 the Calendar with the Offset1 content to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent6(java.util.Calendar component6) {
        setComponent(6, SwiftFormatUtils.getTime3(component6));
        return this;
    }

    /**
     * Set the Offset1 (component 6).
     *
     * @param component6 the Offset1 to set
     * @return the field object to enable build pattern
     */
    public Field69G setOffset1(String component6) {
        return setComponent6(component6);
    }

    /**
     * Set the Offset1 (component 6) from a Calendar object.
     *
     * @see #setComponent6(java.util.Calendar)
     *
     * @param component6 Calendar with the Offset1 content to set
     * @return the field object to enable build pattern
     */
    public Field69G setOffset1(java.util.Calendar component6) {
        return setComponent6(component6);
    }

    /**
     * Set the component 7 (Date2).
     *
     * @param component7 the Date2 to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent7(String component7) {
        setComponent(7, component7);
        return this;
    }

    /**
     * Set the component7 from a Calendar object.
     *
     * @param component7 the Calendar with the Date2 content to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent7(java.util.Calendar component7) {
        setComponent(7, SwiftFormatUtils.getDate4(component7));
        return this;
    }

    /**
     * Set the Date2 (component 7).
     *
     * @param component7 the Date2 to set
     * @return the field object to enable build pattern
     */
    public Field69G setDate2(String component7) {
        return setComponent7(component7);
    }

    /**
     * Set the Date2 (component 7) from a Calendar object.
     *
     * @see #setComponent7(java.util.Calendar)
     *
     * @param component7 Calendar with the Date2 content to set
     * @return the field object to enable build pattern
     */
    public Field69G setDate2(java.util.Calendar component7) {
        return setComponent7(component7);
    }

    /**
     * Set the component 8 (Time2).
     *
     * @param component8 the Time2 to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent8(String component8) {
        setComponent(8, component8);
        return this;
    }

    /**
     * Set the component8 from a Calendar object.
     *
     * @param component8 the Calendar with the Time2 content to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent8(java.util.Calendar component8) {
        setComponent(8, SwiftFormatUtils.getTime2(component8));
        return this;
    }

    /**
     * Set the Time2 (component 8).
     *
     * @param component8 the Time2 to set
     * @return the field object to enable build pattern
     */
    public Field69G setTime2(String component8) {
        return setComponent8(component8);
    }

    /**
     * Set the Time2 (component 8) from a Calendar object.
     *
     * @see #setComponent8(java.util.Calendar)
     *
     * @param component8 Calendar with the Time2 content to set
     * @return the field object to enable build pattern
     */
    public Field69G setTime2(java.util.Calendar component8) {
        return setComponent8(component8);
    }

    /**
     * Set the component 9 (Decimals2).
     *
     * @param component9 the Decimals2 to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent9(String component9) {
        setComponent(9, component9);
        return this;
    }


    /**
     * Alternative method setter for field's Decimals2 (component 9) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component9 the Number with the Decimals2 content to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent9(java.lang.Number component9) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component9 instanceof Long) {
            setComponent(9, SwiftFormatUtils.getLong((Long) component9));
        } else if (component9 instanceof BigInteger || component9 instanceof Integer) {
            setComponent(9, SwiftFormatUtils.getLong(component9.longValue()));
        } else if (component9 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(9, SwiftFormatUtils.getLong(component9.longValue()));
        } else {
            // explicitly set component as null
            setComponent(9, null);
        }
        return this;
    }

    /**
     * Set the Decimals2 (component 9).
     *
     * @param component9 the Decimals2 to set
     * @return the field object to enable build pattern
     */
    public Field69G setDecimals2(String component9) {
        return setComponent9(component9);
    }

    /**
     * Alternative method setter for field's Decimals2 (component 9) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component9 the Number with the Decimals2 content to set
     * @return the field object to enable build pattern
     */
    public Field69G setDecimals2(java.lang.Number component9) {
        return setComponent9(component9);
    }

    /**
     * Set the component 10 (Sign2).
     *
     * @param component10 the Sign2 to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent10(String component10) {
        setComponent(10, component10);
        return this;
    }

    /**
     * Set the Sign2 (component 10).
     *
     * @param component10 the Sign2 to set
     * @return the field object to enable build pattern
     */
    public Field69G setSign2(String component10) {
        return setComponent10(component10);
    }

    /**
     * Set the component 11 (Offset2).
     *
     * @param component11 the Offset2 to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent11(String component11) {
        setComponent(11, component11);
        return this;
    }

    /**
     * Set the component11 from a Calendar object.
     *
     * @param component11 the Calendar with the Offset2 content to set
     * @return the field object to enable build pattern
     */
    public Field69G setComponent11(java.util.Calendar component11) {
        setComponent(11, SwiftFormatUtils.getTime3(component11));
        return this;
    }

    /**
     * Set the Offset2 (component 11).
     *
     * @param component11 the Offset2 to set
     * @return the field object to enable build pattern
     */
    public Field69G setOffset2(String component11) {
        return setComponent11(component11);
    }

    /**
     * Set the Offset2 (component 11) from a Calendar object.
     *
     * @see #setComponent11(java.util.Calendar)
     *
     * @param component11 Calendar with the Offset2 content to set
     * @return the field object to enable build pattern
     */
    public Field69G setOffset2(java.util.Calendar component11) {
        return setComponent11(component11);
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
     * @return the static value of Field69G.NAME
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
    public static Field69G get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field69G(t);
    }

    /**
     * Gets the first instance of Field69G in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field69G get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field69G in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field69G> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field69G from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field69G> getAll(final SwiftTagListBlock block) {
        final List<Field69G> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field69G(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field69G object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field69G fromJson(final String json) {

        final Field69G field = new Field69G();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Qualifier

        if (jsonObject.get("qualifier") != null) {
            field.setComponent1(jsonObject.get("qualifier").getAsString());
        }

        // **** COMPONENT 2 - Date1

        if (jsonObject.get("date1") != null) {
            field.setComponent2(jsonObject.get("date1").getAsString());
        }

        // **** COMPONENT 3 - Time1

        if (jsonObject.get("time1") != null) {
            field.setComponent3(jsonObject.get("time1").getAsString());
        }

        // **** COMPONENT 4 - Decimals1

        if (jsonObject.get("decimals1") != null) {
            field.setComponent4(jsonObject.get("decimals1").getAsString());
        }

        // **** COMPONENT 5 - Sign1

        if (jsonObject.get("sign1") != null) {
            field.setComponent5(jsonObject.get("sign1").getAsString());
        }

        // **** COMPONENT 6 - Offset1

        if (jsonObject.get("offset1") != null) {
            field.setComponent6(jsonObject.get("offset1").getAsString());
        }

        // **** COMPONENT 7 - Date2

        if (jsonObject.get("date2") != null) {
            field.setComponent7(jsonObject.get("date2").getAsString());
        }

        // **** COMPONENT 8 - Time2

        if (jsonObject.get("time2") != null) {
            field.setComponent8(jsonObject.get("time2").getAsString());
        }

        // **** COMPONENT 9 - Decimals2

        if (jsonObject.get("decimals2") != null) {
            field.setComponent9(jsonObject.get("decimals2").getAsString());
        }

        // **** COMPONENT 10 - Sign2

        if (jsonObject.get("sign2") != null) {
            field.setComponent10(jsonObject.get("sign2").getAsString());
        }

        // **** COMPONENT 11 - Offset2

        if (jsonObject.get("offset2") != null) {
            field.setComponent11(jsonObject.get("offset2").getAsString());
        }

        return field;
    }


}
