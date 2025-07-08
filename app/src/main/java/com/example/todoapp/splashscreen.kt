package com.example.todoapp

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay

@Composable
fun AnimatedSplashScreen(navController: NavHostController){
    var startAnimation by remember {
        mutableStateOf(false)
    }
    val alphanim= animateFloatAsState(
        targetValue = if(startAnimation) 1f else 0f,
        animationSpec = tween(
           durationMillis = 3000
        )
    )

    LaunchedEffect(Unit) {

        startAnimation=true

        delay(4000) // Simulate a splash screen delay
        navController.navigate(Screen.Home.route) // Navigate to Home after delay
    }

    splashscreen(alpha= alphanim.value)
}

@Composable
fun splashscreen(alpha: Float) {
    Image(painter= painterResource(id= R.drawable.login_blur),
        contentDescription="background",
        modifier = Modifier.fillMaxSize(),
        contentScale = ContentScale.Crop)

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(180.dp))
        Image(painter = painterResource(id=R.drawable.pngtree_learningwritinghomeworkreadingtaking_4577554), contentDescription = null)
        Text(text="ToDo for Today", style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color= Color(0xFFFFF5E1)
        )
    }

}