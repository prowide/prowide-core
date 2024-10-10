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

import com.prowidesoftware.swift.model.BIC;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import java.util.*;

/**
 * Identifier Code
 *
 * <p>Subfields (components) Data types
 * <ol>
 *   <li>Component 1: Account: <code>String</code></li>
 *   <li>Component 2: IdentifierCode: <code>BIC</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 *   <li>parser pattern: <code>/S$S</code></li>
 *   <li>components pattern: <code>SB</code></li>
 * </ul>
 *
 * @since 7.11.0
 */
public abstract class OptionGPartyField extends Field implements BICContainer {
    public static final String PARSER_PATTERN = "/S$S";

    /**
     * Types pattern
     *
     * Contains a description of the type of each component
     */
    public static final String TYPES_PATTERN = "SB";

    /**
     * Component number for the Account subfield
     */
    public static final Integer ACCOUNT = 1;

    /**
     * Component number for the Identifier Code subfield
     */
    public static final Integer IDENTIFIER_CODE = 2;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public OptionGPartyField() {
        super(2);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     *
     * @param value complete field value including separators and CRLF
     */
    public OptionGPartyField(final String value) {
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
        List<String> lines = SwiftParseUtils.getLines(value);
        if (!lines.isEmpty()) {
            setComponent(1, SwiftParseUtils.getTokenFirst(lines.get(0), "/", null));
            if (lines.size() > 1) {
                setComponent(2, lines.get(1));
            }
        }
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        result.append("/");
        append(result, 1);
        if (getComponent2() != null) {
            result.append(com.prowidesoftware.swift.io.writer.FINWriterVisitor.SWIFT_EOL)
                    .append(getComponent2());
        }
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
        return false;
    }

    /**
     * Returns true if the field is a GENERIC FIELD as specified by the standard.
     *
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
        result.add("Account");
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
        result.put(1, "account");
        result.put(2, "identifierCode");
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
        super.labelMap.put("account", 1);
        super.labelMap.put("identifiercode", 2);
        return super.labelMap;
    }

    /**
     * @return the specific field name (number and letter option)
     */
    @Override
    public abstract String getName();

    /**
     * Gets the component1 (Account).
     *
     * @return the component1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Account (component1) removing its starting slashes if any.
     *
     * @return the Account from component1
     */
    public String getAccount() {
        String c = getComponent(1);
        if (c != null) {
            for (int i = 0; i < c.length(); i++) {
                if (c.charAt(i) != '/') {
                    return c.substring(i);
                }
            }
            return "";
        }
        return null;
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
     * Gets the Identifier Code (component 2).
     * @return the Identifier Code from component 2
     */
    public String getIdentifierCode() {
        return getComponent2();
    }

    /**
     * Get the Identifier Code (component 2) as BIC
     * @return the Identifier Code from component 2 converted to BIC or null if cannot be converted
     */
    public com.prowidesoftware.swift.model.BIC getIdentifierCodeAsBIC() {
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
