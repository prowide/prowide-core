/*
 * Copyright 2006-2019 Prowide
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
package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.Generated;
import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

import java.io.Serializable;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import com.prowidesoftware.swift.model.field.MultiLineField;


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 130</strong>
 * <p>
 * Model and parser for field 130 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>Number</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>/2!n/65x$/2!n/65x</code></li>
 * 		<li>parser pattern: <code>/S/S$/S/S</code></li>
 * 		<li>components pattern: <code>NSNS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2019</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field130 extends Field implements Serializable, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 130
	 */
    public static final String NAME = "130";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_130 = "130";
	public static final String PARSER_PATTERN ="/S/S$/S/S";
	public static final String COMPONENTS_PATTERN = "NSNS";

	/**
	 * Component number for the Heading Code subfield
	 */
	public static final Integer HEADING_CODE = 1;

	/**
	 * Component number for the Heading Text subfield
	 */
	public static final Integer HEADING_TEXT = 2;

	/**
	 * Component number for the Heading Code 2 subfield
	 */
	public static final Integer HEADING_CODE_2 = 3;

	/**
	 * Component number for the Heading Text 2 subfield
	 */
	public static final Integer HEADING_TEXT_2 = 4;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field130() {
		super(4);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field130(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field130(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "130")) {
			throw new IllegalArgumentException("cannot create field 130 from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field130 newInstance(Field130 source) {
		Field130 cp = new Field130();
		cp.setComponents(new ArrayList<>(source.getComponents()));
		return cp;
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
	 * Parses the parameter value into the internal components structure.
	 *
	 * <p>Used to update all components from a full new value, as an alternative
	 * to setting individual components. Previous component values are overwritten.
	 *
	 * @param value complete field value including separators and CRLF
	 * @since 7.8
	 */
	@Override
	public void parse(final String value) {
		init(4);
		List<String> lines = SwiftParseUtils.getLines(value);
		if (!lines.isEmpty()) {
			setComponent1(SwiftParseUtils.getTokenFirst(lines.get(0), "/", "/"));
			setComponent2(SwiftParseUtils.getTokenSecondLast(lines.get(0), "/", "/"));
			if (lines.size() > 1) {
				setComponent3(SwiftParseUtils.getTokenFirst(lines.get(1), "/", "/"));
				setComponent4(SwiftParseUtils.getTokenSecondLast(lines.get(1), "/", "/"));
			}
		}
	}
	/**
	 * Serializes the fields' components into the single string value (SWIFT format)
	 */
	@Override
	public String getValue() {
		final StringBuilder result = new StringBuilder();
		result.append("/");
		append(result, 1);
		result.append("/");
		append(result, 2);
		if (getComponent3() != null || getComponent4() != null) {
			result.append(com.prowidesoftware.swift.io.writer.FINWriterVisitor.SWIFT_EOL);
		}
		result.append("/");
		append(result, 3);
		result.append("/");
		append(result, 4);
		return result.toString();
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
			throw new IllegalArgumentException("invalid component number "+component+" for field 130");
		}
		if (component == 1) {
			//number, amount, rate
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
			f.setMaximumFractionDigits(13);
    		Number n = getComponent1AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 2) {
			//default format (as is)
			return getComponent(2);
		}
		if (component == 3) {
			//number, amount, rate
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
			f.setMaximumFractionDigits(13);
    		Number n = getComponent3AsNumber();
			if (n != null) {
				return f.format(n);
			}
		}
		if (component == 4) {
			//default format (as is)
			return getComponent(4);
		}
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field130.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field130.PARSER_PATTERN
     */
	@Override
	public final String parserPattern() {
        return PARSER_PATTERN;
    }

	/**
	 * Returns the field validator pattern
	 */
	@Override
	public final String validatorPattern() {
		return "/2!n/65x$/2!n/65x";
	}

    /**
     * Given a component number it returns true if the component is optional,
     * regardless of the field being mandatory in a particular message.<br>
     * Being the field's value conformed by a composition of one or several
     * internal component values, the field may be present in a message with
     * a proper value but with some of its internal components not set.
     *
     * @param component component number, first component of a field is referenced as 1
     * @return true if the component is optional for this field, false otherwise
     */
    @Override
    public boolean isOptional(int component) {
        return false;
    }

    /**
     * Returns true if the field is a GENERIC FIELD as specified by the standard.
     * @return true if the field is generic, false otherwise
     */
    @Override
    public boolean isGeneric() {
        return false;
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
	 * Returns english label for components.
	 * <br>
	 * The index in the list is in sync with specific field component structure.
	 * @see #getComponentLabel(int)
	 * @since 7.8.4
	 */
	@Override
	protected List<String> getComponentLabels() {
		List<String> result = new ArrayList<>();
		result.add("Heading Code");
		result.add("Heading Text");
		result.add("Heading Code 2");
		result.add("Heading Text 2");
		return result;
	}

	/**
	 * Returns a mapping between component numbers and their label in camel case format.
	 * @since 7.10.3
	 */
	@Override
	protected Map<Integer, String> getComponentMap() {
		Map<Integer, String> result = new HashMap<>();
		result.put(1, "headingCode");
		result.put(2, "headingText");
		result.put(3, "headingCode2");
		result.put(4, "headingText2");
		return result;
	}
	/**
	 * Gets the component1 (Heading Code).
	 * @return the component1
	 */
	public String getComponent1() {
		return getComponent(1);
	}

	/**
	 * Get the component1 as Number
	 * @return the component1 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getComponent1AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(1));
	}

	/**
	 * Gets the Heading Code (component1).
	 * @return the Heading Code from component1
	 */
	public String getHeadingCode() {
		return getComponent(1);
	}
	
	/**
	 * Get the Heading Code (component1) as Number
	 * @return the Heading Code from component1 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getHeadingCodeAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(1));
	}
	/**
	 * Gets the component2 (Heading Text).
	 * @return the component2
	 */
	public String getComponent2() {
		return getComponent(2);
	}

	/**
	 * Same as getComponent(2)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent2AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent2AsString()", "Use use #getComponent(int) instead.");
		return getComponent(2);
	}

	/**
	 * Gets the Heading Text (component2).
	 * @return the Heading Text from component2
	 */
	public String getHeadingText() {
		return getComponent(2);
	}
	/**
	 * Gets the component3 (Heading Code 2).
	 * @return the component3
	 */
	public String getComponent3() {
		return getComponent(3);
	}

	/**
	 * Get the component3 as Number
	 * @return the component3 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getComponent3AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(3));
	}

	/**
	 * Gets the Heading Code 2 (component3).
	 * @return the Heading Code 2 from component3
	 */
	public String getHeadingCode2() {
		return getComponent(3);
	}
	
	/**
	 * Get the Heading Code 2 (component3) as Number
	 * @return the Heading Code 2 from component3 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getHeadingCode2AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(3));
	}
	/**
	 * Gets the component4 (Heading Text 2).
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
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent4AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent4AsString()", "Use use #getComponent(int) instead.");
		return getComponent(4);
	}

	/**
	 * Gets the Heading Text 2 (component4).
	 * @return the Heading Text 2 from component4
	 */
	public String getHeadingText2() {
		return getComponent(4);
	}


	/**
	 * Set the component1 (Heading Code).
	 * @param component1 the component1 to set
	 */
	public Field130 setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the component1 from a Number object.
	 * <br>
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent1(String) 
	 * method.
	 * 
	 * @see #setComponent1(String)
	 *
	 * @param component1 the Number with the component1 content to set
	 */
	public Field130 setComponent1(java.lang.Number component1) {
		if (component1 != null) {
			setComponent(1, Integer.toString(component1.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the Heading Code (component1).
	 * @param component1 the Heading Code to set
	 */
	public Field130 setHeadingCode(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Heading Code (component1) from a Number object.
	 * @see #setComponent1(java.lang.Number)
	 * @param component1 Number with the Heading Code content to set
	 */
	public Field130 setHeadingCode(java.lang.Number component1) {
		setComponent1(component1);
		return this;
	}

	/**
	 * Set the component2 (Heading Text).
	 * @param component2 the component2 to set
	 */
	public Field130 setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Heading Text (component2).
	 * @param component2 the Heading Text to set
	 */
	public Field130 setHeadingText(String component2) {
		setComponent(2, component2);
		return this;
	}

	/**
	 * Set the component3 (Heading Code 2).
	 * @param component3 the component3 to set
	 */
	public Field130 setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the component3 from a Number object.
	 * <br>
	 * <em>If the component being set is a fixed length number, the argument will not be 
	 * padded.</em> It is recommended for these cases to use the setComponent3(String) 
	 * method.
	 * 
	 * @see #setComponent3(String)
	 *
	 * @param component3 the Number with the component3 content to set
	 */
	public Field130 setComponent3(java.lang.Number component3) {
		if (component3 != null) {
			setComponent(3, Integer.toString(component3.intValue()));
		}
		return this;
	}
	
	/**
	 * Set the Heading Code 2 (component3).
	 * @param component3 the Heading Code 2 to set
	 */
	public Field130 setHeadingCode2(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the Heading Code 2 (component3) from a Number object.
	 * @see #setComponent3(java.lang.Number)
	 * @param component3 Number with the Heading Code 2 content to set
	 */
	public Field130 setHeadingCode2(java.lang.Number component3) {
		setComponent3(component3);
		return this;
	}

	/**
	 * Set the component4 (Heading Text 2).
	 * @param component4 the component4 to set
	 */
	public Field130 setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the Heading Text 2 (component4).
	 * @param component4 the Heading Text 2 to set
	 */
	public Field130 setHeadingText2(String component4) {
		setComponent(4, component4);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field130.NAME
	 */
	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * Gets the first occurrence form the tag list or null if not found.
	 * @return null if not found o block is null or empty
	 * @param block may be null or empty 
	 */
	public static Field130 get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field130(t) ;
	}
	
	/**
	 * Gets the first instance of Field130 in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field130 get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field130 in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field130> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field130 from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field130> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field130> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field130(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}
	
	/**
	 * Returns a specific line from the field's value.<br>
	 *
	 * @see MultiLineField#getLine(int)
	 * @param line a reference to a specific line in the field, first line being 1
	 * @return line content or null if not present or if line number is above the expected
	 * @since 7.7
	 */
	public String getLine(int line) {
		return getLine(line, 0);
	}
	
	/**
	 * Returns a specific line from the field's value.<br>
	 * 
	 * @see MultiLineField#getLine(int, int)
	 * @param line a reference to a specific line in the field, first line being 1
	 * @param offset an optional component number used as offset when counting lines
	 * @return line content or null if not present or if line number is above the expected
	 * @since 7.7
	 */
	public String getLine(int line, int offset) {
		Field130 cp = newInstance(this);
		return getLine(cp, line, null, offset);
	}
	
	/**
	 * Returns the field value split into lines.<br>
	 *
	 * @see MultiLineField#getLines()
	 * @return lines content or empty list if field's value is empty
	 * @since 7.7
	 */
	public List<String> getLines() {
		return SwiftParseUtils.getLines(getValue());
	}

	/**
	 * Returns the field value starting at the offset component, split into lines.<br>
	 *
	 * @see MultiLineField#getLines(int)
	 * @param offset an optional component number used as offset when counting lines
	 * @return found lines or empty list if lines are not present or the offset is invalid
	 * @since 7.7
	 */
	public List<String> getLines(int offset) {
		Field130 cp = newInstance(this);
		return SwiftParseUtils.getLines(getLine(cp, null, null, offset));
	}
	
	/**
	 * Returns a specific subset of lines from the field's value, given a range.<br>
	 *
	 * @see MultiLineField#getLinesBetween(int, int )
	 * @param start a reference to a specific line in the field, first line being 1
	 * @param end a reference to a specific line in the field, must be greater than start
	 * @return found lines or empty list if value is empty
	 * @since 7.7
	 */
	public List<String> getLinesBetween(int start, int end) {
		return getLinesBetween(start, end, 0);
	}

	/**
	 * Returns a specific subset of lines from the field's value, starting at the offset component.<br>
	 *
	 * @see MultiLineField#getLinesBetween(int start, int end, int offset)
	 * @param start a reference to a specific line in the field, first line being 1
	 * @param end a reference to a specific line in the field, must be greater than start
	 * @param offset an optional component number used as offset when counting lines
	 * @return found lines or empty list if lines are not present or the offset is invalid
	 * @since 7.7
	 */
	public List<String> getLinesBetween(int start, int end, int offset) {
		Field130 cp = newInstance(this);
		return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
	}

	/**
	 * This method deserializes the JSON data into a Field130 object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field130 fromJson(final String json) {
		Field130 field = new Field130();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("headingCode") != null) {
			field.setComponent1(jsonObject.get("headingCode").getAsString());
		}
		if (jsonObject.get("headingText") != null) {
			field.setComponent2(jsonObject.get("headingText").getAsString());
		}
		if (jsonObject.get("headingCode2") != null) {
			field.setComponent3(jsonObject.get("headingCode2").getAsString());
		}
		if (jsonObject.get("headingText2") != null) {
			field.setComponent4(jsonObject.get("headingText2").getAsString());
		}
		return field;
	}
	

}
