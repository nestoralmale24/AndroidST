package com.nst.pruebas

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.nst.pruebas.ui.theme.PruebasTheme

class LoginFirebase : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebasTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting4("Android")
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting4(name: String, modifier: Modifier = Modifier) {
    var contraseña by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }


        Column(modifier = Modifier.fillMaxSize()) {
            TextField(
                value = email,
                onValueChange = { email = it },
                label = { Text("Inserta tu email") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email
                )
            )


            TextField(
                value = contraseña,
                onValueChange = { contraseña = it },
                label = { Text("Inserta tu contraseña") },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password
                )
            )

            Button(onClick = {

            }) {
                Text("INICIAR SESION")
            }
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview4() {
    PruebasTheme {
        Greeting4("Android")
    }
}
