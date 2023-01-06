package com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ayas")
data class AyaWithDetails(
    @PrimaryKey
    @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "aya") val aya: String,
    @ColumnInfo(name = "arabic_text") val arabicText: String,
    @ColumnInfo(name = "footnotes") val footnotes: String? = "",
    @ColumnInfo(name = "sura") val sura: String,
    @ColumnInfo(name = "translation") val translation: String
)