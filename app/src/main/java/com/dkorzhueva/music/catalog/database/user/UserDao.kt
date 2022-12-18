package com.dkorzhueva.music.catalog.database.user

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE id LIKE :id")
    fun getUserById(id: String): List<User>

    @Insert
    fun insert(user: User)

    @Delete
    fun delete(user: User)
}