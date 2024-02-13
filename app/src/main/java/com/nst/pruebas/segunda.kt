package com.nst.pruebas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting2(email, contraseña)
                }
            }
        }
    }
}

@Composable
fun Greeting2(email: String, contraseña: String ) {
    Column() {
        Text(text = email)
        Text(text = contraseña)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview2() {
    PruebasTheme {
        Greeting2("A", "B")
    }
}