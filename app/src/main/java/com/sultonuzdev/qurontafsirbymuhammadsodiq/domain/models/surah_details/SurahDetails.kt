package com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah_details

import com.google.gson.annotations.SerializedName

data class SurahDetails(
    @SerializedName("result")
    val result: List<Aya>? =null
)