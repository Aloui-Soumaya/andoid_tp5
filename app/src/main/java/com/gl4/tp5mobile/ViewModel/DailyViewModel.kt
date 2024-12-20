package com.gl4.tp5mobile.ViewModel

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gl4.tp5mobile.RetrofitHelper
import com.gl4.tp5mobile.daily.ForecastResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DailyViewModel(private val context : Context) {
    private val forecastResponse = MutableLiveData<ForecastResponse>()
    var forecast : LiveData<ForecastResponse> = forecastResponse


    fun getDaily(city : String){
        RetrofitHelper.retrofitService.getForecast(city).enqueue(
            object : Callback<ForecastResponse> {
                override fun onResponse(
                    call: Call<ForecastResponse>,
                    response: Response<ForecastResponse>
                ) {
                    if(response.isSuccessful){
                        forecastResponse.value = response.body()
                        forecast = forecastResponse
                        Log.d("mylist", forecast.value.toString())

                    }
                }

                override fun onFailure(call: Call<ForecastResponse>, t: Throwable) {
                }
            }
        )
    }

}