package com.gl4.tp5mobile.daily

import com.gl4.tp5mobile.Infos

data class ForecastResponse(
    val city: City,
    val cnt: Int,
    val cod: String,
    val list: List<Infos>,
    val message: Double
)