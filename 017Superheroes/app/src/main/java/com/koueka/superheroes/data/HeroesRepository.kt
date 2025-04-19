package com.koueka.superheroes.data

import com.koueka.superheroes.R
import com.koueka.superheroes.model.Hero

object HeroesRepository {
    val singleHero = Hero(
        nameRes = R.string.hero1,
        descriptionRes = R.string.description1,
        imageRes = R.drawable.android_superhero1
    )
}