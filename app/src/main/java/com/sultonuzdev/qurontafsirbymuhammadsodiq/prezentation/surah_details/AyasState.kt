package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah_details

import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah.Ayat

data class AyasState(
    val ayaList: List<Ayat>? = null,
    val error: String? = null
)