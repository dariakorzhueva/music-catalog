package com.dkorzhueva.music.catalog.web

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit

class MusicHttpClient {
    companion object {
        private const val CONNECTION_TIMEOUT = 15L

        fun create(): OkHttpClient {
            val logging = getLoggingInterceptor()
            return OkHttpClient.Builder()
                .connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS)
                .addInterceptor(logging)
                .build()
        }

        private fun getLoggingInterceptor(): HttpLoggingInterceptor {
            val logging = HttpLoggingInterceptor()
            logging.apply {
                logging.level = HttpLoggingInterceptor.Level.BODY
            }
            return logging
        }
    }
}