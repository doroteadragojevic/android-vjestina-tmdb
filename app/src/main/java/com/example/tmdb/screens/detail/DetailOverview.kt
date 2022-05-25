package com.example.tmdb.screens.detail


import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.tmdb.modules.Cast
import com.example.tmdb.modules.Crew
import com.example.tmdb.modules.HomeViewModel
import com.example.tmdb.modules.PresentableMovie
import com.example.tmdb.screens.home.MovieCard
import org.koin.androidx.compose.getViewModel
import androidx.compose.runtime.collectAsState as collectAsState

@Composable
fun DetailOverview() {
    val homeViewModel: HomeViewModel = getViewModel()
    Box(
        modifier = Modifier
            .height(250.dp) // 80
            .fillMaxWidth()
            .offset(y = (-120).dp)
            .padding(bottom = 0.dp)
            .height(100.dp)
            .background(Color.White)
    ) {
        Text(
            text = "Overview",
            color = Color(0xFF0B253F),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 28.sp,
            modifier = Modifier
                .padding(18.dp, 20.dp)
                .height(30.dp)
        )
        homeViewModel.detailMovie?.movie?.let {
            Text(
                text = it.overview,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(18.dp, 0.dp)
                    .offset(y = 80.dp)

            )
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Characters() {
    val homeViewModel: HomeViewModel = getViewModel()
    val movie : PresentableMovie? = homeViewModel.detailMovie
    val crew: List<Crew> by homeViewModel.getCrew(movie?.movie!!.id).collectAsState(initial = emptyList())
    val cast: List<Cast> by homeViewModel.getCast(movie?.movie!!.id).collectAsState(initial = emptyList())
    /*LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 80.dp)) {


        items(cast.size) { index ->
            Titles(cast[index].name, cast[index].department)
        }
        items(crew.size){
            index -> Titles(name = crew[index].name, function = crew[index].department)
        }
    }*/
    /*LazyVerticalGrid(
        cells = GridCells.Fixed(3),
        contentPadding = PaddingValues(0.dp, 15.dp)
    ) {


        items(cast) { cast ->
            Titles(cast.name, cast.department)

        }
    }*/
   Row(modifier = Modifier
        .fillMaxWidth()
        .offset(y = (-20).dp), // -20
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Titles("Don Heck", "Characters")
        Titles("Jack Kirby", "Characters")
        Titles("Jon Favreau", "Director")
    }
    Row(modifier = Modifier
        .fillMaxWidth()
        .offset(y = (-20).dp)
        .padding(top = 20.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Titles("Don Heck", "Screenplay")
        Titles("Jack Marcum", "Screenplay")
        Titles("Matt Holloway", "Screenplay")
    }
}

@Composable
fun Titles(name: String, function: String) {
    Column(
        modifier = Modifier
            .width(110.dp)
            .height(50.dp)
    ) {
        Text(
            text = name,
            fontSize = 17.sp,
            fontWeight = FontWeight.ExtraBold
        )
        Text(
            text = function,
            fontSize = 17.sp
        )
    }
}