package com.webnativelqgl

import android.app.Activity
import android.webkit.WebView

class WebNativeLQGL(
    private val activity: Activity,
    private val webView: WebView,
    private val clientId: String
) {

    fun install() {

        webView.settings.javaScriptEnabled = true

        webView.addJavascriptInterface(
            GoogleSignInBridge(
                activity,
                webView,
                clientId
            ),
            "AndroidGoogle"
        )
    }
}
