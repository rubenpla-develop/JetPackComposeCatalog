package com.rubenpla.jetpackcomposecatalog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.rubenpla.jetpackcomposecatalog.model.SuperHero

@Composable
fun ScreenOne(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {

        ItemConstraintHero(
            Modifier.align(alignment = Alignment.Center),
            superHero = SuperHero(
                "The Witcher",
                "Geralt De Rivia",
                "Cd Projekt Red",
                R.drawable.geralt
            )
        ) {}

        Button(modifier = Modifier.padding(start = 16.dp, top = 16.dp), onClick = {
            navigationController.navigate("ScreenTwo")
        }) {
            Text(text = "Go to ScreenTwo")
        }
    }
}

@Composable
fun ScreenTwo(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        ItemConstraintHero(
            Modifier.align(alignment = Alignment.Center),
            superHero = SuperHero(
                "Batman",
                "Bruce Wayne",
                "DC",
                R.drawable.batman
            )
        ) {}

        Button(modifier = Modifier.padding(start = 16.dp, top = 16.dp), onClick = {
            navigationController.navigate("ScreenThree")
        }) {
            Text(text = "Go to ScreenThree")
        }
    }
}

@Composable
fun ScreenThree(navigationController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        ItemConstraintHero(
            Modifier.align(alignment = Alignment.Center),
            superHero = SuperHero(
                "SpiderMan",
                "Peter Parker",
                "marvel",
                R.drawable.spiderman
            )
        ) {}

        Button(modifier = Modifier.padding(start = 16.dp, top = 16.dp), onClick = {
            navigationController.navigate("ScreenOne")
        }) {
            Text(text = "Come back to ScreenThree ")
        }
    }
}