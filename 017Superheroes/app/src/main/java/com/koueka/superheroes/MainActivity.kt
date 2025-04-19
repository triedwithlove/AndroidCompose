package com.koueka.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.koueka.superheroes.data.HeroesRepository
import com.koueka.superheroes.ui.theme.SuperheroesTheme
import com.koueka.superheroes.view.HeroView
import com.koueka.superheroes.view.HeroesFadeAnimatedView
import com.koueka.superheroes.view.HeroesSlideItemAnimatedView
import com.koueka.superheroes.view.HeroesView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {
                //HeroesApp()
                //HeroesFadeAnimatedApp()
                HeroesSlideItemAnimatedApp()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HeroesTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge,
                    modifier = modifier
                )
            }
        }
    )
}


@Composable
fun HeroesFadeAnimatedApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { HeroesTopAppBar() },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        HeroesFadeAnimatedView(
            heroes = HeroesRepository.heroes,
            modifier = Modifier.padding(innerPadding)
        )
    }
}


@Composable
fun HeroesSlideItemAnimatedApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { HeroesTopAppBar() },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        HeroesSlideItemAnimatedView(
            heroes = HeroesRepository.heroes,
            modifier = Modifier.padding(innerPadding)
        )
    }
}


@Composable
fun HeroesApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = { HeroesTopAppBar() },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        HeroesView(
            heroes = HeroesRepository.heroes,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Preview( name = "HeroesAppPreview", showBackground = false, showSystemUi = true)
@Composable
fun HeroesAppPreview() {
    SuperheroesTheme {
        HeroesApp()
    }
}
