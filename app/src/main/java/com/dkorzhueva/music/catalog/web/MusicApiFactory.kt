package com.dkorzhueva.music.catalog.web

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Inject

class MusicApiFactory<T> @Inject constructor() : ApiFactory<T> {
    override fun create(api: Class<T>, httpClient: OkHttpClient, path: String): T {
        return Retrofit.Builder()
            .baseUrl(path)
            .addConverterFactory(SimpleXmlConverterFactory.create())
            .client(httpClient)
            .build()
            .create(api)
    }
}