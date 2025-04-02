package com.koueka.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.koueka.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
/*                    BasicCompose(
                        title = stringResource(R.string.basic_title),
                        description = stringResource(R.string.basic_description),
                        message = stringResource(R.string.basic_message),
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    TaskManager(
                        title = stringResource(R.string.task_manager_title),
                        encouragement = stringResource(R.string.task_manager_encouragement),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun TaskManager(title: String, encouragement: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        val image = painterResource(id = R.drawable.ic_task_completed)
        Image(
            painter = image,
            contentDescription = null
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = modifier.padding(top = 24.dp, bottom = 8.dp)
        )
        Text(
            text = encouragement,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify
        )
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Task Manager"
)
@Composable
fun TaskManagerPreview() {
    ComposePracticeTheme {
        TaskManager(
            title = stringResource(R.string.task_manager_title),
            encouragement = stringResource(R.string.task_manager_encouragement)
        )
    }
}


@Composable
fun BasicCompose(title: String, description: String, message: String, modifier: Modifier = Modifier) {
    Column(verticalArrangement = Arrangement.Top) {
        val image = painterResource(id = R.drawable.bg_compose_background)
        Image(painter = image, contentDescription = null)
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = modifier.padding(16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = message,
            textAlign = TextAlign.Justify,
            modifier = modifier.padding(16.dp)
        )
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Basic Compose"
)
@Composable
fun BasicComposePreview() {
    ComposePracticeTheme {
        BasicCompose(
            title = stringResource(R.string.basic_title),
            description = stringResource(R.string.basic_description),
            message = stringResource(R.string.basic_message)
        )
    }
}