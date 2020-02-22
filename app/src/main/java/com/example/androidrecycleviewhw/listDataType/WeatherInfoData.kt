package com.example.androidrecycleviewhw.listDataType

import android.os.Parcel
import android.os.Parcelable

class WeatherInfoData(val startTime: String,
                      val endTime: String,
                      val infoString: String) : ListData(ListDataType.WEATHER_INFO), Parcelable {
    constructor(parcel: Parcel) : this(
        startTime = parcel.readString() ?: "",
        endTime = parcel.readString() ?: "",
        infoString = parcel.readString() ?: ""
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(startTime)
        parcel.writeString(endTime)
        parcel.writeString(infoString)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WeatherInfoData> {
        override fun createFromParcel(parcel: Parcel): WeatherInfoData {
            return WeatherInfoData(parcel)
        }

        override fun newArray(size: Int): Array<WeatherInfoData?> {
            return arrayOfNulls(size)
        }
    }

}