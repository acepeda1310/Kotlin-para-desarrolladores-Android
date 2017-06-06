package com.adrisoft.apptiempo.dominio.comandos

/**
 * Created by Adrián on 23/05/2017.
 */

import com.adrisoft.apptiempo.data.server.ConsultaPrevision
import com.adrisoft.apptiempo.dominio.mapeadores.MapeadorDatosPrevision
import com.adrisoft.apptiempo.dominio.modelo.ListaPrevision

class ComandoConsultaPrevision(private val codPostal: Long) : Comando<ListaPrevision> {
    override fun ejecutar(): ListaPrevision{
        val consultaPrevision = ConsultaPrevision(codPostal)
        return MapeadorDatosPrevision().convertirDesdeModeloDatos(codPostal, consultaPrevision.ejecutar())
    }
}