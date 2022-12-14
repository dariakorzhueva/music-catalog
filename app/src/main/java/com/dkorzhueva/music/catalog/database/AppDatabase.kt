package com.dkorzhueva.music.catalog.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dkorzhueva.music.catalog.database.user.User
import com.dkorzhueva.music.catalog.database.user.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}