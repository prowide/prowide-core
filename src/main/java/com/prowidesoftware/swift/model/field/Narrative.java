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
import com.prowidesoftware.swift.utils.LineWrapper;
import java.math.BigDecimal;
import java.util.*;
import org.apache.commons.lang3.StringUtils;

/**
 * Models the value of fields containing narrative content. The content is normally text wrapped in lines but they also
 * support the narrative to be structured with codewords.
 *
 * <p>When the structured option is used, different line formats are supported depending on the actual field.
 * In most of the fields the only element in the structured format is the actual text. However some fields can include
 * currency and amount (for example: 73A, 71D, 71B, 73), country codes (for example 77B) or the narrative partitioned
 * as a main narrative and a supplement (for example: 75, 76).
 *
 * <p>Supported line formats are:
 * <pre>
 * Format 1
 *      Line 1:         /8a/[additional information]               (Code)(Narrative)
 *      Lines 2-n:      /8a/[additional information]               (Code)(Narrative)
 *                      [//continuation of additional information] (Narrative)
 *
 * Format 2
 *      Line 1:         /8c/[additional information]                Code)(Narrative)
 *      Lines 2-n:      /8c/[additional information]               (Code)(Narrative)
 *                      [//continuation of additional information] (Narrative)
 *
 * Format 3
 *      Line 1:         /8c/[3!a13d][additional information]       (Code)(Currency)(Amount)(Narrative)
 *      Lines 2-6:      /8c/[3!a13d][additional information]       (Code)(Currency)(Amount)(Narrative)
 *                      [//continuation of additional information] (Narrative)
 *
 * Format 4
 *      Line 1:         /8c/[additional information]               (Code)(Narrative)
 *      Lines 2-3:      [//continuation of additional information] (Narrative)
 *      Variant for cat 1 with country
 *      Line 1:         /8c/2!a[//additional information]          (Code)(Country)(Narrative)
 *      Lines 2-3:      [//continuation of additional information] (Narrative)
 *
 * Format 5
 *      Line 1:         /2n/[supplement 1][/supplement2]           (Query Number)(Narrative 1)(Narrative 2)
 *      Lines 2-6       /2n/[supplement 1][/supplement2]
 *                      [//continuation of supplementary information]
 *
 * Format 6
 *      Line 1:         /6c/[additional information]               (Code)(Narrative)
 *      Lines 2-100:    /6c/[additional information]               (Code)(Narrative)
 *                      [continuation of additional information]   (Narrative) (cannot start with slash)
 *
 * Format 7
 *      Code between slashes at the beginning of a line
 *
 * Format 8
 *      Free format codes in slashes, not necessary on new lines
 * </pre>
 *
 * <p>This model is intended to be a generic container for any type of structured or unstructure narrative, for any
 * narrative container field. When a component (currency, amount, country or supplement) does not apply to a field,
 * it will be simply set to null by the parser.
 *
 * @since 9.0.1
 */
public class Narrative {
    private List<StructuredNarrative> structured = new ArrayList<>();
    private List<String> unstructuredFragments = new ArrayList<>();

    Narrative() {}

    private Narrative(Builder builder) {
        this.structured = builder.structured;
        this.unstructuredFragments = builder.unstructuredFragments;
    }

    /**
     * This builder allows creating the structured narrative with ease, just adding chunks of texts with optional
     * codewords and extra fields. It is intended to simplify construction of different line formats.
     *
     * <p>The implementation splits the text into fragments up to the given length, with word wrapping.
     * <p>Since the builder will do the line wrapping, the parameter text should not contain line breaks. If your text
     * is already formatted into lines use the {@link NarrativeContainer#appendLine(String)} method or the field plain
     * component setter when you have the compete formatted value.
     *
     * @param lineLength specific field max line length, used for text wrapping
     */
    public static Builder builder(int lineLength) {
        return new Builder(lineLength);
    }

    /**
     * Gets the structured part of the narrative, meaning the segments composed by a codeword and a structured text.
     * See examples below.
     *
     * <p>For field:
     * <pre>
     * :77J:THREE (3) COMMERCIAL INVOICES
     * INSTEAD OF FIVE (5) PRESENTED
     * </pre>
     * the result will be empty since all the narrative content is unstructured.
     *
     * <p>For field:
     * <pre>
     * :72:/BNF/first line of beneficiary
     * //second line of beneficiary
     * supplementary unstructured data
     * </pre>
     * the result will be a single entry for the "BNF" content including the narrative texts "first line of beneficiary"
     * and "second line of beneficiary". Notice the "supplementary unstructured data" will not be part of the returned
     * structured data since it is not the continuation for "BNF" but some additional unstructured content in the last
     * field line.
     *
     * @return the structured content or empty if no structured content is present
     */
    public List<StructuredNarrative> getStructured() {
        return structured;
    }

    /**
     * Gets the first structured narrative found for the given codeword.
     * <p>Notice codewords can be repeated for some fields, this method returns the first instance found.
     *
     * @param codeword an instruction codeword for the field such as: BNF, HOLD, NAME, PREVINST, etc..
     * @return found structured content for the codeword or null if the field does not have structured narrative or
     * the structured narrative is not set for the codeword.
     */
    public StructuredNarrative getStructured(String codeword) {
        if (this.structured != null) {
            for (StructuredNarrative structured : this.structured) {
                if (StringUtils.equals(codeword, structured.getCodeword())) {
                    return structured;
                }
            }
        }
        return null;
    }

    /**
     * Count the occurrences of a given codeword in the structured narrative
     *
     * @param codeword an instruction codeword for the field such as: OCMT, CHGS, etc..
     * @return number of structured content with the parameter codeword or zero if none is found
     */
    public int countStructured(String codeword) {
        int count = 0;
        if (this.structured != null) {
            for (StructuredNarrative structured : this.structured) {
                if (StringUtils.equals(codeword, structured.getCodeword())) {
                    count++;
                }
            }
        }
        return count;
    }

    Narrative add(StructuredNarrative structuredNarrative) {
        this.structured.add(structuredNarrative);
        return this;
    }

    /**
     * Returns the part of the field value that is not structured in codewords.
     * See examples below.
     *
     * <p>For field:
     * <pre>
     * :77J:THREE (3) COMMERCIAL INVOICES
     * INSTEAD OF FIVE (5) PRESENTED
     * </pre>
     * the result will be the complete field value since all the narrative content is unstructured.
     *
     * <p>For field:
     * <pre>
     * :72:/BNF/dbln-111- RED-1,123.456-78/10/
     * //05 redemption monies
     * supplementary unstructured data
     * </pre>
     * the result will be "supplementary unstructured data" since that line at the end is unstructured content, not
     * the continuation of the structured narrative for BNF codeword.
     *
     * <p>If the text is wrapped in lines the result list contains one element per line.
     * To get the unstructured narrative text as a simple joined string use {@link #getUnstructured(String)}
     *
     * @return the fragments of the unstructured text or an empty list if there is no unstructured text
     */
    public List<String> getUnstructuredFragments() {
        return unstructuredFragments;
    }

    /**
     * @see #getUnstructuredFragments()
     */
    Narrative addUnstructuredFragment(String narrativeFragment) {
        this.unstructuredFragments.add(narrativeFragment);
        return this;
    }

    /**
     * Gets this unstructured content as a single String, meaning if the text was wrapped in lines this method will
     * return the joined lines without separator.
     *
     * @return the narrative fragments joined as a single string or null if the narrative does not have any text
     */
    public String getUnstructured() {
        return getUnstructured(null);
    }

    /**
     * Gets this unstructured content as a single String, meaning if the text was wrapped in lines this method will
     * return the joined lines.
     *
     * @param delimiter optional delimiter, could be for example null, empty, space or line break.
     * @return the narrative fragments joined as a single string or null if the narrative does not have any text
     */
    public String getUnstructured(String delimiter) {
        if (!this.unstructuredFragments.isEmpty()) {
            String s = delimiter != null ? delimiter : "";
            return String.join(s, this.unstructuredFragments);
        }
        return null;
    }

    /**
     * @return true if non of the narrative fields are set
     */
    public boolean isEmpty() {
        return this.structured.isEmpty() && this.unstructuredFragments.isEmpty();
    }

    /**
     * Simple validation to check that either the structured or unstructured content is set
     * For the structured field the {@link StructuredNarrative#valid()} method is used.
     */
    public boolean valid() {
        return !this.unstructuredFragments.isEmpty() || validStructured();
    }

    private boolean validStructured() {
        for (StructuredNarrative structured : this.structured) {
            if (!structured.valid()) {
                return false;
            }
        }
        return true;
    }

    /**
     * If the field has structured narrative returns a set of all codewords used
     *
     * @return found codewords or empty if none is found (content is unstructured)
     */
    public Set<String> codewords() {
        Set<String> result = new HashSet<>();
        for (StructuredNarrative s : this.structured) {
            if (s.getCodeword() != null) {
                result.add(s.getCodeword());
            }
        }
        return result;
    }

    /**
     * Serializes this narrative components into the single string value (SWIFT format) adding new lines as necessary
     */
    public String getValue() {
        StringBuilder result = new StringBuilder();

        // add the structured narrative
        for (StructuredNarrative structured : this.structured) {
            if (result.length() > 0) {
                // if not the first, add a line break
                result.append(FINWriterVisitor.SWIFT_EOL);
            }
            // append mandatory codeword, even if it is empty (invalid) we will add the slashes
            result.append("/")
                    .append(StringUtils.trimToEmpty(structured.getCodeword()))
                    .append("/");

            if (structured.getCountry() != null) {
                // append the country (only used in some fields)
                result.append(structured.getCountry());
            } else if (structured.getCurrency() != null || structured.getAmount() != null) {
                // append the currency and amount (only used in some fields)
                result.append(StringUtils.trimToEmpty(structured.getCurrency()));
                if (structured.getAmount() != null) {
                    result.append(structured.getAmount());
                }
            }

            // append the narrative content
            boolean first = true;
            for (String fragment : structured.getNarrativeFragments()) {
                if (!first) {
                    // if this is not the first fragment we add a line break and the double slash to indicate this is
                    // a continuation of the preceding information
                    result.append(FINWriterVisitor.SWIFT_EOL).append("//");
                } else if (structured.getCountry() != null) {
                    // if in the first line and country was added, then the additional information must be separated
                    // with double slash, in the same line though
                    result.append("//");
                }
                result.append(fragment);
                first = false;
            }

            // append the narrative supplement (only used in some fields)
            first = true;
            for (String fragment : structured.getNarrativeSupplementFragments()) {
                if (first) {
                    // if in the first supplement we add a single slash separator
                    result.append("/");
                } else {
                    // if this is not the first supplement fragment we add a line break and the double slash to
                    // indicate this is a continuation of the preceding information
                    result.append(FINWriterVisitor.SWIFT_EOL).append("//");
                }
                result.append(fragment);
                first = false;
            }
        }

        // add the unstructured narrative at te end (one fragment per line with no separators)
        for (String fragment : this.unstructuredFragments) {
            if (result.length() > 0) {
                // if not the first, add a line break
                result.append(FINWriterVisitor.SWIFT_EOL);
            }
            result.append(fragment);
        }

        return result.toString();
    }

    public static class Builder {
        final int lineLength;
        private final List<StructuredNarrative> structured = new ArrayList<>();
        private final List<String> unstructuredFragments = new ArrayList<>();

        /**
         * @param lineLength specific field max line length, used for text wrapping
         */
        public Builder(int lineLength) {
            this.lineLength = lineLength;
        }

        /**
         * Adds structured narrative content composed by codeword and wrapped text.
         * Will be serialized as:
         * <pre>
         * Line 1:      /codeword/[narrative]
         * Lines 2-n:   [//continuation of narrative]
         * </pre>
         *
         * @param codeword  the codeword (instruction code)
         * @param narrative the narrative text (will be wrapped into lines if necessary)
         */
        public Builder addCodeword(String codeword, String narrative) {
            StructuredNarrative structured = new StructuredNarrative().setCodeword(codeword);
            String prefix = "/" + StringUtils.trim(codeword) + "/";
            for (String fragment : wrap(prefix, narrative)) {
                structured.addNarrativeFragment(fragment);
            }
            this.structured.add(structured);
            return this;
        }

        /**
         * Adds structured narrative content composed by codeword, currency, amount and optional wrapped text.
         * Will be serialized as:
         * <pre>
         * Line 1:      /codeword/[currency][amount][narrative]
         * Lines 2-n:   [//continuation of narrative]
         * </pre>
         *
         * @param codeword  the codeword (instruction code)
         * @param currency  a three letters ISO currency code
         * @param narrative the narrative text (will be wrapped into lines if necessary)
         */
        public Builder addCodewordWithAmount(String codeword, String currency, BigDecimal amount, String narrative) {
            StructuredNarrative structured = new StructuredNarrative()
                    .setCodeword(codeword)
                    .setCurrency(currency)
                    .setAmount(amount);
            String amountString = amount != null ? amount.toString() : "";
            String prefix = "/" + StringUtils.trim(codeword) + "/" + StringUtils.trim(currency) + amountString;
            for (String fragment : wrap(prefix, narrative)) {
                structured.addNarrativeFragment(fragment);
            }
            this.structured.add(structured);
            return this;
        }

        /**
         * Adds structured narrative content composed by codeword, country code and optional wrapped text.
         * Will be serialized as:
         * <pre>
         * Line 1:      /codeword/country[//narrative]
         * Lines 2-3:   [//continuation of narrative]
         * </pre>
         */
        public Builder addCodewordWithCountry(String codeword, String country, String narrative) {
            StructuredNarrative structured =
                    new StructuredNarrative().setCodeword(codeword).setCountry(country);
            String countrySlash = country != null ? country + "//" : "";
            String prefix = "/" + StringUtils.trim(codeword) + countrySlash;
            for (String fragment : wrap(prefix, narrative)) {
                structured.addNarrativeFragment(fragment);
            }
            this.structured.add(structured);
            return this;
        }

        /**
         * Adds structured narrative content composed by codeword, wrapped narrative and supplementary narrative.
         * This line formats are used for fields with query and response numbers.
         * Will be serialized as:
         * <pre>
         * Line 1:      /number/[narrative][/supplement]
         * Lines 2-6    [//continuation of supplement]
         * or
         * Line 1:      /number/[narrative][/supplement]
         * Lines 2-6    [//continuation of narrative][/supplement]
         * </pre>
         *
         * @param number     the API accepts a String however this line structure is normally used with query/answer numbers as codewords
         * @param narrative  the primary query/answer text
         * @param supplement additional query/answer text, that will be added with slash separator
         */
        public Builder addCodewordWithSupplement(String number, String narrative, String supplement) {
            StructuredNarrative structured = new StructuredNarrative();
            String codeword = number != null ? number : "";
            structured.setCodeword(codeword);
            String prefix = "/" + codeword + "/";
            String text = supplement != null ? narrative + "/" + supplement : narrative;
            boolean isSupplement = false;
            for (String fragment : wrap(prefix, text)) {
                // check if fragment has supplement
                if (!isSupplement && fragment.indexOf('/') >= 0) {
                    // contains supplement
                    String primatyText = StringUtils.substringBefore(fragment, "/");
                    String supplementText = StringUtils.substringAfter(fragment, "/");
                    structured.addNarrativeFragment(primatyText);
                    structured.addNarrativeSupplementFragment(supplementText);
                    // following fragments will be part of supplement
                    isSupplement = true;
                } else {
                    if (isSupplement) {
                        structured.addNarrativeSupplementFragment(fragment);
                    } else {
                        structured.addNarrativeFragment(fragment);
                    }
                }
            }
            this.structured.add(structured);
            return this;
        }

        /**
         * Adds unstructured narrative content wrapped into lines without any format or slash separator
         */
        public Builder addUnstructured(String narrative) {
            List<String> lines = LineWrapper.wrapIntoList(narrative, lineLength);
            this.unstructuredFragments.addAll(lines);
            return this;
        }

        /**
         * Adds unstructured narrative content strictly wrapped into lines without any format or slash separator
         */
        public Builder addUnstructuredStrict(String narrative) {
            List<String> lines = LineWrapper.wrapIntoListStrict(narrative, lineLength);
            this.unstructuredFragments.addAll(lines);
            return this;
        }

        /**
         * Wraps the text into lines considering the prefix size for the first line and considering the "//" prefix
         * that would be added to the following lines in the serialization
         */
        private List<String> wrap(String prefix, String narrative) {
            if (narrative == null) {
                return Collections.emptyList();
            }

            List<String> fragments = new ArrayList<>();

            // first line wrap should discount the prefix size
            List<String> lines = LineWrapper.wrapIntoList(narrative, lineLength - prefix.length());

            if (!lines.isEmpty()) {
                String firstLine = StringUtils.trimToNull(lines.get(0));
                if (firstLine != null) {
                    fragments.add(firstLine);
                }
            }

            if (!fragments.isEmpty()) {

                String remainder = StringUtils.trimToNull(StringUtils.substringAfter(narrative, fragments.get(0)));

                if (remainder != null) {

                    // following lines wrap should discount the "//" that would be added in the serialization
                    lines = LineWrapper.wrapIntoList(remainder, lineLength - 2);

                    fragments.addAll(lines);
                }
            }

            return fragments;
        }

        public Narrative build() {
            return new Narrative(this);
        }
    }
}
