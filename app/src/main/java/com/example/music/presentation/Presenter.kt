package com.example.music.presentation


interface Presenter{

    fun searchTrack(nameTrack: String)
    fun attachView(mainActivity: MainActivity)
    fun  detachView()

}
