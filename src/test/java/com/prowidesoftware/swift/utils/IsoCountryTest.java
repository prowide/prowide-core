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

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * Test cases for the ISO 3166-1 catalog in {@link IsoCountry}
 */
public class IsoCountryTest {

    @Test
    public void findByAlpha2() {
        IsoCountry us = IsoCountry.find("US").orElseThrow(AssertionError::new);
        assertEquals("US", us.getAlpha2());
        assertEquals("USA", us.getAlpha3());
        assertEquals("840", us.getNumeric());
        assertEquals("United States of America", us.getShortName());
    }

    @Test
    public void findByAlpha3() {
        assertEquals(Optional.of(IsoCountry.ES), IsoCountry.find("ESP"));
        assertEquals(Optional.of(IsoCountry.AG), IsoCountry.find("ATG"));
    }

    @Test
    public void findByNumeric() {
        assertEquals(Optional.of(IsoCountry.AG), IsoCountry.find("028"));
        assertEquals(Optional.of(IsoCountry.SB), IsoCountry.find("090"));
        assertEquals(Optional.of(IsoCountry.UY), IsoCountry.find("858"));
    }

    /** The ISO numeric code is three digits, but a value that lost its leading zeros still identifies the country */
    @Test
    public void findByNumericWithoutLeadingZeros() {
        assertEquals(Optional.of(IsoCountry.AG), IsoCountry.find("28"));
        assertEquals(Optional.of(IsoCountry.AF), IsoCountry.find("4"));
        assertEquals(Optional.of(IsoCountry.AL), IsoCountry.find("8"));
    }

    /** A fixed-width numeric field can carry more zeros than the three digits of the ISO code */
    @Test
    public void findByNumericWithExtraLeadingZeros() {
        assertEquals(Optional.of(IsoCountry.AG), IsoCountry.find("0028"));
        assertEquals(Optional.of(IsoCountry.US), IsoCountry.find("000840"));
        assertEquals(Optional.empty(), IsoCountry.find("0000"));
        assertEquals(Optional.empty(), IsoCountry.find("1234"));
        assertEquals(Optional.empty(), IsoCountry.find("01234"));
    }

    /** The numeric lookup must not depend on the digits of the default locale */
    @Test
    public void findByNumericIsIndependentOfTheDefaultLocale() {
        Locale previous = Locale.getDefault();
        Locale.setDefault(new Locale.Builder().setLanguage("ar").setRegion("EG").build());
        try {
            assertEquals(Optional.of(IsoCountry.AG), IsoCountry.find("28"));
            assertEquals(Optional.of(IsoCountry.AF), IsoCountry.find("004"));
        } finally {
            Locale.setDefault(previous);
        }
    }

    /** Numeric codes that are easy to transpose, pinned individually */
    @Test
    public void numericCodesOfNeighbouringCountries() {
        assertEquals("729", IsoCountry.SD.getNumeric());
        assertEquals("728", IsoCountry.SS.getNumeric());
        assertEquals("531", IsoCountry.CW.getNumeric());
        assertEquals("534", IsoCountry.SX.getNumeric());
        assertEquals("535", IsoCountry.BQ.getNumeric());
        assertEquals("831", IsoCountry.GG.getNumeric());
        assertEquals("832", IsoCountry.JE.getNumeric());
        assertEquals("833", IsoCountry.IM.getNumeric());
        assertEquals("248", IsoCountry.AX.getNumeric());
        assertEquals("652", IsoCountry.BL.getNumeric());
        assertEquals(
                IsoCountry.values().length,
                Arrays.stream(IsoCountry.values())
                        .map(IsoCountry::getNumeric)
                        .distinct()
                        .count());
        assertEquals(
                IsoCountry.values().length,
                Arrays.stream(IsoCountry.values())
                        .map(IsoCountry::getAlpha3)
                        .distinct()
                        .count());
    }

    @Test
    public void findIsLenientWithCaseAndSurroundingSpace() {
        assertEquals(Optional.of(IsoCountry.UY), IsoCountry.find("uy"));
        assertEquals(Optional.of(IsoCountry.SD), IsoCountry.find("Sdn"));
        assertEquals(Optional.of(IsoCountry.ES), IsoCountry.find(" ES "));
    }

    @Test
    public void findUnknownIsEmpty() {
        assertEquals(Optional.empty(), IsoCountry.find(null));
        assertEquals(Optional.empty(), IsoCountry.find(""));
        assertEquals(Optional.empty(), IsoCountry.find("   "));
        assertEquals(Optional.empty(), IsoCountry.find("UK"));
        assertEquals(Optional.empty(), IsoCountry.find("foo"));
        assertEquals(Optional.empty(), IsoCountry.find("999"));
        assertEquals(Optional.empty(), IsoCountry.find("99999999999999999999999"));
        assertEquals(Optional.empty(), IsoCountry.find("USAX"));
    }

    /** The ISO 3166-1 user assigned range is not part of the catalog */
    @Test
    public void userAssignedCodesAreNotInTheCatalog() {
        for (String code : new String[] {"XA", "XK", "XX", "XZ", "QM", "QZ", "AA", "ZZ"}) {
            assertEquals(Optional.empty(), IsoCountry.find(code), code);
        }
    }

    /** The catalog carries exactly the officially assigned codes known to the JDK */
    @Test
    public void catalogMatchesTheJdkCountries() {
        Set<String> jdk = new HashSet<>(Arrays.asList(Locale.getISOCountries()));
        Set<String> catalog =
                Arrays.stream(IsoCountry.values()).map(IsoCountry::getAlpha2).collect(Collectors.toSet());
        assertEquals(jdk, catalog);
    }

    @Test
    public void alpha3AndNumericAreConsistent() {
        for (IsoCountry c : IsoCountry.values()) {
            assertEquals(c.name(), c.getAlpha2(), c.name());
            assertEquals(
                    new Locale.Builder().setRegion(c.getAlpha2()).build().getISO3Country(), c.getAlpha3(), c.name());
            assertTrue(c.getNumeric().matches("[0-9]{3}"), c.name() + " numeric " + c.getNumeric());
            assertEquals(Optional.of(c), IsoCountry.find(c.getAlpha3()), c.name());
            assertEquals(Optional.of(c), IsoCountry.find(c.getNumeric()), c.name());
        }
    }

    @Test
    public void namesAreTheIsoShortNames() {
        assertEquals("Afghanistan", IsoCountry.AF.getShortName());
        assertEquals("China", IsoCountry.CN.getShortName());
        assertEquals("Taiwan, Province of China", IsoCountry.TW.getShortName());
        assertEquals("Bonaire, Sint Eustatius and Saba", IsoCountry.BQ.getShortName());
        assertEquals("Svalbard and Jan Mayen", IsoCountry.SJ.getShortName());
        assertEquals("United States Minor Outlying Islands", IsoCountry.UM.getShortName());
        assertEquals("Bolivia, Plurinational State of", IsoCountry.BO.getShortName());
        assertEquals("Korea, Republic of", IsoCountry.KR.getShortName());
        assertEquals("Türkiye", IsoCountry.TR.getShortName());
        assertEquals("Côte d'Ivoire", IsoCountry.CI.getShortName());
        for (IsoCountry c : IsoCountry.values()) {
            assertFalse(c.getShortName().contains("["), c.name() + " carries a footnote: " + c.getShortName());
            assertFalse(c.getShortName().isEmpty(), c.name());
        }
    }
}
