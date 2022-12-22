package com.sultonuzdev.qurontafsirbymuhammadsodiq.data.repository

import com.sultonuzdev.qurontafsirbymuhammadsodiq.data.db.Surah
import com.sultonuzdev.qurontafsirbymuhammadsodiq.data.db.SurahDao
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository.SurahRepository
import kotlinx.coroutines.flow.Flow

class SurahRepositoryImpl(private val surahDao: SurahDao) : SurahRepository {
    override fun getAllSurah(): Flow<List<Surah>> {
        return surahDao.getAllSurah()
    }
}