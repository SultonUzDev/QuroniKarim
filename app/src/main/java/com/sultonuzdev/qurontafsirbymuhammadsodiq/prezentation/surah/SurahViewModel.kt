package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository.SurahRepository
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah_details.AyasState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SurahViewModel
@Inject constructor(
    private val surahRepository: SurahRepository,
) : ViewModel() {

    val allSurah = surahRepository.getAllSurah()

    private val _state = mutableStateOf(AyasState())
    val state: State<AyasState> = _state

    private var getAyaJob: Job? = null
    fun getSurahDetailsById(id: Int) {
        getAyaJob?.cancel()
        getAyaJob = surahRepository.getAyasOfSurahBySurahId(id).onEach { ayas ->
            try {
                _state.value = state.value.copy(ayaList = ayas, error = null)

            } catch (e: Exception) {
                _state.value = state.value.copy(ayaList = null, error = e.message)

            }
        }.launchIn(viewModelScope)


    }

}