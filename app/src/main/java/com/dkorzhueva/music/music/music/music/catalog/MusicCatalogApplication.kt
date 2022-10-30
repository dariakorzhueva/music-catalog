package com.dkorzhueva.music.music.music.music.catalog

import android.app.Application
import com.dkorzhueva.music.music.music.music.catalog.core.di.ApplicationComponent
import com.dkorzhueva.music.music.music.music.catalog.core.di.ApplicationModule
import com.dkorzhueva.music.music.music.music.catalog.core.di.DaggerApplicationComponent

class MusicCatalogApplication : Application() {
    private lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    fun getAppComponent(): ApplicationComponent {
        return appComponent
    }
}