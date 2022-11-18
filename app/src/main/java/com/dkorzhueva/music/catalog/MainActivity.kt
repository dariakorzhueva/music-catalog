package com.dkorzhueva.music.music.music.music.catalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Modifier
import com.dkorzhueva.music.music.music.music.catalog.ui.theme.MusiccatalogTheme
import androidx.compose.material.*
import com.dkorzhueva.music.music.music.music.catalog.authorization.authorization_screen.AuthorizationViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusiccatalogTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val viewModel: AuthorizationViewModel by viewModels()
                    MusicCatalogApp(viewModel)
                }
            }
        }
    }
}