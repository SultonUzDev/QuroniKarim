package com.sultonuzdev.qurontafsirbymuhammadsodiq.data.db

import androidx.room.Dao
import androidx.room.Query
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah.Surah
import kotlinx.coroutines.flow.Flow

@Dao
interface SurahDao {


    @Query("SELECT * FROM suralar")
    fun getAllSurah(): Flow<List<Surah>>
}