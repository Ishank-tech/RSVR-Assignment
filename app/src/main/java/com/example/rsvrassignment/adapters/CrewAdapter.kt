package com.example.rsvrassignment.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.rsvrassignment.models.CrewModel
import com.example.rsvrassignment.R

class CrewAdapter(val context: Context, val list: List<CrewModel>) :
    RecyclerView.Adapter<CrewAdapter.CrewViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CrewViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.crew_item, parent, false)
        return CrewViewHolder(view)
    }

    override fun onBindViewHolder(holder: CrewViewHolder, position: Int) {
        val item = list[position]
        holder.profile.setImageResource(item.img)
        holder.crewName.text = item.crewName
        holder.crew.text = item.crew
    }

    override fun getItemCount(): Int {
        return list.size
    }

    class CrewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val profile = itemView.findViewById<ImageView>(R.id.profile_image2)
        val crewName = itemView.findViewById<TextView>(R.id.crew_name)
        val crew = itemView.findViewById<TextView>(R.id.crew)
    }

}