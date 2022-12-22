package com.sultonuzdev.qurontafsirbymuhammadsodiq.data.api

import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah_details.SurahDetails
import retrofit2.http.GET
import retrofit2.http.Path

interface SurahDetailsApi {

    @GET("")
    suspend fun getSurahDetails(@Path("id") surahId: String):SurahDetails
}