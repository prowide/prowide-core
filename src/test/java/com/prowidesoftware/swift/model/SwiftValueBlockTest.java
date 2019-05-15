package com.prowidesoftware.swift.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SwiftValueBlockTest  {

    @Test
    public void getValuePart() {
        TestValueBlock b = new TestValueBlock();
        assertNull(b.getValuePart("", 0, 0));
        assertEquals("", b.getValuePart("Hello", 0, 0));
        assertEquals("H", b.getValuePart("Hello", 0, 1));
        assertEquals("Hello", b.getValuePart("Hello", 0, 10));
        assertEquals("ello", b.getValuePart("Hello", 1, 10));
        assertEquals("e", b.getValuePart("Hello", 1, 1));
        assertNull(b.getValuePart("Hello", 10, 1));
        assertEquals("EAKWAXXXU3003", b.getValuePart("O101AZADEAKWAXXXU3003", 8, 28));
    }

    static class TestValueBlock extends SwiftValueBlock {

        @Override
        protected void setBlockNumber(Integer blockNumber) {

        }

        @Override
        protected void setBlockName(String blockName) {

        }

        @Override
        public Integer getNumber() {
            return null;
        }

        @Override
        public String getName() {
            return null;
        }
    }

}
