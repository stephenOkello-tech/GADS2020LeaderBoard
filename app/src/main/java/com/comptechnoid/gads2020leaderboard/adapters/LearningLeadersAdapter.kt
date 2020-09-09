package com.comptechnoid.gads2020leaderboard.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.comptechnoid.gads2020leaderboard.R
import com.comptechnoid.gads2020leaderboard.service.LearningLeader
import com.squareup.picasso.Picasso

class LearningLeadersAdapter(private val data: List<LearningLeader>) :
    RecyclerView.Adapter<LearningLeadersAdapter.ViewHolder>() {
    private var ctx: Context? = null

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        ctx = parent.context
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.learning_leaders_vh, parent, false)
        return ViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.name.text = data[position].name
        holder.hours.text = data[position].hours + " Learning Hours "
        holder.country.text = data[position].country
        Picasso.with(ctx).load(data[position].badgeUrl).placeholder(R.mipmap.ic_launcher)
            .into(holder.badge)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var name: TextView
        var country: TextView
        var hours: TextView
        var badge: ImageView

        init {
            name = itemView.findViewById(R.id.name)
            country = itemView.findViewById(R.id.country)
            hours = itemView.findViewById(R.id.hours)
            badge = itemView.findViewById(R.id.badge)
        }
    }

}