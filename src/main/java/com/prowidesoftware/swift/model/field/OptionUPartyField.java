/*
 * Copyright 2006-2023 Prowide
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

import java.util.*;
import org.apache.commons.lang3.StringUtils;

/**
 * Party
 *
 * <p>Subfields (components) Data types
 * <ol>
 *   <li>Component 1: Qualifier: <code>String</code></li>
 *   <li>Component 2: PartyName: <code>String</code></li>
 *   <li>Component 3: PartyName2: <code>String</code></li>
 *   <li>Component 4: PartyName3: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 *   <li>parser pattern: <code>:S//S[$S]0-2</code></li>
 *   <li>components pattern: <code>SSSS</code></li>
 * </ul>
 *
 * @since 7.11.0
 */
public abstract class OptionUPartyField extends Field {
    public static final String PARSER_PATTERN = ":S//S[$S]0-2";

    /**
     * Types pattern
     *
     * Contains a description of the type of each component
     */
    public static final String TYPES_PATTERN = "SSSS";

    /**
     * Component number for the Qualifier subfield
     */
    public static final Integer QUALIFIER = 1;

    /**
     * Component number for the Party Name subfield
     */
    public static final Integer PARTY_NAME = 2;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public OptionUPartyField() {
        super(4);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     *
     * @param value complete field value including separators and CRLF
     */
    public OptionUPartyField(final String value) {
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
        init(4);
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
        appendInLines(result, 3, 4);
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
        if (component < 1 || component > 4) {
            throw new IllegalArgumentException("invalid component number " + component + " for field " + getName());
        }
        // default format (as is)
        return getComponent(component);
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
        return component == 4;
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
        return 4;
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
    public List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Qualifier");
        result.add("Party Name");
        result.add("Party Name 2");
        result.add("Party Name 3");
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
        result.put(2, "partyName");
        result.put(3, "partyName2");
        result.put(4, "partyName3");
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
        super.labelMap.put("partyname", 2);
        super.labelMap.put("partyname2", 3);
        super.labelMap.put("partyname3", 4);
        return super.labelMap;
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
     * Gets the component2 (Party Name).
     *
     * @return the component2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Party Name (component2).
     *
     * @return the Party Name from component2
     */
    public String getPartyNameLine1() {
        return getComponent(2);
    }

    /**
     * Gets the Party Name (component3).
     *
     * @return the Party Name from component3
     */
    public String getPartyNameLine2() {
        return getComponent(3);
    }

    /**
     * Gets the Party Name (component4).
     *
     * @return the Party Name from component4
     */
    public String getPartyNameLine3() {
        return getComponent(4);
    }

    /**
     * Gets the Party Name as a concatenation of component2 to component4.
     *
     * @return the Party Name from components
     */
    public String getPartyName() {
        StringBuilder result = new StringBuilder();
        for (int i = 2; i < 5; i++) {
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
     * Gets the component3 (Party Name).
     *
     * @return the component3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the component4 (Party Name).
     *
     * @return the component4
     */
    public String getComponent4() {
        return getComponent(4);
    }
}
