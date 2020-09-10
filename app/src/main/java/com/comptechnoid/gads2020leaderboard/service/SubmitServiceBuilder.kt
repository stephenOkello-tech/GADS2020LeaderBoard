package com.comptechnoid.gads2020leaderboard.service

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SubmitServiceBuilder{
    private const val BASE_URL = "https://docs.google.com/forms/d/e/"
    private val okHttp : OkHttpClient.Builder = OkHttpClient.Builder()

    private val builder : Retrofit.Builder =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttp.build())


    private val retrofit : Retrofit = builder.build()

    fun <T> buildService(serviceType : Class<T>) : T {
        return retrofit.create(serviceType)
    }

}