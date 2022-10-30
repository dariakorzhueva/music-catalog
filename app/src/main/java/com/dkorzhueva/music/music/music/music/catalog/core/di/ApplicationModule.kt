package com.dkorzhueva.music.music.music.music.catalog.core.di

import android.content.Context
import com.dkorzhueva.music.music.music.music.catalog.MusicCatalogApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule(
    private val application: MusicCatalogApplication
) {
    @Provides
    @Singleton
    fun provideApplicationContext(): Context {
        return this.application
    }
}