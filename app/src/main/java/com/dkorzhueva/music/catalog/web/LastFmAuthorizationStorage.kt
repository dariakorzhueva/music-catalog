package com.dkorzhueva.music.catalog.web

import com.dkorzhueva.music.catalog.BuildConfig
import com.dkorzhueva.music.catalog.algorithm.Md5Algorithm
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LastFmAuthorizationStorage @Inject constructor(
    private val md5Algorithm: Md5Algorithm,
    private val musicApiFactory: MusicApiFactory
) : AuthorizationStorage {

    override suspend fun authorize(username: String, password: String) {
        val api = musicApiFactory.create(
            AuthApi::class.java,
            MusicHttpClient.create(),
            "https://ws.audioscrobbler.com/2.0/"
        )
        val apiSignature =
            "api_key" + BuildConfig.API_KEY + "methodauth.getMobileSessionpassword" + password + "username" + username + BuildConfig.SHARED_SECRET

        val codedString = md5Algorithm.encode(apiSignature)

        try {
            //Save api key to pull users info later
            val result = api.authorize(BuildConfig.API_KEY, username, password, codedString)
        } catch (ex: Exception) {
            println(ex.stackTrace)
        }
    }
}