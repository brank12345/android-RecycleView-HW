package com.example.androidrecycleviewhw

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.example.androidrecycleviewhw.listDataType.ListData

class MainActivityViewModel(private val repository: MainActivityRepository) : ViewModel() {
    private val itemList: MediatorLiveData<MutableList<ListData>> = MediatorLiveData()
    private val errorMessage: MediatorLiveData<String> = MediatorLiveData()

    init {
        itemList.addSource(repository.itemList) {
            it ?: return@addSource
            itemList.value = it
        }

        errorMessage.addSource(repository.errorMessage) {
            it ?: return@addSource
            errorMessage.value = it
        }
    }

    fun getItemList(): MediatorLiveData<MutableList<ListData>> {
        return itemList
    }

    fun getErrorMessage(): MediatorLiveData<String> {
        return errorMessage
    }

    fun queryItemList() {
        repository.queryItemList()
    }

    override fun onCleared() {
        super.onCleared()
        repository.cancelApi()
        itemList.removeSource(repository.itemList)
        errorMessage.removeSource(repository.errorMessage)
    }
}