package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

import java.util.*;

/**
 * Party
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * 		<li><code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>parser pattern: <code>:S/[S]/S/S/S</code></li>
 * 		<li>components pattern: <code>SSSKS</code></li>
 * </ul>
 *
 * @since 7.11.0
 */
public abstract class OptionSPartyField extends Field {
    public static final String PARSER_PATTERN =":S/[S]/S/S/S";
    public static final String COMPONENTS_PATTERN = "SSSKS";

    /**
     * Component number for the Qualifier subfield
     */
    public static final Integer QUALIFIER = 1;

    /**
     * Component number for the Data Source Scheme subfield
     */
    public static final Integer DATA_SOURCE_SCHEME = 2;

    /**
     * Component number for the Type Of ID subfield
     */
    public static final Integer TYPE_OF_ID = 3;

    /**
     * Component number for the Country Code subfield
     */
    public static final Integer COUNTRY_CODE = 4;

    /**
     * Component number for the Alternate ID subfield
     */
    public static final Integer ALTERNATE_ID = 5;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public OptionSPartyField() {
        super(5);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public OptionSPartyField(final String value) {
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
        init(5);
        setComponent(1, SwiftParseUtils.getTokenFirst(value, ":", "/"));
        setComponent(2, SwiftParseUtils.getTokenSecond(value, "/"));
        setComponent(3, SwiftParseUtils.getTokenThird(value, "/"));
        String toparse = SwiftParseUtils.getTokenForthLast(value, "/");
        setComponent(4, SwiftParseUtils.getTokenFirst(toparse, "/"));
        setComponent(5, SwiftParseUtils.getTokenSecondLast(toparse, "/"));
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        result.append(":");
        append(result, 1);
        result.append("/");
        append(result, 2);
        result.append("/");
        append(result, 3);
        result.append("/");
        append(result, 4);
        result.append("/");
        append(result, 5);
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
        if (component < 1 || component > 5) {
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
        if (component == 2) {
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
        return 5;
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
        result.add("Data Source Scheme");
        result.add("Type Of ID");
        result.add("Country Code");
        result.add("Alternate ID");
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
        result.put(2, "dataSourceScheme");
        result.put(3, "typeOfID");
        result.put(4, "countryCode");
        result.put(5, "alternateID");
        return result;
    }

    /**
     * @return the specific field name (number and letter option)
     */
    @Override
    public abstract String getName();

    /**
     * Gets the component1 (Qualifier).
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
     * Gets the Qualifier (component1).
     * @return the Qualifier from component1
     */
    public String getQualifier() {
        return getComponent(1);
    }
    /**
     * Gets the component2 (Data Source Scheme).
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
     * Gets the Data Source Scheme (component2).
     * @return the Data Source Scheme from component2
     */
    public String getDataSourceScheme() {
        return getComponent(2);
    }
    /**
     * Gets the component3 (Type Of ID).
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
     * Gets the Type Of ID (component3).
     * @return the Type Of ID from component3
     */
    public String getTypeOfID() {
        return getComponent(3);
    }
    /**
     * Gets the component4 (Country Code).
     * @return the component4
     */
    public String getComponent4() {
        return getComponent(4);
    }

    /**
     * Gets the Country Code (component4).
     * @return the Country Code from component4
     */
    public String getCountryCode() {
        return getComponent(4);
    }
    /**
     * Gets the component5 (Alternate ID).
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
     * Gets the Alternate ID (component5).
     * @return the Alternate ID from component5
     */
    public String getAlternateID() {
        return getComponent(5);
    }

}
