package com.adrisoft.apptiempo.ui.adaptadores

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.adrisoft.apptiempo.R
import com.adrisoft.apptiempo.dominio.modelo.Prevision
import com.adrisoft.apptiempo.dominio.modelo.ListaPrevision
import com.adrisoft.apptiempo.ui.utiles.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.elemento_prevision.view.*

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

        fun enlazarPrevision(prevision: Prevision) {
            with(prevision) {
                Picasso.with(itemView.ctx).load(iconUrl).into(itemView.icono)
                itemView.fecha.text = date
                itemView.descripcion.text = description
                itemView.temperaturaMax.text = "${high}º"
                itemView.temperaturaMin.text = "${low}º"
                itemView.setOnClickListener {itemClick(this)}
            }
        }
    }
}