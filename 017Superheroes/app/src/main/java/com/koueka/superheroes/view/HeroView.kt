package com.koueka.superheroes.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.koueka.superheroes.R
import com.koueka.superheroes.data.HeroesRepository
import com.koueka.superheroes.model.Hero

@Composable
fun HeroView(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(dimensionResource(R.dimen.elevation))  ,
        modifier = modifier) {
        Row(
            //modifier = modifier
            modifier = Modifier
                .fillMaxWidth()
                //.border(2.dp, Color.Black, MaterialTheme.shapes.medium)
                .clip(shape = MaterialTheme.shapes.medium)
                //.border(2.dp, Color.Black, RoundedCornerShape(30.dp))
                //.clip(shape = RoundedCornerShape(30.dp))
                //.background(color = Color.LightGray)
                .padding(dimensionResource(R.dimen.padding_medium))
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = dimensionResource(R.dimen.padding_medium))
            ) {
                Text(
                    text = stringResource(hero.nameRes),
                    style = MaterialTheme.typography.displaySmall
                )
                Text(
                    text = stringResource(hero.descriptionRes),
                    style = MaterialTheme.typography.bodyLarge
                    //style = MaterialTheme.typography.displayLarge
                )
            }
            Box(modifier = Modifier
                .size(dimensionResource(R.dimen.image_size))
                .clip(shape = MaterialTheme.shapes.small)
                //.clip(shape = RoundedCornerShape(15.dp))
            ) {
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = stringResource(hero.nameRes),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}


@Preview
@Composable
fun HeroViewPreview(
    modifier: Modifier = Modifier
) {
    HeroView(hero = HeroesRepository.singleHero, modifier = modifier)
}

