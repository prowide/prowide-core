package com.prowidesoftware.swift.constraints;

import static org.junit.jupiter.api.Assertions.*;

import com.prowidesoftware.swift.model.IBAN;
import com.prowidesoftware.swift.model.IbanValidationResult;
import javax.validation.ClockProvider;
import javax.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class IbanValidatorTest {

    private IbanValidator validator;
    private TestConstraintValidatorContext context;

    @BeforeEach
    public void setUp() {
        validator = new IbanValidator();
        context = new TestConstraintValidatorContext();
    }

    @Test
    public void testValidIban() {
        String validIban = "ES9121000418450200051332"; // A valid IBAN
        assertEquals(IbanValidationResult.OK, new IBAN(validIban).validate());
        assertTrue(validator.isValid(validIban, context));
        assertFalse(context.isViolationOccurred());
    }

    @Test
    public void testIbanIsNull() {
        String nullIban = null;
        assertEquals(IbanValidationResult.IBAN_IS_NULL, new IBAN(nullIban).validate());
        assertTrue(validator.isValid(nullIban, context));
        assertFalse(context.isViolationOccurred());
        assertNull(context.getViolationMessage());
    }

    @Test
    public void testIbanIsEmpty() {
        String emptyIban = "";
        assertEquals(IbanValidationResult.IBAN_IS_EMPTY, new IBAN(emptyIban).validate());
        assertTrue(validator.isValid(emptyIban, context));
        assertFalse(context.isViolationOccurred());
        assertNull(context.getViolationMessage());
    }

    @Test
    public void testMissingCountryCode() {
        String missingCountryCodeIban = "1";
        assertEquals(IbanValidationResult.MISSING_COUNTRY_CODE, new IBAN(missingCountryCodeIban).validate());
        assertFalse(validator.isValid(missingCountryCodeIban, context));
        assertTrue(context.isViolationOccurred());
        assertEquals("The IBAN must start with the two letters ISO country code", context.getViolationMessage());
    }

    @Test
    public void testInvalidCountryCodeCharset() {
        String invalidCountryCodeIban = "es123456789"; // Lowercase 'es' instead of uppercase
        assertEquals(IbanValidationResult.INVALID_COUNTRY_CODE_CHARSET, new IBAN(invalidCountryCodeIban).validate());
        assertFalse(validator.isValid(invalidCountryCodeIban, context));
        assertTrue(context.isViolationOccurred());
        assertEquals(
                "The country code must contain upper case letters and es was found", context.getViolationMessage());
    }

    @Test
    public void testInvalidCountry() {
        String invalidCountryCodeIban = "ZZ123456789";
        assertEquals(IbanValidationResult.INVALID_COUNTRY_CODE, new IBAN(invalidCountryCodeIban).validate());
        assertFalse(validator.isValid(invalidCountryCodeIban, context));
        assertTrue(context.isViolationOccurred());
        assertEquals(
                "The country code ZZ is not a valid ISO country code or the country code is not configured for IBAN validations",
                context.getViolationMessage());
    }

    @Test
    public void testMissingCheckDigits() {
        String missingCheckDigitsIban = "ESX";
        assertEquals(IbanValidationResult.MISSING_CHECK_DIGITS, new IBAN(missingCheckDigitsIban).validate());
        assertFalse(validator.isValid(missingCheckDigitsIban, context));
        assertTrue(context.isViolationOccurred());
        assertEquals("Missing check digits", context.getViolationMessage());
    }

    @Test
    public void testInvalidCheckDigitsFormat() {
        String invalidCheckDigitsFormatIban = "ESAB123456789"; // Non-numeric check digits
        assertEquals(
                IbanValidationResult.INVALID_CHECK_DIGITS_FORMAT, new IBAN(invalidCheckDigitsFormatIban).validate());
        assertFalse(validator.isValid(invalidCheckDigitsFormatIban, context));
        assertTrue(context.isViolationOccurred());
        assertEquals("Expected 2 check digits and found AB", context.getViolationMessage());
    }

    @Test
    public void testMissingBban() {
        String missingBbanIban = "ES64"; // Country code + check digits, but no BBAN
        assertEquals(IbanValidationResult.MISSING_BBAN, new IBAN(missingBbanIban).validate());
        assertFalse(validator.isValid(missingBbanIban, context));
        assertTrue(context.isViolationOccurred());
        assertEquals("Missing custom account number (BBAN)", context.getViolationMessage());
    }

    @Test
    public void testBbanMaxLengthExceeded() {
        String bbanMaxLengthExceededIban = "ES640123456789012345678901234567890"; // Exceeding max BBAN length
        assertEquals(IbanValidationResult.BBAN_MAX_LENGTH, new IBAN(bbanMaxLengthExceededIban).validate());
        assertFalse(validator.isValid(bbanMaxLengthExceededIban, context));
        assertTrue(context.isViolationOccurred());
        assertEquals(
                "The max length for the custom account number (BBAN) is 30 and found 31",
                context.getViolationMessage());
    }

    @Test
    public void testMissingBbanConfiguration() {
        String missingBbanConfigIban = "AX64123456789";
        assertEquals(IbanValidationResult.MISSING_BBAN_CONFIGURATION, new IBAN(missingBbanConfigIban).validate());
        assertFalse(validator.isValid(missingBbanConfigIban, context));
        assertTrue(context.isViolationOccurred());
        assertEquals(
                "Missing custom account number (BBAN) configuration for country AX", context.getViolationMessage());
    }

    @Test
    public void testInvalidBbanLength() {
        String invalidBbanLengthIban = "ES6401234"; // Invalid BBAN length
        assertEquals(IbanValidationResult.BBAN_INVALID_LENGTH, new IBAN(invalidBbanLengthIban).validate());
        assertFalse(validator.isValid(invalidBbanLengthIban, context));
        assertTrue(context.isViolationOccurred());
        assertEquals(
                "Expected a 20 characters length for the custom account number (BBAN) and found 5 in 01234",
                context.getViolationMessage());
    }

    @Test
    public void testBbanInvalidUpperCaseLetters() {
        String invalidUpperCaseIban = "GI75nWBK000000007099453"; // BBAN with lowercase letters
        assertEquals(IbanValidationResult.BBAN_INVALID_UPPER_CASE_LETTERS, new IBAN(invalidUpperCaseIban).validate());
        assertFalse(validator.isValid(invalidUpperCaseIban, context));
        assertTrue(context.isViolationOccurred());
        assertEquals("The BANK_CODE nWBK must contain only upper case letters", context.getViolationMessage());
    }

    @Test
    public void testBbanInvalidDigitsOrLetters() {
        String invalidDigitsOrLettersIban = "GI75NWBK00000000709t453"; // BBAN with invalid characters
        assertEquals(
                IbanValidationResult.BBAN_INVALID_DIGITS_OR_LETTERS, new IBAN(invalidDigitsOrLettersIban).validate());
        assertFalse(validator.isValid(invalidDigitsOrLettersIban, context));
        assertTrue(context.isViolationOccurred());
        assertEquals(
                "The ACCOUNT_NUMBER 00000000709t453 must contain only digits or upper case letters",
                context.getViolationMessage());
    }

    @Test
    public void testBbanInvalidDigits() {
        String invalidDigitsIban = "ES640abcd100041845024502"; // BBAN with letters where digits expected
        assertEquals(IbanValidationResult.BBAN_INVALID_DIGITS, new IBAN(invalidDigitsIban).validate());
        assertFalse(validator.isValid(invalidDigitsIban, context));
        assertTrue(context.isViolationOccurred());
        assertEquals("The BANK_CODE 0abc must contain only digits", context.getViolationMessage());
    }

    @Disabled
    @Test
    public void testInvalidCharacters() {
        // TODO: find a input that can produce this result
        String invalidCharactersIban = "ES0X1234000000007094532";
        assertEquals(IbanValidationResult.INVALID_CHARACTERS, new IBAN(invalidCharactersIban).validate());
        assertFalse(validator.isValid(invalidCharactersIban, context));
        assertTrue(context.isViolationOccurred());
        assertEquals("Invalid character '@' found", context.getViolationMessage());
    }

    @Test
    public void testInvalidCheckDigits() {
        String invalidCheckDigitsIban = "ES0012345678901234567890"; // Invalid computed check digits
        assertEquals(IbanValidationResult.INVALID_CHECK_DIGITS, new IBAN(invalidCheckDigitsIban).validate());
        assertFalse(validator.isValid(invalidCheckDigitsIban, context));
        assertTrue(context.isViolationOccurred());
        assertEquals("The expected computed check digit is 98 and 00 was found", context.getViolationMessage());
    }

    /**
     * Simulated implementation of ConstraintValidatorContext for testing
     */
    static class TestConstraintValidatorContext implements ConstraintValidatorContext {

        private boolean violationOccurred = false;
        private String violationMessage = null;

        @Override
        public void disableDefaultConstraintViolation() {
            violationOccurred = true;
        }

        @Override
        public String getDefaultConstraintMessageTemplate() {
            return null;
        }

        @Override
        public ClockProvider getClockProvider() {
            return null;
        }

        @Override
        public ConstraintViolationBuilder buildConstraintViolationWithTemplate(String messageTemplate) {
            this.violationMessage = messageTemplate;
            return new TestConstraintViolationBuilder();
        }

        public boolean isViolationOccurred() {
            return violationOccurred;
        }

        public String getViolationMessage() {
            return violationMessage;
        }

        @Override
        public <T> T unwrap(Class<T> type) {
            return null;
        }

        // Simulated ConstraintViolationBuilder implementation
        class TestConstraintViolationBuilder implements ConstraintViolationBuilder {
            @Override
            public NodeBuilderDefinedContext addNode(String name) {
                return null;
            }

            @Override
            public NodeBuilderCustomizableContext addPropertyNode(String name) {
                return null;
            }

            @Override
            public LeafNodeBuilderCustomizableContext addBeanNode() {
                return null;
            }

            @Override
            public ContainerElementNodeBuilderCustomizableContext addContainerElementNode(
                    String name, Class<?> containerType, Integer index) {
                return null;
            }

            @Override
            public NodeBuilderDefinedContext addParameterNode(int index) {
                return null;
            }

            @Override
            public ConstraintValidatorContext addConstraintViolation() {
                return TestConstraintValidatorContext.this;
            }
        }
    }
}
