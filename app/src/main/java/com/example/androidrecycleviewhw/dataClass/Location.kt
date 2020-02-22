package com.example.androidrecycleviewhw.dataClass

import com.google.gson.annotations.SerializedName

data class Location(@SerializedName("weatherElement") val weatherElements: List<WeatherElement>)