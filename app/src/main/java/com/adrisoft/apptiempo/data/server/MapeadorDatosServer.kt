package com.adrisoft.apptiempo.data.server

/**
 * Created by Adrián on 23/05/2017.
 */

import com.adrisoft.apptiempo.dominio.modelo.ListaPrevision
import java.util.*
import java.util.concurrent.TimeUnit
import com.adrisoft.apptiempo.dominio.modelo.Prevision as ModeloPrevision

class MapeadorDatosServer {

    fun convertirADominio(codPostal: Long, prevision: ResultadoPrevision) = with(prevision) {
        ListaPrevision(codPostal, prevision.city.name, prevision.city.country, convertirListaPrevisionADominio(prevision.list))
    }

    private fun convertirListaPrevisionADominio(lista: List<Prevision>): List<com.adrisoft.apptiempo.dominio.modelo.Prevision> {
        return lista.mapIndexed { i, prevision ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertirElementoPrevisionADominio(prevision.copy(dt = dt))
        }
    }

    private fun convertirElementoPrevisionADominio(prevision: Prevision) = with(prevision) {
        com.adrisoft.apptiempo.dominio.modelo.Prevision(dt, weather[0].description, temp.max.toInt(), temp.min.toInt(),
                generarUrlIcono(weather[0].icon))
    }

    private fun generarUrlIcono(codigoIcono: String) = "http://openweathermap.org/img/w/$codigoIcono.png"
}