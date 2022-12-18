package com.dkorzhueva.music.catalog.authorization.authorization_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dkorzhueva.music.catalog.web.auth.AuthorizationStorage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val authorizationStorage: AuthorizationStorage
) : ViewModel() {
    fun authorize(username: String, password: String) {
        viewModelScope.launch {
            authorizationStorage.authorize(username, password)
        }
    }
}