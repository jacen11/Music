package com.example.music

import android.app.Application
import com.example.music.di.AppComponent
import com.example.music.di.DaggerAppComponent

class App : Application() {

    companion object {
        var appComponent: AppComponent? = null
    }

    override fun onCreate() {
        super.onCreate()
        initializeDagger()
    }

    private fun initializeDagger() {
        appComponent = DaggerAppComponent.builder()
            .build()
    }
}
