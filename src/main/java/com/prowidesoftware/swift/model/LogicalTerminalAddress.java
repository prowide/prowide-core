/*
 * Copyright 2006-2018 Prowide
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

/**
 * Identifies a logical channel connection to SWIFT, and the network uses it
 * for addressing. It is composed by the BIC code, an optional terminal
 * identifier (A, B or C) if the institution has more than one terminal,
 * and the branch (padded with "X" if no branch is used). 
 * For example BFOOARBSAXXX or BFOOARBSXXX.<br>
 * 
 * A sender LT address cannot have 'X' as LT identifier, conversely a
 * receiver LT address must have an 'X' as LT identifier.
 * 
 * @author www.prowidesoftware.com
 * @since 7.6
 */
public class LogicalTerminalAddress extends BIC {
	private Character LTIdentifier;
	
	/**
	 * Creates an LT address from its string value.
	 * <p>If the string contains a BIC8 or BIC11 the LT identifier will be set with a default value.
	 * 
	 * @param code a full LT address code (12 characters) or a BIC8 or BIC11
	 */
	public LogicalTerminalAddress(final String code) {
		super(code);
		if (code != null && code.length() >=12) {
			this.LTIdentifier = code.charAt(8);
		}
	}

	public Character getLTIdentifier() {
		return LTIdentifier;
	}

	public void setLTIdentifier(final Character lTIdentifier) {
		LTIdentifier = lTIdentifier;
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
		char LT = (this.LTIdentifier == null || this.LTIdentifier.equals('X'))? 'A' : this.LTIdentifier;
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
		return Objects.equals(LTIdentifier, that.LTIdentifier);
	}

	@Override
	public int hashCode() {
		return Objects.hash(super.hashCode(), LTIdentifier);
	}
}
