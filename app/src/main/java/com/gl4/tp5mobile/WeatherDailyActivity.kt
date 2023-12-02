package com.gl4.tp5mobile

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.gl4.tp5mobile.ViewModel.DailyViewModel
import com.gl4.tp5mobile.databinding.ActivityWeatherForecastsBinding


class WeatherDailyActivity : AppCompatActivity() {

    private lateinit var binding: ActivityWeatherForecastsBinding
    var dailyViewModel: DailyViewModel = DailyViewModel(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWeatherForecastsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val newCity = intent.getStringExtra("newcity")

        if (newCity != null) {
            Log.d("test", "--------------------response is successful")
            dailyViewModel.getDaily(newCity)
        }

        val adapter = WeatherAdapter(null) // Pass null initially
        binding.forecastsRecycler.layoutManager = LinearLayoutManager(this)
        binding.forecastsRecycler.adapter = adapter

        dailyViewModel.forecast.observe(this) {
            if (it != null) {
                Log.d("mynewmlist", it.list.toString())
                Log.d("mynewmlistSize", it.list.size.toString())

                adapter.updateData(it.list)
                binding.cityName.text = it.city.name
            }
        }
    }
}
