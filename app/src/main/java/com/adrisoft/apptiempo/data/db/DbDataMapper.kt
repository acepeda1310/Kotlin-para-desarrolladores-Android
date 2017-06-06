package com.adrisoft.apptiempo.data.db

/**
 * Created by Adrián on 05/06/2017.
 */

import com.adrisoft.apptiempo.dominio.modelo.Prevision
import com.adrisoft.apptiempo.dominio.modelo.ListaPrevision

class DbDataMapper {

    fun convertirDesdeDominio(prevision: ListaPrevision) = with(prevision) {
        val diaria = dailyForecast.map { convertirDiaDesdeCominio(id, it) }
        PrevisionCiudad(id, city, country, diaria)
    }

    private fun convertirDiaDesdeCominio(idCiudad: Long, prevision: Prevision) = with(prevision) {
        PrevisionDiaria(date, description, high, low, iconUrl, idCiudad)
    }

    fun convertirADominio(prevision: PrevisionCiudad) = with(prevision) {
        val diaria = previsionDiaria.map { convertirDiaADominio(it) }
        ListaPrevision(_id, ciudad, pais, diaria)
    }

    private fun convertirDiaADominio(previsionDiaria: PrevisionDiaria) = with(previsionDiaria) {
        Prevision(fecha, descripcion, alta, baja, urlIcono)
    }
}