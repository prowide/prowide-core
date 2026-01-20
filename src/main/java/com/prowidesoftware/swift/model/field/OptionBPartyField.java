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
import org.apache.commons.lang3.Strings;

/**
 * Branch of Sender/Receiver
 *
 * <p>Subfields (components) Data types
 * <ol>
 *   <li>Component 1: DCMark: <code>String</code></li>
 *   <li>Component 2: Account: <code>String</code></li>
 *   <li>Component 3: Location: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 *   <li>parser pattern: <code>[[/c][/S]$][S]</code></li>
 *   <li>components pattern: <code>SSS</code></li>
 * </ul>
 *
 * @since 7.11.0
 */
public abstract class OptionBPartyField extends Field implements PartyIdentifier {
    public static final String PARSER_PATTERN = "[[/c][/S]$][S]";

    /**
     * Types pattern
     *
     * Contains a description of the type of each component
     */
    public static final String TYPES_PATTERN = "SSS";

    /**
     * Component number for the D/C Mark subfield
     */
    public static final Integer DC_MARK = 1;

    /**
     * Component number for the Account subfield
     */
    public static final Integer ACCOUNT = 2;

    /**
     * Component number for the Location subfield
     */
    public static final Integer LOCATION = 3;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public OptionBPartyField() {
        super(3);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     *
     * @param value complete field value including separators and CRLF
     */
    public OptionBPartyField(final String value) {
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
        init(3);
        List<String> lines = SwiftParseUtils.getLines(value);
        if (lines.isEmpty()) {
            return;
        }
        if (lines.get(0).startsWith("/")) {
            String party = lines.get(0);
            if (Strings.CS.startsWith(party, "/C/") || Strings.CS.startsWith(party, "/D/")) {
                setComponent(1, String.valueOf(party.charAt(1)));
                setComponent(2, StringUtils.substring(party, 3));
            } else {
                setComponent(2, StringUtils.substring(party, 1));
            }
            if (lines.size() > 1) {
                setComponent(3, lines.get(1));
            }
        } else {
            setComponent(3, lines.get(0));
        }
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        if (getComponent1() != null) {
            result.append("/").append(getComponent1());
        }
        if (getComponent2() != null) {
            result.append("/").append(getComponent2());
        }
        if (getComponent3() != null) {
            if (result.length() > 0) {
                result.append(com.prowidesoftware.swift.io.writer.FINWriterVisitor.SWIFT_EOL);
            }
            result.append(getComponent3());
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
        if (component < 1 || component > 3) {
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
        if (component == 1) {
            return true;
        }
        if (component == 2) {
            return true;
        }
        return component == 3;
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
        return 3;
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
        result.add("D/C Mark");
        result.add("Account");
        result.add("Location");
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
        result.put(1, "dCMark");
        result.put(2, "account");
        result.put(3, "location");
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
        super.labelMap.put("dcmark", 1);
        super.labelMap.put("account", 2);
        super.labelMap.put("location", 3);
        return super.labelMap;
    }

    /**
     * @return the specific field name (number and letter option)
     */
    @Override
    public abstract String getName();

    /**
     * Gets the component1 (D/C Mark).
     *
     * @return the component1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the D/C Mark (component1).
     *
     * @return the D/C Mark from component1
     */
    public String getDCMark() {
        return getComponent(1);
    }

    /**
     * Gets the component2 (Account).
     *
     * @return the component2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Account (component2) removing its starting slashes if any.
     *
     * @return the Account from component2
     */
    public String getAccount() {
        String c = getComponent(2);
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
     * Gets the component3 (Location).
     *
     * @return the component3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Location (component3).
     *
     * @return the Location from component3
     */
    public String getLocation() {
        return getComponent(3);
    }

    /**
     * Get the formatted Party Identifier (CD Mark + Account)
     *
     * The Party Indentifier has the following format:
     *
     * <code>[/{cd-mark}]/{account}</code>
     *
     * @return the formatted Party Identifier
     */
    @Override
    public String getPartyIdentifier() {
        return PartyIdentifierUtils.getPartyIdentifier(this, 1, 2);
    }

    /**
     * Set the formatted Party Identifier (CD Mark + Account)
     *
     * The Party Indentifier has the following format:
     *
     * <code>[/{cd-mark}]/{account}</code>
     *
     * If the format is not valid
     * @param partyIdentifier the formatted Party Identifier to set
     * @return the current OptionBPartyField
     */
    @Override
    public OptionBPartyField setPartyIdentifier(String partyIdentifier) {
        return (OptionBPartyField) PartyIdentifierUtils.setPartyIdentifier(this, 1, 2, partyIdentifier);
    }
}
