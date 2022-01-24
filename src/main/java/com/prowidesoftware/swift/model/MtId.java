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
package com.prowidesoftware.swift.model;

import com.prowidesoftware.swift.model.mt.MTVariant;
import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

/**
 * Structured identification of MT message types, composed by the business process, actual type and variant.
 * <br>
 * The business process is currently set to a fixed value "fin", however it is kept as
 * class attribute because eventually could be used also for "apc".
 *
 * @author sebastian
 * @since 7.8.4
 */
public class MtId {
    private String businessProcess = "fin";
    private String messageType;
    private String variant;

    /**
     * @since @since 8.0.3
     */
    public MtId() {
    }

    /**
     * Parses a string identifier into a structured MT identifier
     * @param identifier an identifier such as 103, fin.103, fin.103.STP, 202.COV
     * @since 7.8.6
     */
    public MtId(String identifier) {
        this();
        if (identifier != null) {
            this.messageType = identifier.replaceAll("\\D+", "");

            if (StringUtils.isNotBlank(this.messageType)) {
                // if message type was extracted, we try to extract the variant as well
                MTVariant variant = MTVariant.extract(identifier).orElse(null);
                if (variant != null) {
                    this.variant = variant.name();
                }
            } else {
                // otherwise we just use the parameter as type
                this.messageType = identifier;
            }
        }
    }

    /**
     * @param messageType the message type number (optionally prefixed with "fin.")
     * @param variant     An MT variant (STP, REMIT, COV), a MUG identifier or null if none applies
     */
    public MtId(String messageType, String variant) {
        if (StringUtils.startsWith(messageType, "fin.")) {
            this.messageType = StringUtils.substringAfter(messageType, "fin.");
        } else {
            this.messageType = messageType;
        }
        this.variant = variant;
    }

    /**
     * @param messageType the message type number
     * @param variant     a message variant (STP, REMIT, COV) or null if none applies
     */
    public MtId(String messageType, MTVariant variant) {
        this(messageType, variant != null ? variant.name() : null);
    }

    /**
     * Parses a string identifier into a structured MT identifier
     * @param identifier an identifier such as 103, fin.103, fin.103.STP, 202.COV
     * @since 9.1.8
     */
    public static MtId parse(final String identifier) {
        return new MtId(identifier);
    }

    public String getBusinessProcess() {
        return businessProcess;
    }

    /**
     * @since 8.0.3 returns this
     */
    public MtId setBusinessProcess(String businessProcess) {
        this.businessProcess = businessProcess;
        return this;
    }

    public String getMessageType() {
        return messageType;
    }

    /**
     * @since 8.0.3 returns this
     */
    public MtId setMessageType(String messageType) {
        this.messageType = messageType;
        return this;
    }

    public String getVariant() {
        return variant;
    }

    /**
     * @since 8.0.3 returns this
     */
    public MtId setVariant(String variant) {
        this.variant = variant;
        return this;
    }

    /**
     * @since 9.2.6
     */
    public MtId setVariant(MTVariant variant) {
        this.variant = variant.name();
        return this;
    }

    @Override
    public String toString() {
        return id();
    }

    /**
     * Get a string in the form of businessprocess.messagetype.variant
     *
     * @return a string with the MT message type identification
     * @since 7.8.4
     */
    public String id() {
        final StringBuilder sb = new StringBuilder();
        if (businessProcess != null) {
            sb.append(businessProcess);
        } else {
            return null;
        }
        if (messageType != null) {
            sb.append("." + messageType);
        } else {
            return null;
        }
        if (variant != null) {
            sb.append("." + variant);
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MtId mtId = (MtId) o;
        return Objects.equals(businessProcess, mtId.businessProcess) &&
                Objects.equals(messageType, mtId.messageType) &&
                Objects.equals(variant, mtId.variant);
    }

    @Override
    public int hashCode() {
        return Objects.hash(businessProcess, messageType, variant);
    }

    /**
     * Returns the first number in the message type, representing the message category.
     * For example for 103 returns 1
     *
     * @return the message category number or empty if the message type is invalid or not present
     * @since 7.10.4
     */
    public String category() {
        if (messageType != null && messageType.length() > 0) {
            char cat = messageType.charAt(0);
            if (Character.isDigit(cat)) {
                return String.valueOf(cat);
            }
        }
        return "";
    }

}
