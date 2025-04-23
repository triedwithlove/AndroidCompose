package com.koueka.transactionhistory.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes


/**
 * A data class to represent the information presented in the Transaction card
 */
data class Transaction(
    @DrawableRes
    val profilePictureId: Int,

    @StringRes
    val userName: Int,

    val sent: String,
    val received: String,
    val fullName: String,
    val date: String,
    val town: String,
    val phone: String,

    @DrawableRes
    val status: Int
)
