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
package com.prowidesoftware.swift.io.parser;

import static org.junit.jupiter.api.Assertions.*;

import com.prowidesoftware.swift.io.writer.FINWriterVisitor;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import com.prowidesoftware.swift.model.mt.mt7xx.MT767;
import com.prowidesoftware.swift.utils.SafeXmlUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilder;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

/**
 * Test cases for the Prowide Core proprietary XML format parser
 *
 * @since 4.0
 */
public class XMLParserTest {

    @Test
    public void testParse() {
        String xml = "<message>\n" + "<block1>\n"
                + "  <applicationId>F</applicationId>\n"
                + "  <serviceId>01</serviceId>\n"
                + "  <logicalTerminal>BANKBEBBAXXX</logicalTerminal>\n"
                + "  <sessionNumber>2222</sessionNumber>\n"
                + "  <sequenceNumber>123456</sequenceNumber>\n"
                + "</block1>\n"
                + "<block4>\n"
                + "  <tag>\n"
                + "    <name>t1</name>\n"
                + "    <value>v1</value>\n"
                + "  </tag>\n"
                + "</block4>\n"
                + "</message>";
        XMLParser p = new XMLParser();
        SwiftMessage m = p.parse(xml);
        assertNotNull(m);
    }

    @Test
    public void testParse2() {
        String xml = "<message>\n" + "<block1>\n"
                + "  <applicationId>F</applicationId>\n"
                + "  <serviceId>01</serviceId>\n"
                + "  <logicalTerminal>BANKBEBBAXXX</logicalTerminal>\n"
                + "  <sessionNumber>2222</sessionNumber>\n"
                + "  <sequenceNumber>123456</sequenceNumber>\n"
                + "</block1>\n"
                + "<block2 type=\"input\">\n"
                + "  <messageType>100</messageType>\n"
                + "  <receiverAddress>BANKDEFFXXXX</receiverAddress>\n"
                + "  <messagePriority>U</messagePriority>\n"
                + "  <deliveryMonitoring>3</deliveryMonitoring>\n"
                + "  <obsolescencePeriod>003</obsolescencePeriod>\n"
                + "</block2>\n"
                + "</message>";
        XMLParser p = new XMLParser();
        SwiftMessage m = p.parse(xml);
        assertNotNull(m);
    }

    @Test
    public void testParse3() {
        String xml = "<message>\n" + "<block1>\n"
                + "  <applicationId>F</applicationId>\n"
                + "  <serviceId>01</serviceId>\n"
                + "  <logicalTerminal>BANKBEBBAXXX</logicalTerminal>\n"
                + "  <sessionNumber>2222</sessionNumber>\n"
                + "  <sequenceNumber>123456</sequenceNumber>\n"
                + "</block1>\n"
                + "<block2 type=\"output\">\n"
                + "  <messageType>100</messageType>\n"
                + "  <senderInputTime>1200</senderInputTime>\n"
                + "  <MIRDate>970103</MIRDate>\n"
                + "  <MIRLogicalTerminal>BANKBEBBAXXX</MIRLogicalTerminal>\n"
                + "  <MIRSessionNumber>2222</MIRSessionNumber>\n"
                + "  <MIRSequenceNumber>123456</MIRSequenceNumber>\n"
                + "  <receiverOutputDate>970103</receiverOutputDate>\n"
                + "  <receiverOutputTime>1201</receiverOutputTime>\n"
                + "  <messagePriority>N</messagePriority>\n"
                + "</block2>\n"
                + "</message>";
        XMLParser p = new XMLParser();
        SwiftMessage m = p.parse(xml);
        assertNotNull(m);
    }

    /**
     * Test for w3 dom parsing behavior
     *
     */
    @Test
    public void testNode() throws SAXException, IOException {
        final String text = "<tag>line1\r\nline2</tag>";
        final DocumentBuilder db = SafeXmlUtils.documentBuilder();
        InputStream is = new ByteArrayInputStream(text.getBytes(StandardCharsets.UTF_8));
        final Document doc = db.parse(is);
        Node n = doc.getFirstChild();
        // this proves that DOM parser removes original carriage return characters from XML
        assertEquals("line1\nline2", n.getFirstChild().getNodeValue());
    }

    @Test
    public void testCRLF_replace() {
        String text = "aaa\nbbb";
        text = StringUtils.replace(text, "\n", FINWriterVisitor.SWIFT_EOL);
        assertEquals("aaa\r\nbbb", text);
    }

    @Test
    public void testNull() {
        String xml = "<message>\n" + "\n"
                + "<block1>\n"
                + "\n"
                + "  <applicationId>F</applicationId>\n"
                + "\n"
                + "  <serviceId>01</serviceId>\n"
                + "\n"
                + "  <logicalTerminal>CECAESMMA017</logicalTerminal>\n"
                + "\n"
                + "  <sessionNumber>0000</sessionNumber>\n"
                + "\n"
                + "  <sequenceNumber>000000</sequenceNumber>\n"
                + "\n"
                + "</block1>\n"
                + "\n"
                + "<block2 type=\"input\">\n"
                + "\n"
                + "  <messageType>320</messageType>\n"
                + "\n"
                + "  <receiverAddress>CAAMES2AXXXX</receiverAddress>\n"
                + "\n"
                + "  <messagePriority>N</messagePriority>\n"
                + "\n"
                + "</block2>\n"
                + "\n"
                + "<block4>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>15A</name>\n"
                + "\n"
                + "    <value></value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>20</name>\n"
                + "\n"
                + "    <value>00005586-090224</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>22A</name>\n"
                + "\n"
                + "    <value>NEWT</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>22B</name>\n"
                + "\n"
                + "    <value>CONF</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>22C</name>\n"
                + "\n"
                + "    <value>CAAM2A0001CECAMM</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>82A</name>\n"
                + "\n"
                + "    <value>CECAESMM017</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>87A</name>\n"
                + "\n"
                + "    <value>CAAMES2AXXX</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>15B</name>\n"
                + "\n"
                + "    <value></value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>17R</name>\n"
                + "\n"
                + "    <value>L</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>30T</name>\n"
                + "\n"
                + "    <value>20090224</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>30V</name>\n"
                + "\n"
                + "    <value>20090224</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>30P</name>\n"
                + "\n"
                + "    <value>20090225</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>32B</name>\n"
                + "\n"
                + "    <value>EUR111,00</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>30X</name>\n"
                + "\n"
                + "    <value>20090225</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>34E</name>\n"
                + "\n"
                + "    <value>NEUR0,00</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>37G</name>\n"
                + "\n"
                + "    <value>1,</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>14D</name>\n"
                + "\n"
                + "    <value>ACT/360</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>15C</name>\n"
                + "\n"
                + "    <value></value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>53A</name>\n"
                + "\n"
                + "    <value>CECAESMM017</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>58A</name>\n"
                + "\n"
                + "    <value>CAAMES2AXXX</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>15D</name>\n"
                + "\n"
                + "    <value></value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "  <tag>\n"
                + "\n"
                + "    <name>57A</name>\n"
                + "\n"
                + "    <value>CECAESMM017</value>\n"
                + "\n"
                + "  </tag>\n"
                + "\n"
                + "</block4>\n"
                + "\n"
                + "</message>";
        XMLParser p = new XMLParser();
        SwiftMessage m = p.parse(xml);
        assertNotNull(m);
    }

    @Test
    public void testFieldFormat() {
        String xml = "<message>\n" + "<block1>\n"
                + "  <applicationId>F</applicationId>\n"
                + "  <serviceId>01</serviceId>\n"
                + "  <logicalTerminal>TESTUS20AXXX</logicalTerminal>\n"
                + "  <sessionNumber>0816</sessionNumber>\n"
                + "  <sequenceNumber>000001</sequenceNumber>\n"
                + "</block1>\n"
                + "<block2 type=\"input\">\n"
                + "  <messageType>103</messageType>\n"
                + "  <receiverAddress>FOONUS33XXXX</receiverAddress>\n"
                + "  <messagePriority>N</messagePriority>\n"
                + "</block2>\n"
                + "<block4>\n"
                + "<field>\n"
                + "  <name>20</name>\n"
                + "  <component number=\"1\">prueba</component>\n"
                + "</field>\n"
                + "<field>\n"
                + "  <name>23B</name>\n"
                + "  <component number=\"1\">CRED</component>\n"
                + "</field>\n"
                + "<field>\n"
                + "  <name>32A</name>\n"
                + "  <component number=\"1\">160621</component>\n"
                + "  <component number=\"2\">USD</component>\n"
                + "  <component number=\"3\">123123,22</component>\n"
                + "</field>\n"
                + "<field>\n"
                + "  <name>50A</name>\n"
                + "  <component number=\"1\">234523452345345234</component>\n"
                + "  <component number=\"2\">CITIZAJXTRD</component>\n"
                + "</field>\n"
                + "<field>\n"
                + "  <name>52A</name>\n"
                + "  <component number=\"2\">23423421343</component>\n"
                + "  <component number=\"3\">ITAUKYKTXXX</component>\n"
                + "</field>\n"
                + "<field>\n"
                + "  <name>59A</name>\n"
                + "  <component number=\"1\">24523523452345</component>\n"
                + "  <component number=\"2\">HSBCVNVXXXX</component>\n"
                + "</field>\n"
                + "<field>\n"
                + "  <name>71A</name>\n"
                + "  <component number=\"1\">SHA</component>\n"
                + "</field>\n"
                + "</block4>\n"
                + "</message>";
        XMLParser p = new XMLParser();
        SwiftMessage m = p.parse(xml);
        assertNotNull(m);
        MT103 mt = new MT103(m);

        assertNotNull(mt.getField20());
        assertNotNull("prueba", mt.getField20().getComponent1());

        assertNotNull(mt.getField23B());
        assertNotNull("CRED", mt.getField23B().getComponent1());

        assertNotNull(mt.getField32A());
        assertNotNull("160621", mt.getField32A().getComponent1());
        assertNotNull("USD", mt.getField32A().getComponent1());
        assertNotNull("123123,22", mt.getField32A().getComponent1());

        assertNotNull(mt.getField50A());
        assertNotNull("234523452345345234", mt.getField50A().getComponent1());
        assertNotNull("CITIZAJXTRD", mt.getField50A().getComponent1());

        assertNotNull(mt.getField52A());
        assertNotNull("23423421343", mt.getField52A().getComponent2());
        assertNotNull("ITAUKYKTXXX", mt.getField52A().getComponent3());

        assertNotNull(mt.getField59A());
        assertNotNull("24523523452345", mt.getField59A().getComponent1());
        assertNotNull("HSBCVNVXXXX", mt.getField59A().getComponent2());

        assertNotNull(mt.getField71A());
        assertNotNull("SHA", mt.getField71A().getComponent1());
    }

    @Test
    public void testFieldFormatEscaped() {
        String xml = "<message>\n" + "   <block1>\n"
                + "      <applicationId>F</applicationId>\n"
                + "      <serviceId>01</serviceId>\n"
                + "      <logicalTerminal>FOOPGB20A36A</logicalTerminal>\n"
                + "   </block1>\n"
                + "   <block2 type=\"input\">\n"
                + "      <messageType>767</messageType>\n"
                + "      <receiverAddress>FOOLUS60AXXX</receiverAddress>\n"
                + "      <messagePriority>N</messagePriority>\n"
                + "   </block2>\n"
                + "   <block4>\n"
                + "      <field>\n"
                + "         <name>15A</name>\n"
                + "      </field>\n"
                + "      <field>\n"
                + "         <name>27</name>\n"
                + "         <component number=\"1\">1</component>\n"
                + "         <component number=\"2\">1</component>\n"
                + "      </field>\n"
                + "      <field>\n"
                + "         <name>21</name>\n"
                + "         <component number=\"1\">RELTXN12345</component>\n"
                + "      </field>\n"
                + "      <field>\n"
                + "         <name>22A</name>\n"
                + "         <component number=\"1\">ICCA</component>\n"
                + "      </field>\n"
                + "      <field>\n"
                + "         <name>72Z</name>\n"
                + "         <component number=\"1\">&lt;Sender&gt; to &lt;Reciever&gt; message</component>\n"
                + "      </field>\n"
                + "      <field>\n"
                + "         <name>15B</name>\n"
                + "      </field>\n"
                + "      <field>\n"
                + "         <name>20</name>\n"
                + "         <component number=\"1\">PG8761234</component>\n"
                + "      </field>\n"
                + "      <field>\n"
                + "         <name>26E</name>\n"
                + "         <component number=\"1\">2</component>\n"
                + "      </field>\n"
                + "      <field>\n"
                + "         <name>30</name>\n"
                + "         <component number=\"1\">120501</component>\n"
                + "      </field>\n"
                + "      <field>\n"
                + "         <name>52A</name>\n"
                + "         <component number=\"3\">FOOPGB2L</component>\n"
                + "      </field>\n"
                + "      <field>\n"
                + "         <name>32B</name>\n"
                + "         <component number=\"1\">GBP</component>\n"
                + "         <component number=\"2\">38000,</component>\n"
                + "      </field>\n"
                + "      <field>\n"
                + "         <name>77U</name>\n"
                + "         <component number=\"1\">WE, NATIONAL WESTMINSTER BANK, LONDON, HEREBY UNDERTAKE\n"
                + "TO PAY TO YOU ANY SUM OR SUMS NOT EXCEEDING AN AGGREGATE OF USD\n"
                + "27,240,UNITED STATES DOLLARS TWENTY SEVEN THOUSAND TWO HUNDRED\n"
                + "AND FORTY), REPRESENTING 5 PCT OF THE TOTAL ORDER/CONTRACT PRICE\n"
                + "ON RECEIPT BY US AT THIS OFFICE OF YOUR FIRST DEMAND ON US IN\n"
                + "WRITING, COMPLYING WITH ALL THE REQUIREMENTS HEREOF, QUOTING\n"
                + "OUR REFERENCE OVERSEAS DIVISION GUARANTEE NO. PG8761234. THE\n"
                + "SIGNATURES APPEARING THEREON TO BE DULY CONFIRMED BY YOUR\n"
                + "BANKERS, STATING THE AMOUNT PAYABLE AND THAT SOUND AND IMAGE\n"
                + "HAVE FAILED TO PERFORM THE TERMS OF THE ORDER/CONTRACT NO.\n"
                + "S556VSF FOR THE SUPPLY OF A FILM THE VIDEO STORY\n"
                + "ALWAYS PROVIDED THAT\n"
                + "1. THIS UNDERTAKING IS PERSONAL TO YOU AND IS NOT ASSIGNABLE.\n"
                + "2. OUR LIABILITY HEREUNDER SHALL BE LIMITED TO A SUM OR SUMS\n"
                + "NOT EXCEEDING IN AGGREGATE USD 27,240 (UNITED STATES DOLLARS\n"
                + "TWENTY SEVEN THOUSAND TWO HUNDRED AND FORTY).\n"
                + "3. OUR LIABILITY IS VALID AS AT 1 JUNE 2012 AND SHALL EXPIRE\n"
                + "ON 31 MAY 2013 EXCEPT IN RESPECT OF ANY WRITTEN DEMANDS FOR\n"
                + "PAYMENT COMPLYING WITH ALL THE REQUIREMENTS HEREOF RECEIVED BY\n"
                + "US AT THIS OFFICE ON OR BEFORE 31 MAY 2013, AFTER WHICH DATE\n"
                + "THIS UNDERTAKING SHALL BECOME NULL AND VOID WHETHER RETURNED\n"
                + "TO US OR NOT.\n"
                + "4. OUR LIABILITY UNDER THIS UNDERTAKING SHALL BE REDUCED BY\n"
                + "ANY AMOUNTS DEMANDED IN ACCORDANCE WITH THE TERMS HEREOF.\n"
                + "5. THIS UNDERTAKING SHALL BE GOVERNED BY AND CONSTRUED ACCORDING\n"
                + "TO THE LAWS OF ENGLAND, THE COURTS OF WHICH COUNTRY SHALL HAVE\n"
                + "SOLE JURISDICTION TO ADJUDICATE ON ANY AND ALL CLAIMS DIRECTLY\n"
                + "OR INDIRECTLY RELATING HERETO AND YOUR ACCEPTANCE OF OUR\n"
                + "UNDERTAKING SHALL BE YOUR CONFIRMATION THAT YOU SUBMIT TO\n"
                + "THE JURISDICTION OF THE COURTS OF ENGLAND IN THIS REGARD.</component>\n"
                + "      </field>\n"
                + "      <field>\n"
                + "         <name>24G</name>\n"
                + "         <component number=\"1\">BENE</component>\n"
                + "      </field>\n"
                + "      <field>\n"
                + "         <name>15C</name>\n"
                + "      </field>\n"
                + "      <field>\n"
                + "         <name>32B</name>\n"
                + "         <component number=\"1\">GBP</component>\n"
                + "         <component number=\"2\">38000,</component>\n"
                + "      </field>\n"
                + "   </block4>\n"
                + "</message>\n";
        XMLParser p = new XMLParser();
        SwiftMessage m = p.parse(xml);
        assertNotNull(m);
        MT767 mt = new MT767(m);

        assertNotNull(mt.getField72Z());
        assertNotNull("<Sender> to <Reciever> message", mt.getField72Z().getComponent1());
    }

    /**
     * Test that external entities feature is disabled in the XML parsing to avoid XXE (external entity injection)
     */
    @Test
    public void testXxeDisabled() {
        String xml = "<!DOCTYPE foo [ <!ENTITY xxe SYSTEM \"file:///etc/passwd\" >]>" + "<message>\n"
                + "<block1>\n"
                + "  <serviceId>&xxe;</serviceId>\n"
                + "</block1>\n"
                + "<block4>\n"
                + "  <tag>\n"
                + "    <name>t1</name>\n"
                + "    <value>v1</value>\n"
                + "  </tag>\n"
                + "</block4>\n"
                + "</message>";
        XMLParser p = new XMLParser();
        SwiftMessage m = p.parse(xml);
        assertNull(m);
    }
}
