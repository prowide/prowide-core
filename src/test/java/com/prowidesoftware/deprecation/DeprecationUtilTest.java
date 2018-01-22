/* 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
*/
package com.prowidesoftware.deprecation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.prowidesoftware.deprecation.DeprecationUtils.EnvironmentVariableKey;

/**
 * Test cases for the deprecation policy implementation
 * 
 * @author sebastian
 * @since 7.8.9
 */
public class DeprecationUtilTest {

	/**
	 * Default behavior
	 */
	@Test
	public void testPhase2_default() {
		long t0 = System.currentTimeMillis();
		DeprecationUtils.phase2(this.getClass(), "method", "phase 2 message");
		long t1 = System.currentTimeMillis();
		long diff = t1-t0;
		assertTrue(diff >= 4000);
	}
	
	/**
	 * Log and delay switched off
	 */
	@Test
	public void testPhase2_off() {
		DeprecationUtils.setEnv(EnvironmentVariableKey.NOLOG, EnvironmentVariableKey.NODELAY);
		long t0 = System.currentTimeMillis();
		DeprecationUtils.phase2(this.getClass(), null, "another phase 2 message");
		long t1 = System.currentTimeMillis();
		assertTrue((t1-t0) < 4000);
		DeprecationUtils.clearEnv();
	}

	/**
	 * Default behavior
	 */
	@Test(expected=UnsupportedOperationException.class)
	public void testPhase3_default() {
		DeprecationUtils.phase3(this.getClass(), null, "phase 3 message");
	}
	
	/**
	 * Exception switched off
	 */
	@Test
	public void testPhase3_off() {
		DeprecationUtils.setEnv(EnvironmentVariableKey.NOLOG, EnvironmentVariableKey.NODELAY, EnvironmentVariableKey.NOEXCEPTION);
		DeprecationUtils.phase3(this.getClass(), null, "phase 3 message");
		DeprecationUtils.clearEnv();
	}

}
