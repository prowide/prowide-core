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
*/
package com.prowidesoftware.swift.io.parser;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.model.SwiftBlock;
import com.prowidesoftware.swift.model.SwiftTagListBlock;
import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.model.UnparsedTextList;


/**
 * Simple class that increases visibility of parser methods in 
 * order to unit tests them.
 * 
 * @author www.prowidesoftware.com
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
	@ProwideDeprecated(phase3=TargetYear._2018)
	public SwiftBlock consumeBlock() throws IOException {
		return super.consumeBlock();
	}
	
	public String readUntilBlockEnds() throws IOException {
		return super.readUntilBlockEnds();
	}

	public int textTagEndBlock4(String s, int start, Boolean isTextBlock) {
		return super.textTagEndBlock4(s, start, isTextBlock);
	}
}