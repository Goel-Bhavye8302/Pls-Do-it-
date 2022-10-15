package com.ai.game.plsdoit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ai.game.plsdoit.ui.theme.PlsDoItTheme
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : ComponentActivity() {

    public override fun onStart() {
        super.onStart()
        if(Firebase.auth.currentUser != null){
            setContent {
                PlsDoItTheme {
//                    Navigation(context = this, start = Screen.Main.route)
                    BottomNavigation(this);
                }
            }
        }
        else{
            setContent {
                PlsDoItTheme {
                    Navigation(this, Screen.Login.route)
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
}

