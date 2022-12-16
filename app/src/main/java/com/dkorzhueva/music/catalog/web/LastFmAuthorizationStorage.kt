package com.dkorzhueva.music.catalog.web

import com.dkorzhueva.music.catalog.BuildConfig
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LastFmAuthorizationStorage @Inject constructor(
    private val musicApiFactory: MusicApiFactory
) : AuthorizationStorage {
    //Split by classes

    override suspend fun authorize(username: String, password: String) {
        val api = musicApiFactory.create(
            AuthApi::class.java,
            MusicHttpClient.create(),
            "https://ws.audioscrobbler.com/2.0/"
        )
        val apiSignature = "api_key" + BuildConfig.API_KEY + "methodauth.getMobileSessionpassword" + password + "username" + username + BuildConfig.SHARED_SECRET

        val codedString = getCodedString(apiSignature)

        try {
            val result = api.authorize(BuildConfig.API_KEY, username, password, codedString)
        } catch (ex: Exception) {
            println(ex.stackTrace)
        }
    }

    private fun getCodedString(string: String): String {
        val md5 = "MD5"
        try {
            val digest = MessageDigest.getInstance(md5)
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