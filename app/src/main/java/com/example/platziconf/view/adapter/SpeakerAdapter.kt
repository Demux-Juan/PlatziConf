package com.example.platziconf.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.platziconf.R
import com.example.platziconf.model.Speaker
import java.util.*
import kotlin.collections.ArrayList

class SpeakerAdapter(val speakerListener: SpeakerListener) :
    RecyclerView.Adapter<SpeakerAdapter.ViewHolder>() {
    var listSpeaker = ArrayList<Speaker>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.item_speaker, parent, false
        )
    )

    override fun onBindViewHolder(holder: SpeakerAdapter.ViewHolder, position: Int) {
        val speaker = listSpeaker[position] as Speaker

        holder.tvSpeakerName.text = speaker.name
        holder.tvSpeakerWork.text = speaker.workplace
        Glide.with(holder.itemView.context)
            .load(speaker.image)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivSpeakerImage)

        holder.itemView.setOnClickListener{
            speakerListener.onSpeakerClicked(speaker,position)
        }

    }

    override fun getItemCount() = listSpeaker.size

    fun updateDate(data: List<Speaker>) {
        listSpeaker.clear()
        listSpeaker.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val ivSpeakerImage = itemView.findViewById<ImageView>(R.id.ivSpeakerImage)
        val tvSpeakerName = itemView.findViewById<TextView>(R.id.tvSpeakerName)
        val tvSpeakerWork = itemView.findViewById<TextView>(R.id.tvSpeakerWork)

    }
}

