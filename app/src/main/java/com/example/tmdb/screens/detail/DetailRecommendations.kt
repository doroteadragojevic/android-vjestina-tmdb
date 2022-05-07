package com.example.tmdb.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Recommmendations(){
    Box(modifier = Modifier
        .height(80.dp)
        .fillMaxWidth()
        //.offset(y = (-120).dp)
        .padding(bottom = 0.dp)
        //.height(40.dp)
        .background(Color.White)
    ) {
        Text(
            text = "Recommendations",
            color = Color(0xFF0B253F),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 23.sp,
            modifier = Modifier
                .padding(18.dp, 20.dp)
                .height(35.dp)
        )
    }
}

@Composable
fun RecommendCard(painter: Painter) {
    Card(
        modifier = Modifier
            .padding(18.dp, 0.dp)
            .width(190.dp)
            .height(90.dp)
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
        }
    }
}


@Composable
fun RecommmendColumn(str : String, painter : Painter) {
    Column {
        RecommendCard(painter = painter)
        Text(
            text = str,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            modifier = Modifier.padding(22.dp, 0.dp)
        )
    }
}