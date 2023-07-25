package com.prowidesoftware.swift.model.field;

import org.apache.commons.lang3.StringUtils;

public class PartyIdentifierUtils {

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
