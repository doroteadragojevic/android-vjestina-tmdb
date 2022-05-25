package com.example.tmdb.screens.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.tmdb.modules.HomeViewModel
import com.example.tmdb.modules.PresentableMovie
import org.koin.androidx.compose.getViewModel


    @Composable
fun DetailPage(visible : MutableState<Boolean>){
        val reviews = remember{ mutableStateOf(true)}
        val discussions = remember{ mutableStateOf(false)}
    val homeViewModel : HomeViewModel  = getViewModel()
    val detMovie : PresentableMovie? = homeViewModel.detailMovie
    val cast by homeViewModel.getCast(detMovie!!.movie.id).collectAsState(initial = emptyList())
    Scaffold(topBar = {
        TopBar(visible = visible)
    }

    ){
        Column(modifier = Modifier
                .verticalScroll(rememberScrollState())) {
                DetailPageCard()
                DetailOverview()
                Characters()
                TopBilled()
                LazyRow{
                    items(cast.size){
                        index ->

                            TopBiledCastCard(
                                painter = rememberAsyncImagePainter(model = cast[index].profilePath),
                                name = cast[index].name, character = cast[index].character
                            )

                    }
                }
                //Social()
                /*Box(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                ) {
                    DetailTabs(reviews = reviews, discussions = discussions)
                }
                Review()
                ReviewText()
                Recommmendations()
                LazyRow{
                    item{
                        RecommmendColumn(
                            str = "Iron Man 2",
                            painterResource(id = R.drawable.iron_man_2_rec)
                        )
                    }
                    item{
                        RecommmendColumn(
                            str = "Captain America",
                            painter = painterResource(id = R.drawable.captain_america)
                        )
                    }
                }*/
                Box(modifier = Modifier.height(80.dp))

        }
    }
}
