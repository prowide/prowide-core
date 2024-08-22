package com.prowidesoftware.swift.model.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FieldEnumTest {

    @Test
    void testGetFieldName() {
        // Validate that getFieldName returns the correct value
        assertEquals("11A", FieldEnum.F11A.getFieldName());
        assertEquals("22J", FieldEnum.F22J.getFieldName());
        assertEquals("44H", FieldEnum.F44H.getFieldName());
    }

    @Test
    void testFromCodeValid() {
        // Validate that fromCode returns the correct enum when a valid code is provided
        assertEquals(FieldEnum.F11A, FieldEnum.fromCode("11A"));
        assertEquals(FieldEnum.F22J, FieldEnum.fromCode("22J"));
        assertEquals(FieldEnum.F44H, FieldEnum.fromCode("44H"));
    }

    @Test
    void testFromCodeInvalid() {
        // Validate that fromCode returns null when an invalid code is provided
        assertNull(FieldEnum.fromCode("999A"));
        assertNull(FieldEnum.fromCode("ABC"));
        assertNull(FieldEnum.fromCode(""));
    }

    @Test
    void testFromCodeEdgeCases() {
        // Validate edge cases, such as lowercase inputs, to ensure the method is case-sensitive
        assertNull(FieldEnum.fromCode("11a")); // should return null because "11a" is lowercase
        assertNull(FieldEnum.fromCode(" 11A")); // should return null because of the leading space
        assertNull(FieldEnum.fromCode("11A ")); // should return null because of the trailing space
    }

    @Test
    void testAllEnumValues() {
        // Validate that all enum values have the correct field name
        for (FieldEnum field : FieldEnum.values()) {
            assertEquals(field.name().substring(1), field.getFieldName());
        }
    }
}
