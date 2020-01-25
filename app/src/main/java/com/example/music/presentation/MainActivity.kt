package com.example.music.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.music.App
import com.example.music.R
import com.example.music.model.lastfm.Track
import com.example.music.viewpager.ITunesFragment
import com.example.music.viewpager.LastFmFragment
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

        val adapter = MyAdapter(supportFragmentManager)

        viewpager.adapter = adapter
        viewpager.currentItem = 1

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

    class MyAdapter internal constructor(fm: FragmentManager) :
        FragmentPagerAdapter(fm) {

        override fun getCount(): Int {
            return 2
        }

        override fun getItem(position: Int): Fragment {
            return when (position) {
                0 -> LastFmFragment()
                1 -> ITunesFragment()
                else -> LastFmFragment()
            }
        }
    }
}
