/*******************************************************************************
 * Copyright (c) 2016 Prowide Inc.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as 
 *     published by the Free Software Foundation, either version 3 of the 
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 *     
 *     Check the LGPL at <http://www.gnu.org/licenses/> for more details.
 *******************************************************************************/
package com.prowidesoftware.swift.io.writer;

import java.io.IOException;
import java.io.Writer;
import java.util.logging.Level;

import org.apache.commons.lang.StringUtils;

import com.prowidesoftware.swift.WifeException;
import com.prowidesoftware.swift.model.SwiftBlock;
import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftBlock2;
import com.prowidesoftware.swift.model.SwiftBlock3;
import com.prowidesoftware.swift.model.SwiftBlock4;
import com.prowidesoftware.swift.model.SwiftBlock5;
import com.prowidesoftware.swift.model.SwiftBlockUser;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.model.UnparsedTextList;
import com.prowidesoftware.swift.utils.IMessageVisitor;

/**
 * Main class for writing SwiftMessage objects into SWIFT FIN message text.
 * 
 * @author www.prowidesoftware.com
 */
public class FINWriterVisitor implements IMessageVisitor {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(FINWriterVisitor.class.getName());

	/**
	 * EOL as defined by swift
	 */
	public static final String SWIFT_EOL = "\r\n";

	private Writer  writer;
	private Boolean block4asText = Boolean.TRUE;

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
		this.block4asText = Boolean.TRUE;

		// If app identifier NOT 'F' OR service identifier NOT '01'  	=> USE TAG-BLOCK  syntax
		// If message type is category 0                      			=> USE TAG-BLOCK  syntax
		// Otherwise													=> USE TEXT-BLOCK syntax

		SwiftBlock1 b1 = m != null ? m.getBlock1() : null;
		// if b1 not empty
		if (b1 != null && StringUtils.isNotEmpty(b1.getValue())) {
			// check for app id and service id
			String appId  = b1.getApplicationId() != null ? b1.getApplicationId() : "";  
			String servId = b1.getServiceId()     != null ? b1.getServiceId()     : "";
			if (!appId.equals("F") || !servId.equals("01")) {
				// if app identifier NOT 'F' OR service identifier NOT '01' => USE TAG-BLOCK syntax
				this.block4asText = Boolean.FALSE;
			}
		}
		
		SwiftBlock2 b2 = m != null ? m.getBlock2() : null;
		// if b2 not empty
		if (b2 != null && StringUtils.isNotEmpty(b2.getValue())) {
			// check for message category
			String mt = b2.getMessageType() != null ? b2.getMessageType() : "";
			if (mt.startsWith("0")) {
				// if message type is category 0 => USE TAG-BLOCK  syntax
				this.block4asText = Boolean.FALSE;
			}
		}
	}

	public void endMessage(SwiftMessage m) {

		// if message has unparsed texts, write them down
		//
		// IMPORTANT: do not just "write(m.getUnparsedTexts())" because this latest method actually
		//            creates the object if not already there. Guard this with the size "if" that is
		//            safe (returns 0 if there is no list or real size otherwise).
		if (m.getUnparsedTextsSize().intValue() > 0)
			write(m.getUnparsedTexts());

		// cleanup status
		this.block4asText = Boolean.TRUE;
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
		if (v != null && ! v.equals(""))
			write(v);
	}

	public void endBlock1(SwiftBlock1 b) {

		// if block has unparsed texts, write them down
		//
		// IMPORTANT: do not just "write(m.getUnparsedTexts())" because this latest method actually
		//            creates the object if not already there. Guard this with the size "if" that is
		//            safe (returns 0 if there is no list or real size otherwise).
		if (b.getUnparsedTextsSize().intValue() > 0)
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
		if (v != null && ! v.equals(""))
			write(v);
	}

	public void endBlock2(SwiftBlock2 b) {

		// if block has unparsed texts, write them down
		//
		// IMPORTANT: do not just "write(m.getUnparsedTexts())" because this latest method actually
		//            creates the object if not already there. Guard this with the size "if" that is
		//            safe (returns 0 if there is no list or real size otherwise).
		if (b.getUnparsedTextsSize().intValue() > 0)
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
		if (b.getUnparsedTextsSize().intValue() > 0)
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
		write("{4:" + (this.block4asText.booleanValue() ? SWIFT_EOL : ""));
	}

	public void tag(SwiftBlock4 b, Tag t) {
		if (this.block4asText.booleanValue()) {
			appendTextTag(t);
		} else {
			appendBlockTag(t);
		};
	}

	public void endBlock4(SwiftBlock4 b) {

		// if block has unparsed texts, write them down
		//
		// IMPORTANT: do not just "write(m.getUnparsedTexts())" because this latest method actually
		//            creates the object if not already there. Guard this with the size "if" that is
		//            safe (returns 0 if there is no list or real size otherwise).
		if (b.getUnparsedTextsSize().intValue() > 0)
			write(b.getUnparsedTexts());

		// write block termination
		write( (this.block4asText.booleanValue() ? "-" : "") + "}");
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
		if (b.getUnparsedTextsSize().intValue() > 0)
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
		if (b.getUnparsedTextsSize().intValue() > 0)
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
		};
		if (b instanceof SwiftBlock4) {
			tag( (SwiftBlock4) b, t);
		};
		if (b instanceof SwiftBlock5) {
			tag( (SwiftBlock5) b, t);
		};
		if (b instanceof SwiftBlockUser) {
			tag( (SwiftBlockUser) b, t);
		};
	}

	////////////////////////////////////////////////////////////
	//
	// INTERNAL METHODS
	//
	////////////////////////////////////////////////////////////
	private final void appendBlockTag(Tag t) {

		// this goes: "{<tag>:<value>}" (quotes not included)
		String name  = t.getName()  != null ? t.getName()  : "";
		String value = t.getValue() != null ? t.getValue() : "";
		
		// empty tags are not written
		if (name.equals("") && value.equals("")) return;
		
		if ( ! name.equals("")) {
			// we have name
			write("{" + name + ":" + value);
		} else {
			// no name but value => {<value>}
			write("{" + value);
		};

		// if tag has unparsed texts, write them down.
		// this goes "{<tag>:<value>unparsed_texts}" (NOTICE that unparsed text goes inside tag braquets)
		//
		// IMPORTANT: do not just "write(m.getUnparsedTexts())" because this latest method actually
		//            creates the object if not already there. Guard this with the size "if" that is
		//            safe (returns 0 if there is no list or real size otherwise).
		if (t.getUnparsedTextsSize().intValue() > 0)
			write(t.getUnparsedTexts());
		
		// write closing braquets
		write("}");
	}
	
	private final void appendTextTag(Tag t) {

		// this goes: ":<tag>:<value>[CRLF]" (quotes not included)
		String name  = t.getName()  != null ? t.getName()  : "";
		String value = t.getValue() != null ? t.getValue() : "";
		if ( ! name.equals(""))
			write(":" + name + ":" + value + SWIFT_EOL);

		// if tag has unparsed texts, write them down
		//
		// IMPORTANT: do not just "write(m.getUnparsedTexts())" because this latest method actually
		//            creates the object if not already there. Guard this with the size "if" that is
		//            safe (returns 0 if there is no list or real size otherwise).
		if (t.getUnparsedTextsSize().intValue() > 0)
			write(t.getUnparsedTexts());
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
		 * If the value starts with blocknumber and the tag is unnamed,
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
		if (texts.size().intValue() > 0) {
			for(int i = 0; i < texts.size().intValue(); i++) {
				if (texts.isMessage(new Integer(i)).booleanValue())
					write(texts.getText(new Integer(i)));
			};
		};
	}

	private void write(String s) {
		try {
			writer.write(s);
		} catch (IOException e) {
			log.log(Level.SEVERE, "Caught exception in FINWriterVisitor, method write", e);
			throw new WifeException(e);
		};
	}

}
