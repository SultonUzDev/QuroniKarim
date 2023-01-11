package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.introduction

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultonuzdev.qurontafsirbymuhammadsodiq.data.prefrences.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroductionViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    fun saveIntroductionState(introduced: Boolean) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.saveStateOfIntroduction(introduced = introduced)
        }
    }

}