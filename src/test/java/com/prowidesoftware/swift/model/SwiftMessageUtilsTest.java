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

import static com.prowidesoftware.swift.model.SwiftMessageUtils.calculateChecksum;
import static org.junit.jupiter.api.Assertions.*;

import com.prowidesoftware.swift.model.field.*;
import com.prowidesoftware.swift.model.mt.mt1xx.MT103;
import com.prowidesoftware.swift.model.mt.mt5xx.MT502;
import com.prowidesoftware.swift.model.mt.mt5xx.MT535;
import com.prowidesoftware.swift.model.mt.mt5xx.MT540;
import com.prowidesoftware.swift.model.mt.mt6xx.MT670;
import com.prowidesoftware.swift.utils.Lib;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;

public class SwiftMessageUtilsTest {

    @Test
    public void testSplitByField15() {
        final SwiftMessage sm = new SwiftMessage(true);
        sm.getBlock4().append(Field15B.emptyTag()).append(Field32A.emptyTag());
        final Map<String, SwiftTagListBlock> map = SwiftMessageUtils.splitByField15(sm);
        assertNotNull(map);
        assertTrue(map.containsKey("B"));
        final SwiftTagListBlock list = map.get("B");
        assertNotNull(list);
        assertEquals(2, list.size());
    }

    @Test
    public void testSplitByField15LetterOption() {
        final SwiftMessage sm = new SwiftMessage(true);
        sm.getBlock4()
                .append(Field15A.emptyTag())
                .append(Field33A.emptyTag())
                .append(Field15B.emptyTag())
                .append(Field32A.emptyTag())
                .append(Field15B.emptyTag())
                .append(Field32B.emptyTag())
                .append(Field32B.emptyTag());

        List<SwiftTagListBlock> Bs = SwiftMessageUtils.splitByField15(sm, "B");
        assertNotNull(Bs);
        assertEquals(2, Bs.size());

        final SwiftTagListBlock list0 = Bs.get(0);
        assertNotNull(list0);
        assertEquals(2, list0.size());

        final SwiftTagListBlock list1 = Bs.get(1);
        assertNotNull(list1);
        assertEquals(3, list1.size());
    }

    @Test
    public void testSplitByField15LetterOptionIntercalado() {
        final SwiftMessage sm = new SwiftMessage(true);
        sm.getBlock4()
                .append(Field15A.emptyTag())
                .append(Field33A.emptyTag())
                .append(Field15B.emptyTag())
                .append(Field15C.emptyTag())
                .append(Field32A.emptyTag())
                .append(Field15B.emptyTag())
                .append(Field32B.emptyTag())
                .append(Field32B.emptyTag());

        List<SwiftTagListBlock> Bs = SwiftMessageUtils.splitByField15(sm, "B");
        assertNotNull(Bs);
        assertEquals(2, Bs.size());

        final SwiftTagListBlock list0 = Bs.get(0);
        assertNotNull(list0);
        assertEquals(1, list0.size());

        final SwiftTagListBlock list1 = Bs.get(1);
        assertNotNull(list1);
        assertEquals(3, list1.size());
    }

    @Test
    public void testSplitByField15LetterOptionPrimero() {
        final SwiftMessage sm = new SwiftMessage(true);
        sm.getBlock4()
                .append(Field15A.emptyTag())
                .append(Field33A.emptyTag())
                .append(Field15B.emptyTag())
                .append(Field15C.emptyTag())
                .append(Field32A.emptyTag())
                .append(Field15B.emptyTag())
                .append(Field32B.emptyTag())
                .append(Field32B.emptyTag());

        List<SwiftTagListBlock> Bs = SwiftMessageUtils.splitByField15(sm, "A");
        assertNotNull(Bs);
        assertEquals(1, Bs.size());

        final SwiftTagListBlock list0 = Bs.get(0);
        assertNotNull(list0);
        assertEquals(2, list0.size());
    }

    @Test
    public void testSplitByField15LetterOptionUltimo() {
        final SwiftMessage sm = new SwiftMessage(true);
        sm.getBlock4()
                .append(Field15A.emptyTag())
                .append(Field33A.emptyTag())
                .append(Field15B.emptyTag())
                .append(Field15C.emptyTag())
                .append(Field32A.emptyTag())
                .append(Field15B.emptyTag())
                .append(Field32B.emptyTag())
                .append(Field32B.emptyTag())
                .append(Field15D.emptyTag())
                .append(Field34B.emptyTag())
                .append(Field34B.emptyTag())
                .append(Field34B.emptyTag())
                .append(Field34B.emptyTag());

        List<SwiftTagListBlock> Bs = SwiftMessageUtils.splitByField15(sm, "D");
        assertNotNull(Bs);
        assertEquals(1, Bs.size());

        final SwiftTagListBlock list0 = Bs.get(0);
        assertNotNull(list0);
        assertEquals(5, list0.size());
    }

    @Test
    public void testCreateSubsequenceWithParentsB_502() {
        SwiftTagListBlock o = SwiftMessageUtils.createSubsequenceWithParents(
                MT502.class, "B", Field13A.emptyTag(), Field13B.emptyTag(), Field13C.emptyTag());
        assertEquals(5, o.size());
    }

    @Test
    public void testCreateSubsequenceWithParentsA() {
        SwiftTagListBlock o = SwiftMessageUtils.createSubsequenceWithParents(MT535.class, "A", Field13A.emptyTag());
        assertEquals(3, o.size());
    }

    @Test
    public void testCreateSubsequenceWithParentsA1() {
        SwiftTagListBlock o = SwiftMessageUtils.createSubsequenceWithParents(MT535.class, "A1", Field13A.emptyTag());
        assertEquals(5, o.size());
    }

    @Test
    public void testCreateSubsequenceWithParentsA1_order() {
        SwiftTagListBlock o = SwiftMessageUtils.createSubsequenceWithParents(MT535.class, "A1", Field13A.emptyTag());
        assertEquals(5, o.size());
        assertEquals(MT535.SequenceA.START_END_16RS, o.getTag(0).getValue());
        assertEquals(Field16R.NAME, o.getTag(0).getName());

        assertEquals(MT535.SequenceA1.START_END_16RS, o.getTag(1).getValue());
        assertEquals(Field16R.NAME, o.getTag(1).getName());

        assertEquals("13A", o.getTag(2).getName());

        assertEquals(MT535.SequenceA1.START_END_16RS, o.getTag(3).getValue());
        assertEquals(Field16S.NAME, o.getTag(3).getName());

        assertEquals(MT535.SequenceA.START_END_16RS, o.getTag(4).getValue());
        assertEquals(Field16S.NAME, o.getTag(4).getName());
    }

    @Test
    public void testCreateSubsequenceWithParentsB1b1() {
        SwiftTagListBlock o = SwiftMessageUtils.createSubsequenceWithParents(MT535.class, "B1b1", Field13A.emptyTag());
        assertEquals(9, o.size());
    }

    @Test
    public void testRemoveInnerSequences() {
        MT535 m = new MT535()
                .append(MT535.SequenceA.newInstance(
                        MT535.SequenceA1.newInstance(Field13C.tag("foo1")).append(Field13C.tag("foo2"))));
        SwiftTagListBlock sublist = SwiftMessageUtils.removeInnerSequences(m.getSequenceA());

        assertEquals(3, sublist.size());
        assertEquals("foo2", sublist.getTag(1).getValue());
    }

    @Test
    public void testCurrencyAmountFromMessage() throws IOException {
        final String fin = "{1:F01CCRTIT2TX36A0000000000}{2:I101PPABPLPKXXXXN}{3:{108:YSGU193268223XXX}}{4:\n"
                + ":20:4C2W0S0V8AM6X7OH\n"
                + ":28D:00001/00001\n"
                + ":50H:/PL66160011270003012399999999\n"
                + "FOO\n"
                + ":30:131119\n"
                + ":21:ZCAR1HI1HF3STLJO\n"
                + ":32B:PLN2044,10\n"
                + ":59:/PL74175000090000000001905201\n"
                + "POLONIA FOO HOTEL\n"
                + "AL FOOLIMSKIE 45\n"
                + "00-692\n"
                + "PL WARSAWA\n"
                + ":70:1/34530/13\n"
                + ":71A:SHA\n"
                + "-}";
        Money money = SwiftMessageUtils.money(SwiftMessage.parse(fin));
        assertNotNull(money);
        assertEquals("PLN", money.getCurrency());
        assertEquals(new BigDecimal("2044.10"), money.getAmount());
    }

    @Test
    public void testCurrencyAmountFromSystemMessage() throws IOException {
        final String fin =
                "{1:F21BNPAFRPPZXXX0000000002}{4:{177:1702090741}{451:0}}{1:F01BNPAFRPPZXXX0000000002}{2:I103BNPAFRPPXXXXN}{3:{108:REF1}}{4:\n"
                        + ":20:WITHMUR\n"
                        + "-}{5:{MAC:ABCD1234}{CHK:ABCDEF123456}}";
        Money money = SwiftMessageUtils.money(SwiftMessage.parse(fin));
        assertNull(money);
    }

    @Test
    public void testValueDate() throws IOException, ParseException {

        // MT305
        SwiftMessage sm = SwiftMessage.parse(Lib.readResource("MT305.fin"));
        Calendar date = SwiftMessageUtils.valueDate(sm);
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        assertEquals(date.getTime(), sdf.parse("201230"));

        // MT306
        sm = SwiftMessage.parse(Lib.readResource("MT306.fin"));
        date = SwiftMessageUtils.valueDate(sm);
        sdf = new SimpleDateFormat("yyyyMMdd");
        assertEquals(date.getTime(), sdf.parse("20080609"));

        // MT340
        sm = SwiftMessage.parse(Lib.readResource("MT340.fin"));
        date = SwiftMessageUtils.valueDate(sm);
        assertEquals(date.getTime(), sdf.parse("20000715"));

        // MT341
        sm = SwiftMessage.parse(Lib.readResource("MT341.fin"));
        date = SwiftMessageUtils.valueDate(sm);
        assertEquals(date.getTime(), sdf.parse("20000715"));

        // MT360
        sm = SwiftMessage.parse(Lib.readResource("MT360.fin"));
        date = SwiftMessageUtils.valueDate(sm);
        assertEquals(date.getTime(), sdf.parse("20070209"));

        // MT361
        sm = SwiftMessage.parse(Lib.readResource("MT361.fin"));
        date = SwiftMessageUtils.valueDate(sm);
        assertEquals(date.getTime(), sdf.parse("19941214"));

        // MT362
        sm = SwiftMessage.parse(Lib.readResource("MT362.fin"));
        date = SwiftMessageUtils.valueDate(sm);
        assertEquals(date.getTime(), sdf.parse("20090106"));
    }

    @Test
    public void testReference() {
        assertNull(SwiftMessageUtils.reference(null));

        // no reference
        MT103 mt = new MT103();
        assertNull(SwiftMessageUtils.reference(mt.getSwiftMessage()));

        // reference from MUR
        mt.getSwiftMessage().getBlock3().builder().setField108(new Field108("MUR1234"));
        assertEquals("MUR1234", SwiftMessageUtils.reference(mt.getSwiftMessage()));

        // reference from field 20
        mt.append(Field20.tag("REF1"));
        assertEquals("REF1", SwiftMessageUtils.reference(mt.getSwiftMessage()));

        // reference from field 20C:SEME
        MT540 mt2 = new MT540();
        mt2.append(Field20C.tag(":SEME//REF2"));
        assertEquals("REF2", SwiftMessageUtils.reference(mt2.getSwiftMessage()));

        MT670 mt3 = new MT670();
        mt3.append(Field20C.tag(":SEME//REF3"));
        assertEquals("REF3", SwiftMessageUtils.reference(mt3.getSwiftMessage()));
    }

    @Test
    void testCalculateChecksumLength() throws IOException {
        SwiftMessage msg = SwiftMessage.parse(Lib.readResource("MT362.fin"));
        String s = calculateChecksum(msg);
        assertEquals(s.length(), 32);
    }
}
