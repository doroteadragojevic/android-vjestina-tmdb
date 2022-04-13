package com.example.tmdb.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.tmdb.ui.theme.blue

class TopAppBar() {
    @Composable
    fun TopBar(modifier: Modifier, logo: Painter) {
        androidx.compose.material.TopAppBar(
            backgroundColor = blue,
            elevation = 0.dp,
            modifier = modifier
                .fillMaxSize()
                .background(blue)
                .padding(horizontal = 100.dp)
                .height(80.dp)
        ) {
            Box(
                modifier = Modifier
                    .height(80.dp)
                    .width(300.dp)
                    .padding(bottom = 5.dp)
            ) {
                Row(
                    Modifier.fillMaxHeight(),
                    verticalAlignment = Alignment.Bottom
                ) {
                    Image(
                        contentScale = ContentScale.FillWidth,
                        painter = logo, contentDescription = "logo",
                        alignment = Alignment.TopCenter,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}