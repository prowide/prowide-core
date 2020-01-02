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

import com.prowidesoftware.ProwideException;
import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.Lib;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * FIN Parser. This implementation now properly supports all system messages (i.e: messages for MT 0xx) and
 * service messages (for example: ACK).<br>
 * As part of this, the following is now also accepted:<br>
 * <ul>
 * <li>Block 4 may be a non-text block (for example: {4:{101:xx}{102:xx}})</li>
 * <li>Support for unparsed texts (at message, block and tag levels)</li>
 * <li>Support for user defined blocks (for example: {S:{T01:xxx}{T02:yyy}})</li>
 * </ul><br>Field32A
 * This is based in the old SwiftParser2, that is now deprecated.<br>
 */
public class SwiftParser {

	/**
	 * Helper constant with the content of <code>System.getProperty("line.separator", "\n")</code>
	 */
	@Deprecated
	@ProwideDeprecated(phase2 = TargetYear.SRU2020)
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
	private final List<String> errors = new ArrayList<>();

	private int lastBlockStartOffset = 0;

	/**
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
	 * default constructor.<br>
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
	 * sets the input reader.<br>
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
	 * Parse a SWIFT message into a data structure.
	 *
	 * <p>By default this implementation uses the default parser behaviour which is lenient and will do a best effort to
	 * read as much from the message content as possible regardless of the content and block boundaries being valid
	 * or not. For instance, it will read the headers even if the value length is incorrect, and it will read the
	 * text block (block 4) even if it is missing the closing hyphen and bracket.
	 *
	 * <p>For more options check {@link #setConfiguration(SwiftParserConfiguration)}
	 *
	 * <p>IMPORTANT: Since the parser is initialize with a Reader, this method is not reentrant. Once a message was
	 * parsed, the next call to this method will produce a message with null blocks.</p>
	 *
	 * @return the parsed swift message object
	 * @throws IOException if an error occurs during read
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
	 * @deprecated use {@link SwiftMessage#parse(String)} instead
	 */
	@Deprecated
    @ProwideDeprecated(phase3=TargetYear.SRU2020)
	public SwiftMessage parse(final String message) throws IOException {
		DeprecationUtils.phase2(getClass(), "parse(String)", "For a simple static parse call use SwiftMessage#parse(String) instead; for fine grain control or parse configuration you can still create the SwiftParser instance passing a Reader, String or File and call the message() method to get the parsed message object.");
		setData(message);
		return message();
	}
	
	/**
	 * Consume the next block of the message on the reader.
	 * This methods seeks to a block start, then identifies the block
	 * and calls the proper method to consume the block type
	 * that is coming, not all blocks are parsed in the same manner.
	 * @param unparsedReceiver may be null, the unparsedTextList that will receive the chunks that can not be identified sas part of the message
	 *
	 * @return the next block in the reader or null if none was found (i.e: end of input)
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
				final char[] data = new char[128];
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
			throw new ProwideException("The block " + s + " could not be identified");
		}

		// create the block object
		b = createBlock(blockId, s);

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
	 * Creates the specific block instance consuming the extracted content
	 * @param blockId the block identifier, example: 1, 2, 3, 4, 5
	 * @param s the block content
	 * @return a specific block instance with the parsed content
	 */
	private SwiftBlock createBlock(final char blockId, final String s) {
		SwiftBlock b;

		// create the block object
		switch (blockId) {
			case '1': // block 1 (single valued)
				b = createBlock1(s);
				break;
			case '2': // block 2 (single valued)
				if (isInput(s)) {
					b = createBlock2Input(s);
				} else {
					b = createBlock2Output(s);
				}
				break;
			case '3': // block 3 (tag list)
				b = consumeTagListBlock(new SwiftBlock3(), s);
				break;
			case '4': // block 4
				if (this.configuration.isParseTextBlock()) {
					if (isTextBlock(s)) {
						b = consumeBlock4(new SwiftBlock4(), s);
					} else {
						b = consumeTagListBlock(new SwiftBlock4(), s);
					}
				} else {
					b = new SwiftBlock4();
				}
				break;
			case '5': // block 5 (tag list)
				if (this.configuration.isParseTrailerBlock()) {
					b = consumeTagListBlock(new SwiftBlock5(), s);
				} else {
					b = new SwiftBlock5();
				}
				break;
			default: // user defined block (tag list)
				if (this.configuration.isParseUserBlock()) {
					b = consumeTagListBlock(new SwiftBlockUser(Character.toString(blockId)), s);
				} else {
					b = new SwiftBlockUser();
				}
				break;
		}
		return b;
	}

	/**
	 * Creates the block 1, dealing with the {@link IllegalArgumentException} in case of lenient mode
	 */
	private SwiftBlock1 createBlock1(final String s) {
		try {
			return new SwiftBlock1(s, false);
		} catch (IllegalArgumentException e) {
			if (this.configuration.isLenient()) {
				// if configuration is lenient we record the default strict parsing error and try again in lenient mode
				this.errors.add(e.getMessage());
				return new SwiftBlock1(s, true);
			} else {
				throw e;
			}
		}
	}

	/**
	 * Creates the block 2, dealing with the {@link IllegalArgumentException} in case of lenient mode
	 */
	private SwiftBlock2Input createBlock2Input(final String s) {
		try {
			return new SwiftBlock2Input(s, false);
		} catch (IllegalArgumentException e) {
			if (this.configuration.isLenient()) {
				// if configuration is lenient we record the default strict parsing error and try again in lenient mode
				this.errors.add(e.getMessage());
				return new SwiftBlock2Input(s, true);
			} else {
				throw e;
			}
		}
	}

	/**
	 * Creates the block 2, dealing with the {@link IllegalArgumentException} in case of lenient mode
	 */
	private SwiftBlock2Output createBlock2Output(final String s) {
		try {
			return new SwiftBlock2Output(s, false);
		} catch (IllegalArgumentException e) {
			if (this.configuration.isLenient()) {
				// if configuration is lenient we record the default strict parsing error and try again in lenient mode
				this.errors.add(e.getMessage());
				return new SwiftBlock2Output(s, true);
			} else {
				throw e;
			}
		}
	}

	/**
	 * Attempt to detect if block 2 refers to an input or output message.
	 * If the parameter block content is not well-formed will return false as default.
	 * @param s the block 2 value (as a FIN value) for example I100BANKDEFFXXXXU3003 or 2:I100BANKDEFFXXXXU3003
	 * @return whether it's an input block 2 (true) or an output one (false)
	 */
	private static boolean isInput(final String s) {
		// try to find out the in/out type
		final int i = s.indexOf(':');
		Character ch = null;
		if (i >= 0 && (i + 1) < s.length()) {
			// check for input mark after ':'
			ch = s.charAt(i + 1);
		} else if (s.length() > 0) {
			// check start
			ch = s.charAt(0);
		}
		return ch != null && Character.toUpperCase(ch) == 'I';
	}

	/**
	 * consumes a tag list block (i.e: block 3, block 5 or user defined block)
	 *
	 * @param b the block to set up tags into
	 * @param s the block data to process
	 * @return the processed block (the parameter b)
	 */
	protected SwiftTagListBlock consumeTagListBlock(final SwiftTagListBlock b, final String s) {
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
					for (end = i; end < data.length() && data.charAt(end) != '{'; end++) {}
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
	 * a swift block 4:<br>
	 * <ul>
	 * <li><b>Text mode</b>: this is the common block 4 for categories 1 to 9.</li>
	 * <li><b>Tag mode</b>: this is the same format as for blocks 3 and 5. This format is used by
	 * service messages (for example: ACK) and system messages (category 0).</li>
	 * </ul><br>
	 *
	 * @param b the block to set up tags into
	 * @param s the block data to process
	 * @return the processed block (the parameter b)
	 */
	protected SwiftBlock4 consumeBlock4(final SwiftBlock4 b, final String s) {
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

			// check if we skipped a block unparsed text
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
					// force termination only if ending string is -}
					if (!isTextBlock || ignore == 1) {
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
					end = findEndOfTagByLineFeed(s, start, isTextBlock);
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
							end = findEndOfTagByBraces(s, end + 1);
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
						end = findEndOfTagByBraces(s, start);
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
				final Tag t = createTag(tag, tagUnparsedText);
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
	 * Finds the end of a text tag (i.e: ":TAG:VALUE"). This is used to parse block 4.
	 *
	 * <p>The function search the string looking for the occurrence of any of the sequences:
	 * <ul>
	 * <li>"[LBR]:[TAG_START]"</li>
	 * <li>"[LBR]}"</li>
	 * <li>"[LBR]{"</li>
	 * <li>"}"</li>
	 * </ul>
	 * where "[LBR]" stands for "[LF]" or "[CR][LF]" and "[TAG_START]" is a "nn[a]:" (number plus optional
	 * letter option, plus colon).
	 *
	 * <p><b>NOTE</b>: the condition "-}" cannot happen because the terminating dash is already removed.
	 *
	 * @param s the FIN input text
	 * @param start the position to start analysis at
	 * @return the position where the tag ends
	 */
	protected int findEndOfTagByLineFeed(final String s, int start, final boolean isTextBlock) {

		int i = start; 
		
		// start scanning for tag end
		for (; i < s.length(); i++) {

			// check if we found tag end
			char c = s.charAt(i);

			// if char is LF then look-ahead
			if (c == '\n') {

				// keep this position
				int begin = i;

				// look-ahead one character
				if ((i +1) == s.length()) {
					break;
				}
				c = s.charAt(++i);

				// if open brace => it's a proper tag end (mixing BLOCK and TEXT tags, rare but...)
				// if closing brace => it's a proper tag end (because of block end)
				if (!isTextBlock && (c == '{' || c == '}' )) {
					// found it
					i = begin;
					break;
				}
				// if it's a colon followed by a character different than CR or LF (':x') => it's a proper tag end
				// because we have reached a new line with a beginning new tag.
				// Note: It is note sufficient to check for a starting colon because for some fields like
				// 77E for example, it is allowed the field content to have a ':<CR><LF>' as the second line
				// of its content.
				else if (c == ':' && i < s.length()/* prevent index out of bounds */  ) {
					// check if :xxx matches a new starting tag or not, break only if matches valid start of tag
					if (isTagStart(s, (i+1))) {
						i = begin;
						break;
					}
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

		// check if previous character was a CR
		if ((i - 1) >= start && s.charAt(i-1) == '\r') {
			// fix return position
			return i-1;
		} else {
			return i;
		}
	}

	/**
	 * Evaluates if the string at the given position has the format nn[a]:
	 * which means it is a proper tag start.
	 * <p>This method could be overwritten by a subclass to provide more permissive
	 * tag identifiers (for example, to parse non-compliant messages).
	 * 
	 * @param s string to evaluate
	 * @param i starting position in the string to evaluate
	 * @return true if at the given position there is a tag start
	 * @since 7.10.4
	 */
	protected boolean isTagStart(final String s, int i) {
		int length = s.length();
		/*
		 * at least three characters, where first and second characters must be digits
		 */
		if (i+2 < length && Character.isDigit(s.charAt(i)) && Character.isDigit(s.charAt(i+1))) {
			/*
			 * third character must be ':' or letter option (A-Z) immediately followed by another character with ':'
			 */
			char c3 = s.charAt(i+2);
			if (c3 == ':') {
				/*
				 * no letter option
				 */
				return true;
			} else if (Character.isUpperCase(c3) && (i+3) < length && s.charAt(i+3) == ':') {
				/*
				 * with letter option
				 */
				return true;
			}
		}
		return false;
	}

	/**
	 * Finds the end of a block tag (i.e: "{TAG:VALUE}"). This is used to parse blocks other than 4.
	 *
	 * <p>The function search the string looking for an occurrence of "}", bypassing any balanced intermediate curly
	 * braces (could be nested blocks or tags with curly braces boundaries).
	 *
	 * @param s the FIN input text
	 * @param start the position to start analysis at
	 * @return the position where the tag ends (including the "}")
	 */
	private int findEndOfTagByBraces(final String s, int start) {
		// scan until end or end of string
		int balance = 0;
		do {
			// analyze this position
            switch (s.charAt(start++)) {
			case '{':
				balance++;
				break;
			case '}':
				balance--;
				break;
			}
		} while (start < s.length() && balance >= 0);
		return start;
	}

	/**
	 * Process the input as a tag. That is: split name and value (and possibly unparsed texts).<br>
	 * The received buffer contains only the pertinent data for the tag (name and value).
	 * <p>Trailing [CR][LF] on the text indicating the end of the tag value <b>MUST</b> not be present. If any
	 * trailing [CR][LF] is present, it will be considered part of the tag value and will be propagated to the
	 * created Tag instance.
	 *
	 * @param buffer the buffer containing the tag
	 * @param unparsedText the unparsed text to assign (use null if none is wanted).
	 * This single text is fragmented in multiple texts if there are more than one message.
	 * @return a swift Tag
	 */
	protected Tag createTag(final String buffer, final String unparsedText) {
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
		if (StringUtils.isEmpty(name) && StringUtils.isEmpty(value)) {
			return null; // no tag...
		}

		// build the tag
		//
		// NOTE: if we will use different Tag classes, here is the instantiation point
		//
		final Tag t = new Tag();
		if (name != null) {
			t.setName(name);
			t.setValue(value);
		} else {
			log.severe("Avoiding tag with null name and value "+value);
			throw new IllegalArgumentException("Field cannot have a null tag name");
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
	 * inner messages is treated as one single unparsed text.<br>
	 * That is:<br>
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
				end = findEndOfTagByBraces(unparsedText, end + 1);

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
	 * call this method which reads until this block ends.
	 *
	 * @return a string with the block contents
	 * @throws IOException if an error occurred during read
	 */
	protected String readUntilBlockEnds() throws IOException {
		final int start = buffer==null? 0 : buffer.length();
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

		//iterate until proper block end or EOF
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
				// if we have read something and we reach the end of file without a proper closing bracket
				if (len > 0) {
					char n = buffer != null? buffer.charAt(start) : '?';
					final String error = "Missing or invalid closing bracket in block " + n;
					if (configuration.isLenient()) {
						// if the configuration is lenient we report the error and continue
						this.errors.add(error);
					} else {
						// if the configuration is not lenient, we abort the parsing with exception
						throw new IllegalArgumentException(error);
					}
				}
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

		if (buffer != null) {
			return buffer.substring(start, end);
		} else {
			return "";
		}
	}

	private boolean isTextBlock() {
		// hack to report as block4 only text blocks 4, check data in buffer
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
		final char c1 = s.charAt(offset);
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

	/**
	 * @return true if current char is } or for text block buffer is [LF]-}
	 */
	private boolean isBlockEnd(final Boolean isTextBlock, final int curChar) {
		// check buffer
		if (isBlockEnd((char) curChar)) {
			if (isTextBlock != null && isTextBlock) {
				final char ult = buffer.charAt(buffer.length()-2);
				final char antUlt = buffer.charAt(buffer.length()-3);
                return antUlt == '\n' && ult == '-';
			} else {
				return true;
			}
		}
		return false;
	}

	/**
	 * @return true if parameter char is a closing bracket
	 */
	private static boolean isBlockEnd(final char c) {
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
	private int getChar() throws IOException {
		final int c = reader.read();
		if (c >= 0) {
			buffer.append((char) c);
		}
		return c;
	}

	/**
	 * Get a copy of the errors found during the parsing of the message.
	 * <p>You can manipulate this copy without affecting the original list.
	 *
	 * @return a copy of the list of errors found
	 */
	public List<String> getErrors() {
		return new ArrayList(this.errors);
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
	 * @since 7.8.4
	 */
	static public SwiftBlock4 parseBlock4(String s) {
		SwiftBlock4 b4 = new SwiftBlock4();
		String toParse = s;
		if (toParse.startsWith("{")) {
			toParse = toParse.substring(1);
		}
		if (toParse.endsWith("}")) {
			toParse = toParse.substring(0, toParse.length() - 1);
		}
		SwiftParser parser = new SwiftParser();
		return parser.consumeBlock4(b4, toParse);
	}
	
	/**
	 * Parses a string containing an MT message block 3 content 
	 * @param s block content starting with "{3:" and ending with "}"
	 * @return content parsed into a block 3 or an empty block 3 if string cannot be parsed
	 * @since 7.8.6
	 */
	static public SwiftBlock3 parseBlock3(String s) {
		SwiftBlock3 b3 = new SwiftBlock3();
		SwiftParser parser = new SwiftParser();
		return (SwiftBlock3) parser.consumeTagListBlock(b3, s);
	}
	
	/**
	 * Parses a string containing an MT message block 5 content 
	 * @param s block content starting with "{5:" and ending with "}"
	 * @return content parsed into a block 5 or an empty block 5 if string cannot be parsed
	 * @since 7.8.6
	 */
	static public SwiftBlock5 parseBlock5(String s) {
		SwiftBlock5 b5 = new SwiftBlock5();
		SwiftParser parser = new SwiftParser();
		return (SwiftBlock5) parser.consumeTagListBlock(b5, s);
	}

	/**
	 * Parses a string containing an MT message block 1 content 
	 * @param s block content starting with "{1:" and ending with "}"
	 * @return content parsed into a block 1 or an empty block 1 if string cannot be parsed
	 * @since 7.8.6
	 */
	static public SwiftBlock1 parseBlock1(String s) {
		return new SwiftBlock1(StringUtils.strip(s, "{}"), true);
	}

	/**
	 * Parses a string containing an MT message block 2 content.
	 * <p>Will return either a {@link SwiftBlock2Input} or {@link SwiftBlock2Output} depending
	 * on the parameter block content.
	 *
	 * @param s block content starting with "{2:" and ending with "}"
	 * @return content parsed into a block 2 or an empty block 2 if string cannot be parsed
	 * @since 7.8.6
	 */
	static public SwiftBlock2 parseBlock2(String s) {
		if (isInput(s)) {
			return new SwiftBlock2Input(StringUtils.strip(s, "{}"), true);
		} else {
			return new SwiftBlock2Output(StringUtils.strip(s, "{}"), true);
		}
	}
	
	/**
	 * Parses a string containing an MT message block 2 input content (outgoing message sent to SWIFT).
	 * <p>If you don't know the container message direction, user {@link #parseBlock2(String)} instead.
	 *
	 * @param s block content starting with "{2:I" and ending with "}"
	 * @return content parsed into a block 2 or an empty block 2 if string cannot be parsed
	 * @since 7.8.6
	 */
	static public SwiftBlock2Input parseBlock2Input(String s) {
		return new SwiftBlock2Input(StringUtils.strip(s, "{}"), true);
	}

	/**
	 * Parses a string containing an MT message block 2 output content (incoming message received from SWIFT).
	 * <p>If you don't know the container message direction, user {@link #parseBlock2(String)} instead.
	 *
	 * @param s block content starting with "{2:O" and ending with "}"
	 * @return content parsed into a block 2 or an empty block 2 if string cannot be parsed
	 * @since 7.8.6
	 */
	static public SwiftBlock2Output parseBlock2Output(String s) {
		return new SwiftBlock2Output(StringUtils.strip(s, "{}"), true);
	}

}
