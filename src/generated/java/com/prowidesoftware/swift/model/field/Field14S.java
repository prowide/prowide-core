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
 package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.Generated;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

import java.io.Serializable;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;


/**
 * <h2>SWIFT MT Field 14S</h2>
 * Model and parser for field 14S of a SWIFT MT message.
 *
 * <h4>Subfields (components) Data types</h4>
 * <ol> 
 * 		<li><code>String</code></li> 
 * 		<li><code>Number</code></li> 
 * 		<li><code>Calendar</code></li> 
 * 		<li><code>String</code></li> 
 * </ol>
 *
 * <h4>Structure definition</h4>
 * <ul>
 * 		<li>validation pattern: <code>3!a2!n[/&lt;HHMM&gt;/4!c]</code></li>
 * 		<li>parser pattern: <code>SN[/&lt;HHMM&gt;/S]</code></li>
 * 		<li>components pattern: <code>SNHS</code></li>
 * </ul>
 *		 
 * <p>This class complies with standard release <strong>SRU2017</strong></p>
 * <p>NOTE: this source code has been generated from template</p>
 */
@SuppressWarnings("unused") 
@Generated
public class Field14S extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2017;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 14S
	 */
    public static final String NAME = "14S";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_14S = "14S";
	public static final String PARSER_PATTERN ="SN[/<HHMM>/S]";
	public static final String COMPONENTS_PATTERN = "SNHS";

	/**
	 * Component number for the Source subfield
	 */
	public static final Integer SOURCE = 1;

	/**
	 * Component number for the Number subfield
	 */
	public static final Integer NUMBER = 2;

	/**
	 * Component number for the Time subfield
	 */
	public static final Integer TIME = 3;

	/**
	 * Component number for the Location subfield
	 */
	public static final Integer LOCATION = 4;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field14S() {
		super(4);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field14S(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field14S(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "14S")) {
			throw new IllegalArgumentException("cannot create field 14S from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}
	
	/**
	 * Parses the parameter value into the internal components structure.
	 * <br />
	 * Used to update all components from a full new value, as an alternative
	 * to setting individual components. Previous component values are overwritten.
	 *
	 * @param value complete field value including separators and CRLF
	 * @since 7.8
	 */
	@Override
	public void parse(final String value) {
		init(4);
		if (value != null) {
			String left;
			String right = null;
			if (value.indexOf('/') >= 0) {
				left = SwiftParseUtils.getTokenFirst(value, "/");
				right = SwiftParseUtils.getTokenSecondLast(value, "/");
			} else {
				left = value;
			}
			setComponent1(SwiftParseUtils.getAlphaPrefix(left));
			final String second = getComponent1() == null ? left : StringUtils.substringAfter(left, getComponent1());
			setComponent2(second);
			if (right != null) {
				setComponent3(SwiftParseUtils.getTokenFirst(right, "/"));
				setComponent4(SwiftParseUtils.getTokenSecondLast(right, "/"));
			}
		}
	}
	
	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field14S newInstance(Field14S source) {
		Field14S cp = new Field14S();
		cp.setComponents(new ArrayList<String>(source.getComponents()));
		return cp;
	}
	
	/**
	 * Serializes the fields' components into the single string value (SWIFT format)
	 */
	@Override
	public String getValue() {
		final StringBuilder result = new StringBuilder();
		append(result, 1);
		append(result, 2);
		if (getComponent3() != null || getComponent4() != null) {
			result.append("/");
			append(result, 3);
			result.append("/");
			append(result, 4);
		}
		return result.toString();
	}

	/**
	* Create a Tag with this field name and the given value.
	* Shorthand for <code>new Tag(NAME, value)</code>
	* @see #NAME
	* @since 7.5
	*/
	public static Tag tag(final String value) {
		return new Tag(NAME, value);
	}

	/**
	* Create a Tag with this field name and an empty string as value
	* Shorthand for <code>new Tag(NAME, "")</code>
	* @see #NAME
	* @since 7.5
	*/
	public static Tag emptyTag() {
		return new Tag(NAME, "");
	}
	
	/**
	 * Get the component1
	 * @return the component1
	 */
	public String getComponent1() {
		return getComponent(1);
	}

	/**
	 * Same as getComponent(1)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase2=TargetYear._2018)
	public java.lang.String getComponent1AsString() {
		return getComponent(1);
	}

	/**
	 * Get the Source (component1).
	 * @return the Source from component1
	 */
	public String getSource() {
		return getComponent(1);
	}

	/**
	 * Set the component1.
	 * @param component1 the component1 to set
	 */
	public Field14S setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Source (component1).
	 * @param component1 the Source to set
	 */
	public Field14S setSource(String component1) {
		setComponent(1, component1);
		return this;
	}
	/**
	 * Get the component2
	 * @return the component2
	 */
	public String getComponent2() {
		return getComponent(2);
	}

	/**
	 * Get the component2 as Number
	 * @return the component2 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getComponent2AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(2));
	}

	/**
	 * Get the Number (component2).
	 * @return the Number from component2
	 */
	public String getNumber() {
		return getComponent(2);
	}
	
	/**
	 * Get the Number (component2) as Number
	 * @return the Number from component2 converted to Number or <code>null</code> if cannot be converted
	 */
	public java.lang.Number getNumberAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(2));
	}

	/**
	 * Set the component2.
	 * @param component2 the component2 to set
	 */
	public Field14S setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the component2 from a Number object.
	 * <br />
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent2(String) 
	 * method.
	 * 
	 * @see #setComponent2(String)
	 *
	 * @param component2 the Number with the component2 content to set
	 */
	public Field14S setComponent2(java.lang.Number component2) {
		if (component2 != null) {
			setComponent(2, Integer.toString(component2.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the Number (component2).
	 * @param component2 the Number to set
	 */
	public Field14S setNumber(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Number (component2) from a Number object.
	 * @see #setComponent2(java.lang.Number)
	 * @param component2 Number with the Number content to set
	 */
	public Field14S setNumber(java.lang.Number component2) {
		setComponent2(component2);
		return this;
	}
	/**
	 * Get the component3
	 * @return the component3
	 */
	public String getComponent3() {
		return getComponent(3);
	}

	/**
	 * Get the component3 as Calendar
	 * @return the component3 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getComponent3AsCalendar() {
		return SwiftFormatUtils.getTime3(getComponent(3));
	}

	/**
	 * Get the Time (component3).
	 * @return the Time from component3
	 */
	public String getTime() {
		return getComponent(3);
	}
	
	/**
	 * Get the Time (component3) as Calendar
	 * @return the Time from component3 converted to Calendar or <code>null</code> if cannot be converted
	 */
	public java.util.Calendar getTimeAsCalendar() {
		return SwiftFormatUtils.getTime3(getComponent(3));
	}

	/**
	 * Set the component3.
	 * @param component3 the component3 to set
	 */
	public Field14S setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the component3 from a Calendar object.
	 * @param component3 the Calendar with the component3 content to set
	 */
	public Field14S setComponent3(java.util.Calendar component3) {
		setComponent(3, SwiftFormatUtils.getTime3(component3));
		return this;
	}
	
	/**
	 * Set the Time (component3).
	 * @param component3 the Time to set
	 */
	public Field14S setTime(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the Time (component3) from a Calendar object.
	 * @see #setComponent3(java.util.Calendar)
	 * @param component3 Calendar with the Time content to set
	 */
	public Field14S setTime(java.util.Calendar component3) {
		setComponent3(component3);
		return this;
	}
	/**
	 * Get the component4
	 * @return the component4
	 */
	public String getComponent4() {
		return getComponent(4);
	}

	/**
	 * Same as getComponent(4)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase2=TargetYear._2018)
	public java.lang.String getComponent4AsString() {
		return getComponent(4);
	}

	/**
	 * Get the Location (component4).
	 * @return the Location from component4
	 */
	public String getLocation() {
		return getComponent(4);
	}

	/**
	 * Set the component4.
	 * @param component4 the component4 to set
	 */
	public Field14S setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the Location (component4).
	 * @param component4 the Location to set
	 */
	public Field14S setLocation(String component4) {
		setComponent(4, component4);
		return this;
	}

   /**
    * Given a component number it returns true if the component is optional,
    * regardless of the field being mandatory in a particular message.<br />
    * Being the field's value conformed by a composition of one or several 
    * internal component values, the field may be present in a message with
    * a proper value but with some of its internal components not set.
    *
    * @param component component number, first component of a field is referenced as 1
    * @return true if the component is optional for this field, false otherwise
    */
   @Override
   public boolean isOptional(int component) {   
       if (component == 3) {
           return true;
       }
       if (component == 4) {
           return true;
       }
       return false;
   }

   /**
    * Returns true if the field is a GENERIC FIELD as specified by the standard.
    *
    * @return true if the field is generic, false otherwise
    */
   @Override
   public boolean isGeneric() {   
       return false;
   }
   
   public String parserPattern() {
           return PARSER_PATTERN;
   }

	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field14S.NAME
	 */
	@Override
	public String getName() {
		return NAME;
	}
	
	/**
	 * Returns the field's components pattern
	 * @return the static value of Field14S.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
	 * Returns the field's validators pattern
	 */
	@Override
	public final String validatorPattern() {
		return "3!a2!n[/<HHMM>/4!c]";
	}

	/**
	 * Get the first occurrence form the tag list or null if not found.
	 * @return null if not found o block is null or empty
	 * @param block may be null or empty 
	 */
	public static Field14S get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field14S(t) ;
	}
	
	/**
	 * Get the first instance of Field14S in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field14S get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Get a list of all occurrences of the field Field14S in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field14S> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Get a list of all occurrences of the field Field14S from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field14S> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length>0) {
			final ArrayList<Field14S> result = new ArrayList<Field14S>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field14S(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}
	
	/**
	 * Returns the defined amount of components.<br>
	 * This is not the amount of components present in the field instance, but the total amount of components 
	 * that this field accepts as defined. 
	 * @since 7.7
	 */
	@Override
	public int componentsSize() {
		return 4;
	}

	/**
	 * Returns a localized suitable for showing to humans string of a field component.<br>
	 *
	 * @param component number of the component to display
	 * @param locale optional locale to format date and amounts, if null, the default locale is used
	 * @return formatted component value or null if component number is invalid or not present
	 * @throws IllegalArgumentException if component number is invalid for the field
	 * @since 7.8
	 */
	@Override
	public String getValueDisplay(int component, Locale locale) {
		if (component < 1 || component > 4) {
			throw new IllegalArgumentException("invalid component number "+component+" for field 14S");
		}
		if (component == 1) {
			//default format (as is)
			return getComponent(1);
		}
		if (component == 2) {
			//number, amount, rate
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
			f.setMaximumFractionDigits(13);
    		Number n = getComponent2AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 3) {
			//time
			java.text.DateFormat f = new java.text.SimpleDateFormat("HH:mm", notNull(locale));
			java.util.Calendar cal = getComponent3AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		if (component == 4) {
			//default format (as is)
			return getComponent(4);
		}
		return null;	
	}
	
	/**
	 * Returns english label for components.
	 * <br />
	 * The index in the list is in sync with specific field component structure.
	 * @see #getComponentLabel(int)
	 * @since 7.8.4
	 */
	@Override
	protected List<String> getComponentLabels() {
		List<String> result = new ArrayList<String>();
		result.add("Source");
		result.add("Number");
		result.add("Time");
		result.add("Location");
		return result;
	}
	

}
