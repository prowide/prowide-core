# CLAUDE.md

This file provides guidance to Claude Code when working with code in this repository.

## Project Overview

**Prowide Core** is the open-source Java framework for SWIFT FIN messages (MT category 1–9, plus headers, service messages, ACK/NAK). Active since 2006 (formerly WIFE). Apache 2.0. Companion library to [prowide-iso20022](../prowide-iso20022).

Includes:
- Java model for ISO 15022 MT (e.g. `MT103`, `Field32A`) for all categories
- MT parser (FIN / RJE → Java) and builder (Java → FIN / RJE)
- MT ↔ JSON conversion
- MT ↔ proprietary XML conversion
- JPA entity model for MT persistence
- BIC and IBAN validation

## Build & Test

```bash
./gradlew build          # Compile + test + assemble
./gradlew test           # Unit tests only (JUnit 5)
./gradlew spotlessApply  # Format code
./gradlew spotlessCheck  # Verify formatting
./gradlew javadoc        # Generate Javadoc
```

Run a single test: `./gradlew test --tests "ClassName"`.

## Source Layout

```
src/main/java       — hand-written API (MODIFY HERE)
src/generated/java  — generated MT field + message classes (DO NOT MODIFY)
src/test/java       — unit tests
```

Generated code comes from [pw-swift-codegen](../pw-swift-codegen). To change generated output, edit the codegen project and re-run its tasks. The `.claude/hooks/block-generated.sh` PreToolUse hook refuses edits under `src/generated/`.

## Key Components

- `SwiftMessage` — root parsed MT message object
- `SwiftBlock1` … `SwiftBlock5` — the five SWIFT blocks
- `AbstractMT` / `MTxxx` — typed message wrappers (e.g. `MT103`)
- `Field` hierarchy — typed field classes (e.g. `Field32A`)
- `SwiftParser` / `SwiftWriter` — FIN parsing/serialization
- `IBAN`, `BIC` — validation helpers
- `SafeXmlUtils` — XXE-safe XML utilities; **always use this** for XML processing

## SRU and Versioning

- **SRU** = SWIFT's annual Standards Release Update (e.g. SRU2026)
- Version format: `SRU{YEAR}-{semver}` via Axion Release Plugin (Git tags)
- A new SRU is generated in a branch ~6 months before SWIFT's production date
- `.SRU2025.java8-maintenance` / `.SRU2026` sibling working copies exist for active maintenance branches — when in doubt, check `gradle.properties` for the current SRU
- Java 11+ for current SRU; older branches may require Java 8

## Conventions

- Tests: JUnit 5 + AssertJ. XMLUnit for XML comparisons.
- Spotless (Palantir Java Format) on `src/main/java` and `src/test/java`.
- Javadoc: no `@author`; add `@since` to new public API matching the upcoming version in `CHANGELOG.md`; prefer `@see` over duplication.
- Lombok is **not** used here (kept dependency-light for downstream consumers).
- New entries in `CHANGELOG.md` for any functional change.

## Distribution

- **Maven Central**: `com.prowidesoftware:pw-swift-core`
- **Nexus**: internal SNAPSHOT and licensed-product builds
- **Downstream consumers**: prowide-iso20022, pw-swift-integrator, pw-swift-enterprise, several customer products. Any non-trivial API change must be coordinated.
