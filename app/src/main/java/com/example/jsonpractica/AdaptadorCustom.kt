package com.example.jsonpractica

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorCustom(var contexto: Context, items:ArrayList<Empleado>):
    RecyclerView.Adapter<AdaptadorCustom.ViewHolder> () {

    var items:ArrayList<Empleado>?=null

    init {
        this.items = items
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdaptadorCustom.ViewHolder {
        val vista  = LayoutInflater.from(contexto).inflate(R.layout.template_empeados, parent, false)
        val viewHolder = ViewHolder(vista)
        return viewHolder
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }

    override fun onBindViewHolder(holder: AdaptadorCustom.ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.id?.text = item?.id
        holder.nombre?.text = item?.nombre
        holder.puesto?.text = item?.puesto
        holder.sueldo?.text= item?.sueldo.toString()

    }
    class ViewHolder(vista: View):RecyclerView.ViewHolder(vista){
        var vista = vista
        var id: TextView? = null
        var nombre: TextView? = null
        var puesto: TextView? = null
        var sueldo: TextView? = null
        init {
            id = vista.findViewById(R.id.txtId)
            nombre = vista.findViewById(R.id.txtNombre)
            puesto = vista.findViewById(R.id.txtPuesto)
            sueldo = vista.findViewById(R.id.txtSueldo)
        }
    }
}