package com.example.tmdb.modules

import androidx.lifecycle.ViewModel

class FavoritesViewModel(): ViewModel() {
    val popularList = MovieRepositoryImpl(movieApi = MovieApiImpl()).getPopularMovies()
    val topRatedList  = MovieRepositoryImpl(movieApi = MovieApiImpl()).getTopRated()
    val nowPlayingList = MovieRepositoryImpl(movieApi = MovieApiImpl()).getNowPlaying()
    val upcoming = MovieRepositoryImpl(movieApi = MovieApiImpl()).getUpcoming()
    val favorites = MovieRepositoryImpl(movieApi = MovieApiImpl()).getFavoriteMovies()

}