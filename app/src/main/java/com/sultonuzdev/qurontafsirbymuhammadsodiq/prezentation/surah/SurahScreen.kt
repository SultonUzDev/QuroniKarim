package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sultonuzdev.qurontafsirbymuhammadsodiq.data.db.Surah

@Composable

fun SurahScreen(
    navHostController: NavHostController,
    surahViewModel: SurahViewModel = hiltViewModel()
) {
    val allSurah by surahViewModel.allSurah.collectAsState(initial = emptyList())


    Column(Modifier.fillMaxSize()) {
        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            items(allSurah) { surah ->
                SurahRow(surah = surah)
                Spacer(modifier = Modifier.height(1.dp))
            }
        }

    }

}


@Composable
fun SurahRow(surah: Surah) {


    Box(Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        Text(

            text = surah.id.toString(),
            modifier = Modifier
                .fillMaxWidth(0.2f)
                .height(40.dp)
                .background(Color.Green)
                .align(Alignment.CenterStart)
                .padding(2.dp),
            textAlign = TextAlign.Center,

            )

        Text(
            text = surah.surahName, textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight()
                .background(Color.Yellow)
                .padding(2.dp)
                .align(Alignment.Center)
        )

        Text(
            text = surah.ayatCount.toString(), textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.3f)
                .background(Color.Gray)
                .padding(2.dp)
                .align(Alignment.CenterEnd)

        )


    }

}