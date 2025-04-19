package com.koueka.superheroes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.koueka.superheroes.data.HeroesRepository
import com.koueka.superheroes.ui.theme.SuperheroesTheme
import com.koueka.superheroes.view.HeroView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SuperheroesTheme {
                HeroesApp()
/*                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    HeroView(hero = HeroesRepository.singleHero)


                }*/
            }
        }
    }
}


@Composable
fun HeroesApp(modifier: Modifier = Modifier) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(items = HeroesRepository.heroes) { heroParam ->
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
}

@Preview( name = "HeroesAppPreview", showBackground = false, showSystemUi = true)
@Composable
fun HeroesAppPreview() {
    SuperheroesTheme {
        HeroesApp()
    }

}

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SuperheroesTheme {
        Greeting("Android")
    }
}
*/