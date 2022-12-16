package com.dkorzhueva.music.catalog.web

import retrofit2.http.*

interface AuthApi {
    @POST("?method=auth.getMobileSession")
   suspend fun authorize(
        @Query("api_key") apiKey: String,
        @Query("password") password: String,
        @Query("username") username: String,
        @Query("api_sig") apiSig: String
    ): AuthResponse
}