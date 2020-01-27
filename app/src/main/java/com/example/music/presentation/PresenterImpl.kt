package com.example.music.presentation

import android.util.Log
import com.example.music.repository.ITunesService
import com.example.music.repository.LastFmService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PresenterImpl @Inject constructor(
    private var lastFmService: LastFmService,
    private val iTunesService: ITunesService
) : Presenter {

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
                view?.setTrackListLastFm(results.results?.trackmatches?.track)
                Log.i("lastFmService", results.toString())
            }, { ex ->
                Log.e("lastFmService", ex.message)
                view?.showError()
            })

        iTunesService
            .getTrack(nameTrack)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe({ responce ->
                view?.setTrackListITunes(responce.results)
                Log.i("iTunesService", responce.toString())
            }, { ex ->
                Log.e("iTunesService", ex.message)
                view?.showError()
            })

    }
}

