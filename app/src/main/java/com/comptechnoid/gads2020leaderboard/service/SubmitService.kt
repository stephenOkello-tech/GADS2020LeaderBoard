package com.comptechnoid.gads2020leaderboard.service

import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface SubmitService {

    @POST("1FAIpQLSf9d1TcNU6zc6KR8bSEM41Z1g1zl35cwZr2xyjIhaMAz8WChQ/formResponse")
    @FormUrlEncoded
    fun submitProject(
        @Field("entry.1877115667") firstname : String,
        @Field("entry.2006916086") lastname : String,
        @Field("entry.1824927963") email : String,
        @Field("entry.284483984")  link : String
    ) : Call<Void>
}