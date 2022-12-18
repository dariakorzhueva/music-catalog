package com.dkorzhueva.music.catalog.web

import com.dkorzhueva.music.catalog.web.auth.AuthorizationStorage
import com.dkorzhueva.music.catalog.web.auth.LastFmAuthorizationStorage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class WebModule {
    @Binds
    abstract fun bindAuthorizationStorage(authorizationStorage: LastFmAuthorizationStorage): AuthorizationStorage
}