package com.prowidesoftware.swift.model.field;

import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

/**
 * Party Identification
 *
 * <p>Subfields (components) Data types
 * <ol>
 * 		<li><code>String</code></li>
 * </ol>
 *
 * <p>Structure definition
 * <ul>
 * 		<li>parser pattern: <code>S</code></li>
 * 		<li>components pattern: <code>S</code></li>
 * </ul>
 *
 * @since 7.11.0
 */
public abstract class OptionJPartyField extends Field {
    public static final String PARSER_PATTERN ="S";
    public static final String COMPONENTS_PATTERN = "S";

    /**
     * @since 7.11.0
     */
    public enum Codeword {
        ABIC,
        NAME,
        ACCT,
        ADD1,
        ADD2,
        CITY,
        USFW,
        USCH,
        GBSC,
        CLRC,
        NETS,
        SSIS,
        LEIC,
        TXID,
        NOSI,
        SVBY;
    }

    /**
     * Component number for the Party Identification subfield
     */
    public static final Integer PARTY_IDENTIFICATION = 1;

    /**
     * Default constructor. Creates a new field setting all components to null.
     */
    public OptionJPartyField() {
        super(1);
    }

    /**
     * Creates a new field and initializes its components with content from the parameter value.
     * @param value complete field value including separators and CRLF
     */
    public OptionJPartyField(final String value) {
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
        init(1);
        setComponent(1, value);
    }

    /**
     * Serializes the fields' components into the single string value (SWIFT format)
     */
    @Override
    public String getValue() {
        final StringBuilder result = new StringBuilder();
        append(result, 1);
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
        if (component < 1 || component > 1) {
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
        return 1;
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
        result.add("Party Identification");
        return result;
    }

    /**
     * Returns a mapping between component numbers and their label in camel case format.
     * @since 7.10.3
     */
    @Override
    protected Map<Integer, String> getComponentMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(1, "partyIdentification");
        return result;
    }

    /**
     * @return the specific field name (number and letter option)
     */
    @Override
    public abstract String getName();

    /**
     * Gets the component1 (Party Identification).
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
     * Gets the Party Identification (component1).
     * @return the Party Identification from component1
     */
    public String getPartyIdentification() {
        return getComponent(1);
    }

    /**
     * Returns the value following the parameter codeword or null if the codeword or its following value are not found.
     *
     * <p>For {@link Codeword#NETS} or {@link Codeword#SSIS} it will always return null, because those codewords cannot
     * be followed by a value. Breaking lines are ignored, meaning both codewords and values split along lines will be
     * joined before processing.
     *
     * @param codeword a valid codeword to search
     * @return found value following the codeword or null if the codeword or its value are not found
     * @since 7.11.0
     */
    public String getValueByCodeword(Codeword codeword) {
        // some codewords does not have a mandatory format
        if (codeword == Codeword.NETS || codeword == Codeword.SSIS) {
            return null;
        }
        String join = StringUtils.replace(StringUtils.replace(getComponent1(), "\r", ""), "\n", "");
        final String[] tokens = StringUtils.split(join, "/");
        for (int i = 0; i < tokens.length; i++) {
            final String code = tokens[i];
            if (!StringUtils.equals(code, Codeword.NETS.name()) && !StringUtils.equals(code, Codeword.SSIS.name())) {
                i++;
                if (i < tokens.length && StringUtils.equals(code, codeword.name())) {
                    return tokens[i];
                }
            }
        }
        return null;
    }

}