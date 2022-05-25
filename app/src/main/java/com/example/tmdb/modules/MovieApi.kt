package com.example.tmdb.modules

import android.security.identity.AccessControlProfileId
import android.util.Log
import com.example.tmdb.R
import com.example.tmdb.modules.MovieApi.ApiRoutes
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

interface MovieApi {
    object ApiRoutes {
        const val API_KEY = "7038b8e225113ea179e40174854e4ecc"
        const val POPULAR = "https://api.themoviedb.org/3/movie/popular?api_key=7038b8e225113ea179e40174854e4ecc"
        const val NOW_PLAYING = "https://api.themoviedb.org/3/movie/now_playing?api_key=$API_KEY"
        const val UPCOMING = "https://api.themoviedb.org/3/movie/upcoming?api_key=$API_KEY"
        const val TOP_RATED = "https://api.themoviedb.org/3/movie/top_rated?api_key=$API_KEY"
        val DETAILS = "https://api.themoviedb.org/3/movie/movieId?api_key=$API_KEY"
        const val CREDITS = "https://api.themoviedb.org/3/movie/movieId/credits?api_key=$API_KEY"
        //const val SEARCH = "https://api.themoviedb.org/3/search/movie?api_key=7038b8e225113ea179e40174854e4ecc&query=iron"
    }
    suspend fun getPopularMovies() : MovieListResponse
    suspend fun getTopRated() :MovieListResponse
    suspend fun getNowPlaying() :MovieListResponse
    suspend fun getUpcoming() : MovieListResponse
    //suspend fun getDetails(): DetailsResponse
    suspend fun getCredits(movieId : Int) : CreditsResponse
    suspend fun search(query :String) : MovieListResponse
}
internal class MovieApiImpl(private val client: HttpClient) : MovieApi {

    override suspend fun getPopularMovies():MovieListResponse
    {
        val response:MovieListResponse = client.get<MovieListResponse>(ApiRoutes.POPULAR)
        return response
    }

    override suspend fun getTopRated(): MovieListResponse {
        val response:MovieListResponse = client.get(ApiRoutes.TOP_RATED)
        return response
    }

    override suspend fun getNowPlaying(): MovieListResponse {
        val response:MovieListResponse = client.get(ApiRoutes.NOW_PLAYING)
        return response
    }

    override suspend fun getUpcoming() :MovieListResponse {
        val response:MovieListResponse = client.get(ApiRoutes.UPCOMING)
        return response
    }

    override suspend fun getCredits(movieId : Int) : CreditsResponse{
        return client.get("https://api.themoviedb.org/3/movie/${movieId}/credits?api_key=${ApiRoutes.API_KEY}")
    }

    override suspend fun search(query: String): MovieListResponse {
        return client.get( "https://api.themoviedb.org/3/search/movie?api_key=7038b8e225113ea179e40174854e4ecc&query=${query}")
    }


}