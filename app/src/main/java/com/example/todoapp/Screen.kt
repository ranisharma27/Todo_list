package com.example.todoapp

sealed class Screen(val route: String){
    object Splash: Screen("Splash_Screen")
    object Home: Screen("Home_Screen")
}