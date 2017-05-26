package com.adrisoft.apptiempo.ui.adaptadores

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.adrisoft.apptiempo.R
import com.adrisoft.apptiempo.dominio.modelo.Prevision
import com.adrisoft.apptiempo.dominio.modelo.ListaPrevision
import com.adrisoft.apptiempo.ui.utiles.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find
import org.w3c.dom.Text

/**
 * Created by Adrián on 22/05/2017.
 */

class AdaptadorListaMeteo(val previsionSemanal: ListaPrevision,
                          val itemClick: (Prevision) -> Unit) :
        RecyclerView.Adapter<AdaptadorListaMeteo.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        val vista = LayoutInflater.from(parent.ctx).inflate(R.layout.elemento_prevision, parent, false)
        return ViewHolder(vista, itemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        holder.enlazarPrevision(previsionSemanal[position])
    }

    override fun getItemCount() = previsionSemanal.size

    class ViewHolder(view: View, val itemClick: (Prevision) -> Unit) : RecyclerView.ViewHolder(view) {

        private val iconoView = view.find<ImageView>(R.id.icono)
        private val fechaView = view.find<TextView>(R.id.fecha)
        private val descripcionView = view.find<TextView>(R.id.descripcion)
        private val temperaturaMaxView = view.find<TextView>(R.id.temperaturaMax)
        private val temperaturaMinView = view.find<TextView>(R.id.temperaturaMin)

        fun enlazarPrevision(prevision: Prevision) {
            with(prevision) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconoView)
                fechaView.text = date
                descripcionView.text = description
                temperaturaMaxView.text = "${high}º"
                temperaturaMinView.text = "${low}º"
                itemView.setOnClickListener {itemClick(this)}
            }
        }
    }
}