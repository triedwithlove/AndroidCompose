package com.koueka.transactionstatus

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.VectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.koueka.transactionstatus.ui.theme.TransactionStatusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TransactionStatusTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->

                    StatusStepView(
                        step = "3",
                        imageRes = R.drawable.trxn_ph3_delivery_s2_progress,
                        descriptionRes = R.string.str_trxn_ph3_delivery_s2_progress,
                        modifier = Modifier.padding(innerPadding)
                    )

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
fun StatusStepView(
    step: String,
    @DrawableRes imageRes: Int,
    @StringRes descriptionRes: Int,
    modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Bottom,
//        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            //.background(Color.Gray)
    ) {
        Spacer(modifier = Modifier.height(50.dp))

        Text(
            text = "Step: $step",
            modifier = Modifier
                //.background(Color.Red)
        )
        Box(modifier = Modifier
            //.size(40.dp)
            .width(40.dp)
            .height(10.dp)
            //.background(Color.DarkGray)
        ) {
            Image(imageVector = ImageVector.vectorResource(imageRes), contentDescription = null)
        }
        Text(
            text = stringResource(descriptionRes),
            modifier = Modifier
                //.background(Color.Red)
        )

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
    TransactionStatusTheme {
        Greeting("Android")
    }
}
