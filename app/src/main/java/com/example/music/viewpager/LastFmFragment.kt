package com.example.music.viewpager

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
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
        val view: View = inflater.inflate(R.layout.last_fm_list_fragment, container, false)
        return view
    }

    fun show(tracks: List<Track>){
      //  list.layoutManager = LinearLayoutManager(activity)
        list.adapter = LastFmAdapter(tracks)
    }
}
