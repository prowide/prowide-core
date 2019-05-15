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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * BIC model testing
 *
 */
public class BICTest {

	@Test
	public void testParse() {
		BIC b = new BIC(null);
		assertNull(b.getInstitution());
		assertNull(b.getCountry());
		assertNull(b.getLocation());
		assertNull(b.getBranch());
		b = new BIC("");
		assertNull(b.getInstitution());
		assertNull(b.getCountry());
		assertNull(b.getLocation());
		assertNull(b.getBranch());
		b = new BIC("I");
		assertEquals("I", b.getInstitution());
		assertNull(b.getCountry());
		assertNull(b.getLocation());
		assertNull(b.getBranch());
		b = new BIC("IIII");
		assertEquals("IIII", b.getInstitution());
		assertNull(b.getCountry());
		assertNull(b.getLocation());
		assertNull(b.getBranch());
		b = new BIC("IIIIC");
		assertEquals("IIII", b.getInstitution());
		assertEquals("C", b.getCountry());
		assertNull(b.getLocation());
		assertNull(b.getBranch());
		b = new BIC("IIIICC");
		assertEquals("IIII", b.getInstitution());
		assertEquals("CC", b.getCountry());
		assertNull(b.getLocation());
		assertNull(b.getBranch());
		b = new BIC("IIIICCL");
		assertEquals("IIII", b.getInstitution());
		assertEquals("CC", b.getCountry());
		assertEquals("L", b.getLocation());
		assertNull(b.getBranch());
		b = new BIC("IIIICCLL");
		assertEquals("IIII", b.getInstitution());
		assertEquals("CC", b.getCountry());
		assertEquals("LL", b.getLocation());
		assertNull(b.getBranch());
		b = new BIC("IIIICCLLB");
		assertEquals("IIII", b.getInstitution());
		assertEquals("CC", b.getCountry());
		assertEquals("LL", b.getLocation());
		assertEquals("B", b.getBranch());
		b = new BIC("IIIICCLLBBBBBB");
		assertEquals("IIII", b.getInstitution());
		assertEquals("CC", b.getCountry());
		assertEquals("LL", b.getLocation());
		assertEquals("BBBBB", b.getBranch()); //one B is dropped as LT identifier
	}

	@Test 
	public void testIsValid() {
		final BIC b = new BIC("foo");
		assertFalse(b.isValid());
		assertEquals(BicValidationResult.INVALID_LENGTH, b.validate());
	}

	@Test 
	public void testIsValid2() {
		final BIC b = new BIC("FOOOESHU");
		assertTrue(b.isValid());
		assertEquals(BicValidationResult.OK, b.validate());
	}

	@Test
	public void testIsValid3() {
		final BIC b = new BIC("FOOBAR22XXX");
		final boolean valid = b.isValid();
		assertTrue(valid);
	}

	@Test
	public void testIsValid4() {
		final BIC b = new BIC("AZADAEKWXXX");
		BicValidationResult result = b.validate();
		assertEquals(BicValidationResult.OK, result);
	}

	@Test 
	public void testIsValidBadCountry() {
		final BIC b = new BIC("FOOOAAHU");
		assertFalse(b.isValid());
		assertEquals(BicValidationResult.INVALID_COUNTRY, b.validate());
	}

	@Test
	public void testIsValidAlphanumeric() {
		final BIC b = new BIC("FO-OAR11");
		assertFalse(b.isValid());
		assertEquals(BicValidationResult.INVALID_INSTITUTION_CHARSET, b.validate());
	}

	@Test
	public void testIsValidUppercase() {
		final BIC b = new BIC("FOoOAR12");
		assertFalse(b.isValid());
		assertEquals(BicValidationResult.INVALID_INSTITUTION_CHARSET, b.validate());
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
		assertEquals("FOOOOOHUXXX", new BIC("FOOOOOHUAXXX").getBic11()); //LT is picked up as part of the branch
		assertEquals("FOOOOOHUXXX", new BIC("FOOOOOHUXXX").getBic11());
		assertEquals("FOOOOOHUXXX", new BIC("FOOOOOHU").getBic11());
		assertNull(new BIC("FOO").getBic8());
	}

	@Test
	public void testDistinguishedName() {
		assertEquals("o=bacoarb1,o=swift", new BIC("BACOARB1").distinguishedName());
		assertEquals("o=bacoarb1,o=swift", new BIC("BACOARB1XXX").distinguishedName());
		assertEquals("ou=0be,o=bacoarb1,o=swift", new BIC("BACOARB10BE").distinguishedName());
	}

}
