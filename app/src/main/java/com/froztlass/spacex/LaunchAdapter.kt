package com.froztlass.spacex

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

//10121079
//Fa'i Refriandi
//IF-2 (PemAndro-3)

class LaunchAdapter(private var launches: List<Launch>) : RecyclerView.Adapter<LaunchAdapter.LaunchViewHolder>() {

    class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val missionName: TextView = itemView.findViewById(R.id.mission_name)
        val launchYear: TextView = itemView.findViewById(R.id.launch_year  )
        val details: TextView = itemView.findViewById(R.id.details)
        val missionPatch: ImageView = itemView.findViewById(R.id.mission_patch)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_launch, parent, false)
        return LaunchViewHolder(view)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        val launch = launches[position]
        holder.missionName.text = launch.mission_name
        holder.launchYear.text = launch.launch_year
        holder.details.text = launch.nationality ?: "No nationality available"

        Glide.with(holder.itemView.context)
            .load(launch.links.mission_patch)
            .placeholder(R.drawable.placeholder_image)
            .into(holder.missionPatch)
    }

    override fun getItemCount() = launches.size
}
