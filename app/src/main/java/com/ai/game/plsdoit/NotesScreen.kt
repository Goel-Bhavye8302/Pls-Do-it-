package com.ai.game.plsdoit

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ai.game.plsdoit.ui.theme.PlsDoItTheme

@Composable
fun NoteScreen(){
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = 4.dp
        ) {
            Column{
                Text(
                    text = "Shopping",
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
                    style = MaterialTheme.typography.h6,
                    fontSize = 24.sp
                )
                Text(
                    text = "Buy the following things : \n1) Biscuits\n2) Juice\n...",
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
                    fontSize = 18.sp
                )

            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = 4.dp
        ) {
            Column{
                Text(
                    text = "Things to Do",
                    modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
                    style = MaterialTheme.typography.h6,
                    fontSize = 24.sp
                )
                Text(
                    text = "1) Work on project\n2) Do Homework\n...",
                    modifier = Modifier.padding(start = 16.dp, bottom = 16.dp),
                    fontSize = 18.sp
                )
            }
        }
        Image(
            painter = painterResource(id =  R.drawable.add),
            contentDescription = null,
            modifier = Modifier.padding(start = 290.dp, top = 275.dp).size(80.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PlsDoItTheme {
        NoteScreen()
    }
}