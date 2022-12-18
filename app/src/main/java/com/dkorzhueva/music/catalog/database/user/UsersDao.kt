package com.dkorzhueva.music.catalog.database.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsersDao {
    @Query("SELECT * FROM users WHERE id LIKE :id")
    fun getUserById(id: String): List<UserEntity>

    @Insert
    fun insert(user: UserEntity)

    @Delete
    fun delete(user: UserEntity)
}