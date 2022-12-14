package com.ai.game.plsdoit

sealed class Screen(val route: String ){
    object Login: Screen(route = "login_screen")
    object SignUp: Screen(route = "signup_screen")
}
