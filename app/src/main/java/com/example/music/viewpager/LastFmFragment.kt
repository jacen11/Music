package com.example.music.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.music.R
import com.example.music.adapter.LastFmAdapter
import com.example.music.model.lastfm.Track
import kotlinx.android.synthetic.main.last_fm_list_fragment.*

class LastFmFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.last_fm_list_fragment, container, false)
    }

    fun show(tracks: List<Track>){
        list.adapter = LastFmAdapter(tracks)
    }
}
