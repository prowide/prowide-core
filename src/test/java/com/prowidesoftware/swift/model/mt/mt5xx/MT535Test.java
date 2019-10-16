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

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;

public class MT535Test {

	@Ignore("B1b1 and B1c cannot be uniquely identified in this context")
	@Test
	public void test1() {
		MT535 m = new MT535();
		m.append(MT535.SequenceB1b.newInstance(MT535.SequenceB1b1.newInstance()));
		assertTrue(m.getSequenceB1cList().isEmpty());
	}

	@Ignore("B1b1 and B1c cannot be uniquely identified in this context")
	@Test
	public void test1a() {
		MT535 m = new MT535();
		m.append(MT535.SequenceB.newInstance(MT535.SequenceB1b1.newInstance()));
		assertTrue(m.getSequenceB1cList().isEmpty());
	}

	/**
	 * Sequence B1b1 and B1c use the same delimiter so we need to add parent sequence for unique find
	 */
	@Test
	public void test1b() {
		MT535 m = new MT535();
		m.append(MT535.SequenceB1.newInstance());
		m.append(MT535.SequenceB1b1.newInstance());
		assertTrue(m.getSequenceB1cList().isEmpty());
	}

	/**
	 * Sequence B1b1 and B1c use the same delimiter so we need to add parent sequence for unique find
	 */
	@Test
	public void test2() {
		MT535 m = new MT535();
		m.append(MT535.SequenceB1b.newInstance());
		m.append(MT535.SequenceB1c.newInstance());
		assertTrue(m.getSequenceB1b1List().isEmpty());
	}
	
}
