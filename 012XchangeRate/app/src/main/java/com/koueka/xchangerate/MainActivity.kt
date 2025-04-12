package com.koueka.xchangerate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.koueka.xchangerate.ui.theme.XchangeRateTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            XchangeRateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Xchange(modifier = Modifier.fillMaxSize().padding(innerPadding).background(Color.LightGray))

                    /*Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                }
            }
        }
    }
}


@Composable
fun Xchange(modifier: Modifier = Modifier) {
    var amountTop by remember { mutableStateOf("") }
    var amountBottom by remember { mutableStateOf("") }
    val focusRequester = remember { FocusRequester() }


    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        TextField(
            value = amountTop,
            onValueChange = { amountTop = it },
            singleLine = true,
            label = { Text("Amount") },
            modifier = Modifier
                //.focusRequester(focusRequester)
                .clickable {
                    focusRequester.requestFocus()

                    //not working....
                    if (focusRequester.captureFocus()) {
                        android.util.Log.d("MainActivity", "amountTop has the focus")
                    } else {
                        android.util.Log.d("MainActivity", "amountTop has NOT the focus")
                    }
                }
        )
        Text(
            text = "Xchange rate: 1 > 439",
            modifier = Modifier
        )
        TextField(
            value = amountBottom,
            onValueChange = { amountBottom = it },
            singleLine = true,
            label = { Text("Amount") }
        )
    }


}

@Preview(showBackground = true)
@Composable
fun XchangePreview() {
    XchangeRateTheme {
        Xchange()
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
    XchangeRateTheme {
        Greeting("Android")
    }
}
*/