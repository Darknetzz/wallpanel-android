# WallPanel

> [!IMPORTANT]
> **This repository is no longer actively maintained.** For continued development, fixes, and releases, use **[kmbrimble/wallpanel-android](https://github.com/kmbrimble/wallpanel-android)** — a fork of this project with substantial further work (Hilt, KSP, WebView/DuraSpeed fixes, signed sideload builds, and more).

This was a short-lived community fork of [TheTimeWalker/wallpanel-android](https://github.com/thetimewalker/wallpanel-android) (archived May 2025). It modernised the build toolchain so the app could still be compiled on current JDKs and Android tooling; [kmbrimble](https://github.com/kmbrimble/wallpanel-android) then took that base further and is the recommended place for new users and contributions.

## What this fork did

- **Modern build tooling** — Updated to Gradle 9.x, Kotlin 2.x, and current Android Gradle Plugin; supports JDK 17–25 and Android SDK 34.
- **Easier to build** — Google Services and Firebase Crashlytics applied only when `google-services.json` is present.
- **Dev flavors** — `prod` for release builds without secrets; `dev` with optional `local.properties` defaults.
- **Build/code quality** — Dagger and Kotlin toolchain updates, kapt fixes, WebView render-process recovery, deferred service init.

For current features, install instructions, and releases, see [kmbrimble/wallpanel-android](https://github.com/kmbrimble/wallpanel-android).

---

WallPanel is an Android application for Web Based Dashboards and Home Automation Platforms. The Play Store listing still belongs to the archived upstream project:

<a href='https://play.google.com/store/apps/details?id=xyz.wallpanel.app&pcampaignid=pcampaignidMKT-Other-global-all-co-prtnr-py-PartBadge-Mar2515-1'><img alt='Get it on Google Play' src='https://play.google.com/intl/en_us/badges/static/images/badges/en_badge_web_generic.png' width='240'/></a>

Prefer sideloading a build from [kmbrimble’s releases](https://github.com/kmbrimble/wallpanel-android/releases) if you want the actively maintained fork (separate application id, installs alongside the Play Store build).

## Screenshots

<img src="img/dashboard2.png" width="640" />
<img src="img/dashboard3.png" width="640" />
<img src="img/dashboard1.png" width="640" />

## Support

This repo is not accepting new work. Prefer issues and PRs at [kmbrimble/wallpanel-android](https://github.com/kmbrimble/wallpanel-android). Historical context remains in the [original archived project](https://github.com/thetimewalker/wallpanel-android).

### Common Issues

Rendering issues with the webpage you are trying to view. Android applications use a component to render webpages, it's called the WebView component. WebView is not the same as Google Chrome app, it does not render the pages the same. The biggest issue is that your version of WebView is not capable of rendering the webpage you are trying to view. The only way possible to fix this issue is to update the WebView component (from Google Play Store), use a different webpage, or update your device OS.

## Features

- Web Based Dashboards and Home Automation Platforms support.
- Set application as Android Home screen (optional)
- Use code to access the settings and make the settings button invisible.
- Camera support for streaming video, motion detection, face detection, and QR Code reading.
- Google Text-to-Speech support to speak notification messages using MQTT or HTTP.
- MQTT or HTTP commands to remotely control device and application (url, brightness, wake, etc.).
- Sensor data reporting for the device (temperature, light, pressure, battery).
- Streaming MJPEG server support using the device camera.
- Screensaver feature that can be dismissed with motion or face detection.
- Support for Android 4.4 (API level 19) and greater devices.
- Support for launching external applications using intent URL

## Hardware & Software

- Android Device running Android OS 4.4 or greater. Note: The WebView shipped with Android 4.4 (KitKat) is based on the same code as Chrome for Android version 30. This WebView does not have full feature parity with Chrome for Android and is given the version number 30.0.0.0.

**_ If you have need support for older Android 4.0 devices (those below Android 4.4), you want to use the [legacy](https://github.com/thanksmister/wallpanel-android-legacy) version of the application. Alternatively you can download an APK from the release section prior to release v0.8.8-beta.6 _**

## Quick Start

For current installs, follow [kmbrimble/wallpanel-android](https://github.com/kmbrimble/wallpanel-android). Otherwise you can side load from this repo’s [release section](releases) or install from [Google Play](https://play.google.com/store/apps/details?id=xyz.wallpanel.app). Open settings via the dashboard floating icon, set your dashboard URL, and set the settings code (default `1234`).

## Development

The project can be built from the command line with `./gradlew assembleProdDebug` (or `gradlew.bat assembleProdDebug` on Windows).

**JDK:** The project uses **Gradle 9.1.0**, which supports **JDK 17 through JDK 25** (including the latest OpenJDK 25). You can use your system’s latest JDK.

**Android SDK:** Set `ANDROID_HOME` to your Android SDK root, or create `local.properties` in the project root with:
`sdk.dir=C\:\\path\\to\\Android\\sdk` (Windows) or `sdk.dir=/path/to/Android/sdk` (macOS/Linux).

Use the `prod` flavor for a build that does not require `local.properties` secrets. For the `dev` flavor, optional entries in `local.properties` (e.g. `code`, `hassUrl`, `broker`) are used as BuildConfig defaults; the app runs without them (defaults are used).

## Building the Application

To build the application locally, checkout the code from Github and load the project into Android Studio with Android API 31 or higher.

**In this fork:** Google Services and Firebase are applied only when `google-services.json` is present. Without that file, the project builds without Firebase/Crashlytics—no need to remove dependencies manually. If you do want to use Firebase, add `google-services.json` and the following are applied automatically. Otherwise, you can remove these if you prefer a clean build without Google Services:

```
apply plugin: 'com.google.firebase.crashlytics'

implementation 'com.google.firebase:firebase-core:20.1.1'
implementation 'com.google.firebase:firebase-crashlytics-ktx'
implementation 'com.google.firebase:firebase-analytics-ktx'
```

Remove this if you are building the application for devices that do not support Google Services.

```
apply plugin: 'com.google.gms.google-services'

implementation 'com.google.android.gms:play-services-vision:20.1.3'
```

The project should compile normally.

## Limitations

Android devices use WebView to render webpages, This WebView does not have full feature parity with Chrome for Android and therefore pages that render in Chrome may not render nicely in Wall Panel. For example, WebView that shipped with Android 4.4 (KitKat) devices is based on the same code as Chrome for Android version 30.

This WebView does not have full feature parity with Chrome for Android and is given the version number 30.0.0.0. If you find that you cannot render a webpage, it is most likely that the version of WebView on your device does not support the CSS/HTML of that page. You have little recourse but to update the webpage, as there is nothing to be done to the WebView to make it compatible with your code.

Setting WallPanel as the default Home application will always load this application as your home. Removing this feature is difficutl without uninstalling the application. So please do this is you wish to use the application as a "kiosk" type application.

## Contribution

This repository is unmaintained. Please open issues and PRs against [kmbrimble/wallpanel-android](https://github.com/kmbrimble/wallpanel-android). Thanks to all who [contributed here](graphs/contributors).

## Special Thanks

- [kmbrimble](https://github.com/kmbrimble) for continuing development in [kmbrimble/wallpanel-android](https://github.com/kmbrimble/wallpanel-android) — the recommended active fork.
- [TheTimeWalker](https://github.com/TheTimeWalker) for maintaining [wallpanel-android](https://github.com/TheTimeWalker/wallpanel-android) from 2022 until its archive in May 2025.
- [ThanksMister](https://github.com/thanksmister) for maintaining and continued development of [WallPanel](https://github.com/thanksmister/wallpanel-android/) for multiple years.
- [quadportnick](https://github.com/quadportnick) for starting [the original WallPanel (formerly HomeDash)](https://github.com/WallPanel-Project/wallpanel-android).
