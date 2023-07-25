package com.prowidesoftware.swift.model.field;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Field93ETest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl(
                "93E",
                ":DDDD//EEEE/SSSS/1234,",
                ":DDDD//EEEE/DDDD/N1234,",
                ":DDDD//AAAA/EEEE/N1234567890123456789012345,45");
    }

    public void testParse() {
        Field93F f = new Field93F(":DDDD//AAAA/EEEE/N1234,");
        assertEquals("DDDD", f.getComponent1());
        assertEquals("AAAA", f.getComponent2());
        assertEquals("EEEE", f.getComponent3());
        assertEquals("N", f.getComponent4());
        assertEquals("1234,", f.getComponent5());
    }
}
