package com.gl4.tp5mobile

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gl4.tp5mobile.ViewModel.DailyViewModel
import com.gl4.tp5mobile.databinding.ActivityWeatherForecastsBinding


class WeatherForecastsActivity : AppCompatActivity() {

    private lateinit var binding : ActivityWeatherForecastsBinding
    var dailyViewModel : DailyViewModel = DailyViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherForecastsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newcity=intent.getStringExtra("newcity")

        if(newcity != null){
            Log.d("test","response is successful")
            dailyViewModel.getForecast(newcity)
        }

        dailyViewModel.forecast.observe(this) {
            if (it != null){
                binding.forecastsRecycler.adapter = WeatherAdapter(dailyViewModel.forecast.value)
                binding.cityName.text = dailyViewModel.forecast.value!!.city.name
            }
        }

        binding.forecastsRecycler.apply {
            layoutManager = LinearLayoutManager(this@WeatherForecastsActivity)
            adapter = WeatherAdapter(dailyViewModel.forecast.value)
        }
    }
}