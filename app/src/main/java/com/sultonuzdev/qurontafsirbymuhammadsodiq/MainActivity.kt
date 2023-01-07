package com.sultonuzdev.qurontafsirbymuhammadsodiq

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.navigation.SetUpNavGraph
import com.sultonuzdev.qurontafsirbymuhammadsodiq.ui.theme.QuronTafsirByMuhammadSodiqTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuronTafsirByMuhammadSodiqTheme {
                Box(modifier = Modifier.fillMaxSize()) {

                    SetUpNavGraph(
                        context = this@MainActivity,
                        navController = rememberNavController()
                    )
                }


            }
        }
    }


}

