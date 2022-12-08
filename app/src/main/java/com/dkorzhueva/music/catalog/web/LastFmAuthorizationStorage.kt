package com.dkorzhueva.music.catalog.web

import com.dkorzhueva.music.catalog.BuildConfig
import okhttp3.*
import java.io.IOException
import java.security.MessageDigest
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LastFmAuthorizationStorage @Inject constructor() : AuthorizationStorage {
    val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .build()

    //Investigate 404
    //Fix providing storage in the view model

    override fun authorize(username: String, password: String) {
        val secret = "mysecret"
        val apiSignature =
            "api_key" + BuildConfig.API_KEY + "methodauth.getMobileSessionpassword" + password + "username" + username + secret
        val codedString = getCodedString(apiSignature)

        val urlParameter =
            "method=auth.getMobileSession&api_key=" + BuildConfig.API_KEY + "&password=" + password + "&username=" + username + "&api_sig=" + codedString
        val request: Request = Request.Builder()
            .url("https://ws.audioscrobbler.com/2.0/$urlParameter")
            .post(RequestBody.create(null, ByteArray(0))).build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                e.printStackTrace()
            }

            override fun onResponse(call: Call, response: Response) {
                response.body.use { responseBody ->
                    val test = responseBody?.string()
                    if (!response.isSuccessful) throw IOException("Unexpected code $response")
                }
            }
        })
    }

    private fun getCodedString(apiSignature: String): String {
        val digest: MessageDigest = MessageDigest.getInstance("MD5")
        digest.update(apiSignature.toByteArray())
        val messageDigest: ByteArray = digest.digest()

        val hexString = StringBuffer()
        for (i in messageDigest.indices) hexString.append(
            Integer.toHexString(
                0xFF and messageDigest[i]
                    .toInt()
            )
        )
        return hexString.toString()
    }
}