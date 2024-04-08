package com.alvin.alvin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.alvin.alvin.ui.theme.AlvinTheme

class Recycleview : ComponentActivity() {
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
                    RecyclerView() 
                }
            }
        }
    }
}
@Composable
fun ListItem(name:String){
    val expanded= remember { mutableStateOf(false) }
    val extrapadding by animateDpAsState(
        if (expanded.value)24.dp else 0.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Surface(color = MaterialTheme.colorScheme.primary,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)) {

        Column(modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth())    {

            Row {
                Column(modifier = Modifier
                    .weight(1f)) {
                    Text(text = "Course")
                    Text(text = name, style = MaterialTheme.typography.headlineMedium.copy(
                        fontWeight = FontWeight.ExtraBold
                    ))
                }
                OutlinedButton(onClick = { expanded.value=!expanded.value }) {
                    Text(if (expanded.value)"Show less" else "Show more")

                }
            }
            if (expanded.value){
                Column(modifier = Modifier.padding(
                    bottom = extrapadding.coerceAtLeast(0.dp)
                )) {
                    Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras accumsan, ligula vitae convallis consectetur, est metus hendrerit lorem, eu venenatis est arcu a mi. Ut condimentum laoreet sapien at consectetur. Quisque interdum sapien non porttitor malesuada. Curabitur vel pharetra ipsum. Sed luctus felis nec placerat consectetur. Donec quis libero metus. Proin mollis porta ipsum, id interdum erat tincidunt vitae. Quisque id diam in eros lobortis tincidunt vitae eu sem. Proin diam nisi, gravida sed turpis eu, vestibulum semper neque. ")
                }
            }

        }

    }
}
@Composable
fun RecyclerView(names:List<String> = List(1000){"$it"}){
    LazyColumn(modifier = Modifier.padding(vertical = 4.dp)){
        items(items = names){name ->
            ListItem(name = name)

        }
    }

}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

        RecyclerView()

}
