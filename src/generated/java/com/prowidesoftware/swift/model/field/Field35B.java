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


import com.prowidesoftware.swift.model.field.MultiLineField;

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 35B.
 * <p>
 * Model and parser for field 35B of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>[&lt;ISIN&gt; 12!c][$][35x][$35x]0-3(****)</code></li>
 * 		<li>parser pattern: <code>[&lt;ISIN&gt;&lt;SPACE&gt;S][$S]0-4</code></li>
 * 		<li>components pattern: <code>SSSSSS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field35B extends Field implements Serializable, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 35B.
	 */
    public static final String NAME = "35B";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_35B = "35B";

    /**
     * @deprecated use {@link #parserPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
	public static final String PARSER_PATTERN = "[<ISIN><SPACE>S][$S]0-4";

    /**
     * @deprecated use {@link #typesPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "SSSSSS";

    /**
     * @deprecated use {@link #typesPattern()} method instead.
     */
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
	public static final String TYPES_PATTERN = "SSSSSS";

	/**
	 * Component number for the Qualifier subfield.
	 */
	public static final Integer QUALIFIER = 1;

	/**
	 * Component number for the ISIN subfield.
	 */
	public static final Integer ISIN = 2;

	/**
     * Alternative constant name for field's ISIN Component number.
     * @see #ISIN
     */
    public static final Integer IDENTIFICATION_OF_INSTRUMENT = 2;

	/**
     * Alternative constant name for field's ISIN Component number.
     * @see #ISIN
     */
    public static final Integer IDENTIFICATION_OF_SECURITY = 2;

	/**
	 * Component number for the Description subfield.
	 */
	public static final Integer DESCRIPTION = 3;

	/**
     * Alternative constant name for field's Description Component number.
     * @see #DESCRIPTION
     */
    public static final Integer DESCRIPTION_OF_INSTRUMENT = 3;

	/**
     * Alternative constant name for field's Description Component number.
     * @see #DESCRIPTION
     */
    public static final Integer DESCRIPTION_OF_SECURITY = 3;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field35B() {
        super(6);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field35B(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field35B(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "35B")) {
            throw new IllegalArgumentException("cannot create field 35B from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field35B newInstance(Field35B source) {
        Field35B cp = new Field35B();
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
        List<String> lines = SwiftParseUtils.getLines(value);
        if (!lines.isEmpty() && StringUtils.startsWith(lines.get(0), "ISIN ")) {
            setComponent1(SwiftParseUtils.getTokenFirst(lines.get(0), " "));
            setComponent2(SwiftParseUtils.getTokenSecondLast(lines.get(0), " "));
            SwiftParseUtils.setComponentsFromLines(this, 3, null, 1, lines);
        } else {
            SwiftParseUtils.setComponentsFromLines(this, 3, null, 0, lines);
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
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(getComponent2());
        }
        appendInLines(result, 3, 6);
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 35B");
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
        return null;
    }

    /**
     * @deprecated use {@link #typesPattern()} instead.
     */
    @Override
    @Deprecated
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public String componentsPattern() {
        return "SSSSSS";
    }

    /**
     * Returns the field component types pattern.
     *
     * This method returns a letter representing the type for each component in the Field. It supersedes
     * the Components Pattern because it distinguishes between N (Number) and I (BigDecimal).
     * @since 9.2.7
     */
    @Override
    public String typesPattern() {
        return "SSSSSS";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "[<ISIN><SPACE>S][$S]0-4";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "[<ISIN> 12!c][$][35x][$35x]0-3(****)";
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
        if (component == 1) {
            return true;
        }
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
        result.add("Qualifier");
        result.add("ISIN");
        result.add("Description");
        result.add("Description 2");
        result.add("Description 3");
        result.add("Description 4");
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
        result.put(2, "iSIN");
        result.put(3, "description");
        result.put(4, "description2");
        result.put(5, "description3");
        result.put(6, "description4");
        return result;
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
     * Gets the component 2 (ISIN).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the ISIN (component 2).
     * @return the ISIN from component 2
     */
    public String getISIN() {
        return getComponent2();
    }

    /**
     * Alternative method getter for field's ISIN
     * @see #getISIN()
     * @since 9.2.7
     */
    public String getIdentificationOfInstrument() {
        return getISIN();
    }

    /**
     * Alternative method getter for field's ISIN
     * @see #getISIN()
     * @since 9.2.7
     */
    public String getIdentificationOfSecurity() {
        return getISIN();
    }

    /**
     * Gets the component 3 (Description).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Description (component 3).
     * @return the Description from component 3
     */
    public String getDescriptionLine1() {
        return getComponent3();
    }

    /**
     * Alternative method getter for field's Description
     * @see #getDescriptionLine1()
     * @since 9.2.7
     */
    public String getDescriptionOfInstrumentLine1() {
        return getDescriptionLine1();
    }

    /**
     * Alternative method getter for field's Description
     * @see #getDescriptionLine1()
     * @since 9.2.7
     */
    public String getDescriptionOfSecurityLine1() {
        return getDescriptionLine1();
    }

    /**
     * Gets the Description as a concatenation of component 3 to component 6.
     * @return the Description from components
     */
    public String getDescription() {
        return getDescription(null);
    }

    /**
     * Gets the Description as a concatenation of component 3 to component 6 joined together with a copy of the
     * specified delimiter.
     * @param deli the delimiter that separates each component
     * @return the Description from components
     * @since 9.1.4
     */
    public String getDescription(CharSequence deli) {
        StringBuilder result = new StringBuilder();
        for (int i = 3; i < 7; i++) {
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
     * Alternative method getter for concatenation
     * of component 3 to component 6 joined together with a copy of the
     * specified delimiter.
     * @return the Description from components
     * @see #getDescription()
     */
    public String getDescriptionOfInstrument() {
        return getDescription();
    }

    /**
     * Alternative method getter for concatenation
     * of component 3 to component 6 joined together with a copy of the
     * specified delimiter.
     * @param deli the delimiter that separates each component
     * @return the Description from components
     * @see #getDescription()
     */
    public String getDescriptionOfInstrument(CharSequence deli) {
        return getDescription(deli);
    }

    /**
     * Alternative method getter for concatenation
     * of component 3 to component 6 joined together with a copy of the
     * specified delimiter.
     * @return the Description from components
     * @see #getDescription()
     */
    public String getDescriptionOfSecurity() {
        return getDescription();
    }

    /**
     * Alternative method getter for concatenation
     * of component 3 to component 6 joined together with a copy of the
     * specified delimiter.
     * @param deli the delimiter that separates each component
     * @return the Description from components
     * @see #getDescription()
     */
    public String getDescriptionOfSecurity(CharSequence deli) {
        return getDescription(deli);
    }

    /**
     * Gets the component 4 (Description 2).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the Description 2 (component 4).
     * @return the Description 2 from component 4
     */
    public String getDescriptionLine2() {
        return getComponent4();
    }

    /**
     * Alternative method getter for field's Description 2
     * @see #getDescriptionLine2()
     * @since 9.2.7
     */
    public String getDescriptionOfInstrumentLine2() {
        return getDescriptionLine2();
    }

    /**
     * Alternative method getter for field's Description 2
     * @see #getDescriptionLine2()
     * @since 9.2.7
     */
    public String getDescriptionOfSecurityLine2() {
        return getDescriptionLine2();
    }

    /**
     * Gets the component 5 (Description 3).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Gets the Description 3 (component 5).
     * @return the Description 3 from component 5
     */
    public String getDescriptionLine3() {
        return getComponent5();
    }

    /**
     * Alternative method getter for field's Description 3
     * @see #getDescriptionLine3()
     * @since 9.2.7
     */
    public String getDescriptionOfInstrumentLine3() {
        return getDescriptionLine3();
    }

    /**
     * Alternative method getter for field's Description 3
     * @see #getDescriptionLine3()
     * @since 9.2.7
     */
    public String getDescriptionOfSecurityLine3() {
        return getDescriptionLine3();
    }

    /**
     * Gets the component 6 (Description 4).
     * @return the component 6
     */
    public String getComponent6() {
        return getComponent(6);
    }

    /**
     * Gets the Description 4 (component 6).
     * @return the Description 4 from component 6
     */
    public String getDescriptionLine4() {
        return getComponent6();
    }

    /**
     * Alternative method getter for field's Description 4
     * @see #getDescriptionLine4()
     * @since 9.2.7
     */
    public String getDescriptionOfInstrumentLine4() {
        return getDescriptionLine4();
    }

    /**
     * Alternative method getter for field's Description 4
     * @see #getDescriptionLine4()
     * @since 9.2.7
     */
    public String getDescriptionOfSecurityLine4() {
        return getDescriptionLine4();
    }

    /**
     * Set the component 1 (Qualifier).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field35B setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Qualifier (component 1).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field35B setQualifier(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (ISIN).
     *
     * @param component2 the ISIN to set
     * @return the field object to enable build pattern
     */
    public Field35B setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the ISIN (component 2).
     *
     * @param component2 the ISIN to set
     * @return the field object to enable build pattern
     */
    public Field35B setISIN(String component2) {
        return setComponent2(component2);
    }

    /**
     * Alternative method setter for field's ISIN
     *
     * @see #setISIN(String)
     *
     * @param component2 the ISIN to set
     * @return the field object to enable build pattern
     */
    public Field35B setIdentificationOfInstrument(String component2) {
        return setISIN(component2);
    }

    /**
     * Alternative method setter for field's ISIN
     *
     * @see #setISIN(String)
     *
     * @param component2 the ISIN to set
     * @return the field object to enable build pattern
     */
    public Field35B setIdentificationOfSecurity(String component2) {
        return setISIN(component2);
    }

    /**
     * Set the component 3 (Description).
     *
     * @param component3 the Description to set
     * @return the field object to enable build pattern
     */
    public Field35B setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Description (component 3).
     *
     * @param component3 the Description to set
     * @return the field object to enable build pattern
     */
    public Field35B setDescriptionLine1(String component3) {
        return setComponent3(component3);
    }

    /**
     * Alternative method setter for field's Description
     *
     * @see #setDescriptionLine1(String)
     *
     * @param component3 the Description to set
     * @return the field object to enable build pattern
     */
    public Field35B setDescriptionOfInstrumentLine1(String component3) {
        return setDescriptionLine1(component3);
    }

    /**
     * Alternative method setter for field's Description
     *
     * @see #setDescriptionLine1(String)
     *
     * @param component3 the Description to set
     * @return the field object to enable build pattern
     */
    public Field35B setDescriptionOfSecurityLine1(String component3) {
        return setDescriptionLine1(component3);
    }

    /**
     * Set the Description splitting the parameter lines into components 3 to 6.
     *
     * @param value the Description to set, may contain line ends and each line will be set to its correspondent component attribute
     * @return the field object to enable build pattern
     */
    public Field35B setDescription(String value) {
        List<String> lines = SwiftParseUtils.getLines(value);
        SwiftParseUtils.setComponentsFromLines(this, 3, 4, 0, lines);
        return this;
    }

    /**
     * Alternative method setter for
     * the Description splitting the parameter lines into components 3 to 6.
     *
     * @param value the Description to set, may contain line ends and each line will be set to its correspondent component attribute
     * @return the field object to enable build pattern
     * @see #setDescription(String)
     */
    public Field35B setDescriptionOfInstrument(String value) {
        return setDescription(value);
    }

    /**
     * Alternative method setter for
     * the Description splitting the parameter lines into components 3 to 6.
     *
     * @param value the Description to set, may contain line ends and each line will be set to its correspondent component attribute
     * @return the field object to enable build pattern
     * @see #setDescription(String)
     */
    public Field35B setDescriptionOfSecurity(String value) {
        return setDescription(value);
    }

    /**
     * Set the component 4 (Description 2).
     *
     * @param component4 the Description 2 to set
     * @return the field object to enable build pattern
     */
    public Field35B setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the Description 2 (component 4).
     *
     * @param component4 the Description 2 to set
     * @return the field object to enable build pattern
     */
    public Field35B setDescriptionLine2(String component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative method setter for field's Description 2
     *
     * @see #setDescriptionLine2(String)
     *
     * @param component4 the Description 2 to set
     * @return the field object to enable build pattern
     */
    public Field35B setDescriptionOfInstrumentLine2(String component4) {
        return setDescriptionLine2(component4);
    }

    /**
     * Alternative method setter for field's Description 2
     *
     * @see #setDescriptionLine2(String)
     *
     * @param component4 the Description 2 to set
     * @return the field object to enable build pattern
     */
    public Field35B setDescriptionOfSecurityLine2(String component4) {
        return setDescriptionLine2(component4);
    }

    /**
     * Set the component 5 (Description 3).
     *
     * @param component5 the Description 3 to set
     * @return the field object to enable build pattern
     */
    public Field35B setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the Description 3 (component 5).
     *
     * @param component5 the Description 3 to set
     * @return the field object to enable build pattern
     */
    public Field35B setDescriptionLine3(String component5) {
        return setComponent5(component5);
    }

    /**
     * Alternative method setter for field's Description 3
     *
     * @see #setDescriptionLine3(String)
     *
     * @param component5 the Description 3 to set
     * @return the field object to enable build pattern
     */
    public Field35B setDescriptionOfInstrumentLine3(String component5) {
        return setDescriptionLine3(component5);
    }

    /**
     * Alternative method setter for field's Description 3
     *
     * @see #setDescriptionLine3(String)
     *
     * @param component5 the Description 3 to set
     * @return the field object to enable build pattern
     */
    public Field35B setDescriptionOfSecurityLine3(String component5) {
        return setDescriptionLine3(component5);
    }

    /**
     * Set the component 6 (Description 4).
     *
     * @param component6 the Description 4 to set
     * @return the field object to enable build pattern
     */
    public Field35B setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }

    /**
     * Set the Description 4 (component 6).
     *
     * @param component6 the Description 4 to set
     * @return the field object to enable build pattern
     */
    public Field35B setDescriptionLine4(String component6) {
        return setComponent6(component6);
    }

    /**
     * Alternative method setter for field's Description 4
     *
     * @see #setDescriptionLine4(String)
     *
     * @param component6 the Description 4 to set
     * @return the field object to enable build pattern
     */
    public Field35B setDescriptionOfInstrumentLine4(String component6) {
        return setDescriptionLine4(component6);
    }

    /**
     * Alternative method setter for field's Description 4
     *
     * @see #setDescriptionLine4(String)
     *
     * @param component6 the Description 4 to set
     * @return the field object to enable build pattern
     */
    public Field35B setDescriptionOfSecurityLine4(String component6) {
        return setDescriptionLine4(component6);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field35B.NAME
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
    public static Field35B get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field35B(t);
    }

    /**
     * Gets the first instance of Field35B in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field35B get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field35B in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field35B> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field35B from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field35B> getAll(final SwiftTagListBlock block) {
        final List<Field35B> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add(new Field35B(f));
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
    public String getLine(int line, int offset) {
        Field35B cp = newInstance(this);
        return getLine(cp, line, null, offset);
    }

    /**
     * Returns the field value split into lines.
     *
     * @see MultiLineField#getLines()
     * @return lines content or empty list if field's value is empty
     * @since 7.7
     */
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
    public List<String> getLines(int offset) {
        Field35B cp = newInstance(this);
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
    public List<String> getLinesBetween(int start, int end, int offset) {
        Field35B cp = newInstance(this);
        return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
    }

    /**
     * This method deserializes the JSON data into a Field35B object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field35B fromJson(final String json) {

        final Field35B field = new Field35B();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Qualifier

        if (jsonObject.get("qualifier") != null) {
            field.setComponent1(jsonObject.get("qualifier").getAsString());
        }

        // **** COMPONENT 2 - ISIN

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("identificationOfInstrument") != null) {
            field.setComponent2(jsonObject.get("identificationOfInstrument").getAsString());
        }
        if (jsonObject.get("identificationOfSecurity") != null) {
            field.setComponent2(jsonObject.get("identificationOfSecurity").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("iSIN") != null) {
            field.setComponent2(jsonObject.get("iSIN").getAsString());
        }

        // **** COMPONENT 3 - Description

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("descriptionOfInstrument") != null) {
            field.setComponent3(jsonObject.get("descriptionOfInstrument").getAsString());
        }
        if (jsonObject.get("descriptionOfSecurity") != null) {
            field.setComponent3(jsonObject.get("descriptionOfSecurity").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("description") != null) {
            field.setComponent3(jsonObject.get("description").getAsString());
        }

        // **** COMPONENT 4 - Description 2

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("descriptionOfInstrument2") != null) {
            field.setComponent4(jsonObject.get("descriptionOfInstrument2").getAsString());
        }
        if (jsonObject.get("descriptionOfSecurity2") != null) {
            field.setComponent4(jsonObject.get("descriptionOfSecurity2").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("description2") != null) {
            field.setComponent4(jsonObject.get("description2").getAsString());
        }

        // **** COMPONENT 5 - Description 3

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("descriptionOfInstrument3") != null) {
            field.setComponent5(jsonObject.get("descriptionOfInstrument3").getAsString());
        }
        if (jsonObject.get("descriptionOfSecurity3") != null) {
            field.setComponent5(jsonObject.get("descriptionOfSecurity3").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("description3") != null) {
            field.setComponent5(jsonObject.get("description3").getAsString());
        }

        // **** COMPONENT 6 - Description 4

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("descriptionOfInstrument4") != null) {
            field.setComponent6(jsonObject.get("descriptionOfInstrument4").getAsString());
        }
        if (jsonObject.get("descriptionOfSecurity4") != null) {
            field.setComponent6(jsonObject.get("descriptionOfSecurity4").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("description4") != null) {
            field.setComponent6(jsonObject.get("description4").getAsString());
        }

        return field;
    }


}
