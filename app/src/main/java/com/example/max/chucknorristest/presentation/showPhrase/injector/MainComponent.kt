package com.example.max.chucknorristest.presentation.showPhrase.injector

import com.example.max.chucknorristest.data.injector.ServiceModule
import com.example.max.chucknorristest.presentation.showPhrase.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ServiceModule::class, MainModule::class) )
interface MainComponent {

    fun inject(activity: MainActivity)

}