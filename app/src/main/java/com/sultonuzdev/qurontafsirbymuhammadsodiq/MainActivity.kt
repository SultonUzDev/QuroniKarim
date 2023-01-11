package com.sultonuzdev.qurontafsirbymuhammadsodiq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.navigation.SetUpNavGraph
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.splash.SplashViewModel
import com.sultonuzdev.qurontafsirbymuhammadsodiq.ui.theme.QuronTafsirByMuhammadSodiqTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    @Inject
    lateinit var splashViewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        installSplashScreen().setKeepOnScreenCondition {
            !splashViewModel.isLoading.value
        }

        setContent {
            QuronTafsirByMuhammadSodiqTheme {
                Box(modifier = Modifier.fillMaxSize()) {
                    val screen by splashViewModel.startDestination
                    val navController = rememberNavController()
                    SetUpNavGraph(
                        navController = navController, startDestination = screen
                    )
                }


            }
        }
    }


}

