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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.tmdb.modules.FavoritesViewModel
import com.example.tmdb.modules.HomeViewModel
import com.example.tmdb.modules.Movie
import com.example.tmdb.modules.PresentableMovie
import com.example.tmdb.screens.detail.DetailPage
import com.example.tmdb.screens.home.MovieCard
import com.example.tmdb.screens.home.TopAppBar
import com.example.tmdb.ui.theme.blue
import org.koin.androidx.compose.getViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FavoriteScreen(
    logo: Painter, modifier: Modifier = Modifier,
    visible: MutableState<Boolean>
) {
    val favoritesViewModel: FavoritesViewModel = getViewModel()
    val homeViewModel : HomeViewModel = getViewModel()

    val favoriteMovies: List<PresentableMovie> by favoritesViewModel.presentableFavorites.collectAsState(initial = emptyList())




    if (visible.value) {
        Scaffold(
            topBar = { TopAppBar().TopBar(modifier, logo) }
        ) {

            Text(
                text = "Favorites",
                fontSize = 21.sp,
                color = blue,
                modifier = Modifier
                    .padding(18.dp, 20.dp),
                fontWeight = FontWeight.Bold
            )


            //ODKOMENTIRAJ
            LazyVerticalGrid(
                cells = GridCells.Adaptive(minSize = 120.dp),
                Modifier
                    .padding(0.dp, 40.dp)
                    .offset(y = 10.dp),
                contentPadding = PaddingValues(0.dp, 15.dp)
            ) {


                items(favoriteMovies.size) { index ->
                    MovieCard().MovieCard(
                        painter = rememberAsyncImagePainter(
                            model = favoriteMovies[index].movie.imageUrl
                        ),
                        favorite = favoriteMovies.contains((favoriteMovies[index])),
                        //mutableStateOf(true),
                        visible,
                        favoriteMovies[index],
                        onFavouriteClick = {
                            favoritesViewModel.toggleFavorite(it)
                            homeViewModel.detailMovie = favoriteMovies[index]
                        }
                    )
                }
            }
        }
    } else {
        DetailPage(visible)
    }
}