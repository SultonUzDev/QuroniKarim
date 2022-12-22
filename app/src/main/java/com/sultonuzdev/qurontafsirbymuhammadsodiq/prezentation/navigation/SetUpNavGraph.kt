package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah.SurahScreen
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah_details.SurahDetailsScreen

@Composable
fun SetUpNavGraph(navController: NavHostController) {

    NavHost(navController = navController, startDestination = ScreenRoute.Surah.route) {
        composable(ScreenRoute.Surah.route) {
            SurahScreen(navHostController = navController)
        }
        composable(ScreenRoute.SurahDetails.route) {
            SurahDetailsScreen()
        }
    }

}