package com.webnativelqgl

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        webView = WebView(this)

        setContentView(webView)

        webView.settings.javaScriptEnabled = true


        WebNativeLQGL(
            this,
            webView,
            "662633670578-8t6mido2ddipl9oo7ts7of14lo9mvvas.apps.googleusercontent.com"
        ).install()


        webView.loadUrl(
            "https://example.com"
        )
    }
}
