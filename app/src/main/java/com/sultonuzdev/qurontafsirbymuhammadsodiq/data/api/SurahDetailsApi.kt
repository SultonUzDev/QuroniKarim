package com.sultonuzdev.qurontafsirbymuhammadsodiq.data.api

import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah_details.SurahDetails
import com.sultonuzdev.qurontafsirbymuhammadsodiq.utils.Resource
import org.json.JSONObject
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface SurahDetailsApi {
    @Headers("Content-Type: application/json")
    @GET("{id}")
    suspend fun getSurahDetails(@Path("id") surahId: String):SurahDetails
}