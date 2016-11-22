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
import java.util.logging.Level;

/**
 * Base class for SWIFT blocks that contain its fields concatenated as a single <b>fixed length</b> value; blocks 1 and 2.<br>
 * This is an <b>abstract</b> class so specific block classes for each block should be instantiated.
 *
 * @author www.prowidesoftware.com
 * @since 4.0
 */
public abstract class SwiftValueBlock extends SwiftBlock implements Serializable {
	private static final long serialVersionUID = -3680693640473937755L;
	@SuppressWarnings("unused")
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(SwiftValueBlock.class.getName());

	/**
	 * Default constructor, shouldn't be used normally.
	 * present only for subclasses
	 */
	protected SwiftValueBlock() {

	}

	/**
	 * This method should be overwritten by subclasses, calling 
	 * this method will throw a <code>java.lang.UnsupportedOperationException</code>
	 * @return N/A
	 */
	public String getBlockValue() {
		throw new UnsupportedOperationException("cannot call getBlockValue on SwiftValueBlock, must be on specific subclasses");
	}

	/**
	 * This method should be overwritten by subclasses, calling 
	 * this method will throw a <code>java.lang.UnsupportedOperationException</code>
	 * 
	 * @return the blocks value as a single string
	 */
	public String getValue() {
		throw new UnsupportedOperationException("cannot call getValue on SwiftValueBlock, must be on specific subclasses");
	}

	/**
	 * This method should be overwritten by subclasses and proper 
	 * parsing be done to set specific values of the block, calling 
	 * this method will throw a <code>java.lang.UnsupportedOperationException</code>
	 * 
	 * @param value the blocks value as a single string
	 */
	public void setValue(final String value) {
		throw new UnsupportedOperationException("cannot call setValue on SwiftValueBlock, must be on specific subclasses");
	}

	/**
	 * This method should be overwritten by subclasses, calling 
	 * this method will throw a <code>java.lang.UnsupportedOperationException</code>
	 * @param value <em>unused</em> 
	 */
	public void setBlockValue(final String value) {
		throw new UnsupportedOperationException("cannot call setBlockValue on SwiftValueBlock, must be on specific subclasses");
	}

	/**
	 * Tells if the block contains at least one field.
	 * This method must be called on specific subclasses, calling it for SwiftValueBlock will throw 
	 * a <code>java.lang.UnsupportedOperationException</code>
	 * @return <code>true</code> if getValue returns a non <code>null</code> object
	 */
	public boolean isEmpty() {
		return (this.getValue() == null);
	}

	/**
	 * Tells the block's string value size (in chars).<br>
	 * NOTICE this does not return the actual number of fields set
	 * because value blocks are mostly fixed length.
	 * This method must be called on specific subclasses, calling it for SwiftValueBlock will throw 
	 * a <code>java.lang.UnsupportedOperationException</code>
	 * @return the size of the value or zero if value is null 
	 */
	public int size() {
		return (this.getValue() == null ? 0 : this.getValue().length());
	}

	/**
	 * returns a fragment of the block value received (or <code>null</code> if value is not large enough).<br />
	 * This method is used in derived classes to get value fragments. 
	 * @param value the full block value
	 * @param start the starting point of the fragment in the big block value
	 * @param size the fragment size
	 * @return the value fragment or <code>null</code> if value is not large enough
	 */
	protected String getValuePart(final String value, final int start, int size) {
		// prepare the result
		String s = null;

		// check start is within bounds
		if (start < value.length()) {

			// check start+size is within bounds
			int boundedSize;
			if ((start + size) >= value.length()) {
				boundedSize = value.length() - start;
			} else {
				boundedSize = size;
			}

			// get the fragment
			try {
				s = value.substring(start, start + boundedSize);
			} catch (final IndexOutOfBoundsException e) {
				log.log(Level.SEVERE, "Exception parsing value part", e);
			}
		}
		return s;
	}
	

	/**
	 * Returns a fragment of the block value received from a starting index until the end of value
	 * (or <code>null</code> if value is not large enough).<br />
	 * 
	 * This method is used in derived classes to get value fragments. 
	 * @param value the full block value
	 * @param start the starting point of the fragment in the big block value
	 * @return the value fragment or <code>null</code> if value is not large enough
	 * @since 7.7
	 */
	protected String getValuePart(final String value, final int start) {
		// check start is within bounds
		if (start < value.length()) {
			return value.substring(start);
		}
		return null;
	}
}
