package com.ai.game.plsdoit

import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.ai.game.plsdoit.ui.theme.PlsDoItTheme
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun Login(navController: NavController, context: ComponentActivity){
    var firebaseAuth = Firebase.auth

    var username by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(16.dp),
            contentScale = ContentScale.Crop
        )

        LoginHeader()
        LoginFields(username = username,
            password = password,
            onUsernameChanged = {
                username = it
            },
            onPasswordChanged = {
                password = it
            }
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 70.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = {
                    Firebase.auth.signInWithEmailAndPassword(username, password).addOnCompleteListener(context) { task ->
                            if (task.isSuccessful) {
                                // Sign in success, update UI with the signed-in user's information
                                Log.d("ChechAuth", "signInWithEmail:success")
                                Toast.makeText(context, "Welcome!", Toast.LENGTH_SHORT).show()
                                navController.navigate(BottomNav.Main.route)
                            } else {
                                // If sign in fails, display a message to the user.
                                Log.w("CheckAuth", "signInWithEmail:failure", task.exception)
                                Toast.makeText(context, "Authentication failed.", Toast.LENGTH_SHORT).show()
                            }
                        }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0, 63, 85))
            ) {
                Text(text = "Login", color = Color.White)
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate(Screen.SignUp.route)
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color(0, 63, 85))
            ) {
                Text(text = "Don't have an account?", color = Color.White)
            }
        }


    }
}


@Composable
fun LoginHeader(){
    Text(
        text = "Welcome Back",
        fontSize = 36.sp,
        textAlign = TextAlign.Justify,
        fontWeight = FontWeight.ExtraBold,
        modifier = Modifier.padding(top = 40.dp)
    )
    Text(
        text = "Sign in to continue!",
        fontSize = 18.sp,
        textAlign = TextAlign.Justify,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(bottom = 50.dp)
    )
}

@Composable
fun LoginFields(username: String, password: String, onUsernameChanged: (String) -> Unit, onPasswordChanged: (String) -> Unit){
    DemoField(value = username,
        label = "Username",
        placeHolder = "Enter your email address",
        onValueChange = onUsernameChanged,
        leadingIcon = {
            Icon(Icons.Default.Email, contentDescription = null)
        }
    )
    Spacer(modifier = Modifier
        .fillMaxWidth()
        .height(8.dp))

    DemoField(value = password,
        label = "Password",
        placeHolder = "Enter your password",
        onValueChange = onPasswordChanged,
        visualTransformation = PasswordVisualTransformation(),
        leadingIcon = {
            Icon(Icons.Default.Lock, contentDescription = null)
        }
    )
}

@Composable
fun DemoField(
    value: String,
    label: String,
    placeHolder: String,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    leadingIcon: @Composable (() -> Unit)? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    onValueChange: (String) -> Unit){
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(text = label)
        },
        placeholder = {
            Text(placeHolder)
        },
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        leadingIcon = leadingIcon,
        trailingIcon = trailingIcon
    )
}
