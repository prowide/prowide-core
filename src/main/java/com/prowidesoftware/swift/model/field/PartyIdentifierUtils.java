package com.prowidesoftware.swift.model.field;

import org.apache.commons.lang3.StringUtils;

public class PartyIdentifierUtils {

    /**
     * Builds a party identifier string in the form {@code /CD/ACCOUNT} from the given field components.
     * If only the CD component is present (no account), an extra trailing slash is appended so that the CD
     * is not misinterpreted as an account number.
     *
     * @param field            the field containing the components
     * @param cdComponent      index of the CD (credit/debit) component
     * @param accountComponent index of the account component
     * @return the party identifier string or null if both components are blank
     */
    public static String getPartyIdentifier(Field field, int cdComponent, int accountComponent) {

        // get the components
        String cd = StringUtils.trimToNull(field.getComponent(cdComponent));
        String account = StringUtils.trimToNull(field.getComponent(accountComponent));

        // build the parts (prepend a slash if part is not null)
        String cdPart = cd != null ? "/" + cd : null;
        String accountPart = account != null ? "/" + account : null;

        // if we have a CD but not an account, we need the extra "/" so that CD is not mistaken as account
        if (cdPart != null && accountPart == null) {
            accountPart = "/";
        }

        // build the party identifier
        return StringUtils.trimToNull((cdPart != null ? cdPart : "") + (accountPart != null ? accountPart : ""));
    }

    /**
     * Sets the CD and account components of the given field from a party identifier string in the form
     * {@code /CD/ACCOUNT} or {@code /ACCOUNT}.
     * If the party identifier is null, does not start with {@code /}, or is otherwise invalid,
     * both components are cleared.
     *
     * @param field            the field to update
     * @param cdComponent      index of the CD (credit/debit) component
     * @param accountComponent index of the account component
     * @param partyIdentifier  the party identifier to parse and set
     * @return the modified field
     */
    public static Field setPartyIdentifier(Field field, int cdComponent, int accountComponent, String partyIdentifier) {

        // if party identifier is null or does not start with a "/" => set to empty
        partyIdentifier = StringUtils.trimToNull(partyIdentifier);
        if (partyIdentifier == null || !partyIdentifier.startsWith("/")) {
            field.setComponent(cdComponent, null);
            field.setComponent(accountComponent, null);
            return field;
        }

        // if we have a dcMark => separate, ELSE => set account and empty dcMark
        String dcMark = SwiftParseUtils.getTokenFirst(partyIdentifier, "/", "/");
        if (StringUtils.isNotEmpty(dcMark)) {
            field.setComponent(cdComponent, dcMark);
            field.setComponent(
                    accountComponent,
                    SwiftParseUtils.getTokenSecondLast(StringUtils.substring(partyIdentifier, 1), "/"));
        } else {
            field.setComponent(cdComponent, null);
            field.setComponent(accountComponent, StringUtils.substring(partyIdentifier, 1));
        }

        return field;
    }
}
