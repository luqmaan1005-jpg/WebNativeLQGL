package com.webnativelqgl

import android.app.Activity
import android.webkit.WebView

class WebNativeLQGL(
    private val activity: Activity,
    private val webView: WebView
) {

    fun install() {

        webView.settings.javaScriptEnabled = true

        webView.addJavascriptInterface(
            GoogleSignInBridge(
                activity,
                webView
            ),
            "AndroidGoogle"
        )
    }
}
