package com.prowidesoftware.swift.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class DistinguishedNameTest {

    @Test
    void testDistinguishedNameWithCommonNameAndOU() {
        String bic8 = "BIC8CODE";
        String ou = "FOO";
        DistinguishedName dn =
                new DistinguishedName.Builder(bic8).withBranch(ou).build();
        assertEquals("ou=foo,o=bic8code,o=swift", dn.toString());
    }

    @Test
    void testDistinguishedNameWithOUOnly() {
        String bic8 = "bic8code";
        String ou = "bar";
        DistinguishedName dn =
                new DistinguishedName.Builder(bic8).withBranch(ou).build();
        assertEquals("ou=bar,o=bic8code,o=swift", dn.toString());
    }

    @Test
    void testDistinguishedNameWithNoOUOrCN() {
        String bic8 = "BIC8CODE";
        DistinguishedName dn = new DistinguishedName.Builder(bic8).build();
        assertEquals("o=bic8code,o=swift", dn.toString());
    }

    @Test
    void testDistinguishedNameEmptyValues() {
        String bic8 = "BIC8CODE";
        DistinguishedName dn =
                new DistinguishedName.Builder(bic8).withBranch("").build();
        assertEquals("o=bic8code,o=swift", dn.toString());
    }

    @Test
    void testParseBIC() {
        String dn1 = "cn=John Doe,o=swift,ou=users,dc=example,dc=com";
        assertNull(DistinguishedName.parseBIC(dn1));

        dn1 = "o=bic8code,o=swift";
        assertEquals("BIC8CODEXXX", DistinguishedName.parseBIC(dn1));

        dn1 = "ou=bar,o=bic8code,o=swift";
        assertEquals("BIC8CODEBAR", DistinguishedName.parseBIC(dn1));

        assertNull(DistinguishedName.parseBIC(null));

        assertNull(DistinguishedName.parseBIC(""));

        assertNull(DistinguishedName.parseBIC("XXX"));
    }

    @Test
    void testParseBranchSingleOU() {
        assertEquals("XXX", DistinguishedName.parseBranch("ou=xxx,o=biccode,o=swift"));
    }

    @Test
    void testParseBranchUppercasesResult() {
        assertEquals("XXX", DistinguishedName.parseBranch("ou=XXX,o=biccode,o=swift"));
    }

    @Test
    void testParseBranchWithCN() {
        assertEquals("XXX", DistinguishedName.parseBranch("cn=a,ou=xxx,o=biccode,o=swift"));
    }

    @Test
    void testParseBranchMultipleOU() {
        // rightmost ou (closest to o=<bic8>) is the branch; leftmost is a subdivision
        assertEquals("BBB", DistinguishedName.parseBranch("cn=a,ou=dept,ou=bbb,o=biccode,o=swift"));
    }

    @Test
    void testParseBranchNoOU() {
        assertNull(DistinguishedName.parseBranch("o=biccode,o=swift"));
    }

    @Test
    void testParseBranchNull() {
        assertNull(DistinguishedName.parseBranch(null));
    }

    @Test
    void testParseBranchBlank() {
        assertNull(DistinguishedName.parseBranch(""));
        assertNull(DistinguishedName.parseBranch("   "));
    }

    @Test
    void testParseBranchNoMatch() {
        assertNull(DistinguishedName.parseBranch("o=biccode,o=swift"));
    }
}
