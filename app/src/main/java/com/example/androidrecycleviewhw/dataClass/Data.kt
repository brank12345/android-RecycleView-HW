package com.example.androidrecycleviewhw.dataClass

import com.google.gson.annotations.SerializedName

data class Data(@SerializedName("success") val success: String,
                @SerializedName("records") val records: Record
)