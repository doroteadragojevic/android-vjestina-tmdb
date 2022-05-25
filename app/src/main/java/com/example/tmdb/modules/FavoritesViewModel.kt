package com.example.tmdb.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class FavoritesViewModel(private val repository: MovieRepository): ViewModel() {
    fun toggleFavorite(movie: Movie) {
        repository.toggleMovie(movie)
    }
    val favorites = repository.getFavoriteMovies()

    val presentableFavorites : Flow<List<PresentableMovie>> = combine(
        favorites,
        repository.getFavoriteMovies().map { it.map { movie -> movie.id } }
    ){ movies: List<Movie>, favorites: List<Int> ->
        movies.map {
            PresentableMovie(movie = it, isFavorite = favorites.contains(it.id))
        }
    }


    var popularList: Flow<List<Movie>> = repository.getPopularMovies()
    var topRatedList : Flow<List<Movie>> = repository.getTopRated()
    var nowPlayingList : Flow<List<Movie>> = repository.getNowPlaying()
    var upcoming :Flow<List<Movie>> = repository.getUpcoming()


}