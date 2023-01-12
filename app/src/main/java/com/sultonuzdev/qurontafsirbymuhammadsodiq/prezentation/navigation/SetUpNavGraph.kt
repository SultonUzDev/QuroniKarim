package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.introduction.IntroductionScreen
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah.SurahScreen
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah_details.SurahDetailsScreen

@Composable
fun SetUpNavGraph( navController: NavHostController, startDestination: String) {

    NavHost(navController = navController, startDestination = startDestination) {

        composable(ScreenRoute.Introduction.route) {
            IntroductionScreen(navController)
        }

//        composable(ScreenRoute.Splash.route) {
//            AnimatedSplashScreen(navController = navController)
//        }
        composable(
            ScreenRoute.Surah.route
        ) {

            SurahScreen(navHostController = navController)


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