package com.example.music.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.music.R
import com.example.music.adapter.ITunesAdapter
import com.example.music.model.itunes.Result
import kotlinx.android.synthetic.main.last_fm_list_fragment.*


class ITunesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.i_tunes_list_fragment, container, false)
    }

    fun show(tracks: List<Result>) {
        list.adapter = ITunesAdapter(tracks)
    }
}
