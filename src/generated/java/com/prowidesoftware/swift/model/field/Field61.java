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
import java.util.Calendar;

import com.prowidesoftware.swift.model.field.MultiLineField;
import com.prowidesoftware.swift.model.field.AmountContainer;
import com.prowidesoftware.swift.model.field.AmountResolver;
import com.prowidesoftware.swift.model.field.DateContainer;
import com.prowidesoftware.swift.model.field.DateResolver;

import com.prowidesoftware.swift.model.*;
import com.prowidesoftware.swift.utils.SwiftFormatUtils;
import org.apache.commons.lang3.StringUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * SWIFT MT Field 61.
 * <p>
 * Model and parser for field 61 of a SWIFT MT message.
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li>Component 1: ValueDate: <code>Calendar</code></li>
 * 		<li>Component 2: EntryDate: <code>Calendar</code></li>
 * 		<li>Component 3: DebitCreditMark: <code>String</code></li>
 * 		<li>Component 4: FundsCode: <code>String</code></li>
 * 		<li>Component 5: Amount: <code>BigDecimal</code></li>
 * 		<li>Component 6: TransactionType: <code>String</code></li>
 * 		<li>Component 7: IdentificationCode: <code>String</code></li>
 * 		<li>Component 8: ReferenceForTheAccountOwner: <code>String</code></li>
 * 		<li>Component 9: ReferenceOfTheAccountServicingInstitution: <code>String</code></li>
 * 		<li>Component 10: SupplementaryDetails: <code>String</code></li>
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
 * This class complies with standard release <strong>SRU2024</strong>
 */
@SuppressWarnings("unused")
@Generated
public class Field61 extends Field implements Serializable, AmountContainer, DateContainer, MultiLineField {
	/**
	 * Constant identifying the SRU to which this class belongs to.
	 */
	public static final int SRU = 2024;

	private static final long serialVersionUID = 1L;
	/**
	 * Constant with the field name 61.
	 */
    public static final String NAME = "61";
    /**
     * Same as NAME, intended to be clear when using static imports.
     */
    public static final String F_61 = "61";

	/**
	 * Component number for the Value Date subfield.
	 */
	public static final Integer VALUE_DATE = 1;

	/**
     * Alternative constant name for field's Value Date Component number.
     * @see #VALUE_DATE
     */
    public static final Integer DATE = 1;

	/**
	 * Component number for the Entry Date subfield.
	 */
	public static final Integer ENTRY_DATE = 2;

	/**
	 * Component number for the Debit/Credit Mark subfield.
	 */
	public static final Integer DEBITCREDIT_MARK = 3;


	/**
	 * Component number for the Funds Code subfield.
	 */
	public static final Integer FUNDS_CODE = 4;

	/**
	 * Component number for the Amount subfield.
	 */
	public static final Integer AMOUNT = 5;

	/**
	 * Component number for the Transaction Type subfield.
	 */
	public static final Integer TRANSACTION_TYPE = 6;

	/**
	 * Component number for the Identification Code subfield.
	 */
	public static final Integer IDENTIFICATION_CODE = 7;

	/**
	 * Component number for the Reference For The Account Owner subfield.
	 */
	public static final Integer REFERENCE_FOR_THE_ACCOUNT_OWNER = 8;

	/**
	 * Component number for the Reference Of The Account Servicing Institution subfield.
	 */
	public static final Integer REFERENCE_OF_THE_ACCOUNT_SERVICING_INSTITUTION = 9;

	/**
	 * Component number for the Supplementary Details subfield.
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
     * Copy constructor.
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
            throw new IllegalArgumentException("invalid component number " + component + " for field 61");
        }
        if (component == 1) {
            //date: [YY]YYMMDD
            java.text.DateFormat f = java.text.DateFormat.getDateInstance(java.text.DateFormat.DEFAULT, notNull(locale));
            java.util.Calendar cal = getComponent1AsCalendar();
            if (cal != null) {
                return f.format(cal.getTime());
            }
        }
        if (component == 2) {
            //month and day: MMDD
            java.text.DateFormat f = new java.text.SimpleDateFormat("MMM dd", notNull(locale));
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
            //amount, rate
            java.text.NumberFormat f = java.text.NumberFormat.getNumberInstance(notNull(locale));
            f.setMaximumFractionDigits(13);
            BigDecimal n = getComponent5AsBigDecimal();
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
        // This is the last component, return directly without `if`
        //default format (as is)
        return getComponent(10);
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
        return "EJSSISSSSS";
    }

    /**
     * Returns the field parser pattern.
     */
    @Override
    public String parserPattern() {
        return "CUSTOM";
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
    public List<String> getComponentLabels() {
        List<String> result = new ArrayList<>();
        result.add("Value Date");
        result.add("Entry Date");
        result.add("Debit/Credit Mark");
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
        result.put(3, "debitCreditMark");
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
        super.labelMap.put("valuedate", 1);
        // alias name
        super.labelMap.put("date", 1);
        super.labelMap.put("entrydate", 2);
        super.labelMap.put("debitcreditmark", 3);
        // alias name
        super.labelMap.put("dcmark", 3);
        super.labelMap.put("fundscode", 4);
        super.labelMap.put("amount", 5);
        super.labelMap.put("transactiontype", 6);
        super.labelMap.put("identificationcode", 7);
        super.labelMap.put("referencefortheaccountowner", 8);
        super.labelMap.put("referenceoftheaccountservicinginstitution", 9);
        super.labelMap.put("supplementarydetails", 10);
        return super.labelMap;
    }

    /**
     * Gets the component 1 (Value Date).
     * @return the component 1
     */
    public String getComponent1() {
        return getComponent(1);
    }

    /**
     * Get the component 1 as Calendar
     *
     * @return the component 1 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent1AsCalendar() {
        return SwiftFormatUtils.getDate2(getComponent(1));
    }

    /**
     * Gets the Value Date (component 1).
     * @return the Value Date from component 1
     */
    public String getValueDate() {
        return getComponent1();
    }

    /**
     * Alternative method getter for field's Value Date
     * @since 9.2.7
     */
    public String getDate() {
        return getValueDate();
    }

    /**
     * Get the Value Date (component 1) as Calendar
     * @return the Value Date from component 1 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getValueDateAsCalendar() {
        return getComponent1AsCalendar();
    }

    /**
     * @since 9.2.7
     */
    public java.util.Calendar getDateAsCalendar() {
        return getValueDateAsCalendar();
    }

    /**
     * Gets the component 2 (Entry Date).
     * @return the component 2
     */
    public String getComponent2() {
        return getComponent(2);
    }

    /**
     * Get the component 2 as Calendar
     *
     * @return the component 2 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getComponent2AsCalendar() {
        return SwiftFormatUtils.getMonthDay(getComponent(2));
    }

    /**
     * Gets the Entry Date (component 2).
     * @return the Entry Date from component 2
     */
    public String getEntryDate() {
        return getComponent2();
    }

    /**
     * Get the Entry Date (component 2) as Calendar
     * @return the Entry Date from component 2 converted to Calendar or null if cannot be converted
     */
    public java.util.Calendar getEntryDateAsCalendar() {
        return getComponent2AsCalendar();
    }

    /**
     * Gets the component 3 (Debit/Credit Mark).
     * @return the component 3
     */
    public String getComponent3() {
        return getComponent(3);
    }

    /**
     * Gets the Debit/Credit Mark (component 3).
     * @return the Debit/Credit Mark from component 3
     */
    public String getDebitCreditMark() {
        return getComponent3();
    }


    /**
     * Gets the component 4 (Funds Code).
     * @return the component 4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the Funds Code (component 4).
     * @return the Funds Code from component 4
     */
    public String getFundsCode() {
        return getComponent4();
    }

    /**
     * Gets the component 5 (Amount).
     * @return the component 5
     */
    public String getComponent5() {
        return getComponent(5);
    }

    /**
     * Get the component 5 as BigDecimal
     *
     * @return the component 5 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getComponent5AsBigDecimal() {
        return SwiftFormatUtils.getBigDecimal(getComponent(5));
    }

    /**
     * Gets the Amount (component 5).
     * @return the Amount from component 5
     */
    public String getAmount() {
        return getComponent5();
    }

    /**
     * Get the Amount (component 5) as BigDecimal
     * @return the Amount from component 5 converted to BigDecimal or null if cannot be converted
     * @since 9.2.7
     */
    public java.math.BigDecimal getAmountAsBigDecimal() {
        return getComponent5AsBigDecimal();
    }

    /**
     * Gets the component 6 (Transaction Type).
     * @return the component 6
     */
    public String getComponent6() {
        return getComponent(6);
    }

    /**
     * Gets the Transaction Type (component 6).
     * @return the Transaction Type from component 6
     */
    public String getTransactionType() {
        return getComponent6();
    }

    /**
     * Gets the component 7 (Identification Code).
     * @return the component 7
     */
    public String getComponent7() {
        return getComponent(7);
    }

    /**
     * Gets the Identification Code (component 7).
     * @return the Identification Code from component 7
     */
    public String getIdentificationCode() {
        return getComponent7();
    }

    /**
     * Gets the component 8 (Reference For The Account Owner).
     * @return the component 8
     */
    public String getComponent8() {
        return getComponent(8);
    }

    /**
     * Gets the Reference For The Account Owner (component 8).
     * @return the Reference For The Account Owner from component 8
     */
    public String getReferenceForTheAccountOwner() {
        return getComponent8();
    }

    /**
     * Gets the component 9 (Reference Of The Account Servicing Institution).
     * @return the component 9
     */
    public String getComponent9() {
        return getComponent(9);
    }

    /**
     * Gets the Reference Of The Account Servicing Institution (component 9).
     * @return the Reference Of The Account Servicing Institution from component 9
     */
    public String getReferenceOfTheAccountServicingInstitution() {
        return getComponent9();
    }

    /**
     * Gets the component 10 (Supplementary Details).
     * @return the component 10
     */
    public String getComponent10() {
        return getComponent(10);
    }

    /**
     * Gets the Supplementary Details (component 10).
     * @return the Supplementary Details from component 10
     */
    public String getSupplementaryDetails() {
        return getComponent10();
    }

    /**
     * Set the component 1 (Value Date).
     *
     * @param component1 the Value Date to set
     * @return the field object to enable build pattern
     */
    public Field61 setComponent1(String component1) {
        setComponent(1, component1);
        return this;
    }

    /**
     * Set the component1 from a Calendar object.
     *
     * @param component1 the Calendar with the Value Date content to set
     * @return the field object to enable build pattern
     */
    public Field61 setComponent1(java.util.Calendar component1) {
        setComponent(1, SwiftFormatUtils.getDate2(component1));
        return this;
    }

    /**
     * Set the Value Date (component 1).
     *
     * @param component1 the Value Date to set
     * @return the field object to enable build pattern
     */
    public Field61 setValueDate(String component1) {
        return setComponent1(component1);
    }

    /**
     * Set the Value Date (component 1) from a Calendar object.
     *
     * @see #setComponent1(java.util.Calendar)
     *
     * @param component1 Calendar with the Value Date content to set
     * @return the field object to enable build pattern
     */
    public Field61 setValueDate(java.util.Calendar component1) {
        return setComponent1(component1);
    }

    public Field61 setDate(String component1) {
        return setValueDate(component1);
    }

    public Field61 setDate(java.util.Calendar component1) {
        return setValueDate(component1);
    }

    /**
     * Set the component 2 (Entry Date).
     *
     * @param component2 the Entry Date to set
     * @return the field object to enable build pattern
     */
    public Field61 setComponent2(String component2) {
        setComponent(2, component2);
        return this;
    }

    /**
     * Set the component2 from a Calendar object.
     *
     * @param component2 the Calendar with the Entry Date content to set
     * @return the field object to enable build pattern
     */
    public Field61 setComponent2(java.util.Calendar component2) {
        setComponent(2, SwiftFormatUtils.getMonthDay(component2));
        return this;
    }

    /**
     * Set the Entry Date (component 2).
     *
     * @param component2 the Entry Date to set
     * @return the field object to enable build pattern
     */
    public Field61 setEntryDate(String component2) {
        return setComponent2(component2);
    }

    /**
     * Set the Entry Date (component 2) from a Calendar object.
     *
     * @see #setComponent2(java.util.Calendar)
     *
     * @param component2 Calendar with the Entry Date content to set
     * @return the field object to enable build pattern
     */
    public Field61 setEntryDate(java.util.Calendar component2) {
        return setComponent2(component2);
    }

    /**
     * Set the component 3 (Debit/Credit Mark).
     *
     * @param component3 the Debit/Credit Mark to set
     * @return the field object to enable build pattern
     */
    public Field61 setComponent3(String component3) {
        setComponent(3, component3);
        return this;
    }

    /**
     * Set the Debit/Credit Mark (component 3).
     *
     * @param component3 the Debit/Credit Mark to set
     * @return the field object to enable build pattern
     */
    public Field61 setDebitCreditMark(String component3) {
        return setComponent3(component3);
    }

    /**
     * Set the component 4 (Funds Code).
     *
     * @param component4 the Funds Code to set
     * @return the field object to enable build pattern
     */
    public Field61 setComponent4(String component4) {
        setComponent(4, component4);
        return this;
    }

    /**
     * Set the Funds Code (component 4).
     *
     * @param component4 the Funds Code to set
     * @return the field object to enable build pattern
     */
    public Field61 setFundsCode(String component4) {
        return setComponent4(component4);
    }

    /**
     * Set the component 5 (Amount).
     *
     * @param component5 the Amount to set
     * @return the field object to enable build pattern
     */
    public Field61 setComponent5(String component5) {
        setComponent(5, component5);
        return this;
    }

    /**
     * Alternative method setter for field's Amount (component 5) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10.0 becomes an Float)
     *
     * @param component5 the Number with the Amount content to set
     * @return the field object to enable build pattern
     */
    public Field61 setComponent5(java.lang.Number component5) {

        // NOTE: remember instanceof implicitly checks for non-null

        if (component5 instanceof BigDecimal) {
            setComponent(5, SwiftFormatUtils.getBigDecimal((BigDecimal) component5));
        } else if (component5 instanceof BigInteger) {
            setComponent(5, SwiftFormatUtils.getBigDecimal(new BigDecimal((BigInteger) component5)));
        } else if (component5 instanceof Long || component5 instanceof Integer) {
            setComponent(5, SwiftFormatUtils.getBigDecimal(BigDecimal.valueOf(component5.longValue())));
        } else if (component5 != null) {
            // it's other non-null Number (Float, Double, etc...)
            setComponent(5, SwiftFormatUtils.getBigDecimal(BigDecimal.valueOf(component5.doubleValue())));
        } else {
            // explicitly set component as null
            setComponent(5, null);
        }
        return this;
    }

    /**
     * Set the Amount (component 5).
     *
     * @param component5 the Amount to set
     * @return the field object to enable build pattern
     */
    public Field61 setAmount(String component5) {
        return setComponent5(component5);
    }

    /**
     * Alternative method setter for field's Amount (component 5) as Number
     * <p>
     * This method supports java constant value boxing for simpler coding styles (ex: 10 becomes an Integer)
     *
     * @param component5 the Number with the Amount content to set
     * @return the field object to enable build pattern
     */
    public Field61 setAmount(java.lang.Number component5) {
        return setComponent5(component5);
    }

    /**
     * Set the component 6 (Transaction Type).
     *
     * @param component6 the Transaction Type to set
     * @return the field object to enable build pattern
     */
    public Field61 setComponent6(String component6) {
        setComponent(6, component6);
        return this;
    }

    /**
     * Set the Transaction Type (component 6).
     *
     * @param component6 the Transaction Type to set
     * @return the field object to enable build pattern
     */
    public Field61 setTransactionType(String component6) {
        return setComponent6(component6);
    }

    /**
     * Set the component 7 (Identification Code).
     *
     * @param component7 the Identification Code to set
     * @return the field object to enable build pattern
     */
    public Field61 setComponent7(String component7) {
        setComponent(7, component7);
        return this;
    }

    /**
     * Set the Identification Code (component 7).
     *
     * @param component7 the Identification Code to set
     * @return the field object to enable build pattern
     */
    public Field61 setIdentificationCode(String component7) {
        return setComponent7(component7);
    }

    /**
     * Set the component 8 (Reference For The Account Owner).
     *
     * @param component8 the Reference For The Account Owner to set
     * @return the field object to enable build pattern
     */
    public Field61 setComponent8(String component8) {
        setComponent(8, component8);
        return this;
    }

    /**
     * Set the Reference For The Account Owner (component 8).
     *
     * @param component8 the Reference For The Account Owner to set
     * @return the field object to enable build pattern
     */
    public Field61 setReferenceForTheAccountOwner(String component8) {
        return setComponent8(component8);
    }

    /**
     * Set the component 9 (Reference Of The Account Servicing Institution).
     *
     * @param component9 the Reference Of The Account Servicing Institution to set
     * @return the field object to enable build pattern
     */
    public Field61 setComponent9(String component9) {
        setComponent(9, component9);
        return this;
    }

    /**
     * Set the Reference Of The Account Servicing Institution (component 9).
     *
     * @param component9 the Reference Of The Account Servicing Institution to set
     * @return the field object to enable build pattern
     */
    public Field61 setReferenceOfTheAccountServicingInstitution(String component9) {
        return setComponent9(component9);
    }

    /**
     * Set the component 10 (Supplementary Details).
     *
     * @param component10 the Supplementary Details to set
     * @return the field object to enable build pattern
     */
    public Field61 setComponent10(String component10) {
        setComponent(10, component10);
        return this;
    }

    /**
     * Set the Supplementary Details (component 10).
     *
     * @param component10 the Supplementary Details to set
     * @return the field object to enable build pattern
     */
    public Field61 setSupplementaryDetails(String component10) {
        return setComponent10(component10);
    }


    /**
     * Returns the list of all NON-NULL amounts as BigDecimal
     *
     * @return the list of NON-NULL amounts as BigDecimal values
     * @see AmountResolver#amounts(Field)
     */
    public List<BigDecimal> amounts() {
        return AmountResolver.amounts(this);
    }

    /**
     * Returns the first amounts as BigDecimal
     *
     * @return the first amount as BigDecimal value. Can be null
     * @see AmountResolver#amount(Field)
     */
    @Override
    public BigDecimal amount() {
        return AmountResolver.amount(this);
    }

    /**
     * Returns all components that can be converted to a Calendar
     *
     * @return the list of converted components (a Calendar object or null)
     * @since 9.2.7
     */
    @Override
    public List<Calendar> dates() {
        return DateResolver.dates(this);
    }

    /**
     * Returns the first component that can be converted to a Calendar
     *
     * @return the converted components (a Calendar object or null)
     * @since 9.2.7
     */
    public Calendar date() {
        return DateResolver.date(this);
    }


    /**
     * Returns the field's name composed by the field number and the letter option (if any).
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
        return new Field61(t);
    }

    /**
     * Gets the first instance of Field61 in the given message.
     * @param msg may be empty or null
     * @return null if not found or msg is empty or null
     * @see #get(SwiftTagListBlock)
     */
    public static Field61 get(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return null;
        }
        return get(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field61 in the given message
     * an empty list is returned if none found.
     * @param msg may be empty or null in which case an empty list is returned
     * @see #getAll(SwiftTagListBlock)
     */
    public static List<Field61> getAll(final SwiftMessage msg) {
        if (msg == null || msg.getBlock4() == null || msg.getBlock4().isEmpty()) {
            return java.util.Collections.emptyList();
        }
        return getAll(msg.getBlock4());
    }

    /**
     * Gets a list of all occurrences of the field Field61 from the given block
     * an empty list is returned if none found.
     *
     * @param block may be empty or null in which case an empty list is returned
     */
    public static List<Field61> getAll(final SwiftTagListBlock block) {
        final List<Field61> result = new ArrayList<>();
        if (block == null || block.isEmpty()) {
            return result;
        }
        final Tag[] arr = block.getTagsByName(NAME);
        if (arr != null) {
            for (final Tag f : arr) {
                result.add(new Field61(f));
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
        Field61 cp = newInstance(this);
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
        Field61 cp = newInstance(this);
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

        final Field61 field = new Field61();

        final JsonObject jsonObject = JsonParser.parseString(json).getAsJsonObject();

        // **** COMPONENT 1 - Value Date

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("date") != null) {
            field.setComponent1(jsonObject.get("date").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("valueDate") != null) {
            field.setComponent1(jsonObject.get("valueDate").getAsString());
        }

        // **** COMPONENT 2 - Entry Date

        if (jsonObject.get("entryDate") != null) {
            field.setComponent2(jsonObject.get("entryDate").getAsString());
        }

        // **** COMPONENT 3 - Debit/Credit Mark

        // first try using alias's names (including deprecated ones, if any)
        if (jsonObject.get("dCMark") != null) {
            field.setComponent3(jsonObject.get("dCMark").getAsString());
        }

        // last try using the official component's name (overwrites alternatives and DEPRECATED)
        if (jsonObject.get("debitCreditMark") != null) {
            field.setComponent3(jsonObject.get("debitCreditMark").getAsString());
        }

        // **** COMPONENT 4 - Funds Code

        if (jsonObject.get("fundsCode") != null) {
            field.setComponent4(jsonObject.get("fundsCode").getAsString());
        }

        // **** COMPONENT 5 - Amount

        if (jsonObject.get("amount") != null) {
            field.setComponent5(jsonObject.get("amount").getAsString());
        }

        // **** COMPONENT 6 - Transaction Type

        if (jsonObject.get("transactionType") != null) {
            field.setComponent6(jsonObject.get("transactionType").getAsString());
        }

        // **** COMPONENT 7 - Identification Code

        if (jsonObject.get("identificationCode") != null) {
            field.setComponent7(jsonObject.get("identificationCode").getAsString());
        }

        // **** COMPONENT 8 - Reference For The Account Owner

        if (jsonObject.get("referenceForTheAccountOwner") != null) {
            field.setComponent8(jsonObject.get("referenceForTheAccountOwner").getAsString());
        }

        // **** COMPONENT 9 - Reference Of The Account Servicing Institution

        if (jsonObject.get("referenceOfTheAccountServicingInstitution") != null) {
            field.setComponent9(jsonObject.get("referenceOfTheAccountServicingInstitution").getAsString());
        }

        // **** COMPONENT 10 - Supplementary Details

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
		String comp3and4 = null;
        if (toparse != null && toparse.length() > 0) {
            int i = 0;
            while (i < toparse.length() && (!StringUtils.isNumeric(Character.toString(toparse.charAt(i))) && toparse.charAt(i) != ',')) {
                i++;
            }
            if (i > 0) {
                comp3and4 = StringUtils.substring(toparse, 0, i);
            }
        }

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
