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

import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.model.SwiftBlock;
import com.prowidesoftware.swift.model.SwiftTagListBlock;
import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.model.UnparsedTextList;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;


/**
 * Simple class that increases visibility of parser methods in 
 * order to unit tests them.
 *
 * @since 4.0
 */
public final class VisibleParser extends SwiftParser {
	
	public VisibleParser() {
		super();
	}
	
	public void simpleBlockConsumer(SwiftBlock b, String s) throws IOException {
		super.tagListBlockConsume( (SwiftTagListBlock) b, s);
	}
	
	public VisibleParser(InputStream is) {
		super(is);
	}
	
	public VisibleParser(Reader r) {
		super(r);
	}
	
	protected char identifyBlock(String s) {
		return super.identifyBlock(s);
	}
	
	public String findBlockStart() throws IOException {
		return super.findBlockStart();
	}
	
	public Tag consumeTag(String br) throws IOException {
		if (br.startsWith("{"))
			br = br.substring(1);
		if (br.endsWith("}"))
			br = br.substring(0, br.length() - 1);
		if (br.startsWith(":"))
			br = br.substring(1);
		return super.consumeTag(br, null);
	}
	
	/**
	 * @deprecated use {@link #consumeBlock(UnparsedTextList)} instead of this, <code>consumeBlock(null)</code> is acceptable
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear._2019)
	public SwiftBlock consumeBlock() throws IOException {
		DeprecationUtils.phase3(getClass(), "consumeBlock()", "Use consumeBlock(UnparsedTextList) instead, where consumeBlock() is acceptable.");
		return super.consumeBlock();
	}
	
	public String readUntilBlockEnds() throws IOException {
		return super.readUntilBlockEnds();
	}

	public int textTagEndBlock4(String s, int start, Boolean isTextBlock) {
		return super.textTagEndBlock4(s, start, isTextBlock);
	}

}