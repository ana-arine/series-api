package com.example.apiseries.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.apiseries.model.Series
import com.example.apiseries.service.ApiService
import com.example.apiseries.service.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SeriesViewModel() : ViewModel() {

    val seriesInfo = MutableLiveData<Series>()

    private var retrofitClient = RetrofitInitializer.getRetrofitInstance()
    private var apiService: ApiService = retrofitClient.create(ApiService::class.java)

    fun dataSeriesConsult(id: Int){

        val requestAPI = apiService.getSeriesInfo(id)

        requestAPI.enqueue(object : Callback<Series> {
            override fun onResponse(call: Call<Series>, response: Response<Series>) {
                response.body()?.let { series ->
                    seriesInfo.postValue(series)
                }
            }

            override fun onFailure(call: Call<Series>, t: Throwable) {
                requestAPI.cancel()
                Log.i("URL", call.request().url().toString())
                Log.i("URL", t.message.toString())
            }

        })
    }

}