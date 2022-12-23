package com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah_details

import com.google.gson.annotations.SerializedName

data class Aya(

    @SerializedName("aya")
    val aya: String,
    @SerializedName("arabic_text")
    val arabicText: String,
    @SerializedName("footnotes")
    val footnotes: String,
    @SerializedName("id")
    val id: String,
    @SerializedName("sura")
    val sura: String,
    @SerializedName("translation")
    val translation: String
)