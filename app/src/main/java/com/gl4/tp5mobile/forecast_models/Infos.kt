package com.gl4.tp5mobile

import com.gl4.tp5mobile.forecast_models.FeelsLike
import com.gl4.tp5mobile.forecast_models.Temp
import com.gl4.tp5mobile.forecast_models.Weather

data class Infos(
    val clouds: Int,
    val deg: Int,
    val dt: Int,
    val feels_like: FeelsLike,
    val gust: Double,
    val humidity: Int,
    val pop: Double,
    val pressure: Int,
    val rain: Double,
    val speed: Double,
    val sunrise: Int,
    val sunset: Int,
    val temp: Temp,
    val weather: List<Weather>
)