package com.example.music.viewpager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.music.R

class LastFmFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.last_fm_fragment, container, false)
        val textView: TextView = view.findViewById(R.id.detailsText)
        textView.text = "Проверка"
        return view
    }
}