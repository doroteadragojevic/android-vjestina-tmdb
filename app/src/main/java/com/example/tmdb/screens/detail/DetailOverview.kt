package com.example.tmdb.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DetailOverview(){
    Box(modifier = Modifier
        .height(105.dp) // 80
        .fillMaxWidth()
        .offset(y = (-120).dp)
        .padding(bottom = 0.dp)
        .height(60.dp)
        .background(Color.White)
    ){
        Text(
            text = "Overview",
            color = Color(0xFF0B253F),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 28.sp,
            modifier = Modifier
                .padding(18.dp, 20.dp)
                .height(30.dp)
        )
            Text(
                text = "After being held captive in an Afghan cave, " +
                        "billionaire engineer Tony Stark creates a unique " +
                        "weaponized suit of armor to fight evil.",
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(18.dp, 0.dp)
                    .offset(y = 80.dp)

            )

    }
}

@Composable
fun Characters(){
    /*LazyVerticalGrid(cells = GridCells.Adaptive(minSize = 80.dp)){
                    item{
                        Titles("Don Heck", "Characters")
                    }
                    item{
                        Titles("Don Heck", "Characters")
                    }
                    item{
                        Titles("Don Heck", "Characters")
                    }
                    item{
                        Titles("Don Heck", "Characters")
                    }
                    item{
                        Titles("Don Heck", "Characters")
                    }
                    item{
                        Titles("Don Heck", "Characters")
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
fun Titles(name : String, function : String){
    Column(modifier = Modifier
        .width(110.dp)
        .height(50.dp)){
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