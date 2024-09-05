package com.prowidesoftware.swift.model.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FieldEnumTest {

    @Test
    void testfieldName() {
        // Validate that fieldName returns the correct value
        assertEquals("11A", FieldEnum.F11A.fieldName());
        assertEquals("14P", FieldEnum.F14P.fieldName());
        assertEquals("30K", FieldEnum.F30K.fieldName());
    }

    @Test
    void testfromFieldNameValid() {
        // Validate that fromFieldName returns the correct enum when a valid code is provided
        assertEquals(FieldEnum.F11A, FieldEnum.fromFieldName("11A"));
        assertEquals(FieldEnum.F14R, FieldEnum.fromFieldName("14R"));
        assertEquals(FieldEnum.F30K, FieldEnum.fromFieldName("30K"));
    }

    @Test
    void testfromFieldNameInvalid() {
        // Validate that fromFieldName returns null when an invalid code is provided
        assertNull(FieldEnum.fromFieldName("930K"));
        assertNull(FieldEnum.fromFieldName("ABC"));
        assertNull(FieldEnum.fromFieldName(""));
    }

    @Test
    void testfromFieldNameEdgeCases() {
        // Validate edge cases, such as lowercase inputs, to ensure the method is case-sensitive
        assertNull(FieldEnum.fromFieldName("11a")); // should return null because "11a" is lowercase
        assertNull(FieldEnum.fromFieldName(" 11A")); // should return null because of the leading space
        assertNull(FieldEnum.fromFieldName("11A ")); // should return null because of the trailing space
    }

    @Test
    void testAllEnumValues() {
        // Validate that all enum values have the correct field name
        for (FieldEnum field : FieldEnum.values()) {
            assertEquals(field.name().substring(1), field.fieldName());
        }
    }
}
