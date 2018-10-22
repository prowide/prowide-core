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
package com.prowidesoftware.swift.model.field;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test for Field70F and similar fields.
 * 
 * @author www.prowidesoftware.com
 * @since 6.0
 */
public class Field70FTest extends AbstractFieldTest {

	@Override
	@Test
	public void testSerialization() {
		testSerializationImpl("70F",
				":ADTX//----REPURCHASE OFFER----\n.\nFTT/N: PURCHASED SHARES WILL BE\nDESTROYED",
				":ABCD//SIMPLE FOO NARRATIVE WITHOUT ANY CODEWORD"
			);
	}
	
	@Test
	public void testField70FString() {
		String c2 = "+--------REPURCHASE OFFER---------+\n"+
			".\n"+
			"FTT/N: PURCHASED SHARES WILL BE\n"+
			"DESTROYED\n"+
			".\n"+
			"THE COMPANY ANNOUNCED AN OFFER TO\n"+
			"BUY UP TO 18'926'350 OWN SHARES IN\n"+
			"ORDER TO REDUCE THE SHARE CAPITAL.\n"+
			".\n"+
			"PRICE : NO FIXED PRICE\n"+
			"A SECOND TRADING LINE WITH THE\n"+
			"ISIN CH0189177055 HAS BEEN\n"+
			"ESTABLISHED ON SIX SWISS EXCHANGE.\n"+
			".\n"+
			"PLEASE NOTE: UNDER THE SWISS\n"+
			"COMPANY ACT, A CAPITAL REDUCTION\n"+
			"IS TO BE TREATED AS A PARTIAL\n"+
			"LIQUIDATION AND SUBJECT TO A WITH-\n"+
			"HOLDING TAX OF 35 PCT PAYABLE ON\n"+
			"THE DIFFERENCE BETWEEN THE\n"+
			"REPURCHASE PRICE AND THE SHARE\n"+
			"NOMINAL VALUE OF CHF 1.00.\n"+
			"BENEFICIAL OWNERS DOMICILED IN\n"+
			"SWITZERLAND CAN RECLAIM THE FULL\n"+
			"AMOUNT OF THE TAX PAID.\n"+
			"PERSONS DOMICILED OUTSIDE OF\n"+
			"SWITZERLAND CAN RECLAIM THE WITH-\n"+
			"HOLDING TAX UNDER ANY DOUBLE\n"+
			"TAXATION AGREEMENTS.\n"+
			".\n"+
			"PLEASE SELL YOUR SHARES (DISPO)\n"+
			"THROUGH THE LEADMANAGER CREDIT\n"+
			"SUISSE AG.\n"+
			".\n"+
			"PLEASE NOTE: IF YOU HAVE SOLD\n"+
			"SECOND-LINE SHARES THROUGH THE LEAD\n"+
			"MANAGER CREDIT SUISSE, YOU HAVE TO\n"+
			"INSTRUCT SIX SIS WITH SWIFT MT 565\n"+
			"TO TRANSFER THE SHARES FROM\n"+
			"ORIGINAL-ISIN (FIRST-LINE) TO\n"+
			"SECOND-LINE.\n"+
			".\n"+
			"PLEASE INDICATE: TRADE-DATE,\n"+
			"SETTLEMENT-DATE + YOUR REFFERENCE\n"+
			"AND YOUR DIRECT PHONE-NUMBER.\n"+
			".\n"+
			"RESTRICTIONS:\n"+
			"USA / U.S. PERSONS\n"+
			"ALL INVESTORS MUST VERIFY THAT THEY\n"+
			"ARE NOT ACTING AGAINST THEIR\n"+
			"COUNTRY OF RESIDENCE LAW\n"+
			"REGULATIONS.\n"+
			"WITH YOUR INSTRUCTION YOU CONFIRM\n"+
			"YOUR ELIGIBILITY TO PARTICIPATE IN\n"+
			"THE OFFER BEING AWARE OF ANY\n"+
			"RESTRICTIONS.\n"+
			".\n"+
			"PLEASE IGNORE THE PAYMENT DATE.\n"+
			"SETTLEMENT WILL BE 'ONGOING'.\n"+
			".\n";
		
		Field70F f = new Field70F(":ADTX//"+c2);
		assertEquals("ADTX", f.getComponent1());
		assertEquals(c2, f.getComponent2());
	}
}
