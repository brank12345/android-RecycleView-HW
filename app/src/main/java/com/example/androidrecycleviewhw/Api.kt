package com.example.androidrecycleviewhw

import androidx.lifecycle.MutableLiveData
import com.example.androidrecycleviewhw.dataClass.Data
import com.example.androidrecycleviewhw.listDataType.ListData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api {
    val errorMessageLiveData: MutableLiveData<String> = MutableLiveData()
    val itemListLiveData: MutableLiveData<MutableList<ListData>> = MutableLiveData()
    private var retrofitCall : Call<Data>? = null

    fun callAPI() {
        retrofitCall = Retrofit.Builder()
            .baseUrl("https://opendata.cwb.gov.tw/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(APIService::class.java)
            .call("CWB-E65FC405-2EC8-43B4-8E2F-FE51B890C932", "臺北市")

        retrofitCall?.enqueue(object : Callback<Data> {
            override fun onFailure(call: Call<Data>, t: Throwable) {
                call.cancel()
                errorMessageLiveData.value = t.message
            }

            override fun onResponse(
                call: Call<Data>,
                response: Response<Data>
            ) {
                response.body()?.apply {
                    itemListLiveData.value = ItemListUtils.createList(this)
                }

            }

        })
    }

    fun cancelApi() {
        retrofitCall?.cancel()
    }
}