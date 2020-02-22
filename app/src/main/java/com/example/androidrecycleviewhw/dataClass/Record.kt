package com.example.androidrecycleviewhw.dataClass

import com.google.gson.annotations.SerializedName

data class Record(@SerializedName("datasetDescription") val description: String,
                  @SerializedName("location") val locations: List<Location>)