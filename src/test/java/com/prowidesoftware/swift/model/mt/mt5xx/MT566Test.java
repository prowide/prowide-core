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

package com.prowidesoftware.swift.model.mt.mt5xx;

import static org.junit.Assert.*;

import org.junit.Test;

import com.prowidesoftware.swift.model.mt.mt5xx.MT566;


public class MT566Test {

	/**
	 * Sequence B1 and D1a use the same delimiter so we need to add parent sequence for unique find
	 */
	@Test
	public void test1() {
		MT566 m = new MT566();
		m.append(MT566.SequenceB1.newInstance());
		m.append(MT566.SequenceD1.newInstance());
		assertTrue(m.getSequenceD1aList().isEmpty());
	}

	/**
	 * Sequence B1 and D1a use the same delimiter so we need to add parent sequence for unique find
	 */
	@Test
	public void test2() {
		MT566 m = new MT566();
		m.append(MT566.SequenceB.newInstance());
		m.append(MT566.SequenceD1a.newInstance());
		assertTrue(m.getSequenceB1List().isEmpty());
	}
	
}
