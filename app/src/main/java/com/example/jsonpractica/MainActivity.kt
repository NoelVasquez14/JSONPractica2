package com.example.jsonpractica

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import android.widget.Toast
import com.google.gson.Gson


class MainActivity : AppCompatActivity() {
    var id = ArrayList<String>()
    var nombre = ArrayList<String>()
    var puesto = ArrayList<String>()
    var sueldo = ArrayList<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bDatos = findViewById<Button>(R.id.btnDatos)
        val bVer = findViewById<Button>(R.id.btnVer)

        bDatos.setOnClickListener {
            if(Network.hayRed(this)){
                SolictudHTTPVolley("https://practicamoviles.s3.us-east-2.amazonaws.com/json.txt")
                Toast.makeText(this,"Datos Obtenidos", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this,"Error: No hay Red", Toast.LENGTH_LONG).show()
            }
        }
        bVer.setOnClickListener {
            val intent = Intent(this, Lista::class.java)
            intent.putExtra("id",id)
            intent.putExtra("nombre",nombre)
            intent.putExtra("puesto",puesto)
            intent.putExtra("sueldo",sueldo)
            startActivity(intent)
        }
    }

    private fun SolictudHTTPVolley(url: String){
        val queue = Volley.newRequestQueue(this)
        val solicitud = StringRequest(Request.Method.GET, url, Response.Listener<String>{
                response ->
            try {
                //var respuesta = response.toString()
                val gson = Gson()
                val res = gson.fromJson(response.toString(), Empleados::class.java)

                //Log.d("SolicitudHTTPVolley", response)
                //Toast.makeText(this, res.cursos?.get(0)?.nombre.toString(), Toast.LENGTH_LONG).show()
                //Toast.makeText(this, res.cursos?.size.toString(), Toast.LENGTH_LONG).show()

                for (i in 0..res?.empleados?.count().toString().toInt()){
                    id.add(res.empleados?.get(i)?.id.toString())
                    nombre.add(res.empleados?.get(i)?.nombre.toString())
                    puesto.add(res.empleados?.get(i)?.puesto.toString())
                    sueldo.add(res.empleados?.get(i)?.sueldo.toString().toInt())
                }
                Log.d("GSON", res.empleados?.count().toString())
            }catch (e: Exception){

            }
        }, Response.ErrorListener {  })
        queue.add(solicitud)
    }
}
