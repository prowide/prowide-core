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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import java.util.ArrayList;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

/**
 * Block3 tests.
 * 
 * @author sebastian
 * @since 7.8.8
 */
public class SwiftBlock3Test {

	@Test
	public void testGenerateMUR() throws InterruptedException {
		SwiftBlock3 b = new SwiftBlock3();
		assertNull(b.getTagByName("108"));
		b.generateMUR(true);
		assertNotNull(b.getTagByName("108"));
		final String current = b.getTagByName("108").getValue();
		b.generateMUR(false);
		assertEquals(current, b.getTagByName("108").getValue());
		Thread.sleep(500);
		b.generateMUR(true);
		assertFalse("expected a different MUR after generateMUR(true)", StringUtils.equals(current, b.getTagByName("108").getValue()));
	}

	@Test
	public void testIsSTP() {
		SwiftBlock3 b = new SwiftBlock3();
		assertFalse(b.isSTP());
		b.append(new Tag("119", "STP"));
		assertTrue(b.isSTP());
	}

}
