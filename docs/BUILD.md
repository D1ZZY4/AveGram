# Building AveGram

## Toolchain

| Tool | Version |
|---|---|
| JDK | 21 (Temurin recommended) |
| Android SDK | API 34+ installed |
| Android NDK | `27.2.12479018` |
| CMake | `3.22.1` or `4.x` |
| Gradle | `9.4.0` (provided via wrapper) |

## Quick start (local)

```bash
git clone https://github.com/YOUR_USERNAME/AveGram
cd AveGram
echo "sdk.dir=$ANDROID_HOME" > local.properties
./gradlew TMessagesProj:assembleRelease
```

The signed APKs land under `TMessagesProj/build/outputs/apk/release/`.

## Build flavors

AveGram inherits the upstream build matrix:

| Flavor | Purpose |
|---|---|
| `Release` | Production APK, optimized & shrunk |
| `Debug` | Local development, all logs enabled |
| `Staging` | Internal testing |

Build a specific flavor:

```bash
./gradlew TMessagesProj:assembleDebug
./gradlew TMessagesProj:assembleStaging
```

## Signing

Release builds expect a keystore at `TMessagesProj/release.keystore`.
Set the signing credentials in `gradle.properties` (or via environment):

```properties
RELEASE_KEY_ALIAS=androidkey
RELEASE_KEY_PASSWORD=android
RELEASE_STORE_PASSWORD=android
```

For CI builds, base64-encode your keystore and inject it as a secret. The
GitHub Actions workflow at `.github/workflows/release.yml` shows the pattern.

## CI build (GitHub Actions)

1. Fork the repo.
2. (Optional) Add the following repository secrets:
   - `KEYSTORE_BASE64` — your `release.keystore` encoded with `base64`
   - `KEYSTORE_PASSWORD` · `KEY_ALIAS` · `KEY_PASSWORD`
3. Push to `main` or trigger **AveGram Release Build** manually.
4. Download the APK from the run's artifacts panel.

## Configuration

`gradle.properties` controls app identity:

```properties
APP_VERSION_CODE=6666
APP_VERSION_NAME=12.6.4
APP_PACKAGE=com.avegram
```

## Firebase / Google Services

`TMessagesProj/google-services.json` ships with a placeholder. To use your own
Firebase project:

1. Create a Firebase project with package name `com.avegram`.
2. Download `google-services.json` and replace the file in `TMessagesProj/`.

## Troubleshooting

| Symptom | Fix |
|---|---|
| `No matching client found for package name` | `APP_PACKAGE` in `gradle.properties` must match the `package_name` in `google-services.json`. |
| `package com.avegram.helper does not exist` | Make sure all rebrand refactors are complete (`com.avegram.messenger` → `com.avegram`). |
| `resource mipmap/ic_launcher_avegram_* not found` | Either add the asset under `mipmap-*` or point the reference to an existing icon (e.g. `ic_launcher_nagram_blue`). |
| NDK version mismatch | Install NDK `27.2.12479018` via SDK Manager. |
| Gradle out of memory | Increase JVM args: `-Xmx4g` in `gradle.properties`. |

For anything else, open an issue with the **full** `gradlew --stacktrace` output.
