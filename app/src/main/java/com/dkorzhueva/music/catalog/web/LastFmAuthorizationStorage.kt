package com.dkorzhueva.music.catalog.web

import com.dkorzhueva.music.catalog.BuildConfig
import okhttp3.*
import java.io.IOException
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class LastFmAuthorizationStorage @Inject constructor() : AuthorizationStorage {
    val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .build()

    override fun authorize(username: String, password: String) {
        val apiSignature =
            "api_key" + BuildConfig.API_KEY + "methodauth.getMobileSessionpassword" + password + "username" + username + BuildConfig.SHARED_SECRET

        val codedString = getCodedString(apiSignature)

        val urlParameter =
            "method=auth.getMobileSession&api_key=" + BuildConfig.API_KEY + "&password=" + password + "&username=" + username + "&api_sig=" + codedString
        val request: Request = Request.Builder()
            .url("https://ws.audioscrobbler.com/2.0/?$urlParameter")
            .post(RequestBody.create(null, ByteArray(0)))
            .build()

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

    private fun getCodedString(string: String): String {
        val MD5 = "MD5"
        try {
            val digest = MessageDigest
                .getInstance(MD5)
            digest.update(string.toByteArray())
            val messageDigest = digest.digest()

            val hexString = StringBuilder()
            for (aMessageDigest in messageDigest) {
                var h = Integer.toHexString(0xFF and aMessageDigest.toInt())
                while (h.length < 2) h = "0$h"
                hexString.append(h)
            }
            return hexString.toString()
        } catch (e: NoSuchAlgorithmException) {
            e.printStackTrace()
        }
        return ""
    }
}