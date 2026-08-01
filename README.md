# WebNativeLQGL

WebNativeLQGL is a hybrid Android + JavaScript library that enables native Google Sign-In inside Android WebView applications.

It allows web applications, PWAs, and WebView-wrapped apps to communicate with native Android Google authentication through a JavaScript bridge.

## Features

- ✅ Native Google Sign-In
- ✅ Android WebView support
- ✅ JavaScript bridge
- ✅ TypeScript support
- ✅ Android Credential Manager integration
- ✅ Works with any website URL
- ✅ Reusable Android SDK
- ✅ Designed for hybrid apps

## How It Works

```text
Web Application
       |
       v
WebNativeLQGL JavaScript Library
       |
       v
Android JavaScript Bridge
       |
       v
Native Google Sign-In
       |
       v
Google Account
```

## Installation

### JavaScript Library

Install with npm:

```bash
npm install webnativelqgl
```

Import:

```javascript
import { WebNativeLQGL } from "webnativelqgl";
```

## JavaScript Usage

Start Google Sign-In:

```javascript
const user = await WebNativeLQGL.signIn();

console.log(user.name);
console.log(user.email);
console.log(user.idToken);
```

## Android Setup

Add the WebNativeLQGL SDK to your Android project.

Initialize the bridge:

```kotlin
WebNativeLQGL(
    this,
    webView,
    "YOUR_GOOGLE_WEB_CLIENT_ID"
).install()
```

Enable JavaScript:

```kotlin
webView.settings.javaScriptEnabled = true
```

## Project Structure

```text
WebNativeLQGL/
│
├── src/
│   ├── index.ts
│   ├── signIn.ts
│   ├── signOut.ts
│   ├── bridge.ts
│   ├── types.ts
│   └── detectWebView.ts
│
└── android/
    └── app/
        └── src/
            └── main/
                └── java/
                    └── com/
                        └── webnativelqgl/
                            ├── MainActivity.kt
                            ├── WebNativeLQGL.kt
                            ├── GoogleSignInBridge.kt
                            └── UserResult.kt
```

## Requirements

- Android API 23+
- Google Play Services
- Google OAuth Web Client ID
- Android WebView
- JavaScript enabled

## Security

Always verify Google ID tokens on your backend before creating sessions.

Never trust authentication data directly from the client without verification.

## Compatible With

- React apps
- Vue apps
- Next.js apps
- Lovable apps
- PWAs
- HTML/JavaScript websites
- Android WebView wrappers

## License

MIT License
