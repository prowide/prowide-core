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
package com.prowidesoftware.swift.io.parser;

import java.util.logging.Logger;

import com.prowidesoftware.swift.model.MxNode;
import com.prowidesoftware.swift.model.mx.dic.AddressType2Code;
import com.prowidesoftware.swift.model.mx.dic.ApplicationHeader;
import com.prowidesoftware.swift.model.mx.dic.BranchAndFinancialInstitutionIdentification5;
import com.prowidesoftware.swift.model.mx.dic.BranchData2;
import com.prowidesoftware.swift.model.mx.dic.BusinessApplicationHeader1;
import com.prowidesoftware.swift.model.mx.dic.BusinessApplicationHeaderV01;
import com.prowidesoftware.swift.model.mx.dic.ClearingSystemIdentification2Choice;
import com.prowidesoftware.swift.model.mx.dic.ClearingSystemMemberIdentification2;
import com.prowidesoftware.swift.model.mx.dic.ContactDetails2;
import com.prowidesoftware.swift.model.mx.dic.CopyDuplicate1Code;
import com.prowidesoftware.swift.model.mx.dic.DateAndPlaceOfBirth;
import com.prowidesoftware.swift.model.mx.dic.DuplicateIndication;
import com.prowidesoftware.swift.model.mx.dic.EntityIdentification;
import com.prowidesoftware.swift.model.mx.dic.FinancialIdentificationSchemeName1Choice;
import com.prowidesoftware.swift.model.mx.dic.FinancialInstitutionIdentification8;
import com.prowidesoftware.swift.model.mx.dic.GenericFinancialIdentification1;
import com.prowidesoftware.swift.model.mx.dic.NamePrefix1Code;
import com.prowidesoftware.swift.model.mx.dic.OrganisationIdentification7;
import com.prowidesoftware.swift.model.mx.dic.Party10Choice;
import com.prowidesoftware.swift.model.mx.dic.Party9Choice;
import com.prowidesoftware.swift.model.mx.dic.PartyIdentification42;
import com.prowidesoftware.swift.model.mx.dic.PersonIdentification5;
import com.prowidesoftware.swift.model.mx.dic.PostalAddress6;
import com.prowidesoftware.swift.model.mx.dic.SignatureEnvelope;

/**
 * Non-public helper class used by {@link MxParser} to parse the business header
 * in its two variants, using MxNode. 
 * 
 * @author sebastian@prowidesoftware.com
 * @since 7.8.4
 */
class MxBusinessHeaderParser {
	private static final transient Logger log = Logger.getLogger(MxBusinessHeaderParser.class.getName());

	/**
	 * Parses the application header from the parameter node.
	 * @return parsed header or null if the content cannot be parsed or the header is not present in the xml
	 */
	static ApplicationHeader parseApplicationHeader(final MxNode tree) {
		final long t0 = System.currentTimeMillis();
		try {
			if (tree != null) {
				final MxNode header = tree.findFirstByName(MxParser.HEADER_LOCALNAME);
				if (header == null) {
					log.warning(MxParser.HEADER_LOCALNAME + " element not found");
				} else {
					final ApplicationHeader result = new ApplicationHeader();
					
					/*
					 * From
					 */
					MxNode From = header.findFirst("./From");
					if (From != null) {
						result.setFrom(new EntityIdentification());
						MxNode Type = From.findFirst("./Type");
						if (Type != null) {
							result.getFrom().setType(Type.getValue());
						}
						MxNode Id = From.findFirst("./Id");
						if (Id != null) {
							result.getFrom().setId(Id.getValue());
						}
					}

					/*
					 * To
					 */
					MxNode To = header.findFirst("./To");
					if (To != null) {
						result.setTo(new EntityIdentification());
						MxNode Type = To.findFirst("./Type");
						if (Type != null) {
							result.getTo().setType(Type.getValue());
						}
						MxNode Id = To.findFirst("./Id");
						if (Id != null) {
							result.getTo().setId(Id.getValue());
						}
					}

					/*
					 * Service name
					 */
					MxNode SvcName = header.findFirst("./SvcName");
					if (SvcName != null) {
						result.setSvcName(SvcName.getValue());
					}
					
					/*
					 * Message name
					 */
					MxNode MsgName = header.findFirst("./MsgName");
					if (MsgName != null) {
						result.setMsgName(MsgName.getValue());
					}
					
					/*
					 * Message reference
					 */
					MxNode MsgRef = header.findFirst("./MsgRef");
					if (MsgRef != null) {
						result.setMsgRef(MsgRef.getValue());
					}

					/*
					 * Date
					 */
					MxNode CrDate = header.findFirst("./CrDate");
					if (CrDate != null) {
						try {
							result.setCrDate(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(CrDate.getValue()));
						} catch (final javax.xml.datatype.DatatypeConfigurationException e) {
							log.warning("exception " + e + " parsign header crDate [" + CrDate.getValue() + "]");
						}
					}

					/*
					 * Duplicate information
					 */
					MxNode Dup = header.findFirst("./Dup");
					if (Dup != null) {
						result.setDup(new DuplicateIndication());
						MxNode Ref = Dup.findFirst("./Ref");
						if (Ref != null) {
							result.getDup().setRef(Ref.getValue());
						}
						MxNode Info = Dup.findFirst("./Info");
						if (Info != null) {
							result.getDup().setInfo(Info.getValue());
						}
					}

					return result;
				}
			}
		} finally {
			final long t1 = System.currentTimeMillis();
			log.fine("parseApplicationHeader_sax: " + (t1 - t0) + "ms");
		}
		return null;
	}
	
	/**
	 * Parses the application header from the parameter node.
	 * @return parsed header or null if the content cannot be parsed or the header is not present in the xml
	 */
	static BusinessApplicationHeaderV01 parseBusinessApplicationHeaderV01(final MxNode tree) {
		final long t0 = System.currentTimeMillis();
		if (tree != null) {
			final MxNode header = tree.findFirstByName(MxParser.HEADER_LOCALNAME);
			if (header == null) {
				log.warning(MxParser.HEADER_LOCALNAME + " element not found");
			} else {
				final BusinessApplicationHeaderV01 result = new BusinessApplicationHeaderV01();

				MxNode CharSet = header.findFirst("./CharSet");
				if (CharSet != null) {
					result.setCharSet(CharSet.getValue());
				}

				MxNode Fr = header.findFirst("./Fr");
				if (Fr != null) {
					result.setFr(new Party9Choice());
					parse(Fr, result.getFr());					
				}
				
				MxNode To = header.findFirst("./To");
				if (To != null) {
					result.setTo(new Party9Choice());
					parse(To, result.getTo());
				}

				MxNode BizMsgIdr = header.findFirst("./BizMsgIdr");
				if (BizMsgIdr != null) {
					result.setBizMsgIdr(BizMsgIdr.getValue());
				}
				
				MxNode MsgDefIdr = header.findFirst("./MsgDefIdr");
				if (MsgDefIdr != null) {
					result.setMsgDefIdr(MsgDefIdr.getValue());
				}
				
				MxNode BizSvc = header.findFirst("./BizSvc");
				if (BizSvc != null) {
					result.setBizSvc(BizSvc.getValue());
				}

				MxNode CreDt = header.findFirst("./CreDt");
				if (CreDt != null) {
					try {
						result.setCreDt(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(CreDt.getValue()));
					} catch (final javax.xml.datatype.DatatypeConfigurationException e) {
						log.warning("exception " + e + " parsing header crDate [" + CreDt.getValue() + "]");
					}
				}

				MxNode CpyDplct = header.findFirst("./CpyDplct");
				if (CpyDplct != null) {
					try {
						result.setCpyDplct(CopyDuplicate1Code.valueOf(CpyDplct.getValue()));
					} catch (final Exception e) {
						log.warning("exception " + e + " parsing header CpyDplct [" + CpyDplct.getValue() + "]");
					}	
				}
				
				MxNode PssblDplct = header.findFirst("./PssblDplct");
				if (PssblDplct != null) {
					try {
						result.setPssblDplct(Boolean.valueOf(PssblDplct.getValue()));
					} catch (final Exception e) {
						log.warning("exception " + e + " parsing header PssblDplct [" + PssblDplct.getValue() + "]");
					}
				}
				
				MxNode Prty = header.findFirst("./Prty");
				if (Prty != null) {
					result.setPrty(Prty.getValue());
				}

				MxNode Sgntr = header.findFirst("./Sgntr");
				if (Sgntr != null) {
					result.setSgntr(new SignatureEnvelope());
					result.getSgntr().setAny(Sgntr.getValue());
				}

				MxNode Rltd = header.findFirst("./Rltd");
				if (Rltd != null) {
					result.setRltd(new BusinessApplicationHeader1());
					parse(Rltd, result.getRltd());
				}
				
				return result;
			}
		}
		final long t1 = System.currentTimeMillis();
		log.fine("parseApplicationHeader_sax: " + (t1 - t0) + "ms");
		return null;
	}
	
	/**
	 * Helper parse for BusinessApplicationHeader1.
	 * This actually parses a BusinessApplicationHeaderV01 and copies all its content into 
	 * the result BusinessApplicationHeader1. Both header model classes share the same fields.
	 * @param node current node for the path search
	 * @param h object to fill with parsed content
	 */
	private static void parse(MxNode node, BusinessApplicationHeader1 h) {
		BusinessApplicationHeaderV01 bah = parseBusinessApplicationHeaderV01(node);
		if (bah != null) {
			h.setBizMsgIdr(bah.getBizMsgIdr());
			h.setBizSvc(bah.getBizSvc());
			h.setCharSet(bah.getCharSet());
			h.setCpyDplct(bah.getCpyDplct());
			h.setCreDt(bah.getCreDt());
			h.setFr(bah.getFr());
			h.setMsgDefIdr(bah.getMsgDefIdr());
			h.setPrty(bah.getPrty());
			h.setSgntr(bah.getSgntr());
			h.setTo(bah.getTo());
			h.setPssblDplct(bah.isPssblDplct());
		}
	}

	/**
	 * Helper parse for Party9Choice
	 * @param node current node for the path search
	 * @param party object to fill with parsed content
	 */
	private static void parse(MxNode node, Party9Choice party) {
		MxNode OrgId = node.findFirst("./OrgId");
		if (OrgId != null) {
			party.setOrgId(new PartyIdentification42());
			parse(OrgId, party.getOrgId());
		}
		MxNode FIId = node.findFirst("./FIId");
		if (FIId != null) {
			party.setFIId(new BranchAndFinancialInstitutionIdentification5());
			parse(FIId, party.getFIId());
		}
	}
	
	/**
	 * Helper parse for BranchAndFinancialInstitutionIdentification5
	 * @param node current node for the path search
	 * @param fiId object to fill with parsed content
	 */
	private static void parse(MxNode node, BranchAndFinancialInstitutionIdentification5 fiId) {
		MxNode FinInstnId = node.findFirst("./FinInstnId");
		if (FinInstnId != null) {
			fiId.setFinInstnId(new FinancialInstitutionIdentification8());
			parse(FinInstnId, fiId.getFinInstnId());
		}
		MxNode BrnchId = node.findFirst("./BrnchId");
		if (BrnchId != null) {
			fiId.setBrnchId(new BranchData2());
			parse(BrnchId, fiId.getBrnchId());
		}
	}

	/**
	 * Helper parse for BranchData2
	 * @param node current node for the path search
	 * @param branch object to fill with parsed content
	 */
	private static void parse(MxNode node, BranchData2 branch) {
		MxNode Id = node.findFirst("./Id");
		if (Id != null) {
			branch.setId(Id.getValue());
		}
		MxNode Nm = node.findFirst("./Nm");
		if (Nm != null) {
			branch.setNm(Nm.getValue());
		}
		MxNode PstlAdr = node.findFirst("./PstlAdr");
		if (PstlAdr != null) {
			branch.setPstlAdr(new PostalAddress6());
			parse(PstlAdr, branch.getPstlAdr());
		}
	}

	/**
	 * Helper parse for PostalAddress6
	 * @param node current node for the path search
	 * @param pstlAdr object to fill with parsed content
	 */
	private static void parse(MxNode node, PostalAddress6 pstlAdr) {
		MxNode AdrTp = node.findFirst("./AdrTp");
		if (AdrTp != null) {
			try {
				pstlAdr.setAdrTp(AddressType2Code.valueOf(AdrTp.getValue()));
			} catch (final Exception e) {
				log.warning("exception " + e + " parsing header AdrTp [" + AdrTp.getValue() + "]");
			}
		}
		MxNode Dept = node.findFirst("./Dept");
		if (Dept != null) {
			pstlAdr.setDept(Dept.getValue());
		}
		MxNode SubDept = node.findFirst("./SubDept");
		if (AdrTp != null) {
			pstlAdr.setSubDept(SubDept.getValue());
		}
		MxNode StrtNm = node.findFirst("./StrtNm");
		if (StrtNm != null) {
			pstlAdr.setStrtNm(StrtNm.getValue());
		}
		MxNode BldgNb = node.findFirst("./BldgNb");
		if (BldgNb != null) {
			pstlAdr.setBldgNb(BldgNb.getValue());
		}
		MxNode PstCd = node.findFirst("./PstCd");
		if (PstCd != null) {
			pstlAdr.setPstCd(PstCd.getValue());
		}
		MxNode TwnNm = node.findFirst("./TwnNm");
		if (TwnNm != null) {
			pstlAdr.setTwnNm(TwnNm.getValue());
		}
		MxNode CtrySubDvsn = node.findFirst("./CtrySubDvsn");
		if (CtrySubDvsn != null) {
			pstlAdr.setCtrySubDvsn(CtrySubDvsn.getValue());
		}
		MxNode Ctry = node.findFirst("./Ctry");
		if (Ctry != null) {
			pstlAdr.setCtry(Ctry.getValue());
		}
	}

	/**
	 * Helper parse for FinancialInstitutionIdentification8
	 * @param node current node for the path search
	 * @param finInstnId object to fill with parsed content
	 */
	private static void parse(MxNode node, FinancialInstitutionIdentification8 finInstnId) {
		MxNode BICFI = node.findFirst("./BICFI");
		if (BICFI != null) {
			finInstnId.setBICFI(BICFI.getValue());
		}
		MxNode ClrSysMmbId = node.findFirst("./ClrSysMmbId");
		if (ClrSysMmbId != null) {
			finInstnId.setClrSysMmbId(new ClearingSystemMemberIdentification2());
			parse(ClrSysMmbId, finInstnId.getClrSysMmbId());
			
		}
		MxNode Nm = node.findFirst("./Nm");
		if (Nm != null) {
			finInstnId.setNm(Nm.getValue());
		}
		MxNode PstlAdr = node.findFirst("./PstlAdr");
		if (PstlAdr != null) {
			finInstnId.setPstlAdr(new PostalAddress6());
			parse(PstlAdr, finInstnId.getPstlAdr());
		}
		MxNode Othr = node.findFirst("./Othr");
		if (Othr != null) {
			finInstnId.setOthr(new GenericFinancialIdentification1());
			parse(Othr, finInstnId.getOthr());
		}		
	}

	/**
	 * Helper parse for GenericFinancialIdentification1
	 * @param node current node for the path search
	 * @param fiId object to fill with parsed content
	 */
	private static void parse(MxNode node, GenericFinancialIdentification1 fiId) {
		MxNode Id = node.findFirst("./Id");
		if (Id != null) {
			fiId.setId(Id.getValue());
		}
		MxNode SchmeNm = node.findFirst("./SchmeNm");
		if (SchmeNm != null) {
			fiId.setSchmeNm(new FinancialIdentificationSchemeName1Choice());
			parse(SchmeNm, fiId.getSchmeNm());
		}
		MxNode Issr = node.findFirst("./Issr");
		if (Issr != null) {
			fiId.setIssr(Issr.getValue());
		}
	}

	/**
	 * Helper parse for FinancialIdentificationSchemeName1Choice
	 * @param node current node for the path search
	 * @param schmeNm object to fill with parsed content
	 */
	private static void parse(MxNode node, FinancialIdentificationSchemeName1Choice schmeNm) {
		MxNode Cd = node.findFirst("./Cd");
		if (Cd != null) {
			schmeNm.setCd(Cd.getValue());
		}
		MxNode Prtry = node.findFirst("./Prtry");
		if (Prtry != null) {
			schmeNm.setPrtry(Prtry.getValue());
		}
	}

	/**
	 * Helper parse for ClearingSystemMemberIdentification2
	 * @param node current node for the path search
	 * @param clrSysMmbId object to fill with parsed content
	 */
	private static void parse(MxNode node, ClearingSystemMemberIdentification2 clrSysMmbId) {
		MxNode ClrSysId = node.findFirst("./ClrSysId");
		if (ClrSysId != null) {
			clrSysMmbId.setClrSysId(new ClearingSystemIdentification2Choice());
			parse(ClrSysId, clrSysMmbId.getClrSysId());
		}
		MxNode MmbId = node.findFirst("./MmbId");
		if (MmbId != null) {
			clrSysMmbId.setMmbId(MmbId.getValue());
		}		
	}

	/**
	 * Helper parse for ClearingSystemIdentification2Choice
	 * @param node current node for the path search
	 * @param clrSysId object to fill with parsed content
	 */
	private static void parse(MxNode node, ClearingSystemIdentification2Choice clrSysId) {
		MxNode Cd = node.findFirst("./Cd");
		if (Cd != null) {
			clrSysId.setCd(Cd.getValue());
		}
		MxNode Prtry = node.findFirst("./Prtry");
		if (Prtry != null) {
			clrSysId.setPrtry(Prtry.getValue());
		}		
	}

	/**
	 * Helper parse for PartyIdentification42
	 * @param node current node for the path search
	 * @param party object to fill with parsed content
	 */
	private static void parse(MxNode node, PartyIdentification42 party) {
		MxNode Nm = node.findFirst("./Nm");
		if (Nm != null) {
			party.setNm(Nm.getValue());
		}
		MxNode PstlAdr = node.findFirst("./PstlAdr");
		if (PstlAdr != null) {
			party.setPstlAdr(new PostalAddress6());
			parse(PstlAdr, party.getPstlAdr());
		}		
		MxNode Id = node.findFirst("./Id");
		if (Id != null) {
			party.setId(new Party10Choice());
			parse(Id, party.getId());
		}
		MxNode CtryOfRes = node.findFirst("./CtryOfRes");
		if (CtryOfRes != null) {
			party.setCtryOfRes(CtryOfRes.getValue());
		}
		MxNode CtctDtls = node.findFirst("./CtctDtls");
		if (CtctDtls != null) {
			party.setCtctDtls(new ContactDetails2());
			parse(CtctDtls, party.getCtctDtls());
		}
	}

	/**
	 * Helper parse for ContactDetails2
	 * @param node current node for the path search
	 * @param ctctDtls object to fill with parsed content
	 */
	private static void parse(MxNode node, ContactDetails2 ctctDtls) {
		MxNode NmPrfx = node.findFirst("./NmPrfx");
		if (NmPrfx != null) {
			try {
				ctctDtls.setNmPrfx(NamePrefix1Code.valueOf(NmPrfx.getValue()));
			} catch (final Exception e) {
				log.warning("exception " + e + " parsing header NmPrfx [" + NmPrfx.getValue() + "]");
			}
		}
		MxNode Nm = node.findFirst("./Nm");
		if (Nm != null) {
			ctctDtls.setNm(Nm.getValue());
		}
		MxNode PhneNb = node.findFirst("./PhneNb");
		if (PhneNb != null) {
			ctctDtls.setPhneNb(PhneNb.getValue());
		}
		MxNode MobNb = node.findFirst("./MobNb");
		if (MobNb != null) {
			ctctDtls.setMobNb(MobNb.getValue());
		}
		MxNode FaxNb = node.findFirst("./FaxNb");
		if (FaxNb != null) {
			ctctDtls.setFaxNb(FaxNb.getValue());
		}
		MxNode EmailAdr = node.findFirst("./EmailAdr");
		if (EmailAdr != null) {
			ctctDtls.setEmailAdr(EmailAdr.getValue());
		}
		MxNode Othr = node.findFirst("./Othr");
		if (Othr != null) {
			ctctDtls.setOthr(Othr.getValue());
		}
	}

	/**
	 * Helper parse for Party10Choice
	 * @param node current node for the path search
	 * @param id object to fill with parsed content
	 */
	private static void parse(MxNode node, Party10Choice id) {
		MxNode OrgId = node.findFirst("./OrgId");
		if (OrgId != null) {
			id.setOrgId(new OrganisationIdentification7());
			parse(OrgId, id.getOrgId());
		}
		MxNode PrvtId = node.findFirst("./PrvtId");
		if (PrvtId != null) {
			id.setPrvtId(new PersonIdentification5());
			parse(PrvtId, id.getPrvtId());
		}
	}

	/**
	 * Helper parse for PersonIdentification5
	 * @param node current node for the path search
	 * @param prvtId object to fill with parsed content
	 */
	private static void parse(MxNode node, PersonIdentification5 prvtId) {
		MxNode DtAndPlcOfBirth = node.findFirst("./DtAndPlcOfBirth");
		if (DtAndPlcOfBirth != null) {
			prvtId.setDtAndPlcOfBirth(new DateAndPlaceOfBirth());
			parse(DtAndPlcOfBirth, prvtId.getDtAndPlcOfBirth());
		}
	}

	/**
	 * Helper parse for DateAndPlaceOfBirth
	 * @param node current node for the path search
	 * @param dtAndPlcOfBirth object to fill with parsed content
	 */
	private static void parse(MxNode node, DateAndPlaceOfBirth dtAndPlcOfBirth) {
		MxNode BirthDt = node.findFirst("./BirthDt");
		if (BirthDt != null) {
			try {
				dtAndPlcOfBirth.setBirthDt(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar(BirthDt.getValue()));
			} catch (final javax.xml.datatype.DatatypeConfigurationException e) {
				log.warning("exception " + e + " parsing header BirthDt [" + BirthDt.getValue() + "]");
			}
		}
		MxNode PrvcOfBirth = node.findFirst("./PrvcOfBirth");
		if (PrvcOfBirth != null) {
			dtAndPlcOfBirth.setPrvcOfBirth(PrvcOfBirth.getValue());
		}
		MxNode CityOfBirth = node.findFirst("./CityOfBirth");
		if (CityOfBirth != null) {
			dtAndPlcOfBirth.setCityOfBirth(CityOfBirth.getValue());
		}
		MxNode CtryOfBirth = node.findFirst("./CtryOfBirth");
		if (CtryOfBirth != null) {
			dtAndPlcOfBirth.setCtryOfBirth(CtryOfBirth.getValue());
		}
	}

	/**
	 * Helper parse for OrganisationIdentification7
	 * @param node current node for the path search
	 * @param orgId object to fill with parsed content
	 */
	private static void parse(MxNode node, OrganisationIdentification7 orgId) {
		MxNode AnyBIC = node.findFirst("./AnyBIC");
		if (AnyBIC != null) {
			orgId.setAnyBIC(AnyBIC.getValue());
		}
	}
}
