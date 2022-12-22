package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah

import androidx.lifecycle.ViewModel
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository.SurahRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SurahViewModel
@Inject constructor(
    private val surahRepository: SurahRepository
) : ViewModel() {

    val allSurah = surahRepository.getAllSurah()

}