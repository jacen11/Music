package com.example.music.di

import com.example.music.presentation.Presenter
import com.example.music.presentation.PresenterImpl
import dagger.Binds
import dagger.Module

@Module
interface MainModule {

    @Binds
    fun providePresenter(impl: PresenterImpl): Presenter
}