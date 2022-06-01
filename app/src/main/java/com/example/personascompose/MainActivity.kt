package com.example.personascompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.personascompose.Utilidades.Pantalla
import com.example.personascompose.ui.theme.PersonasComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersonasComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    MyApp()
                }
            }
        }
    }
}



@Composable
fun MyApp() {
    val navHostController = rememberNavController( )

    NavHost(navController = navHostController, startDestination = Pantalla.ListadoPersonas.route) {
        composable(route = Pantalla.ListadoPersonas.route) {
            ListadoPersonas(
                clickRegitro = { navHostController.navigate(Pantalla.RegistroPersona.route) },
                clickListadoOcupacion = { navHostController.navigate(Pantalla.ListadoOcupacion.route) })
        }
        composable(route = Pantalla.RegistroPersona.route){
            RegistroPersona()
        }
        composable(Pantalla.ListadoOcupacion.route){
            ListadoOcupacion(clickRegistroOcup = {navHostController.navigate(Pantalla.RegistroOcupacion.route)})
        }
        composable(route = Pantalla.RegistroOcupacion.route){
            RegistroOcupacion()
        }
    }
}


@Composable
fun RegistroPersona(){

    val scaffoldState = rememberScaffoldState()
    var ocupaciones by rememberSaveable() {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Personas")})
        },

        scaffoldState = scaffoldState

    ) {
        Column(modifier = Modifier.padding(8.dp)){
            OutlinedTextField(
                label = {
                    Text(text = "PersonaId")
                },

                value = ocupaciones,
                onValueChange = {ocupaciones = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Nombres")
                },

                value = ocupaciones,
                onValueChange = {ocupaciones = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Email")
                },

                value = ocupaciones,
                onValueChange = {ocupaciones = it},
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                label = {
                    Text(text = "Salario")
                },
                value = ocupaciones,
                onValueChange = {ocupaciones = it},
                modifier = Modifier.fillMaxWidth()
            )


            Row() {
                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Nuevo")

                }

                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Guardar")
                }
                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Icon(imageVector = Icons.Default.Delete, contentDescription =null )
                    Text(text = "Eliminar")
                }
            }
        }
    }
}

@Composable
fun RegistroOcupacion(){

    val scaffoldState = rememberScaffoldState()
    var ocupacion by rememberSaveable() {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Registro de Ocupaciones")})
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(8.dp)){
            OutlinedTextField(
                label = {
                    Text(text = "OcupacionId")
                },

                value = ocupacion,
                onValueChange = {ocupacion = it},
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                label = {
                    Text(text = "Nombre Ocupacion")
                },

                value = ocupacion,
                onValueChange = {ocupacion = it},
                modifier = Modifier.fillMaxWidth()
            )


            Row() {
                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Nuevo")
                }
                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Guardar")
                }
                OutlinedButton(
                    onClick = {

                    },
                    modifier = Modifier.padding(8.dp)
                ) {
                    Text(text = "Eliminar")
                }
            }
        }
    }
}

@Composable
fun ListadoPersonas(clickRegitro:() ->Unit, clickListadoOcupacion:() ->Unit){
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = {
            TopAppBar(title = {Text(text = "Listado de Personas")})

        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    clickRegitro()
                },
                backgroundColor = Color.Cyan

            ) {

            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(10.dp)) {
            OutlinedButton(
                onClick = {
                clickListadoOcupacion()
            }) {
               Text(text = "Ocupaciones")
            }

            val lista = listOf("Juan", "Pedro", "Matias", "Mateo", "Felix")

            LazyColumn(modifier = Modifier.fillMaxWidth()){
                items(lista){
                    nombre -> RowNombre(nombre)
                }
            }
        }

    }
}

@Composable
fun ListadoOcupacion(clickRegistroOcup:()->Unit){

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Listado de Ocupaciones")})
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    clickRegistroOcup()
                },
                backgroundColor = MaterialTheme.colors.primary
            ) {
            }
        },
        scaffoldState = scaffoldState
    ) {
        Column(modifier = Modifier.padding(8.dp)) {


            val lista = listOf("Supervisor de Campo", "Capacitacion", "Gestor Local", "Gestor Provincial")

            LazyColumn(modifier = Modifier.fillMaxWidth()) {
                items(lista) { ocupacion ->
                    RowOcupaciones(ocupacion)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    PersonasComposeTheme {
    MyApp()
    }
}

@Composable
fun RowNombre(nombre: String){
    Row(){
        Text("Nombre : $nombre")
    }
}

@Composable
fun RowOcupaciones(nombre: String){
    Row(){
        Text("Ocupacion : $nombre")
    }
}