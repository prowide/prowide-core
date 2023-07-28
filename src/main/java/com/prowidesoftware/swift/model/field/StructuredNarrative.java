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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * Simple POJO for portions of structured text in narrative containers.
 *
 * <p>The structured narrative consist of a codeword or instruction plus additional content. This additional content
 * is normally the actual narrative text but for some fields can include a currency and amount or a country code.
 *
 * <p>This model is intended to be a generic container for any type of structured narrative, for any narrative container
 * field. When a component (currency, amount, country or supplement) does not apply to a field, it will be simply set to
 * null by the parser.
 *
 * <p>To create this structure see {@link Narrative#builder(int)}
 *
 * @since 9.0.1
 */
public class StructuredNarrative {
    private final List<String> narrativeFragments = new ArrayList<>();
    private final List<String> narrativeSupplementFragments = new ArrayList<>();
    private String codeword;
    private String currency;
    private BigDecimal amount;
    private String country;

    private String bankCode;

    /**
     * The codeword is a mandatory keyword to identify this particular narrative content in a narrative field value.
     * For most fields it consists of uppercase letters only but for some fields it can be alphanumeric or numbers only.
     * The allowed codewords per field are defined in the standard or agreed between parties.
     */
    public String getCodeword() {
        return codeword;
    }

    /**
     * @see #getCodeword()
     */
    StructuredNarrative setCodeword(String codeword) {
        this.codeword = codeword;
        return this;
    }

    /**
     * In fields 73A, 71D, 71B and 73 the currency can be present as the first part of the narrative content along
     * an amount.
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @see #getCurrency()
     */
    StructuredNarrative setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * In SCORE messages, in field 71B, there is a bank code within the codeword with a slash separator (i.e. C/USD).
     * This will get the bank code (i.e. C for the C/USD case). Or null if this is not possible.
     * @see #getCurrency()
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * See {@link #getBankCode()}.
     */
    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    /**
     * In fields such as 73A, 71D, 71B and 73 the amount (along the currency) can be present as the first part of the
     * narrative content.
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * @see #getAmount()
     */
    StructuredNarrative setAmount(BigDecimal amount) {
        this.amount = amount;
        return this;
    }

    /**
     * In fields such as 77B a two letters country code can be present as the first part of the narrative content.
     */
    public String getCountry() {
        return country;
    }

    /**
     * @see #getCountry()
     */
    StructuredNarrative setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * Returns the list of text fragments in the narrative, fragments are segments of the text that is wrapped in lines.
     * If the narrative is a single string in a single line, the list will contain a single element.
     * To get the narrative as a simple joined string use {@link #getNarrative(String)}
     *
     * @return the narrative fragments or an empty list if the narrative does not have any text
     */
    public List<String> getNarrativeFragments() {
        return narrativeFragments;
    }

    /**
     * @see #getNarrativeFragments()
     */
    StructuredNarrative addNarrativeFragment(String narrativeFragment) {
        this.narrativeFragments.add(narrativeFragment);
        return this;
    }

    /**
     * In fields such as 75 or 76 the narrative can be split into a first text along an optional second supplement.
     * This method returns the list of text fragments in the supplement, fragments are segments of the text that is
     * wrapped in lines. If the supplement is a single string in a single line, the list will contain a single element.
     * To get the supplement as a simple joined string use {@link #getNarrativeSupplement(String)}
     *
     * @return the narrative supplement fragments or an empty list if the narrative does not have any supplement text
     */
    public List<String> getNarrativeSupplementFragments() {
        return narrativeSupplementFragments;
    }

    /**
     * @see #getNarrativeSupplementFragments()
     */
    StructuredNarrative addNarrativeSupplementFragment(String narrativeSupplementFragment) {
        this.narrativeSupplementFragments.add(narrativeSupplementFragment);
        return this;
    }

    /**
     * Gets this narrative content as a single String, meaning if the narrative was wrapped in lines this method will
     * return the joined lines without separator.
     *
     * @return the narrative fragments joined as a single string or null if the narrative does not have any text
     */
    public String getNarrative() {
        return getNarrative(null);
    }

    /**
     * Gets this narrative content as a single String, meaning if the narrative was wrapped in lines this method will
     * return the joined lines.
     *
     * @param delimiter optional delimiter, could be for example null, empty, space or line break.
     * @return the narrative fragments joined as a single string or null if the narrative does not have any text
     */
    public String getNarrative(String delimiter) {
        if (!this.narrativeFragments.isEmpty()) {
            String s = delimiter != null ? delimiter : "";
            return String.join(s, this.narrativeFragments);
        }
        return null;
    }

    /**
     * Gets this narrative supplement content as a single String, meaning if the text was wrapped in lines this
     * method will return the joined lines without separator.
     *
     * @return the narrative supplement fragments joined as a single string or null if the narrative does not have any
     * supplement text
     */
    public String getNarrativeSupplement() {
        return getNarrativeSupplement(null);
    }

    /**
     * Gets this narrative supplement content as a single String, meaning if the text was wrapped in lines this
     * method will return the joined lines.
     *
     * @param delimiter optional delimiter, could be for example null, empty, space or line break.
     * @return the narrative supplement fragments joined as a single string or null if the narrative does not have any
     * supplement text
     */
    public String getNarrativeSupplement(String delimiter) {
        if (!this.narrativeSupplementFragments.isEmpty()) {
            String s = delimiter != null ? delimiter : "";
            return String.join(s, this.narrativeSupplementFragments);
        }
        return null;
    }

    /**
     * @return true if non of the narrative fields are set
     */
    public boolean isEmpty() {
        return this.codeword == null
                && this.currency == null
                && this.amount == null
                && this.country == null
                && this.narrativeFragments.isEmpty()
                && this.narrativeSupplementFragments.isEmpty();
    }

    /**
     * Basic validation to check the codeword is present and at least one of the other fields is present
     */
    public boolean valid() {
        return StringUtils.isNotBlank(this.codeword)
                && (this.currency != null && this.amount != null
                        || this.country != null
                        || !this.narrativeFragments.isEmpty());
    }
}
