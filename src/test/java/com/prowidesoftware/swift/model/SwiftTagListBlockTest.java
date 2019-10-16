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

import com.prowidesoftware.swift.io.ConversionService;
import com.prowidesoftware.swift.model.field.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Tag list block tests.
 *
 * @since 4.0
 */
public class SwiftTagListBlockTest {

	private SwiftTagListBlock b;
	private Tag t;

	@Before
	public void setUp() {
		this.b = new SwiftBlock3();
		this.t = new Tag("n:v");
	}
	
	@Test
	public void testContainsTag() {
		b.append(t);
		assertTrue(b.containsTag("n"));
	}
	
	@Test
	public void testCountStartsWith() {
		b.append(new Tag("1", "FOO"));
		b.append(new Tag("1", "BAR"));
		b.append(new Tag("1", "FOO2"));
		b.append(new Tag("1", "FOO"));
		
		b.append(new Tag("2", "FOO"));
		b.append(new Tag("2", "BAR"));
		b.append(new Tag("2", "FOO2"));
		b.append(new Tag("2", "FOO"));
		
		b.append(new Tag("1", "FOO"));
		b.append(new Tag("1", "BAR"));
		b.append(new Tag("1", "FOO2"));
		b.append(new Tag("1", "FOO"));
		
		assertEquals(6, b.countTagsStarsWith("1", "FOO"));
		assertEquals(2, b.countTagsStarsWith("1", "FOO2"));
	}

	@Test
	public void testContainsAll() {
		b.append(t);
		b.append(new Tag("1", "val"));
		assertTrue(b.containsAllOf(t.getName(), "1"));
		assertFalse(b.containsAllOf(t.getName(), "2"));
	}

	@Test
	public void testGetTagValue() {
		b.append(t);
		assertEquals("v", b.getTagValue("n"));
	}

	@Test
	public void testGetTagByName() {
		b.append(t);
		Tag found = b.getTagByName("n");
		assertEquals(t, found);
	}

	@Test
	public void testIsEmpty() {
		assertTrue(b.isEmpty());
		b.append(t);
		assertFalse(b.isEmpty());
	}

	@Test
	public void testSize() {
		assertEquals(0, b.size());
		b.append(t);
		assertEquals(1, b.size());
	}

	@Test
	public void testGetTagCount() {
		assertEquals(0, b.countAll());
		b.append(t);
		assertEquals(1, b.countAll());
	}

	@Test
	public void testGetTagCountString() {
		b.append(t);
		b.append(t);
		b.append(t);
		assertEquals(3, b.countByName("n"));
	}

	@Test
	public void testGetTagValues() {
		Tag t = new Tag("1:val1");
		b.append(t);
		
		String[] vals = b.getTagValues("foo");
		assertNotNull(vals);
		assertEquals(0, vals.length);
	}

	@Test
	public void testGetTagMap() {
		Map<String, String> m = b.getTagMap();
		assertTrue(m.isEmpty());
		
		b.append(t);
		m = b.getTagMap();
		
		assertEquals(1, m.size());
		assertTrue(m.containsKey("n"));
		assertTrue(m.containsValue("v"));
	}

	@Test
	public void testRemoveTag() {
		b.removeTag("");
		assertTrue(b.isEmpty());
		b.append(t);
		assertFalse(b.isEmpty());
		b.removeTag("n");
		assertTrue(b.isEmpty());
	}

	@Test
	public void testTagIterator() {
		b.getTags().clear();
		Iterator<Tag> it = b.tagIterator();
		assertFalse(it.hasNext());
		
		b.append(t);
		assertEquals(t, b.tagIterator().next());
	}

	@Test
	public void testIsTagBlock() {
		assertTrue(b.isTagBlock());
	}

	@Test
	public void testGetTagValuesEmpty2() {
		String[] vals = b.getTagValues("foo");
		assertNotNull(vals);
		assertEquals(0, vals.length);
	}

	@Test
	public void testGetTagValues1() {
		Tag t = new Tag("1:val1");
		b.append(t);
		
		String[] vals = b.getTagValues("1");
		assertNotNull(vals);
		assertEquals(1, vals.length);
		assertEquals("val1", vals[0]);
	}
	
	@Test
	public void testGetTagValues2() {
		b.append(new Tag("1:val1"));
		b.append(new Tag("1:val2"));
		
		String[] vals = b.getTagValues("1");
		assertNotNull(vals);
		assertEquals(2, vals.length);
		assertEquals("val1", vals[0]);
		assertEquals("val2", vals[1]);
	}

	@Test
	public void testRemoveAll1() {
		b.append(new Tag("1:val1"));
		b.append(new Tag("1:val2"));
		
		int vals = b.removeAll("1");
		assertEquals(2, vals);
	}

	@Test
	public void testRemoveAll2() {
		b.append(new Tag("a:val1"));
		b.append(new Tag("1:val1"));
		b.append(new Tag("b:val1"));
		b.append(new Tag("1:val1"));
		b.append(new Tag("c:val2"));
		
		int vals = b.removeAll("1");
		assertEquals(2, vals);
	}

	@Test
	public void testgetTagsByName() {
		b.append(new Tag("a:val1"));
		b.append(new Tag("1:val1"));
		b.append(new Tag("b:val1"));
		b.append(new Tag("1:val2"));
		b.append(new Tag("c:val3"));
		
		Tag[] tags = b.getTagsByName("1");
		assertEquals(2, tags.length);
		assertEquals("val1", tags[0].getValue());
		assertEquals("val2", tags[1].getValue());
	}
	
	@Test
	public void testgetTagsByValue() {
		b.append(new Tag("a:val1"));
		b.append(new Tag("1:val1"));
		b.append(new Tag("1:val2"));
		b.append(new Tag("c:val3"));
		b.append(new Tag("b:val1"));
		List<Tag> tags = b.getTagsByValue("val1");
		
		assertEquals(3, tags.size());
		assertEquals("a", tags.get(0).getName());
		assertEquals("1", tags.get(1).getName());
		assertEquals("b", tags.get(2).getName());
	}
	
	@Test
	public void testgetTagsByContent() {
		b.append(new Tag("a:val1aaa"));
		b.append(new Tag("1:dddval1"));
		b.append(new Tag("1:val2"));
		b.append(new Tag("c:val3"));
		b.append(new Tag("b:ffval1gg"));
		List<Tag> tags = b.getTagsByContent("val1");
		
		assertEquals(3, tags.size());
		assertEquals("a", tags.get(0).getName());
		assertEquals("1", tags.get(1).getName());
		assertEquals("b", tags.get(2).getName());
	}
	
	/**
	 * Normal test with starting and ending tag
	 */
	@Test
	public void testgetSubBlock01() {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		
		SwiftTagListBlock sb = b.getSubBlock(new Tag("2:val2"), new Tag("4:val4"));
		
		assertEquals(3, sb.size());
		assertEquals("2", sb.getTag(0).getName());
		assertEquals("3", sb.getTag(1).getName());
		assertEquals("4", sb.getTag(2).getName());
		assertEquals("val2", sb.getTag(0).getValue());
		assertEquals("val3", sb.getTag(1).getValue());
		assertEquals("val4", sb.getTag(2).getValue());
	}
	
	/**
	 * Normal test with no ending tag
	 */
	@Test
	public void testgetSubBlock02() {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		
		SwiftTagListBlock sb = b.getSubBlock(new Tag("2:val2"), null);
		
		assertEquals(4, sb.size());
		assertEquals("2", sb.getTag(0).getName());
		assertEquals("3", sb.getTag(1).getName());
		assertEquals("4", sb.getTag(2).getName());
		assertEquals("5", sb.getTag(3).getName());
		assertEquals("val2", sb.getTag(0).getValue());
		assertEquals("val3", sb.getTag(1).getValue());
		assertEquals("val4", sb.getTag(2).getValue());
		assertEquals("val5", sb.getTag(3).getValue());
	}
	
	/**
	 * Normal test using block names
	 */
	@Test
	public void testgetSubBlock03() {
		b.append(new Tag("1:val1"));
		b.append(new Tag("16R:foo"));
		b.append(new Tag("3:val3"));
		b.append(new Tag("16S:foo"));
		b.append(new Tag("5:val5"));
		
		SwiftTagListBlock sb = b.getSubBlock("foo");
		
		assertEquals(3, sb.size());
		assertEquals("16R", sb.getTag(0).getName());
		assertEquals("3", sb.getTag(1).getName());
		assertEquals("16S", sb.getTag(2).getName());
		assertEquals("foo", sb.getTag(0).getValue());
		assertEquals("val3", sb.getTag(1).getValue());
		assertEquals("foo", sb.getTag(2).getValue());
	}
	
	/**
	 * Test using block name, with nested sub blocks
	 */
	@Test
	public void testgetSubBlock04() {
		b.append(new Tag("1:val1"));
		b.append(new Tag("16R:foo"));
		b.append(new Tag("3:val3"));
		b.append(new Tag("16R:aaa"));
		b.append(new Tag("3:val3"));
		b.append(new Tag("16S:aaa"));
		b.append(new Tag("16S:foo"));
		b.append(new Tag("5:val5"));
		
		SwiftTagListBlock sb = b.getSubBlock("foo");
		
		assertEquals(6, sb.size());
		
		assertEquals("16R", sb.getTag(0).getName());
		assertEquals("foo", sb.getTag(0).getValue());

		assertEquals("3", sb.getTag(1).getName());
		assertEquals("val3", sb.getTag(1).getValue());

		assertEquals("16R", sb.getTag(2).getName());
		assertEquals("aaa", sb.getTag(2).getValue());
		
		assertEquals("3", sb.getTag(3).getName());
		assertEquals("val3", sb.getTag(3).getValue());
		
		assertEquals("16S", sb.getTag(4).getName());
		assertEquals("aaa", sb.getTag(4).getValue());
		
		assertEquals("16S", sb.getTag(5).getName());
		assertEquals("foo", sb.getTag(5).getValue());
	}
	
	/**
	 * Ending tag precedes starting tag
	 */
	@Test
	public void testgetSubBlock05() {
		b.append(new Tag("1:val1"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("3:val3"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("5:val5"));
		
		SwiftTagListBlock sb = b.getSubBlock(new Tag("2:val2"), new Tag("4:val4"));
		
		assertEquals(2, sb.size());
		assertEquals("2", sb.getTag(0).getName());
		assertEquals("val2", sb.getTag(0).getValue());
		assertEquals("5", sb.getTag(1).getName());
		assertEquals("val5", sb.getTag(1).getValue());
	}
	
	/**
	 * Normal test with starting and ending tag and multiple sub blocks
	 */
	@Test
	public void testgetSubBlock06() {
		b.append(new Tag("99:foo"));
		b.append(new Tag("1:start"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3:end"));
		b.append(new Tag("88:foo"));
		b.append(new Tag("1:start"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("3:end"));
		b.append(new Tag("77:foo"));
		
		List<SwiftTagListBlock> sbs = b.getSubBlocks(new Tag("1:start"), new Tag("3:end"));
		
		assertEquals(2, sbs.size());

		SwiftTagListBlock sb = sbs.get(0);
		assertEquals(3, sb.size());
		assertEquals("1", sb.getTag(0).getName());
		assertEquals("start", sb.getTag(0).getValue());
		assertEquals("2", sb.getTag(1).getName());
		assertEquals("val2", sb.getTag(1).getValue());
		assertEquals("3", sb.getTag(2).getName());
		assertEquals("end", sb.getTag(2).getValue());
		
		SwiftTagListBlock sb2 = sbs.get(1);
		assertEquals(3, sb2.size());
		assertEquals("1", sb2.getTag(0).getName());
		assertEquals("start", sb2.getTag(0).getValue());
		assertEquals("4", sb2.getTag(1).getName());
		assertEquals("val4", sb2.getTag(1).getValue());
		assertEquals("3", sb2.getTag(2).getName());
		assertEquals("end", sb2.getTag(2).getValue());
	}
	
	@Test
	public void testSplit() {
		b.append(new Tag("99:foo"));
		
		b.append(new Tag("1:start"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3:end"));
		b.append(new Tag("88:foo"));
		
		b.append(new Tag("1:start"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("3:end"));
		b.append(new Tag("77:foo"));
		b.append(new Tag("77:foo"));
		
		List<SwiftTagListBlock> sbs = b.splitByTagName("1");
		
		assertEquals(3, sbs.size());

		SwiftTagListBlock sb = sbs.get(0);
		assertEquals(1, sb.size());
		assertEquals("99", sb.getTag(0).getName());
		
		SwiftTagListBlock sb2 = sbs.get(1);
		assertEquals(4, sb2.size());

		SwiftTagListBlock sb3 = sbs.get(2);
		assertEquals(5, sb3.size());
	}
	
	@Test
	public void testSplitByNonexisting() {
		b.append(new Tag("99:foo"));
		b.append(new Tag("1:start"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3:end"));
		b.append(new Tag("88:foo"));
		
		List<SwiftTagListBlock> sbs = b.splitByTagName("XX");
		
		assertEquals(1, sbs.size());
		assertEquals(5, sbs.get(0).size());
	}
	
	/**
	 * Normal test using block name and multiple sub blocks
	 */
	@Test
	public void testgetSubBlock07() {
		b.append(new Tag("99:foo"));
		b.append(new Tag("16R:blockname"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("16S:blockname"));
		b.append(new Tag("88:foo"));
		b.append(new Tag("16R:blockname"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("16S:blockname"));
		b.append(new Tag("77:foo"));
		
		List<SwiftTagListBlock> sbs = b.getSubBlocks("blockname");
		
		assertEquals(2, sbs.size());

		SwiftTagListBlock sb = sbs.get(0);
		assertEquals(3, sb.size());
		assertEquals("16R", sb.getTag(0).getName());
		assertEquals("blockname", sb.getTag(0).getValue());
		assertEquals("2", sb.getTag(1).getName());
		assertEquals("val2", sb.getTag(1).getValue());
		assertEquals("16S", sb.getTag(2).getName());
		assertEquals("blockname", sb.getTag(2).getValue());
		
		SwiftTagListBlock sb2 = sbs.get(1);
		assertEquals(3, sb2.size());
		assertEquals("16R", sb2.getTag(0).getName());
		assertEquals("blockname", sb2.getTag(0).getValue());
		assertEquals("4", sb2.getTag(1).getName());
		assertEquals("val4", sb2.getTag(1).getValue());
		assertEquals("16S", sb2.getTag(2).getName());
		assertEquals("blockname", sb2.getTag(2).getValue());
	}
	
	/**
	 * Test using block name and multiple sub blocks, with nested sub blocks
	 */
	@Test
	public void testgetSubBlock08() {
		b.append(new Tag("99:foo"));
		b.append(new Tag("16R:blockname"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("16S:blockname"));
		b.append(new Tag("88:foo"));
		b.append(new Tag("16R:blockname"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("16R:foo"));
		b.append(new Tag("66:foo"));
		b.append(new Tag("16S:foo"));
		b.append(new Tag("16S:blockname"));
		b.append(new Tag("77:foo"));
		
		List<SwiftTagListBlock> sbs = b.getSubBlocks("blockname");
		
		assertEquals(2, sbs.size());

		SwiftTagListBlock sb = sbs.get(0);
		assertEquals(3, sb.size());
		assertEquals("16R", sb.getTag(0).getName());
		assertEquals("blockname", sb.getTag(0).getValue());
		assertEquals("2", sb.getTag(1).getName());
		assertEquals("val2", sb.getTag(1).getValue());
		assertEquals("16S", sb.getTag(2).getName());
		assertEquals("blockname", sb.getTag(2).getValue());
		
		SwiftTagListBlock sb2 = sbs.get(1);
		assertEquals(6, sb2.size());
		assertEquals("16R", sb2.getTag(0).getName());
		assertEquals("blockname", sb2.getTag(0).getValue());
		assertEquals("4", sb2.getTag(1).getName());
		assertEquals("val4", sb2.getTag(1).getValue());
		assertEquals("16R", sb2.getTag(2).getName());
		assertEquals("foo", sb2.getTag(2).getValue());
		assertEquals("66", sb2.getTag(3).getName());
		assertEquals("foo", sb2.getTag(3).getValue());
		assertEquals("16S", sb2.getTag(4).getName());
		assertEquals("foo", sb2.getTag(4).getValue());
		assertEquals("16S", sb2.getTag(5).getName());
		assertEquals("blockname", sb2.getTag(5).getValue());
	}
	
	/**
	 * Test using block name and multiple sub blocks, with nested sub blocks and missing ending tag
	 */
	@Test
	public void testgetSubBlock09() {
		b.append(new Tag("99:foo"));
		b.append(new Tag("16R:blockname"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("16S:blockname"));
		b.append(new Tag("88:foo"));
		b.append(new Tag("16R:blockname"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("16R:foo"));
		b.append(new Tag("66:foo"));
		b.append(new Tag("16S:foo"));
		b.append(new Tag("77:foo"));
		
		List<SwiftTagListBlock> sbs = b.getSubBlocks("blockname");
		
		assertEquals(2, sbs.size());

		SwiftTagListBlock sb = sbs.get(0);
		assertEquals(3, sb.size());
		assertEquals("16R", sb.getTag(0).getName());
		assertEquals("blockname", sb.getTag(0).getValue());
		assertEquals("2", sb.getTag(1).getName());
		assertEquals("val2", sb.getTag(1).getValue());
		assertEquals("16S", sb.getTag(2).getName());
		assertEquals("blockname", sb.getTag(2).getValue());
		
		SwiftTagListBlock sb2 = sbs.get(1);
		assertEquals(6, sb2.size());
		assertEquals("16R", sb2.getTag(0).getName());
		assertEquals("blockname", sb2.getTag(0).getValue());
		assertEquals("4", sb2.getTag(1).getName());
		assertEquals("val4", sb2.getTag(1).getValue());
		assertEquals("16R", sb2.getTag(2).getName());
		assertEquals("foo", sb2.getTag(2).getValue());
		assertEquals("66", sb2.getTag(3).getName());
		assertEquals("foo", sb2.getTag(3).getValue());
		assertEquals("16S", sb2.getTag(4).getName());
		assertEquals("foo", sb2.getTag(4).getValue());
		assertEquals("77", sb2.getTag(5).getName());
		assertEquals("foo", sb2.getTag(5).getValue());
	}
	
	/**
	 * Normal test with starting and ending tag names and multiple sub blocks
	 */
	@Test
	public void testgetSubBlock10() {
		b.append(new Tag("99:foo"));
		b.append(new Tag("1:start"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3:end"));
		b.append(new Tag("88:foo"));
		b.append(new Tag("1:start"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("3:end"));
		b.append(new Tag("77:foo"));
		
		List<SwiftTagListBlock> sbs = b.getSubBlocks("1", "3");
		
		assertEquals(2, sbs.size());

		SwiftTagListBlock sb = sbs.get(0);
		assertEquals(3, sb.size());
		assertEquals("1", sb.getTag(0).getName());
		assertEquals("start", sb.getTag(0).getValue());
		assertEquals("2", sb.getTag(1).getName());
		assertEquals("val2", sb.getTag(1).getValue());
		assertEquals("3", sb.getTag(2).getName());
		assertEquals("end", sb.getTag(2).getValue());
		
		SwiftTagListBlock sb2 = sbs.get(1);
		assertEquals(3, sb2.size());
		assertEquals("1", sb2.getTag(0).getName());
		assertEquals("start", sb2.getTag(0).getValue());
		assertEquals("4", sb2.getTag(1).getName());
		assertEquals("val4", sb2.getTag(1).getValue());
		assertEquals("3", sb2.getTag(2).getName());
		assertEquals("end", sb2.getTag(2).getValue());
	}
	
	/**
	 * Normal test with starting and ending tag names and multiple sub blocks
	 * using tag number for end boundary (regardless of letter option)
	 */
	@Test
	public void testgetSubBlock10b() {
		b.append(new Tag("99:foo"));
		b.append(new Tag("1:start"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3A:end"));
		b.append(new Tag("88:foo"));
		b.append(new Tag("1:start"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("3B:end"));
		b.append(new Tag("77:foo"));
		
		List<SwiftTagListBlock> sbs = b.getSubBlocks("1", 3);
		
		assertEquals(2, sbs.size());

		SwiftTagListBlock sb = sbs.get(0);
		assertEquals(3, sb.size());
		assertEquals("1", sb.getTag(0).getName());
		assertEquals("start", sb.getTag(0).getValue());
		assertEquals("2", sb.getTag(1).getName());
		assertEquals("val2", sb.getTag(1).getValue());
		assertEquals("3A", sb.getTag(2).getName());
		assertEquals("end", sb.getTag(2).getValue());
		
		SwiftTagListBlock sb2 = sbs.get(1);
		assertEquals(3, sb2.size());
		assertEquals("1", sb2.getTag(0).getName());
		assertEquals("start", sb2.getTag(0).getValue());
		assertEquals("4", sb2.getTag(1).getName());
		assertEquals("val4", sb2.getTag(1).getValue());
		assertEquals("3B", sb2.getTag(2).getName());
		assertEquals("end", sb2.getTag(2).getValue());
	}
	
	/**
	 * Not found
	 */
	@Test
	public void testgetSubBlock11() {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		
		SwiftTagListBlock sb = b.getSubBlock(new Tag("7:val7"), new Tag("8:val8"));
		
		assertEquals(0, sb.size());
	}
	
	/**
	 * Not found
	 */
	@Test
	public void testContainTag() {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		assertTrue(b.containsTag(new Tag("4:val4")));
		assertFalse(b.containsTag(new Tag("4:foo")));
		assertFalse(b.containsTag(new Tag("foo:val4")));
	}
	
	@Test
	public void testContainsField() {
		b.append(new Tag("21E:"));
		b.append(new Tag("50B:"));
		assertTrue(b.containsField("50B"));
		assertTrue(b.containsField("50a"));
		assertTrue(b.containsField("21E"));
		assertTrue(b.containsField("21a"));
	}
	
	@Test
	public void testFieldsByNameEmptyResult() {
		// empty result
		b.append(new Tag("1", "foo"));
		Field[] fieldsByName = b.getFieldsByName("2");
		assertEquals(0, fieldsByName.length);
		
		// empty result with empty set
		Field[] o = new SwiftTagListBlock().getFieldsByName("");
		assertEquals(0, o.length);

		o = new SwiftTagListBlock().getFieldsByName("1");
		assertEquals(0, o.length);
	}
	
	@Test
	public void testFieldsByNameWildcards() {
		b.append(new Tag("95C", "foo"));
		Field[] fieldsByName = b.getFieldsByName("95a");
		assertEquals(1, fieldsByName.length);
		
		b.append(new Tag("93", "bar"));
		fieldsByName = b.getFieldsByName("95a");
		assertEquals(1, fieldsByName.length);

		b.append(new Tag("95C", "foo2"));
		fieldsByName = b.getFieldsByName("95a");
		assertEquals(2, fieldsByName.length);
	}
	
	@Test
	public void testFieldsByNameBeing() {
		b.append(new Tag("95C", "foo"));
		assertEquals(1, b.getFieldsByName("95a", "foo").size());
		
		b.append(new Tag("93", "bar"));
		assertEquals(1, b.getFieldsByName("95a", "foo").size());
		
		b.append(new Tag("95C", "foo"));
		b.append(new Tag("95C", "foo2"));
		b.append(new Tag("95C", "foo2"));
		b.append(new Tag("95C", "foo2"));
		assertEquals(2, b.getFieldsByName("95a", "foo").size());
		assertEquals(3, b.getFieldsByName("95a", "foo2").size());
	}

	@Test
	public void testTagsByNameBeing() {
		b.append(new Tag("95C", "foo"));
		assertEquals(1, b.getTagsByName("95a", "foo").size());

		b.append(new Tag("93", "bar"));
		assertEquals(1, b.getTagsByName("95a", "foo").size());

		b.append(new Tag("95C", "foo"));
		b.append(new Tag("95C", "foo2"));
		b.append(new Tag("95C", "foo2"));
		b.append(new Tag("95C", "foo2"));
		assertEquals(2, b.getTagsByName("95a", "foo").size());
		assertEquals(3, b.getTagsByName("95a", "foo2").size());
	}

	@Test
	public void testGetTagIndex() {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		
		assertEquals((int)0, (int)b.getTagIndex("1", null));
		assertEquals((int)2, (int)b.getTagIndex("3", new String[]{"A", "B", "K"}));
		assertEquals((int)3, (int)b.getTagIndex("4", new String[]{"A", "B", "K", ""}));
	}
	
	@Test
	public void testGetSubBlockAfterFirst() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		SwiftTagListBlock sb = b.getSubBlockAfterFirst("2", true);
		assertEquals(4, sb.size());
		assertEquals("val2", sb.getTag(0).getValue());
		assertEquals("val5", sb.getTag(3).getValue());
	}
	
	@Test
	public void testGetSubBlockAfterFirst2() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		SwiftTagListBlock sb = b.getSubBlockAfterFirst("3K", true);
		assertEquals(3, sb.size());
		assertEquals("val3", sb.getTag(0).getValue());
		assertEquals("val5", sb.getTag(2).getValue());
	}
	
	@Test
	public void testGetSubBlockAfterFirst3() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		b.append(new Tag("3K:val6"));
		b.append(new Tag("7:val7"));
		b.append(new Tag("8:val8"));
		SwiftTagListBlock sb = b.getSubBlockAfterFirst("3K", false);
		assertEquals(5, sb.size());
		assertEquals("val4", sb.getTag(0).getValue());
		assertEquals("val8", sb.getTag(4).getValue());
	}
	
	@Test
	public void testGetSubBlockAfterFirstLimit() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		b.append(new Tag("3K:val6"));
		b.append(new Tag("7:val7"));
		b.append(new Tag("8:val8"));
		SwiftTagListBlock sb = b.getSubBlockAfterFirst("8", false);
		assertEquals(0, sb.size());
	}
	
	@Test
	public void testGetSubBlockAfterFirstLimit2() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		b.append(new Tag("3K:val6"));
		b.append(new Tag("7:val7"));
		b.append(new Tag("8:val8"));
		SwiftTagListBlock sb = b.getSubBlockAfterFirst("1", false);
		assertEquals(7, sb.size());
	}

	@Test
	public void testGetSubBlockAfterFirstNotFound() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		b.append(new Tag("3K:val6"));
		b.append(new Tag("7:val7"));
		b.append(new Tag("8:val8"));
		SwiftTagListBlock sb = b.getSubBlockAfterFirst("99", false);
		assertEquals(0, sb.size());
	}
	
	@Test
	public void testGetSubBlockAfterFirstTag() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		b.append(new Tag("3K:val6"));
		b.append(new Tag("7:val7"));
		b.append(new Tag("8:val8"));
		SwiftTagListBlock sb = b.getSubBlockAfterFirst(new Tag("3K:val3"), false);
		assertEquals(5, sb.size());
		assertEquals("val4", sb.getTag(0).getValue());
		assertEquals("val8", sb.getTag(4).getValue());
	}
	
	@Test
	public void testGetSubBlockBeforeFirst() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		SwiftTagListBlock sb = b.getSubBlockBeforeFirst("2", false);
		assertEquals(1, sb.size());
		assertEquals("val1", sb.getTag(0).getValue());
	}

	@Test
	public void testGetSubBlockBeforeLast() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("5:val5"));
		SwiftTagListBlock sb = b.getSubBlockBeforeLast("2", false);
		assertEquals(3, sb.size());
		assertEquals("val3", sb.getTag(2).getValue());
		
		sb = b.getSubBlockBeforeLast("2", true);
		assertEquals(4, sb.size());
		assertEquals("val2", sb.getTag(3).getValue());
	}

	@Test
	public void testIndexOfLast() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("5:val5"));

		assertEquals(3, b.indexOfLast("2"));

		assertEquals(0, b.indexOfLast("1"));
		
		assertEquals(4, b.indexOfLast("5"));
	}

	@Test
	public void testGetSubBlockAfterLast() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("5:val5"));
		SwiftTagListBlock sb = b.getSubBlockAfterLast("2", false);
		assertEquals(1, sb.size());
		assertEquals("val5", sb.getTag(0).getValue());
		
		sb = b.getSubBlockAfterLast("2", true);
		assertEquals(2, sb.size());
		assertEquals("val5", sb.getTag(1).getValue());
	}

	@Test
	public void testGetSubBlockBeforeFirst2() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		SwiftTagListBlock sb = b.getSubBlockBeforeFirst("2", true);
		assertEquals(2, sb.size());
		assertEquals("val1", sb.getTag(0).getValue());
		assertEquals("val2", sb.getTag(1).getValue());
	}
	
	@Test
	public void testGetSubBlockBeforeFirst3() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		SwiftTagListBlock sb = b.getSubBlockBeforeFirst("3K", true);
		assertEquals(3, sb.size());
		assertEquals("val1", sb.getTag(0).getValue());
		assertEquals("val2", sb.getTag(1).getValue());
		assertEquals("val3", sb.getTag(2).getValue());
	}
	
	@Test
	public void testGetSubBlockBeforeFirstFirst2() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		b.append(new Tag("3K:val6"));
		b.append(new Tag("7:val7"));
		b.append(new Tag("8:val8"));
		SwiftTagListBlock sb = b.getSubBlockBeforeFirst("3K", false);
		assertEquals(2, sb.size());
		assertEquals("val1", sb.getTag(0).getValue());
		assertEquals("val2", sb.getTag(1).getValue());
	}
	
	@Test
	public void testGetSubBlockBeforeFirstLimit() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		b.append(new Tag("3K:val6"));
		b.append(new Tag("7:val7"));
		b.append(new Tag("8:val8"));
		SwiftTagListBlock sb = b.getSubBlockBeforeFirst("1", false);
		assertEquals(0, sb.size());
	}
	
	@Test
	public void testGetSubBlockBeforeFirstLimit2() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		b.append(new Tag("3K:val6"));
		b.append(new Tag("7:val7"));
		b.append(new Tag("8:val8"));
		SwiftTagListBlock sb = b.getSubBlockBeforeFirst("8", false);
		assertEquals(7, sb.size());
	}
	
	@Test
	public void testGetSubBlockBeforeFirstNotFound() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		b.append(new Tag("3K:val6"));
		b.append(new Tag("7:val7"));
		b.append(new Tag("8:val8"));
		SwiftTagListBlock sb = b.getSubBlockBeforeFirst("99", false);
		assertEquals(8, sb.size());
	}

	@Test
	public void testRemove() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		String sb = b.removeTag("3K");
		assertEquals("val3", sb);
		assertEquals(4, b.size());
	}

	/**
	 * Test for subblocks API with real case message
	 */
	@Test 
	public void testGetSubBlockMT564() {
		final String msg = "{1:F01MTGSUS6SAXXX3206837054}{2:O5641435070316CHASGB2LDGST07128160300703160735N}{3:{108:000255CQ8272245}}{4:\n" + 
				":16R:GENL\n" + 
				":20C::CORP//D455103\n" + 
				":20C::SEME//029206016\n" + 
				":23G:NEWM\n" + 
				":22F::CAEV//DVCA\n" + 
				":22F::CAMV//MAND\n" + 
				":98C::PREP//20070316143348\n" + 
				":25D::PROC//COMP\n" + 
				":16S:GENL\n" + 
				":16R:USECU\n" + 
				":35B:ISIN CH0011075394\n" + 
				"/XX/5983816\n" + 
				"ZURICH FIN SVS GRP\n" + 
				"CHF0.10\n" + 
				":16R:ACCTINFO\n" + 
				":97A::SAFE//760043140\n" + 
				":94F::SAFE//CUST/UBSWCHZH80A\n" + 
				":93B::ELIG//UNIT/7000,\n" + 
				":16S:ACCTINFO\n" + 
				":16S:USECU\n" + 
				":16R:CADETL\n" + 
				":98A::XDTE//20111111\n" + 
				":98A::PAYD//20111111\n" + 
				":98A::RDTE//20111111\n" + 
				":92A::WITF//35,\n" + 
				":92A::GRSS//0,000001000\n" + 
				":16S:CADETL\n" + 
				":16R:CAOPTN\n" + 
				":13A::CAON//001\n" + 
				":22F::CAOP//CASH\n" + 
				":11A::OPTN//CHF\n" + 
				":17B::DFLT//Y\n" + 
				":98A::XDTE//20111111\n" + 
				":98A::PAYD//20111111\n" + 
				":98A::RDTE//20111111\n" + 
				":92A::GRSS//0,000001000\n" + 
				":16R:CASHMOVE\n" + 
				":22H::CRDB//CRED\n" + 
				":19B::ENTL//CHF0,01\n" + 
				":19B::GRSS//CHF0,01\n" + 
				":19B::NETT//CHF0,01\n" + 
				":98A::PAYD//20111111\n" + 
				":98A::VALU//20111111\n" + 
				":16S:CASHMOVE\n" + 
				":16S:CAOPTN\n" +
				"-}";
		//parse text message into SWIFT message object
		SwiftMessage o = (new ConversionService()).getMessageFromFIN(msg);
		List<SwiftTagListBlock> sequencesB2 = o.getBlock4().getSubBlocks("ACCTINFO");
		List<SwiftTagListBlock> sequencesC = o.getBlock4().getSubBlocks("INTSEC");
		
		for (SwiftTagListBlock seq : sequencesB2) {
			Field[] fields = seq.getFieldsByName("93B");
			assertEquals(1, fields.length);
			Field93B f = (Field93B) fields[0];
			assertEquals(":ELIG//UNIT/7000,", f.getValue());
		}
		
		assertTrue(sequencesC.isEmpty());
	}

	@Test
	public void testFilterByName() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		b.append(new Tag("3K:val6"));
		b.append(new Tag("7:val7"));
		b.append(new Tag("8:val8"));
		SwiftTagListBlock sb = b.filterByName(true, "1", "4", "7");
		assertEquals(3, sb.size());
		assertEquals("val7", sb.getTag(2).getValue());
		sb = b.filterByName(false, "1", "4", "7");
		assertEquals(5, sb.size());
	}

	@Test
	public void testFilterByName2() throws Exception {		
		SwiftTagListBlock sb = b.filterByName(true, "1", "4", "7");
		assertEquals(0, sb.size());
		
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		b.append(new Tag("3K:val6"));
		b.append(new Tag("7:val7"));
		b.append(new Tag("8:val8"));
		
		sb = b.filterByName(false);
		assertEquals(8, sb.size());
	}
	
	@Test
	public void testFilterByNameOrdered() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		b.append(new Tag("3K:val6"));
		b.append(new Tag("7:val7"));
		b.append(new Tag("8:val8"));
		SwiftTagListBlock sb = b.filterByNameOrdered("1", "2", "4");
		assertEquals(2, sb.size());
		assertEquals("val1", sb.getTag(0).getValue());
		assertEquals("val2", sb.getTag(1).getValue());
	}
	
	@Test
	public void testGetOptionalList() throws Exception {
		
		b.append(new Tag("1:val1")); // entra, en primera fila de permitidos
		b.append(new Tag("2:val2")); // entra en la tercera
		b.append(new Tag("3:val3")); // no entra, de la tercera ya se consumui el priero, y de cada fila se acepta uno
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		b.append(new Tag("6:val6"));
		b.append(new Tag("7:val7"));
		b.append(new Tag("8:val8"));
		
		SwiftTagListBlock result = b.getOptionalList( new String[][]{{"1a", "1b", "1"},{"2e", "2c"}, {"2", "3"}} );
		
		assertEquals(2, result.size());
		assertEquals("val1", result.getTag(0).getValue());
		assertEquals("val2", result.getTag(1).getValue());
	}

	@Test
	public void testGetOptionalLists() throws Exception {
		appends(b, 1, 8);
		appends(b, 1, 8);
		
		List<SwiftTagListBlock> result = b.getOptionalLists( new String[][]{{"1a", "1b", "1"},{"2e", "2c"}, {"2", "3"}} );
		
		assertNotNull(result);
		assertEquals(2, result.size());
	}

	@Test
	public void testGetSubBlockDelimitedWithOptionalTail() throws Exception {
		appends(b, 1, 8);
		
		String[] start = new String[]{"1"};
		String[] end = new String[]{"5c", "5b", "5"};
		String[] tail = new String[]{};
		SwiftTagListBlock result = b.getSubBlockDelimitedWithOptionalTail(start, end, tail);
		
		assertEquals(""+result.tagNamesList(), 5, result.size());
	}
	
	@Test
	public void testGetSubBlocksDelimitedWithOptionalTail() throws Exception {
		appends(b, 1, 8);
		appends(b, 1, 8);
		
		String[] start = new String[]{"1"};
		String[] end = new String[]{"5c", "5b", "5"};
		String[] tail = new String[]{};
		List<SwiftTagListBlock> result = b.getSubBlocksDelimitedWithOptionalTail(start, end, tail);
		
		assertEquals(2, result.size());
		assertEquals(5, result.get(0).size());
		assertEquals(5, result.get(1).size());
		
		tail = new String[]{"6a", "6"};
		result = b.getSubBlocksDelimitedWithOptionalTail(start, end, tail);
		assertEquals(2, result.size());
		assertEquals(6, result.get(0).size());
		assertEquals(6, result.get(1).size());
	}
	
	@Test
	public void testGetSubBlockDelimitedWithOptionalTail_304bugNPE() throws Exception {
		appends(b, 1, 4);
		
		String[] start = new String[]{"1"};
		String[] end = new String[]{"2"};
		String[] tail = new String[]{"3", "4"};
		SwiftTagListBlock result = b.getSubBlockDelimitedWithOptionalTail(start, end, tail);
		
		assertNotNull(result);
		assertEquals(4, result.size());
	}
	
	@Test
	public void testGetSubBlockDelimitedWithOptionalTail_Bug1() throws Exception {
		appends(b, 1, 9);
		
		String[] start = new String[]{"1"};
		String[] end = new String[]{"3"};
		String[] tail = new String[]{"6", "7"};
		SwiftTagListBlock result = b.getSubBlockDelimitedWithOptionalTail(start, end, tail);
		
		assertNotNull(result);
		assertEquals("returned: "+result.tagNamesList(), 3, result.size());
	}

	/*
	 * The getSubBlock includes the starting element in the result but excludes the ending one
	 */
	@Test
	public void testGetSubBlock() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("5:val5"));
		SwiftTagListBlock sb = b.getSubBlock(1, 2);
		assertEquals(1, sb.size());
		assertEquals("val2", sb.getTag(0).getValue());

		sb = b.getSubBlock(1, 1+4);
		assertEquals(4, sb.size());
		assertEquals("val3", sb.getTag(1).getValue());

		sb = b.getSubBlock(null, 1);
		assertEquals(1, sb.size());
		assertEquals("val1", sb.getTag(0).getValue());

		sb = b.getSubBlock(4, null);
		assertEquals(1, sb.size());
		assertEquals("val5", sb.getTag(0).getValue());

		sb = b.getSubBlock(0, 100);
		assertEquals(5, sb.size());
	}

	/*
	 * The sublist method includes both the starting and ending elements in the result
	 */
	@Test
	public void testSublist() throws Exception {
		appends(b, 1, 10);
		
		SwiftTagListBlock sl = b.sublist(0, 1);
		assertEquals(2, sl.size());
		
		sl = b.sublist(null, null);
		assertEquals(b.size(), sl.size());
	}
	
	private void appends(SwiftTagListBlock block, int from ,int to) {
		for (int i=from;i<=to;i++) {
			block.append(new Tag(""+i, "val"+i));
		}
	}
	
	@Test
	public void testRemoveSubBlock() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:val4"));
		b.append(new Tag("5:val5"));
		SwiftTagListBlock sb = b.removeSubBlock("TEST");
		assertEquals(5, sb.size());
		assertEquals("val1", sb.getTag(0).getValue());
		assertEquals("val2", sb.getTag(1).getValue());
		assertEquals("val3", sb.getTag(2).getValue());
		assertEquals("val4", sb.getTag(3).getValue());
		assertEquals("val5", sb.getTag(4).getValue());
	}

	@Test
	public void testRemoveSubBlock_2() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("16S:TEST"));
		b.append(new Tag("5:val5"));
		SwiftTagListBlock sb = b.removeSubBlock("TEST");
		assertEquals(5, sb.size());
		assertEquals("val1", sb.getTag(0).getValue());
		assertEquals("val2", sb.getTag(1).getValue());
		assertEquals("val3", sb.getTag(2).getValue());
		assertEquals("TEST", sb.getTag(3).getValue());
		assertEquals("val5", sb.getTag(4).getValue());
	}

	@Test
	public void testRemoveSubBlock_3() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("16R:HELLO"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("16S:TEST"));
		b.append(new Tag("5:val5"));
		SwiftTagListBlock sb = b.removeSubBlock("TEST");
		assertEquals(5, sb.size());
		assertEquals("val1", sb.getTag(0).getValue());
		assertEquals("HELLO", sb.getTag(1).getValue());
		assertEquals("val3", sb.getTag(2).getValue());
		assertEquals("TEST", sb.getTag(3).getValue());
		assertEquals("val5", sb.getTag(4).getValue());
	}

	@Test
	public void testRemoveSubBlock_4() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("16R:TEST"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("16S:TEST"));
		b.append(new Tag("5:val5"));
		SwiftTagListBlock sb = b.removeSubBlock("TEST");
		assertEquals(2, sb.size());
		assertEquals("val1", sb.getTag(0).getValue());
		assertEquals("val5", sb.getTag(1).getValue());
	}

	@Test
	public void testRemoveSubBlock_5() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("16R:TEST"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("16S:FOO"));
		b.append(new Tag("5:val5"));
		SwiftTagListBlock sb = b.removeSubBlock("TEST");
		assertEquals(1, sb.size());
		assertEquals("val1", sb.getTag(0).getValue());
	}
	
	@Test
	public void testRemoveSubBlock_6() throws Exception {
		b.append(new Tag("1:val1"));
		b.append(new Tag("16R:TEST"));
		b.append(new Tag("3K:val3"));
		b.append(new Tag("4:FOO"));
		b.append(new Tag("5:val5"));
		SwiftTagListBlock sb = b.removeSubBlock("TEST");
		assertEquals(1, sb.size());
		assertEquals("val1", sb.getTag(0).getValue());
	}

	/*
	 * https://github.com/prowide/prowide-core/issues/13
	 */
	@Test
	public void testRemoveSubBlock_7() throws Exception {
		b.append(Field20.tag("before"));

		// first sub-block
		b.append(Field16R.tag("SUBBAL"));
		b.append(Field20.tag("first block"));
		b.append(Field16S.tag("SUBBAL"));
		// second sub-block
		b.append(Field16R.tag("SUBBAL"));
		b.append(Field20.tag("second block"));
		b.append(Field16S.tag("SUBBAL"));

		b.append(Field20.tag("after"));

		SwiftTagListBlock sb = b.removeSubBlock("SUBBAL");
		assertEquals("before", sb.getTag(0).getValue());
		assertEquals("SUBBAL", sb.getTag(1).getValue());
		assertEquals("second block", sb.getTag(2).getValue());
		assertEquals("SUBBAL", sb.getTag(3).getValue());
		assertEquals("after", sb.getTag(4).getValue());
		assertEquals(5, sb.size());
	}

	/*
	 * https://github.com/prowide/prowide-core/issues/13
	 */
	@Test
	public void testRemoveSubBlocks() throws Exception {
		b.append(Field20.tag("before"));

		// first sub-block
		b.append(Field16R.tag("SUBBAL"));
		b.append(Field20.tag("first block"));
		b.append(Field16S.tag("SUBBAL"));
		// second sub-block
		b.append(Field16R.tag("SUBBAL"));
		b.append(Field20.tag("second block"));
		b.append(Field16S.tag("SUBBAL"));

		b.append(Field20.tag("after"));

		// remove all subblocks
		SwiftTagListBlock sb = b.removeSubBlocks("SUBBAL");
		assertEquals("before", sb.getTag(0).getValue());
		assertEquals("after", sb.getTag(1).getValue());
		assertEquals(2, sb.size());
	}

	@Test
	public void testEmptyArrayReturn() throws Exception {
		Field[] arr = new SwiftTagListBlock().getFieldsByName("nn");
		assertNotNull(arr);
		assertEquals(0, arr.length);
	}
	
	@Test
	public void testGetFieldByName19A() throws Exception {
		b.append(Field19A.tag(":SETT"));
		assertNotNull(b.getFieldByName(Field19A.NAME, "SETT"));
	}
	
	/**
	 * @since 7.8.5
	 */
	@Test
	public void testGetSubBlockByTagNames() throws Exception {
		/*
		 * empty search and empty block
		 */
		SwiftTagListBlock result = b.getSubBlockByTagNames(0);
		assertNotNull(result);
		assertTrue(result.isEmpty());
		
		appends(b, 1, 9);

		/*
		 * filled block, empty search
		 */
		result = b.getSubBlockByTagNames(0);
		assertNotNull(result);
		assertTrue(result.isEmpty());

		/*
		 * single match on first tag
		 */
		result = b.getSubBlockByTagNames(0, "1");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals("1", result.getTag(0).getName());
		
		/*
		 * single match on second tag
		 */
		result = b.getSubBlockByTagNames(0, "2");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals("2", result.getTag(0).getName());
		
		/*
		 * the same with index above match
		 */
		result = b.getSubBlockByTagNames(8, "2");
		assertNotNull(result);
		assertTrue(result.isEmpty());
		
		/*
		 * same with index before match
		 */
		result = b.getSubBlockByTagNames(1, "2");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals("2", result.getTag(0).getName());
		
		/*
		 * double match on consecutive tags
		 */
		result = b.getSubBlockByTagNames(0, "2", "3");
		assertNotNull(result);
		assertEquals(2, result.size());
		assertEquals("2", result.getTag(0).getName());
		assertEquals("3", result.getTag(1).getName());
		
		/*
		 * double match on non-consecutive tags
		 */
		result = b.getSubBlockByTagNames(0, "2", "5");
		assertNotNull(result);
		assertEquals(2, result.size());
		assertEquals("2", result.getTag(0).getName());
		assertEquals("5", result.getTag(1).getName());

		/*
		 * single match because unordered search tags
		 */
		result = b.getSubBlockByTagNames(0, "5", "2");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals("2", result.getTag(0).getName());
	}
	
	/**
	 * @since 7.8.5
	 */
	@Test
	public void testGetSubBlockByTagNames_repetition() throws Exception {
		b.append(new Tag("1", "1"));
		b.append(new Tag("2", "2"));
		b.append(new Tag("2", "2"));
		b.append(new Tag("2", "2"));
		b.append(new Tag("3", "3"));
		b.append(new Tag("4", "4"));
		
		/*
		 * simple case with repetition on block
		 */
		SwiftTagListBlock result = b.getSubBlockByTagNames(0, "2");
		assertNotNull(result);
		assertEquals(3, result.size());
		assertEquals("2", result.getTag(0).getName());
		assertEquals("2", result.getTag(1).getName());
		assertEquals("2", result.getTag(2).getName());
		
		/*
		 * same as above with other unmatched tags
		 */
		result = b.getSubBlockByTagNames(0, "foo", "2", "99");
		assertNotNull(result);
		assertEquals(3, result.size());
		assertEquals("2", result.getTag(0).getName());
		assertEquals("2", result.getTag(1).getName());
		assertEquals("2", result.getTag(2).getName());
		
		/*
		 * repetition on search tags does not produce any difference
		 */
		result = b.getSubBlockByTagNames(0, "2", "2", "2");
		assertNotNull(result);
		assertEquals(3, result.size());
		assertEquals("2", result.getTag(0).getName());
		assertEquals("2", result.getTag(1).getName());
		assertEquals("2", result.getTag(2).getName());
	}
	
	/**
	 * similar to {@link #testGetSubBlockByTagNames()} but getting
	 * multiple block instances
	 * @since 7.8.5
	 */
	@Test
	public void testGetSubBlocksByTagNames() throws Exception {
		/*
		 * empty search and empty block
		 */
		List<SwiftTagListBlock> result = b.getSubBlocksByTagNames(0);
		assertNotNull(result);
		assertTrue(result.isEmpty());
		
		appends(b, 1, 9);

		/*
		 * filled block, empty search
		 */
		result = b.getSubBlocksByTagNames(0);
		assertNotNull(result);
		assertTrue(result.isEmpty());

		/*
		 * single match on first tag
		 */
		result = b.getSubBlocksByTagNames(0, "1");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(1, result.get(0).size());
		assertEquals("1", result.get(0).getTag(0).getName());
		
		/*
		 * single match on second tag
		 */
		result = b.getSubBlocksByTagNames(0, "2");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(1, result.get(0).size());
		assertEquals("2", result.get(0).getTag(0).getName());
		
		/*
		 * the same with index above match
		 */
		result = b.getSubBlocksByTagNames(8, "2");
		assertNotNull(result);
		assertTrue(result.isEmpty());
		
		/*
		 * same with index before match
		 */
		result = b.getSubBlocksByTagNames(1, "2");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(1, result.get(0).size());
		assertEquals("2", result.get(0).getTag(0).getName());
		
		/*
		 * double match on consecutive tags
		 */
		result = b.getSubBlocksByTagNames(0, "2", "3");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(2, result.get(0).size());
		assertEquals("2", result.get(0).getTag(0).getName());
		assertEquals("3", result.get(0).getTag(1).getName());
		
		/*
		 * double match on non-consecutive tags
		 */
		result = b.getSubBlocksByTagNames(0, "2", "5");
		assertNotNull(result);
		assertEquals(1, result.size());
		assertEquals(2, result.get(0).size());
		assertEquals("2", result.get(0).getTag(0).getName());
		assertEquals("5", result.get(0).getTag(1).getName());

		/*
		 * single match because unordered search tags
		 */
		result = b.getSubBlocksByTagNames(0, "5", "2");
		assertNotNull(result);
		assertEquals(2, result.size());
		//first pass will find 2
		assertEquals(1, result.get(0).size());
		assertEquals("2", result.get(0).getTag(0).getName());
		//second pass will find 5
		assertEquals(1, result.get(1).size());
		assertEquals("5", result.get(1).getTag(0).getName());
	}

	@Test
	public void testAdd_1() {
		b.append(new Tag("1:val1"));
		b.append(new Tag("2:val2"));
		b.append(new Tag("3:val3"));

		b.addTag(2,(new Tag("4:val4")));

		assertEquals(4, b.getTags().size());
		assertEquals("val1", b.getTag(0).getValue());
		assertEquals("val2", b.getTag(1).getValue());
		assertEquals("val4", b.getTag(2).getValue());
		assertEquals("val3", b.getTag(3).getValue());

		assertEquals((int)2, (int)b.getTagIndex("4", null));
        assertEquals((int)3, (int)b.getTagIndex("3", null));
	}

	@Test
	public void testAdd_2() {
		b.addTag(0, new Tag("1:val1"));
		b.addTag(1, new Tag("2:val2"));
		b.addTag(2, new Tag("3:val3"));

		assertEquals(3, b.getTags().size());
		assertEquals("val1", b.getTag(0).getValue());
		assertEquals("val2", b.getTag(1).getValue());
		assertEquals("val3", b.getTag(2).getValue());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void testAdd_3() {
		b.addTag(1, new Tag("1:val1"));
	}

	@Test
    public void testSet() {
        b.append(new Tag("1:val1"));
        b.append(new Tag("2:val2"));
        b.append(new Tag("3:val3"));
        b.setTag(2,(new Tag("15", "15")));
        assertEquals((int)2, (int)b.getTagIndex("15", null));
        assertNull(b.getTagIndex("3", null));
    }

	@Test
	public void testFieldByQualifiers() {
		// conditional qualifier is component 3
		b.append(new Tag("22F", ":AAAA//BBBB"));
		assertNotNull(b.getFieldByQualifiers("22F", "AAAA", "BBBB"));
		
		// DSS is ignored
		b.append(new Tag("22F", ":AAAA/DSS/CCCC"));
		assertNotNull(b.getFieldByQualifiers("22F", "AAAA", "CCCC"));
		
		// conditional qualifier is component 2
		b.append(new Tag("12C", ":AAAA//BBBB"));
		assertNotNull(b.getFieldByQualifiers("12C", "AAAA", "BBBB"));
		
		// not generic field
		b.append(new Tag("22K", "AAAA/BBBB"));
		assertNull(b.getFieldByQualifiers("22K", "AAAA", "BBBB"));
	}

	@Test
	public void testSplitByTagName() {
		b.append(new Tag("20:foo"));
		b.append(new Tag("21:foo"));
		assertTrue(b.splitByTagName(22, null).isEmpty());
		assertTrue(b.splitByTagName(22, "L").isEmpty());

		b.append(new Tag("22L:foo"));
		assertTrue(b.splitByTagName(22, "M").isEmpty());
		assertEquals(1, b.splitByTagName(22, null).size());
		assertEquals(1, b.splitByTagName(22, "L").size());

		b.append(new Tag("32A:foo"));
		b.append(new Tag("22L:foo"));
		assertEquals(2, b.splitByTagName(22, null).size());
		assertEquals(2, b.splitByTagName(22, "L").size());

		b.append(new Tag("22M:foo"));
		b.append(new Tag("95P:foo"));
		assertEquals(3, b.splitByTagName(22, null).size());
		assertEquals(2, b.splitByTagName(22, "L").size());

		List<SwiftTagListBlock> list1 = b.splitByTagName(22, null);
		assertEquals("22L", list1.get(0).getTag(0).getName());
		assertEquals("32A", list1.get(0).getTag(1).getName());
		assertEquals("22L", list1.get(1).getTag(0).getName());
		assertEquals("22M", list1.get(2).getTag(0).getName());
		assertEquals("95P", list1.get(2).getTag(1).getName());

		List<SwiftTagListBlock> list2 = b.splitByTagName(22, "L");
		assertEquals("22L", list2.get(0).getTag(0).getName());
		assertEquals("32A", list2.get(0).getTag(1).getName());
		assertEquals("22L", list2.get(1).getTag(0).getName());
		assertEquals("22M", list2.get(1).getTag(1).getName());
		assertEquals("95P", list2.get(1).getTag(2).getName());
	}
	
}