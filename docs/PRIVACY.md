# Privacy Policy

_Last updated: April 2026_

AveGram is an unofficial, open-source Telegram client. This page explains
what data the app touches, where it goes, and what it never collects.

## TL;DR

- **AveGram itself collects nothing.** No telemetry, no analytics, no
  phone-home.
- All chat data flows directly between your device and **Telegram's**
  servers via the official MTProto protocol.
- Optional features (AI translation, Firebase push) only activate if
  **you** configure them.

## What stays on your device

| Data | Where |
|---|---|
| Account session keys | Android encrypted shared preferences |
| Cached messages, media, stickers | App-private storage |
| Saved deleted messages (AyuGram feature) | Local SQLite, app-private |
| Bookmarks, custom folders, settings | Local SQLite, app-private |
| AI provider API keys | Android encrypted shared preferences |

This data is **never** transmitted by AveGram to any server we control —
because we don't run any servers.

## What goes to Telegram

Everything you'd expect from a Telegram client: messages, media, contacts
(if you grant permission), online status, etc. This is identical to using
the official Telegram app and is governed by Telegram's own privacy
policy: <https://telegram.org/privacy>.

## Optional third-party services

You opt in to each of these — none are on by default.

### Firebase Cloud Messaging (push notifications)
If enabled, Google receives a device token to deliver push notifications.
See <https://firebase.google.com/support/privacy>.

### Firebase Crashlytics (crash reporting)
If enabled, anonymized crash stack traces are sent to Google to help us
fix bugs. No message content is included.

### AI translation providers
If you enable in-chat translation and add an API key, the **text you ask
to translate** is sent to your chosen provider:

- **OpenAI** — <https://openai.com/policies/privacy-policy>
- **Google Gemini** — <https://policies.google.com/privacy>
- **DeepSeek** — <https://platform.deepseek.com/privacy>

You can clear the key any time in Settings → AI.

## Permissions we request

| Permission | Why |
|---|---|
| Internet | Talk to Telegram servers |
| Storage | Save & open media |
| Camera | Take photos & video calls |
| Microphone | Voice messages & calls |
| Contacts | Sync your address book to Telegram (optional) |
| Notifications | Show incoming messages |
| Location | Share location messages (only when you tap share) |

You can revoke any permission in Android system settings without breaking
the rest of the app.

## Children's privacy

AveGram is not directed at children under 13. Telegram itself requires
users to be at least 16 (or the legal minimum age in their country).

## Changes to this policy

We'll update this file in the repo. Material changes will be noted in
the [CHANGELOG](CHANGELOG.md).

## Contact

Questions? Open an issue on GitHub. Because AveGram is community-run, we
can't offer email support.
