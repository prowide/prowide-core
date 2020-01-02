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

import com.prowidesoftware.swift.model.Tag;

import java.io.IOException;


/**
 * Simple class that increases visibility of parser methods in order to unit tests them.
 *
 * @since 4.0
 */
final class VisibleParser extends SwiftParser {
	
	public VisibleParser() {
		super();
	}

	@Override
	protected char identifyBlock(String s) {
		return super.identifyBlock(s);
	}

	@Override
	public String findBlockStart() throws IOException {
		return super.findBlockStart();
	}
	
	public Tag consumeTag(String br) {
		if (br.startsWith("{"))
			br = br.substring(1);
		if (br.endsWith("}"))
			br = br.substring(0, br.length() - 1);
		if (br.startsWith(":"))
			br = br.substring(1);
		return super.createTag(br, null);
	}

	@Override
	public String readUntilBlockEnds() throws IOException {
		return super.readUntilBlockEnds();
	}

	@Override
	public int findEndOfTagByLineFeed(String s, int start, boolean isTextBlock) {
		return super.findEndOfTagByLineFeed(s, start, isTextBlock);
	}

}