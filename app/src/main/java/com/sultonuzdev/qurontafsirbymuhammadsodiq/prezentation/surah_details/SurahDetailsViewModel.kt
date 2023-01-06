package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah_details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah.AyaWithDetails
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah_details.Aya
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository.SurahDetailsRepository
import com.sultonuzdev.qurontafsirbymuhammadsodiq.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurahDetailsViewModel @Inject constructor(
    private val surahDetailsRepository: SurahDetailsRepository
) : ViewModel() {

    var state by mutableStateOf(SurahDetailsState())

    fun getSurahDetailsById(id: String) {
        viewModelScope.launch {
            val result = surahDetailsRepository.getSurahDetailById(id)
            state = state.copy(surahDetails = null, isLoading = true, error = null)
            state = when (result) {
                is Resource.Success -> {
                    state.copy(surahDetails = result.data, isLoading = false, error = null)
                }
                is Resource.Error -> {
                    state.copy(surahDetails = null, isLoading = false, error = result.message)
                }
            }

        }

    }

    fun saveAya(aya: AyaWithDetails) {
        viewModelScope.launch {
            surahDetailsRepository.saveAyaInDb(aya)
        }
    }
}