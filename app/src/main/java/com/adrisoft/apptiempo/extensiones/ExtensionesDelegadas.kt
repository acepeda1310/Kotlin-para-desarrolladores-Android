package com.adrisoft.apptiempo.extensiones

/**
 * Created by Adrián on 30/05/2017.
 */

import kotlin.reflect.KProperty

object DelegacionesExt {
    fun <T> valorUnicoNoNull() = VarValorUnicoNoNull<T>()
}

class VarValorUnicoNoNull<T> {

    private var valor: T? = null

    operator fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return valor ?: throw IllegalStateException("${property.name} no inicializada")
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, valor: T) {
        this.valor = if (this.valor == null) valor
        else throw IllegalStateException("${property.name} ya está inicializada")
    }
}