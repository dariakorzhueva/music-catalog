package com.dkorzhueva.music.music.music.music.catalog

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dkorzhueva.music.music.music.music.catalog.core.BaseActivity
import com.dkorzhueva.music.music.music.music.catalog.core.di.MainActComponent
import com.dkorzhueva.music.music.music.music.catalog.ui.theme.MusiccatalogTheme
import android.content.Context
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource

class MainActivity : BaseActivity<MainActComponent>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusiccatalogTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Authorization()
                }
            }
        }
    }

    override fun createComponent(): MainActComponent {
        return (applicationContext as MusicCatalogApplication)
            .getAppComponent()
            .mainActComponent()
            .create()
    }

    override fun injectView(component: MainActComponent?) {
        component?.inject(this)
    }
}

@Composable
fun Authorization() {
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

@Preview(showBackground = true)
@Composable
fun AuthorizationPreview() {
    MusiccatalogTheme {
        Authorization()
    }
}