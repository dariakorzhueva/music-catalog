package com.dkorzhueva.music.catalog.authorization.authorization_screen.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.hilt.navigation.compose.hiltViewModel
import com.dkorzhueva.music.catalog.R
import com.dkorzhueva.music.catalog.authorization.authorization_screen.AuthorizationViewModel

@Composable
fun Authorization(
    viewModel: AuthorizationViewModel = hiltViewModel()
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
            label = {
                Text(stringResource(R.string.authorization_username))
            },
            value = username,
            onValueChange = {
                username = it
            }
        )

        var password by remember { mutableStateOf("") }
        var isPasswordVisible by remember { mutableStateOf(false) }
        OutlinedTextField(
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            label = {
                Text(stringResource(R.string.authorization_password))
            },
            onValueChange = {
                password = it
            },
            trailingIcon = {
                val image =
                    if (isPasswordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff

                val description =
                    if (isPasswordVisible) stringResource(R.string.authorization_password_hidePassword) else stringResource(
                        R.string.authorization_password_showPassword
                    )

                IconButton(
                    onClick = { isPasswordVisible = !isPasswordVisible }
                ) {
                    Icon(imageVector = image, description)
                }
            },
            value = password,
            visualTransformation = getVisualTransformation(isPasswordVisible),
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

private fun getVisualTransformation(isPasswordVisible: Boolean): VisualTransformation {
    return if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation()
}