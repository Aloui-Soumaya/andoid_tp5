package com.gl4.tp5mobile.ViewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gl4.tp5mobile.RetrofitHelper
import com.gl4.tp5mobile.weather.WeatherResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherViewModel {
    private val weatherReponse = MutableLiveData<WeatherResponse>()
    var weather : LiveData<WeatherResponse> = weatherReponse


    private fun findWeather(city : String){
        RetrofitHelper.retrofitService.getWeather(city).enqueue(
            object : Callback<WeatherResponse>{
                override fun onResponse(
                    call: Call<WeatherResponse>,
                    response: Response<WeatherResponse>
                ) {
                    if(response.isSuccessful){
                        Log.d("test","-------------------response is successful")
                        weatherReponse.value = response.body()
                    }
                }

                override fun onFailure(call: Call<WeatherResponse>, t: Throwable) {

                }

            }
        )
    }

    fun changeCity(city : String) : String?{
        findWeather(city)
        weather = weatherReponse
        return weatherReponse.value?.name
    }

}