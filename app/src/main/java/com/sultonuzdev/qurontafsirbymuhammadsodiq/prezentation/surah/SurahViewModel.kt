package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultonuzdev.qurontafsirbymuhammadsodiq.data.api.SurahDetailsApi
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository.SurahDetailsRepository
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.repository.SurahRepository
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

    private val _state = mutableStateOf(SurahDetailsState())
    val state: State<SurahDetailsState> = _state

    init {
        getSurahDetailsById("1")
    }

    fun getSurahDetailsById(id: String): State<SurahDetailsState> {
        viewModelScope.launch {
            _state.value = state.value.copy(surahDetails = null, isLoading = true, error = null)
            _state.value = state.value.copy(
                surahDetails = surahDetailsRepository.getSurahDetailById(id),
                isLoading = false,
                error = null
            )


        }

        return state
    }

}