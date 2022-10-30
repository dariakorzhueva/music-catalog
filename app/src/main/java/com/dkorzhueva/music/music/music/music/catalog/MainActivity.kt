package com.dkorzhueva.music.music.music.music.catalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.dkorzhueva.music.music.music.music.catalog.core.BaseActivity
import com.dkorzhueva.music.music.music.music.catalog.core.di.MainActComponent
import com.dkorzhueva.music.music.music.music.catalog.ui.theme.MusiccatalogTheme

class MainActivity : BaseActivity<MainActComponent>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusiccatalogTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
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
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MusiccatalogTheme {
        Greeting("Android")
    }
}