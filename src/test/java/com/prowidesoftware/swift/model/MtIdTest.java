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
package com.prowidesoftware.swift.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.prowidesoftware.swift.model.field.Field32A;
import org.junit.jupiter.api.Test;

class MtIdTest {

    @Test
    public void testConstructor() {
        // from well defined identifier
        assertEquals("fin.103", new MtId("103").id());
        assertEquals("fin.103", new MtId("fin.103").id());
        assertEquals("fin.103.REMIT", new MtId("fin.103.REMIT").id());
        assertEquals("fin.103.REMIT", new MtId("103.REMIT").id());
        assertEquals("fin.103.STP", new MtId("fin.103.STP").id());
        assertEquals("fin.103.STP", new MtId("103.STP").id());
        assertEquals("fin.202.COV", new MtId("fin.202.COV").id());
        assertEquals("fin.202.COV", new MtId("202.COV").id());
        assertEquals("fin.103.STP", new MtId("fin.103_STP").id());
        assertEquals("fin.103.STP", new MtId("fin.103STP").id());
        assertEquals("fin.202.COV", new MtId("fin.202_COV").id());
        assertEquals("fin.202.COV", new MtId("fin.202COV").id());

        // from ISO 15022 namespaces
        assertEquals("fin.103", new MtId("urn:swift:xsd:fin.103.2021").id());
        assertEquals("fin.103.REMIT", new MtId("urn:swift:xsd:fin.103.REMIT.2022").id());
        assertEquals("fin.103.STP", new MtId("urn:swift:xsd:fin.103.STP.2022").id());

        // ACK/NACK
        assertEquals("fin.ACK", new MtId("ACK").id());
        assertEquals("fin.NAK", new MtId("NAK").id());

        // Other strings
        assertEquals("fin.BypassFoobar", new MtId("BypassFoobar").id());
    }

    @Test
    public void testNamespaceURI() {
        int current = Field32A.SRU;
        assertEquals("urn:swift:xsd:fin.103." + current, new MtId("103").namespaceURI());
        assertEquals("urn:swift:xsd:fin.103." + current, new MtId("fin.103").namespaceURI());
        assertEquals("urn:swift:xsd:fin.103.REMIT." + current, new MtId("fin.103.REMIT").namespaceURI());
        assertEquals("urn:swift:xsd:fin.103.REMIT." + current, new MtId("103.REMIT").namespaceURI());
        assertEquals("urn:swift:xsd:fin.103.STP." + current, new MtId("fin.103.STP").namespaceURI());
        assertEquals("urn:swift:xsd:fin.103.STP." + current, new MtId("103.STP").namespaceURI());
        assertEquals("urn:swift:xsd:fin.202.COV." + current, new MtId("fin.202.COV").namespaceURI());
        assertEquals("urn:swift:xsd:fin.202.COV." + current, new MtId("202.COV").namespaceURI());
        assertEquals("urn:swift:xsd:fin.103.STP." + current, new MtId("fin.103_STP").namespaceURI());
        assertEquals("urn:swift:xsd:fin.103.STP." + current, new MtId("fin.103STP").namespaceURI());
        assertEquals("urn:swift:xsd:fin.202.COV." + current, new MtId("fin.202_COV").namespaceURI());
        assertEquals("urn:swift:xsd:fin.202.COV." + current, new MtId("fin.202COV").namespaceURI());
        assertEquals("urn:swift:xsd:fin.ACK." + current, new MtId("ACK").namespaceURI());
        assertEquals("urn:swift:xsd:fin.NAK." + current, new MtId("NAK").namespaceURI());
        assertEquals("urn:swift:xsd:fin.BypassFoobar." + current, new MtId("BypassFoobar").namespaceURI());
    }
}
