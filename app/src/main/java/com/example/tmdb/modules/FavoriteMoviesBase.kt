package com.example.tmdb.modules

class FavoriteMoviesBase {
    val favoriteMovies:MutableList<Movie> = mutableListOf()

    fun insert(movie: Movie){
        favoriteMovies.add(movie);
        movie.favourite.value = true;
    }

    fun delete(movie: Movie){
        favoriteMovies.remove(movie)
        movie.favourite.value=false
    }


}