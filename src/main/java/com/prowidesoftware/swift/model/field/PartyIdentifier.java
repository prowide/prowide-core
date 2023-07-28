package com.prowidesoftware.swift.model.field;

/**
 * Field with a Party Identifier.
 *
 * <p>This interface provides convenience methods to set/get the Party Identifier by relying in
 * the underlying components
 */
public interface PartyIdentifier {

    /**
     * Get the formatted Party Identifier (CD Mark + Account)
     *
     * The Party Indentifier has the following format:
     *
     * <code>[/{cd-mark}]/{account}</code>
     *
     * @return the formatted Party Identifier
     */
    String getPartyIdentifier();

    /**
     * Set the formatted Party Identifier (CD Mark + Account)
     *
     * The Party Indentifier has the following format:
     *
     * <code>[/{cd-mark}]/{account}</code>
     *
     * If the format is not valid
     * @param partyIdentifier the formatted Party Identifier to set
     * @return the current OptionAPartyField
     */
    PartyIdentifier setPartyIdentifier(String partyIdentifier);
}
