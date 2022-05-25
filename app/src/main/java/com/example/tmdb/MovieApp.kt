package com.example.tmdb

import android.app.Application
import com.example.tmdb.di.movieModule
import org.koin.core.context.startKoin

class MovieApp:Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin{
            modules(movieModule)
        }
    }

}