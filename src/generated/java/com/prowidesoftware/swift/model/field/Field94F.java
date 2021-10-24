/*
 * Copyright 2006-2021 Prowide
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

import com.prowidesoftware.swift.model.BIC;

import com.prowidesoftware.swift.model.field.GenericField;
import com.prowidesoftware.swift.model.field.BICContainer;
import com.prowidesoftware.swift.model.field.BICResolver;

import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 94F</strong>
 * <p>
 * Model and parser for field 94F of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>BIC</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>:4!c//4!c/&lt;BIC&gt;</code></li>
 * 		<li>parser pattern: <code>:S//S/S</code></li>
 * 		<li>components pattern: <code>SSB</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field94F extends Field implements Serializable, BICContainer, GenericField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 94F
	 */
    public static final String NAME = "94F";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_94F = "94F";
	public static final String PARSER_PATTERN = ":S//S/S";

    /**
     * Components pattern
     *
     * Contains a description of the type for every component. This is <em>DEPRECATED</em>,
     * use TYPES_PATTERN instead, because it distinguishes between N (number) and I (BigDecimal)
     * @see #TYPES_PATTERN
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "SSB";

    /**
     * Types pattern
     *
     * Contains a description of the type for every component, use instead of COMPONENTS_PATTERN.
     * @since 9.2.7
     */
	public static final String TYPES_PATTERN = "SSB";

	/**
	 * Component number for the Qualifier subfield
	 */
	public static final Integer QUALIFIER = 1;

	/**
	 * Component number for the Place Code subfield
	 */
	public static final Integer PLACE_CODE = 2;

	/**
	 * Alternative (<em>DEPRECATED</em>) constant name for field's Place Code Component number
	 * @see #PLACE_CODE
	 */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public static final Integer CODE = 2;

	/**
	 * Component number for the Identifier Code subfield
	 */
	public static final Integer IDENTIFIER_CODE = 3;

	/**
	 * Alternative (<em>DEPRECATED</em>) constant name for field's Identifier Code Component number
	 * @see #IDENTIFIER_CODE
	 */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public static final Integer BIC = 3;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field94F() {
        super(3);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field94F(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field94F(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "94F")) {
            throw new IllegalArgumentException("cannot create field 94F from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.<br>
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field94F newInstance(Field94F source) {
        Field94F cp = new Field94F();
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
        init(3);
        setComponent1(SwiftParseUtils.getTokenFirst(value, ":", "//"));
        String toparse = SwiftParseUtils.getTokenSecondLast(value, "//");
        setComponent2(SwiftParseUtils.getTokenFirst(toparse, "/"));
        setComponent3(SwiftParseUtils.getTokenSecondLast(toparse, "/"));
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        result.append(":");
        append(result, 1);
        result.append("//");
        append(result, 2);
        result.append("/");
        append(result, 3);
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
        if (component < 1 || component > 3) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 94F");
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
        return null;
    }

    /**
     * Returns the field components pattern
     *
     * This method is <em>DEPRECATED</em>, use <code>typesPattern()</code> instead.
     * @see #typesPattern()
     * @return the static value of Field94F.COMPONENTS_PATTERN
     */
    @Override
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public final String componentsPattern() {
        return COMPONENTS_PATTERN;
    }

    /**
     * Returns the field component types pattern
     *
     * This method returns a letter representing the type for each component in the Field. It supersedes
     * the Components Pattern because it distinguishes between N (Number) and I (BigDecimal).
     * @since 9.2.7
     * @see #TYPES_PATTERN
     * @return the static value of Field94F.TYPES_PATTERN
     */
    @Override
    public final String typesPattern() {
        return TYPES_PATTERN;
    }

    /**
     * Returns the field parser pattern
     * @return the static value of Field94F.PARSER_PATTERN
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
        return ":4!c//4!c/<BIC>";
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
        return true;
    }

    /**
     * Returns the defined amount of components.<br>
     * This is not the amount of components present in the field instance, but the total amount of components
     * that this field accepts as defined.
     * @since 7.7
     */
    @Override
    public int componentsSize() {
        return 3;
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
        result.add("Qualifier");
        result.add("Place Code");
        result.add("Identifier Code");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "qualifier");
        result.put(2, "placeCode");
        result.put(3, "identifierCode");
        return result;
    }


    /**
     * Gets the component 1 (Qualifier).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Qualifier (component 1).
     * @return the Qualifier from component 1
     */
    public String getQualifier() {
        return getComponent1();
    }

    /**
     * Gets the component 2 (Place Code).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Gets the Place Code (component 2).
     * @return the Place Code from component 2
     */
    public String getPlaceCode() {
        return getComponent2();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Place Code
     * @see #getPlaceCode()
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public String getCode() {
        return getPlaceCode();
    }

    /**
     * Gets the component 3 (Identifier Code).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Get the component 3 as BIC
     *
     * @return the component 3 converted to BIC or null if cannot be converted
     */
    public com.prowidesoftware.swift.model.BIC getComponent3AsBIC() {
        return SwiftFormatUtils.getBIC(getComponent(3));
    }

    /**
     * Gets the Identifier Code (component 3).
     * @return the Identifier Code from component 3
     */
    public String getIdentifierCode() {
        return getComponent3();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Identifier Code
     * @see #getIdentifierCode()
     * @since 9.2.7
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public String getBIC() {
        return getIdentifierCode();
    }

    /**
     * Get the Identifier Code (component 3) as BIC
     * @return the Identifier Code from component 3 converted to BIC or null if cannot be converted
     */
    public com.prowidesoftware.swift.model.BIC getIdentifierCodeAsBIC() {
        return getComponent3AsBIC();
    }

    /**
     * Alternative <em>DEPRECATED</em> method getter for field's Identifier Code as BIC
     * @see #getIdentifierCodeAsBIC()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public com.prowidesoftware.swift.model.BIC getBICAsBIC() {
        return getIdentifierCodeAsBIC();
    }

    /**
     * Set the component 1 (Qualifier).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field94F setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Qualifier (component 1).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field94F setQualifier(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Place Code).
     *
     * @param component2 the Place Code to set
     * @return the field object to enable build pattern
     */
    public Field94F setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Place Code (component 2).
     *
     * @param component2 the Place Code to set
     * @return the field object to enable build pattern
     */
    public Field94F setPlaceCode(String component2) {
        return setComponent2(component2);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Place Code
     *
     * @see #setPlaceCode(String)
     *
     * @param component2 the Place Code to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public Field94F setCode(String component2) {
        return setPlaceCode(component2);
    }

    /**
     * Set the component 3 (Identifier Code).
     *
     * @param component3 the Identifier Code to set
     * @return the field object to enable build pattern
     */
    public Field94F setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a BIC object.
     *
     * @param component3 the BIC with the Identifier Code content to set
     * @return the field object to enable build pattern
     */
    public Field94F setComponent3(com.prowidesoftware.swift.model.BIC component3) {
        setComponent(3, SwiftFormatUtils.getBIC(component3));
        return this;
    }

    /**
     * Set the Identifier Code (component 3).
     *
     * @param component3 the Identifier Code to set
     * @return the field object to enable build pattern
     */
    public Field94F setIdentifierCode(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Identifier Code (component 3) from a BIC object.
     *
     * @see #setComponent3(com.prowidesoftware.swift.model.BIC)
     *
     * @param component3 BIC with the Identifier Code content to set
     * @return the field object to enable build pattern
     */
    public Field94F setIdentifierCode(com.prowidesoftware.swift.model.BIC component3) {
        return setComponent3(component3);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Identifier Code
     *
     * @see #setIdentifierCode(String)
     *
     * @param component3 the Identifier Code to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public Field94F setBIC(String component3) {
        return setIdentifierCode(component3);
    }

    /**
     * Alternative <em>DEPRECATED</em> method setter for field's Identifier Code from a BIC object.
     *
     * @see #setComponent3(com.prowidesoftware.swift.model.BIC)
     *
     * @param component3 BIC with the Identifier Code content to set
     * @return the field object to enable build pattern
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public Field94F setBIC(com.prowidesoftware.swift.model.BIC component3) {
        return setIdentifierCode(component3);
    }


    public List<BIC> bics() {
        return BICResolver.bics(this);
    }

    public List<String> bicStrings () {
        return BICResolver.bicStrings(this);
    }


    /**
     * Returns the issuer code (or Data Source Scheme or DSS).
     * The DSS is only present in some generic fields, when present, is equals to component two.
     *
     * @return DSS component value or null if the DSS is not set or not available for this field.
     */
    public String getDSS() {
        return null;
    }

    /**
     * Checks if the issuer code (or Data Source Scheme or DSS) is present.
     *
     * @see #getDSS()
     * @return true if DSS is present, false otherwise.
     */
    public boolean isDSSPresent() {
        return false;
    }

    /**
     * Component number for the conditional qualifier subfield
     */
    public static final Integer CONDITIONAL_QUALIFIER = 2;

    /**
     * Gets the component with the conditional (secondary) qualifier.
     *
     * @return for generic fields returns the value of the conditional qualifier or null if not set or not applicable for this field.
     */
    public String getConditionalQualifier() {
        return getComponent(CONDITIONAL_QUALIFIER);
    }

    /**
     * Returns the field's name composed by the field number and the letter option (if any)
     * @return the static value of Field94F.NAME
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
    public static Field94F get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field94F(t) ;
    }

    /**
     * Gets the first instance of Field94F in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field94F get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return null;
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field94F in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field94F> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return java.util.Collections.emptyList();
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field94F from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field94F> getAll(final SwiftTagListBlock block) {
        final List<Field94F> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add( new Field94F(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field94F object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field94F fromJson(final String json) {

        Field94F field = new Field94F();

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(json);

        // **** COMPONENT 1 - Qualifier

        if (jsonObject.get("qualifier") != null) {
            field.setComponent1(jsonObject.get("qualifier").getAsString());
        }

        // **** COMPONENT 2 - Place Code

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("code") != null) {
            field.setComponent2(jsonObject.get("code").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("placeCode") != null) {
            field.setComponent2(jsonObject.get("placeCode").getAsString());
        }

        // **** COMPONENT 3 - Identifier Code

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("bIC") != null) {
            field.setComponent3(jsonObject.get("bIC").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("identifierCode") != null) {
            field.setComponent3(jsonObject.get("identifierCode").getAsString());
        }

        return field;
    }


}
