package com.example.tmdb.modules

interface MovieRepository {
    fun getPopularMovies(): List<Movie>
    fun getTopRated() : List<Movie>
    fun getNowPlaying() : List<Movie>
    fun getUpcoming() : List<Movie>
}

internal class MovieRepositoryImpl(
    private val movieApi: MovieApiImpl
) : MovieRepository {

    val favorite = FavoriteMoviesBase()


    override fun getPopularMovies(): List<Movie> { //flow napraviti kad dobbijemo api
        val movieResponse = movieApi.popularList
        return movieResponse
    }

    override fun getTopRated(): List<Movie> {
        return movieApi.topRatedList
    }

    override fun getNowPlaying(): List<Movie> {
        return movieApi.nowPlayingList
    }

    override fun getUpcoming(): List<Movie> {
        return movieApi.upcoming
    }

    fun getFavoriteMovies() : FavoriteMoviesBase {
        return favorite
    }
}