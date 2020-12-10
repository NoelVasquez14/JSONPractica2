package com.example.jsonpractica

class Empleado(id:String, nombre:String, sueldo:Int , puesto:String) {
    var id:String = ""
    var nombre:String = ""
    var puesto:String = ""
    var sueldo:Int = 0

    init {
        this.id = id
        this.nombre = nombre
        this.sueldo = sueldo
        this.puesto= puesto
    }
}