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
package com.prowidesoftware.swift.io.parser;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.prowidesoftware.swift.DeleteSchedule;
import com.prowidesoftware.swift.WifeException;
import com.prowidesoftware.swift.model.SwiftBlock;
import com.prowidesoftware.swift.model.SwiftBlock1;
import com.prowidesoftware.swift.model.SwiftBlock2Input;
import com.prowidesoftware.swift.model.SwiftBlock2Output;
import com.prowidesoftware.swift.model.SwiftBlock3;
import com.prowidesoftware.swift.model.SwiftBlock4;
import com.prowidesoftware.swift.model.SwiftBlock5;
import com.prowidesoftware.swift.model.SwiftBlockUser;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.SwiftTagListBlock;
import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.model.UnparsedTextList;
import com.prowidesoftware.swift.utils.Lib;

/**
 * FIN Parser. This implementation now properly supports all system messages (i.e: messages for MT 0xx) and
 * service messages (for example: ACK).<br />
 * As part of this, the following is now also accepted:<br />
 * <ul>
 * <li>Block 4 may be a non-text block (for example: {4:{101:xx}{102:xx}})</li>
 * <li>Support for unparsed texts (at message, block and tag levels)</li>
 * <li>Support for user defined blocks (for example: {S:{T01:xxx}{T02:yyy}})</li>
 * </ul><br/>
 * This is based in the old SwiftParser2, that is now deprecated.<br />
 *
 * @author www.prowidesoftware.com
 */
public class SwiftParser {

	/**
	 * Helper constant with the content of <code>System.getProperty("line.separator", "\n")</code>
	 */
	public static final String EOL = System.getProperty("line.separator", "\n");

	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftParser.class.getName());

	private Reader reader;

	private StringBuilder buffer;

	/**
	 * Reference to the current message being parsed.
	 * This should be used when some parsing decision needs to be made based on a previous item parsed,
	 * like a value in a previous tag or block.
	 */
	private SwiftMessage currentMessage;

	/**
	 * Errors found while parsing the message.
	 */
	@SuppressWarnings("rawtypes")
	private final List errors = new ArrayList();

	private int lastBlockStartOffset = 0;

	/**
	 * Indicates whether the parser is permissive or not.
	 * Has particular impact on parsing the headers blocks 1 and 2. Defaults to false.
	 * @since 7.8
	 */
	private SwiftParserConfiguration configuration = new SwiftParserConfiguration();

	/**
	 * Constructor with an input stream for parsing a message
	 * @param is stream to read
	 */
	public SwiftParser(final InputStream is) {
		this(new InputStreamReader(is));
	}

	/**
	 * Constructor with a reader for parsing a message
	 * @param r the Reader with the swift message to read
	 */
	public SwiftParser(final Reader r) {
		this();
		setReader(r);
	}

	/**
	 * Constructor with a String for parsing a message
	 * @param message the String with the swift message to read
	 */
	public SwiftParser(final String message) {
		this(new StringReader(message));
	}

	/**
	 * default constructor.<br />
	 * <b>NOTE</b>: If this constructor is called, setReader must be called to use the parser
	 */
	public SwiftParser() {
		super();
	}

	/**
	 * Create a parser and feed it with the contents of the given file
	 * @param messageFile existing, readable file to read
	 * @throws IOException if an error occurs during read
	 * @since 7.7
	 */
	public SwiftParser(final File messageFile) throws IOException {
		this(Lib.readFile(messageFile));
	}

	/**
	 * sets the input reader.<br />
	 * <b>NOTE</b>: this resets the internal buffer
	 * @param r the reader to use
	 */
	public void setReader(final Reader r) {
		this.buffer = new StringBuilder();
		this.reader = r;
	}

	/**
	 * sets the input data to the received string.
	 * @param data the data to use as input
	 */
	public void setData(final String data) {
		setReader(new StringReader(data));
	}

	/**
	 * Parse a SWIFT message into a data structure
	 *
	 * @return the parsed swift message object
	 * @throws IOException
	 */
	public SwiftMessage message() throws IOException {

		// create a message and store for local reference
		final SwiftMessage message = new SwiftMessage(false);
		this.currentMessage = message;

		// Clear all errors before starting the parse process
		this.errors.clear();
		try {
			boolean done = false;
			SwiftBlock b;
			do {
				// try to consume a block
				b = consumeBlock(message.getUnparsedTexts());
				if (b != null) {
					this.currentMessage.addBlock(b);
				} else {
					done = true;
				}
			} while (!done);
		} finally {
			// Clean the reference to the message being parsed
			this.currentMessage = null;
		}

		return message;
	}

	/**
	 * Sets the parameter string as this parser data and returns the parsed object.
	 *
	 * @param message the String with the swift message to parse
	 * @return the parsed swift message object
	 * @throws IOException
	 *
	 * @since 6.0
	 */
	//TODO hacer este metodo static
	public SwiftMessage parse(final String message) throws IOException {
		setData(message);
		return message();
	}

	/**
	 * @deprecated use {@link #consumeBlock(UnparsedTextList)} instead of this, <code>consumeBlock(null)</code> is acceptable
	 */
	@Deprecated
	@com.prowidesoftware.deprecation.ProwideDeprecated(phase2=com.prowidesoftware.deprecation.TargetYear._2017)
	protected SwiftBlock consumeBlock() throws IOException {
		return consumeBlock(null);
	}
	
	/**
	 * Consume the next block of the message on the reader.
	 * This methods seeks to a block start, then identifies the block
	 * and calls the proper method to consume the block type
	 * that is coming, not all blocks are parsed in the same manner.
	 * @param unparsedReceiver may be <code>null</code>, the unparsedTextList that will receive the chunks that can not be identified sas part of the message
	 *
	 * @return the next block in the reader or <code>null</code> if none was found (i.e: end of input)
	 * @throws IOException if an error occurred during read
	 */
	protected SwiftBlock consumeBlock(final UnparsedTextList unparsedReceiver) throws IOException {

		// search for block start
		final String unparsed = findBlockStart();
		
		// si el string es no vacio agregarlo a unparsed texts
		
		// read the block contents
		final String s = readUntilBlockEnds();
		if ("".equals(s)) {
			/* if we have an unparsed text add it to last block */
			if (unparsed.length()>0) {
				if (unparsedReceiver == null) {
					log.warning("Unparsed text '"+unparsed+"' can not be reported since unparsedReceiver is null");
				} else {
					unparsedReceiver.addText(unparsed);
				}
			}
			return null;
		}

		// analyze if it is an unparsed text
		//
		// NOTE: This can happen when we have got a block 1 and there is already a block 1
		//
		if (s.startsWith("1:") && this.currentMessage != null && this.currentMessage.getBlock1() != null) {

			// unparsed text => initialize value to append
			final StringBuilder utBuffer = new StringBuilder();
			utBuffer.append("{");
			utBuffer.append(s);
			utBuffer.append("}");
			boolean done = false;
			
			while (!done) {
				// try to read a block of data
				final char data[] = new char[128];
				final int size = this.reader.read(data);
				if (size > 0) {
					// append the read buffer
					utBuffer.append(data);
				} else {
					// we are done
					done = true;
				}
			}
			final String unparsedText = utBuffer.toString();

			// build an unparsed text list
			final UnparsedTextList list = processUnparsedText(unparsedText);
			if (list != null) {
				this.currentMessage.setUnparsedTexts(list);
			}

			// no more reading
			return null;
		}

		// identify and create the proper block
		final char blockId = identifyBlock(s);
		SwiftBlock b;
		if (blockId == ' ') {
			// block cannot be identified
			log.severe("unidentified block:" + s);
			throw new WifeException("The block " + s + " could not be identified");
		}

		// create the block object
		switch (blockId) {
		case '1': // block 1 (single valued)
			b = new SwiftBlock1(s, this.configuration.isLenient());
			break;
		case '2': // block 2 (single valued)
			if (isInput(s)) {
				b = new SwiftBlock2Input(s, this.configuration.isLenient());
			} else {
				b = new SwiftBlock2Output(s, this.configuration.isLenient());
			}
			break;
		case '3': // block 3 (tag list)
			b = tagListBlockConsume(new SwiftBlock3(), s);
			break;
		case '4': // block 4
			if (this.configuration.isParseTextBlock()) {
				if (isTextBlock(s)) {
					b = block4Consume(new SwiftBlock4(), s);
				} else {
					b = tagListBlockConsume(new SwiftBlock4(), s);
				}
			} else {
				b = new SwiftBlock4();
			}
			break;
		case '5': // block 5 (tag list)
			if (this.configuration.isParseTrailerBlock()) {
				b = tagListBlockConsume(new SwiftBlock5(), s);
			} else {
				b = new SwiftBlock5();
			}
			break;
		default: // user defined block (tag list)
			if (this.configuration.isParseUserBlock()) {
				b = tagListBlockConsume(new SwiftBlockUser(Character.toString(blockId)), s);
			} else {
				b = new SwiftBlockUser();
			}
			break;
		}

		if (unparsed.length()>0) {
			if (unparsedReceiver == null) {
				log.warning("Unparsed text '"+unparsed+"' can not be reported since unparsedReceiver is null");
			} else {
				unparsedReceiver.addText(unparsed);
			}
		}		
		return b;
	}

	/**
	 * Attempt to detect if block 2 refers to an input or output message
	 * @param s the block 2 value (as a FIN value)
	 * @return whether it's an input block 2 (true) or an output one (false)
	 */
	private boolean isInput(final String s) {
		// try to find out the in/out type
		final int i = s.indexOf(':');
		if (i >= 0 && (i + 1) < s.length()) {
			// check for input mark
			return Character.toUpperCase(s.charAt(i + 1)) == 'I';
		}
		return false;
	}

	/**
	 * consumes a tag list block (i.e: block 3, block 5 or user defined block)
	 *
	 * @param b the block to set up tags into
	 * @param s the block data to process
	 * @return the processed block (the parameter b)
	 * @throws IOException
	 */
	protected SwiftTagListBlock tagListBlockConsume(final SwiftTagListBlock b, final String s) throws IOException {
		// start processing the block data
		final int start = s.indexOf(':');
		if (start >= 0 && (start + 1) < s.length()) {
			final String data = s.substring(start + 1);

			/*
			 * Enter a loop that will read any block or inner data
			 * The idea is to accept equally these strings:
			 * {block1}{block2}
			 * data1{block1}data2{block2}data3
			 */
			for (int i = 0; i < data.length(); i++) {
				final char c = data.charAt(i);
				if (c == '{') {
					final int end = data.indexOf('}', i);
					if (end >= 0 && data.length() > end) {

						final String inner = data.substring(i + 1, end);
						// Seek the cursor to last 'processed' position
						i = end;
						final Tag t = new Tag(inner);
						log.finest("" + t);
						b.append(t);
					}
				} else {
					// read all the characters until data end or a new '{'
					int end;
					for (end = i; end < data.length() && data.charAt(end) != '{'; end++) {
						;
					}
					final String unparsedText = data.substring(i, end).trim();
					if (!"".equals(unparsedText)) {
						b.unparsedTextAddText(unparsedText);
					}
					i = end - 1;
				}
			}
		}

		return b;
	}

	/**
	 * Parses a block 4 from an input string. This method supports the two possible formats of
	 * a swift block 4:<br />
	 * <ul>
	 * <li><b>Text mode</b>: this is the common block 4 for categories 1 to 9.</li>
	 * <li><b>Tag mode</b>: this is the same format as for blocks 3 and 5. This format is used by
	 * service messages (for example: ACK) and system messages (category 0).</li>
	 * </ul><br />
	 *
	 * @param b the block to set up tags into
	 * @param s the block data to process
	 * @return the processed block (the parameter b)
	 * @throws IOException
	 */
	protected SwiftBlock4 block4Consume(final SwiftBlock4 b, final String s) throws IOException {
		/*
		 * Note that if the block4 is a text block last character is -, which is part of the EOB
		 * since the parser removes the last }
		 */

		// process by "tokenizing" the input, this meaning:
		// - skip the "4:" (block identifier)
		// - scan for a tag start character (maybe '{' or ':')
		//   - if start is '{' => find tag end by balancing braces => split tag (considering unparsed texts)
		//   - if start is ':' => find tag end as '<CR><LF>:[X]' => split tag (no unparsed texts)
		// - detect block end as '<CR><LF>-}' or '}'
		//
		int start = 0;
		if (s.charAt(start) == '4') {
			start++;
		}
		if (s.charAt(start) == ':') {
			start++;
		}

		final boolean isTextBlock = isTextBlock(s);

		Tag lastTag = null;
		// start processing tags
		while (start < s.length()) {

			// position ourselves at something meaningful
			int begin = start;
			char c = ' ', prev;
			do {
				prev = c;
				c = s.charAt(start++);
			} while (start < s.length() && c != ':' && c != '{' && !(prev=='-' && c == '}'));

			// check if we must correct end of unparsed text by "-}" (we don't want "-" to be unparsed text)
			int ignore = 0;
			if (c == '}') {
				if (s.charAt(start - 1) == '-') {
					ignore = 1;
				}
			}

			// check if we skipped an block unparsed text
			String unparsedText = s.substring(begin, start - ignore - 1).trim();
			if (!"".equals(unparsedText)) {
				b.unparsedTextAddText(unparsedText);
			}

			// if no more buffer => terminate
			if (start == s.length()) {
				continue;
			}

			// decide what are we looking at (notice that "-}" is detected by "}")
			int end = 0;
			String tag = null;
			String tagUnparsedText = null;
			switch (c) {
			case '}':
				// force termination only if  ending string is -}
				if ((isTextBlock && ignore==1) || !isTextBlock) {
					start = s.length();
				}
				/*
				 * De la terminacion anterior debemos contemplar que termino el mensaje de alguna forma porque
				 * parece que no se esta detectando bien y entra en loop infinito (bug reportado de hecho)
				 */
				/// TODO review this log seems to be part of an infinite loop
				log.severe("malformed message: exit by bracket");
				//				break;
			case ':':
				// get the tag text
				end = textTagEndBlock4(s, start, isTextBlock);
				tag = s.substring(start, end);
				break;
			case '{':
				// two things are possible here:
				// A) this is an unparsed text (i.e: the tag id is 1)
				// B) this is a valid tag (i.e: the tag id is not one)
				if (s.startsWith("1:", start)) {
					//
					// CASE A (an unparsed text)
					//
					
					// keep our position
					begin = start > 0 ? start - 1 : 0;
					end = begin + 1;
					while (end < s.length() && !s.startsWith("{1:", end)) {
						end = blockTagEnd(s, end + 1);
					}

					// get the unparsed text
					unparsedText = s.substring(begin, end);

					// add the unparsed text
					b.unparsedTextAddText(unparsedText);
				} else {
					//
					// CASE B (a tag)
					//

					// get the tag text
					end = blockTagEnd(s, start);
					tag = s.substring(start, end - 1);
					final int utPos = tag.indexOf("{1:");
					if (utPos != -1) {
						// separate unparsed texts from value
						tagUnparsedText = tag.substring(utPos);
						tag = tag.substring(0, utPos);
					}
				}
				break;
			} /* switch(c) */

			// process the tag (only if we have a tag)
			if (tag != null) {

				// process the tag
				final Tag t = consumeTag(tag, tagUnparsedText);
				if (t != null) {
					b.append(t);
					lastTag = t;
				}
			}

			// continue processing from the end of this tag
			start = end;
		}

		// Strip EOB from last tags value
		stripEOB(lastTag);

		return b;
	}

	private void stripEOB(final Tag lastTag) {
		if (lastTag != null) {
			final String v = lastTag.getValue();
			if (v != null) {
				/*
				 * In the parser we support both \r\n or \n as line separator
				 */
				if (v.endsWith("\r\n-")) {
					lastTag.setValue(v.substring(0, v.length()-3));
				} else if (v.endsWith("\n-")) {
					lastTag.setValue(v.substring(0, v.length()-2));
				}
			}
		}
	}

	/**
	 * finds the end of a text tag (i.e: ":TAG:VALUE"). This is used to parse block 4.<br />
	 * The function search the string looking for the occurrence of any of the sequences:<br />
	 * <ul>
	 * <li>"[LBR]:[X]"</li>
	 * <li>"[LBR]}"</li>
	 * <li>"[LBR]{"</li>
	 * <li>"}"</li>
	 * </ul>
	 * where "[LBR]" stands for any of: "[CR]", "[LF]" or "[CR][LF]"
	 * and "[X]" is any character other than [CR] and [LF].<br />
	 * Then considers the end of the tag as <b>NOT</b> containing the found sequence.<br />
	 * <b>NOTE</b>: the condition "-}" cannot happen because the terminating dash is already removed.<br />
	 *
	 * renamed to state clearly that this search is only used in block4Consume
	 *
	 * @param s the FIN input text
	 * @param start the position to start analysis at
	 * @return the position where the tag ends (excluding the &lt;CR&gt;&lt;LF&gt;)
	 */
	protected int textTagEndBlock4(final String s, int start, final boolean isTextBlock) {

		int i = start; 
		
		// start scanning for tag end
		for (; i < s.length(); i++) {

			// check if we found tag end
			char c = s.charAt(i);
			if (c == '\r' || c == '\n') {

				// keep this position
				final int begin = i;

				// repeat cause "\r\n", accept "\n\r" also
				if ((i + 1) == s.length()) {
					break;
				}
				c = s.charAt(++i);
				if (c == '\r' || c == '\n') {
					if ((i +1) == s.length()) {
						break;
					}
					c = s.charAt(++i);
				}

				// if open brace => it's a proper tag end (mixing BLOCK and TEXT tags, rare but...)
				// if closing brace => it's a proper tag end (because of block end)
				if ((!isTextBlock) && (c == '{' || c == '}' )) {
					// found it
					i = begin;
					break;
				}
				// if it's a colon followed by a character different than CR or LF (':x') => it's a proper tag end
				// because we have reached a new line with a beginning new tag.
				// Note: It is note sufficient to check for a starting colon because for some fields like
				// 77E for example, it is allowed the field content to have a ':<CR><LF>' as the second line
				// of its content.
				else if (c == ':' 
						&& i < s.length()/* prevent index out of bounds */  ) {
					// 2015.10 miguel 
					// check if :xxx matched regexp of field or not, break only if matches valid start of tag
					if (tagStarts(s.substring(i+1))) {
						i = begin;
						break;
					}
					//TODO evaluate if this is still needed or not
//					final char z = s.charAt(++start);
//					if (z != '\r' && z != '\n') {
//						// found it
//						start = begin;
//						break;
//					}
				}

				// not matched => skip current char and continue
				i = begin;
				continue;
			}

			// check if we found block end (as "-}")
			if (c == '-') {

				// check for closing brace
				c = (i + 1) < s.length() ? s.charAt(i + 1) : ' ';
				if (c == '}' && isTextBlock) {
					break;
				}
			}

			// check if we found block end (as "}")
			if (c == '}' && !isTextBlock) {
				break;
			}
		}

		return i;
	}

	private static final boolean tagStarts(final String str) {
		final int l = str.length();
		
		if (l>0 && !Character.isDigit(str.charAt(0))) {
			return false; 
		}
		
		// OK el primero es digito, el segundo puede ser dos cosas: letra o numero o :final
		if (l>1) {
			char c2 = str.charAt(1);
			if (c2 == ':') {
				/*
				 * 2015.10 miguel
				 * aceptamos :1: por compatibilidad, pero no es un proper tagname
				 */
				return true;
			}

			/*
			 * 2015.10 miguel
			 * idem antes, aceptamos :1A: por compatibilidad, pero no es un proper tagname
			 */
			if ( Character.isLetter(c2) && l>2 ) {
				if ( ':' == str.charAt(2)) {
					return true;
				}
			}

			//  el segundo char debe ser un numero
			// Cubre caso 11: y 11a:
			if ( Character.isDigit(c2) && l>2 ) {
				if ( ':' == str.charAt(2)) {
					return true;
				}
				if (l>3 && ':' == str.charAt(3) && Character.isLetter(str.charAt(2))) {
					return true;
				}
			}
			
		}
		return false;
	}

	/**
	 * Finds the end of a block tag (i.e: "{TAG:VALUE}"). This is used to parse blocks other than 4.<br />
	 * The function search the string looking for the occurrence of the sequence "}". It is important to
	 * note that curly braces are balanced along the search.
	 * @param s the FIN input text
	 * @param start the position to start analysis at
	 * @return the position where the tag ends (including the "}")
	 */
	private int blockTagEnd(final String s, int start) {
		// scan until end or end of string
		int balance = 0;
		char c;
		do {
			// analyze this position
			switch ((c = s.charAt(start++))) {
			case '{':
				balance++;
				break;
			case '}':
				balance--;
				break;
			}
		} while (start < s.length() && (balance >= 0 || (balance == 0 && c != '}')));
		return start;
	}

	/**
	 * Process the input as a tag. That is: split name and value (and possibly unparsed texts).<br />
	 * The received buffer contains only the pertinent data for the tag (name and value). Trailing
	 * [CR][LF] on the text <b>MUST</b> not be present.
	 *
	 * @param buffer the buffer containing the tag
	 * @param unparsedText the unparsed text to assign (use <code>null</code> if none is wanted).
	 * This single text is fragmented in multiple texts if there are more than one message.
	 * @return a swift Tag
	 * @throws IOException
	 */
	protected Tag consumeTag(final String buffer, final String unparsedText) throws IOException {
		// separate name and value
		final int sep = buffer.indexOf(':');
		String name = null;
		String value;
		if (sep != -1) {
			name = buffer.substring(0, sep);
			value = buffer.substring(sep + 1);
		} else {
			value = buffer;
		}

		// ignore empty tags (most likely, an "{}" in an unparsed text...)
		if ((name == null || name.equals("")) && (value == null || value.equals(""))) {
			return null; // no tag...
		}

		// remove terminating [CR][LF] (or any combination)
		int size = value.length();
		if (size > 0) {
			final char c = value.charAt(size - 1);
			if (c == '\r' || c == '\n') {
				size--;
			}
		}
		if (size > 0) {
			final char c = value.charAt(size - 1);
			if (c == '\r' || c == '\n') {
				size--;
			}
		}
		if (size != value.length()) {
			value = value.substring(0, size);
		}

		// build the tag
		//
		// NOTE: if we will use different Tag classes, here is the instantiation point
		//
		final Tag t = new Tag();
		if (name!=null) {
			t.setName(name);
			t.setValue(value);
		} else {
			log.severe("Avoiding tag with null name and value "+value);
			throw new IllegalArgumentException("Null name and value");
		}

		// if there is unparsed text => process it
		if (unparsedText != null) {
			t.setUnparsedTexts(processUnparsedText(unparsedText));
		}

		return t;
	}

	/**
	 * this method receives a string that is a sequence of unparsed text and splits it into
	 * different unparsed texts. The algorithm is to split on message begin (i.e: "{1:" and
	 * balance curly braces). This last thing ensures that a single message with unparsed text
	 * inner messages is treated as one single unparsed text.<br />
	 * That is:<br />
	 *
	 * <pre>
	 * {1:...}                 -- message block 1
	 * {4:...                  -- message block 4
	 *    {1:...}              -- \
	 *    {4:...               -- | one single unparsed text
	 *        {1:...}          -- | for block 4
	 *        {4:...}          -- /
	 *    }
	 * }
	 * </pre>
	 *
	 * @param unparsedText the unparsed text to split (this parameter cannot be <b>null</b>).
	 * @return the list of unparsed texts. This can be <b>null</b> if the input is the empty string.
	 */
	private UnparsedTextList processUnparsedText(final String unparsedText) {
		// prepare to process
		UnparsedTextList list = null;

		// we start a new unparsed text at every "{1:"
		int start = 0;
		while (start < unparsedText.length()) {

			// find the block end (balancing braces)
			int end = start + 1;
			while ((end + 1) < unparsedText.length() && !unparsedText.startsWith("{1:", end)) {
				end = blockTagEnd(unparsedText, end + 1);

				// include trailing white spaces
				while (end < unparsedText.length() && Character.isWhitespace(unparsedText.charAt(end))) {
					end++;
				}
			}

			// separate a text
			final String text = unparsedText.substring(start, end).trim();
			if (!"".equals(text)) {

				// add it to the list (create it if needed)
				if (list == null) {
					list = new UnparsedTextList();
				}
				list.addText(text);
			}

			// continue with next text
			start = end;
		}

		return list;
	}

	/**
	 * Identify the block to be consumed.
	 *
	 * @param s the block identifier
	 * @return the block identifier or a space if the block can not be identified
	 */
	protected char identifyBlock(final String s) {
		if (s != null && s.length() > 1) {
			final char c = s.charAt(0);
			if ('0' <= c && c <= '9') {
				return c;
			}
			if ('a' <= c && c <= 'z') {
				return c;
			}
			if ('A' <= c && c <= 'Z') {
				return c;
			}
		}
		return ' ';
	}

	/**
	 * Reads the buffer until end of block is reached.
	 * The initial character of the block must be already consumed and the
	 * reader has to be ready to consume the first character inside the block
	 *
	 * <p>This method assumes that the starting block character was consumed
	 * because that is required in order to identify the start of a block, and
	 * call this method which reads until this block ends.</p>
	 *
	 * @return a string with the block contents
	 * @throws IOException
	 */
	protected String readUntilBlockEnds() throws IOException {
		final int start = buffer==null?0:buffer.length();
		int len = 0;
		int c;

		/*
		 * Best effort reading includes this End Of Block (EOB) logic:
		 * first proper end of block or last block start.
		 */
		boolean checkNested = true;

		// starts holds the amount of blockstart chars encountered, when this method
		// is called, the initial block start was consumed, and therefore, this is initialized in 1
		// this is needed to be able to include inner {} inside blocks
		int starts = 1;
		boolean done = false;
		int count=0;
		Boolean isTextBlock = null;
		while (!done) {
			c = getChar();
			// check if we can set the textblock flag first
			if (isTextBlock == null && count++ >=3) {
				isTextBlock = isTextBlock();
				if (isTextBlock) {
					checkNested = false;
				}
			}
			// found EOF?
			if (c == -1) {
				done = true;
			} else {
				if (checkNested && isBlockStart((char) c)) {
					starts++;
				}
				if (isBlockEnd(isTextBlock, c)) {
					if (checkNested) {
						starts--;
						if (starts == 0) {
							done = true;
						} else {
							len++;
						}
					} else {
						done = true;
					}
				} else {
					len++;
				}
			}
		}

		final int end = start + len;

		return buffer.substring(start, end);
	}

	private boolean isTextBlock() {
		// hack to report as block4 only text blocks 4 , check data in buffer
		if (this.lastBlockStartOffset >=0 && buffer.length()>this.lastBlockStartOffset) {
			return isTextBlock(buffer.substring(this.lastBlockStartOffset));
		}
		return false;
	}
	/**
	 * Determines if the given string is the start of a textblock
	 */
	private boolean isTextBlock(final String s) {
		// hack to report as block4 only text blocks 4 , check data in buffer
		if (s.length()<3) {
			return false;
		}
		final int offset;
		if (s.charAt(0)=='{') {
			offset = 1;
		} else {
			offset = 0;
		}
		final char c1 = s.charAt(offset+0);
		final char c2 = s.charAt(offset+1);
		if (c1=='4' && c2==':'){
			int c = offset+2;
			char tmp;
			while ((offset+c)<s.length()) {
				tmp = s.charAt(offset+c);
				c++;
				if (tmp == '{') {
					return false;
				} else if (tmp == ':') {
					return true;
				}
			}
			// Notice: for all 4: default is true since it's more lenient than tagmode
			return true;
		}
		return false;
	}


	private final boolean isBlockEnd(final Boolean isTextBlock, final int curChar) {
		// check buffer
		if (isBlockEnd((char) curChar)) {
			if ((isTextBlock!=null) && isTextBlock.booleanValue()) {
				final char ult = buffer.charAt(buffer.length()-2);
				final char antUlt = buffer.charAt(buffer.length()-3);
				if (antUlt == '\n' && ult == '-' ) {
					return true;
				}
			} else {
				return true;
			}
		}
		return false;
	}

	private static final boolean isBlockEnd(final char c) {
		return c == '}';
	}

	/**
	 * read on the reader until a block start character or EOF is reached.
	 * @throws IOException if thrown during read
	 */
	protected String findBlockStart() throws IOException {
		final StringBuilder textUntilBlock = new StringBuilder();
		int c;
		do {
			c = getChar();
			textUntilBlock.append((char)c);
		} while (c != -1 && !isBlockStart((char) c));
		if (textUntilBlock.length()>0) {
			// el ultimo char es EOF of {, sea cual sea lo borramos
			textUntilBlock.deleteCharAt(textUntilBlock.length()-1);
		}
		
		// debug code
		//if (textUntilBlock.length()>0) log.fine("textUntilBlock: "+textUntilBlock.toString());
		
		return textUntilBlock.length()>0 ? textUntilBlock.toString() : StringUtils.EMPTY; 
	}

	private boolean isBlockStart(final char c) {
		if (c == '{') {
			lastBlockStartOffset = buffer.length()-1;
			return true;
		}
		return false;
	}

	/**
	 * Read a char from stream and append it to the inner buffer
	 * @return the next char read
	 * @throws IOException if an error occurs during read
	 */
	private final int getChar() throws IOException {
		final int c = reader.read();
		if (c >= 0) {
			buffer.append((char) c);
		}
		return c;
	}

	/**
	 * Get a copy of the errors found.
	 * users can manipulate this copy without affecting the original.
	 *
	 * @return the list of errors found
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List getErrors() {
		return new ArrayList(this.errors);
	}

	/**
	 * @deprecated use {@link #getConfiguration()} instead
	 */
	@Deprecated
	@DeleteSchedule(2016)
	public boolean isLenient() {
		return this.configuration.isLenient();
	}

	/**
	 * @deprecated use {@link #setConfiguration(SwiftParserConfiguration)} instead
	 */
	@Deprecated
	@DeleteSchedule(2016)
	public void setLenient(final boolean lenient) {
		this.configuration.setLenient(lenient);
	}

	/**
	 * Gets the current parse configuration
	 * @since 7.8
	 * @see SwiftParserConfiguration
	 */
	public SwiftParserConfiguration getConfiguration() {
		return configuration;
	}

	/**
	 * Sets a new parse configuration
	 * @since 7.8
	 * @param configuration new configuration
	 * @see SwiftParserConfiguration
	 */
	public void setConfiguration(final SwiftParserConfiguration configuration) {
		this.configuration = configuration;
	}
	
	/**
	 * Parses a string containing the text block of an MT message 
	 * @param s block content starting with "{4:\r\n" and ending with "\r\n-}"
	 * @return content parsed into a block 4 or an empty block 4 if string cannot be parsed
	 * @throws IOException
	 * @since 7.8.4
	 */
	static public SwiftBlock4 parseBlock4(String s) throws IOException {
		SwiftBlock4 b4 = new SwiftBlock4();
		String toParse = s;
		if (toParse.startsWith("{")) {
			toParse = toParse.substring(1);
		}
		if (toParse.endsWith("}")) {
			toParse = toParse.substring(0, toParse.length() - 1);
		}
		SwiftParser parser = new SwiftParser();
		return parser.block4Consume(b4, toParse);
	}
}
