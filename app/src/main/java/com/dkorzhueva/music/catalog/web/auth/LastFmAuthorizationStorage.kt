package com.dkorzhueva.music.catalog.web.auth

import com.dkorzhueva.music.catalog.BuildConfig
import com.dkorzhueva.music.catalog.algorithm.Md5Algorithm
import com.dkorzhueva.music.catalog.web.MusicApiFactory
import com.dkorzhueva.music.catalog.web.MusicHttpClient
import com.dkorzhueva.music.catalog.web.ServerUrl.LAST_FM_SERVER_URL
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LastFmAuthorizationStorage @Inject constructor(
    private val md5Algorithm: Md5Algorithm,
    private val musicApiFactory: MusicApiFactory<AuthApi>
) : AuthorizationStorage {

    override suspend fun authorize(username: String, password: String): AuthResponse? {
        val api = musicApiFactory.create(
            AuthApi::class.java,
            MusicHttpClient.create(),
            LAST_FM_SERVER_URL
        )
        val apiSignature =
            "api_key" + BuildConfig.API_KEY + "methodauth.getMobileSessionpassword" + password + "username" + username + BuildConfig.SHARED_SECRET

        val codedString = md5Algorithm.encode(apiSignature)

        return try {
            api.authorize(BuildConfig.API_KEY, username, password, codedString)
        } catch (ex: Exception) {
            null
        }
    }
}