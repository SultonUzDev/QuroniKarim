package com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository

import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah.Surah
import kotlinx.coroutines.flow.Flow

interface SurahRepository {

    fun getAllSurah(): Flow<List<Surah>>
}