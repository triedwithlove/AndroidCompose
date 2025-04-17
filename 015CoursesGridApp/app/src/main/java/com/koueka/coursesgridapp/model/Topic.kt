package com.koueka.coursesgridapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes
    val stringResourceId: Int,
    val taken: Int,

    @DrawableRes
    val imageResourceId: Int
)
