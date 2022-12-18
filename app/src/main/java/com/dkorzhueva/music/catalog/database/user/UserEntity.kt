package com.dkorzhueva.music.catalog.database.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey
    val id: String,
    val username: String,
    val key: String
)