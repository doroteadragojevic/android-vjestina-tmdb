package com.example.tmdb.modules

import com.example.tmdb.R

interface MovieApi {
    suspend fun getPopularMovies() : MovieResponse
    suspend fun getTopRated() : MovieResponse
    suspend fun getNowPlaying() : MovieResponse
    suspend fun getUpcoming() : MovieResponse
}

internal class MovieApiImpl : MovieApi {
    val popularList  = listOf(
        Movie(R.drawable.iron_man),
        Movie(R.drawable.lion_king),
        Movie(R.drawable.iron_man_2),
        Movie(R.drawable.iron_man_3)
    )
    val topRatedList  = listOf(
        Movie(R.drawable.iron_man_3),
        Movie(R.drawable.iron_man_2),
        Movie(R.drawable.iron_man),
        Movie(R.drawable.lion_king)
    )
    val nowPlayingList = listOf(
        Movie(R.drawable.iron_man_3),
        Movie(R.drawable.iron_man_2),
        Movie(R.drawable.iron_man),
        Movie(R.drawable.lion_king)
    )
    val upcoming = listOf(
        Movie(R.drawable.iron_man_3),
        Movie(R.drawable.iron_man_2 ),
        Movie(R.drawable.iron_man),
        Movie(R.drawable.lion_king)
    )

    override suspend fun getPopularMovies(): MovieResponse {
        val popularList  = MovieResponse(listOf(
            R.drawable.iron_man,
            R.drawable.lion_king,
            R.drawable.iron_man_2,
            R.drawable.iron_man_3
        ))
        return popularList
    }

    override suspend fun getTopRated(): MovieResponse {
        val topRatedList  = MovieResponse(listOf(R.drawable.iron_man_3,
            R.drawable.iron_man_2,
            R.drawable.iron_man,
            R.drawable.lion_king))

        return topRatedList
    }

    override suspend fun getNowPlaying(): MovieResponse {
        val nowPlayingList = MovieResponse(listOf(R.drawable.iron_man_3,
            R.drawable.iron_man_2,
            R.drawable.iron_man,
            R.drawable.lion_king))

        return getNowPlaying();
    }

    override suspend fun getUpcoming(): MovieResponse {
        val upcoming = MovieResponse(listOf(R.drawable.iron_man_3,
            R.drawable.iron_man_2,
            R.drawable.iron_man,
            R.drawable.lion_king))

        return upcoming
    }
}