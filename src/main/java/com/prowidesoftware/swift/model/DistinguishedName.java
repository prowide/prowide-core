package com.prowidesoftware.swift.model;

import org.apache.commons.lang3.StringUtils;

/**
 * Represents a Distinguished Name (DN) in the context of a directory service.
 * The DN is constructed using the organization unit (ou), Bank Identifier Code (BIC8), and SWIFT code.
 * This class provides a builder pattern for creating DistinguishedName instances.
 */
public class DistinguishedName {

    /**
     * The organization unit (ou) representing the branch in the Distinguished Name.
     */
    private final String branch;

    /**
     * The Bank Identifier Code (BIC8) in lowercase format.
     */
    private final String bic8;

    /**
     * The SWIFT code representing the organization.
     */
    private final String swift;

    /**
     * Private constructor to create a DistinguishedName instance using the Builder.
     *
     * @param builder The builder containing the required parameters for the DistinguishedName.
     */
    private DistinguishedName(Builder builder) {
        this.branch = builder.branch;
        this.bic8 = builder.bic8;
        this.swift = builder.swift;
    }

    public String getBranch() {
        return branch;
    }

    public String getBic8() {
        return bic8;
    }

    public String getSwift() {
        return swift;
    }

    @Override
    public String toString() {
        StringBuilder dn = new StringBuilder();
        if (branch != null && !branch.isEmpty()) {
            dn.append("ou=").append(branch).append(",");
        }
        dn.append("o=").append(bic8).append(",o=").append(swift);
        return dn.toString();
    }

    /**
     * Parses a BIC11 from a SWIFT Distinguished Name string.
     *
     * <p>Extracts the institution BIC8 from the {@code o=} component and the branch from the
     * {@code ou=} component. The result is always an 11-character BIC: if no branch is present
     * in the DN, {@code XXX} is used as the default branch code.
     *
     * <p>When multiple {@code ou} components are present, the one closest to {@code o=&lt;bic8&gt;}
     * (rightmost) is used as the branch. See {@link #parseBranch(String)} for details.
     *
     * @param dn the Distinguished Name string, may be null or blank
     * @return the BIC11 in uppercase, or null if no BIC8 component is found or the input is blank
     * @see #parseBranch(String)
     */
    public static String parseBIC(final String dn) {
        if (StringUtils.isBlank(dn)) {
            return null;
        }
        String bic8 = null;
        for (String s : StringUtils.split(dn, ",")) {
            if (StringUtils.startsWith(s, "o=") && !StringUtils.equals(s, "o=swift")) {
                bic8 = StringUtils.upperCase(StringUtils.substringAfter(s, "o="));
                break;
            }
        }
        if (bic8 == null) {
            return null;
        }
        BIC bic = new BIC(bic8);
        String branch = parseBranch(dn);
        if (branch != null) {
            bic.setBranch(branch);
        }
        return bic.getBic11();
    }

    /**
     * Parses the branch code from a SWIFT Distinguished Name string.
     *
     * <p>The branch is represented by the {@code ou} component. Only {@code ou} values with exactly
     * 3 characters are considered valid; others are silently ignored. When multiple valid {@code ou}
     * components are present, the one closest to {@code o=&lt;bic8&gt;} (i.e. the rightmost) is used,
     * as DNs are read right-to-left from least to most specific:
     * <pre>cn=a,ou=dept,ou=bbb,o=biccode,o=swift → branch is "BBB"</pre>
     *
     * @param dn the Distinguished Name string, may be null or blank
     * @return the branch code in uppercase, or null if not present, invalid, or if the input is blank
     */
    protected static String parseBranch(final String dn) {
        if (StringUtils.isBlank(dn)) {
            return null;
        }
        String branch = null;
        for (String s : StringUtils.split(dn, ",")) {
            if (StringUtils.startsWith(s, "ou=")) {
                String value = StringUtils.substringAfter(s, "ou=");
                if (value.length() == 3) {
                    // keep iterating — last valid match is the rightmost (closest to o=<bic8>)
                    branch = value;
                }
            }
        }
        return branch != null ? StringUtils.upperCase(branch) : null;
    }

    /**
     * Builder class for constructing DistinguishedName instances.
     */
    public static class Builder {
        private String branch;
        private final String bic8;
        private final String swift;

        public Builder(String bic8) {
            this.bic8 = StringUtils.lowerCase(bic8);
            this.swift = "swift";
        }

        public Builder withBranch(String ou) {
            this.branch = StringUtils.lowerCase(ou);
            return this;
        }

        public DistinguishedName build() {
            return new DistinguishedName(this);
        }
    }
}
