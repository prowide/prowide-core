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
 * SWIFT MT Field 24G.
 * <p>
 * Model and parser for field 24G of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Code: <code>String</code></li>
 * 		<li>Component 2: Narrative: <code>String</code></li>
 * 		<li>Component 3: Narrative2: <code>String</code></li>
 * 		<li>Component 4: Narrative3: <code>String</code></li>
 * 		<li>Component 5: Narrative4: <code>String</code></li>
 * 		<li>Component 6: Narrative5: <code>String</code></li>
 * 		<li>Component 7: Narrative6: <code>String</code></li>
 * 		<li>Component 8: Narrative7: <code>String</code></li>
 * 		<li>Component 9: Narrative8: <code>String</code></li>
 * 		<li>Component 10: Narrative9: <code>String</code></li>
 * 		<li>Component 11: Narrative10: <code>String</code></li>
 * 		<li>Component 12: Narrative11: <code>String</code></li>
 * 		<li>Component 13: Narrative12: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>4!c(**)[$65z]0-12</code></li>
 * 		<li>parser pattern: <code>S[$S]0-12</code></li>
 * 		<li>components pattern: <code>SSSSSSSSSSSSS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field24G extends Field implements Serializable, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 24G.
	 */
    public static final String NAME = "24G";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_24G = "24G";

	/**
	 * Component number for the Code subfield.
	 */
	public static final Integer CODE = 1;

	/**
	 * Component number for the Narrative subfield.
	 */
	public static final Integer NARRATIVE = 2;


    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field24G() {
        super(13);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field24G(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field24G(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "24G")) {
            throw new IllegalArgumentException("cannot create field 24G from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field24G newInstance(Field24G source) {
        Field24G cp = new Field24G();
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
        init(13);
        List<String> lines = SwiftParseUtils.getLines(value);
        SwiftParseUtils.setComponentsFromLines(this, 1, null, 0, lines);
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        appendInLines(result, 1, 13);
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
        if (component < 1 || component > 13) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 24G");
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
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(13);
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
        return "SSSSSSSSSSSSS";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "S[$S]0-12";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "4!c(**)[$65z]0-12";
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
        return 13;
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
        result.add("Code");
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
        result.put(2, "narrative");
        result.put(3, "narrative2");
        result.put(4, "narrative3");
        result.put(5, "narrative4");
        result.put(6, "narrative5");
        result.put(7, "narrative6");
        result.put(8, "narrative7");
        result.put(9, "narrative8");
        result.put(10, "narrative9");
        result.put(11, "narrative10");
        result.put(12, "narrative11");
        result.put(13, "narrative12");
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
        super.labelMap.put("code", 1);
        super.labelMap.put("narrative", 2);
        // alias name
        super.labelMap.put("nameandaddress", 2);
        super.labelMap.put("narrative2", 3);
        // alias name
        super.labelMap.put("nameandaddress2", 3);
        super.labelMap.put("narrative3", 4);
        // alias name
        super.labelMap.put("nameandaddress3", 4);
        super.labelMap.put("narrative4", 5);
        // alias name
        super.labelMap.put("nameandaddress4", 5);
        super.labelMap.put("narrative5", 6);
        // alias name
        super.labelMap.put("nameandaddress5", 6);
        super.labelMap.put("narrative6", 7);
        // alias name
        super.labelMap.put("nameandaddress6", 7);
        super.labelMap.put("narrative7", 8);
        // alias name
        super.labelMap.put("nameandaddress7", 8);
        super.labelMap.put("narrative8", 9);
        // alias name
        super.labelMap.put("nameandaddress8", 9);
        super.labelMap.put("narrative9", 10);
        // alias name
        super.labelMap.put("nameandaddress9", 10);
        super.labelMap.put("narrative10", 11);
        // alias name
        super.labelMap.put("nameandaddress10", 11);
        super.labelMap.put("narrative11", 12);
        // alias name
        super.labelMap.put("nameandaddress11", 12);
        super.labelMap.put("narrative12", 13);
        // alias name
        super.labelMap.put("nameandaddress12", 13);
        return super.labelMap;
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
     * Gets the component 2 (Narrative).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Narrative (component 2).
     * @return the Narrative from component 2
     */
    public String getNarrativeLine1() {
        return getComponent2();
    }


    /**
     * Gets the Narrative as a concatenation of component 2 to component 13.
     * @return the Narrative from components
     */
    public String getNarrative() {
        return getNarrative(null);
    }

    /**
     * Gets the Narrative as a concatenation of component 2 to component 13 joined together with a copy of the
     * specified delimiter.
     * @param deli the delimiter that separates each component
     * @return the Narrative from components
     * @since 9.1.4
     */
    public String getNarrative(CharSequence deli) {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i < 14; i++) {
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
     * Gets the component 3 (Narrative 2).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Narrative 2 (component 3).
     * @return the Narrative 2 from component 3
     */
    public String getNarrativeLine2() {
        return getComponent3();
    }


    /**
     * Gets the component 4 (Narrative 3).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the Narrative 3 (component 4).
     * @return the Narrative 3 from component 4
     */
    public String getNarrativeLine3() {
        return getComponent4();
    }


    /**
     * Gets the component 5 (Narrative 4).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Gets the Narrative 4 (component 5).
     * @return the Narrative 4 from component 5
     */
    public String getNarrativeLine4() {
        return getComponent5();
    }


    /**
     * Gets the component 6 (Narrative 5).
     * @return the component 6
     */
    public String getComponent6() {
        return getComponent(6);
    }

    /**
     * Gets the Narrative 5 (component 6).
     * @return the Narrative 5 from component 6
     */
    public String getNarrativeLine5() {
        return getComponent6();
    }


    /**
     * Gets the component 7 (Narrative 6).
     * @return the component 7
     */
    public String getComponent7() {
        return getComponent(7);
    }

    /**
     * Gets the Narrative 6 (component 7).
     * @return the Narrative 6 from component 7
     */
    public String getNarrativeLine6() {
        return getComponent7();
    }


    /**
     * Gets the component 8 (Narrative 7).
     * @return the component 8
     */
    public String getComponent8() {
        return getComponent(8);
    }

    /**
     * Gets the Narrative 7 (component 8).
     * @return the Narrative 7 from component 8
     */
    public String getNarrativeLine7() {
        return getComponent8();
    }


    /**
     * Gets the component 9 (Narrative 8).
     * @return the component 9
     */
    public String getComponent9() {
        return getComponent(9);
    }

    /**
     * Gets the Narrative 8 (component 9).
     * @return the Narrative 8 from component 9
     */
    public String getNarrativeLine8() {
        return getComponent9();
    }


    /**
     * Gets the component 10 (Narrative 9).
     * @return the component 10
     */
    public String getComponent10() {
        return getComponent(10);
    }

    /**
     * Gets the Narrative 9 (component 10).
     * @return the Narrative 9 from component 10
     */
    public String getNarrativeLine9() {
        return getComponent10();
    }


    /**
     * Gets the component 11 (Narrative 10).
     * @return the component 11
     */
    public String getComponent11() {
        return getComponent(11);
    }

    /**
     * Gets the Narrative 10 (component 11).
     * @return the Narrative 10 from component 11
     */
    public String getNarrativeLine10() {
        return getComponent11();
    }


    /**
     * Gets the component 12 (Narrative 11).
     * @return the component 12
     */
    public String getComponent12() {
        return getComponent(12);
    }

    /**
     * Gets the Narrative 11 (component 12).
     * @return the Narrative 11 from component 12
     */
    public String getNarrativeLine11() {
        return getComponent12();
    }


    /**
     * Gets the component 13 (Narrative 12).
     * @return the component 13
     */
    public String getComponent13() {
        return getComponent(13);
    }

    /**
     * Gets the Narrative 12 (component 13).
     * @return the Narrative 12 from component 13
     */
    public String getNarrativeLine12() {
        return getComponent13();
    }


    /**
     * Set the component 1 (Code).
     *
     * @param component1 the Code to set
     * @return the field object to enable build pattern
     */
    public Field24G setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Code (component 1).
     *
     * @param component1 the Code to set
     * @return the field object to enable build pattern
     */
    public Field24G setCode(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Narrative).
     *
     * @param component2 the Narrative to set
     * @return the field object to enable build pattern
     */
    public Field24G setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Narrative (component 2).
     *
     * @param component2 the Narrative to set
     * @return the field object to enable build pattern
     */
    public Field24G setNarrativeLine1(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Narrative splitting the parameter lines into components 2 to 13.
     *
     * @param value the Narrative to set, may contain line ends and each line will be set to its correspondent component attribute
     * @return the field object to enable build pattern
     */
    public Field24G setNarrative(String value) {
        List<String> lines = SwiftParseUtils.getLines(value);
        SwiftParseUtils.setComponentsFromLines(this, 2, 12, 0, lines);
        return this;
    }

    /**
     * Set the component 3 (Narrative 2).
     *
     * @param component3 the Narrative 2 to set
     * @return the field object to enable build pattern
     */
    public Field24G setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Narrative 2 (component 3).
     *
     * @param component3 the Narrative 2 to set
     * @return the field object to enable build pattern
     */
    public Field24G setNarrativeLine2(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Narrative 3).
     *
     * @param component4 the Narrative 3 to set
     * @return the field object to enable build pattern
     */
    public Field24G setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the Narrative 3 (component 4).
     *
     * @param component4 the Narrative 3 to set
     * @return the field object to enable build pattern
     */
    public Field24G setNarrativeLine3(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Narrative 4).
     *
     * @param component5 the Narrative 4 to set
     * @return the field object to enable build pattern
     */
    public Field24G setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the Narrative 4 (component 5).
     *
     * @param component5 the Narrative 4 to set
     * @return the field object to enable build pattern
     */
    public Field24G setNarrativeLine4(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the component 6 (Narrative 5).
     *
     * @param component6 the Narrative 5 to set
     * @return the field object to enable build pattern
     */
    public Field24G setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }

    /**
     * Set the Narrative 5 (component 6).
     *
     * @param component6 the Narrative 5 to set
     * @return the field object to enable build pattern
     */
    public Field24G setNarrativeLine5(String component6) {
        return setComponent6(component6);
    }

    /**
     * Set the component 7 (Narrative 6).
     *
     * @param component7 the Narrative 6 to set
     * @return the field object to enable build pattern
     */
    public Field24G setComponent7(String component7) {
        setComponent(7, component7);
        return this;
    }

    /**
     * Set the Narrative 6 (component 7).
     *
     * @param component7 the Narrative 6 to set
     * @return the field object to enable build pattern
     */
    public Field24G setNarrativeLine6(String component7) {
        return setComponent7(component7);
    }

    /**
     * Set the component 8 (Narrative 7).
     *
     * @param component8 the Narrative 7 to set
     * @return the field object to enable build pattern
     */
    public Field24G setComponent8(String component8) {
        setComponent(8, component8);
        return this;
    }

    /**
     * Set the Narrative 7 (component 8).
     *
     * @param component8 the Narrative 7 to set
     * @return the field object to enable build pattern
     */
    public Field24G setNarrativeLine7(String component8) {
        return setComponent8(component8);
    }

    /**
     * Set the component 9 (Narrative 8).
     *
     * @param component9 the Narrative 8 to set
     * @return the field object to enable build pattern
     */
    public Field24G setComponent9(String component9) {
        setComponent(9, component9);
        return this;
    }

    /**
     * Set the Narrative 8 (component 9).
     *
     * @param component9 the Narrative 8 to set
     * @return the field object to enable build pattern
     */
    public Field24G setNarrativeLine8(String component9) {
        return setComponent9(component9);
    }

    /**
     * Set the component 10 (Narrative 9).
     *
     * @param component10 the Narrative 9 to set
     * @return the field object to enable build pattern
     */
    public Field24G setComponent10(String component10) {
        setComponent(10, component10);
        return this;
    }

    /**
     * Set the Narrative 9 (component 10).
     *
     * @param component10 the Narrative 9 to set
     * @return the field object to enable build pattern
     */
    public Field24G setNarrativeLine9(String component10) {
        return setComponent10(component10);
    }

    /**
     * Set the component 11 (Narrative 10).
     *
     * @param component11 the Narrative 10 to set
     * @return the field object to enable build pattern
     */
    public Field24G setComponent11(String component11) {
        setComponent(11, component11);
        return this;
    }

    /**
     * Set the Narrative 10 (component 11).
     *
     * @param component11 the Narrative 10 to set
     * @return the field object to enable build pattern
     */
    public Field24G setNarrativeLine10(String component11) {
        return setComponent11(component11);
    }

    /**
     * Set the component 12 (Narrative 11).
     *
     * @param component12 the Narrative 11 to set
     * @return the field object to enable build pattern
     */
    public Field24G setComponent12(String component12) {
        setComponent(12, component12);
        return this;
    }

    /**
     * Set the Narrative 11 (component 12).
     *
     * @param component12 the Narrative 11 to set
     * @return the field object to enable build pattern
     */
    public Field24G setNarrativeLine11(String component12) {
        return setComponent12(component12);
    }

    /**
     * Set the component 13 (Narrative 12).
     *
     * @param component13 the Narrative 12 to set
     * @return the field object to enable build pattern
     */
    public Field24G setComponent13(String component13) {
        setComponent(13, component13);
        return this;
    }

    /**
     * Set the Narrative 12 (component 13).
     *
     * @param component13 the Narrative 12 to set
     * @return the field object to enable build pattern
     */
    public Field24G setNarrativeLine12(String component13) {
        return setComponent13(component13);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field24G.NAME
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
    public static Field24G get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field24G(t);
    }

    /**
     * Gets the first instance of Field24G in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field24G get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field24G in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field24G> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field24G from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field24G> getAll(final SwiftTagListBlock block) {
        final List<Field24G> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field24G(f));
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
        Field24G cp = newInstance(this);
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
        Field24G cp = newInstance(this);
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
        Field24G cp = newInstance(this);
        return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
    }

    /**
     * This method deserializes the JSON data into a Field24G object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field24G fromJson(final String json) {

        final Field24G field = new Field24G();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Code

        if (jsonObject.get("code") != null) {
            field.setComponent1(jsonObject.get("code").getAsString());
        }

        // **** COMPONENT 2 - Narrative

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("nameandAddress") != null) {
            field.setComponent2(jsonObject.get("nameandAddress").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("narrative") != null) {
            field.setComponent2(jsonObject.get("narrative").getAsString());
        }

        // **** COMPONENT 3 - Narrative 2

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("nameandAddress2") != null) {
            field.setComponent3(jsonObject.get("nameandAddress2").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("narrative2") != null) {
            field.setComponent3(jsonObject.get("narrative2").getAsString());
        }

        // **** COMPONENT 4 - Narrative 3

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("nameandAddress3") != null) {
            field.setComponent4(jsonObject.get("nameandAddress3").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("narrative3") != null) {
            field.setComponent4(jsonObject.get("narrative3").getAsString());
        }

        // **** COMPONENT 5 - Narrative 4

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("nameandAddress4") != null) {
            field.setComponent5(jsonObject.get("nameandAddress4").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("narrative4") != null) {
            field.setComponent5(jsonObject.get("narrative4").getAsString());
        }

        // **** COMPONENT 6 - Narrative 5

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("nameandAddress5") != null) {
            field.setComponent6(jsonObject.get("nameandAddress5").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("narrative5") != null) {
            field.setComponent6(jsonObject.get("narrative5").getAsString());
        }

        // **** COMPONENT 7 - Narrative 6

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("nameandAddress6") != null) {
            field.setComponent7(jsonObject.get("nameandAddress6").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("narrative6") != null) {
            field.setComponent7(jsonObject.get("narrative6").getAsString());
        }

        // **** COMPONENT 8 - Narrative 7

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("nameandAddress7") != null) {
            field.setComponent8(jsonObject.get("nameandAddress7").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("narrative7") != null) {
            field.setComponent8(jsonObject.get("narrative7").getAsString());
        }

        // **** COMPONENT 9 - Narrative 8

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("nameandAddress8") != null) {
            field.setComponent9(jsonObject.get("nameandAddress8").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("narrative8") != null) {
            field.setComponent9(jsonObject.get("narrative8").getAsString());
        }

        // **** COMPONENT 10 - Narrative 9

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("nameandAddress9") != null) {
            field.setComponent10(jsonObject.get("nameandAddress9").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("narrative9") != null) {
            field.setComponent10(jsonObject.get("narrative9").getAsString());
        }

        // **** COMPONENT 11 - Narrative 10

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("nameandAddress10") != null) {
            field.setComponent11(jsonObject.get("nameandAddress10").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("narrative10") != null) {
            field.setComponent11(jsonObject.get("narrative10").getAsString());
        }

        // **** COMPONENT 12 - Narrative 11

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("nameandAddress11") != null) {
            field.setComponent12(jsonObject.get("nameandAddress11").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("narrative11") != null) {
            field.setComponent12(jsonObject.get("narrative11").getAsString());
        }

        // **** COMPONENT 13 - Narrative 12

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("nameandAddress12") != null) {
            field.setComponent13(jsonObject.get("nameandAddress12").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("narrative12") != null) {
            field.setComponent13(jsonObject.get("narrative12").getAsString());
        }

        return field;
    }


}
