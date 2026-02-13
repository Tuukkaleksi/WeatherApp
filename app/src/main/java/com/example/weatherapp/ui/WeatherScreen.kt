package com.example.weatherapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.weatherapp.viewmodel.WeatherViewModel
import androidx.compose.ui.graphics.Color

@Composable
fun WeatherScreen(viewModel: WeatherViewModel = viewModel()) {

    val state = viewModel.uiState

    Column(modifier = Modifier.padding(36.dp)) {

        TextField(
            value = state.city,
            onValueChange = { viewModel.updateCity(it) },
            label = { Text("Kaupunki") }
        )

        Button(onClick = { viewModel.fetchWeather() }) {
            Text("Hae sää")
        }

        if (state.isLoading) {
            CircularProgressIndicator()
        }

        state.error?.let {
            Text(it, color = Color.Red)
        }

        if (state.temperature.isNotEmpty()) {
            Text("Lämpötila: ${state.temperature}")
            Text("Kuvaus: ${state.description}")
        }
    }
}
