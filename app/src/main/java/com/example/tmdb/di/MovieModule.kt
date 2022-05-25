package com.example.tmdb.di


import android.util.Log
import com.example.tmdb.modules.*
import com.example.tmdb.modules.MovieRepositoryImpl
import io.ktor.client.*
import io.ktor.client.engine.android.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*

val movieModule = module {

    viewModel {

        HomeViewModel(get())


    }
    viewModel {

        FavoritesViewModel(get())

    }

    single<MovieRepository>{
        MovieRepositoryImpl(get(), get())
    }

    single<MovieApi>{
        MovieApiImpl(get())
    }

    single{
        FavoriteMoviesBase()
    }

    single {
         HttpClient(Android) {

            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.d("HTTP", message)
                    }
                }
                level = LogLevel.ALL
            }
             install(JsonFeature){
                 serializer = KotlinxSerializer(kotlinx.serialization.json.Json{
                     ignoreUnknownKeys = true
                 })


             }
        }

    }


}
