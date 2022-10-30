package com.dkorzhueva.music.music.music.music.catalog.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import com.dkorzhueva.music.music.music.music.catalog.MusicCatalogApplication

abstract class BaseActivity<T> : ComponentActivity() {
    private var component: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        component = createComponent()
        injectView(component)
        super.onCreate(savedInstanceState)
    }

    protected abstract fun createComponent(): T
    protected abstract fun injectView(component: T?)
}