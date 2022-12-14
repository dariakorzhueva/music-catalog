package com.dkorzhueva.music.catalog.database.user

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    @PrimaryKey
    val id: String,
    val apiKey: String,
    val username: String
)