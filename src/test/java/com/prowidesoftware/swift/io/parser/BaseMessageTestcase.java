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
package com.prowidesoftware.swift.io.parser;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;

import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftBlock2;
import com.prowidesoftware.swift.model.SwiftBlock3;
import com.prowidesoftware.swift.model.SwiftBlock4;
import com.prowidesoftware.swift.model.SwiftBlock5;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.Tag;

/**
 * Base class for tests of specific message types
 *
 * @since 4.0
 */
public abstract class BaseMessageTestcase {

	protected SwiftBlock1 b1;
	protected SwiftBlock2 b2;
	protected SwiftBlock3 b3;
	protected SwiftBlock4 b4;
	protected SwiftBlock5 b5;
	protected SwiftMessage o;
	protected Tag [] tags;
	protected Tag t;
	protected String messageToParse;

	protected SwiftParser buildParser(String filename) {
		InputStream is = getInputStream(filename);
		SwiftParser parser = new SwiftParser(is);
		return parser;
	}

	protected InputStream getInputStream(String filename) {
		InputStream is = getClass().getResourceAsStream(filename);
		if (is == null) {
			fail(filename + " not found in classpath");
		}
		return is;
	}

	protected String readMessageFromInputStream(InputStream is) {
		// prepare the output
		String s = null;
		try {
			StringBuilder msgBuf = new StringBuilder();

            // append until $ or EOF
            int c;
            do {
                c = is.read();
                if (c != '$' && c != -1)
                    msgBuf.append( (char) c);
            } while (c != '$' && c != -1);

            // check for end of input
            if (msgBuf.length() > 0)
                s = msgBuf.toString();
		} catch (IOException e) {
			fail("Reading input file: FAILED [" + e.getMessage() + "]");
		}
		return(s);
    }

	protected SwiftMessage parseMessage(String msg) {
		o = null;
		try {
			final SwiftParser parser = new SwiftParser(new StringReader(msg));
			o = parser.message();
			if (o!=null) {
				this.b1 = o.getBlock1();
				this.b2 = o.getBlock2();
				this.b3 = o.getBlock3();
				this.b4 = o.getBlock4();
				this.b5 = o.getBlock5();
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail("Parsing of: " + msg + " failed: " + e);
		}
		assertNotNull(o);
		return o;
	}

	protected SwiftMessage parseResource(String m) {
		o = null;
		try {
			o = buildParser(m).message();
			if (o!=null) {
				this.b1 = o.getBlock1();
				this.b2 = o.getBlock2();
				this.b3 = o.getBlock3();
				this.b4 = o.getBlock4();
				this.b5 = o.getBlock5();
			}
		} catch (IOException e) {
			e.printStackTrace();
			fail("Parsing of: " + m + " failed: " + e);
		}
		assertNotNull(o);
		return o;
	}

	/**
	 * Asserts that the given message and blocks 1-5 are not null
	 * @param o the swift message
	 */
	protected void assertAllBlocksNonNull(SwiftMessage o) {
		assertNotNull(o);
		assertNotNull("Block 1 is null", o.getBlock1());
		assertNotNull("Block 2 is null", o.getBlock2());
		assertNotNull("Block 3 is null", o.getBlock3());
		assertNotNull("Block 4 is null", o.getBlock4());
		assertNotNull("Block 5 is null", o.getBlock5());
	}

}
