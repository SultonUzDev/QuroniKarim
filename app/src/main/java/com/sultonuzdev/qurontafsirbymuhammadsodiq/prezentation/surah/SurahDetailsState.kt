package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah

import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah_details.SurahDetails

data class SurahDetailsState(
    val surahDetails: SurahDetails? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
