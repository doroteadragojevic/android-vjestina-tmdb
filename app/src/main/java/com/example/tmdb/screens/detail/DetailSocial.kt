package com.example.tmdb.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmdb.screens.home.Tabs

@Composable
fun Social(){
    Box(modifier = Modifier
        .height(80.dp)
        .fillMaxWidth()
        //.offset(y = (-120).dp)
        .padding(bottom = 0.dp)
        //.height(40.dp)
        .background(Color.White)
    ) {
        Text(
            text = "Social",
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
fun DetailTabs(reviews: MutableState<Boolean>,discussions: MutableState<Boolean>){
    Row() {
        //reviews
        DetailTabsBox(reviews = discussions, discussions = reviews, "Reviews(5)")
        //discussions
        DetailTabsBox(reviews = reviews, discussions = discussions, "Discussions(4)")
    }
}

@Composable
fun DetailTabsBox(
    reviews: MutableState<Boolean>,
    discussions: MutableState<Boolean>,
    str : String
){
    TextButton(onClick = {
        reviews.value = false;
        discussions.value = true;
    }) {
        Tabs().TextDisplayed(popular = discussions, str)
    }
}