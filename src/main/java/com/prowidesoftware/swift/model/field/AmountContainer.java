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
package com.prowidesoftware.swift.model.field;

import java.math.BigDecimal;


/**
 * Interface to mark fields whose definition contain an amount.
 * Note that if a field has a amount and it is optional, and the actual 
 * field has not set the optional amounts/ies then
 * the call amounts() will return an empty list
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public interface AmountContainer {

	/**
	 * Get the first amount in this field.
	 */
	BigDecimal amount();
}
