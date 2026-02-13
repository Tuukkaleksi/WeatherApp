package com.example.weatherapp.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.remote.RetrofitInstance
import kotlinx.coroutines.launch
import com.example.weatherapp.BuildConfig
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class WeatherViewModel : ViewModel() {
    data class UiState(
        val city: String = "",
        val temperature: String = "",
        val description: String = "",
        val isLoading: Boolean = false,
        val error: String? = null
    )

    var uiState by mutableStateOf(UiState())
        private set

    fun updateCity(newCity: String) {
        uiState = uiState.copy(city = newCity)
    }

    fun fetchWeather() {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true, error = null)

            println(BuildConfig.WEATHER_API_KEY)

            try {
                val response = RetrofitInstance.api.getWeather(
                    city = uiState.city,
                    apiKey = BuildConfig.WEATHER_API_KEY
                )

                uiState = uiState.copy(
                    temperature = "${response.main.temp} °C",
                    description = response.weather.first().description,
                    isLoading = false
                )

            } catch (e: Exception) {
                uiState = uiState.copy(
                    isLoading = false,
                    error = "Tarkista antamasi Kaupunki."
                )
            }
        }
    }
}