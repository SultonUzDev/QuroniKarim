package com.sultonuzdev.qurontafsirbymuhammadsodiq.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "surahs")
data class Surah(
    @PrimaryKey()
    @ColumnInfo(name = "_id") var id: Int,
    @ColumnInfo(name = "surah_name") var surahName: String,
    @ColumnInfo(name = "aya_count") var ayatCount: Int,
    @ColumnInfo(name = "written_place") var place: String,
)