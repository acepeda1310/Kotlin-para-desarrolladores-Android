package com.adrisoft.apptiempo.dominio.comandos

/**
 * Created by Adrián on 23/05/2017.
 */

import com.adrisoft.apptiempo.dominio.datasource.PrevisionProvider
import com.adrisoft.apptiempo.dominio.modelo.ListaPrevision

class ComandoConsultaPrevision(
        val codPostal: Long,
        val previsionProvider: PrevisionProvider = PrevisionProvider()) :
        Comando<ListaPrevision> {

    companion object {
        val DIAS = 7
    }

    override fun ejecutar(): ListaPrevision{
        return previsionProvider.consultaPorCodPostal(codPostal, DIAS)
    }
}