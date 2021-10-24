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


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 330</strong>
 * <p>
 * Model and parser for field 330 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>Long</code></li>
 * 		<li><code>Long</code></li>
 * 		<li><code>Long</code></li>
 * 		<li><code>Long</code></li>
 * 		<li><code>Long</code></li>
 * 		<li><code>Long</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>4!n6!n6!n6!n6!n1!n</code></li>
 * 		<li>parser pattern: <code>4!N6!N6!N6!N6!N1!N</code></li>
 * 		<li>components pattern: <code>NNNNNN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field330 extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 330
	 */
    public static final String NAME = "330";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_330 = "330";
	public static final String PARSER_PATTERN = "4!N6!N6!N6!N6!N1!N";

    /**
     * Components pattern
     *
     * Contains a description of the type for every component. This is <em>DEPRECATED</em>,
     * use TYPES_PATTERN instead, because it distinguishes between N (number) and I (BigDecimal)
     * @see #TYPES_PATTERN
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "NNNNNN";

    /**
     * Types pattern
     *
     * Contains a description of the type for every component, use instead of COMPONENTS_PATTERN.
     * @since 9.2.7
     */
	public static final String TYPES_PATTERN = "NNNNNN";

	/**
	 * Component number for the Session Number subfield
	 */
	public static final Integer SESSION_NUMBER = 1;

	/**
	 * Component number for the ISN subfield
	 */
	public static final Integer ISN = 2;

	/**
	 * Component number for the ISN NAK subfield
	 */
	public static final Integer ISN_NAK = 3;

	/**
	 * Component number for the OSN subfield
	 */
	public static final Integer OSN = 4;

	/**
	 * Component number for the OSN NAK subfield
	 */
	public static final Integer OSN_NAK = 5;

	/**
	 * Component number for the ACK Replay Indicator subfield
	 */
	public static final Integer ACK_REPLAY_INDICATOR = 6;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field330() {
        super(6);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field330(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field330(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "330")) {
            throw new IllegalArgumentException("cannot create field 330 from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.<br>
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field330 newInstance(Field330 source) {
        Field330 cp = new Field330();
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
        init(6);
        if (value != null) {
            if (value.length() >= 4) {
                setComponent1(StringUtils.substring(value, 0, 4));
            }
            if (value.length() >= 10) {
                setComponent2(StringUtils.substring(value, 4, 10));
            }
            if (value.length() >= 16) {
                setComponent3(StringUtils.substring(value, 10, 16));
            }
            if (value.length() >= 22) {
                setComponent4(StringUtils.substring(value, 16, 22));
            }
            if (value.length() >= 28) {
                setComponent5(StringUtils.substring(value, 22, 28));
            }
            if (value.length() > 28) {
                setComponent6(StringUtils.substring(value, 28));
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
        if (component < 1 || component > 6) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 330");
        }
        if (component == 1) {
            //number, amount, rate
            java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
            f.setMaximumFractionDigits(13);
            Number n = getComponent1AsNumber();
            if (n != null) {
                return f.format(n);
            }
        }
        if (component == 2) {
            //number, amount, rate
            java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
            f.setMaximumFractionDigits(13);
            Number n = getComponent2AsNumber();
            if (n != null) {
                return f.format(n);
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
        if (component == 5) {
            //number, amount, rate
            java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
            f.setMaximumFractionDigits(13);
            Number n = getComponent5AsNumber();
            if (n != null) {
                return f.format(n);
            }
        }
        if (component == 6) {
            //number, amount, rate
            java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
            f.setMaximumFractionDigits(13);
            Number n = getComponent6AsNumber();
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
     * @return the static value of Field330.COMPONENTS_PATTERN
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
     * @return the static value of Field330.TYPES_PATTERN
     */
    @Override
    public final String typesPattern() {
        return TYPES_PATTERN;
    }

    /**
     * Returns the field parser pattern
     * @return the static value of Field330.PARSER_PATTERN
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
        return "4!n6!n6!n6!n6!n1!n";
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
    protected List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Session Number");
        result.add("ISN");
        result.add("ISN NAK");
        result.add("OSN");
        result.add("OSN NAK");
        result.add("ACK Replay Indicator");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "sessionNumber");
        result.put(2, "iSN");
        result.put(3, "iSNNAK");
        result.put(4, "oSN");
        result.put(5, "oSNNAK");
        result.put(6, "aCKReplayIndicator");
        return result;
    }


    /**
     * Gets the component 1 (Session Number).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Get the component 1 as Long
     *
     * @return the component 1 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent1AsLong() {
        return SwiftFormatUtils.getLong(getComponent(1));
    }

    /**
     * Get the component 1 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent1AsLong()</code> to get the proper value.
     *
     * @return the component 1 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent1AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getComponent1AsNumber() {
        Long l = getComponent1AsLong();
        return l != null ? new BigDecimal(l) : null;
    }

    /**
     * Gets the Session Number (component 1).
     * @return the Session Number from component 1
     */
    public String getSessionNumber() {
        return getComponent1();
    }

    /**
     * Get the Session Number (component 1) as Long
     * @return the Session Number from component 1 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getSessionNumberAsLong() {
        return getComponent1AsLong();
    }

    /**
     * Get the Session Number (component 1) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent1AsLong()</code> to get the proper value.
     *
     * @return the component 1 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getSessionNumberAsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getSessionNumberAsNumber() {
        return getComponent1AsNumber();
    }

    /**
     * Gets the component 2 (ISN).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Get the component 2 as Long
     *
     * @return the component 2 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent2AsLong() {
        return SwiftFormatUtils.getLong(getComponent(2));
    }

    /**
     * Get the component 2 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent2AsLong()</code> to get the proper value.
     *
     * @return the component 2 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent2AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getComponent2AsNumber() {
        Long l = getComponent2AsLong();
        return l != null ? new BigDecimal(l) : null;
    }

    /**
     * Gets the ISN (component 2).
     * @return the ISN from component 2
     */
    public String getISN() {
        return getComponent2();
    }

    /**
     * Get the ISN (component 2) as Long
     * @return the ISN from component 2 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getISNAsLong() {
        return getComponent2AsLong();
    }

    /**
     * Get the ISN (component 2) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent2AsLong()</code> to get the proper value.
     *
     * @return the component 2 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getISNAsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getISNAsNumber() {
        return getComponent2AsNumber();
    }

    /**
     * Gets the component 3 (ISN NAK).
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
     * Gets the ISN NAK (component 3).
     * @return the ISN NAK from component 3
     */
    public String getISNNAK() {
        return getComponent3();
    }

    /**
     * Get the ISN NAK (component 3) as Long
     * @return the ISN NAK from component 3 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getISNNAKAsLong() {
        return getComponent3AsLong();
    }

    /**
     * Get the ISN NAK (component 3) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent3AsLong()</code> to get the proper value.
     *
     * @return the component 3 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getISNNAKAsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getISNNAKAsNumber() {
        return getComponent3AsNumber();
    }

    /**
     * Gets the component 4 (OSN).
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
     * Gets the OSN (component 4).
     * @return the OSN from component 4
     */
    public String getOSN() {
        return getComponent4();
    }

    /**
     * Get the OSN (component 4) as Long
     * @return the OSN from component 4 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getOSNAsLong() {
        return getComponent4AsLong();
    }

    /**
     * Get the OSN (component 4) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent4AsLong()</code> to get the proper value.
     *
     * @return the component 4 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getOSNAsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getOSNAsNumber() {
        return getComponent4AsNumber();
    }

    /**
     * Gets the component 5 (OSN NAK).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Get the component 5 as Long
     *
     * @return the component 5 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent5AsLong() {
        return SwiftFormatUtils.getLong(getComponent(5));
    }

    /**
     * Get the component 5 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent5AsLong()</code> to get the proper value.
     *
     * @return the component 5 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent5AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getComponent5AsNumber() {
        Long l = getComponent5AsLong();
        return l != null ? new BigDecimal(l) : null;
    }

    /**
     * Gets the OSN NAK (component 5).
     * @return the OSN NAK from component 5
     */
    public String getOSNNAK() {
        return getComponent5();
    }

    /**
     * Get the OSN NAK (component 5) as Long
     * @return the OSN NAK from component 5 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getOSNNAKAsLong() {
        return getComponent5AsLong();
    }

    /**
     * Get the OSN NAK (component 5) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent5AsLong()</code> to get the proper value.
     *
     * @return the component 5 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getOSNNAKAsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getOSNNAKAsNumber() {
        return getComponent5AsNumber();
    }

    /**
     * Gets the component 6 (ACK Replay Indicator).
     * @return the component 6
     */
    public String getComponent6() {
        return getComponent(6);
    }

    /**
     * Get the component 6 as Long
     *
     * @return the component 6 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent6AsLong() {
        return SwiftFormatUtils.getLong(getComponent(6));
    }

    /**
     * Get the component 6 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent6AsLong()</code> to get the proper value.
     *
     * @return the component 6 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent6AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getComponent6AsNumber() {
        Long l = getComponent6AsLong();
        return l != null ? new BigDecimal(l) : null;
    }

    /**
     * Gets the ACK Replay Indicator (component 6).
     * @return the ACK Replay Indicator from component 6
     */
    public String getACKReplayIndicator() {
        return getComponent6();
    }

    /**
     * Get the ACK Replay Indicator (component 6) as Long
     * @return the ACK Replay Indicator from component 6 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getACKReplayIndicatorAsLong() {
        return getComponent6AsLong();
    }

    /**
     * Get the ACK Replay Indicator (component 6) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent6AsLong()</code> to get the proper value.
     *
     * @return the component 6 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getACKReplayIndicatorAsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getACKReplayIndicatorAsNumber() {
        return getComponent6AsNumber();
    }

    /**
     * Set the component 1 (Session Number).
     *
     * @param component1 the Session Number to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the component1 from a Long object.
     * <br>
     * <em>If the component being set is a fixed length number, the argument will not be
     * padded.</em> It is recommended for these cases to use the setComponent1(String)
     * method.
     *
     * @see #setComponent1(String)
     * @since 9.2.7
     *
     * @param component1 the Long with the Session Number content to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent1(java.lang.Long component1) {
        setComponent(1, SwiftFormatUtils.getLong(component1));
        return this;
    }

    /**
     * Alternative method setter for field's Session Number (component 1) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Session Number content to set
     * @return the field object to enable build pattern
     * @see #setSessionNumber(java.lang.Long)
     */
    public Field330 setComponent1(java.lang.Number component1) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component1 instanceof Long) {
            setComponent(1, SwiftFormatUtils.getLong( (Long) component1));
        } else if (component1 instanceof BigInteger || component1 instanceof Integer) {
            setComponent(1, SwiftFormatUtils.getLong(component1.longValue()));
        } else if (component1 instanceof Float || component1 instanceof Double ||
                   component1 instanceof BigDecimal) {
            // it's non null
            setComponent(1, SwiftFormatUtils.getLong(component1.longValue()));
        } else {
            // so it's a Number that failed instanceof Number => it's null
            setComponent(1, null);
        }
        return this;
    }

    /**
     * Set the Session Number (component 1).
     *
     * @param component1 the Session Number to set
     * @return the field object to enable build pattern
     */
    public Field330 setSessionNumber(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the Session Number (component 1) from a Long object.
     *
     * @see #setComponent1(java.lang.Long)
     *
     * @param component1 Long with the Session Number content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field330 setSessionNumber(java.lang.Long component1) {
        return setComponent1(component1);
    }

    /**
     * Alternative method setter for field's Session Number (component 1) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Session Number content to set
     * @return the field object to enable build pattern
     * @see #setSessionNumber(java.lang.Long)
     */
    public Field330 setSessionNumber(java.lang.Number component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (ISN).
     *
     * @param component2 the ISN to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Long object.
     * <br>
     * <em>If the component being set is a fixed length number, the argument will not be
     * padded.</em> It is recommended for these cases to use the setComponent2(String)
     * method.
     *
     * @see #setComponent2(String)
     * @since 9.2.7
     *
     * @param component2 the Long with the ISN content to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent2(java.lang.Long component2) {
        setComponent(2, SwiftFormatUtils.getLong(component2));
        return this;
    }

    /**
     * Alternative method setter for field's ISN (component 2) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the ISN content to set
     * @return the field object to enable build pattern
     * @see #setISN(java.lang.Long)
     */
    public Field330 setComponent2(java.lang.Number component2) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component2 instanceof Long) {
            setComponent(2, SwiftFormatUtils.getLong( (Long) component2));
        } else if (component2 instanceof BigInteger || component2 instanceof Integer) {
            setComponent(2, SwiftFormatUtils.getLong(component2.longValue()));
        } else if (component2 instanceof Float || component2 instanceof Double ||
                   component2 instanceof BigDecimal) {
            // it's non null
            setComponent(2, SwiftFormatUtils.getLong(component2.longValue()));
        } else {
            // so it's a Number that failed instanceof Number => it's null
            setComponent(2, null);
        }
        return this;
    }

    /**
     * Set the ISN (component 2).
     *
     * @param component2 the ISN to set
     * @return the field object to enable build pattern
     */
    public Field330 setISN(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the ISN (component 2) from a Long object.
     *
     * @see #setComponent2(java.lang.Long)
     *
     * @param component2 Long with the ISN content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field330 setISN(java.lang.Long component2) {
        return setComponent2(component2);
    }

    /**
     * Alternative method setter for field's ISN (component 2) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the ISN content to set
     * @return the field object to enable build pattern
     * @see #setISN(java.lang.Long)
     */
    public Field330 setISN(java.lang.Number component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (ISN NAK).
     *
     * @param component3 the ISN NAK to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent3(String component3) {
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
     * @param component3 the Long with the ISN NAK content to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent3(java.lang.Long component3) {
        setComponent(3, SwiftFormatUtils.getLong(component3));
        return this;
    }

    /**
     * Alternative method setter for field's ISN NAK (component 3) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the ISN NAK content to set
     * @return the field object to enable build pattern
     * @see #setISNNAK(java.lang.Long)
     */
    public Field330 setComponent3(java.lang.Number component3) {

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
     * Set the ISN NAK (component 3).
     *
     * @param component3 the ISN NAK to set
     * @return the field object to enable build pattern
     */
    public Field330 setISNNAK(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the ISN NAK (component 3) from a Long object.
     *
     * @see #setComponent3(java.lang.Long)
     *
     * @param component3 Long with the ISN NAK content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field330 setISNNAK(java.lang.Long component3) {
        return setComponent3(component3);
    }

    /**
     * Alternative method setter for field's ISN NAK (component 3) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the ISN NAK content to set
     * @return the field object to enable build pattern
     * @see #setISNNAK(java.lang.Long)
     */
    public Field330 setISNNAK(java.lang.Number component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (OSN).
     *
     * @param component4 the OSN to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent4(String component4) {
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
     * @param component4 the Long with the OSN content to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent4(java.lang.Long component4) {
        setComponent(4, SwiftFormatUtils.getLong(component4));
        return this;
    }

    /**
     * Alternative method setter for field's OSN (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the OSN content to set
     * @return the field object to enable build pattern
     * @see #setOSN(java.lang.Long)
     */
    public Field330 setComponent4(java.lang.Number component4) {

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
     * Set the OSN (component 4).
     *
     * @param component4 the OSN to set
     * @return the field object to enable build pattern
     */
    public Field330 setOSN(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the OSN (component 4) from a Long object.
     *
     * @see #setComponent4(java.lang.Long)
     *
     * @param component4 Long with the OSN content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field330 setOSN(java.lang.Long component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative method setter for field's OSN (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the OSN content to set
     * @return the field object to enable build pattern
     * @see #setOSN(java.lang.Long)
     */
    public Field330 setOSN(java.lang.Number component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (OSN NAK).
     *
     * @param component5 the OSN NAK to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the component5 from a Long object.
     * <br>
     * <em>If the component being set is a fixed length number, the argument will not be
     * padded.</em> It is recommended for these cases to use the setComponent5(String)
     * method.
     *
     * @see #setComponent5(String)
     * @since 9.2.7
     *
     * @param component5 the Long with the OSN NAK content to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent5(java.lang.Long component5) {
        setComponent(5, SwiftFormatUtils.getLong(component5));
        return this;
    }

    /**
     * Alternative method setter for field's OSN NAK (component 5) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component5 the Number with the OSN NAK content to set
     * @return the field object to enable build pattern
     * @see #setOSNNAK(java.lang.Long)
     */
    public Field330 setComponent5(java.lang.Number component5) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component5 instanceof Long) {
            setComponent(5, SwiftFormatUtils.getLong( (Long) component5));
        } else if (component5 instanceof BigInteger || component5 instanceof Integer) {
            setComponent(5, SwiftFormatUtils.getLong(component5.longValue()));
        } else if (component5 instanceof Float || component5 instanceof Double ||
                   component5 instanceof BigDecimal) {
            // it's non null
            setComponent(5, SwiftFormatUtils.getLong(component5.longValue()));
        } else {
            // so it's a Number that failed instanceof Number => it's null
            setComponent(5, null);
        }
        return this;
    }

    /**
     * Set the OSN NAK (component 5).
     *
     * @param component5 the OSN NAK to set
     * @return the field object to enable build pattern
     */
    public Field330 setOSNNAK(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the OSN NAK (component 5) from a Long object.
     *
     * @see #setComponent5(java.lang.Long)
     *
     * @param component5 Long with the OSN NAK content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field330 setOSNNAK(java.lang.Long component5) {
        return setComponent5(component5);
    }

    /**
     * Alternative method setter for field's OSN NAK (component 5) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component5 the Number with the OSN NAK content to set
     * @return the field object to enable build pattern
     * @see #setOSNNAK(java.lang.Long)
     */
    public Field330 setOSNNAK(java.lang.Number component5) {
        return setComponent5(component5);
    }

    /**
     * Set the component 6 (ACK Replay Indicator).
     *
     * @param component6 the ACK Replay Indicator to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }

    /**
     * Set the component6 from a Long object.
     * <br>
     * <em>If the component being set is a fixed length number, the argument will not be
     * padded.</em> It is recommended for these cases to use the setComponent6(String)
     * method.
     *
     * @see #setComponent6(String)
     * @since 9.2.7
     *
     * @param component6 the Long with the ACK Replay Indicator content to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent6(java.lang.Long component6) {
        setComponent(6, SwiftFormatUtils.getLong(component6));
        return this;
    }

    /**
     * Alternative method setter for field's ACK Replay Indicator (component 6) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component6 the Number with the ACK Replay Indicator content to set
     * @return the field object to enable build pattern
     * @see #setACKReplayIndicator(java.lang.Long)
     */
    public Field330 setComponent6(java.lang.Number component6) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component6 instanceof Long) {
            setComponent(6, SwiftFormatUtils.getLong( (Long) component6));
        } else if (component6 instanceof BigInteger || component6 instanceof Integer) {
            setComponent(6, SwiftFormatUtils.getLong(component6.longValue()));
        } else if (component6 instanceof Float || component6 instanceof Double ||
                   component6 instanceof BigDecimal) {
            // it's non null
            setComponent(6, SwiftFormatUtils.getLong(component6.longValue()));
        } else {
            // so it's a Number that failed instanceof Number => it's null
            setComponent(6, null);
        }
        return this;
    }

    /**
     * Set the ACK Replay Indicator (component 6).
     *
     * @param component6 the ACK Replay Indicator to set
     * @return the field object to enable build pattern
     */
    public Field330 setACKReplayIndicator(String component6) {
        return setComponent6(component6);
    }

    /**
     * Set the ACK Replay Indicator (component 6) from a Long object.
     *
     * @see #setComponent6(java.lang.Long)
     *
     * @param component6 Long with the ACK Replay Indicator content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field330 setACKReplayIndicator(java.lang.Long component6) {
        return setComponent6(component6);
    }

    /**
     * Alternative method setter for field's ACK Replay Indicator (component 6) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component6 the Number with the ACK Replay Indicator content to set
     * @return the field object to enable build pattern
     * @see #setACKReplayIndicator(java.lang.Long)
     */
    public Field330 setACKReplayIndicator(java.lang.Number component6) {
        return setComponent6(component6);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any)
     * @return the static value of Field330.NAME
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
    public static Field330 get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field330(t) ;
    }

    /**
     * Gets the first instance of Field330 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field330 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return null;
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field330 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field330> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return java.util.Collections.emptyList();
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field330 from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field330> getAll(final SwiftTagListBlock block) {
        final List<Field330> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add( new Field330(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field330 object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field330 fromJson(final String json) {

        Field330 field = new Field330();

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(json);

        // **** COMPONENT 1 - Session Number

        if (jsonObject.get("sessionNumber") != null) {
            field.setComponent1(jsonObject.get("sessionNumber").getAsString());
        }

        // **** COMPONENT 2 - ISN

        if (jsonObject.get("iSN") != null) {
            field.setComponent2(jsonObject.get("iSN").getAsString());
        }

        // **** COMPONENT 3 - ISN NAK

        if (jsonObject.get("iSNNAK") != null) {
            field.setComponent3(jsonObject.get("iSNNAK").getAsString());
        }

        // **** COMPONENT 4 - OSN

        if (jsonObject.get("oSN") != null) {
            field.setComponent4(jsonObject.get("oSN").getAsString());
        }

        // **** COMPONENT 5 - OSN NAK

        if (jsonObject.get("oSNNAK") != null) {
            field.setComponent5(jsonObject.get("oSNNAK").getAsString());
        }

        // **** COMPONENT 6 - ACK Replay Indicator

        if (jsonObject.get("aCKReplayIndicator") != null) {
            field.setComponent6(jsonObject.get("aCKReplayIndicator").getAsString());
        }

        return field;
    }


}
