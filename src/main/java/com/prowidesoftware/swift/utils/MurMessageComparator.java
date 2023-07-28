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

import com.prowidesoftware.swift.model.SwiftMessage;
import java.util.Comparator;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

/**
 * Compares the messages based on the MUR.
 *
 * <p>The MUR is the Message User Reference used by applications for reconciliation with ACK. It is a free-format field
 * in which users may specify their own reference of up to 16 characters of the permitted character set.
 *
 * <p>In user-to-user messages the MUR is field 108 in the user header block (block 3) while for system messages
 * (category 0) the MUR when present it is field 108 in the text block (block 4).
 *
 * <p>This comparator is intended for ACK matching. When you compare a service message 21 with a user MT, as an
 * alternative to the {@link AckMessageComparator} that uses the full original message copy</p>
 *
 * @since 8.0.3
 */
public class MurMessageComparator implements Comparator<SwiftMessage> {

    /**
     * Compare the two given messages based on the MUR.
     *
     * @param left  a non-null message
     * @param right a non-null message
     */
    @Override
    public int compare(final SwiftMessage left, final SwiftMessage right) {
        Objects.requireNonNull(left);
        Objects.requireNonNull(right);
        return StringUtils.equals(left.getMUR(), right.getMUR()) ? 0 : 1;
    }
}
