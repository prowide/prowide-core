package com.prowidesoftware.swift.model.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FieldEnumTest {

    @Test
    void testFieldName_F11A() {
        FieldEnum field = FieldEnum.F11A;
        String expectedName = "11A";
        assertEquals(expectedName, field.fieldName());
    }

    @Test
    void testFieldName_F29Q() {
        FieldEnum field = FieldEnum.F29Q;
        String expectedName = "29Q";
        assertEquals(expectedName, field.fieldName());
    }

    @Test
    void testFieldName_F30K() {
        FieldEnum field = FieldEnum.F30K;
        String expectedName = "30K";
        assertEquals(expectedName, field.fieldName());
    }

    @Test
    void testFromFieldNameValid_11A() {
        String fieldName = "11A";
        FieldEnum expectedEnum = FieldEnum.F11A;
        assertEquals(expectedEnum, FieldEnum.fromFieldName(fieldName));
    }

    @Test
    void testFromFieldNameValid_29Q() {
        String fieldName = "29Q";
        FieldEnum expectedEnum = FieldEnum.F29Q;
        assertEquals(expectedEnum, FieldEnum.fromFieldName(fieldName));
    }

    @Test
    void testFromFieldNameValid_30K() {
        String fieldName = "30K";
        FieldEnum expectedEnum = FieldEnum.F30K;
        assertEquals(expectedEnum, FieldEnum.fromFieldName(fieldName));
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
        assertNull(FieldEnum.fromFieldName(null)); // Test null input
        assertNull(FieldEnum.fromFieldName("11")); // Test partial field name
        assertNull(FieldEnum.fromFieldName("111A")); // Test invalid format with correct length
    }

    @Test
    void testAllEnumValues() {
        // Validate that all enum values have the correct field name
        for (FieldEnum field : FieldEnum.values()) {
            assertEquals(field.name().substring(1), field.fieldName());
        }
    }
}
