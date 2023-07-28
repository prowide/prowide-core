package com.prowidesoftware.swift.model.field;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Field93FTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl(
                "93F",
                ":DDDD//EEEE/1234,",
                ":DDDD//EEEE/N1234,",
                ":DDDD/111fffff/EEEE/1234,",
                ":DDDD/111fffff/EEEE/N1234,");
    }

    public void testParse() {
        Field93F f = new Field93F(":DDDD/111fffff/EEEE/N1234,");
        assertEquals("DDDD", f.getComponent1());
        assertEquals("111fffff", f.getComponent2());
        assertEquals("EEEE", f.getComponent3());
        assertEquals("N", f.getComponent4());
        assertEquals("1234,", f.getComponent5());
    }
}
