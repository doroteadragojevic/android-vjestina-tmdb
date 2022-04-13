package com.example.tmdb

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
import com.example.tmdb.modules.FavoritesViewModel
import com.example.tmdb.modules.HomeViewModel
import com.example.tmdb.screens.main.BottomBarScreen

@Composable
fun BottomNavGraph(homeViewModel: HomeViewModel,
                   favoritesViewModel: FavoritesViewModel,
                   navController: NavHostController
                   ){
    NavHost(navController = navController,
        startDestination = BottomBarScreen.Home.route){

        composable(route = BottomBarScreen.Home.route){
            HomeScreen(painterResource(id = R.drawable.logo),
                Modifier
                    .offset(0.dp, 0.dp)
                    .height(45.dp),
                visible = mutableStateOf(true),
                homeViewModel,
                favoritesViewModel
                )
        }
        composable(route = BottomBarScreen.Favorites.route){
            FavoriteScreen(painterResource(id = R.drawable.logo),
                Modifier
                    .offset(0.dp, 0.dp)
                    .height(45.dp),
                visible = mutableStateOf(true),
                favoritesViewModel
            )
        }
    }
}