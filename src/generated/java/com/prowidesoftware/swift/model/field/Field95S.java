/*
 * Copyright 2006-2024 Prowide
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


import com.prowidesoftware.swift.model.field.GenericField;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 95S.
 * <p>
 * Model and parser for field 95S of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Qualifier: <code>String</code></li>
 * 		<li>Component 2: DataSourceScheme: <code>String</code></li>
 * 		<li>Component 3: TypeOfID: <code>String</code></li>
 * 		<li>Component 4: CountryCode: <code>String</code></li>
 * 		<li>Component 5: AlternateID: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>:4!c/[8c]/4!c/&lt;CC&gt;/30x(***)</code></li>
 * 		<li>parser pattern: <code>:S/[S]/S/S/S</code></li>
 * 		<li>components pattern: <code>SSSKS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field95S extends OptionSPartyField implements Serializable, GenericField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 95S.
	 */
    public static final String NAME = "95S";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_95S = "95S";

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field95S() {
        super();
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field95S(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field95S(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "95S")) {
            throw new IllegalArgumentException("cannot create field 95S from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field95S newInstance(Field95S source) {
        Field95S cp = new Field95S();
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
     * Create a Tag with this field name and an empty string as value.
     * Shorthand for <code>new Tag(NAME, "")</code>
     * @see #NAME
     * @since 7.5
     */
    public static Tag emptyTag() {
        return new Tag(NAME, "");
    }

    /**
     * Returns the field validator pattern.
     */
    @Override
    public final String validatorPattern() {
        return ":4!c/[8c]/4!c/<CC>/30x(***)";
    }

    /**
     * Set the component 1 (Qualifier).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field95S setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Qualifier (component 1).
     *
     * @param component1 the Qualifier to set
     * @return the field object to enable build pattern
     */
    public Field95S setQualifier(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Data Source Scheme).
     *
     * @param component2 the Data Source Scheme to set
     * @return the field object to enable build pattern
     */
    public Field95S setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Data Source Scheme (component 2).
     *
     * @param component2 the Data Source Scheme to set
     * @return the field object to enable build pattern
     */
    public Field95S setDataSourceScheme(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Type Of ID).
     *
     * @param component3 the Type Of ID to set
     * @return the field object to enable build pattern
     */
    public Field95S setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Type Of ID (component 3).
     *
     * @param component3 the Type Of ID to set
     * @return the field object to enable build pattern
     */
    public Field95S setTypeOfID(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Country Code).
     *
     * @param component4 the Country Code to set
     * @return the field object to enable build pattern
     */
    public Field95S setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the Country Code (component 4).
     *
     * @param component4 the Country Code to set
     * @return the field object to enable build pattern
     */
    public Field95S setCountryCode(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Alternate ID).
     *
     * @param component5 the Alternate ID to set
     * @return the field object to enable build pattern
     */
    public Field95S setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the Alternate ID (component 5).
     *
     * @param component5 the Alternate ID to set
     * @return the field object to enable build pattern
     */
    public Field95S setAlternateID(String component5) {
        return setComponent5(component5);
    }



    /**
     * Returns the issuer code (or Data Source Scheme or DSS).
     * The DSS is only present in some generic fields, when present, is equals to component two.
     *
     * @return DSS component value or null if the DSS is not set or not available for this field.
     */
    @Override
    public String getDSS() {
        return getComponent2();
    }

    /**
     * Checks if the issuer code (or Data Source Scheme or DSS) is present.
     *
     * @see #getDSS()
     * @return true if DSS is present, false otherwise.
     */
    @Override
    public boolean isDSSPresent() {
        return getComponent2() != null;
    }

    /**
     * Component number for the conditional qualifier subfield.
     */
    public static final Integer CONDITIONAL_QUALIFIER = 3;

    /**
     * Gets the component with the conditional (secondary) qualifier.
     *
     * @return for generic fields returns the value of the conditional qualifier or null if not set or not applicable for this field.
     */
    @Override
    public String getConditionalQualifier() {
        return getComponent(CONDITIONAL_QUALIFIER);
    }

    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field95S.NAME
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
    public static Field95S get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field95S(t);
    }

    /**
     * Gets the first instance of Field95S in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field95S get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field95S in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field95S> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field95S from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field95S> getAll(final SwiftTagListBlock block) {
        final List<Field95S> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field95S(f));
            }
        }
        return result;
    }

    /**
     * This method deserializes the JSON data into a Field95S object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field95S fromJson(final String json) {

        final Field95S field = new Field95S();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Qualifier

        if (jsonObject.get("qualifier") != null) {
            field.setComponent1(jsonObject.get("qualifier").getAsString());
        }

        // **** COMPONENT 2 - Data Source Scheme

        if (jsonObject.get("dataSourceScheme") != null) {
            field.setComponent2(jsonObject.get("dataSourceScheme").getAsString());
        }

        // **** COMPONENT 3 - Type Of ID

        if (jsonObject.get("typeOfID") != null) {
            field.setComponent3(jsonObject.get("typeOfID").getAsString());
        }

        // **** COMPONENT 4 - Country Code

        if (jsonObject.get("countryCode") != null) {
            field.setComponent4(jsonObject.get("countryCode").getAsString());
        }

        // **** COMPONENT 5 - Alternate ID

        if (jsonObject.get("alternateID") != null) {
            field.setComponent5(jsonObject.get("alternateID").getAsString());
        }

        return field;
    }


}
