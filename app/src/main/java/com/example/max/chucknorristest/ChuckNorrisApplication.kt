package com.example.max.chucknorristest

import android.app.Application
import com.example.max.chucknorristest.presentation.showPhrase.MainActivity
import com.example.max.chucknorristest.presentation.showPhrase.injector.DaggerMainComponent
import com.example.max.chucknorristest.presentation.showPhrase.injector.MainComponent
import com.example.max.chucknorristest.presentation.showPhrase.injector.MainModule
import com.facebook.stetho.Stetho

class ChuckNorrisApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }

    fun getMainComponent(activity: MainActivity): MainComponent {
        return DaggerMainComponent.builder().mainModule(MainModule(activity)).build()
    }

}