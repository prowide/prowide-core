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
package com.prowidesoftware.swift.model;

import com.prowidesoftware.deprecation.DeprecationUtils;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import com.prowidesoftware.swift.io.ConversionService;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.*;

/**
 * <p>List of unparsed texts for messages, blocks or tags.<br>
 * For performance reasons, the
 * unparsed texts are stored directly as strings inside this list object. The need then
 * for this object (as opposed to directly using a List) is for some functionality
 * aggregation, specially if you consider that the same is used in all levels of the
 * message structure.
 * 
 * <p>It is expected that classes that use this object do not create unnecessary instances of
 * this (also for performance reasons). The motive become obvious when you consider that
 * an average SWIFT message will have 4 blocks (1, 2, 3 and 4) and that block 4 will have
 * at least 20 tags (so the count of instances of this will be: 1 for the message, 4 for the
 * blocks and 20 for the tags, giving 25). For more complex messages, the number is near
 * linear with the number of tags, while at the same time, most of those messages will have
 * no unparsed texts.
 *
 * <p>For this, it is expected that the message, block and tag objects will have some convenience
 * methods to access this class methods only if they have a valid object.
 *
 * <p>This class will be used in four different scenarios:
 * 
 * <p>1) SERVICE MESSAGES (for example: ACK)
 * 
 * <p>It's been reported that Swift Alliance Access appends the original message to the ACK on
 * delivery. In this case, the appended original message will be attached to the ACK as an
 * unparsed text
 * 
 * <p>2) SOME SYSTEM MESSAGES (for example: MT 021, Retrieval Response)
 * 
 * <p>In this case, as per documentation, the retrieved message is appended in block 4, after
 * the tags of the message. In this case, the original (retrieved) message is appended to
 * block 4 as an unparsed text.
 * 
 * <p>3) SOME REPORT MESSAGES (for example: MT 056, LT History Report)
 * 
 * <p>In this case, complete messages (one or more) are appended to a tag value.
 * An example of this is MT 056 (LT History Report) where the original login request and
 * the associated login response (optional) are appended to TAG 270 value. Here, two
 * unparsed texts are appended to tag 270 of the parsed message.
 * 
 * <p>4) USER DEFINED BLOCKS
 * 
 * <p>As part of the user defined blocks support, we have decided to append the (complete) original
 * block text as an unparsed text to the User Block (class SwiftBlockUser) to allow for some
 * degree of liberty regarding data encoding in these blocks (however, these user defined blocks
 * where designed considering that they behave as standard block 3 or 5.
 * 
 * @since 5.0
 */
public class UnparsedTextList implements Serializable {
	private static final long serialVersionUID = 7302986014143689797L;
	private static final String WRITER_MESSAGE = "parameter 'index' cannot be null";

	/**
	 * Unique identifier of the unparsed texts list.
	 * Mainly used for persistence services.
	 * @deprecated use persistence mapping in the AbstractSwiftMessage model instead
	 */
	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	private Long id;

	/**
	 * list of unparsed texts
	 *
	 * @since 5.0
	 */
	private List<String> texts = new ArrayList<>();

	/**
	 * Default Constructor 
	 */
	public UnparsedTextList() {
		super();
	}

	/**
	 * Constructor from a collection of texts
	 * @param texts the list of unparsed texts to set
	 * @throws IllegalArgumentException if parameter texts is null
	 * @throws IllegalArgumentException if parameter texts has elements of class other than String
	 */
	public UnparsedTextList(final Collection<String> texts) {
		// sanity check
		Validate.notNull(texts, "parameter 'texts' cannot be null");
		this.texts = new ArrayList<>(texts);
	}

	/**
	 * Get the unique identifier of this unparsed text list or null if it is not set
	 * @return the unique identifier 
	 * @deprecated use persistence mapping in the AbstractSwiftMessage model instead
	 */
	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	public Long getId() {
		DeprecationUtils.phase2(getClass(), "getId()", "The SwiftModel model is no more intended for persistence, use the more effective JPA annotated model in AbstractSwiftMessage instead");
		return id;
	}

	/**
	 * Sets the unique identifier of this unparsed text list
	 * @param id the unique identifier to set.
	 * @deprecated use persistence mapping in the AbstractSwiftMessage model instead
	 */
	@Deprecated
	@ProwideDeprecated(phase3 = TargetYear.SRU2020)
	public void setId(final Long id) {
		DeprecationUtils.phase2(getClass(), "setId(Long)", "The SwiftModel model is no more intended for persistence, use the more effective JPA annotated model in AbstractSwiftMessage instead");
		this.id = id;
	}

	/**
	 * gets as FIN string, conforming a String object with the concatenation of the unparsed texts.
	 * @return String concatenation of the unparsed texts
	 */
	public String getAsFINString() {
		// performance optimization
		if (this.texts.isEmpty()) {
			return ("");
		}

		// visit every unparsed text
		final StringBuilder s = new StringBuilder();
		for (final Iterator<String> itr = this.texts.iterator(); itr.hasNext();) {
			s.append(itr.next());
		}
		;

		return (s.toString());
	}

	/**
	 * convert this to string
	 */
	public String toString() {
		return (ToStringBuilder.reflectionToString(this));
	}

	/**
	 * decides if it is likely that an unparsed text is a SWIFT FIN message.<br>
	 * It is considered that a text it is likely to be message if it contains
	 * the text "{1:".
	 * @param text the text to analyze
	 * @return true if the text is likely to be a SWIFT message
	 */
	static public Boolean isMessage(final String text) {
		// sanity check and evaluation
		return Boolean.valueOf((text != null && (text.indexOf("{1:") >= 0)));
	}

	/**
	 * returns the full list of unparsed texts
	 * @return the list of texts
	 */
	public List<String> getTexts() {
		return (this.texts);
	}

	/**
	 * Set the list of texts, the list must be a list of Strings or an empty list.<br>
	 * This method is mainly needed for persistence services.
	 * @param texts the list of unparsed texts to set
	 * @throws IllegalArgumentException if parameter texts is null
	 * @throws IllegalArgumentException if parameter texts has elements of class other than String
	 * @since 5.0
	 */
	protected void setTexts(final List<String> texts) {
		// setup the new list
		this.texts = texts;
	}

	/**
	 * get the number of unparsed texts
	 * @return the number of unparsed texts
	 */
	public Integer size() {
		// sanity check and evaluation
		return new Integer(this.texts.size());
	}

	/**
	 * decides if a specific text (by index) is likely a SWIFT FIN message. Exceptions are inherited from
	 * base implementation methods.
	 * @param index the unparsed text number
	 * @return true if the text at position index is likely to be a SWIFT message
	 * @throws IllegalArgumentException if parameter index is null
	 * @throws IndexOutOfBoundsException if parameter index is out of bounds
	 */
	public Boolean isMessage(final Integer index) {
		return (UnparsedTextList.isMessage(this.getText(index)));
	}

	/**
	 * get an unparsed text
	 * @param index the unparsed text number
	 * @return the requested text
	 * @throws IllegalArgumentException if parameter index is null
	 * @throws IndexOutOfBoundsException if parameter index is out of bounds
	 */
	public String getText(final Integer index) {
		// sanity check
		Validate.notNull(index, WRITER_MESSAGE);

		return ((String) this.texts.get(index.intValue()));
	}

	/**
	 * get an unparsed text as a parsed swift message
	 * @param index the unparsed text number
	 * @return the text at position index parsed into a SwiftMessage object
	 * @throws IllegalArgumentException if parameter index is null
	 * @throws IndexOutOfBoundsException if parameter index is out of bounds 
	 */
	public SwiftMessage getTextAsMessage(final Integer index) {
		// sanity check
		Validate.notNull(index, WRITER_MESSAGE);

		// create a conversion class
		final ConversionService cService = new ConversionService();
		return (cService.getMessageFromFIN((String) this.texts.get(index.intValue())));
	}

	/**
	 * adds a new unparsed text
	 * @param text the unparsed text to append
	 * @throws IllegalArgumentException if parameter text is null
	 */
	public void addText(final String text) {
		// sanity check
		Validate.notNull(text, "parameter 'text' cannot be null");

		// append the text
		this.texts.add(text);
	}

	/**
	 * adds a new unparsed text from a message
	 * @param message the message to be appended
	 * @throws IllegalArgumentException if parameter message is null
	 */
	public void addText(final SwiftMessage message) {
		// sanity check
		Validate.notNull(message, "parameter 'message' cannot be null");

		// get the text version of the message
		final ConversionService cService = new ConversionService();
		final String msg = cService.getFIN(message);

		// add the text
		this.addText(msg);
	}

	/**
	 * removes an unparsed text
	 * @param index the index of the text to remove
	 * @throws IllegalArgumentException if parameter index is null
	 * @throws IndexOutOfBoundsException if parameter index is out of bounds
	 */
	public void removeText(final Integer index) {
		// sanity check
		Validate.notNull(index, WRITER_MESSAGE);

		// remove the text
		this.texts.remove(index.intValue());
	}

	/**
	 * removes an unparsed text
	 * @param index the index of the text to remove
	 * @throws IndexOutOfBoundsException if parameter index is out of bounds
	 */
	public void removeText(final int index) {
		// remove the text
		this.texts.remove(index);
	}

	/**
	 * removes an unparsed text
	 * @param text the text value to remove (uses equals)
	 * @throws IllegalArgumentException if parameter text is null
	 */
	public void removeText(final String text) {
		// sanity check
		Validate.notNull(text, "parameter 'text' cannot be null");

		// remove the text (if it exists)
		final int pos = this.texts.indexOf(text);
		if (pos != -1) {
			this.texts.remove(pos);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UnparsedTextList that = (UnparsedTextList) o;
		return Objects.equals(texts, that.texts);
	}

	@Override
	public int hashCode() {
		return Objects.hash(texts);
	}
}
