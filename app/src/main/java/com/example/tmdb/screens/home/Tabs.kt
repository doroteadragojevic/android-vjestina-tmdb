package com.example.tmdb.screens.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Tabs() {

    @Composable
    fun TextDisplayed(popular : MutableState<Boolean>, str:String){
        Text(
            text = str,
            fontSize = 18.sp,
            color =
            if(popular.value){
                Color(0xFF000000)
            } else{
                Color(0xFF828282)
            },
            style = if(popular.value){
                TextStyle(textDecoration = TextDecoration.Underline)
            } else{
                TextStyle(textDecoration = TextDecoration.None)
            },
            fontWeight = if(popular.value){
                FontWeight(700)
            } else {
                FontWeight(500)
            },
            modifier = Modifier.padding(16.dp, 0.dp)
        )
    }
}