package com.rubenpla.jetpackcomposecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                    Column(Modifier.fillMaxSize()) {
                        MyText()
                        MyTextField()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
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
        Column(Modifier.fillMaxSize()) {
            MyText()
            MyTextField()
        }
    }
}