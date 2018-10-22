![alt tag](http://www.prowidesoftware.com/img/logoPW_800x253-300dpi.jpg)


**Prowide Core** is an open source Java framework for managing SWIFT messages.

The project (previously known as WIFE) is active since 2006, production ready and commercially supported.

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/2005f830d80c4db4a5c26e4380eb8d23)](https://www.codacy.com/app/prowide/prowide-core?utm_source=github.com&utm_medium=referral&utm_content=prowide/prowide-core&utm_campaign=badger)
<a href="https://codeclimate.com/github/prowide/prowide-core/maintainability"><img src="https://api.codeclimate.com/v1/badges/5f64e32b42dc0a4742b1/maintainability" /></a>

### What's included?

* Java model for ISO 15022 MT (for example: MT103 and Field32A classes, for all MT message categories)
* Parser from SWIFT (FIN or RJE) into Java
* Builder API from Java to SWIFT (FIN or RJE)
* Conversion to JSON and proprietary XML
* Complementary model suited for persistence
* Generic support for ISO 20022 MX
* IBAN validation

![alt tag](https://www.prowidesoftware.com/img/infografias/coreModelLayers.png)

For SWIFT messages validation, extended MX support, GUI application and more, please check our complementary commercial offerings at http://www.prowidesoftware.com/

### Documentation
* Documentation site http://www.prowidesoftware.com/resources
* Javadoc http://api.prowidesoftware.com/core/
* Changelog http://www.prowidesoftware.com/resources/changelog
* Code examples https://github.com/prowide/prowide-core-examples

### Distribution
This repository exposes the **source code for the maintenance and LTS yearly releases**. 
Latest public **binary DOWNLOAD** is available at http://www.prowidesoftware.com/download-prowide-core

SRU updates are made available on October (one month before SWIFT production date) for the general public, and 6 months in advance for subscribed customers.

### License

Apache License 2.0

SWIFT is a trademark of S.W.I.F.T. SCRL. (www.swift.com)

### Build

* run "./gradlew eclipse" or "./gradlew idea" to generate your local IDE setup
* run "./gradlew build" to build the library
