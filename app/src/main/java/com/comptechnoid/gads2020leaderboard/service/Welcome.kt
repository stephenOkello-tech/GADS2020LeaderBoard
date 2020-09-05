package com.comptechnoid.gads2020leaderboard.service

import com.google.gson.annotations.SerializedName

data class Welcome(
    @SerializedName("live") val live : Boolean,
    @SerializedName("name") val name : String,
    @SerializedName("message") val message : String
)