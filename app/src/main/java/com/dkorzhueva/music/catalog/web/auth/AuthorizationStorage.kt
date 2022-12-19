package com.dkorzhueva.music.catalog.web.auth

interface AuthorizationStorage {
    suspend fun authorize(username: String, password: String): AuthResponse?
}