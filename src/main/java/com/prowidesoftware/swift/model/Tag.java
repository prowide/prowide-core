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

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;

import com.prowidesoftware.swift.model.field.Field;

/**
 * Representation of a swift tag (also 'field' in computer terms) in a message.
 * 
 * <h4>NOTE</h4>
 * This class is also used inside SwiftBlock to store the value of a block that 
 * is not associated with a particular field, in this case, the Tag name attribute 
 * is set to <code>null</code>;
 * <h4>IMPORTANT NOTE ABOUT MULTILINE TAGS</h4>
 * <p>Multiline tags are read with readline, so while swift defines \r\n to be the
 * line terminator, the parser accepts a more wide range of line terminations. The 
 * values are stored in swift line terminators, that is always \r\n, so be aware that 
 * if a multiline field is separated with \n parse will be successfully but the returned
 * value will be separated by \r\n</p>
 * 
 * <p>Instances of this class may have a list of unparsed texts (UnparsedTextList).
 * For easy access, methods have been created that first ensure the lists exists (the
 * real object is created and then call the base method).<br />
 * However, not all the base list methods have been implemented. If you need to use not
 * exposed functionality, retrieve the underlying list with (see getUnparsedTexts method)</p>
 *  
 * @author www.prowidesoftware.com
 */
public class Tag implements Serializable {
	private static final transient java.util.logging.Logger log = java.util.logging.Logger.getLogger(Tag.class.getName());

	private static final long serialVersionUID = -1066430327311949399L;

	/**
	 * Unique identified when this tag is a persisted element
	 */
	protected Long id;
	
	/**
	 * Indicates the position of this tag in a message when persisted.
	 * This value is used to remember the positions of the tags inside 
	 * a block when persisted. This value may not be set when persistence
	 * is not used and should not be used by clients.
	 */
	protected Integer sortKey;
	
	/**
	 * Name of the tag, usually a number that may be followed by a letter.
	 * This value may be <code>null</code>.
	 */
	protected String name;

	/**
	 * Value of the corresponding tag.
	 */
	protected String value;
	
	/**
	 * List of unparsed texts. For performance reasons, this will be null until really needed.
	 */
	protected UnparsedTextList unparsedTexts = null;

	/**
	 * Reference to the sequence node, if any, that this tags belongs to.
	 */
	protected SequenceNode sequence = null;
	
	/**
	 * Default constructor
	 */
	public Tag() {
	}

	/**
	 * Create a tag from the value in inner.
	 * If inner contains one : character, the 
	 * string before is set as the tagname and the rest as the value.
	 * If inner contains more than one :, then the first value is used
	 * as previously described.
	 * If no : is contained, then all string is put in value and name remains <code>null</code> (useful for bloc data)
	 * 
	 * <br/>
	 * Maps:
	 * <code><pre>
	 * "" -> name=null, value=null
	 * "foo" -> name=null, value=foo
	 * ":foo" -> name=null, value=foo
	 * "foo:" -> name=foo, value=null
	 * "foo:bar" -> name=foo, value=bar
	 * </pre></code>
	 * @param inner the string to build the tag
	 * @throws IllegalArgumentException if inner is <code>null</code>
	 */
	public Tag(String inner) {
		
		// sanity check
		Validate.notNull(inner, "parameter 'inner' cannot be null");

		// analyze how to split the inner value
		int i = inner.indexOf(':');
		if (i>=0) {
			if (i>0) {
				this.name = inner.substring(0, i);
			}
			if (i+1<inner.length()) {
				this.value = inner.substring(i+1);
			}
		} else {
			if (inner.length()>0)
				this.value = inner;
		}
	}

	/**
	 * Create a tag with the given tagname and value
	 * @param tagname name of this tag
	 * @param value the value of this tag
	 * @throws IllegalArgumentException if parameter tagname or value are <code>null</code>
	 */
	public Tag(String tagname, String value) {

		// sanity check
		Validate.notNull(tagname, "parameter 'tagname' cannot be null");
		Validate.notNull(value, "parameter 'value' cannot be null");

		this.name = tagname;
		this.value = value;
	}

	/**
	 * Constructor for an unparsed text list
	 * @param unparsedText the list of unparsed texts
	 * @see Tag#Tag()
	 */
	public Tag(UnparsedTextList unparsedText) {

		// base constructor
		this();

		// set the unparsed text list
		this.unparsedTexts = unparsedText;
	}

	/**
	 * Constructor for tag encoded value and an unparsed text list
	 * @param inner the string to build the tag
	 * @param unparsedText the list of unparsed texts
	 * @throws IllegalArgumentException if parameter inner is <code>null</code>
	 * @see Tag#Tag(String)
	 */
	public Tag(String inner, UnparsedTextList unparsedText) {

		// base constructor
		this(inner);

		// set the unparsed text list
		this.unparsedTexts = unparsedText;
	}

	/**
	 * Constructor for tag name and value and an unparsed text list
	 * @param tagname name of this tag
	 * @param value the value of this tag
	 * @param unparsedText the list of unparsed texts
	 * @throws IllegalArgumentException if parameter tagname or value are <code>null</code>
	 * @see Tag#Tag(String,String)
	 */
	public Tag(String tagname, String value, UnparsedTextList unparsedText) {

		// base constructor
		this(tagname, value);

		// set the unparsed text list
		this.unparsedTexts = unparsedText;
	}

	/**
	 * Get the name of this tag
	 * @return a string with the current tag name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Set the tag name
	 * @param name the name of the tag to be set
	 * @throws IllegalArgumentException if parameter name is <code>null</code>
	 */
	public void setName(String name) {

		// sanity check
		Validate.notNull(name, "parameter 'name' cannot be null");

		this.name = name;
	}

	/**
	 * Get the value of the tag.<br> 
	 * Notice that in some cases the value can be null,
	 * for example the value of the "DLM" tag in this block:<br> 
	 * {5:{CHK:F9351591947F}{SYS:1610010606VNDZBET2AXXX0019000381}{DLM:}}
	 *
	 * 
	 * @return a string with the value of the tag or <code>null</code> if the value was not set
	 */
	//TODO review parser implementation and check if always <code>null</code> is set or empty string
	public String getValue() {
		return value;
	}

	/**
	 * Sets the value of this tag.
	 * @param value the value for the tag, may be <code>null</code>
	 */
	public void setValue(String value) {
		this.value = value;
	}

	public String toString() {
		return new StringBuilder().append("Tag[").append(name).append(":").append(value).append("]").toString();
	}

	/**
	 * Get the unique identifier of the tag if it is persisted
	 * @return the unique id or <code>null</code> if it is not a persistent object
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Set the unique identifier of the tag if it is persisted
	 * @param id the id to be set
	 * @see #sortKey
	 */
	public void setId(Long id) {

		this.id = id;
	}

	/**
	 * get the sortkey of this tag
	 * @return an integer with the current sortkey
	 * @see #sortKey
	 */
	public Integer getSortKey() {
		return sortKey;
	}

	/**
	 * Set the sortkey of this tag.
	 * This value may be changed by clients when persistence is used and the order of the tags
	 * in a message are being modified.
	 * @param sortKey the new sortkey
	 */
	public void setSortKey(Integer sortKey) {
		this.sortKey = sortKey;
	}

	/**
	 * verifies that the unparsed text list exists
	 */
	protected void unparsedTextVerify() {
		if (this.unparsedTexts == null)
			this.unparsedTexts = new UnparsedTextList();
	}

	/**
	 * returns the unparsed text list
	 * @return the unparsed text attached to this tag object
	 */
	public UnparsedTextList getUnparsedTexts() {

		// create the list if needed
		unparsedTextVerify();
		return(this.unparsedTexts);
	}

	/**
	 * sets the list of unparsed texts
	 * @param texts the new list of unparsed texts (may be null)
	 */
	public void setUnparsedTexts(UnparsedTextList texts) {

		this.unparsedTexts = texts;
	}

	/**
	 * returns the size of the unparsed text list
	 * @return the count of unparsed texts attached to this tag object
	 */
	public Integer getUnparsedTextsSize() {

		// no list => size is zero...
		if (this.unparsedTexts == null)
			return new Integer(0);
		return this.unparsedTexts.size() ;
	}

	/**
	 * decides if a specific text (by index) is likely a SWIFT FIN message. Exceptions are inherited from
	 * base implementation methods.
	 * @param index the unparsed text number
	 * @return true if the unparsed text at position index is a full SWIFT message
	 * @throws IllegalArgumentException if parameter index is <code>null</code>
	 * @throws IndexOutOfBoundsException if parameter index is out of bounds
	 */
	public Boolean unparsedTextIsMessage(Integer index) {

		// create the list if needed
		unparsedTextVerify();
		return(this.unparsedTexts.isMessage(index));
	}

	/**
	 * get an unparsed text
	 * @param index the unparsed text number
	 * @return the requested text
	 * @throws IllegalArgumentException if parameter index is <code>null</code>
	 * @throws IndexOutOfBoundsException if parameter index is out of bounds
	 */
	public String unparsedTextGetText(Integer index) {

		// create the list if needed
		unparsedTextVerify();
		return(this.unparsedTexts.getText(index));
	}

	/**
	 * get an unparsed text as a parsed swift message
	 * @param index the unparsed text number
	 * @return the unparsed text at position index parsed into a SwiftMessage object
	 * @throws IllegalArgumentException if parameter index is <code>null</code> 
	 */
	public SwiftMessage unparsedTextGetAsMessage(Integer index) {

		// create the list if needed
		unparsedTextVerify();
		return(this.unparsedTexts.getTextAsMessage(index));
	}

	/**
	 * adds a new unparsed text
	 * @param text the unparsed text to append
	 * @throws IllegalArgumentException if parameter text is <code>null</code> 
	 */
	public void unparsedTextAddText(String text) {

		// create the list if needed
		unparsedTextVerify();
		this.unparsedTexts.addText(text);
	}

	/**
	 * adds a new unparsed text from a message
	 * @param message the message to be appended
	 * @throws IllegalArgumentException if parameter message is <code>null</code> 
	 */
	public void unparsedTextAddText(SwiftMessage message) {

		// create the list if needed
		unparsedTextVerify();
		this.unparsedTexts.addText(message);
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((sortKey == null) ? 0 : sortKey.hashCode());
		result = prime * result + ((unparsedTexts == null) ? 0 : unparsedTexts.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Tag other = (Tag) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (sortKey == null) {
			if (other.sortKey != null)
				return false;
		} else if (!sortKey.equals(other.sortKey))
			return false;
		if (unparsedTexts == null) {
			if (other.unparsedTexts != null)
				return false;
		} else if (!unparsedTexts.equals(other.unparsedTexts))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	/**
	 * Attempt to parse the tag name as an integer.
	 * <em>Note that for 15A this method will return -1</em>
	 * 
	 * @return the resulting value of parsing the tagname as an integer or -1 if an error occurs
	 */
	public int getNameAsInt() {
		try {
			return Integer.valueOf(this.name).intValue();
		} catch (Exception unused) {
			return -1;
		}
	}

	/**
	 * Tells if this tagname is a given number, so the integer 58 will match 58A and 58D.
	 * 
	 * @param n the number that this tagname will be compared to
	 * @return <code>true</code> if this tagname starts with the given number or <code>false</code> in any other case
	 */
	public boolean isNumber(int n) {
		return this.name != null && getNumber() != null && getNumber().equals(n);
	}
	
	/**
	 * Iterate the current tagname and return only number as told by {@link Character#isDigit(char)}
	 * 
	 * @return an integer containing the numeric of the tagname or <code>null</code> if no digits are found
	 * @since 6.2
	 */
	public Integer getNumber() {
		if (this.name!=null) {
			final StringBuilder sb = new StringBuilder();
			for (int i=0;i<this.name.length();i++) {
				char c = this.name.charAt(i);
				if (Character.isDigit(c)) {
					sb.append(c);
				}
			}
			if (sb.length() > 0) {
				return Integer.parseInt(sb.toString());
			}
		}
		return null;
	}
	
	/**
	 * Iterate the current tagname and return only letters as told by {@link Character#isLetter(char)}
	 * 
	 * @return a string containing only letter characters of the tagname or <code>null</code> if no letters are found
	 */
	public String getLetterOption() {
		if (this.name!=null) {
			final StringBuilder sb = new StringBuilder();
			for (int i=0;i<this.name.length();i++) {
				char c = this.name.charAt(i);
				if (Character.isLetter(c)) {
					sb.append(c);
				}
			}
			if (sb.length() > 0) {
				return sb.toString();
			}
		}
		return null;
	}
	
	/**
	 * @see Field#getField(Tag)
	 */
	public Field getField() {
		return Field.getField(this);
	}

	/**
	 * Tell if this tag value contains any of the given values.
	 * This method is case sensitive. It handles null values.
	 * Actual test is delegated to {@link StringUtils#contains(String,String)}
	 * @param values variable list of values to test
	 * @return <code>true</code> if the value of this tag is one of the given values. 
	 * returns <code>false</code> in any other case, including a null or empty list of values
	 */
	public boolean contains(String ... values) {
		if (values != null && values.length>0) {
			final String _v = getValue();
			for (String v : values) {
				if (StringUtils.contains(_v, v)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Shorthand equivalent to calling first {@link #setName(String)} and then {@link #setValue(String)}
	 * @param name the tagname
	 * @param value the tagvalue
	 */
	public void setNameValue(String name, String value) {
		setName(name);
		setValue(value);
	}

	/**
	 * equivalent to StringUtils.startsWith(tag.getValue(), prefix)
	 * @see StringUtils#startsWith(String, String)
	 */
	public boolean startsWith(String prefix) {
		return StringUtils.startsWith(getValue(), prefix);
	}
	/**
	 * equivalent to StringUtils.contains(tag.getValue(), searchStr)
	 * @see StringUtils#contains(String, String)
	 */
	public boolean contains(String searchStr) {
		return StringUtils.contains(getValue(), searchStr);
	}
	
	/**
	 * 
	 * @return this Tag as a FieldNN instance or <code>null</code> if an error occurs
	 */
	public Field asField() {
		try {
			return Field.getField(this);
		} catch (Exception e) {
			log.log(Level.WARNING, "cannot build Field object for Tag "+this, e);
		}
		return null;
	}
	
}
