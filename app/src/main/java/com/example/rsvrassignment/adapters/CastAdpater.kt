package com.example.rsvrassignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rsvrassignment.models.CastModel
import com.example.rsvrassignment.R

class CastAdpater(val context: Context, val list: List<CastModel>) :
    RecyclerView.Adapter<CastAdpater.CastViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CastViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cast_item, parent, false)
        return CastViewHolder(view)
    }

    override fun onBindViewHolder(holder: CastViewHolder, position: Int) {
        val item = list[position]
        holder.profile2.setImageResource(item.ProfileImage)
        holder.nameOfActor.text = item.name
        holder.castName.text = item.castName
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class CastViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profile2 = itemView.findViewById<ImageView>(R.id.profile_image)
        val nameOfActor = itemView.findViewById<TextView>(R.id.name)
        val castName = itemView.findViewById<TextView>(R.id.cast_name)
    }

}