package com.example.jsonpractica

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Lista : AppCompatActivity() {
    var lista: RecyclerView? = null
    var adaptador:AdaptadorCustom? = null
    var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        var id = intent.getStringArrayListExtra("id")
        var nombre = intent.getStringArrayListExtra("nombre")
        var puesto = intent.getStringArrayListExtra("puesto")
        var sueldo = intent.getIntegerArrayListExtra("sueldo")

        var num = nombre.size-1
        var empleados=ArrayList<Empleado>();
        for (i in 0..num){
            empleados.add(Empleado(id[i],nombre[i],sueldo[i],puesto[i]))
        }

        lista = findViewById(R.id.lista)
        lista?.setHasFixedSize(true) //habilitar la vista de la lista

        layoutManager = LinearLayoutManager(this)
        lista?.layoutManager = layoutManager //habilitar el manejador de la lista

        adaptador = AdaptadorCustom(this, empleados) // enviar el contexto y el arrayList al adaptador
        lista?.adapter = adaptador //asiganar el adaptador a la lista

    }
}
