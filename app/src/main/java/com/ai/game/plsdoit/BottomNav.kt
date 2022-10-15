package com.ai.game.plsdoit

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomNav(
    val route: String,
    val title: String,
    val image: ImageVector
){
    object Main: BottomNav(
        route = "Home",
        title = "Home",
        image = Icons.Default.Home
    )
    object Task: BottomNav(
        route = "Tasks",
        title = "Tasks",
        image = Icons.Default.DateRange
    )
    object Note: BottomNav(
        route = "Notes",
        title = "Notes",
        image = Icons.Default.Edit
    )
}
