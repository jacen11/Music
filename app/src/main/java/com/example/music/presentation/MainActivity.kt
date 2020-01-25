package com.example.music.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.music.App
import com.example.music.R
import com.example.music.model.lastfm.Track
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {

        App.appComponent?.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.attachView(this)

        btnStartSearch.setOnClickListener {
            if (etNameTrack.text.toString().isNotBlank()) {
                presenter.searchTrack(etNameTrack.text.toString())
            } else {
                Toast.makeText(this, "Пустой запрос", Toast.LENGTH_LONG).show()
            }
        }
    }

    fun setTrackList(list: List<Track>?) {

    }

    fun showError() {
        Toast.makeText(this, "Произошла ошибка", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()

        if (isFinishing) {
            App.appComponent = null
        }
    }
}
