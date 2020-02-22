package com.example.androidrecycleviewhw

class MainActivityRepository {
    private val api: Api = Api()
    val errorMessage = api.errorMessageLiveData
    val itemList = api.itemListLiveData

    fun queryItemList() {
        api.callAPI()
    }

    fun cancelApi() {
        api.cancelApi()
    }
}