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
 * <strong>SWIFT MT Field 79Z</strong>
 * <p>
 * Model and parser for field 79Z of a SWIFT MT message.
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
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>50z[$50z]0-34</code></li>
 * 		<li>parser pattern: <code>S[$S]0-34</code></li>
 * 		<li>components pattern: <code>SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2019</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field79Z extends Field implements Serializable, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 79Z
	 */
    public static final String NAME = "79Z";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_79Z = "79Z";
	public static final String PARSER_PATTERN ="S[$S]0-34";
	public static final String COMPONENTS_PATTERN = "SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS";

	/**
	 * Component number for the Narrative subfield
	 */
	public static final Integer NARRATIVE = 1;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field79Z() {
		super(35);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field79Z(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field79Z(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "79Z")) {
			throw new IllegalArgumentException("cannot create field 79Z from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field79Z newInstance(Field79Z source) {
		Field79Z cp = new Field79Z();
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
		init(35);
		List<String> lines = SwiftParseUtils.getLines(value);
		SwiftParseUtils.setComponentsFromLines(this, 1, null, 0, lines);
	}
	/**
	 * Serializes the fields' components into the single string value (SWIFT format)
	 */
	@Override
	public String getValue() {
		final StringBuilder result = new StringBuilder();
		appendInLines(result, 1, 35);
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
		if (component < 1 || component > 35) {
			throw new IllegalArgumentException("invalid component number "+component+" for field 79Z");
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
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field79Z.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field79Z.PARSER_PATTERN
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
		return "50z[$50z]0-34";
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
        if (component == 2) {
            return true;
        }
        if (component == 3) {
            return true;
        }
        if (component == 4) {
            return true;
        }
        if (component == 5) {
            return true;
        }
        if (component == 6) {
            return true;
        }
        if (component == 7) {
            return true;
        }
        if (component == 8) {
            return true;
        }
        if (component == 9) {
            return true;
        }
        if (component == 10) {
            return true;
        }
        if (component == 11) {
            return true;
        }
        if (component == 12) {
            return true;
        }
        if (component == 13) {
            return true;
        }
        if (component == 14) {
            return true;
        }
        if (component == 15) {
            return true;
        }
        if (component == 16) {
            return true;
        }
        if (component == 17) {
            return true;
        }
        if (component == 18) {
            return true;
        }
        if (component == 19) {
            return true;
        }
        if (component == 20) {
            return true;
        }
        if (component == 21) {
            return true;
        }
        if (component == 22) {
            return true;
        }
        if (component == 23) {
            return true;
        }
        if (component == 24) {
            return true;
        }
        if (component == 25) {
            return true;
        }
        if (component == 26) {
            return true;
        }
        if (component == 27) {
            return true;
        }
        if (component == 28) {
            return true;
        }
        if (component == 29) {
            return true;
        }
        if (component == 30) {
            return true;
        }
        if (component == 31) {
            return true;
        }
        if (component == 32) {
            return true;
        }
        if (component == 33) {
            return true;
        }
        if (component == 34) {
            return true;
        }
        if (component == 35) {
            return true;
        }
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
		return 35;
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
		result.add("Narrative");
		result.add("Narrative 2");
		result.add("Narrative 3");
		result.add("Narrative 4");
		result.add("Narrative 5");
		result.add("Narrative 6");
		result.add("Narrative 7");
		result.add("Narrative 8");
		result.add("Narrative 9");
		result.add("Narrative 10");
		result.add("Narrative 11");
		result.add("Narrative 12");
		result.add("Narrative 13");
		result.add("Narrative 14");
		result.add("Narrative 15");
		result.add("Narrative 16");
		result.add("Narrative 17");
		result.add("Narrative 18");
		result.add("Narrative 19");
		result.add("Narrative 20");
		result.add("Narrative 21");
		result.add("Narrative 22");
		result.add("Narrative 23");
		result.add("Narrative 24");
		result.add("Narrative 25");
		result.add("Narrative 26");
		result.add("Narrative 27");
		result.add("Narrative 28");
		result.add("Narrative 29");
		result.add("Narrative 30");
		result.add("Narrative 31");
		result.add("Narrative 32");
		result.add("Narrative 33");
		result.add("Narrative 34");
		result.add("Narrative 35");
		return result;
	}

	/**
	 * Returns a mapping between component numbers and their label in camel case format.
	 * @since 7.10.3
	 */
	@Override
	protected Map<Integer, String> getComponentMap() {
		Map<Integer, String> result = new HashMap<>();
		result.put(1, "narrative");
		result.put(2, "narrative2");
		result.put(3, "narrative3");
		result.put(4, "narrative4");
		result.put(5, "narrative5");
		result.put(6, "narrative6");
		result.put(7, "narrative7");
		result.put(8, "narrative8");
		result.put(9, "narrative9");
		result.put(10, "narrative10");
		result.put(11, "narrative11");
		result.put(12, "narrative12");
		result.put(13, "narrative13");
		result.put(14, "narrative14");
		result.put(15, "narrative15");
		result.put(16, "narrative16");
		result.put(17, "narrative17");
		result.put(18, "narrative18");
		result.put(19, "narrative19");
		result.put(20, "narrative20");
		result.put(21, "narrative21");
		result.put(22, "narrative22");
		result.put(23, "narrative23");
		result.put(24, "narrative24");
		result.put(25, "narrative25");
		result.put(26, "narrative26");
		result.put(27, "narrative27");
		result.put(28, "narrative28");
		result.put(29, "narrative29");
		result.put(30, "narrative30");
		result.put(31, "narrative31");
		result.put(32, "narrative32");
		result.put(33, "narrative33");
		result.put(34, "narrative34");
		result.put(35, "narrative35");
		return result;
	}
	/**
	 * Gets the component1 (Narrative).
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
	 * Gets the Narrative (component1).
	 * @return the Narrative from component1
	 */
	public String getNarrativeLine1() {
		return getComponent(1);
	}

	/**
	 * Gets the Narrative (component2).
	 * @return the Narrative from component2
	 */
	public String getNarrativeLine2() {
		return getComponent(2);
	}

	/**
	 * Gets the Narrative (component3).
	 * @return the Narrative from component3
	 */
	public String getNarrativeLine3() {
		return getComponent(3);
	}

	/**
	 * Gets the Narrative (component4).
	 * @return the Narrative from component4
	 */
	public String getNarrativeLine4() {
		return getComponent(4);
	}

	/**
	 * Gets the Narrative (component5).
	 * @return the Narrative from component5
	 */
	public String getNarrativeLine5() {
		return getComponent(5);
	}

	/**
	 * Gets the Narrative (component6).
	 * @return the Narrative from component6
	 */
	public String getNarrativeLine6() {
		return getComponent(6);
	}

	/**
	 * Gets the Narrative (component7).
	 * @return the Narrative from component7
	 */
	public String getNarrativeLine7() {
		return getComponent(7);
	}

	/**
	 * Gets the Narrative (component8).
	 * @return the Narrative from component8
	 */
	public String getNarrativeLine8() {
		return getComponent(8);
	}

	/**
	 * Gets the Narrative (component9).
	 * @return the Narrative from component9
	 */
	public String getNarrativeLine9() {
		return getComponent(9);
	}

	/**
	 * Gets the Narrative (component10).
	 * @return the Narrative from component10
	 */
	public String getNarrativeLine10() {
		return getComponent(10);
	}

	/**
	 * Gets the Narrative (component11).
	 * @return the Narrative from component11
	 */
	public String getNarrativeLine11() {
		return getComponent(11);
	}

	/**
	 * Gets the Narrative (component12).
	 * @return the Narrative from component12
	 */
	public String getNarrativeLine12() {
		return getComponent(12);
	}

	/**
	 * Gets the Narrative (component13).
	 * @return the Narrative from component13
	 */
	public String getNarrativeLine13() {
		return getComponent(13);
	}

	/**
	 * Gets the Narrative (component14).
	 * @return the Narrative from component14
	 */
	public String getNarrativeLine14() {
		return getComponent(14);
	}

	/**
	 * Gets the Narrative (component15).
	 * @return the Narrative from component15
	 */
	public String getNarrativeLine15() {
		return getComponent(15);
	}

	/**
	 * Gets the Narrative (component16).
	 * @return the Narrative from component16
	 */
	public String getNarrativeLine16() {
		return getComponent(16);
	}

	/**
	 * Gets the Narrative (component17).
	 * @return the Narrative from component17
	 */
	public String getNarrativeLine17() {
		return getComponent(17);
	}

	/**
	 * Gets the Narrative (component18).
	 * @return the Narrative from component18
	 */
	public String getNarrativeLine18() {
		return getComponent(18);
	}

	/**
	 * Gets the Narrative (component19).
	 * @return the Narrative from component19
	 */
	public String getNarrativeLine19() {
		return getComponent(19);
	}

	/**
	 * Gets the Narrative (component20).
	 * @return the Narrative from component20
	 */
	public String getNarrativeLine20() {
		return getComponent(20);
	}

	/**
	 * Gets the Narrative (component21).
	 * @return the Narrative from component21
	 */
	public String getNarrativeLine21() {
		return getComponent(21);
	}

	/**
	 * Gets the Narrative (component22).
	 * @return the Narrative from component22
	 */
	public String getNarrativeLine22() {
		return getComponent(22);
	}

	/**
	 * Gets the Narrative (component23).
	 * @return the Narrative from component23
	 */
	public String getNarrativeLine23() {
		return getComponent(23);
	}

	/**
	 * Gets the Narrative (component24).
	 * @return the Narrative from component24
	 */
	public String getNarrativeLine24() {
		return getComponent(24);
	}

	/**
	 * Gets the Narrative (component25).
	 * @return the Narrative from component25
	 */
	public String getNarrativeLine25() {
		return getComponent(25);
	}

	/**
	 * Gets the Narrative (component26).
	 * @return the Narrative from component26
	 */
	public String getNarrativeLine26() {
		return getComponent(26);
	}

	/**
	 * Gets the Narrative (component27).
	 * @return the Narrative from component27
	 */
	public String getNarrativeLine27() {
		return getComponent(27);
	}

	/**
	 * Gets the Narrative (component28).
	 * @return the Narrative from component28
	 */
	public String getNarrativeLine28() {
		return getComponent(28);
	}

	/**
	 * Gets the Narrative (component29).
	 * @return the Narrative from component29
	 */
	public String getNarrativeLine29() {
		return getComponent(29);
	}

	/**
	 * Gets the Narrative (component30).
	 * @return the Narrative from component30
	 */
	public String getNarrativeLine30() {
		return getComponent(30);
	}

	/**
	 * Gets the Narrative (component31).
	 * @return the Narrative from component31
	 */
	public String getNarrativeLine31() {
		return getComponent(31);
	}

	/**
	 * Gets the Narrative (component32).
	 * @return the Narrative from component32
	 */
	public String getNarrativeLine32() {
		return getComponent(32);
	}

	/**
	 * Gets the Narrative (component33).
	 * @return the Narrative from component33
	 */
	public String getNarrativeLine33() {
		return getComponent(33);
	}

	/**
	 * Gets the Narrative (component34).
	 * @return the Narrative from component34
	 */
	public String getNarrativeLine34() {
		return getComponent(34);
	}

	/**
	 * Gets the Narrative (component35).
	 * @return the Narrative from component35
	 */
	public String getNarrativeLine35() {
		return getComponent(35);
	}

	/**
	 * Gets the Narrative as a concatenation of component1 to component35.
	 * @return the Narrative from components
	 */
	public String getNarrative() {
		StringBuilder result = new StringBuilder();
		for (int i = 1 ; i < 36 ; i++) {
			if (StringUtils.isNotBlank(getComponent(i))) {
				if (result.length() > 0) {
					result.append(com.prowidesoftware.swift.io.writer.FINWriterVisitor.SWIFT_EOL);
				}
				result.append(StringUtils.trimToEmpty(getComponent(i)));
			}
		}
		return result.toString();
	}
	/**
	 * Gets the component2 (Narrative).
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
	 * Gets the component3 (Narrative).
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
	 * Gets the component4 (Narrative).
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
	 * Gets the component5 (Narrative).
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
	 * Gets the component6 (Narrative).
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
	 * Gets the component7 (Narrative).
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
	 * Gets the component8 (Narrative).
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
	 * Gets the component9 (Narrative).
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
	 * Gets the component10 (Narrative).
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
	 * Gets the component11 (Narrative).
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
	 * Gets the component12 (Narrative).
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
	 * Gets the component13 (Narrative).
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
	 * Gets the component14 (Narrative).
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
	 * Gets the component15 (Narrative).
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
	 * Gets the component16 (Narrative).
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
	 * Gets the component17 (Narrative).
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
	 * Gets the component18 (Narrative).
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
	 * Gets the component19 (Narrative).
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
	 * Gets the component20 (Narrative).
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
	 * Gets the component21 (Narrative).
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
	 * Gets the component22 (Narrative).
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
	 * Gets the component23 (Narrative).
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
	 * Gets the component24 (Narrative).
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
	 * Gets the component25 (Narrative).
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
	 * Gets the component26 (Narrative).
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
	 * Gets the component27 (Narrative).
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
	 * Gets the component28 (Narrative).
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
	 * Gets the component29 (Narrative).
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
	 * Gets the component30 (Narrative).
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
	 * Gets the component31 (Narrative).
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
	 * Gets the component32 (Narrative).
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
	 * Gets the component33 (Narrative).
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
	 * Gets the component34 (Narrative).
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
	 * Gets the component35 (Narrative).
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
	 * Set the component1 (Narrative).
	 * @param component1 the component1 to set
	 */
	public Field79Z setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}

	/**
	 * Set the Narrative (component1).
	 * @param component1 the Narrative to set
	 */
	public Field79Z setNarrativeLine1(String component1) {
		setComponent(1, component1);
		return this;
	}

	/**
	 * Set the Narrative (component2).
	 * @param component2 the Narrative to set
	 */
	public Field79Z setNarrativeLine2(String component2) {
		setComponent(2, component2);
		return this;
	}

	/**
	 * Set the Narrative (component3).
	 * @param component3 the Narrative to set
	 */
	public Field79Z setNarrativeLine3(String component3) {
		setComponent(3, component3);
		return this;
	}

	/**
	 * Set the Narrative (component4).
	 * @param component4 the Narrative to set
	 */
	public Field79Z setNarrativeLine4(String component4) {
		setComponent(4, component4);
		return this;
	}

	/**
	 * Set the Narrative (component5).
	 * @param component5 the Narrative to set
	 */
	public Field79Z setNarrativeLine5(String component5) {
		setComponent(5, component5);
		return this;
	}

	/**
	 * Set the Narrative (component6).
	 * @param component6 the Narrative to set
	 */
	public Field79Z setNarrativeLine6(String component6) {
		setComponent(6, component6);
		return this;
	}

	/**
	 * Set the Narrative (component7).
	 * @param component7 the Narrative to set
	 */
	public Field79Z setNarrativeLine7(String component7) {
		setComponent(7, component7);
		return this;
	}

	/**
	 * Set the Narrative (component8).
	 * @param component8 the Narrative to set
	 */
	public Field79Z setNarrativeLine8(String component8) {
		setComponent(8, component8);
		return this;
	}

	/**
	 * Set the Narrative (component9).
	 * @param component9 the Narrative to set
	 */
	public Field79Z setNarrativeLine9(String component9) {
		setComponent(9, component9);
		return this;
	}

	/**
	 * Set the Narrative (component10).
	 * @param component10 the Narrative to set
	 */
	public Field79Z setNarrativeLine10(String component10) {
		setComponent(10, component10);
		return this;
	}

	/**
	 * Set the Narrative (component11).
	 * @param component11 the Narrative to set
	 */
	public Field79Z setNarrativeLine11(String component11) {
		setComponent(11, component11);
		return this;
	}

	/**
	 * Set the Narrative (component12).
	 * @param component12 the Narrative to set
	 */
	public Field79Z setNarrativeLine12(String component12) {
		setComponent(12, component12);
		return this;
	}

	/**
	 * Set the Narrative (component13).
	 * @param component13 the Narrative to set
	 */
	public Field79Z setNarrativeLine13(String component13) {
		setComponent(13, component13);
		return this;
	}

	/**
	 * Set the Narrative (component14).
	 * @param component14 the Narrative to set
	 */
	public Field79Z setNarrativeLine14(String component14) {
		setComponent(14, component14);
		return this;
	}

	/**
	 * Set the Narrative (component15).
	 * @param component15 the Narrative to set
	 */
	public Field79Z setNarrativeLine15(String component15) {
		setComponent(15, component15);
		return this;
	}

	/**
	 * Set the Narrative (component16).
	 * @param component16 the Narrative to set
	 */
	public Field79Z setNarrativeLine16(String component16) {
		setComponent(16, component16);
		return this;
	}

	/**
	 * Set the Narrative (component17).
	 * @param component17 the Narrative to set
	 */
	public Field79Z setNarrativeLine17(String component17) {
		setComponent(17, component17);
		return this;
	}

	/**
	 * Set the Narrative (component18).
	 * @param component18 the Narrative to set
	 */
	public Field79Z setNarrativeLine18(String component18) {
		setComponent(18, component18);
		return this;
	}

	/**
	 * Set the Narrative (component19).
	 * @param component19 the Narrative to set
	 */
	public Field79Z setNarrativeLine19(String component19) {
		setComponent(19, component19);
		return this;
	}

	/**
	 * Set the Narrative (component20).
	 * @param component20 the Narrative to set
	 */
	public Field79Z setNarrativeLine20(String component20) {
		setComponent(20, component20);
		return this;
	}

	/**
	 * Set the Narrative (component21).
	 * @param component21 the Narrative to set
	 */
	public Field79Z setNarrativeLine21(String component21) {
		setComponent(21, component21);
		return this;
	}

	/**
	 * Set the Narrative (component22).
	 * @param component22 the Narrative to set
	 */
	public Field79Z setNarrativeLine22(String component22) {
		setComponent(22, component22);
		return this;
	}

	/**
	 * Set the Narrative (component23).
	 * @param component23 the Narrative to set
	 */
	public Field79Z setNarrativeLine23(String component23) {
		setComponent(23, component23);
		return this;
	}

	/**
	 * Set the Narrative (component24).
	 * @param component24 the Narrative to set
	 */
	public Field79Z setNarrativeLine24(String component24) {
		setComponent(24, component24);
		return this;
	}

	/**
	 * Set the Narrative (component25).
	 * @param component25 the Narrative to set
	 */
	public Field79Z setNarrativeLine25(String component25) {
		setComponent(25, component25);
		return this;
	}

	/**
	 * Set the Narrative (component26).
	 * @param component26 the Narrative to set
	 */
	public Field79Z setNarrativeLine26(String component26) {
		setComponent(26, component26);
		return this;
	}

	/**
	 * Set the Narrative (component27).
	 * @param component27 the Narrative to set
	 */
	public Field79Z setNarrativeLine27(String component27) {
		setComponent(27, component27);
		return this;
	}

	/**
	 * Set the Narrative (component28).
	 * @param component28 the Narrative to set
	 */
	public Field79Z setNarrativeLine28(String component28) {
		setComponent(28, component28);
		return this;
	}

	/**
	 * Set the Narrative (component29).
	 * @param component29 the Narrative to set
	 */
	public Field79Z setNarrativeLine29(String component29) {
		setComponent(29, component29);
		return this;
	}

	/**
	 * Set the Narrative (component30).
	 * @param component30 the Narrative to set
	 */
	public Field79Z setNarrativeLine30(String component30) {
		setComponent(30, component30);
		return this;
	}

	/**
	 * Set the Narrative (component31).
	 * @param component31 the Narrative to set
	 */
	public Field79Z setNarrativeLine31(String component31) {
		setComponent(31, component31);
		return this;
	}

	/**
	 * Set the Narrative (component32).
	 * @param component32 the Narrative to set
	 */
	public Field79Z setNarrativeLine32(String component32) {
		setComponent(32, component32);
		return this;
	}

	/**
	 * Set the Narrative (component33).
	 * @param component33 the Narrative to set
	 */
	public Field79Z setNarrativeLine33(String component33) {
		setComponent(33, component33);
		return this;
	}

	/**
	 * Set the Narrative (component34).
	 * @param component34 the Narrative to set
	 */
	public Field79Z setNarrativeLine34(String component34) {
		setComponent(34, component34);
		return this;
	}

	/**
	 * Set the Narrative (component35).
	 * @param component35 the Narrative to set
	 */
	public Field79Z setNarrativeLine35(String component35) {
		setComponent(35, component35);
		return this;
	}

	/**
	 * Set the Narrative splitting the parameter lines into components 1 to 35.
	 * @param value the Narrative to set, may contain line ends and each line will be set to its correspondent component attribute
	 */
	public Field79Z setNarrative(String value) {
		List<String> lines = SwiftParseUtils.getLines(value);
		SwiftParseUtils.setComponentsFromLines(this, 1, 35, 0, lines);
		return this;
	}

	/**
	 * Set the component2 (Narrative).
	 * @param component2 the component2 to set
	 */
	public Field79Z setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}

	/**
	 * Set the component3 (Narrative).
	 * @param component3 the component3 to set
	 */
	public Field79Z setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}

	/**
	 * Set the component4 (Narrative).
	 * @param component4 the component4 to set
	 */
	public Field79Z setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}

	/**
	 * Set the component5 (Narrative).
	 * @param component5 the component5 to set
	 */
	public Field79Z setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}

	/**
	 * Set the component6 (Narrative).
	 * @param component6 the component6 to set
	 */
	public Field79Z setComponent6(String component6) {
		setComponent(6, component6);
		return this;
	}

	/**
	 * Set the component7 (Narrative).
	 * @param component7 the component7 to set
	 */
	public Field79Z setComponent7(String component7) {
		setComponent(7, component7);
		return this;
	}

	/**
	 * Set the component8 (Narrative).
	 * @param component8 the component8 to set
	 */
	public Field79Z setComponent8(String component8) {
		setComponent(8, component8);
		return this;
	}

	/**
	 * Set the component9 (Narrative).
	 * @param component9 the component9 to set
	 */
	public Field79Z setComponent9(String component9) {
		setComponent(9, component9);
		return this;
	}

	/**
	 * Set the component10 (Narrative).
	 * @param component10 the component10 to set
	 */
	public Field79Z setComponent10(String component10) {
		setComponent(10, component10);
		return this;
	}

	/**
	 * Set the component11 (Narrative).
	 * @param component11 the component11 to set
	 */
	public Field79Z setComponent11(String component11) {
		setComponent(11, component11);
		return this;
	}

	/**
	 * Set the component12 (Narrative).
	 * @param component12 the component12 to set
	 */
	public Field79Z setComponent12(String component12) {
		setComponent(12, component12);
		return this;
	}

	/**
	 * Set the component13 (Narrative).
	 * @param component13 the component13 to set
	 */
	public Field79Z setComponent13(String component13) {
		setComponent(13, component13);
		return this;
	}

	/**
	 * Set the component14 (Narrative).
	 * @param component14 the component14 to set
	 */
	public Field79Z setComponent14(String component14) {
		setComponent(14, component14);
		return this;
	}

	/**
	 * Set the component15 (Narrative).
	 * @param component15 the component15 to set
	 */
	public Field79Z setComponent15(String component15) {
		setComponent(15, component15);
		return this;
	}

	/**
	 * Set the component16 (Narrative).
	 * @param component16 the component16 to set
	 */
	public Field79Z setComponent16(String component16) {
		setComponent(16, component16);
		return this;
	}

	/**
	 * Set the component17 (Narrative).
	 * @param component17 the component17 to set
	 */
	public Field79Z setComponent17(String component17) {
		setComponent(17, component17);
		return this;
	}

	/**
	 * Set the component18 (Narrative).
	 * @param component18 the component18 to set
	 */
	public Field79Z setComponent18(String component18) {
		setComponent(18, component18);
		return this;
	}

	/**
	 * Set the component19 (Narrative).
	 * @param component19 the component19 to set
	 */
	public Field79Z setComponent19(String component19) {
		setComponent(19, component19);
		return this;
	}

	/**
	 * Set the component20 (Narrative).
	 * @param component20 the component20 to set
	 */
	public Field79Z setComponent20(String component20) {
		setComponent(20, component20);
		return this;
	}

	/**
	 * Set the component21 (Narrative).
	 * @param component21 the component21 to set
	 */
	public Field79Z setComponent21(String component21) {
		setComponent(21, component21);
		return this;
	}

	/**
	 * Set the component22 (Narrative).
	 * @param component22 the component22 to set
	 */
	public Field79Z setComponent22(String component22) {
		setComponent(22, component22);
		return this;
	}

	/**
	 * Set the component23 (Narrative).
	 * @param component23 the component23 to set
	 */
	public Field79Z setComponent23(String component23) {
		setComponent(23, component23);
		return this;
	}

	/**
	 * Set the component24 (Narrative).
	 * @param component24 the component24 to set
	 */
	public Field79Z setComponent24(String component24) {
		setComponent(24, component24);
		return this;
	}

	/**
	 * Set the component25 (Narrative).
	 * @param component25 the component25 to set
	 */
	public Field79Z setComponent25(String component25) {
		setComponent(25, component25);
		return this;
	}

	/**
	 * Set the component26 (Narrative).
	 * @param component26 the component26 to set
	 */
	public Field79Z setComponent26(String component26) {
		setComponent(26, component26);
		return this;
	}

	/**
	 * Set the component27 (Narrative).
	 * @param component27 the component27 to set
	 */
	public Field79Z setComponent27(String component27) {
		setComponent(27, component27);
		return this;
	}

	/**
	 * Set the component28 (Narrative).
	 * @param component28 the component28 to set
	 */
	public Field79Z setComponent28(String component28) {
		setComponent(28, component28);
		return this;
	}

	/**
	 * Set the component29 (Narrative).
	 * @param component29 the component29 to set
	 */
	public Field79Z setComponent29(String component29) {
		setComponent(29, component29);
		return this;
	}

	/**
	 * Set the component30 (Narrative).
	 * @param component30 the component30 to set
	 */
	public Field79Z setComponent30(String component30) {
		setComponent(30, component30);
		return this;
	}

	/**
	 * Set the component31 (Narrative).
	 * @param component31 the component31 to set
	 */
	public Field79Z setComponent31(String component31) {
		setComponent(31, component31);
		return this;
	}

	/**
	 * Set the component32 (Narrative).
	 * @param component32 the component32 to set
	 */
	public Field79Z setComponent32(String component32) {
		setComponent(32, component32);
		return this;
	}

	/**
	 * Set the component33 (Narrative).
	 * @param component33 the component33 to set
	 */
	public Field79Z setComponent33(String component33) {
		setComponent(33, component33);
		return this;
	}

	/**
	 * Set the component34 (Narrative).
	 * @param component34 the component34 to set
	 */
	public Field79Z setComponent34(String component34) {
		setComponent(34, component34);
		return this;
	}

	/**
	 * Set the component35 (Narrative).
	 * @param component35 the component35 to set
	 */
	public Field79Z setComponent35(String component35) {
		setComponent(35, component35);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field79Z.NAME
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
	public static Field79Z get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field79Z(t) ;
	}
	
	/**
	 * Gets the first instance of Field79Z in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field79Z get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field79Z in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field79Z> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field79Z from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field79Z> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field79Z> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field79Z(f));
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
		Field79Z cp = newInstance(this);
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
		Field79Z cp = newInstance(this);
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
		Field79Z cp = newInstance(this);
		return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
	}

	/**
	 * This method deserializes the JSON data into a Field79Z object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field79Z fromJson(final String json) {
		Field79Z field = new Field79Z();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("narrative") != null) {
			field.setComponent1(jsonObject.get("narrative").getAsString());
		}
		if (jsonObject.get("narrative2") != null) {
			field.setComponent2(jsonObject.get("narrative2").getAsString());
		}
		if (jsonObject.get("narrative3") != null) {
			field.setComponent3(jsonObject.get("narrative3").getAsString());
		}
		if (jsonObject.get("narrative4") != null) {
			field.setComponent4(jsonObject.get("narrative4").getAsString());
		}
		if (jsonObject.get("narrative5") != null) {
			field.setComponent5(jsonObject.get("narrative5").getAsString());
		}
		if (jsonObject.get("narrative6") != null) {
			field.setComponent6(jsonObject.get("narrative6").getAsString());
		}
		if (jsonObject.get("narrative7") != null) {
			field.setComponent7(jsonObject.get("narrative7").getAsString());
		}
		if (jsonObject.get("narrative8") != null) {
			field.setComponent8(jsonObject.get("narrative8").getAsString());
		}
		if (jsonObject.get("narrative9") != null) {
			field.setComponent9(jsonObject.get("narrative9").getAsString());
		}
		if (jsonObject.get("narrative10") != null) {
			field.setComponent10(jsonObject.get("narrative10").getAsString());
		}
		if (jsonObject.get("narrative11") != null) {
			field.setComponent11(jsonObject.get("narrative11").getAsString());
		}
		if (jsonObject.get("narrative12") != null) {
			field.setComponent12(jsonObject.get("narrative12").getAsString());
		}
		if (jsonObject.get("narrative13") != null) {
			field.setComponent13(jsonObject.get("narrative13").getAsString());
		}
		if (jsonObject.get("narrative14") != null) {
			field.setComponent14(jsonObject.get("narrative14").getAsString());
		}
		if (jsonObject.get("narrative15") != null) {
			field.setComponent15(jsonObject.get("narrative15").getAsString());
		}
		if (jsonObject.get("narrative16") != null) {
			field.setComponent16(jsonObject.get("narrative16").getAsString());
		}
		if (jsonObject.get("narrative17") != null) {
			field.setComponent17(jsonObject.get("narrative17").getAsString());
		}
		if (jsonObject.get("narrative18") != null) {
			field.setComponent18(jsonObject.get("narrative18").getAsString());
		}
		if (jsonObject.get("narrative19") != null) {
			field.setComponent19(jsonObject.get("narrative19").getAsString());
		}
		if (jsonObject.get("narrative20") != null) {
			field.setComponent20(jsonObject.get("narrative20").getAsString());
		}
		if (jsonObject.get("narrative21") != null) {
			field.setComponent21(jsonObject.get("narrative21").getAsString());
		}
		if (jsonObject.get("narrative22") != null) {
			field.setComponent22(jsonObject.get("narrative22").getAsString());
		}
		if (jsonObject.get("narrative23") != null) {
			field.setComponent23(jsonObject.get("narrative23").getAsString());
		}
		if (jsonObject.get("narrative24") != null) {
			field.setComponent24(jsonObject.get("narrative24").getAsString());
		}
		if (jsonObject.get("narrative25") != null) {
			field.setComponent25(jsonObject.get("narrative25").getAsString());
		}
		if (jsonObject.get("narrative26") != null) {
			field.setComponent26(jsonObject.get("narrative26").getAsString());
		}
		if (jsonObject.get("narrative27") != null) {
			field.setComponent27(jsonObject.get("narrative27").getAsString());
		}
		if (jsonObject.get("narrative28") != null) {
			field.setComponent28(jsonObject.get("narrative28").getAsString());
		}
		if (jsonObject.get("narrative29") != null) {
			field.setComponent29(jsonObject.get("narrative29").getAsString());
		}
		if (jsonObject.get("narrative30") != null) {
			field.setComponent30(jsonObject.get("narrative30").getAsString());
		}
		if (jsonObject.get("narrative31") != null) {
			field.setComponent31(jsonObject.get("narrative31").getAsString());
		}
		if (jsonObject.get("narrative32") != null) {
			field.setComponent32(jsonObject.get("narrative32").getAsString());
		}
		if (jsonObject.get("narrative33") != null) {
			field.setComponent33(jsonObject.get("narrative33").getAsString());
		}
		if (jsonObject.get("narrative34") != null) {
			field.setComponent34(jsonObject.get("narrative34").getAsString());
		}
		if (jsonObject.get("narrative35") != null) {
			field.setComponent35(jsonObject.get("narrative35").getAsString());
		}
		return field;
	}
	

}
