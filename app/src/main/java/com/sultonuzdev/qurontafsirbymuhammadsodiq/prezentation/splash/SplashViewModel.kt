package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.splash

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sultonuzdev.qurontafsirbymuhammadsodiq.data.prefrences.DataStoreRepository
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.navigation.ScreenRoute
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {
    private val _isLoading: MutableState<Boolean> = mutableStateOf(true)
    val isLoading: State<Boolean> = _isLoading


    private val _startDestination: MutableState<String> = mutableStateOf(ScreenRoute.Surah.route)
    val startDestination: State<String> = _startDestination

    init {
        viewModelScope.launch {
            repository.readStateOfIntroduction().collect { completed ->
                Log.d("mlog", "Completed: $completed")
                if (completed) {

                    _startDestination.value = ScreenRoute.Surah.route
                } else {
                    _startDestination.value = ScreenRoute.Introduction.route
                }
            }
            _isLoading.value = false
        }
    }

}