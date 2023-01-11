package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.introduction

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sultonuzdev.qurontafsirbymuhammadsodiq.R

@SuppressLint("SupportAnnotationUsage")
sealed class IntroductionPages(
    @DrawableRes
    val image: Int,
    @StringRes
    val title: String,
    @StringRes
    val desc: String
) {
    object First : IntroductionPages(
        image = R.drawable.logo,
        title = "Bir",
        desc = "Bir decs"
    )

    object Second : IntroductionPages(
        image = R.drawable.logo,
        title = "IKKI",
        desc = "IKKI IKKI"
    )

    object Third : IntroductionPages(
        image = R.drawable.logo,
        title = "UCH",
        desc = "Bir ikki uch"
    )
}