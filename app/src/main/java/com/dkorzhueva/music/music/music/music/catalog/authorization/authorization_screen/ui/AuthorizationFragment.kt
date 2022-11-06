package com.dkorzhueva.music.music.music.music.catalog.authorization.authorization_screen.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import com.dkorzhueva.music.music.music.music.catalog.MusicCatalogApplication
import com.dkorzhueva.music.music.music.music.catalog.authorization.authorization_screen.di.AuthorizationFrComponent
import com.dkorzhueva.music.music.music.music.catalog.core.BaseFragment

class AuthorizationFragment: BaseFragment<AuthorizationFrComponent>() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                Authorization()
            }
        }
    }

    override fun createComponent(): AuthorizationFrComponent {
        return (activity?.applicationContext as MusicCatalogApplication)
            .getAppComponent()
            .mainActComponent()
            .create()
            .authorizationFrComponent()
            .create()
    }

    override fun injectView(component: AuthorizationFrComponent?) {
        component?.inject(this)
    }
}