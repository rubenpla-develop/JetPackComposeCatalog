package com.rubenpla.jetpackcomposecatalog

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.rubenpla.jetpackcomposecatalog.model.CheckInfo
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
/*                    var status by rememberSaveable() {
                        mutableStateOf(false)
                    }

                    val checkInfo = CheckInfo(title = "Checkbox title 1",
                        selected = status,
                        onCheckedChange = { status = it })*/
                    
                    val myOptions = getOptions(titles = listOf("CheckBox 1",
                            "Checkbox 2",
                            "CheckBox 3",
                            "CheckBox 4"))

                    Column(Modifier.fillMaxSize()) {
/*                        MyText()
                        MyTextField()
                        MyTextFieldAdvance()
                        MyTexFieldOutlined(myText) { myText = it }*/
                        //MyButtonExample()
                        //            MyImage()
                        //            MyImageAdvance()
                        //            MyIcon()
                        //MyProgressBar()
                        //MyProgressbarAdvanced()
                        //mySwitch()
                        //myCheckBox()
                        //myCheckBoxWithText()
                        //myCheckBoxWithTextCompleted(checkboxInfo = checkInfo)
                        myOptions.forEach {
                            myCheckBoxWithTextCompleted(checkboxInfo = it)
                        }
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
        var status by rememberSaveable() {
            mutableStateOf(false)
        }

        val checkInfo = CheckInfo(title = "Checkbox title 1",
            selected = true,
            onCheckedChange = { status = it })

        Column(Modifier.fillMaxSize()) {
/*            MyText()
            MyTextField()
            MyTextFieldAdvance()
            MyTexFieldOutlined(myText) { myText = it }*/
            //MyButtonExample()
//            MyImage()
//            MyImageAdvance()
//            MyIcon()
            //MyProgressBar()
            //MyProgressbarAdvanced()
            //mySwitch()
            //myCheckBox()
            //myCheckBoxWithText()
            myCheckBoxWithTextCompleted(checkboxInfo = checkInfo)
        }
    }
}

@Composable
fun myCheckBoxWithTextCompleted(checkboxInfo: CheckInfo) {

    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(checked = checkboxInfo.selected,
            onCheckedChange = {
                checkboxInfo.onCheckedChange(!checkboxInfo.selected)
            })

        Spacer(modifier = Modifier.width(3.dp))
        Text(text = checkboxInfo.title)
    }

}

@Composable
fun getOptions(titles : List<String>) : List<CheckInfo> {
    return titles.map {
        var status by rememberSaveable() {
            mutableStateOf(false)
        }

        CheckInfo(title = it,
            selected = status,
            onCheckedChange = { myNewStatus -> status = myNewStatus })
    }
}

@Composable
fun myCheckBoxWithText() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Row(Modifier.padding(8.dp), verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = state, onCheckedChange = {
                state = !state
            })

        Spacer(modifier = Modifier.width(3.dp))
        Text(text = "Checkbox Text")
    }

}

@Composable
fun myCheckBox() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Checkbox(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp)
            .width(48.dp)
            .height(48.dp),
        checked = state, onCheckedChange = {
            state = !state
        },
        enabled = true,
        colors = CheckboxDefaults.colors(
            uncheckedColor = Color.Red,
            checkedColor = Color.Green,
            disabledUncheckedColor = Color.DarkGray,
            disabledCheckedColor = Color.LightGray,
            checkmarkColor = Color.Blue
        )
    )
}

@Composable
fun mySwitch() {
    var state by rememberSaveable {
        mutableStateOf(true)
    }

    Switch(
        modifier = Modifier
            .padding(top = 16.dp, start = 16.dp)
            .width(48.dp)
            .height(48.dp),
        checked = state, onCheckedChange = {
            state = !state
        },
        enabled = true,
        colors = SwitchDefaults.colors(
            uncheckedThumbColor = Color.Red,
            checkedThumbColor = Color.Green,
            uncheckedTrackColor = Color.DarkGray,
            checkedTrackColor = Color.LightGray
        )
    )
}

@Composable
fun MyProgressBar() {
    var showLoading by rememberSaveable() {
        mutableStateOf(false)
    }

    Column(
        Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .width(48.dp)
                    .height(48.dp),
                color = Color.Red, strokeWidth = 3.dp,
            )
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 24.dp), color = Color.Red,
                trackColor = Color.Green
            )
        }

        var textButtonState: String? by rememberSaveable() {
            mutableStateOf("Show")
        }
        Button(modifier = Modifier.padding(top = 24.dp),
            onClick = {
                showLoading = !showLoading

                textButtonState = when (showLoading) {
                    true -> "Hide"
                    false -> "Show"
                }
            }) {
            Text(text = "$textButtonState Progress Bar")
        }
    }
}

@Composable
fun MyProgressbarAdvanced() {

    var percentage by rememberSaveable() {
        mutableStateOf(0.5f)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .width(96.dp)
                .height(96.dp),
            progress = percentage
        )

        Text(
            modifier = Modifier.padding(top = 16.dp),
            text = "Loading Complete at ${percentage * 100}%"
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(25.dp)
                .background(Color.LightGray), horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(modifier = Modifier.width(125.dp), onClick = { percentage += 0.1f }) {
                Text(text = "+ 10%")
            }

            Button(modifier = Modifier.width(125.dp), onClick = { percentage -= 0.1f }) {
                Text(text = " -10%")
            }
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
fun MyImageAdvance() {
    Image(
        modifier = Modifier
            .padding(top = 16.dp)
            .clip(/*RoundedCornerShape(28.dp)*/CircleShape)
            .border(3.dp, Color.DarkGray, CircleShape),
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Ejemplo",
        alpha = 0.7f
    )
}

@Composable
fun MyIcon() {
    Icon(
        modifier = Modifier
            .width(96.dp)
            .height(96.dp),
        imageVector = Icons.Rounded.AccountBox, contentDescription = "Icon", tint = Color.Red
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