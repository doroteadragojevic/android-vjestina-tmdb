package com.example.tmdb

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.tmdb.modules.FavoritesViewModel
import com.example.tmdb.modules.HomeViewModel
import com.example.tmdb.screens.main.BottomBarScreen

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(bottomBar = {
        BottomBar(navController = navController)
    }) {
        BottomNavGraph(
            navController = navController
            )
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Favorites
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestionation = navBackStackEntry?.destination
    
    BottomNavigation() {
        screens.forEach{screen ->
            AddItem(screen = screen,
                currentDestination = currentDestionation,
                navController = navController)
        }
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    currentDestination :NavDestination?,
    navController : NavHostController
){
    BottomNavigationItem(
        label = {
            Text(text = screen.title, fontSize = 15.sp)
        },
        icon={
            Icon(imageVector = screen.icon,
                contentDescription = "Navigation Icon")
        },
        selected = currentDestination?.hierarchy?.any{
            it.route == screen.route
        } == true,
        unselectedContentColor = Color.Gray.copy(0.7f),
        selectedContentColor = Color(0xFF0B253F),
        modifier = Modifier.background(Color(0xFFFFFFFF)),
        onClick = {
            navController.navigate(screen.route)
        }
    )
}