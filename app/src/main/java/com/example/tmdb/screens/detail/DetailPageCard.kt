package com.example.tmdb.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.tmdb.R
import com.example.tmdb.modules.HomeViewModel
import org.koin.androidx.compose.getViewModel
import kotlin.math.roundToInt

@Composable
fun DetailPageCard(){
    val homeViewModel: HomeViewModel = getViewModel()
    Card(shape = RoundedCornerShape(0.dp)) {
        Image(
            painter = rememberAsyncImagePainter(model = homeViewModel.detailMovie?.movie?.imageUrl),
            contentDescription = "",
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillBounds

        )
        Box(modifier = Modifier
            .height(400.dp)
            .fillMaxWidth()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Transparent,
                        Color.Black
                    ),
                    startY = 150f
                )
            )
        )
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 130.dp)) {

            UserScore()

            homeViewModel.detailMovie?.let {
                Text(
                    text = it.movie.title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 25.sp,
                    modifier = Modifier.padding(top = 83.dp)

                )
            }
            Box(modifier = Modifier
                .padding(top = 120.dp)
                .height(40.dp)
                .fillMaxWidth()
            ){
                homeViewModel.detailMovie?.movie?.releaseDate?.let {
                    Text(
                        text = it,
                        color = Color.White
                    )
                }
            }
            IconsBox()
        }
    }
}


@Composable
fun UserScore(){
    val homeViewModel : HomeViewModel = getViewModel()
        Card(
            backgroundColor = Color.Transparent
        ) {
            Image(
                painter = painterResource(id = R.drawable.user_score),
                contentDescription = "userScore",
                modifier = Modifier
                    .width(50.dp)
                    .height(50.dp),
                contentScale = ContentScale.FillBounds
            )

            Text(
                text = (homeViewModel.detailMovie?.movie?.vote_average?.times(10)?.roundToInt()).toString() + "%",
                color = Color.White,
                modifier = Modifier
                    .padding(15.dp)
                    .background(Color.Transparent),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold)
        }
        Text(
            text = "User Score",
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(0.dp, 65.dp),
            color = Color.White,
            fontSize = 17.sp
        )
}

@Composable
fun IconsBox(){
    Box(modifier = Modifier
        .padding(top = 140.dp, bottom = 0.dp)
        .height(45.dp)
        .fillMaxWidth()
    ){
        Row{

            PictureIcons(painter = painterResource(id = R.drawable.favorite))
        }
    }
}

@Composable
fun PictureIcons(painter : Painter){
    val homeViewModel : HomeViewModel = getViewModel()
    val favorite = homeViewModel.detailMovie?.isFavorite
    Box(modifier = if (!favorite!!) {
        Modifier
            .padding(10.dp, 8.dp)
            .width(30.dp)
            .height(30.dp)
            .background(Color(0xFF757575).copy(0.8f), CircleShape)
            .padding(3.dp)
            .clickable {
                homeViewModel.detailMovie?.let { homeViewModel.toggleFavorite(it.movie) }
            }
    } else {
        Modifier
            .padding(10.dp, 8.dp)
            .width(30.dp)
            .height(30.dp)
            .background(Color.White.copy(0.7f), CircleShape)
            .padding(3.dp)
            .clickable { homeViewModel.detailMovie?.let { homeViewModel.toggleFavorite(it.movie) } }
    },
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painter,
            contentDescription = "",
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray.copy(0.3f)),
            tint = Color.White

        )

    }
}