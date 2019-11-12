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
package com.prowidesoftware.swift.io.writer;

import com.prowidesoftware.ProwideException;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.IMessageVisitor;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;

/**
 * Main class for writing SwiftMessage objects into SWIFT FIN message text.
 *
 * <p>The implementation preserves the EOLS as they are found in the message object. This is particularly important for
 * block 4 where fields can have multiple lines. To serialize into a compliant FIN text you can apply
 * {@link SwiftWriter#ensureEols(String)} to the result.
 */
public class FINWriterVisitor implements IMessageVisitor {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(FINWriterVisitor.class.getName());

	/**
	 * EOL as defined by swift
	 */
	public static final String SWIFT_EOL = "\r\n";

	private Writer  writer;
	private boolean block4asText = true;
	private boolean trimTagValues = false;

	/**
	 * @return true if the visitor is setup to trim tag values
	 * @since 8.0.2
	 */
	public boolean isTrimTagValues() {
		return trimTagValues;
	}

	/**
	 * @param trimTagValues true if the visitor should trim tag values (it is false by default)
	 * @since 8.0.2
	 */
	public void setTrimTagValues(boolean trimTagValues) {
		this.trimTagValues = trimTagValues;
	}

	/**
	 * @param writer
	 */
	public FINWriterVisitor(Writer writer) {
		this.writer = writer;
	}

	////////////////////////////////////////////////////////////
	//
	// MESSAGE HANDLING
	//
	////////////////////////////////////////////////////////////
	public void startMessage(SwiftMessage m) {

		// initialize status
		this.block4asText = true;

		// If app identifier NOT 'F' OR service identifier NOT '01'  	=> USE TAG-BLOCK  syntax
		// If message type is category 0                      			=> USE TAG-BLOCK  syntax
		// Otherwise													=> USE TEXT-BLOCK syntax

		SwiftBlock1 b1 = m != null ? m.getBlock1() : null;
		// if b1 not empty
		if (b1 != null && StringUtils.isNotEmpty(b1.getValue())) {
			// check for app id and service id
			boolean isAppIdOrServiceId = !StringUtils.equals(b1.getApplicationId(), "F") || !StringUtils.equals(b1.getServiceId(), "01");
			if (isAppIdOrServiceId) {
				// if app identifier NOT 'F' OR service identifier NOT '01' => USE TAG-BLOCK syntax
				this.block4asText = false;
			}
		}
		
		SwiftBlock2 b2 = m != null ? m.getBlock2() : null;
		// if b2 not empty
		if (b2 != null && StringUtils.isNotEmpty(b2.getValue())) {
			// check for message category
			String mt = StringUtils.trimToEmpty(b2.getMessageType());
			if (mt.startsWith("0")) {
				// if message type is category 0 => USE TAG-BLOCK  syntax
				this.block4asText = false;
			}
		}
	}

	public void endMessage(SwiftMessage m) {

		// if message has unparsed texts, write them down
		//
		// IMPORTANT: do not just "write(m.getUnparsedTexts())" because this latest method actually
		//            creates the object if not already there. Guard this with the size "if" that is
		//            safe (returns 0 if there is no list or real size otherwise).
		if (m.getUnparsedTextsSize() > 0)
			write(m.getUnparsedTexts());

		// cleanup status
		this.block4asText = true;
	}

	////////////////////////////////////////////////////////////
	//
	// BLOCK 1
	//
	////////////////////////////////////////////////////////////
	public void startBlock1(SwiftBlock1 b) {
		write("{1:");
	}

	public void value(SwiftBlock1  b, String v) {
		if (StringUtils.isNotEmpty(v)) {
			write(v);
		}
	}

	public void endBlock1(SwiftBlock1 b) {

		// if block has unparsed texts, write them down
		//
		// IMPORTANT: do not just "write(m.getUnparsedTexts())" because this latest method actually
		//            creates the object if not already there. Guard this with the size "if" that is
		//            safe (returns 0 if there is no list or real size otherwise).
		if (b.getUnparsedTextsSize() > 0)
			write(b.getUnparsedTexts());

		// write block termination
		write("}");
	}

	////////////////////////////////////////////////////////////
	//
	// BLOCK 2
	//
	////////////////////////////////////////////////////////////
	public void startBlock2(SwiftBlock2 b) {
		write("{2:");
	}

	public void value(SwiftBlock2 b, String v) {
		if (StringUtils.isNotEmpty(v)) {
			write(v);
		}
	}

	public void endBlock2(SwiftBlock2 b) {

		// if block has unparsed texts, write them down
		//
		// IMPORTANT: do not just "write(m.getUnparsedTexts())" because this latest method actually
		//            creates the object if not already there. Guard this with the size "if" that is
		//            safe (returns 0 if there is no list or real size otherwise).
		if (b.getUnparsedTextsSize() > 0)
			write(b.getUnparsedTexts());

		// write block termination
		write("}");
	}

	////////////////////////////////////////////////////////////
	//
	// BLOCK 3
	//
	////////////////////////////////////////////////////////////
	public void startBlock3(SwiftBlock3 b) {
		write("{3:");
	}

	public void tag(SwiftBlock3 b, Tag t) {
		appendBlockTag(t);
	}

	public void endBlock3(SwiftBlock3 b) {

		// if block has unparsed texts, write them down
		//
		// IMPORTANT: do not just "write(m.getUnparsedTexts())" because this latest method actually
		//            creates the object if not already there. Guard this with the size "if" that is
		//            safe (returns 0 if there is no list or real size otherwise).
		if (b.getUnparsedTextsSize() > 0)
			write(b.getUnparsedTexts());

		// write block termination
		write("}");
	}

	////////////////////////////////////////////////////////////
	//
	// BLOCK 4
	//
	////////////////////////////////////////////////////////////
	public void startBlock4(SwiftBlock4 b) {
		write("{4:" + (this.block4asText ? SWIFT_EOL : ""));
	}

	public void tag(SwiftBlock4 b, Tag t) {
		if (this.block4asText) {
			appendTextTag(t);
		} else {
			appendBlockTag(t);
		}
	}

	public void endBlock4(SwiftBlock4 b) {

		// if block has unparsed texts, write them down
		//
		// IMPORTANT: do not just "write(m.getUnparsedTexts())" because this latest method actually
		//            creates the object if not already there. Guard this with the size "if" that is
		//            safe (returns 0 if there is no list or real size otherwise).
		if (b.getUnparsedTextsSize() > 0)
			write(b.getUnparsedTexts());

		// write block termination
		write( (this.block4asText ? "-" : "") + "}");
	}

	////////////////////////////////////////////////////////////
	//
	// BLOCK 5
	//
	////////////////////////////////////////////////////////////
	public void startBlock5(SwiftBlock5 b) {
		write("{5:");
	}

	public void tag(SwiftBlock5 b, Tag t) {
		appendBlockTag(t);
	}

	public void endBlock5(SwiftBlock5 b) {

		// if block has unparsed texts, write them down
		//
		// IMPORTANT: do not just "write(m.getUnparsedTexts())" because this latest method actually
		//            creates the object if not already there. Guard this with the size "if" that is
		//            safe (returns 0 if there is no list or real size otherwise).
		if (b.getUnparsedTextsSize() > 0)
			write(b.getUnparsedTexts());

		// write block termination
		write("}");
	}

	////////////////////////////////////////////////////////////
	//
	// USER DEFINED BLOCK
	//
	////////////////////////////////////////////////////////////
	public void startBlockUser(SwiftBlockUser b) {
		write("{" + b.getName() + ":");
	}

	public void tag(SwiftBlockUser b, Tag t) {
		appendBlockTag(t);
	}

	public void endBlockUser(SwiftBlockUser b) {

		// if block has unparsed texts, write them down
		//
		// IMPORTANT: do not just "write(m.getUnparsedTexts())" because this latest method actually
		//            creates the object if not already there. Guard this with the size "if" that is
		//            safe (returns 0 if there is no list or real size otherwise).
		if (b.getUnparsedTextsSize() > 0)
			write(b.getUnparsedTexts());

		// write block termination
		write("}");
	}

	////////////////////////////////////////////////////////////
	//
	// DEPRECATED
	//
	////////////////////////////////////////////////////////////
	public void tag(SwiftBlock b, Tag t) {
		if (b == null)
			return;
		if (b instanceof SwiftBlock3) {
			tag( (SwiftBlock3) b, t);
		}
		if (b instanceof SwiftBlock4) {
			tag( (SwiftBlock4) b, t);
		}
		if (b instanceof SwiftBlock5) {
			tag( (SwiftBlock5) b, t);
		}
		if (b instanceof SwiftBlockUser) {
			tag( (SwiftBlockUser) b, t);
		}
	}

	////////////////////////////////////////////////////////////
	//
	// INTERNAL METHODS
	//
	////////////////////////////////////////////////////////////
	private void appendBlockTag(Tag t) {
		// this goes: "{<tag>:<value>}" (quotes not included)
		
		// empty tags are not written
		if (StringUtils.isEmpty(t.getName()) && StringUtils.isEmpty(t.getValue())) {
			return;
		}

		// we don't trim the value to preserve trailing spaces, but we avoid printing null
		if (StringUtils.isNotEmpty(t.getName())) {
			// we have name
			write("{" + t.getName() + ":" + notNullValue(t));
		} else {
			// no name but value => {<value>}
			write("{" + notNullValue(t));
		}

		// if tag has unparsed texts, write them down.
		// this goes "{<tag>:<value>unparsed_texts}" (NOTICE that unparsed text goes inside tag braquets)
		//
		// IMPORTANT: do not just "write(m.getUnparsedTexts())" because this latest method actually
		//            creates the object if not already there. Guard this with the size "if" that is
		//            safe (returns 0 if there is no list or real size otherwise).
		if (t.getUnparsedTextsSize() > 0)
			write(t.getUnparsedTexts());
		
		// write closing braquets
		write("}");
	}

	/**
	 * Returns the tag value ensuring it is not null, if the value is null it will be printed as empty.
	 * Depending on the parameter of {@link #setTrimTagValues(boolean)} the value will also be trimmed.
	 */
	private String notNullValue(Tag t) {
		if (this.trimTagValues) {
			// trim all values
			return StringUtils.trimToEmpty(t.getValue());
		} else if (t.getValue() == null) {
			// avoid null
			return "";
		} else {
			// preserve if not null and trim is not explicitly required
			return t.getValue();
		}
	}

	private void appendTextTag(Tag t) {
		// this goes: ":<tag>:<value>[CRLF]" (quotes not included)
		if (StringUtils.isNotEmpty(t.getName())) {
			// we don't trim the value to preserve trailing spaces, but we avoid printing null
			write(":" + t.getName() + ":" + notNullValue(t) + SWIFT_EOL);
		}

		// if tag has unparsed texts, write them down
		//
		// IMPORTANT: do not just "write(m.getUnparsedTexts())" because this latest method actually
		//            creates the object if not already there. Guard this with the size "if" that is
		//            safe (returns 0 if there is no list or real size otherwise).
		if (t.getUnparsedTextsSize() > 0) {
			write(t.getUnparsedTexts());
		}
	}


	/**
	 * Returns the tags value.
	 * 
	 * @param t
	 * @param block
	 * @return the tag value removing the block number if present
	 */
	protected String getTagValue(final Tag t, final int block) {
		/*
		 * If the value starts with block number and the tag is unnamed,
		 * assume is block data and avoid repeating block number 
		 */
		String s = t.getValue();
		if (t.getName()==null && s.startsWith(block+":") && s.length()>2) {
			return s.substring(2);
		}
		return s;
	}

	private void write(UnparsedTextList texts) {
		// write the unparsed texts (if any)
		if (texts.size() > 0) {
			for(int i = 0; i < texts.size(); i++) {
				if (texts.isMessage(i))
					write(texts.getText(i));
			}
		}
	}

	private void write(String s) {
		try {
			writer.write(s);
		} catch (IOException e) {
			log.log(Level.SEVERE, "Caught exception in FINWriterVisitor, method write", e);
			throw new ProwideException(e);
		}
	}

}
