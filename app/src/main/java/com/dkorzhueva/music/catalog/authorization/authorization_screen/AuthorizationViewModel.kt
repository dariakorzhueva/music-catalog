package com.dkorzhueva.music.catalog.authorization.authorization_screen

import androidx.lifecycle.ViewModel
import com.dkorzhueva.music.catalog.web.AuthorizationStorage
import com.dkorzhueva.music.catalog.web.LastFmAuthorizationStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    //private val authorizationStorage: AuthorizationStorage
) : ViewModel() {
    fun authorize(username: String, password: String) {
        LastFmAuthorizationStorage().authorize(username, password)
    }
}