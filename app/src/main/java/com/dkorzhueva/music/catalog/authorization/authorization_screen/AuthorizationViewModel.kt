package com.dkorzhueva.music.catalog.authorization.authorization_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dkorzhueva.music.catalog.authorization.usecase.AuthorizeUseCase
import com.dkorzhueva.music.catalog.authorization.usecase.input.AuthorizeInput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val authorizeUseCase: AuthorizeUseCase
) : ViewModel() {
    fun authorize(username: String, password: String) {
        viewModelScope.launch {
            authorizeUseCase.execute(
                AuthorizeInput(
                    username = username,
                    password = password
                ),
                onSuccess = {
                    val userExists = it ?: false
                    if (userExists) {
                        //Move to the next screen
                    } else {
                        //Show error
                    }
                },
                onError = {
                    //Catch no network - show snackbar
                }
            )
        }
    }
}