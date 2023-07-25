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

/**
 * Full qualified names for fields used in block 5.
 * <p>This list is not comprehensive, it just contains the most commonly used fields int he trailer block.
 *
 * @since 8.0.2
 */
public enum SwiftBlock5Field {
    MAC(
            "Message Authentication Code calculated based on the entire contents of the message using a pre-exchanged key and a secret algorithm."),
    CHK("Checksum calculated for all message types."),
    PDE("Possible Duplicate Emission added if user thinks the same message was sent previously."),
    PDM(
            "Possible Duplicate Message added to any output message being resent because a prior delivery may not be valid."),
    DLM(
            "Delayed Message added if the message has not been delivered within the expected minutes according to the message priority."),
    MRF("The Message Reference specifies the reference of the original user message."),
    TNG("Test & Training Message, only in test and training mode"),
    SYS("System Originated Message added for system message or service message, cotaining the MIR of the request.");

    private final String description;

    SwiftBlock5Field(String description) {
        this.description = description;
    }

    public String description() {
        return this.description;
    }
}
