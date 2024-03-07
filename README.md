![alt tag](https://www.prowidesoftware.com/img/logo/horizontal/500x142.png)


**Prowide Core** is an open source Java framework for managing SWIFT FIN messages.

The project (previously known as WIFE) is active since 2006, production ready and commercially supported.


### What's included?

* Java model for ISO 15022 MT (for example: MT103 and Field32A classes, for all MT message categories)
* Parser from SWIFT MT (FIN or RJE) into Java
* Builder API from Java to SWIFT MT (FIN or RJE)
* Conversion between SWIFT MT and JSON
* Conversion between SWIFT MT and proprietary XML for MT
* JPA entities model for MT message persistence
* BIC and IBAN validation

For ISO 20022 model, parser and builder API check the https://github.com/prowide/prowide-iso20022 project

For SWIFT messages validation, translations, GUI application and more, please check Prowide's complementary commercial offerings at http://www.prowidesoftware.com/

### Documentation
* Documentation site https://dev.prowidesoftware.com
* Javadoc https://www.javadoc.io/doc/com.prowidesoftware/pw-swift-core/
* Code examples https://github.com/prowide/prowide-core-examples

### Distribution
Latest public **binary DOWNLOAD** is available at https://dev.prowidesoftware.com/SRU2022/getting-started/download-core/

SRU updates are made available on October (one month before SWIFT production date) for the general public, and 6 months in advance for subscribed customers.

### License

Apache License 2.0

SWIFT is a trademark of S.W.I.F.T. SCRL. (www.swift.com)

### Build

* run `./gradlew build` to build the library

Make sure your IDE encoding is UTF-8, some test may fail if not.

### Versioning

The versioning scheme used is [Semantic Versioning 2.0.0](http://semver.org/) with the Gradle Axion Release plugin
that controls versions automatically based on git tags. If you ever face issues with the version or version tags are
manually manipulated; the following command will clean up your local tags and fetch the remote tags again:

```
git tag -l | xargs git tag -d
git fetch --tags
```
