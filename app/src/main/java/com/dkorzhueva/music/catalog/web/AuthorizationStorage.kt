package com.dkorzhueva.music.catalog.web

interface AuthorizationStorage {
    suspend fun authorize(username: String, password: String)
}