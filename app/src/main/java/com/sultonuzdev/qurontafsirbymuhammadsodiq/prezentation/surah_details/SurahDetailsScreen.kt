package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah_details

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.sultonuzdev.qurontafsirbymuhammadsodiq.R
import com.sultonuzdev.qurontafsirbymuhammadsodiq.domain.models.surah.Ayat
import com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.surah.SurahViewModel
import com.sultonuzdev.qurontafsirbymuhammadsodiq.ui.theme.*
import com.sultonuzdev.qurontafsirbymuhammadsodiq.utils.InternetConnection

var isPlaying = false
//var ayaId = 1

@Composable
fun SurahDetailsScreen(
    surahName: String,
    surahId: String,
    viewModel: SurahViewModel = hiltViewModel(),
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

    val context = LocalContext.current
    val mediaItem =
        MediaItem.fromUri("https://cdn.islamic.network/quran/audio/128/ar.alafasy/${aya.id}.mp3")
    val player = provideExoPlayer(context = context, mediaItem = mediaItem)

//    ayaId = aya.id.toInt()



    LaunchedEffect(player) {
        player.prepare()
        player.playWhenReady = false
    }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 4.dp)
    ) {

        var checkPlayStatus by remember {
            mutableStateOf(false)
        }


        val iconPlay = painterResource(id = R.drawable.ic_play)

        val iconPause = painterResource(id = R.drawable.ic_pause)





        player.playWhenReady = true
        player.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(playbackState: Int) {
                if (playbackState == ExoPlayer.STATE_ENDED) {
                    checkPlayStatus = !checkPlayStatus
                    isPlaying = false
                }
            }
        })
        Icon(if (checkPlayStatus) iconPause else iconPlay,
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.End)
                .clickable {
                    val internetConnection = InternetConnection.checkForInternet(context)


                    if (internetConnection) {
                        if (isPlaying) {
                            Toast
                                .makeText(
                                    context,
                                    "Илтимос оят якунлангуча кутинг",
                                    Toast.LENGTH_SHORT
                                )
                                .show()
                        } else {
                            isPlaying = if (checkPlayStatus) {
                                player.pause()
                                false
                            } else {
                                player.play()
                                true
                            }
                            checkPlayStatus = !checkPlayStatus
                        }


                    } else {
                        Toast
                            .makeText(context, "Илтимос интернетга уланишни текширинг", Toast.LENGTH_SHORT)
                            .show()
                    }


                })
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

fun provideExoPlayer(context: Context, mediaItem: MediaItem): ExoPlayer {
    val player = ExoPlayer.Builder(context).build()
    player.setMediaItem(mediaItem)
    return player
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
