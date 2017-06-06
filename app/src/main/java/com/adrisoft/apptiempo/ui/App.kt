package com.adrisoft.apptiempo.ui

/**
 * Created by Adrián on 30/05/2017.
 */

import android.app.Application
import com.adrisoft.apptiempo.extensiones.DelegacionesExt

class App : Application() {

    companion object {
        var instance: App by DelegacionesExt.valorUnicoNoNull()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}