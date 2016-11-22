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
package com.prowidesoftware.swift.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.Collection;

import org.apache.commons.lang.Validate;
import org.apache.commons.lang.builder.ToStringBuilder;

import com.prowidesoftware.swift.io.ConversionService;

/**
 * <p>List of unparsed texts for messages, blocks or tags.<br /> 
 * For performance reasons, the
 * unparsed texts are stored directly as strings inside this list object. The need then
 * for this object (as opposed to directly using a List) is for some functionality
 * aggregation, specially if you consider that the same is used in all levels of the
 * message structure.</p> 
 * 
 * <p>It is expected that classes that use this object do not create unnecessary instances of
 * this (also for performance reasons). The motive become obvious when you consider that
 * an average SWIFT message will have 4 blocks (1, 2, 3 and 4) and that block 4 will have
 * at least 20 tags (so the count of instances of this will be: 1 for the message, 4 for the
 * blocks and 20 for the tags, giving 25). For more complex messages, the number is near
 * linear with the number of tags, while at the same time, most of those messages will have
 * no unparsed texts.</p>  
 *
 * <p>For this, it is expected that the message, block and tag objects will have some convenience
 * methods to access this class methods only if they have a valid object.</p>
 *
 * <p>This class will be used in four different scenarios:</p>
 * 
 * <p>1) SERVICE MESSAGES (for example: ACK)</p>
 * 
 * <p>It's been reported that Swift Alliance Access appends the original message to the ACK on
 * delivery. In this case, the appended original message will be attached to the ACK as an
 * unparsed text</p> 
 * 
 * <p>2) SOME SYSTEM MESSAGES (for example: MT 021, Retrieval Response)</p>
 * 
 * <p>In this case, as per documentation, the retrieved message is appended in block 4, after
 * the tags of the message. In this case, the original (retrieved) message is appended to
 * block 4 as an unparsed text.</p>
 * 
 * <p>3) SOME REPORT MESSAGES (for example: MT 056, LT History Report)</p>
 * 
 * <p>In this case, complete messages (one or more) are appended to a tag value.
 * An example of this is MT 056 (LT History Report) where the original login request and
 * the associated login response (optional) are appended to TAG 270 value. Here, two
 * unparsed texts are appended to tag 270 of the parsed message.</p> 
 * 
 * <p>4) USER DEFINED BLOCKS</p>
 * 
 * <p>As part of the user defined blocks support, we have decided to append the (complete) original
 * block text as an unparsed text to the User Block (class SwiftBlockUser) to allow for some
 * degree of liberty regarding data encoding in these blocks (however, these user defined blocks
 * where designed considering that they behave as standard block 3 or 5.</p> 
 * 
 * @since 5.0
 * @author www.prowidesoftware.com
 */
public class UnparsedTextList implements Serializable {
	private static final long serialVersionUID = 7302986014143689797L;

	/**
	 * Unique identifier of the unparsed texts list.
	 * Mainly used for persistence services.
	 */
	private Long id;

	/**
	 * list of unparsed texts
	 *
	 * @since 5.0
	 */
	private List<String> texts = new ArrayList<String>();

	/**
	 * Default Constructor 
	 */
	public UnparsedTextList() {
		super();
	}

	/**
	 * Constructor from a collection of texts
	 * @param texts the list of unparsed texts to set
	 * @throws IllegalArgumentException if parameter texts is <code>null</code>
	 * @throws IllegalArgumentException if parameter texts has elements of class other than String
	 */
	public UnparsedTextList(final Collection<String> texts) {
		// sanity check
		Validate.notNull(texts, "parameter 'texts' cannot be null");
		Validate.allElementsOfType(texts, String.class, "parameter 'texts' may only have String elements");

		this.texts = new ArrayList<String>(texts);
	}

	/**
	 * Get the unique identifier of this unparsed text list or <code>null</code> if it is not set
	 * @return the unique identifier 
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the unique identifier of this unparsed text list
	 * @param id the unique identifier to set.
	 */
	public void setId(final Long id) {
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
	 * @throws IllegalArgumentException if parameter texts is <code>null</code>
	 * @throws IllegalArgumentException if parameter texts has elements of class other than String
	 * @since 5.0
	 */
	protected void setTexts(final List<String> texts) {
		// sanity check
		//Validate.notNull(texts, "parameter 'texts' cannot be null");
		//Validate.allElementsOfType(texts, String.class, "parameter 'texts' may only have String elements");

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
	 * @throws IllegalArgumentException if parameter index is <code>null</code>
	 * @throws IndexOutOfBoundsException if parameter index is out of bounds
	 */
	public Boolean isMessage(final Integer index) {
		return (UnparsedTextList.isMessage(this.getText(index)));
	}

	/**
	 * get an unparsed text
	 * @param index the unparsed text number
	 * @return the requested text
	 * @throws IllegalArgumentException if parameter index is <code>null</code>
	 * @throws IndexOutOfBoundsException if parameter index is out of bounds
	 */
	public String getText(final Integer index) {
		// sanity check
		Validate.notNull(index, "parameter 'index' cannot be null");

		return ((String) this.texts.get(index.intValue()));
	}

	/**
	 * get an unparsed text as a parsed swift message
	 * @param index the unparsed text number
	 * @return the text at position index parsed into a SwiftMessage object
	 * @throws IllegalArgumentException if parameter index is <code>null</code>
	 * @throws IndexOutOfBoundsException if parameter index is out of bounds 
	 */
	public SwiftMessage getTextAsMessage(final Integer index) {
		// sanity check
		Validate.notNull(index, "parameter 'index' cannot be null");

		// create a conversion class
		final ConversionService cService = new ConversionService();
		return (cService.getMessageFromFIN((String) this.texts.get(index.intValue())));
	}

	/**
	 * adds a new unparsed text
	 * @param text the unparsed text to append
	 * @throws IllegalArgumentException if parameter text is <code>null</code> 
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
	 * @throws IllegalArgumentException if parameter message is <code>null</code> 
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
	 * @throws IllegalArgumentException if parameter index is <code>null</code>
	 * @throws IndexOutOfBoundsException if parameter index is out of bounds
	 */
	public void removeText(final Integer index) {
		// sanity check
		Validate.notNull(index, "parameter 'index' cannot be null");

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
	 * @throws IllegalArgumentException if parameter text is <code>null</code>
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

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((texts == null) ? 0 : texts.hashCode());
		return result;
	}

	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final UnparsedTextList other = (UnparsedTextList) obj;
		if (texts == null) {
			if (other.texts != null) {
				return false;
			}
		} else if (!texts.equals(other.texts)) {
			return false;
		}
		return true;
	}

}
