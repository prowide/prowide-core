package com.prowidesoftware.swift.model.field;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Field57DTest extends AbstractFieldTest {

    @Override
    @Test
    public void testSerialization() {
        testSerializationImpl("57D",
                "//\nBIODATA LIMITED\nLONDON WC1 23H\nUNITED KINGDOM",
                "//"
        );
    }

    @Test
    public void testEmptyPartyField() {
        Field57D f = new Field57D("//");
        assertNull(f.getComponent1());
        assertNotNull(f.getComponent2());
        assertEquals("/", f.getComponent2());
        assertEquals("", f.getAccount());
    }

}
