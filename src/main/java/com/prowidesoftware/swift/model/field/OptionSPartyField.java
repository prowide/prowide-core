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

/**
 * Party
 *
 * <p>Subfields (components) Data types
 * <ol>
 *   <li>Component 1: Qualifier: <code>String</code></li>
 *   <li>Component 2: DataSourceScheme: <code>String</code></li>
 *   <li>Component 3: TypeofId: <code>String</code></li>
 *   <li>Component 4: CountryCode: <code>String</code></li>
 *   <li>Component 5: AlternateId: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 *   <li>parser pattern: <code>:S/[S]/S/S/S</code></li>
 *   <li>components pattern: <code>SSSKS</code></li>
 * </ul>
 *
 * @since 7.11.0
 */
public abstract class OptionSPartyField extends Field {
    public static final String PARSER_PATTERN = ":S/[S]/S/S/S";

    /**
     * Types pattern
     *
     * Contains a description of the type of each component
     */
    public static final String TYPES_PATTERN = "SSSKS";

    /**
     * Component number for the Qualifier subfield
     */
    public static final Integer QUALIFIER = 1;

    /**
     * Component number for the Data Source Scheme subfield
     */
    public static final Integer DATA_SOURCE_SCHEME = 2;

    /**
     * Component number for the Type Of ID subfield
     */
    public static final Integer TYPE_OF_ID = 3;

    /**
     * Component number for the Country Code subfield
     */
    public static final Integer COUNTRY_CODE = 4;

    /**
     * Component number for the Alternate ID subfield
     */
    public static final Integer ALTERNATE_ID = 5;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public OptionSPartyField() {
        super(5);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     *
     * @param value complete field value including separators and CRLF
     */
    public OptionSPartyField(final String value) {
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
        setComponent(1, SwiftParseUtils.getTokenFirst(value, ":", "/"));
        setComponent(2, SwiftParseUtils.getTokenSecond(value, "/"));
        setComponent(3, SwiftParseUtils.getTokenThird(value, "/"));
        String toparse = SwiftParseUtils.getTokenForthLast(value, "/");
        setComponent(4, SwiftParseUtils.getTokenFirst(toparse, "/"));
        setComponent(5, SwiftParseUtils.getTokenSecondLast(toparse, "/"));
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        result.append(":");
        append(result, 1);
        result.append("/");
        append(result, 2);
        result.append("/");
        append(result, 3);
        result.append("/");
        append(result, 4);
        result.append("/");
        append(result, 5);
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
        return component == 2;
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
    public List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Qualifier");
        result.add("Data Source Scheme");
        result.add("Type Of ID");
        result.add("Country Code");
        result.add("Alternate ID");
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
        result.put(2, "dataSourceScheme");
        result.put(3, "typeOfID");
        result.put(4, "countryCode");
        result.put(5, "alternateID");
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
        super.labelMap.put("datasourcescheme", 2);
        super.labelMap.put("typeofid", 3);
        super.labelMap.put("countrycode", 4);
        super.labelMap.put("alternateid", 5);
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
     * Gets the component2 (Data Source Scheme).
     *
     * @return the component2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Data Source Scheme (component2).
     *
     * @return the Data Source Scheme from component2
     */
    public String getDataSourceScheme() {
        return getComponent(2);
    }

    /**
     * Gets the component3 (Type Of ID).
     *
     * @return the component3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Type Of ID (component3).
     *
     * @return the Type Of ID from component3
     */
    public String getTypeOfID() {
        return getComponent(3);
    }

    /**
     * Gets the component4 (Country Code).
     *
     * @return the component4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the Country Code (component4).
     *
     * @return the Country Code from component4
     */
    public String getCountryCode() {
        return getComponent(4);
    }

    /**
     * Gets the component5 (Alternate ID).
     *
     * @return the component5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Gets the Alternate ID (component5).
     *
     * @return the Alternate ID from component5
     */
    public String getAlternateID() {
        return getComponent(5);
    }
}
