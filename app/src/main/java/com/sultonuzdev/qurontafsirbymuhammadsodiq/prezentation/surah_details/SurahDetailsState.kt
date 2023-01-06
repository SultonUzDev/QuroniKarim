package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah_details

import com.google.gson.JsonObject
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah_details.SurahDetails
import org.json.JSONObject

data class SurahDetailsState(
    val surahDetails: SurahDetails? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
