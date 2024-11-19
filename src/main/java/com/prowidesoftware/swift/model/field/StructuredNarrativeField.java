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

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;
import java.util.*;

/**
 * Common API for fields supporting a structured narrative option.
 *
 * <p>These fields support having a simple unstructured content splitted in lines and also a structured version with
 * codewords. The codewords are separated with slashes and can be use to categorize part of the narrative content.
 *
 * <p>Different structured line formats are defined depending on the  field number and letter option. This API provides
 * a simple way to get portions of the structured narrative using the code words, regardless of the specific line format
 * the field supports.
 *
 * @since 9.0.1
 */
public abstract class StructuredNarrativeField extends Field implements NarrativeContainer {
    public static final String PARSER_PATTERN = "S";

    /**
     * Types pattern
     *
     * Contains a description of the type of each component
     */
    public static final String TYPES_PATTERN = "S";

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public StructuredNarrativeField() {
        super(1);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     *
     * @param value complete field value including separators and CRLF
     */
    public StructuredNarrativeField(final String value) {
        super(value);
    }

    /**
     * Parses the parameter value into the internal components structure.
     *
     * <p>The narrative fields are modelled as a single String component containing the complete field value, with
     * all its lines and structured content if any. The API provided for this class allows getting specific lines
     * or specific portions of the structured narrative content with ease.
     *
     * @param value complete field value including separators and CRLF
     * @since 7.8
     */
    @Override
    public void parse(String value) {
        init(1);
        setComponent(1, value);
    }

    @Override
    public String getValueDisplay(int component, Locale locale) {
        if (component != 1) {
            throw new IllegalArgumentException("invalid component number " + component + " for field " + getName());
        }
        // default format (as is)
        return getComponent1();
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        return getComponent1();
    }

    @Override
    public abstract String getName();

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
     * regardless of the field being mandatory in a particular message.
     *
     * @param component component number, first component of a field is referenced as 1
     * @return always returns false since Narrative fields are modelled as a single mandatory component
     */
    @Override
    public boolean isOptional(int component) {
        return false;
    }

    /**
     * Returns true if the field is a GENERIC FIELD as specified by the standard.
     *
     * @return always false since narrative fields are not generic fields
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
     * @return for narrative fields this method always returns 1
     * @since 7.7
     */
    @Override
    public int componentsSize() {
        return 1;
    }

    /**
     * Returns english label for components.
     * <br>
     * The index in the list is in sync with specific field component structure.
     *
     * @return for Narrative fields returns a single element for the "Narrative" as a single component
     * @see #getComponentLabel(int)
     * @since 7.8.4
     */
    @Override
    public List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Narrative");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     *
     * @return for Narrative fields returns a single entry for the "Narrative" as a single component
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "narrative");
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
        return super.labelMap;
    }

    /**
     * Gets the single field component with the complete consolidated narrative content.
     *
     * @return the narrative content
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * @see NarrativeContainer#narrative()
     */
    @Override
    public Narrative narrative() {
        return NarrativeResolver.parse(this);
    }

    /**
     * @see NarrativeContainer#appendLine(String)
     */
    @Override
    public NarrativeContainer appendLine(String line) {
        StringBuilder value = new StringBuilder();
        if (getComponent1() != null) {
            value.append(getComponent1());
        }
        if (value.length() > 0) {
            // if there is some content already, add a line break
            value.append(FINWriterVisitor.SWIFT_EOL);
        }

        // append new line
        value.append(line);

        // override internal field value
        setComponent(1, value.toString());

        return this;
    }

    /**
     * @see NarrativeContainer#setNarrative(Narrative)
     */
    @Override
    public NarrativeContainer setNarrative(Narrative narrative) {
        // override current value with serialized narrative
        setComponent(1, narrative.getValue());
        return this;
    }
}
