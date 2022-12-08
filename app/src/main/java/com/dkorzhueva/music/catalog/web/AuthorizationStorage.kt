package com.dkorzhueva.music.catalog.web

interface AuthorizationStorage {
    fun authorize(username: String, password: String)
}