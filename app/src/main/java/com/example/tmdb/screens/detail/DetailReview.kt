package com.example.tmdb.screens.detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tmdb.R

@Composable
fun Review(){
    Row(modifier = Modifier.padding(18.dp, 20.dp)){
        Box(modifier = Modifier
            .clip(CircleShape)
            .width(60.dp)
            .height(60.dp)

        ){
            Image(painter = painterResource(
                id = R.drawable.peruvian_post
            ),
                contentScale = ContentScale.Crop,
                contentDescription = "",
                modifier = Modifier.fillMaxSize()
            )
        }
        Box(modifier = Modifier
            .width(300.dp)
            .height(70.dp)
            .padding(start = 30.dp)){
            Text(
                text = "A review by The Peruvian Post",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Normal, color = Color(0XFF828282))) {
                        append("Written by ")
                    }
                    withStyle(
                        style = SpanStyle(
                            fontWeight = FontWeight.Bold
                        )
                    ) {
                        append("The Peruvian Post ")
                    }
                    withStyle(style = SpanStyle(fontWeight = FontWeight.Normal, color = Color(0XFF828282))) {
                        append("on February 17, 2020")
                    }

                },
                modifier = Modifier.padding(top = 35.dp)
            )
        }
    }
}

@Composable
fun ReviewText(){
    Box(modifier = Modifier
        .height(380.dp)
        .fillMaxWidth()
        .padding(18.dp, 0.dp)){
        Text(
            buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Normal,
                        fontSize = 17.sp,
                        color = Color(0XFF828282))
                ) {
                    append("When director Jon Favreau" +
                            " and Sarah Halley cast Robert Downey Jr," +
                            " they glimpsed something magnificent:" +
                            " a more-than-skilled actor who faultlessly portrayed " +
                            "the role of Tony Stark." +
                            " Despite Favreau's initial decision in choosing a fresh face," +
                            " he ended up delighted due to his charismatic," +
                            " natural and comfortable attitude. He did not realise it yet," +
                            " but he was moulding with the right measures" +
                            " a whole superhero cinematic universe which" +
                            " lasted until today and still goes for more.\n" +
                            "\n" +
                            "The filmmakers took the proper time to introduce a" +
                            " character whose production was undecided since" +
                            " New Line Pictures argu... ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 17.sp
                    )
                ) {
                    append("read the rest.")
                }

            },
            modifier = Modifier.padding(top = 27.dp)
        )
    }
}