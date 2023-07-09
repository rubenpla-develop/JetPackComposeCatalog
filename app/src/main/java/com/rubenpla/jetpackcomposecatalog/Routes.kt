package com.rubenpla.jetpackcomposecatalog

sealed class Routes(val route: String) {
    object ScreenOne : Routes("ScreenOne")
    object ScreenTwo : Routes("ScreenTwo")
    object ScreenThree : Routes("ScreenThree")
    object ScreenFour : Routes("ScreenFour")
}
