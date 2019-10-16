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
import java.math.BigDecimal;
import com.prowidesoftware.swift.model.field.AmountContainer;
import com.prowidesoftware.swift.model.field.AmountResolver;
import com.prowidesoftware.swift.model.field.MultiLineField;


import org.apache.commons.lang3.StringUtils;

import com.prowidesoftware.swift.model.field.SwiftParseUtils;
import com.prowidesoftware.swift.model.field.Field;
import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * <strong>SWIFT MT Field 61</strong>
 * <p>
 * Model and parser for field 61 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>Calendar</code></li>
 * 		<li><code>Calendar</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>Number</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>validation pattern: <code>CUSTOM</code></li>
 * 		<li>parser pattern: <code>CUSTOM</code></li>
 * 		<li>components pattern: <code>EJSSNSSSSS</code></li>
 * </ul>
 *
 * <p>
 * This class complies with standard release <strong>SRU2019</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field61 extends Field implements Serializable, AmountContainer, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2019;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 61
	 */
    public static final String NAME = "61";
    /**
     * same as NAME, intended to be clear when using static imports
     */
    public static final String F_61 = "61";
	public static final String PARSER_PATTERN ="CUSTOM";
	public static final String COMPONENTS_PATTERN = "EJSSNSSSSS";

	/**
	 * Component number for the Value Date subfield
	 */
	public static final Integer VALUE_DATE = 1;

	/**
	 * Component number for the Entry Date subfield
	 */
	public static final Integer ENTRY_DATE = 2;

	/**
	 * Component number for the D/C Mark subfield
	 */
	public static final Integer DC_MARK = 3;

	/**
	 * Component number for the Funds Code subfield
	 */
	public static final Integer FUNDS_CODE = 4;

	/**
	 * Component number for the Amount subfield
	 */
	public static final Integer AMOUNT = 5;

	/**
	 * Component number for the Transaction Type subfield
	 */
	public static final Integer TRANSACTION_TYPE = 6;

	/**
	 * Component number for the Identification Code subfield
	 */
	public static final Integer IDENTIFICATION_CODE = 7;

	/**
	 * Component number for the Reference For The Account Owner subfield
	 */
	public static final Integer REFERENCE_FOR_THE_ACCOUNT_OWNER = 8;

	/**
	 * Component number for the Reference Of The Account Servicing Institution subfield
	 */
	public static final Integer REFERENCE_OF_THE_ACCOUNT_SERVICING_INSTITUTION = 9;

	/**
	 * Component number for the Supplementary Details subfield
	 */
	public static final Integer SUPPLEMENTARY_DETAILS = 10;

	/**
	 * Default constructor. Creates a new field setting all components to null.
	 */
	public Field61() {
		super(10);
	}
	    					
	/**
	 * Creates a new field and initializes its components with content from the parameter value.
	 * @param value complete field value including separators and CRLF
	 */
	public Field61(final String value) {
		super(value);
	}
	
	/**
	 * Creates a new field and initializes its components with content from the parameter tag.
	 * The value is parsed with {@link #parse(String)} 	 
	 * @throws IllegalArgumentException if the parameter tag is null or its tagname does not match the field name
	 * @since 7.8
	 */
	public Field61(final Tag tag) {
		this();
		if (tag == null) {
			throw new IllegalArgumentException("tag cannot be null.");
		}
		if (!StringUtils.equals(tag.getName(), "61")) {
			throw new IllegalArgumentException("cannot create field 61 from tag "+tag.getName()+", tagname must match the name of the field.");
		}
		parse(tag.getValue());
	}

	/**
	 * Copy constructor.<br>
	 * Initializes the components list with a deep copy of the source components list.
	 * @param source a field instance to copy
	 * @since 7.7
	 */
	public static Field61 newInstance(Field61 source) {
		Field61 cp = new Field61();
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
		init(10);
      //parse code from merge file
      parseCustom(value);
	}
	/**
	 * Serializes the fields' components into the single string value (SWIFT format)
	 */
	@Override
	public String getValue() {
		final StringBuilder result = new StringBuilder();
		// CUSTOM pattern for field 61
		append(result, 1);
		append(result, 2);
		append(result, 3);
		append(result, 4);
		append(result, 5);
		append(result, 6);
		append(result, 7);
		append(result, 8);
		if (getComponent9() != null) {
			result.append("//");
			result.append(getComponent9());
		}
		if (getComponent10() != null) {
			result.append(com.prowidesoftware.swift.io.writer.FINWriterVisitor.SWIFT_EOL);
			result.append(getComponent10());
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
		if (component < 1 || component > 10) {
			throw new IllegalArgumentException("invalid component number "+component+" for field 61");
		}
		if (component == 1) {
			//date
			java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, notNull(locale));
			java.util.Calendar cal = getComponent1AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
		}
		if (component == 2) {
			//monthday
			java.text.DateFormat f = new java.text.SimpleDateFormat("MMM", notNull(locale));
			java.util.Calendar cal = getComponent2AsCalendar();
			if (cal != null) {
				return f.format(cal.getTime());
			}
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
			//number, amount, rate
			java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
			f.setMaximumFractionDigits(13);
    		Number n = getComponent5AsNumber();
			if (n != null) {
				return f.format(n);
			}
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
		return null;
	}
	/**
	 * Returns the field components pattern
	 * @return the static value of Field61.COMPONENTS_PATTERN
	 */
	@Override
	public final String componentsPattern() {
		return COMPONENTS_PATTERN;
	}

	/**
     * Returns the field parser pattern
     * @return the static value of Field61.PARSER_PATTERN
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
        if (component == 2) {
            return true;
        }
        if (component == 4) {
            return true;
        }
        if (component == 9) {
            return true;
        }
        if (component == 10) {
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
		return 10;
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
		result.add("Value Date");
		result.add("Entry Date");
		result.add("D/C Mark");
		result.add("Funds Code");
		result.add("Amount");
		result.add("Transaction Type");
		result.add("Identification Code");
		result.add("Reference For The Account Owner");
		result.add("Reference Of The Account Servicing Institution");
		result.add("Supplementary Details");
		return result;
	}

	/**
	 * Returns a mapping between component numbers and their label in camel case format.
	 * @since 7.10.3
	 */
	@Override
	protected Map<Integer, String> getComponentMap() {
		Map<Integer, String> result = new HashMap<>();
		result.put(1, "valueDate");
		result.put(2, "entryDate");
		result.put(3, "dCMark");
		result.put(4, "fundsCode");
		result.put(5, "amount");
		result.put(6, "transactionType");
		result.put(7, "identificationCode");
		result.put(8, "referenceForTheAccountOwner");
		result.put(9, "referenceOfTheAccountServicingInstitution");
		result.put(10, "supplementaryDetails");
		return result;
	}
	/**
	 * Gets the component1 (Value Date).
	 * @return the component1
	 */
	public String getComponent1() {
		return getComponent(1);
	}

	/**
	 * Get the component1 as Calendar
	 * @return the component1 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getComponent1AsCalendar() {
		return SwiftFormatUtils.getDate2(getComponent(1));
	}

	/**
	 * Gets the Value Date (component1).
	 * @return the Value Date from component1
	 */
	public String getValueDate() {
		return getComponent(1);
	}
	
	/**
	 * Get the Value Date (component1) as Calendar
	 * @return the Value Date from component1 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getValueDateAsCalendar() {
		return SwiftFormatUtils.getDate2(getComponent(1));
	}
	/**
	 * Gets the component2 (Entry Date).
	 * @return the component2
	 */
	public String getComponent2() {
		return getComponent(2);
	}

	/**
	 * Get the component2 as Calendar
	 * @return the component2 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getComponent2AsCalendar() {
		return SwiftFormatUtils.getMonthDay(getComponent(2));
	}

	/**
	 * Gets the Entry Date (component2).
	 * @return the Entry Date from component2
	 */
	public String getEntryDate() {
		return getComponent(2);
	}
	
	/**
	 * Get the Entry Date (component2) as Calendar
	 * @return the Entry Date from component2 converted to Calendar or null if cannot be converted
	 */
	public java.util.Calendar getEntryDateAsCalendar() {
		return SwiftFormatUtils.getMonthDay(getComponent(2));
	}
	/**
	 * Gets the component3 (D/C Mark).
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
	 * Gets the D/C Mark (component3).
	 * @return the D/C Mark from component3
	 */
	public String getDCMark() {
		return getComponent(3);
	}
	/**
	 * Gets the component4 (Funds Code).
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
	 * Gets the Funds Code (component4).
	 * @return the Funds Code from component4
	 */
	public String getFundsCode() {
		return getComponent(4);
	}
	/**
	 * Gets the component5 (Amount).
	 * @return the component5
	 */
	public String getComponent5() {
		return getComponent(5);
	}

	/**
	 * Get the component5 as Number
	 * @return the component5 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getComponent5AsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(5));
	}

	/**
	 * Gets the Amount (component5).
	 * @return the Amount from component5
	 */
	public String getAmount() {
		return getComponent(5);
	}
	
	/**
	 * Get the Amount (component5) as Number
	 * @return the Amount from component5 converted to Number or null if cannot be converted
	 */
	public java.lang.Number getAmountAsNumber() {
		return SwiftFormatUtils.getNumber(getComponent(5));
	}
	/**
	 * Gets the component6 (Transaction Type).
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
	 * Gets the Transaction Type (component6).
	 * @return the Transaction Type from component6
	 */
	public String getTransactionType() {
		return getComponent(6);
	}
	/**
	 * Gets the component7 (Identification Code).
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
	 * Gets the Identification Code (component7).
	 * @return the Identification Code from component7
	 */
	public String getIdentificationCode() {
		return getComponent(7);
	}
	/**
	 * Gets the component8 (Reference For The Account Owner).
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
	 * Gets the Reference For The Account Owner (component8).
	 * @return the Reference For The Account Owner from component8
	 */
	public String getReferenceForTheAccountOwner() {
		return getComponent(8);
	}
	/**
	 * Gets the component9 (Reference Of The Account Servicing Institution).
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
	 * Gets the Reference Of The Account Servicing Institution (component9).
	 * @return the Reference Of The Account Servicing Institution from component9
	 */
	public String getReferenceOfTheAccountServicingInstitution() {
		return getComponent(9);
	}
	/**
	 * Gets the component10 (Supplementary Details).
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
	 * Gets the Supplementary Details (component10).
	 * @return the Supplementary Details from component10
	 */
	public String getSupplementaryDetails() {
		return getComponent(10);
	}
    
	/**
	 * @see AmountResolver#amounts(Field)
	 */
	public List<BigDecimal> amounts() {
		return AmountResolver.amounts(this);
	}
	
	/**
	 * @see AmountResolver#amount(Field)
	 */
	public BigDecimal amount() {
		return AmountResolver.amount(this);
	}


	/**
	 * Set the component1 (Value Date).
	 * @param component1 the component1 to set
	 */
	public Field61 setComponent1(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the component1 from a Calendar object.
	 * <br>
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -&gt; 1234,</li>
	 * 	<li>Example: 1234 -&gt; 1234,</li>
	 * 	<li>Example: 1234.56 -&gt; 1234,56</li>
	 * </ul>
	 * @param component1 the Calendar with the component1 content to set
	 */
	public Field61 setComponent1(java.util.Calendar component1) {
		setComponent(1, SwiftFormatUtils.getDate2(component1));
		return this;
	}
	
	/**
	 * Set the Value Date (component1).
	 * @param component1 the Value Date to set
	 */
	public Field61 setValueDate(String component1) {
		setComponent(1, component1);
		return this;
	}
	
	/**
	 * Set the Value Date (component1) from a Calendar object.
	 * @see #setComponent1(java.util.Calendar)
	 * @param component1 Calendar with the Value Date content to set
	 */
	public Field61 setValueDate(java.util.Calendar component1) {
		setComponent1(component1);
		return this;
	}

	/**
	 * Set the component2 (Entry Date).
	 * @param component2 the component2 to set
	 */
	public Field61 setComponent2(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the component2 from a Calendar object.
	 * <br>
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -&gt; 1234,</li>
	 * 	<li>Example: 1234 -&gt; 1234,</li>
	 * 	<li>Example: 1234.56 -&gt; 1234,56</li>
	 * </ul>
	 * @param component2 the Calendar with the component2 content to set
	 */
	public Field61 setComponent2(java.util.Calendar component2) {
		setComponent(2, SwiftFormatUtils.getMonthDay(component2));
		return this;
	}
	
	/**
	 * Set the Entry Date (component2).
	 * @param component2 the Entry Date to set
	 */
	public Field61 setEntryDate(String component2) {
		setComponent(2, component2);
		return this;
	}
	
	/**
	 * Set the Entry Date (component2) from a Calendar object.
	 * @see #setComponent2(java.util.Calendar)
	 * @param component2 Calendar with the Entry Date content to set
	 */
	public Field61 setEntryDate(java.util.Calendar component2) {
		setComponent2(component2);
		return this;
	}

	/**
	 * Set the component3 (D/C Mark).
	 * @param component3 the component3 to set
	 */
	public Field61 setComponent3(String component3) {
		setComponent(3, component3);
		return this;
	}
	
	/**
	 * Set the D/C Mark (component3).
	 * @param component3 the D/C Mark to set
	 */
	public Field61 setDCMark(String component3) {
		setComponent(3, component3);
		return this;
	}

	/**
	 * Set the component4 (Funds Code).
	 * @param component4 the component4 to set
	 */
	public Field61 setComponent4(String component4) {
		setComponent(4, component4);
		return this;
	}
	
	/**
	 * Set the Funds Code (component4).
	 * @param component4 the Funds Code to set
	 */
	public Field61 setFundsCode(String component4) {
		setComponent(4, component4);
		return this;
	}

	/**
	 * Set the component5 (Amount).
	 * @param component5 the component5 to set
	 */
	public Field61 setComponent5(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the component5 from a Number object.
	 * <br>
	 * Parses the Number into a SWIFT amount with truncated zero decimals and mandatory decimal separator.
	 * <ul>
	 * 	<li>Example: 1234.00 -&gt; 1234,</li>
	 * 	<li>Example: 1234 -&gt; 1234,</li>
	 * 	<li>Example: 1234.56 -&gt; 1234,56</li>
	 * </ul>
	 * @param component5 the Number with the component5 content to set
	 */
	public Field61 setComponent5(java.lang.Number component5) {
		setComponent(5, SwiftFormatUtils.getNumber(component5));
		return this;
	}
	
	/**
	 * Set the Amount (component5).
	 * @param component5 the Amount to set
	 */
	public Field61 setAmount(String component5) {
		setComponent(5, component5);
		return this;
	}
	
	/**
	 * Set the Amount (component5) from a Number object.
	 * @see #setComponent5(java.lang.Number)
	 * @param component5 Number with the Amount content to set
	 */
	public Field61 setAmount(java.lang.Number component5) {
		setComponent5(component5);
		return this;
	}

	/**
	 * Set the component6 (Transaction Type).
	 * @param component6 the component6 to set
	 */
	public Field61 setComponent6(String component6) {
		setComponent(6, component6);
		return this;
	}
	
	/**
	 * Set the Transaction Type (component6).
	 * @param component6 the Transaction Type to set
	 */
	public Field61 setTransactionType(String component6) {
		setComponent(6, component6);
		return this;
	}

	/**
	 * Set the component7 (Identification Code).
	 * @param component7 the component7 to set
	 */
	public Field61 setComponent7(String component7) {
		setComponent(7, component7);
		return this;
	}
	
	/**
	 * Set the Identification Code (component7).
	 * @param component7 the Identification Code to set
	 */
	public Field61 setIdentificationCode(String component7) {
		setComponent(7, component7);
		return this;
	}

	/**
	 * Set the component8 (Reference For The Account Owner).
	 * @param component8 the component8 to set
	 */
	public Field61 setComponent8(String component8) {
		setComponent(8, component8);
		return this;
	}
	
	/**
	 * Set the Reference For The Account Owner (component8).
	 * @param component8 the Reference For The Account Owner to set
	 */
	public Field61 setReferenceForTheAccountOwner(String component8) {
		setComponent(8, component8);
		return this;
	}

	/**
	 * Set the component9 (Reference Of The Account Servicing Institution).
	 * @param component9 the component9 to set
	 */
	public Field61 setComponent9(String component9) {
		setComponent(9, component9);
		return this;
	}
	
	/**
	 * Set the Reference Of The Account Servicing Institution (component9).
	 * @param component9 the Reference Of The Account Servicing Institution to set
	 */
	public Field61 setReferenceOfTheAccountServicingInstitution(String component9) {
		setComponent(9, component9);
		return this;
	}

	/**
	 * Set the component10 (Supplementary Details).
	 * @param component10 the component10 to set
	 */
	public Field61 setComponent10(String component10) {
		setComponent(10, component10);
		return this;
	}
	
	/**
	 * Set the Supplementary Details (component10).
	 * @param component10 the Supplementary Details to set
	 */
	public Field61 setSupplementaryDetails(String component10) {
		setComponent(10, component10);
		return this;
	}

   
	/**
	 * Returns the field's name composed by the field number and the letter option (if any)
	 * @return the static value of Field61.NAME
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
	public static Field61 get(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return null;
		}
		final Tag t = block.getTagByName(NAME);
		if (t == null) {
			return null;
		}
		return new Field61(t) ;
	}
	
	/**
	 * Gets the first instance of Field61 in the given message.
	 * @param msg may be empty or null
	 * @return null if not found or msg is empty or null
	 * @see #get(SwiftTagListBlock)
	 */
	public static Field61 get(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return null;
		return get(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field61 in the given message
	 * an empty list is returned if none found.
	 * @param msg may be empty or null in which case an empty list is returned
	 * @see #getAll(SwiftTagListBlock)
	 */ 
	public static List<Field61> getAll(final SwiftMessage msg) {
		if (msg == null || msg.getBlock4()==null || msg.getBlock4().isEmpty())
			return java.util.Collections.emptyList();
		return getAll(msg.getBlock4());
	}

	/**
	 * Gets a list of all occurrences of the field Field61 from the given block
	 * an empty list is returned if none found.
	 *
	 * @param block may be empty or null in which case an empty list is returned 
	 */ 
	public static List<Field61> getAll(final SwiftTagListBlock block) {
		if (block == null || block.isEmpty()) {
			return java.util.Collections.emptyList();
		}
		final Tag[] arr = block.getTagsByName(NAME);
		if (arr != null && arr.length > 0) {
			final List<Field61> result = new ArrayList<>(arr.length);
			for (final Tag f : arr) {
				result.add( new Field61(f));
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
		Field61 cp = newInstance(this);
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
		Field61 cp = newInstance(this);
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
		Field61 cp = newInstance(this);
		return SwiftParseUtils.getLines(getLine(cp, start, end, offset));
	}

	/**
	 * This method deserializes the JSON data into a Field61 object.
	 * @param json JSON structure including tuples with label and value for all field components
	 * @return a new field instance with the JSON data parsed into field components or an empty field id the JSON is invalid
	 * @since 7.10.3
	 * @see Field#fromJson(String)
	 */
	public static Field61 fromJson(final String json) {
		Field61 field = new Field61();
		JsonParser parser = new JsonParser();
		JsonObject jsonObject = (JsonObject) parser.parse(json);
		if (jsonObject.get("valueDate") != null) {
			field.setComponent1(jsonObject.get("valueDate").getAsString());
		}
		if (jsonObject.get("entryDate") != null) {
			field.setComponent2(jsonObject.get("entryDate").getAsString());
		}
		if (jsonObject.get("dCMark") != null) {
			field.setComponent3(jsonObject.get("dCMark").getAsString());
		}
		if (jsonObject.get("fundsCode") != null) {
			field.setComponent4(jsonObject.get("fundsCode").getAsString());
		}
		if (jsonObject.get("amount") != null) {
			field.setComponent5(jsonObject.get("amount").getAsString());
		}
		if (jsonObject.get("transactionType") != null) {
			field.setComponent6(jsonObject.get("transactionType").getAsString());
		}
		if (jsonObject.get("identificationCode") != null) {
			field.setComponent7(jsonObject.get("identificationCode").getAsString());
		}
		if (jsonObject.get("referenceForTheAccountOwner") != null) {
			field.setComponent8(jsonObject.get("referenceForTheAccountOwner").getAsString());
		}
		if (jsonObject.get("referenceOfTheAccountServicingInstitution") != null) {
			field.setComponent9(jsonObject.get("referenceOfTheAccountServicingInstitution").getAsString());
		}
		if (jsonObject.get("supplementaryDetails") != null) {
			field.setComponent10(jsonObject.get("supplementaryDetails").getAsString());
		}
		return field;
	}
	

	/**
	 * Custom parser for Field61.
	 *
	 * <p>
	 * Uses semantic information to split components 3 and 4 (assuming component 3 can only be D, C, RD, RC).
	 * It also splits VAR-SEQU-1 into components 7 and 8.
	 *
	 * <p>MT=940, 942
	 * <br>
	 * &lt;DATE2&gt;[&lt;DATE1&gt;]2a[1a]&lt;NUMBER&gt;15&lt;SUB-6&gt;&lt;VAR-SEQU-1&gt;[’CRLF’&lt;ERI-F61&gt;]
	 *
	 * <p>
	 * MT=other, i.e. : 608, 950, 970, 972, n92, n95, n96
	 * <br>
	 * &lt;DATE2&gt;[&lt;DATE1&gt;]2a[1a]&lt;NUMBER&gt;15&lt;SUB-6&gt;&lt;VAR-SEQU-1&gt;[’CRLF’34x](**)
	 */
	protected void parseCustom(String value) {
		//thanks to Mark Karatovic for his contribution on this implementation.
		java.util.List<String>lines = SwiftParseUtils.getLines(value);
		if (lines.isEmpty()) {
			return;
		}
		/*
		 * parse dates
		 */
		String dates = SwiftParseUtils.getNumericPrefix(lines.get(0));
		int dates_length = dates != null ? dates.length() : 0;
		if (dates_length >= 6) {
			setComponent1(org.apache.commons.lang3.StringUtils.substring(dates, 0, 6));
		}
		if (dates_length >= 10) {
			setComponent2(org.apache.commons.lang3.StringUtils.substring(dates, 6));
		}
		String toparse = org.apache.commons.lang3.StringUtils.substring(lines.get(0), dates_length);
			
		/*
		 * parse component 3 and 4 (DC mark and optional funds code)
		 */
		String comp3and4 = SwiftParseUtils.getAlphaPrefix(toparse);	
		if (comp3and4 != null) {
	    	if (comp3and4.charAt(0) == 'R' || comp3and4.charAt(0) == 'E') {
	    		/*
		         EC Expected Credit
		         ED Expected Debit
		         RC Reversal of Credit (debit entry)
		         RD Reversal of Debit (credit entry)
		        */
	    		if (comp3and4.length() >= 2) {
	    			setComponent3(org.apache.commons.lang3.StringUtils.substring(comp3and4, 0, 2));
	    		}
	    		if (comp3and4.length() >= 3) {
	    			setComponent4(org.apache.commons.lang3.StringUtils.substring(comp3and4, 2));
	    		}
	    	} else{
	    		/*
		         C  Credit
		         D  Debit
		        */
	    		if (comp3and4.length() >= 1) {
	    			setComponent3(org.apache.commons.lang3.StringUtils.substring(comp3and4, 0, 1));
	    		}
	    		if (comp3and4.length() >= 2) {
	    			setComponent4(org.apache.commons.lang3.StringUtils.substring(comp3and4, 1));
	    		}
	    	}
	    		
			String toparse2 = org.apache.commons.lang3.StringUtils.substring(toparse, comp3and4.length());
				
			/*
			 * parse component 5
			 */
			String comp5 = SwiftParseUtils.getNumericPrefix(toparse2);
			int comp5_length = comp5 != null ? comp5.length() : 0;
			setComponent5(comp5);
				
			/*
			 * parse <SUB-6> into components 6 and 7
			 */
			String toparse3 = org.apache.commons.lang3.StringUtils.substring(toparse2, comp5_length);
			String toParseTxnCode = org.apache.commons.lang3.StringUtils.substring(toparse3, 0, 4);
			setComponent6(org.apache.commons.lang3.StringUtils.substring(toParseTxnCode, 0, 1));
			setComponent7(org.apache.commons.lang3.StringUtils.substring(toParseTxnCode, 1));

			int toParseTxnCodeLength = toParseTxnCode != null ? toParseTxnCode.length() : 0;
			String toparse4 = org.apache.commons.lang3.StringUtils.substring(toparse3, toParseTxnCodeLength);
				
			/*
			 * parse <VAR-SEQU-1> into components 8 and 9
			 */
			setComponent8(org.apache.commons.lang3.StringUtils.substringBefore(toparse4, "//"));
			setComponent9(org.apache.commons.lang3.StringUtils.substringAfter(toparse4, "//"));
		}
		
		if (lines.size() > 1) {
			setComponent10(lines.get(1));
		}
	}
}
