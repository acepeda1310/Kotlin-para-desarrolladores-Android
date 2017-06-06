package com.adrisoft.apptiempo.ui.actividades

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.adrisoft.apptiempo.R
import com.adrisoft.apptiempo.ui.adaptadores.AdaptadorListaMeteo
import com.adrisoft.apptiempo.dominio.comandos.ComandoConsultaPrevision
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listaMeteo.layoutManager = LinearLayoutManager(this)

        doAsync {
            val resultado = ComandoConsultaPrevision(94043).ejecutar()
            uiThread {
                val adaptador = AdaptadorListaMeteo(resultado, { toast(it.description) })
                listaMeteo.adapter = adaptador
            }
        }
    }
}
