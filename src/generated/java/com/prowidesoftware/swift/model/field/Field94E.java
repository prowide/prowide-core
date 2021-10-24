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


import com.prowidesoftware.swift.model.field.GenericField;
import com.prowidesoftware.swift.model.field.MultiLineField;

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 94E</strong>
 * <p>
 * Model and parser for field 94E of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
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
 * 		<li>validation pattern: <code>:4!c//35x[$35x]0-9</code></li>
 * 		<li>parser pattern: <code>:S//S[$S]0-9</code></li>
 * 		<li>components pattern: <code>SSSSSSSSSSS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field94E extends Field implements Serializable, GenericField, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 94E
	 */
    public static final String NAME = "94E";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_94E = "94E";
	public static final String PARSER_PATTERN = ":S//S[$S]0-9";

    /**
     * Components pattern
     *
     * Contains a description of the type for every component. This is <em>DEPRECATED</em>,
     * use TYPES_PATTERN instead, because it distinguishes between N (number) and I (BigDecimal)
     * @see #TYPES_PATTERN
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "SSSSSSSSSSS";

    /**
     * Types pattern
     *
     * Contains a description of the type for every component, use instead of COMPONENTS_PATTERN.
     * @since 9.2.7
     */
	public static final String TYPES_PATTERN = "SSSSSSSSSSS";

	/**
	 * Component number for the Qualifier subfield
	 */
	public static final Integer QUALIFIER = 1;

	/**
	 * Component number for the Address subfield
	 */
	public static final Integer ADDRESS = 2;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field94E() {
        super(11);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field94E(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field94E(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "94E")) {
            throw new IllegalArgumentException("cannot create field 94E from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.<br>
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field94E newInstance(Field94E source) {
        Field94E cp = new Field94E();
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
        init(11);
        List<String> lines = SwiftParseUtils.getLines(value);
        if (!lines.isEmpty()) {
            setComponent1(SwiftParseUtils.getTokenFirst(lines.get(0), ":", "//"));
            setComponent2(SwiftParseUtils.getTokenSecondLast(lines.get(0), "//"));
        }
        SwiftParseUtils.setComponentsFromLines(this, 3, null, 1, lines);
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
        appendInLines(result, 3, 11);
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 94E");
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
        return null;
    }

    /**
     * Returns the field components pattern
     *
     * This method is <em>DEPRECATED</em>, use <code>typesPattern()</code> instead.
     * @see #typesPattern()
     * @return the static value of Field94E.COMPONENTS_PATTERN
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
     * @return the static value of Field94E.TYPES_PATTERN
     */
    @Override
    public final String typesPattern() {
        return TYPES_PATTERN;
    }

    /**
     * Returns the field parser pattern
     * @return the static value of Field94E.PARSER_PATTERN
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
        return ":4!c//35x[$35x]0-9";
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
    protected List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Qualifier");
        result.add("Address");
        result.add("Address 2");
        result.add("Address 3");
        result.add("Address 4");
        result.add("Address 5");
        result.add("Address 6");
        result.add("Address 7");
        result.add("Address 8");
        result.add("Address 9");
        result.add("Address 10");
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
        result.put(2, "address");
        result.put(3, "address2");
        result.put(4, "address3");
        result.put(5, "address4");
        result.put(6, "address5");
        result.put(7, "address6");
        result.put(8, "address7");
        result.put(9, "address8");
        result.put(10, "address9");
        result.put(11, "address10");
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
     * Gets the component 2 (Address).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Address (component 2).
     * @return the Address from component 2
     */
    public String getAddressLine1() {
        return getComponent2();
    }

    /**
     * Gets the Address as a concatenation of component 2 to component 11.
     * @return the Address from components
     */
    public String getAddress() {
        return getAddress(null);
    }

    /**
     * Gets the Address as a concatenation of component 2 to component 11 joined together with a copy of the
     * specified delimiter.
     * @param deli the delimiter that separates each component
     * @return the Address from components
     * @since 9.1.4
     */
    public String getAddress(CharSequence deli) {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i < 12; i++) {
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
     * Gets the component 3 (Address 2).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Address 2 (component 3).
     * @return the Address 2 from component 3
     */
    public String getAddressLine2() {
        return getComponent3();
    }

    /**
     * Gets the component 4 (Address 3).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the Address 3 (component 4).
     * @return the Address 3 from component 4
     */
    public String getAddressLine3() {
        return getComponent4();
    }

    /**
     * Gets the component 5 (Address 4).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Gets the Address 4 (component 5).
     * @return the Address 4 from component 5
     */
    public String getAddressLine4() {
        return getComponent5();
    }

    /**
     * Gets the component 6 (Address 5).
     * @return the component 6
     */
    public String getComponent6() {
        return getComponent(6);
    }

    /**
     * Gets the Address 5 (component 6).
     * @return the Address 5 from component 6
     */
    public String getAddressLine5() {
        return getComponent6();
    }

    /**
     * Gets the component 7 (Address 6).
     * @return the component 7
     */
    public String getComponent7() {
        return getComponent(7);
    }

    /**
     * Gets the Address 6 (component 7).
     * @return the Address 6 from component 7
     */
    public String getAddressLine6() {
        return getComponent7();
    }

    /**
     * Gets the component 8 (Address 7).
     * @return the component 8
     */
    public String getComponent8() {
        return getComponent(8);
    }

    /**
     * Gets the Address 7 (component 8).
     * @return the Address 7 from component 8
     */
    public String getAddressLine7() {
        return getComponent8();
    }

    /**
     * Gets the component 9 (Address 8).
     * @return the component 9
     */
    public String getComponent9() {
        return getComponent(9);
    }

    /**
     * Gets the Address 8 (component 9).
     * @return the Address 8 from component 9
     */
    public String getAddressLine8() {
        return getComponent9();
    }

    /**
     * Gets the component 10 (Address 9).
     * @return the component 10
     */
    public String getComponent10() {
        return getComponent(10);
    }

    /**
     * Gets the Address 9 (component 10).
     * @return the Address 9 from component 10
     */
    public String getAddressLine9() {
        return getComponent10();
    }

    /**
     * Gets the component 11 (Address 10).
     * @return the component 11
     */
    public String getComponent11() {
        return getComponent(11);
    }

    /**
     * Gets the Address 10 (component 11).
     * @return the Address 10 from component 11
     */
    public String getAddressLine10() {
        return getComponent11();
    }

    /**
     * Set the component 1 (Qualifier).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field94E setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Qualifier (component 1).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field94E setQualifier(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Address).
     *
     * @param component2 the Address to set
     * @return the field object to enable build pattern
     */
    public Field94E setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Address (component 2).
     *
     * @param component2 the Address to set
     * @return the field object to enable build pattern
     */
    public Field94E setAddressLine1(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Address splitting the parameter lines into components 2 to 11.
     *
     * @param value the Address to set, may contain line ends and each line will be set to its correspondent component attribute
     * @return the field object to enable build pattern
     */
    public Field94E setAddress(String value) {
        List<String> lines = SwiftParseUtils.getLines(value);
        SwiftParseUtils.setComponentsFromLines(this, 2, 10, 0, lines);
        return this;
    }

    /**
     * Set the component 3 (Address 2).
     *
     * @param component3 the Address 2 to set
     * @return the field object to enable build pattern
     */
    public Field94E setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Address 2 (component 3).
     *
     * @param component3 the Address 2 to set
     * @return the field object to enable build pattern
     */
    public Field94E setAddressLine2(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Address 3).
     *
     * @param component4 the Address 3 to set
     * @return the field object to enable build pattern
     */
    public Field94E setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the Address 3 (component 4).
     *
     * @param component4 the Address 3 to set
     * @return the field object to enable build pattern
     */
    public Field94E setAddressLine3(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Address 4).
     *
     * @param component5 the Address 4 to set
     * @return the field object to enable build pattern
     */
    public Field94E setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the Address 4 (component 5).
     *
     * @param component5 the Address 4 to set
     * @return the field object to enable build pattern
     */
    public Field94E setAddressLine4(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the component 6 (Address 5).
     *
     * @param component6 the Address 5 to set
     * @return the field object to enable build pattern
     */
    public Field94E setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }

    /**
     * Set the Address 5 (component 6).
     *
     * @param component6 the Address 5 to set
     * @return the field object to enable build pattern
     */
    public Field94E setAddressLine5(String component6) {
        return setComponent6(component6);
    }

    /**
     * Set the component 7 (Address 6).
     *
     * @param component7 the Address 6 to set
     * @return the field object to enable build pattern
     */
    public Field94E setComponent7(String component7) {
        setComponent(7, component7);
        return this;
    }

    /**
     * Set the Address 6 (component 7).
     *
     * @param component7 the Address 6 to set
     * @return the field object to enable build pattern
     */
    public Field94E setAddressLine6(String component7) {
        return setComponent7(component7);
    }

    /**
     * Set the component 8 (Address 7).
     *
     * @param component8 the Address 7 to set
     * @return the field object to enable build pattern
     */
    public Field94E setComponent8(String component8) {
        setComponent(8, component8);
        return this;
    }

    /**
     * Set the Address 7 (component 8).
     *
     * @param component8 the Address 7 to set
     * @return the field object to enable build pattern
     */
    public Field94E setAddressLine7(String component8) {
        return setComponent8(component8);
    }

    /**
     * Set the component 9 (Address 8).
     *
     * @param component9 the Address 8 to set
     * @return the field object to enable build pattern
     */
    public Field94E setComponent9(String component9) {
        setComponent(9, component9);
        return this;
    }

    /**
     * Set the Address 8 (component 9).
     *
     * @param component9 the Address 8 to set
     * @return the field object to enable build pattern
     */
    public Field94E setAddressLine8(String component9) {
        return setComponent9(component9);
    }

    /**
     * Set the component 10 (Address 9).
     *
     * @param component10 the Address 9 to set
     * @return the field object to enable build pattern
     */
    public Field94E setComponent10(String component10) {
        setComponent(10, component10);
        return this;
    }

    /**
     * Set the Address 9 (component 10).
     *
     * @param component10 the Address 9 to set
     * @return the field object to enable build pattern
     */
    public Field94E setAddressLine9(String component10) {
        return setComponent10(component10);
    }

    /**
     * Set the component 11 (Address 10).
     *
     * @param component11 the Address 10 to set
     * @return the field object to enable build pattern
     */
    public Field94E setComponent11(String component11) {
        setComponent(11, component11);
        return this;
    }

    /**
     * Set the Address 10 (component 11).
     *
     * @param component11 the Address 10 to set
     * @return the field object to enable build pattern
     */
    public Field94E setAddressLine10(String component11) {
        return setComponent11(component11);
    }



    /**
     * Returns the issuer code (or Data Source Scheme or DSS).
     * The DSS is only present in some generic fields, when present, is equals to component two.
     *
     * @return DSS component value or null if the DSS is not set or not available for this field.
     */
    public String getDSS() {
        return null;
    }

    /**
     * Checks if the issuer code (or Data Source Scheme or DSS) is present.
     *
     * @see #getDSS()
     * @return true if DSS is present, false otherwise.
     */
    public boolean isDSSPresent() {
        return false;
    }

    /**
     * Component number for the conditional qualifier subfield
     */
    public static final Integer CONDITIONAL_QUALIFIER = 2;

    /**
     * Gets the component with the conditional (secondary) qualifier.
     *
     * @return for generic fields returns the value of the conditional qualifier or null if not set or not applicable for this field.
     */
    public String getConditionalQualifier() {
        return getComponent(CONDITIONAL_QUALIFIER);
    }

    /**
     * Returns the field's name composed by the field number and the letter option (if any)
     * @return the static value of Field94E.NAME
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
    public static Field94E get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field94E(t) ;
    }

    /**
     * Gets the first instance of Field94E in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field94E get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return null;
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field94E in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field94E> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return java.util.Collections.emptyList();
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field94E from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field94E> getAll(final SwiftTagListBlock block) {
        final List<Field94E> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add( new Field94E(f));
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
        Field94E cp = newInstance(this);
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
        Field94E cp = newInstance(this);
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
        Field94E cp = newInstance(this);
        return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
    }

    /**
     * This method deserializes the JSON data into a Field94E object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field94E fromJson(final String json) {

        Field94E field = new Field94E();

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(json);

        // **** COMPONENT 1 - Qualifier

        if (jsonObject.get("qualifier") != null) {
            field.setComponent1(jsonObject.get("qualifier").getAsString());
        }

        // **** COMPONENT 2 - Address

        if (jsonObject.get("address") != null) {
            field.setComponent2(jsonObject.get("address").getAsString());
        }

        // **** COMPONENT 3 - Address 2

        if (jsonObject.get("address2") != null) {
            field.setComponent3(jsonObject.get("address2").getAsString());
        }

        // **** COMPONENT 4 - Address 3

        if (jsonObject.get("address3") != null) {
            field.setComponent4(jsonObject.get("address3").getAsString());
        }

        // **** COMPONENT 5 - Address 4

        if (jsonObject.get("address4") != null) {
            field.setComponent5(jsonObject.get("address4").getAsString());
        }

        // **** COMPONENT 6 - Address 5

        if (jsonObject.get("address5") != null) {
            field.setComponent6(jsonObject.get("address5").getAsString());
        }

        // **** COMPONENT 7 - Address 6

        if (jsonObject.get("address6") != null) {
            field.setComponent7(jsonObject.get("address6").getAsString());
        }

        // **** COMPONENT 8 - Address 7

        if (jsonObject.get("address7") != null) {
            field.setComponent8(jsonObject.get("address7").getAsString());
        }

        // **** COMPONENT 9 - Address 8

        if (jsonObject.get("address8") != null) {
            field.setComponent9(jsonObject.get("address8").getAsString());
        }

        // **** COMPONENT 10 - Address 9

        if (jsonObject.get("address9") != null) {
            field.setComponent10(jsonObject.get("address9").getAsString());
        }

        // **** COMPONENT 11 - Address 10

        if (jsonObject.get("address10") != null) {
            field.setComponent11(jsonObject.get("address10").getAsString());
        }

        return field;
    }


}
