package com.dkorzhueva.music.catalog.web.auth

import com.dkorzhueva.music.catalog.core.mapper.Mapper
import com.dkorzhueva.music.catalog.database.user.UserEntity
import java.util.*

class AuthResponseMapper : Mapper<UserEntity?, AuthResponse> {
    override fun mapToEntity(data: AuthResponse): UserEntity? {
        val session = data.session
        return session?.let {
            return UserEntity(
                id = UUID.randomUUID().toString(),
                username = session.name,
                key = session.key
            )
        }
    }
}