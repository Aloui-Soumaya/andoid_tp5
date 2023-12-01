package com.gl4.tp5mobile.forecast_models

import com.gl4.tp5mobile.Infos
import com.gl4.tp5mobile.forecast_models.City

data class ForecastResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<Infos>,
    val message: Double
)