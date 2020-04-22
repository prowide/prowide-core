
package com.prowidesoftware.swift.model.mx.dic;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.prowidesoftware.CopyableTo;
import com.prowidesoftware.Generated;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * The application header is the first element of the RequestPayload element. The payload contains the document which contains the business document. This may be an ISO 20022 message or a SWIFT proprietary message.
 * 
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ApplicationHeader", propOrder = {
    "from",
    "to",
    "svcName",
    "msgName",
    "msgRef",
    "crDate",
    "dup"
})
@Generated
public class ApplicationHeader implements CopyableTo<ApplicationHeader>
{

    @XmlElement(name = "From")
    protected EntityIdentification from;
    @XmlElement(name = "To")
    protected EntityIdentification to;
    @XmlElement(name = "SvcName")
    protected String svcName;
    @XmlElement(name = "MsgName")
    protected String msgName;
    @XmlElement(name = "MsgRef", required = true)
    protected String msgRef;
    @XmlElement(name = "CrDate", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar crDate;
    @XmlElement(name = "Dup")
    protected DuplicateIndication dup;

    /**
     * Gets the value of the from property.
     * 
     * @return
     *     possible object is
     *     {@link EntityIdentification }
     *     
     */
    public EntityIdentification getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityIdentification }
     *     
     */
    public ApplicationHeader setFrom(EntityIdentification value) {
        this.from = value;
        return this;
    }

    /**
     * Gets the value of the to property.
     * 
     * @return
     *     possible object is
     *     {@link EntityIdentification }
     *     
     */
    public EntityIdentification getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     * @param value
     *     allowed object is
     *     {@link EntityIdentification }
     *     
     */
    public ApplicationHeader setTo(EntityIdentification value) {
        this.to = value;
        return this;
    }

    /**
     * Gets the value of the svcName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSvcName() {
        return svcName;
    }

    /**
     * Sets the value of the svcName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ApplicationHeader setSvcName(String value) {
        this.svcName = value;
        return this;
    }

    /**
     * Gets the value of the msgName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgName() {
        return msgName;
    }

    /**
     * Sets the value of the msgName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ApplicationHeader setMsgName(String value) {
        this.msgName = value;
        return this;
    }

    /**
     * Gets the value of the msgRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgRef() {
        return msgRef;
    }

    /**
     * Sets the value of the msgRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public ApplicationHeader setMsgRef(String value) {
        this.msgRef = value;
        return this;
    }

    /**
     * Gets the value of the crDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getCrDate() {
        return crDate;
    }

    /**
     * Sets the value of the crDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public ApplicationHeader setCrDate(XMLGregorianCalendar value) {
        this.crDate = value;
        return this;
    }

    /**
     * Gets the value of the dup property.
     * 
     * @return
     *     possible object is
     *     {@link DuplicateIndication }
     *     
     */
    public DuplicateIndication getDup() {
        return dup;
    }

    /**
     * Sets the value of the dup property.
     * 
     * @param value
     *     allowed object is
     *     {@link DuplicateIndication }
     *     
     */
    public ApplicationHeader setDup(DuplicateIndication value) {
        this.dup = value;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

    @Override
    public boolean equals(Object that) {
        return EqualsBuilder.reflectionEquals(this, that);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    public final void copyTo(final ApplicationHeader target) {
        EntityIdentification fromTarget = new EntityIdentification();
        from.copyTo(fromTarget);
        target.from = fromTarget;
        EntityIdentification toTarget = new EntityIdentification();
        to.copyTo(toTarget);
        target.to = toTarget;
        target.svcName = svcName;
        target.msgName = msgName;
        target.msgRef = msgRef;
        // debug: XMLGregorianCalendar does not implement copyTo
        target.crDate = crDate;
        DuplicateIndication dupTarget = new DuplicateIndication();
        dup.copyTo(dupTarget);
        target.dup = dupTarget;
    }

}
