/*******************************************************************************
 * Copyright (c) 2016 Prowide Inc.
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as 
 *     published by the Free Software Foundation, either version 3 of the 
 *     License, or (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  
 *     
 *     Check the LGPL at <http://www.gnu.org/licenses/> for more details.
 *******************************************************************************/
package com.prowidesoftware.swift.model.mt;

import static com.prowidesoftware.swift.model.SwiftMessageUtils.join;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.Validate;

import com.prowidesoftware.swift.model.SwiftTagListBlock;
import com.prowidesoftware.swift.model.field.Field16S;
import com.prowidesoftware.swift.model.mt.mt3xx.MT307;
import com.prowidesoftware.swift.model.mt.mt3xx.MT307.SequenceA1;
import com.prowidesoftware.swift.model.mt.mt3xx.MT307.SequenceC1;
import com.prowidesoftware.swift.model.mt.mt3xx.MT307.SequenceD1;
import com.prowidesoftware.swift.model.mt.mt5xx.MT535;
import com.prowidesoftware.swift.model.mt.mt5xx.MT536;
import com.prowidesoftware.swift.model.mt.mt5xx.MT537;
import com.prowidesoftware.swift.model.mt.mt5xx.MT537.SequenceB;
import com.prowidesoftware.swift.model.mt.mt5xx.MT538;
import com.prowidesoftware.swift.model.mt.mt5xx.MT564;
import com.prowidesoftware.swift.model.mt.mt5xx.MT566;
import com.prowidesoftware.swift.model.mt.mt5xx.MT575;
import com.prowidesoftware.swift.model.mt.mt5xx.MT576;
import com.prowidesoftware.swift.model.mt.mt5xx.MT586;
import com.prowidesoftware.swift.model.mt.mt6xx.MT670;
import com.prowidesoftware.swift.model.mt.mt6xx.MT671;


/**
 * All methods in this class may be removed without prior advice.
 * <em>DO NOT USE</em>
 * These are intended to solve some sequence access code required from MT classes.
 * Use those MTxxx.getSequenceX directly instead of these.
 *
 * @author miguel@prowidesoftware.com
 * @since 7.8
 *
 */
public class SequenceUtils {

	private SequenceUtils(){}

	public static List<MT307.SequenceA1> resolveMT307GetSequenceA1List_sru2016(final MT307 mt307) {
		Validate.notNull(mt307);
		final ArrayList<SequenceA1> result = new ArrayList<MT307.SequenceA1>();
		for (final SwiftTagListBlock seq : mt307.getSequenceA().getSubBlocks(MT307.SequenceA1.START_END_16RS)) {
			final SequenceA1 s = MT307.SequenceA1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return  result;
	}
	public static List<MT307.SequenceC1> resolveMT307GetSequenceC1List_sru2016(final MT307 mt307) {
		Validate.notNull(mt307);
		final List<SequenceC1> result = new ArrayList<MT307.SequenceC1>();
		for (final SwiftTagListBlock seq : mt307.getSequenceC().getSubBlocks(MT307.SequenceC1.START_END_16RS)) {
			final SequenceC1 s = MT307.SequenceC1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT307.SequenceD1> resolveMT307GetSequenceD1List_sru2016(final MT307 mt307) {
		Validate.notNull(mt307);
		final List<SequenceD1> result = new ArrayList<MT307.SequenceD1>();
		for (final SwiftTagListBlock seq : mt307.getSequenceD().getSubBlocks(MT307.SequenceD1.START_END_16RS)) {
			final MT307.SequenceD1 s = MT307.SequenceD1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT307.SequenceB3a> resolveMT307GetSequenceB3aList_sru2016(final MT307 mt307) {
		Validate.notNull(mt307);
		final List<MT307.SequenceB3a> result = new ArrayList<MT307.SequenceB3a>();
		for (final SwiftTagListBlock seq : join(mt307.getSequenceB3List()).getSubBlocks(MT307.SequenceB3a.START_END_16RS)) {
			final MT307.SequenceB3a s = MT307.SequenceB3a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT535.SequenceB1b1> resolveMT535GetSequenceB1b1List_sru2016(final MT535 mt535) {
		Validate.notNull(mt535);
		final List<MT535.SequenceB1b1> result = new ArrayList<MT535.SequenceB1b1>();
		for (final SwiftTagListBlock seq : join(mt535.getSequenceB1bList()).getSubBlocks(MT535.SequenceB1b1.START_END_16RS)) {
			final MT535.SequenceB1b1 s = MT535.SequenceB1b1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT535.SequenceB1c> resolveMT535GetSequenceB1cList_sru2016(final MT535 mt535) {
		Validate.notNull(mt535);
		final List<MT535.SequenceB1c> result = new ArrayList<MT535.SequenceB1c>();
		for (final SwiftTagListBlock seq : join(mt535.getSequenceB1List()).getSubBlocks(MT535.SequenceB1c.START_END_16RS)) {
			final MT535.SequenceB1c s = MT535.SequenceB1c.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT536.SequenceA1> resolveMT536GetSequenceA1List_sru2016(final MT536 mt536) {
		Validate.notNull(mt536);
		final List<MT536.SequenceA1> result = new ArrayList<MT536.SequenceA1>();
		for (final SwiftTagListBlock seq : mt536.getSequenceA().getSubBlocks(MT536.SequenceA1.START_END_16RS)) {
			final MT536.SequenceA1 s = MT536.SequenceA1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT536.SequenceB1a1> resolveMT536GetSequenceB1a1List_sru2016(final MT536 mt536) {
		Validate.notNull(mt536);
		final List<MT536.SequenceB1a1> result = new ArrayList<MT536.SequenceB1a1>();
		for (final SwiftTagListBlock seq : join(mt536.getSequenceBList()).getSubBlocks(MT536.SequenceB1a1.START_END_16RS)) {
			final MT536.SequenceB1a1 s = MT536.SequenceB1a1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT537.SequenceA1> resolveMT537GetSequenceA1List_sru2016(final MT537 mt537) {
		Validate.notNull(mt537);
		final List<MT537.SequenceA1> result = new ArrayList<MT537.SequenceA1>();
		for (final SwiftTagListBlock seq : mt537.getSequenceA().getSubBlocks(MT537.SequenceA1.START_END_16RS)) {
			final MT537.SequenceA1 s = MT537.SequenceA1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT537.SequenceB> resolveMT537GetSequenceBList_sru2016(final MT537 mt537) {
		return resolveMT537GetSequenceBList_sru2016(mt537.getSwiftMessage().getBlock4());

	}
	public static List<MT537.SequenceB> resolveMT537GetSequenceBList_sru2016(final SwiftTagListBlock mt537 /* block 4 */) {
		Validate.notNull(mt537);
		final List<SequenceB> result = new ArrayList<MT537.SequenceB>();
		/*
		 * B delimiter overlaps with C3 delimiter, everything after and including C and use
		 * standard getter for B
		 */
		final List<SwiftTagListBlock> raw = mt537.removeAfterFirst(MT537.SequenceC.START_END_16RS, false).getSubBlocks(MT537.SequenceB.START_END_16RS);
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
	public static List<MT537.SequenceB1> resolveMT537GetSequenceB1List_sru2016(final MT537 mt537) {
		Validate.notNull(mt537);
		final List<MT537.SequenceB1> result = new ArrayList<MT537.SequenceB1>();
		for (final SwiftTagListBlock seq : join(mt537.getSequenceBList()).getSubBlocks(MT537.SequenceB1.START_END_16RS)) {
			final MT537.SequenceB1 s = MT537.SequenceB1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT537.SequenceB2a> resolveMT537GetSequenceB2aList_sru2016(final MT537 mt537) {
		Validate.notNull(mt537);
		final List<MT537.SequenceB2a> result = new ArrayList<MT537.SequenceB2a>();
		for (final SwiftTagListBlock seq : join(mt537.getSequenceB2List()).getSubBlocks(MT537.SequenceB2a.START_END_16RS)) {
			final MT537.SequenceB2a s = MT537.SequenceB2a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT537.SequenceB2b1> resolveMT537GetSequenceB2b1List_sru2016(final MT537 mt537) {
		Validate.notNull(mt537);
		final List<MT537.SequenceB2b1> result = new ArrayList<MT537.SequenceB2b1>();
		for (final SwiftTagListBlock seq : join(mt537.getSequenceB2List()).getSubBlocks(MT537.SequenceB2b1.START_END_16RS)) {
			final MT537.SequenceB2b1 s = MT537.SequenceB2b1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT537.SequenceC1> resolveMT537GetSequenceC1List_sru2016(final MT537 mt537) {
		Validate.notNull(mt537);
		final List<MT537.SequenceC1> result = new ArrayList<MT537.SequenceC1>();
		for (final SwiftTagListBlock seq : join(mt537.getSequenceCList()).getSubBlocks(MT537.SequenceC1.START_END_16RS)) {
			final MT537.SequenceC1 s = MT537.SequenceC1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT537.SequenceC2> resolveMT537GetSequenceC2List_sru2016(final MT537 mt537) {
		Validate.notNull(mt537);
		final List<MT537.SequenceC2> result = new ArrayList<MT537.SequenceC2>();
		for (final SwiftTagListBlock seq : join(mt537.getSequenceCList()).getSubBlocks(MT537.SequenceC2.START_END_16RS)) {
			final MT537.SequenceC2 s = MT537.SequenceC2.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT537.SequenceC2a> resolveMT537GetSequenceC2aList_sru2016(final MT537 mt537) {
		Validate.notNull(mt537);
		final List<MT537.SequenceC2a> result = new ArrayList<MT537.SequenceC2a>();
		for (final SwiftTagListBlock seq : join(mt537.getSequenceC2List()).getSubBlocks(MT537.SequenceC2a.START_END_16RS)) {
			final MT537.SequenceC2a s = MT537.SequenceC2a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT537.SequenceC3> resolveMT537GetSequenceC3List_sru2016(final MT537 mt537) {
		Validate.notNull(mt537);
		final List<MT537.SequenceC3> result = new ArrayList<MT537.SequenceC3>();
		for (final SwiftTagListBlock seq : join(mt537.getSequenceCList()).getSubBlocks(MT537.SequenceC3.START_END_16RS)) {
			final MT537.SequenceC3 s = MT537.SequenceC3.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT537.SequenceC3a> resolveMT537GetSequenceC3aList_sru2016(final MT537 mt537) {
		Validate.notNull(mt537);
		final List<MT537.SequenceC3a> result = new ArrayList<MT537.SequenceC3a>();
		for (final SwiftTagListBlock seq : join(mt537.getSequenceC3List()).getSubBlocks(MT537.SequenceC3a.START_END_16RS)) {
			final MT537.SequenceC3a s = MT537.SequenceC3a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT537.SequenceB2b> resolveMT537GetSequenceB2bList_sru2016(final MT537 mt537) {
		Validate.notNull(mt537);
		final List<MT537.SequenceB2b> result = new ArrayList<MT537.SequenceB2b>();
		for (final SwiftTagListBlock seq : join(mt537.getSequenceB2List()).getSubBlocks(MT537.SequenceB2b.START_END_16RS)) {
			final MT537.SequenceB2b s = MT537.SequenceB2b.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT538.SequenceA1> resolveMT538GetSequenceA1List_sru2016(final MT538 mt538) {
		Validate.notNull(mt538);
		final List<MT538.SequenceA1> result = new ArrayList<MT538.SequenceA1>();
		for (final SwiftTagListBlock seq : mt538.getSequenceA().getSubBlocks(MT538.SequenceA1.START_END_16RS)) {
			final MT538.SequenceA1 s = MT538.SequenceA1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT538.SequenceB2a1> resolveMT538GetSequenceB2a1List_sru2016(final MT538 mt538) {
		Validate.notNull(mt538);
		final List<MT538.SequenceB2a1> result = new ArrayList<MT538.SequenceB2a1>();
		for (final SwiftTagListBlock seq : join(mt538.getSequenceBList()).getSubBlocks(MT538.SequenceB2a1.START_END_16RS)) {
			final MT538.SequenceB2a1 s = MT538.SequenceB2a1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static MT564.SequenceB1 resolveMT564GetSequenceB1_sru2016(final MT564 mt564) {
		Validate.notNull(mt564);
		final MT564.SequenceB1 result = MT564.SequenceB1.newInstance();
		result.clear().append(mt564.getSequenceB().getSubBlock(MT564.SequenceB1.START_END_16RS));
		return result;
	}
	public static List<MT564.SequenceE1a> resolveMT564GetSequenceE1aList_sru2016(final MT564 mt564) {
		Validate.notNull(mt564);
		final List<MT564.SequenceE1a> result = new ArrayList<MT564.SequenceE1a>();
		for (final SwiftTagListBlock seq : join(mt564.getSequenceEList()).getSubBlocks(MT564.SequenceE1a.START_END_16RS)) {
			final MT564.SequenceE1a s = MT564.SequenceE1a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT566.SequenceB1> resolveMT566GetSequenceB1List_sru2016(final MT566 mt566) {
		Validate.notNull(mt566);
		final List<MT566.SequenceB1> result = new ArrayList<MT566.SequenceB1>();
		for (final SwiftTagListBlock seq : mt566.getSequenceB().getSubBlocks(MT566.SequenceB1.START_END_16RS)) {
			final MT566.SequenceB1 s = MT566.SequenceB1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT566.SequenceD1a> resolveMT566GetSequenceD1aList_sru2016(final MT566 mt566) {
		Validate.notNull(mt566);
		final List<MT566.SequenceD1a> result = new ArrayList<MT566.SequenceD1a>();
		for (final SwiftTagListBlock seq : mt566.getSequenceD().getSubBlocks(MT566.SequenceD1a.START_END_16RS)) {
			final MT566.SequenceD1a s = MT566.SequenceD1a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT575.SequenceA1> resolveMT575GetSequenceA1List_sru2016(final MT575 mt575) {
		Validate.notNull(mt575);
		final List<MT575.SequenceA1> result = new ArrayList<MT575.SequenceA1>();
		for (final SwiftTagListBlock seq : mt575.getSequenceA().getSubBlocks(MT575.SequenceA1.START_END_16RS)) {
			final MT575.SequenceA1 s = MT575.SequenceA1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT575.SequenceB1a1> resolveMT575GetSequenceB1a1List_sru2016(final MT575 mt575) {
		Validate.notNull(mt575);
		final List<MT575.SequenceB1a1> result = new ArrayList<MT575.SequenceB1a1>();
		for (final SwiftTagListBlock seq : join(mt575.getSequenceB1aList()).getSubBlocks(MT575.SequenceB1a1.START_END_16RS)) {
			final MT575.SequenceB1a1 s = MT575.SequenceB1a1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT575.SequenceB1a4> resolveMT575GetSequenceB1a4List_sru2016(final MT575 mt575) {
		Validate.notNull(mt575);
		final List<MT575.SequenceB1a4> result = new ArrayList<MT575.SequenceB1a4>();
		for (final SwiftTagListBlock seq : join(mt575.getSequenceB1aList()).getSubBlocks(MT575.SequenceB1a4.START_END_16RS)) {
			final MT575.SequenceB1a4 s = MT575.SequenceB1a4.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT575.SequenceC1> resolveMT575GetSequenceC1List_sru2016(final MT575 mt575) {
		Validate.notNull(mt575);
		final List<MT575.SequenceC1> result = new ArrayList<MT575.SequenceC1>();
		for (final SwiftTagListBlock seq : join(mt575.getSequenceCList()).getSubBlocks(MT575.SequenceC1.START_END_16RS)) {
			final MT575.SequenceC1 s = MT575.SequenceC1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT575.SequenceC2a> resolveMT575GetSequenceC2aList_sru2016(final MT575 mt575) {
		Validate.notNull(mt575);
		final List<MT575.SequenceC2a> result = new ArrayList<MT575.SequenceC2a>();
		for (final SwiftTagListBlock seq : join(mt575.getSequenceC2List()).getSubBlocks(MT575.SequenceC2a.START_END_16RS)) {
			final MT575.SequenceC2a s = MT575.SequenceC2a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT576.SequenceA1> resolveMT576GetSequenceA1List_sru2016(final MT576 mt576) {
		Validate.notNull(mt576);
		final List<MT576.SequenceA1> result = new ArrayList<MT576.SequenceA1>();
		for (final SwiftTagListBlock seq : mt576.getSequenceA().getSubBlocks(MT576.SequenceA1.START_END_16RS)) {
			final MT576.SequenceA1 s = MT576.SequenceA1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT576.SequenceB2a> resolveMT576GetSequenceB2aList_sru2016(final MT576 mt576) {
		Validate.notNull(mt576);
		final List<MT576.SequenceB2a> result = new ArrayList<MT576.SequenceB2a>();
		for (final SwiftTagListBlock seq : join(mt576.getSequenceBList()).getSubBlocks(MT576.SequenceB2a.START_END_16RS)) {
			final MT576.SequenceB2a s = MT576.SequenceB2a.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT586.SequenceA1> resolveMT586GetSequenceA1List_sru2016(final MT586 mt586) {
		Validate.notNull(mt586);
		final List<MT586.SequenceA1> result = new ArrayList<MT586.SequenceA1>();
		for (final SwiftTagListBlock seq : mt586.getSequenceA().getSubBlocks(MT586.SequenceA1.START_END_16RS)) {
			final MT586.SequenceA1 s = MT586.SequenceA1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static List<MT586.SequenceB1> resolveMT586GetSequenceB1List_sru2016(final MT586 mt586) {
		Validate.notNull(mt586);
		final List<MT586.SequenceB1> result = new ArrayList<MT586.SequenceB1>();
		for (final SwiftTagListBlock seq : join(mt586.getSequenceBList()).getSubBlocks(MT586.SequenceB1.START_END_16RS)) {
			final MT586.SequenceB1 s = MT586.SequenceB1.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}

	public static List<MT670.SequenceB2> resolveMT670GetSequenceB2List_sru2016(final MT670 mt670) {
		Validate.notNull(mt670);
		final List<MT670.SequenceB2> result = new ArrayList<MT670.SequenceB2>();
		for (final SwiftTagListBlock seq : join(mt670.getSequenceBList()).getSubBlocks(MT670.SequenceB2.START_END_16RS)) {
			final MT670.SequenceB2 s = MT670.SequenceB2.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static MT670.SequenceC resolveMT670GetSequenceC_sru2016(final MT670 mt670) {
		Validate.notNull(mt670);
		final MT670.SequenceC result = MT670.SequenceC.newInstance();
		result.clear().append(getMT670_1_C(mt670.getSwiftMessage().getBlock4(), MT670.SequenceB.START_END_16RS));
		return result;
	}

	public static List<MT671.SequenceB2> resolveMT671GetSequenceB2List_sru2016(final MT671 mt671) {
		Validate.notNull(mt671);
		final List<MT671.SequenceB2> result = new ArrayList<MT671.SequenceB2>();
		for (final SwiftTagListBlock seq : join(mt671.getSequenceBList()).getSubBlocks(MT671.SequenceB2.START_END_16RS)) {
			final MT671.SequenceB2 s = MT671.SequenceB2.newInstance();
			s.clear().append(seq);
			result.add(s);
		}
		return result;
	}
	public static MT671.SequenceC resolveMT671GetSequenceC_sru2016(final MT671 mt671) {
		Validate.notNull(mt671);
		final MT671.SequenceC result = MT671.SequenceC.newInstance();
		result.clear().append(getMT670_1_C(mt671.getSwiftMessage().getBlock4(), MT671.SequenceB.START_END_16RS));
		return result;
	}

	private static SwiftTagListBlock getMT670_1_C(final SwiftTagListBlock b4, final String B_startEnd16rs) {
		/* 2016 Apr Miguel
		 * Since B contains inside a colliding sequence, with same delimiter as sequence C, if B is present we remove it to avoid ambiguity
		 */
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
