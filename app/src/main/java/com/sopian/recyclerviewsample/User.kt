package com.sopian.recyclerviewsample

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val name: String,
    val phone: Long
) : Parcelable