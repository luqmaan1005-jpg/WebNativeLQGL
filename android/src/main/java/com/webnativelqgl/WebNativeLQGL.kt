package com.webnativelqgl

import android.webkit.WebView

class WebNativeLQGL(
    private val webView: WebView
) {

    fun install() {

        webView.settings.javaScriptEnabled = true

        webView.addJavascriptInterface(
            GoogleSignInBridge(webView),
            "AndroidGoogle"
        )
    }
}
