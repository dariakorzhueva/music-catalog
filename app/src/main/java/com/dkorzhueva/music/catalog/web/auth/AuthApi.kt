package com.dkorzhueva.music.catalog.web.auth

import retrofit2.http.*

interface AuthApi {
    @POST("?method=auth.getMobileSession")
   suspend fun authorize(
        @Query("api_key") apiKey: String,
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("api_sig") apiSig: String
    ): AuthResponse
}