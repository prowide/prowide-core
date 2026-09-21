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
package com.prowidesoftware.swift.utils;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

/**
 * The ISO 3166-1 catalog of officially assigned country codes.
 *
 * <p>Each constant is an alpha-2 code and carries the alpha-3 code, the three-digit numeric code and the English
 * short name of the country in the comma-inverted form of the ISO 3166-1 lists ("Bolivia, Plurinational State of").
 * The catalog is the reference for the country name lookup, while the code validation with application
 * customizations (added or removed codes) remains in {@link IsoUtils}.
 *
 * <p>The ISO 3166-1 user assigned codes (the XA to XZ range, for example XX or XK) are not part of the catalog.
 *
 * @see IsoUtils#isValidISOCountry(String)
 * @since 10.3.20
 */
public enum IsoCountry {
    AD("AND", "020", "Andorra"),
    AE("ARE", "784", "United Arab Emirates"),
    AF("AFG", "004", "Afghanistan"),
    AG("ATG", "028", "Antigua and Barbuda"),
    AI("AIA", "660", "Anguilla"),
    AL("ALB", "008", "Albania"),
    AM("ARM", "051", "Armenia"),
    AO("AGO", "024", "Angola"),
    AQ("ATA", "010", "Antarctica"),
    AR("ARG", "032", "Argentina"),
    AS("ASM", "016", "American Samoa"),
    AT("AUT", "040", "Austria"),
    AU("AUS", "036", "Australia"),
    AW("ABW", "533", "Aruba"),
    AX("ALA", "248", "Åland Islands"),
    AZ("AZE", "031", "Azerbaijan"),
    BA("BIH", "070", "Bosnia and Herzegovina"),
    BB("BRB", "052", "Barbados"),
    BD("BGD", "050", "Bangladesh"),
    BE("BEL", "056", "Belgium"),
    BF("BFA", "854", "Burkina Faso"),
    BG("BGR", "100", "Bulgaria"),
    BH("BHR", "048", "Bahrain"),
    BI("BDI", "108", "Burundi"),
    BJ("BEN", "204", "Benin"),
    BL("BLM", "652", "Saint Barthélemy"),
    BM("BMU", "060", "Bermuda"),
    BN("BRN", "096", "Brunei Darussalam"),
    BO("BOL", "068", "Bolivia, Plurinational State of"),
    BQ("BES", "535", "Bonaire, Sint Eustatius and Saba"),
    BR("BRA", "076", "Brazil"),
    BS("BHS", "044", "Bahamas"),
    BT("BTN", "064", "Bhutan"),
    BV("BVT", "074", "Bouvet Island"),
    BW("BWA", "072", "Botswana"),
    BY("BLR", "112", "Belarus"),
    BZ("BLZ", "084", "Belize"),
    CA("CAN", "124", "Canada"),
    CC("CCK", "166", "Cocos (Keeling) Islands"),
    CD("COD", "180", "Congo, Democratic Republic of the"),
    CF("CAF", "140", "Central African Republic"),
    CG("COG", "178", "Congo"),
    CH("CHE", "756", "Switzerland"),
    CI("CIV", "384", "Côte d'Ivoire"),
    CK("COK", "184", "Cook Islands"),
    CL("CHL", "152", "Chile"),
    CM("CMR", "120", "Cameroon"),
    CN("CHN", "156", "China"),
    CO("COL", "170", "Colombia"),
    CR("CRI", "188", "Costa Rica"),
    CU("CUB", "192", "Cuba"),
    CV("CPV", "132", "Cabo Verde"),
    CW("CUW", "531", "Curaçao"),
    CX("CXR", "162", "Christmas Island"),
    CY("CYP", "196", "Cyprus"),
    CZ("CZE", "203", "Czechia"),
    DE("DEU", "276", "Germany"),
    DJ("DJI", "262", "Djibouti"),
    DK("DNK", "208", "Denmark"),
    DM("DMA", "212", "Dominica"),
    DO("DOM", "214", "Dominican Republic"),
    DZ("DZA", "012", "Algeria"),
    EC("ECU", "218", "Ecuador"),
    EE("EST", "233", "Estonia"),
    EG("EGY", "818", "Egypt"),
    EH("ESH", "732", "Western Sahara"),
    ER("ERI", "232", "Eritrea"),
    ES("ESP", "724", "Spain"),
    ET("ETH", "231", "Ethiopia"),
    FI("FIN", "246", "Finland"),
    FJ("FJI", "242", "Fiji"),
    FK("FLK", "238", "Falkland Islands (Malvinas)"),
    FM("FSM", "583", "Micronesia, Federated States of"),
    FO("FRO", "234", "Faroe Islands"),
    FR("FRA", "250", "France"),
    GA("GAB", "266", "Gabon"),
    GB("GBR", "826", "United Kingdom of Great Britain and Northern Ireland"),
    GD("GRD", "308", "Grenada"),
    GE("GEO", "268", "Georgia"),
    GF("GUF", "254", "French Guiana"),
    GG("GGY", "831", "Guernsey"),
    GH("GHA", "288", "Ghana"),
    GI("GIB", "292", "Gibraltar"),
    GL("GRL", "304", "Greenland"),
    GM("GMB", "270", "Gambia"),
    GN("GIN", "324", "Guinea"),
    GP("GLP", "312", "Guadeloupe"),
    GQ("GNQ", "226", "Equatorial Guinea"),
    GR("GRC", "300", "Greece"),
    GS("SGS", "239", "South Georgia and the South Sandwich Islands"),
    GT("GTM", "320", "Guatemala"),
    GU("GUM", "316", "Guam"),
    GW("GNB", "624", "Guinea-Bissau"),
    GY("GUY", "328", "Guyana"),
    HK("HKG", "344", "Hong Kong"),
    HM("HMD", "334", "Heard Island and McDonald Islands"),
    HN("HND", "340", "Honduras"),
    HR("HRV", "191", "Croatia"),
    HT("HTI", "332", "Haiti"),
    HU("HUN", "348", "Hungary"),
    ID("IDN", "360", "Indonesia"),
    IE("IRL", "372", "Ireland"),
    IL("ISR", "376", "Israel"),
    IM("IMN", "833", "Isle of Man"),
    IN("IND", "356", "India"),
    IO("IOT", "086", "British Indian Ocean Territory"),
    IQ("IRQ", "368", "Iraq"),
    IR("IRN", "364", "Iran, Islamic Republic of"),
    IS("ISL", "352", "Iceland"),
    IT("ITA", "380", "Italy"),
    JE("JEY", "832", "Jersey"),
    JM("JAM", "388", "Jamaica"),
    JO("JOR", "400", "Jordan"),
    JP("JPN", "392", "Japan"),
    KE("KEN", "404", "Kenya"),
    KG("KGZ", "417", "Kyrgyzstan"),
    KH("KHM", "116", "Cambodia"),
    KI("KIR", "296", "Kiribati"),
    KM("COM", "174", "Comoros"),
    KN("KNA", "659", "Saint Kitts and Nevis"),
    KP("PRK", "408", "Korea, Democratic People's Republic of"),
    KR("KOR", "410", "Korea, Republic of"),
    KW("KWT", "414", "Kuwait"),
    KY("CYM", "136", "Cayman Islands"),
    KZ("KAZ", "398", "Kazakhstan"),
    LA("LAO", "418", "Lao People's Democratic Republic"),
    LB("LBN", "422", "Lebanon"),
    LC("LCA", "662", "Saint Lucia"),
    LI("LIE", "438", "Liechtenstein"),
    LK("LKA", "144", "Sri Lanka"),
    LR("LBR", "430", "Liberia"),
    LS("LSO", "426", "Lesotho"),
    LT("LTU", "440", "Lithuania"),
    LU("LUX", "442", "Luxembourg"),
    LV("LVA", "428", "Latvia"),
    LY("LBY", "434", "Libya"),
    MA("MAR", "504", "Morocco"),
    MC("MCO", "492", "Monaco"),
    MD("MDA", "498", "Moldova, Republic of"),
    ME("MNE", "499", "Montenegro"),
    MF("MAF", "663", "Saint Martin (French part)"),
    MG("MDG", "450", "Madagascar"),
    MH("MHL", "584", "Marshall Islands"),
    MK("MKD", "807", "North Macedonia"),
    ML("MLI", "466", "Mali"),
    MM("MMR", "104", "Myanmar"),
    MN("MNG", "496", "Mongolia"),
    MO("MAC", "446", "Macao"),
    MP("MNP", "580", "Northern Mariana Islands"),
    MQ("MTQ", "474", "Martinique"),
    MR("MRT", "478", "Mauritania"),
    MS("MSR", "500", "Montserrat"),
    MT("MLT", "470", "Malta"),
    MU("MUS", "480", "Mauritius"),
    MV("MDV", "462", "Maldives"),
    MW("MWI", "454", "Malawi"),
    MX("MEX", "484", "Mexico"),
    MY("MYS", "458", "Malaysia"),
    MZ("MOZ", "508", "Mozambique"),
    NA("NAM", "516", "Namibia"),
    NC("NCL", "540", "New Caledonia"),
    NE("NER", "562", "Niger"),
    NF("NFK", "574", "Norfolk Island"),
    NG("NGA", "566", "Nigeria"),
    NI("NIC", "558", "Nicaragua"),
    NL("NLD", "528", "Netherlands, Kingdom of the"),
    NO("NOR", "578", "Norway"),
    NP("NPL", "524", "Nepal"),
    NR("NRU", "520", "Nauru"),
    NU("NIU", "570", "Niue"),
    NZ("NZL", "554", "New Zealand"),
    OM("OMN", "512", "Oman"),
    PA("PAN", "591", "Panama"),
    PE("PER", "604", "Peru"),
    PF("PYF", "258", "French Polynesia"),
    PG("PNG", "598", "Papua New Guinea"),
    PH("PHL", "608", "Philippines"),
    PK("PAK", "586", "Pakistan"),
    PL("POL", "616", "Poland"),
    PM("SPM", "666", "Saint Pierre and Miquelon"),
    PN("PCN", "612", "Pitcairn"),
    PR("PRI", "630", "Puerto Rico"),
    PS("PSE", "275", "Palestine, State of"),
    PT("PRT", "620", "Portugal"),
    PW("PLW", "585", "Palau"),
    PY("PRY", "600", "Paraguay"),
    QA("QAT", "634", "Qatar"),
    RE("REU", "638", "Réunion"),
    RO("ROU", "642", "Romania"),
    RS("SRB", "688", "Serbia"),
    RU("RUS", "643", "Russian Federation"),
    RW("RWA", "646", "Rwanda"),
    SA("SAU", "682", "Saudi Arabia"),
    SB("SLB", "090", "Solomon Islands"),
    SC("SYC", "690", "Seychelles"),
    SD("SDN", "729", "Sudan"),
    SE("SWE", "752", "Sweden"),
    SG("SGP", "702", "Singapore"),
    SH("SHN", "654", "Saint Helena, Ascension and Tristan da Cunha"),
    SI("SVN", "705", "Slovenia"),
    SJ("SJM", "744", "Svalbard and Jan Mayen"),
    SK("SVK", "703", "Slovakia"),
    SL("SLE", "694", "Sierra Leone"),
    SM("SMR", "674", "San Marino"),
    SN("SEN", "686", "Senegal"),
    SO("SOM", "706", "Somalia"),
    SR("SUR", "740", "Suriname"),
    SS("SSD", "728", "South Sudan"),
    ST("STP", "678", "Sao Tome and Principe"),
    SV("SLV", "222", "El Salvador"),
    SX("SXM", "534", "Sint Maarten (Dutch part)"),
    SY("SYR", "760", "Syrian Arab Republic"),
    SZ("SWZ", "748", "Eswatini"),
    TC("TCA", "796", "Turks and Caicos Islands"),
    TD("TCD", "148", "Chad"),
    TF("ATF", "260", "French Southern Territories"),
    TG("TGO", "768", "Togo"),
    TH("THA", "764", "Thailand"),
    TJ("TJK", "762", "Tajikistan"),
    TK("TKL", "772", "Tokelau"),
    TL("TLS", "626", "Timor-Leste"),
    TM("TKM", "795", "Turkmenistan"),
    TN("TUN", "788", "Tunisia"),
    TO("TON", "776", "Tonga"),
    TR("TUR", "792", "Türkiye"),
    TT("TTO", "780", "Trinidad and Tobago"),
    TV("TUV", "798", "Tuvalu"),
    TW("TWN", "158", "Taiwan, Province of China"),
    TZ("TZA", "834", "Tanzania, United Republic of"),
    UA("UKR", "804", "Ukraine"),
    UG("UGA", "800", "Uganda"),
    UM("UMI", "581", "United States Minor Outlying Islands"),
    US("USA", "840", "United States of America"),
    UY("URY", "858", "Uruguay"),
    UZ("UZB", "860", "Uzbekistan"),
    VA("VAT", "336", "Holy See"),
    VC("VCT", "670", "Saint Vincent and the Grenadines"),
    VE("VEN", "862", "Venezuela, Bolivarian Republic of"),
    VG("VGB", "092", "Virgin Islands (British)"),
    VI("VIR", "850", "Virgin Islands (U.S.)"),
    VN("VNM", "704", "Viet Nam"),
    VU("VUT", "548", "Vanuatu"),
    WF("WLF", "876", "Wallis and Futuna"),
    WS("WSM", "882", "Samoa"),
    YE("YEM", "887", "Yemen"),
    YT("MYT", "175", "Mayotte"),
    ZA("ZAF", "710", "South Africa"),
    ZM("ZMB", "894", "Zambia"),
    ZW("ZWE", "716", "Zimbabwe");

    private static final Map<String, IsoCountry> BY_CODE = new HashMap<>();

    static {
        for (IsoCountry c : values()) {
            BY_CODE.put(c.getAlpha2(), c);
            BY_CODE.put(c.alpha3, c);
            BY_CODE.put(c.numeric, c);
        }
    }

    private final String alpha3;
    private final String numeric;
    private final String shortName;

    IsoCountry(String alpha3, String numeric, String shortName) {
        this.alpha3 = alpha3;
        this.numeric = numeric;
        this.shortName = shortName;
    }

    /**
     * Finds a country by any of its ISO 3166-1 codes.
     *
     * <p>The parameter can be the alpha-2 code (US), the alpha-3 code (USA) or the numeric code (840). The lookup is
     * case-insensitive, ignores surrounding whitespace and accepts a numeric code with fewer or more leading zeros
     * than the three digits of the ISO code (28 or 0028 for Antigua and Barbuda, whose ISO numeric code is 028). The
     * normalization is independent of the default locale.
     *
     * @param code an alpha-2, alpha-3 or numeric ISO 3166-1 code
     * @return the country, or empty if the parameter is null, blank or not an officially assigned code
     */
    public static Optional<IsoCountry> find(String code) {
        if (code == null) {
            return Optional.empty();
        }
        String key = code.trim().toUpperCase(Locale.ROOT);
        if (isAsciiDigits(key)) {
            String digits = stripLeadingZeros(key);
            if (digits.length() > 3) {
                return Optional.empty();
            }
            key = "000".substring(digits.length()) + digits;
        }
        return Optional.ofNullable(BY_CODE.get(key));
    }

    private static boolean isAsciiDigits(String s) {
        if (s.isEmpty()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }

    private static String stripLeadingZeros(String digits) {
        int i = 0;
        while (i < digits.length() && digits.charAt(i) == '0') {
            i++;
        }
        return digits.substring(i);
    }

    /**
     * Gets the alpha-2 code, which is also the constant name.
     *
     * @return the two letters ISO 3166-1 alpha-2 code, for example US
     */
    public String getAlpha2() {
        return name();
    }

    /**
     * Gets the alpha-3 code.
     *
     * @return the three letters ISO 3166-1 alpha-3 code, for example USA
     */
    public String getAlpha3() {
        return alpha3;
    }

    /**
     * Gets the numeric code, always three digits.
     *
     * @return the three digits ISO 3166-1 numeric code, for example 840
     */
    public String getNumeric() {
        return numeric;
    }

    /**
     * Gets the English short name of the country, in the comma-inverted form of the ISO 3166-1 lists (for example
     * "Bolivia, Plurinational State of"). Notice this differs from {@link #name()}, which is the alpha-2 code.
     *
     * @return the English short name, for example United States of America
     */
    public String getShortName() {
        return shortName;
    }
}
