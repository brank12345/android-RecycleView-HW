package com.example.androidrecycleviewhw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidrecycleviewhw.listDataType.ListData

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: MainActivityViewModel
    private var recyclerView: RecyclerView? = null
    private var viewManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.item_list)
        viewManager = LinearLayoutManager(this)
        initViewModel()

        viewModel.queryItemList()
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
            this.adapter = ItemListAdapter(data)
            this.layoutManager = viewManager
        }
    }
}
