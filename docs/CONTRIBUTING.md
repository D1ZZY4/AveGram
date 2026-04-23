# Contributing to AveGram

Thanks for considering a contribution! AveGram is community-maintained
and every PR matters.

## Ground rules

1. Be respectful. We follow the spirit of the
   [Contributor Covenant](https://www.contributor-covenant.org/).
2. Keep PRs focused. One change, one PR.
3. Don't break upstream features unintentionally.
4. Respect the GPL-3.0 license — all contributions are licensed under it.

## Workflow

1. **Fork** the repo and create a feature branch:
   ```bash
   git checkout -b feat/my-cool-thing
   ```
2. **Write code** following the conventions below.
3. **Build locally** to make sure nothing is broken:
   ```bash
   ./gradlew TMessagesProj:assembleDebug
   ```
4. **Commit** with a descriptive message:
   ```
   feat(folders): add custom folder reordering
   fix(chat): prevent crash on empty deleted-message
   docs(build): document keystore env vars
   ```
5. **Push & open a PR** against `main`. Reference any related issues.

## Code style

### Java
- 4-space indent
- Braces on the same line
- Match the style of surrounding Telegram code (it's the bulk of the codebase)

### Kotlin
- 4-space indent
- Prefer expression bodies for short functions
- `val` over `var` whenever possible
- Use coroutines for async work, not `AsyncTask`

### XML (resources)
- 4-space indent
- Sort attributes: `android:id`, `layout_*`, then everything else
- Use existing color / dimen tokens — don't hard-code

### Naming
- New AveGram code goes under `com.avegram.*`
- Ported NagramX code stays under `org.avegram.*`
- Don't create files under `xyz.nextalone.nagram.*` — that namespace is retired

## Adding a feature from another fork

1. Find the original code in AyuGram / Cherrygram / NagramX / exteraGram.
2. Check its license — must be GPL-compatible.
3. Port it, **preserving the original copyright header**.
4. Add an entry to [`CREDITS.md`](CREDITS.md) noting the source.

## Reporting bugs

Open an issue with:

- **Steps to reproduce** (numbered list)
- **Expected** vs **actual** behaviour
- **Device** + Android version
- **AveGram version** (Settings → About)
- **Logs** if available (`adb logcat` is gold)

## Translations

Translations are managed via the upstream Telegram localization matrix.
Use [Crowdin](https://translations.telegram.org/) for the base strings;
AveGram-specific strings live in `TMessagesProj/src/main/res/values/strings.xml`.

## License of contributions

By submitting a PR, you agree that your contribution is licensed under
the GNU GPL v3.0, the same license as the project.
