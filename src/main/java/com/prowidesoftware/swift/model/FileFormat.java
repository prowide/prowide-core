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

import com.prowidesoftware.deprecation.ProwideDeprecated;
import com.prowidesoftware.deprecation.TargetYear;

/**
 * Supported file formats in the {@link AbstractSwiftMessage} hierarchy.
 *
 * @author sebastian
 * @since 7.8.4
 */
public enum FileFormat {
    /**
     * SWIFT FIN message format
     */
    FIN("fin"),
    /**
     * Prowide CORE XML format
     */
    CORE_XML("xml"),
    /**
     * @deprecated undefined and unused file format
     */
    @ProwideDeprecated(phase3 = TargetYear.SRU2025)
    MQ_MT("mt"),
    /**
     * Only valid for MT.
     * Remote Job Entry
     */
    RJE("rje"),
    /**
     * MX format
     */
    MX("xml"),
    /**
     * Applies to both MT and MX
     */
    XML_V2("xml"),
    /**
     * Prowide default JSON formats for both MT and MX
     */
    JSON("json");

    private final String extension;

    FileFormat(String extension) {
        this.extension = extension;
    }

    public String extension() {
        return this.extension;
    }

    public String label() {
        return "file-format." + name();
    }
}
