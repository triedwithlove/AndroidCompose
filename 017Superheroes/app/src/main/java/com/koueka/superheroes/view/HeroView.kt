package com.koueka.superheroes.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
fun HeroesFadeAnimatedView(
    heroes: List<Hero>,
    modifier: Modifier = Modifier
) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            //start immediately the animation
            targetState = true
        }
    }

    //Fade in entry animation for the entire list and fade out on exit
    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)),
        exit = fadeOut(),
        //modifier = modifier
    ) {
        HeroesView(heroes = heroes, modifier = modifier)
    }
}


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun HeroesSlideItemAnimatedView(
    heroes: List<Hero>,
    modifier: Modifier = Modifier
) {
    val visibleState = remember {
        MutableTransitionState(false).apply {
            //start immediately the animation
            targetState = true
        }
    }

    //Fade in entry animation for the entire list and fade out on exit
    AnimatedVisibility(
        visibleState = visibleState,
        enter = fadeIn(animationSpec = spring(dampingRatio = Spring.DampingRatioLowBouncy)),
        exit = fadeOut(),
        //modifier = modifier
    ) {
        LazyColumn(modifier = modifier) {
            itemsIndexed(items = heroes) { indexParam, heroParam ->
                HeroView(
                    hero = heroParam,
                    modifier = Modifier
                        .padding(
                            horizontal = dimensionResource(R.dimen.padding_medium),
                            vertical = dimensionResource(R.dimen.padding_small)
                        )
                        .animateEnterExit(
                            enter = slideInVertically(
                                animationSpec = spring(
                                    stiffness = Spring.StiffnessVeryLow,
                                    dampingRatio = Spring.DampingRatioLowBouncy
                                ),
                                initialOffsetY = {it * (indexParam + 1)}
                            )
                        )
                )
            }
        }
    }
}


@Composable
fun HeroesView(
    heroes: List<Hero>,
    modifier: Modifier = Modifier
) {
    LazyColumn(modifier = modifier) {
        items(items = heroes) { heroParam ->
            HeroView(
                hero = heroParam,
                modifier = Modifier.padding(
                    top = dimensionResource(R.dimen.padding_extra_small),
                    bottom = dimensionResource(R.dimen.padding_extra_small),
                    start = dimensionResource(R.dimen.padding_medium),
                    end = dimensionResource(R.dimen.padding_medium)
                )
            )
        }
    }
}


@Composable
fun HeroView(
    hero: Hero,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults
            .cardElevation(defaultElevation =  dimensionResource(R.dimen.elevation)),
        modifier = modifier) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                //.border(2.dp, Color.Black, MaterialTheme.shapes.medium)
                .clip(shape = MaterialTheme.shapes.medium)
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
                )
            }
            Box(modifier = Modifier
                .size(dimensionResource(R.dimen.image_size))
                .clip(shape = MaterialTheme.shapes.small)
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

