package com.dkorzhueva.music.catalog.authorization.authorization_screen.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.dkorzhueva.music.catalog.authorization.authorization_screen.AuthorizationViewModel
import com.dkorzhueva.music.catalog.R
import dagger.hilt.android.AndroidEntryPoint

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
        var username by remember { mutableStateOf("") }
        OutlinedTextField(
            value = username,
            onValueChange = {
                username = it
            },
            label = {
                Text(stringResource(R.string.authorization_username))
            }
        )
        var password by remember { mutableStateOf("") }
        OutlinedTextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text(stringResource(R.string.authorization_password))
            }
        )
        val roundPercent = 25
        Button(
            modifier = Modifier
                .wrapContentWidth()
                .padding(dimensionResource(R.dimen.padding_8)),
            shape = RoundedCornerShape(roundPercent),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(R.color.dark_red_color),
                contentColor = Color.White
            ),
            onClick = {
                viewModel.authorize(username, password)
            })
        {
            Text(stringResource(R.string.authorization_logIn))
        }
    }
}