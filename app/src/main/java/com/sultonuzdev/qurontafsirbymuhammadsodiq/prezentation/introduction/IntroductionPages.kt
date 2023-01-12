package com.sultonuzdev.qurontafsirbymuhammadsodiq.prezentation.introduction

import android.annotation.SuppressLint
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.sultonuzdev.qurontafsirbymuhammadsodiq.R

sealed class IntroductionPages(
    @DrawableRes
    val image: Int,
    @StringRes
    val title: Int,
    @StringRes
    val desc: Int
) {
    object First : IntroductionPages(
        image = R.drawable.ic_first,
        title = R.string.first,
        desc = R.string.first_desc
    )

    object Second : IntroductionPages(
        image = R.drawable.ic_second,
        title = R.string.second,
        desc = R.string.second_desc
    )

    object Third : IntroductionPages(
        image = R.drawable.ic_third,
        title = R.string.third,
        desc = R.string.third_desc
    )


}