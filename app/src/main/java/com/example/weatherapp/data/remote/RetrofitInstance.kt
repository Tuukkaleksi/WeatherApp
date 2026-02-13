package com.example.weatherapp.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL =
        "https://api.openweathermap.org/data/2.5/"

    private val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
        GsonConverterFactory.create()).build()

    val api: WeatherApi = retrofit.create(WeatherApi::class.java)
}