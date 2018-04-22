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

import com.google.gson.annotations.SerializedName;

/**
 * SWIFT character sets named after the User Handbook.
 *
 * @author www.prowidesoftware.com
 */
public enum SwiftCharset {
	@SerializedName("n")n,
	@SerializedName("a")a,
	@SerializedName("A")A,
	@SerializedName("x")x,
	@SerializedName("y")y,
	@SerializedName("z")z,
	@SerializedName("c")c,
	@SerializedName("B")B
}
