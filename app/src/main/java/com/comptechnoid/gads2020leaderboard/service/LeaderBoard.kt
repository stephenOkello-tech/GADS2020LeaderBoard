package com.comptechnoid.gads2020leaderboard.service

import com.google.gson.annotations.SerializedName

data class LearningLeader (
    @SerializedName("name") val name : String,
    @SerializedName("hours") val hours : String,
    @SerializedName("country") val country : String,
    @SerializedName("badgeUrl") val badgeUrl :String
)

data class SkillIQLeader(
    @SerializedName("name") val name : String,
    @SerializedName("score") val score : String,
    @SerializedName("country") val country : String,
    @SerializedName("badgeUrl") val badgeUrl :String
)