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

import java.math.BigDecimal;
import java.math.BigInteger;

import com.prowidesoftware.swift.model.field.MultiLineField;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 59F.
 * <p>
 * Model and parser for field 59F of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: Account: <code>String</code></li>
 * 		<li>Component 2: Number1: <code>Long</code></li>
 * 		<li>Component 3: NameAndAddress1: <code>String</code></li>
 * 		<li>Component 4: Number2: <code>Long</code></li>
 * 		<li>Component 5: NameAndAddress2: <code>String</code></li>
 * 		<li>Component 6: Number3: <code>Long</code></li>
 * 		<li>Component 7: NameAndAddress3: <code>String</code></li>
 * 		<li>Component 8: Number4: <code>Long</code></li>
 * 		<li>Component 9: NameAndAddress4: <code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>CUSTOM</code></li>
 * 		<li>parser pattern: <code>[/S$]N/S[$N/S$]0-3</code></li>
 * 		<li>components pattern: <code>SNSNSNSNS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field59F extends Field implements Serializable, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 59F.
	 */
    public static final String NAME = "59F";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_59F = "59F";

	/**
	 * Component number for the Account subfield.
	 */
	public static final Integer ACCOUNT = 1;

	/**
	 * Component number for the Number 1 subfield.
	 */
	public static final Integer NUMBER_1 = 2;

	/**
	 * Component number for the Name And Address 1 subfield.
	 */
	public static final Integer NAME_AND_ADDRESS_1 = 3;

	/**
	 * Component number for the Number 2 subfield.
	 */
	public static final Integer NUMBER_2 = 4;

	/**
	 * Component number for the Name And Address 2 subfield.
	 */
	public static final Integer NAME_AND_ADDRESS_2 = 5;

	/**
	 * Component number for the Number 3 subfield.
	 */
	public static final Integer NUMBER_3 = 6;

	/**
	 * Component number for the Name And Address 3 subfield.
	 */
	public static final Integer NAME_AND_ADDRESS_3 = 7;

	/**
	 * Component number for the Number 4 subfield.
	 */
	public static final Integer NUMBER_4 = 8;

	/**
	 * Component number for the Name And Address 4 subfield.
	 */
	public static final Integer NAME_AND_ADDRESS_4 = 9;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field59F() {
        super(9);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field59F(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field59F(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "59F")) {
            throw new IllegalArgumentException("cannot create field 59F from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field59F newInstance(Field59F source) {
        Field59F cp = new Field59F();
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
        init(9);
        List<String> lines = SwiftParseUtils.getLines(value);
        int component = 2;
        for (int i=0; i<lines.size(); i++) {
            if (i == 0 && lines.get(0).startsWith("/")) {
                setComponent1(StringUtils.substring(lines.get(0), 1));
            } else {
                setComponent(component++, SwiftParseUtils.getTokenFirst(lines.get(i), "/"));
                setComponent(component++, SwiftParseUtils.getTokenSecondLast(lines.get(i), "/"));
            }
        }
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        if (getComponent1() != null) {
            result.append("/").append(getComponent1());
        }
        for (int comp = 2; comp<=8; comp++) {
            if (getComponent(comp) != null || getComponent(comp+1) != null) {
                if (result.length() > 0) {
                    result.append(com.prowidesoftware.swift.io.writer.FINWriterVisitor.SWIFT_EOL);
                }
                append(result, comp);
                result.append('/');
                append(result, comp+1);
                comp++;
            }
        }
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
        if (component < 1 || component > 9) {
            throw new IllegalArgumentException("invalid component number " + component + " for field 59F");
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
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(9);
    }

    /**
     * Returns the field component types pattern.
     * <p>
     * This method returns a letter representing the type for each component in the Field. It supersedes
     * the Components Pattern because it distinguishes between N (Number) and I (BigDecimal).
     * @since 9.2.7
     */
    @Override
    public String typesPattern() {
        return "SNSNSNSNS";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "[/S$]N/S[$N/S$]0-3";
    }

    /**
     * Returns the field validator pattern
     */
    @Override
    public String validatorPattern() {
        return "CUSTOM";
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
        if (component == 1) {
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
        return 9;
    }

    /**
     * Returns english label for components.
     * <br>
     * The index in the list is in sync with specific field component structure.
     * @see #getComponentLabel(int)
     * @since 7.8.4
     */
    @Override
    public List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Account");
        result.add("Number 1");
        result.add("Name And Address 1");
        result.add("Number 2");
        result.add("Name And Address 2");
        result.add("Number 3");
        result.add("Name And Address 3");
        result.add("Number 4");
        result.add("Name And Address 4");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "account");
        result.put(2, "number1");
        result.put(3, "nameAndAddress1");
        result.put(4, "number2");
        result.put(5, "nameAndAddress2");
        result.put(6, "number3");
        result.put(7, "nameAndAddress3");
        result.put(8, "number4");
        result.put(9, "nameAndAddress4");
        return result;
    }

    /**
     * @see Field#getLabelMap()
     * @since 9.3.12
     */
    @Override
    protected Map<String, Integer> getLabelMap() {
        if (super.labelMap != null && !super.labelMap.isEmpty()) {
            // return cached map
            return super.labelMap;
        }
        super.labelMap = new HashMap<>();
        super.labelMap.put("account", 1);
        super.labelMap.put("number1", 2);
        super.labelMap.put("nameandaddress1", 3);
        super.labelMap.put("number2", 4);
        super.labelMap.put("nameandaddress2", 5);
        super.labelMap.put("number3", 6);
        super.labelMap.put("nameandaddress3", 7);
        super.labelMap.put("number4", 8);
        super.labelMap.put("nameandaddress4", 9);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Account).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Gets the Account (component 1) removing its starting slashes if any.
     * @return the Account from component 1
     */
    public String getAccount() {
        String account = getComponent(1);
        if (account != null) {
            for(int i = 0; i < account.length(); i++) {
                if (account.charAt(i) != '/') {
                    return account.substring(i);
                }
            }
            return "";
        }
        return null;
    }

    /**
     * Gets the component 2 (Number 1).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Get the component 2 as Long
     *
     * @return the component 2 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent2AsLong() {
        return SwiftFormatUtils.getLong(getComponent(2));
    }

    /**
     * Gets the Number 1 (component 2).
     * @return the Number 1 from component 2
     */
    public String getNumber1() {
        return getComponent2();
    }

    /**
     * Get the Number 1 (component 2) as Long
     * @return the Number 1 from component 2 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getNumber1AsLong() {
        return getComponent2AsLong();
    }

    /**
     * Gets the component 3 (Name And Address 1).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Name And Address 1 (component 3).
     * @return the Name And Address 1 from component 3
     */
    public String getNameAndAddress1() {
        return getComponent3();
    }

    /**
     * Gets the component 4 (Number 2).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Get the component 4 as Long
     *
     * @return the component 4 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent4AsLong() {
        return SwiftFormatUtils.getLong(getComponent(4));
    }

    /**
     * Gets the Number 2 (component 4).
     * @return the Number 2 from component 4
     */
    public String getNumber2() {
        return getComponent4();
    }

    /**
     * Get the Number 2 (component 4) as Long
     * @return the Number 2 from component 4 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getNumber2AsLong() {
        return getComponent4AsLong();
    }

    /**
     * Gets the component 5 (Name And Address 2).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Gets the Name And Address 2 (component 5).
     * @return the Name And Address 2 from component 5
     */
    public String getNameAndAddress2() {
        return getComponent5();
    }

    /**
     * Gets the component 6 (Number 3).
     * @return the component 6
     */
    public String getComponent6() {
        return getComponent(6);
    }

    /**
     * Get the component 6 as Long
     *
     * @return the component 6 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent6AsLong() {
        return SwiftFormatUtils.getLong(getComponent(6));
    }

    /**
     * Gets the Number 3 (component 6).
     * @return the Number 3 from component 6
     */
    public String getNumber3() {
        return getComponent6();
    }

    /**
     * Get the Number 3 (component 6) as Long
     * @return the Number 3 from component 6 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getNumber3AsLong() {
        return getComponent6AsLong();
    }

    /**
     * Gets the component 7 (Name And Address 3).
     * @return the component 7
     */
    public String getComponent7() {
        return getComponent(7);
    }

    /**
     * Gets the Name And Address 3 (component 7).
     * @return the Name And Address 3 from component 7
     */
    public String getNameAndAddress3() {
        return getComponent7();
    }

    /**
     * Gets the component 8 (Number 4).
     * @return the component 8
     */
    public String getComponent8() {
        return getComponent(8);
    }

    /**
     * Get the component 8 as Long
     *
     * @return the component 8 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent8AsLong() {
        return SwiftFormatUtils.getLong(getComponent(8));
    }

    /**
     * Gets the Number 4 (component 8).
     * @return the Number 4 from component 8
     */
    public String getNumber4() {
        return getComponent8();
    }

    /**
     * Get the Number 4 (component 8) as Long
     * @return the Number 4 from component 8 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getNumber4AsLong() {
        return getComponent8AsLong();
    }

    /**
     * Gets the component 9 (Name And Address 4).
     * @return the component 9
     */
    public String getComponent9() {
        return getComponent(9);
    }

    /**
     * Gets the Name And Address 4 (component 9).
     * @return the Name And Address 4 from component 9
     */
    public String getNameAndAddress4() {
        return getComponent9();
    }

    /**
     * Set the component 1 (Account).
     *
     * @param component1 the Account to set
     * @return the field object to enable build pattern
     */
    public Field59F setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the Account (component 1).
     *
     * @param component1 the Account to set
     * @return the field object to enable build pattern
     */
    public Field59F setAccount(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Number 1).
     *
     * @param component2 the Number 1 to set
     * @return the field object to enable build pattern
     */
    public Field59F setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }


    /**
     * Alternative method setter for field's Number 1 (component 2) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the Number 1 content to set
     * @return the field object to enable build pattern
     */
    public Field59F setComponent2(java.lang.Number component2) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component2 instanceof Long) {
            setComponent(2, SwiftFormatUtils.getLong((Long) component2));
        } else if (component2 instanceof BigInteger || component2 instanceof Integer) {
            setComponent(2, SwiftFormatUtils.getLong(component2.longValue()));
        } else if (component2 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(2, SwiftFormatUtils.getLong(component2.longValue()));
        } else {
            // explicitly set component as null
            setComponent(2, null);
        }
        return this;
    }

    /**
     * Set the Number 1 (component 2).
     *
     * @param component2 the Number 1 to set
     * @return the field object to enable build pattern
     */
    public Field59F setNumber1(String component2) {
        return setComponent2(component2);
    }

    /**
     * Alternative method setter for field's Number 1 (component 2) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the Number 1 content to set
     * @return the field object to enable build pattern
     */
    public Field59F setNumber1(java.lang.Number component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Name And Address 1).
     *
     * @param component3 the Name And Address 1 to set
     * @return the field object to enable build pattern
     */
    public Field59F setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Name And Address 1 (component 3).
     *
     * @param component3 the Name And Address 1 to set
     * @return the field object to enable build pattern
     */
    public Field59F setNameAndAddress1(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Number 2).
     *
     * @param component4 the Number 2 to set
     * @return the field object to enable build pattern
     */
    public Field59F setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }


    /**
     * Alternative method setter for field's Number 2 (component 4) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Number 2 content to set
     * @return the field object to enable build pattern
     */
    public Field59F setComponent4(java.lang.Number component4) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component4 instanceof Long) {
            setComponent(4, SwiftFormatUtils.getLong((Long) component4));
        } else if (component4 instanceof BigInteger || component4 instanceof Integer) {
            setComponent(4, SwiftFormatUtils.getLong(component4.longValue()));
        } else if (component4 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(4, SwiftFormatUtils.getLong(component4.longValue()));
        } else {
            // explicitly set component as null
            setComponent(4, null);
        }
        return this;
    }

    /**
     * Set the Number 2 (component 4).
     *
     * @param component4 the Number 2 to set
     * @return the field object to enable build pattern
     */
    public Field59F setNumber2(String component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative method setter for field's Number 2 (component 4) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Number 2 content to set
     * @return the field object to enable build pattern
     */
    public Field59F setNumber2(java.lang.Number component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Name And Address 2).
     *
     * @param component5 the Name And Address 2 to set
     * @return the field object to enable build pattern
     */
    public Field59F setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Set the Name And Address 2 (component 5).
     *
     * @param component5 the Name And Address 2 to set
     * @return the field object to enable build pattern
     */
    public Field59F setNameAndAddress2(String component5) {
        return setComponent5(component5);
    }

    /**
     * Set the component 6 (Number 3).
     *
     * @param component6 the Number 3 to set
     * @return the field object to enable build pattern
     */
    public Field59F setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }


    /**
     * Alternative method setter for field's Number 3 (component 6) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component6 the Number with the Number 3 content to set
     * @return the field object to enable build pattern
     */
    public Field59F setComponent6(java.lang.Number component6) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component6 instanceof Long) {
            setComponent(6, SwiftFormatUtils.getLong((Long) component6));
        } else if (component6 instanceof BigInteger || component6 instanceof Integer) {
            setComponent(6, SwiftFormatUtils.getLong(component6.longValue()));
        } else if (component6 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(6, SwiftFormatUtils.getLong(component6.longValue()));
        } else {
            // explicitly set component as null
            setComponent(6, null);
        }
        return this;
    }

    /**
     * Set the Number 3 (component 6).
     *
     * @param component6 the Number 3 to set
     * @return the field object to enable build pattern
     */
    public Field59F setNumber3(String component6) {
        return setComponent6(component6);
    }

    /**
     * Alternative method setter for field's Number 3 (component 6) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component6 the Number with the Number 3 content to set
     * @return the field object to enable build pattern
     */
    public Field59F setNumber3(java.lang.Number component6) {
        return setComponent6(component6);
    }

    /**
     * Set the component 7 (Name And Address 3).
     *
     * @param component7 the Name And Address 3 to set
     * @return the field object to enable build pattern
     */
    public Field59F setComponent7(String component7) {
        setComponent(7, component7);
        return this;
    }

    /**
     * Set the Name And Address 3 (component 7).
     *
     * @param component7 the Name And Address 3 to set
     * @return the field object to enable build pattern
     */
    public Field59F setNameAndAddress3(String component7) {
        return setComponent7(component7);
    }

    /**
     * Set the component 8 (Number 4).
     *
     * @param component8 the Number 4 to set
     * @return the field object to enable build pattern
     */
    public Field59F setComponent8(String component8) {
        setComponent(8, component8);
        return this;
    }


    /**
     * Alternative method setter for field's Number 4 (component 8) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component8 the Number with the Number 4 content to set
     * @return the field object to enable build pattern
     */
    public Field59F setComponent8(java.lang.Number component8) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component8 instanceof Long) {
            setComponent(8, SwiftFormatUtils.getLong((Long) component8));
        } else if (component8 instanceof BigInteger || component8 instanceof Integer) {
            setComponent(8, SwiftFormatUtils.getLong(component8.longValue()));
        } else if (component8 != null) {
            // it's another non-null Number (Float, Double, BigDecimal, etc...)
            setComponent(8, SwiftFormatUtils.getLong(component8.longValue()));
        } else {
            // explicitly set component as null
            setComponent(8, null);
        }
        return this;
    }

    /**
     * Set the Number 4 (component 8).
     *
     * @param component8 the Number 4 to set
     * @return the field object to enable build pattern
     */
    public Field59F setNumber4(String component8) {
        return setComponent8(component8);
    }

    /**
     * Alternative method setter for field's Number 4 (component 8) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component8 the Number with the Number 4 content to set
     * @return the field object to enable build pattern
     */
    public Field59F setNumber4(java.lang.Number component8) {
        return setComponent8(component8);
    }

    /**
     * Set the component 9 (Name And Address 4).
     *
     * @param component9 the Name And Address 4 to set
     * @return the field object to enable build pattern
     */
    public Field59F setComponent9(String component9) {
        setComponent(9, component9);
        return this;
    }

    /**
     * Set the Name And Address 4 (component 9).
     *
     * @param component9 the Name And Address 4 to set
     * @return the field object to enable build pattern
     */
    public Field59F setNameAndAddress4(String component9) {
        return setComponent9(component9);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any).
     * @return the static value of Field59F.NAME
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
    public static Field59F get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field59F(t);
    }

    /**
     * Gets the first instance of Field59F in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field59F get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field59F in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field59F> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field59F from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field59F> getAll(final SwiftTagListBlock block) {
        final List<Field59F> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field59F(f));
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
    @Override
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
    @Override
    public String getLine(int line, int offset) {
        Field59F cp = newInstance(this);
        return getLine(cp, line, null, offset);
    }

    /**
     * Returns the field value split into lines.
     *
     * @see MultiLineField#getLines()
     * @return lines content or empty list if field's value is empty
     * @since 7.7
     */
    @Override
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
    @Override
    public List<String> getLines(int offset) {
        Field59F cp = newInstance(this);
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
    @Override
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
    @Override
    public List<String> getLinesBetween(int start, int end, int offset) {
        Field59F cp = newInstance(this);
        return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
    }

    /**
     * This method deserializes the JSON data into a Field59F object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field59F fromJson(final String json) {

        final Field59F field = new Field59F();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Account

        if (jsonObject.get("account") != null) {
            field.setComponent1(jsonObject.get("account").getAsString());
        }

        // **** COMPONENT 2 - Number 1

        if (jsonObject.get("number1") != null) {
            field.setComponent2(jsonObject.get("number1").getAsString());
        }

        // **** COMPONENT 3 - Name And Address 1

        if (jsonObject.get("nameAndAddress1") != null) {
            field.setComponent3(jsonObject.get("nameAndAddress1").getAsString());
        }

        // **** COMPONENT 4 - Number 2

        if (jsonObject.get("number2") != null) {
            field.setComponent4(jsonObject.get("number2").getAsString());
        }

        // **** COMPONENT 5 - Name And Address 2

        if (jsonObject.get("nameAndAddress2") != null) {
            field.setComponent5(jsonObject.get("nameAndAddress2").getAsString());
        }

        // **** COMPONENT 6 - Number 3

        if (jsonObject.get("number3") != null) {
            field.setComponent6(jsonObject.get("number3").getAsString());
        }

        // **** COMPONENT 7 - Name And Address 3

        if (jsonObject.get("nameAndAddress3") != null) {
            field.setComponent7(jsonObject.get("nameAndAddress3").getAsString());
        }

        // **** COMPONENT 8 - Number 4

        if (jsonObject.get("number4") != null) {
            field.setComponent8(jsonObject.get("number4").getAsString());
        }

        // **** COMPONENT 9 - Name And Address 4

        if (jsonObject.get("nameAndAddress4") != null) {
            field.setComponent9(jsonObject.get("nameAndAddress4").getAsString());
        }

        return field;
    }

	/**
	 * Specific implementation for field 59F using dynamic labels based on line identifiers.
	 *
	 * <p>For component 3 this implementation will return the labels provided by
	 * {@link #getLabelForLineNumber(String)} while for all other cases it will return the
	 * default label.
	 *
	 * <p>
	 * Also since the party identifier can be an account or a code plus the identifier,
	 * then for component 1 if the value starts with a slash, this implementation will return
	 * "Account" as label instead of the generic "Party Identifier".
	 *
	 * @param number a component number
	 * @return english label for the field component
	 *
	 * @since 9.4.14
	 */
	@Override
	public String getComponentLabel(final int number) {
		if (number == 1 && StringUtils.startsWith(getComponent1(), "/")) {
			return "Account";
		}
		if (number == 3 || number == 5 || number == 7) {
			String label = getLabelForLineNumber(getComponent(number-1));
			if (label != null) {
				return label;
			}
		}
		return super.getComponentLabel(number);
	}


	/**
	 * Return the line labels based on the structured line number identification as follows:
	 *
	 * <ul>
	 * 	<li>1 -&gt; Name of Beneficiary Customer</li>
	 * 	<li>2 -&gt; Address Line</li>
	 * 	<li>3 -&gt; Country and Town</li>
	 * 	<li>For any other number returns null</li>
	 * </ul>
	 *
	 * <p>This is used in {@link #getComponentLabel(int)} to determine a suitable label dynamically
	 * based on the line identifiers. For example if the field value is this:
	 * <pre>
	 * 1/John Smith
	 * 2/Hoogstrat 6
	 * 3/BE/Brussel
	 * </pre>
	 * The components will be parsed as follows:
	 * <ul>
	 * 	<li>1 -&gt; John Smith</li>
	 * 	<li>2 -&gt; 1</li>
	 * 	<li>3 -&gt; Hoogstrat 6</li>
	 * 	<li>4 -&gt; 2</li>
	 * 	<li>5 -&gt; BE/Brussel</li>
	 * 	<li>5 -&gt; 3</li>
	 * </ul>
	 *
	 * <p>
	 * @param lineIdentifier the line number identifier, 1 to 3 according to the specification.
	 * @return the line label
	 * @since 9.4.14
	 */
	public String getLabelForLineNumber(String lineIdentifier) {
		if (StringUtils.isNumeric(StringUtils.trimToNull(lineIdentifier))) {
            try {
                int number = Integer.valueOf(lineIdentifier.trim());
                if (number == 1) {
                    return "Name of Beneficiary Customer";
                } else if (number == 2) {
                    return "Address Line";
                } else if (number == 3) {
                    return "Country and Town";
                }
            } catch (NumberFormatException e) {
                // ignore
            }
		}
		return null;
	}
    /**
     * Get the details (right part of the line) based on the line identification number.
     * This API is specific for the structured field 59F.
     * @param lineIdentifier a line number in the range of 1 to 3
     * @return the details for the found lines or empty list if non is found or the line number is incorrect
     * @since 7.10.4
     */
    public List<String> detailsByNumber(int lineIdentifier) {
		List<String> result = new ArrayList<>();
		String number = String.valueOf(lineIdentifier);
		if (StringUtils.equals(number, getComponent2()) && StringUtils.isNotBlank(getComponent3())) {
			result.add(getComponent3());
		}
		if (StringUtils.equals(number, getComponent4()) && StringUtils.isNotBlank(getComponent5())) {
			result.add(getComponent5());
		}
		if (StringUtils.equals(number, getComponent6()) && StringUtils.isNotBlank(getComponent7())) {
			result.add(getComponent7());
		}
		if (StringUtils.equals(number, getComponent8()) && StringUtils.isNotBlank(getComponent9())) {
			result.add(getComponent9());
		}
		return result;
	}

    /**
     * Check if the line identified by a given number is present.
     * This API is specific for the structured field 59F.
     * @param lineIdentifier a line number in the range of 1 to 3
     * @return true if the structured content includes the line identified by the given number
     * @since 7.10.4
     */
    public boolean contains(int lineIdentifier) {
		String number = String.valueOf(lineIdentifier);
		if (StringUtils.equals(number, getComponent2()) && StringUtils.isNotBlank(getComponent3())) {
			return true;
		}
		if (StringUtils.equals(number, getComponent4()) && StringUtils.isNotBlank(getComponent5())) {
            return true;
		}
		if (StringUtils.equals(number, getComponent6()) && StringUtils.isNotBlank(getComponent7())) {
			return true;
		}
		if (StringUtils.equals(number, getComponent8()) && StringUtils.isNotBlank(getComponent9())) {
			return true;
		}
		return false;
	}
}
