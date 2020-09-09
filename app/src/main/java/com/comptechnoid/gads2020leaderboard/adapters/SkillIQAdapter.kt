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
import com.comptechnoid.gads2020leaderboard.service.SkillIQLeader
import com.squareup.picasso.Picasso

class SkillIQAdapter(private val data : List<SkillIQLeader>) :
    RecyclerView.Adapter<SkillIQAdapter.ViewHolder>() {

    private var ctx : Context? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        ctx = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.skilliq_leaders_vh, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = data.get(position).name
        holder.score.text = data.get(position).score + " Skill IQ Score"
        holder.country.text = data.get(position).country

        Picasso.with(ctx).load(data.get(position).badgeUrl).placeholder(R.mipmap.ic_launcher).into(holder.badge)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var name : TextView = itemView.findViewById(R.id.name)
        var country : TextView = itemView.findViewById(R.id.country)
        var badge : ImageView = itemView.findViewById(R.id.badge)
        var score : TextView = itemView.findViewById(R.id.score)

    }
}