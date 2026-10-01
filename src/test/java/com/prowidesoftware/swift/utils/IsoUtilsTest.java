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

import java.util.Locale;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * test cases for {@link IsoUtils}
 */
public class IsoUtilsTest {

    @Test
    public void testCurrencies() {
        /*
         * valid
         */
        assertTrue(IsoUtils.getInstance().isValidISOCurrency("EUR"));
        assertTrue(IsoUtils.getInstance().isValidISOCurrency("USD"));
        assertTrue(IsoUtils.getInstance().isValidISOCurrency("ARS"));
        assertTrue(IsoUtils.getInstance().isValidISOCurrency("BYN"));
        assertTrue(IsoUtils.getInstance().isValidISOCurrency("NGN"));
        /*
         * invalid
         */
        assertFalse(IsoUtils.getInstance().isValidISOCurrency("usd"));
        assertFalse(IsoUtils.getInstance().isValidISOCurrency(""));
        assertFalse(IsoUtils.getInstance().isValidISOCurrency(null));
        assertFalse(IsoUtils.getInstance().isValidISOCurrency("XYZ"));

        IsoUtils.getInstance().addCurrency("XYZ");
        assertTrue(IsoUtils.getInstance().isValidISOCurrency("XYZ"));
        IsoUtils.getInstance().removeCurrency("XYZ");
        assertFalse(IsoUtils.getInstance().isValidISOCurrency("XYZ"));
    }

    @Test
    public void testCountries() {
        /*
         * valid
         */
        assertTrue(IsoUtils.getInstance().isValidISOCountry("US"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("AR"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("BR"));
        /*
         * invalid
         */
        assertFalse(IsoUtils.getInstance().isValidISOCountry("us"));
        assertFalse(IsoUtils.getInstance().isValidISOCountry("Foo"));
        assertFalse(IsoUtils.getInstance().isValidISOCountry(""));
        assertFalse(IsoUtils.getInstance().isValidISOCountry(null));
        assertFalse(IsoUtils.getInstance().isValidISOCountry("ZZ"));
        assertFalse(IsoUtils.getInstance().isValidISOCountry("ar"));
    }

    @Test
    public void testCountriesUserAssigned() {
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XA"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XB"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XC"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XD"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XE"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XF"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XG"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XH"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XI"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XJ"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XK"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XL"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XM"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XN"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XO"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XP"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XQ"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XR"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XS"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XT"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XU"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XV"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XW"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XX"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XY"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XZ"));
    }

    @Test
    public void testAddCountry_1() {
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> IsoUtils.getInstance().addCountry(null));
    }

    @Test
    public void testAddCountry_2() {
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> IsoUtils.getInstance().addCountry("33"));
    }

    @Test
    public void testAddCountry_3() {
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> IsoUtils.getInstance().addCountry("aa"));
    }

    @Test
    public void testAddCountry_4() {
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> IsoUtils.getInstance().addCountry("AAA"));
    }

    @Test
    public void testAddCountry_5() {
        IsoUtils.getInstance().addCountry("SZ");
        assertTrue(IsoUtils.getInstance().isValidISOCountry("SZ"));
        IsoUtils.getInstance().removeCountry("SZ");
        assertFalse(IsoUtils.getInstance().isValidISOCountry("SZ"));
    }

    @Test
    public void testAddCurrency_1() {
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> IsoUtils.getInstance().addCurrency(null));
    }

    @Test
    public void testAddCurrency_2() {
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> IsoUtils.getInstance().addCurrency("333"));
    }

    @Test
    public void testAddCurrency_3() {
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> IsoUtils.getInstance().addCurrency("aaa"));
    }

    @Test
    public void testAddCurrency_4() {
        Assertions.assertThrows(
                IllegalArgumentException.class, () -> IsoUtils.getInstance().addCurrency("AAAA"));
    }

    @Test
    public void testAddCurrency_5() {
        IsoUtils.getInstance().addCurrency("DSZ");
        assertTrue(IsoUtils.getInstance().isValidISOCurrency("DSZ"));
        IsoUtils.getInstance().removeCurrency("DSZ");
        assertFalse(IsoUtils.getInstance().isValidISOCurrency("DSZ"));
    }

    @Test
    public void testCountryNameByAlpha2() {
        assertEquals("United States of America", IsoUtils.getInstance().getCountryName("US"));
        assertEquals("Spain", IsoUtils.getInstance().getCountryName("ES"));
        assertEquals("Antigua and Barbuda", IsoUtils.getInstance().getCountryName("AG"));
    }

    @Test
    public void testCountryNameByAlpha3() {
        assertEquals("Spain", IsoUtils.getInstance().getCountryName("ESP"));
        assertEquals("Antigua and Barbuda", IsoUtils.getInstance().getCountryName("ATG"));
        assertEquals("Sudan", IsoUtils.getInstance().getCountryName("SDN"));
    }

    @Test
    public void testCountryNameByNumeric() {
        assertEquals("Antigua and Barbuda", IsoUtils.getInstance().getCountryName("028"));
        assertEquals("Solomon Islands", IsoUtils.getInstance().getCountryName("090"));
        assertEquals("Uruguay", IsoUtils.getInstance().getCountryName("858"));
        assertEquals("United States of America", IsoUtils.getInstance().getCountryName("840"));
    }

    /** A numeric code with fewer or more leading zeros than the three ISO digits still identifies the country */
    @Test
    public void testCountryNameByNumericWithOtherLeadingZeros() {
        assertEquals("Antigua and Barbuda", IsoUtils.getInstance().getCountryName("28"));
        assertEquals("Afghanistan", IsoUtils.getInstance().getCountryName("4"));
        assertEquals("Antigua and Barbuda", IsoUtils.getInstance().getCountryName("0028"));
        assertEquals("United States of America", IsoUtils.getInstance().getCountryName("000840"));
        assertNull(IsoUtils.getInstance().getCountryName("0000"));
        assertNull(IsoUtils.getInstance().getCountryName("1234"));
    }

    @Test
    public void testCountryNameIsLenientWithCaseAndSurroundingSpace() {
        assertEquals("Uruguay", IsoUtils.getInstance().getCountryName("uy"));
        assertEquals("Sudan", IsoUtils.getInstance().getCountryName("Sdn"));
        assertEquals("Spain", IsoUtils.getInstance().getCountryName(" ES "));
    }

    /** The numeric lookup must not depend on the digits of the default locale */
    @Test
    public void testCountryNameByNumericIsIndependentOfTheDefaultLocale() {
        Locale previous = Locale.getDefault();
        Locale.setDefault(new Locale.Builder().setLanguage("ar").setRegion("EG").build());
        try {
            assertEquals("Antigua and Barbuda", IsoUtils.getInstance().getCountryName("28"));
            assertEquals("Afghanistan", IsoUtils.getInstance().getCountryName("004"));
        } finally {
            Locale.setDefault(previous);
        }
    }

    @Test
    public void testCountryNameUnknownIsNull() {
        assertNull(IsoUtils.getInstance().getCountryName(null));
        assertNull(IsoUtils.getInstance().getCountryName(""));
        assertNull(IsoUtils.getInstance().getCountryName("   "));
        assertNull(IsoUtils.getInstance().getCountryName("UK"));
        assertNull(IsoUtils.getInstance().getCountryName("foo"));
        assertNull(IsoUtils.getInstance().getCountryName("999"));
        assertNull(IsoUtils.getInstance().getCountryName("99999999999999999999999"));
        assertNull(IsoUtils.getInstance().getCountryName("USAX"));
    }

    /** The user assigned codes have no name, even when added to the country codes */
    @Test
    public void testCountryNameOfUserAssignedCodes() {
        for (String code : new String[] {"XA", "XK", "XX", "XZ", "QM", "QZ", "AA", "ZZ"}) {
            assertNull(IsoUtils.getInstance().getCountryName(code), code);
        }
        IsoUtils.getInstance().addCountry("XK");
        try {
            assertNull(IsoUtils.getInstance().getCountryName("XK"));
        } finally {
            IsoUtils.getInstance().removeCountry("XK");
        }
    }

    /** The ISO short names, free of footnote marks, with the non-ASCII names read as UTF-8 */
    @Test
    public void testCountryNamesAreTheIsoShortNames() {
        assertEquals("Afghanistan", IsoUtils.getInstance().getCountryName("AF"));
        assertEquals("China", IsoUtils.getInstance().getCountryName("CN"));
        assertEquals("Taiwan, Province of China", IsoUtils.getInstance().getCountryName("TW"));
        assertEquals("Bonaire, Sint Eustatius and Saba", IsoUtils.getInstance().getCountryName("BQ"));
        assertEquals("Svalbard and Jan Mayen", IsoUtils.getInstance().getCountryName("SJ"));
        assertEquals("Bolivia, Plurinational State of", IsoUtils.getInstance().getCountryName("BO"));
        assertEquals("Korea, Republic of", IsoUtils.getInstance().getCountryName("KR"));
        assertEquals("Türkiye", IsoUtils.getInstance().getCountryName("TR"));
        assertEquals("Côte d'Ivoire", IsoUtils.getInstance().getCountryName("CI"));
        assertEquals("Åland Islands", IsoUtils.getInstance().getCountryName("AX"));
    }

    /** Every officially assigned country known to the JDK has a name, by any of its three codes */
    @Test
    public void testEveryJdkCountryHasAName() {
        for (String alpha2 : Locale.getISOCountries()) {
            String name = IsoUtils.getInstance().getCountryName(alpha2);
            assertNotNull(name, alpha2);
            assertFalse(name.isEmpty(), alpha2);
            assertFalse(name.contains("["), alpha2 + " carries a footnote: " + name);
            String alpha3 = new Locale.Builder().setRegion(alpha2).build().getISO3Country();
            assertEquals(name, IsoUtils.getInstance().getCountryName(alpha3), alpha2 + " by alpha-3 " + alpha3);
        }
    }
}
