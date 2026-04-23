# FAQ

### Is AveGram safe to log in with my real Telegram account?

Yes. AveGram talks to Telegram's official MTProto servers, just like the
official client. No credentials or messages are sent anywhere else.
That said: it's an unofficial client, so you accept some risk by using
it. Read [Telegram's ToS for unofficial clients](https://core.telegram.org/api/obtaining_api_id).

### Will I get banned for using AveGram?

Telegram historically tolerates well-behaved unofficial clients. Avoid
features that look spammy (mass-DMs, scrapers) and you'll be fine.

### How do I update?

- **Built via GitHub Actions** — re-run the workflow and install the new APK.
- **Built locally** — pull the latest `main` and rebuild.
- In-app updater: not bundled (we don't ship a phone-home update channel).

### Can I use AveGram alongside the official Telegram app?

Yes — AveGram has its own `applicationId` (`com.avegram`), so it installs
side-by-side with the official client.

### Will my chats sync between the official client and AveGram?

Yes. Telegram chats live on Telegram's servers; both clients see the same
data. Local-only features (saved deleted messages, bookmarks) are
device-specific.

### Does AveGram support Material You?

Yes, on Android 12 and newer.

### My build fails with "package com.avegram.helper does not exist"

You're building an older snapshot from before the rebrand refactor.
Pull the latest `main` and re-run.

### My build fails with "No matching client found for package name"

Your `APP_PACKAGE` in `gradle.properties` doesn't match the `package_name`
in `TMessagesProj/google-services.json`. Either align the two or supply
your own `google-services.json`.

### How do I report a bug?

Open an issue with steps to reproduce, your device + Android version, and
the AveGram version (Settings → About). See
[CONTRIBUTING.md](CONTRIBUTING.md) for the full template.

### Can I disable AyuGram's deleted-message saving?

Yes. Settings → AyuGram → Save deleted messages.

### Where are the AI translation API keys stored?

In Android's encrypted shared preferences, scoped to the app's UID.
They're never sent anywhere except the AI provider you configure.

### What's the difference between `com.avegram` and `org.avegram`?

- `com.avegram.*` — new code added by AveGram contributors.
- `org.avegram.*` — code ported from NagramX, kept in its own namespace
  to make license attribution easy.

### Is there a Play Store version?

Not currently. Distribution is via GitHub releases.

### Where's the privacy policy?

`docs/PRIVACY.md` — coming soon. AveGram itself collects nothing; data
flows are governed by Telegram's privacy policy and (if you enable AI
translation) your chosen AI provider's policy.
