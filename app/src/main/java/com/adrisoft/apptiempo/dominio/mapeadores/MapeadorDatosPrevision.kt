package com.adrisoft.apptiempo.dominio.mapeadores

/**
 * Created by Adrián on 23/05/2017.
 */

import com.adrisoft.apptiempo.data.Prevision
import com.adrisoft.apptiempo.data.ResultadoPrevision
import com.adrisoft.apptiempo.dominio.modelo.ListaPrevision
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit
import com.adrisoft.apptiempo.dominio.modelo.Prevision as ModeloPrevision

class MapeadorDatosPrevision {

    fun convertirDesdeModeloDatos(prevision: ResultadoPrevision): ListaPrevision {
        return ListaPrevision(prevision.city.name, prevision.city.country, convertirListaPrevisionADominio(prevision.list))
    }

    private fun convertirListaPrevisionADominio(lista: List<Prevision>): List<ModeloPrevision> {
        return lista.mapIndexed { i, prevision ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertirElementoPrevisionADominio(prevision.copy(dt = dt))
        }
    }

    private fun convertirElementoPrevisionADominio(prevision: Prevision): ModeloPrevision {
        return ModeloPrevision(convertirFecha(prevision.dt), prevision.weather[0].description,
                prevision.temp.max.toInt(), prevision.temp.min.toInt())
    }

    private fun convertirFecha(fecha: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(fecha)
    }
}