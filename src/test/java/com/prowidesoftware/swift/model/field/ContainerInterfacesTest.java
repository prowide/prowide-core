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

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ContainerInterfacesTest {

    @Test
    public void testInstanceOf() {
        // both currency and amount
        assertTrue(new Field32A() instanceof MonetaryAmountContainer);
        assertTrue(new Field32A() instanceof CurrencyContainer);
        assertTrue(new Field32A() instanceof AmountContainer);

        // only amount
        assertFalse(new Field33B() instanceof MonetaryAmountContainer);
        assertFalse(new Field33B() instanceof CurrencyContainer);
        assertTrue(new Field33B() instanceof AmountContainer);

        // only currencies
        assertFalse(new Field32Q() instanceof MonetaryAmountContainer);
        assertTrue(new Field32Q() instanceof CurrencyContainer);
        assertFalse(new Field32Q() instanceof AmountContainer);
    }

}
