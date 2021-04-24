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
