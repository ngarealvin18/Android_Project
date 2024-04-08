 package com.alvin.alvin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.alvin.alvin.ui.theme.AlvinTheme

class SimpleList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AlvinTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    Greeting("Android")
                    SimpleListview()
                }
            }
        }
    }
}

private val nameList= mutableListOf(
    "Alvin","Mercy","Kelly","John","Joy","Ian","Sharon",
    "Alvin","Mercy","Kelly","John","Joy","Ian","Sharon",
    "Alvin","Mercy","Kelly","John","Joy","Ian","Sharon",
    "Alvin","Mercy","Kelly","John","Joy","Ian","Sharon",
    "Alvin","Mercy","Kelly","John","Joy","Ian","Sharon",
    "Alvin","Mercy","Kelly","John","Joy","Ian","Sharon",
    "Alvin","Mercy","Kelly","John","Joy","Ian","Sharon",
    "Alvin","Mercy","Kelly","John","Joy","Ian","Sharon")

private val listModifier= Modifier
    .fillMaxSize()
    .background(Color.Cyan)
    .padding(30.dp)

private val textStyle=
    TextStyle(fontSize = 25.sp, color = Color.Red)

 @Composable
 fun SimpleListview() {
     LazyColumn(modifier = listModifier){
         items(nameList){

             jina ->
             Text(text= jina, style = textStyle)
         }
     }

 }

 @Preview
 @Composable
 private fun List() {
     SimpleListview()

 }
