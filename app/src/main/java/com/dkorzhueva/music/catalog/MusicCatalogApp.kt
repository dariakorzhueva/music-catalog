package com.dkorzhueva.music.catalog

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dkorzhueva.music.catalog.authorization.authorization_screen.AuthorizationViewModel
import com.dkorzhueva.music.catalog.authorization.authorization_screen.ui.Authorization
import com.dkorzhueva.music.catalog.core.ui.Screen

@Composable
fun MusicCatalogApp(viewModel: AuthorizationViewModel) {
    val navController: NavHostController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Authorization.route
    ) {
        composable(Screen.Authorization.route) {
            Authorization(viewModel)
        }
    }
}