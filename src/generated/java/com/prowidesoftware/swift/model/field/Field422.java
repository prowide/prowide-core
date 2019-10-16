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
 * <strong>SWIFT MT Field 422</strong>
 * <p>
 * Model and parser for field 422 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>Character</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Character</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Character</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Character</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Character</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Character</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Character</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Character</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Character</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Character</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Character</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Character</code></li>
 * 		<li><code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>12*(1!c/38x)</code></li>
 * 		<li>parser pattern: <code>12*(S/S)</code></li>
 * 		<li>components pattern: <code>cScScScScScScScScScScScS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2019</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field422 extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 422
	 */
    public static final String NAME = "422";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_422 = "422";
	public static final String PARSER_PATTERN ="12*(S/S)";
	public static final String COMPONENTS_PATTERN = "cScScScScScScScScScScScS";

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field422() {
		super(24);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field422(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field422(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "422")) {
			throw new IllegalArgumentException("cannot create field 422 from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field422 newInstance(Field422 source) {
		Field422 cp = new Field422();
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
		init(24);
		/*
		 * This parser implementation needs review, the actual field format is not clear in the standard:
		 
		 * 422 <copy-message-data-text> 12*(1!c/38x) This field is only for use by Market Infrastructures 
		 * which have subscribed to the Market Infrastructure Resiliency Service (MIRS).
		 *
		 * It is not clear how to split one instance to the other between the 12 occurrences
		 */
		if (value != null) {
			String[] tokens = StringUtils.split(value, "/");
			final StringBuilder lastComponent = new StringBuilder();
			for (int i=0; i<tokens.length; i++) {
				if (i < 24) {
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
				setComponent24(lastComponent.toString());
			}
		}
	}
	/**
	 * Serializes the fields' components into the single string value (SWIFT format)
	 */
	@Override
	public String getValue() {
		final StringBuilder result = new StringBuilder();
		//FIXME serialization 12*(S/S)
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
		if (component < 1 || component > 24) {
			throw new IllegalArgumentException("invalid component number "+component+" for field 422");
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
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field422.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field422.PARSER_PATTERN
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
		return "12*(1!c/38x)";
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
		return 24;
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
	 * Set the component1 ($label).
	 * @param component1 the component1 to set
	 */
	public Field422 setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}

	/**
	 * Set the component2 ($label).
	 * @param component2 the component2 to set
	 */
	public Field422 setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}

	/**
	 * Set the component3 ($label).
	 * @param component3 the component3 to set
	 */
	public Field422 setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}

	/**
	 * Set the component4 ($label).
	 * @param component4 the component4 to set
	 */
	public Field422 setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}

	/**
	 * Set the component5 ($label).
	 * @param component5 the component5 to set
	 */
	public Field422 setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}

	/**
	 * Set the component6 ($label).
	 * @param component6 the component6 to set
	 */
	public Field422 setComponent6(String component6) {
		setComponent(6, component6);
		return this;
	}

	/**
	 * Set the component7 ($label).
	 * @param component7 the component7 to set
	 */
	public Field422 setComponent7(String component7) {
		setComponent(7, component7);
		return this;
	}

	/**
	 * Set the component8 ($label).
	 * @param component8 the component8 to set
	 */
	public Field422 setComponent8(String component8) {
		setComponent(8, component8);
		return this;
	}

	/**
	 * Set the component9 ($label).
	 * @param component9 the component9 to set
	 */
	public Field422 setComponent9(String component9) {
		setComponent(9, component9);
		return this;
	}

	/**
	 * Set the component10 ($label).
	 * @param component10 the component10 to set
	 */
	public Field422 setComponent10(String component10) {
		setComponent(10, component10);
		return this;
	}

	/**
	 * Set the component11 ($label).
	 * @param component11 the component11 to set
	 */
	public Field422 setComponent11(String component11) {
		setComponent(11, component11);
		return this;
	}

	/**
	 * Set the component12 ($label).
	 * @param component12 the component12 to set
	 */
	public Field422 setComponent12(String component12) {
		setComponent(12, component12);
		return this;
	}

	/**
	 * Set the component13 ($label).
	 * @param component13 the component13 to set
	 */
	public Field422 setComponent13(String component13) {
		setComponent(13, component13);
		return this;
	}

	/**
	 * Set the component14 ($label).
	 * @param component14 the component14 to set
	 */
	public Field422 setComponent14(String component14) {
		setComponent(14, component14);
		return this;
	}

	/**
	 * Set the component15 ($label).
	 * @param component15 the component15 to set
	 */
	public Field422 setComponent15(String component15) {
		setComponent(15, component15);
		return this;
	}

	/**
	 * Set the component16 ($label).
	 * @param component16 the component16 to set
	 */
	public Field422 setComponent16(String component16) {
		setComponent(16, component16);
		return this;
	}

	/**
	 * Set the component17 ($label).
	 * @param component17 the component17 to set
	 */
	public Field422 setComponent17(String component17) {
		setComponent(17, component17);
		return this;
	}

	/**
	 * Set the component18 ($label).
	 * @param component18 the component18 to set
	 */
	public Field422 setComponent18(String component18) {
		setComponent(18, component18);
		return this;
	}

	/**
	 * Set the component19 ($label).
	 * @param component19 the component19 to set
	 */
	public Field422 setComponent19(String component19) {
		setComponent(19, component19);
		return this;
	}

	/**
	 * Set the component20 ($label).
	 * @param component20 the component20 to set
	 */
	public Field422 setComponent20(String component20) {
		setComponent(20, component20);
		return this;
	}

	/**
	 * Set the component21 ($label).
	 * @param component21 the component21 to set
	 */
	public Field422 setComponent21(String component21) {
		setComponent(21, component21);
		return this;
	}

	/**
	 * Set the component22 ($label).
	 * @param component22 the component22 to set
	 */
	public Field422 setComponent22(String component22) {
		setComponent(22, component22);
		return this;
	}

	/**
	 * Set the component23 ($label).
	 * @param component23 the component23 to set
	 */
	public Field422 setComponent23(String component23) {
		setComponent(23, component23);
		return this;
	}

	/**
	 * Set the component24 ($label).
	 * @param component24 the component24 to set
	 */
	public Field422 setComponent24(String component24) {
		setComponent(24, component24);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field422.NAME
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
	public static Field422 get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field422(t) ;
	}
	
	/**
	 * Gets the first instance of Field422 in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field422 get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field422 in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field422> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field422 from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field422> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field422> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field422(f));
			}
			return result;
		}
		return java.util.Collections.emptyList();
	}

	/**
	 * This method deserializes the JSON data into a Field422 object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field422 fromJson(final String json) {
		Field422 field = new Field422();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		return field;
	}
	

}
