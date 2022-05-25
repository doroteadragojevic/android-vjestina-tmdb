package com.example.tmdb.modules

class FavoriteMoviesBase {
    private val _favoriteMovies: MutableList<Movie> = mutableListOf()
    val favoriteMovies: List<Movie>
        get() = _favoriteMovies.toList()

    fun insert(movie: Movie) {
        _favoriteMovies.add(movie)
    }

    fun delete(movie: Movie) {
        _favoriteMovies.remove(movie)
    }


}