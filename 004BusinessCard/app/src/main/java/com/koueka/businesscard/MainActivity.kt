package com.koueka.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.koueka.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    BusinessCard()
                }
            }
        }
    }
}


@Composable
fun BusinessCard() {
    Column(verticalArrangement = Arrangement.Bottom, modifier = Modifier.fillMaxHeight()) {
        Info()
        ComposeContact()
    }
}

@Preview(
    showBackground = false,
    name = "Business Card"
)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}


@Composable
fun Info() {
    Column(modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 190.dp)) {
        val img = painterResource(id = R.drawable.image_profile)
        val borderWidth = 4.dp
        Image(
            painter = img,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(100.dp)
                .border(
                    BorderStroke(borderWidth, Color.Yellow),
                    CircleShape
                )
                .align(alignment = Alignment.CenterHorizontally)
                .clip(CircleShape)
        )

        Text(
            text = "Full Name",
            textAlign = TextAlign.Center,
            fontSize = 49.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
        )

        Text(
            text = "title",
            textAlign = TextAlign.Center,
            color = Color.Green,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 1.dp)
        )
    }
}

@Preview(
    showBackground = false,
    name = "Info"
)
@Composable
fun InfoPreview() {
    BusinessCardTheme {
        Info()
    }
}


@Composable
fun ComposeContact() {
    Column(modifier = Modifier.padding(bottom = 100.dp)) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Icon(
                Icons.Rounded.Phone,
                contentDescription = "Phone",
                modifier = Modifier.padding(end = 15.dp)
            )
            Text(
                text = "+1987654320",
                modifier = Modifier.width(170.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Icon(
                Icons.Rounded.Share,
                contentDescription = "social",
                modifier = Modifier.padding(end = 15.dp)
            )
            Text(
                text = "@socialmediahandle",
                modifier = Modifier.width(170.dp)
            )
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        ) {
            Icon(
                Icons.Rounded.Email,
                contentDescription = "Basket",
                modifier = Modifier.padding(end = 15.dp)
            )
            Text(
                text = "email@domain.com",
                modifier = Modifier.width(170.dp)
            )
        }
    }
}

@Preview(
    showBackground = false,
    name = "Contact"
)
@Composable
fun ComposeContactPreview() {
    BusinessCardTheme {
        ComposeContact()
    }
}


@Composable
fun TestIcon() {
    Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.fillMaxWidth()) {
        Icon(Icons.Rounded.Share, contentDescription = "Basket", modifier = Modifier.padding(end = 15.dp))
        Text(text = "email@domain.com")
    }
}

@Preview(showBackground = false)
@Composable
fun TestIconPreview() {
    BusinessCardTheme {
        TestIcon()
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
    BusinessCardTheme {
        Greeting("Android")
    }
}