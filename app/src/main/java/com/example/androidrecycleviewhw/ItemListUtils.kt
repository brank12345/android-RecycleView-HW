package com.example.androidrecycleviewhw

import android.util.Log

object ItemListUtils {
    fun createList(data: Data) {
        data.records.locations[0].weatherElements.forEach { weatherElement ->
            weatherElement.times.forEach { timeInfo ->
                Log.d("QAQ", timeInfo.startTime)
                Log.d("QAQ", timeInfo.endTime)
                Log.d("QAQ", "${timeInfo.parameter.parameterName} ${timeInfo.parameter.parameterUnit}")
                Log.d("QAQ", "-------------")
            }
        }
    }
}