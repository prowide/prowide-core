/*
* Copyright 2006-2025 Prowide
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

import com.prowidesoftware.swift.internal.SequenceStyle;

/**
* Associates each MT with the separator style used to carve its
* sequences in block4.
*/
public enum MtSequenceSeparatorEnum {

    MT008(SequenceStyle.Type.CUSTOM),
    MT009(SequenceStyle.Type.CUSTOM),
    MT010(SequenceStyle.Type.CUSTOM),
    MT011(SequenceStyle.Type.CUSTOM),
    MT012(SequenceStyle.Type.CUSTOM),
    MT015(SequenceStyle.Type.CUSTOM),
    MT019(SequenceStyle.Type.CUSTOM),
    MT020(SequenceStyle.Type.CUSTOM),
    MT021(SequenceStyle.Type.CUSTOM),
    MT022(SequenceStyle.Type.CUSTOM),
    MT023(SequenceStyle.Type.CUSTOM),
    MT024(SequenceStyle.Type.CUSTOM),
    MT025(SequenceStyle.Type.CUSTOM),
    MT026(SequenceStyle.Type.CUSTOM),
    MT027(SequenceStyle.Type.CUSTOM),
    MT028(SequenceStyle.Type.CUSTOM),
    MT029(SequenceStyle.Type.CUSTOM),
    MT031(SequenceStyle.Type.CUSTOM),
    MT032(SequenceStyle.Type.CUSTOM),
    MT035(SequenceStyle.Type.CUSTOM),
    MT036(SequenceStyle.Type.CUSTOM),
    MT037(SequenceStyle.Type.CUSTOM),
    MT041(SequenceStyle.Type.CUSTOM),
    MT042(SequenceStyle.Type.CUSTOM),
    MT043(SequenceStyle.Type.CUSTOM),
    MT044(SequenceStyle.Type.CUSTOM),
    MT045(SequenceStyle.Type.CUSTOM),
    MT046(SequenceStyle.Type.CUSTOM),
    MT047(SequenceStyle.Type.CUSTOM),
    MT048(SequenceStyle.Type.CUSTOM),
    MT049(SequenceStyle.Type.CUSTOM),
    MT051(SequenceStyle.Type.CUSTOM),
    MT052(SequenceStyle.Type.CUSTOM),
    MT055(SequenceStyle.Type.CUSTOM),
    MT056(SequenceStyle.Type.CUSTOM),
    MT057(SequenceStyle.Type.CUSTOM),
    MT061(SequenceStyle.Type.CUSTOM),
    MT062(SequenceStyle.Type.CUSTOM),
    MT063(SequenceStyle.Type.CUSTOM),
    MT064(SequenceStyle.Type.CUSTOM),
    MT065(SequenceStyle.Type.CUSTOM),
    MT066(SequenceStyle.Type.CUSTOM),
    MT067(SequenceStyle.Type.CUSTOM),
    MT068(SequenceStyle.Type.CUSTOM),
    MT069(SequenceStyle.Type.CUSTOM),
    MT070(SequenceStyle.Type.CUSTOM),
    MT071(SequenceStyle.Type.CUSTOM),
    MT072(SequenceStyle.Type.CUSTOM),
    MT073(SequenceStyle.Type.CUSTOM),
    MT074(SequenceStyle.Type.CUSTOM),
    MT077(SequenceStyle.Type.CUSTOM),
    MT081(SequenceStyle.Type.CUSTOM),
    MT082(SequenceStyle.Type.CUSTOM),
    MT083(SequenceStyle.Type.CUSTOM),
    MT090(SequenceStyle.Type.CUSTOM),
    MT092(SequenceStyle.Type.CUSTOM),
    MT094(SequenceStyle.Type.CUSTOM),
    MT096(SequenceStyle.Type.CUSTOM),
    MT097(SequenceStyle.Type.CUSTOM),
    MT101(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT102(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT103(SequenceStyle.Type.CUSTOM),
    MT104(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT105(SequenceStyle.Type.CUSTOM),
    MT107(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT110(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT111(SequenceStyle.Type.CUSTOM),
    MT112(SequenceStyle.Type.CUSTOM),
    MT190(SequenceStyle.Type.CUSTOM),
    MT191(SequenceStyle.Type.CUSTOM),
    MT192(SequenceStyle.Type.CUSTOM),
    MT195(SequenceStyle.Type.CUSTOM),
    MT196(SequenceStyle.Type.CUSTOM),
    MT198(SequenceStyle.Type.CUSTOM),
    MT199(SequenceStyle.Type.CUSTOM),
    MT200(SequenceStyle.Type.CUSTOM),
    MT201(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT202(SequenceStyle.Type.CUSTOM),
    MT203(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT204(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT205(SequenceStyle.Type.CUSTOM),
    MT210(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT290(SequenceStyle.Type.CUSTOM),
    MT291(SequenceStyle.Type.CUSTOM),
    MT292(SequenceStyle.Type.CUSTOM),
    MT295(SequenceStyle.Type.CUSTOM),
    MT296(SequenceStyle.Type.CUSTOM),
    MT298(SequenceStyle.Type.CUSTOM),
    MT299(SequenceStyle.Type.CUSTOM),
    MT300(SequenceStyle.Type.SPLIT_BY_15),
    MT304(SequenceStyle.Type.SPLIT_BY_15),
    MT305(SequenceStyle.Type.SPLIT_BY_15),
    MT306(SequenceStyle.Type.SPLIT_BY_15),
    MT320(SequenceStyle.Type.SPLIT_BY_15),
    MT321(SequenceStyle.Type.GENERATED_16RS),
    MT330(SequenceStyle.Type.SPLIT_BY_15),
    MT340(SequenceStyle.Type.SPLIT_BY_15),
    MT341(SequenceStyle.Type.SPLIT_BY_15),
    MT350(SequenceStyle.Type.SPLIT_BY_15),
    MT360(SequenceStyle.Type.SPLIT_BY_15),
    MT361(SequenceStyle.Type.SPLIT_BY_15),
    MT362(SequenceStyle.Type.SPLIT_BY_15),
    MT364(SequenceStyle.Type.SPLIT_BY_15),
    MT365(SequenceStyle.Type.SPLIT_BY_15),
    MT370(SequenceStyle.Type.GENERATED_16RS),
    MT380(SequenceStyle.Type.GENERATED_16RS),
    MT381(SequenceStyle.Type.GENERATED_16RS),
    MT390(SequenceStyle.Type.CUSTOM),
    MT391(SequenceStyle.Type.CUSTOM),
    MT392(SequenceStyle.Type.CUSTOM),
    MT395(SequenceStyle.Type.CUSTOM),
    MT396(SequenceStyle.Type.CUSTOM),
    MT398(SequenceStyle.Type.CUSTOM),
    MT399(SequenceStyle.Type.CUSTOM),
    MT400(SequenceStyle.Type.CUSTOM),
    MT410(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT412(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT416(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT420(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT422(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT430(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT450(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT455(SequenceStyle.Type.CUSTOM),
    MT456(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT490(SequenceStyle.Type.CUSTOM),
    MT491(SequenceStyle.Type.CUSTOM),
    MT492(SequenceStyle.Type.CUSTOM),
    MT495(SequenceStyle.Type.CUSTOM),
    MT496(SequenceStyle.Type.CUSTOM),
    MT498(SequenceStyle.Type.CUSTOM),
    MT499(SequenceStyle.Type.CUSTOM),
    MT500(SequenceStyle.Type.GENERATED_16RS),
    MT501(SequenceStyle.Type.GENERATED_16RS),
    MT502(SequenceStyle.Type.GENERATED_16RS),
    MT503(SequenceStyle.Type.GENERATED_16RS),
    MT504(SequenceStyle.Type.GENERATED_16RS),
    MT505(SequenceStyle.Type.GENERATED_16RS),
    MT506(SequenceStyle.Type.GENERATED_16RS),
    MT507(SequenceStyle.Type.GENERATED_16RS),
    MT508(SequenceStyle.Type.GENERATED_16RS),
    MT509(SequenceStyle.Type.GENERATED_16RS),
    MT510(SequenceStyle.Type.GENERATED_16RS),
    MT513(SequenceStyle.Type.GENERATED_16RS),
    MT514(SequenceStyle.Type.GENERATED_16RS),
    MT515(SequenceStyle.Type.GENERATED_16RS),
    MT516(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT517(SequenceStyle.Type.GENERATED_16RS),
    MT518(SequenceStyle.Type.GENERATED_16RS),
    MT519(SequenceStyle.Type.GENERATED_16RS),
    MT524(SequenceStyle.Type.GENERATED_16RS),
    MT526(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT527(SequenceStyle.Type.GENERATED_16RS),
    MT530(SequenceStyle.Type.GENERATED_16RS),
    MT535(SequenceStyle.Type.GENERATED_16RS),
    MT536(SequenceStyle.Type.GENERATED_16RS),
    MT537(SequenceStyle.Type.GENERATED_16RS),
    MT538(SequenceStyle.Type.GENERATED_16RS),
    MT540(SequenceStyle.Type.GENERATED_16RS),
    MT541(SequenceStyle.Type.GENERATED_16RS),
    MT542(SequenceStyle.Type.GENERATED_16RS),
    MT543(SequenceStyle.Type.GENERATED_16RS),
    MT544(SequenceStyle.Type.GENERATED_16RS),
    MT545(SequenceStyle.Type.GENERATED_16RS),
    MT546(SequenceStyle.Type.GENERATED_16RS),
    MT547(SequenceStyle.Type.GENERATED_16RS),
    MT548(SequenceStyle.Type.GENERATED_16RS),
    MT549(SequenceStyle.Type.GENERATED_16RS),
    MT558(SequenceStyle.Type.GENERATED_16RS),
    MT564(SequenceStyle.Type.GENERATED_16RS),
    MT565(SequenceStyle.Type.GENERATED_16RS),
    MT566(SequenceStyle.Type.GENERATED_16RS),
    MT567(SequenceStyle.Type.GENERATED_16RS),
    MT568(SequenceStyle.Type.GENERATED_16RS),
    MT569(SequenceStyle.Type.GENERATED_16RS),
    MT575(SequenceStyle.Type.GENERATED_16RS),
    MT576(SequenceStyle.Type.GENERATED_16RS),
    MT578(SequenceStyle.Type.GENERATED_16RS),
    MT581(SequenceStyle.Type.CUSTOM),
    MT586(SequenceStyle.Type.GENERATED_16RS),
    MT590(SequenceStyle.Type.CUSTOM),
    MT591(SequenceStyle.Type.CUSTOM),
    MT592(SequenceStyle.Type.CUSTOM),
    MT595(SequenceStyle.Type.CUSTOM),
    MT596(SequenceStyle.Type.CUSTOM),
    MT598(SequenceStyle.Type.CUSTOM),
    MT599(SequenceStyle.Type.CUSTOM),
    MT600(SequenceStyle.Type.SPLIT_BY_15),
    MT601(SequenceStyle.Type.SPLIT_BY_15),
    MT604(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT605(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT606(SequenceStyle.Type.CUSTOM),
    MT607(SequenceStyle.Type.CUSTOM),
    MT608(SequenceStyle.Type.CUSTOM),
    MT620(SequenceStyle.Type.SPLIT_BY_15),
    MT670(SequenceStyle.Type.GENERATED_16RS),
    MT671(SequenceStyle.Type.GENERATED_16RS),
    MT690(SequenceStyle.Type.CUSTOM),
    MT691(SequenceStyle.Type.CUSTOM),
    MT692(SequenceStyle.Type.CUSTOM),
    MT695(SequenceStyle.Type.CUSTOM),
    MT696(SequenceStyle.Type.CUSTOM),
    MT698(SequenceStyle.Type.CUSTOM),
    MT699(SequenceStyle.Type.CUSTOM),
    MT700(SequenceStyle.Type.CUSTOM),
    MT701(SequenceStyle.Type.CUSTOM),
    MT705(SequenceStyle.Type.CUSTOM),
    MT707(SequenceStyle.Type.CUSTOM),
    MT708(SequenceStyle.Type.CUSTOM),
    MT710(SequenceStyle.Type.CUSTOM),
    MT711(SequenceStyle.Type.CUSTOM),
    MT720(SequenceStyle.Type.CUSTOM),
    MT721(SequenceStyle.Type.CUSTOM),
    MT730(SequenceStyle.Type.CUSTOM),
    MT732(SequenceStyle.Type.CUSTOM),
    MT734(SequenceStyle.Type.CUSTOM),
    MT740(SequenceStyle.Type.CUSTOM),
    MT742(SequenceStyle.Type.CUSTOM),
    MT744(SequenceStyle.Type.CUSTOM),
    MT747(SequenceStyle.Type.CUSTOM),
    MT750(SequenceStyle.Type.CUSTOM),
    MT752(SequenceStyle.Type.CUSTOM),
    MT754(SequenceStyle.Type.CUSTOM),
    MT756(SequenceStyle.Type.CUSTOM),
    MT759(SequenceStyle.Type.CUSTOM),
    MT760(SequenceStyle.Type.SPLIT_BY_15),
    MT761(SequenceStyle.Type.CUSTOM),
    MT765(SequenceStyle.Type.CUSTOM),
    MT767(SequenceStyle.Type.SPLIT_BY_15),
    MT768(SequenceStyle.Type.CUSTOM),
    MT769(SequenceStyle.Type.CUSTOM),
    MT775(SequenceStyle.Type.CUSTOM),
    MT785(SequenceStyle.Type.CUSTOM),
    MT786(SequenceStyle.Type.CUSTOM),
    MT787(SequenceStyle.Type.CUSTOM),
    MT790(SequenceStyle.Type.CUSTOM),
    MT791(SequenceStyle.Type.CUSTOM),
    MT792(SequenceStyle.Type.CUSTOM),
    MT795(SequenceStyle.Type.CUSTOM),
    MT796(SequenceStyle.Type.CUSTOM),
    MT798(SequenceStyle.Type.CUSTOM),
    MT799(SequenceStyle.Type.CUSTOM),
    MT801(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT802(SequenceStyle.Type.CUSTOM),
    MT890(SequenceStyle.Type.CUSTOM),
    MT891(SequenceStyle.Type.CUSTOM),
    MT892(SequenceStyle.Type.CUSTOM),
    MT895(SequenceStyle.Type.CUSTOM),
    MT896(SequenceStyle.Type.CUSTOM),
    MT898(SequenceStyle.Type.CUSTOM),
    MT899(SequenceStyle.Type.CUSTOM),
    MT900(SequenceStyle.Type.CUSTOM),
    MT910(SequenceStyle.Type.CUSTOM),
    MT920(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT935(SequenceStyle.Type.CUSTOM),
    MT940(SequenceStyle.Type.CUSTOM),
    MT941(SequenceStyle.Type.CUSTOM),
    MT942(SequenceStyle.Type.CUSTOM),
    MT950(SequenceStyle.Type.CUSTOM),
    MT970(SequenceStyle.Type.CUSTOM),
    MT971(SequenceStyle.Type.CUSTOM),
    MT972(SequenceStyle.Type.CUSTOM),
    MT973(SequenceStyle.Type.GENERATED_FIXED_WITH_OPTIONAL_TAIL),
    MT985(SequenceStyle.Type.CUSTOM),
    MT986(SequenceStyle.Type.CUSTOM),
    MT990(SequenceStyle.Type.CUSTOM),
    MT991(SequenceStyle.Type.CUSTOM),
    MT992(SequenceStyle.Type.CUSTOM),
    MT995(SequenceStyle.Type.CUSTOM),
    MT996(SequenceStyle.Type.CUSTOM),
    MT998(SequenceStyle.Type.CUSTOM),
    MT999(SequenceStyle.Type.CUSTOM),
    UNKNOWN(SequenceStyle.Type.CUSTOM);

    private final SequenceStyle.Type style;

    MtSequenceSeparatorEnum(SequenceStyle.Type style) {
        this.style = style;
    }

    public SequenceStyle.Type style() {
        return style;
    }

    /**
    * Resolves an enum constant from an MT identifier.
    *
    * @param mtId any string containing the three digit MT number
    *             (e.g. {@code "103"}, {@code "103_STP"}, {@code "MT103"})
    * @return a matching constant, or {@link #UNKNOWN} if not recognised
    */
    public static MtSequenceSeparatorEnum from(String mtId) {
        if (mtId == null)
            return UNKNOWN;
        String key = "MT" + mtId.replaceAll("[^0-9]", "");
        try {
            return valueOf(key);
        } catch (Exception e) {
            return UNKNOWN;
        }
    }

    /** @return {@code true} if the message uses the field 15 splitter */
    public static boolean isSplitBy15(String mtId) {
        MtSequenceSeparatorEnum from = from(mtId);
        return SequenceStyle.Type.SPLIT_BY_15.equals(from.style);
    }

    /** @return {@code true} if the message uses 16R/16S delimiters */
    public static boolean isGenerated16RS(String mtId) {
        MtSequenceSeparatorEnum from = from(mtId);
        return SequenceStyle.Type.GENERATED_16RS.equals(from.style);
    }
}
