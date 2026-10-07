/*
 * Copyright 2006 Prowide
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

package com.prowidesoftware.swift.model.mt;

import static org.junit.jupiter.api.Assertions.*;

import com.prowidesoftware.swift.model.SwiftTagListBlock;
import com.prowidesoftware.swift.model.Tag;
import com.prowidesoftware.swift.model.mt.mt5xx.*;
import com.prowidesoftware.swift.model.mt.mt6xx.MT670;
import com.prowidesoftware.swift.model.mt.mt6xx.MT671;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

/**
 * Characterization of the no-arg getters for sequences delimited by a non-unique 16R/S qualifier,
 * currently resolved by hand-written methods in {@link SequenceUtils}.
 *
 * <p>These tests pin down the CURRENT behavior (scoping, boundary tags, list ordering, empty and
 * null-message cases) so that the resolution can be migrated to generated parent-scoped accessors
 * without any observable change. Every affected getter of the 16 MT classes is covered.
 */
public class NonUnique16RSCharacterizationTest {

    private static Tag r(String qualifier) {
        return new Tag("16R", qualifier);
    }

    private static Tag s(String qualifier) {
        return new Tag("16S", qualifier);
    }

    /** content marker tag, the name is irrelevant for 16R/S sub-block resolution */
    private static Tag c(String marker) {
        return new Tag("13A", marker);
    }

    /**
     * Asserts the sequence starts with 16R, ends with 16S (boundary tags are part of the returned
     * content) and contains exactly the given 13A markers, in order.
     */
    private static void assertSeq(SwiftTagListBlock block, String qualifier, String... markers) {
        assertNotNull(block);
        assertFalse(block.isEmpty(), "expected a non empty sequence for " + qualifier);
        assertEquals("16R", block.getTag(0).getName());
        assertEquals(qualifier, block.getTag(0).getValue());
        assertEquals("16S", block.getTag(block.size() - 1).getName());
        assertEquals(qualifier, block.getTag(block.size() - 1).getValue());
        assertEquals(Arrays.asList(markers), markers(block));
    }

    private static List<String> markers(SwiftTagListBlock block) {
        return block.getTags().stream()
                .filter(t -> "13A".equals(t.getName()))
                .map(Tag::getValue)
                .collect(Collectors.toList());
    }

    private static void assertSeqList(
            List<? extends SwiftTagListBlock> list, String qualifier, String[]... markersPerItem) {
        assertNotNull(list);
        assertEquals(markersPerItem.length, list.size(), "sequence count for " + qualifier);
        for (int i = 0; i < markersPerItem.length; i++) {
            assertSeq(list.get(i), qualifier, markersPerItem[i]);
        }
    }

    private static String[] m(String... markers) {
        return markers;
    }

    // ---------------------------------------------------------------------------------------------
    // MT513: C2 and D4 share DIGPAYSETT, scoped to C (ORDRDET) and D (SETDET)
    // ---------------------------------------------------------------------------------------------

    @Test
    public void testMT513() {
        MT513 mt = new MT513();
        mt.append(
                r("ORDRDET"),
                c("c-pre"),
                r("DIGPAYSETT"),
                c("c2-1"),
                s("DIGPAYSETT"),
                s("ORDRDET"),
                r("SETDET"),
                c("d-pre"),
                r("DIGPAYSETT"),
                c("d4-1"),
                s("DIGPAYSETT"),
                s("SETDET"));
        assertSeq(mt.getSequenceC2(), "DIGPAYSETT", "c2-1");
        assertSeq(mt.getSequenceD4(), "DIGPAYSETT", "d4-1");
    }

    @Test
    public void testMT513_empty() {
        // only D holds a DIGPAYSETT block: C2 resolves empty (never null when a message is present)
        MT513 mt = new MT513();
        mt.append(r("SETDET"), r("DIGPAYSETT"), c("d4-1"), s("DIGPAYSETT"), s("SETDET"));
        assertNotNull(mt.getSequenceC2());
        assertTrue(mt.getSequenceC2().isEmpty());
        assertSeq(mt.getSequenceD4(), "DIGPAYSETT", "d4-1");
    }

    // ---------------------------------------------------------------------------------------------
    // MT514: B1 and C4 share DIGPAYSETT, scoped to B (CONFDET) and C (SETDET)
    // ---------------------------------------------------------------------------------------------

    @Test
    public void testMT514() {
        MT514 mt = new MT514();
        mt.append(
                r("CONFDET"),
                r("DIGPAYSETT"),
                c("b1-1"),
                s("DIGPAYSETT"),
                s("CONFDET"),
                r("SETDET"),
                r("DIGPAYSETT"),
                c("c4-1"),
                s("DIGPAYSETT"),
                s("SETDET"));
        assertSeq(mt.getSequenceB1(), "DIGPAYSETT", "b1-1");
        assertSeq(mt.getSequenceC4(), "DIGPAYSETT", "c4-1");
    }

    // ---------------------------------------------------------------------------------------------
    // MT515: C1 and D4 share DIGPAYSETT, scoped to C (CONFDET) and D (SETDET)
    // ---------------------------------------------------------------------------------------------

    @Test
    public void testMT515() {
        MT515 mt = new MT515();
        mt.append(
                r("CONFDET"),
                r("DIGPAYSETT"),
                c("c1-1"),
                s("DIGPAYSETT"),
                s("CONFDET"),
                r("SETDET"),
                r("DIGPAYSETT"),
                c("d4-1"),
                s("DIGPAYSETT"),
                s("SETDET"));
        assertSeq(mt.getSequenceC1(), "DIGPAYSETT", "c1-1");
        assertSeq(mt.getSequenceD4(), "DIGPAYSETT", "d4-1");
    }

    // ---------------------------------------------------------------------------------------------
    // MT518: B1 and C4 share DIGPAYSETT, scoped to B (CONFDET) and C (SETDET)
    // ---------------------------------------------------------------------------------------------

    @Test
    public void testMT518() {
        MT518 mt = new MT518();
        mt.append(
                r("CONFDET"),
                r("DIGPAYSETT"),
                c("b1-1"),
                s("DIGPAYSETT"),
                s("CONFDET"),
                r("SETDET"),
                r("DIGPAYSETT"),
                c("c4-1"),
                s("DIGPAYSETT"),
                s("SETDET"));
        assertSeq(mt.getSequenceB1(), "DIGPAYSETT", "b1-1");
        assertSeq(mt.getSequenceC4(), "DIGPAYSETT", "c4-1");
    }

    // ---------------------------------------------------------------------------------------------
    // MT535: B1b1 (in repetitive B1b=SUBBAL) and B1c (in repetitive B1=FIN) share BREAK
    // ---------------------------------------------------------------------------------------------

    @Test
    public void testMT535() {
        MT535 mt = new MT535();
        mt.append(
                r("SUBSAFE"),
                r("FIN"), // B1 #1
                r("SUBBAL"), // B1b #1
                r("BREAK"),
                c("b1b1-1"),
                s("BREAK"),
                r("BREAK"),
                c("b1b1-2"),
                s("BREAK"),
                s("SUBBAL"),
                r("SUBBAL"), // B1b #2
                r("BREAK"),
                c("b1b1-3"),
                s("BREAK"),
                s("SUBBAL"),
                r("BREAK"),
                c("b1c-1"),
                s("BREAK"), // B1c of B1 #1
                s("FIN"),
                r("FIN"), // B1 #2
                r("BREAK"),
                c("b1c-2"),
                s("BREAK"), // B1c of B1 #2
                s("FIN"),
                s("SUBSAFE"));

        // B1b1 scoped to the B1b occurrences, concatenated in message order
        assertSeqList(mt.getSequenceB1b1List(), "BREAK", m("b1b1-1"), m("b1b1-2"), m("b1b1-3"));

        // B1c resolves within B1, which also CONTAINS the B1b1 blocks nested in B1b: the current
        // resolution cannot tell them apart, so the B1b1 occurrences leak into the B1c result.
        // This is a known limitation of the scoping (B1b1 and B1c are both under B1) that the
        // generated parent scoping must preserve as is.
        assertSeqList(mt.getSequenceB1cList(), "BREAK", m("b1b1-1"), m("b1b1-2"), m("b1b1-3"), m("b1c-1"), m("b1c-2"));
    }

    /**
     * Intended behavior change of the parent scoping migration: with the legacy SequenceUtils
     * resolution the parent occurrences were joined into a single block before splitting, so an
     * unterminated 16R block at the end of one parent silently swallowed content of the NEXT parent
     * occurrence (up to the first 16S of the qualifier found there). Resolving each parent occurrence
     * separately truncates the malformed block at its parent boundary instead.
     */
    @Test
    public void testMT535_unterminatedBlockDoesNotBleedAcrossParents() {
        MT535 mt = new MT535();
        mt.append(
                r("SUBSAFE"),
                r("FIN"),
                r("SUBBAL"), // B1b #1 with an unterminated BREAK (no 16S)
                r("BREAK"),
                c("b1b1-1"),
                s("SUBBAL"),
                r("SUBBAL"), // B1b #2, well formed
                r("BREAK"),
                c("b1b1-2"),
                s("BREAK"),
                s("SUBBAL"),
                s("FIN"),
                s("SUBSAFE"));
        List<MT535.SequenceB1b1> list = mt.getSequenceB1b1List();
        assertEquals(2, list.size());
        // the malformed block is truncated at the end of its own B1b occurrence
        assertEquals(Arrays.asList("b1b1-1"), markers(list.get(0)));
        assertEquals(Arrays.asList("b1b1-2"), markers(list.get(1)));
    }

    @Test
    public void testMT535_empty() {
        MT535 mt = new MT535();
        mt.append(r("SUBSAFE"), r("FIN"), s("FIN"), s("SUBSAFE"));
        assertTrue(mt.getSequenceB1b1List().isEmpty());
        assertTrue(mt.getSequenceB1cList().isEmpty());
    }

    // ---------------------------------------------------------------------------------------------
    // MT536: A1 (in single A=GENL) and B1a1 (in repetitive B1a=TRAN) share LINK
    // ---------------------------------------------------------------------------------------------

    @Test
    public void testMT536() {
        MT536 mt = new MT536();
        mt.append(
                r("GENL"),
                r("LINK"),
                c("a1-1"),
                s("LINK"),
                r("LINK"),
                c("a1-2"),
                s("LINK"),
                s("GENL"),
                r("SUBSAFE"),
                r("FIN"),
                r("TRAN"), // B1a #1
                r("LINK"),
                c("b1a1-1"),
                s("LINK"),
                s("TRAN"),
                r("TRAN"), // B1a #2
                r("LINK"),
                c("b1a1-2"),
                s("LINK"),
                s("TRAN"),
                s("FIN"),
                s("SUBSAFE"));
        assertSeqList(mt.getSequenceA1List(), "LINK", m("a1-1"), m("a1-2"));
        assertSeqList(mt.getSequenceB1a1List(), "LINK", m("b1a1-1"), m("b1a1-2"));
    }

    // ---------------------------------------------------------------------------------------------
    // MT537: LINK shared by A1/B2a/C1, TRANSDET by B2b/C2, DIGPAYSETT by B2b1/C2a, SETPRTY by
    // B2b2/C2b, STAT by B/C3/D1a1B1a, REAS by B1/C3a/D1a1B1a1, TRAN by B2/D1a1B1
    // ---------------------------------------------------------------------------------------------

    private MT537 sample537() {
        MT537 mt = new MT537();
        mt.append(
                r("GENL"),
                r("LINK"),
                c("a1-1"),
                s("LINK"),
                r("LINK"),
                c("a1-2"),
                s("LINK"),
                s("GENL"),
                r("STAT"),
                c("b-1"), // B #1
                r("REAS"),
                c("b1-1"),
                s("REAS"),
                r("TRAN"),
                c("b2-1"), // B2 #1
                r("LINK"),
                c("b2a-1"),
                s("LINK"),
                r("TRANSDET"),
                c("b2b-1"), // B2b #1
                r("DIGPAYSETT"),
                c("b2b1-1"),
                s("DIGPAYSETT"),
                r("SETPRTY"),
                c("b2b2-1"),
                s("SETPRTY"),
                s("TRANSDET"),
                s("TRAN"),
                s("STAT"),
                r("STAT"),
                c("b-2"), // B #2
                r("REAS"),
                c("b1-2"),
                s("REAS"),
                s("STAT"),
                r("TRANS"), // C #1
                r("LINK"),
                c("c1-1"),
                s("LINK"),
                r("TRANSDET"),
                c("c2-1"), // C2 #1
                r("DIGPAYSETT"),
                c("c2a-1"),
                s("DIGPAYSETT"),
                r("SETPRTY"),
                c("c2b-1"),
                s("SETPRTY"),
                s("TRANSDET"),
                r("STAT"),
                c("c3-1"), // C3 #1
                r("REAS"),
                c("c3a-1"),
                s("REAS"),
                s("STAT"),
                s("TRANS"),
                r("PENA"), // D
                r("PENACUR"),
                r("PENACOUNT"),
                r("PENDET"),
                r("RELTRAN"), // D1a1B #1
                r("TRAN"),
                c("d1a1b1-1"), // D1a1B1 #1
                r("STAT"),
                c("d1a1b1a-1"), // D1a1B1a #1
                r("REAS"),
                c("d1a1b1a1-1"),
                s("REAS"),
                s("STAT"),
                s("TRAN"),
                s("RELTRAN"),
                s("PENDET"),
                s("PENACOUNT"),
                s("PENACUR"),
                s("PENA"));
        return mt;
    }

    @Test
    public void testMT537_A_and_B_family() {
        MT537 mt = sample537();
        assertSeqList(mt.getSequenceA1List(), "LINK", m("a1-1"), m("a1-2"));
        // B excludes the STAT blocks of C3 and D1a1B1a (custom trim before C and D)
        assertSeqList(
                mt.getSequenceBList(),
                "STAT",
                m("b-1", "b1-1", "b2-1", "b2a-1", "b2b-1", "b2b1-1", "b2b2-1"),
                m("b-2", "b1-2"));
        assertSeqList(mt.getSequenceB1List(), "REAS", m("b1-1"), m("b1-2"));
        assertSeqList(mt.getSequenceB2List(), "TRAN", m("b2-1", "b2a-1", "b2b-1", "b2b1-1", "b2b2-1"));
        assertSeqList(mt.getSequenceB2aList(), "LINK", m("b2a-1"));
        assertSeqList(mt.getSequenceB2bList(), "TRANSDET", m("b2b-1", "b2b1-1", "b2b2-1"));
        assertSeqList(mt.getSequenceB2b1List(), "DIGPAYSETT", m("b2b1-1"));
        assertSeqList(mt.getSequenceB2b2List(), "SETPRTY", m("b2b2-1"));
    }

    @Test
    public void testMT537_C_and_D_family() {
        MT537 mt = sample537();
        assertSeqList(mt.getSequenceC1List(), "LINK", m("c1-1"));
        assertSeqList(mt.getSequenceC2List(), "TRANSDET", m("c2-1", "c2a-1", "c2b-1"));
        assertSeqList(mt.getSequenceC2aList(), "DIGPAYSETT", m("c2a-1"));
        assertSeqList(mt.getSequenceC2bList(), "SETPRTY", m("c2b-1"));
        assertSeqList(mt.getSequenceC3List(), "STAT", m("c3-1", "c3a-1"));
        assertSeqList(mt.getSequenceC3aList(), "REAS", m("c3a-1"));
        assertSeqList(mt.getSequenceD1a1B1List(), "TRAN", m("d1a1b1-1", "d1a1b1a-1", "d1a1b1a1-1"));
        assertSeqList(mt.getSequenceD1a1B1aList(), "STAT", m("d1a1b1a-1", "d1a1b1a1-1"));
        assertSeqList(mt.getSequenceD1a1B1a1List(), "REAS", m("d1a1b1a1-1"));
    }

    @Test
    public void testMT537_empty() {
        MT537 mt = new MT537();
        mt.append(r("GENL"), s("GENL"));
        assertTrue(mt.getSequenceA1List().isEmpty());
        assertTrue(mt.getSequenceBList().isEmpty());
        assertTrue(mt.getSequenceB1List().isEmpty());
        assertTrue(mt.getSequenceC3List().isEmpty());
        assertTrue(mt.getSequenceD1a1B1aList().isEmpty());
    }

    // ---------------------------------------------------------------------------------------------
    // MT538: A1 (in single A=GENL) and B2a1 (in repetitive B2a=INPOS) share LINK
    // ---------------------------------------------------------------------------------------------

    @Test
    public void testMT538() {
        MT538 mt = new MT538();
        mt.append(
                r("GENL"),
                r("LINK"),
                c("a1-1"),
                s("LINK"),
                s("GENL"),
                r("FIN"),
                r("SUBBAL"),
                r("INPOS"),
                r("LINK"),
                c("b2a1-1"),
                s("LINK"),
                s("INPOS"),
                s("SUBBAL"),
                s("FIN"));
        assertSeqList(mt.getSequenceA1List(), "LINK", m("a1-1"));
        assertSeqList(mt.getSequenceB2a1List(), "LINK", m("b2a1-1"));
    }

    // ---------------------------------------------------------------------------------------------
    // MT548: STAT shared by A2/C1a1B1a, REAS shared by A2a/C1a1B1a1
    // ---------------------------------------------------------------------------------------------

    @Test
    public void testMT548() {
        MT548 mt = new MT548();
        mt.append(
                r("GENL"),
                r("STAT"),
                c("a2-1"), // A2 #1
                r("REAS"),
                c("a2a-1"),
                s("REAS"),
                s("STAT"),
                r("STAT"),
                c("a2-2"), // A2 #2
                s("STAT"),
                s("GENL"),
                r("PENA"),
                r("PENACUR"),
                r("PENACOUNT"),
                r("PENDET"),
                r("RELTRAN"),
                r("TRAN"),
                r("STAT"),
                c("c1a1b1a-1"), // C1a1B1a #1
                r("REAS"),
                c("c1a1b1a1-1"),
                s("REAS"),
                s("STAT"),
                s("TRAN"),
                s("RELTRAN"),
                s("PENDET"),
                s("PENACOUNT"),
                s("PENACUR"),
                s("PENA"));
        assertSeqList(mt.getSequenceA2List(), "STAT", m("a2-1", "a2a-1"), m("a2-2"));
        assertSeqList(mt.getSequenceA2aList(), "REAS", m("a2a-1"));
        assertSeqList(mt.getSequenceC1a1B1aList(), "STAT", m("c1a1b1a-1", "c1a1b1a1-1"));
        assertSeqList(mt.getSequenceC1a1B1a1List(), "REAS", m("c1a1b1a1-1"));
    }

    // ---------------------------------------------------------------------------------------------
    // MT564: B1 (in single B=USECU) and E1a (in repetitive E1=SECMOVE) share FIA
    // ---------------------------------------------------------------------------------------------

    @Test
    public void testMT564() {
        MT564 mt = new MT564();
        mt.append(
                r("USECU"),
                r("FIA"),
                c("b1-1"),
                s("FIA"),
                s("USECU"),
                r("CAOPTN"),
                r("SECMOVE"), // E1 #1
                r("FIA"),
                c("e1a-1"),
                s("FIA"),
                s("SECMOVE"),
                r("SECMOVE"), // E1 #2
                r("FIA"),
                c("e1a-2"),
                s("FIA"),
                s("SECMOVE"),
                s("CAOPTN"));
        assertSeq(mt.getSequenceB1(), "FIA", "b1-1");
        assertSeqList(mt.getSequenceE1aList(), "FIA", m("e1a-1"), m("e1a-2"));
    }

    @Test
    public void testMT564_empty() {
        MT564 mt = new MT564();
        mt.append(r("USECU"), s("USECU"));
        assertNotNull(mt.getSequenceB1());
        assertTrue(mt.getSequenceB1().isEmpty());
        assertTrue(mt.getSequenceE1aList().isEmpty());
    }

    // ---------------------------------------------------------------------------------------------
    // MT566: B1 (in single B=USECU) and D1a (in repetitive D1=SECMOVE) share FIA
    // ---------------------------------------------------------------------------------------------

    @Test
    public void testMT566() {
        MT566 mt = new MT566();
        mt.append(
                r("USECU"),
                r("FIA"),
                c("b1-1"),
                s("FIA"),
                s("USECU"),
                r("CACONF"),
                r("SECMOVE"), // D1 #1
                r("FIA"),
                c("d1a-1"),
                s("FIA"),
                s("SECMOVE"),
                s("CACONF"));
        assertSeq(mt.getSequenceB1(), "FIA", "b1-1");
        assertSeqList(mt.getSequenceD1aList(), "FIA", m("d1a-1"));
    }

    // ---------------------------------------------------------------------------------------------
    // MT575: LINK shared by A1/B1a1/C1, SETPRTY shared by B1a4/C2a
    // ---------------------------------------------------------------------------------------------

    @Test
    public void testMT575() {
        MT575 mt = new MT575();
        mt.append(
                r("GENL"),
                r("LINK"),
                c("a1-1"),
                s("LINK"),
                s("GENL"),
                r("CASHACCT"),
                r("ACTCURR"),
                r("ACTINFO"), // B1a #1
                r("LINK"),
                c("b1a1-1"),
                s("LINK"),
                r("SETPRTY"),
                c("b1a4-1"),
                s("SETPRTY"),
                s("ACTINFO"),
                s("ACTCURR"),
                s("CASHACCT"),
                r("FREEASS"), // C #1
                r("LINK"),
                c("c1-1"),
                s("LINK"),
                r("TRANSDET"), // C2 #1
                r("SETPRTY"),
                c("c2a-1"),
                s("SETPRTY"),
                s("TRANSDET"),
                s("FREEASS"));
        assertSeqList(mt.getSequenceA1List(), "LINK", m("a1-1"));
        assertSeqList(mt.getSequenceB1a1List(), "LINK", m("b1a1-1"));
        assertSeqList(mt.getSequenceB1a4List(), "SETPRTY", m("b1a4-1"));
        assertSeqList(mt.getSequenceC1List(), "LINK", m("c1-1"));
        assertSeqList(mt.getSequenceC2aList(), "SETPRTY", m("c2a-1"));
    }

    // ---------------------------------------------------------------------------------------------
    // MT576: A1 (in single A=GENL) and B2a (in repetitive B2=ORDER) share LINK
    // ---------------------------------------------------------------------------------------------

    @Test
    public void testMT576() {
        MT576 mt = new MT576();
        mt.append(
                r("GENL"),
                r("LINK"),
                c("a1-1"),
                s("LINK"),
                s("GENL"),
                r("FIN"),
                r("ORDER"),
                r("LINK"),
                c("b2a-1"),
                s("LINK"),
                s("ORDER"),
                s("FIN"));
        assertSeqList(mt.getSequenceA1List(), "LINK", m("a1-1"));
        assertSeqList(mt.getSequenceB2aList(), "LINK", m("b2a-1"));
    }

    // ---------------------------------------------------------------------------------------------
    // MT586: A1 (in single A=GENL) and B1 (in repetitive B=ALLDET) share LINK
    // ---------------------------------------------------------------------------------------------

    @Test
    public void testMT586() {
        MT586 mt = new MT586();
        mt.append(
                r("GENL"),
                r("LINK"),
                c("a1-1"),
                s("LINK"),
                s("GENL"),
                r("ALLDET"), // B #1
                r("LINK"),
                c("b1-1"),
                s("LINK"),
                s("ALLDET"),
                r("ALLDET"), // B #2
                r("LINK"),
                c("b1-2"),
                s("LINK"),
                s("ALLDET"));
        assertSeqList(mt.getSequenceA1List(), "LINK", m("a1-1"));
        assertSeqList(mt.getSequenceB1List(), "LINK", m("b1-1"), m("b1-2"));
    }

    // ---------------------------------------------------------------------------------------------
    // MT670/MT671: B2 (in repetitive B=SSIDET) and level one C share OTHRDET
    // ---------------------------------------------------------------------------------------------

    @Test
    public void testMT670() {
        MT670 mt = new MT670();
        mt.append(
                r("SSIDET"), // B #1
                r("OTHRDET"),
                c("b2-1"),
                s("OTHRDET"),
                s("SSIDET"),
                r("SSIDET"), // B #2
                r("OTHRDET"),
                c("b2-2"),
                s("OTHRDET"),
                s("SSIDET"),
                r("OTHRDET"),
                c("c-1"),
                s("OTHRDET")); // C
        assertSeqList(mt.getSequenceB2List(), "OTHRDET", m("b2-1"), m("b2-2"));
        // Current behavior of the manual resolver: when sequence B is present and followed by more
        // content, SequenceUtils.getMT670_1_C calls sublist(last, size) whose end index is inclusive,
        // so it always overflows and the getter throws. C only resolves when the message ends right
        // at the 16S of B (empty C) or has no B at all. Pre-existing bug, pinned here as is; the C
        // resolver is out of the parent-scoping migration (level one collision, stays manual).
        assertThrows(IllegalArgumentException.class, mt::getSequenceC);
    }

    @Test
    public void testMT670_C_absent() {
        MT670 mt = new MT670();
        mt.append(r("SSIDET"), r("OTHRDET"), c("b2-1"), s("OTHRDET"), s("SSIDET"));
        assertTrue(mt.getSequenceC().isEmpty());
    }

    @Test
    public void testMT671() {
        MT671 mt = new MT671();
        mt.append(
                r("SSIDET"), r("OTHRDET"), c("b2-1"), s("OTHRDET"), s("SSIDET"), r("OTHRDET"), c("c-1"), s("OTHRDET"));
        assertSeqList(mt.getSequenceB2List(), "OTHRDET", m("b2-1"));
        // same pre-existing sublist overflow as in MT670, see testMT670
        assertThrows(IllegalArgumentException.class, mt::getSequenceC);
    }

    @Test
    public void testMT670_C_without_B() {
        // without B the resolver hands the whole block 4 to the C sequence
        MT670 mt = new MT670();
        mt.append(r("OTHRDET"), c("c-1"), s("OTHRDET"));
        assertSeq(mt.getSequenceC(), "OTHRDET", "c-1");
    }

    // ---------------------------------------------------------------------------------------------
    // Null SwiftMessage: every affected no-arg getter returns null (instead of throwing) when the
    // MT instance holds no SwiftMessage (reachable through setSwiftMessage(null))
    // ---------------------------------------------------------------------------------------------

    private static <T extends AbstractMT> T noMessage(T mt) {
        mt.setSwiftMessage(null);
        return mt;
    }

    @Test
    public void testNullSwiftMessage() {
        assertNull(noMessage(new MT513()).getSequenceC2());
        assertNull(noMessage(new MT513()).getSequenceD4());
        assertNull(noMessage(new MT514()).getSequenceB1());
        assertNull(noMessage(new MT514()).getSequenceC4());
        assertNull(noMessage(new MT515()).getSequenceC1());
        assertNull(noMessage(new MT515()).getSequenceD4());
        assertNull(noMessage(new MT518()).getSequenceB1());
        assertNull(noMessage(new MT518()).getSequenceC4());
        assertNull(noMessage(new MT535()).getSequenceB1b1List());
        assertNull(noMessage(new MT535()).getSequenceB1cList());
        assertNull(noMessage(new MT536()).getSequenceA1List());
        assertNull(noMessage(new MT536()).getSequenceB1a1List());
        assertNull(noMessage(new MT537()).getSequenceA1List());
        assertNull(noMessage(new MT537()).getSequenceBList());
        assertNull(noMessage(new MT537()).getSequenceB1List());
        assertNull(noMessage(new MT537()).getSequenceB2List());
        assertNull(noMessage(new MT537()).getSequenceB2aList());
        assertNull(noMessage(new MT537()).getSequenceB2bList());
        assertNull(noMessage(new MT537()).getSequenceB2b1List());
        assertNull(noMessage(new MT537()).getSequenceB2b2List());
        assertNull(noMessage(new MT537()).getSequenceC1List());
        assertNull(noMessage(new MT537()).getSequenceC2List());
        assertNull(noMessage(new MT537()).getSequenceC2aList());
        assertNull(noMessage(new MT537()).getSequenceC2bList());
        assertNull(noMessage(new MT537()).getSequenceC3List());
        assertNull(noMessage(new MT537()).getSequenceC3aList());
        assertNull(noMessage(new MT537()).getSequenceD1a1B1List());
        assertNull(noMessage(new MT537()).getSequenceD1a1B1aList());
        assertNull(noMessage(new MT537()).getSequenceD1a1B1a1List());
        assertNull(noMessage(new MT538()).getSequenceA1List());
        assertNull(noMessage(new MT538()).getSequenceB2a1List());
        assertNull(noMessage(new MT548()).getSequenceA2List());
        assertNull(noMessage(new MT548()).getSequenceA2aList());
        assertNull(noMessage(new MT548()).getSequenceC1a1B1aList());
        assertNull(noMessage(new MT548()).getSequenceC1a1B1a1List());
        assertNull(noMessage(new MT564()).getSequenceB1());
        assertNull(noMessage(new MT564()).getSequenceE1aList());
        assertNull(noMessage(new MT566()).getSequenceB1());
        assertNull(noMessage(new MT566()).getSequenceD1aList());
        assertNull(noMessage(new MT575()).getSequenceA1List());
        assertNull(noMessage(new MT575()).getSequenceB1a1List());
        assertNull(noMessage(new MT575()).getSequenceB1a4List());
        assertNull(noMessage(new MT575()).getSequenceC1List());
        assertNull(noMessage(new MT575()).getSequenceC2aList());
        assertNull(noMessage(new MT576()).getSequenceA1List());
        assertNull(noMessage(new MT576()).getSequenceB2aList());
        assertNull(noMessage(new MT586()).getSequenceA1List());
        assertNull(noMessage(new MT586()).getSequenceB1List());
        assertNull(noMessage(new MT670()).getSequenceB2List());
        assertNull(noMessage(new MT670()).getSequenceC());
        assertNull(noMessage(new MT671()).getSequenceB2List());
        assertNull(noMessage(new MT671()).getSequenceC());
    }
}
