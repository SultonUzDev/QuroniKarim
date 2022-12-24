package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.navigation

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.splash.AnimatedSplashScreen
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah.SurahScreen
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah_details.SurahDetailsScreen

@Composable
fun SetUpNavGraph(context: Context, navController: NavHostController) {

    NavHost(navController = navController, startDestination = ScreenRoute.Splash.route) {
        composable(ScreenRoute.Splash.route) {
            AnimatedSplashScreen(navController = navController)
        }
        composable(
            ScreenRoute.Surah.route
        ) {

            SurahScreen(navHostController = navController, context = context)


        }

        /*+ "/{surahId}",
            arguments = listOf(navArgument("surahId") {
                type =
                    NavType.StringType
            })*/
        composable(ScreenRoute.SurahDetails.route
        ) {

//            val surahId = navBack.arguments?.getString("surahId")
//            surahId?.let {
                SurahDetailsScreen()
//            }
        }
    }

}