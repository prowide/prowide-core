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
    void testFieldName_F22J() {
        FieldEnum field = FieldEnum.F22J;
        String expectedName = "22J";
        assertEquals(expectedName, field.fieldName());
    }

    @Test
    void testFieldName_F44H() {
        FieldEnum field = FieldEnum.F44H;
        String expectedName = "44H";
        assertEquals(expectedName, field.fieldName());
    }

    @Test
    void testFromFieldNameValid_11A() {
        String fieldName = "11A";
        FieldEnum expectedEnum = FieldEnum.F11A;
        assertEquals(expectedEnum, FieldEnum.fromFieldName(fieldName));
    }

    @Test
    void testFromFieldNameValid_22J() {
        String fieldName = "22J";
        FieldEnum expectedEnum = FieldEnum.F22J;
        assertEquals(expectedEnum, FieldEnum.fromFieldName(fieldName));
    }

    @Test
    void testFromFieldNameValid_44H() {
        String fieldName = "44H";
        FieldEnum expectedEnum = FieldEnum.F44H;
        assertEquals(expectedEnum, FieldEnum.fromFieldName(fieldName));
    }

    @Test
    void testfromFieldNameInvalid() {
        // Validate that fromFieldName returns null when an invalid code is provided
        assertNull(FieldEnum.fromFieldName("999A"));
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
