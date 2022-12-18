package com.dkorzhueva.music.catalog.web.auth

import com.dkorzhueva.music.catalog.core.mapper.Mapper
import com.dkorzhueva.music.catalog.database.user.User
import javax.inject.Inject

class AuthResponseMapper @Inject constructor() : Mapper<User?, AuthResponse> {
    override fun mapToEntity(data: AuthResponse): User? {
        val session = data.session
        return session?.let {
            return User(
                username = session.name,
                apiKey = session.key
            )
        }
    }
}