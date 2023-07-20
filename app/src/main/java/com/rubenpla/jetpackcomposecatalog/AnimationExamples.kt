package com.rubenpla.jetpackcomposecatalog

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.rubenpla.jetpackcomposecatalog.ComponentType.*
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import kotlin.random.Random.Default.nextInt

@Composable
fun ColorAnimationSimple() {
    var firstColor by rememberSaveable {
        mutableStateOf(false)
    }

    var showBox by rememberSaveable {
        mutableStateOf(true)
    }

    val realColor by animateColorAsState(
        targetValue = if (firstColor) Color.Red else Color.Yellow,
        animationSpec = tween(durationMillis = 4000),
        finishedListener = { showBox = !showBox }
    )

    if (showBox) {
        Box(modifier = Modifier
            .size(100.dp)
            .background(realColor)
            .clickable { firstColor = !firstColor })
    }
}

@Composable
fun SizeAnimation() {
    var context = LocalContext.current
    var smallSize by rememberSaveable {
        mutableStateOf(true)
    }

    val size by animateDpAsState(
        targetValue = if (smallSize) 50.dp else 250.dp,
        animationSpec = tween(1000),
        label = "Animation Size",
        finishedListener = { Toast.makeText(context, "Animation!!!", Toast.LENGTH_SHORT).show() }
    )

    Column() {
        Box(modifier = Modifier
            .size(size)
            .background(Color.DarkGray)
            .clickable { smallSize = !smallSize })
    }
}

@Composable
fun VisibilityAnimation() {
    var isVisible by remember { mutableStateOf(true) }

    Column(Modifier.fillMaxSize()) {
        Button(onClick = { isVisible = !isVisible }) {
            Text(text = "Show/Hide")
        }

        Spacer(Modifier.size(50.dp))

        AnimatedVisibility(
            visible = isVisible,
            enter = slideInHorizontally(),
            exit = slideOutVertically()
        ) {
            Box(modifier = Modifier
                .size(150.dp)
                .background(Color.Red))
        }
    }
}

@Composable
fun CrossFadeExampleAnimation() {
    var myComponentType : ComponentType by remember {
        mutableStateOf(Text)
    }

    Column(Modifier.fillMaxHeight(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
        Button(onClick = {
            myComponentType = getComponentTypeRandom()
        }) {
            Text(text = "Switch component")
        }
    }

    Crossfade(targetState =  myComponentType) {
        val composable = when (it){

            Text -> Text("COMPONENT TEXT!")
            Image -> Icon(Icons.Default.Search, contentDescription = "Icon")
            Box -> Box(
                Modifier
                    .size(150.dp)
                    .background(Color.Red))
            Error -> Text("ERROR MESSAGE!!!")
        }

        CrossFadeComposableContainer(Modifier, randomComposable = { composable })
    }




}

@Composable
fun CrossFadeComposableContainer(modifier : Modifier, randomComposable : () -> Unit) {
    Column(
        Modifier
            .padding(150.dp)
            .fillMaxWidth()) {
        randomComposable
    }
}

fun getComponentTypeRandom(): ComponentType {
    return when (nextInt(from = 0, until = 3)) {
        0 -> ComponentType.Image
        1 -> ComponentType.Text
        2 -> ComponentType.Box
        else -> ComponentType.Error
    }
}

enum class ComponentType() {
    Image, Text, Box, Error
}

