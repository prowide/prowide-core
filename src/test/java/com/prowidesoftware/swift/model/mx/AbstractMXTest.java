package com.prowidesoftware.swift.model.mx;

import static org.junit.Assert.assertNotNull;

import javax.xml.bind.annotation.XmlRootElement;

import org.junit.Test;
import org.w3c.dom.Element;

public class AbstractMXTest {

	@Test
	public void testElement() {
		MockMsg m = new MockMsg();
		m.setContent("Hello World!");
		Element e = m.element();
		assertNotNull(e);
	}

}

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
	
}
