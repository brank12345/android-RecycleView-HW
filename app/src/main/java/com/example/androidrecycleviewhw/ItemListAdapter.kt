package com.example.androidrecycleviewhw

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrecycleviewhw.listDataType.ListData
import com.example.androidrecycleviewhw.listDataType.ListDataType
import com.example.androidrecycleviewhw.listDataType.WeatherInfoData
import kotlinx.android.synthetic.main.weather_info_layout.view.*

class ItemListAdapter(private val itemList: MutableList<ListData>, private val itemClickListener: ItemClickListener) : RecyclerView.Adapter<ItemListAdapter.MyViewHolder>() {
    interface ItemClickListener {
        fun onItemClick(weatherInfoData: WeatherInfoData)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = when(viewType) {
            ViewType.WEATHER_INFO.value -> {
                LayoutInflater.from(parent.context).inflate(R.layout.weather_info_layout, parent, false)
            }
            ViewType.IMAGE.value -> {
                LayoutInflater.from(parent.context).inflate(R.layout.image_item_layout, parent, false)
            }
            else -> {
                LayoutInflater.from(parent.context).inflate(R.layout.weather_info_layout, parent, false)
            }
        }
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        when(getItemViewType(position)) {
            ViewType.WEATHER_INFO.value -> {
                if (itemList[position].getDataType() == ListDataType.WEATHER_INFO) {
                    val data = itemList[position] as WeatherInfoData
                    val text = "${data.startTime}\n${data.endTime}\n${data.infoString}"
                    holder.view.description.text = text

                    holder.view.setOnClickListener {
                        itemClickListener.onItemClick(data)
                    }
                }
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(itemList[position].getDataType()) {
            ListDataType.WEATHER_INFO -> ViewType.WEATHER_INFO.value
            ListDataType.IMAGE -> ViewType.IMAGE.value
        }
    }

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view)
}