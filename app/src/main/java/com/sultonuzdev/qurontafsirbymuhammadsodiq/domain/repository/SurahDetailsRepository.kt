package com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository

import com.google.gson.JsonObject
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah_details.SurahDetails
import com.sultonuzdev.qurontafsirbymuhammadsodiq.utils.Resource
import org.json.JSONObject

interface SurahDetailsRepository {

        suspend fun getSurahDetailById(surahId: String): SurahDetails
}