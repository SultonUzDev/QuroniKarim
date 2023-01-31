package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.navigation

sealed class ScreenRoute(val route: String) {
    object Introduction : ScreenRoute("introduction")
    object Surah : ScreenRoute("surah")
    object SurahDetails : ScreenRoute("surah_details")
}
