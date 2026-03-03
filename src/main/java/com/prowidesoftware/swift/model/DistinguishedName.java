package com.prowidesoftware.swift.model;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Strings;

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

    public static String parseBIC(final String dn) {
        if (StringUtils.isBlank(dn)) {
            return null;
        }
        for (String s : StringUtils.split(dn, ",")) {
            if (Strings.CS.startsWith(s, "o=") && !Strings.CS.equals(s, "o=swift")) {
                return StringUtils.upperCase(StringUtils.substringAfter(s, "o="));
            }
        }
        return null;
    }

    /**
     * Parses the branch code from a SWIFT Distinguished Name string.
     *
     * <p>The branch is represented by the {@code ou} component. When multiple {@code ou} components
     * are present, the one closest to {@code o=&lt;bic8&gt;} (i.e. the rightmost) is the branch code,
     * as DNs are read right-to-left from least to most specific:
     * <pre>cn=a,ou=dept,ou=bbb,o=biccode,o=swift → branch is "BBB"</pre>
     *
     * @param dn the Distinguished Name string, may be null or blank
     * @return the branch code in uppercase, or null if not present or if the input is blank
     */
    protected static String parseBranch(final String dn) {
        if (StringUtils.isBlank(dn)) {
            return null;
        }
        String branch = null;
        for (String s : StringUtils.split(dn, ",")) {
            if (Strings.CS.startsWith(s, "ou=")) {
                // keep iterating — last match is the rightmost (closest to o=<bic8>)
                branch = StringUtils.substringAfter(s, "ou=");
            }
        }
        return StringUtils.isBlank(branch) ? null : StringUtils.upperCase(branch);
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
