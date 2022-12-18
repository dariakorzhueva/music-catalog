package com.dkorzhueva.music.catalog.web

import com.dkorzhueva.music.catalog.web.auth.LastFmApi
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Inject

class MusicApiFactory @Inject constructor(): ApiFactory<LastFmApi> {
    override fun create(api: Class<LastFmApi>, httpClient: OkHttpClient, path: String): LastFmApi {
        return Retrofit.Builder()
            .baseUrl(path)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .client(httpClient)
            .build()
            .create(api)
    }
}