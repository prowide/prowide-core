package com.prowidesoftware.swift.issues;
import java.io.IOException;

import com.prowidesoftware.swift.io.ConversionService;
import com.prowidesoftware.swift.io.IConversionService;
import com.prowidesoftware.swift.io.parser.SwiftParser;

import junit.framework.TestCase;

public class Bug3085740 extends TestCase {

  private String expectedMT940 = "{1:F01XXXXXXXXAXXX0000000000}{2:I940XXXXXXXXXXXXN}{4:\r\n" +
								":20:REFXXXXX\r\n" +
								":25:K005201001004509050156\r\n" +
								":28C:00001\r\n" +
								":60F:C051007XOF2644893271,0\r\n" +
								":61:0710241024DF4105400,0FMSC1234567890\r\n" +
								"TEST LIBELLE\r\n" +
								":61:0710251025DF3000000000,0FMSC1234567890\r\n" +
								"TEST LIBELLE\r\n" +
								":61:0710251025CF959919691,0FMSC1234567890\r\n" +
								"TEST LIBELLE\r\n" +
								":61:0710251025CF523237057,0FMSC1234567890\r\n" +
								"TEST LIBELLE\r\n" +
								":61:0710251025CF3000000000,0FMSC1234567890\r\n" +
								"TEST LIBELLE\r\n" +
								":62F:C061207XOF4123944619,0\r\n" +
								":86:Message de bienvenue\r\n" +
							    ":62M:C100921ZAR499650,23\r\n" +
							    "-}";

  public void testWifeBug() throws IOException {
    IConversionService conversionService = new ConversionService();
    String actualMT940 = conversionService.getFIN(new SwiftParser(expectedMT940).message());
    assertEquals(expectedMT940, actualMT940);
  }

}
