package com.example.chapter6_mvp.network

import com.example.chapter6_mvp.Model.DataCarItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("admin/car")
    fun getAllCar() : Call<List<DataCarItem>>
}