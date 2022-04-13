package com.example.tmdb.modules

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.graphics.painter.Painter

data class Movie(
    val painter: Int,
    var favourite: MutableState<Boolean> = mutableStateOf(false)
)
