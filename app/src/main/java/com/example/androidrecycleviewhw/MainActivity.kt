package com.example.androidrecycleviewhw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViewModel()
    }

    override fun onStart() {
        super.onStart()
        viewModel.queryItemList()
    }

    private fun initViewModel() {
        val factory = ViewModelFactory()
        viewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java).apply {
            getItemList().observe(this@MainActivity, Observer {
                it ?: return@Observer
                it.forEach { data ->
                    //Log.d("QAQ", data.toString())
                }
            })

            getErrorMessage().observe(this@MainActivity, Observer {
                it ?: return@Observer
                //Log.d("QAQ", "error: $it")
            })
        }
    }
}
