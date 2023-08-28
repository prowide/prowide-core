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
 * @see SwiftMessageUtils
 * @since 9.1.4
 */
public class DefaultMtMetadataStrategy implements MessageMetadataStrategy {

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
     */
    @Override
    public Optional<String> sender(AbstractMessage message) {
        return Optional.ofNullable(SwiftMessageUtils.sender(asSwiftMessage(message)));
    }

    /**
     * Extracts the MT receiver, if any, using {@link SwiftMessageUtils#receiver(SwiftMessage)}
     */
    @Override
    public Optional<String> receiver(AbstractMessage message) {
        return Optional.ofNullable(SwiftMessageUtils.receiver(asSwiftMessage(message)));
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
