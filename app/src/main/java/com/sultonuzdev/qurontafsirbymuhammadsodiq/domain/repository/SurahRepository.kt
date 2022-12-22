package com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository

import com.sultonuzdev.qurontafsirbymuhammadsodiq.data.db.Surah
import kotlinx.coroutines.flow.Flow

interface SurahRepository {

    fun getAllSurah(): Flow<List<Surah>>
}