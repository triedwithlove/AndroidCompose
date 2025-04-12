package com.koueka.artapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.koueka.artapp.ui.theme.ArtAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ArtworkApp(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
                        //.background(Color.LightGray)
                    )
                }
            }
        }
    }
}


@Composable
fun ArtworkApp(modifier: Modifier = Modifier) {
    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier,
    ) {
        val artworkList = buildArtworkList()
        var result by remember { mutableIntStateOf(0) }
        var artwork = artworkList.get(result)

        Text(text = "Picture: ${result+1}", modifier = Modifier)
        ArtworkItem(artwork = artwork, modifier = Modifier)
        //ArtworkDisplayController()
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = { result = (5 + result - 1) % 5 },
                modifier = Modifier.weight(0.3f).padding(horizontal = 25.dp)
            ) {
                Text(text = "Previous", modifier = Modifier)
            }

            Button(
                onClick = { result = (result + 1) % 5 },
                modifier = Modifier
                    .weight(0.3f)
                    .padding(horizontal = 25.dp)
            ) {
                Text(
                    text = "Next",
                    modifier = Modifier
                )

            }
        }
    }
}

@Composable
fun ArtworkItem(artwork: Artwork, modifier: Modifier = Modifier) {
    Column (modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ArtworkWall(imageID = artwork.imageID)
        Spacer(modifier = Modifier.height(45.dp))
        ArtworkDescriptor(
            title = artwork.title,
            description = artwork.description,
            author = artwork.author,
            year = artwork.year)
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkAppPreview() {
    ArtAppTheme {
        ArtworkApp()
    }
}

@Composable
fun ArtworkWall(imageID: Int, modifier: Modifier = Modifier) {
    Column (modifier = Modifier.padding(10.dp)/*.background(Color.Blue)*/) {
        ElevatedCard (elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
            modifier = modifier.padding(16.dp)) {
            Image(painter = painterResource(imageID),
                contentDescription = null,
                modifier = Modifier.padding(15.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkWallPreview() {
    ArtAppTheme {
        ArtworkWall(imageID = R.drawable.loom_01)
    }
}


@Composable
fun ArtworkDescriptor(
    title: String,
    description: String,
    author: String,
    year: String,
    modifier: Modifier = Modifier
) {
    Column (
        verticalArrangement = Arrangement.Center,
        //horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(start = 15.dp, end = 15.dp)
            .background(Color(0xFFEAECEE))
    ) {
        Text(
            text = "$title",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = modifier
        )
        Text(
            text = "$description",
            fontSize = 20.sp,
            modifier = modifier
        )
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontWeight = FontWeight.Bold, fontSize = 20.sp)) {
                    append("$author")
                }
                append("$year")
            },
            modifier = modifier
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkDescriptorPreview() {
    ArtAppTheme {
        ArtworkDescriptor(
            title = "title",
            description = "Artwork Descriptor",
            author = "Beth ILYEA",
            year = " (2025)")
    }
}


@Composable
fun ArtworkDisplayController(modifier: Modifier = Modifier) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp),
        horizontalArrangement = Arrangement.SpaceBetween
        ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(0.3f)
                .padding(horizontal = 25.dp)
        ) {
            Text(
                text = "Previous",
                modifier = modifier
            )

        }

        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .weight(0.3f)
                .padding(horizontal = 25.dp)
        ) {
            Text(
                text = "Next",
                modifier = modifier
            )

        }
    }
}

@Preview(showBackground = true)
@Composable
fun ArtworkDisplayControllerPreview() {
    ArtAppTheme {
        ArtworkDisplayController()
    }
}
