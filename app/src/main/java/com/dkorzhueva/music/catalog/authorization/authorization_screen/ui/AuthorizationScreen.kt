package com.dkorzhueva.music.catalog.authorization.authorization_screen.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.dkorzhueva.music.catalog.authorization.authorization_screen.AuthorizationViewModel
import com.dkorzhueva.music.catalog.R

@Composable
fun Authorization(
    viewModel: AuthorizationViewModel
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val roundPercent = 50
        Button(
            shape = RoundedCornerShape(roundPercent),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(R.color.spotify_color),
                contentColor = Color.White
            ),
            onClick = {

            })
        {
            Text(stringResource(R.string.authorization_authorizeViaSpotify))
        }
    }
}