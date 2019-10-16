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
package com.prowidesoftware.swift.model.mt;

import com.prowidesoftware.swift.model.SwiftTagListBlock;
import com.prowidesoftware.swift.model.field.Field16S;
import com.prowidesoftware.swift.model.mt.mt5xx.*;
import com.prowidesoftware.swift.model.mt.mt5xx.MT537.SequenceB;
import com.prowidesoftware.swift.model.mt.mt6xx.MT670;
import com.prowidesoftware.swift.model.mt.mt6xx.MT671;
import org.apache.commons.lang3.Validate;

import java.util.ArrayList;
import java.util.List;

import static com.prowidesoftware.swift.model.SwiftMessageUtils.join;


/**
 * <em>DO NOT USE</em>. All methods in this class may be removed without prior advice. 
 * Use those MTxxx.getSequenceX directly instead.
 * 
 * <p>These are intended to solve some sequence access code required from MT classes.
 *
 * @since 7.8
 *
 */
// TODO this code could be generated
public class SequenceUtils {

	// Suppress default constructor for noninstantiability
	private SequenceUtils() {
		throw new AssertionError();
	}

	private static List<SwiftTagListBlock> resolveNotUniqueSeparator(final AbstractMT mt, SwiftTagListBlock parent, String separator) {
		Validate.notNull(mt);
		SwiftTagListBlock base = parent;
		if (parent.isEmpty()) {
			base = mt.getSwiftMessage().getBlock4();
		}
		return base.getSubBlocks(separator);
	}

	public static List<MT535.SequenceB1b1> resolveMT535GetSequenceB1b1List_sru2019(final MT535 mt) {
		final List<MT535.SequenceB1b1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceB1bList()), MT535.SequenceB1b1.START_END_16RS)) {
			final MT535.SequenceB1b1 s = MT535.SequenceB1b1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT535.SequenceB1c> resolveMT535GetSequenceB1cList_sru2019(final MT535 mt) {
		final List<MT535.SequenceB1c> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceB1List()), MT535.SequenceB1c.START_END_16RS)) {
			final MT535.SequenceB1c s = MT535.SequenceB1c.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT536.SequenceA1> resolveMT536GetSequenceA1List_sru2019(final MT536 mt) {
		final List<MT536.SequenceA1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, mt.getSequenceA(), MT536.SequenceA1.START_END_16RS)) {
			final MT536.SequenceA1 s = MT536.SequenceA1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT536.SequenceB1a1> resolveMT536GetSequenceB1a1List_sru2019(final MT536 mt) {
		final List<MT536.SequenceB1a1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceB1aList()), MT536.SequenceB1a1.START_END_16RS)) {
			final MT536.SequenceB1a1 s = MT536.SequenceB1a1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT537.SequenceA1> resolveMT537GetSequenceA1List_sru2019(final MT537 mt) {
		final List<MT537.SequenceA1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, mt.getSequenceA(), MT537.SequenceA1.START_END_16RS)) {
			final MT537.SequenceA1 s = MT537.SequenceA1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT537.SequenceB> resolveMT537GetSequenceBList_sru2019(final MT537 mt) {
		return resolveMT537GetSequenceBList_sru2019(mt.getSwiftMessage().getBlock4());

	}

	public static List<MT537.SequenceB> resolveMT537GetSequenceBList_sru2019(final SwiftTagListBlock mt /* block 4 */) {
		Validate.notNull(mt);
		final List<SequenceB> result = new ArrayList<>();
		// B delimiter overlaps with C3 delimiter, everything after and including C and use standard getter for B
		final List<SwiftTagListBlock> raw = mt.getSubBlockBeforeFirst(MT537.SequenceC.START_END_16RS, false).getSubBlocks(MT537.SequenceB.START_END_16RS);
		if (raw == null) {
			return null;
		} else {
			for (final SwiftTagListBlock swiftTagListBlock : raw) {
				final MT537.SequenceB sequenceB = MT537.SequenceB.newInstance();
				sequenceB.getTags().clear();
				sequenceB.append(swiftTagListBlock);
				result.add(sequenceB);
			}
		}
		return result;
	}

	public static List<MT537.SequenceB1> resolveMT537GetSequenceB1List_sru2019(final MT537 mt) {
		final List<MT537.SequenceB1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceBList()), MT537.SequenceB1.START_END_16RS)) {
			final MT537.SequenceB1 s = MT537.SequenceB1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT537.SequenceB2> resolveMT537GetSequenceB2List_sru2019(final MT537 mt) {
		final List<MT537.SequenceB2> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceBList()), MT537.SequenceB2.START_END_16RS)) {
			final MT537.SequenceB2 s = MT537.SequenceB2.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT537.SequenceB2a> resolveMT537GetSequenceB2aList_sru2019(final MT537 mt) {
		final List<MT537.SequenceB2a> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceB2List()), MT537.SequenceB2a.START_END_16RS)) {
			final MT537.SequenceB2a s = MT537.SequenceB2a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	
	public static List<MT537.SequenceB2b> resolveMT537GetSequenceB2bList_sru2019(final MT537 mt) {
		final List<MT537.SequenceB2b> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceB2List()), MT537.SequenceB2b.START_END_16RS)) {
			final MT537.SequenceB2b s = MT537.SequenceB2b.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	
	public static List<MT537.SequenceB2b1> resolveMT537GetSequenceB2b1List_sru2019(final MT537 mt) {
		final List<MT537.SequenceB2b1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceB2bList()), MT537.SequenceB2b1.START_END_16RS)) {
			final MT537.SequenceB2b1 s = MT537.SequenceB2b1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT537.SequenceC1> resolveMT537GetSequenceC1List_sru2019(final MT537 mt) {
		final List<MT537.SequenceC1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceCList()), MT537.SequenceC1.START_END_16RS)) {
			final MT537.SequenceC1 s = MT537.SequenceC1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT537.SequenceC2> resolveMT537GetSequenceC2List_sru2019(final MT537 mt) {
		final List<MT537.SequenceC2> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceCList()), MT537.SequenceC2.START_END_16RS)) {
			final MT537.SequenceC2 s = MT537.SequenceC2.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT537.SequenceC2a> resolveMT537GetSequenceC2aList_sru2019(final MT537 mt) {
		final List<MT537.SequenceC2a> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceC2List()), MT537.SequenceC2a.START_END_16RS)) {
			final MT537.SequenceC2a s = MT537.SequenceC2a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT537.SequenceC3> resolveMT537GetSequenceC3List_sru2019(final MT537 mt) {
		final List<MT537.SequenceC3> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceCList()), MT537.SequenceC3.START_END_16RS)) {
			final MT537.SequenceC3 s = MT537.SequenceC3.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT537.SequenceC3a> resolveMT537GetSequenceC3aList_sru2019(final MT537 mt) {
		final List<MT537.SequenceC3a> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceC3List()), MT537.SequenceC3a.START_END_16RS)) {
			final MT537.SequenceC3a s = MT537.SequenceC3a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT537.SequenceD1a1A2a> resolveMT537GetSequenceD1a1A2aList_sru2019(final MT537 mt) {
		final List<MT537.SequenceD1a1A2a> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceD1a1A2List()), MT537.SequenceD1a1A2a.START_END_16RS)) {
			final MT537.SequenceD1a1A2a s = MT537.SequenceD1a1A2a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT537.SequenceD1a1A2a1> resolveMT537GetSequenceD1a1A2a1List_sru2019(final MT537 mt) {
		final List<MT537.SequenceD1a1A2a1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceD1a1A2aList()), MT537.SequenceD1a1A2a1.START_END_16RS)) {
			final MT537.SequenceD1a1A2a1 s = MT537.SequenceD1a1A2a1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT537.SequenceD1a1A2a1A> resolveMT537GetSequenceD1a1A2a1AList_sru2019(final MT537 mt) {
		final List<MT537.SequenceD1a1A2a1A> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceD1a1A2a1List()), MT537.SequenceD1a1A2a1A.START_END_16RS)) {
			final MT537.SequenceD1a1A2a1A s = MT537.SequenceD1a1A2a1A.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT538.SequenceA1> resolveMT538GetSequenceA1List_sru2019(final MT538 mt) {
		final List<MT538.SequenceA1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, mt.getSequenceA(), MT538.SequenceA1.START_END_16RS)) {
			final MT538.SequenceA1 s = MT538.SequenceA1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT538.SequenceB2a1> resolveMT538GetSequenceB2a1List_sru2019(final MT538 mt) {
		final List<MT538.SequenceB2a1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceB2aList()), MT538.SequenceB2a1.START_END_16RS)) {
			final MT538.SequenceB2a1 s = MT538.SequenceB2a1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT548.SequenceA2> resolveMT548GetSequenceA2List_sru2019(final MT548 mt) {
		final List<MT548.SequenceA2> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, mt.getSequenceA(), MT548.SequenceA2.START_END_16RS)) {
			final MT548.SequenceA2 s = MT548.SequenceA2.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT548.SequenceA2a> resolveMT548GetSequenceA2aList_sru2019(final MT548 mt) {
		final List<MT548.SequenceA2a> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceA2List()), MT548.SequenceA2a.START_END_16RS)) {
			final MT548.SequenceA2a s = MT548.SequenceA2a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT548.SequenceC1a1A2a1> resolveMT548GetSequenceC1a1A2a1List_sru2019(final MT548 mt) {
		final List<MT548.SequenceC1a1A2a1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceC1a1A2aList()), MT548.SequenceC1a1A2a1.START_END_16RS)) {
			final MT548.SequenceC1a1A2a1 s = MT548.SequenceC1a1A2a1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT548.SequenceC1a1A2a1A> resolveMT548GetSequenceC1a1A2a1AList_sru2019(final MT548 mt) {
		final List<MT548.SequenceC1a1A2a1A> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceC1a1A2a1List()), MT548.SequenceC1a1A2a1A.START_END_16RS)) {
			final MT548.SequenceC1a1A2a1A s = MT548.SequenceC1a1A2a1A.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static MT564.SequenceB1 resolveMT564GetSequenceB1_sru2019(final MT564 mt) {
		Validate.notNull(mt);
		final MT564.SequenceB1 result = MT564.SequenceB1.newInstance();
		// we just get the first subblock
		result.clear().append(mt.getSequenceB().getSubBlock(MT564.SequenceB1.START_END_16RS));
		return result;
	}

	public static List<MT564.SequenceE1a> resolveMT564GetSequenceE1aList_sru2019(final MT564 mt) {
		final List<MT564.SequenceE1a> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceE1List()), MT564.SequenceE1a.START_END_16RS)) {
			final MT564.SequenceE1a s = MT564.SequenceE1a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT566.SequenceB1> resolveMT566GetSequenceB1List_sru2019(final MT566 mt) {
		final List<MT566.SequenceB1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, mt.getSequenceB(), MT566.SequenceB1.START_END_16RS)) {
			final MT566.SequenceB1 s = MT566.SequenceB1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT566.SequenceD1a> resolveMT566GetSequenceD1aList_sru2019(final MT566 mt) {
		final List<MT566.SequenceD1a> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceD1List()), MT566.SequenceD1a.START_END_16RS)) {
			final MT566.SequenceD1a s = MT566.SequenceD1a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT575.SequenceA1> resolveMT575GetSequenceA1List_sru2019(final MT575 mt) {
		final List<MT575.SequenceA1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, mt.getSequenceA(), MT575.SequenceA1.START_END_16RS)) {
			final MT575.SequenceA1 s = MT575.SequenceA1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT575.SequenceB1a1> resolveMT575GetSequenceB1a1List_sru2019(final MT575 mt) {
		final List<MT575.SequenceB1a1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceB1aList()), MT575.SequenceB1a1.START_END_16RS)) {
			final MT575.SequenceB1a1 s = MT575.SequenceB1a1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT575.SequenceB1a4> resolveMT575GetSequenceB1a4List_sru2019(final MT575 mt) {
		final List<MT575.SequenceB1a4> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceB1aList()), MT575.SequenceB1a4.START_END_16RS)) {
			final MT575.SequenceB1a4 s = MT575.SequenceB1a4.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT575.SequenceC1> resolveMT575GetSequenceC1List_sru2019(final MT575 mt) {
		final List<MT575.SequenceC1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceCList()), MT575.SequenceC1.START_END_16RS)) {
			final MT575.SequenceC1 s = MT575.SequenceC1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT575.SequenceC2a> resolveMT575GetSequenceC2aList_sru2019(final MT575 mt) {
		final List<MT575.SequenceC2a> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceC2List()), MT575.SequenceC2a.START_END_16RS)) {
			final MT575.SequenceC2a s = MT575.SequenceC2a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT576.SequenceA1> resolveMT576GetSequenceA1List_sru2019(final MT576 mt) {
		final List<MT576.SequenceA1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, mt.getSequenceA(), MT576.SequenceA1.START_END_16RS)) {
			final MT576.SequenceA1 s = MT576.SequenceA1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT576.SequenceB2a> resolveMT576GetSequenceB2aList_sru2019(final MT576 mt) {
		final List<MT576.SequenceB2a> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceB2List()), MT576.SequenceB2a.START_END_16RS)) {
			final MT576.SequenceB2a s = MT576.SequenceB2a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT586.SequenceA1> resolveMT586GetSequenceA1List_sru2019(final MT586 mt) {
		final List<MT586.SequenceA1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, mt.getSequenceA(), MT586.SequenceA1.START_END_16RS)) {
			final MT586.SequenceA1 s = MT586.SequenceA1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT586.SequenceB1> resolveMT586GetSequenceB1List_sru2019(final MT586 mt) {
		final List<MT586.SequenceB1> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceBList()), MT586.SequenceB1.START_END_16RS)) {
			final MT586.SequenceB1 s = MT586.SequenceB1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT670.SequenceB2> resolveMT670GetSequenceB2List_sru2019(final MT670 mt) {
		final List<MT670.SequenceB2> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceBList()), MT670.SequenceB2.START_END_16RS)) {
			final MT670.SequenceB2 s = MT670.SequenceB2.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static MT670.SequenceC resolveMT670GetSequenceC_sru2019(final MT670 mt) {
		Validate.notNull(mt);
		final MT670.SequenceC result = MT670.SequenceC.newInstance();
		result.clear().append(getMT670_1_C(mt.getSwiftMessage().getBlock4(), MT670.SequenceB.START_END_16RS));
		return result;
	}

	public static List<MT671.SequenceB2> resolveMT671GetSequenceB2List_sru2019(final MT671 mt) {
		final List<MT671.SequenceB2> result = new ArrayList<>();
		for (final SwiftTagListBlock seq : resolveNotUniqueSeparator(mt, join(mt.getSequenceBList()), MT671.SequenceB2.START_END_16RS)) {
			final MT671.SequenceB2 s = MT671.SequenceB2.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static MT671.SequenceC resolveMT671GetSequenceC_sru2019(final MT671 mt) {
		Validate.notNull(mt);
		final MT671.SequenceC result = MT671.SequenceC.newInstance();
		result.clear().append(getMT670_1_C(mt.getSwiftMessage().getBlock4(), MT671.SequenceB.START_END_16RS));
		return result;
	}

	private static SwiftTagListBlock getMT670_1_C(final SwiftTagListBlock b4, final String B_startEnd16rs) {
		// Since B contains inside a colliding sequence, with same delimiter as sequence C, if B is present we remove it to avoid ambiguity
		final int last = b4.indexOfLastValue(Field16S.NAME, B_startEnd16rs);
		if (last>=0) {
			if (last+1 == b4.size()) {
				/*
				 * If 16S of C is the last tag on the message then there won't be a C block
				 */
				return SwiftTagListBlock.EMPTY_LIST;
			}
			return b4.sublist(last, b4.size());
		}
		return b4;
	}

}
