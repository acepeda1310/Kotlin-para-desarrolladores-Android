package com.adrisoft.apptiempo.ui.actividades

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.adrisoft.apptiempo.R
import com.adrisoft.apptiempo.ui.adaptadores.AdaptadorListaMeteo
import com.adrisoft.apptiempo.data.Consulta
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.find
import org.jetbrains.anko.longToast
import org.jetbrains.anko.uiThread

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

        val listaMeteo: RecyclerView = find(R.id.lista_meteo)
        listaMeteo.layoutManager = LinearLayoutManager(this)
        listaMeteo.adapter = AdaptadorListaMeteo(items)

        val url = "http://api.openweathermap.org/data/2.5/forecast/daily?" +
                "APPID=15646a06818f61f7b8d7823ca833e1ce&q=94043&mode=json&units=metric&cnt=7"

        doAsync {
            Consulta(url).run()
            uiThread { longToast("Consulta realizada") }
        }
    }
}
