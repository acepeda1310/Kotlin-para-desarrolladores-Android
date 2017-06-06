package com.adrisoft.apptiempo.extensiones

/**
 * Created by Adrián on 06/06/2017.
 */

fun <K, V : Any> Map<K, V?>.toVarargArray(): Array<out Pair<K, V>> =
        map({ Pair(it.key, it.value!!) }).toTypedArray()