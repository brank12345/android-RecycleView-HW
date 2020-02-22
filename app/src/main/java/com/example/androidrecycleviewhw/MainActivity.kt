package com.example.androidrecycleviewhw

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrecycleviewhw.listDataType.ListData
import com.example.androidrecycleviewhw.listDataType.WeatherInfoData

class MainActivity : AppCompatActivity(), ItemListAdapter.ItemClickListener {
    private lateinit var viewModel: MainActivityViewModel
    private var recyclerView: RecyclerView? = null
    private var viewManager: RecyclerView.LayoutManager? = null
    private var debounceLock: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.item_list)
        viewManager = LinearLayoutManager(this)
        initViewModel()

        viewModel.queryItemList()
    }

    override fun onResume() {
        super.onResume()
        debounceLock = false
    }

    private fun initViewModel() {
        val factory = ViewModelFactory()
        viewModel = ViewModelProviders.of(this, factory).get(MainActivityViewModel::class.java).apply {
            getItemList().observe(this@MainActivity, Observer {
                it ?: return@Observer
                handleDataUpdate(it)
            })

            getErrorMessage().observe(this@MainActivity, Observer {
                it ?: return@Observer
                //Log.d("QAQ", "error: $it")
            })
        }
    }

    private fun handleDataUpdate(data: MutableList<ListData>) {
        recyclerView?.apply {
            setHasFixedSize(true)
            this.adapter = ItemListAdapter(data, this@MainActivity)
            this.layoutManager = viewManager
        }
    }

    override fun onItemClick(weatherInfoData: WeatherInfoData) {
        if (debounceLock) {
            return
        } else {
            debounceLock = true
        }
        val intent = Intent(this, MoreDetailActivity::class.java)
        intent.putExtra(BundleKeys.WEATHER_INDO_DATA.value, weatherInfoData)
        startActivity(intent)
    }
}
