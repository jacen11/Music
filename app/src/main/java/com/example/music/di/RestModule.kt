package com.example.music.di

import com.example.music.BuildConfig
import com.example.music.repository.LastFmService
import dagger.Module
import dagger.Provides
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor.*


private const val BASE_URL_LAST_FM = "https://ws.audioscrobbler.com/2.0/"

@Module
class RestModule {

    private fun getClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = if (BuildConfig.DEBUG) Level.BODY else Level.BASIC
        return OkHttpClient.Builder().addInterceptor(logging).build()
    }

    @Provides
    @Singleton
    fun provideLastFm(): Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL_LAST_FM)
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .client(getClient())
        .build()

    @Provides
    @Singleton
    fun provideTrackLastFm(retrofit: Retrofit): LastFmService =
        retrofit.create(LastFmService::class.java)

}