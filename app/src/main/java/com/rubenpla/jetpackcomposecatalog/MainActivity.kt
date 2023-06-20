package com.rubenpla.jetpackcomposecatalog

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rubenpla.jetpackcomposecatalog.ui.theme.JetPackComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetPackComposeCatalogTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var myText by remember {
                        mutableStateOf("Compose")
                    }
                    Column(Modifier.fillMaxSize()) {
/*                        MyText()
                        MyTextField()
                        MyTextFieldAdvance()
                        MyTexFieldOutlined(myText) { myText = it }*/
                        MyButtonExample()
                    }
                }
            }
        }
    }
}

@Preview(
    name = "PREVIEW 1",
    showBackground = true,
    showSystemUi = true,
    apiLevel = 33,
    device = Devices.PIXEL_3A_XL
)
@Composable
fun GreetingPreview() {
    JetPackComposeCatalogTheme {
        // Greeting("Android")
        var myText by remember {
            mutableStateOf("Compose")
        }

        Column(Modifier.fillMaxSize()) {
/*            MyText()
            MyTextField()
            MyTextFieldAdvance()
            MyTexFieldOutlined(myText) { myText = it }*/
            //MyButtonExample()
            MyImage()
        }
    }
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo",
        alpha = 0.7f
    )
}

@Composable
fun MyButtonExample() {
    var enabled by rememberSaveable { mutableStateOf(true) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Button(
            onClick = {
                Log.i("Udemy", "Button clicked!!")
                enabled = false
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue,
                contentColor = Color.White
            ),
            border = BorderStroke(5.dp, Color.DarkGray),
            enabled = enabled
        ) {
            Text(text = "Standard Button")
        }

        OutlinedButton(
            onClick = {
                Log.i("Udemy", "Button clicked!!")
                enabled = false
            }, Modifier.padding(top = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.LightGray,
                contentColor = Color.DarkGray
            ),
            // border = BorderStroke(2.dp,Color.DarkGray),
            enabled = enabled
        ) {
            Text(text = "Outlined Button")
        }

        TextButton(
            onClick = {
                Log.i("Udemy", "Button clicked!!")
                enabled = false
            },
            enabled = enabled
        ) {
            Text(text = "TextButton")
        }
    }
}

@Composable
fun MyText() {
    Column() {
        Text(text = "Esto es un ejemplo", fontFamily = FontFamily.Monospace, fontSize = 29.sp)
        Text(text = "Esto es un ejemplo 2", color = Color.Magenta, fontWeight = FontWeight.W900)
        Text(
            text = "Esto es un ejemplo 2", color = Color.Blue, fontWeight = FontWeight.W900,
            style = TextStyle(fontFamily = FontFamily.Cursive), fontSize = 32.sp
        )
        Text(
            text = "Esto es un ejemplo 2", color = Color.Blue, fontWeight = FontWeight.W900,
            style = TextStyle(textDecoration = TextDecoration.LineThrough), fontSize = 32.sp
        )
        Text(
            text = "Esto es un ejemplo 2", color = Color.Blue, fontWeight = FontWeight.W900,
            style = TextStyle(
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.LineThrough,
                        TextDecoration.Underline
                    )
                )
            ), fontSize = 51.sp
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {
    var myText by remember {
        mutableStateOf("")
    }

    TextField(value = myText, onValueChange = { myText = it })

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextFieldAdvance() {
    var myText by remember {
        mutableStateOf("")
    }

    TextField(
        value = myText,
        onValueChange = {
            myText = if (it.contains("a")) {
                it.replace("a", "")
            } else {
                it
            }
        },
        label = { Text("Introduce tu nombre") })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTexFieldOutlined(name: String, onValueChanged: (String) -> Unit) {


    OutlinedTextField(
        value = name,
        onValueChange = { onValueChanged(it) },
        label = { Text(text = "Introduce tu nombre") },
        modifier = Modifier.padding(16.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Green,
            unfocusedBorderColor = Color.DarkGray
        )
    )
}