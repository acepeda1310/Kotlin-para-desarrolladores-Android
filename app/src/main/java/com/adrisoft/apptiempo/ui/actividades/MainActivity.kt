package com.adrisoft.apptiempo.ui.actividades

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.adrisoft.apptiempo.R
import com.adrisoft.apptiempo.ui.adaptadores.AdaptadorListaMeteo
import com.adrisoft.apptiempo.dominio.comandos.ComandoConsultaPrevision
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaMeteo: RecyclerView = find(R.id.lista_meteo)
        listaMeteo.layoutManager = LinearLayoutManager(this)

        doAsync {
            val resultado = ComandoConsultaPrevision("94043").ejecutar()
            uiThread {
                listaMeteo.adapter = AdaptadorListaMeteo(resultado)
            }
        }
    }
}
