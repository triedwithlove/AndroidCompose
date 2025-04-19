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
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.koueka.superheroes.data.HeroesRepository
import com.koueka.superheroes.model.Hero

@Composable
fun HeroView(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card() {
        Column(
            modifier = Modifier
                //.background(color = Color.Yellow)
                //.clip(shape = RoundedCornerShape(15.dp))
                //.padding(top = 50.dp, start = 1.dp, end = 1.dp)
            //.wrapContentSize()
        ) {
            Row(
                //modifier = modifier
                modifier = Modifier
                    .fillMaxWidth()
                    //.border(2.dp, Color.Black, MaterialTheme.shapes.medium)
                    .clip(shape = MaterialTheme.shapes.medium)
                    //.border(2.dp, Color.Black, RoundedCornerShape(30.dp))
                    //.clip(shape = RoundedCornerShape(30.dp))
                    //.background(color = Color.LightGray)
                    .padding(16.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 16.dp)
                ) {
                    Text(
                        text = stringResource(hero.nameRes),
                        style = MaterialTheme.typography.displaySmall
                    )
                    Text(
                        text = stringResource(hero.descriptionRes),
                        style = MaterialTheme.typography.bodyLarge
                        //                    style = MaterialTheme.typography.displayLarge
                    )
                }
                Image(
                    painter = painterResource(hero.imageRes),
                    contentDescription = stringResource(hero.nameRes),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(72.dp)
                        .clip(shape = RoundedCornerShape(15.dp))
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

