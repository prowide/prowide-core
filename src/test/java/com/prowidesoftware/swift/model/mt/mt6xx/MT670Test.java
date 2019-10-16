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

package com.prowidesoftware.swift.model.mt.mt6xx;

import static org.junit.Assert.*;

import org.junit.Test;

import com.prowidesoftware.swift.model.mt.mt6xx.MT670;


public class MT670Test {

	@Test
	public void test1() {
		MT670 m = new MT670();
		m.append(MT670.SequenceB.newInstance(MT670.SequenceB2.newInstance()));
		assertTrue(m.getSequenceC().isEmpty());
		assertFalse(m.getSequenceB2List().isEmpty());
	}

	/**
	 * Sequence C and B2 use the same delimiter so we need to add parent sequence for unique find
	 */
	@Test
	public void test2() {
		MT670 m = new MT670();
		m.append(MT670.SequenceB.newInstance());
		m.append(MT670.SequenceC.newInstance());
		assertTrue(m.getSequenceB2List().isEmpty());
	}
	
	@Test
	public void test3() {
		MT670 m = new MT670();
		m.append(MT670.SequenceC.newInstance());
		assertFalse(m.getSequenceC().isEmpty());
	}
	
}
