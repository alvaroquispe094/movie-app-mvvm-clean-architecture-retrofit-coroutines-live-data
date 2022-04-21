package com.groupal.themovieapp.data.repository

import com.groupal.themovieapp.data.model.Menu
import com.groupal.themovieapp.data.model.MenuProvider
import com.groupal.themovieapp.data.model.Movie
import com.groupal.themovieapp.data.model.MovieProvider
import com.groupal.themovieapp.data.service.MenuService
import com.groupal.themovieapp.data.service.MovieService
import javax.inject.Inject

class MovieRepository @Inject constructor(
        private val api: MovieService,
        private val movieProvider: MovieProvider
){
    suspend fun getAllMovies(): List<Movie> {
        val response = api.getMovies()
        movieProvider.movies = response
        return response
    }

    suspend fun getMovie(id: String): Movie {
        val response = api.getMovie(id)
        movieProvider.movie = response
        return response
    }
}