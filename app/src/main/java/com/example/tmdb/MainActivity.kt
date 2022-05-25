package com.example.tmdb

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tmdb.modules.FavoritesViewModel
import com.example.tmdb.modules.HomeViewModel
import com.example.tmdb.modules.MovieRepositoryImpl


class MainActivity : ComponentActivity() {

//    @RequiresApi(Build.VERSION_CODES.N

    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContent {



            MainScreen()



        }
    }
}
