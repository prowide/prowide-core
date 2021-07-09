/*
 * Copyright 2006-2021 Prowide
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

/**
 * Official variants for MT messages (not including closed user groups version of messages)
 *
 * @author sebastian
 * @since 7.8
 */
public enum MTVariant {
    STP(true),
    REMIT(true),
    COV(true);

    boolean validationFlag = false;

    MTVariant(boolean validationFlag) {
        this.validationFlag = validationFlag;
    }

    /**
     * returns true if the variant is also a validation flag used in the user header block
     */
    public boolean isValidationFlag() {
        return this.validationFlag;
    }
}
