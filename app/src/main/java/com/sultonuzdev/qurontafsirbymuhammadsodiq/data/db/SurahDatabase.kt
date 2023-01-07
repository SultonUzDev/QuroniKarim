package com.sultonuzdev.qurontafsirbymuhammadsodiq.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah.Ayat
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah.Surah


@Database(entities = [Surah::class, Ayat::class], version = 1, exportSchema = false)
abstract class SurahDatabase() : RoomDatabase() {
    abstract val surahDao: SurahDao
}