package com.example.androidrecycleviewhw

import com.google.gson.annotations.SerializedName

data class WeatherElement(@SerializedName("time") val times: List<TimeInfo>)