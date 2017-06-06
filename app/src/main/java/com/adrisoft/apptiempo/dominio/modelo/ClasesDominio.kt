package com.adrisoft.apptiempo.dominio.modelo

/**
 * Created by Adrián on 23/05/2017.
 */

data class ListaPrevision(val id: Long, val city: String, val country: String, val dailyForecast: List<Prevision>) {

    val size: Int
        get() = dailyForecast.size

    operator fun get(position: Int) = dailyForecast[position]
}

data class Prevision(val date: Long, val description: String, val high: Int, val low: Int,
                     val iconUrl: String)