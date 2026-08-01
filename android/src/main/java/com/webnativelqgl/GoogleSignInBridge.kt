package com.webnativelqgl

import android.app.Activity
import android.webkit.JavascriptInterface
import android.webkit.WebView
import androidx.credentials.CredentialManager
import androidx.credentials.GetCredentialRequest
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.json.JSONObject


class GoogleSignInBridge(
    private val activity: Activity,
    private val webView: WebView
) {


    @JavascriptInterface
    fun signIn(callback:String) {


        CoroutineScope(
            Dispatchers.Main
        ).launch {


            try {


                val googleOption =
                    GetGoogleIdOption.Builder()
                        .setFilterByAuthorizedAccounts(false)
                        .setServerClientId(
                            "662633670578-8t6mido2ddipl9oo7ts7of14lo9mvvas.apps.googleusercontent.com"
                        )
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



                val credential =
                    result.credential



                val googleCredential =
                    credential
                        as com.google.android.libraries.identity.googleid
                        .GoogleIdTokenCredential



                val json =
                    JSONObject()



                json.put(
                    "id",
                    googleCredential.id
                )


                json.put(
                    "name",
                    googleCredential.displayName
                )


                json.put(
                    "email",
                    googleCredential.id
                )


                json.put(
                    "photo",
                    googleCredential.profilePictureUri
                )


                json.put(
                    "idToken",
                    googleCredential.idToken
                )



                sendCallback(
                    callback,
                    json.toString()
                )


            }
            catch(e:Exception){


                val error =
                    JSONObject()


                error.put(
                    "error",
                    e.message
                )


                sendCallback(
                    callback,
                    error.toString()
                )

            }

        }

    }



    private fun sendCallback(
        callback:String,
        data:String
    ){

        webView.post {

            webView.evaluateJavascript(
                "window['$callback']($data)",
                null
            )

        }

    }


}
