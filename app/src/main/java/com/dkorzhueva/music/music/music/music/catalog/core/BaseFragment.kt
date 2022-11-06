package com.dkorzhueva.music.music.music.music.catalog.core

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.fragment.app.Fragment

abstract class BaseFragment<T> : Fragment() {
    private var component: T? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        component = createComponent()
        injectView(component)
        super.onCreate(savedInstanceState)
    }

    protected abstract fun createComponent(): T
    protected abstract fun injectView(component: T?)
}