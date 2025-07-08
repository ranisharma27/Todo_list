package com.example.todoapp

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.delay

@Composable
fun SetupNavGraph(navController: NavHostController, todoViewModel: TodoViewModel) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        // Splash Screen
        composable(route = Screen.Splash.route) {
            AnimatedSplashScreen(navController)
        }

        // Home Screen
        composable(route = Screen.Home.route) {
            TodoListPage(todoViewModel) // Pass the ViewModel to the TodoListPage
        }
    }
}
