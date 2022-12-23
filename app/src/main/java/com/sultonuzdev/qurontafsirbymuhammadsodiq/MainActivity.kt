package com.sultonuzdev.qurontafsirbymuhammadsodiq

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.google.gson.GsonBuilder
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah_details.SurahDetails
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.navigation.SetUpNavGraph
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah.SurahViewModel
import com.sultonuzdev.qurontafsirbymuhammadsodiq.ui.theme.QuronTafsirByMuhammadSodiqTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuronTafsirByMuhammadSodiqTheme {
                Box(modifier = Modifier.fillMaxSize()) {

                    SetUpNavGraph(navController = rememberNavController())
                }


            }
        }
    }


}

