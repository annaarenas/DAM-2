package edu.annaarenas.practica1

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.annaarenas.practica1.ui.theme.Practica1Theme

//Anna Arenas Martínez 2DAM

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Practica1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    NombreApellidos()
                }
            }
        }
    }
}

@Composable
fun NombreApellidos(){
    var nombre by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center, // Centra verticalmente
        horizontalAlignment = Alignment.CenterHorizontally) {

        //Bloque de texto nombre
        TextField(value = nombre, onValueChange = {nombre = it}, label = {Text("Ingrese su nombre")})

        Spacer(modifier = Modifier.height(3.dp))

        //Bloque de texto apellidos
        TextField(value = apellidos, onValueChange = {apellidos = it}, label = {Text("Ingrese sus apellidos")})

        Spacer(modifier = Modifier.height(8.dp))

        //Campo que muestra nombre y apellidos
        if (nombre != "" && apellidos != "") {
            Text("$nombre $apellidos")
        }

        Spacer(modifier = Modifier.height(8.dp))

        //Boton limpiar
        Button(onClick = { nombre = ""; apellidos = ""}) {
            Text(text = "Limpiar")
        }

        Spacer(modifier = Modifier.height(8.dp))

        val context = LocalContext.current //para el contexto del toast

        //Boton de saludar que muestra el nombre y apellidos en un toast
        if(nombre != "" && apellidos != ""){
            Button(onClick = {
                Toast.makeText(context, "$nombre $apellidos", Toast.LENGTH_SHORT).show()
            }) {
                Text("Saludar")
            }
        }
    }
}
