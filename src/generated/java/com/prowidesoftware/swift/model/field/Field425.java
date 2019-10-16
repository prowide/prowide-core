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


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 425</strong>
 * <p>
 * Model and parser for field 425 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>20*(2!c/37x)</code></li>
 * 		<li>parser pattern: <code>20*(S/S)</code></li>
 * 		<li>components pattern: <code>SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2019</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field425 extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 425
	 */
    public static final String NAME = "425";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_425 = "425";
	public static final String PARSER_PATTERN ="20*(S/S)";
	public static final String COMPONENTS_PATTERN = "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS";

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field425() {
		super(40);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field425(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field425(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "425")) {
			throw new IllegalArgumentException("cannot create field 425 from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field425 newInstance(Field425 source) {
		Field425 cp = new Field425();
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
		init(40);
		/*
		 * This parser implementation needs review, the actual field format is not clear in the standard:
		 
		 * 422 <MI-message-data-text> 20*(2!c/37x) This field is only for use by Market Infrastructures 
		 * which have subscribed to the Market Infrastructure Resiliency Service (MIRS).
		 *
		 * It is not clear how to split one instance to the other between the 12 occurrences
		 */
		if (value != null) {
			String[] tokens = StringUtils.split(value, "/");
			final StringBuilder lastComponent = new StringBuilder();
			for (int i=0; i<tokens.length; i++) {
				if (i < 40) {
					//set all components sequentially, but the last one
					setComponent(i+1, tokens[i]);
				} else {
					//the last component will include all the remaining string
					if (lastComponent.length() > 0) {
						lastComponent.append("/");
					}
					lastComponent.append(tokens[i]);
				}
			}
			if (lastComponent.length() > 0) {
				setComponent40(lastComponent.toString());
			}
		}
	}
	/**
	 * Serializes the fields' components into the single string value (SWIFT format)
	 */
	@Override
	public String getValue() {
		final StringBuilder result = new StringBuilder();
		//FIXME serialization 20*(S/S)
		// @NotImplemented
		int notImplemented;
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
		if (component < 1 || component > 40) {
			throw new IllegalArgumentException("invalid component number "+component+" for field 425");
		}
		if (component == 1) {
			//default format (as is)
			return getComponent(1);
		}
		if (component == 2) {
			//default format (as is)
			return getComponent(2);
		}
		if (component == 3) {
			//default format (as is)
			return getComponent(3);
		}
		if (component == 4) {
			//default format (as is)
			return getComponent(4);
		}
		if (component == 5) {
			//default format (as is)
			return getComponent(5);
		}
		if (component == 6) {
			//default format (as is)
			return getComponent(6);
		}
		if (component == 7) {
			//default format (as is)
			return getComponent(7);
		}
		if (component == 8) {
			//default format (as is)
			return getComponent(8);
		}
		if (component == 9) {
			//default format (as is)
			return getComponent(9);
		}
		if (component == 10) {
			//default format (as is)
			return getComponent(10);
		}
		if (component == 11) {
			//default format (as is)
			return getComponent(11);
		}
		if (component == 12) {
			//default format (as is)
			return getComponent(12);
		}
		if (component == 13) {
			//default format (as is)
			return getComponent(13);
		}
		if (component == 14) {
			//default format (as is)
			return getComponent(14);
		}
		if (component == 15) {
			//default format (as is)
			return getComponent(15);
		}
		if (component == 16) {
			//default format (as is)
			return getComponent(16);
		}
		if (component == 17) {
			//default format (as is)
			return getComponent(17);
		}
		if (component == 18) {
			//default format (as is)
			return getComponent(18);
		}
		if (component == 19) {
			//default format (as is)
			return getComponent(19);
		}
		if (component == 20) {
			//default format (as is)
			return getComponent(20);
		}
		if (component == 21) {
			//default format (as is)
			return getComponent(21);
		}
		if (component == 22) {
			//default format (as is)
			return getComponent(22);
		}
		if (component == 23) {
			//default format (as is)
			return getComponent(23);
		}
		if (component == 24) {
			//default format (as is)
			return getComponent(24);
		}
		if (component == 25) {
			//default format (as is)
			return getComponent(25);
		}
		if (component == 26) {
			//default format (as is)
			return getComponent(26);
		}
		if (component == 27) {
			//default format (as is)
			return getComponent(27);
		}
		if (component == 28) {
			//default format (as is)
			return getComponent(28);
		}
		if (component == 29) {
			//default format (as is)
			return getComponent(29);
		}
		if (component == 30) {
			//default format (as is)
			return getComponent(30);
		}
		if (component == 31) {
			//default format (as is)
			return getComponent(31);
		}
		if (component == 32) {
			//default format (as is)
			return getComponent(32);
		}
		if (component == 33) {
			//default format (as is)
			return getComponent(33);
		}
		if (component == 34) {
			//default format (as is)
			return getComponent(34);
		}
		if (component == 35) {
			//default format (as is)
			return getComponent(35);
		}
		if (component == 36) {
			//default format (as is)
			return getComponent(36);
		}
		if (component == 37) {
			//default format (as is)
			return getComponent(37);
		}
		if (component == 38) {
			//default format (as is)
			return getComponent(38);
		}
		if (component == 39) {
			//default format (as is)
			return getComponent(39);
		}
		if (component == 40) {
			//default format (as is)
			return getComponent(40);
		}
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field425.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field425.PARSER_PATTERN
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
		return "20*(2!c/37x)";
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
		return 40;
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
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		result.add(null);
		return result;
	}

	/**
	 * Returns a mapping between component numbers and their label in camel case format.
	 * @since 7.10.3
	 */
	@Override
	protected Map<Integer, String> getComponentMap() {
		Map<Integer, String> result = new HashMap<>();
		return result;
	}
	/**
	 * Gets the component1 ($label).
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
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent1AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent1AsString()", "Use use #getComponent(int) instead.");
		return getComponent(1);
	}
	/**
	 * Gets the component2 ($label).
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
	 * Gets the component3 ($label).
	 * @return the component3
	 */
	public String getComponent3() {
		return getComponent(3);
	}

	/**
	 * Same as getComponent(3)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent3AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent3AsString()", "Use use #getComponent(int) instead.");
		return getComponent(3);
	}
	/**
	 * Gets the component4 ($label).
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
	 * Gets the component5 ($label).
	 * @return the component5
	 */
	public String getComponent5() {
		return getComponent(5);
	}

	/**
	 * Same as getComponent(5)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent5AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent5AsString()", "Use use #getComponent(int) instead.");
		return getComponent(5);
	}
	/**
	 * Gets the component6 ($label).
	 * @return the component6
	 */
	public String getComponent6() {
		return getComponent(6);
	}

	/**
	 * Same as getComponent(6)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent6AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent6AsString()", "Use use #getComponent(int) instead.");
		return getComponent(6);
	}
	/**
	 * Gets the component7 ($label).
	 * @return the component7
	 */
	public String getComponent7() {
		return getComponent(7);
	}

	/**
	 * Same as getComponent(7)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent7AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent7AsString()", "Use use #getComponent(int) instead.");
		return getComponent(7);
	}
	/**
	 * Gets the component8 ($label).
	 * @return the component8
	 */
	public String getComponent8() {
		return getComponent(8);
	}

	/**
	 * Same as getComponent(8)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent8AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent8AsString()", "Use use #getComponent(int) instead.");
		return getComponent(8);
	}
	/**
	 * Gets the component9 ($label).
	 * @return the component9
	 */
	public String getComponent9() {
		return getComponent(9);
	}

	/**
	 * Same as getComponent(9)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent9AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent9AsString()", "Use use #getComponent(int) instead.");
		return getComponent(9);
	}
	/**
	 * Gets the component10 ($label).
	 * @return the component10
	 */
	public String getComponent10() {
		return getComponent(10);
	}

	/**
	 * Same as getComponent(10)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent10AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent10AsString()", "Use use #getComponent(int) instead.");
		return getComponent(10);
	}
	/**
	 * Gets the component11 ($label).
	 * @return the component11
	 */
	public String getComponent11() {
		return getComponent(11);
	}

	/**
	 * Same as getComponent(11)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent11AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent11AsString()", "Use use #getComponent(int) instead.");
		return getComponent(11);
	}
	/**
	 * Gets the component12 ($label).
	 * @return the component12
	 */
	public String getComponent12() {
		return getComponent(12);
	}

	/**
	 * Same as getComponent(12)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent12AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent12AsString()", "Use use #getComponent(int) instead.");
		return getComponent(12);
	}
	/**
	 * Gets the component13 ($label).
	 * @return the component13
	 */
	public String getComponent13() {
		return getComponent(13);
	}

	/**
	 * Same as getComponent(13)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent13AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent13AsString()", "Use use #getComponent(int) instead.");
		return getComponent(13);
	}
	/**
	 * Gets the component14 ($label).
	 * @return the component14
	 */
	public String getComponent14() {
		return getComponent(14);
	}

	/**
	 * Same as getComponent(14)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent14AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent14AsString()", "Use use #getComponent(int) instead.");
		return getComponent(14);
	}
	/**
	 * Gets the component15 ($label).
	 * @return the component15
	 */
	public String getComponent15() {
		return getComponent(15);
	}

	/**
	 * Same as getComponent(15)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent15AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent15AsString()", "Use use #getComponent(int) instead.");
		return getComponent(15);
	}
	/**
	 * Gets the component16 ($label).
	 * @return the component16
	 */
	public String getComponent16() {
		return getComponent(16);
	}

	/**
	 * Same as getComponent(16)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent16AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent16AsString()", "Use use #getComponent(int) instead.");
		return getComponent(16);
	}
	/**
	 * Gets the component17 ($label).
	 * @return the component17
	 */
	public String getComponent17() {
		return getComponent(17);
	}

	/**
	 * Same as getComponent(17)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent17AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent17AsString()", "Use use #getComponent(int) instead.");
		return getComponent(17);
	}
	/**
	 * Gets the component18 ($label).
	 * @return the component18
	 */
	public String getComponent18() {
		return getComponent(18);
	}

	/**
	 * Same as getComponent(18)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent18AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent18AsString()", "Use use #getComponent(int) instead.");
		return getComponent(18);
	}
	/**
	 * Gets the component19 ($label).
	 * @return the component19
	 */
	public String getComponent19() {
		return getComponent(19);
	}

	/**
	 * Same as getComponent(19)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent19AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent19AsString()", "Use use #getComponent(int) instead.");
		return getComponent(19);
	}
	/**
	 * Gets the component20 ($label).
	 * @return the component20
	 */
	public String getComponent20() {
		return getComponent(20);
	}

	/**
	 * Same as getComponent(20)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent20AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent20AsString()", "Use use #getComponent(int) instead.");
		return getComponent(20);
	}
	/**
	 * Gets the component21 ($label).
	 * @return the component21
	 */
	public String getComponent21() {
		return getComponent(21);
	}

	/**
	 * Same as getComponent(21)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent21AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent21AsString()", "Use use #getComponent(int) instead.");
		return getComponent(21);
	}
	/**
	 * Gets the component22 ($label).
	 * @return the component22
	 */
	public String getComponent22() {
		return getComponent(22);
	}

	/**
	 * Same as getComponent(22)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent22AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent22AsString()", "Use use #getComponent(int) instead.");
		return getComponent(22);
	}
	/**
	 * Gets the component23 ($label).
	 * @return the component23
	 */
	public String getComponent23() {
		return getComponent(23);
	}

	/**
	 * Same as getComponent(23)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent23AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent23AsString()", "Use use #getComponent(int) instead.");
		return getComponent(23);
	}
	/**
	 * Gets the component24 ($label).
	 * @return the component24
	 */
	public String getComponent24() {
		return getComponent(24);
	}

	/**
	 * Same as getComponent(24)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent24AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent24AsString()", "Use use #getComponent(int) instead.");
		return getComponent(24);
	}
	/**
	 * Gets the component25 ($label).
	 * @return the component25
	 */
	public String getComponent25() {
		return getComponent(25);
	}

	/**
	 * Same as getComponent(25)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent25AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent25AsString()", "Use use #getComponent(int) instead.");
		return getComponent(25);
	}
	/**
	 * Gets the component26 ($label).
	 * @return the component26
	 */
	public String getComponent26() {
		return getComponent(26);
	}

	/**
	 * Same as getComponent(26)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent26AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent26AsString()", "Use use #getComponent(int) instead.");
		return getComponent(26);
	}
	/**
	 * Gets the component27 ($label).
	 * @return the component27
	 */
	public String getComponent27() {
		return getComponent(27);
	}

	/**
	 * Same as getComponent(27)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent27AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent27AsString()", "Use use #getComponent(int) instead.");
		return getComponent(27);
	}
	/**
	 * Gets the component28 ($label).
	 * @return the component28
	 */
	public String getComponent28() {
		return getComponent(28);
	}

	/**
	 * Same as getComponent(28)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent28AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent28AsString()", "Use use #getComponent(int) instead.");
		return getComponent(28);
	}
	/**
	 * Gets the component29 ($label).
	 * @return the component29
	 */
	public String getComponent29() {
		return getComponent(29);
	}

	/**
	 * Same as getComponent(29)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent29AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent29AsString()", "Use use #getComponent(int) instead.");
		return getComponent(29);
	}
	/**
	 * Gets the component30 ($label).
	 * @return the component30
	 */
	public String getComponent30() {
		return getComponent(30);
	}

	/**
	 * Same as getComponent(30)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent30AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent30AsString()", "Use use #getComponent(int) instead.");
		return getComponent(30);
	}
	/**
	 * Gets the component31 ($label).
	 * @return the component31
	 */
	public String getComponent31() {
		return getComponent(31);
	}

	/**
	 * Same as getComponent(31)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent31AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent31AsString()", "Use use #getComponent(int) instead.");
		return getComponent(31);
	}
	/**
	 * Gets the component32 ($label).
	 * @return the component32
	 */
	public String getComponent32() {
		return getComponent(32);
	}

	/**
	 * Same as getComponent(32)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent32AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent32AsString()", "Use use #getComponent(int) instead.");
		return getComponent(32);
	}
	/**
	 * Gets the component33 ($label).
	 * @return the component33
	 */
	public String getComponent33() {
		return getComponent(33);
	}

	/**
	 * Same as getComponent(33)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent33AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent33AsString()", "Use use #getComponent(int) instead.");
		return getComponent(33);
	}
	/**
	 * Gets the component34 ($label).
	 * @return the component34
	 */
	public String getComponent34() {
		return getComponent(34);
	}

	/**
	 * Same as getComponent(34)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent34AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent34AsString()", "Use use #getComponent(int) instead.");
		return getComponent(34);
	}
	/**
	 * Gets the component35 ($label).
	 * @return the component35
	 */
	public String getComponent35() {
		return getComponent(35);
	}

	/**
	 * Same as getComponent(35)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent35AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent35AsString()", "Use use #getComponent(int) instead.");
		return getComponent(35);
	}
	/**
	 * Gets the component36 ($label).
	 * @return the component36
	 */
	public String getComponent36() {
		return getComponent(36);
	}

	/**
	 * Same as getComponent(36)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent36AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent36AsString()", "Use use #getComponent(int) instead.");
		return getComponent(36);
	}
	/**
	 * Gets the component37 ($label).
	 * @return the component37
	 */
	public String getComponent37() {
		return getComponent(37);
	}

	/**
	 * Same as getComponent(37)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent37AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent37AsString()", "Use use #getComponent(int) instead.");
		return getComponent(37);
	}
	/**
	 * Gets the component38 ($label).
	 * @return the component38
	 */
	public String getComponent38() {
		return getComponent(38);
	}

	/**
	 * Same as getComponent(38)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent38AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent38AsString()", "Use use #getComponent(int) instead.");
		return getComponent(38);
	}
	/**
	 * Gets the component39 ($label).
	 * @return the component39
	 */
	public String getComponent39() {
		return getComponent(39);
	}

	/**
	 * Same as getComponent(39)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent39AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent39AsString()", "Use use #getComponent(int) instead.");
		return getComponent(39);
	}
	/**
	 * Gets the component40 ($label).
	 * @return the component40
	 */
	public String getComponent40() {
		return getComponent(40);
	}

	/**
	 * Same as getComponent(40)
	 * @deprecated use {@link #getComponent(int)} instead
	 */
	@Deprecated
	@ProwideDeprecated(phase4=TargetYear.SRU2020)
	public java.lang.String getComponent40AsString() {
		com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent40AsString()", "Use use #getComponent(int) instead.");
		return getComponent(40);
	}


	/**
	 * Set the component1 ($label).
	 * @param component1 the component1 to set
	 */
	public Field425 setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}

	/**
	 * Set the component2 ($label).
	 * @param component2 the component2 to set
	 */
	public Field425 setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}

	/**
	 * Set the component3 ($label).
	 * @param component3 the component3 to set
	 */
	public Field425 setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}

	/**
	 * Set the component4 ($label).
	 * @param component4 the component4 to set
	 */
	public Field425 setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}

	/**
	 * Set the component5 ($label).
	 * @param component5 the component5 to set
	 */
	public Field425 setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}

	/**
	 * Set the component6 ($label).
	 * @param component6 the component6 to set
	 */
	public Field425 setComponent6(String component6) {
		setComponent(6, component6);
		return this;
	}

	/**
	 * Set the component7 ($label).
	 * @param component7 the component7 to set
	 */
	public Field425 setComponent7(String component7) {
		setComponent(7, component7);
		return this;
	}

	/**
	 * Set the component8 ($label).
	 * @param component8 the component8 to set
	 */
	public Field425 setComponent8(String component8) {
		setComponent(8, component8);
		return this;
	}

	/**
	 * Set the component9 ($label).
	 * @param component9 the component9 to set
	 */
	public Field425 setComponent9(String component9) {
		setComponent(9, component9);
		return this;
	}

	/**
	 * Set the component10 ($label).
	 * @param component10 the component10 to set
	 */
	public Field425 setComponent10(String component10) {
		setComponent(10, component10);
		return this;
	}

	/**
	 * Set the component11 ($label).
	 * @param component11 the component11 to set
	 */
	public Field425 setComponent11(String component11) {
		setComponent(11, component11);
		return this;
	}

	/**
	 * Set the component12 ($label).
	 * @param component12 the component12 to set
	 */
	public Field425 setComponent12(String component12) {
		setComponent(12, component12);
		return this;
	}

	/**
	 * Set the component13 ($label).
	 * @param component13 the component13 to set
	 */
	public Field425 setComponent13(String component13) {
		setComponent(13, component13);
		return this;
	}

	/**
	 * Set the component14 ($label).
	 * @param component14 the component14 to set
	 */
	public Field425 setComponent14(String component14) {
		setComponent(14, component14);
		return this;
	}

	/**
	 * Set the component15 ($label).
	 * @param component15 the component15 to set
	 */
	public Field425 setComponent15(String component15) {
		setComponent(15, component15);
		return this;
	}

	/**
	 * Set the component16 ($label).
	 * @param component16 the component16 to set
	 */
	public Field425 setComponent16(String component16) {
		setComponent(16, component16);
		return this;
	}

	/**
	 * Set the component17 ($label).
	 * @param component17 the component17 to set
	 */
	public Field425 setComponent17(String component17) {
		setComponent(17, component17);
		return this;
	}

	/**
	 * Set the component18 ($label).
	 * @param component18 the component18 to set
	 */
	public Field425 setComponent18(String component18) {
		setComponent(18, component18);
		return this;
	}

	/**
	 * Set the component19 ($label).
	 * @param component19 the component19 to set
	 */
	public Field425 setComponent19(String component19) {
		setComponent(19, component19);
		return this;
	}

	/**
	 * Set the component20 ($label).
	 * @param component20 the component20 to set
	 */
	public Field425 setComponent20(String component20) {
		setComponent(20, component20);
		return this;
	}

	/**
	 * Set the component21 ($label).
	 * @param component21 the component21 to set
	 */
	public Field425 setComponent21(String component21) {
		setComponent(21, component21);
		return this;
	}

	/**
	 * Set the component22 ($label).
	 * @param component22 the component22 to set
	 */
	public Field425 setComponent22(String component22) {
		setComponent(22, component22);
		return this;
	}

	/**
	 * Set the component23 ($label).
	 * @param component23 the component23 to set
	 */
	public Field425 setComponent23(String component23) {
		setComponent(23, component23);
		return this;
	}

	/**
	 * Set the component24 ($label).
	 * @param component24 the component24 to set
	 */
	public Field425 setComponent24(String component24) {
		setComponent(24, component24);
		return this;
	}

	/**
	 * Set the component25 ($label).
	 * @param component25 the component25 to set
	 */
	public Field425 setComponent25(String component25) {
		setComponent(25, component25);
		return this;
	}

	/**
	 * Set the component26 ($label).
	 * @param component26 the component26 to set
	 */
	public Field425 setComponent26(String component26) {
		setComponent(26, component26);
		return this;
	}

	/**
	 * Set the component27 ($label).
	 * @param component27 the component27 to set
	 */
	public Field425 setComponent27(String component27) {
		setComponent(27, component27);
		return this;
	}

	/**
	 * Set the component28 ($label).
	 * @param component28 the component28 to set
	 */
	public Field425 setComponent28(String component28) {
		setComponent(28, component28);
		return this;
	}

	/**
	 * Set the component29 ($label).
	 * @param component29 the component29 to set
	 */
	public Field425 setComponent29(String component29) {
		setComponent(29, component29);
		return this;
	}

	/**
	 * Set the component30 ($label).
	 * @param component30 the component30 to set
	 */
	public Field425 setComponent30(String component30) {
		setComponent(30, component30);
		return this;
	}

	/**
	 * Set the component31 ($label).
	 * @param component31 the component31 to set
	 */
	public Field425 setComponent31(String component31) {
		setComponent(31, component31);
		return this;
	}

	/**
	 * Set the component32 ($label).
	 * @param component32 the component32 to set
	 */
	public Field425 setComponent32(String component32) {
		setComponent(32, component32);
		return this;
	}

	/**
	 * Set the component33 ($label).
	 * @param component33 the component33 to set
	 */
	public Field425 setComponent33(String component33) {
		setComponent(33, component33);
		return this;
	}

	/**
	 * Set the component34 ($label).
	 * @param component34 the component34 to set
	 */
	public Field425 setComponent34(String component34) {
		setComponent(34, component34);
		return this;
	}

	/**
	 * Set the component35 ($label).
	 * @param component35 the component35 to set
	 */
	public Field425 setComponent35(String component35) {
		setComponent(35, component35);
		return this;
	}

	/**
	 * Set the component36 ($label).
	 * @param component36 the component36 to set
	 */
	public Field425 setComponent36(String component36) {
		setComponent(36, component36);
		return this;
	}

	/**
	 * Set the component37 ($label).
	 * @param component37 the component37 to set
	 */
	public Field425 setComponent37(String component37) {
		setComponent(37, component37);
		return this;
	}

	/**
	 * Set the component38 ($label).
	 * @param component38 the component38 to set
	 */
	public Field425 setComponent38(String component38) {
		setComponent(38, component38);
		return this;
	}

	/**
	 * Set the component39 ($label).
	 * @param component39 the component39 to set
	 */
	public Field425 setComponent39(String component39) {
		setComponent(39, component39);
		return this;
	}

	/**
	 * Set the component40 ($label).
	 * @param component40 the component40 to set
	 */
	public Field425 setComponent40(String component40) {
		setComponent(40, component40);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field425.NAME
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
	public static Field425 get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field425(t) ;
	}
	
	/**
	 * Gets the first instance of Field425 in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field425 get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field425 in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field425> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field425 from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field425> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field425> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field425(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}

	/**
	 * This method deserializes the JSON data into a Field425 object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field425 fromJson(final String json) {
		Field425 field = new Field425();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		return field;
	}
	

}
