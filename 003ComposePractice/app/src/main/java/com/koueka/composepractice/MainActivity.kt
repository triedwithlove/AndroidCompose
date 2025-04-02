package com.koueka.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.koueka.composepractice.ui.theme.ComposePracticeTheme
import com.koueka.composepractice.ui.theme.bottomEndColor
import com.koueka.composepractice.ui.theme.bottomStartColor
import com.koueka.composepractice.ui.theme.topEndColor
import com.koueka.composepractice.ui.theme.topStartColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposePracticeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
//                Surface(modifier = Modifier.fillMaxSize()) {
/*                    BasicCompose(
                        title = stringResource(R.string.basic_title),
                        description = stringResource(R.string.basic_description),
                        message = stringResource(R.string.basic_message),
                        modifier = Modifier.padding(innerPadding)
                    )*/
/*                    TaskManager(
                        title = stringResource(R.string.task_manager_title),
                        encouragement = stringResource(R.string.task_manager_encouragement),
                        modifier = Modifier.padding(innerPadding)
                    )*/
                    ComposeQuadrant(
                        title_top_start = stringResource(R.string.quadrant_title_top_start),
                        description_top_start = stringResource(R.string.quadrant_title_top_start_description),
                        color_top_start = topStartColor,

                        title_top_end = stringResource(R.string.quadrant_title_top_end),
                        description_top_end = stringResource(R.string.quadrant_title_top_end_description),
                        color_top_end = topEndColor,

                        title_bottom_start = stringResource(R.string.quadrant_title_bottom_start),
                        description_bottom_start = stringResource(R.string.quadrant_title_bottom_start_description),
                        color_bottom_start = bottomStartColor,

                        title_bottom_end = stringResource(R.string.quadrant_title_bottom_end),
                        description_bottom_end = stringResource(R.string.quadrant_title_bottom_end_description),
                        color_bottom_end = bottomEndColor,

                        modifier = Modifier.padding(innerPadding)
//                        modifier = Modifier
                    )
                }
            }
        }
    }
}


@Composable
fun ComposeQuadrant(
    title_top_start: String, description_top_start: String, color_top_start: Color,
    title_top_end: String, description_top_end: String, color_top_end: Color,
    title_bottom_start: String, description_bottom_start: String, color_bottom_start: Color,
    title_bottom_end: String, description_bottom_end: String, color_bottom_end: Color,
    modifier: Modifier = Modifier) {

    Column(modifier = Modifier
        .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.weight(1F)) {
            PartialComposeQuadrant(
                title = title_top_start,
                description = description_top_start,
                color = color_top_start,
                modifier = Modifier.weight(1F)
            )
            PartialComposeQuadrant(
                title = title_top_end,
                description = description_top_end,
                color = color_top_end,
                modifier = Modifier.weight(1F)
            )
        }
        Row(
            modifier = Modifier.weight(1f)) {
            PartialComposeQuadrant(
                title = title_bottom_start,
                description = description_bottom_start,
                color = color_bottom_start,
                modifier = Modifier.weight(1f)
            )
            PartialComposeQuadrant(
                title = title_bottom_end,
                description = description_bottom_end,
                color = color_bottom_end,
                modifier = Modifier.weight(1F)
            )
        }
    }

}


@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Compose Quadrant"
)
@Composable
fun ComposeQuadrantPreview() {
    ComposePracticeTheme {
        ComposeQuadrant(
            title_top_start = stringResource(R.string.quadrant_title_top_start),
            description_top_start = stringResource(R.string.quadrant_title_top_start_description),
            color_top_start = topStartColor,

            title_top_end = stringResource(R.string.quadrant_title_top_end),
            description_top_end = stringResource(R.string.quadrant_title_top_end_description),
            color_top_end = topEndColor,

            title_bottom_start = stringResource(R.string.quadrant_title_bottom_start),
            description_bottom_start = stringResource(R.string.quadrant_title_bottom_start_description),
            color_bottom_start = bottomStartColor,

            title_bottom_end = stringResource(R.string.quadrant_title_bottom_end),
            description_bottom_end = stringResource(R.string.quadrant_title_bottom_end_description),
            color_bottom_end = bottomEndColor,
        )
    }
}


@Composable
fun PartialComposeQuadrant(
    title: String,
    description: String,
    color: Color,
    modifier: Modifier = Modifier) {

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(Color.LightGray)) {
            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = description,
                textAlign = TextAlign.Justify
            )
        }
    }
}


@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Partial Compose Quadrant"
)
@Composable
fun PartialComposeQuadrantPreview() {
    ComposePracticeTheme {
        PartialComposeQuadrant(
            title = stringResource(R.string.quadrant_title_top_start),
            description = stringResource(R.string.quadrant_title_top_start_description),
            topStartColor
        )
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
    name = "Compose Article"
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