package com.prowidesoftware.swift.model.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FieldEnumTest {

    @Test
    void testGetFieldName() {
        // Validate that getFieldName returns the correct value
        assertEquals("11A", FieldEnum.F11A.getFieldName());
        assertEquals("14P", FieldEnum.F14P.getFieldName());
        assertEquals("30K", FieldEnum.F30K.getFieldName());
    }

    @Test
    void testFromCodeValid() {
        // Validate that fromCode returns the correct enum when a valid code is provided
        assertEquals(FieldEnum.F11A, FieldEnum.fromCode("11A"));
        assertEquals(FieldEnum.F14R, FieldEnum.fromCode("14R"));
        assertEquals(FieldEnum.F30K, FieldEnum.fromCode("30K"));
    }

    @Test
    void testFromCodeInvalid() {
        // Validate that fromCode returns null when an invalid code is provided
        assertNull(FieldEnum.fromCode("930K"));
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
