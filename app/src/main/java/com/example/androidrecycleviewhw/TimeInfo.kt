package com.example.androidrecycleviewhw

import com.google.gson.annotations.SerializedName

data class TimeInfo(@SerializedName("startTime") val startTime: String,
                    @SerializedName("endTime") val endTime: String,
                    @SerializedName("parameter") val parameter: Parameter)