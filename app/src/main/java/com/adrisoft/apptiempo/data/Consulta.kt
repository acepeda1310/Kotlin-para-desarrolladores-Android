package com.adrisoft.apptiempo.data

/**
 * Created by Adrián on 23/05/2017.
 */

import android.util.Log
import java.net.URL

class Consulta(val url: String) {

    fun run() {
        val meteoJsonStr = URL(url).readText()
        Log.d(javaClass.simpleName, meteoJsonStr)
    }
}