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



import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 425.
 * <p>
 * Model and parser for field 425 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: <code>String</code></li>
 * 		<li>Component 2: <code>String</code></li>
 * 		<li>Component 3: <code>String</code></li>
 * 		<li>Component 4: <code>String</code></li>
 * 		<li>Component 5: <code>String</code></li>
 * 		<li>Component 6: <code>String</code></li>
 * 		<li>Component 7: <code>String</code></li>
 * 		<li>Component 8: <code>String</code></li>
 * 		<li>Component 9: <code>String</code></li>
 * 		<li>Component 10: <code>String</code></li>
 * 		<li>Component 11: <code>String</code></li>
 * 		<li>Component 12: <code>String</code></li>
 * 		<li>Component 13: <code>String</code></li>
 * 		<li>Component 14: <code>String</code></li>
 * 		<li>Component 15: <code>String</code></li>
 * 		<li>Component 16: <code>String</code></li>
 * 		<li>Component 17: <code>String</code></li>
 * 		<li>Component 18: <code>String</code></li>
 * 		<li>Component 19: <code>String</code></li>
 * 		<li>Component 20: <code>String</code></li>
 * 		<li>Component 21: <code>String</code></li>
 * 		<li>Component 22: <code>String</code></li>
 * 		<li>Component 23: <code>String</code></li>
 * 		<li>Component 24: <code>String</code></li>
 * 		<li>Component 25: <code>String</code></li>
 * 		<li>Component 26: <code>String</code></li>
 * 		<li>Component 27: <code>String</code></li>
 * 		<li>Component 28: <code>String</code></li>
 * 		<li>Component 29: <code>String</code></li>
 * 		<li>Component 30: <code>String</code></li>
 * 		<li>Component 31: <code>String</code></li>
 * 		<li>Component 32: <code>String</code></li>
 * 		<li>Component 33: <code>String</code></li>
 * 		<li>Component 34: <code>String</code></li>
 * 		<li>Component 35: <code>String</code></li>
 * 		<li>Component 36: <code>String</code></li>
 * 		<li>Component 37: <code>String</code></li>
 * 		<li>Component 38: <code>String</code></li>
 * 		<li>Component 39: <code>String</code></li>
 * 		<li>Component 40: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>20*(2!c/37x)</code></li>
 * 		<li>parser pattern: <code>20*(S/S)</code></li>
 * 		<li>components pattern: <code>SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field425 extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 425.
	 */
    public static final String NAME = "425";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_425 = "425";

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field425() {
        super(40);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field425(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field425(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "425")) {
            throw new IllegalArgumentException("cannot create field 425 from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field425 newInstance(Field425 source) {
        Field425 cp = new Field425();
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
        init(40);
        /*
         * This parser implementation needs review, the actual field format is not clear in the standard:
         *
         * 422 <MI-message-data-text> 20*(2!c/37x) This field is only for use by Market Infrastructures
         * which have subscribed to the Market Infrastructure Resiliency Service (MIRS).
         *
         * It is not clear how to split one instance to the other between the 12 occurrences
         */
        if (value != null) {
            String[] tokens = StringUtils.split(value, "/");
            final StringBuilder lastComponent = new StringBuilder();
            for (int i=0; i<tokens.length; i++) {
                if (i < 40) {
                    //set all components sequentially, but the last one
                    setComponent(i+1, tokens[i]);
                } else {
                    //the last component will include all the remaining string
                    if (lastComponent.length() > 0) {
                        lastComponent.append("/");
                    }
                    lastComponent.append(tokens[i]);
                }
            }
            if (lastComponent.length() > 0) {
                setComponent40(lastComponent.toString());
            }
        }
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        //FIXME serialization 20*(S/S)
        // @NotImplemented
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
        if (component < 1 || component > 40) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 425");
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
        if (component == 6) {
            //default format (as is)
            return getComponent(6);
        }
        if (component == 7) {
            //default format (as is)
            return getComponent(7);
        }
        if (component == 8) {
            //default format (as is)
            return getComponent(8);
        }
        if (component == 9) {
            //default format (as is)
            return getComponent(9);
        }
        if (component == 10) {
            //default format (as is)
            return getComponent(10);
        }
        if (component == 11) {
            //default format (as is)
            return getComponent(11);
        }
        if (component == 12) {
            //default format (as is)
            return getComponent(12);
        }
        if (component == 13) {
            //default format (as is)
            return getComponent(13);
        }
        if (component == 14) {
            //default format (as is)
            return getComponent(14);
        }
        if (component == 15) {
            //default format (as is)
            return getComponent(15);
        }
        if (component == 16) {
            //default format (as is)
            return getComponent(16);
        }
        if (component == 17) {
            //default format (as is)
            return getComponent(17);
        }
        if (component == 18) {
            //default format (as is)
            return getComponent(18);
        }
        if (component == 19) {
            //default format (as is)
            return getComponent(19);
        }
        if (component == 20) {
            //default format (as is)
            return getComponent(20);
        }
        if (component == 21) {
            //default format (as is)
            return getComponent(21);
        }
        if (component == 22) {
            //default format (as is)
            return getComponent(22);
        }
        if (component == 23) {
            //default format (as is)
            return getComponent(23);
        }
        if (component == 24) {
            //default format (as is)
            return getComponent(24);
        }
        if (component == 25) {
            //default format (as is)
            return getComponent(25);
        }
        if (component == 26) {
            //default format (as is)
            return getComponent(26);
        }
        if (component == 27) {
            //default format (as is)
            return getComponent(27);
        }
        if (component == 28) {
            //default format (as is)
            return getComponent(28);
        }
        if (component == 29) {
            //default format (as is)
            return getComponent(29);
        }
        if (component == 30) {
            //default format (as is)
            return getComponent(30);
        }
        if (component == 31) {
            //default format (as is)
            return getComponent(31);
        }
        if (component == 32) {
            //default format (as is)
            return getComponent(32);
        }
        if (component == 33) {
            //default format (as is)
            return getComponent(33);
        }
        if (component == 34) {
            //default format (as is)
            return getComponent(34);
        }
        if (component == 35) {
            //default format (as is)
            return getComponent(35);
        }
        if (component == 36) {
            //default format (as is)
            return getComponent(36);
        }
        if (component == 37) {
            //default format (as is)
            return getComponent(37);
        }
        if (component == 38) {
            //default format (as is)
            return getComponent(38);
        }
        if (component == 39) {
            //default format (as is)
            return getComponent(39);
        }
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(40);
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
        return "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "20*(S/S)";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "20*(2!c/37x)";
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
        return 40;
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
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        result.add(null);
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
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
        return super.labelMap;
    }

    /**
     * Gets the component 1 ($label).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the component 2 ($label).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the component 3 ($label).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the component 4 ($label).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the component 5 ($label).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Gets the component 6 ($label).
     * @return the component 6
     */
    public String getComponent6() {
        return getComponent(6);
    }

    /**
     * Gets the component 7 ($label).
     * @return the component 7
     */
    public String getComponent7() {
        return getComponent(7);
    }

    /**
     * Gets the component 8 ($label).
     * @return the component 8
     */
    public String getComponent8() {
        return getComponent(8);
    }

    /**
     * Gets the component 9 ($label).
     * @return the component 9
     */
    public String getComponent9() {
        return getComponent(9);
    }

    /**
     * Gets the component 10 ($label).
     * @return the component 10
     */
    public String getComponent10() {
        return getComponent(10);
    }

    /**
     * Gets the component 11 ($label).
     * @return the component 11
     */
    public String getComponent11() {
        return getComponent(11);
    }

    /**
     * Gets the component 12 ($label).
     * @return the component 12
     */
    public String getComponent12() {
        return getComponent(12);
    }

    /**
     * Gets the component 13 ($label).
     * @return the component 13
     */
    public String getComponent13() {
        return getComponent(13);
    }

    /**
     * Gets the component 14 ($label).
     * @return the component 14
     */
    public String getComponent14() {
        return getComponent(14);
    }

    /**
     * Gets the component 15 ($label).
     * @return the component 15
     */
    public String getComponent15() {
        return getComponent(15);
    }

    /**
     * Gets the component 16 ($label).
     * @return the component 16
     */
    public String getComponent16() {
        return getComponent(16);
    }

    /**
     * Gets the component 17 ($label).
     * @return the component 17
     */
    public String getComponent17() {
        return getComponent(17);
    }

    /**
     * Gets the component 18 ($label).
     * @return the component 18
     */
    public String getComponent18() {
        return getComponent(18);
    }

    /**
     * Gets the component 19 ($label).
     * @return the component 19
     */
    public String getComponent19() {
        return getComponent(19);
    }

    /**
     * Gets the component 20 ($label).
     * @return the component 20
     */
    public String getComponent20() {
        return getComponent(20);
    }

    /**
     * Gets the component 21 ($label).
     * @return the component 21
     */
    public String getComponent21() {
        return getComponent(21);
    }

    /**
     * Gets the component 22 ($label).
     * @return the component 22
     */
    public String getComponent22() {
        return getComponent(22);
    }

    /**
     * Gets the component 23 ($label).
     * @return the component 23
     */
    public String getComponent23() {
        return getComponent(23);
    }

    /**
     * Gets the component 24 ($label).
     * @return the component 24
     */
    public String getComponent24() {
        return getComponent(24);
    }

    /**
     * Gets the component 25 ($label).
     * @return the component 25
     */
    public String getComponent25() {
        return getComponent(25);
    }

    /**
     * Gets the component 26 ($label).
     * @return the component 26
     */
    public String getComponent26() {
        return getComponent(26);
    }

    /**
     * Gets the component 27 ($label).
     * @return the component 27
     */
    public String getComponent27() {
        return getComponent(27);
    }

    /**
     * Gets the component 28 ($label).
     * @return the component 28
     */
    public String getComponent28() {
        return getComponent(28);
    }

    /**
     * Gets the component 29 ($label).
     * @return the component 29
     */
    public String getComponent29() {
        return getComponent(29);
    }

    /**
     * Gets the component 30 ($label).
     * @return the component 30
     */
    public String getComponent30() {
        return getComponent(30);
    }

    /**
     * Gets the component 31 ($label).
     * @return the component 31
     */
    public String getComponent31() {
        return getComponent(31);
    }

    /**
     * Gets the component 32 ($label).
     * @return the component 32
     */
    public String getComponent32() {
        return getComponent(32);
    }

    /**
     * Gets the component 33 ($label).
     * @return the component 33
     */
    public String getComponent33() {
        return getComponent(33);
    }

    /**
     * Gets the component 34 ($label).
     * @return the component 34
     */
    public String getComponent34() {
        return getComponent(34);
    }

    /**
     * Gets the component 35 ($label).
     * @return the component 35
     */
    public String getComponent35() {
        return getComponent(35);
    }

    /**
     * Gets the component 36 ($label).
     * @return the component 36
     */
    public String getComponent36() {
        return getComponent(36);
    }

    /**
     * Gets the component 37 ($label).
     * @return the component 37
     */
    public String getComponent37() {
        return getComponent(37);
    }

    /**
     * Gets the component 38 ($label).
     * @return the component 38
     */
    public String getComponent38() {
        return getComponent(38);
    }

    /**
     * Gets the component 39 ($label).
     * @return the component 39
     */
    public String getComponent39() {
        return getComponent(39);
    }

    /**
     * Gets the component 40 ($label).
     * @return the component 40
     */
    public String getComponent40() {
        return getComponent(40);
    }

    /**
     * Set the component 1 ($label).
     *
     * @param component1 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the component 2 ($label).
     *
     * @param component2 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component 3 ($label).
     *
     * @param component3 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component 4 ($label).
     *
     * @param component4 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component 5 ($label).
     *
     * @param component5 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the component 6 ($label).
     *
     * @param component6 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }

    /**
     * Set the component 7 ($label).
     *
     * @param component7 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent7(String component7) {
        setComponent(7, component7);
        return this;
    }

    /**
     * Set the component 8 ($label).
     *
     * @param component8 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent8(String component8) {
        setComponent(8, component8);
        return this;
    }

    /**
     * Set the component 9 ($label).
     *
     * @param component9 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent9(String component9) {
        setComponent(9, component9);
        return this;
    }

    /**
     * Set the component 10 ($label).
     *
     * @param component10 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent10(String component10) {
        setComponent(10, component10);
        return this;
    }

    /**
     * Set the component 11 ($label).
     *
     * @param component11 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent11(String component11) {
        setComponent(11, component11);
        return this;
    }

    /**
     * Set the component 12 ($label).
     *
     * @param component12 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent12(String component12) {
        setComponent(12, component12);
        return this;
    }

    /**
     * Set the component 13 ($label).
     *
     * @param component13 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent13(String component13) {
        setComponent(13, component13);
        return this;
    }

    /**
     * Set the component 14 ($label).
     *
     * @param component14 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent14(String component14) {
        setComponent(14, component14);
        return this;
    }

    /**
     * Set the component 15 ($label).
     *
     * @param component15 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent15(String component15) {
        setComponent(15, component15);
        return this;
    }

    /**
     * Set the component 16 ($label).
     *
     * @param component16 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent16(String component16) {
        setComponent(16, component16);
        return this;
    }

    /**
     * Set the component 17 ($label).
     *
     * @param component17 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent17(String component17) {
        setComponent(17, component17);
        return this;
    }

    /**
     * Set the component 18 ($label).
     *
     * @param component18 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent18(String component18) {
        setComponent(18, component18);
        return this;
    }

    /**
     * Set the component 19 ($label).
     *
     * @param component19 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent19(String component19) {
        setComponent(19, component19);
        return this;
    }

    /**
     * Set the component 20 ($label).
     *
     * @param component20 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent20(String component20) {
        setComponent(20, component20);
        return this;
    }

    /**
     * Set the component 21 ($label).
     *
     * @param component21 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent21(String component21) {
        setComponent(21, component21);
        return this;
    }

    /**
     * Set the component 22 ($label).
     *
     * @param component22 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent22(String component22) {
        setComponent(22, component22);
        return this;
    }

    /**
     * Set the component 23 ($label).
     *
     * @param component23 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent23(String component23) {
        setComponent(23, component23);
        return this;
    }

    /**
     * Set the component 24 ($label).
     *
     * @param component24 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent24(String component24) {
        setComponent(24, component24);
        return this;
    }

    /**
     * Set the component 25 ($label).
     *
     * @param component25 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent25(String component25) {
        setComponent(25, component25);
        return this;
    }

    /**
     * Set the component 26 ($label).
     *
     * @param component26 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent26(String component26) {
        setComponent(26, component26);
        return this;
    }

    /**
     * Set the component 27 ($label).
     *
     * @param component27 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent27(String component27) {
        setComponent(27, component27);
        return this;
    }

    /**
     * Set the component 28 ($label).
     *
     * @param component28 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent28(String component28) {
        setComponent(28, component28);
        return this;
    }

    /**
     * Set the component 29 ($label).
     *
     * @param component29 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent29(String component29) {
        setComponent(29, component29);
        return this;
    }

    /**
     * Set the component 30 ($label).
     *
     * @param component30 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent30(String component30) {
        setComponent(30, component30);
        return this;
    }

    /**
     * Set the component 31 ($label).
     *
     * @param component31 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent31(String component31) {
        setComponent(31, component31);
        return this;
    }

    /**
     * Set the component 32 ($label).
     *
     * @param component32 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent32(String component32) {
        setComponent(32, component32);
        return this;
    }

    /**
     * Set the component 33 ($label).
     *
     * @param component33 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent33(String component33) {
        setComponent(33, component33);
        return this;
    }

    /**
     * Set the component 34 ($label).
     *
     * @param component34 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent34(String component34) {
        setComponent(34, component34);
        return this;
    }

    /**
     * Set the component 35 ($label).
     *
     * @param component35 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent35(String component35) {
        setComponent(35, component35);
        return this;
    }

    /**
     * Set the component 36 ($label).
     *
     * @param component36 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent36(String component36) {
        setComponent(36, component36);
        return this;
    }

    /**
     * Set the component 37 ($label).
     *
     * @param component37 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent37(String component37) {
        setComponent(37, component37);
        return this;
    }

    /**
     * Set the component 38 ($label).
     *
     * @param component38 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent38(String component38) {
        setComponent(38, component38);
        return this;
    }

    /**
     * Set the component 39 ($label).
     *
     * @param component39 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent39(String component39) {
        setComponent(39, component39);
        return this;
    }

    /**
     * Set the component 40 ($label).
     *
     * @param component40 the $label to set
     * @return the field object to enable build pattern
     */
    public Field425 setComponent40(String component40) {
        setComponent(40, component40);
        return this;
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field425.NAME
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
    public static Field425 get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field425(t);
    }

    /**
     * Gets the first instance of Field425 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field425 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field425 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field425> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field425 from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field425> getAll(final SwiftTagListBlock block) {
        final List<Field425> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field425(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field425 object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    @SuppressWarnings("unused")
    public static Field425 fromJson(final String json) {









































        return new Field425();
    }


}
