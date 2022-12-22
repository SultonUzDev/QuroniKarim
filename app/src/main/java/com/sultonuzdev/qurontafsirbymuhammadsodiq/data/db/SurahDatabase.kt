package com.sultonuzdev.qurontafsirbymuhammadsodiq.data.db

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [Surah::class], version = 1)
abstract class SurahDatabase() : RoomDatabase() {
    abstract val surahDao: SurahDao
}