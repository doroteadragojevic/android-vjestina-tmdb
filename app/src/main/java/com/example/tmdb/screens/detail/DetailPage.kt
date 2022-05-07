package com.example.tmdb.screens.detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.tmdb.R


    @OptIn(ExperimentalFoundationApi::class)
    @Composable
fun DetailPage(visible : MutableState<Boolean>){
        val reviews = remember{ mutableStateOf(true)}
        val discussions = remember{ mutableStateOf(false)}
    Scaffold(topBar = {
        TopBar(visible = visible)
    }

    ){
        Column(modifier = Modifier
                .verticalScroll(rememberScrollState())) {
                DetailPageCard()
                DetailOverview()
                Characters()
                TopBilled()
                LazyRow{
                    item{
                        TopBiledCastCard(
                            painter = painterResource(id = R.drawable.robert_d),
                            name = "Robert Downey Jr.",
                            character = "Tony Stark / Iron Man")

                    }
                    item{
                        TopBiledCastCard(
                            painter = painterResource(id = R.drawable.terrence_h),
                            name = "Terrence Howard",
                            character = "James Rhodes")

                    }
                    item{
                        TopBiledCastCard(
                            painter = painterResource(id = R.drawable.jeff_b),
                            name = "Jeff Bridges",
                            character = "Obadiah Stane / Iron Monger")

                    }
                }
                Social()
                Box(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                ) {
                    DetailTabs(reviews = reviews, discussions = discussions)
                }
                Review()
                ReviewText()
                Recommmendations()
                LazyRow{
                    item{
                        RecommmendColumn(
                            str = "Iron Man 2",
                            painterResource(id = R.drawable.iron_man_2_rec)
                        )
                    }
                    item{
                        RecommmendColumn(
                            str = "Captain America",
                            painter = painterResource(id = R.drawable.captain_america)
                        )
                    }
                }
                Box(modifier = Modifier.height(80.dp))

        }
    }
}
