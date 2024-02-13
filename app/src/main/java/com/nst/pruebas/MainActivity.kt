package com.nst.pruebas

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.nst.pruebas.ui.theme.PruebasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PruebasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}



//COLUMN SIRVE PARA METER EN UNA MISMA COLUMNA UN CONJUNTOS DE ELEMENTOS
//ROW SIRVE PARA METER EN UNA MISMA FILA UN CONJUNTOS DE ELEMENTOS

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Greeting(name: String) {

    var fot by remember { mutableStateOf(R.drawable.c)}
    var imagenTotal = painterResource(fot)

    val image1 = (R.drawable.c)
    val image2 = (R.drawable.hombre)
    val image3 = (R.drawable.solo_campo)
    val image4 = (R.drawable.tractor)

    var contraseña by remember {
        mutableStateOf("")
    }

    var email by remember {
        mutableStateOf("")
    }

    Surface {
        Image(
            painter = imagenTotal, contentDescription = "el guapo",
            contentScale = ContentScale.Crop,
            alpha = 0.9F
        )

        Column(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
        ) {
            Text(
                text = stringResource(R.string.hola),
                color = Color.White,
                modifier = Modifier.padding(15.dp),
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )

            Text(
                text = stringResource(R.string.adios),
                color = Color.White,
                modifier = Modifier.padding(15.dp),
                fontSize = 30.sp,
                textAlign = TextAlign.Center
            )

            Button(
                onClick = {
                    val num = (1..4).random()
                    when (num) {
                        1 -> fot = image1
                        2 -> fot = image2
                        3 -> fot = image3
                        4 -> fot = image4
                    }
                }
            ) {
                Text("Pulsa para cambiar el fondo")
            }

            TextField(
                value = email,
                onValueChange = {email=it},
                label = {Text("Inserta tu email" )},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Email
                )
            )

            TextField(
                value = contraseña,
                onValueChange = {contraseña=it},
                label = {Text("Inserta tu contraseña" )},
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Password
                )
            )
            val contexto = LocalContext.current
            val intent_segunda = Intent(contexto, segunda::class.java)

            intent_segunda.putExtra("email",email)
            intent_segunda.putExtra("contraseña",contraseña)


            Button(onClick = {
                if(email == "admin@admin.com" && contraseña == "123"){
                    contexto.startActivity(intent_segunda)
                }else{ Toast.makeText(contexto, "Cosas pasan", Toast.LENGTH_LONG).show()
                }
            }) {
                Text("Segunda")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PruebasTheme {
        Greeting("Néstor")
    }
}