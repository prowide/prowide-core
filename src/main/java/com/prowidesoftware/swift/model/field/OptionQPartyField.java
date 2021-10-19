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

import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Party
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>parser pattern: <code>:S//S[$S]0-3</code></li>
 * 		<li>components pattern: <code>SSSSS</code></li>
 * </ul>
 *
 * @since 7.11.0
 */
public abstract class OptionQPartyField extends Field {
    public static final String PARSER_PATTERN = ":S//S[$S]0-3";

    /**
     * Components pattern
     *
     * This is <em>DEPRECATED</em>, use <code>TYPES_PATTERN</code> instead.
     * @see #TYPES_PATTERN
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public static final String COMPONENTS_PATTERN = "SSSSS";

    /**
     * Types pattern
     *
     * Contains a description of the type of each component
     */
    public static final String TYPES_PATTERN = "SSSSS";

    /**
     * Component number for the Qualifier subfield
     */
    public static final Integer QUALIFIER = 1;

    /**
     * Component number for the Name And Address subfield
     */
    public static final Integer NAME_AND_ADDRESS = 2;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public OptionQPartyField() {
        super(5);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     *
     * @param value complete field value including separators and CRLF
     */
    public OptionQPartyField(final String value) {
        super(value);
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
        init(5);
        List<String> lines = SwiftParseUtils.getLines(value);
        if (!lines.isEmpty()) {
            setComponent(1, SwiftParseUtils.getTokenFirst(lines.get(0), ":", "//"));
            setComponent(2, SwiftParseUtils.getTokenSecond(lines.get(0), "//"));
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
        appendInLines(result, 3, 5);
        return result.toString();
    }

    /**
     * Returns a localized suitable for showing to humans string of a field component.<br>
     *
     * @param component number of the component to display
     * @param locale    optional locale to format date and amounts, if null, the default locale is used
     * @return formatted component value or null if component number is invalid or not present
     * @throws IllegalArgumentException if component number is invalid for the field
     * @since 7.8
     */
    @Override
    public String getValueDisplay(int component, Locale locale) {
        if (component < 1 || component > 5) {
            throw new IllegalArgumentException("invalid component number " + component + " for field " + getName());
        }
        //default format (as is)
        return getComponent(component);
    }

    /**
     * Returns the field components pattern
     *
     * This is <em>DEPRECATED</em>, use <code>typesPattern()</code> instead.
     * @return the static value of COMPONENTS_PATTERN
     * @see #typesPattern()
     */
    @Deprecated
    @ProwideDeprecated(phase2= TargetYear.SRU2022)
    @Override
    public final String componentsPattern() {
        return COMPONENTS_PATTERN;
    }

    /**
     * Returns the field component types pattern
     *
     * This method returns a letter representing the type for each component in the Field. It supersedes
     * the Components Pattern because it distinguishes between N (Number) and I (BigDecimal).
     * @see #TYPES_PATTERN
     * @return the static value of TYPES_PATTERN
     */
    @Override
    public final String typesPattern() {
        return TYPES_PATTERN;
    }

    /**
     * Returns the field parser pattern
     *
     * @return the static value of PARSER_PATTERN
     */
    @Override
    public final String parserPattern() {
        return PARSER_PATTERN;
    }

    /**
     * Returns the field validator pattern, that could vary er specific field
     */
    @Override
    public abstract String validatorPattern();

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
        return component == 5;
    }

    /**
     * Returns true if the field is a GENERIC FIELD as specified by the standard.
     *
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
     *
     * @since 7.7
     */
    @Override
    public int componentsSize() {
        return 5;
    }

    /**
     * Returns english label for components.
     * <br>
     * The index in the list is in sync with specific field component structure.
     *
     * @see #getComponentLabel(int)
     * @since 7.8.4
     */
    @Override
    protected List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Qualifier");
        result.add("Name And Address");
        result.add("Name And Address 2");
        result.add("Name And Address 3");
        result.add("Name And Address 4");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     *
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "qualifier");
        result.put(2, "nameAndAddress");
        result.put(3, "nameAndAddress2");
        result.put(4, "nameAndAddress3");
        result.put(5, "nameAndAddress4");
        return result;
    }

    /**
     * @return the specific field name (number and letter option)
     */
    @Override
    public abstract String getName();

    /**
     * Gets the component1 (Qualifier).
     *
     * @return the component1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Qualifier (component1).
     *
     * @return the Qualifier from component1
     */
    public String getQualifier() {
        return getComponent(1);
    }

    /**
     * Gets the component2 (Name And Address).
     *
     * @return the component2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Name And Address (component2).
     *
     * @return the Name And Address from component2
     */
    public String getNameAndAddressLine1() {
        return getComponent(2);
    }

    /**
     * Gets the Name And Address (component3).
     *
     * @return the Name And Address from component3
     */
    public String getNameAndAddressLine2() {
        return getComponent(3);
    }

    /**
     * Gets the Name And Address (component4).
     *
     * @return the Name And Address from component4
     */
    public String getNameAndAddressLine3() {
        return getComponent(4);
    }

    /**
     * Gets the Name And Address (component5).
     *
     * @return the Name And Address from component5
     */
    public String getNameAndAddressLine4() {
        return getComponent(5);
    }

    /**
     * Gets the Name And Address as a concatenation of component2 to component5.
     *
     * @return the Name And Address from components
     */
    public String getNameAndAddress() {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i < 6; i++) {
            if (StringUtils.isNotBlank(getComponent(i))) {
                if (result.length() > 0) {
                    result.append(com.prowidesoftware.swift.io.writer.FINWriterVisitor.SWIFT_EOL);
                }
                result.append(StringUtils.trimToEmpty(getComponent(i)));
            }
        }
        return result.toString();
    }

    /**
     * Gets the component3 (Name And Address).
     *
     * @return the component3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the component4 (Name And Address).
     *
     * @return the component4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the component5 (Name And Address).
     *
     * @return the component5
     */
    public String getComponent5() {
        return getComponent(5);
    }

}
