package com.example.music.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.music.R
import com.example.music.model.lastfm.Track


class LastFmAdapter(val tracks: List<Track>) :
    RecyclerView.Adapter<LastFmAdapter.TrackViewHolder>() {

    // var tracks: List<Track>? = null

    class TrackViewHolder internal constructor(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
       // var rl: RecyclerView
        var name: TextView
        var artist: TextView
        // var image: ImageView

        init {
           // rl = itemView.findViewById(R.id.rl)
            name = itemView.findViewById(R.id.txtName)
            artist = itemView.findViewById(R.id.txtArtist)
            //  image = itemView.findViewById(R.id.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder =
        TrackViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.last_fm_item_fragment,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = tracks.size

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {

        holder.artist.text = tracks[position]?.artist
        holder.name.text = tracks[position]?.name
    }

}