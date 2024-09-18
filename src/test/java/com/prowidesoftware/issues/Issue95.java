package com.prowidesoftware.issues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.prowidesoftware.swift.model.field.Field32A;
import org.junit.jupiter.api.Test;

public class Issue95 {

    @Test
    public void testInheritance() {
        MyField32A f = new MyField32A("121212USD1234,");
        assertEquals("121212USD1234,FOO", f.getValue());
    }

    public static class MyField32A extends Field32A {

        public MyField32A(String value) {
            super(value);
        }

        @Override
        public String getValue() {
            return super.getValue() + "FOO";
        }
    }
}
