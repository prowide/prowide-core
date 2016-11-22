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
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import com.prowidesoftware.swift.DeleteSchedule;

public class AmountResolver {
	private static final Logger log = Logger.getLogger(AmountResolver.class.getName());
	
	@DeleteSchedule()
	public static List<BigDecimal> amounts(final Field f, final int ... component) {
		return null;
	}

	/**
	 * get the amount of the given field by reading it's components pattern.
	 * The first index of 'N', number, is returned as amount.
	 * <em>See the returns notes</em>
	 *
	 * @param f the field where to extract the amount, must not be null
	 *
	 * @return a BigDecimal with the number found in the first numeric component or <code>null</code> if there is 
	 * 	no numeric component in the field. It may also return null if Field.getComponent(index,Number.class) fails
	 * 	for that component
	 * @see Field#getComponentAs(int, Class)
	 * @since 7.8
	 */
	public static BigDecimal amount(final Field f) {
		Validate.notNull(f);
		final int i = StringUtils.indexOf(f.componentsPattern(), 'N');
		if (i>=0) {
			final Number n = (Number) f.getComponentAs(i+1, Number.class);
			if (n == null) {
				log.warning("getComponentAs("+(i+1)+", Number.class) returned null for field "+f);
				return null;
			}
			return new BigDecimal(n.toString());
		}
		return null;
	}
}
