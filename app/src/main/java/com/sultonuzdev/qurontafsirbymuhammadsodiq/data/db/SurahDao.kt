package com.sultonuzdev.qurontafsirbymuhammadsodiq.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah.AyaWithDetails
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah.Surah
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah_details.Aya
import kotlinx.coroutines.flow.Flow

@Dao
interface SurahDao {


    @Query("SELECT * FROM suralar")
    fun getAllSurah(): Flow<List<Surah>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSurahIntoDb(vararg aya: AyaWithDetails)


}