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
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.graphics.ColorUtils
import androidx.core.view.WindowCompat
import com.example.compose.model.SampleData
import com.example.compose.ui.theme.ComposeTheme
import com.google.accompanist.insets.*
import com.google.accompanist.insets.ui.TopAppBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class Main2Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //设置沉浸式
        WindowCompat.setDecorFitsSystemWindows(window, false)
//        window.statusBarColor = resources.getColor(R.color.color_t)
        setContent {
            ComposeTheme(darkTheme = false) {

                TestStatusBarHeight()
                // A surface container using the 'background' color from the theme
//                Surface(color = MaterialTheme.colors.onPrimary) {
//                    TestRow()
//                }


            }
        }
    }

    @Preview
    @Composable
    private fun TestStatusBarHeight() {
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setStatusBarColor(Color.Transparent, darkIcons = true)
        }
        ProvideWindowInsets {
            //ProvideWindowInsets中
            //Modifier.statusBarsHeight()才生效
            Surface(color = Color.Magenta) {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.statusBarsHeight())
                    Text(text = "test04")
                    Text(text = "test04")
                }

            }
        }
    }


    @Preview
    @Composable
    private fun TestRow() {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top
        ) {
            Text(text = stringResource(id = R.string.app_name))
            Text(text = "test02", color = Color.Red)
            Text(text = "test03", fontWeight = FontWeight.Bold, textAlign = TextAlign.Right)
            Text(text = "test04")
        }

    }

    @Preview
    @Composable
    fun TestBox() {
        Text(text = "test box")
        Box {

        }
    }


}