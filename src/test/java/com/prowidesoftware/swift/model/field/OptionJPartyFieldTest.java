package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.swift.model.field.OptionJPartyField.Codeword;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test for API in the party field option J classes.
 *
 * @since 7.11.0
 */
public class OptionJPartyFieldTest {

    @Test
    public void testGetValueByCodeword() {
        TestPartyField f = new TestPartyField("/ABIC/CHASUS33\n"+
                "/NAME/12345xxxxx12345xxxxx12345+++++1234\n"+
                "/ACCT/12345xxxxx12345xxxxx12345/NETS/\n"+
                "/ADD1/12345xxxxx12345xxxxx12345+++++1234\n"+
                "5/ADD2/12345xxxxx12345xxxxx12345+++++123");
        assertNull(f.getValueByCodeword(Codeword.SVBY));
        assertNull(f.getValueByCodeword(Codeword.NETS));
        assertNull(f.getValueByCodeword(Codeword.SSIS));
        assertNull(f.getValueByCodeword(Codeword.LEIC));
        assertEquals("CHASUS33", f.getValueByCodeword(Codeword.ABIC));
        assertEquals("12345xxxxx12345xxxxx12345+++++1234", f.getValueByCodeword(Codeword.NAME));
        assertEquals("12345xxxxx12345xxxxx12345", f.getValueByCodeword(Codeword.ACCT));
        assertEquals("12345xxxxx12345xxxxx12345+++++12345", f.getValueByCodeword(Codeword.ADD1));
        assertEquals("12345xxxxx12345xxxxx12345+++++123", f.getValueByCodeword(Codeword.ADD2));
    }

    private class TestPartyField extends OptionJPartyField {

        TestPartyField(String value) {
            super(value);
        }

        @Override
        public String validatorPattern() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }
    }

}
