package com.example.androidrecycleviewhw.dataClass

import com.google.gson.annotations.SerializedName

data class WeatherElement(@SerializedName("time") val times: List<TimeInfo>)