package com.adrisoft.apptiempo.ui.adaptadores

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.adrisoft.apptiempo.dominio.modelo.ListaPrevision

/**
 * Created by Adrián on 22/05/2017.
 */

class AdaptadorListaMeteo(val previsionSemanal: ListaPrevision) :
        RecyclerView.Adapter<AdaptadorListaMeteo.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder,
                                  position: Int) {
        with(previsionSemanal[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun getItemCount(): Int = previsionSemanal.size

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
}