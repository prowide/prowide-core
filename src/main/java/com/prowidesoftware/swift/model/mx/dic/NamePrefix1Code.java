
package com.prowidesoftware.swift.model.mx.dic;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 */
@XmlType(name = "NamePrefix1Code")
@XmlEnum
public enum NamePrefix1Code {


    /**
     * Title of the person is Doctor or Dr.
     * 
     */
    DOCT,

    /**
     * Title of the person is Mister or Mr.
     * 
     */
    MIST,

    /**
     * Title of the person is Miss.
     * 
     */
    MISS,

    /**
     * Title of the person is Madam.
     * 
     */
    MADM;

    public String value() {
        return name();
    }

    public static NamePrefix1Code fromValue(String v) {
        return valueOf(v);
    }

}
