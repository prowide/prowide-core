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

import com.prowidesoftware.swift.model.field.Field106;
import com.prowidesoftware.swift.model.field.Field108;
import com.prowidesoftware.swift.model.field.Field121;
import com.prowidesoftware.swift.model.field.Field165;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import static org.junit.Assert.*;

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

	@Test
	public void testBuilder() {
		SwiftBlock3 b = new SwiftBlock3();
		b.builder()
				.setField121(new Field121("foo"))
				.setField106(new Field106("foo"))
				.setField165(new Field165("foo"))
				.setField106(new Field106("finalValue106"))
				.setField108(new Field108("foo"));
		assertEquals(Field108.NAME, b.getTags().get(0).getName());
		assertEquals(Field106.NAME, b.getTags().get(1).getName());
		assertEquals(Field121.NAME, b.getTags().get(2).getName());
		assertEquals(Field165.NAME, b.getTags().get(3).getName());
		assertEquals(4, b.getTags().size());
		assertEquals("finalValue106", b.getTagValue(Field106.NAME));
	}

}
