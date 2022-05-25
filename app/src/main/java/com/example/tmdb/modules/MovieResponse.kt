package com.example.tmdb.modules


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MovieListResponse(
    @SerialName("results")
    val results: List<MovieResponse>
)

@Serializable
data class MovieResponse(
    @SerialName("poster_path")
    val posterPath: String? = null,
    @SerialName("adult")
    val adult: Boolean,
    @SerialName("overview")
    val overview: String,
    @SerialName("release_date")
    val releaseDate: String? = null,
    @SerialName("genre_ids")
    val genreIds : List<Int>? = null,
    @SerialName("id")
    val id: Int,
    @SerialName("original_title")
    val original_title: String,
    @SerialName("original_language")
    val original_language: String,
    @SerialName("title")
    val title: String,
    @SerialName("backdrop_path")
    val backdrop_path: String? = null,
    @SerialName("popularity")
    val popularity: Double,
    @SerialName("vote_count")
    val vote_count: Int,
    @SerialName("video")
    val video : Boolean,
    @SerialName("vote_average")
    val vote_average: Double


)

fun toMovie(mr: MovieResponse) = Movie(
    imageUrl = mr.posterPath?.let { "https://image.tmdb.org/t/p/original/$it" },
    mr.overview,
    mr.releaseDate,
    mr.genreIds,
    mr.id,
    mr.original_title,
    mr.original_language,
    mr.title,
    mr.backdrop_path,
    mr.popularity,
    mr.vote_count,
    mr.vote_average
)

@Serializable
data class CastResponse(

    @SerialName("known_for_department")
    val department : String,
    @SerialName("name")
    val name : String,
    @SerialName("profile_path")
    val profilePath : String?,
    @SerialName("character")
    val character : String

)

@Serializable
data class CrewResponse(
    @SerialName("profile_path")
    val profilePath : String?,
    @SerialName("known_for_department")
    val department : String,
    @SerialName("name")
    val name : String

)

@Serializable
data class CreditsResponse(
    @SerialName("cast")
    val cast: List<CastResponse>,
    @SerialName("crew")
    val crew : List<CrewResponse>
)

fun toCrew(c : CrewResponse) = Crew(c.profilePath,c.department, c.name)

fun toCast(c : CastResponse) = Cast(c.profilePath,c.department, c.name, c.character)


