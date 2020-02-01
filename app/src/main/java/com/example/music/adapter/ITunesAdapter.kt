package com.example.music.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.music.R
import com.example.music.model.itunes.Result
import com.example.music.model.lastfm.Track
import java.util.*


class ITunesAdapter(val tracks: List<Result>) :
    RecyclerView.Adapter<ITunesAdapter.TrackViewHolder>() {

    class TrackViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.txtName)
        var artist: TextView = itemView.findViewById(R.id.txtArtist)
        var image: ImageView = itemView.findViewById(R.id.image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrackViewHolder =
        TrackViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.i_tunes_item_fragment,
                parent,
                false
            )
        )

    override fun getItemCount(): Int = tracks.size

    override fun onBindViewHolder(holder: TrackViewHolder, position: Int) {

        holder.artist.text = tracks[position]?.artistName
        holder.name.text = tracks[position]?.trackName
        Glide.with(holder.image).load(tracks[position]?.artworkUrl100).into(holder.image);
    }

}
