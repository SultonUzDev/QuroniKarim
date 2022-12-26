package com.sultonuzdev.qurontafsirbymuhammadsodiq.data.repository

import com.sultonuzdev.qurontafsirbymuhammadsodiq.data.api.SurahDetailsApi
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah_details.SurahDetails
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository.SurahDetailsRepository
import com.sultonuzdev.qurontafsirbymuhammadsodiq.utils.Resource
import org.json.JSONObject
import retrofit2.Response
import javax.inject.Inject

class SurahDetailsRepositoryImpl @Inject constructor(
    private val api: SurahDetailsApi
) : SurahDetailsRepository {
    override suspend fun getSurahDetailById(surahId: String): Resource<SurahDetails> {

        return try {
            Resource.Success(data = api.getSurahDetails(surahId))
        } catch (e: Exception) {
            Resource.Error(data = null, message = e.message)
        }

    }
}