package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.splash

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.sultonuzdev.qurontafsirbymuhammadsodiq.R
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.navigation.ScreenRoute
import com.sultonuzdev.qurontafsirbymuhammadsodiq.ui.theme.Color1
import com.sultonuzdev.qurontafsirbymuhammadsodiq.ui.theme.ColorPrimaryDark
import com.sultonuzdev.qurontafsirbymuhammadsodiq.ui.theme.ColorTextHeader
import kotlinx.coroutines.delay


@Composable
fun AnimatedSplashScreen(navController: NavHostController) {
    var startAnim by remember { mutableStateOf(false) }
    val alphaAnim = animateFloatAsState(
        targetValue = if (startAnim) 1f else 0f,
        animationSpec = tween(durationMillis = 1000)
    )

    LaunchedEffect(key1 = true) {
        startAnim = true
        delay(3000)
        navController.popBackStack()
        navController.navigate(ScreenRoute.Surah.route)
    }
    SplashScreen(alphaAnim.value)

}

@Composable
fun SplashScreen(alpha: Float) {


    Column(
        Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.purple_700)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.6f)
                .alpha(alpha)
                .padding(16.dp),
            painter = painterResource(id = R.drawable.logo),
        )
        Text(
            text = stringResource(id = R.string.app_description),
            color = ColorTextHeader,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily(Font(R.font.kamikom)),
            fontSize = 20.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .alpha(alpha)
                .fillMaxWidth(0.8f)
                .fillMaxHeight(0.4f)
        )


    }

}