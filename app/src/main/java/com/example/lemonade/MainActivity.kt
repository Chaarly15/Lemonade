package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
           LemonadeTheme {
               LemonadeApp()
           }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadePreviewApp(){

    LemonadeApp(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center))
}

@Composable
fun LemonadeApp(modifier: Modifier = Modifier){

    var result by remember { mutableStateOf(1) }
    val imageResources = when (result){
        1->R.drawable.lemon_tree
        2->R.drawable.lemon_squeeze
        3->R.drawable.lemon_drink
        else->R.drawable.lemon_restart
    }

    val description = when (result) {
        1 -> stringResource(R.string.tree)
        2 -> stringResource(R.string.lemon)
        3 -> stringResource(R.string.lemonade)
        else -> stringResource(R.string.empty_glass)
    }

    Column(modifier = modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center),
        horizontalAlignment = Alignment.CenterHorizontally){

        Button(onClick = {result = if (result < 4) result + 1 else 1}, colors = ButtonDefaults.buttonColors(
            colorResource(id = R.color.limonade_bg)),
            shape = RoundedCornerShape(26.dp),
            modifier = Modifier) {

            Image(painter = painterResource(imageResources), contentDescription = String())
        }
        Text(description)
    }
}