package com.koueka.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.koueka.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LemonadeTheme {
                Scaffold(modifier = Modifier.fillMaxSize(),
                    topBar = {
                        CenterAlignedTopAppBar(
                            title = {
                                Text(
                                    text = "Lemonade",
                                    fontWeight = FontWeight.Bold
                                )
                            },
                            colors = TopAppBarDefaults.largeTopAppBarColors(
                                containerColor = MaterialTheme.colorScheme.primaryContainer
                            )
                        )
                    }
                ) { innerPadding ->
                    LemonadeApp(modifier= Modifier.padding(innerPadding).fillMaxSize()
                        .wrapContentSize(Alignment.Center))
                }
            }
        }
    }
}


@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    Column (
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var result by remember { mutableStateOf(0) }
        var squeezeLemon by remember { mutableStateOf(0) }

        var textDescription  = when (result) {
            0 -> stringResource(R.string.lemon_tree_description)
            1 -> stringResource(R.string.lemon_description)
            2 -> stringResource(R.string.glass_of_lemonade_description)
            else -> stringResource(R.string.empty_glass_description)
        }

        var imageDescription  = when (result) {
            0 -> stringResource(R.string.lemon_tree)
            1 -> stringResource(R.string.lemon)
            2 -> stringResource(R.string.glass_of_lemonade)
            else -> stringResource(R.string.empty_glass)
        }

        var maxVal by remember { mutableStateOf(1) }
        var imageResource = when (result) {
            0 -> R.drawable.lemon_tree
            1 -> R.drawable.lemon_squeeze
            2 -> R.drawable.lemon_drink
            else -> R.drawable.lemon_restart
        }

        val onImageClick: () -> Unit = {
            android.util.Log.d("MainActivity", "result per click = $result")
            if (1 == result) {
                squeezeLemon++
                android.util.Log.d("MainActivity", "max squeeze tap = $maxVal,  squeezeLemon=$squeezeLemon ")
                if (maxVal == squeezeLemon) {
                    android.util.Log.d("MainActivity", "max squeeze tap = $maxVal, re-init squeezeLemon=$squeezeLemon ")
                    result++
                    squeezeLemon = 0
                }
            } else {
                result++
                result %= 4
                if (1 == result) {
                    maxVal = (2..4).random()
                    android.util.Log.d("MainActivity", "maxVal = $maxVal")
                }
            }
        }

        Image(
            painter = painterResource(imageResource),
            contentDescription = imageDescription,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .background(color = Color.LightGray, shape = RoundedCornerShape(16.dp))
                .clickable (onClick = onImageClick)
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = textDescription,
            fontSize = 18.sp
        )
    }
}


@Composable
fun Lemonade(modifier: Modifier = Modifier
    .fillMaxSize()
    .wrapContentSize(Alignment.Center)
) {
    Column (modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(R.drawable.lemon_tree),
            contentDescription = stringResource(R.string.lemon_tree_description),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .background(color = Color.Gray, shape = RoundedCornerShape(16.dp))
                //.size(160.dp)
                //.clip(RoundedCornerShape(60.dp))
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = stringResource(R.string.lemon_tree_description),
            fontSize = 18.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreview() {
    LemonadeTheme {
        Lemonade()
    }
}

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
    LemonadeTheme {
        Greeting("Android")
    }
}