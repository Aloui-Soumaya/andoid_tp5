package com.gl4.tp5mobile
import com.gl4.tp5mobile.forecast_models.ForecastResponse
import com.gl4.tp5mobile.weather_models.WeatherResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherAPI {

    @GET("weather?APPID=17db59488cadcad345211c36304a9266")
    fun getWeather(@Query("q") city : String) : Call<WeatherResponse>

    @GET("forecast/daily?APPID=17db59488cadcad345211c36304a926")
    fun getForecast(@Query("q") city : String): Call<ForecastResponse>

}
