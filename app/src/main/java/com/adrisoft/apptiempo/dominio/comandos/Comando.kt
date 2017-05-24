package com.adrisoft.apptiempo.dominio.comandos

/**
 * Created by Adrián on 23/05/2017.
 */

interface Comando<T> {
    fun ejecutar(): T
}