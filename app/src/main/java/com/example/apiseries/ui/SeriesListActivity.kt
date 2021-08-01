package com.example.apiseries.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.apiseries.databinding.ActivitySeriesListBinding
import com.example.apiseries.viewmodel.ListAdapter
import com.example.apiseries.viewmodel.SeriesListViewModel

class SeriesListActivity : AppCompatActivity() {

    private val bindingActivity by lazy {
        ActivitySeriesListBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: SeriesListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(bindingActivity.root)

        viewModel = ViewModelProvider(this).get(SeriesListViewModel::class.java)

        initializeUI()
    }


    private fun initializeUI() {

        bindingActivity.progressBar.visibility = View.VISIBLE

        bindingActivity.rvSeriesList.layoutManager = GridLayoutManager(this,3)

        viewModel.consultSeriesList()

        viewModel.listaSerie.observe(this, Observer { lista ->
            bindingActivity.progressBar.visibility = View.GONE
            bindingActivity.rvSeriesList.adapter = ListAdapter(lista)
        })

    }
}