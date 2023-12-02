package com.gl4.tp5mobile

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.gl4.tp5mobile.daily.ForecastResponse
import java.util.Date

class WeatherAdapter(private var forecastList: List<Infos>?) :
    RecyclerView.Adapter<WeatherAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val date : TextView = itemView.findViewById(R.id.date_item)
        val pressure: TextView = itemView.findViewById(R.id.pressure)
        val temperature: TextView = itemView.findViewById(R.id.temperature)
        val humidity: TextView = itemView.findViewById(R.id.humidity)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_i, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentForecast = forecastList?.get(position)
        Log.d("everyItem", currentForecast.toString())
        holder.date.text="Date : ${currentForecast?.dt?.let { Date(it.toLong()*1000).toString() }}"
        holder.pressure.text = "Pressure ${currentForecast?.pressure.toString()}"
        holder.temperature.text = "Temperature ${currentForecast?.temp?.day.toString()}"
        holder.humidity.text = "Humidity ${currentForecast?.humidity.toString()}"
    }

    override fun getItemCount(): Int {
        Log.d("AdapterItemCount", "ItemCount: ${forecastList?.size ?: 0}")
        return forecastList?.size ?: 0
    }

    fun updateData(newList: List<Infos>?) {
        forecastList = newList
        notifyDataSetChanged()
        Log.d("AdapterUpdate", "New List Size: ${newList?.size}")
    }
}
