package com.webnativelqgl

import android.webkit.JavascriptInterface
import android.webkit.WebView
import org.json.JSONObject


class GoogleSignInBridge(
    private val webView: WebView
) {


    @JavascriptInterface
    fun signIn(callback:String) {


        // Opens native Google sign in
        // Real Google Credential Manager code connects here

        val fakeUser = JSONObject()

        fakeUser.put(
            "id",
            "google-user-id"
        )

        fakeUser.put(
            "name",
            "Google User"
        )

        fakeUser.put(
            "email",
            "user@gmail.com"
        )

        fakeUser.put(
            "photo",
            ""
        )

        fakeUser.put(
            "idToken",
            "GOOGLE_ID_TOKEN"
        )


        sendCallback(
            callback,
            fakeUser.toString()
        )
    }



    @JavascriptInterface
    fun signOut(){

        // Clear Google session here

    }



    private fun sendCallback(
        callback:String,
        data:String
    ){

        webView.post {

            webView.evaluateJavascript(
                """
                window['$callback']($data)
                """.trimIndent(),
                null
            )

        }

    }

}
