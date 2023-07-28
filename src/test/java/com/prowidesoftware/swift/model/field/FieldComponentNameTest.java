package com.prowidesoftware.swift.model.field;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Multiple test cases for the fields component names API
 */
public class FieldComponentNameTest {

    @Test
    public void test() {
        Field12B f = new Field12B();
        assertEquals(3, f.componentNameToNumber("instrumenttypecode"));
        assertEquals(3, f.componentNameToNumber("InstrumenttypeCode"));
        assertEquals(3, f.componentNameToNumber("INSTRUMENTTYPECODE"));
        // type is an alias in this field
        assertEquals(3, f.componentNameToNumber("type"));

        assertEquals(0, f.componentNameToNumber("foo"));
    }
}
