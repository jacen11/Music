package com.example.music.viewpager

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.music.R
import com.example.music.adapter.LastFmAdapter
import kotlinx.android.synthetic.main.last_fm_list_fragment.*

class LastFmFragment : Fragment() {

    var adapterView:LastFmAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.last_fm_list_fragment, container, false)

//        val textView: TextView = view.findViewById(R.id.detailsText)
//        textView.text = "Проверка"
        if (list != null){
            list.adapter = adapterView
        }

        val parcelableArray = arguments?.getParcelableArray("data")
        Log.i("fragment", parcelableArray.toString())

        return view
    }

    fun show(adapter: LastFmAdapter){
        list.adapter = adapter
    }

}