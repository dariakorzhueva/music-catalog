package com.dkorzhueva.music.catalog.web

import com.dkorzhueva.music.catalog.web.auth.AuthApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Inject

class MusicApiFactory @Inject constructor(): ApiFactory<AuthApi> {
    override fun create(api: Class<AuthApi>, httpClient: OkHttpClient, path: String): AuthApi {
        return Retrofit.Builder()
            .baseUrl(path)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .client(httpClient)
            .build()
            .create(api)
    }
}