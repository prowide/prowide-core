package com.prowidesoftware.swift.model.field;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FieldEnu5mTest {

    @ParameterizedTest
    @CsvSource({"F11A,11A", "F22J,22J", "F44H,44H"})
    void testFieldName(FieldEnum field, String expectedName) {
        assertEquals(expectedName, field.fieldName());
    }

    @ParameterizedTest
    @CsvSource({"11A,F11A", "22J,F22J", "44H,F44H"})
    void testFromFieldNameValid(String fieldName, FieldEnum expectedEnum) {
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
