package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.navigation

import android.content.Context
import android.util.Log
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

        composable(
            route = ScreenRoute.SurahDetails.route + "/{surahId}/{surahName}",
            arguments = listOf(
                navArgument(name = "surahId") {
                    type = NavType.StringType
                },
                navArgument(name = "surahName") {
                    type = NavType.StringType
                }
            )

        ) { navBack ->

            navBack.arguments?.let { bundle ->
                val surahId = bundle.getString("surahId")
                val surahName = bundle.getString("surahName")
                surahId?.let { id ->
                    surahName?.let {
                        SurahDetailsScreen(
                            it,
                            id,
                        )
                    }
                }

            }

        }
    }

}