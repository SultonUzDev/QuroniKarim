package com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah_details

import com.google.gson.annotations.SerializedName

data class Aya(

    @SerializedName("aya")
    val aya: String? =null,
    @SerializedName("footnotes")
    val footnotes: String? =null,
    @SerializedName("id")
    val id: String? =null,
    @SerializedName("sura")
    val sura: String? =null,
    @SerializedName("translation")
    val translation: String? =null
)