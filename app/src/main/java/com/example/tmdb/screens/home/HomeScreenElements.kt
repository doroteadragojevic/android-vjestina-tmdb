package com.example.tmdb.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tmdb.R
import com.example.tmdb.modules.HomeViewModel
import com.example.tmdb.modules.Movie
import kotlinx.coroutines.delay
import org.koin.androidx.compose.getViewModel


@Composable
fun Search(searching: MutableState<Boolean>, searchingCards: MutableState<Boolean>) {
    Box(
        modifier = Modifier
            .height(100.dp)
    ) {
        Row() {
            val textState = remember { mutableStateOf(TextFieldValue("")) }
            SearchView(textState, searching, searchingCards)
            CancelButton(textState, searching, searchingCards)
        }
    }
}

@Composable
fun Cathegory(str: String) {
    Box(
        modifier = Modifier
            .padding(4.dp, 20.dp)
            .height(35.dp)
            .fillMaxWidth()
    ) {
        Text(
            text = str,
            color = Color(0xFF0B253F),
            modifier = Modifier.padding(18.dp, 0.dp),
            fontWeight = FontWeight(800),
            fontSize = 20.sp
        )
    }

}

@Composable
fun SearchView(
    state: MutableState<TextFieldValue>,
    searching: MutableState<Boolean>,
    searchingCards: MutableState<Boolean>
) {
    var query by remember{ mutableStateOf("")}
    val homeViewModel : HomeViewModel = getViewModel()
    Spacer(modifier = Modifier.height(2.dp))
    TextField(
        value = query,
        onValueChange = { value ->
            state.value = TextFieldValue(value)
            searching.value = true
            searchingCards.value = false
            query = value

        },
        modifier = if (state.value != TextFieldValue("")) {
            (Modifier
                .width(300.dp)
                .padding(20.dp)
                .clip(RoundedCornerShape(10.dp)))
        } else {
            Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .clip(RoundedCornerShape(10.dp))
        },
        textStyle = TextStyle(color = Color(0xFF0B253F), fontSize = 16.sp),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.ic_vector),
                contentDescription = "",
                modifier = Modifier
                    .padding(15.dp)
                    .size(24.dp)
                    .clickable {
                        homeViewModel.search(query)
                        searchingCards.value = true

                    }
            )
        },
        /*trailingIcon = {
            if (state.value != TextFieldValue("")) {
                TextButton(
                    onClick = {
                        state.value =
                            TextFieldValue("") // Remove text from TextField when you press the 'X' icon
                    }
                ){
                    Text(
                        text = "Cancel"
                    )

                }
            }
        },*/
        singleLine = true,
        colors = TextFieldDefaults.textFieldColors(
            //textColor = Color.White,
            //leadingIconColor = Color.White,
            trailingIconColor = Color.Black,
            //backgroundColor = Color.Blue,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            //disabledIndicatorColor = Color.Transparent
        )
    )
}

//@Preview(showBackground = true)
@Composable
fun SearchViewPreview(searching: MutableState<Boolean>, searchingCards: MutableState<Boolean>) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    SearchView(textState, searching, searchingCards)
}

@Composable
fun CancelButton(
    state: MutableState<TextFieldValue>,
    searching: MutableState<Boolean>,
    searchingCards: MutableState<Boolean>
) {

    TextButton(
        onClick = {
            state.value =
                TextFieldValue("") // Remove text from TextField when you press the 'X' icon
            searching.value = false
            searchingCards.value = false
        }
    ) {
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "Cancel",
            modifier = Modifier
                .padding(top = 30.dp),
            textAlign = TextAlign.Center,
            color = Color(0xFF0B253F),
            fontSize = 15.sp
        )
    }

}


@Composable
fun SearchCard(painter: Painter, name: String, visible: MutableState<Boolean>) {
    Card(
        modifier = Modifier
            .padding(3.dp)
            .width(370.dp)
            .height(200.dp)
            .clickable {
                visible.value = false
            },
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Image(
            painter = painter,
            contentDescription = "",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(100.dp)
                .height(500.dp)
                .fillMaxSize()
                .padding(0.dp, 0.dp, 250.dp, 0.dp)

        )
        //}
        Box(
            modifier = Modifier
                .width(150.dp)
                .fillMaxHeight()
                .padding(start = 120.dp)
        ) {
            Text(
                text = name,
                modifier = Modifier.padding(18.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = "After being held captive in an Afghan cave," +
                        " billionaire engineer Tony Stark creates" +
                        " a unique weaponized suit of armor to fight evil.",
                modifier = Modifier.padding(18.dp, 50.dp),
                fontSize = 16.sp,
                color = Color(0xFF828282)
            )
        }
    }
}
