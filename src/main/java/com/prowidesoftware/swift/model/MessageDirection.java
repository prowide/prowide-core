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
 * Message direction from SWIFT perspective.
 *
 * <p>A message direction is Input when it is sent to SWIFT, meaning it is and outbound message from the application.
 * Conversely, a message direction is Output when it is received from SWIFT, meaning it is and inbound message for the
 * application.</p>
 *
 * @since 9.1.2
 */
public enum MessageDirection {
    Input,
    Output
}
