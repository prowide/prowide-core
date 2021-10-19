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

import java.math.BigDecimal;
import java.math.BigInteger;


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 343</strong>
 * <p>
 * Model and parser for field 343 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>Long</code></li>
 * 		<li><code>Long</code></li>
 * 		<li><code>Long</code></li>
 * 		<li><code>Long</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>5!n 5!n 5!n 5!n</code></li>
 * 		<li>parser pattern: <code>N&lt;SPACE&gt;N&lt;SPACE&gt;N&lt;SPACE&gt;N</code></li>
 * 		<li>components pattern: <code>NNNN</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2021</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field343 extends Field implements Serializable {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2021;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 343
	 */
    public static final String NAME = "343";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_343 = "343";
	public static final String PARSER_PATTERN = "N<SPACE>N<SPACE>N<SPACE>N";

    /**
     * Components pattern
     *
     * Contains a description of the type for every component. This is <em>DEPRECATED</em>,
     * use TYPES_PATTERN instead, because it distinguishes between N (number) and I (BigDecimal)
     * @see #TYPES_PATTERN
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
	public static final String COMPONENTS_PATTERN = "NNNN";

    /**
     * Types pattern
     *
     * Contains a description of the type for every component, use instead of COMPONENTS_PATTERN.
     * @since 9.2.7
     */
	public static final String TYPES_PATTERN = "NNNN";

	/**
	 * Component number for the Region Time Count 1 subfield
	 */
	public static final Integer REGION_TIME_COUNT_1 = 1;

	/**
	 * Component number for the Region Time Count 2 subfield
	 */
	public static final Integer REGION_TIME_COUNT_2 = 2;

	/**
	 * Component number for the Region Time Count 3 subfield
	 */
	public static final Integer REGION_TIME_COUNT_3 = 3;

	/**
	 * Component number for the Region Time Count 4 subfield
	 */
	public static final Integer REGION_TIME_COUNT_4 = 4;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public Field343() {
        super(4);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public Field343(final String value) {
        super(value);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter tag.
     * The value is parsed with {@link #parse(String)}
     * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
     * @since 7.8
     */
    public Field343(final Tag tag) {
        this();
        if (tag == null) {
            throw new IllegalArgumentException("tag cannot be null.");
        }
        if (!StringUtils.equals(tag.getName(), "343")) {
            throw new IllegalArgumentException("cannot create field 343 from tag "+tag.getName()+", tagname must match the name of the field.");
        }
        parse(tag.getValue());
    }

    /**
     * Copy constructor.<br>
     * Initializes the components list with a deep copy of the source components list.
     * @param source a field instance to copy
     * @since 7.7
     */
    public static Field343 newInstance(Field343 source) {
        Field343 cp = new Field343();
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
        String[] values = StringUtils.split(value);
        if (values != null) {
            int component = 1;
            for (String v : values) {
                setComponent(component, v);
                component++;
            }
        }
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        append(result, 1);
        result.append(" ");
        append(result, 2);
        result.append(" ");
        append(result, 3);
        result.append(" ");
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 343");
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
            //number, amount, rate
            java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
            f.setMaximumFractionDigits(13);
            Number n = getComponent2AsNumber();
            if (n != null) {
                return f.format(n);
            }
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
            //number, amount, rate
            java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
            f.setMaximumFractionDigits(13);
            Number n = getComponent4AsNumber();
            if (n != null) {
                return f.format(n);
            }
        }
        return null;
    }

    /**
     * Returns the field components pattern
     *
     * This method is <em>DEPRECATED</em>, use <code>typesPattern()</code> instead.
     * @see #typesPattern()
     * @return the static value of Field343.COMPONENTS_PATTERN
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
     * @return the static value of Field343.TYPES_PATTERN
     */
    @Override
    public final String typesPattern() {
        return TYPES_PATTERN;
    }

    /**
     * Returns the field parser pattern
     * @return the static value of Field343.PARSER_PATTERN
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
        return "5!n 5!n 5!n 5!n";
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
        result.add("Region Time Count 1");
        result.add("Region Time Count 2");
        result.add("Region Time Count 3");
        result.add("Region Time Count 4");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "regionTimeCount1");
        result.put(2, "regionTimeCount2");
        result.put(3, "regionTimeCount3");
        result.put(4, "regionTimeCount4");
        return result;
    }


    /**
     * Gets the component 1 (Region Time Count 1).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Get the component 1 as Long
     *
     * @return the component 1 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent1AsLong() {
        return SwiftFormatUtils.getLong(getComponent(1));
    }

    /**
     * Get the component 1 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent1AsLong()</code> to get the proper value.
     *
     * @return the component 1 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent1AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getComponent1AsNumber() {
        Long l = getComponent1AsLong();
        return l != null ? new BigDecimal(l.longValue()) : null;
    }

    /**
     * Gets the Region Time Count 1 (component 1).
     * @return the Region Time Count 1 from component 1
     */
    public String getRegionTimeCount1() {
        return getComponent1();
    }

    /**
     * Get the Region Time Count 1 (component 1) as Long
     * @return the Region Time Count 1 from component 1 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getRegionTimeCount1AsLong() {
        return getComponent1AsLong();
    }

    /**
     * Get the Region Time Count 1 (component 1) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent1AsLong()</code> to get the proper value.
     *
     * @return the component 1 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getRegionTimeCount1AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getRegionTimeCount1AsNumber() {
        return getComponent1AsNumber();
    }

    /**
     * Gets the component 2 (Region Time Count 2).
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
     * Get the component 2 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent2AsLong()</code> to get the proper value.
     *
     * @return the component 2 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent2AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getComponent2AsNumber() {
        Long l = getComponent2AsLong();
        return l != null ? new BigDecimal(l.longValue()) : null;
    }

    /**
     * Gets the Region Time Count 2 (component 2).
     * @return the Region Time Count 2 from component 2
     */
    public String getRegionTimeCount2() {
        return getComponent2();
    }

    /**
     * Get the Region Time Count 2 (component 2) as Long
     * @return the Region Time Count 2 from component 2 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getRegionTimeCount2AsLong() {
        return getComponent2AsLong();
    }

    /**
     * Get the Region Time Count 2 (component 2) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent2AsLong()</code> to get the proper value.
     *
     * @return the component 2 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getRegionTimeCount2AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getRegionTimeCount2AsNumber() {
        return getComponent2AsNumber();
    }

    /**
     * Gets the component 3 (Region Time Count 3).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Get the component 3 as Long
     *
     * @return the component 3 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getComponent3AsLong() {
        return SwiftFormatUtils.getLong(getComponent(3));
    }

    /**
     * Get the component 3 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent3AsLong()</code> to get the proper value.
     *
     * @return the component 3 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent3AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getComponent3AsNumber() {
        Long l = getComponent3AsLong();
        return l != null ? new BigDecimal(l.longValue()) : null;
    }

    /**
     * Gets the Region Time Count 3 (component 3).
     * @return the Region Time Count 3 from component 3
     */
    public String getRegionTimeCount3() {
        return getComponent3();
    }

    /**
     * Get the Region Time Count 3 (component 3) as Long
     * @return the Region Time Count 3 from component 3 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getRegionTimeCount3AsLong() {
        return getComponent3AsLong();
    }

    /**
     * Get the Region Time Count 3 (component 3) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent3AsLong()</code> to get the proper value.
     *
     * @return the component 3 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getRegionTimeCount3AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getRegionTimeCount3AsNumber() {
        return getComponent3AsNumber();
    }

    /**
     * Gets the component 4 (Region Time Count 4).
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
     * Get the component 4 as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent4AsLong()</code> to get the proper value.
     *
     * @return the component 4 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getComponent4AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getComponent4AsNumber() {
        Long l = getComponent4AsLong();
        return l != null ? new BigDecimal(l.longValue()) : null;
    }

    /**
     * Gets the Region Time Count 4 (component 4).
     * @return the Region Time Count 4 from component 4
     */
    public String getRegionTimeCount4() {
        return getComponent4();
    }

    /**
     * Get the Region Time Count 4 (component 4) as Long
     * @return the Region Time Count 4 from component 4 converted to Long or null if cannot be converted
     * @since 9.2.7
     */
    public java.lang.Long getRegionTimeCount4AsLong() {
        return getComponent4AsLong();
    }

    /**
     * Get the Region Time Count 4 (component 4) as as Number (BigDecimal)
     *
     * The value is returned as BigDecimal to keep compatibility with previous API. You should
     * use <code>getComponent4AsLong()</code> to get the proper value.
     *
     * @return the component 4 converted to Number (BigDecimal) or null if cannot be converted
     * @see #getRegionTimeCount4AsLong()
     */
    @Deprecated
    @ProwideDeprecated(phase2=TargetYear.SRU2022)
    public java.lang.Number getRegionTimeCount4AsNumber() {
        return getComponent4AsNumber();
    }

    /**
     * Set the component 1 (Region Time Count 1).
     *
     * @param component1 the Region Time Count 1 to set
     * @return the field object to enable build pattern
     */
    public Field343 setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the component1 from a Long object.
     * <br>
     * <em>If the component being set is a fixed length number, the argument will not be
     * padded.</em> It is recommended for these cases to use the setComponent1(String)
     * method.
     *
     * @see #setComponent1(String)
     * @since 9.2.7
     *
     * @param component1 the Long with the Region Time Count 1 content to set
     * @return the field object to enable build pattern
     */
    public Field343 setComponent1(java.lang.Long component1) {
        setComponent(1, SwiftFormatUtils.getLong(component1));
        return this;
    }

    /**
     * Alternative method setter for field's Region Time Count 1 (component 1) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Region Time Count 1 content to set
     * @return the field object to enable build pattern
     * @see #setRegionTimeCount1(java.lang.Long)
     */
    public Field343 setComponent1(java.lang.Number component1) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component1 instanceof Long) {
            setComponent(1, SwiftFormatUtils.getLong( (Long) component1));
        } else if (component1 instanceof BigInteger || component1 instanceof Integer) {
            setComponent(1, SwiftFormatUtils.getLong(new Long(component1.longValue())));
        } else if (component1 instanceof Float || component1 instanceof Double ||
                   component1 instanceof BigDecimal || component1 instanceof Number) {
            // it's non null
            setComponent(1, SwiftFormatUtils.getLong(new Long(component1.longValue())));
        } else {
            // so it's a Number that failed instanceof Number => it's null
            setComponent(1, null);
        }
        return this;
    }

    /**
     * Set the Region Time Count 1 (component 1).
     *
     * @param component1 the Region Time Count 1 to set
     * @return the field object to enable build pattern
     */
    public Field343 setRegionTimeCount1(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the Region Time Count 1 (component 1) from a Long object.
     *
     * @see #setComponent1(java.lang.Long)
     *
     * @param component1 Long with the Region Time Count 1 content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field343 setRegionTimeCount1(java.lang.Long component1) {
        return setComponent1(component1);
    }

    /**
     * Alternative method setter for field's Region Time Count 1 (component 1) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component1 the Number with the Region Time Count 1 content to set
     * @return the field object to enable build pattern
     * @see #setRegionTimeCount1(java.lang.Long)
     */
    public Field343 setRegionTimeCount1(java.lang.Number component1) {
        return setComponent1(component1);
    }

    /**
     * Set the component 2 (Region Time Count 2).
     *
     * @param component2 the Region Time Count 2 to set
     * @return the field object to enable build pattern
     */
    public Field343 setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Long object.
     * <br>
     * <em>If the component being set is a fixed length number, the argument will not be
     * padded.</em> It is recommended for these cases to use the setComponent2(String)
     * method.
     *
     * @see #setComponent2(String)
     * @since 9.2.7
     *
     * @param component2 the Long with the Region Time Count 2 content to set
     * @return the field object to enable build pattern
     */
    public Field343 setComponent2(java.lang.Long component2) {
        setComponent(2, SwiftFormatUtils.getLong(component2));
        return this;
    }

    /**
     * Alternative method setter for field's Region Time Count 2 (component 2) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the Region Time Count 2 content to set
     * @return the field object to enable build pattern
     * @see #setRegionTimeCount2(java.lang.Long)
     */
    public Field343 setComponent2(java.lang.Number component2) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component2 instanceof Long) {
            setComponent(2, SwiftFormatUtils.getLong( (Long) component2));
        } else if (component2 instanceof BigInteger || component2 instanceof Integer) {
            setComponent(2, SwiftFormatUtils.getLong(new Long(component2.longValue())));
        } else if (component2 instanceof Float || component2 instanceof Double ||
                   component2 instanceof BigDecimal || component2 instanceof Number) {
            // it's non null
            setComponent(2, SwiftFormatUtils.getLong(new Long(component2.longValue())));
        } else {
            // so it's a Number that failed instanceof Number => it's null
            setComponent(2, null);
        }
        return this;
    }

    /**
     * Set the Region Time Count 2 (component 2).
     *
     * @param component2 the Region Time Count 2 to set
     * @return the field object to enable build pattern
     */
    public Field343 setRegionTimeCount2(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Region Time Count 2 (component 2) from a Long object.
     *
     * @see #setComponent2(java.lang.Long)
     *
     * @param component2 Long with the Region Time Count 2 content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field343 setRegionTimeCount2(java.lang.Long component2) {
        return setComponent2(component2);
    }

    /**
     * Alternative method setter for field's Region Time Count 2 (component 2) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component2 the Number with the Region Time Count 2 content to set
     * @return the field object to enable build pattern
     * @see #setRegionTimeCount2(java.lang.Long)
     */
    public Field343 setRegionTimeCount2(java.lang.Number component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Region Time Count 3).
     *
     * @param component3 the Region Time Count 3 to set
     * @return the field object to enable build pattern
     */
    public Field343 setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the component3 from a Long object.
     * <br>
     * <em>If the component being set is a fixed length number, the argument will not be
     * padded.</em> It is recommended for these cases to use the setComponent3(String)
     * method.
     *
     * @see #setComponent3(String)
     * @since 9.2.7
     *
     * @param component3 the Long with the Region Time Count 3 content to set
     * @return the field object to enable build pattern
     */
    public Field343 setComponent3(java.lang.Long component3) {
        setComponent(3, SwiftFormatUtils.getLong(component3));
        return this;
    }

    /**
     * Alternative method setter for field's Region Time Count 3 (component 3) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Region Time Count 3 content to set
     * @return the field object to enable build pattern
     * @see #setRegionTimeCount3(java.lang.Long)
     */
    public Field343 setComponent3(java.lang.Number component3) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component3 instanceof Long) {
            setComponent(3, SwiftFormatUtils.getLong( (Long) component3));
        } else if (component3 instanceof BigInteger || component3 instanceof Integer) {
            setComponent(3, SwiftFormatUtils.getLong(new Long(component3.longValue())));
        } else if (component3 instanceof Float || component3 instanceof Double ||
                   component3 instanceof BigDecimal || component3 instanceof Number) {
            // it's non null
            setComponent(3, SwiftFormatUtils.getLong(new Long(component3.longValue())));
        } else {
            // so it's a Number that failed instanceof Number => it's null
            setComponent(3, null);
        }
        return this;
    }

    /**
     * Set the Region Time Count 3 (component 3).
     *
     * @param component3 the Region Time Count 3 to set
     * @return the field object to enable build pattern
     */
    public Field343 setRegionTimeCount3(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the Region Time Count 3 (component 3) from a Long object.
     *
     * @see #setComponent3(java.lang.Long)
     *
     * @param component3 Long with the Region Time Count 3 content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field343 setRegionTimeCount3(java.lang.Long component3) {
        return setComponent3(component3);
    }

    /**
     * Alternative method setter for field's Region Time Count 3 (component 3) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component3 the Number with the Region Time Count 3 content to set
     * @return the field object to enable build pattern
     * @see #setRegionTimeCount3(java.lang.Long)
     */
    public Field343 setRegionTimeCount3(java.lang.Number component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Region Time Count 4).
     *
     * @param component4 the Region Time Count 4 to set
     * @return the field object to enable build pattern
     */
    public Field343 setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the component4 from a Long object.
     * <br>
     * <em>If the component being set is a fixed length number, the argument will not be
     * padded.</em> It is recommended for these cases to use the setComponent4(String)
     * method.
     *
     * @see #setComponent4(String)
     * @since 9.2.7
     *
     * @param component4 the Long with the Region Time Count 4 content to set
     * @return the field object to enable build pattern
     */
    public Field343 setComponent4(java.lang.Long component4) {
        setComponent(4, SwiftFormatUtils.getLong(component4));
        return this;
    }

    /**
     * Alternative method setter for field's Region Time Count 4 (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Region Time Count 4 content to set
     * @return the field object to enable build pattern
     * @see #setRegionTimeCount4(java.lang.Long)
     */
    public Field343 setComponent4(java.lang.Number component4) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component4 instanceof Long) {
            setComponent(4, SwiftFormatUtils.getLong( (Long) component4));
        } else if (component4 instanceof BigInteger || component4 instanceof Integer) {
            setComponent(4, SwiftFormatUtils.getLong(new Long(component4.longValue())));
        } else if (component4 instanceof Float || component4 instanceof Double ||
                   component4 instanceof BigDecimal || component4 instanceof Number) {
            // it's non null
            setComponent(4, SwiftFormatUtils.getLong(new Long(component4.longValue())));
        } else {
            // so it's a Number that failed instanceof Number => it's null
            setComponent(4, null);
        }
        return this;
    }

    /**
     * Set the Region Time Count 4 (component 4).
     *
     * @param component4 the Region Time Count 4 to set
     * @return the field object to enable build pattern
     */
    public Field343 setRegionTimeCount4(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the Region Time Count 4 (component 4) from a Long object.
     *
     * @see #setComponent4(java.lang.Long)
     *
     * @param component4 Long with the Region Time Count 4 content to set
     * @return the field object to enable build pattern
     * @since 9.2.7
     */
    public Field343 setRegionTimeCount4(java.lang.Long component4) {
        return setComponent4(component4);
    }

    /**
     * Alternative method setter for field's Region Time Count 4 (component 4) as as Number
     *
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component4 the Number with the Region Time Count 4 content to set
     * @return the field object to enable build pattern
     * @see #setRegionTimeCount4(java.lang.Long)
     */
    public Field343 setRegionTimeCount4(java.lang.Number component4) {
        return setComponent4(component4);
    }



    /**
     * Returns the field's name composed by the field number and the letter option (if any)
     * @return the static value of Field343.NAME
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
    public static Field343 get(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return null;
        }
        final Tag t = block.getTagByName(NAME);
        if (t == null) {
            return null;
        }
        return new Field343(t) ;
    }

    /**
     * Gets the first instance of Field343 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field343 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return null;
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field343 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field343> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty())
            return java.util.Collections.emptyList();
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field343 from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field343> getAll(final SwiftTagListBlock block) {
        if (block == null || block.isEmpty()) {
            return java.util.Collections.emptyList();
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null && arr.length > 0) {
            final List<Field343> result = new ArrayList<>(arr.length);
            for (final Tag f : arr) {
                result.add( new Field343(f));
            }
            return result;
        }
        return java.util.Collections.emptyList();
    }

    /**
     * This method deserializes the JSON data into a Field343 object.
     * @param json JSON structure including tuples with label and value for all field components
     * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
     * @since 7.10.3
     * @see Field#fromJson(String)
     */
    public static Field343 fromJson(final String json) {

        Field343 field = new Field343();

        JsonParser parser = new JsonParser();
        JsonObject jsonObject = (JsonObject) parser.parse(json);

        // **** COMPONENT 1 - Region Time Count 1

        if (jsonObject.get("regionTimeCount1") != null) {
            field.setComponent1(jsonObject.get("regionTimeCount1").getAsString());
        }

        // **** COMPONENT 2 - Region Time Count 2

        if (jsonObject.get("regionTimeCount2") != null) {
            field.setComponent2(jsonObject.get("regionTimeCount2").getAsString());
        }

        // **** COMPONENT 3 - Region Time Count 3

        if (jsonObject.get("regionTimeCount3") != null) {
            field.setComponent3(jsonObject.get("regionTimeCount3").getAsString());
        }

        // **** COMPONENT 4 - Region Time Count 4

        if (jsonObject.get("regionTimeCount4") != null) {
            field.setComponent4(jsonObject.get("regionTimeCount4").getAsString());
        }

        return field;
    }


}
