/*******************************************************************************
 * Copyright (c) 2016 Prowide Inc.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as 
 *     published by the Free Software Foundation, either version 3 of the 
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 *     
 *     Check the LGPL at <http://www.gnu.org/licenses/> for more details.
 *******************************************************************************/
package com.prowidesoftware.swift.model;

/**
 * Identifies a logical channel connection to SWIFT, and the network uses it
 * for addressing. It is composed by the BIC code, an optional terminal
 * identifier (A, B or C) if the institution has more than one terminal,
 * and the branch (padded with "X" if no branch is used). 
 * For example BFOOARBSAXXX or BFOOARBSXXX.<br />
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
	 * 
	 * @param code a 12 characters string containing the full LT address code
	 */
	public LogicalTerminalAddress(final String code) {
		super(code);
		if (code.length() == 12) {
			this.LTIdentifier = code.charAt(8);
		}
	}

	public Character getLTIdentifier() {
		return LTIdentifier;
	}

	public void setLTIdentifier(Character lTIdentifier) {
		LTIdentifier = lTIdentifier;
	}
	
	/**
	 * Returns a proper LT address for the sender of a message, assuring
	 * the returned code has 12 characters and with no "X" in the 9th position.<br />
	 * 
	 * If the terminal identifier is not set or if it is set to "X", then 
	 * the default identifier "A" will be used.<br />
	 * 
	 * The branch code is padded with "XXX" if not present. 
	 * 
	 * @return the 12 characters address or null if the BIC has less than 8 characters
	 */
	public String getSenderLogicalTerminalAddress() {
		Character LT = (this.LTIdentifier == null || this.LTIdentifier.equals('X'))? 'A' : this.LTIdentifier;
		String branch = getBranch() != null? getBranch() : "XXX";
		if (getBic8() != null) {
			return getBic8() + LT + branch;
		}
		return null;
	}
	
	/**
	 * Returns a proper LT address for the sender of a message, assuring
	 * the returned code has 12 characters and with a fixed "X" in the 9th position.<br />
	 * 
	 * The branch code is padded with "XXX" if not present. 
	 * 
	 * @return the 12 characters address or null if the BIC has less than 8 characters
	 */
	public String getReceiverLogicalTerminalAddress() {
		String branch = getBranch() != null? getBranch() : "XXX";
		if (getBic8() != null) {
			return getBic8() + "X" + branch;
		}
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((LTIdentifier == null) ? 0 : LTIdentifier.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LogicalTerminalAddress other = (LogicalTerminalAddress) obj;
		if (LTIdentifier == null) {
			if (other.LTIdentifier != null)
				return false;
		} else if (!LTIdentifier.equals(other.LTIdentifier))
			return false;
		return true;
	}

}
