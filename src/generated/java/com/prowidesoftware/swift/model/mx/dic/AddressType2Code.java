
/*
 * Copyright 2006-2018 Prowide
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

package com.prowidesoftware.swift.model.mx.dic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlType(name = "AddressType2Code")
@XmlEnum
public enum AddressType2Code {


    /**
     * Address is the complete postal address.
     * 
     */
    ADDR,

    /**
     * Address is a postal office (PO) box.
     * 
     */
    PBOX,

    /**
     * Address is the home address.
     * 
     */
    HOME,

    /**
     * Address is the business address.
     * 
     */
    BIZZ,

    /**
     * Address is the address to which mail is sent.
     * 
     */
    MLTO,

    /**
     * Address is the address to which delivery is to take place.
     * 
     */
    DLVY;

    public String value() {
        return name();
    }

    public static AddressType2Code fromValue(String v) {
        return valueOf(v);
    }

}
