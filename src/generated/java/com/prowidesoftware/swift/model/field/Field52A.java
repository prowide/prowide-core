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

import com.prowidesoftware.swift.model.field.MultiLineField;
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
 * SWIFT MT Field 52A.
 * <p>
 * Model and parser for field 52A of a SWIFT MT message.
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
 * 		<li>validation pattern: <code>[[/&lt;DC&gt;][/34x]$]&lt;BIC&gt;</code></li>
 * 		<li>parser pattern: <code>[[/c][/S]$]S</code></li>
 * 		<li>components pattern: <code>SSB</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field52A extends OptionAPartyField implements Serializable, BICContainer, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 52A.
	 */
    public static final String NAME = "52A";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_52A = "52A";

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field52A() {
        super();
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field52A(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field52A(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "52A")) {
            throw new IllegalArgumentException("cannot create field 52A from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field52A newInstance(Field52A source) {
        Field52A cp = new Field52A();
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
        return "[[/<DC>][/34x]$]<BIC>";
    }

    /**
     * Set the component 1 (D/C Mark).
     *
     * @param component1 the D/C Mark to set
     * @return the field object to enable build pattern
     */
    public Field52A setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the D/C Mark (component 1).
     *
     * @param component1 the D/C Mark to set
     * @return the field object to enable build pattern
     */
    public Field52A setDCMark(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Account).
     *
     * @param component2 the Account to set
     * @return the field object to enable build pattern
     */
    public Field52A setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the Account (component 2).
     *
     * @param component2 the Account to set
     * @return the field object to enable build pattern
     */
    public Field52A setAccount(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Identifier Code).
     *
     * @param component3 the Identifier Code to set
     * @return the field object to enable build pattern
     */
    public Field52A setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a BIC object.
     *
     * @param component3 the BIC with the Identifier Code content to set
     * @return the field object to enable build pattern
     */
    public Field52A setComponent3(com.prowidesoftware.swift.model.BIC component3) {
        setComponent(3, SwiftFormatUtils.getBIC(component3));
        return this;
    }

    /**
     * Set the Identifier Code (component 3).
     *
     * @param component3 the Identifier Code to set
     * @return the field object to enable build pattern
     */
    public Field52A setIdentifierCode(String component3) {
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
    public Field52A setIdentifierCode(com.prowidesoftware.swift.model.BIC component3) {
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
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public Field52A setBIC(String component3) {
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
    @ProwideDeprecated(phase2 = TargetYear.SRU2022)
    public Field52A setBIC(com.prowidesoftware.swift.model.BIC component3) {
        return setIdentifierCode(component3);
    }


    public List<BIC> bics() {
        return BICResolver.bics(this);
    }

    public List<String> bicStrings () {
        return BICResolver.bicStrings(this);
    }


    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field52A.NAME
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
    public static Field52A get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field52A(t);
    }

    /**
     * Gets the first instance of Field52A in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field52A get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field52A in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field52A> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field52A from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field52A> getAll(final SwiftTagListBlock block) {
        final List<Field52A> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            for (final Tag f : arr) {
                result.add(new Field52A(f));
            }
        }
        return result;
    }

    /**
     * Returns a specific line from the field's value.
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
     * Returns a specific line from the field's value.
     *
     * @see MultiLineField#getLine(int, int)
     * @param line a reference to a specific line in the field, first line being 1
     * @param offset an optional component number used as offset when counting lines
     * @return line content or null if not present or if line number is above the expected
     * @since 7.7
     */
    public String getLine(int line, int offset) {
        Field52A cp = newInstance(this);
        return getLine(cp, line, null, offset);
    }

    /**
     * Returns the field value split into lines.
     *
     * @see MultiLineField#getLines()
     * @return lines content or empty list if field's value is empty
     * @since 7.7
     */
    public List<String> getLines() {
        return SwiftParseUtils.getLines(getValue());
    }

    /**
     * Returns the field value starting at the offset component, split into lines.
     *
     * @see MultiLineField#getLines(int)
     * @param offset an optional component number used as offset when counting lines
     * @return found lines or empty list if lines are not present or the offset is invalid
     * @since 7.7
     */
    public List<String> getLines(int offset) {
        Field52A cp = newInstance(this);
        return SwiftParseUtils.getLines(getLine(cp, null, null, offset));
    }

    /**
     * Returns a specific subset of lines from the field's value, given a range.
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
     * Returns a specific subset of lines from the field's value, starting at the offset component.
     *
     * @see MultiLineField#getLinesBetween(int start, int end, int offset)
     * @param start a reference to a specific line in the field, first line being 1
     * @param end a reference to a specific line in the field, must be greater than start
     * @param offset an optional component number used as offset when counting lines
     * @return found lines or empty list if lines are not present or the offset is invalid
     * @since 7.7
     */
    public List<String> getLinesBetween(int start, int end, int offset) {
        Field52A cp = newInstance(this);
        return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
    }

    /**
     * This method deserializes the JSON data into a Field52A object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field52A fromJson(final String json) {

        final Field52A field = new Field52A();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - D/C Mark

        if (jsonObject.get("dCMark") != null) {
            field.setComponent1(jsonObject.get("dCMark").getAsString());
        }

        // **** COMPONENT 2 - Account

        if (jsonObject.get("account") != null) {
            field.setComponent2(jsonObject.get("account").getAsString());
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
