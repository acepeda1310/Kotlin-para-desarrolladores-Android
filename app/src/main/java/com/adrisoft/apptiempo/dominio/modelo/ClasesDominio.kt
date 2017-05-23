package com.adrisoft.apptiempo.dominio.modelo

/**
 * Created by Adrián on 23/05/2017.
 */

data class ListaPrevision(val city: String, val country: String, val dailyForecast: List<Prevision>)
data class Prevision(val date: String, val description: String, val high: Int, val low: Int)