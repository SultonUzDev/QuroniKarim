@file:Suppress("DEPRECATION")

package com.sultonuzdev.qurontafsirbymuhammadsodiq.utils

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager

val Context.isConnected: Boolean
    @SuppressLint("ServiceCast")
    get() {
        return (getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager)
            .activeNetworkInfo?.isConnected == true
    }