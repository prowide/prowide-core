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

import com.prowidesoftware.swift.utils.IsoUtils;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.ImmutableTriple;
import org.apache.commons.lang3.tuple.Triple;

/**
 * Implementation for {@link StructuredNarrativeField}
 *
 * @since 9.0.1
 */
public class NarrativeResolver {
    private static final java.util.logging.Logger log =
            java.util.logging.Logger.getLogger(NarrativeResolver.class.getName());

    private static final int CODEWORDTYPE_UCASE = 1;
    private static final int CODEWORDTYPE_UCASE_NUMBER = 2;
    private static final int CODEWORDTYPE_NUMBER = 3;

    /**
     * Parses the narrative text with a specific format depending on the field
     */
    public static Narrative parse(Field f) {
        // each field support one or two line formats
        switch (f.getName()) {
            case Field77A.NAME:
            case Field74.NAME:
            case Field86.NAME:
                return parseFormat1(f);
            case Field72Z.NAME:
            case Field72.NAME:
            case Field77.NAME:
            case Field77J.NAME:
                return parseFormat2(f);
            case Field73A.NAME:
            case Field71D.NAME:
            case Field73.NAME:
            case Field71B.NAME:
            case "71E": // SCORE field
                return parseFormat3(f);
            case Field77B.NAME:
                return parseFormat4(f);
            case Field75.NAME:
            case Field76.NAME:
                return parseFormat5(f);
            case Field49N.NAME:
            case Field45B.NAME:
            case Field46B.NAME:
            case Field47B.NAME:
            case Field49M.NAME:
                return parseFormat6(f);
            case Field70.NAME:
            case Field77D.NAME:
            case Field37N.NAME:
                return parseFormat7(f);
            case Field29A.NAME:
            case Field79.NAME:
                return parseFormat8(f.getValue());
            case Field61.NAME:
                Field61 field61 = (Field61) f;
                return parseFormat8(field61.getSupplementaryDetails());
        }
        log.warning("Don't know how to parse structured narrative line formats for " + f.getName());
        return new Narrative();
    }

    private static Narrative parseFormat(
            Field f,
            int codewordMaxSize,
            int codewordType,
            boolean supportsCountry,
            boolean supportsCurrency,
            boolean supportsSupplement,
            boolean additionalNarrativesStartWithDoubleSlash) {

        // create an empty narrative, get the value and check there's something to do
        Narrative narrative = new Narrative();
        String value = f.getValue();
        if (value == null) {
            return narrative;
        }

        // start processing
        boolean unstructuredSection = !value.startsWith("/") || value.startsWith("//");
        StructuredNarrative structured = new StructuredNarrative();
        boolean firstSupplementAdded = false;
        List<String> valueLines = notEmptyLines(value);
        int lineIndex = 0;
        for (String valueLine : valueLines) {
            lineIndex++;
            final int lineLength = valueLine.length();

            if (unstructuredSection) {
                narrative.addUnstructuredFragment(valueLine);
                continue;
            }
            unstructuredSection = true;

            if (valueLine.charAt(0) == '/') {
                String text;
                if (valueLine.length() > 1 && valueLine.charAt(1) == '/') {
                    // line starts with '//'
                    unstructuredSection = false;
                    if (additionalNarrativesStartWithDoubleSlash) {
                        // continuation of current narrative, remove '//'
                        valueLine = valueLine.substring(2);

                        if (supportsSupplement) {
                            firstSupplementAdded = addNarrativeSupplement(firstSupplementAdded, valueLine, structured);
                        } else if (StringUtils.isNotEmpty(valueLine)) {
                            structured.addNarrativeFragment(valueLine, lineIndex, lineLength);
                        }
                    } else structured.addNarrativeFragment(valueLine, lineIndex, lineLength);
                } else {
                    // new codeword
                    String codeword = StringUtils.substringBetween(valueLine, "/", "/");
                    if (isCodewordValid(codeword, codewordType, codewordMaxSize)) {
                        firstSupplementAdded = false;
                        unstructuredSection = false;
                        structured = new StructuredNarrative().setCodeword(codeword);

                        text = StringUtils.substringAfter(valueLine, codeword + "/");

                        if (supportsCountry) {
                            String country = getCountry(StringUtils.substringBefore(text, "//"));
                            if (country != null) {
                                structured.setCountry(country);
                                text = StringUtils.substringAfter(text, "//");
                            }
                        }

                        String textWithoutBankCode = text;
                        if (text.length() > 1 && Character.isUpperCase(text.charAt(0)) && (text.charAt(1) == '/')) {
                            textWithoutBankCode = text.substring(2);
                            structured.setBankCode(text.substring(0, 1));
                        }

                        if (supportsCurrency && isCurrencyAndAmount(textWithoutBankCode)) {
                            Triple<String, BigDecimal, String> tripleValue =
                                    getCurrencyAmountAndNarrative(textWithoutBankCode);
                            String currency = tripleValue.getLeft();
                            BigDecimal amount = tripleValue.getMiddle();
                            String narrativeFragment = tripleValue.getRight();

                            if (currency != null) {
                                structured.setCurrency(currency);
                                if (amount != null) {
                                    structured.setAmount(amount);
                                }
                            }
                            textWithoutBankCode = narrativeFragment;
                        }

                        if (supportsSupplement) {
                            firstSupplementAdded = addNarrativeSupplement(firstSupplementAdded, text, structured);
                        } else if (textWithoutBankCode != null) {
                            if (supportsCountry) {
                                if (!textWithoutBankCode.isEmpty()) {
                                    structured.addNarrativeFragment(
                                            textWithoutBankCode,
                                            lineIndex,
                                            lineLength); // structured.addNarrativeFragment(null);
                                }
                            } else {
                                structured.addNarrativeFragment(textWithoutBankCode, lineIndex, lineLength);
                            }
                        }

                        narrative.add(structured);
                    } else if (!additionalNarrativesStartWithDoubleSlash && !structured.isEmpty()) {
                        structured.addNarrativeFragment(valueLine, lineIndex, lineLength);
                        unstructuredSection = false;
                    }
                }
            } else if (!additionalNarrativesStartWithDoubleSlash && !structured.isEmpty()) {
                structured.addNarrativeFragment(valueLine, lineIndex, lineLength);
                unstructuredSection = false;
            }
            if (unstructuredSection) narrative.addUnstructuredFragment(valueLine);
        }

        return narrative;
    }

    static boolean isCurrencyAndAmount(String textWithoutBankCode) {

        if (textWithoutBankCode.length() < 4) return false;

        for (int i = 0; i < 3; i++) {
            if (!Character.isUpperCase(textWithoutBankCode.charAt(i))) {
                return false;
            }
        }

        return Character.isDigit(textWithoutBankCode.charAt(3));
    }

    private static List<String> notEmptyLines(String value) {
        return SwiftParseUtils.getLines(value).stream()
                .filter(StringUtils::isNotEmpty)
                .collect(Collectors.toList());
    }

    // returns true if it's the first supplement added
    private static boolean addNarrativeSupplement(
            boolean firstSupplementAdded, String line, StructuredNarrative structured) {
        if (!firstSupplementAdded) {
            // narrative
            String text = StringUtils.substringBefore(line, "/");
            if (StringUtils.isNotEmpty(text)) {
                structured.addNarrativeFragment(text);
            }

            // first supplement
            text = StringUtils.substringAfter(line, "/");
            if (StringUtils.isNotEmpty(text)) {
                structured.addNarrativeSupplementFragment(text);
                return true;
            }
        } else {
            // additional supplement
            if (StringUtils.isNotEmpty(line)) {
                structured.addNarrativeSupplementFragment(line);
            }
        }
        return firstSupplementAdded;
    }

    /**
     * Free format codes in slashes, not necessary on new lines
     */
    public static Narrative parseFreeFormat(String value) {
        Narrative narrative = new Narrative();

        if (value == null) {
            return narrative;
        }

        boolean structured = value.startsWith("/")
                && isCodewordValid(StringUtils.substringBefore(value.substring(1), "/"), CODEWORDTYPE_UCASE, -1);

        List<String> lines = notEmptyLines(value);
        if (structured) {
            // parse structured items detecting codewords
            String[] tokens = String.join("", lines).split("/");
            String currentCodeword = null;
            StringBuilder currentText = new StringBuilder();
            for (String token : tokens) {
                if (isCodewordValid(token, CODEWORDTYPE_UCASE, -1)) {
                    if (currentCodeword != null) {
                        // store current structured item
                        add(narrative, currentCodeword, currentText.toString());
                    }
                    currentCodeword = token;
                    currentText = new StringBuilder();

                } else {
                    if (currentText.length() > 0) {
                        // add the separator back if it was present between the narrative text
                        currentText.append("/");
                    }
                    currentText.append(token);
                }
            }
            if (currentCodeword != null) {
                // add the last created item if necessary
                add(narrative, currentCodeword, currentText.toString());
            }

        } else {
            // set lines as unstructured content
            for (String line : lines) {
                narrative.addUnstructuredFragment(line);
            }
        }

        return narrative;
    }

    /**
     * Adds a structured narrative item to the narrative
     *
     * @param narrative the narrative where item is added
     * @param codeword  a codeword
     * @param text      the narrative text or blank to skip
     */
    private static void add(Narrative narrative, String codeword, String text) {
        StructuredNarrative item = new StructuredNarrative().setCodeword(codeword);
        if (StringUtils.isNoneBlank(text)) {
            item.addNarrativeFragment(text);
        }
        narrative.add(item);
    }

    private static boolean isCodewordValid(String codeword, int codewordType, int codewordMaxSize) {
        if (StringUtils.isBlank(codeword)) return false;
        codeword = StringUtils.trimToEmpty(codeword);

        // Maxlength
        if (codewordMaxSize > 0 && codeword.length() > codewordMaxSize) return false;

        // Type
        for (int i = 0; i < codeword.length(); i++) {
            char c = codeword.charAt(i);
            if (!Character.isLetterOrDigit(c)) return false;
            else if (Character.isLowerCase(c)
                    && (codewordType == CODEWORDTYPE_UCASE || codewordType == CODEWORDTYPE_UCASE_NUMBER)) return false;
            else if (Character.isLetter(c) && codewordType == CODEWORDTYPE_NUMBER) return false;
            else if (Character.isDigit(c) && codewordType == CODEWORDTYPE_UCASE) return false;
        }

        return true;
    }

    private static String getCountry(String text) {
        text = StringUtils.trimToEmpty(text);
        if (!IsoUtils.getInstance().isValidISOCountry(text)) return null;
        return text;
    }

    private static Triple<String, BigDecimal, String> getCurrencyAmountAndNarrative(String text) {
        StringBuilder currency = new StringBuilder();
        StringBuilder amount = new StringBuilder();
        StringBuilder narrative = new StringBuilder();

        int section = 1;
        text = StringUtils.trimToEmpty(text);
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            switch (section) {
                case 1: // currency section
                    if (Character.isDigit(c)) {
                        section = 2;
                        amount.append(c);
                    } else currency.append(c);
                    break;
                case 2: // amount section
                    if (Character.isDigit(c) || c == '.' || c == ',') amount.append(c == ',' ? '.' : c);
                    else {
                        section = 3;
                        narrative.append(c);
                    }
                    break;
                case 3: // narrative section
                    narrative.append(c);
                    break;
            }
        }

        return new ImmutableTriple<>(
                currency.length() == 0 ? null : currency.toString(),
                amount.length() == 0 ? null : new BigDecimal(amount.toString()),
                narrative.length() == 0 ? null : narrative.toString());
    }

    /**
     * Line 1:       /8a/[additional information]   (Code)(Narrative)
     * Lines 2-n:    /8a/[additional information]   (Code)(Narrative)
     * [//continuation of additional information]   (Narrative)
     */
    public static Narrative parseFormat1(Field f) {
        return parseFormat(f, 8, CODEWORDTYPE_UCASE, false, false, false, true);
    }

    /**
     * Line 1:       /8c/[additional information]   (Code)(Narrative)
     * Lines 2-n:    /8c/[additional information]   (Code)(Narrative)
     * [//continuation of additional information]   (Narrative)
     */
    public static Narrative parseFormat2(Field f) {
        return parseFormat(f, 8, CODEWORDTYPE_UCASE_NUMBER, false, false, false, true);
    }

    /**
     * Line 1:       /8c/[3!a13d][additional information]  (Code)(Currency)(Amount)(Narrative)
     * Lines 2-6:   /8c/[3!a13d][additional information]   (Code)(Currency)(Amount)(Narrative)
     * [//continuation of additional information]          (Narrative)
     */
    public static Narrative parseFormat3(Field f) {
        return parseFormat(f, 8, CODEWORDTYPE_UCASE_NUMBER, false, true, false, true);
    }

    /**
     * Line 1:       /8c/[additional information]              (Code)(Narrative)
     * Lines 2-3:   [//continuation of additional information] (Narrative)
     * Variant for cat 1 with country
     * Line 1:       /8c/2!a[//additional information]         (Code)(Country)(Narrative)
     * Lines 2-3:   [//continuation of additional information] (Narrative)
     */
    public static Narrative parseFormat4(Field f) {
        return parseFormat(f, 8, CODEWORDTYPE_UCASE_NUMBER, true, false, false, true);
    }

    /**
     * Line 1:    /2n/[supplement 1][/supplement2]             (Query Number)(Narrative 1)(Narrative 2)
     * Lines 2-6  /2n/[supplement 1][/supplement2]
     * [//continuation of supplementary information]
     */
    public static Narrative parseFormat5(Field f) {
        return parseFormat(f, 2, CODEWORDTYPE_NUMBER, false, false, true, true);
    }

    /**
     * Line 1:   /6c/[additional information]         (Code)(Narrative)
     * Lines 2-100:  /6c/[additional information]     (Code)(Narrative)
     * [continuation of additional information]       (Narrative) (cannot start with slash)
     */
    public static Narrative parseFormat6(Field f) {
        return parseFormat(f, 6, CODEWORDTYPE_UCASE_NUMBER, false, false, false, false);
    }

    /**
     * Code between slashes at the beginning of a line
     */
    public static Narrative parseFormat7(Field f) {
        return parseFormat(f, -1, CODEWORDTYPE_UCASE, false, false, false, true);
    }

    /**
     * @see #parseFreeFormat(String)
     */
    public static Narrative parseFormat8(String value) {
        return parseFreeFormat(value);
    }
}
