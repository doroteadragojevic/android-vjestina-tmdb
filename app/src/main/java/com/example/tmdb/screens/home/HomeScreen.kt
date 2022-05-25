package com.example.tmdb.screens.home


import android.widget.ArrayAdapter
import android.widget.ListAdapter
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.tmdb.R
import com.example.tmdb.modules.*
import com.example.tmdb.screens.detail.DetailPage
import org.koin.androidx.compose.getViewModel

@Composable
fun HomeScreen(
    logo: Painter,
    modifier: Modifier = Modifier,
    visible: MutableState<Boolean>
) {

    val homeViewModel: HomeViewModel = getViewModel()


    val whatsPopularList: List<PresentableMovie> by homeViewModel.presentableWhatsPopular.collectAsState(
        initial = emptyList()
    )
    val nowPlayingListMut: List<PresentableMovie> by homeViewModel.presentableNowPlaying.collectAsState(
        initial = emptyList()
    )
    val upcomingList: List<PresentableMovie> by homeViewModel.presentableUpcoming.collectAsState(
        initial = emptyList()
    )

    val searchList: List<Movie> by homeViewModel.searchList.collectAsState(initial = emptyList())
    //val whatsPopularList: MutableState<List<Movie>?> = popularList

    val popular = remember { mutableStateOf(true) }
    val topRated = remember { mutableStateOf(false) }
    val searching = remember { mutableStateOf(false) }
    val searchingCards = remember { mutableStateOf(false) }


    //val favoritesViewModel: FavoritesViewModel = getViewModel()
    /*val favoriteMovies: List<Movie> by favoritesViewModel.favorites.collectAsState<List<Movie>, List<Movie>>(
        initial = emptyList()
    )*/



    if (visible.value) {
        Scaffold(

            topBar = { TopAppBar().TopBar(modifier, logo) }

        ) {
            LazyColumn {

                item {
                    Search(searching, searchingCards)
                }
                if (!searching.value) {
                    item {
                        Cathegory(stringResource(id = R.string.home_first_cathegory))//str = "What's popular")
                    }
                    item {
                        Box(
                            modifier = Modifier
                                .height(40.dp)
                                .fillMaxWidth()
                        ) {
                            Row {
                                //popular
                                TextButton(onClick = {
                                    homeViewModel.selectWhatsPopular(WhatsPopularType.POPULAR)

                                }) {
                                    Tabs().TextDisplayed(popular = homeViewModel.isPopularTab,
                                        "Popular")

                                }
                                //top_rated
                                TextButton(onClick = {
                                    homeViewModel.selectWhatsPopular(WhatsPopularType.TOP_RATED)

                                }) {
                                    Tabs().TextDisplayed(popular = homeViewModel.isTopRatedTab, "Top Rated")
                                }
                            }
                        }
                    }
                    item {
                        LazyRow {
                            items(whatsPopularList.size) { index ->
                                val presentableMovie = whatsPopularList[index]
                                val movie = presentableMovie.movie
                                MovieCard().MovieCard(

                                    painter = rememberAsyncImagePainter(model = movie.imageUrl),
                                    //it2.favourite,
                                    favorite = presentableMovie.isFavorite,
                                    visible,
                                    presentableMovie,
                                    onFavouriteClick = {
                                        homeViewModel.toggleFavorite(it)

                                    }
                                )

                            }
                        }
                    }
                    item {
                        Cathegory(str = "Now Playing")

                    }
                    item {
                        LazyRow {

                            items(nowPlayingListMut.size) { index ->
                                val presentableMovie = nowPlayingListMut[index]
                                val movie = presentableMovie.movie
                                MovieCard().MovieCard(

                                    painter = rememberAsyncImagePainter(model = movie.imageUrl),
                                    favorite = presentableMovie.isFavorite,
                                    visible,
                                    presentableMovie,
                                    onFavouriteClick = {
                                        homeViewModel.toggleFavorite(it)
                                    }
                                )
                            }

                        }
                    }
                    item {
                        Cathegory(str = "Upcoming")
                    }
                    item {
                        LazyRow {

                            items(upcomingList.size) { index ->
                                val presentableMovie = upcomingList[index]
                                val movie = presentableMovie.movie
                                MovieCard().MovieCard(

                                    painter = rememberAsyncImagePainter(model = movie.imageUrl),
                                    //it2.favourite,
                                    favorite = presentableMovie.isFavorite,
                                    visible,
                                    presentableMovie,
                                    onFavouriteClick = {
                                        homeViewModel.toggleFavorite(it)
                                    }
                                )
                            }

                        }
                    }
                    item {
                        Box(modifier = Modifier.height(70.dp))
                    }
                } else if (searchingCards.value) {

                    items(searchList.size){
                        index ->
                        SearchCard(
                            painter = rememberAsyncImagePainter(model = searchList[index].imageUrl),
                            name = searchList[index].title, visible
                        )

                    }
                    /*item {
                        SearchCard(
                            painter = painterResource(id = R.drawable.iron_man),
                            name = "Iron Man (2008)", visible
                        )
                    }
                    item {
                        SearchCard(
                            painter = painterResource(id = R.drawable.iron_man_2),
                            name = "Iron Man 2 (2010)", visible
                        )
                    }
                    item {
                        SearchCard(
                            painter = painterResource(id = R.drawable.iron_man_2),
                            name = "Iron Man 3 (2013)", visible
                        )
                    }
                    item {
                        Box(modifier = Modifier.height(70.dp))
                    }*/
                } else if (searching.value) {

                }
            }
        }
    } else if (!visible.value) {
        DetailPage(visible)
    }
}


