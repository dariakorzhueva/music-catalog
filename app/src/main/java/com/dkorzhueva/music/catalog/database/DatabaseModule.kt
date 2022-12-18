package com.dkorzhueva.music.catalog.database

import android.content.Context
import androidx.room.Room
import com.dkorzhueva.music.catalog.database.user.UsersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    fun bindUsersDatabase(
        @ApplicationContext context: Context
    ): UsersDao {
        val db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "music-catalog-database"
        ).build()
        return db.usersDao()
    }
}