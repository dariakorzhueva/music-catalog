package com.dkorzhueva.music.catalog.web.auth

import com.dkorzhueva.music.catalog.core.mapper.Mapper
import com.dkorzhueva.music.catalog.database.user.User
import java.util.*
import javax.inject.Inject

class AuthResponseMapper @Inject constructor() : Mapper<User?, AuthResponse> {
    override fun mapToEntity(data: AuthResponse): User? {
        val session = data.session
        return session?.let {
            return User(
                id = UUID.randomUUID().toString(),
                username = session.name,
                apiKey = session.key
            )
        }
    }
}