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
package com.prowidesoftware.swift.io;

import static org.junit.jupiter.api.Assertions.*;

import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.mt.AbstractMT;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.Test;

/**
 * Test cases for the {@link RJEReader} class
 *
 * @author sebastian
 * @since 9.2.0
 */
public class RJEReaderTest {

    @Test
    public void testIterator() throws IOException {
        try (InputStream inputStream = RJEReaderTest.class.getResourceAsStream("/MT103-out-ack.rje")) {
            RJEReader r = new RJEReader(inputStream, StandardCharsets.US_ASCII);
            int count = 0;
            for (String m : r) {
                assertNotNull(m);
                // System.out.println("msg "+(count));
                count++;
            }
            assertEquals(13, count);
        }
    }

    @Test
    public void testIteratorOnInvalidString() {
        for (String m : new RJEReader("foo")) {
            assertEquals("foo", m);
        }
    }

    @Test
    public void testIteratorNotReentrant() {
        RJEReader r = new RJEReader("foo");
        for (String m : r) {
            assertEquals("foo", m);
        }
        assertThrows(
                IllegalStateException.class,
                () -> {
                    for (String m : r) {
                        assertEquals("foo", m);
                    }
                },
                "Expected iterator to throw IllegalStateException, but it didn't");
    }

    @Test
    public void testIterableWithNextMT() throws IOException {
        try (InputStream inputStream = RJEReaderTest.class.getResourceAsStream("/MT103-out-ack.rje")) {
            RJEReader r = new RJEReader(inputStream, StandardCharsets.US_ASCII);
            assertTrue(r.hasNext());
            AbstractMT mt = r.nextMT();
            assertNotNull(mt);
            // System.out.println(mt.message());
            assertEquals("103", mt.getMessageType());
        }
    }

    @Test
    public void testIterableWithInvalidString() throws IOException {
        RJEReader r = new RJEReader("foo");
        assertEquals("foo", r.next());
        assertNull(r.next());

        r = new RJEReader("foo");
        assertNull(r.nextMT());
    }

    @Test
    public void testDeliveryNotification() throws IOException {
        RJEReader r = new RJEReader(
                "{1:F01AAAAFRPPZXXX0000000001}{2:O0111702090738DYLRXXXXCXXX00000000001702090738S}{4:{175:0741}{106:170209AAAAFRPPZXXX0000000002}{108:REF1}{175:0741}{107:170209AAAAFRPPXXXX0000000002}}{5:{CHK:ABCDEF123456}{SYS:}}$");
        assertNotNull(r.nextMT());
        assertNull(r.nextMT());
    }

    @Test
    public void testBulkFileWithAcks() throws IOException {
        try (InputStream inputStream = RJEReaderTest.class.getResourceAsStream("/MT103-bulk-with-ack.rje")) {
            RJEReader r = new RJEReader(inputStream, StandardCharsets.US_ASCII);
            assertNotNull(inputStream, "The input stream could not be found");

            int count = 0;
            while (r.hasNext()) {
                SwiftMessage ack = r.nextSwiftMessage();
                assertNotNull(ack);
                assertTrue(ack.isServiceMessage21());

                SwiftMessage mt = SwiftMessage.parse(ack.getUnparsedTexts().getAsFINString());
                assertNotNull(mt);
                assertTrue(mt.isType(103));
                // System.out.println(mt.getBlock4().getTagValue("20"));
                count++;
            }
            assertEquals(3, count);
        }
    }
}
