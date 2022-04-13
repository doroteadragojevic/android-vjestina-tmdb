package com.example.tmdb

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import com.example.tmdb.modules.FavoritesViewModel
import com.example.tmdb.modules.HomeViewModel


class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
            val favoritesViewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)



            MainScreen(homeViewModel, favoritesViewModel)



        }
    }
}
