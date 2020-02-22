package com.example.androidrecycleviewhw

import com.google.gson.annotations.SerializedName

data class Location(@SerializedName("weatherElement") val weatherElements: List<WeatherElement>)