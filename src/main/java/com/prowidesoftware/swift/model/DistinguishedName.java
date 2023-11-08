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

    public static String parseBIC(final String dn) {
        if (StringUtils.isBlank(dn)) {
            return null;
        }
        for (String s : StringUtils.split(dn, ",")) {
            if (StringUtils.startsWith(s, "o=") && !StringUtils.equals(s, "o=swift")) {
                return StringUtils.upperCase(StringUtils.substringAfter(s, "o="));
            }
        }
        return null;
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
