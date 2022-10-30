package com.dkorzhueva.music.music.music.music.catalog.core.di

import android.content.Context
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ApplicationModule::class
    ]
)
interface ApplicationComponent {
    fun context(): Context
}