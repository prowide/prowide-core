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


import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 330.
 * <p>
 * Model and parser for field 330 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: SessionNumber: <code>Long</code></li>
 * 		<li>Component 2: ISN: <code>Long</code></li>
 * 		<li>Component 3: ISNNAK: <code>Long</code></li>
 * 		<li>Component 4: OSN: <code>Long</code></li>
 * 		<li>Component 5: OSNNAK: <code>Long</code></li>
 * 		<li>Component 6: ACKReplayIndicator: <code>Long</code></li>
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
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field330 extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 330.
	 */
    public static final String NAME = "330";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_330 = "330";

	/**
	 * Component number for the Session Number subfield.
	 */
	public static final Integer SESSION_NUMBER = 1;

	/**
	 * Component number for the ISN subfield.
	 */
	public static final Integer ISN = 2;

	/**
	 * Component number for the ISN NAK subfield.
	 */
	public static final Integer ISN_NAK = 3;

	/**
	 * Component number for the OSN subfield.
	 */
	public static final Integer OSN = 4;

	/**
	 * Component number for the OSN NAK subfield.
	 */
	public static final Integer OSN_NAK = 5;

	/**
	 * Component number for the ACK Replay Indicator subfield.
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
     * Copy constructor.
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
            //default format (as is)
            return getComponent(1);
        }
        if (component == 2) {
            //default format (as is)
            return getComponent(2);
        }
        if (component == 3) {
            //default format (as is)
            return getComponent(3);
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
        //default format (as is)
        return getComponent(6);
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
        return "NNNNNN";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "4!N6!N6!N6!N6!N1!N";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
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
    public List<String> getComponentLabels() {
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
        super.labelMap.put("sessionnumber", 1);
        super.labelMap.put("isn", 2);
        super.labelMap.put("isnnak", 3);
        super.labelMap.put("osn", 4);
        super.labelMap.put("osnnak", 5);
        super.labelMap.put("ackreplayindicator", 6);
        return super.labelMap;
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
     * Alternative method setter for field's Session Number (component 1) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Session Number content to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent1(java.lang.Number component1) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component1 instanceof Long) {
            setComponent(1, SwiftFormatUtils.getLong((Long) component1));
        } else if (component1 instanceof BigInteger || component1 instanceof Integer) {
            setComponent(1, SwiftFormatUtils.getLong(component1.longValue()));
        } else if (component1 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(1, SwiftFormatUtils.getLong(component1.longValue()));
        } else {
            // explicitly set component as null
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
     * Alternative method setter for field's Session Number (component 1) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Session Number content to set
     * @return the field object to enable build pattern
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
     * Alternative method setter for field's ISN (component 2) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the ISN content to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent2(java.lang.Number component2) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component2 instanceof Long) {
            setComponent(2, SwiftFormatUtils.getLong((Long) component2));
        } else if (component2 instanceof BigInteger || component2 instanceof Integer) {
            setComponent(2, SwiftFormatUtils.getLong(component2.longValue()));
        } else if (component2 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(2, SwiftFormatUtils.getLong(component2.longValue()));
        } else {
            // explicitly set component as null
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
     * Alternative method setter for field's ISN (component 2) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the ISN content to set
     * @return the field object to enable build pattern
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
     * Alternative method setter for field's ISN NAK (component 3) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the ISN NAK content to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent3(java.lang.Number component3) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component3 instanceof Long) {
            setComponent(3, SwiftFormatUtils.getLong((Long) component3));
        } else if (component3 instanceof BigInteger || component3 instanceof Integer) {
            setComponent(3, SwiftFormatUtils.getLong(component3.longValue()));
        } else if (component3 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(3, SwiftFormatUtils.getLong(component3.longValue()));
        } else {
            // explicitly set component as null
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
     * Alternative method setter for field's ISN NAK (component 3) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the ISN NAK content to set
     * @return the field object to enable build pattern
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
     * Alternative method setter for field's OSN (component 4) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the OSN content to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent4(java.lang.Number component4) {

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
     * Set the OSN (component 4).
     *
     * @param component4 the OSN to set
     * @return the field object to enable build pattern
     */
    public Field330 setOSN(String component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative method setter for field's OSN (component 4) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the OSN content to set
     * @return the field object to enable build pattern
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
     * Alternative method setter for field's OSN NAK (component 5) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component5 the Number with the OSN NAK content to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent5(java.lang.Number component5) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component5 instanceof Long) {
            setComponent(5, SwiftFormatUtils.getLong((Long) component5));
        } else if (component5 instanceof BigInteger || component5 instanceof Integer) {
            setComponent(5, SwiftFormatUtils.getLong(component5.longValue()));
        } else if (component5 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(5, SwiftFormatUtils.getLong(component5.longValue()));
        } else {
            // explicitly set component as null
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
     * Alternative method setter for field's OSN NAK (component 5) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component5 the Number with the OSN NAK content to set
     * @return the field object to enable build pattern
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
     * Alternative method setter for field's ACK Replay Indicator (component 6) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component6 the Number with the ACK Replay Indicator content to set
     * @return the field object to enable build pattern
     */
    public Field330 setComponent6(java.lang.Number component6) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component6 instanceof Long) {
            setComponent(6, SwiftFormatUtils.getLong((Long) component6));
        } else if (component6 instanceof BigInteger || component6 instanceof Integer) {
            setComponent(6, SwiftFormatUtils.getLong(component6.longValue()));
        } else if (component6 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(6, SwiftFormatUtils.getLong(component6.longValue()));
        } else {
            // explicitly set component as null
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
     * Alternative method setter for field's ACK Replay Indicator (component 6) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component6 the Number with the ACK Replay Indicator content to set
     * @return the field object to enable build pattern
     */
    public Field330 setACKReplayIndicator(java.lang.Number component6) {
        return setComponent6(component6);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
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
        return new Field330(t);
    }

    /**
     * Gets the first instance of Field330 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field330 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field330 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field330> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
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
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field330(f));
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

        final Field330 field = new Field330();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

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
