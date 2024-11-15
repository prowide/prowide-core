package com.prowidesoftware.swift.model.mt;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for {@link MtSequenceEnum} to validate the sequence definitions
 * and format compliance for different SWIFT MT message types.
 */
class MtSequenceEnumTest {

    /**
     * Regex pattern for validating SWIFT MT sequence formats.
     * Valid examples:
     * - "A"           (simple sequence)
     * - "B/B1"        (sequence with numeric suffix)
     * - "E/E1/E1a"    (nested sequence)
     * - "E/E1a/E1a1"  (complex nested sequence)
     */
    private static final String SEQUENCE_PATTERN = "^[A-Z](?:/[A-Z][0-9]?(?:[a-z][0-9]?[A-Za-z0-9]*)?)*$";

    @Test
    void testGetSequences_MT101() {
        MtSequenceEnum sequence = MtSequenceEnum.MT101;
        Set<String> expectedSequences = new HashSet<>(Arrays.asList("A", "B"));
        assertEquals(expectedSequences, sequence.sequences());
    }

    @Test
    void testGetSequences_MT102() {
        MtSequenceEnum sequence = MtSequenceEnum.MT102;
        Set<String> expectedSequences = new HashSet<>(Arrays.asList("A", "B", "C"));
        assertEquals(expectedSequences, sequence.sequences());
    }

    @Test
    void testGetSequences_MT300() {
        MtSequenceEnum sequence = MtSequenceEnum.MT300;
        Set<String> expectedSequences = new HashSet<>(Arrays.asList(
                "A", "B", "B/B1", "B/B2", "C", "D", "D/D1", "E", "E/E1", "E/E1/E1a", "E/E1/E1a/E1a1", "F"));
        assertEquals(expectedSequences, sequence.sequences());
    }

    @Test
    void testGetSequences_MT508() {
        MtSequenceEnum sequence = MtSequenceEnum.MT508;
        Set<String> expectedSequences = new HashSet<>(Arrays.asList("A", "A/A1", "B", "B/B1", "C"));
        assertEquals(expectedSequences, sequence.sequences());
    }

    @Test
    void testFromFieldNameValid_MT101() {
        String fieldName = "MT101";
        MtSequenceEnum expectedEnum = MtSequenceEnum.MT101;
        assertEquals(expectedEnum, MtSequenceEnum.valueOf(fieldName));
    }

    @Test
    void testFromFieldNameValid_MT102() {
        String fieldName = "MT102";
        MtSequenceEnum expectedEnum = MtSequenceEnum.MT102;
        assertEquals(expectedEnum, MtSequenceEnum.valueOf(fieldName));
    }

    @Test
    void testFromFieldNameValid_MT508() {
        String fieldName = "MT508";
        MtSequenceEnum expectedEnum = MtSequenceEnum.MT508;
        assertEquals(expectedEnum, MtSequenceEnum.valueOf(fieldName));
    }

    @Test
    void testFromFieldNameInvalid() {
        assertThrows(NullPointerException.class, () -> MtSequenceEnum.valueOf(null));
        assertThrows(IllegalArgumentException.class, () -> MtSequenceEnum.valueOf("INVALID"));
        assertThrows(IllegalArgumentException.class, () -> MtSequenceEnum.valueOf(""));
        assertThrows(IllegalArgumentException.class, () -> MtSequenceEnum.valueOf("MT"));
        assertThrows(IllegalArgumentException.class, () -> MtSequenceEnum.valueOf("MT999999"));
        assertThrows(IllegalArgumentException.class, () -> MtSequenceEnum.valueOf("MTxxx"));
    }

    @Test
    void testAllEnumValuesHaveSequences() {
        for (MtSequenceEnum seqValue : MtSequenceEnum.values()) {
            String enumName = seqValue.name();
            assertNotNull(seqValue.sequences(), String.format("Sequence for enum value '%s' is null", enumName));
            assertFalse(
                    seqValue.sequences().isEmpty(),
                    String.format("Sequence for enum value '%s' is empty. Expected at least one sequence.", enumName));

            // Validate sequence format
            Set<String> sequences = seqValue.sequences();
            for (String sequence : sequences) {
                assertTrue(
                        sequence.matches(SEQUENCE_PATTERN),
                        String.format(
                                "Sequence '%s' in %s should match format: %s", sequence, enumName, SEQUENCE_PATTERN));
            }

            // Check for duplicates
            Set<String> uniqueSequences = new HashSet<>(sequences);
            assertEquals(
                    sequences.size(),
                    uniqueSequences.size(),
                    String.format("Sequences in %s contain duplicates: %s", enumName, sequences));
        }
    }
}
