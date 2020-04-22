package com.prowidesoftware.swift.model.mx;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
final class MockMsg extends AbstractMX {
    private String content;

    @SuppressWarnings("rawtypes")
    @Override
    public Class[] getClasses() {
        return new Class[]{MockMsg.class};
    }

    @Override
    public String getNamespace() {
        return "foo:namespace";
    }

    @Override
    public String getBusinessProcess() {
        return null;
    }

    @Override
    public int getFunctionality() {
        return 0;
    }

    @Override
    public int getVariant() {
        return 0;
    }

    @Override
    public int getVersion() {
        return 0;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String message() {
        return null;
    }

}