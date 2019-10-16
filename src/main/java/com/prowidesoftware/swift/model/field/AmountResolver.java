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
package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Helper API to detect amount component in fields.
 */
public class AmountResolver {
	private static final Logger log = Logger.getLogger(AmountResolver.class.getName());
	
	/**
	 * Gets the amounts of the given field by reading it's components pattern.
	 * All index of 'N', number, in the pattern are looked for and returned as amount.
	 * 
	 * <em>See the returns notes</em>
	 *
	 * @param f the field where to extract the amounts, must not be null
	 *
	 * @return a list of BigDecimal with the numbers found in the numeric components or an empty list if none is found.
	 * Missing or invalid numeric components are ignored; meaning if a components expected to be a number is not present 
	 * or it is not a valid number or Field.getComponent(index,Number.class) fails, that component is not included in the
	 * result list.
	 * 
	 * @see Field#getComponentAs(int, Class)
	 * @since 7.8.9
	 */
	public static List<BigDecimal> amounts(final Field f) {
		Validate.notNull(f);
		List<BigDecimal> amounts = new ArrayList<>();
		int i = StringUtils.indexOf(f.componentsPattern(), 'N');
		while (i >= 0) {
			BigDecimal amount = amount(f, i+1);
			if (amount != null) {
				amounts.add(amount);
			}
			i = StringUtils.indexOf(f.componentsPattern(), 'N', i+1);
		}
		return amounts;
	}

	/**
	 * Gets the amount of the given field by reading it's components pattern.
	 * The first index of 'N', number, is returned as amount.
	 * 
	 * <em>See the returns notes</em>
	 *
	 * @param f the field where to extract the amount, must not be null
	 *
	 * @return a BigDecimal with the number found in the first numeric component or null if there is
	 * 	no numeric component in the field. It may also return null if Field.getComponent(index,Number.class) fails
	 * 	for that component
	 * 
	 * @see Field#getComponentAs(int, Class)
	 * @since 7.8
	 */
	public static BigDecimal amount(final Field f) {
		Validate.notNull(f);
		final int i = StringUtils.indexOf(f.componentsPattern(), 'N');
		if (i >= 0) {
			return amount(f, i+1);
		}
		return null;
	}
	
	/**
	 * Returns the indicated component as BigDecimal
	 * @param f the field
	 * @param component a component number (1 based)
	 * @return the BigDecimal for the amount or null if component is not found or is not a Number
	 * @since 7.8.9
	 */
	private static BigDecimal amount(final Field f, int component) {
		final Number n = (Number) f.getComponentAs(component, Number.class);
		if (n == null) {
			log.warning("getComponentAs("+(component)+", Number.class) returned null for field "+f);
			return null;
		}
		return new BigDecimal(n.toString());
	}
}
