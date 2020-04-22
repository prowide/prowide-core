package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import org.apache.commons.lang3.StringUtils;

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
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>parser pattern: <code>:S//S[$S]0-2</code></li>
 * 		<li>components pattern: <code>SSSS</code></li>
 * </ul>
 *
 * @since 7.11.0
 */
public abstract class OptionUPartyField extends Field {
    public static final String PARSER_PATTERN =":S//S[$S]0-2";
    public static final String COMPONENTS_PATTERN = "SSSS";

    /**
     * Component number for the Qualifier subfield
     */
    public static final Integer QUALIFIER = 1;

    /**
     * Component number for the Party Name subfield
     */
    public static final Integer PARTY_NAME = 2;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public OptionUPartyField() {
        super(4);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public OptionUPartyField(final String value) {
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
        init(4);
        List<String> lines = SwiftParseUtils.getLines(value);
        if (!lines.isEmpty()) {
            setComponent(1, SwiftParseUtils.getTokenFirst(lines.get(0), ":", "//"));
            setComponent(2, SwiftParseUtils.getTokenSecond(lines.get(0), "//"));
        }
        SwiftParseUtils.setComponentsFromLines(this, 3, null, 1, lines);
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
        appendInLines(result, 3, 4);
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
            throw new IllegalArgumentException("invalid component number "+component+" for field "+getName());
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
        if (component == 3) {
            return true;
        }
        if (component == 4) {
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
        result.add("Qualifier");
        result.add("Party Name");
        result.add("Party Name 2");
        result.add("Party Name 3");
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
        result.put(2, "partyName");
        result.put(3, "partyName2");
        result.put(4, "partyName3");
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
     * Gets the component2 (Party Name).
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
     * Gets the Party Name (component2).
     * @return the Party Name from component2
     */
    public String getPartyNameLine1() {
        return getComponent(2);
    }

    /**
     * Gets the Party Name (component3).
     * @return the Party Name from component3
     */
    public String getPartyNameLine2() {
        return getComponent(3);
    }

    /**
     * Gets the Party Name (component4).
     * @return the Party Name from component4
     */
    public String getPartyNameLine3() {
        return getComponent(4);
    }

    /**
     * Gets the Party Name as a concatenation of component2 to component4.
     * @return the Party Name from components
     */
    public String getPartyName() {
        StringBuilder result = new StringBuilder();
        for (int i = 2 ; i < 5 ; i++) {
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
     * Gets the component3 (Party Name).
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
     * Gets the component4 (Party Name).
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

}
