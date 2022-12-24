package com.example.rsvrassignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.rsvrassignment.R

class SimilarMoviesAdapter(val context: Context, val list: List<Int>) :
    RecyclerView.Adapter<SimilarMoviesAdapter.SimilarMoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SimilarMoviesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.similar_movies_item, parent, false)
        return SimilarMoviesViewHolder(view)
    }

    override fun onBindViewHolder(holder: SimilarMoviesViewHolder, position: Int) {
        holder.movie.setImageResource(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class SimilarMoviesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movie = itemView.findViewById<ImageView>(R.id.movie)
    }

}