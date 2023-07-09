package com.rubenpla.jetpackcomposecatalog

sealed class Routes(val route: String) {
    object ScreenOne : Routes("ScreenOne")
    object ScreenTwo : Routes("ScreenTwo")
    object ScreenThree : Routes("ScreenThree")
    object ScreenFour : Routes("ScreenFour/{age}") {
        fun createRoute(age : Int) = "ScreenFour/$age"
    }
    object ScreenFive : Routes("ScreenFive?name={name}") {
        fun createRoute(name : String) = "ScreenFive?name=$name"
    }
}
