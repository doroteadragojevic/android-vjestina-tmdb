package com.example.tmdb.modules

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*

interface MovieRepository {
    fun getPopularMovies(): Flow<List<Movie>>
    fun getTopRated(): Flow<List<Movie>>
    fun getNowPlaying(): Flow<List<Movie>>
    fun getUpcoming(): Flow<List<Movie>>
    fun getFavoriteMovies(): Flow<List<Movie>>
    fun toggleMovie(movie: Movie)
    fun getCrew(movieId : Int) : Flow<List<Crew>>
    fun getCast(movieId : Int) : Flow<List<Cast>>
    fun getSearch(query : String) : Flow<List<Movie>>
}

internal class MovieRepositoryImpl(
    private val movieApi: MovieApi,
    private val favoriteMoviesBase: FavoriteMoviesBase
) : MovieRepository {

    val favorite = FavoriteMoviesBase()


    override fun getPopularMovies(): Flow<List<Movie>> {
        val popular: Flow<List<Movie>> = flow {
            //while(true){
            val popular = movieApi.getPopularMovies().results.map { toMovie(it) }

            emit(popular) // Emits the result of the request to the flow
            //delay(5000) // Suspends the coroutine for some time
            //}
        }

        return popular
    }

    override fun getTopRated(): Flow<List<Movie>> {
        //return movieApi.topRatedList
        val topRated: Flow<List<Movie>> = flow {
            //while(true){
            val topRated = movieApi.getTopRated().results.map { toMovie(it) }

            emit(topRated) // Emits the result of the request to the flow
            //delay(5000) // Suspends the coroutine for some time
            //}
        }
        return topRated
    }

    override fun getNowPlaying(): Flow<List<Movie>> {
        val nowPlaying: Flow<List<Movie>> = flow {
            //while(true){
            val nowPlaying = movieApi.getNowPlaying().results.map { toMovie(it) }

            emit(nowPlaying) // Emits the result of the request to the flow
            //delay(5000) // Suspends the coroutine for some time
            //}
        }
        return nowPlaying
    }

    override fun getUpcoming(): Flow<List<Movie>> {
        //return movieApi.upcoming
        val upcoming: Flow<List<Movie>> = flow {
            //while(true){
            val upcoming = movieApi.getUpcoming().results.map { toMovie(it) }

            emit(upcoming) // Emits the result of the request to the flow
            //delay(5000) // Suspends the coroutine for some time
            //}
        }
        return upcoming
    }

    private val favoriteMoviesRefreshEvent = MutableSharedFlow<Any>()
    private val favoriteMoviesFlow: Flow<List<Movie>> = favoriteMoviesRefreshEvent
        .onStart { emit(Any()) }
        .map {
            favoriteMoviesBase.favoriteMovies
        }
        .shareIn(CoroutineScope(Dispatchers.Default), SharingStarted.Lazily, replay = 1)

    override fun getFavoriteMovies(): Flow<List<Movie>> = favoriteMoviesFlow

    override fun toggleMovie(movie: Movie) {
        if (favoriteMoviesBase.favoriteMovies.contains(movie)) {
            favoriteMoviesBase.insert(movie)
        } else {
            favoriteMoviesBase.delete(movie)
        }
        favoriteMoviesRefreshEvent.tryEmit(Any())
    }

    override fun getCrew(movieId : Int) : Flow<List<Crew>>{
        val credits = flow {
            val credits = movieApi.getCredits(movieId = movieId).crew.map { toCrew(it) }

            emit(credits)
        }
        return credits
    }

    override fun getCast(movieId: Int): Flow<List<Cast>> {

        val credits = flow {
            val credits = movieApi.getCredits(movieId = movieId).cast.map { toCast(it) }

            emit(credits)
        }
        return credits
    }

    override fun getSearch(query: String): Flow<List<Movie>> {

        val search: Flow<List<Movie>> = flow {
            val search = movieApi.search(query).results.map { toMovie(it) }

            emit(search)
        }
        return search
    }
}