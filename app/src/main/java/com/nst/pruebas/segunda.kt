package com.nst.pruebas

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.nst.pruebas.ui.theme.PruebasTheme

class segunda : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var email : String? = intent.getStringExtra("email")
        var contraseña : String? = intent.getStringExtra("contraseña")


        if(email == null){
            email = "no hay"
        }
        if(contraseña == null){
            contraseña = "no hay"
        }

        setContent {
            PruebasTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2()
                }
            }
        }
    }
}

@Composable
fun Greeting2() {

    val context = LocalContext.current
    val sp = context.getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
    var email : String? = sp.getString("email", "")
    var contraseña : String? = sp.getString("contraseña", "")

    if(email == null){
        email = "no hay"
    }
    if(contraseña == null){
        contraseña = "no hay"
    }

    Column() {
        Text(text = email)
        Text(text = contraseña)
        Button(onClick = {}) {
            Toast.makeText(context, "cosas pasan", Toast.LENGTH_LONG).show()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    PruebasTheme {
        Greeting2()
    }
}