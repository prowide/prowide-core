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
package com.prowidesoftware.swift.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;

import org.junit.Test;

import com.prowidesoftware.swift.io.parser.SwiftParser;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.Tag;

/**
 * Kantoro Erkulov
 * https://sourceforge.net/p/wife/discussion/544818/thread/8ba75d64/?limit=25#09f0
 */
public class CustomTagInParserTest {
	
	@Test
	public void test() throws IOException {
		final String fin = "{1:F01BIC0BANKAXXX0006222623}{2:I198BIC0BANKXXXXS}{4:\n" +
					":20:my_ref\n" +
					":CUSTOM_TAG:my_value\n" +
					"-}";
		SwiftParser swiftParser = new SwiftParser(fin);
		SwiftMessage swiftMessage = swiftParser.message();
		final Tag t20 = swiftMessage.getBlock4().getTagByName("20");
        final Tag tcustom = swiftMessage.getBlock4().getTagByName("CUSTOM_TAG");
        /*
         * we expect this to be null because CUSTOM_TAG is not a proper tag name and since
         * parser patch on October 2015 we check for proper tag names because a startign ':'
         * is note sufficient to check for a starting colon because for some fields like
         * 77E for example, it is allowed the field content to have a ':<CR><LF>' as the second line
         * of its content.
         */
        assertNull(tcustom);
        assertEquals("my_ref\n:CUSTOM_TAG:my_value", t20.getValue());
	}

}
