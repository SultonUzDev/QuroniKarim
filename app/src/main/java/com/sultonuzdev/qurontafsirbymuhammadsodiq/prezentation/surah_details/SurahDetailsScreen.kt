package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah_details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah_details.Aya

@Composable
fun SurahDetailsScreen(
    viewModel: SurahDetailsViewModel = hiltViewModel()
) {
    var ayaList = emptyList<Aya>()
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    )
    {


        if (viewModel.state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
        viewModel.state.error?.let { error ->
            Text(
                text = error,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }
        viewModel.state.surahDetails?.let {
            ayaList =it.result
        }
        LazyColumn {
            items(ayaList) { aya ->
                Text(text = "${aya.aya} \n${aya.arabicText} \n${aya.translation}")

            }
        }




    }

}