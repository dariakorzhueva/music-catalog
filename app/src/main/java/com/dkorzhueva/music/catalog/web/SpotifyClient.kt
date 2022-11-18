package com.dkorzhueva.music.music.music.music.catalog.web

import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit

class SpotifyClient {
    private val client = OkHttpClient.Builder()
        .connectTimeout(15, TimeUnit.SECONDS)
        .addInterceptor(AuthInterceptor())
        .build()
}