package com.dkorzhueva.music.music.music.music.catalog

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dkorzhueva.music.music.music.music.catalog.authorization.authorization_screen.ui.Authorization
import com.dkorzhueva.music.music.music.music.catalog.core.Screen

@Composable
fun MusicCatalogApp() {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Authorization.route
    ) {
        composable(Screen.Authorization.route) {
            Authorization()
        }
    }
}