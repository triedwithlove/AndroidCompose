package com.koueka.xchangerate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.focus.onFocusEvent
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.koueka.xchangerate.ui.theme.XchangeRateTheme
import java.text.NumberFormat

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            XchangeRateTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Xchange(modifier = Modifier
                        .fillMaxSize()
                        .padding(innerPadding)
//                        .background(Color.LightGray)
                    )
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
    var isError by remember { mutableStateOf(false) }

    var xchDirection by remember { mutableStateOf(Direction.INIT) }
    val xchRate: Double = 416.365

    var iconDirection = R.drawable.stat_minus_3_64dp
    var xRateStr = "X-Rate: 1 > $xchRate"
    if (Direction.TF_BOTTOM == xchDirection) {
        iconDirection = R.drawable.stat_3_64dp
        xRateStr = "X-Rate: 1 > ${String.format("%.4f", 1/xchRate)}"
    } else {
        iconDirection = R.drawable.stat_minus_3_64dp
        xRateStr = "X-Rate: 1 > $xchRate"
    }

    Column (
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {

        Column (
            horizontalAlignment = Alignment.CenterHorizontally,

            modifier = Modifier
                .fillMaxWidth(0.8f)
                .border(2.dp, Color.Black, RoundedCornerShape(15.dp))
                .clip(shape = RoundedCornerShape(15.dp))
                //.border(2.dp, Color.Black, RectangleShape)
                .background(Color.LightGray)
        ) {
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "eXchange Rate",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 5.dp)
            )

            TextField(
                value = amountTop,
                onValueChange = { str ->
                    amountTop = str

                    val tmp = amountTop.replace(oldValue = ",", newValue = "", ignoreCase = true)
                    val amountIn = tmp.toDoubleOrNull() ?: 0.0
                    if (amountIn > 0.0) {
                        amountTop = NumberFormat.getNumberInstance().format(amountIn)
                    }
                    if (amountIn > 10000) {
                        isError = true

                    } else {
                        isError = false
                        val result = amountIn * xchRate
                        amountBottom = NumberFormat.getNumberInstance().format(result)

                    }
                },
                textStyle = TextStyle.Default.copy(fontSize = 28.sp, fontWeight = FontWeight.Bold),
                singleLine = true,
                isError = isError,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Gray,
                    errorContainerColor = Color.Red
                ),
                label = { Text("Amount (\$CAD)", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                leadingIcon = {
                    Image(
                        painter = painterResource(R.drawable.canada_flag),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .padding(start = 5.dp, end = 5.dp)
                    )  },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusEvent {
                        if (it.isFocused) {
                            xchDirection = Direction.TF_TOP
                            android.util.Log.d("MainActivity", " isFocused amountTop has the focus")
                        }
                    }
            )

            Row (horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 5.dp, bottom = 5.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(iconDirection),
                    contentDescription = "direction",
                    modifier = Modifier
                        .size(50.dp)
                        .padding(start = 10.dp, end = 10.dp)
                )
                Text(
                    text = xRateStr,
                    fontSize = 18.sp,
                )
            }

            TextField(
                value = amountBottom,
                onValueChange = { str ->
                    amountBottom = str

                    val tmp = amountBottom.replace(oldValue = ",", newValue = "", ignoreCase = true)
                    val amountOut = tmp.toDoubleOrNull() ?: 0.0
                    if (amountOut > 0.0) {
                        amountBottom = NumberFormat.getNumberInstance().format(amountOut)
                    }
                    val result = amountOut / xchRate

                    if (result > 10000) {
                        isError = true
                    } else {
                        isError = false
                        amountTop = NumberFormat.getNumberInstance().format(result)
                    }
                },
                textStyle = TextStyle.Default.copy(fontSize = 28.sp, fontWeight = FontWeight.Bold),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.Transparent,
                    unfocusedContainerColor = Color.Transparent,
                    disabledContainerColor = Color.Gray,
                    errorContainerColor = Color.Red
                ),
                label = { Text("Amount (XAF/CFA)", fontSize = 20.sp, fontWeight = FontWeight.Bold) },
                leadingIcon = {
                    Image(
                        painter = painterResource(R.drawable.cameroon_flag),
                        contentDescription = null,
                        modifier = Modifier
                            .size(50.dp)
                            .padding(start = 5.dp, end = 5.dp)
                    )  },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                enabled = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .onFocusEvent {
                        if (it.isFocused) {
                            xchDirection = Direction.TF_BOTTOM
                            android.util.Log.d("MainActivity", " isFocused amountBottom has the focus")
                        }
                    }
            )
            Spacer(modifier = Modifier.height(15.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun XchangePreview() {
    XchangeRateTheme {
        Xchange()
    }
}

