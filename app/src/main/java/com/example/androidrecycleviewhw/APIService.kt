package com.example.androidrecycleviewhw

import com.example.androidrecycleviewhw.dataClass.Data
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface APIService {
    @GET("v1/rest/datastore/F-C0032-001")
    fun call(@Query("Authorization") token: String,
             @Query("locationName") location: String): Call<Data>
}