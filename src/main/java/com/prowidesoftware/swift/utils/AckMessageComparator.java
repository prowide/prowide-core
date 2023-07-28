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
package com.prowidesoftware.swift.utils;

/**
 * A {@link SwiftMessageComparator} tailored for typical ACK matching using the full original message copy.
 *
 * <p>Compares all values from block 1 2 3 and 4, ignoring session and sequence number in block1. The trailer block 5
 * if present in any of the messages is also ignored. Regarding multiline fields the EOL must be an exact match
 * (meaning CRLF is not the same as just LF). And for block 2 Input, the optional fields for the Delivery Monitoring
 * and Obsolescence Period are ignored during comparison.
 *
 * <p>For ACK matching based on the MUR, see {@link MurMessageComparator}
 */
public class AckMessageComparator extends SwiftMessageComparator {

    public AckMessageComparator() {
        super.ignoreEolsInMultiline = true;
        super.ignoreTrailer = true;
        super.ignoreHeaderSession = true;
        super.ignoreBlock2OptionalFields = true;
    }
}
