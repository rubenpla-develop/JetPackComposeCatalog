package com.rubenpla.jetpackcomposecatalog

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun myBasicSlider() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }
    Column(modifier = Modifier.padding(18.dp)) {
        Slider(value = sliderPosition,
            onValueChange = { sliderPosition = it })

        Text(text = sliderPosition.toString())
    }

}

@Composable
fun myAdvanceSlider() {
    var sliderPosition by remember {
        mutableStateOf(0f)
    }

    var completeValue by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.padding(18.dp)) {
        Slider(value = sliderPosition,
            onValueChange = {
                sliderPosition = it
                completeValue = it.toInt().toString()
            },
            valueRange = 0f..20f,
            steps = 18,
            onValueChangeFinished = {
                completeValue = sliderPosition.toInt().toString()
            })

        Text(text = completeValue)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myRangeSlider() {
    var currentRange by remember {
        mutableStateOf(0f..10f)
    }

    var completeValue by remember {
        mutableStateOf("")
    }

    Column(modifier = Modifier.padding(18.dp)) {
        RangeSlider(value = currentRange,
            onValueChange = {
                currentRange = it
            },
            valueRange = 0f..10f,
            steps = 9
        )

        Text(text = "Value less than ${currentRange.start}")
        Text(text = "Value higher than ${currentRange.endInclusive}")


    }
}