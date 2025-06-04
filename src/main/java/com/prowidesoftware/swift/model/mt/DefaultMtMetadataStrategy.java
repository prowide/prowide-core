/*
 * Copyright 2006-2023 Prowide
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
package com.prowidesoftware.swift.model.mt;

import com.prowidesoftware.swift.model.*;
import java.util.Calendar;
import java.util.Optional;

/**
 * Default implementation of MT messages metadata extraction.
 *
 * <p>
 * The implementation uses the utility methods from {@link SwiftMessageUtils} to extract the metadata from the MT
 * messages, including support for acknowledgements (ACKs) and negative acknowledgements (NAKs).
 *
 * @see SwiftMessageUtils
 * @since 9.1.4
 */
public class DefaultMtMetadataStrategy implements MessageMetadataStrategy {

    private static final java.util.logging.Logger log =
            java.util.logging.Logger.getLogger(DefaultMtMetadataStrategy.class.getName());

    /**
     * Extracts the MT main reference using {@link SwiftMessageUtils#reference(SwiftMessage)}
     */
    @Override
    public Optional<String> reference(AbstractMessage message) {
        return Optional.ofNullable(SwiftMessageUtils.reference(asSwiftMessage(message)));
    }

    /**
     * Extracts the MT main amount, if present, using {@link SwiftMessageUtils#money(SwiftMessage)}
     */
    @Override
    public Optional<Money> amount(AbstractMessage message) {
        return Optional.ofNullable(SwiftMessageUtils.money(asSwiftMessage(message)));
    }

    /**
     * Extracts the MT value date, if any, using {@link SwiftMessageUtils#valueDate(SwiftMessage)}
     */
    @Override
    public Optional<Calendar> valueDate(AbstractMessage message) {
        return Optional.ofNullable(SwiftMessageUtils.valueDate(asSwiftMessage(message)));
    }

    /**
     * Extracts the MT trade date, if any, using {@link SwiftMessageUtils#tradeDate(SwiftMessage)}
     */
    @Override
    public Optional<Calendar> tradeDate(AbstractMessage message) {
        return Optional.ofNullable(SwiftMessageUtils.tradeDate(asSwiftMessage(message)));
    }

    /**
     * Extracts the MT sender, if present, using {@link SwiftMessageUtils#sender(SwiftMessage)}
     * When found, returns the BIC11 format of the sender LT address.
     */
    @Override
    public Optional<String> sender(AbstractMessage message) {
        final String sender = SwiftMessageUtils.sender(asSwiftMessage(message));
        return getBIC(sender);
    }

    /**
     * Extracts the MT receiver, if any, using {@link SwiftMessageUtils#receiver(SwiftMessage)}
     * When found, returns the BIC11 format of the receiver LT address.
     */
    @Override
    public Optional<String> receiver(AbstractMessage message) {
        final String receiver = SwiftMessageUtils.receiver(asSwiftMessage(message));
        return getBIC(receiver);
    }

    /**
     *
     * @param inputBIC the BIC to validate and convert to BIC11 format
     * @return the BIC11 format of the input BIC, if valid, or an empty Optional if the input is null or invalid.
     */
    private static Optional<String> getBIC(String inputBIC) {
        if (inputBIC != null) {
            BIC bic = new BIC(inputBIC);
            if (bic.isValid()) {
                return Optional.of(bic.getBic11());
            } else {
                log.fine("Invalid BIC: " + inputBIC);
            }
        }
        return Optional.empty();
    }

    /**
     * Extracts the MT identifier, if any, using {@link SwiftMessageUtils#identifier(SwiftMessage)}
     */
    @Override
    public Optional<String> identifier(AbstractMessage message) {
        return Optional.ofNullable(SwiftMessageUtils.identifier(asSwiftMessage(message)));
    }

    private SwiftMessage asSwiftMessage(AbstractMessage message) {
        if (message != null && message.isMT()) {
            AbstractMT mt = (AbstractMT) message;
            return mt.getSwiftMessage();
        }
        return null;
    }
}
