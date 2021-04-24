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
package com.prowidesoftware.swift.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * test cases for {@link IsoUtils}
 *
 * @author sebastian
 * @since 7.9.2
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

        IsoUtils.getInstance().getCurrencies().add("XYZ");
        assertTrue(IsoUtils.getInstance().isValidISOCurrency("XYZ"));
        IsoUtils.getInstance().getCurrencies().remove("XYZ");
    }

    @Test
    public void testCountries() {
        /*
         * valid
         */
        assertTrue(IsoUtils.getInstance().isValidISOCountry("US"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("AR"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("BR"));
        assertTrue(IsoUtils.getInstance().isValidISOCountry("XK")); //Kosovo, not currently in ISO
        /*
         * invalid
         */
        assertFalse(IsoUtils.getInstance().isValidISOCountry("us"));
        assertFalse(IsoUtils.getInstance().isValidISOCountry("Foo"));
        assertFalse(IsoUtils.getInstance().isValidISOCountry(""));
        assertFalse(IsoUtils.getInstance().isValidISOCountry(null));
        assertFalse(IsoUtils.getInstance().isValidISOCountry("XX"));
        assertFalse(IsoUtils.getInstance().isValidISOCountry("ZZ"));
        assertFalse(IsoUtils.getInstance().isValidISOCountry("ar"));
    }

    @Test
    public void testAddCountry_1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IsoUtils.getInstance().addCountry(null);
        });
    }

    @Test
    public void testAddCountry_2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IsoUtils.getInstance().addCountry("33");
        });

    }

    @Test
    public void testAddCountry_3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IsoUtils.getInstance().addCountry("aa");
        });

    }

    @Test
    public void testAddCountry_4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IsoUtils.getInstance().addCountry("AAA");
        });

    }

    @Test
    public void testAddCountry_5() {
        IsoUtils.getInstance().addCountry("SZ");
        assertTrue(IsoUtils.getInstance().isValidISOCountry("SZ"));
        IsoUtils.getInstance().getCountries().remove("SZ");
    }

    @Test
    public void testAddCurrency_1() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IsoUtils.getInstance().addCurrency(null);
        });

    }

    @Test
    public void testAddCurrency_2() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IsoUtils.getInstance().addCurrency("333");
        });

    }

    @Test
    public void testAddCurrency_3() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IsoUtils.getInstance().addCurrency("aaa");
        });

    }

    @Test
    public void testAddCurrency_4() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            IsoUtils.getInstance().addCurrency("AAAA");
        });
    }

    @Test
    public void testAddCurrency_5() {
        IsoUtils.getInstance().addCurrency("DSZ");
        assertTrue(IsoUtils.getInstance().isValidISOCurrency("DSZ"));
        IsoUtils.getInstance().getCurrencies().remove("DSZ");
    }

}
