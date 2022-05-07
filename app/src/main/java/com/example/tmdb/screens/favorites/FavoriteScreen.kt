package com.example.tmdb

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmdb.modules.FavoritesViewModel
import com.example.tmdb.screens.detail.DetailPage
import com.example.tmdb.screens.home.MovieCard
import com.example.tmdb.screens.home.TopAppBar
import com.example.tmdb.ui.theme.blue

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FavoriteScreen (logo : Painter, modifier: Modifier = Modifier,
                    visible : MutableState<Boolean>,
                    favoritesViewModel: FavoritesViewModel
){
    val whatsPopularList = remember{ mutableStateOf(favoritesViewModel.popularList) }
    val nowPlaying = remember{ mutableStateOf(favoritesViewModel.nowPlayingList) }
    val upcoming = remember{ mutableStateOf(favoritesViewModel.upcoming) }

    if(visible.value) {
        Scaffold(
            topBar = { TopAppBar().TopBar(modifier, logo) }
        ) {

            Text(
                text = "Favorites",
                fontSize = 21.sp,
                color = blue,
                modifier = Modifier
                    .padding(18.dp, 20.dp)
                        ,
                fontWeight = FontWeight.Bold
            )
            //TODO prikazivanje oznacenih filmova


            LazyVerticalGrid(
                cells = GridCells.Adaptive(minSize = 120.dp),
                Modifier
                    .padding(0.dp, 40.dp)
                    .offset(y = 10.dp),
                contentPadding = PaddingValues(0.dp, 15.dp)
            ) {
                /*whatsPopularList.value.forEach{
                if(it.favourite == mutableStateOf(false)){
                    item {
                        MovieCard().MovieCard(painter = it.painter, favorite = it.favourite)
                    }
                }
            }*/
                /*items(whatsPopularList.value.size){
                index -> if(whatsPopularList.value.get(index).favourite == mutableStateOf(true)) {
                MovieCard().MovieCard(
                    painter = whatsPopularList.value.get(index).painter,
                    favorite = whatsPopularList.value.get(index).favourite
                )
            }
            }*/
                /*items(nowPlaying.value.size) { index ->
                    MovieCard().MovieCard(
                        painter = painterResource(id = nowPlaying.value.get(index).painter),
                        favorite = mutableStateOf(true),
                        visible,
                        nowPlaying.value.get(index),
                        favoritesViewModel)
                }


                items(upcoming.value.size) { index ->
                    MovieCard().MovieCard(
                        painter = painterResource(id = upcoming.value.get(index).painter),
                        favorite = mutableStateOf(true),
                        visible,
                        upcoming.value.get(index),
                        favoritesViewModel
                    )
                }*/

                items(favoritesViewModel.favorites.favoriteMovies.size){
                    index ->
                    MovieCard().MovieCard(
                        painter = painterResource(id =
                        favoritesViewModel.favorites.favoriteMovies.get(index).painter),
                        favorite =favoritesViewModel.favorites.favoriteMovies.get(index).favourite,
                            //mutableStateOf(true),
                        visible,
                        favoritesViewModel.favorites.favoriteMovies.get(index),
                        favoritesViewModel
                    )
                }
            }
        }
    } else {
        DetailPage(visible)
    }
}