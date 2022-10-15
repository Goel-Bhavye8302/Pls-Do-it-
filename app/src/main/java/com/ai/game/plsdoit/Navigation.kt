package com.ai.game.plsdoit

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.ai.game.plsdoit.BottomNavigation

@Composable
fun Navigation(context: ComponentActivity, start: String){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = start){
        composable(route = Screen.Login.route){
            Login(navController, context)
        }
        composable(route = Screen.SignUp.route){
            SignUp(navController, context)
        }
    }
}

@Composable
fun BottomNavigation(context: ComponentActivity) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = { BottomBar(navController = navController)}
    ) {
        BottomGraph(navController = navController, context = context, it)
    }
}

@Composable
fun BottomGraph(navController: NavHostController, context: ComponentActivity, it: PaddingValues){
    NavHost(navController = navController, startDestination = BottomNav.Main.route){
        composable(route = BottomNav.Main.route){
            MainScreen()
        }
        composable(route = BottomNav.Note.route){
            NoteScreen()
        }
        composable(route = BottomNav.Task.route){
            TaskScreen()
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomNav.Main,
        BottomNav.Note,
        BottomNav.Task
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currDestination = navBackStackEntry?.destination

    BottomNavigation{
        screens.forEach{ screen ->
            AddItem(
                screen = screen,
                currentDestination = currDestination,
                navController = navController
            )
        }
    }
}

@Composable
fun RowScope.AddItem(screen: BottomNav, currentDestination: NavDestination?, navController: NavHostController){
    BottomNavigationItem(
        label = {
            Text(text = screen.title)
        },
        icon = {
            Icon(imageVector = screen.image, contentDescription = null)
        },
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route
        } == true,
        unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
        onClick = {
            navController.navigate(screen.route) {
                popUpTo(navController.graph.findStartDestination().id)
                launchSingleTop = true
            }
        }
    )
}