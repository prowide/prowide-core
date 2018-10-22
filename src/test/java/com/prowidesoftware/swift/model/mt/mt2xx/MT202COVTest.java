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

package com.prowidesoftware.swift.model.mt.mt2xx;

import com.prowidesoftware.swift.model.field.*;
import org.junit.Test;
import org.junit.Ignore;

import static org.junit.Assert.*;

public class MT202COVTest {

	@Test
	public void test1() {
		MT202COV m = new MT202COV();
		assertNotNull(m.getUETR());
		assertTrue(m.getSwiftMessage().isCOV());
	}

	@Ignore("the newInstance API in sequence with no delimiters 16RS should be revamped because it is misleading")
	@Test
	public void test2() {
		MT202COV m = new MT202COV()
				.append(MT202COV.SequenceA.newInstance(
						Field20.tag("REF"),
						Field21.tag("RELREF"),
						Field32A.tag("121212USD1234,56"),
						Field58A.tag("ABCOCOBMXXX")))
				.append(MT202COV.SequenceB.newInstance(
						Field50A.tag("DEFOCOBMXXX"),
						Field59A.tag("GHIOCOBMXXX")));
		assertNotNull(m.getUETR());
		assertTrue(m.getSwiftMessage().isCOV());
		assertEquals(6, m.getSwiftMessage().getBlock4().getTags().size());
	}
	
}
