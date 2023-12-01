package com.gl4.tp5mobile.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gl4.tp5mobile.RetrofitHelper
import com.gl4.tp5mobile.weather_models.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel {
    private val weatherReponse = MutableLiveData<WeatherResponse>()
    var weather : LiveData<WeatherResponse> = weatherReponse

    init {
        getWeather("Tunis")
    }

    private fun getWeather(city : String){
        RetrofitHelper.retrofitService.getWeather(city).enqueue(
            object : Callback<WeatherResponse>{
                override fun onResponse(
                    call: Call<WeatherResponse>,
                    response: Response<WeatherResponse>
                ) {
                    if(response.isSuccessful){
                        weatherReponse.value = response.body()
                    }
                }

                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {

                }

            }
        )
    }

    fun changeCity(city : String) : String?{
        getWeather(city)
        weather = weatherReponse
        return weatherReponse.value?.name
    }

}