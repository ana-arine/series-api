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


class SeriesListViewModel : ViewModel() {

    val listaSerie = MutableLiveData<List<Series>>()

    private var retrofitClient = RetrofitInitializer.getRetrofitInstance()
    private var apiService: ApiService = retrofitClient.create(ApiService::class.java)

    fun consultSeriesList(){
        val requestAPI = apiService.getSeriesList()

        requestAPI.enqueue(object : Callback<List<Series>> {

            override fun onResponse(call: Call<List<Series>>, response: Response<List<Series>>) {

                response.body()?.let { lista ->
                      listaSerie.postValue(lista)
                }
            }

            override fun onFailure(call: Call<List<Series>>, t: Throwable) {
                requestAPI.cancel()
                Log.i("URL", call.request().url().toString())
                Log.i("URL", t.message.toString())
             //   Toast.makeText(context, "Loading error", Toast.LENGTH_SHORT).show()
            }

        })
    }

}