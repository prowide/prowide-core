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
package com.prowidesoftware.swift.model.field;

/**
 * Interface to mark generic fields and add method related to DSS and qualifiers.
 *
 * @since 6.4
 */
public interface GenericField {
    /**
     * Returns the issuer code (or Data Source Scheme or DSS).
     * The DSS is only present in some generic fields, when present, is equals to component two.
     *
     * @return DSS component value or null if the DSS is not set or not available for this field.
     */
    String getDSS();

    /**
     * Checks if the issuer code (or Data Source Scheme or DSS) is present.
     *
     * @return true if DSS is present, false otherwise.
     * @see #getDSS()
     */
    boolean isDSSPresent();

    /**
     * Gets the conditional (secondary) qualifier.
     *
     * <p>In generic fields this is normally the component following the DSS or the double slash separator when the
     * field does not has a DSS component; so in most cases this method returns either 2 or 3 depending if the field
     * contains a DSS component or not. For some specific fields the conditionally qualifier could be something
     * different, for example in fields 69D and 92H it is the component 4.
     *
     * @return for generic fields returns the value of the conditional qualifier or null if not set or not applicable for this field.
     */
    String getConditionalQualifier();
}
