package com.prowidesoftware.swift.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.Error;
import com.networknt.schema.InputFormat;
import com.networknt.schema.Schema;
import com.networknt.schema.SchemaRegistry;
import com.networknt.schema.SpecificationVersion;
import java.io.InputStream;
import java.util.List;
import org.junit.jupiter.api.Test;

public class MtSwiftMessageJsonSchemaTest {

    public static boolean validateSchema(String jsonMsg) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        try (InputStream in =
                MtSwiftMessageJsonSchemaTest.class.getResourceAsStream("/MtSwiftMessageJsonSchema.json")) {
            if (in == null) {
                throw new IllegalStateException("Schema not found in classpath");
            }
            JsonNode schemaNode = mapper.readTree(in);

            SchemaRegistry schemaRegistry = SchemaRegistry.withDefaultDialect(SpecificationVersion.DRAFT_2020_12);
            Schema schema = schemaRegistry.getSchema(schemaNode);
            schema.initializeValidators();

            List<Error> errors = schema.validate(jsonMsg, InputFormat.JSON);
            return errors.isEmpty();
        }
    }

    @Test
    public void test_103_input() throws Exception {
        String m = "{1:F01FOOLARB1X0B28683497518}{2:I103ESPBESMMAXXXU2}{3:{108:FOOB3926BE868XXX}}{4:\n"
                + ":20:REFERENCE\n"
                + ":23B:CRED\n"
                + ":32A:130204USD1234567,89\n"
                + ":50A:/12345678901234567890\n"
                + "CFIMHKH1XXX\n"
                + ":59:/12345678901234567890\n"
                + "JOE DOE\n"
                + "MyStreet 1234\n"
                + ":71A:OUR\n"
                + "-}{5:{CHK:3916EF336FF7}";

        final MtSwiftMessage mt = new MtSwiftMessage(m);
        final String json = mt.toJson();
        assertTrue(validateSchema(json));
    }

    @Test
    public void test_103_output() throws Exception {
        String m =
                "{1:F01FOOLARB1A0B12349797518}{2:O1031534051028ESPBESMMAXXX54237522120510281748N}{3:{113:ROMF}{108:0510280182794663}{119:STP}}{4:\n"
                        + ":20:0061350113089906\n"
                        + ":13C:/RNCTIME/1534+0000\n"
                        + ":23B:CRED\n"
                        + ":23E:SDVA\n"
                        + ":32A:011028EUR754321,\n"
                        + ":33B:EUR754321,\n"
                        + ":50K:/12345678\n"
                        + "FOO FOOOOOO MODERADO FOO\n"
                        + "FOOA 1234 XXXXX 33 BUZON 999\n"
                        + "28014 MADRID\n"
                        + ":52A:/3999\n"
                        + "FOOAESMMXXX\n"
                        + ":53A:FOOAESMMXXX\n"
                        + ":57A:FOOUOOYYXXX\n"
                        + ":59:/ES0123456789012345671234\n"
                        + "FOO FOOOOOO MODERADO FOO\n"
                        + ":71A:OUR\n"
                        + "-}{5:{MAC:CD672A83}{CHK:30822ED475E5}}";

        final MtSwiftMessage mt = new MtSwiftMessage(m);
        final String json = mt.toJson();
        assertTrue(validateSchema(json));
    }

    @Test
    public void test_202() throws Exception {
        String m =
                "{1:F01FOOBARYYAXXX8628453424}{2:O2021300050901FOOGLULXALTA06556102830509011300N}{3:{108:FOOB3926BE868XXX}}{4:\n"
                        + ":20:IUHZNKKTM9968908\n"
                        + ":21:IUHZNKKTM9968908\n"
                        + ":13C:/RNCTIME/1356+0000\n"
                        + ":13C:/RNCTIME/1410+0000\n"
                        + ":32A:050901EUR19265,53\n"
                        + ":52A:FOOGLULXLTA\n"
                        + ":53A:/D/1234A0123456ABC012345\n"
                        + "FOOBARYY\n"
                        + ":54A:BAPPIT21AP8\n"
                        + ":56A:BMISLBB1025\n"
                        + ":57A:HLFXGB21L17\n"
                        + ":58A:/ES12 1234 6789 1234 1111 1234\n"
                        + "SEICUS33CAI\n"
                        + ":72:/BNF/00002695 0001 2005083130110\n"
                        + "-}{5:{CHK:3916EF336FF7}";

        final MtSwiftMessage mt = new MtSwiftMessage(m);
        final String json = mt.toJson();
        assertTrue(validateSchema(json));
    }

    @Test
    public void test_199() throws Exception {
        String m =
                "{1:F01FOOUUSYYAXXX8628453424}{2:I199FOOPCHZZXXXXN}{3:{121:21b671f2-c0c8-4d78-8f98-981fbcb85248}}{4:\n"
                        + ":20:WXYZ9876TRCK\n"
                        + ":21:ABCD12345WXYZ\n"
                        + ":79://1912011123-0500\n"
                        + "//ACCC\n"
                        + "//WXYZUS33\n"
                        + "//USD470,\n"
                        + "-}";

        final MtSwiftMessage mt = new MtSwiftMessage(m);
        final String json = mt.toJson();
        assertTrue(validateSchema(json));
    }

    @Test
    public void test_300() throws Exception {
        String m = "{1:F01FOOGIT2TE36A4861316430}{2:I300CNFMGB2LXXXXN}{3:{108:YSDE193236BF5XXX}}{4:\n" + ":15A:\n"
                + ":20:161549215\n"
                + ":22A:NEWT\n"
                + ":94A:AGNT\n"
                + ":22C:CNFM2L0007GEBABB\n"
                + ":82A:FOOGIT2T36A\n"
                + ":87J:/ABIC/UKWN\n"
                + "/NAME/MAGOTTEAUX\n"
                + ":83J:/NAME/MAGOTTEAUX INTERNATIONAL SA\n"
                + ":77H:OTHER/20081006\n"
                + ":77D:/MASTER/EMAD\n"
                + ":15B:\n"
                + ":30T:20131118\n"
                + ":30V:20131118\n"
                + ":36:1,350007\n"
                + ":32B:USD788736,00\n"
                + ":57A:/D/240022543915\n"
                + "FOOGIT2T36A\n"
                + ":33B:EUR584245,86\n"
                + ":57A:/C/240022543915\n"
                + "FOOGIT2T36A\n"
                + ":15C:\n"
                + ":24D:ELEC/FXAB\n"
                + "-}{5:{CHK:067630F7738A}}";

        final MtSwiftMessage mt = new MtSwiftMessage(m);
        final String json = mt.toJson();
        assertTrue(validateSchema(json));
    }

    @Test
    public void test_320() throws Exception {
        String m =
                "{1:F01FOOYUSPPAXXX3768156193}{2:O3201139050822FOORUSZZAFXO29569650200508221139N}{3:{108:FC003105ded7970a}}{4:\n"
                        + ":15A:\n"
                        + ":20:TR858265\n"
                        + ":21:TR847341\n"
                        + ":22A:NEWT\n"
                        + ":22B:MATU\n"
                        + ":22C:FOORZZ0042FOOYPP\n"
                        + ":82A:FOOYCHZZ\n"
                        + ":87A:FOORFRPP\n"
                        + ":15B:\n"
                        + ":17R:L\n"
                        + ":30T:20010614\n"
                        + ":30V:20010618\n"
                        + ":30P:20011218\n"
                        + ":32B:CHF4000000,\n"
                        + ":32H:NCHF4084000,\n"
                        + ":34E:NCHF84000,\n"
                        + ":37G:4,2\n"
                        + ":14D:360/360\n"
                        + ":15C:\n"
                        + ":57A:FOOYCH22\n"
                        + ":15D:\n"
                        + ":53A:FOOYCH22\n"
                        + ":57A:FOOYCHZZ\n"
                        + "-}{5:{CHK:97BE21F26A78}";

        final MtSwiftMessage mt = new MtSwiftMessage(m);
        final String json = mt.toJson();
        assertTrue(validateSchema(json));
    }

    @Test
    public void test_380() throws Exception {
        String m =
                "{1:F01FOOXGB2SAXXX3768156193}{2:O3801139050822IVSIGB2SAFXO29569650200508221139N}{3:{108:FC003105ded7970a}}{4:\n"
                        + ":16R:GENL\n"
                        + ":20C::SEME//FX256\n"
                        + ":20C::FXOR//FX256\n"
                        + ":23G:NEWM\n"
                        + ":16S:GENL\n"
                        + ":16R:FXORDER\n"
                        + ":22H::BUSE//BUYI\n"
                        + ":98A::ORDR//20030226\n"
                        + ":98A::RVAL//20030228\n"
                        + ":19B::ORDR//USD10000000,\n"
                        + ":11A::CNTR//CHF\n"
                        + ":16R:ORDRPRTY\n"
                        + ":95Q::INVE//STAR INVESTMENT\n"
                        + ":97A::SAFE//GG784SS652\n"
                        + ":16S:ORDRPRTY\n"
                        + ":16S:FXORDER\n"
                        + "-}{5:{CHK:97BE21F26A78}";

        final MtSwiftMessage mt = new MtSwiftMessage(m);
        final String json = mt.toJson();
        assertTrue(validateSchema(json));
    }

    @Test
    public void test_502() throws Exception {
        String m =
                "{1:F01FOOHCH20AXXX0527012180}{2:O5020750040609LRLRUSXX4A0400004386330406090954U}{3:{108:MT502 001 OF 008}}{4:\n"
                        + ":16R:GENL\n"
                        + ":20C::SEME//01116\n"
                        + ":23G:NEWM/CODU\n"
                        + ":22F::TRTR//BASK\n"
                        + ":16R:LINK\n"
                        + ":20C::PREV//x\n"
                        + ":16S:LINK\n"
                        + ":16S:GENL\n"
                        + ":16R:ORDRDET\n"
                        + ":94B::TRAD//EXCH/XSWX\n"
                        + ":16R:PRIC\n"
                        + ":90A::LIMI//DISC/1200,\n"
                        + ":16S:PRIC\n"
                        + ":22H::BUSE//SWIT\n"
                        + ":22F::TOOR//ALNO\n"
                        + ":22H::PAYM//APMT\n"
                        + ":98A::EXPI//19991231\n"
                        + ":16R:TRADPRTY\n"
                        + ":95P::BUYR//FOOBARXX\n"
                        + ":16S:TRADPRTY\n"
                        + ":19A::ORDR//NUSD1,34\n"
                        + ":35B:ISIN MA0000011058\n"
                        + ":16S:ORDRDET\n"
                        + ":16R:SETDET\n"
                        + ":22F::SETR//COLI\n"
                        + ":16R:SETPRTY\n"
                        + ":95R::REAG/A2C4E6G8/34x\n"
                        + ":16S:SETPRTY\n"
                        + ":16R:SETPRTY\n"
                        + ":95R::BUYR/A2C4E6G8/34x\n"
                        + ":16S:SETPRTY\n"
                        + ":16R:SETPRTY\n"
                        + ":95R::RECU/A2C4E6G8/34x\n"
                        + ":16S:SETPRTY\n"
                        + ":16R:SETPRTY\n"
                        + ":95R::DEAG/A2C4E6G8/34x\n"
                        + ":16S:SETPRTY\n"
                        + ":16R:SETPRTY\n"
                        + ":95P::PSET//FOOBARYY\n"
                        + ":16S:SETPRTY\n"
                        + ":16S:SETDET\n"
                        + "-}{5:{MAC:307F606D}{CHK:521A0E3826D3}}";

        final MtSwiftMessage mt = new MtSwiftMessage(m);
        final String json = mt.toJson();
        assertTrue(validateSchema(json));
    }

    @Test
    public void test_535() throws Exception {
        String m = "{1:F01FOOBARXXAXXX0387240778}{2:O5350029060914FOOBARXXXXXX03549878070609140029N}{4:\n"
                + ":16R:GENL\n"
                + ":28E:00005/MORE\n"
                + ":20C::SEME//ICF2750609140005\n"
                + ":23G:NEWM\n"
                + ":98A::STAT//20060913\n"
                + ":22F::SFRE//DAIL\n"
                + ":22F::CODE//COMP\n"
                + ":22F::STTY//CUST\n"
                + ":22F::STBA//TRAD\n"
                + ":97A::SAFE//F275\n"
                + ":17B::ACTI//Y\n"
                + ":17B::AUDT//N\n"
                + ":17B::CONS//N\n"
                + ":16S:GENL\n"
                + ":16R:SUBSAFE\n"
                + ":16R:FIN\n"
                + ":35B:/US/31392EXH8\n"
                + "FEDERAL NATL MTG ASSN\n"
                + ":16R:FIA\n"
                + ":92A::CUFC//0,14528727\n"
                + ":16S:FIA\n"
                + ":93B::AGGR//FAMT/35732656,\n"
                + ":93B::AVAI//FAMT/35732656,\n"
                + ":16R:SUBBAL\n"
                + ":93B::AGGR//FAMT/35732656,\n"
                + ":94F::SAFE//NCSD/FOOBUS33\n"
                + ":16S:SUBBAL\n"
                + ":16S:FIN\n"
                + ":16R:FIN\n"
                + ":35B:/US/31406RR72\n"
                + "FNMA POOL 817810\n"
                + ":16R:FIA\n"
                + ":92A::CUFC//0,000000\n"
                + ":16S:FIA\n"
                + ":93B::AGGR//AMOR/0,\n"
                + ":93B::AVAI//FAMT/N990692,\n"
                + ":93B::NAVL//FAMT/990692,\n"
                + ":16R:SUBBAL\n"
                + ":93B::AGGR//FAMT/0,\n"
                + ":93B::AVAI//FAMT/N990692,\n"
                + ":93B::NAVL//FAMT/990692,\n"
                + ":94F::SAFE//NCSD/FOOBUS33\n"
                + ":16S:SUBBAL\n"
                + ":16S:FIN\n"
                + ":16S:SUBSAFE\n"
                + "-}{5:{MAC:E19445CF}{CHK:D625798DFC51}";

        final MtSwiftMessage mt = new MtSwiftMessage(m);
        final String json = mt.toJson();
        assertTrue(validateSchema(json));
    }

    @Test
    public void test_540() throws Exception {
        String m = "{1:F01TESTUS20AXXX0000000000}{2:I540FOOXUS3NXXXXN}{4:\n"
                + ":16R:GENL\n"
                + ":20C::SEME//GC899999\n"
                + ":23G:NEWM/COPY\n"
                + ":98A::PREP//20170729\n"
                + ":16R:LINK\n"
                + ":20C::COMM//CMID2233\n"
                + ":16S:LINK\n"
                + ":16S:GENL\n"
                + ":16R:TRADDET\n"
                + ":98C::SETT//20170729105244\n"
                + ":35B:ISIN AAA222341223\n"
                + ":16S:TRADDET\n"
                + ":16R:FIAC\n"
                + ":36B::SETT//UNIT/1,\n"
                + ":97B::SAFE/SA22/AS11/123456\n"
                + ":16S:FIAC\n"
                + ":16R:SETDET\n"
                + ":22F::SETR//BSBK\n"
                + ":16R:SETPRTY\n"
                + ":95Q::PSET//Foo name and address in a large lin\n"
                + "e of text\n"
                + ":16S:SETPRTY\n"
                + ":16R:SETPRTY\n"
                + ":95P::BUYR//FOOFBRXXXXX\n"
                + ":98A::PROC//20170809\n"
                + ":16S:SETPRTY\n"
                + ":16R:SETPRTY\n"
                + ":95P::SELL//FOOBARXXXXX\n"
                + ":16S:SETPRTY\n"
                + ":16R:SETPRTY\n"
                + ":95Q::DEAG//Other party name and address\n"
                + ":98A::PROC//20180315\n"
                + ":16S:SETPRTY\n"
                + ":16R:SETPRTY\n"
                + ":95P::REAG//FOORUSNYXXX\n"
                + ":16S:SETPRTY\n"
                + ":16S:SETDET\n"
                + "-}";

        final MtSwiftMessage mt = new MtSwiftMessage(m);
        final String json = mt.toJson();
        assertTrue(validateSchema(json));
    }

    @Test
    public void test_720() throws Exception {
        String m = "{1:F01FOOHGB20A36A6294534377}{2:I720FOOXSGS0XXXXN}{4:\n"
                + ":27:1/1\n"
                + ":40B:IRREVOCABLE\n"
                + "ADDING OUR CONFIRMATION\n"
                + ":20:IMP124678\n"
                + ":21:DAE74568\n"
                + ":31C:130721\n"
                + ":40E:UCP LATEST VERSION\n"
                + ":31D:130930LONDON\n"
                + ":52A:FOOBARXX\n"
                + ":50:LONDON MOTOSPARES LTD\n"
                + "12 CYCLE SQUARE\n"
                + "UK/LONDON\n"
                + ":59:CYCLIST LTD\n"
                + "498 WHEELER ST\n"
                + "SG/SINGAPORE\n"
                + ":32B:GBP100000,\n"
                + ":39C:FREIGHT MAY BE PAID IN EXCESS OF\n"
                + "CREDIT AMOUNT AGAINST FREIGHTNOTE\n"
                + "IN WHICH CASE CTD TO BE STAMPED\n"
                + "FREIGHT PREPAID\n"
                + ":41A:FOOHGB2L\n"
                + "BY PAYMENT\n"
                + ":43P:NOT ALLOWED\n"
                + ":43T:ALLOWED\n"
                + ":44A:SINGAPORE\n"
                + ":44B:ROTTERDAM\n"
                + ":45A:+400 FUEL TANKS MODEL 1320 AA CONT. 10 GALL.\n"
                + "+120 CLUTCHES 4 GANGS MODEL A 154\n"
                + "+800 CYLINDERS 150CCMODEL C45-15\n"
                + "+600 REAR WHEELS COMPLETE 28 IN MAGNESIUM MODEL MW 123-28\n"
                + "+120 FUEL-INJECTION SETS COMPLETE MODEL A 156-F\n"
                + "+FCA SINGAPORE\n"
                + ":46A:+SIGNED COMMERCIAL INVOICE IN FIVE-FOLD\n"
                + "+COMBINED TRANSPORT DOCUMENTS (FULL SET) EVIDENCING TAKING IN\n"
                + "CHARGE OF THE MERCHANDISE AS A FULL CONTAINER LOAD FOR SHIPMENT\n"
                + "BY OCEAN VESSEL TO ROTTERDAM ISSUED TO THE ORDER AND BLANK\n"
                + "ENDORSED DATED NOT LATER THAN 030920\n"
                + "+PACKING LIST IN FIVE-FOLD\n"
                + "+DECLARATION ISSUED BY THE COMPANY UNDERSIGNING THE CTD THAT\n"
                + "THE GOODS WILL BE SENT BY VESSEL PLYING IN REGULAR LINE SERVICE\n"
                + ":48:10/CTD\n"
                + ":49:WITHOUT\n"
                + "-}";

        final MtSwiftMessage mt = new MtSwiftMessage(m);
        final String json = mt.toJson();
        assertTrue(validateSchema(json));
    }

    @Test
    public void test_767() throws Exception {
        String m = "{1:F01FOOPGB20D36A6294534377}{2:I767FOOLUS60XXXXN}{4:\n" + ":15A:\n"
                + ":27:1/1\n"
                + ":21:RELTXN12345\n"
                + ":22A:ICCA\n"
                + ":72Z:<Sender> to <Reciever> message\n"
                + ":15B:\n"
                + ":20:PG8761234\n"
                + ":26E:2\n"
                + ":30:120501\n"
                + ":52A:FOOPGB2L\n"
                + ":32B:GBP38000,\n"
                + ":77U:WE, NATIONAL WESTMINSTER BANK, LONDON, HEREBY UNDERTAKE\n"
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
                + "THE JURISDICTION OF THE COURTS OF ENGLAND IN THIS REGARD.\n"
                + ":24G:BENE\n"
                + ":15C:\n"
                + ":32B:GBP38000,\n"
                + "-}";

        final MtSwiftMessage mt = new MtSwiftMessage(m);
        final String json = mt.toJson();
        assertTrue(validateSchema(json));
    }

    @Test
    public void test_950() throws Exception {
        String m =
                "{1:F01FOOBARXXAXXX0387241036}{2:O9502352060913YYYYUSYYYYYY18884819330609140052N}{3:{108:0000000309140009}}{4:\n"
                        + ":20:123456\n"
                        + ":25:123 456789\n"
                        + ":28C:102\n"
                        + ":60F:C020527EUR3723495,\n"
                        + ":61:020528D1,2FBNK505064/DEV//67914\n"
                        + ":61:020528D30,2NCHK21088//123464\n"
                        + ":61:020528D250,NCHK32177//123460\n"
                        + ":61:020528D450,S103505066/WVE//P064118\n"
                        + "FAVOUR K. DESMID\n"
                        + ":61:020528D500,NCH44366//123456\n"
                        + ":61:020528D1058,47S103505068//3841188\n"
                        + "FAVOUR H. F. JASSEN\n"
                        + ":61:020528D2500,NCHK43271//123457\n"
                        + ":61:020528D3840,S103505064//3841189\n"
                        + "FAVOUR H. F. JANSSEN\n"
                        + ":61:020528D5000,S20076/799483//47829\n"
                        + "ORDER ROTTERDAM\n"
                        + ":62F:C020528EUR3709865,13\n"
                        + "-}{5:{CHK:C0EB56371C00}";

        final MtSwiftMessage mt = new MtSwiftMessage(m);
        final String json = mt.toJson();
        assertTrue(validateSchema(json));
    }
}
