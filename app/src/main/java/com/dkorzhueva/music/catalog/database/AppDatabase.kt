package com.dkorzhueva.music.catalog.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dkorzhueva.music.catalog.database.user.UserEntity
import com.dkorzhueva.music.catalog.database.user.UsersDao

@Database(entities = [UserEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun usersDao(): UsersDao
}