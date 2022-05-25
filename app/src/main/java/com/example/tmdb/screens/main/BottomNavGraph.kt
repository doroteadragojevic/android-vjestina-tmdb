package com.example.tmdb

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tmdb.screens.home.HomeScreen
import com.example.tmdb.screens.main.BottomBarScreen

@SuppressLint("UnrememberedMutableState")
@Composable
fun BottomNavGraph(
                   navController: NavHostController
                   ){
    NavHost(navController = navController,
        startDestination = BottomBarScreen.Home.route){

        composable(route = BottomBarScreen.Home.route){
            HomeScreen(painterResource(id = R.drawable.logo),
                Modifier
                    .offset(0.dp, 0.dp)
                    .height(45.dp),
                visible = mutableStateOf(true)
                )
        }
        composable(route = BottomBarScreen.Favorites.route){
            FavoriteScreen(painterResource(id = R.drawable.logo),
                Modifier
                    .offset(0.dp, 0.dp)
                    .height(45.dp),
                visible = mutableStateOf(true)
            )
        }
    }
}