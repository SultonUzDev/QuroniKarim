package com.sultonuzdev.qurontafsirbymuhammadsodiq.data.repository

import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah.Surah
import com.sultonuzdev.qurontafsirbymuhammadsodiq.data.db.SurahDao
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah.Ayat
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository.SurahRepository
import kotlinx.coroutines.flow.Flow

class SurahRepositoryImpl(private val surahDao: SurahDao) : SurahRepository {
    override fun getAllSurah(): Flow<List<Surah>> {
        return surahDao.getAllSurah()
    }

    override fun getAyasOfSurahBySurahId(surahId: Int): Flow<List<Ayat>> {
        return surahDao.getAyasBySurahId(surahId)
    }
}