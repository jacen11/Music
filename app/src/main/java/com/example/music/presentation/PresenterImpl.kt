package com.example.music.presentation

import android.util.Log
import com.example.music.repository.LastFmService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PresenterImpl @Inject constructor(private var lastFmService: LastFmService) : Presenter {

    private var view: MainActivity? = null

    override fun attachView(view: MainActivity) {
        this.view = view
    }

    override fun detachView() {
        this.view = null
    }

    override fun searchTrack(nameTrack: String) {

        lastFmService
            .getTrack(nameTrack)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ results ->
                view?.setTrackList(results.results?.trackmatches?.track)
                Log.i("lastFmService", results.toString())
            }, { ex ->
                Log.e("service", ex.message)
                view?.showError()
            })
    }
}

