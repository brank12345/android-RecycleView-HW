package com.example.androidrecycleviewhw

import com.example.androidrecycleviewhw.dataClass.Data
import com.example.androidrecycleviewhw.listDataType.ImageData
import com.example.androidrecycleviewhw.listDataType.ListData
import com.example.androidrecycleviewhw.listDataType.WeatherInfoData

object ItemListUtils {
    private const val NULL = "null"

    fun createList(data: Data): MutableList<ListData> {
        val list: MutableList<ListData> = mutableListOf()

        data.records.locations[0].weatherElements.forEach { weatherElement ->
            weatherElement.times.forEach { timeInfo ->
                var infoString = timeInfo.parameter.parameterName
                if (timeInfo.parameter.parameterUnit != NULL) {
                    infoString += timeInfo.parameter.parameterUnit
                }

                list.add(WeatherInfoData(
                    startTime = timeInfo.startTime,
                    endTime = timeInfo.endTime,
                    infoString = infoString)
                )

                //list.add(ImageData())
            }
        }
        return list
    }
}