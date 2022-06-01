package com.example.personascompose.Utilidades

sealed class Pantalla(val route: String) {

    object ListadoPersonas : Pantalla("ListadoPersonas")
    object ListadoOcupacion : Pantalla("ListadoOcupacion")
    object RegistroPersona : Pantalla("RegistroPersona")
    object RegistroOcupacion : Pantalla("RegistroOcupacion")
}