package com.example.androidrecycleviewhw

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MainActivityViewModel::class.java) -> MainActivityViewModel(MainActivityRepository()) as T
            else -> throw IllegalArgumentException("Unknown ViewModel Class")
        }
    }
}