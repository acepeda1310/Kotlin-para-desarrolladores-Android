package com.adrisoft.apptiempo.actividades

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.adrisoft.apptiempo.R
import com.adrisoft.apptiempo.adaptadores.AdaptadorListaMeteo

class MainActivity : AppCompatActivity() {

    private val items = listOf(
            "Lun 23/6 – Soleado – 31/17",
            "Mar 24/6 – Nuboso – 21/8",
            "Mie 25/6 – Nublado – 22/17",
            "Jue 26/6 – Lluvioso – 18/11",
            "Vie 27/6 – Nuboso – 21/10",
            "Sab 28/6 – ATRAPADO EN LA ESTACIÓN METEOROLÓGICA – 23/18",
            "Dom 29/6 – Soleado – 20/7"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listaMeteo = findViewById(R.id.lista_meteo) as RecyclerView
        listaMeteo.layoutManager = LinearLayoutManager(this)
        listaMeteo.adapter = AdaptadorListaMeteo(items)
    }
}
