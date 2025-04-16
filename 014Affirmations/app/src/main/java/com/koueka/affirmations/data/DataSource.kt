package com.koueka.affirmations.data

import com.koueka.affirmations.R
import com.koueka.affirmations.model.Affirmation

class DataSource() {
    fun loadAffirmations(): List<Affirmation> {
        return listOf<Affirmation>(
            Affirmation(R.string.affirmation1, R.drawable.image1)
        )
    }
}