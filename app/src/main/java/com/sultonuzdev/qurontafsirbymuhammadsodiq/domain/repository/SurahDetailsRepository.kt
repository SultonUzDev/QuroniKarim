package com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository

import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah_details.SurahDetails

interface SurahDetailsRepository {

    suspend fun getSurahDetailById(surahId: String): SurahDetails
}