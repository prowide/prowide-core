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
import static org.junit.Assert.assertTrue;

import org.junit.Test;


public class SwiftCharsetUtilsTest {
	private static transient final java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftCharsetUtilsTest.class.getName());
	
	@Test
	public void test_n() throws Exception {
		log.info("n "+SwiftCharsetUtils.getAsString(SwiftCharsetUtils.get_n()));

		assertTrue(SwiftCharsetUtils.is_n('0'));
		assertTrue(SwiftCharsetUtils.is_n('1'));
		assertTrue(SwiftCharsetUtils.is_n('2'));
		assertTrue(SwiftCharsetUtils.is_n('3'));
		assertTrue(SwiftCharsetUtils.is_n('4'));
		assertTrue(SwiftCharsetUtils.is_n('5'));
		assertTrue(SwiftCharsetUtils.is_n('6'));
		assertTrue(SwiftCharsetUtils.is_n('7'));
		assertTrue(SwiftCharsetUtils.is_n('8'));
		assertTrue(SwiftCharsetUtils.is_n('9'));
		
		assertFalse(SwiftCharsetUtils.is_n('A'));
		assertFalse(SwiftCharsetUtils.is_n('a'));
		assertFalse(SwiftCharsetUtils.is_n('$'));
		assertFalse(SwiftCharsetUtils.is_n('('));
		
		assertEquals(SwiftCharsetUtils.OK, SwiftCharsetUtils.is_n("23423423023"));
		assertEquals(0, SwiftCharsetUtils.is_n("fdfasd"));
		assertEquals(0, SwiftCharsetUtils.is_n("k14234"));
		assertEquals(1, SwiftCharsetUtils.is_n("2h654k"));
		assertEquals(6, SwiftCharsetUtils.is_n("098765:"));
	}
	
	@Test
	public void test_a() throws Exception {
		log.info("a "+SwiftCharsetUtils.getAsString(SwiftCharsetUtils.get_a()));

		assertTrue(SwiftCharsetUtils.is_a('A'));
		assertTrue(SwiftCharsetUtils.is_a('B'));
		assertTrue(SwiftCharsetUtils.is_a('C'));
		assertTrue(SwiftCharsetUtils.is_a('D'));
		assertTrue(SwiftCharsetUtils.is_a('E'));
		assertTrue(SwiftCharsetUtils.is_a('F'));
		assertTrue(SwiftCharsetUtils.is_a('G'));
		assertTrue(SwiftCharsetUtils.is_a('H'));
		assertTrue(SwiftCharsetUtils.is_a('I'));
		assertTrue(SwiftCharsetUtils.is_a('J'));
		assertTrue(SwiftCharsetUtils.is_a('K'));
		assertTrue(SwiftCharsetUtils.is_a('L'));
		assertTrue(SwiftCharsetUtils.is_a('M'));
		assertTrue(SwiftCharsetUtils.is_a('N'));
		assertTrue(SwiftCharsetUtils.is_a('O'));
		assertTrue(SwiftCharsetUtils.is_a('P'));
		assertTrue(SwiftCharsetUtils.is_a('Q'));
		assertTrue(SwiftCharsetUtils.is_a('R'));
		assertTrue(SwiftCharsetUtils.is_a('S'));
		assertTrue(SwiftCharsetUtils.is_a('T'));
		assertTrue(SwiftCharsetUtils.is_a('U'));
		assertTrue(SwiftCharsetUtils.is_a('V'));
		assertTrue(SwiftCharsetUtils.is_a('W'));
		assertTrue(SwiftCharsetUtils.is_a('X'));
		assertTrue(SwiftCharsetUtils.is_a('Y'));
		assertTrue(SwiftCharsetUtils.is_a('Z'));
		
		assertFalse(SwiftCharsetUtils.is_a('a'));
		assertFalse(SwiftCharsetUtils.is_a('1'));
		assertFalse(SwiftCharsetUtils.is_a('$'));
		assertFalse(SwiftCharsetUtils.is_a('('));
		
		assertEquals(SwiftCharsetUtils.OK, SwiftCharsetUtils.is_a("AJSHDJDHF"));
		assertEquals(0, SwiftCharsetUtils.is_a("asdfasd"));
		assertEquals(0, SwiftCharsetUtils.is_a("kHSJDHD"));
		assertEquals(1, SwiftCharsetUtils.is_a("YhUJUIk"));
		assertEquals(6, SwiftCharsetUtils.is_a("JUHYDF:"));
	}
	
	@Test
	public void test_x() throws Exception {
		log.info("x "+SwiftCharsetUtils.getAsString(SwiftCharsetUtils.get_x()));
		
		assertTrue(SwiftCharsetUtils.is_x('A'));
		assertTrue(SwiftCharsetUtils.is_x('B'));
		assertTrue(SwiftCharsetUtils.is_x('C'));
		assertTrue(SwiftCharsetUtils.is_x('D'));
		assertTrue(SwiftCharsetUtils.is_x('E'));
		assertTrue(SwiftCharsetUtils.is_x('F'));
		assertTrue(SwiftCharsetUtils.is_x('G'));
		assertTrue(SwiftCharsetUtils.is_x('H'));
		assertTrue(SwiftCharsetUtils.is_x('I'));
		assertTrue(SwiftCharsetUtils.is_x('J'));
		assertTrue(SwiftCharsetUtils.is_x('K'));
		assertTrue(SwiftCharsetUtils.is_x('L'));
		assertTrue(SwiftCharsetUtils.is_x('M'));
		assertTrue(SwiftCharsetUtils.is_x('N'));
		assertTrue(SwiftCharsetUtils.is_x('O'));
		assertTrue(SwiftCharsetUtils.is_x('P'));
		assertTrue(SwiftCharsetUtils.is_x('Q'));
		assertTrue(SwiftCharsetUtils.is_x('R'));
		assertTrue(SwiftCharsetUtils.is_x('S'));
		assertTrue(SwiftCharsetUtils.is_x('T'));
		assertTrue(SwiftCharsetUtils.is_x('U'));
		assertTrue(SwiftCharsetUtils.is_x('V'));
		assertTrue(SwiftCharsetUtils.is_x('W'));
		assertTrue(SwiftCharsetUtils.is_x('X'));
		assertTrue(SwiftCharsetUtils.is_x('Y'));
		assertTrue(SwiftCharsetUtils.is_x('Z'));
		assertTrue(SwiftCharsetUtils.is_x('a'));
		assertTrue(SwiftCharsetUtils.is_x('b'));
		assertTrue(SwiftCharsetUtils.is_x('c'));
		assertTrue(SwiftCharsetUtils.is_x('d'));
		assertTrue(SwiftCharsetUtils.is_x('e'));
		assertTrue(SwiftCharsetUtils.is_x('f'));
		assertTrue(SwiftCharsetUtils.is_x('g'));
		assertTrue(SwiftCharsetUtils.is_x('h'));
		assertTrue(SwiftCharsetUtils.is_x('i'));
		assertTrue(SwiftCharsetUtils.is_x('j'));
		assertTrue(SwiftCharsetUtils.is_x('k'));
		assertTrue(SwiftCharsetUtils.is_x('l'));
		assertTrue(SwiftCharsetUtils.is_x('m'));
		assertTrue(SwiftCharsetUtils.is_x('n'));
		assertTrue(SwiftCharsetUtils.is_x('o'));
		assertTrue(SwiftCharsetUtils.is_x('p'));
		assertTrue(SwiftCharsetUtils.is_x('q'));
		assertTrue(SwiftCharsetUtils.is_x('r'));
		assertTrue(SwiftCharsetUtils.is_x('s'));
		assertTrue(SwiftCharsetUtils.is_x('t'));
		assertTrue(SwiftCharsetUtils.is_x('u'));
		assertTrue(SwiftCharsetUtils.is_x('v'));
		assertTrue(SwiftCharsetUtils.is_x('w'));
		assertTrue(SwiftCharsetUtils.is_x('x'));
		assertTrue(SwiftCharsetUtils.is_x('y'));
		assertTrue(SwiftCharsetUtils.is_x('z'));
		assertTrue(SwiftCharsetUtils.is_x('0'));
		assertTrue(SwiftCharsetUtils.is_x('1'));
		assertTrue(SwiftCharsetUtils.is_x('2'));
		assertTrue(SwiftCharsetUtils.is_x('3'));
		assertTrue(SwiftCharsetUtils.is_x('4'));
		assertTrue(SwiftCharsetUtils.is_x('5'));
		assertTrue(SwiftCharsetUtils.is_x('6'));
		assertTrue(SwiftCharsetUtils.is_x('7'));
		assertTrue(SwiftCharsetUtils.is_x('8'));
		assertTrue(SwiftCharsetUtils.is_x('9'));
		assertTrue(SwiftCharsetUtils.is_x('/'));
		assertTrue(SwiftCharsetUtils.is_x('-'));
		assertTrue(SwiftCharsetUtils.is_x('?'));
		assertTrue(SwiftCharsetUtils.is_x(':'));
		assertTrue(SwiftCharsetUtils.is_x('('));
		assertTrue(SwiftCharsetUtils.is_x(')'));
		assertTrue(SwiftCharsetUtils.is_x('.'));
		assertTrue(SwiftCharsetUtils.is_x(','));
		assertTrue(SwiftCharsetUtils.is_x('\''));
		assertTrue(SwiftCharsetUtils.is_x('+'));
		assertTrue(SwiftCharsetUtils.is_x(' '));
		
		assertFalse(SwiftCharsetUtils.is_x('$'));
		assertFalse(SwiftCharsetUtils.is_x('&'));
		assertFalse(SwiftCharsetUtils.is_x('%'));
		assertFalse(SwiftCharsetUtils.is_x('{'));
		assertFalse(SwiftCharsetUtils.is_x('_'));
		assertFalse(SwiftCharsetUtils.is_x('{'));
		assertFalse(SwiftCharsetUtils.is_x('['));
		assertFalse(SwiftCharsetUtils.is_x(']'));
		assertFalse(SwiftCharsetUtils.is_x('@'));
		assertFalse(SwiftCharsetUtils.is_x('!'));
		assertFalse(SwiftCharsetUtils.is_x('"'));
		assertFalse(SwiftCharsetUtils.is_x('*'));
		assertFalse(SwiftCharsetUtils.is_x('<'));
		assertFalse(SwiftCharsetUtils.is_x('>'));
		assertFalse(SwiftCharsetUtils.is_x(';'));
		
		assertEquals(SwiftCharsetUtils.OK, SwiftCharsetUtils.is_x("asdkjahsdHJKAHS876823 /asd78(sdf)+ adssssd' sds89?sd-43/sdf"));
		assertEquals(0, SwiftCharsetUtils.is_x("$asdfasd"));
		assertEquals(1, SwiftCharsetUtils.is_x("Y&UJUIk"));
		assertEquals(6, SwiftCharsetUtils.is_x("J3fYDF="));
	}
	
	@Test
	public void test_y() throws Exception {
		log.info("y "+SwiftCharsetUtils.getAsString(SwiftCharsetUtils.get_y()));
	
		assertTrue(SwiftCharsetUtils.is_y('A'));
		assertTrue(SwiftCharsetUtils.is_y('B'));
		assertTrue(SwiftCharsetUtils.is_y('C'));
		assertTrue(SwiftCharsetUtils.is_y('D'));
		assertTrue(SwiftCharsetUtils.is_y('E'));
		assertTrue(SwiftCharsetUtils.is_y('F'));
		assertTrue(SwiftCharsetUtils.is_y('G'));
		assertTrue(SwiftCharsetUtils.is_y('H'));
		assertTrue(SwiftCharsetUtils.is_y('I'));
		assertTrue(SwiftCharsetUtils.is_y('J'));
		assertTrue(SwiftCharsetUtils.is_y('K'));
		assertTrue(SwiftCharsetUtils.is_y('L'));
		assertTrue(SwiftCharsetUtils.is_y('M'));
		assertTrue(SwiftCharsetUtils.is_y('N'));
		assertTrue(SwiftCharsetUtils.is_y('O'));
		assertTrue(SwiftCharsetUtils.is_y('P'));
		assertTrue(SwiftCharsetUtils.is_y('Q'));
		assertTrue(SwiftCharsetUtils.is_y('R'));
		assertTrue(SwiftCharsetUtils.is_y('S'));
		assertTrue(SwiftCharsetUtils.is_y('T'));
		assertTrue(SwiftCharsetUtils.is_y('U'));
		assertTrue(SwiftCharsetUtils.is_y('V'));
		assertTrue(SwiftCharsetUtils.is_y('W'));
		assertTrue(SwiftCharsetUtils.is_y('X'));
		assertTrue(SwiftCharsetUtils.is_y('Y'));
		assertTrue(SwiftCharsetUtils.is_y('Z'));
		assertTrue(SwiftCharsetUtils.is_y('0'));
		assertTrue(SwiftCharsetUtils.is_y('1'));
		assertTrue(SwiftCharsetUtils.is_y('2'));
		assertTrue(SwiftCharsetUtils.is_y('3'));
		assertTrue(SwiftCharsetUtils.is_y('4'));
		assertTrue(SwiftCharsetUtils.is_y('5'));
		assertTrue(SwiftCharsetUtils.is_y('6'));
		assertTrue(SwiftCharsetUtils.is_y('7'));
		assertTrue(SwiftCharsetUtils.is_y('8'));
		assertTrue(SwiftCharsetUtils.is_y('9'));
		assertTrue(SwiftCharsetUtils.is_y(' '));
		assertTrue(SwiftCharsetUtils.is_y('.'));
		assertTrue(SwiftCharsetUtils.is_y(','));
		assertTrue(SwiftCharsetUtils.is_y('-'));
		assertTrue(SwiftCharsetUtils.is_y('('));
		assertTrue(SwiftCharsetUtils.is_y(')'));
		assertTrue(SwiftCharsetUtils.is_y('/'));
		assertTrue(SwiftCharsetUtils.is_y('='));
		assertTrue(SwiftCharsetUtils.is_y('\''));
		assertTrue(SwiftCharsetUtils.is_y('+'));
		assertTrue(SwiftCharsetUtils.is_y(':'));
		assertTrue(SwiftCharsetUtils.is_y('?'));
		assertTrue(SwiftCharsetUtils.is_y('!'));
		assertTrue(SwiftCharsetUtils.is_y('"'));
		assertTrue(SwiftCharsetUtils.is_y('%'));
		assertTrue(SwiftCharsetUtils.is_y('&'));
		assertTrue(SwiftCharsetUtils.is_y('*'));
		assertTrue(SwiftCharsetUtils.is_y(';'));
		assertTrue(SwiftCharsetUtils.is_y('<'));
		assertTrue(SwiftCharsetUtils.is_y('>'));
		
		assertFalse(SwiftCharsetUtils.is_y('$'));
		assertFalse(SwiftCharsetUtils.is_y('_'));
		assertFalse(SwiftCharsetUtils.is_y('{'));
		assertFalse(SwiftCharsetUtils.is_y('['));
		assertFalse(SwiftCharsetUtils.is_y(']'));
		assertFalse(SwiftCharsetUtils.is_y('@'));

		
		assertEquals(SwiftCharsetUtils.OK, SwiftCharsetUtils.is_y("KJAHSDJSHJKAHS876823 /DD78()+ DDFD<JJ>&%*\"\' 89?DD-43/D;!:=D"));
		assertEquals(0, SwiftCharsetUtils.is_y("$asdfasd"));
		assertEquals(1, SwiftCharsetUtils.is_y("YkUJUIk"));
		assertEquals(6, SwiftCharsetUtils.is_y("J3(YDF_"));
	}
	
	@Test
	public void test_z() throws Exception {
		log.info("z "+SwiftCharsetUtils.getAsString(SwiftCharsetUtils.get_z()));
		
		assertEquals(SwiftCharsetUtils.OK, SwiftCharsetUtils.is_z("KJAHSDJSsdfs@#HJKAHS876823 /DD78()+ DDFD<JJ>&%*\"\' 89?DD-43/D;!:=D"));
		assertEquals(0, SwiftCharsetUtils.is_z("$asdfasd"));
		assertEquals(SwiftCharsetUtils.OK, SwiftCharsetUtils.is_z("Y_UJUIk"));
		assertEquals(SwiftCharsetUtils.OK, SwiftCharsetUtils.is_z("J3(dDF_"));
	}
	
	@Test
	public void test_c() throws Exception {
		log.info("c "+SwiftCharsetUtils.getAsString(SwiftCharsetUtils.get_c()));
		
		assertEquals(SwiftCharsetUtils.OK, SwiftCharsetUtils.is_c("KASJDFSD8223JS2220983JFKSI12SFD5344678590LSKSFDMNCVXOW"));
		assertEquals(0, SwiftCharsetUtils.is_c("$asdfasd"));
		assertEquals(1, SwiftCharsetUtils.is_c("Y(UJUIk"));
		assertEquals(6, SwiftCharsetUtils.is_c("J3SSDF%"));
	}
	
	@Test
	public void test_B() throws Exception {
		log.info("B "+SwiftCharsetUtils.getAsString(SwiftCharsetUtils.get_B()));
		
		assertEquals(SwiftCharsetUtils.OK, SwiftCharsetUtils.is_B("KASJDFasdsSD8223JS22209ytJFKSI1dd2SFD5d344678590LSKSFDMNCVXOW"));
		assertEquals(0, SwiftCharsetUtils.is_B("$asdfasd"));
		assertEquals(1, SwiftCharsetUtils.is_B("s(UJUIk"));
		assertEquals(6, SwiftCharsetUtils.is_B("J3ssDF%"));
	}
	
	@Test
	public void test_filter() throws Exception {
		assertEquals("", SwiftCharsetUtils.filter("", SwiftCharset.x));
		assertEquals("abcd", SwiftCharsetUtils.filter("abcd", SwiftCharset.x));
		assertEquals("abcdEFG", SwiftCharsetUtils.filter("abcdEFG", SwiftCharset.x));
		assertEquals("abcdEFG 1234", SwiftCharsetUtils.filter("abcdEFG 1234", SwiftCharset.x));
		assertEquals("abcdEFG 1234", SwiftCharsetUtils.filter("abc%dEFG 1234", SwiftCharset.x));
		assertEquals("abcdE\nFG 1234/", SwiftCharsetUtils.filter("abc%dE\nFG 1234/", SwiftCharset.x));
	}
	
	@Test
	public void asString() throws Exception {
		String s = SwiftCharsetUtils.getAsString(SwiftCharset.a); 
		log.info("a" +s);
		assertFalse(s.contains("M"));
		assertTrue(s.contains("A"));
		assertTrue(s.contains("Z"));
		s = SwiftCharsetUtils.getAsString(SwiftCharset.A); 
		log.info("A" +s);
		assertFalse(s.contains("M"));
		assertTrue(s.contains("A"));
		assertTrue(s.contains("Z"));
		assertFalse(s.contains("m"));
		assertTrue(s.contains("a"));
		assertTrue(s.contains("z"));
		log.info("B" +SwiftCharsetUtils.getAsString(SwiftCharset.B));
		log.info("c" +SwiftCharsetUtils.getAsString(SwiftCharset.c));
		log.info("n" +SwiftCharsetUtils.getAsString(SwiftCharset.n));
		log.info("x" +SwiftCharsetUtils.getAsString(SwiftCharset.x));
		log.info("y" +SwiftCharsetUtils.getAsString(SwiftCharset.y));
		log.info("z" +SwiftCharsetUtils.getAsString(SwiftCharset.z));
	}
}
