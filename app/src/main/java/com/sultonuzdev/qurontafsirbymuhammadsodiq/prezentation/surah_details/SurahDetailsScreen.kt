package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah_details

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.sultonuzdev.qurontafsirbymuhammadsodiq.R
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah.Ayat
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah.SurahViewModel
import com.sultonuzdev.qurontafsirbymuhammadsodiq.ui.theme.*

@Composable
fun SurahDetailsScreen(
    surahName: String, surahId: String, viewModel: SurahViewModel = hiltViewModel()
) {
    val colors = listOf(
        Color3, Color1, Color2, Color4


    )
    var ayaList = emptyList<Ayat>()
    viewModel.getSurahDetailsById(surahId.toInt())


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(colors)
            )
    ) {

        viewModel.state.value.error?.let { error ->
            Text(
                text = error,
                color = Color.Red,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(
                    Alignment.Center
                )
            )
        }
        viewModel.state.value.ayaList?.let {
            ayaList = it
        }


        LazyColumn(Modifier.fillMaxSize()) {
            item { HeaderScreen(name = surahName) }
            items(ayaList) { aya ->
                Divider(
                    thickness = 1.dp,
                    color = Color.Gray,
                    modifier = Modifier.padding(vertical = 8.dp)
                )

                SurahDetailsItemRow(aya = aya)
            }
        }


    }

}


@Composable
fun HeaderScreen(name: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
    ) {
        Image(
            contentDescription = null,
            alignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center),
            painter = painterResource(id = R.drawable.top_bar),


            )
        Text(
            text = name,
            modifier = Modifier.align(Alignment.Center),
            fontFamily = FontFamily(Font(R.font.kamikom)),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            color = ColorTextHeader,


            )
    }

}

@Composable
fun SurahDetailsItemRow(aya: Ayat) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
    ) {

        MainRowInItemView(aya = aya)
        Text(
            text = aya.translation,
            textAlign = TextAlign.Start,
            fontSize = 16.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            fontFamily = FontFamily(Font(R.font.kamikom)),
            color = ColorAya
        )


        if (!aya.footnotes.isNullOrEmpty()) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Blue, fontWeight = FontWeight.SemiBold
                        )
                    ) {
                        append("Изоҳ: ")
                    }
                    withStyle(style = SpanStyle(color = ColorAyaDesc)) {
                        append(aya.footnotes)
                    }

                },
                modifier = Modifier.padding(4.dp), fontSize = 14.sp,
            )
        }


    }

}

@Composable
fun MainRowInItemView(aya: Ayat) {
    Row(Modifier.fillMaxWidth()) {
        val id = aya.sura + "/" + aya.aya
        ImageTextViewForDetailsRow(id = id)
        Text(
            text = aya.arabicText,
            textAlign = TextAlign.End,
            fontSize = 20.sp,
            modifier = Modifier
                .fillMaxWidth()
                .align(alignment = Alignment.CenterVertically),
            color = Color.Black,
            letterSpacing = 1.sp,
            fontWeight = FontWeight.SemiBold

        )

    }
}

@Composable
fun ImageTextViewForDetailsRow(id: String) {
    Box(
        modifier = Modifier
            .size(70.dp)
            .padding(4.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.ocatagon_surah_details),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            alignment = Alignment.Center
        )
        Text(
            text = id,
            modifier = Modifier.align(Alignment.Center),
            textAlign = TextAlign.Center,
            color = ColorTextHeader,
            fontFamily = FontFamily(Font(R.font.junegull)),
            fontSize = 12.sp

        )
    }


}
