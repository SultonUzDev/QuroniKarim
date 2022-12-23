package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah_details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository.SurahDetailsRepository
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah.SurahDetailsState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurahDetailsViewModel @Inject constructor(
    private val surahDetailsRepository: SurahDetailsRepository
) : ViewModel() {

    var state by mutableStateOf(SurahDetailsState())
init {
    getSurahDetailsById("1")
}

    private fun getSurahDetailsById(id: String) {
        viewModelScope.launch {

            state = state.copy(surahDetails = null, isLoading = true, error = null)
            val result = surahDetailsRepository.getSurahDetailById(id)
            state = state.copy(surahDetails = result, isLoading = false, error = null)


        }

    }

}