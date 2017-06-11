package com.adrisoft.apptiempo.data.server

/**
 * Created by Adrián on 23/05/2017.
 */

data class ResultadoPrevision(val city: Ciudad, val list: List<Prevision>)
data class Ciudad(val id: Long, val name: String, val coord: Coordenadas, val country: String, val population: Int)
data class Coordenadas(val lon: Float, val lat: Float)
data class Prevision(val dt: Long, val temp: Temperatura, val pressure: Float, val humidity: Int,
                     val weather: List<Tiempo>, val speed: Float, val deg: Int, val clouds: Int, val rain: Float)

data class Temperatura(val day: Float, val min: Float, val max: Float, val night: Float, val eve: Float, val morn: Float)
data class Tiempo(val id: Long, val main: String, val description: String, val icon: String)