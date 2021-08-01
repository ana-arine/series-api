package com.example.apiseries.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.apiseries.databinding.ActivitySeriesInfoBinding
import com.example.apiseries.viewmodel.SeriesViewModel

class SeriesInfoActivity : AppCompatActivity() {

    private val bindingActivity by lazy {
        ActivitySeriesInfoBinding.inflate(layoutInflater)
    }

    private lateinit var viewModel: SeriesViewModel

    override fun onCreate(savedInstantState: Bundle?) {
        super.onCreate(savedInstantState)

        setContentView(bindingActivity.root)

        viewModel = ViewModelProvider(this).get(SeriesViewModel::class.java)

        inicializeUI()
    }

    private fun inicializeUI() {
        val id = intent.extras?.get("ID_SHOW") as Int

        bindingActivity.progressBar.visibility = View.VISIBLE

        viewModel.dataSeriesConsult(id)

        viewModel.seriesInfo.observe(this, Observer { series ->

            bindingActivity.txtItemTitle.text = series.name
            bindingActivity.txtItemLanguage.text = series.language
            bindingActivity.txtItemGenre.text = series.genres.toString()
            bindingActivity.txtItemRuntime.text = series.runtime.toString()
            bindingActivity.txtItemSchedule.text = series.schedule.toString()
            bindingActivity.txtItemSite.text = series.officialSite

            //val urlImage = series.image.medium

            Glide.with(this)
                .load(series.image.medium)
                .into(bindingActivity.imgItemSeries)

            bindingActivity.progressBar.visibility = View.GONE

        })

        bindingActivity.btnBack.setOnClickListener {
            onBackPressed()
        }

    }
}