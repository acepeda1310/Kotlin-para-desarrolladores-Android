package com.adrisoft.apptiempo.dominio.datasource

/**
 * Created by Adrián on 11/06/2017.
 */

import com.adrisoft.apptiempo.data.db.PrevisionDb
import com.adrisoft.apptiempo.data.server.PrevisionServer
import com.adrisoft.apptiempo.dominio.modelo.ListaPrevision
import com.adrisoft.apptiempo.extensiones.firstResult

class PrevisionProvider(val fuentes: List<PrevisionDataSource> = PrevisionProvider.FUENTES) {

    companion object {
        val DIA_EN_MILIS = 1000 * 60 * 60 * 24
        val FUENTES = listOf(PrevisionDb(), PrevisionServer())
    }

    fun consultaPorCodPostal(codPostal: Long, dias: Int): ListaPrevision
            = fuentes.firstResult { consultaFuente(it, dias, codPostal)}

    private fun consultaFuente(fuente: PrevisionDataSource, dias: Int, codPostal: Long): ListaPrevision? {
        val res = fuente.consultaPrevisionPorCodPostal(codPostal, todayTimeSpan())
        return if (res != null && res.size >= dias) res else null
    }

    private fun todayTimeSpan() = System.currentTimeMillis() / DIA_EN_MILIS * DIA_EN_MILIS
}