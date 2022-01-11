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
import com.prowidesoftware.swift.model.BIC;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import java.util.*;

/**
 * Party
 *
 * <p>Subfields (components) Data types
 * <ol>
 *   <li><code>String</code></li>
 *   <li><code>BIC</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 *   <li>parser pattern: <code>:S//S</code></li>
 *   <li>components pattern: <code>SB</code></li>
 * </ul>
 *
 * @since 7.11.0
 */
public abstract class OptionPPartyField extends Field implements BICContainer {
    public static final String PARSER_PATTERN = ":S//S";

    /**
     * Components pattern
     *
     * This is <em>DEPRECATED</em>, use <code>TYPES_PATTERN</code> instead.
     * @see #TYPES_PATTERN
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public static final String COMPONENTS_PATTERN = "SB";

    /**
     * Types pattern
     *
     * Contains a description of the type of each component
     */
    public static final String TYPES_PATTERN = "SB";

    /**
     * Component number for the Qualifier subfield
     */
    public static final Integer QUALIFIER = 1;

    /**
     * Component number for the Identifier Code subfield
     */
    public static final Integer IDENTIFIER_CODE = 2;

    /**
     * Component number for the BIC subfield
     *
     * Use <code>IDENTIFIER_CODE</code> instead
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public static final Integer BIC = 2;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public OptionPPartyField() {
        super(2);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     *
     * @param value complete field value including separators and CRLF
     */
    public OptionPPartyField(final String value) {
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
        init(2);
        setComponent(1, SwiftParseUtils.getTokenFirst(value, ":", "//"));
        setComponent(2, SwiftParseUtils.getTokenSecondLast(value, "//"));
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
        if (component < 1 || component > 2) {
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
        return false;
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
        return 2;
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
        result.add("Identifier Code");
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
        result.put(2, "identifierCode");
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
     * Gets the component2 (BIC).
     *
     * @return the component2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Get the component2 as BIC
     *
     * @return the component2 converted to BIC or null if cannot be converted
     */
    public com.prowidesoftware.swift.model.BIC getComponent2AsBIC() {
        return SwiftFormatUtils.getBIC(getComponent(2));
    }

    /**
     * Gets the Identifier Code (component3).
     *
     * @return the BIC from component3
     */
    public String getIdentifierCode() {
        return getComponent2();
    }

    /**
     * Get the Identifier Code (component3) as BIC
     *
     * @return the BIC from component3 converted to BIC or null if cannot be converted
     */
    public com.prowidesoftware.swift.model.BIC getIdentifierCodeAsBIC() {
        return getComponent2AsBIC();
    }

    /**
     * Gets the BIC (component2).
     *
     * Use <code>getIdentifierCode</code> instead
     *
     * @return the BIC from component2
     * @see #getIdentifierCode()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public String getBIC() {
        return getComponent2();
    }

    /**
     * Get the BIC (component2) as BIC
     *
     * Use <code>getIdentifierCodeAsBIC</code> instead
     *
     * @return the BIC from component2 converted to BIC or null if cannot be converted
     * @see #getIdentifierCodeAsBIC()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public com.prowidesoftware.swift.model.BIC getBICAsBIC() {
        return getComponent2AsBIC();
    }

    @Override
    public List<com.prowidesoftware.swift.model.BIC> bics() {
        final List<BIC> result = new ArrayList<>();
        result.add(SwiftFormatUtils.getBIC(getComponent(2)));
        return result;
    }

    @Override
    public List<String> bicStrings() {
        final List<String> result = new ArrayList<>();
        result.add(getComponent(2));
        return result;
    }

}
