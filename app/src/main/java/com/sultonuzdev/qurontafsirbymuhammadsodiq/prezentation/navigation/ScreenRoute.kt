package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.navigation

sealed class ScreenRoute(val route: String) {
    object Splash : ScreenRoute("splash")
    object Surah : ScreenRoute("surah")
    object SurahDetails : ScreenRoute("surah_details")
}
