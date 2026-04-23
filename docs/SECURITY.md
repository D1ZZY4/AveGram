# Security Policy

## Supported versions

We patch security issues on the **latest `main`** branch. Older releases
are not back-patched — please update to stay safe.

| Version | Supported |
|---|---|
| Latest `main` | ✅ |
| Tagged releases | ✅ (current tag only) |
| Older builds | ❌ |

## Reporting a vulnerability

**Please do NOT open a public GitHub issue for security bugs.**

Instead:

1. Open a [GitHub Security Advisory](https://github.com/YOUR_USERNAME/AveGram/security/advisories/new)
   on the repository (private by default).
2. Include:
   - A clear description of the issue
   - Steps to reproduce
   - Affected versions / commit hashes
   - Impact assessment (what an attacker could do)
   - (Optional) A suggested fix

We aim to:

- **Acknowledge** within 72 hours
- **Triage** within 7 days
- **Patch** critical issues within 30 days

## What's in scope

- Code in this repository
- Build pipeline & CI configuration
- Default Firebase / Google Services configuration shipped in the repo

## What's out of scope

- Vulnerabilities in **Telegram itself** — report to Telegram directly
- Vulnerabilities in **upstream forks** (NagramXF, AyuGram, etc.) —
  report to those projects
- Bugs in third-party AI providers (OpenAI, Gemini, DeepSeek)
- Issues that require physical access to an unlocked device
- Social-engineering attacks against users

## Disclosure policy

We follow **coordinated disclosure**:

1. You report privately.
2. We confirm and develop a fix.
3. We ship the fix and credit you (unless you prefer anonymity).
4. After users have had reasonable time to update (typically 14 days),
   the advisory is made public.

## Hall of Fame

Security researchers who responsibly disclose issues will be listed
here, with their permission.

_(empty for now — be the first!)_

## Hardening tips for users

- Always build from source or download from the official GitHub releases
- Verify APK signatures before installing
- Don't sideload AveGram from random Telegram channels
- Use Android's app-lock / biometric protection
- Keep your Telegram account's 2FA enabled
