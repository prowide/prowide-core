package com.prowidesoftware.issues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.prowidesoftware.swift.model.mt.mt5xx.MT537;
import java.util.List;
import org.junit.jupiter.api.Test;

public class Issue78 {

    @Test
    public void test() {
        String fin =
                "{1:F01XXXXXXX0AXXX0400996471}{2:O5371305211201XXXXXXX0AXXX14523429742112011305N}{3:{108:GCH-xxxxxxxxxxxx}}{4:\n"
                        +
                        // sequence A
                        ":16R:GENL\n"
                        + ":28E:5/LAST\n"
                        + ":13A::STAT//513\n"
                        + ":20C::SEME//000000000000251C\n"
                        + ":23G:PENA\n"
                        + ":98A::STAT//20211130\n"
                        + ":22F::SFRE//DAIL\n"
                        + ":22F::CODE//DELT\n"
                        + ":22H::STST//PENA\n"
                        + ":95P::ACOW//XXXXXXXXX01\n"
                        + ":97A::SAFE//NONREF\n"
                        + ":17B::ACTI//Y\n"
                        + ":16S:GENL\n"
                        +

                        // sequence B
                        ":16R:STAT\n"
                        + ":25D::IPRC//CPRC\n"
                        +

                        // sequence B1
                        ":16R:REAS\n"
                        + ":24B::CAND//CANI\n"
                        + ":70D::REAS//SXAA015 - Failure of the settlement\n"
                        + "DESCRIPTION 111\n"
                        + "DESCRIPTION 112\n"
                        + "DESCRIPTION 113\n"
                        + "terparty\n"
                        + ":16S:REAS\n"
                        + ":16S:STAT\n"
                        +

                        // sequence D
                        ":16R:PENA\n"
                        + ":69A::STAT//20211101/20211130\n"
                        + ":22F::CODE//CURR\n"
                        + ":95P::ASDP//XXXXXXXXXXX\n"
                        +

                        // sequence D1
                        ":16R:PENACUR\n"
                        + ":11A::PECU//EUR\n"
                        + ":98A::DACO//20211130\n"
                        + ":95P::REPA//XXXXXXXXD01\n"
                        + ":95P::CASD//XXXXXXXXXXX\n"
                        + ":95P::DCSD//XXXXXXXXXXX\n"
                        + ":22F::TRCA//CSDP\n"
                        +

                        // sequence D1a
                        ":16R:PENACOUNT\n"
                        + ":95P::REPA//XXXXXXXXXXX\n"
                        + ":22F::TRCA//CCPA\n"
                        + ":19A::AGNT//EUR1,04\n"
                        +

                        // sequence D1a1
                        ":16R:PENDET\n"
                        + ":20C::PCOM//211130067774271\n"
                        + ":20C::PREF//N211130067774271\n"
                        + ":22H::PNTP//SEFP\n"
                        + ":22H::CALM//SECU\n"
                        + ":17B::CMPU//N\n"
                        + ":25D::PNST//ACTV\n"
                        + ":19A::AMCO//EUR1,\n"
                        + ":99A::DAAC//001\n"
                        +

                        // sequence D1a1A
                        ":16R:CALDET\n"
                        + ":98A::PEDA//20211130\n"
                        +

                        // sequence D1a1A1
                        ":16R:FIA\n"
                        + ":35B:ISIN XX000000\n"
                        + ":12A::CLAS/REGL/SOVR\n"
                        + ":92A::GOMB//0,001\n"
                        + ":16S:FIA\n"
                        + ":19A::SECU//EUR11,\n"
                        + ":16S:CALDET\n"
                        +

                        // sequence D1a1B
                        ":16R:RELTRAN\n"
                        + ":20C::ACOW//NONREF\n"
                        + ":20C::MITI//2111262161218562\n"
                        +

                        // sequence D1a1B1
                        ":16R:TRAN\n"
                        + ":22H::REDE//RECE\n"
                        + ":22H::PAYM//APMT\n"
                        + ":22F::SETR//REPU\n"
                        + ":22F::TRAN//SETT\n"
                        + ":22F::BDEV/T2S/IDVP\n"
                        + ":98A::SETT//20211129\n"
                        + ":98C::ASTS//20211126181652\n"
                        + ":98C::MTCH//20211126181652\n"
                        + ":98C::SCTS//20211130143000\n"
                        + ":97A::SAFE//XXXXXXXXXXXXXX1000XX0\n"
                        + ":95P::ACOW//XXXXXXXXX01\n"
                        + ":36B::PSTA//FAMT/50000000,\n"
                        + ":19A::PSTA//EUR1111111,\n"
                        +

                        // sequence D1a1B1a
                        ":16R:STAT\n"
                        + ":25D::SETT//PENF\n"
                        +

                        // sequence D1a1B1a1
                        ":16R:REAS\n"
                        + ":24B::PENF//CLAC\n"
                        + ":70D::REAS//SXAA015 - Failure of the settlement\n"
                        + "DESCRIPTION 101\n"
                        + "DESCRIPTION 102\n"
                        + "DESCRIPTION 103\n"
                        + ":16S:REAS\n"
                        + ":16S:STAT\n"
                        + ":16S:TRAN\n"
                        + ":16S:RELTRAN\n"
                        + ":16S:PENDET\n"
                        +

                        // sequence D1a1 [2]
                        ":16R:PENDET\n"
                        + ":20C::PCOM//211130067807953\n"
                        + ":20C::PREF//N211130067807953\n"
                        + ":22H::PNTP//SEFP\n"
                        + ":22H::CALM//SECU\n"
                        + ":17B::CMPU//N\n"
                        + ":25D::PNST//ACTV\n"
                        + ":19A::AMCO//EUR111,5\n"
                        + ":99A::DAAC//001\n"
                        + ":16R:CALDET\n"
                        + ":98A::PEDA//20211130\n"
                        + ":16R:FIA\n"
                        + ":35B:ISIN XX00000000\n"
                        + ":12A::CLAS/REGL/SOVR\n"
                        + ":92A::GOMB//0,001\n"
                        + ":16S:FIA\n"
                        + ":19A::SECU//EUR111,5\n"
                        + ":16S:CALDET\n"
                        + ":16R:RELTRAN\n"
                        + ":20C::ACOW//NONREF\n"
                        + ":20C::MITI//2111242159118671\n"
                        + ":16R:TRAN\n"
                        + ":22H::REDE//RECE\n"
                        + ":22H::PAYM//APMT\n"
                        + ":22F::SETR//TRAD\n"
                        + ":22F::TRAN//SETT\n"
                        + ":22F::BDEV/T2S/IDVP\n"
                        + ":98A::SETT//20211125\n"
                        + ":98C::ASTS//20211124181453\n"
                        + ":98C::MTCH//20211124181453\n"
                        + ":98C::SCTS//20211130143000\n"
                        + ":97A::SAFE//XXXXXXXXXXXXXX1000X0\n"
                        + ":95P::ACOW//XXXXXXXMD01\n"
                        + ":36B::PSTA//FAMT/50000000,\n"
                        + ":19A::PSTA//EUR111111111,75\n"
                        + ":16R:STAT\n"
                        + ":25D::SETT//PENF\n"
                        + ":16R:REAS\n"
                        + ":24B::PENF//CLAC\n"
                        + ":70D::REAS//SXAA015 - Failure of the settlement\n"
                        + "DESCRIPTION 1\n"
                        + "DESCRIPTION 2\n"
                        + "DESCRIPTION 3\n"
                        + ":16S:REAS\n"
                        + ":16S:STAT\n"
                        + ":16S:TRAN\n"
                        + ":16S:RELTRAN\n"
                        + ":16S:PENDET\n"
                        +

                        // sequence D1a1 [4]
                        ":16R:PENDET\n"
                        + ":20C::PCOM//211130067821332\n"
                        + ":20C::PREF//N211130067821332\n"
                        + ":22H::PNTP//SEFP\n"
                        + ":22H::CALM//SECU\n"
                        + ":17B::CMPU//N\n"
                        + ":25D::PNST//ACTV\n"
                        + ":19A::AMCO//EUR111,\n"
                        + ":99A::DAAC//001\n"
                        + ":16R:CALDET\n"
                        + ":98A::PEDA//20211130\n"
                        + ":16R:FIA\n"
                        + ":35B:ISIN XX00000000\n"
                        + ":12A::CLAS/REGL/SOVR\n"
                        + ":92A::GOMB//0,001\n"
                        + ":16S:FIA\n"
                        + ":19A::SECU//EUR111,\n"
                        + ":16S:CALDET\n"
                        + ":16R:RELTRAN\n"
                        + ":20C::ACOW//NONREF\n"
                        + ":20C::MITI//2111242159121848\n"
                        + ":16R:TRAN\n"
                        + ":22H::REDE//RECE\n"
                        + ":22H::PAYM//APMT\n"
                        + ":22F::SETR//TRAD\n"
                        + ":22F::TRAN//SETT\n"
                        + ":22F::BDEV/T2S/IDVP\n"
                        + ":98A::SETT//20211125\n"
                        + ":98C::ASTS//20211124181533\n"
                        + ":98C::MTCH//20211124181533\n"
                        + ":98C::SCTS//20211130143000\n"
                        + ":97A::SAFE//XXXXXXXXXXD01000L10\n"
                        + ":95P::ACOW//XXXXXXXMD01\n"
                        + ":36B::PSTA//FAMT/50000000,\n"
                        + ":19A::PSTA//EUR11111111,15\n"
                        + ":16R:STAT\n"
                        + ":25D::SETT//PENF\n"
                        + ":16R:REAS\n"
                        + ":24B::PENF//CLAC\n"
                        + ":70D::REAS//SXAA015 - Failure of the settlement\n"
                        + "DESCRIPTION 10\n"
                        + "DESCRIPTION 11\n"
                        + "DESCRIPTION 12\n"
                        + ":16S:REAS\n"
                        + ":16S:STAT\n"
                        + ":16S:TRAN\n"
                        + ":16S:RELTRAN\n"
                        + ":16S:PENDET\n"
                        +

                        // sequence D1a1 [5]
                        ":16R:PENDET\n"
                        + ":20C::PCOM//211130067830614\n"
                        + ":20C::PREF//N211130067830614\n"
                        + ":22H::PNTP//SEFP\n"
                        + ":22H::CALM//SECU\n"
                        + ":17B::CMPU//N\n"
                        + ":25D::PNST//ACTV\n"
                        + ":19A::AMCO//EUR92,06\n"
                        + ":99A::DAAC//001\n"
                        + ":16R:CALDET\n"
                        + ":98A::PEDA//20211130\n"
                        + ":16R:FIA\n"
                        + ":35B:ISIN XX00000000\n"
                        + ":12A::CLAS/REGL/SOVR\n"
                        + ":92A::GOMB//0,001\n"
                        + ":16S:FIA\n"
                        + ":19A::SECU//EUR11,06\n"
                        + ":16S:CALDET\n"
                        + ":16R:RELTRAN\n"
                        + ":20C::ACOW//NONREF\n"
                        + ":20C::MITI//2111262161219993\n"
                        + ":16R:TRAN\n"
                        + ":22H::REDE//RECE\n"
                        + ":22H::PAYM//APMT\n"
                        + ":22F::SETR//REPU\n"
                        + ":22F::TRAN//SETT\n"
                        + ":22F::BDEV/T2S/IDVP\n"
                        + ":98A::SETT//20211129\n"
                        + ":98C::ASTS//20211126181705\n"
                        + ":98C::MTCH//20211126181705\n"
                        + ":98C::SCTS//20211130143000\n"
                        + ":97A::SAFE//XXXXXXXXXXXXD01000L10\n"
                        + ":95P::ACOW//XXXXXXXXX01\n"
                        + ":36B::PSTA//FAMT/7500000,\n"
                        + ":19A::PSTA//EUR11111111,85\n"
                        + ":16R:STAT\n"
                        + ":25D::SETT//PENF\n"
                        + ":16R:REAS\n"
                        + ":24B::PENF//CLAC\n"
                        + ":70D::REAS//SXAA015 - Failure of the settlement\n"
                        + "DESCRIPTION 13\n"
                        + "DESCRIPTION 14\n"
                        + "DESCRIPTION 15\n"
                        + ":16S:REAS\n"
                        + ":16S:STAT\n"
                        + ":16S:TRAN\n"
                        + ":16S:RELTRAN\n"
                        + ":16S:PENDET\n"
                        + ":16S:PENACOUNT\n"
                        + ":16S:PENACUR\n"
                        + ":16S:PENA\n"
                        + "-}{5:{CHK:0F4F93C68EA5}{TNG:}}";
        MT537 mt537 = MT537.parse(fin);
        List<MT537.SequenceB> sequences = mt537.getSequenceBList();
        assertEquals(1, sequences.size());
    }
}
