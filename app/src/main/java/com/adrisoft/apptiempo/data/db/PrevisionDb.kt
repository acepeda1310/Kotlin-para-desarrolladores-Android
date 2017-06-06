package com.adrisoft.apptiempo.data.db

/**
 * Created by Adrián on 05/06/2017.
 */

import com.adrisoft.apptiempo.dominio.modelo.ListaPrevision
import com.adrisoft.apptiempo.extensiones.clear
import com.adrisoft.apptiempo.extensiones.parseList
import com.adrisoft.apptiempo.extensiones.parseOpt
import com.adrisoft.apptiempo.extensiones.toVarargArray
import org.jetbrains.anko.db.insert
import org.jetbrains.anko.db.select
import java.util.*

class PrevisionDb(val previsionDBHelper: PrevisionDBHelper = PrevisionDBHelper.instance,
                  val dataMapper: DbDataMapper = DbDataMapper()) {

    fun consultarPrevisionPorCodPostal(codPostal: Long, fecha: Long) = previsionDBHelper.use {

        val consultaDiaria = "${TablaPrevisionDiaria.ID_CIUDAD} = ? AND ${TablaPrevisionDiaria.FECHA} >= ?"
        val previsionDiaria = select(TablaPrevisionDiaria.NOMBRE)
                .whereSimple(consultaDiaria, codPostal.toString(), fecha.toString())
                .parseList { PrevisionDiaria(HashMap(it)) }

        val ciudad = select(TablaPrevisionCiudad.NOMBRE)
                .whereSimple("${TablaPrevisionCiudad.ID} = ?", codPostal.toString())
                .parseOpt { PrevisionCiudad(HashMap(it), previsionDiaria) }

        if (ciudad != null) dataMapper.convertirADominio(ciudad) else null
    }

    fun guardarPrevision(prevision: ListaPrevision) = previsionDBHelper.use {

        clear(TablaPrevisionCiudad.NOMBRE)
        clear(TablaPrevisionDiaria.NOMBRE)

        with(dataMapper.convertirDesdeDominio(prevision)) {
            insert(TablaPrevisionCiudad.NOMBRE, *map.toVarargArray())
            previsionDiaria.forEach { insert(TablaPrevisionDiaria.NOMBRE, *it.map.toVarargArray()) }
        }
    }
}