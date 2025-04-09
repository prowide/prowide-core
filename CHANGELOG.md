# Prowide Core - CHANGELOG

#### 9.5.5 - December 2024
  * Update apache-commons-lang3 from 3.14.0 to 3.17.0 fixing derived apache-text dependency vulnerabilities 
  * Minor thread safety fix in the `PropertyLoaded` class, used by the `SafeXmlUtils`
  * Gradle wrapper update to 8.12

#### 9.5.4 - November 2024
  * Rolling back SHA-256 checksum algorithm to MD5 in the MT message model

#### 9.5.3 - November 2024
  * (PW-2040) Updated the BBAN validation data file to the IBAN REGISTRY Jul 2024 release 
  * (PW-2006) Fixed `getMUR` and `setMUR` in `SwiftMessage` to prioritize field 108 in block 4 over block 3 for system messages (category 0)
  * Added new `MtSequenceEnum` with all the available inner sequences of specific MT schemas
  * Added `isSystemMessage()` to SwiftMessage to check if the message is a category 0 message (010. 011, etc...)
  * Added new `MtSequenceEnum` with all the available inner sequences of specific MT schemas

#### 9.5.2 - October 2024
  * Added new `FieldEnum` with all the available field names
  * Code security improvements as per CodeQL recommendations

#### 9.5.1 - June 2024
  * (PW-1913) Added IBAN validation for Egypt local account structure
  * Restore deprecated method in MT210 class

#### 9.5.0 - May 2024
  * SWIFT Standard release update 2024 (live 16 November 2025)
  * Yearly revision of deprecation phase (see https://dev.prowidesoftware.com/SRU2024/getting-started/deprecation/)
  * Dependency update: commons-lang3 -> 3.14.0'
  * Dependency update: gson -> 2.11.0'

#### 9.4.16 - May 2024
  * (PW-1862) Added NarrativeFragment class for detailed line information in StructuredNarrative fragments
  * Fixed SwiftMessage getPDE(): return empty value instead of null when codeword exists and has no value
  * Added isPercentage() helper method to field 37K

#### 9.4.15 - March 2024
  * (PW-1812) Updated the narrative resolver, format 2 (used in field 72 for example), to allow empty values as part of the narrative fragment
  * Updated validators for BIC, country, and currency constraints to utilize keywords for i18n-compatible messages
  * Deprecated unnecessary methods in the SafeXmlUtils class

#### 9.4.14 - December 2023
  * (PW-1718) Changed the getComponentLabel(component) in Field59F to be dynamic based on the line identifiers (similar to existing API in Field50F)

#### 9.4.13 - November 2023
  * (PW-1697) Fixed validation/parse pattern in field 29O
  * (PW-1697) MT306 changes in field 30I
  * Added DistinguishedName with Builder in order to encapsulate the BIC branch name logic 

#### 9.4.12 - November 2023
  * (PW-1697) Fixed validation pattern in fields 14[H,K,L,M,N,O] and 29J

#### 9.4.11 - November 2023
  * (PW-1695) Fixed a stack overflow in the fields fromJson implementation when a malformed JSON input contains empty field names
  * (PW-1688) Added missing field labels for SRU2023 changes in the pw_swift_*.properties file

#### 9.4.10 - October 2023
  * (PW-1675) update to Field 31R to support also two date components as requested by SCORE messages
  * Added 36B and 36D getters to MT543

#### 9.4.9 - October 2023
  * (PW-1659) Field 24G deprecated Name and Address for Narrative

#### 9.4.8 - October 2023
  * Added default methods for sender, receiver, and identifier extraction to the MessageExtractionStrategy
  * Added JSON to the `FileFormat` enumeration

#### 9.4.7 - September 2023
  * (PW-1478) Fixed Field 44J parse and getValue to enable proper data preservation when the field contains multiline content

#### 9.4.6 - September 2023
  * Added support for an optional `pw-swift-core.properties` to customize the behavior of the SafeXmlUtils class

#### 9.4.5 - August 2023
  * (PW-1478) Field 44J parse and getValue fix

#### 9.4.4 - August 2023
  * (PW-1478) Field 44J format fixed to allow multiline

#### 9.4.3 - July 2023
  * (PW-1461) Remove deprecation of field 31R model since is it used back in SRU2023
  * (PW-1405) Trim original String payload when creating an AbstractSwiftMessage

#### 9.4.2 - June 2023
  * (GH-163) Remove unnecessary padding in sender and receiver in AbstractMT#creeate(number, sender, receiver) method
  * (PW-1323) Fixing getValue method for pattern issue in Field44J

#### 9.4.1 - June 2023
  * (PW-1323) Fixing missing pattern issue in Field44J

#### 9.4.0 - May 2023
  * SWIFT Standard release update 2023 (live 19 November 2023)
  * Yearly revision of deprecation phase (see https://dev.prowidesoftware.com/SRU2022/getting-started/deprecation/)

#### 9.3.15 - May 2023
  * (PW-1341) Avoid log pollution with exception stacktrace in Field#formatAccount method
  * (PW-1264) Added distinguishedName(boolean includeDefaultBranch) method to BIC in order to return default branch name

#### 9.3.14 - March 2023
  * (PW-1182) Fixed MT internal Loops API, when strategy is GENERATED_FIXED_WITH_OPTIONAL_TAIL and the tail part contains repetitive fields, such as MT920
  * (PW-1241) Added addUnstructuredStrict method to Narrative in order to strictly wrap unstructured input

#### 9.3.13 - March 2023
  * Deprecated all fields that are only used in SCORE messages and not in the general MT standard as they will eventually be removed from the library

#### 9.3.12 - February 2023
  * (PW-1109) Changed Narrative Resolver to validate minimum codeword length of 1 char
  * (GH-148) Fixed parser of Field61 amount component when number starts with the decimal comma (implicit zero in amount lower than 1)
  * Added getComponent(String componentName) to retrieve the component based on the name instead of the number
  * Added componentNameToNumber(String componentName) to retrieve the component number based on the component name

#### 9.3.11 - January 2023
  * (PW-1152) Preserve line breaks when creating NarrativeContainer fields from JSON with legacy structure: narrative1, narrative2, etc...
  * Fixed duplicate elements when serializing NarrativeContainer fields into JSON 

#### 9.3.10 - January 2023
  * (PW-1150) Added field model class for 31M (required in SCORE MT798_753)
  * (PW-1150) Added field model class for 71E (required in SCORE MT798_755 and MT798_757)

#### 9.3.9 - December 2022
  * (PW-1078) StructuredNarrative: Fixed parser to treat the optional [3!a13d] part as a unit block, both currency and amount present or missing

#### 9.3.8 - November 2022
  * (GH-127) Enhanced field JSON serialization to include detailed structure when the field is a NarrativeContainer 

#### 9.3.7 - November 2022
  * (PW-1101) Fix field 35C labels to match the FIN xsd: Identification Of Instrument, Description Of Instrument

#### 9.3.6 - November 2022
  * (PW-1086) Fixed typo in field 36D accessors
  * (PW-1078) StructuredNarrative: Added getBankCode() methods in order to allow direct access to data (used in SCORE messages)
  * (GH-88) Added missing constants for ISO 15022 codes 
  * MT540 and MT548 added missing getter for Field99C
  * Added removeRepeatedBoundaries method in order to remove repeated tag boundaries

#### 9.3.5 - October 2022
  * SRU2022 updates review: field 35C validation pattern changed to <VAR-SEQU-5>

#### 9.3.4 - September 2022
  * Added getCADETL method for "CADETL" separator sequences
  * (GH-119) MT566: Fixed repetitions of sequence USECU/FIA that is not repetitive
  * Added sequence getters using the boundary field qualifier, for example getSequenceGENL() as equivalent to the existing getSequenceA()

#### 9.3.3 - August 2022
  * (PW-1015) Added field model classes for 47E, 49D and 49F (required in SCORE MT798_774)

#### 9.3.2 - July 2022
  * (PW-977) Changed the MT203 and MT210 inner structure from regular sequence to inner loop named Loop1
  * Added Loop1 getter API to MTs: 110, 201, 203, 210, 410, 412, 420, 422, 450, 456, 604, 605, 801, 920, 973

#### 9.3.1 - July 2022
  * (PW-976) Added new MonetaryAmountContainer interface for fields having both an Amount and Currency
  * (PW-969) Modified field 12E, 12K and 12R labels
  * (PW-969) Added an optional narrative component to field 12R (required when the field is used in SCORE messages)
  * (PW-898) Changed the heuristic to retrieve sequence B1 from MT300 and MT304 to be more efficient even if the message structure is invalid
  * (PW-867) Enhanced the parsing of party fields A, B and D, to be more strict when splitting the /D/ or /C/ prefix from the account
  * Enhanced MtId constructor with regex matching
  * Added method namespaceURI() in the MtId class to return for example "urn:swift:xsd:fin.103.2021" for the MT103

#### 9.3.0 - May 2022
  * SWIFT Standard release update 2022 (live 20 November 2022)
  * Yearly revision of deprecation phase (see http://www.prowidesoftware.com/resources/deprecation-policy)
  * Updated gson dependency to 2.9.0

#### 9.2.13 - April 2022
  * (PW-892) Fixed AbstractMT#create when the message type number is less than 100
  * Added a convenient String message() method in the SwiftMessage object to get the FIN serialization of the message
  * Fixed error in Field 94G getValue

#### 9.2.12 - March 2022
  * (GH-103) fixed invalid ConstraintValidator annotation on CurrencyValidator
  * (GH-95) patterns getters are now non-final to avoid overwriting; static constants have been deprecated
  * RJE and PPC readers, added a constructor with explicit charset (same in swift parser from input stream)
  * Validate.notNull -> Objects.requireNonNull
  * Spotbugs code review

#### 9.2.11 - January 2022
  * Added LineWrapper (utils) to replace Apache's WordUtils.wrap and thus the commons-text dependency
  * Added convenient method in the envelop message MT798 to get the sub-message type as a SwiftMessage
  * Added a copy constructor to the Tag class

#### 9.2.10 - January 2022
  * (PW-815) Fixed getValue in field 12H (SCORE) where narrative is optional
  * (GH-89) MT530: Fixed repetition of sequence C ADDINFO
  * Updated dependency: gson:2.8.8 -> gson:2.8.9
  * Java 11 and 17 compatibility updates
  * Added plugins for automatic versioning and code quality reporting

#### 9.2.9 - December 2021
  * (GH-78) Fixed MT537#getSequenceBList where sequence B delimiter "STAT" overlaps with C3 and D1a1B1a delimiters
  * (GH-74) Fixed parser for Field48 and similar cases to avoid trimming content when the component contains also the slash separator as part of the value
  * (GH-62) Added com.prowidesoftware.core as automatic module name in the MANIFEST for JPMS support
  * Fields getComponentLabel is now public, returning the specific label for each field component
  * Fixed bug in PartyIdentifierUtils.getPartyIdentifier
  * Fixes in field component names and optional status
  * Fixes in field parsing
  * Incompatible change in field 71N (changed from 7 Narrative lines to Code + 6 Narrative lines)
  * Incompatible change for field 11T to have two lines (MT new-line DATE + TIME)
  * Fixed Structured Narrative parsing to return an empty Narrative object with null string values

#### 9.2.8 - November 2021
  * (PW-764) Added new variant values (RFDD, ISLFIN)
  * (PW-703) Block 2 parser: lenient parser to avoid duplicate error when exception on invalid Input/Output indicator
  * (CR-23) Enhanced getValueDisplay for fields (no decimal separator for numbers that are not amounts)

#### 9.2.7 - October 2021
  * Field 98D, 98E and 98G: removed invalid get{Component4|Sign}AsCurrency and set{Component4|Sign}(Currency) as no currency applies to these fields
  * Fields 94L and 85L: separated component 2 (Legal Entity Identifier) into two (Legal Entity Identifier Code and Legal Entity Identifier Number). Kept get/setLegalEntityIdentifier for backwards compatibility
  * Field 94H: second component now has get{name}AsBIC and set{name}(BIC) methods
  * Field 56B: now inherits from OptionBPartyField (to have get/setPartyIdentifier)
  * Field 26C: separated component 5 into 5 (Denomination) and 6 (Form) for compatibility with Swift. Kept get/setDenominationForm for backwards compatibility
  * Field 26A: now has 2 components (Number 1 and Number 2) for compatibility with Swift. get/setNumber is kept for backwards compatibility
  * Field 23: fixed getValue and parse to properly handle missing intermediate fields
  * Field 14S: has 4 new compatibility methods: getRateSource/setRateSource for Source and Number components and getTimeAndLocation/setTimeAndLocation for Time and Location components
  * Field 12: component is now of expected to have a numeric type
  * Code cleanup for Fields and Date|BIC|Amount|Currency Container
  * Added support for BigDecimal and Long component types (instead of just Number) in several fields
  * Fixed display text generation for fields having a date with pattern MMDD (only the month was included in the text)
  * OptionAPartyField: added set/getPartyIdentifier (for components 1 and 2) and renamed BIC to IdentifierCode. Affects fields 42A, 51A, 52A, 53A, 54A, 55A, 56A, 57A, 58A, 81A, 82A, 83A, 84A, 85A, 86A, 87A, 88A, 89A, 91A and 96A
  * OptionDPartyField: added set/getPartyIdentifier (for components 1 and 2). Affects fields 42D, 50D, 51D, 52D, 53D, 54D, 55D, 56D, 57D, 58D, 81D, 82D, 83D, 84D, 85D, 86D, 87D, 88D, 89D, 91D and 96D
  * OptionBPartyField: added set/getPartyIdentifier (for components 1 and 2). Affects fields 52B, 53B, 54B, 55B, 57B, 58B, 82B, 84B, 85B, 86B, 87B and 88B
  * Prepared Option A, B and D classes to support the PartyIdentifier interface with methods getPartyIdentifier and setPartyIdentifier
  * Enhanced Block2 creation by enriching Block Type to "O" or "I".
  * (PW-746) Fixed MT reference extraction for 20C in categories other than 5, and with MUR as fallback option
  * (CR-23) Added SwiftMessage#getMOR
  * Updated dependency: Apache Commons Lang 3.8.1 -> 3.12.0
  * Updated dependency: Apache Commons Text 1.6 -> 1.9
  * Updated dependency: Gson 2.8.2 -> 2.8.8

#### 9.2.6 - October 2021
  * (GH-60) Enhanced parser for field 98C
  * (PW-703) Enhanced SwiftParser in order to validate "Input" or "Output" Block 2 type
  * Enhanced the MtId to automatically extract the variant from String identifiers such as "fin.103.STP" or "202.COV"

#### 9.2.5 - September 2021
  * (PW-664) Parser enhancement to be lenient on LF before block identifier

#### 9.2.4 - August 2021
  * MultiLineField: preserve starting component separator when getting lines with offset

#### 9.2.3 - August 2021
  * Added user assigned country codes (example "XE") as valid codes in the IsoUtils country validation
  * Added field classes for SCORE messages: 11T, 12[S,R], 25G, 31[J,K,T], 34[D,K,L,M,S,T,U,X,V,W], 49[J,K,L] (to be used in the proprietary payload of the MT798 envelop)
  * MT564: Minor scheme fix, 92a TAXR and WITL can be repeated in CASHMOVE (E2)

#### 9.2.2 - July 2021
  * (PW-627) fixed Narrative.builder() to compute "//" size in the lines wrapping
  * (PW-581) the MultiLineField API now preserves any starting and trailing spaces in field lines
  * MT565: fixed repetition of sequence B2 (multiple to single)
  * MT548: Minor scheme fix, added letter option "C" in field "98C:SCTS" in sequence "C1a1B1"

#### 9.2.1 - June 2021
  * Added "ignore block 3" and "ignore priority" options to the SwiftMessageComparator
  * Added field classes for SCORE messages: 12[H,K,L], 20E, 25F, 29[D,F], 31R, 78B (to be used in the proprietary payload of the MT798 envelop)
  * Enhanced parser for LogicalTerminalAddress when the parameter has 9 characters
  * (PW-534) allowed null value for the Tag constructor

#### 9.2.0 - May 2021
  * SWIFT Standard release update 2021 (live 21 November 2021)
  * Yearly revision of deprecation phase (see http://www.prowidesoftware.com/resources/deprecation-policy)
  * Fixed the getSequence API in MT classes when the sequence boundary field is repetitive, in some scenarios produced invalid results
  * (PW-519) Field92H: Added "Rate Status" accessors
  * (PW-519) Field92J: Replaced "Narrative" accessors by "Rate Status" accessors

#### 9.1.4 - April 2021
  * Fixed getConditionalQualifier in fields 69C, 69D and 92H
  * Fixed field 41D isOptional(component) method
  * (PW-510) Fixed parser of field 90L
  * (PW-508) Fixed validator pattern in field 98K
  * Added MultiLineField interface implementation to fields: 45C, 45L and 49Z
  * Removed MultiLineField interface implementation to field 77H since its value is always a single line
  * (PW-501) Added getNarrative(deli), getNameAndAddress(deli) and similar getters in Field classes to get a concatenation of the relevant components with a specific delimiter
  * (PW-501) Fixed the getNarrative(), getNameAndAddress() and similar getters in Field classes to do a simple join of the relevant components, without CRLF and without components value trim
  * (PW-505) Fixed SwiftFormatUtils#decimalsInAmount(BigDecimal)
  * NPE prevention in AbstractMT.getFields() when the parsed FIN content is invalid
  * Added UETRUtils to generate the GPI unique end-to-end transaction reference, mandatory for several payment messages
  * Added customizable strategies to set the MtSwiftMessage metadata fields: reference, main amount, value date, etc...
  * Added field classes for SCORE messages: 13E, 21S, 21T, 27A, 29P, 29S, 29U, 49Z (to be used in the proprietary payload of the MT798 envelop)
  * (PW-451) Added backward compatible implementation in setComponent* and SetNarrative* API of narrative container fields: 29A, 37N, 70, 71B, 71D, 72Z, 72, 73A, 73, 74, 75, 76, 77A, 77B, 77D, 77
  * (PW-445) Added backward compatible fromJson for narrative container fields: 29A, 37N, 45B, 46B, 49M, 49N, 70, 71B, 71D, 72Z, 72, 73A, 73, 74, 75, 76, 77A, 77B, 77D, 77J, 77
  * Added Direction to the SwiftBlock2Field enumeration
  * Added more message type cases to the SwiftMessageUtils valueDate
  * Minor fixes in MT530 model: fields B/22F and C/90[A,B]

#### 9.1.3 - December 2020
  * Changed SwiftMessage#isGpi() to be true for: 103, 199, 299, 192, 196, 202COV or 205COV (mandatory outgoing GPI types)
  * Removed the indexes from the AbstractSwiftMessage JPA mapping (can be created directly in the DB as needed)
  * Added options in the MT message comparator to ignore the LT identifier or test flag when comparing header LT addresses
  * Added asTestBic in BIC to create a test BIC by setting the second component of the location to zero
  * Added API in the SwiftBlock2Output to set the MIR date and receiver date time fields from Calendar object

#### 9.1.2 - October 2020
  * Fixed set of MUR when an MtSwiftMessage is created from an acknowledge (service 21 message)
  * Changed AbstractSwiftMessage JPA mapping to EAGER load the status trail and the properties
  * Added a new MessageDirection enum as alternative to the legacy MessageIOType

#### 9.1.1 - September 2020
  * Fixed parser for fields 94L and 95L
  * Added MurMessageComparator to match ACKs based on the MUR
  * Changed the SwiftMessage#getMUR to retrieve field 108 from either block 3 or block 4 (system messages)
  * Enhanced the AckMessageComparator to still match on differences in block 2 optional fields or block 4 EOL characters
  * Minor refactor in MtSwiftMessage update from model (SwiftMessage)
  * Added a trim to the content parsed from the RJE reader
  * Fixed setPdm in MtSwiftMessage that was over writing the pde field
  * Minor changes in the MtSwiftMessage to avoid log warnings when setting metadata from message model
  * Added convenient field getters in the ServiceMessage21 (ACK/NAK) model class and made the getMtId() return "gpa.021"

#### 9.1.0 - May 2020
  * SWIFT Standard release update 2020 (live 22 November 2020)
  * Yearly revision of deprecation phase (see http://www.prowidesoftware.com/resources/deprecation-policy)
  * Enhanced components namings in field 98[DEGH]
  * Added rich API to parse and build narrative fields: 29A, 37N, 45B, 46B, 49M, 49N, 70, 71B, 71D, 72Z, 72, 73A, 73, 74, 75, 76, 77A, 77B, 77D, 77J, 77
  * Mx related classes moved to the prowide-iso20022 project (open source since October 2020)

#### 8.0.2 - April 2019
  * Added IBAN validation for Seychelles
  * Added field setters API in the SwiftBlock5
  * Added SwiftBlock5Field enumeration with commonly used block 5 trailer fields
  * (CR #235) Added SafeXmlUtils to disallow XXE in all XML parsing code
  * Fixed parser for fields 70[C,D,E,G], 94E, 95V when first line second component contains slashes
  * Changed default root element for Mx from message to RequestPayload
  * Fixed month day parsing in SwiftFormatUtils for leap years
  * Added MxParser#containsLegacyHeader() to check weather the message uses the legacy SWIFT header or the ISO business header
  * Added MtSwiftMessage constructor from AbstractMT
  * Fixed parser to preserve trailing lines in field values, even if the lines are empty (empty trailing lines were trimmed before)
  * (CR #203) Enhanced parser for party fields, explicit /D/ and /C/ is parsed as mark, otherwise any content following the / is parsed as account
  * Fixed field 108 order and overwrite if exist logic in SwiftBlock3#generateMUR
  * (CR #207) Added optional parameter in SwiftWriter and FINWriterVisitor to control whether field values should be trimmed

#### 8.0.1 - October 2019
  * Added SwiftMessageUtils#currencyAmount to retrieve the main currency and amount from a message
  * (CR #192) Fixed ConversionService#getFIN(SwiftMessage) to avoid altering the message parameter when removing empty blocks
  * Added an optional SwiftWriter#writeMessage with ignoreEmptyBlocks parameter
  * SwiftMessage#setUserBlocks(List) made public
  * Removed the trim to field values in the XML to enable consistent round trip conversion between FIN and XML
  * Explicit UTF-8 encoding was added where necessary to ensure portability
  * Added MultiLineField implementation to 45D, 49G, 49M and 49N

#### 8.0.0 - May 2019
  * JRE requirement increased to Java 1.8
  * SWIFT Standard release update 2019 (live 17 November 2019)
  * Yearly revision of deprecation phase (see http://www.prowidesoftware.com/resources/deprecation-policy)
  * Added common hierarchy for option J party fields

#### 7.10.4 - May 2019
  * Updated dependencies: apache-commons-lang 3.7 -> 3.8.1
  * Updated dependencies: apache-text 1.3 -> 1.6
  * Added copy constructors to MT header blocks
  * Added setDate(Calendar) to MIR object
  * (Issue #25) Fixed padding in PPCWriter
  * Added helper API SwiftTagListBlock#splitByTagName to get sub-blocks by field boundary
  * Fixed IOB exception in SwiftBlock2Output#setMIR in lenient mode
  * SwiftParser#tagStarts changed to protected to allow overwriting in custom parsers for non-compliant messages
  * Moved getMessageType from MtSwiftMessage to parent class AbstractSwiftMessage
  * Added getVariant and getMtId to MtSwiftMessage; added getMxId to MxSwiftMessage
  * Added setMUR in SwiftMessage
  * Added helper method in SwiftWriter to ensure break lines of any String has CRLF
  * Added setSignature and getSignature to SwiftMessage and AbstractMT to set and retrieve MDG tag in S block (LAU computation available in Prowide Integrator)
  * Added propertyValue to AbstractSwiftMessage to check if a property is set with a given value
  * Changed IsoUtils implementation to use Currency.getAvailableCurrencies() in the initialization
  * Deprecated AckSystemMessage in favor of ServiceMessage21
  * Fixed negative index bug in AbstractSwiftMessage#getPreviousStatusInfo when message has less than two statuses in the trail
  * Fixed getLines API in Fields that in some cases was trimming the first line starting slash from the result
  * Fixed eventual NPE produced in MxSwiftMessage#updateFromMessage() when creating MxSwiftMessage from XML document
  * Fixed column length for "variant" in MxSwiftMessage persistence mapping
  * Added a fields() method in SwiftTagListBlock to get all block Tag objects as Field objects
  * Added API to field 50F and 59F to get structured content for the line numbers

#### 7.10.3 - October 2018
  * License changed from LGPL to the more permissive Apache License 2.0
  * Fixed serialization of field 48
  * Completed SwiftMessageUtils#currencyAmount for missing MTs
  * Fixed NPE in SwiftBlock4.removeEmptySequences with fields 15A as sequence boundary
  * (Issue #15) MxParser.java typo analiseMessage -> analyseMessage
  * Added getFields() to MT classes
  * Added bean validation annotations for BIC, IBAN, ISO country and currency
  * Enhanced the BIC internal model to allow accessor for all subfields
  * Enhanced the BIC validation with enum to report the specific validation problem found
  * Changed the default SwiftParser behavior to lenient, meaning by default it will not throw any IllegalArgumentException when headers size is invalid
  * Fixed FIN writer to preserve trailing spaces in tag value
  * Added JPA annotations to the SWIFT model intended for persistence (AbstractSwiftMessage and subclasses)
  * Removed the old Hibernate XML mapping AbstractSwiftMessage.hbm.xml (in favor of generic JPA annotations in model)
  * Added SwiftTagListBlock#removeSubBlocks to remove all instances of a given subblock
  * (Issue #13) Fixed SwifttagListBlock#removeSubBlock
  * Added JsonSerializable interface to all model classes implementing toJson()
  * Added toJson and fromJson to MT and Field classes
  * Added toJson and fromJson to the MtSwiftMessage and MxSwiftMessage model
  * Added field 434 in SwiftBlock3Builder

#### 7.10.2 - May 2018
  * Revamped the JSON API implementation using Gson, added missing fromJson methods

#### 7.10.1 - April 2018
  * FIN writer: reverted the trim in tag values introduced in 7.8.9

#### 7.10.0 - April 2018
  * SWIFT Standard release update 2018
  * JRE requirement increased to Java 1.7
  * Dependencies: updated apache commons-lang from 2.6 to 3.7
  * Yearly revision of deprecation phase (see http://www.prowidesoftware.com/resources/deprecation-policy)
  * Added API in SwiftMessage for the SWIFT gpi service: getters and setters for the service type identifier and UETR
  * Added an automatically generated UETR when creating new MT instances for 103, 103 STP, 103 REMIT, 202, 202 COV, 205, or 205 COV
  * Added API in SwiftMessage to set the variant (STP, REMIT, COV)
  * New helper API for block 3 (SwiftBlock3Builder) to ensure only expected fields are added and in proper order

#### 7.9.7 - April 2018
  * Dependencies: added gson 2.8.2
  * Added full IBAN validation including control digits and custom account numbers per country
  * Added SwiftCharset and SwiftCharsetUtils helper API to validate SWIFT related charsets.
  * Added SwiftTagListBlock#getFieldByQualifiers(name, qualifier, conditionalQualifier) to gather generic fields based on qualifiers content
  * Added addTag(index, tag) and setTag(index, tag) in SwiftTagListBlock to insert new field in specific positions
  * Added Field#is(String ...) to test component 1 of fields against a list of possible values
  * Added non-ISO country code XK (Kosovo) to IsoUtils
  * Added API in IsoUtils to add custom codes for countries and currencies
  * Added read-only properties in AbstractSwiftMessage for the message creation year, month and day of moth
  * Added support for custom split char in RJE reader/writer
  * Fixed missing repetitive 35B in MT549
  * Build migrated to Gradle

#### 7.9.6 - December 2017
  * Fixed conversion to XML with compressed parameter true in ConversionService

#### 7.9.5 - December 2017
  * Fixed getValueDisplay in field 50F to strip the starting slash in the account number
  * Added getLabelForLineNumber(String subfieldNumber) in Field50F to return the labels for the structured line identifiers
  * Enhanced getComponentLabel(final int number) in Field50F to return proper dynamic labels based on line number identifiers
  * Added getCorrespondentBIC to SwiftMessage and AbstractSwiftMessage
  * Expanded sender/receiver in MtSwiftMessage and MxSwiftMessage from BIC8 to BIC11 in order to keep branch information in those cached attributes
  * Added checksumBody to AbstractSwiftMessage for proprietary checksum calculated on the body only, as a complement to the existing checksum on the whole message
  * Fixed AbstractSwiftMessage#copyTo(msg) implementation to perform hard copy of list objects (similar to a copy constructor implementation)
  * Expanded precision in getValueDisplay for all numeric fields to preserve the decimal digits present in the original value
  * Implemented SwiftMessage#getUUID and added getUID(Calendar, Long)
  * Implemented SwiftMessageUtils#calculateChecksum as MD5 hash on whole FIN message content and added new checksum for the text block only

#### 7.9.4 - November 2017
  * Internal code maintenance release

#### 7.9.3 - October 2017
  * JRE requirement increased to Java 1.6
  * Added API in BIC to return the distinguished name (DN) for a BIC
  * Added equalsIgnoreCR in Tag to compare values regardless of carriage return character being present or not in new lines
  * Fixed MxParser#parseBusinessApplicationHeaderV01 (it was setting the FinInstnId/Nm as BIC)
  * Removed invalid component in field 86J
  * Fixed order of components in fields 98J and 98K
  * Completed the component labels for all fields
  * Changed field 22C structure into individual components for the <SB-LC> function
  * Enhanced fields parse/serialization to preserve any whitespace in a component

#### 7.9.2 - August 2017
  * Fixed FINWriterVisitor to prevent printing 'null' tag values
  * Deprecated custom resource properties for currency and country codes, in favor of Java nativa API in Currency and Locale
  * Removed package-info.class from target jar to avoid class modifier issue in Java8 runtime
  * Fixed serialization of field 50F to allow the first line without a starting forward slash

#### 7.9.1 - June 2017
  * (Issue #5) Enhanced performance in SwiftParser
  * Removed sequence API for inner loops (non sequence) in MTs 306, 320, 340, 360, 361, 362, 410, 412, 420, 422, 450, 456

#### 7.9.0 - May 2017
  * SWIFT Standard release update 2017 (live 19 November 2017 for MT and 18 November for MX)
  * (Issue #2) maven build issues
  * (Issue #3) Field61 component 5 treated as amount
  * (Issue #4) Field72 structure fixed to allow 6 components at most
  * Field99A implements AmountContainer
  * Field95L implements BICContainer

#### 7.8.9 - May 2017
  * Yearly revision of deprecation phase (see http://www.prowidesoftware.com/resources/deprecation-policy)
  * Added convenient isType(int) to SwiftMessage
  * Fixed amounts() in AmountContainer fields

#### 7.8.8 - March 2017
  * Added hashcode and equals to MxId
  * Added MUR generation in block 3
  * Added a multi-purpose SwiftMessageComparator for MT, as an abstraction of the existing AckMessageComparator
  * Added helper API to remove empty sequences in block 4
  * Added ACK/NAK identifier constants and API in AbstractSwiftMessage
  * Added getDateAsCalendar in MIR/MOR
  * Added MtCategory enum for MT message categories and convenient category API in SwiftMessage
  * Added support for system and service messages in metadata gathered from SwiftMesasge in MtSwiftMessage
  * Added isServiceMessage in SwiftMessage
  * Added static factory method parse to SwiftMessage
  * Added new fields in AbstractSwiftMessage to hold main currency and amount, automatically set for most MTs from fields 32a, 33a, 34a, 19a and 62a
  * Added conversion to and from LT address in SwiftFormatUtils
  * (CR #10) Added comprehensive implementation of MT and Field classes for system messages (category 0)
  * Added custom name for internal loop sequences in MTs 110, 360, 361, 604, 605, 609, 824, 920, 935, 940, 942, 971 and 973
  * Added more options to retrieve information from the status trail in AbstractSwiftMessage
  * Reduced visibility from public to protected for MTs inner sequence classes mutable fields; START, END, TAIL.
  * Fixed analyze and strip API in MxParser to support nested Document elements
  * Fixed MT500 removed invalid fields after GENL linkage sequence
  * Fixed AckMessageComparator to cover all fields in block 2 input and output
  * Fixed getSender and getReceiver for service messages in SwiftMessage
  * Fixed MT600, removed invalid fields 26F, 34G, 31C in sequence A
  * Fixed parse for DATE1 (MMDD) to handle properly leap years
  * Fixed RJEWriter to avoid writing the split character '$' and the end of the file, afterwards the last message
  * Expanded helper API in AckSystemMessage
  * TagListBlock tags field made private instead of package protected
  * Enabled mutability of LogicalTerminalAddress objects, allowing setting the branch from superclass BIC
  * Enhanced parser for fields 11R, 11S and 37H (NPE prevention)
  * Removed invalid generated code for internal loops (non-sequence) in MTs: 110, 201, 360, 361, 559, 604, 605, 609, 824, 920, 935, 940, 942, 971, 973
  * Enhanced from() and to() methods in BusinessHeader to catch more options

#### 7.8.7 - December 2016
  * Fixed getMessageType in MT103_STP, MT102_STP, MT103_REMIT, MT202COV and MT205COV to return the number without the validation flag (as expected per javadoc definition)
  * MT518 fixed fieldset for Field 70
  * MT330 fixed qualifier in Field 22
  * MT513 and MT514 Field 11 moved outside previous fieldset
  * MT541 to MT547 Field 90[A,B] changed to fieldset.
  * MT564 fixed fieldset items in Field93[B,C]
  * MT565 to MT567 Sequence D, fixed field 13
  * MT609 and MT798_763 fixed qualifiers in Field 29
  * When creating MT instances, the validation flag (STP, REMIT, COV) will be automatically created as block 3 field 119 when applies for the created MT
  * Log warning when creating MTnnn objects from invalid message types, for example calling MT103.parse(fin) and passing FIN content for an MT 202
  * Ignore validation flag (STP, REMIT, COV) if it is not valid for the message type, when creating MT object from SwiftMessage (to avoid ClassNotFoundException)
  * Enhanced semantic in AckMessageComparator when a blocks are null or empty (see javadoc for details on how blank blocks are handled in comparison)

#### 7.8.6 - November 2016
  * MxParser; IOB exception prevention in strip methods when XML has empty header or document
  * Prevention for IOB exception in ensureEOLS when converting MT message from model into FIN text
  * Expanded API in SwiftParser with static parse methods for each MT block
  * Expanded API in SwiftWriter to serialize any MT block into its native SWIFT representation, also made visit API in SwiftMessage static

#### 7.8.5 - October 2016
  * Added getSubBlockByTagNames and getSubBlocksByTagNames in SwiftTagListBlock to retrieve subblocks based on comprehensive list or tag names
  * Added API in BusinessHeader to create valid BAH from simple parameters
  * Added API in BIC to get the branch and institution
  * Added API to match message identifier by regex, for example fin.*STP
  * Added API to strip header and document portion of Mx message in XML format
  * Added analizeMessage in MxParser, lightweight API to retrieve structure information from an MX messages
  * Added enumerations for message priority and delivery monitoring in MT block 2
  * Added json() to AbstractMT
  * Added getComponentLabel(int) in Field classes
  * Added updateFrom AbstractMT to MtSwiftMessage
  * Added reference as class attribute in AbstractSwiftMessage (set by subclasses)
  * Added FileFormat attribute to AbstractSwiftMessage for clear identification of content in implementing subclasses
  * Added constructor of MxSwiftMessage from AbstracMX
  * Added API to get BIC codes from DN in Mx messages
  * Added MtId class, analogous to the existing MxId for MX messages
  * SwiftParser parsing of block 4 published as static public method
  * Added AbstractMessage as base class for specific MTnnn and MXmmm model hierarchy
  * Added MessageStandardType with MT and MX values and ServiceIdType for header service id values
  * Added nextSwiftMessage in RJE/PPC readers for system messages support
  * Added valuesNumeric to MT enumeration MtType
  * Added getValueDisplay with optional locale parameter to display formatted field and individual components values
  * Added MTVariant enum and getVariant API in swift messages
  * Added CONDITIONAL_QUALIFIER component number as static class field for all generic fields (fields implementing the GenericField interface)
  * Added BusinessHeader serialization into xml and Element objects
  * Added business header parse from Element object in MxParser
  * Added RJEReader and RJEWriter to create MT message files in RJE format
  * Added PPCWriter to create MT message files in DOS-PPC format (also enhanced API for the existing PPCFileReader)
  * Added path() API in MxNode
  * Added MtType, an enumeration of all available MTnnn implementations
  * Added parse to Field classes to update field components from full value
  * Added append lists of Tag or Field to TagListBlock
  * Added support for attributes in MxNode
  * Added generic setters for attributes in header blocks 1 and 2 using qualified names (#setField)
  * Added write XML method for MX business header
  * Added validName as static method in Field, to validate field names
  * Added getField static API in Field to create new instances with reflection given the field name and value
  * Added reference(msg) to SwiftMessageUtils to get the sender reference from messages that contain a reference field
  * Added SwiftMessageRevision to the swift messages model, to hold and track changes in swift messages
  * Fixed parser for field 98F
  * Fixed field 61 parse allowing EC and ED as credit/debit mark subfield
  * Fixed from() and to() methods in BusinessHeader to return the BIC code for both possible header types
  * FIxed serialization of component 1 in field 50F
  * Fixed parser and serialization in Field98F
  * Fixed SwiftMessage.toJson single quote to double quote in timestamp field
  * Fixed getLabel when used with the parameters combination of a valid mt and a null sequence
  * Fixed getValue in Field61,
  * Added proper implementation for isOptional(component) in Field61
  * Fixed components trim to null in parser for several fields when the component value is not present
  * Fixed separators trim in getLine API
  * Fixed setComponentN(Number) when component is not a SWIFT amount, Number is now serialized as an integer (without decimal separator)
  * Fixed MT parser to allow additional lines in a field start with colon ':'
  * Fixed field 32R second component changed from currency to string to allow codewords ’FOZ’, ’GOZ’, ’GRM’, ’KLO’, ‘LIT’, ’LOT’, ‘OTH’, ‘PND’, ’TAL’, ’TOL’, ‘TON’, ‘TOZ’, ’UNT’
  * Fixed field 33B first component changed from currency to string to allow codeword ’PCT’ used in MT601
  * Fixed API inconsistencies in MtSwiftMessage when updating from SwiftMessage objects.
  * Bugfix MT506 added mandatory field 28E
  * Added missing getters for Sequence E1 in MT300
  * Changed MX messages detection in MxParser to lighter implementation using Stax
  * Normalized Input/Output Outgoing/Incoming API in AbstractMT and SwiftMessage
  * SwiftMessage.toJson changed timestamp format to the recommended ISO 8601
  * MxSwiftMessage meta-data (sender, receiver, reference, identifier) read and set from raw XML content
  * Added support in XmlParser for the field version of Core proprietary XML format for MTs, the parser now reads both formats seamlessly
  * Better header API in MxSwiftMessage to support both ISO and SWIFT business headers
  * Elaborated identifier in MtSwiftMessage, using fin.type.variant instead of just the message type
  * Added comprehensive sequence names into pw_swift_label property files
  * Added translations of pw_swift_label property files to FR, DE and IT (complementing the existent EN, ES and RU files)
  * Completed pw_swift_label property files for all field + mt + sequence combinations
  * Complete application header parsing in MxParser
  * Better application header detection in MxParser based on namespaces
  * Added component labels for field 13K
  * Fields 11R and 11S component 3 split into two independent components.
  * In Field61, component 6 was splitted into two independent components to hold the "transaction type" and the "identification code" as stated in the standard definition for function <SUB-6>
  * Added SwiftParserConfiguration to encapsulate several parsing options, allowing fast parsing of AbstractMT by reading the text block in raw format

#### 7.7.0 - October 2015
  * valueDate in SwiftMessageUtils
  * isType(int...) in SwiftMessage
  * Enhanced the getSequence API in MT classes with support to nested sequences, allowing for ex: getSequenceE1(getSequenceEList().get(n))
  * getLine API for FieldNN classes based on semantic lines number identification
  * Copy constructors for FieldNN classes, performing a deep copy of the components' list
  * MxParser message detection
  * New generic XML model and API, as backbone for MX messages.
  * Headers Blocks: new generic getters in blocks 1 and 2 to retrieve attributes using full qualified names from enums; for example getField(SwiftBlock1Field.LogicalTerminal)
  * Static labels for subfields in FieldNN classes to allow for example getComponent(Field93B.BALANCE)
  * BIC: API to check for live and non-live bics
  * MxParser: parseApplicationHeader and constructors from several sources
  * Added missing labels' API to fields: 36E, 69A, 69C, 69D, 70C, 70D, 70G, 90F, 90J, 92D, 92L, 92M, 92N, 92R
  * Added the ApplicationHeader attribute to AbstractMX
  * Added API to search nodes or content by path or name in the MxNode tree returned by the MxParser
  * Added json() and xml() methods to MT classes
  * Added write to file and output streams to AbstractMT and AbstractMX
  * Added consistent constructors from String, File or InputStream to MTnnn classes
  * Added static parse methods to create MTnnn objects from String, File, InputStream or MtSwiftMessage
  * Added consistent constructors from String, File or InputStream to AbstractSwiftMessage and subclasses MtSwiftMessage and MxSwiftMessage
  * Added static parse methods to create MtSwiftMessage and MxSwiftMessage objects from String, File or InputStream
  * Lib: added read from input streams
  * NPE prevention in SwiftFormatUtils.getCurrency
  * Fixed getSender and getReceiver for MTxxx to return accurate information regardless the message being of type input or output (also to be consistent with analogous methods in SwiftMessage)
  * Added CR and LF to charset z and x at SwiftcharsetUtils
  * Fixed validation of fields 70F, 77S and 77T that unnecessary restricted the allowed amount of lines (not it is unlimited because charset Z allows CRLF).
  * Fixed OutOfBound exception at MxNode findFirst implementation when a node has multiple children
  * Fixed getDescription for Field35B, now returning component 3 instead of 2
  * Better API consistency between MT and MX implementations, with common ways to parse and build.
  * Changed sender and receiver attributes for MtSwiftMessage to hold BIC8 instead of full LT identifiers.
  * Deprecated the use of model message inside MtSwiftMessage
  * Simplified distribution zip with -sources and -javadoc jars

#### 7.6.0 - October 2014
  * New BIC API: isTestAndTraining(), getLogicalTerminalIdentifier(), bic8() and bic11()
  * New model for LT addresses, and its related API in header classes
  * New SwiftMessage API: AbstractMT toMT()
  * New AbstractMT API: getSequence(name), getSequenceList(name)
  * Added builder API: constructors and append methods to add content with chaining support
  * Added missing getValue() implementations to field classes. Example: Field26C
  * Added annotations to MTNNN classes to identify sequence split strategy involved (more traceable code)
  * SRU 2014. Affected MTs: 300, 304, 305, 306, 340, 341, 360, 361, 380, 381, 502, 506, 508, 509, 513, 514, 515, 518, 527, 530, 536, 537, 538, 540, 541, 542, 543, 544, 545, 546, 547, 548, 549, 558, 564, 565, 566, 567, 568, 569, 575, 600, 601, 942
  * Added description and release javadoc comments to MT classes
  * Added MX Generic model support
  * Added MX parse
  * Added MT300.getSequenceE()
  * Minor fix in MT300 sequences structure, B1 and B2 inside B, and named D's subsequence as D1
  * SwiftTagListBlock implements Iterable<Tag>
  * Bugfix SwitTagListBlock.countTagsStarsWith(string,string) was ignoring tagnames in count

#### 7.5.0 - August 2014
  * Added toJson in SwiftMessage and SwiftTagListBlock, SwiftBlock1 and 2
  * Added to SwiftTagListBlock  getFieldByName(String, being)
  * Added to SwiftTagListBlock  getFieldByName(String, being, component2)
  * Added to SwiftTagListBlock  getFieldByNumber(int , being)
  * Added START_TAG and END_TAG constant to Sequence inner classes
  * Added Sequence.newInstance() method
  * Added static method Field.emptyTag()
  * Added to SwiftTagListBlock append(SwiftTagListBlock)
  * Changed SwiftFormatUtils.getNumber(Number) to allow variable amount of decimal parts without the previous limit of two
  * Added support for national clearing system codes in party identifier components: example 52A starting with //AT123
  * JSON serialization: fixed missing quotes escaping and newline
  * in some occasions, getSequenceA() incorrectly returned null instead of empty sequence as stated in javadoc
  * Refactored Field77A to include 20 independent components instead of just one (current implementation is similar to Field79)
  * Deprecated isAnyOf(String ... names) and added isNameAnyOf(String ... names) semantics of method more clear with its name
  * Changed the semantic of getAccount methods to remove starting slashes if any
  * Some javadoc for BICRecord
  * Added serialization timestamp to JSON generation
  * In Field* void set changed to Class set so we can support the code style new Field().setThis().setThat().setThatToo()
  * Added Field.asTag()
  * Added option in XMLWriterVisitor to serialize field instead of tag

#### 7.4.0 - March 2014
  * In BIC added subtype attribute and getBranch method
  * ReaderIterator to read a file from a classpath resource and split its content by the '$' symbol
  * In SwiftMessage new API to check and get linkages sequences
  * In AbstractSwiftMessage new constructor using MTSwiftMessage as parameter
  * In MTSwiftMessage updateFromModel and updateFromFIN using internal attributes
  * Several helper methods to parse field content using SwiftParseUtils
  * Field classes implementation for fields belonging to System and Service Messages (i.e. 451)
  * Resource bundle labels for System and Service Messages fields
  * MOR class to represent the message output reference (inherited from the MIR)
  * SwiftParseUtils: getTokenSecond and getTokenSecondLast with prefix
  * getAll(SwiftMessage) in every FieldNN class
  * getAll(SwiftTagListBlock) in every FieldNN class
  * New constant in Field suitable for import static
  * SwiftTagListBlock: constructors made public
  * SwiftTagListBlock: added filterByNameOrdered(String ...)
  * SwiftTagListBlock: added getFieldsByNumber(int)
  * SwiftTagListBlock: added removeSubBlock(String)
  * SwiftTagListBlock: deprecated int getTagCount(String)
  * SwiftTagListBlock: added int countByName(String)
  * SwiftTagListBlock: deprecated int getTagCount()
  * SwiftTagListBlock: added int countAll()
  * SwiftTagListBlock: added method boolean containsAllOf(String...)
  * Improved toString in SwiftTagListBlock and Tag
  * Javadoc improvements
  * Fixed SwiftBlock1 constructor to allow LTs missing the optional A, B or C identifier (11 characters length); ex. FOOOAR22XXX
  * Fixed getStatusInfo and getPreviousStatus in messages base class that was causing IOB exceptions
  * Issue 39: missing trimToEmpty in getComponent2 in 50H
  * MT207: fixed maximum repetitions of sequence B from 1 to unlimited

#### 7.3.0 - January 2014
  * removed log4j.properties
  * New API: Field.isAnyOf(String...)
  * Added many methods in SwiftTagListBlock in resemblance to String manipulation API
  * SwiftTagListBlock added: getTagsByNumber(int), SwiftTagListBlock removeAfterFirst(String, boolean)
  * Added Tag.startsWith
  * Added Tag.contains
  * Added PPCFileReader iterator to read and split pc connect files

#### 7.2.0 - September 2013
  * Added Field.letterOption
  * Added SwiftTagListBlock.getSubBlockBeforeFirst
  * Added SwiftTagListBlock.filterByName
  * Fixed Field.appendInLines that was causing the getValue of several fields (ex 35B) to start with unexpected EOL
  * Fixed NPE in XMLParser with null value in tags
  * Fixed Avoid usage of double in amount resolver

#### 7.0.0 - August 2013
  * Enhanced messages model with base support for MX messages.
  * New messages meta-data model to handle additional information: Status history, User notes, Properties list.
  * Useful API to SwiftMessage to get: direction, PDE, PDM, UUID, MIR, MUR and getTypeInt
  * Complete FieldNN implementation classes
  * Complete MT helper classes, covering all message types
  * Added model and API to handle Sequences at MT classes, covering all sequences based on 16R/16S boundaries.
  * New API to handle sub blocks: SwiftTagListBlock.removeUntilFirst, SwiftTagListBlock.containsAnyOf
  * Ensuring of SWIFT EOL at ConversionService.getFIN
  * Fixed getValue of several fields to prevent printing of null
  * Fixed getValue of several fields with missing slash separator on optional components
  * Added missing field getters for MT classes with fieldsets: for example 93B at MT564.
  * getValue for Field35B. Thanks to Raghu rathorr@users.sf.net
  * getCalendar bug related to unused format parameter
  * Changed Field26C parser and subfields structure to split the string before the VAR-SEQU into independent components
  * Removed deprecated net.sourceforge classes
  * Removed unimplemented method amounts() in AmountContainer

#### 6.4.0 - March 2013
  * Added visitor API on tag list block
  * New interface to identify and use generic fields (notice DSS methods are not part of non-generic fields)
  * Added API on MT classes to simplify messages creation
  * Comprehensive getters and setter API for field classes using functional names
  * Added PatternContainer interface and implemented in field
  * Better CurrencyContainer API
  * Added API to SwiftFormatUtils to get String components from Calendar using different SWIFT date/time formats
  * Implemented API for CurrencyContainer for all Fields
  * Added MT helper classes for MTs: 518, 549, 800, 801, 802, 824, 600, 601, 604, 605, 606, 607, 608, 609
  * Added Field implementations for 33G, 35U, 86B, 68A, 68B, 68C, 94C, 31F, 37a, 34J, 35H, 31X
  * Added API to simplify messages creation; defaults for header blocks attributes, addField to Block4, setSender at Block1

#### 6.3.0 - October 2012
  * Added MT helper classes for MTs: 500, 501, 502, 503, 504, 505, 506, 507, 508, 509, 510, 565
  * Fixed getAsCalendar for year component of field 77H
  * Fixed parsing of field 50F
  * Added field class for: 26C
  * Support to identify which sequence a tag belongs to
  * Added API to FieldNN classes to get the DSS field
  * Added API to FieldNN classes to get the qualifier and conditional qualifier components
  * Added API to FieldNN classes to determine if field is generic or non generic
  * Field class made abstract
  * FieldNN isOptional: method to check if a given component is optional for the field
  * Field getLabel: support for label exceptions per mt and sequence
  * SwiftParser changes to distinguish the presence of brackets when they are block boundaries or part of an invalid field value
  * Improved parsing of Field35B, first and second components are set only if "ISIN " is present
  * SR2012 update: deprecated fields 23C, 23F. Updated MT300, MT304, MT305 with field changes.
  * Added serialization for: 20E, 29G, 31G, 36E, 50G, 50H, 69B, 69D, 69F, 77H, 90F, 90J, 90K, 92D, 92L, 92M, 92N, 94D, 94G, 95T, 98F
  * Fixed serialization of field 59A

#### 6.2.0 - June 2012
  * Purged and some tunning of parser log
  * Added getField* API con block4
  * Added Tag API: public boolean contains(String ... values)
  * Added more API to get subblocks based on tag number boundaries regardless of letter options
  * Fixed Tag.isNumber to consider the whole number and not just the prefix, isNumber(58) returns true to 58A but not to 5
  * Added Tag.getNumber() API
  * Fixed build to include MTs and FieldNN source codes in the package
  * Fixed parser for fields: 94D, 50H, 50G and 52G
  * Added MT helper classes for MTs: 567, 900, 910, 920, 935, 941, 970, 971, 972, 973, 985, 986
  * Added API for getLabel at Field objects, to retrieve business oriented names from resource bundles

#### 6.1.0 - March 2012
  * Added BICContainer interface
  * Added MT helper classes for MTs: 360, 361, 362, 364, 365, 381, n90, n92, n95, n96, n98, 420, 422, 430, 450, 455, 456, 701, 705, 711, 720, 721, 732, 734, 740, 742, 747, 750, 752, 754, 756, 768
  * Added getValue for Field13E
  * Fixed getValue for Field31R (2nd component is optional)

#### 6.0.0 - February 2012
  * Merged patches from Walter Birch
  * SwiftParser: fix for parse error with malformed tag 72
  * Implemented getValue for Fields: 19B, 31D, 31P, 31R, 39P, 40B, 41D, 92F, 93B, 98E and others with the same parser pattern
  * Changed packages in Hibernate mappings from sourceforge to prowidesoftware
  * Added SwiftMessageUtils class
  * Added date container interface to Fields to better support higher level model expressions
  * Added currency container interface to Fields to better support higher level model expressions
  * SWIFT standard update (Nov 2011)
  * Fixed field parser for 35B
  * Changed SwiftParser log level
  * Build: consistent release in jar, sources and javadocs jars, include dependent jars in lib directory
  * API to create FieldNN objects from Tag objects
  * Fixed field parser for 35B when first component is an ISIN number
  * Added DATE1 support for fields parser (fixes Field61)
  * SwiftMessage API to get sender and receiver addresses from message headers
  * Added MT helper classes for MTs: 101, 104, 105, 107, 110, 111, 112, 200, 201, 204, 205, 205COV, 207, 256, 300, 305, 306, 307, 330, 340, 341, 350, 540, 541, 542, 543, 564, 566
  * MT helper classes 102_not_STP and 103_not_STP with inheritance from defaults MT103 and MT102 classes
  * Added Field implementations for 36E, 69B, 69D, 69F, 90F, 90J, 93B, 93C, 94G, 95T, 95S, 98E, 98F, 98L, 67A, 77J, 92E, 98D, 95S, 50G, 50H, 52G, 31G, 77H
  * TIME3 implementation to format utils
  * Suppress warnings for unused imports in eclipse

#### 6.0.0-RC5 - August 2011
  * Fixed parser for Field20E
  * Added Field implementations for 90K, 92D, 92L, 92M, 92N

#### 6.0.0-RC4 - July 2011
  * Added MT helper classes for MTs (SCORE): 798<743>, 798<745>, 798<760>, 798<761>, 798<762>, 798<763>, 798<764>, 798<766>, 798<767>, 798<769>, 798<779>, 798<788>, 798<789>, 798<790>, 798<791>, 798<793>, 798<794>, 798<799>
  * Added MT helper classes for MTs: 191, 291, 391, 399, 491, 535, 591, 691, 699, 707, 760, 767, 769, 790, 791, 891, 991, 999
  * Added Field implementations for 13E, 20E, 22L, 23X, 24E, 27A, 29D, 29G, 29S, 31R, 39D, 39P, 49H, 49J, 50M, 72C, 77C, 77E, 78B

#### 6.0.0-RC3 - April 2011
  * Added MT helper classes for MTs: 304, 320, 321, 210, 599
  * Added Field implementations for 19B, 32H, 32R, 34E, 37G, 37M, 37R, 38J, 92F, 62A, 62B

#### 6.0.0-RC2 - February 2011
  * Added Field implementation for 15 (A,B,C,D,E,F,G,H,I,J,K,L,M,N)
  * Added MT helper classes for MTs: 300, 400, 410, 412, 416, 499, 544, 545, 546, 547, 548, 700, 710, 730, 799
  * Added Field implementations for 31D, 31P, 40B, 41A, 41D, 45A, 45B, 46A, 46B, 47A, 47B
  * field serialization from components values into SWIFT single string value
  * Removed log4.properties from distribution jar
  * MTs API: fixed field mutiplicity when a field becomes repetitive being present on multiple sequences or at repetitive sequences.
  * Hibernate mappings: removed confusing/commented blocktype mappings at SwiftBlock.hbm.xml
  * Hibernate mappings: package rename

#### 6.0.0-RC1 - October 2010
  * Migrated src code to java 1.5 (binary distribution is still 1.4 compatible by means of http://retroweaver.sourceforge.net/)
  * Java 1.4 compatibility changes
  * normalization of linefeeds to CRLF at Tag creation from XML parsing
  * Removed deprecated API
  * Added new package io with subpackages parser and writer; added new package utils.
  * Renamed all packages to com.prowidesoftware (backward compatibility maintained with facades)
  * Added implementation for MTs 102 not STP, 102 STP, 103 not STP, 103 STP, 195, 199, 202, 202COV, 203, 295, 299, 940, 942, 950
  * Added new SWIFT MT high level generated API, with classes for specific message types
  * New source package for generated swift model
  * Merged project "prowide SWIFT Fields" into "WIFE"
  * Added comparison options to AckMessageComparator
  * Removed old and incorrect charset validator class net.sourceforge.wife.swift.MessageValidator
  * Fix in remove user block method, thanks to Herman's contribution and patience
  * Parser API for (new SwiftParser()).parse(messageToParse);
  * Replaced commons-lang-2.3 -> 2.4
  * Fixed message writer: system messages' block4 generated with inline tags
  * SwiftMessage API to check if it's Straight Through Processing (STP), based on the content of the User Header
  * SwiftMessage API to check if it's a cover payment (COV), based on the content of the User Header
  * SwiftTagListBlock API to check if contains a specific Tag
  * Removed unimplemented and confusing package net.sourceforge.wife.validation
  * Deprecated old and unused validation-related classes
  * Added AckMessageComparator which is useful of identify the ack of a given message.
  * SwiftTagListBlock API to get a sub block given its name or its starting and ending Tag
  * SwiftTagListBlock API to get tags by content, given its exact or partial value
  * Helper methods from Block4 moved to SwiftTagListBlock
  * SwiftTagListBlock is no longer abstract, so it can be used to create instances for subblocks
  * Required JVM upgrade to 1.5
  * Initial update of upload-sf target for release to sourceforge

#### 5.2.0 - February 2009
  * Added missing hashcode and equals
  * Javadocs improvements
  * Revised and tested hibernate mappings
  * Added getBlockType
  * Added length to unparsed text persistence mappings
  * Fixed persistence mapping for block2 inheritance
  * Updated hibernate libs to version 3.2.6
  * Added isOutput
  * isInput made concrete, not abstract
  * Added abstract isInput() method to SwiftBlock2 for safer casting subblocks when input/output is unknown

#### 5.1.0 - July 2007
  * Migrated logging to java logging api
  * Removed SwiftBlock's deprecated methods.
  * Moved some common methods in SwiftBlock2Input/SwiftBlock2Output to parent class SwiftBlock2.
  * Upgraded commons-lang to version 2.3
  * Improved persistence mapping.
  * Move persistence (helper) package to wife-test project.
  * Minor javadoc fixes.
  * Fixed some warnings.

#### 5.0.0 - June 2007
  * Improved Hibernate mapping for simplified and more efficient data base schema.
  * Added support for unparsed text to model, persistence mapping and conversion services (needed for some MT0xx for example).
  * XML to SwiftMessage parsing methods moved from ConversionService to XMLParser in "parser" package.
  * New package created for parser classes "net.sourceforge.wife.swift.parser".
  * Made abstract intermediate classes of blocks object hierarchy.
  * Added support for user custom blocks in model, persistence mapping and conversion services.
  * Improved overall test cases coverage and source/resources structure.
  * Fixed some warnings.
  * Swift Parser enhancements; don't throw exception on unrecognized data, but preserve an internal list of errors.
  * Added reference to current message in parser, so it can take decisions based on parsed data.
  * Added constant for possible values for application id to SwiftBlock1.
  * Updated dependency: hsqldb 1.8.0.4 -> hsqldb 1.8.0.7.
  * Updated dependency: hibernate 3.1.3 -> hibernate 3.2.3.ga.

#### 4.0.0 - April 2007
  * Moving to junit 4 - some new tests are being written with junit4, this should make testing some features singificantly easier.
  * Move size and isEmpty methods to subclasses.
  * Improved deprecated exception messages and javadoc.
  * Added useful getter for the MIR field in Block 2 output.
  * Added support for optional fields in Block 2 input.
  * Method specific to each block moved to each block class, when possible compatibility methods were left in old places, marked as deprecated to provide a smoother migration path.
  * Removed deprecated API in SwiftBlock.
  * Adapted parser to new model refactor.
  * More javadoc in parser.
  * Improved xml writer (more clean tabs and EOL).
  * Refactored and fixed XML parsing for blocks 3 and 5.
  * Fixed build.xml to include resources in generated jar files.
  * Improved javadoc and validations in fin writer.
  * Completed basic internal XML parsing.
  * Added more tests for XML conversion.
  * Implemented XML conversion parsing for all blocks (except 4).
  * Updated passing test in conversion service.

#### 3.4.0 - March 2007
  * Added license header to source files.
  * Minor fixes in build system.
  * Enhanced IBAN validation routine.
  * Added numerous tests for IBAN validation.
  * Added JSValidationUnit backed by Rhino, to support easy extension of validations.
  * Made all loggers private static transient final.
  * Enhanced overview documentation.
  * Javadoc updates.
  * Code clean up.
  * Added many tag specific validation units targeting MT103 validation.
  * Removed ant junit fork since it broke in ant 1.7.

#### 3.3.0 - January 2007
  * Initiated MT103 validation rule.
  * Validation framework core classes written.
  * Utility classes for validation.
  * Removed old and deprecated/replaces writer component.
  * Dependencies clean up, ant downloads less libs now.
  * Added Currency ISO Codes (needed for validations).
  * VF: implemented TagExists and ConditionalTagPresence validation units.
  * Started implementation of validation units.
  * Initial implementation of BIC validation.
  * Initial implementation of IBAN validation.
  * Added ISO Countries for IBAN validation.
  * Fixed issue in writer with block5 as mentioned in bug 1601122.
  * Fixed issue 1595631.

#### 3.2.0 - 2006
  * Parser logging information cleanup.
  * Migrating to log4j 1.2.8 for better compatibility (issued with trace method on some servers).
  * Fixed build to properly include current timestamp in dist target when property release.name is not set.
  * Fixed bug in parser/writer integration which included double block number when using the writer with an object of a just parsed message(1595589).
  * Updated code to fix issue mentioned in https://sourceforge.net/forum/message.php?msg_id=4001538.

#### 3.1.1 - 2006
  * Small fixes for java 1.4 compatibility.

#### 3.1.0 - 2006
  * Fixes to compile for java 1.4 by default.
  * Fixed test for bug 1540294, typo in block number.
  * Use system EOL in XML writer.
  * Added compile timestamp to manifest in created jars.

#### 3.0.0 - 2006
  * Build: Added release.name property to manifest.
  * Build: added selection of tests known to fail and those known to pass.
  * Fixed persistence mapping.
  * Improved build and added control to exclude tests that are know to fail.
  * Model simplification: SwiftBlockN classes are being removed in favor of base class SwiftBlock removed list of blocks in message which was confusing when not all blocks present.
  * SwiftBlock (base class) and subclasses are mapped and persisted ok, either the base class or the subclasses.
  * Added many tests for Hibernate persistence of SwiftMessage hierarchy.
  * Added XML Visitor to write a swift message to an XML representation.
  * Added ConversionService class which encapsulates many services conveniently.

#### 2.0.0 - 2006
  * New parser component highly tested on production and unit tests.
  * Writer component usable. while it has many limitations, it can be used as it is now.
  * Work in progress swift message persistence mapping.
  * Work in progress swift expression <-> regular expression conversion.
