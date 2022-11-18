package com.dkorzhueva.music.music.music.music.catalog.web

import retrofit2.http.POST

interface AuthApi {
    @POST
    fun authorize(): AuthResponse
}