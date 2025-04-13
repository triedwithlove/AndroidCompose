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
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.koueka.xchangerate.ui.theme.XchangeRateTheme
import java.text.NumberFormat

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

enum class Direction {INIT, TF_TOP, TF_BOTTOM}


@Composable
fun Xchange(modifier: Modifier = Modifier) {
    var amountTop by remember { mutableStateOf("") }
    var amountBottom by remember { mutableStateOf("") }
//    val focusRequester = remember { FocusRequester() }

    var xchDirection by remember { mutableStateOf(Direction.INIT) }
    val xchRate: Double = 416.36517

/*
    val amountIn = amountTop.toDoubleOrNull() ?: 0.0
    val amountOut = amountBottom.toDoubleOrNull() ?: 0.0
*/

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
            onValueChange = { str ->
                amountTop = str

                //
                val amountIn = amountTop.toDoubleOrNull() ?: 0.0
                val result = amountIn * xchRate
                amountBottom = NumberFormat.getInstance().format(result)

                /*
                                //val amountIn = amountTop.toDoubleOrNull() ?: 0.0
                                var amountIn = 0.0
                                android.util.Log.d("MainActivity", " valueChanged amountTop=$amountTop")
                                if (null == amountTop.toDoubleOrNull()) {
                                    val tmp = NumberFormat.getNumberInstance().format(amountTop)
                                    android.util.Log.d("MainActivity", " valueChanged tmp=$tmp")
                                    amountIn = tmp.toDoubleOrNull() ?: 0.0
                                    android.util.Log.d("MainActivity", " valueChanged amountIn=$amountIn")
                                } else {
                                    amountIn = amountTop.toDoubleOrNull() ?: 0.0
                                    android.util.Log.d("MainActivity", " valueChanged amountIn=$amountIn")
                                }

                                val result = amountIn * xchRate
                                amountBottom = NumberFormat.getNumberInstance().format(result)
                */
            },
            singleLine = true,
            label = { Text("Amount") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .onFocusEvent {
                    if (it.isFocused) {
                        xchDirection = Direction.TF_TOP
                        android.util.Log.d("MainActivity", " isFocused amountTop has the focus")
                        amountTop = ""
                        amountBottom = ""

                        /*
                        val amountIn = amountTop.toDoubleOrNull() ?: 0.0
                        val amountOut = amountBottom.toDoubleOrNull() ?: 0.0
*/


                    }
                }
        )

        Text(
            text = "Xchange rate: 1 > 439",
            modifier = Modifier
        )

        TextField(
            value = amountBottom,
            onValueChange = { str ->
                amountBottom = str

                val amountOut = amountBottom.toDoubleOrNull() ?: 0.0
                val result = amountOut / xchRate
                amountTop = NumberFormat.getInstance().format(result)
            },
            singleLine = true,
            label = { Text("Amount") },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            enabled = true,
            modifier = Modifier
                .onFocusEvent {
                    if (it.isFocused) {
                        xchDirection = Direction.TF_BOTTOM
                        android.util.Log.d("MainActivity", " isFocused amountBottom has the focus")
                        amountBottom = ""
                        amountTop = ""
                    }
                }
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