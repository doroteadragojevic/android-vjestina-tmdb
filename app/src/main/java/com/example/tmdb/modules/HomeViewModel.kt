package com.example.tmdb.modules

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: MovieRepository
): ViewModel() {
    fun toggleFavorite(movie: Movie) {
        repository.toggleMovie(movie)
    }

    val favorites = repository.getFavoriteMovies()
    private val whatsPopularTypePublisher = MutableStateFlow(WhatsPopularType.POPULAR)
    private val popularList: Flow<List<Movie>> = repository.getPopularMovies()
    private val topRatedList : Flow<List<Movie>> = repository.getTopRated()
    var nowPlayingList : Flow<List<Movie>> = repository.getNowPlaying()
    var upcoming :Flow<List<Movie>> = repository.getUpcoming()
    var isPopularTab : MutableState<Boolean> = mutableStateOf(true)
    var isTopRatedTab : MutableState<Boolean> = mutableStateOf(false)
    var searchList : Flow<List<Movie>> = emptyFlow()

    fun search(query : String){
        searchList = repository.getSearch(query)
    }

    fun getCrew(movieId : Int) : Flow<List<Crew>>{
        return  repository.getCrew(movieId)
    }
    fun getCast(movieId : Int) : Flow<List<Cast>>{
        return  repository.getCast(movieId)
    }

    private val whatsPopularList = whatsPopularTypePublisher.flatMapLatest {
        when(it){
            WhatsPopularType.POPULAR -> popularList
            WhatsPopularType.TOP_RATED -> topRatedList
        }
    }

    val presentableWhatsPopular : Flow<List<PresentableMovie>> = combine(
        whatsPopularList,
        repository.getFavoriteMovies().map { it.map { movie -> movie.id } }
    ){ movies: List<Movie>, favorites: List<Int> ->
        movies.map {
            PresentableMovie(movie = it, isFavorite = favorites.contains(it.id))
        }
    }

    val presentableNowPlaying : Flow<List<PresentableMovie>> = combine(
        nowPlayingList,
        repository.getFavoriteMovies().map{ it.map{movie -> movie.id}}
    ){
        movies: List<Movie>, favorites: List<Int> ->
        movies.map {
            PresentableMovie(movie = it, isFavorite = favorites.contains(it.id))
        }
    }

    val presentableUpcoming : Flow<List<PresentableMovie>> = combine(
        upcoming,
        repository.getFavoriteMovies().map{ it.map{movie -> movie.id}}
    ){
            movies: List<Movie>, favorites: List<Int> ->
        movies.map {
            PresentableMovie(movie = it, isFavorite = favorites.contains(it.id))
        }
    }


    fun selectWhatsPopular(type: WhatsPopularType){
        whatsPopularTypePublisher.value = type
        isPopularTab.value = when(type){
            WhatsPopularType.POPULAR -> true;
            WhatsPopularType.TOP_RATED -> false;
        }
        isTopRatedTab.value = when(type){
            WhatsPopularType.POPULAR -> false;
            WhatsPopularType.TOP_RATED -> true;
        }
    }

    var detailMovie : PresentableMovie? = null


}

enum class WhatsPopularType{
    POPULAR, TOP_RATED
}