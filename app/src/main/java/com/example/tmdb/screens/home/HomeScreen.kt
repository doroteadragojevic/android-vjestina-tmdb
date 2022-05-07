package com.example.tmdb



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
import com.example.tmdb.modules.FavoritesViewModel
import com.example.tmdb.modules.HomeViewModel
import com.example.tmdb.screens.detail.DetailPage
import com.example.tmdb.screens.home.*

@Composable
fun HomeScreen(logo : Painter,
               modifier: Modifier = Modifier,
               visible: MutableState<Boolean>,
               homeViewModel: HomeViewModel,
               favoritesViewModel: FavoritesViewModel
               ){

    val whatsPopularList = remember{ mutableStateOf(homeViewModel.popularList) }
    val popularList = homeViewModel.popularList
    val topRatedList = homeViewModel.topRatedList
    val nowPlayingListMut = remember{ mutableStateOf(homeViewModel.nowPlayingList) }
    val upcomingList = remember{ mutableStateOf(homeViewModel.upcoming) }

    val popular = remember{ mutableStateOf(true)}
    val top_rated = remember{ mutableStateOf(false)}
    val searching = remember{ mutableStateOf(false)}
    val searchingCards = remember{ mutableStateOf(false)}
if((visible.value == true) ) {
    Scaffold(

        topBar = { com.example.tmdb.screens.home.TopAppBar().TopBar(modifier, logo) }

    ) {
        LazyColumn {

            item {
                Search(searching, searchingCards)
            }
            if((searching.value == false)) {
                item {
                    Cathegory(stringResource(id = R.string.home_first_cathegory))//str = "What's popular")
                }
                item {
                    Box(
                        modifier = Modifier
                            .height(40.dp)
                            .fillMaxWidth()
                        ) {
                            Row() {
                            //popular
                                TextButton(onClick = {
                                    popular.value = true;
                                    top_rated.value = false;
                                    whatsPopularList.value = popularList
                                }) {
                                    Tabs().TextDisplayed(popular = popular, "Popular")

                                }
                            //top_rated
                                TextButton(onClick = {
                                    popular.value = false;
                                    top_rated.value = true;
                                    whatsPopularList.value = topRatedList
                                }) {
                                    Tabs().TextDisplayed(popular = top_rated, "Top Rated")
                                }
                            }
                        }
                    }
                    item {
                        LazyRow {
                            items(4) { index ->
                                MovieCard().MovieCard(
                                    painter = painterResource(id = whatsPopularList.value.get(index).painter),
                                    whatsPopularList.value.get(index).favourite,
                                    visible,
                                    whatsPopularList.value.get(index),
                                    favoritesViewModel
                                )
                            }
                        }
                    }
                    item {
                        Cathegory(str = "Now Playing")

                    }
                    item {
                        LazyRow {
                            items(4) { index ->
                                MovieCard().MovieCard(
                                    painterResource(id = nowPlayingListMut.value.get(index).painter),
                                    nowPlayingListMut.value.get(index).favourite,
                                    visible,
                                    nowPlayingListMut.value.get(index),
                                    favoritesViewModel
                                )
                            }
                        }
                    }
                    item {
                        Cathegory(str = "Upcoming")
                    }
                    item {
                        LazyRow {
                            items(4) { index ->
                                MovieCard().MovieCard(
                                    painter = painterResource(id = upcomingList.value.get(index).painter),
                                    upcomingList.value.get(index).favourite,
                                    visible,
                                    upcomingList.value.get(index),
                                    favoritesViewModel
                                )
                            }
                        }
                    }
                    item {
                        Box(modifier = Modifier.height(70.dp))
                    }
                } else if(searchingCards.value == true){
                    item {
                        SearchCard(
                            painter = painterResource(id = R.drawable.iron_man),
                            name = "Iron Man (2008)"
                        , visible)
                    }
                    item {
                        SearchCard(
                            painter = painterResource(id = R.drawable.iron_man_2),
                            name = "Iron Man 2 (2010)"
                        , visible)
                    }
                    item {
                        SearchCard(
                            painter = painterResource(id = R.drawable.iron_man_2),
                            name = "Iron Man 3 (2013)"
                        ,visible)
                    }
                    item{
                       Box(modifier = Modifier.height(70.dp))
                    }
                }
                else if(searching.value == true){

                }
            }
        }
    } else if(visible.value == false){
        DetailPage(visible)
    }
}
