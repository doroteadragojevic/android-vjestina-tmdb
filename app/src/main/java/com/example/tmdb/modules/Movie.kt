package com.example.tmdb.modules

import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val imageUrl: String? = null,
    val overview: String,
    val releaseDate: String? = null,
    val genreIds : List<Int>? = null,
    val id: Int,
    val original_title: String,
    val original_language: String,
    val title: String,
    val backdrop_path: String? = null,
    val popularity: Double,
    val vote_count: Int,
    val vote_average: Double
    //var favourite: MutableState<Boolean> = mutableStateOf(false)
)

data class PresentableMovie(
    val movie: Movie,
    val isFavorite: Boolean
)
@Serializable
data class Crew(
    val profilePath : String?,
    val department : String,
    val name : String
)
@Serializable
data class Cast(
    val profilePath : String?,
    val department: String,
    val name: String,
    val character : String
)
