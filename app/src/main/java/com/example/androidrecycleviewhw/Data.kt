package com.example.androidrecycleviewhw

import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class Data(@SerializedName("success") val success: String,
                @SerializedName("records") val records: Record)