package com.dkorzhueva.music.music.music.music.catalog.web

import com.dkorzhueva.music.music.music.music.catalog.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val redirectUri = "http://music.catalog.app"

        val request: Request = chain.request()
        val authenticatedRequest: Request = request.newBuilder()
            .header("Content-Type", "application/json")
            .header("client_id", BuildConfig.CLIENT_ID)
            .header("response_type", "code")
            .header("redirect_uri", redirectUri)
            .build()
        return chain.proceed(authenticatedRequest)
    }
}