/*
 * Copyright 2006-2023 Prowide
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.prowidesoftware.swift.model;

import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/**
 * Identifies a logical channel connection to SWIFT, and the network uses it for addressing.
 * It is basically a BIC code with an additional character identifier the terminal sending the message. The LT
 * identifier is located in position 9 of a full 12 characters address.
 * For example letter 'A' in CCCCUS33AXXX<br>
 * <p>
 * A sender LT address cannot have 'X' as LT identifier, conversely a
 * receiver LT address must have an 'X' as LT identifier.
 *
 * @author sebastian
 * @since 7.6
 */
public class LogicalTerminalAddress extends BIC {
    private Character lTIdentifier = null;

    /**
     * Creates an LT address from its string value.
     * <p>If the string contains a BIC8 or BIC11 the LT identifier will be set with a default value. If the BIC has
     * 12 characters, then the LT and branch is extracted from the parameter code. Finally if the BIC has a special
     * size of 9 characters, that is parsed as the BIC8 plus the LT identifier, letting the branch with default.
     *
     * @param code a full LT address code (12 characters) or a BIC8, BIC11 or BIC8 plus LT identifier
     */
    public LogicalTerminalAddress(final String code) {
        if (code != null) {
            setInstitution(StringUtils.trimToNull(StringUtils.substring(code, 0, 4)));
            setCountry(StringUtils.trimToNull(StringUtils.substring(code, 4, 6)));
            setLocation(StringUtils.trimToNull(StringUtils.substring(code, 6, 8)));
            if (code.length() > 8) {
                // after the BIC 8 we expect the LT, the LT + branch o just the branch
                if (code.length() == 9) {
                    // if it has just 9 characters we assume it is a BIC8 plus the LT without branch
                    this.lTIdentifier = code.charAt(8);
                } else if (code.length() >= 12) {
                    // for 12 or more characters we extract both the LT and the branch
                    this.lTIdentifier = code.charAt(8);
                    super.branch = StringUtils.trimToNull(StringUtils.substring(code, 9));
                } else {
                    // otherwise we take the part after the BIC8 as the branch
                    super.branch = StringUtils.trimToNull(StringUtils.substring(code, 8));
                }
            }
        }
    }

    public Character getLTIdentifier() {
        return lTIdentifier;
    }

    public void setLTIdentifier(final Character _lTIdentifier) {
        lTIdentifier = _lTIdentifier;
    }

    /**
     * Returns a proper LT address for the sender of a message, assuring
     * the returned code has 12 characters and with no "X" in the 9th position.
     *
     * <p>If the terminal identifier is not set or if it is set to "X", then
     * the default identifier "A" will be used.
     *
     * <p>The branch code is padded with "XXX" if not present.
     *
     * @return the 12 characters address or null if the BIC has less than 8 characters
     */
    public String getSenderLogicalTerminalAddress() {
        char LT = this.lTIdentifier == null || this.lTIdentifier.equals('X') ? 'A' : this.lTIdentifier;
        if (getBic8() != null) {
            return getBic8() + LT + getBranchOrDefault();
        }
        return null;
    }

    /**
     * Returns a proper LT address for the receiver of a message, assuring
     * the returned code has 12 characters and with a fixed "X" in the 9th position.
     *
     * <p>The branch code is padded with "XXX" if not present.
     *
     * @return the 12 characters address or null if the BIC has less than 8 characters
     */
    public String getReceiverLogicalTerminalAddress() {
        if (getBic8() != null) {
            return getBic8() + "X" + getBranchOrDefault();
        }
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        LogicalTerminalAddress that = (LogicalTerminalAddress) o;
        return Objects.equals(lTIdentifier, that.lTIdentifier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), lTIdentifier);
    }
}
