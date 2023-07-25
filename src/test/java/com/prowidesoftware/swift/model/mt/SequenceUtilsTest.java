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

package com.prowidesoftware.swift.model.mt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.prowidesoftware.swift.model.mt.mt5xx.*;
import com.prowidesoftware.swift.model.mt.mt6xx.MT670;
import com.prowidesoftware.swift.model.mt.mt6xx.MT671;
import org.junit.jupiter.api.Test;

public class SequenceUtilsTest {
    /*
     * Si falla alguno de estos tests quiere decir que ya no es necesario  este codigo y podria volverse a
     * la generacion basica.
     * Esto asegura las precondiciones que implican generar el codigo, como es un static de un lib,
     * el codegen no lo referencia mas al no estar vigente pero seguiria estando el metodo
     */

    @Test
    public void testPrecondition535() {
        assertEquals(MT535.SequenceB1b1.START_END_16RS, MT535.SequenceB1c.START_END_16RS);
    }

    @Test
    public void testPrecondition536() {
        assertEquals(MT536.SequenceA1.START_END_16RS, MT536.SequenceB1a1.START_END_16RS);
    }

    @Test
    public void testPrecondition537() {
        assertEquals(MT537.SequenceA1.START_END_16RS, MT537.SequenceB2a.START_END_16RS);
        assertEquals(MT537.SequenceA1.START_END_16RS, MT537.SequenceC1.START_END_16RS);
        assertEquals(MT537.SequenceB.START_END_16RS, MT537.SequenceC3.START_END_16RS);
        assertEquals(MT537.SequenceB1.START_END_16RS, MT537.SequenceC3a.START_END_16RS);
        assertEquals(MT537.SequenceB2b.START_END_16RS, MT537.SequenceC2.START_END_16RS);
        assertEquals(MT537.SequenceB2b1.START_END_16RS, MT537.SequenceC2a.START_END_16RS);
    }

    @Test
    public void testPrecondition538() {
        assertEquals(MT538.SequenceA1.START_END_16RS, MT538.SequenceB2a1.START_END_16RS);
    }

    @Test
    public void testPrecondition564() {
        assertEquals(MT564.SequenceB1.START_END_16RS, MT564.SequenceE1a.START_END_16RS);
    }

    @Test
    public void testPrecondition566() {
        assertEquals(MT566.SequenceB1.START_END_16RS, MT566.SequenceD1a.START_END_16RS);
    }

    @Test
    public void testPrecondition575() {
        assertEquals(MT575.SequenceA1.START_END_16RS, MT575.SequenceB1a1.START_END_16RS);
        assertEquals(MT575.SequenceA1.START_END_16RS, MT575.SequenceC1.START_END_16RS);

        assertEquals(MT575.SequenceB1a4.START_END_16RS, MT575.SequenceC2a.START_END_16RS);
    }

    @Test
    public void testPrecondition576() {
        assertEquals(MT576.SequenceA1.START_END_16RS, MT576.SequenceB2a.START_END_16RS);
    }

    @Test
    public void testPrecondition586() {
        assertEquals(MT586.SequenceA1.START_END_16RS, MT586.SequenceB1.START_END_16RS);
    }

    @Test
    public void testPrecondition670() {
        assertEquals(MT670.SequenceB2.START_END_16RS, MT670.SequenceC.START_END_16RS);
    }

    @Test
    public void testPrecondition671() {
        assertEquals(MT671.SequenceB2.START_END_16RS, MT671.SequenceC.START_END_16RS);
    }
}
