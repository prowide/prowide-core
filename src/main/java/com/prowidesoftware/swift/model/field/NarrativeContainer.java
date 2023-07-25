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

/**
 * Fields that are modelled as a single component, but the value contains a narrative that can be parsed into
 * a structured or unstructured format.
 *
 * @see Narrative
 * @since 8.1.0
 */
public interface NarrativeContainer {

    /**
     * Parses the field content into a narrative model.
     *
     * @return the content parsed into a Narrative or an empty Narrative it the field is not well-formed
     */
    Narrative narrative();

    /**
     * Appends a line of content to this field.
     * <p>The parameter line is added to the current value without restrictions or validation. This method is intended
     * for use cases when the internal structure of the field is well-known and you are confident of the content
     * that is added has valid line formats for the specific field.
     *
     * @param line a properly formatted line of content such as "/NAME/Joe Doe"
     * @return this field
     */
    NarrativeContainer appendLine(String line);

    /**
     * Sets or overrides this field value serializing the content of the structured narrative provided by parameter.
     *
     * @param narrative a narrative instance
     * @return this field
     * @see Narrative#builder(int)
     */
    NarrativeContainer setNarrative(Narrative narrative);
}
