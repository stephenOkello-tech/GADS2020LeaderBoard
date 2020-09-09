package com.comptechnoid.gads2020leaderboard.service

import retrofit2.Call
import retrofit2.http.GET

interface MainService {

    @GET("/")
    fun welcome() : Call<Welcome>

    @GET("/api/hours")
    fun getLearningLeaders() : Call<List<LearningLeader>>

    @GET("/api/skilliq")
    fun getSkilliqLeaders() : Call<List<SkillIQLeader>>

}