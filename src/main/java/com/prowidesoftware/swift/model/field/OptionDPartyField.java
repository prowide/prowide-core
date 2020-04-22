package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * Name & Address
 *
 * <p>Subfields (components) Data types
 * <ol>
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
 * 		<li>parser pattern: <code>[[/c][/S]$]S[$S]0-3</code></li>
 * 		<li>components pattern: <code>SSSSSS</code></li>
 * </ul>
 *
 * @since 7.11.0
 */
public abstract class OptionDPartyField extends Field {
    public static final String PARSER_PATTERN ="[[/c][/S]$]S[$S]0-3";
    public static final String COMPONENTS_PATTERN = "SSSSSS";

    /**
     * Component number for the D/C Mark subfield
     */
    public static final Integer DC_MARK = 1;

    /**
     * Component number for the Account subfield
     */
    public static final Integer ACCOUNT = 2;

    /**
     * Component number for the Name And Address subfield
     */
    public static final Integer NAME_AND_ADDRESS = 3;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public OptionDPartyField() {
        super(6);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public OptionDPartyField(final String value) {
        super(value);
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
        init(6);
        List<String> lines = SwiftParseUtils.getLines(value);
        if (lines.isEmpty()) {
            return;
        }
        if (lines.get(0).startsWith("/")) {
            String party = lines.get(0);
            if (party.length() >= 3 && party.charAt(1) != '/' && party.charAt(2) == '/') {
                setComponent(1, String.valueOf(party.charAt(1)));
                setComponent(2, StringUtils.substring(party, 3));
            } else {
                setComponent(2, StringUtils.substring(party, 1));
            }
            SwiftParseUtils.setComponentsFromLines(this, 3, null, 1, lines);
        } else {
            SwiftParseUtils.setComponentsFromLines(this, 3, null, 0, lines);
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
        if (getComponent2() != null) {
            result.append("/").append(getComponent2());
        }
        appendInLines(result, 3, 6);
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
        if (component < 1 || component > 6) {
            throw new IllegalArgumentException("invalid component number "+component+" for field "+ getName());
        }
        //default format (as is)
        return getComponent(component);
    }

    /**
     * Returns the field components pattern
     * @return the static value of COMPONENTS_PATTERN
     */
    @Override
    public final String componentsPattern() {
        return COMPONENTS_PATTERN;
    }

    /**
     * Returns the field parser pattern
     * @return the static value of PARSER_PATTERN
     */
    @Override
    public final String parserPattern() {
        return PARSER_PATTERN;
    }

    /**
     * Returns the field validator pattern, that could vary er specific field
     */
    @Override
    public abstract String validatorPattern();

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
        if (component == 2) {
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
        return 6;
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
        result.add("D/C Mark");
        result.add("Account");
        result.add("Name And Address");
        result.add("Name And Address 2");
        result.add("Name And Address 3");
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
        result.put(1, "dCMark");
        result.put(2, "account");
        result.put(3, "nameAndAddress");
        result.put(4, "nameAndAddress2");
        result.put(5, "nameAndAddress3");
        result.put(6, "nameAndAddress4");
        return result;
    }

    /**
     * @return the specific field name (number and letter option)
     */
    @Override
    public abstract String getName();

    /**
     * Gets the component1 (D/C Mark).
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
    @ProwideDeprecated(phase4= TargetYear.SRU2020)
    public java.lang.String getComponent1AsString() {
        com.prowidesoftware.deprecation.DeprecationUtils.phase3(getClass(), "getComponent1AsString()", "Use use #getComponent(int) instead.");
        return getComponent(1);
    }

    /**
     * Gets the D/C Mark (component1).
     * @return the D/C Mark from component1
     */
    public String getDCMark() {
        return getComponent(1);
    }
    /**
     * Gets the component2 (Account).
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
     * Gets the Account (component2) removing its starting slashes if any.
     * @return the Account from component2
     */
    public String getAccount() {
        String c = getComponent(2);
        if (c != null) {
            for (int i=0; i<c.length(); i++) {
                if (c.charAt(i) != '/') {
                    return c.substring(i);
                }
            }
            return "";
        }
        return null;
    }
    /**
     * Gets the component3 (Name And Address).
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
     * Gets the Name And Address (component3).
     * @return the Name And Address from component3
     */
    public String getNameAndAddressLine1() {
        return getComponent(3);
    }

    /**
     * Gets the Name And Address (component4).
     * @return the Name And Address from component4
     */
    public String getNameAndAddressLine2() {
        return getComponent(4);
    }

    /**
     * Gets the Name And Address (component5).
     * @return the Name And Address from component5
     */
    public String getNameAndAddressLine3() {
        return getComponent(5);
    }

    /**
     * Gets the Name And Address (component6).
     * @return the Name And Address from component6
     */
    public String getNameAndAddressLine4() {
        return getComponent(6);
    }

    /**
     * Gets the Name And Address as a concatenation of component3 to component6.
     * @return the Name And Address from components
     */
    public String getNameAndAddress() {
        StringBuilder result = new StringBuilder();
        for (int i = 3 ; i < 7 ; i++) {
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
     * Gets the component4 (Name And Address).
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
     * Gets the component5 (Name And Address).
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
     * Gets the component6 (Name And Address).
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

}
