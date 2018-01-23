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
 * 
 */
package com.prowidesoftware.swift.model.field;

import static org.junit.Assert.assertFalse;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;
import org.junit.Test;

import com.prowidesoftware.swift.model.Tag;

public class Field11STest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("11S",
				"195\n121212"
			);
	}
	
	@Test
	public void testSerialization2() throws Exception {
		Field11S field11s = new Field11S();
		field11s.setComponent1("195");
		field11s.setComponent2(Calendar.getInstance());
		field11s.setComponent3(2);
		Tag tag = field11s.asTag();
		String val = tag.getValue();
		assertFalse(StringUtils.isBlank(val));
	}
	
}