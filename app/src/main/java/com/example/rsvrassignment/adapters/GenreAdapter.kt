package com.example.rsvrassignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rsvrassignment.models.Genre
import com.example.rsvrassignment.R

class GenreAdapter(val context: Context, val list: List<Genre>) :
    RecyclerView.Adapter<GenreAdapter.GenreViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.type_item, parent, false)
        return GenreViewHolder(view)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val item = list[position]
        holder.genre.text = item.genre
        holder.genre.setBackgroundResource(item.color)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class GenreViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val genre = itemView.findViewById<TextView>(R.id.genre)
    }

}