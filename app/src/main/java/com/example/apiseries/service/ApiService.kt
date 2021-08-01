package com.example.apiseries.service

import com.example.apiseries.model.Series
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("shows")
    fun getSeriesList(): Call<List<Series>>

    @GET("shows/{id}")
    fun getSeriesInfo(@Path("id") id: Int): Call<Series>
}
