package com.adrisoft.apptiempo.data.server

/**
 * Created by Adrián on 11/06/2017.
 */

import com.adrisoft.apptiempo.data.db.PrevisionDb
import com.adrisoft.apptiempo.dominio.datasource.PrevisionDataSource
import com.adrisoft.apptiempo.dominio.modelo.ListaPrevision

class PrevisionServer(val dataMapper: MapeadorDatosServer = MapeadorDatosServer(),
                      val previsionDb: PrevisionDb = PrevisionDb()) : PrevisionDataSource {

    override fun consultaPrevisionPorCodPostal(codPostal: Long, fecha: Long): ListaPrevision? {
        val resultado = ConsultaPrevisionPorCodPostal(codPostal).ejecutar()
        val convertido = dataMapper.convertirADominio(codPostal, resultado)
        previsionDb.guardarPrevision(convertido)
        return previsionDb.consultarPrevisionPorCodPostal(codPostal, fecha)
    }
}