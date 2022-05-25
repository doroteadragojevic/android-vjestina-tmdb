package com.example.tmdb.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tmdb.R
import com.example.tmdb.modules.FavoritesViewModel
import com.example.tmdb.modules.HomeViewModel
import com.example.tmdb.modules.Movie
import com.example.tmdb.modules.PresentableMovie
import org.koin.androidx.compose.getViewModel

class MovieCard() {
    @Composable
    fun MovieCard(
        painter: Painter,
        favorite: Boolean,
        visible : MutableState<Boolean>,
        movie: PresentableMovie,
        onFavouriteClick : (movie: Movie) -> Unit
    ) {
        val homeViewModel: HomeViewModel = getViewModel()
        Card(
            modifier = Modifier
                .padding(3.dp)
                .width(150.dp)
                .height(210.dp)

                .clickable {
                    visible.value = false
                    homeViewModel.detailMovie = movie
                }
                ,
            shape = RoundedCornerShape(15.dp),
            elevation = 5.dp
        ) {
            Box(modifier = Modifier.height(230.dp)) {
                Image(
                    painter = painter,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(0.dp, 0.dp)
                )
                Box(modifier = if (!favorite) {
                    Modifier
                        .padding(5.dp)
                        .width(25.dp)
                        .background(Color.Gray.copy(0.3f), CircleShape)
                        .padding(3.dp)
                        .clickable {
                            onFavouriteClick(movie.movie)
                        }
                } else {
                    Modifier
                        .padding(5.dp)
                        .width(25.dp)
                        .background(Color.White.copy(0.7f), CircleShape)
                        .padding(3.dp)
                        .clickable {
                            onFavouriteClick(movie.movie)

                        }
                },
                    contentAlignment = Alignment.TopStart
                ) {
                    Icon(
                        painterResource(id = R.drawable.favorite),
                        contentDescription = "",
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.Gray.copy(0.3f)),
                        tint = Color.White

                    )

                }

            }
        }
    }
}
