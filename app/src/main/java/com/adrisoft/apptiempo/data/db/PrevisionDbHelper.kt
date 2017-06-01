package com.adrisoft.apptiempo.data.db

/**
 * Created by Adrián on 01/06/2017.
 */

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.adrisoft.apptiempo.ui.App
import org.jetbrains.anko.db.*

class PrevisionDBHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx,
        PrevisionDBHelper.DB_NOMBRE, null, PrevisionDBHelper.DB_VERSION) {

    companion object {
        val DB_NOMBRE = "prevision.db"
        val DB_VERSION = 1
        val instance by lazy { PrevisionDBHelper() }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(TablaPrevisionCiudad.NOMBRE, true,
                TablaPrevisionCiudad.ID to INTEGER + PRIMARY_KEY,
                TablaPrevisionCiudad.CIUDAD to TEXT,
                TablaPrevisionCiudad.PAIS to TEXT)

        db.createTable(TablaPrevisionDiaria.NOMBRE, true,
                TablaPrevisionDiaria.ID to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                TablaPrevisionDiaria.FECHA to INTEGER,
                TablaPrevisionDiaria.DESCRIPCION to TEXT,
                TablaPrevisionDiaria.ALTA to INTEGER,
                TablaPrevisionDiaria.BAJA to INTEGER,
                TablaPrevisionDiaria.URL_ICONO to TEXT,
                TablaPrevisionDiaria.ID_CIUDAD to INTEGER)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.dropTable(TablaPrevisionCiudad.NOMBRE, true)
        db.dropTable(TablaPrevisionDiaria.NOMBRE, true)
        onCreate(db)
    }
}