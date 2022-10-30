package com.dkorzhueva.music.music.music.music.catalog.authorization.authorization_screen.di

import com.dkorzhueva.music.music.music.music.catalog.authorization.authorization_screen.ui.AuthorizationFragment
import com.dkorzhueva.music.music.music.music.catalog.core.di.AuthorizationFrModule
import dagger.Subcomponent

@Subcomponent(
    modules = [AuthorizationFrModule::class]
)
interface AuthorizationFrComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): AuthorizationFrComponent
    }

    fun inject(fragment: AuthorizationFragment)
}