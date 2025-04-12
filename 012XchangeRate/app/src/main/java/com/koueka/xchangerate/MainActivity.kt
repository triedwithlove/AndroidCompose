package com.koueka.xchangerate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.onKeyEvent
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
//    val focusRequester = remember { FocusRequester() }

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        /*
        TextField(
            value = amountTop,
            onValueChange = { amountTop = it },
            singleLine = true,
            label = { Text("Amount") },
            enabled = false,
            modifier = Modifier
                .onFocusEvent {
                    android.util.Log.d("MainActivity", " FocusEvent amountTop has the focus")
                }
                .onFocusChanged {
                    android.util.Log.d("MainActivity", " FocusChanged amountTop has the focus")
                }
                .onKeyEvent {
                    android.util.Log.d("MainActivity", " keyEvent amountTop has the focus")
                    true
                }
                //.focusRequester(focusRequester)
                .clickable {
                    //onClick = {}
                    android.util.Log.d("MainActivity", "click amountTop has the focus")
                    //focusRequester.requestFocus()
                }
//                .focusRequester(focusRequester)
        )
*/

        TextField(
            value = amountTop,
            onValueChange = { str -> amountTop = str },
            singleLine = true,
            label = { Text("Amount") },
            modifier = Modifier
                .onFocusEvent {
                    if (it.isFocused) {
                        android.util.Log.d("MainActivity", " isFocused amountTop has the focus")
                    }
                    //android.util.Log.d("MainActivity", " FocusEvent amountTop hasFocus=${it.hasFocus}")
                    //android.util.Log.d("MainActivity", " FocusEvent amountTop isFocus=${it.isFocused}")
                    //android.util.Log.d("MainActivity", " FocusEvent amountTop isCaptured=${it.isCaptured}")
                }/*
                .onFocusChanged {
                    android.util.Log.d("MainActivity", " FocusChanged amountTop has the focus")
                    if (it.isFocused) {
                        android.util.Log.d("MainActivity", " isFocused amountTop has the focus")
                    }
                }
                .clickable {
                    android.util.Log.d("MainActivity", "click amountTop has the focus")
                }*/
        )

        Text(
            text = "Xchange rate: 1 > 439",
            modifier = Modifier
        )

        TextField(
            value = amountBottom,
            onValueChange = { str -> amountBottom = str },
            singleLine = true,
            label = { Text("Amount") },
            enabled = true,
            modifier = Modifier
                .onFocusEvent {
                    if (it.isFocused) {
                        android.util.Log.d("MainActivity", " isFocused amountBottom has the focus")
                    }
                    //android.util.Log.d("MainActivity", " FocusEvent amountBottom hasFocus=${it.hasFocus}")
                }
                /*
                .onFocusChanged {
                    android.util.Log.d("MainActivity", " FocusChanged amountBottom has the focus")
                }
                .clickable {
                    android.util.Log.d("MainActivity", "click amountBottom has the focus")
                }*/
        )



        /*
        TextField(
            value = amountBottom,
            onValueChange = { amountBottom = it },
            singleLine = true,
            label = { Text("Amount") },
            interactionSource = remember { MutableInteractionSource() }
                .also {
                    param ->
                    LaunchedEffect(param) {
                        param.interactions.collect {
                            if (it is PressInteraction) {
                                android.util.Log.d("MainActivity", "click amountBottom has the focus")
                                //not working
                            }
                        }
                    }
                }
        )
        */
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