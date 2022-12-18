package com.dkorzhueva.music.catalog.web

import com.dkorzhueva.music.catalog.web.auth.AuthorizationStorage
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class WebModule {
    @Binds
    abstract fun bindAuthorizationStorage(myHelperImpl: LastFmAuthorizationStorage): AuthorizationStorage
}