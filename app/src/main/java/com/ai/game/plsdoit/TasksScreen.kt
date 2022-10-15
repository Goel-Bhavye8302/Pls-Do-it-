package com.ai.game.plsdoit

import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ai.game.plsdoit.ui.theme.PlsDoItTheme

@Composable
fun TaskScreen(){
    val checkedState1 = remember { mutableStateOf(false) }
    val checkedState2 = remember { mutableStateOf(false) }
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
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Checkbox(
                        checked = checkedState1.value,
                        onCheckedChange = { checkedState1.value = it },
                    )
                    Text(
                        text = "Hackathon",
                        modifier = Modifier.padding(start = 5.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
                        style = MaterialTheme.typography.h6,
                        fontSize = 24.sp
                    )

                }
                Text(
                    text = "Participate in Compete and Compose!",
                    modifier = Modifier.padding(start = 13.dp, bottom = 16.dp),
                    fontSize = 18.sp
                )
                Row(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    Icon(Icons.Default.DateRange, contentDescription = null)
                    Text(
                        text = "Tomorrow 5:30 PM",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 5.dp, end = 16.dp)
                    )
                }
            }
        }
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            elevation = 4.dp
        ) {
            Column{
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Checkbox(
                        checked = checkedState2.value,
                        onCheckedChange = { checkedState2.value = it },
                    )
                    Text(
                        text = "PickUp Grandpa",
                        modifier = Modifier.padding(start = 5.dp, end = 16.dp, top = 16.dp, bottom = 16.dp),
                        style = MaterialTheme.typography.h6,
                        fontSize = 24.sp
                    )

                }
                Text(
                    text = "Pickup grandpa from station",
                    modifier = Modifier.padding(start = 13.dp, bottom = 16.dp),
                    fontSize = 18.sp
                )
                Row(
                    modifier = Modifier
                        .padding(bottom = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.End
                ){
                    Icon(Icons.Default.DateRange, contentDescription = null)
                    Text(
                        text = "Wednesday 6:30 AM",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 5.dp, end = 16.dp)
                    )
                }
            }
        }
        Image(
            painter = painterResource(id =  R.drawable.add),
            contentDescription = null,
            modifier = Modifier.padding(start = 290.dp, top = 300.dp).size(80.dp)
        )
    }
}


