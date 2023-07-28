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

import java.util.UUID;

/**
 * Unique end-to-end transaction reference (UETR) generator.
 * <p>This unique reference is mandatory for GPI payment messages. For MT messages it is located in block 3 field 121.
 *
 * @since 9.1.4
 */
public class UETRUtils {

    /**
     * Creates a new random UETR compatible with MT block 3 field 121
     */
    public static String generate() {
        // we just use the Java UUID that is compatible with the SWIFT spec for UETR
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
