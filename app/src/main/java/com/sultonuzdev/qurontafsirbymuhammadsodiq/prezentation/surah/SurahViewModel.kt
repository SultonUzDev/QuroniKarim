package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultonuzdev.qurontafsirbymuhammadsodiq.data.api.SurahDetailsApi
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository.SurahDetailsRepository
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository.SurahRepository
import com.sultonuzdev.qurontafsirbymuhammadsodiq.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurahViewModel
@Inject constructor(
    private val surahRepository: SurahRepository,
    private val surahDetailsRepository: SurahDetailsRepository
) : ViewModel() {

    val allSurah = surahRepository.getAllSurah()



    var state by mutableStateOf(SurahDetailsState())

//    init {
//        getSurahDetailsById("1")
//    }

    fun getSurahDetailsById(id: String) {
        viewModelScope.launch {

            state = state.copy(surahDetails = null, isLoading = true, error = null)
            val result = surahDetailsRepository.getSurahDetailById(id)
            state = if (result.isSuccessful) {
                state.copy(surahDetails = result.body(), isLoading = false, error = null)
            } else {
                state.copy(
                    surahDetails = null,
                    isLoading = false,
                    error = result.errorBody().toString()
                )

            }

        }

    }

}