package com.webnativelqgl

import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView


    override fun onCreate(
        savedInstanceState: Bundle?
    ) {

        super.onCreate(savedInstanceState)

        webView = WebView(this)

        setContentView(webView)


        webView.settings.javaScriptEnabled = true


        WebNativeLQGL(
            this,
            webView
        ).install()


        // Any website works here
        webView.loadUrl(
            intent.getStringExtra("url")
                ?: "https://example.com"
        )

    }
}
