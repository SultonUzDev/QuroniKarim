package com.sultonuzdev.qurontafsirbymuhammadsodiq.data.db

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SurahDao {


    @Query("Select * from surahs")
    fun getAllSurah(): Flow<List<Surah>>
}