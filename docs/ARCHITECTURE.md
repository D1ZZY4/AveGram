# Architecture

## High-level layout

```
AveGram/
├── TMessagesProj/                 # Main Android module
│   ├── src/main/
│   │   ├── java/                  # Java sources
│   │   ├── kotlin/                # Kotlin sources
│   │   ├── res/                   # Android resources
│   │   ├── jni/                   # Native (C/C++) sources
│   │   └── AndroidManifest.xml
│   ├── build.gradle               # App-module build script
│   └── google-services.json       # Firebase config
├── buildSrc/                      # Custom Gradle plugins / build logic
├── gradle/                        # Gradle wrapper config
├── docs/                          # 📚 Documentation (you are here)
├── .github/workflows/             # CI build pipelines
├── build.gradle                   # Root build script
├── settings.gradle                # Module list
└── gradle.properties              # App identity & build flags
```

## Package map (Java/Kotlin)

| Package | Origin | Purpose |
|---|---|---|
| `org.telegram.*` | Telegram (DrKLO) | Core messenger, UI, networking |
| `tw.nekomimi.nekogram.*` | Nekogram lineage | Settings overrides, helpers |
| `com.exteragram.messenger.*` | exteraGram | UI components |
| `com.radolyn.ayugram.*` | AyuGram | Message log, deleted-message DB |
| `org.avegram.*` | This fork (renamed from `xyz.nextalone.nagram.*`) | NagramX features |
| `com.avegram.*` | This fork | AveGram-exclusive helpers, folders, AI |

> The `com.avegram` namespace is reserved for **new** code added by this
> fork. The `org.avegram` namespace contains code ported from upstream
> NagramX with the package renamed.

## Build identity vs. code namespace

| What | Value | Why |
|---|---|---|
| `applicationId` | `com.avegram` | Play Store / Firebase identity |
| Manifest `namespace` | `org.telegram.messenger` | Generated `R` class location — kept stable to avoid touching thousands of `import org.telegram.messenger.R;` |

These two are **independent** in modern Android Gradle Plugin and may differ.

## Native layer

Native code lives under `TMessagesProj/jni/` and is built by CMake via the
Android Gradle Plugin. It includes:

- `voip/` — TgCalls + libtgvoip for voice / video calls
- `ffmpeg/`, `flac/`, `opus/` — media codecs
- `image/` — bitmap utilities
- `sqlite/` — local DB engine

## Resource organisation

- `res/values-*` — localized strings (full Telegram language matrix)
- `res/mipmap-*` — launcher icons (multiple variants per density)
- `res/drawable-*` — UI icons & shapes
- `res/xml/` — manifest fragments (contacts account, file paths, etc.)

## CI / CD

GitHub Actions workflows under `.github/workflows/`:

- `release.yml` — builds the signed release APK on demand or push to `main`

Build cache and Gradle config-cache are enabled to keep CI runs short.
