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

import com.prowidesoftware.ProwideException;
import com.prowidesoftware.swift.io.writer.FINWriterVisitor;
import com.prowidesoftware.swift.model.MtSwiftMessage;
import com.prowidesoftware.swift.model.SwiftBlock2Output;
import com.prowidesoftware.swift.model.SwiftMessage;
import com.prowidesoftware.swift.model.SwiftTagListBlock;
import com.prowidesoftware.swift.model.field.Field27;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import com.prowidesoftware.swift.model.mt.mt7xx.MT798;
import java.io.IOException;
import java.io.StringReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SwiftParserTest {

    @Test
    public void test103_1() throws IOException {
        String messageToParse =
                "{1:F01FOOBARYYAXXX1234123456}{2:O1030803051028AAPBESMMAXXX54237368560510280803N}{3:{113:NOMF}{108:0510280086100057}{119:STP}}{4:\n"
                        + ":20:D051026EUR100057\n"
                        + ":13C:/RNCTIME/0802+0000\n"
                        + ":23B:CRED\n"
                        + ":32A:051028EUR6740,91\n"
                        + ":33B:EUR6740,91\n"
                        + ":50A:SSSSESMMXXX\n"
                        + ":53A:BBBBESMMXXX\n"
                        + ":57A:FOOBARYYXXX\n"
                        + ":59:/ES0123456789012345671234\n"
                        + "FOOOOO 1000 FOOBAR S.A.\n"
                        + ":70:REDEMPTS. TRADEDATE 2222-10-26\n"
                        + "/123123123: FOOVIMAR 2000 FOOBAR\n"
                        + ":71A:SHA\n"
                        + "-}{5:{MAC:D9D8FA56}{CHK:46E46A6460F2}}";

        SwiftMessage m = new SwiftParser(messageToParse).message();

        assertEquals("103", m.getType());

        // check b1
        assertEquals("F01FOOBARYYAXXX1234123456", m.getBlock1().getBlockValue());
        assertEquals("F", m.getBlock1().getApplicationId());
        assertEquals("01", m.getBlock1().getServiceId());
        assertEquals("FOOBARYYAXXX", m.getBlock1().getLogicalTerminal());
        assertEquals("1234", m.getBlock1().getSessionNumber());
        assertEquals("123456", m.getBlock1().getSequenceNumber());

        // check b2
        assertEquals(
                "O1030803051028AAPBESMMAXXX54237368560510280803N", m.getBlock2().getBlockValue());
        assertEquals("103", m.getBlock2().getMessageType());
        assertEquals("0803", ((SwiftBlock2Output) m.getBlock2()).getSenderInputTime());
        assertEquals("051028", ((SwiftBlock2Output) m.getBlock2()).getMIRDate());
        assertEquals("AAPBESMMAXXX", ((SwiftBlock2Output) m.getBlock2()).getMIRLogicalTerminal());
        assertEquals("5423", ((SwiftBlock2Output) m.getBlock2()).getMIRSessionNumber());
        assertEquals("736856", ((SwiftBlock2Output) m.getBlock2()).getMIRSequenceNumber());
        assertEquals("051028AAPBESMMAXXX5423736856", ((SwiftBlock2Output) m.getBlock2()).getMIR());
        assertEquals("051028", ((SwiftBlock2Output) m.getBlock2()).getReceiverOutputDate());
        assertEquals("0803", ((SwiftBlock2Output) m.getBlock2()).getReceiverOutputTime());
        assertEquals("N", m.getBlock2().getMessagePriority());

        // check b3
        assertEquals(3, m.getBlock3().countAll());
        assertEquals("NOMF", m.getBlock3().getTagValue("113"));
        assertEquals("0510280086100057", m.getBlock3().getTagValue("108"));
        assertEquals("STP", m.getBlock3().getTagValue("119"));

        // check b4
        assertEquals(11, m.getBlock4().countAll());
        assertEquals("D051026EUR100057", m.getBlock4().getTagValue("20"));
        assertEquals("/RNCTIME/0802+0000", m.getBlock4().getTagValue("13C"));
        assertEquals("CRED", m.getBlock4().getTagValue("23B"));
        assertEquals("051028EUR6740,91", m.getBlock4().getTagValue("32A"));
        assertEquals("EUR6740,91", m.getBlock4().getTagValue("33B"));
        assertEquals("SSSSESMMXXX", m.getBlock4().getTagValue("50A"));
        assertEquals("BBBBESMMXXX", m.getBlock4().getTagValue("53A"));
        assertEquals("FOOBARYYXXX", m.getBlock4().getTagValue("57A"));
        assertEquals(
                "/ES0123456789012345671234\n" + "FOOOOO 1000 FOOBAR S.A.",
                m.getBlock4().getTagValue("59"));
        assertEquals(
                "REDEMPTS. TRADEDATE 2222-10-26\n" + "/123123123: FOOVIMAR 2000 FOOBAR",
                m.getBlock4().getTagValue("70"));
        assertEquals("SHA", m.getBlock4().getTagValue("71A"));

        // check b5
        assertEquals(2, m.getBlock5().countAll());
        assertEquals("D9D8FA56", m.getBlock5().getTagValue("MAC"));
        assertEquals("46E46A6460F2", m.getBlock5().getTagValue("CHK"));
    }

    @Test
    public void test103_2() throws IOException {
        String messageToParse =
                "{1:F01FOOBARYYAXXX1234123456}{2:O1030803051028AAPBESMMAXXX54237368560510280803N}{3:{113:NOMF}{108:0510280086100057}{119:STP}}{4:\n"
                        + ":20:D051026EUR100057\n"
                        + ":13C:/RNCTIME/0802+0000\n"
                        + ":23B:CRED\n"
                        + ":32A:051028EUR6740,91\n"
                        + ":33B:EUR6740,91\n"
                        + ":50A:SSSSESMMXXX\n"
                        + ":53A:BBBBESMMXXX\n"
                        + ":57A:FOOBARYYXXX\n"
                        + ":59:/ES0123456789012345671234\n"
                        + "FOOOOO 1000 FOOBAR S.A.\n"
                        + ":70:REDEMPTS. TRADEDATE 2222-10-26\n"
                        + "/123123123: FOOVIMAR 2000 FOOBAR\n"
                        + ":71A:SHA\n"
                        + "-}{5:{MAC:D9D8FA56}{CHK:46E46A6460F2}}";

        SwiftMessage m = SwiftMessage.parse(messageToParse);

        assertEquals("103", m.getType());

        // check b1
        assertEquals("F01FOOBARYYAXXX1234123456", m.getBlock1().getBlockValue());
        assertEquals("F", m.getBlock1().getApplicationId());
        assertEquals("01", m.getBlock1().getServiceId());
        assertEquals("FOOBARYYAXXX", m.getBlock1().getLogicalTerminal());
        assertEquals("1234", m.getBlock1().getSessionNumber());
        assertEquals("123456", m.getBlock1().getSequenceNumber());

        // check b2
        assertEquals(
                "O1030803051028AAPBESMMAXXX54237368560510280803N", m.getBlock2().getBlockValue());
        assertEquals("103", m.getBlock2().getMessageType());
        assertEquals("0803", ((SwiftBlock2Output) m.getBlock2()).getSenderInputTime());
        assertEquals("051028", ((SwiftBlock2Output) m.getBlock2()).getMIRDate());
        assertEquals("AAPBESMMAXXX", ((SwiftBlock2Output) m.getBlock2()).getMIRLogicalTerminal());
        assertEquals("5423", ((SwiftBlock2Output) m.getBlock2()).getMIRSessionNumber());
        assertEquals("736856", ((SwiftBlock2Output) m.getBlock2()).getMIRSequenceNumber());
        assertEquals("051028AAPBESMMAXXX5423736856", ((SwiftBlock2Output) m.getBlock2()).getMIR());
        assertEquals("051028", ((SwiftBlock2Output) m.getBlock2()).getReceiverOutputDate());
        assertEquals("0803", ((SwiftBlock2Output) m.getBlock2()).getReceiverOutputTime());
        assertEquals("N", m.getBlock2().getMessagePriority());

        // check b3
        assertEquals(3, m.getBlock3().countAll());
        assertEquals("NOMF", m.getBlock3().getTagValue("113"));
        assertEquals("0510280086100057", m.getBlock3().getTagValue("108"));
        assertEquals("STP", m.getBlock3().getTagValue("119"));

        // check b4
        assertEquals(11, m.getBlock4().countAll());
        assertEquals("D051026EUR100057", m.getBlock4().getTagValue("20"));
        assertEquals("/RNCTIME/0802+0000", m.getBlock4().getTagValue("13C"));
        assertEquals("CRED", m.getBlock4().getTagValue("23B"));
        assertEquals("051028EUR6740,91", m.getBlock4().getTagValue("32A"));
        assertEquals("EUR6740,91", m.getBlock4().getTagValue("33B"));
        assertEquals("SSSSESMMXXX", m.getBlock4().getTagValue("50A"));
        assertEquals("BBBBESMMXXX", m.getBlock4().getTagValue("53A"));
        assertEquals("FOOBARYYXXX", m.getBlock4().getTagValue("57A"));
        assertEquals(
                "/ES0123456789012345671234\n" + "FOOOOO 1000 FOOBAR S.A.",
                m.getBlock4().getTagValue("59"));
        assertEquals(
                "REDEMPTS. TRADEDATE 2222-10-26\n" + "/123123123: FOOVIMAR 2000 FOOBAR",
                m.getBlock4().getTagValue("70"));
        assertEquals("SHA", m.getBlock4().getTagValue("71A"));

        // check b5
        assertEquals(2, m.getBlock5().countAll());
        assertEquals("D9D8FA56", m.getBlock5().getTagValue("MAC"));
        assertEquals("46E46A6460F2", m.getBlock5().getTagValue("CHK"));
    }

    @Test
    public void testPatchWalterBirch() throws IOException {
        final String fin = "{1:F01VONTCHZZAXXX7586415286}{2:I202CHASUS33XXXXN}{3:{108:129324618/1XXXXX}}{4:"
                + FINWriterVisitor.SWIFT_EOL + ":20:129324618/1XXXXX"
                + FINWriterVisitor.SWIFT_EOL + ":21:NONREF"
                + FINWriterVisitor.SWIFT_EOL + ":32A:110705USD20079,39"
                + FINWriterVisitor.SWIFT_EOL + ":57A:CITIUS33XXX"
                + FINWriterVisitor.SWIFT_EOL + ":58A:NBSZCHZZXXX"
                + FINWriterVisitor.SWIFT_EOL + ":72:/BNF/30.05.11 10000"
                + FINWriterVisitor.SWIFT_EOL + ""
                + FINWriterVisitor.SWIFT_EOL + "-}{5:{CHK:88C7BBB37D50}}";
        final SwiftParser p = new SwiftParser(new StringReader(fin));
        final SwiftMessage msg = p.message();
        assertNotNull(msg.getBlock1());
        assertNotNull(msg.getBlock4());
        assertEquals(
                6,
                msg.getBlock4().size(),
                "Expected 6 tags but found " + msg.getBlock4().size() + ", "
                        + msg.getBlock4().tagNamesList());
    }

    @Test
    public void testAck1() throws Exception {
        final String msg =
                "{1:F21OMFNCIABAXXX6368087500}{4:{177:1511041614}{451:0}}{1:F01OMFNCIABAXXX6368087500}{2:O1031542151104BCAOSNDPAXXX22438129121511041542N}{3:{113:0030}{108:001RTGS153030005}}{4:\n"
                        + ":20:1234567890\n"
                        + ":23B:CRED\n"
                        + ":23E:SDVA\n"
                        + ":26T:001\n"
                        + ":32A:151104XOF27000000,\n"
                        + ":50K:/0020121503484101\n"
                        + "SOXNYFAYTONU VORYEAUGEIS\n"
                        + ":53A:/D/D00030901\n"
                        + "ECOCMLBA\n"
                        + ":57A:/C/A00031061\n"
                        + "OMFNCIAB\n"
                        + ":59:/010010100100014010010160\n"
                        + "FOO VOYAGES\n"
                        + ":70:TRANSFERT\n"
                        + ":71A:SHA\n"
                        + ":72:/CODTYPTR/001\n"
                        + "//REGLEMENT\n"
                        + "-}{5:{MAC:00000000}{CHK:0AF226411593}}{S:{SPD:}{SAC:}{COP:P}}";
        SwiftMessage sm = new SwiftParser(msg).message();
        assertNotNull(sm);
        assertTrue(sm.isAck());
    }

    @Test
    public void testAck2() throws Exception {
        final String msg =
                "{1:F21OMFNCIABAXXX6368087504}{4:{177:1511041718}{451:0}}{1:F01OMFNCIABAXXX6368087504}{2:O1031746151104CCEICMCXAXXX64953042471511041646N}{4:\n"
                        + ":20:1234567890\n"
                        + ":23B:CRED\n"
                        + ":32A:151104XOF14773500,\n"
                        + ":50K:/00057 03363591001 84\n"
                        + "FOO SARL \n"
                        + "AKWA, FACE ANCIEN DIRECTION NOBRA\n"
                        + "BP 1432 DOURAZLA\n"
                        + "237 CAMEROUN\n"
                        + ":57A:CBAOSNDA\n"
                        + ":59:/SN 012 01201 036169011401 63\n"
                        + "TSAEMOXU FOO INTERUNATIONALE SARL\n"
                        + "DIAMNIADO, DAKAR\n"
                        + "SENEGAL\n"
                        + ":70:/INV/TFI-ZS-15002\n"
                        + ":71A:SHA\n"
                        + "-}{5:{MAC:00000000}{CHK:50085EDF60EC}}{S:{SPD:}{SAC:}{COP:P}}";
        SwiftMessage sm = new SwiftParser(msg).message();
        assertNotNull(sm);
        assertTrue(sm.isAck());
    }

    /**
     * Extra data simple
     */
    @Test
    public void testExtraDataSimple() throws IOException {
        final String fin = "{1:F01MOSWRUMMAXXX0000000000}{2:I103COBADEFFXXXXN}{3:{108:02161OKP00130914}}{4:\n"
                + ":20:12345677890\n"
                + ":23B:CRED\n"
                + ":32A:160217EUR500,\n"
                + ":50K:/42301978502050100067\n"
                + "SHEPTUKHA VIKTORIA PAS45 15 362057\n"
                + "CCC MOSCOW MOSCOW UL. AVIACIONNAYA\n"
                + "DON. 99 KV. 123\n"
                + ":52D:BANK OF MOSCOW\n"
                + ":57A:CAIXESBBXXX\n"
                + ":59:/ES3021000122390200002631\n"
                + "FOO TRADE SL SPAIN CASTELLO D E\n"
                + "FOO PLACA JOC DE LA PILOTA , NU\n"
                + "M 1\n"
                + ":70:PAYMENT FOR NALOG ZA APARTAMENT\n"
                + ":71A:OUR\n"
                + ":72:/ACC/UR LIZO BBBB ))))))))::::::\n"
                + "-}foo";
        SwiftParser p = new SwiftParser(fin);
        SwiftMessage m = p.message();
        assertNotEquals(0, (int) m.getUnparsedTextsSize());
    }

    /**
     * Expected extra "}}}}" reported as error
     */
    @Test
    public void testExtraData() throws IOException {
        final String fin =
                "{1:F01MOSWRUMMAXXX0000000000}{2:I103COBADEFFXXXXN}{3:{108:02161OKP00130914}}{4:\n" + ":20:1234567890\n"
                        + ":23B:CRED\n"
                        + ":32A:160217EUR500,\n"
                        + ":50K:/42301978502050100067\n"
                        + "FOO VIKTORIA PAS45 15 362057\n"
                        + "CCC MOSCOW MOSCOW UL. FOO\n"
                        + "DON. 13 KV. 131\n"
                        + ":52D:BANK OF MOSCOW\n"
                        + ":57A:CAIXESBBXXX\n"
                        + ":59:/ES3021000122390200002631\n"
                        + "FOO TRADE SL SPAIN CASTELLO D E\n"
                        + "FOO PLACA JOC DE LA PILOTA , NU\n"
                        + "M 1\n"
                        + ":70:PAYMENT FOR NALOG ZA APARTAMENT\n"
                        + ":71A:OUR\n"
                        + ":72:/ACC/UR LIZO BBBB ))))))))::::::\n"
                        + "-}}}}}";
        SwiftParser p = new SwiftParser(fin);
        SwiftMessage m = p.message();
        assertNotEquals(0, (int) m.getUnparsedTextsSize());
    }

    /*
     * https://sourceforge.net/p/wife/bugs/80/
     */
    @Test
    public void testParse() throws IOException {
        final String fin = "{1:F01TESTAR00AXXX7607663781}{2:O1010824170510TESTAR00AXXX94149133901705101425N}{4:\n"
                + ":20:DG942_171206-004\n"
                + ":28D:00001/00001\n"
                + ":50H:/344110001637\n"
                + "TESTAR00AXXX\n"
                + "Utrecht\n"
                + "Netherlands\n"
                + ":30:170502\n"
                + ":21:010735904\n"
                + ":32B:CNY14,00\n"
                + ":57A:CIBKCNBJ473\n"
                + ":59:/344110000361\n"
                + "CASH CUSTOMER I\n"
                + "TESTAR00AXXX\n"
                + "Utrecht\n"
                + "Netherlands\n"
                + ":70:/RFB/C767405OCP021001\n"
                + ":71A:SHA\n"
                + "-}{5:{CHK:B3BF0D846AFD}}";
        SwiftMessage msg = new SwiftParser(fin).message();
        assertNotNull(msg);
        assertNotNull(msg.getBlock1());
        assertNotNull(msg.getBlock2());
        assertNotNull(msg.getBlock4());
        assertNotNull(msg.getBlock5());
        assertEquals("TESTAR00AXXX", msg.getBlock1().getLogicalTerminal());
        assertEquals("101", msg.getBlock2().getMessageType());
        assertEquals("DG942_171206-004", msg.getBlock4().getFieldByName("20").getValue());
    }

    @Test
    public void testEmptyLines() throws IOException {
        String fin = "{1:F01TESTARZZAXXX0000000000}{2:I199TESTARZZXXXXN}{4:\n" + ":20:1111\n"
                + "\n"
                + ":21:2222\n"
                + "\r\n"
                + ":59:3333\r\n4444\r\n"
                + ":79:5555\r6666\n"
                + ":72:7777\n\r\n\n\r\n\n"
                + "-}";
        SwiftMessage sm = SwiftMessage.parse(fin);
        assertEquals("1111\n", sm.getBlock4().getTagByName("20").getValue());
        assertEquals("2222\n", sm.getBlock4().getTagByName("21").getValue());
        assertEquals("3333\r\n4444", sm.getBlock4().getTagByName("59").getValue());
        assertEquals("5555\r6666", sm.getBlock4().getTagByName("79").getValue());
        assertEquals("7777\n\r\n\n\r\n", sm.getBlock4().getTagByName("72").getValue());
    }

    @Test
    void
            reproduce_parse_stringWithNonsenseHeadersButUsefulContentBlock_returnsNullForHeadersAndValidValuesFieldsInContent() {
        MtSwiftMessage msg = MtSwiftMessage.parse(
                "Big blue sea{4:\n" + ":20:123456789\n" + ":77E:\n" + ":15A:\n" + ":27:3/5\n" + "-}dark green forrest");
        // We simply claim that this is an MT798, and it works!
        MT798 mt798 = new MT798(msg);
        assertEquals("798", mt798.getMessageType());
        // Submessage type is null, as expected
        assertNull(mt798.getField12());
        // The content of block 4 is available
        SwiftTagListBlock contentMessage = mt798.getSwiftMessage().getBlock4().getSubBlockAfterFirst("77E", false);

        Field27 field27 = (Field27) contentMessage.getFieldByName("27");
        assertEquals(3, field27.getNumberAsLong());
        assertEquals(5, field27.getTotalAsLong());
        assertNull(contentMessage.getFieldByName("52A"));
    }

    @Test
    void testParseInvalidPayload() throws IOException {
        SwiftMessage msg = SwiftMessage.parse("foo bar");
        assertNull(msg.getBlock1());
        assertNull(msg.getBlock2());
        assertNull(msg.getBlock3());
        assertNull(msg.getBlock4());
        assertNull(msg.getBlock5());
        assertNull(msg.getUserBlocks());

        // Although we may wrap it as an MT
        MT103 mt103 = new MT103(msg);

        // thew MT content is null
        assertNull(mt103.getField20());
        assertNull(mt103.getField32A());
    }

    @Test
    void testParseEmptyContent() throws IOException {
        SwiftMessage msg = SwiftMessage.parse("");
        assertNull(msg.getBlock1());
        assertNull(msg.getBlock2());
        assertNull(msg.getBlock3());
        assertNull(msg.getBlock4());
        assertNull(msg.getBlock5());
        assertNull(msg.getUserBlocks());

        // Although we may wrap it as an MT
        MT103 mt103 = new MT103(msg);

        // thew MT content is null
        assertNull(mt103.getField20());
        assertNull(mt103.getField32A());
    }

    @Test
    void testParseInvalidHeader() throws IOException {
        SwiftMessage msg = SwiftMessage.parse(
                "Big blue sea{4:\n" + ":20:123456789\n" + ":77E:\n" + ":15A:\n" + ":27:3/5\n" + "-}dark green forrest");

        // Still cast to a specific type
        MT798 mt798 = new MT798(msg);

        assertEquals("798", mt798.getMessageType());

        // missing field is null, as expected
        assertNull(mt798.getField12());

        // The content of block 4 is still available
        assertEquals("123456789", mt798.getField20().getValue());

        SwiftTagListBlock contentMessage = mt798.getSwiftMessage().getBlock4().getSubBlockAfterFirst("77E", false);

        Field27 field27 = (Field27) contentMessage.getFieldByName("27");
        assertEquals(3, field27.getNumberAsLong());
        assertEquals(5, field27.getTotalAsLong());
        assertNull(contentMessage.getFieldByName("52A"));
    }

    @Test
    void test_parse_system_message_MT094_from_String_lenient_true() throws IOException {
        String fin_MT094 = "{1:F01AAAACNBJBXXX1010000000}{2:O0941836210827NXNXXXXX0XXX00080000012345678911S}\n"
                + "{4:{135:N}{136:X12345}{130:/01/BANK\n"
                + "/01/XXXXXYYYYYX}{134:FOOABHBX\n"
                + "ABCDFGGH N.A.\n"
                + "ABCANA}{312:SUBJECT: xxxx XXXX AAA AASX YXYXY FOR SSS YXYXYXYX-XXX YXYX\n"
                + "XXXXXX YYY YYYYYYY TO FFF WWWWW REF X00000000 ON 00\n"
                + "XXX0000 YYY XXXXX YXYXYXY CODES YXYXYX FOR IPSUM LOERM\n"
                + "S YSYSY XXXX XXXX,THE XXXXX OF THE XXXXXX IPSUM AAA\n"
                + "XXXX XXX XXX MXXXAY XXXX IN XXX AND XXXX.}}{\n"
                + // unexpected LF
                "5:{CHK:123456789123}{SYS:1234567891XXXXXX1YYXXX1234567894}}";
        SwiftParser parser = new SwiftParser(fin_MT094);
        SwiftParserConfiguration configuration = new SwiftParserConfiguration();
        configuration.setLenient(true);
        parser.setConfiguration(configuration);
        parser.message();

        String errorMessage =
                "The block \n" + "5:{CHK:123456789123}{SYS:1234567891XXXXXX1YYXXX1234567894} could not be identified";
        assertEquals(parser.getErrors().size(), 1);
        assertEquals(parser.getErrors().get(0), errorMessage);
    }

    @Test
    void test_parse_system_message_MT094_from_String_lenient_false() {
        String fin_MT094 = "{1:F01AAAACNBJBXXX1010000000}{2:O0941836210827NXNXXXXX0XXX00080000012345678911S}\n"
                + "{4:{135:N}{136:X12345}{130:/01/BANK\n"
                + "/01/XXXXXYYYYYX}{134:FOOABHBX\n"
                + "ABCDFGGH N.A.\n"
                + "ABCANA}{312:SUBJECT: xxxx XXXX AAA AASX YXYXY FOR SSS YXYXYXYX-XXX YXYX\n"
                + "XXXXXX YYY YYYYYYY TO FFF WWWWW REF X00000000 ON 00\n"
                + "XXX0000 YYY XXXXX YXYXYXY CODES YXYXYX FOR IPSUM LOERM\n"
                + "S YSYSY XXXX XXXX,THE XXXXX OF THE XXXXXX IPSUM AAA\n"
                + "XXXX XXX XXX MXXXAY XXXX IN XXX AND XXXX.}}{\n"
                + // unexpected LF
                "5:{CHK:123456789123}{SYS:1234567891XXXXXX1YYXXX1234567894}}";
        SwiftParser parser = new SwiftParser(fin_MT094);
        SwiftParserConfiguration configuration = new SwiftParserConfiguration();
        configuration.setLenient(false);
        parser.setConfiguration(configuration);

        Assertions.assertThrows(ProwideException.class, parser::message);
    }
}
