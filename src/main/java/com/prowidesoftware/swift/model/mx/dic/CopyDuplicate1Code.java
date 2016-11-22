
package com.prowidesoftware.swift.model.mx.dic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlType(name = "CopyDuplicate1Code")
@XmlEnum
public enum CopyDuplicate1Code {


    /**
     * Message is being sent as a copy to a party other than the account owner, for information purposes and the message is a duplicate of a message previously sent.
     * 
     */
    CODU,

    /**
     * Message is being sent as a copy to a party other than the account owner, for information purposes.
     * 
     */
    COPY,

    /**
     * Message is for information/confirmation purposes. It is a duplicate of a message previously sent.
     * 
     */
    DUPL;

    public String value() {
        return name();
    }

    public static CopyDuplicate1Code fromValue(String v) {
        return valueOf(v);
    }

}
