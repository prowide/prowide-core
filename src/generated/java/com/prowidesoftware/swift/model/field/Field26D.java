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


import com.prowidesoftware.swift.model.field.MultiLineField;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 26D.
 * <p>
 * Model and parser for field 26D of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Narrative: <code>String</code></li>
 * 		<li>Component 2: Narrative2: <code>String</code></li>
 * 		<li>Component 3: Narrative3: <code>String</code></li>
 * 		<li>Component 4: Narrative4: <code>String</code></li>
 * 		<li>Component 5: Narrative5: <code>String</code></li>
 * 		<li>Component 6: Narrative6: <code>String</code></li>
 * 		<li>Component 7: Narrative7: <code>String</code></li>
 * 		<li>Component 8: Narrative8: <code>String</code></li>
 * 		<li>Component 9: Narrative9: <code>String</code></li>
 * 		<li>Component 10: Narrative10: <code>String</code></li>
 * 		<li>Component 11: Narrative11: <code>String</code></li>
 * 		<li>Component 12: Narrative12: <code>String</code></li>
 * 		<li>Component 13: Narrative13: <code>String</code></li>
 * 		<li>Component 14: Narrative14: <code>String</code></li>
 * 		<li>Component 15: Narrative15: <code>String</code></li>
 * 		<li>Component 16: Narrative16: <code>String</code></li>
 * 		<li>Component 17: Narrative17: <code>String</code></li>
 * 		<li>Component 18: Narrative18: <code>String</code></li>
 * 		<li>Component 19: Narrative19: <code>String</code></li>
 * 		<li>Component 20: Narrative20: <code>String</code></li>
 * 		<li>Component 21: Narrative21: <code>String</code></li>
 * 		<li>Component 22: Narrative22: <code>String</code></li>
 * 		<li>Component 23: Narrative23: <code>String</code></li>
 * 		<li>Component 24: Narrative24: <code>String</code></li>
 * 		<li>Component 25: Narrative25: <code>String</code></li>
 * 		<li>Component 26: Narrative26: <code>String</code></li>
 * 		<li>Component 27: Narrative27: <code>String</code></li>
 * 		<li>Component 28: Narrative28: <code>String</code></li>
 * 		<li>Component 29: Narrative29: <code>String</code></li>
 * 		<li>Component 30: Narrative30: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>65x[$65x]0-29</code></li>
 * 		<li>parser pattern: <code>S[$S]0-29</code></li>
 * 		<li>components pattern: <code>SSSSSSSSSSSSSSSSSSSSSSSSSSSSSS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field26D extends Field implements Serializable, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 26D.
	 */
    public static final String NAME = "26D";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_26D = "26D";

	/**
	 * Component number for the Narrative subfield.
	 */
	public static final Integer NARRATIVE = 1;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field26D() {
        super(30);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field26D(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field26D(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "26D")) {
            throw new IllegalArgumentException("cannot create field 26D from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field26D newInstance(Field26D source) {
        Field26D cp = new Field26D();
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
        init(30);
        List<String> lines = SwiftParseUtils.getLines(value);
        SwiftParseUtils.setComponentsFromLines(this, 1, null, 0, lines);
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        appendInLines(result, 1, 30);
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
        if (component < 1 || component > 30) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 26D");
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
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(30);
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
        return "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSS";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "S[$S]0-29";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "65x[$65x]0-29";
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
        if (component == 4) {
            return true;
        }
        if (component == 5) {
            return true;
        }
        if (component == 6) {
            return true;
        }
        if (component == 7) {
            return true;
        }
        if (component == 8) {
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
        if (component == 12) {
            return true;
        }
        if (component == 13) {
            return true;
        }
        if (component == 14) {
            return true;
        }
        if (component == 15) {
            return true;
        }
        if (component == 16) {
            return true;
        }
        if (component == 17) {
            return true;
        }
        if (component == 18) {
            return true;
        }
        if (component == 19) {
            return true;
        }
        if (component == 20) {
            return true;
        }
        if (component == 21) {
            return true;
        }
        if (component == 22) {
            return true;
        }
        if (component == 23) {
            return true;
        }
        if (component == 24) {
            return true;
        }
        if (component == 25) {
            return true;
        }
        if (component == 26) {
            return true;
        }
        if (component == 27) {
            return true;
        }
        if (component == 28) {
            return true;
        }
        if (component == 29) {
            return true;
        }
        if (component == 30) {
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
        return 30;
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
        result.add("Narrative");
        result.add("Narrative 2");
        result.add("Narrative 3");
        result.add("Narrative 4");
        result.add("Narrative 5");
        result.add("Narrative 6");
        result.add("Narrative 7");
        result.add("Narrative 8");
        result.add("Narrative 9");
        result.add("Narrative 10");
        result.add("Narrative 11");
        result.add("Narrative 12");
        result.add("Narrative 13");
        result.add("Narrative 14");
        result.add("Narrative 15");
        result.add("Narrative 16");
        result.add("Narrative 17");
        result.add("Narrative 18");
        result.add("Narrative 19");
        result.add("Narrative 20");
        result.add("Narrative 21");
        result.add("Narrative 22");
        result.add("Narrative 23");
        result.add("Narrative 24");
        result.add("Narrative 25");
        result.add("Narrative 26");
        result.add("Narrative 27");
        result.add("Narrative 28");
        result.add("Narrative 29");
        result.add("Narrative 30");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "narrative");
        result.put(2, "narrative2");
        result.put(3, "narrative3");
        result.put(4, "narrative4");
        result.put(5, "narrative5");
        result.put(6, "narrative6");
        result.put(7, "narrative7");
        result.put(8, "narrative8");
        result.put(9, "narrative9");
        result.put(10, "narrative10");
        result.put(11, "narrative11");
        result.put(12, "narrative12");
        result.put(13, "narrative13");
        result.put(14, "narrative14");
        result.put(15, "narrative15");
        result.put(16, "narrative16");
        result.put(17, "narrative17");
        result.put(18, "narrative18");
        result.put(19, "narrative19");
        result.put(20, "narrative20");
        result.put(21, "narrative21");
        result.put(22, "narrative22");
        result.put(23, "narrative23");
        result.put(24, "narrative24");
        result.put(25, "narrative25");
        result.put(26, "narrative26");
        result.put(27, "narrative27");
        result.put(28, "narrative28");
        result.put(29, "narrative29");
        result.put(30, "narrative30");
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
        super.labelMap.put("narrative", 1);
        super.labelMap.put("narrative2", 2);
        super.labelMap.put("narrative3", 3);
        super.labelMap.put("narrative4", 4);
        super.labelMap.put("narrative5", 5);
        super.labelMap.put("narrative6", 6);
        super.labelMap.put("narrative7", 7);
        super.labelMap.put("narrative8", 8);
        super.labelMap.put("narrative9", 9);
        super.labelMap.put("narrative10", 10);
        super.labelMap.put("narrative11", 11);
        super.labelMap.put("narrative12", 12);
        super.labelMap.put("narrative13", 13);
        super.labelMap.put("narrative14", 14);
        super.labelMap.put("narrative15", 15);
        super.labelMap.put("narrative16", 16);
        super.labelMap.put("narrative17", 17);
        super.labelMap.put("narrative18", 18);
        super.labelMap.put("narrative19", 19);
        super.labelMap.put("narrative20", 20);
        super.labelMap.put("narrative21", 21);
        super.labelMap.put("narrative22", 22);
        super.labelMap.put("narrative23", 23);
        super.labelMap.put("narrative24", 24);
        super.labelMap.put("narrative25", 25);
        super.labelMap.put("narrative26", 26);
        super.labelMap.put("narrative27", 27);
        super.labelMap.put("narrative28", 28);
        super.labelMap.put("narrative29", 29);
        super.labelMap.put("narrative30", 30);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Narrative).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Narrative (component 1).
     * @return the Narrative from component 1
     */
    public String getNarrativeLine1() {
        return getComponent1();
    }

    /**
     * Gets the Narrative as a concatenation of component 1 to component 30.
     * @return the Narrative from components
     */
    public String getNarrative() {
        return getNarrative(null);
    }

    /**
     * Gets the Narrative as a concatenation of component 1 to component 30 joined together with a copy of the
     * specified delimiter.
     * @param deli the delimiter that separates each component
     * @return the Narrative from components
     * @since 9.1.4
     */
    public String getNarrative(CharSequence deli) {
        StringBuilder result = new StringBuilder();
        for (int i = 1; i < 31; i++) {
            if (getComponent(i) != null) {
                if (deli != null && result.length() > 0) {
                    result.append(deli);
                }
                result.append(getComponent(i));
            }
        }
        return result.toString();
    }

    /**
     * Gets the component 2 (Narrative 2).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Narrative 2 (component 2).
     * @return the Narrative 2 from component 2
     */
    public String getNarrativeLine2() {
        return getComponent2();
    }

    /**
     * Gets the component 3 (Narrative 3).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Narrative 3 (component 3).
     * @return the Narrative 3 from component 3
     */
    public String getNarrativeLine3() {
        return getComponent3();
    }

    /**
     * Gets the component 4 (Narrative 4).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the Narrative 4 (component 4).
     * @return the Narrative 4 from component 4
     */
    public String getNarrativeLine4() {
        return getComponent4();
    }

    /**
     * Gets the component 5 (Narrative 5).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Gets the Narrative 5 (component 5).
     * @return the Narrative 5 from component 5
     */
    public String getNarrativeLine5() {
        return getComponent5();
    }

    /**
     * Gets the component 6 (Narrative 6).
     * @return the component 6
     */
    public String getComponent6() {
        return getComponent(6);
    }

    /**
     * Gets the Narrative 6 (component 6).
     * @return the Narrative 6 from component 6
     */
    public String getNarrativeLine6() {
        return getComponent6();
    }

    /**
     * Gets the component 7 (Narrative 7).
     * @return the component 7
     */
    public String getComponent7() {
        return getComponent(7);
    }

    /**
     * Gets the Narrative 7 (component 7).
     * @return the Narrative 7 from component 7
     */
    public String getNarrativeLine7() {
        return getComponent7();
    }

    /**
     * Gets the component 8 (Narrative 8).
     * @return the component 8
     */
    public String getComponent8() {
        return getComponent(8);
    }

    /**
     * Gets the Narrative 8 (component 8).
     * @return the Narrative 8 from component 8
     */
    public String getNarrativeLine8() {
        return getComponent8();
    }

    /**
     * Gets the component 9 (Narrative 9).
     * @return the component 9
     */
    public String getComponent9() {
        return getComponent(9);
    }

    /**
     * Gets the Narrative 9 (component 9).
     * @return the Narrative 9 from component 9
     */
    public String getNarrativeLine9() {
        return getComponent9();
    }

    /**
     * Gets the component 10 (Narrative 10).
     * @return the component 10
     */
    public String getComponent10() {
        return getComponent(10);
    }

    /**
     * Gets the Narrative 10 (component 10).
     * @return the Narrative 10 from component 10
     */
    public String getNarrativeLine10() {
        return getComponent10();
    }

    /**
     * Gets the component 11 (Narrative 11).
     * @return the component 11
     */
    public String getComponent11() {
        return getComponent(11);
    }

    /**
     * Gets the Narrative 11 (component 11).
     * @return the Narrative 11 from component 11
     */
    public String getNarrativeLine11() {
        return getComponent11();
    }

    /**
     * Gets the component 12 (Narrative 12).
     * @return the component 12
     */
    public String getComponent12() {
        return getComponent(12);
    }

    /**
     * Gets the Narrative 12 (component 12).
     * @return the Narrative 12 from component 12
     */
    public String getNarrativeLine12() {
        return getComponent12();
    }

    /**
     * Gets the component 13 (Narrative 13).
     * @return the component 13
     */
    public String getComponent13() {
        return getComponent(13);
    }

    /**
     * Gets the Narrative 13 (component 13).
     * @return the Narrative 13 from component 13
     */
    public String getNarrativeLine13() {
        return getComponent13();
    }

    /**
     * Gets the component 14 (Narrative 14).
     * @return the component 14
     */
    public String getComponent14() {
        return getComponent(14);
    }

    /**
     * Gets the Narrative 14 (component 14).
     * @return the Narrative 14 from component 14
     */
    public String getNarrativeLine14() {
        return getComponent14();
    }

    /**
     * Gets the component 15 (Narrative 15).
     * @return the component 15
     */
    public String getComponent15() {
        return getComponent(15);
    }

    /**
     * Gets the Narrative 15 (component 15).
     * @return the Narrative 15 from component 15
     */
    public String getNarrativeLine15() {
        return getComponent15();
    }

    /**
     * Gets the component 16 (Narrative 16).
     * @return the component 16
     */
    public String getComponent16() {
        return getComponent(16);
    }

    /**
     * Gets the Narrative 16 (component 16).
     * @return the Narrative 16 from component 16
     */
    public String getNarrativeLine16() {
        return getComponent16();
    }

    /**
     * Gets the component 17 (Narrative 17).
     * @return the component 17
     */
    public String getComponent17() {
        return getComponent(17);
    }

    /**
     * Gets the Narrative 17 (component 17).
     * @return the Narrative 17 from component 17
     */
    public String getNarrativeLine17() {
        return getComponent17();
    }

    /**
     * Gets the component 18 (Narrative 18).
     * @return the component 18
     */
    public String getComponent18() {
        return getComponent(18);
    }

    /**
     * Gets the Narrative 18 (component 18).
     * @return the Narrative 18 from component 18
     */
    public String getNarrativeLine18() {
        return getComponent18();
    }

    /**
     * Gets the component 19 (Narrative 19).
     * @return the component 19
     */
    public String getComponent19() {
        return getComponent(19);
    }

    /**
     * Gets the Narrative 19 (component 19).
     * @return the Narrative 19 from component 19
     */
    public String getNarrativeLine19() {
        return getComponent19();
    }

    /**
     * Gets the component 20 (Narrative 20).
     * @return the component 20
     */
    public String getComponent20() {
        return getComponent(20);
    }

    /**
     * Gets the Narrative 20 (component 20).
     * @return the Narrative 20 from component 20
     */
    public String getNarrativeLine20() {
        return getComponent20();
    }

    /**
     * Gets the component 21 (Narrative 21).
     * @return the component 21
     */
    public String getComponent21() {
        return getComponent(21);
    }

    /**
     * Gets the Narrative 21 (component 21).
     * @return the Narrative 21 from component 21
     */
    public String getNarrativeLine21() {
        return getComponent21();
    }

    /**
     * Gets the component 22 (Narrative 22).
     * @return the component 22
     */
    public String getComponent22() {
        return getComponent(22);
    }

    /**
     * Gets the Narrative 22 (component 22).
     * @return the Narrative 22 from component 22
     */
    public String getNarrativeLine22() {
        return getComponent22();
    }

    /**
     * Gets the component 23 (Narrative 23).
     * @return the component 23
     */
    public String getComponent23() {
        return getComponent(23);
    }

    /**
     * Gets the Narrative 23 (component 23).
     * @return the Narrative 23 from component 23
     */
    public String getNarrativeLine23() {
        return getComponent23();
    }

    /**
     * Gets the component 24 (Narrative 24).
     * @return the component 24
     */
    public String getComponent24() {
        return getComponent(24);
    }

    /**
     * Gets the Narrative 24 (component 24).
     * @return the Narrative 24 from component 24
     */
    public String getNarrativeLine24() {
        return getComponent24();
    }

    /**
     * Gets the component 25 (Narrative 25).
     * @return the component 25
     */
    public String getComponent25() {
        return getComponent(25);
    }

    /**
     * Gets the Narrative 25 (component 25).
     * @return the Narrative 25 from component 25
     */
    public String getNarrativeLine25() {
        return getComponent25();
    }

    /**
     * Gets the component 26 (Narrative 26).
     * @return the component 26
     */
    public String getComponent26() {
        return getComponent(26);
    }

    /**
     * Gets the Narrative 26 (component 26).
     * @return the Narrative 26 from component 26
     */
    public String getNarrativeLine26() {
        return getComponent26();
    }

    /**
     * Gets the component 27 (Narrative 27).
     * @return the component 27
     */
    public String getComponent27() {
        return getComponent(27);
    }

    /**
     * Gets the Narrative 27 (component 27).
     * @return the Narrative 27 from component 27
     */
    public String getNarrativeLine27() {
        return getComponent27();
    }

    /**
     * Gets the component 28 (Narrative 28).
     * @return the component 28
     */
    public String getComponent28() {
        return getComponent(28);
    }

    /**
     * Gets the Narrative 28 (component 28).
     * @return the Narrative 28 from component 28
     */
    public String getNarrativeLine28() {
        return getComponent28();
    }

    /**
     * Gets the component 29 (Narrative 29).
     * @return the component 29
     */
    public String getComponent29() {
        return getComponent(29);
    }

    /**
     * Gets the Narrative 29 (component 29).
     * @return the Narrative 29 from component 29
     */
    public String getNarrativeLine29() {
        return getComponent29();
    }

    /**
     * Gets the component 30 (Narrative 30).
     * @return the component 30
     */
    public String getComponent30() {
        return getComponent(30);
    }

    /**
     * Gets the Narrative 30 (component 30).
     * @return the Narrative 30 from component 30
     */
    public String getNarrativeLine30() {
        return getComponent30();
    }

    /**
     * Set the component 1 (Narrative).
     *
     * @param component1 the Narrative to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Narrative (component 1).
     *
     * @param component1 the Narrative to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine1(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the Narrative splitting the parameter lines into components 1 to 30.
     *
     * @param value the Narrative to set, may contain line ends and each line will be set to its correspondent component attribute
     * @return the field object to enable build pattern
     */
    public Field26D setNarrative(String value) {
        List<String> lines = SwiftParseUtils.getLines(value);
        SwiftParseUtils.setComponentsFromLines(this, 1, 30, 0, lines);
        return this;
    }

    /**
     * Set the component 2 (Narrative 2).
     *
     * @param component2 the Narrative 2 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Narrative 2 (component 2).
     *
     * @param component2 the Narrative 2 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine2(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Narrative 3).
     *
     * @param component3 the Narrative 3 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Narrative 3 (component 3).
     *
     * @param component3 the Narrative 3 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine3(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Narrative 4).
     *
     * @param component4 the Narrative 4 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the Narrative 4 (component 4).
     *
     * @param component4 the Narrative 4 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine4(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Narrative 5).
     *
     * @param component5 the Narrative 5 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the Narrative 5 (component 5).
     *
     * @param component5 the Narrative 5 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine5(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the component 6 (Narrative 6).
     *
     * @param component6 the Narrative 6 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }

    /**
     * Set the Narrative 6 (component 6).
     *
     * @param component6 the Narrative 6 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine6(String component6) {
        return setComponent6(component6);
    }

    /**
     * Set the component 7 (Narrative 7).
     *
     * @param component7 the Narrative 7 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent7(String component7) {
        setComponent(7, component7);
        return this;
    }

    /**
     * Set the Narrative 7 (component 7).
     *
     * @param component7 the Narrative 7 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine7(String component7) {
        return setComponent7(component7);
    }

    /**
     * Set the component 8 (Narrative 8).
     *
     * @param component8 the Narrative 8 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent8(String component8) {
        setComponent(8, component8);
        return this;
    }

    /**
     * Set the Narrative 8 (component 8).
     *
     * @param component8 the Narrative 8 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine8(String component8) {
        return setComponent8(component8);
    }

    /**
     * Set the component 9 (Narrative 9).
     *
     * @param component9 the Narrative 9 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent9(String component9) {
        setComponent(9, component9);
        return this;
    }

    /**
     * Set the Narrative 9 (component 9).
     *
     * @param component9 the Narrative 9 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine9(String component9) {
        return setComponent9(component9);
    }

    /**
     * Set the component 10 (Narrative 10).
     *
     * @param component10 the Narrative 10 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent10(String component10) {
        setComponent(10, component10);
        return this;
    }

    /**
     * Set the Narrative 10 (component 10).
     *
     * @param component10 the Narrative 10 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine10(String component10) {
        return setComponent10(component10);
    }

    /**
     * Set the component 11 (Narrative 11).
     *
     * @param component11 the Narrative 11 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent11(String component11) {
        setComponent(11, component11);
        return this;
    }

    /**
     * Set the Narrative 11 (component 11).
     *
     * @param component11 the Narrative 11 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine11(String component11) {
        return setComponent11(component11);
    }

    /**
     * Set the component 12 (Narrative 12).
     *
     * @param component12 the Narrative 12 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent12(String component12) {
        setComponent(12, component12);
        return this;
    }

    /**
     * Set the Narrative 12 (component 12).
     *
     * @param component12 the Narrative 12 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine12(String component12) {
        return setComponent12(component12);
    }

    /**
     * Set the component 13 (Narrative 13).
     *
     * @param component13 the Narrative 13 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent13(String component13) {
        setComponent(13, component13);
        return this;
    }

    /**
     * Set the Narrative 13 (component 13).
     *
     * @param component13 the Narrative 13 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine13(String component13) {
        return setComponent13(component13);
    }

    /**
     * Set the component 14 (Narrative 14).
     *
     * @param component14 the Narrative 14 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent14(String component14) {
        setComponent(14, component14);
        return this;
    }

    /**
     * Set the Narrative 14 (component 14).
     *
     * @param component14 the Narrative 14 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine14(String component14) {
        return setComponent14(component14);
    }

    /**
     * Set the component 15 (Narrative 15).
     *
     * @param component15 the Narrative 15 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent15(String component15) {
        setComponent(15, component15);
        return this;
    }

    /**
     * Set the Narrative 15 (component 15).
     *
     * @param component15 the Narrative 15 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine15(String component15) {
        return setComponent15(component15);
    }

    /**
     * Set the component 16 (Narrative 16).
     *
     * @param component16 the Narrative 16 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent16(String component16) {
        setComponent(16, component16);
        return this;
    }

    /**
     * Set the Narrative 16 (component 16).
     *
     * @param component16 the Narrative 16 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine16(String component16) {
        return setComponent16(component16);
    }

    /**
     * Set the component 17 (Narrative 17).
     *
     * @param component17 the Narrative 17 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent17(String component17) {
        setComponent(17, component17);
        return this;
    }

    /**
     * Set the Narrative 17 (component 17).
     *
     * @param component17 the Narrative 17 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine17(String component17) {
        return setComponent17(component17);
    }

    /**
     * Set the component 18 (Narrative 18).
     *
     * @param component18 the Narrative 18 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent18(String component18) {
        setComponent(18, component18);
        return this;
    }

    /**
     * Set the Narrative 18 (component 18).
     *
     * @param component18 the Narrative 18 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine18(String component18) {
        return setComponent18(component18);
    }

    /**
     * Set the component 19 (Narrative 19).
     *
     * @param component19 the Narrative 19 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent19(String component19) {
        setComponent(19, component19);
        return this;
    }

    /**
     * Set the Narrative 19 (component 19).
     *
     * @param component19 the Narrative 19 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine19(String component19) {
        return setComponent19(component19);
    }

    /**
     * Set the component 20 (Narrative 20).
     *
     * @param component20 the Narrative 20 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent20(String component20) {
        setComponent(20, component20);
        return this;
    }

    /**
     * Set the Narrative 20 (component 20).
     *
     * @param component20 the Narrative 20 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine20(String component20) {
        return setComponent20(component20);
    }

    /**
     * Set the component 21 (Narrative 21).
     *
     * @param component21 the Narrative 21 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent21(String component21) {
        setComponent(21, component21);
        return this;
    }

    /**
     * Set the Narrative 21 (component 21).
     *
     * @param component21 the Narrative 21 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine21(String component21) {
        return setComponent21(component21);
    }

    /**
     * Set the component 22 (Narrative 22).
     *
     * @param component22 the Narrative 22 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent22(String component22) {
        setComponent(22, component22);
        return this;
    }

    /**
     * Set the Narrative 22 (component 22).
     *
     * @param component22 the Narrative 22 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine22(String component22) {
        return setComponent22(component22);
    }

    /**
     * Set the component 23 (Narrative 23).
     *
     * @param component23 the Narrative 23 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent23(String component23) {
        setComponent(23, component23);
        return this;
    }

    /**
     * Set the Narrative 23 (component 23).
     *
     * @param component23 the Narrative 23 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine23(String component23) {
        return setComponent23(component23);
    }

    /**
     * Set the component 24 (Narrative 24).
     *
     * @param component24 the Narrative 24 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent24(String component24) {
        setComponent(24, component24);
        return this;
    }

    /**
     * Set the Narrative 24 (component 24).
     *
     * @param component24 the Narrative 24 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine24(String component24) {
        return setComponent24(component24);
    }

    /**
     * Set the component 25 (Narrative 25).
     *
     * @param component25 the Narrative 25 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent25(String component25) {
        setComponent(25, component25);
        return this;
    }

    /**
     * Set the Narrative 25 (component 25).
     *
     * @param component25 the Narrative 25 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine25(String component25) {
        return setComponent25(component25);
    }

    /**
     * Set the component 26 (Narrative 26).
     *
     * @param component26 the Narrative 26 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent26(String component26) {
        setComponent(26, component26);
        return this;
    }

    /**
     * Set the Narrative 26 (component 26).
     *
     * @param component26 the Narrative 26 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine26(String component26) {
        return setComponent26(component26);
    }

    /**
     * Set the component 27 (Narrative 27).
     *
     * @param component27 the Narrative 27 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent27(String component27) {
        setComponent(27, component27);
        return this;
    }

    /**
     * Set the Narrative 27 (component 27).
     *
     * @param component27 the Narrative 27 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine27(String component27) {
        return setComponent27(component27);
    }

    /**
     * Set the component 28 (Narrative 28).
     *
     * @param component28 the Narrative 28 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent28(String component28) {
        setComponent(28, component28);
        return this;
    }

    /**
     * Set the Narrative 28 (component 28).
     *
     * @param component28 the Narrative 28 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine28(String component28) {
        return setComponent28(component28);
    }

    /**
     * Set the component 29 (Narrative 29).
     *
     * @param component29 the Narrative 29 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent29(String component29) {
        setComponent(29, component29);
        return this;
    }

    /**
     * Set the Narrative 29 (component 29).
     *
     * @param component29 the Narrative 29 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine29(String component29) {
        return setComponent29(component29);
    }

    /**
     * Set the component 30 (Narrative 30).
     *
     * @param component30 the Narrative 30 to set
     * @return the field object to enable build pattern
     */
    public Field26D setComponent30(String component30) {
        setComponent(30, component30);
        return this;
    }

    /**
     * Set the Narrative 30 (component 30).
     *
     * @param component30 the Narrative 30 to set
     * @return the field object to enable build pattern
     */
    public Field26D setNarrativeLine30(String component30) {
        return setComponent30(component30);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field26D.NAME
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
    public static Field26D get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field26D(t);
    }

    /**
     * Gets the first instance of Field26D in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field26D get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field26D in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field26D> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field26D from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field26D> getAll(final SwiftTagListBlock block) {
        final List<Field26D> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field26D(f));
            }
        }
        return result;
    }

    /**
     * Returns a specific line from the field's value.
     *
     * @see MultiLineField#getLine(int)
     * @param line a reference to a specific line in the field, first line being 1
     * @return line content or null if not present or if line number is above the expected
     * @since 7.7
     */
    @Override
    public String getLine(int line) {
        return getLine(line, 0);
    }

    /**
     * Returns a specific line from the field's value.
     *
     * @see MultiLineField#getLine(int, int)
     * @param line a reference to a specific line in the field, first line being 1
     * @param offset an optional component number used as offset when counting lines
     * @return line content or null if not present or if line number is above the expected
     * @since 7.7
     */
    @Override
    public String getLine(int line, int offset) {
        Field26D cp = newInstance(this);
        return getLine(cp, line, null, offset);
    }

    /**
     * Returns the field value split into lines.
     *
     * @see MultiLineField#getLines()
     * @return lines content or empty list if field's value is empty
     * @since 7.7
     */
    @Override
    public List<String> getLines() {
        return SwiftParseUtils.getLines(getValue());
    }

    /**
     * Returns the field value starting at the offset component, split into lines.
     *
     * @see MultiLineField#getLines(int)
     * @param offset an optional component number used as offset when counting lines
     * @return found lines or empty list if lines are not present or the offset is invalid
     * @since 7.7
     */
    @Override
    public List<String> getLines(int offset) {
        Field26D cp = newInstance(this);
        return SwiftParseUtils.getLines(getLine(cp, null, null, offset));
    }

    /**
     * Returns a specific subset of lines from the field's value, given a range.
     *
     * @see MultiLineField#getLinesBetween(int, int )
     * @param start a reference to a specific line in the field, first line being 1
     * @param end a reference to a specific line in the field, must be greater than start
     * @return found lines or empty list if value is empty
     * @since 7.7
     */
    @Override
    public List<String> getLinesBetween(int start, int end) {
        return getLinesBetween(start, end, 0);
    }

    /**
     * Returns a specific subset of lines from the field's value, starting at the offset component.
     *
     * @see MultiLineField#getLinesBetween(int start, int end, int offset)
     * @param start a reference to a specific line in the field, first line being 1
     * @param end a reference to a specific line in the field, must be greater than start
     * @param offset an optional component number used as offset when counting lines
     * @return found lines or empty list if lines are not present or the offset is invalid
     * @since 7.7
     */
    @Override
    public List<String> getLinesBetween(int start, int end, int offset) {
        Field26D cp = newInstance(this);
        return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
    }

    /**
     * This method deserializes the JSON data into a Field26D object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field26D fromJson(final String json) {

        final Field26D field = new Field26D();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Narrative

        if (jsonObject.get("narrative") != null) {
            field.setComponent1(jsonObject.get("narrative").getAsString());
        }

        // **** COMPONENT 2 - Narrative 2

        if (jsonObject.get("narrative2") != null) {
            field.setComponent2(jsonObject.get("narrative2").getAsString());
        }

        // **** COMPONENT 3 - Narrative 3

        if (jsonObject.get("narrative3") != null) {
            field.setComponent3(jsonObject.get("narrative3").getAsString());
        }

        // **** COMPONENT 4 - Narrative 4

        if (jsonObject.get("narrative4") != null) {
            field.setComponent4(jsonObject.get("narrative4").getAsString());
        }

        // **** COMPONENT 5 - Narrative 5

        if (jsonObject.get("narrative5") != null) {
            field.setComponent5(jsonObject.get("narrative5").getAsString());
        }

        // **** COMPONENT 6 - Narrative 6

        if (jsonObject.get("narrative6") != null) {
            field.setComponent6(jsonObject.get("narrative6").getAsString());
        }

        // **** COMPONENT 7 - Narrative 7

        if (jsonObject.get("narrative7") != null) {
            field.setComponent7(jsonObject.get("narrative7").getAsString());
        }

        // **** COMPONENT 8 - Narrative 8

        if (jsonObject.get("narrative8") != null) {
            field.setComponent8(jsonObject.get("narrative8").getAsString());
        }

        // **** COMPONENT 9 - Narrative 9

        if (jsonObject.get("narrative9") != null) {
            field.setComponent9(jsonObject.get("narrative9").getAsString());
        }

        // **** COMPONENT 10 - Narrative 10

        if (jsonObject.get("narrative10") != null) {
            field.setComponent10(jsonObject.get("narrative10").getAsString());
        }

        // **** COMPONENT 11 - Narrative 11

        if (jsonObject.get("narrative11") != null) {
            field.setComponent11(jsonObject.get("narrative11").getAsString());
        }

        // **** COMPONENT 12 - Narrative 12

        if (jsonObject.get("narrative12") != null) {
            field.setComponent12(jsonObject.get("narrative12").getAsString());
        }

        // **** COMPONENT 13 - Narrative 13

        if (jsonObject.get("narrative13") != null) {
            field.setComponent13(jsonObject.get("narrative13").getAsString());
        }

        // **** COMPONENT 14 - Narrative 14

        if (jsonObject.get("narrative14") != null) {
            field.setComponent14(jsonObject.get("narrative14").getAsString());
        }

        // **** COMPONENT 15 - Narrative 15

        if (jsonObject.get("narrative15") != null) {
            field.setComponent15(jsonObject.get("narrative15").getAsString());
        }

        // **** COMPONENT 16 - Narrative 16

        if (jsonObject.get("narrative16") != null) {
            field.setComponent16(jsonObject.get("narrative16").getAsString());
        }

        // **** COMPONENT 17 - Narrative 17

        if (jsonObject.get("narrative17") != null) {
            field.setComponent17(jsonObject.get("narrative17").getAsString());
        }

        // **** COMPONENT 18 - Narrative 18

        if (jsonObject.get("narrative18") != null) {
            field.setComponent18(jsonObject.get("narrative18").getAsString());
        }

        // **** COMPONENT 19 - Narrative 19

        if (jsonObject.get("narrative19") != null) {
            field.setComponent19(jsonObject.get("narrative19").getAsString());
        }

        // **** COMPONENT 20 - Narrative 20

        if (jsonObject.get("narrative20") != null) {
            field.setComponent20(jsonObject.get("narrative20").getAsString());
        }

        // **** COMPONENT 21 - Narrative 21

        if (jsonObject.get("narrative21") != null) {
            field.setComponent21(jsonObject.get("narrative21").getAsString());
        }

        // **** COMPONENT 22 - Narrative 22

        if (jsonObject.get("narrative22") != null) {
            field.setComponent22(jsonObject.get("narrative22").getAsString());
        }

        // **** COMPONENT 23 - Narrative 23

        if (jsonObject.get("narrative23") != null) {
            field.setComponent23(jsonObject.get("narrative23").getAsString());
        }

        // **** COMPONENT 24 - Narrative 24

        if (jsonObject.get("narrative24") != null) {
            field.setComponent24(jsonObject.get("narrative24").getAsString());
        }

        // **** COMPONENT 25 - Narrative 25

        if (jsonObject.get("narrative25") != null) {
            field.setComponent25(jsonObject.get("narrative25").getAsString());
        }

        // **** COMPONENT 26 - Narrative 26

        if (jsonObject.get("narrative26") != null) {
            field.setComponent26(jsonObject.get("narrative26").getAsString());
        }

        // **** COMPONENT 27 - Narrative 27

        if (jsonObject.get("narrative27") != null) {
            field.setComponent27(jsonObject.get("narrative27").getAsString());
        }

        // **** COMPONENT 28 - Narrative 28

        if (jsonObject.get("narrative28") != null) {
            field.setComponent28(jsonObject.get("narrative28").getAsString());
        }

        // **** COMPONENT 29 - Narrative 29

        if (jsonObject.get("narrative29") != null) {
            field.setComponent29(jsonObject.get("narrative29").getAsString());
        }

        // **** COMPONENT 30 - Narrative 30

        if (jsonObject.get("narrative30") != null) {
            field.setComponent30(jsonObject.get("narrative30").getAsString());
        }

        return field;
    }


}
