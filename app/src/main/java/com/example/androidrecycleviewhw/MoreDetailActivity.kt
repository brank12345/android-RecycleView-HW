package com.example.androidrecycleviewhw

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidrecycleviewhw.listDataType.WeatherInfoData

class MoreDetailActivity : AppCompatActivity() {
    private var weatherInfoData: WeatherInfoData? = null
    private var centerBottom: TextView? = null

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.more_detail_layout)

        weatherInfoData = intent.getParcelableExtra<WeatherInfoData>(BundleKeys.WEATHER_INDO_DATA.value)
        centerBottom = findViewById<TextView>(R.id.center_bottom)

        weatherInfoData?.apply {
            centerBottom?.text = "${weatherInfoData?.startTime}\n${weatherInfoData?.endTime}\n${weatherInfoData?.infoString}"
        }
    }
}