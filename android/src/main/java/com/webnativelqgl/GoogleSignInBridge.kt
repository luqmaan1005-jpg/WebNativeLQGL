package com.webnativelqgl

import android.app.Activity
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject


class GoogleSignInBridge(
    private val activity: Activity,
    private val webView: WebView,
    private val serverClientId: String
) {


    @JavascriptInterface
    fun signIn(callback: String) {

        CoroutineScope(
            Dispatchers.Main
        ).launch {

            try {

                val googleOption =
                    GetGoogleIdOption.Builder()
                        .setFilterByAuthorizedAccounts(false)
                        .setServerClientId(serverClientId)
                        .build()


                val request =
                    GetCredentialRequest.Builder()
                        .addCredentialOption(
                            googleOption
                        )
                        .build()


                val credentialManager =
                    CredentialManager.create(
                        activity
                    )


                val result =
                    credentialManager.getCredential(
                        activity,
                        request
                    )


                val googleCredential =
                    GoogleIdTokenCredential
                        .createFrom(
                            result.credential.data
                        )


                val json =
                    JSONObject()


                json.put(
                    "id",
                    googleCredential.id
                )


                json.put(
                    "name",
                    googleCredential.displayName ?: ""
                )


                json.put(
                    "email",
                    googleCredential.id
                )


                json.put(
                    "photo",
                    googleCredential.profilePictureUri?.toString() ?: ""
                )


                json.put(
                    "idToken",
                    googleCredential.idToken
                )


                sendCallback(
                    callback,
                    json.toString()
                )


            } catch (e: Exception) {


                val error =
                    JSONObject()


                error.put(
                    "error",
                    e.message ?: "Unknown error"
                )


                sendCallback(
                    callback,
                    error.toString()
                )
            }
        }
    }


    @JavascriptInterface
    fun signOut() {

        // Add sign-out logic later

    }


    private fun sendCallback(
        callback: String,
        data: String
    ) {

        webView.post {

            webView.evaluateJavascript(
                "window['$callback']($data)",
                null
            )

        }
    }
}
