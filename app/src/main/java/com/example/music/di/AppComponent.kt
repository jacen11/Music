package com.example.music.di

import com.example.music.presentation.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(
    modules = [
        MainModule::class,
        RestModule::class
    ]
)
@Singleton
interface AppComponent {

    fun inject(mainActivity: MainActivity)
}