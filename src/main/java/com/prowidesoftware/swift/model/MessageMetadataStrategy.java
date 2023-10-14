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
package com.prowidesoftware.swift.model;

import java.util.Calendar;
import java.util.Optional;

/**
 * A strategy to extract specific properties of an MT or MX message.
 * Used when an {@link MtSwiftMessage} or Mx message is created or updated.
 *
 * <p>Enables injecting your own implementation for the entity metadata extraction, to set the generic properties
 * shared by all message types: main reference, main amount and currency, value date, trade date.
 *
 * @since 9.1.4
 */
public interface MessageMetadataStrategy {

    /**
     * Extracts the message main reference (available in most message types)
     */
    Optional<String> reference(AbstractMessage message);

    /**
     * Extracts the message main amount (only meaningful for some types of messages)
     */
    Optional<Money> amount(AbstractMessage message);

    /**
     * Extracts the message value date (only meaningful for some types of messages)
     */
    Optional<Calendar> valueDate(AbstractMessage message);

    /**
     * Extracts the message trade date (only meaningful for some types of messages)
     */
    Optional<Calendar> tradeDate(AbstractMessage message);

    /**
     * Extracts the sender information from the message.
     * This default implementation returns empty.
     * @since 9.3.19
     */
    default Optional<String> sender(AbstractMessage message) {
        return Optional.empty();
    }

    /**
     * Extracts the receiver information from the message.
     * This default implementation returns empty.
     * @since 9.3.19
     */
    default Optional<String> receiver(AbstractMessage message) {
        return Optional.empty();
    }

    /**
     * Extracts the identifier from the message.
     * This default implementation returns empty.
     * @since 9.3.19
     */
    default Optional<String> identifier(AbstractMessage message) {
        return Optional.empty();
    }
}
