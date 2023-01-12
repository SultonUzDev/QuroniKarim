package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah.Surah
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.navigation.ScreenRoute
import com.sultonuzdev.qurontafsirbymuhammadsodiq.ui.theme.*
import com.sultonuzdev.qurontafsirbymuhammadsodiq.R

@Composable
fun SurahScreen(
    navHostController: NavHostController,
    surahViewModel: SurahViewModel = hiltViewModel()
) {
    val context: Context = LocalContext.current

    val allSurah by surahViewModel.allSurah.collectAsState(initial = emptyList())

    val colors = listOf(
        Color1,
        Color2,
        Color3,
        )
    Column(
        Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(colors)
            )
    ) {


        LazyColumn(horizontalAlignment = Alignment.CenterHorizontally) {
            item {
                HeaderScreen()
            }

            items(allSurah) { surah ->
                Divider(
                    thickness = 1.dp,
                    color = Color.Gray,
                    modifier = Modifier.padding(2.dp)
                )
                SurahRow(surah = surah, navHostController, context)


            }
        }

    }

}

@Composable
fun HeaderScreen() {
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
            text = stringResource(id = R.string.suralar),
            modifier = Modifier
                .align(Alignment.Center),
            fontFamily = FontFamily(Font(R.font.kamikom)),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.SemiBold,
            color = ColorTextHeader,


            )
    }

}

@Preview
@Composable
fun HeaderPreview() {
    HeaderScreen()
}

@Composable
fun SurahRow(
    surah: Surah,
    navHostController: NavHostController,
    context: Context,
) {


    Row(
        Modifier
            .fillMaxWidth()
            .clickable {

                navHostController.navigate(
                    ScreenRoute.SurahDetails.route
                            + "/{surahId}".replace(
                        oldValue = "{surahId}",
                        newValue = surah.id.toString()
                    ) + "/{surahName}".replace(
                        oldValue = "{surahName}",
                        newValue = surah.surahName
                    )
                )


            }, verticalAlignment = Alignment.CenterVertically
    ) {
        ImageTextView(surah.id.toString())
        SurahInfoScreen(surah = surah)

    }

}

@Composable
fun SurahInfoScreen(surah: Surah) {

    Column {
        Text(
            text = surah.surahName, textAlign = TextAlign.Center, color = ColorSurah,
            modifier = Modifier.padding(start = 16.dp, top = 4.dp, bottom = 4.dp),
            fontSize = 18.sp,
            fontFamily = FontFamily.SansSerif,
            fontWeight = FontWeight.SemiBold
        )
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = ColorTextHeader,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append(text = surah.ayatCount.toString())
                }
                append(" " + stringResource(id = R.string.count_desc) + ", ")
                withStyle(
                    style = SpanStyle(
                        color = ColorTextHeader,
                        fontWeight = FontWeight.SemiBold
                    )
                ) {
                    append(" " + surah.place)
                }
            },
            modifier = Modifier
                .padding(start = 16.dp, top = 4.dp, bottom = 4.dp),
            textAlign = TextAlign.Start,
            fontWeight = FontWeight.Normal,
            fontFamily = FontFamily.Serif,
            fontSize = 14.sp,
            color = ColorText
        )

    }

}

@Composable
fun ImageTextView(id: String) {
    Box(
        modifier = Modifier
            .size(52.dp)
            .padding(start = 10.dp, end = 4.dp, top = 2.dp, bottom = 2.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.octagon),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize(),
            alignment = Alignment.Center
        )
        Text(
            text = id,
            modifier = Modifier
                .align(Alignment.Center), textAlign = TextAlign.Center,
            color = ColorTextHeader, fontFamily = FontFamily(Font(R.font.junegull))

        )
    }


}



