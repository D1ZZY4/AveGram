<div align="center">
  <img src="TMessagesProj/src/main/res/mipmap-xxxhdpi/ic_launcher_nagram_dark_blue.png" width="100" alt="AveGram Logo"/>
  
  # AveGram
  
  **A modern, minimalist Telegram client — forked from NagramXF**
  
  [![Build](https://github.com/YOUR_USERNAME/AveGram/actions/workflows/release.yml/badge.svg)](https://github.com/YOUR_USERNAME/AveGram/actions)
  ![Android](https://img.shields.io/badge/Android-5.0%2B-brightgreen)
  ![License](https://img.shields.io/badge/License-GPL--2.0-blue)
</div>

---

## ✨ Features

- 🎨 **Modern Glass UI** — frosted glass cards, rounded corners, clean layouts
- 🌙 **Deep Dark Mode** — true dark #0D1117 background with glass accents
- 💬 **Ghost Mode** — read messages without being seen
- 🗑️ **Deleted Messages** — save and view deleted messages
- 🤖 **AI Translator** — translate using OpenAI / Gemini / DeepSeek
- 📋 **Edit History** — view edit history of messages
- 🚀 **All NagramXF features** + AveGram exclusive design

## 📦 Build

### Via GitHub Actions (Recommended)
1. Fork this repo
2. Go to **Actions** tab
3. Run **"AveGram Release Build"** workflow
4. Download APK from artifacts

### Manual Build
```bash
git clone https://github.com/YOUR_USERNAME/AveGram
cd AveGram
echo "sdk.dir=$ANDROID_HOME" >> local.properties
./gradlew TMessagesProj:assembleRelease
```

## 🎨 Design System

| Token | Value | Usage |
|-------|-------|-------|
| Primary | `#2196F3` | Buttons, accents |
| Primary Dark | `#1565C0` | Pressed states |
| Background Light | `#FAFCFF` | Light mode bg |
| Background Dark | `#0D1117` | Dark mode bg |
| Card Dark | `#1C2232` | Glass cards dark |
| Corner Radius | `16-24dp` | Cards, sheets |

## 📜 License

GPL-2.0 — Based on [Telegram](https://github.com/DrKLO/Telegram), [NagramXF](https://github.com/Keeperorowner/NagramXF)
