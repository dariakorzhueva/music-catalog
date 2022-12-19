package com.dkorzhueva.music.catalog.authorization.authorization_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dkorzhueva.music.catalog.authorization.usecase.AuthorizeUseCase
import com.dkorzhueva.music.catalog.authorization.usecase.input.AuthorizeInput
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(
    private val authorizeUseCase: AuthorizeUseCase
) : ViewModel() {

    private val userExistsState: MutableSharedFlow<Boolean> = MutableSharedFlow()
    val userExists: SharedFlow<Boolean>
        get() = userExistsState.asSharedFlow()

    private val internetConnectionErrorState: MutableSharedFlow<Boolean> = MutableSharedFlow()
    val internetConnectionError: SharedFlow<Boolean>
        get() = internetConnectionErrorState.asSharedFlow()

    fun authorize(username: String, password: String) {
        viewModelScope.launch {
            authorizeUseCase.execute(
                AuthorizeInput(
                    username = username,
                    password = password
                ),
                onSuccess = {
                    val userExists = it ?: false
                    setUserExists(userExists)
                },
                onError = {
                    Log.d(TAG, "Authorization error: $it ${it?.message}")
                    setInternetConnectionErrorState()
                }
            )
        }
    }

    private fun setUserExists(exist: Boolean) {
        viewModelScope.launch {
            userExistsState.emit(exist)
        }
    }

    private fun setInternetConnectionErrorState() {
        viewModelScope.launch {
            internetConnectionErrorState.emit(true)
        }
    }

    companion object {
        private val TAG = AuthorizationViewModel::class.java.canonicalName
            ?: AuthorizationViewModel::class.java.simpleName
    }
}