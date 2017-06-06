package com.adrisoft.apptiempo.data.db

/**
 * Created by Adrián on 05/06/2017.
 */

import java.util.*

class PrevisionCiudad(val map: MutableMap<String, Any?>, val previsionDiaria: List<PrevisionDiaria>){
    var _id: Long by map
    var ciudad: String by map
    var pais: String by map

    constructor(id: Long, ciudad: String, pais: String, previsionDiaria: List<PrevisionDiaria>)
            : this(HashMap(), previsionDiaria) {
        this._id = id
        this.ciudad = ciudad
        this.pais = pais
    }
}

class PrevisionDiaria(var map: MutableMap<String, Any?>) {
    var _id: Long by map
    var fecha: Long by map
    var descripcion: String by map
    var alta: Int by map
    var baja: Int by map
    var urlIcono: String by map
    var idCiudad: Long by map

    constructor(fecha: Long, descripcion: String, alta: Int, baja: Int, urlIcono: String, idCiudad: Long)
            : this(HashMap()) {
        this.fecha = fecha
        this.descripcion = descripcion
        this.alta = alta
        this.baja = baja
        this.urlIcono = urlIcono
        this.idCiudad = idCiudad
    }
}