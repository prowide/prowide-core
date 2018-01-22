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
package com.prowidesoftware.swift.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * BIC model testing
 *
 * @author www.prowidesoftware.com
 *
 */
public class BICTest {

	@Test 
	public void testIsValid() {
		final BIC b = new BIC("foo");
		final boolean valid = b.isValid();
		assertFalse(valid);
	}

	@Test 
	public void testIsValid2() {
		final BIC b = new BIC("FOOOESHU");
		final boolean valid = b.isValid();
		assertTrue(valid);
	}

	@Test
	public void testIsValid3() {
		final BIC b = new BIC("CARBVEC0XX");
		final boolean valid = b.isValid();
		assertTrue(valid);
	}

	@Test 
	public void testIsValidBadCountry() {
		final BIC b = new BIC("FOOOAAHU");
		final boolean valid = b.isValid();
		assertFalse(valid);
	}

	@Test
	public void testIsValidAlphanumeric() {
		final BIC b = new BIC("FO-OAR11");
		final boolean valid = b.isValid();
		assertFalse(valid);
	}

	@Test
	public void testIsValidUppercase() {
		final BIC b = new BIC("FOoOAR12");
		final boolean valid = b.isValid();
		assertFalse(valid);
	}

	@Test 
	public void testGetBranch1() {
		final BIC b = new BIC("FOOOOOHU");
		assertNull(b.getBranch());
	}

	@Test 
	public void testGetBranch2() {
		final BIC b = new BIC("FOOOOOHUABC");
		assertEquals("ABC", b.getBranch());
	}

	@Test 
	public void testGetBranch3() {
		final BIC b = new BIC("FOOOOOHUAB");
		assertNull(b.getBranch());
	}

	/*
	 * bic de 12 con LT
	 */
	@Test 
	public void testGetBranchBIC12() {
		final BIC b = new BIC("FOOOOOHUABCD");
		assertEquals("BCD", b.getBranch());
		assertEquals("FOOOOOHUBCD", b.getBic11());
	}
	
	@Test 
	public void testTestAndTraining() {
		assertTrue(new BIC("FOOOOO00AB").isTestAndTraining());
		assertFalse(new BIC("").isTestAndTraining());
		assertFalse(new BIC("FOOOOOAUAB").isTestAndTraining());
	}

	@Test 
	public void testBIC8() {
		assertEquals("FOOOOOHU", new BIC("FOOOOOHUAXXX").getBic8());
		assertEquals("FOOOOOHU", new BIC("FOOOOOHUXXX").getBic8());
		assertEquals("FOOOOOHU", new BIC("FOOOOOHU").getBic8());
		assertNull(new BIC("FOO").getBic8());
	}

	@Test 
	public void testBIC11() {
		assertEquals("FOOOOOHUXXX", new BIC("FOOOOOHUAXXX").getBic11());
		assertEquals("FOOOOOHUXXX", new BIC("FOOOOOHUXXX").getBic11());
		assertEquals("FOOOOOHUXXX", new BIC("FOOOOOHU").getBic11());
		assertNull(new BIC("FOO").getBic8());
	}

	@Test
	public void testCountry() {
		assertEquals("AR", new BIC("BACOARB10BE").country());
	}

	@Test
	public void testDistinguishedName() {
		assertEquals("o=bacoarb1,o=swift", new BIC("BACOARB1").distinguishedName());
		assertEquals("o=bacoarb1,o=swift", new BIC("BACOARB1XXX").distinguishedName());
		assertEquals("ou=0be,o=bacoarb1,o=swift", new BIC("BACOARB10BE").distinguishedName());
	}

}
