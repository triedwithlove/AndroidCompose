package com.koueka.transactionhistory.data

import com.koueka.transactionhistory.R
import com.koueka.transactionhistory.model.Transaction


object TrxnRepository {
    val transaction: Transaction = Transaction(
        profilePictureId = R.drawable.user_kompina,
        userName = R.string.user_kompina,
        sent = "Sent: \$117.46",
        received = "51,000",
        fullName = "Kompina MBANGA DLA",
        date = "2025/02/15",
        town = "Douala",
        phone = "(+237) 6 99 85 65 21",
        status = R.drawable.trxn_ph2_check_s2_progress
    )

    val trxnList: List<Transaction> = listOf(
        //1
        Transaction(
            profilePictureId = R.drawable.user_default,
            userName = R.string.user_woman_f,
            sent = "Sent: \$351.99",
            received = "115,000",
            fullName = "Fashion Brand Woman",
            date = "2024/12/20",
            town = "Bafoussam",
            phone = "(+237) 6 75 02 56 12",
            status = R.drawable.trxn_ph2_check_s2_progress
        ),
        //2
        Transaction(
            profilePictureId = R.drawable.user_kompina,
            userName = R.string.user_kompina,
            sent = "Sent: \$117.46",
            received = "51,000",
            fullName = "Kompina MBANGA DLA",
            date = "2025/02/15",
            town = "Douala",
            phone = "(+237) 6 99 85 65 21",
            status = R.drawable.trxn_ph3_delivery_s1_init
        ),
        //3
        Transaction(
            profilePictureId = R.drawable.user_uriel_aude,
            userName = R.string.user_uriel_aude,
            sent = "Sent: \$10.00",
            received = "4,135",
            fullName = "Kompina MBANGA DLA",
            date = "2025/04/04",
            town = "Douala",
            phone = "(+237) 6 89 58 00 12",
            status = R.drawable.trxn_ph1_init_s4_success
        ),
        //4
        Transaction(
            profilePictureId = R.drawable.user_withlove_t,
            userName = R.string.user_withlove_t,
            sent = "Sent: \$600.6",
            received = "259,000",
            fullName = "WithLove Tried",
            date = "2024/12/25",
            town = "Yaounde",
            phone = "(+237) 6 75 05 63 12",
            status = R.drawable.trxn_ph4_complete_s3_error
        ),
        //5
        Transaction(
            profilePictureId = R.drawable.user_default,
            userName = R.string.user_sweetheart,
            sent = "Sent: \$117.46",
            received = "51,000",
            fullName = "Bertoua",
            date = "2024/06/29",
            town = "Douala",
            phone = "(+237) 6 77 99 33 32",
            status = R.drawable.trxn_ph3_delivery_s4_success
        ),
        //6
        Transaction(
            profilePictureId = R.drawable.user_elder_d,
            userName = R.string.user_elder_d,
            sent = "Sent: \$1,217.46",
            received = "6,015,000",
            fullName = "Zion ELDER DAUGHTER",
            date = "2025/01/31",
            town = "Bagangte",
            phone = "(+237) 6 69 50 21 21",
            status = R.drawable.trxn_ph4_complete_s4_success
        )
    )
}




/*
val transactions = listOf(
    Dog(R.drawable.koda, R.string.dog_name_1, 2, R.string.dog_description_1),
    Dog(R.drawable.lola, R.string.dog_name_2, 16, R.string.dog_description_2),
    Dog(R.drawable.frankie, R.string.dog_name_3, 2, R.string.dog_description_3),
    Dog(R.drawable.nox, R.string.dog_name_4, 8, R.string.dog_description_4),
    Dog(R.drawable.faye, R.string.dog_name_5, 8, R.string.dog_description_5),
    Dog(R.drawable.bella, R.string.dog_name_6, 14, R.string.dog_description_6),
    Dog(R.drawable.moana, R.string.dog_name_7, 2, R.string.dog_description_7),
    Dog(R.drawable.tzeitel, R.string.dog_name_8, 7, R.string.dog_description_8),
    Dog(R.drawable.leroy, R.string.dog_name_9, 4, R.string.dog_description_9)
)
*/




