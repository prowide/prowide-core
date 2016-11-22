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
 * SWIFT business process classification for MX messages.
 *
 * @author www.prowidesoftware.com
 * @since 7.0
 */
public enum MxBusinessProcess {
	acmt("Account Management"),
	admi("Administration"),
	auth("Authorities"),
	caaa("Acceptor to Acquirer Card Transactions"),
	caam("ATM Management"),
	camt("Cash Management"),
	catm("Terminal Management"),
	catp("ATM Card Transactions"),
	colr("Collateral Management"),
	fxtr("Foreign Exchange Trade"),
	defp("Derivatives"),
	head("Business Application Header"),
	pacs("Payments Clearing and Settlement"),
	pain("Payments Initiation"),
	reda("Reference Data"),
	secl("Securities Clearing"),
	seev("Securities Events"),
	semt("Securities Management"),
	sese("Securities Settlement"),
	seti("Securities Trade Initiation"),
	setr("Securities Trade"),
	supl("Suplementary Data"),
	trea("Treasury"),
	tsin("Trade Services Initiation"),
	tsmt("Trade Services Management"),
	tsrv("Trade Services");

	private String description = null;

	private MxBusinessProcess(final String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
}
