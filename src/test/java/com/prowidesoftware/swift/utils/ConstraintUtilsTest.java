package com.prowidesoftware.swift.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConstraintUtilsTest {

    @Test
    public void testEscapeEcmaScript() {
        assertNull(ConstraintUtils.escapeEcmaScript(null));
        assertEquals("He didn\\'t say, \\\"stop!\\\"", ConstraintUtils.escapeEcmaScript("He didn't say, \"stop!\""));
        assertEquals(
                "document.getElementById(\\\"test\\\").value = \\'<script>alert(\\'aaa\\');<\\/script>\\';",
                ConstraintUtils.escapeEcmaScript(
                        "document.getElementById(\"test\").value = '<script>alert('aaa');</script>';"));
    }
}
