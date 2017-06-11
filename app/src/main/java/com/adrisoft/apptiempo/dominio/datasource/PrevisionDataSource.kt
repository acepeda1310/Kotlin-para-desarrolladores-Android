package com.adrisoft.apptiempo.dominio.datasource

/**
 * Created by Adrián on 11/06/2017.
 */

import com.adrisoft.apptiempo.dominio.modelo.ListaPrevision

interface PrevisionDataSource {
    fun consultaPrevisionPorCodPostal(codPostal: Long, fecha: Long): ListaPrevision?
}