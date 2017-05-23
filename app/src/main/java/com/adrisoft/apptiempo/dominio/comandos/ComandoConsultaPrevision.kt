package com.adrisoft.apptiempo.dominio.comandos

/**
 * Created by Adrián on 23/05/2017.
 */

import com.adrisoft.apptiempo.data.ConsultaPrevision
import com.adrisoft.apptiempo.dominio.mapeadores.MapeadorDatosPrevision
import com.adrisoft.apptiempo.dominio.modelo.ListaPrevision

class ComandoConsultaPrevision(val codPostal: String) : Comando<ListaPrevision> {
    override fun ejecutar(): ListaPrevision{
        val consultaPrevision = ConsultaPrevision(codPostal)
        return MapeadorDatosPrevision().convertirDesdeModeloDatos(consultaPrevision.ejecutar())
    }
}