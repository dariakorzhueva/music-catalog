package com.dkorzhueva.music.catalog.web

import okhttp3.OkHttpClient

interface ApiFactory<T> {
    fun create(api: Class<T>, httpClient: OkHttpClient, path: String): T
}