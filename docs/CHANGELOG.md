# Changelog

All notable changes to AveGram are documented here.
This project adheres loosely to [Semantic Versioning](https://semver.org/).

## [Unreleased]

### Added
- Comprehensive `docs/` directory: build, features, architecture, design
  system, contributing, credits, FAQ
- Replit preview landing page

### Changed
- Refactored Java/Kotlin packages:
  `com.avegram.messenger.*` → `com.avegram.*`,
  `xyz.nextalone.nagram.*` → `org.avegram.*`
- `APP_PACKAGE` aligned with `google-services.json` (`com.avegram`)

### Fixed
- `processReleaseGoogleServices` failure caused by package-name mismatch
- `processReleaseResources` failure caused by missing
  `ic_launcher_avegram_blue` reference in `xml/contacts.xml`
- Missing class imports under `com.avegram.helper.*` and
  `com.avegram.ui.folders.*`

## [12.6.4] — Initial AveGram release

- Fork from NagramXF
- Rebrand to AveGram identity (logo, colors, package)
- All upstream NagramXF features preserved
