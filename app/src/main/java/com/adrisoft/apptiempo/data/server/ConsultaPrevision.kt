package com.adrisoft.apptiempo.data.server

/**
 * Created by Adrián on 23/05/2017.
 */

import com.google.gson.Gson
import java.net.URL

class ConsultaPrevision(val codPostal: Long) {

    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/forecast/daily?mode=json&units=metric&cnt=7"
        private val URL_COMPLETA = "${URL}&APPID=${APP_ID}&q="
    }

    fun ejecutar(): ResultadoPrevision {
        val previsionJsonStr = URL(URL_COMPLETA + codPostal).readText()
        return Gson().fromJson(previsionJsonStr, ResultadoPrevision::class.java)
    }
}