package com.koueka.superheroes.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

/**
 * A data class to represent the information presented in the Hero card/item
 */

data class Hero(
    @StringRes
    val nameRes: Int,

    @StringRes
    val descriptionRes: Int,

    @DrawableRes
    val imageRes: Int
)
