package com.example.compose

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import com.example.compose.model.SampleData
import com.example.compose.ui.theme.ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme(darkTheme = false) {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.onPrimary) {
                    MessageCard(Message("Android", "Jetpack Compose"))

//                    LazyColumn {
//                        items(SampleData.conversationSample) { message ->
//                            MessageCard(message)
//                        }
//                    }
                }


            }
        }
    }
}


@Composable
fun Greeting(name: String) {
    Text(
        text = "Hello $name!",
        Modifier
            .background(Color.Black)
            .padding(20.dp),
        color = Color.White,
    )

}

@Composable
fun MessageCard(msg: Message) {
    Row {
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "des",
            modifier = Modifier.clip(CircleShape)
        )

        Spacer(modifier = Modifier.width(10.dp))
        Column(
            modifier = Modifier
                .background(Color(0xFFFF6200))
                .padding(5.dp)
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = msg.author,
                Modifier
                    .background(Color.Blue)
                    .padding(20.dp),
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = msg.body,
                Modifier
                    .background(Color.Green)
                    .padding(20.dp),
                color = Color.White,
                style = MaterialTheme.typography.body2
            )

            Spacer(modifier = Modifier.height(10.dp))

            LazyColumn {
                val list = listOf("111111", "222222", "333333", "444444", "5555555", "6666666", "77777", "88888")
                items(list) { message ->
                    Box(
                        modifier = Modifier
                            .fillParentMaxWidth()
                            .background(if (list.indexOf(message) % 2 == 0) Color.Red else Color.LightGray),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = message,
                            modifier = Modifier.padding(40.dp),
                            color = Color.White,
                            style = MaterialTheme.typography.body2
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                    }
                }
            }
        }
    }


}

data class Message(val author: String, val body: String)


@Preview(
//    uiMode = Configuration.UI_MODE_NIGHT_YES,
//    showBackground = true,
//    name = "Dark Mode"
)
@Composable
fun PreviewMessageCard() {
    MessageCard(
        msg = Message("Android", "Jetpack Compose")
    )
}