package com.dkorzhueva.music.music.music.music.catalog.core.di

import com.dkorzhueva.music.music.music.music.catalog.MainActivity
import com.dkorzhueva.music.music.music.music.catalog.authorization.authorization_screen.di.AuthorizationFrComponent
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
    modules = [FragmentSubcomponentsModule::class]
)
interface MainActComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): MainActComponent
    }

    fun inject(activity: MainActivity)

    fun authorizationFrComponent(): AuthorizationFrComponent.Factory
}