package com.dkorzhueva.music.catalog.authorization.usecase

import com.dkorzhueva.music.catalog.authorization.usecase.input.AuthorizeInput
import com.dkorzhueva.music.catalog.core.usecase.UseCase
import com.dkorzhueva.music.catalog.database.user.UserDao
import com.dkorzhueva.music.catalog.web.auth.AuthResponseMapper
import com.dkorzhueva.music.catalog.web.auth.AuthorizationStorage
import javax.inject.Inject

class AuthorizeUseCase @Inject constructor(
    private val authResponseMapper: AuthResponseMapper,
    private val authorizationStorage: AuthorizationStorage,
    private val userDatabase: UserDao
) : UseCase<AuthorizeInput, Unit> {
    override suspend fun process(input: AuthorizeInput) {
        val authResponse = authorizationStorage.authorize(input.username, input.password)
        val user = authResponse?.let {
            authResponseMapper.mapToEntity(it)
        }
        user?.let {
            userDatabase.insert(user)
        }
    }
}