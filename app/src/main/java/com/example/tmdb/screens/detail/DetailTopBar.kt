package com.example.tmdb.screens.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tmdb.R
import com.example.tmdb.screens.home.TopAppBar


//class DetailTopBar {
    @Composable
    fun TopBar(visible : MutableState<Boolean>) {
        TopAppBar().TopBar(
            modifier = Modifier
                .offset(0.dp, 0.dp)
                .height(45.dp), logo = painterResource(id = R.drawable.logo)
        );
        Box(modifier = Modifier
            .padding(10.dp)
            .clickable { visible.value = true }) {
            Icon(
                painter = painterResource(id = R.drawable.back),
                contentDescription = "back",
                tint = Color.White.copy(0.8f)
            )
        }
    }
//}