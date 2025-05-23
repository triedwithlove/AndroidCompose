package com.koueka.coursesgridapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.koueka.coursesgridapp.data.DataSource
import com.koueka.coursesgridapp.model.Topic
import com.koueka.coursesgridapp.ui.theme.CoursesGridAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoursesGridAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CoursesApp(modifier = Modifier.padding(innerPadding))

/*
                    TopicList(
                        com.koueka.coursesgridapp.data.DataSource.topics,
                        modifier = Modifier.padding(innerPadding)
                    )
*/
                }
            }
        }
    }
}

@Composable
fun CoursesApp(modifier: Modifier = Modifier) {
    val layoutDirection = LocalLayoutDirection.current
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(
                start = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection = layoutDirection),
                end = WindowInsets.safeDrawing.asPaddingValues()
                    .calculateStartPadding(layoutDirection = layoutDirection)
            )
    ) {
        //---
        TopicList(topicList = DataSource.topics, modifier = Modifier.padding(4.dp))
    }
}

@Preview
@Composable
private fun CoursesAppPreview() {
    CoursesApp()
}



@Composable
fun TopicList(topicList: List<Topic>, modifier: Modifier = Modifier) {
    LazyVerticalGrid (
        columns = GridCells.Adaptive(170.dp),
        modifier = modifier
    ) {
        items(count = topicList.size) { item ->
            TopicCard(
                topic = topicList.get(item),
                modifier = Modifier
                    .padding(4.dp)
            )
        }
    }
}

@Preview
@Composable
private fun TopicListPreview() {
    TopicList(com.koueka.coursesgridapp.data.DataSource.topics)
}


@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    //
    Card(modifier = modifier.padding(top = 0.dp)) {
        Row (modifier = Modifier.height(68.dp)
        ) {
            Image(
                painter = painterResource(topic.imageResourceId),
                contentDescription = stringResource(topic.stringResourceId),
                modifier = Modifier
                    .width(68.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)) {
                Text(
//                    text = LocalContext.current.getString(affirmation.stringResourceId),
                    text = stringResource(topic.stringResourceId),
                    modifier = Modifier.padding(top = 0.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically,
//                    modifier = Modifier.background(Color.Yellow)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_grain),
                        contentDescription = null,
                        modifier = Modifier,
                        contentScale = ContentScale.Crop
                    )
                    Text(
                        text = "${topic.taken}",
                        modifier = Modifier.padding(start = 8.dp),
                        style = MaterialTheme.typography.labelMedium
                    )
                }
            }
        }
    }
}


@Preview
@Composable
private fun TopicCardPreview() {
    TopicCard(Topic(R.string.architecture, 58, R.drawable.architecture))
}
