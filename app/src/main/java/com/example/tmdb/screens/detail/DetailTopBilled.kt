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
fun TopBilled(){
    Box(modifier = Modifier
        .height(80.dp)
        .fillMaxWidth()
        //.offset(y = (-120).dp)
        .padding(bottom = 0.dp)
        //.height(40.dp)
        .background(Color.White)
    ) {
        Text(
            text = "Top Billed Cast",
            color = Color(0xFF0B253F),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 28.sp,
            modifier = Modifier
                .padding(18.dp, 20.dp)
                .height(35.dp)
        )
    }
}

@Composable
fun TopBiledCastCard(painter : Painter, name: String, character : String){
    Card(
        modifier = Modifier
            .padding(5.dp)
            .width(150.dp)
            .height(210.dp)

        ,
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier
            .height(230.dp)) {
            Image(
                painter = painter,
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(0.dp, 0.dp)
            )
            Box(
                modifier = Modifier
                    .offset(y = 140.dp)
                    .height(70.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            ) {
                Text(
                    text = name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(5.dp, 5.dp)
                )
                Text(
                    text = character,
                    fontSize = 15.sp,
                    modifier = Modifier
                        .padding(5.dp, 0.dp)
                        .padding(top = 30.dp)
                )

            }

        }
    }
}