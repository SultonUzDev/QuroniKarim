package com.sultonuzdev.qurontafsirbymuhammadsodiq.data.mapper

import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah.AyaWithDetails
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah_details.Aya


fun Aya.mapToAyaDetails(): AyaWithDetails {

    return AyaWithDetails(id, aya, arabicText, footnotes, sura, translation)
}